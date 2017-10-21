$(document).ready( function () {
    var table = $('#personsTable').DataTable({
        "sAjaxSource": "/persons",
        "sAjaxDataProp": "",
        "order": [[ 0, "asc" ]],
        "aoColumns": [
            { "mData": "firstName" },
            { "mData": "lastName" }
        ]
    })
});