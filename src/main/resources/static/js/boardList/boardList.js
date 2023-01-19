$(document).ready(() => {
    console.log('준비완료');
    $('#boardListSale').on('click', function () {
        $.ajax({
            url: '/board/boardList/' + 'sale',
            type: 'get',
            contentType: 'application/json',

            success: function (data) {
                $.each(data, function (index, data) {
                    console.log(index, data.boardNum)
                    html += '<div class="entry">';
                    html += '<h3 class="term">' + data.boardNum + '</h3>';
                    html += '<div class="part">' + data.boardTitle + '</div>';
                    html += '<div class="definition">';
                    html += data.saleAria;
                    html += '</div>';
                    html += '</div>';
                });
                console.log(html);
                $('#boardList').html(html);
            }
        }).fail(function (xhr, status, errorThrown) {
            $("#demo").html("오류가 발생했습니다.<br>")
                .append("오류명: " + errorThrown + "<br>")
                .append("상태: " + status);
        })
    });

    $('#boardListBuy').on('click', function () {
        $.ajax({
            url: '/board/boardList/' + 'buy',
            type: 'get',
            contentType: 'application/json',
        }).done(function (json) {


        }).fail(function (xhr, status, errorThrown) {

            $("#text").html("오류가 발생했습니다.<br>")
                .append("오류명: " + errorThrown + "<br>")
                .append("상태: " + status);

        })
    });
})
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
