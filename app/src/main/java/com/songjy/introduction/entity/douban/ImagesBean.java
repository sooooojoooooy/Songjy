package com.songjy.introduction.entity.douban;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午3:32.
 */

public class ImagesBean {
    /**
     * small : https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p1910813120.webp
     * large : https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1910813120.webp
     * medium : https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1910813120.webp
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
        return "ImagesBean{" +
                "small='" + small + '\'' +
                ", large='" + large + '\'' +
                ", medium='" + medium + '\'' +
                '}';
    }
}
