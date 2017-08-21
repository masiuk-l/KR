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
    $.ajax({
        type: 'get',
        url: contextUrl + '/frontController?command=reserveBook&bookID=' + bookID
    }).done(function (data) {
        $('#quantity').text(data);
        $('.reserve-book').attr('class', 'btn btn-secondary disabled').text(reserved);
    }).fail(function (data) {
        if (console && console.log) {
            console.log("Error data:", data);
        }
    });
}