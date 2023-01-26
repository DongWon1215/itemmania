/*$(document).ready(() => {
    console.log('준비완료');
    $('#boardListSale').on('click', function () {
        $.ajax({
            url: '/board/boardList/',
            type: 'post',
            contentType: 'application/json',

            success: function (data) {
                $("#demo").html("성공.<br>")
                    .append("성공: " + data + "<br>")
                    .append("상태: " + data);
            }
        }).fail(function (xhr, status, errorThrown) {
            $("#demo").html("오류가 발생했습니다.<br>")
                .append("오류명: " + errorThrown + "<br>")
                .append("상태: " + status);
        })
    });


})*/


/*
function searchbarSubmit() {
    var f = document.getElementById("g_searchbar_form");
    var h = f.querySelector('[name="search_game"]');
    var c = f.querySelector('[name="search_server"]');
    var a = h.value;
    var g = c.value;
    var b = f.querySelector('[name="search_type"]:checked').value;
    var d = (g === "0" || g === "") ? "list.html" : "list_search.html";
    var e = "//trade.itemmania.com/" + b + "/" + d;
    if (a.isEmpty()) {
        alert("게임을 선택해주세요.");
        return false
    } else {
        _myService.setLastSearch()
    }
    f.action = e;
    return true
}
*/

