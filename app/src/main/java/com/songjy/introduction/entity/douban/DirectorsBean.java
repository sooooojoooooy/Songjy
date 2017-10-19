package com.songjy.introduction.entity.douban;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午3:34.
 */

public class DirectorsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1023040/
     * avatars : {"small":"https://img3.doubanio.com/img/celebrity/small/750.jpg","large":"https://img3.doubanio.com/img/celebrity/large/750.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/750.jpg"}
     * name : 陈凯歌
     * id : 1023040
     */

    private String alt;
    private AvatarsBean avatars;
    private String name;
    private String id;

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public AvatarsBean getAvatars() {
        return avatars;
    }

    public void setAvatars(AvatarsBean avatars) {
        this.avatars = avatars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "DirectorsBean{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
