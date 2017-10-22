$( document ).ready(function() {
    connect();
})

function connect() {
    var socket = new SockJS('/ws-persons');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/persons', function (person) {
            console.log(person);
            var contact = JSON.parse(person.body);
            showPerson(contact.lastName);
        });
    });
}


function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#persons").html("");
}

function showPerson(message) {
    $("#persons").append("<tr><td>" + message + "</td></tr>");
}

