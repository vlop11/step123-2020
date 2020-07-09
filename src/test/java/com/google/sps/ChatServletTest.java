package com.google.sps;

import com.google.sps.servlets.ChatServlet;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public final class ChatServletTest {
    private String MESSAGE_TEXT_TOXIC = "what kind of idiot name is foo?";
    private File apiKeyFile;
    private Scanner scanner;
    private String API_KEY;
    private String REFERER;
    private String apiURL;
    private ChatServlet servlet;

    @Before
    public void setUp() throws FileNotFoundException {
        // Reads API Key and Referer from file 
        apiKeyFile = new File("keys.txt");
        scanner = new Scanner(apiKeyFile);
        API_KEY = scanner.nextLine();
        REFERER = scanner.nextLine();

        apiURL = "https://commentanalyzer.googleapis.com/v1alpha1/comments:analyze?key=" + API_KEY;
        servlet = new ChatServlet();
    }

    @Test
    public void testsCommentScore() throws IOException {
        Double expected = 0.9208521;
        Double actual = servlet.getCommentScore(apiURL, REFERER, MESSAGE_TEXT_TOXIC);

        Assert.assertEquals(expected, actual);
    }

}
