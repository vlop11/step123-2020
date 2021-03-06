package com.google.sps.servlets;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.sps.utils.StringConstants.*;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.stream.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/updateChat")
public class UpdateChatServlet extends HttpServlet {

    /**
     * When called, doGet will return a JSON list of only new messages that 
     * have been posted, but not yet displayed on the users's end. Called every
     * second by the .js file for the chat page.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String groupID = (String) request.getParameter(GROUP_ID_PROPERTY);
        final int currMessages = Integer.parseInt(request.getParameter("currMessages"));
        
        // Sets an offset so already fetched messages won't be returned
        FetchOptions fetchOptions = FetchOptions.Builder.withOffset(currMessages);
        DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

        // Calls query on all entities of type Message
        Query messageQuery = new Query(MESSAGE_KIND + groupID).addSort(TIMESTAMP_PROPERTY, SortDirection.ASCENDING);
        PreparedQuery preparedMessageQuery = datastore.prepare(messageQuery);

        // Creates list of only the new messages
        ImmutableList<String> messagesList = preparedMessageQuery.asList(fetchOptions)
            .stream().map(message -> (String) message.getProperty(MESSAGE_TEXT_PROPERTY))
            .collect(toImmutableList());

        response.setContentType(CONTENT_TYPE_JSON);
        response.getWriter().println(convertToJSON(messagesList));
    }

    private String convertToJSON(ImmutableList<String> jsonList) {
        Gson gson = new Gson();
        return gson.toJson(jsonList);
    }
}
