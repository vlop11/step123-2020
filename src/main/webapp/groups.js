goog.require('goog.dom');
goog.require('goog.dom.classlist');

let newGroupContainer;

function init() {
    newGroupContainer = goog.dom.getElement("new-group-container");
}

function toggleHidden() {
    goog.dom.classlist.toggle(newGroupContainer, "hidden");
}

function joinGroup(groupId) {
    const bodyData = {'groupId': groupId};
    const response = fetch("/groups",  {
        method: "PUT",
        body: JSON.stringify(bodyData)
    });
}
