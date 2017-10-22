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
             showPerson(JSON.parse(person.body));
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
function showPerson(data) {
     $("#personsSocketTable").append("<tr><td>" + data.firstName + "</td><td>"+ data.lastName + "</td></tr>");
 }

