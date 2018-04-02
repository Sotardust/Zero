package com.dai.zero.http.netease;

public class NetEaseApi {
    private final static String BaseURL = "http://music.163.com/";

    /**
     * 获取用户歌单
     *
     * @param uid
     * @return
     */
    public static FillParam getPlaylistOfUser(String uid) {
        FillParam fp = new FillParam();
//        fp.setUrl(BaseURL + "weapi/user/playlist?csrf_token=");
        fp.addParam("offset", 0);
        fp.addParam("uid", uid);
        fp.addParam("limit", 20);
        fp.addParam("csrf_token", "nothing");
        return fp;
    }

    /**
     * 获取歌单详情
     *
     * @param playlist_id
     * @return
     */
    public static FillParam getDetailOfPlaylist(String playlist_id) {
        FillParam fp = new FillParam();
        //fp.setUrl(BaseURL + "weapi/v3/playlist/detail?csrf_token=");
        fp.addParam("id", playlist_id);
        fp.addParam("offset", 0);
        fp.addParam("total", "True");
        fp.addParam("limit", 100);
        fp.addParam("n", 1000);
        fp.addParam("csrf_token", "nothing");
        return fp;
    }

    /**
     * 搜索歌曲
     *
     * @param s;
     * @return
     */
    public static FillParam SearchMusicList(String s, String type) {
        FillParam fp = new FillParam();
        fp.addParam("s", s);
        fp.addParam("type", type);
        fp.addParam("offset", 0);
        fp.addParam("total", "True");
        fp.addParam("limit", 20);
        fp.addParam("n", 1000);
        fp.addParam("csrf_token", "nothing");
        return fp;
    }

    //搜索音乐
    //http://music.163.com/weapi/search/suggest/multimatch?csrf_token=
    public static FillParam SearchMusic(String s) {
        FillParam fp = new FillParam();
        fp.addParam("s", s);
        fp.addParam("limit", 20);
        fp.addParam("csrf_token", "");
        return fp;
    }

    //http://music.163.com/weapi/search/suggest/web?csrf_token=
    public static FillParam SearchGeShou(String s) {
        FillParam fp = new FillParam();
        fp.addParam("s", s);
        fp.addParam("offset", "0");
        fp.addParam("csrf_token", "");
        fp.addParam("total", "true");
        fp.addParam("type", "100");
        fp.addParam("limit", "90");
        return fp;
    }
    //todo:analyse more api

}
