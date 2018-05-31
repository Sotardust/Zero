package com.dai.zero.main.util;

import com.dai.zero.bean.FindBean;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Administrator on 2018/4/1 0001.
 */

public class ParamAnalysisUtil {
    public static String neteaseContent = "<ul class=\"m-cvrlst f-cb\" id=\"m-pl-container\">\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/TPtanZoOZlDrz65Wp4Fi4w==/19131502323881623.jpg?param=140y140\">\n" +
            "<a title=\"五四 | 城市青年图鉴\" href=\"/playlist?id=2195037934\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2195037934\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">44207</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"五四 | 城市青年图鉴\" href=\"/playlist?id=2195037934\" class=\"tit f-thide s-fc0\">五四 | 城市青年图鉴</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"Zig-Zag\" href=\"/user/home?id=68208482\" class=\"nm nm-icn f-thide s-fc3\">Zig-Zag</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/mxVdQ3P0snI9JHTpD9eGwA==/109951163275200967.jpg?param=140y140\">\n" +
            "<a title=\"4月国电精选&nbsp;|&nbsp;崛起中的中国电子音乐\" href=\"/playlist?id=2170120521\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2170120521\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">14639</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"4月国电精选&nbsp;|&nbsp;崛起中的中国电子音乐\" href=\"/playlist?id=2170120521\" class=\"tit f-thide s-fc0\">4月国电精选&nbsp;|&nbsp;崛起中的中国电子音乐</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"PurpleBattery\" href=\"/user/home?id=77561297\" class=\"nm nm-icn f-thide s-fc3\">PurpleBattery</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/o58GsVBhH6XQyXbJiWeygA==/18693896697643550.jpg?param=140y140\">\n" +
            "<a title=\"「虽然很辛苦，但是努力过真好」\" href=\"/playlist?id=572598549\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"572598549\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">77万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「虽然很辛苦，但是努力过真好」\" href=\"/playlist?id=572598549\" class=\"tit f-thide s-fc0\">「虽然很辛苦，但是努力过真好」</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"八月夏末_\" href=\"/user/home?id=56002621\" class=\"nm nm-icn f-thide s-fc3\">八月夏末_</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/QnEfpW9taEfWccVDg-MctA==/109951163267578612.jpg?param=140y140\">\n" +
            "<a title=\"「华语」喜欢你只是我一个人的彳亍\" href=\"/playlist?id=2200298188\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2200298188\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">118万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「华语」喜欢你只是我一个人的彳亍\" href=\"/playlist?id=2200298188\" class=\"tit f-thide s-fc0\">「华语」喜欢你只是我一个人的彳亍</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"哥哥-Leslie\" href=\"/user/home?id=40136303\" class=\"nm nm-icn f-thide s-fc3\">哥哥-Leslie</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/Hw8AyPHTzWd5qLSCxTppIA==/18681802069742775.jpg?param=140y140\">\n" +
            "<a title=\"夏天快要来临，牵你手去买冰淇淋\" href=\"/playlist?id=2199015597\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2199015597\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">318万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"夏天快要来临，牵你手去买冰淇淋\" href=\"/playlist?id=2199015597\" class=\"tit f-thide s-fc0\">夏天快要来临，牵你手去买冰淇淋</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"谷歌之露\" href=\"/user/home?id=266088971\" class=\"nm nm-icn f-thide s-fc3\">谷歌之露</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/aVhyn0VAuwcBMEG3GgdTsw==/109951163280704629.jpg?param=140y140\">\n" +
            "<a title=\"华语歌曲精选（持续更新）\" href=\"/playlist?id=2211299864\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2211299864\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">44270</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"华语歌曲精选（持续更新）\" href=\"/playlist?id=2211299864\" class=\"tit f-thide s-fc0\">华语歌曲精选（持续更新）</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"汪星宇Music\" href=\"/user/home?id=253668392\" class=\"nm nm-icn f-thide s-fc3\">汪星宇Music</a> <sup class=\"icn u-icn2 u-icn2-music2 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/38v27r8EljeET-tFanmdlw==/109951163274818322.jpg?param=140y140\">\n" +
            "<a title=\"倾听100部电影，爱情的美丽与哀愁\" href=\"/playlist?id=2203603614\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2203603614\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">183万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"倾听100部电影，爱情的美丽与哀愁\" href=\"/playlist?id=2203603614\" class=\"tit f-thide s-fc0\">倾听100部电影，爱情的美丽与哀愁</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"蝶影丛虫\" href=\"/user/home?id=311877725\" class=\"nm nm-icn f-thide s-fc3\">蝶影丛虫</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/U4llcN68fL2Jw_rTh6haQw==/18774161046479087.jpg?param=140y140\">\n" +
            "<a title=\"重逢是始料未及丨回首又见你 流星花园\" href=\"/playlist?id=2202374751\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2202374751\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">363万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"重逢是始料未及丨回首又见你 流星花园\" href=\"/playlist?id=2202374751\" class=\"tit f-thide s-fc0\">重逢是始料未及丨回首又见你 流星花园</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"宠着长岛冰茶吗\" href=\"/user/home?id=375540586\" class=\"nm nm-icn f-thide s-fc3\">宠着长岛冰茶吗</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/wpahk9cQCDtdzJPE52EzJQ==/109951163271025942.jpg?param=140y140\">\n" +
            "<a title=\"你的青春里有没有属于你的一首歌？\" href=\"/playlist?id=2201879658\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2201879658\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">670万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"你的青春里有没有属于你的一首歌？\" href=\"/playlist?id=2201879658\" class=\"tit f-thide s-fc0\">你的青春里有没有属于你的一首歌？</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"mayuko然\" href=\"/user/home?id=129593031\" class=\"nm nm-icn f-thide s-fc3\">mayuko然</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/oX_I3L4zC_dB-lWLFShj0w==/109951163257345812.jpg?param=140y140\">\n" +
            "<a title=\"『四大名著』中国古典文学的精品\" href=\"/playlist?id=2193807890\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2193807890\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">125万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『四大名著』中国古典文学的精品\" href=\"/playlist?id=2193807890\" class=\"tit f-thide s-fc0\">『四大名著』中国古典文学的精品</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"花色游戏\" href=\"/user/home?id=248755337\" class=\"nm nm-icn f-thide s-fc3\">花色游戏</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/9Nnst9tlJZ1NdZEN8eb0Mw==/109951163261938931.jpg?param=140y140\">\n" +
            "<a title=\"岛·乐队集°台北夜空下的氤氲青年\" href=\"/playlist?id=2194760666\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2194760666\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">71万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"岛·乐队集°台北夜空下的氤氲青年\" href=\"/playlist?id=2194760666\" class=\"tit f-thide s-fc0\">岛·乐队集°台北夜空下的氤氲青年</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"鮭魚先森\" href=\"/user/home?id=9890112\" class=\"nm nm-icn f-thide s-fc3\">鮭魚先森</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/lzy222V4GyqakQfrmpdDwg==/18953381440148467.jpg?param=140y140\">\n" +
            "<a title=\"「古风」笛子前奏，如春风拂过\" href=\"/playlist?id=2188949054\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2188949054\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">159万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「古风」笛子前奏，如春风拂过\" href=\"/playlist?id=2188949054\" class=\"tit f-thide s-fc0\">「古风」笛子前奏，如春风拂过</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"佯佯得意\" href=\"/user/home?id=411402173\" class=\"nm nm-icn f-thide s-fc3\">佯佯得意</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/YWLGsjO2yNKZfaHewCdYSA==/109951163279773237.jpg?param=140y140\">\n" +
            "<a title=\"「2018」奔跑吧 第二季 BGM\" href=\"/playlist?id=2192048784\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2192048784\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">70869</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「2018」奔跑吧 第二季 BGM\" href=\"/playlist?id=2192048784\" class=\"tit f-thide s-fc0\">「2018」奔跑吧 第二季 BGM</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"provisionality\" href=\"/user/home?id=46293017\" class=\"nm nm-icn f-thide s-fc3\">provisionality</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/4gZNU13YQeFvYQfxmgSeyg==/109951163249663052.jpg?param=140y140\">\n" +
            "<a title=\"100个伤感的瞬间，有没有你的心酸？\" href=\"/playlist?id=2179646633\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2179646633\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">613万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"100个伤感的瞬间，有没有你的心酸？\" href=\"/playlist?id=2179646633\" class=\"tit f-thide s-fc0\">100个伤感的瞬间，有没有你的心酸？</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"朩朩青尘\" href=\"/user/home?id=7394345\" class=\"nm nm-icn f-thide s-fc3\">朩朩青尘</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/lhdp6FTOqNb07O7iJhjIFw==/19118308184364461.jpg?param=140y140\">\n" +
            "<a title=\"『国摇』五十支乐队五十种精神信仰\" href=\"/playlist?id=2179431622\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2179431622\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">280万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『国摇』五十支乐队五十种精神信仰\" href=\"/playlist?id=2179431622\" class=\"tit f-thide s-fc0\">『国摇』五十支乐队五十种精神信仰</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"浮梦沉生\" href=\"/user/home?id=256834399\" class=\"nm nm-icn f-thide s-fc3\">浮梦沉生</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/WjDAZ9C8whAB6yfE_sfIFw==/109951163244980773.jpg?param=140y140\">\n" +
            "<a title=\"致回不去的校园，致那美好的曾经\" href=\"/playlist?id=2182683172\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2182683172\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">425万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"致回不去的校园，致那美好的曾经\" href=\"/playlist?id=2182683172\" class=\"tit f-thide s-fc0\">致回不去的校园，致那美好的曾经</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"可尼晏\" href=\"/user/home?id=283413472\" class=\"nm nm-icn f-thide s-fc3\">可尼晏</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/ggshqZeKjWpdlD4dZRNJEQ==/18897306347170557.jpg?param=140y140\">\n" +
            "<a title=\"欢快小调 给百无聊赖的生活来支兴奋剂\" href=\"/playlist?id=2182669327\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2182669327\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">280万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"欢快小调 给百无聊赖的生活来支兴奋剂\" href=\"/playlist?id=2182669327\" class=\"tit f-thide s-fc0\">欢快小调 给百无聊赖的生活来支兴奋剂</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"鹿白川\" href=\"/user/home?id=493707309\" class=\"nm nm-icn f-thide s-fc3\">鹿白川</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/nA_0ekpi85zuqj39VJSH6A==/109951163272618425.jpg?param=140y140\">\n" +
            "<a title=\"后来的我们 唱着《后来》消失在人海\" href=\"/playlist?id=2181695887\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2181695887\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">330万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"后来的我们 唱着《后来》消失在人海\" href=\"/playlist?id=2181695887\" class=\"tit f-thide s-fc0\">后来的我们 唱着《后来》消失在人海</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"金暗洙\" href=\"/user/home?id=61711382\" class=\"nm nm-icn f-thide s-fc3\">金暗洙</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/1zG5PxVL3W1s5yU7b37MKA==/109951163260209046.jpg?param=140y140\">\n" +
            "<a title=\"「情歌Rap」我的超能力是超级喜欢你ღ\" href=\"/playlist?id=2177788266\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2177788266\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">8029</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「情歌Rap」我的超能力是超级喜欢你ღ\" href=\"/playlist?id=2177788266\" class=\"tit f-thide s-fc0\">「情歌Rap」我的超能力是超级喜欢你ღ</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"丁蛮\" href=\"/user/home?id=284887870\" class=\"nm nm-icn f-thide s-fc3\">丁蛮</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/P8w0xreTcXV-GAUcx6Axjg==/109951163216834301.jpg?param=140y140\">\n" +
            "<a title=\"熬夜和想你，我都该戒掉了\" href=\"/playlist?id=2163517726\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2163517726\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">1180万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"熬夜和想你，我都该戒掉了\" href=\"/playlist?id=2163517726\" class=\"tit f-thide s-fc0\">熬夜和想你，我都该戒掉了</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"朩朩青尘\" href=\"/user/home?id=7394345\" class=\"nm nm-icn f-thide s-fc3\">朩朩青尘</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/y9iABvPb3Mk8iqArtC8nKg==/19133701347129053.jpg?param=140y140\">\n" +
            "<a title=\"于时间的长廊上 你再也不等我\" href=\"/playlist?id=2168895862\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2168895862\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">925万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"于时间的长廊上 你再也不等我\" href=\"/playlist?id=2168895862\" class=\"tit f-thide s-fc0\">于时间的长廊上 你再也不等我</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"咕噜咀嚼C\" href=\"/user/home?id=120199044\" class=\"nm nm-icn f-thide s-fc3\">咕噜咀嚼C</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/4KVzztEigiXzbYpF_qj3DA==/109951163266301256.jpg?param=140y140\">\n" +
            "<a title=\"『古风·遇梦』听梦不愿醒 便随你风月无际\" href=\"/playlist?id=2171419444\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2171419444\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">116万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『古风·遇梦』听梦不愿醒 便随你风月无际\" href=\"/playlist?id=2171419444\" class=\"tit f-thide s-fc0\">『古风·遇梦』听梦不愿醒 便随你风月无际</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"花色游戏\" href=\"/user/home?id=248755337\" class=\"nm nm-icn f-thide s-fc3\">花色游戏</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/_rrm6Rgj2v3quCktMmtUNA==/109951163214236048.jpg?param=140y140\">\n" +
            "<a title=\"多少人以朋友的名义爱着一个人？\" href=\"/playlist?id=2162749304\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2162749304\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">645万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"多少人以朋友的名义爱着一个人？\" href=\"/playlist?id=2162749304\" class=\"tit f-thide s-fc0\">多少人以朋友的名义爱着一个人？</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"冷山集\" href=\"/user/home?id=104388569\" class=\"nm nm-icn f-thide s-fc3\">冷山集</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/BPqdfpQ3KXUiYiQgV3ycdQ==/109951163226749851.jpg?param=140y140\">\n" +
            "<a title=\"华语电影台词对白｜念念有声\" href=\"/playlist?id=2166181332\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2166181332\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">379万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"华语电影台词对白｜念念有声\" href=\"/playlist?id=2166181332\" class=\"tit f-thide s-fc0\">华语电影台词对白｜念念有声</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"下一颗巧克力\" href=\"/user/home?id=2445590\" class=\"nm nm-icn f-thide s-fc3\">下一颗巧克力</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/lITzHDYbGiXx2ApeGij5bg==/19069929672736187.jpg?param=140y140\">\n" +
            "<a title=\"「古风」藏在诗词里的歌名\" href=\"/playlist?id=2157458176\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2157458176\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">356万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「古风」藏在诗词里的歌名\" href=\"/playlist?id=2157458176\" class=\"tit f-thide s-fc0\">「古风」藏在诗词里的歌名</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"佯佯得意\" href=\"/user/home?id=411402173\" class=\"nm nm-icn f-thide s-fc3\">佯佯得意</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/o_7tjLLQNjHIZUPoNYO0Cw==/19218363742479542.jpg?param=140y140\">\n" +
            "<a title=\"繁华都市里的100个孤独旅人\" href=\"/playlist?id=2161007233\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2161007233\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">348万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"繁华都市里的100个孤独旅人\" href=\"/playlist?id=2161007233\" class=\"tit f-thide s-fc0\">繁华都市里的100个孤独旅人</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"墨_小宝\" href=\"/user/home?id=19389416\" class=\"nm nm-icn f-thide s-fc3\">墨_小宝</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/uXQsCWqdPverr4O-zMWP2w==/18906102440201061.jpg?param=140y140\">\n" +
            "<a title=\"大广赛命题歌单\" href=\"/playlist?id=2161675933\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2161675933\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">24万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"大广赛命题歌单\" href=\"/playlist?id=2161675933\" class=\"tit f-thide s-fc0\">大广赛命题歌单</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"网易云音乐校园\" href=\"/user/home?id=437350415\" class=\"nm nm-icn f-thide s-fc3\">网易云音乐校园</a> <sup class=\"icn u-icn2 u-icn2-music2 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/PH84DCJr7IdUwrJvue49Rw==/18872017579728048.jpg?param=140y140\">\n" +
            "<a title=\"华语女声 那些闪闪发光的吉他小姐姐\" href=\"/playlist?id=2154093907\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2154093907\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">124万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"华语女声 那些闪闪发光的吉他小姐姐\" href=\"/playlist?id=2154093907\" class=\"tit f-thide s-fc0\">华语女声 那些闪闪发光的吉他小姐姐</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"鹿白川\" href=\"/user/home?id=493707309\" class=\"nm nm-icn f-thide s-fc3\">鹿白川</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/6wq2s3Rtm8aJYvAoHKmgyA==/109951163202408350.jpg?param=140y140\">\n" +
            "<a title=\"我爱你 第一句是假的 第二句也是假的\" href=\"/playlist?id=2144281377\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2144281377\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">1241万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"我爱你 第一句是假的 第二句也是假的\" href=\"/playlist?id=2144281377\" class=\"tit f-thide s-fc0\">我爱你 第一句是假的 第二句也是假的</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"名侦探-柯北\" href=\"/user/home?id=44530116\" class=\"nm nm-icn f-thide s-fc3\">名侦探-柯北</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/o9GzTfkc0E8dOUCeejPv4w==/18680702558107743.jpg?param=140y140\">\n" +
            "<a title=\"岁月如潮水，将我向老歌推\" href=\"/playlist?id=2139305008\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2139305008\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">1162万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"岁月如潮水，将我向老歌推\" href=\"/playlist?id=2139305008\" class=\"tit f-thide s-fc0\">岁月如潮水，将我向老歌推</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"丑萌的猫\" href=\"/user/home?id=437728739\" class=\"nm nm-icn f-thide s-fc3\">丑萌的猫</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/TpCinfY4hmnWhl6JbcPGog==/109951163185285618.jpg?param=140y140\">\n" +
            "<a title=\"台湾偶像剧黄金年代|记忆是阵阵花香\" href=\"/playlist?id=2134421380\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2134421380\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">603万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"台湾偶像剧黄金年代|记忆是阵阵花香\" href=\"/playlist?id=2134421380\" class=\"tit f-thide s-fc0\">台湾偶像剧黄金年代|记忆是阵阵花香</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"可尼晏\" href=\"/user/home?id=283413472\" class=\"nm nm-icn f-thide s-fc3\">可尼晏</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/pAidnPdX-0fhVakVXiHMzg==/18575149441852040.jpg?param=140y140\">\n" +
            "<a title=\"一百首‖让你瞬间勾起回忆的老歌\" href=\"/playlist?id=2134203011\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2134203011\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">402万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"一百首‖让你瞬间勾起回忆的老歌\" href=\"/playlist?id=2134203011\" class=\"tit f-thide s-fc0\">一百首‖让你瞬间勾起回忆的老歌</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"情思天鹅\" href=\"/user/home?id=108952364\" class=\"nm nm-icn f-thide s-fc3\">情思天鹅</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/BBfrJ4hkX9NOs1UkxyLMZw==/19085322835513264.jpg?param=140y140\">\n" +
            "<a title=\"你是一首旋律，被写在春天的风里\" href=\"/playlist?id=2139819755\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2139819755\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">314万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"你是一首旋律，被写在春天的风里\" href=\"/playlist?id=2139819755\" class=\"tit f-thide s-fc0\">你是一首旋律，被写在春天的风里</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"南屏晚歌\" href=\"/user/home?id=419044882\" class=\"nm nm-icn f-thide s-fc3\">南屏晚歌</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/npjVzLVW9E0fex6HZbv1iw==/109951163198861683.jpg?param=140y140\">\n" +
            "<a title=\"黄舒骏推荐华语流行音乐30年必听歌曲\" href=\"/playlist?id=2141392076\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2141392076\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">30万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"黄舒骏推荐华语流行音乐30年必听歌曲\" href=\"/playlist?id=2141392076\" class=\"tit f-thide s-fc0\">黄舒骏推荐华语流行音乐30年必听歌曲</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"黄舒骏\" href=\"/user/home?id=1384879758\" class=\"nm nm-icn f-thide s-fc3\">黄舒骏</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/KzYLvOqUujpQRhedlMgniQ==/18714787418579648.jpg?param=140y140\">\n" +
            "<a title=\"2010-2018百部爱情电影OST合集\" href=\"/playlist?id=2136967635\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2136967635\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">53万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"2010-2018百部爱情电影OST合集\" href=\"/playlist?id=2136967635\" class=\"tit f-thide s-fc0\">2010-2018百部爱情电影OST合集</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"南屏晚歌\" href=\"/user/home?id=419044882\" class=\"nm nm-icn f-thide s-fc3\">南屏晚歌</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "</ul>" +
            "<ul class=\"m-cvrlst f-cb\" id=\"m-pl-container\">\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/P7WPK7hxi6ML10wgoWTW9A==/109951163178025408.jpg?param=140y140\">\n" +
            "<a title=\"任贤齐：这里的表演很精彩\" href=\"/playlist?id=2129466456\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2129466456\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">134万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"任贤齐：这里的表演很精彩\" href=\"/playlist?id=2129466456\" class=\"tit f-thide s-fc0\">任贤齐：这里的表演很精彩</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"云音乐歌单之友\" href=\"/user/home?id=39577093\" class=\"nm nm-icn f-thide s-fc3\">云音乐歌单之友</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/GjEYDkrdS-FNC6siXlKp-Q==/109951163182765878.jpg?param=140y140\">\n" +
            "<a title=\"伤心回忆寄存馆|今日营业中\" href=\"/playlist?id=2123418952\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2123418952\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">371万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"伤心回忆寄存馆|今日营业中\" href=\"/playlist?id=2123418952\" class=\"tit f-thide s-fc0\">伤心回忆寄存馆|今日营业中</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"溺水小熊\" href=\"/user/home?id=416935335\" class=\"nm nm-icn f-thide s-fc3\">溺水小熊</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/xIzuBDpK7FbG81uVdfSjoQ==/19078725765747383.jpg?param=140y140\">\n" +
            "<a title=\"田馥甄最全歌曲正序集\" href=\"/playlist?id=2125261392\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2125261392\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">40万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"田馥甄最全歌曲正序集\" href=\"/playlist?id=2125261392\" class=\"tit f-thide s-fc0\">田馥甄最全歌曲正序集</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"周宗元要勇敢\" href=\"/user/home?id=60011491\" class=\"nm nm-icn f-thide s-fc3\">周宗元要勇敢</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/pX2lsnYvvVCmykkA6qpdAA==/18930291695999064.jpg?param=140y140\">\n" +
            "<a title=\"「古风」错身遇个你，穷尽诗家笔\" href=\"/playlist?id=2118036706\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2118036706\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">246万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「古风」错身遇个你，穷尽诗家笔\" href=\"/playlist?id=2118036706\" class=\"tit f-thide s-fc0\">「古风」错身遇个你，穷尽诗家笔</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"佯佯得意\" href=\"/user/home?id=411402173\" class=\"nm nm-icn f-thide s-fc3\">佯佯得意</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/8UlHDv3_ynDCsz4TC-Raxw==/109951163160241235.jpg?param=140y140\">\n" +
            "<a title=\"暖春，寄一首阳光明媚的歌给你\" href=\"/playlist?id=2114030515\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2114030515\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">567万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"暖春，寄一首阳光明媚的歌给你\" href=\"/playlist?id=2114030515\" class=\"tit f-thide s-fc0\">暖春，寄一首阳光明媚的歌给你</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"名侦探-柯北\" href=\"/user/home?id=44530116\" class=\"nm nm-icn f-thide s-fc3\">名侦探-柯北</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/fmGmWizaWrpC5gwoAmnDGA==/19025949207609358.jpg?param=140y140\">\n" +
            "<a title=\"「不老女声」你 是 窗 前 深 浅 白 月 光\" href=\"/playlist?id=2121679666\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2121679666\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">739万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「不老女声」你 是 窗 前 深 浅 白 月 光\" href=\"/playlist?id=2121679666\" class=\"tit f-thide s-fc0\">「不老女声」你 是 窗 前 深 浅 白 月 光</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"双皮奶吃人\" href=\"/user/home?id=45803217\" class=\"nm nm-icn f-thide s-fc3\">双皮奶吃人</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/u-FpM4sspH_B2tOuX6P09w==/109951163169224713.jpg?param=140y140\">\n" +
            "<a title=\"华语男声丨有些记忆 只有音乐可以唤起\" href=\"/playlist?id=2122104724\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2122104724\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">464万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"华语男声丨有些记忆 只有音乐可以唤起\" href=\"/playlist?id=2122104724\" class=\"tit f-thide s-fc0\">华语男声丨有些记忆 只有音乐可以唤起</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"金暗洙\" href=\"/user/home?id=61711382\" class=\"nm nm-icn f-thide s-fc3\">金暗洙</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/3o4PV6uLUbwNR9RnSeinQg==/109951163176418492.jpg?param=140y140\">\n" +
            "<a title=\"【SHE全专辑集】\" href=\"/playlist?id=2121558366\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2121558366\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">107万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"【SHE全专辑集】\" href=\"/playlist?id=2121558366\" class=\"tit f-thide s-fc0\">【SHE全专辑集】</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"刘宽-\" href=\"/user/home?id=1580117\" class=\"nm nm-icn f-thide s-fc3\">刘宽-</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/T0NCBc6PZ0l94SsVR5qRkw==/19138099393653100.jpg?param=140y140\">\n" +
            "<a title=\"华语男声 你来这走一遭 奇迹般万物生长\" href=\"/playlist?id=2116641078\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2116641078\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">130万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"华语男声 你来这走一遭 奇迹般万物生长\" href=\"/playlist?id=2116641078\" class=\"tit f-thide s-fc0\">华语男声 你来这走一遭 奇迹般万物生长</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"鹿白川\" href=\"/user/home?id=493707309\" class=\"nm nm-icn f-thide s-fc3\">鹿白川</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/2FO2Yq0HivveMlO_dNOzJA==/109951163171439991.jpg?param=140y140\">\n" +
            "<a title=\"华研国际精选\" href=\"/playlist?id=2121878228\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2121878228\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">80万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"华研国际精选\" href=\"/playlist?id=2121878228\" class=\"tit f-thide s-fc0\">华研国际精选</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"告白气球-V\" href=\"/user/home?id=333306387\" class=\"nm nm-icn f-thide s-fc3\">告白气球-V</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/JJiebnZ0qau0LuMf-uaSRg==/18631224534853553.jpg?param=140y140\">\n" +
            "<a title=\"非主流青春里听过的歌\" href=\"/playlist?id=2113359151\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2113359151\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">138万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"非主流青春里听过的歌\" href=\"/playlist?id=2113359151\" class=\"tit f-thide s-fc0\">非主流青春里听过的歌</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"佯佯得意\" href=\"/user/home?id=411402173\" class=\"nm nm-icn f-thide s-fc3\">佯佯得意</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/lZNDuj-Fh2fgY-U631A9pA==/109951163216990434.jpg?param=140y140\">\n" +
            "<a title=\"看万般喜乐纷至沓来\" href=\"/playlist?id=2115691962\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2115691962\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">21876</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"看万般喜乐纷至沓来\" href=\"/playlist?id=2115691962\" class=\"tit f-thide s-fc0\">看万般喜乐纷至沓来</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"SouthRose\" href=\"/user/home?id=433097439\" class=\"nm nm-icn f-thide s-fc3\">SouthRose</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/Ut34N0F6Jy--F9eLblaI5A==/109951163200648104.jpg?param=140y140\">\n" +
            "<a title=\"爱情曾来过，最后留下琥珀\" href=\"/playlist?id=2118114949\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2118114949\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">30万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"爱情曾来过，最后留下琥珀\" href=\"/playlist?id=2118114949\" class=\"tit f-thide s-fc0\">爱情曾来过，最后留下琥珀</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"哥哥-Leslie\" href=\"/user/home?id=40136303\" class=\"nm nm-icn f-thide s-fc3\">哥哥-Leslie</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/TrPKmRXEh1RjAUtk98sXRQ==/109951163220304475.jpg?param=140y140\">\n" +
            "<a title=\"『随歌入画』笔墨浓淡 丹青绘山河\" href=\"/playlist?id=2102255856\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2102255856\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">147万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『随歌入画』笔墨浓淡 丹青绘山河\" href=\"/playlist?id=2102255856\" class=\"tit f-thide s-fc0\">『随歌入画』笔墨浓淡 丹青绘山河</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"花色游戏\" href=\"/user/home?id=248755337\" class=\"nm nm-icn f-thide s-fc3\">花色游戏</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/odnHxkz8BjOj9xBcIbDPYQ==/109951163145421426.jpg?param=140y140\">\n" +
            "<a title=\"古风 I 红烛多情化着泪 漫漫长夜摧伊人\" href=\"/playlist?id=2100341581\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2100341581\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">208万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"古风 I 红烛多情化着泪 漫漫长夜摧伊人\" href=\"/playlist?id=2100341581\" class=\"tit f-thide s-fc0\">古风 I 红烛多情化着泪 漫漫长夜摧伊人</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"朩朩青尘\" href=\"/user/home?id=7394345\" class=\"nm nm-icn f-thide s-fc3\">朩朩青尘</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/j6NqmJnw0U3iP_qXwzmmZg==/18863221486719166.jpg?param=140y140\">\n" +
            "<a title=\"ONER团综bgm\" href=\"/playlist?id=2111698780\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2111698780\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">64372</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"ONER团综bgm\" href=\"/playlist?id=2111698780\" class=\"tit f-thide s-fc0\">ONER团综bgm</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"你非我杯茶\" href=\"/user/home?id=559768186\" class=\"nm nm-icn f-thide s-fc3\">你非我杯茶</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/i1kx6RbOgLkXgH7chsh8vQ==/109951163249537120.jpg?param=140y140\">\n" +
            "<a title=\"『经典咏流传』四书五经唐诗宋词朗诵\" href=\"/playlist?id=2099834585\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2099834585\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">57362</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『经典咏流传』四书五经唐诗宋词朗诵\" href=\"/playlist?id=2099834585\" class=\"tit f-thide s-fc0\">『经典咏流传』四书五经唐诗宋词朗诵</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"璨梦星辰\" href=\"/user/home?id=107005194\" class=\"nm nm-icn f-thide s-fc3\">璨梦星辰</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/EmhoV66_fesIIc4sYQ5EAQ==/19080924788992622.jpg?param=140y140\">\n" +
            "<a title=\"放完寒假，还是要继续追逐梦想\" href=\"/playlist?id=2097548733\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2097548733\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">311万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"放完寒假，还是要继续追逐梦想\" href=\"/playlist?id=2097548733\" class=\"tit f-thide s-fc0\">放完寒假，还是要继续追逐梦想</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"阿色不喝七喜\" href=\"/user/home?id=368282503\" class=\"nm nm-icn f-thide s-fc3\">阿色不喝七喜</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/KmPhnFGz-P0V7ZkzNZI0PQ==/109951163136609113.jpg?param=140y140\">\n" +
            "<a title=\"民谣里有哪些動聽的情话？\" href=\"/playlist?id=2091758391\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2091758391\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">204万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"民谣里有哪些動聽的情话？\" href=\"/playlist?id=2091758391\" class=\"tit f-thide s-fc0\">民谣里有哪些動聽的情话？</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"Romantic丶Notes\" href=\"/user/home?id=90953939\" class=\"nm nm-icn f-thide s-fc3\">Romantic丶Notes</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/1b4PYx4pywTRBBr7TtHBXA==/18823639069713073.jpg?param=140y140\">\n" +
            "<a title=\"如果可以，我想和古人谈一场恋爱\" href=\"/playlist?id=2091038787\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2091038787\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">209万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"如果可以，我想和古人谈一场恋爱\" href=\"/playlist?id=2091038787\" class=\"tit f-thide s-fc0\">如果可以，我想和古人谈一场恋爱</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"冷色布偶猫\" href=\"/user/home?id=1322226034\" class=\"nm nm-icn f-thide s-fc3\">冷色布偶猫</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/uV2ryn8D4xzv2aYgKdKMwA==/109951163145348936.jpg?param=140y140\">\n" +
            "<a title=\"想要办一场古风婚礼，许一世天地作嫁\" href=\"/playlist?id=2074273616\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2074273616\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">436万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"想要办一场古风婚礼，许一世天地作嫁\" href=\"/playlist?id=2074273616\" class=\"tit f-thide s-fc0\">想要办一场古风婚礼，许一世天地作嫁</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"花色游戏\" href=\"/user/home?id=248755337\" class=\"nm nm-icn f-thide s-fc3\">花色游戏</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/vdbw22CK1MHbYWC3OSGfKg==/19199672044731044.jpg?param=140y140\">\n" +
            "<a title=\"古风精选 你眼中是江湖 我眼中是你\" href=\"/playlist?id=2074681032\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2074681032\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">582万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"古风精选 你眼中是江湖 我眼中是你\" href=\"/playlist?id=2074681032\" class=\"tit f-thide s-fc0\">古风精选 你眼中是江湖 我眼中是你</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"鹿白川\" href=\"/user/home?id=493707309\" class=\"nm nm-icn f-thide s-fc3\">鹿白川</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/TIqzhf7GQSQSeIySQsyqVw==/109951163152304206.jpg?param=140y140\">\n" +
            "<a title=\"寒假都快结束了，暑假为什么不接上？\" href=\"/playlist?id=2106881647\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2106881647\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">210万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"寒假都快结束了，暑假为什么不接上？\" href=\"/playlist?id=2106881647\" class=\"tit f-thide s-fc0\">寒假都快结束了，暑假为什么不接上？</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"CharitySylvia\" href=\"/user/home?id=90928936\" class=\"nm nm-icn f-thide s-fc3\">CharitySylvia</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/M-wzwR10JkzM9YU-_ikUpw==/109951163200071876.jpg?param=140y140\">\n" +
            "<a title=\"『曲作精选』细数古风圈原创作曲人❷\" href=\"/playlist?id=2088028082\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2088028082\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">11万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『曲作精选』细数古风圈原创作曲人❷\" href=\"/playlist?id=2088028082\" class=\"tit f-thide s-fc0\">『曲作精选』细数古风圈原创作曲人❷</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"花色游戏\" href=\"/user/home?id=248755337\" class=\"nm nm-icn f-thide s-fc3\">花色游戏</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/MEKx2gO_PSEflIZ5-5auZw==/18782957139480495.jpg?param=140y140\">\n" +
            "<a title=\"【妖说】沧海桑田 只待君归\" href=\"/playlist?id=2081400147\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2081400147\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">153万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"【妖说】沧海桑田 只待君归\" href=\"/playlist?id=2081400147\" class=\"tit f-thide s-fc0\">【妖说】沧海桑田 只待君归</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"冷色布偶猫\" href=\"/user/home?id=1322226034\" class=\"nm nm-icn f-thide s-fc3\">冷色布偶猫</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/rSlP85XKmSKRd7talIksLA==/19174383277348946.jpg?param=140y140\">\n" +
            "<a title=\"『这！就是街舞』最全BGM合集持更\" href=\"/playlist?id=2078747658\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2078747658\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">162万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『这！就是街舞』最全BGM合集持更\" href=\"/playlist?id=2078747658\" class=\"tit f-thide s-fc0\">『这！就是街舞』最全BGM合集持更</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"潮音潮乐\" href=\"/user/home?id=278675941\" class=\"nm nm-icn f-thide s-fc3\">潮音潮乐</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/nq29jN2ZpiGJZLLl4khbmw==/18520173860450563.jpg?param=140y140\">\n" +
            "<a title=\"古风词作‖他们只是喜欢用歌的方式来讲故事\" href=\"/playlist?id=2081133164\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2081133164\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">163万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"古风词作‖他们只是喜欢用歌的方式来讲故事\" href=\"/playlist?id=2081133164\" class=\"tit f-thide s-fc0\">古风词作‖他们只是喜欢用歌的方式来讲故事</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"佯佯得意\" href=\"/user/home?id=411402173\" class=\"nm nm-icn f-thide s-fc3\">佯佯得意</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/N28HiLsanNSfG70rL9CJ8w==/19165587184343511.jpg?param=140y140\">\n" +
            "<a title=\"『热血街舞团』参演曲目及出场BGM\" href=\"/playlist?id=2077299279\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2077299279\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">51万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"『热血街舞团』参演曲目及出场BGM\" href=\"/playlist?id=2077299279\" class=\"tit f-thide s-fc0\">『热血街舞团』参演曲目及出场BGM</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"潮音潮乐\" href=\"/user/home?id=278675941\" class=\"nm nm-icn f-thide s-fc3\">潮音潮乐</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/oA7SCckq1_kVUh4ycjVLxA==/19079825277366167.jpg?param=140y140\">\n" +
            "<a title=\"「婚礼用」为你着一袭白纱，愿余生共赴白发\" href=\"/playlist?id=2087840417\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2087840417\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">32985</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"「婚礼用」为你着一袭白纱，愿余生共赴白发\" href=\"/playlist?id=2087840417\" class=\"tit f-thide s-fc0\">「婚礼用」为你着一袭白纱，愿余生共赴白发</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"宠着长岛冰茶吗\" href=\"/user/home?id=375540586\" class=\"nm nm-icn f-thide s-fc3\">宠着长岛冰茶吗</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/lu0NuzTOhEk_0H63KhXu7w==/109951163137328402.jpg?param=140y140\">\n" +
            "<a title=\"我们在苏打绿的小宇宙里再遇见\" href=\"/playlist?id=2092015892\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2092015892\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">239万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"我们在苏打绿的小宇宙里再遇见\" href=\"/playlist?id=2092015892\" class=\"tit f-thide s-fc0\">我们在苏打绿的小宇宙里再遇见</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"云音乐歌单之友\" href=\"/user/home?id=39577093\" class=\"nm nm-icn f-thide s-fc3\">云音乐歌单之友</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/MPsxJ2F_afunBeledyBazg==/18819241023045385.jpg?param=140y140\">\n" +
            "<a title=\"敲可爱的歌单（恋爱的感觉）\" href=\"/playlist?id=2105070813\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2105070813\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">6521</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"敲可爱的歌单（恋爱的感觉）\" href=\"/playlist?id=2105070813\" class=\"tit f-thide s-fc0\">敲可爱的歌单（恋爱的感觉）</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"i木元\" href=\"/user/home?id=431943124\" class=\"nm nm-icn f-thide s-fc3\">i木元</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/Hcf_U-bipM4nl8AQbWsqvQ==/19031446765754182.jpg?param=140y140\">\n" +
            "<a title=\"细数那些值得单曲循环的民谣\" href=\"/playlist?id=2150055953\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2150055953\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">553万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"细数那些值得单曲循环的民谣\" href=\"/playlist?id=2150055953\" class=\"tit f-thide s-fc0\">细数那些值得单曲循环的民谣</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"鹿白川\" href=\"/user/home?id=493707309\" class=\"nm nm-icn f-thide s-fc3\">鹿白川</a> <sup class=\"u-icn u-icn-84 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/8oGC8szXNn7dUwtwv-YuGA==/109951163213190507.jpg?param=140y140\">\n" +
            "<a title=\"90后回忆杀-学生时代听过的那些歌\" href=\"/playlist?id=2080319176\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2080319176\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">19万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"90后回忆杀-学生时代听过的那些歌\" href=\"/playlist?id=2080319176\" class=\"tit f-thide s-fc0\">90后回忆杀-学生时代听过的那些歌</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"神是美丽的魔\" href=\"/user/home?id=249316823\" class=\"nm nm-icn f-thide s-fc3\">神是美丽的魔</a> </p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/BVCm1i567_mtHC4BEIeMSA==/109951163198795265.jpg?param=140y140\">\n" +
            "<a title=\"歌词唱透了心声，回忆模糊了眼眸\" href=\"/playlist?id=2139324915\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2139324915\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">1000万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"歌词唱透了心声，回忆模糊了眼眸\" href=\"/playlist?id=2139324915\" class=\"tit f-thide s-fc0\">歌词唱透了心声，回忆模糊了眼眸</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"朩朩青尘\" href=\"/user/home?id=7394345\" class=\"nm nm-icn f-thide s-fc3\">朩朩青尘</a> <sup class=\"u-icn u-icn-1 \"></sup>\n" +
            "</p>\n" +
            "</li>\n" +
            "<li>\n" +
            "<div class=\"u-cover u-cover-1\">\n" +
            "<img class=\"j-flag\" src=\"http://p1.music.126.net/5huMNo9jcnZRYr5GY2U04g==/18670806954019563.jpg?param=140y140\">\n" +
            "<a title=\"我最大的遗憾，就是你的遗憾与我有关。\" href=\"/playlist?id=2080204765\" class=\"msk\"></a>\n" +
            "<div class=\"bottom\">\n" +
            "<a class=\"icon-play f-fr\" title=\"播放\" href=\"javascript:;\" data-res-type=\"13\" data-res-id=\"2080204765\" data-res-action=\"play\"></a>\n" +
            "<span class=\"icon-headset\"></span>\n" +
            "<span class=\"nb\">27万</span>\n" +
            "</div>\n" +
            "</div>\n" +
            "<p class=\"dec\">\n" +
            "<a title=\"我最大的遗憾，就是你的遗憾与我有关。\" href=\"/playlist?id=2080204765\" class=\"tit f-thide s-fc0\">我最大的遗憾，就是你的遗憾与我有关。</a>\n" +
            "</p>\n" +
            "<p><span class=\"s-fc4\">by</span> <a title=\"是阿蒙吖\" href=\"/user/home?id=546526815\" class=\"nm nm-icn f-thide s-fc3\">是阿蒙吖</a> </p>\n" +
            "</li>\n" +
            "</ul>";

    public static HashMap<String, String> stringToHashMap(String s) {
        HashMap<String, String> hashMap = new HashMap<>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            hashMap.put("params", jsonObject.getString("params"));
            hashMap.put("encSecKey", jsonObject.getString("encSecKey"));
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            return hashMap;
        }
    }

    //解析html文件获取bean数据
    public static FindBean getFindData() {

        ArrayList<String> imageList = new ArrayList<>();
        ArrayList<String> titleList = new ArrayList<>();
        ArrayList<String> addressList = new ArrayList<>();

        Document document = Jsoup.parse(neteaseContent);
        Elements elements = document.select("ul");
        for (Element element : elements) {
            for (Element element1 : element.children()) {
                for (Element element2 : element1.children()) {
                    for (Element element3 : element2.children()) {
                        String image = element3.attr("src");
                        String title = element3.attr("title");
                        String address = element3.attr("href");

                        if (!image.isEmpty()) imageList.add(image);

                        if (!title.isEmpty() && imageList.size() > titleList.size())
                            titleList.add(title);

                        if (!address.isEmpty() && imageList.size() > addressList.size()) {
                            addressList.add(address);
                            break;
                        }
                    }
                }
            }
        }
        FindBean findBean = new FindBean();
        findBean.setTitleList(titleList);
        findBean.setImageList(imageList);
        findBean.setAddressList(addressList);
        return findBean;

    }

}
