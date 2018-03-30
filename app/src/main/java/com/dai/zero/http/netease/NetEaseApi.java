package com.dai.zero.http.netease;

public class NetEaseApi {
    private final static String BaseURL = "http://music.163.com/";

    /**
     * 获取用户歌单
     *
     * @param uid
     * @return
     */
    public static AddParam getPlaylistOfUser(String uid) {
        AddParam upp = new AddParam();
        upp.setUrl(BaseURL + "weapi/user/playlist?csrf_token=");
        upp.addPara("offset", 0);
        upp.addPara("uid", uid);
        upp.addPara("limit", 20);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

    /**
     * 获取歌单详情
     *
     * @param playlist_id
     * @return
     */
    public static AddParam getDetailOfPlaylist(String playlist_id) {
        AddParam upp = new AddParam();
        //upp.setUrl(BaseURL + "weapi/v3/playlist/detail?csrf_token=");
        upp.addPara("id", playlist_id);
        upp.addPara("offset", 0);
        upp.addPara("total", "True");
        upp.addPara("limit", 100);
        upp.addPara("n", 1000);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

    /**
     * 搜索歌曲
     *
     * @param s;
     * @return
     */
    public static AddParam SearchMusicList(String s, String type) {
        AddParam upp = new AddParam();
        upp.addPara("s", s);
        upp.addPara("type", type);
        upp.addPara("offset", 0);
        upp.addPara("total", "True");
        upp.addPara("limit", 20);
        upp.addPara("n", 1000);
        upp.addPara("csrf_token", "nothing");
        return upp;
    }

    //搜索音乐
    public static AddParam SearchMusic(String s) {
        AddParam upp = new AddParam();
        upp.addPara("s", s);
        upp.addPara("limit", 20);
        upp.addPara("csrf_token", "");
        return upp;
    }

    public static AddParam SearchGeShou(String s) {
        AddParam upp = new AddParam();
        upp.addPara("s", s);
        upp.addPara("offset", "0");
        upp.addPara("csrf_token", "");
        upp.addPara("total", "true");
        upp.addPara("type", "100");
        upp.addPara("limit", "90");
        return upp;
    }
    //todo:analyse more api

}
