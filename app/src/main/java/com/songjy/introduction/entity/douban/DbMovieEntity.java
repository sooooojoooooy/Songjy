package com.songjy.introduction.entity.douban;

import java.util.List;

/**
 * Created by songjiyuan
 * on 17/10/18 # 下午3:30.
 */

public class DbMovieEntity {
    /**
     * count : 1
     * start : 1
     * total : 250
     * subjects : [{"rating":{"max":10,"average":9.5,"stars":"50","min":0},"genres":["剧情","爱情","同性"],"title":"霸王别姬","casts":[{"alt":"https://movie.douban.com/celebrity/1003494/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/67.jpg","large":"https://img1.doubanio.com/img/celebrity/large/67.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/67.jpg"},"name":"张国荣","id":"1003494"},{"alt":"https://movie.douban.com/celebrity/1050265/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/46345.jpg","large":"https://img3.doubanio.com/img/celebrity/large/46345.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/46345.jpg"},"name":"张丰毅","id":"1050265"},{"alt":"https://movie.douban.com/celebrity/1035641/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1399268395.47.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1399268395.47.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1399268395.47.jpg"},"name":"巩俐","id":"1035641"}],"collect_count":813846,"original_title":"霸王别姬","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1023040/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/750.jpg","large":"https://img3.doubanio.com/img/celebrity/large/750.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/750.jpg"},"name":"陈凯歌","id":"1023040"}],"year":"1993","images":{"small":"https://img3.doubanio.com/view/movie_poster_cover/ipst/public/p1910813120.webp","large":"https://img3.doubanio.com/view/movie_poster_cover/lpst/public/p1910813120.webp","medium":"https://img3.doubanio.com/view/movie_poster_cover/spst/public/p1910813120.webp"},"alt":"https://movie.douban.com/subject/1291546/","id":"1291546"}]
     * title : 豆瓣电影Top250
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    @Override
    public String toString() {
        return "DbMovieEntity{" +
                "count=" + count +
                ", start=" + start +
                ", total=" + total +
                ", title='" + title + '\'' +
                ", subjects=" + subjects +
                '}';
    }
}
