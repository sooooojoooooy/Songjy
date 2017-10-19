package com.songjy.introduction.entity.douban;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午3:33.
 */

public class CastsBean {
    /**
     * alt : https://movie.douban.com/celebrity/1003494/
     * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/67.jpg","large":"https://img1.doubanio.com/img/celebrity/large/67.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/67.jpg"}
     * name : 张国荣
     * id : 1003494
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
        return "CastsBean{" +
                "alt='" + alt + '\'' +
                ", avatars=" + avatars +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
