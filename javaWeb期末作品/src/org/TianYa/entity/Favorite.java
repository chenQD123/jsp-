package org.TianYa.entity;

public class Favorite {
    private int no;
    private String title;
    private String about;

    public Favorite() {
    }

    public Favorite(int no, String title, String about) {
        this.no = no;
        this.title = title;
        this.about = about;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
