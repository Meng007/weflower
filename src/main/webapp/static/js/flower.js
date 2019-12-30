var data1 = {
    "action":"pageFlower",
    "type":"dr",
    "page":1,
    "row":5
}
var data2 = {
    "action":"pageFlower",
    "type":"pz",
    "page":1,
    "row":10
}
var data3 = {
    "action":"pageFlower",
    "type":"pj",
    "page":1,
    "row":7
}
var data4 = {
    "action":"pageFlower",
    "type":"sp",
    "page":1,
    "row":4
}

function dr() {
    var flower_dr = $("#flower_dr");
    $.ajax({
        url:"/flower/info",
        data:data1,
        type:'get',
        dataType:"json",
        success:function (data) {
            flower_dr.empty();
            console.log(data)
            console.log(data.list.length)
            for (var i = 1; i <data.list.length; i++) {
                flower_dr.append(
                    "<li><a href='/flower/info?action=flower&fid="+data.list[i].fid+"'><img src='"+data.list[i].pic  +"' /></a></li>"
                )
            }
            $("#dr5").attr("src",data.list[0].pic);
            $("#a5").attr("href","/flower/info?action=flower&fid="+data.list[0].fid);
            data1.page=data.page;
        }
    })
}
function pz() {
    var flower_pz_1 = $("#flower_pz_1");
    var flower_pz_2 = $("#flower_pz_2");
    var flower_pz_3 = $("#flower_pz_3");
    $.ajax({
        url:"/flower/info",
        data:data2,
        type:'get',
        dataType:"json",
        success:function (data) {

            flower_pz_1.empty();
            flower_pz_2.empty();
            flower_pz_3.empty();
            console.log(data)
            for (var i = 1; i <data.list.length; i++) {
                if (i<4) {
                    flower_pz_1.append(
                        "<li>\n" +
                        "                        <a><img src='" + data.list[i].pic + "' /></a>\n" +
                        "                        <p><font>" + data.list[i].name + "</font>(" + data.list[i].title + ")</p>\n" +
                        "                        <p class=\"buy\"><span class=\"buyWord\">" + data.list[i].type + "</span><a href='/flower/info?action=flower&fid=" + data.list[i].fid + "'><span class=\"buyBuy\">立即购买></span></a></p>\n" +
                        "                    </li>")

                }else if (i>=4 && i<7){
                        flower_pz_2.append(
                            "<li>\n" +
                            "                        <a><img src='"+data.list[i].pic+"' /></a>\n" +
                            "                        <p><font>"+data.list[i].name+"</font>("+data.list[i].title+")</p>\n" +
                            "                        <p class=\"buy\"><span class=\"buyWord\">"+data.list[i].type+"</span><a href='/flower/info?action=flower&fid="+data.list[i].fid+"'><span class=\"buyBuy\">立即购买></span></a></p>\n" +
                            "                    </li>")
                    }else {
                        flower_pz_3.append(
                            "<li>\n" +
                            "                        <a><img src='"+data.list[i].pic+"' /></a>\n" +
                            "                        <p><font>"+data.list[i].name+"</font>("+data.list[i].title+")</p>\n" +
                            "                        <p class=\"buy\"><span class=\"buyWord\">"+data.list[i].type+"</span><a href='/flower/info?action=flower&fid="+data.list[i].fid+"'><span class=\"buyBuy\">立即购买></span></a></p>\n" +
                            "                    </li>")
                    }
                }

            $("#flower_pz_img").attr("src",data.list[0].pic);
            $("#flower_pz_a").attr("href","/flower/info?action=flower&fid="+data.list[0].fid);
            data2.page=data.page;

        }
    })
}
function pj() {
    var flower_pj_1 = $("#flower_pj_1");
    var flower_pj_2 = $("#flower_pj_2");
    $.ajax({
        url:"/flower/info",
        data:data3,
        type:'get',
        dataType:"json",
        success:function (data) {
            flower_pj_1.empty();
            flower_pj_2.empty();
            console.log(data)
            for (var i = 1; i <data.list.length; i++) {
                if (i<4) {
                    flower_pj_1.append(
                        "<li>\n" +
                        "                        <a><img src='" + data.list[i].pic + "' /></a>\n" +
                        "                        <p><font>" + data.list[i].name + "</font>(" + data.list[i].title + ")</p>\n" +
                        "                        <p class=\"buy\"><span class=\"buyWord\">" + data.list[i].type + "</span><a href='/flower/info?action=flower&fid=" + data.list[i].fid + "'><span class=\"buyBuy\">立即购买></span></a></p>\n" +
                        "                    </li>")

                }else {
                    flower_pj_2.append(
                        "<li>\n" +
                        "                        <a><img src='"+data.list[i].pic+"' /></a>\n" +
                        "                        <p><font>"+data.list[i].name+"</font>("+data.list[i].title+")</p>\n" +
                        "                        <p class=\"buy\"><span class=\"buyWord\">"+data.list[i].type+"</span><a href='/flower/info?action=flower&fid="+data.list[i].fid+"'><span class=\"buyBuy\">立即购买></span></a></p>\n" +
                        "                    </li>")
                }
            }
            $("#flower_pj_img").attr("src",data.list[0].pic);
            $("#flower_pj_a").attr("href","/flower/info?action=flower&fid="+data.list[0].fid);
            data3.page=data.page;
        }
    })
}
function sp() {
    $.ajax({
        url:"/flower/info",
        data:data4,
        type:'get',
        dataType:"json",
        success:function (data) {
            var flower_sp = $("#flower_sp");
            flower_sp.empty();
            console.log(data)
            for (var i = 1; i <data.list.length ; i++) {
                    flower_sp.append(
                        "<li>\n" +
                        "                        <a><img src='"+data.list[i].pic+"' /></a>\n" +
                        "                        <p><font>"+data.list[i].name+"</font>("+data.list[i].title+")</p>\n" +
                        "                        <p class=\"buy\"><span class=\"buyWord\">"+data.list[i].type+"</span><a href='/flower/info?action=flower&fid="+data.list[i].fid+"'><span class=\"buyBuy\">立即购买></span></a></p>\n" +
                        "                    </li>"
                    )
            }
            $("#flower_sp_img").attr("src",data.list[0].pic);
            $("#flower_sp_a").attr("href","/flower/info?action=flower&fid="+data.list[0].fid);
            data4.page=data.page;
        }
    })
}