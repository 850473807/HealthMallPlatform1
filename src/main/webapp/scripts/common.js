var main_url = "http://localhost:8080";

function initPage() {
    $.ajax({
        url: main_url + "/page/init",
        type: "post",
        dataType: "json",
        success: function (data) {
            if (data.user != null) {
                var text = "<li><span>欢迎! <a href='/user/info'>" +
                    data.user + "</a></span></li>"
                    + "<li><a href='" + main_url + "/user/logout'>退出</a></li>";

                $("#login").html(text);
            } else {
                var text = "<li><span>欢迎! </span></li>"
                    +
                    "<li><a href='/html/login.html'>登录</a></li>";
                $("#login").html(text);
            }

            var text = "<li><a href='../html/index.html'>首页</a></li>"
            var list = data.category;
            // 类型标签
            for (var i = 0; i < list.length; i++) {
                var href = 'javascript: reload("'+main_url + '/page/search?category=' + list[i].id+'")';
                text += "<li><a href='" + href + "'>" + list[i].name + "</a></li>"
            }
            $("#category").html(text);
        }
    });
}

function reload(href) {
    window.location.href = href +"&"+new Date().getMilliseconds();
}

function buildPage(data) {
    var text = "";
    var text2 = "";
    $.each(data.list,function (i,e) {
        var href = main_url+'/page/detail?prod='+e.pid+"&"+new Date().getMilliseconds();
        var img = '../images/'+e.img;
        var name = e.pname;
        var price = (e.price/100).toFixed(2);
        var marketPrice = (e.marketPrice/100).toFixed(2);
        var talkNum = e.talkNum;
        text+='<li class="block-list">' +
            '<a href="'+href+'"><img src="'+img+'" alt=""/>'+name+'</a>' +
            '<p class="price"><strong>¥ '+price+'</strong></p>' +
            '<div class="market-price">' +
            '<small>市场价<del>￥'+marketPrice+'</del></small>' +
            '<p><a href="javascript: void (0)">'+talkNum+'</a>人讨论</p>' +
            '</div>' +
            '<p class="buy-btn">' +
            '<a href="javascript: buyNow('+e.pid+')">立刻购买</a>' +
            '<a href="javascript: add2cart('+e.pid+')">加入购物车</a>' +
            '</p>' +
            '</li>';

        text2+='<li class="menu_list clearfix">\n' +
            '<a class="leftBar title" href="'+href+'"><img class="leftBar" src="'+img+'" alt=""><span class="leftBar">'+name+'</span>' +
            '</a>' +
            '<span class="leftBar price"><strong>¥ '+price+'</strong></span>' +
            '<div class="leftBar market-price">' +
            '<small>市场价<del>￥'+marketPrice+'</del></small>' +
            '<p><a href="javascript: void (0)">'+talkNum+'</a>人讨论</p>' +
            '</div>' +
            '<p class="rightBar buy-box">' +
            '<span class="buy-btn">' +
            '<a href="javascript: void (0)">立刻购买</a>' +
            '</span>' +
            '<span class="buy-btn">\n' +
            '<a href="javascript: void (0)">加入购物车</a>' +
            '</span>' +
            '</p>' +
            '</li>';
    })
    $('#block-list-box').html(text);
    $('#menu_list_box').html(text2);

    var curentPage = data.page.curentPage;
    var totalPage = data.page.totalPage;
    var totalCount = data.page.totalCount;

    var pageContent =
        '<span>第 '+curentPage+'页， 共 '+totalPage+' 页 [共'+totalCount+'件商品]</span>';
    for (var i=1;i<=totalPage;i++){
        var active = i==curentPage ? 'class="current"':'';
        var
            pageHref = 'javascript: pageQuery('+i+')';

        pageContent +=
            '<a '+active+' href="'+pageHref+'">'+i+'</a>';
    }
    $('#page').html(pageContent);

}

function index() {
    window.location.href = main_url+"/html/index.html"
}

function searchList(isReload) {
    var name =$('#search').val();
    var brand = "";
    $.each($('#brand input'),function (i,e) {
       brand+=e.checked?e.value+",":"";
    });
    var price = "";
    $.each($('#price input'),function (i,e) {
        price=e.checked?e.value:price;
    });

    price = price==1?"0,10000":price==2?"10100,30000":price==3?"30000,99999999999":"";
    
    if (isReload)
    {
        window.location.href =main_url + "/page/search?name="+name;
    }
    else
    {
        $.ajax({
            url: main_url + "/prod/search",
            type: "post",
            data: {"name":name,"brand":brand,"price":price},
            dataType: "json",
            success: function (data) {
                buildPage(data);
            }
        });
    }
}

$(function () {
    $('#price [type="checkbox"]').each(function () {
        $(this).click(function () {
            if(this.checked){
                $('#price [type="checkbox"]').removeAttr('checked');
                this.checked='checked';
            }
        })
    })
})

function add2cart(pid) {

    var count = $("#count_"+pid).val()?$("#count_"+pid).val():1;
    $.ajax({
        url: main_url + "/cart/add2Cart?pid="+pid+"&count="+count,
        type: "post",
        dataType: "json",
        success: function (data) {

        }
    });
}

function buyNow(pid) {
    var count = $("#count_"+pid).val()?$("#count_"+pid).val():1;
    $.ajax({
        url: main_url + "/cart/buyNow?pid="+pid+"&count="+count,
        type: "post",
        dataType: "json",
        success: function (data) {
            window.location.href = main_url+data.href;
        }
    });
}

function toCart() {

    $.ajax({
        url: main_url + "/cart/toCart",
        type: "post",
        dataType: "json",
        success: function (data) {
            window.location.href = main_url+data.href;
        }
    });
}