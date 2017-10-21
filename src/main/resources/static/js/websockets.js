var stompClient = null;

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

function connect() {
    var socket = new SockJS('/ws-persons');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/topic/persons', function (person) {
            console.log(person);
            var contact = JSON.parse(person.body);
            showGreeting(contact.lastName);

            // showGreeting(JSON.parse(person.body).content);

            //var personObject = JSON.parse(person);
            // showGreeting(JSON.parse(person.body).content);

            // JSON.parse(person).lastName;
            // showGreeting(JSON.parse(person.body).content);


            // showGreeting(JSON.parse(person.body).content);

            //var personObject = JSON.parse(person);
            // showGreeting(JSON.parse(person.body).content);

            // JSON.parse(person).lastName;
            // showGreeting(JSON.parse(person.body).content);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendName() {
    stompClient.send("/app/person/hello", {}, JSON.stringify(
        {
            'id': $("#id").val(),
            'firstName': $("#firstName").val(),
            'lastName': $("#lastName").val(),

        }
    ));
}

function showGreeting(message) {
    $("#persons").append("<tr><td>" + message + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $("#connect").click(function () {
        connect();
    });
    $("#disconnect").click(function () {
        disconnect();
    });
    $("#send").click(function () {
        sendName();
    });
});