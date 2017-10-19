package com.songjy.introduction.entity.douban;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午3:33.
 */

public class AvatarsBean {
    /**
     * small : https://img1.doubanio.com/img/celebrity/small/67.jpg
     * large : https://img1.doubanio.com/img/celebrity/large/67.jpg
     * medium : https://img1.doubanio.com/img/celebrity/medium/67.jpg
     */

    private String small;
    private String large;
    private String medium;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Override
    public String toString() {
        return "AvatarsBean{" +
                "small='" + small + '\'' +
                ", large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
