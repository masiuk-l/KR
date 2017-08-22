$(document).ready(function () {

    $('.reserve-book').click(function () {
        reserveBook($(this));
    });
});

function reserveBook(element) {
    var bookID = $(element).attr('id');
    console.log(bookID);
    var json = JSON.stringify(bookID);
    console.log(json);
    var jqxhr = $.ajax({
        type: 'get',
        url: contextUrl + '/frontController?command=reserveBook&bookID=' + bookID,
        converters: {
            "text": function (data) {
                console.log("1");
                // $('#quantity').text(data);
                // $('.reserve-book').attr('class', 'btn btn-secondary disabled').text(reserved);
            },
            "xml": function () {
                console.log("1");
                window.location.href = contextUrl + '/frontController?command=login';
            }
        }

    }).done(function (XMLHttpRequest, data) {
        //var headers = jqxhr;
        console.log(headers)

    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });

}