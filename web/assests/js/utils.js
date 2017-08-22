$(document).ready(function () {

    $('.reserve-book').click(function () {
        reserveBook($(this));
    });
});

function reserveBook(element) {
    var jqxhr;
    var bookID = $(element).attr('id');
    console.log(bookID);
    var json = JSON.stringify(bookID);
    console.log(json);
    jqxhr = $.ajax({
        type: 'get',
        url: contextUrl + '/frontController?command=reserveBook&bookID=' + bookID,
        success: function (response) {
            var str = "\"Auth required\"";

            if (response.toString() === str) {
                window.location.href = contextUrl + '/frontController?command=login';
            }
            else {
                $('#quantity').text(response);
                $('.reserve-book').attr('class', 'btn btn-secondary disabled').text(reserved);
            }
        }

    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });

}