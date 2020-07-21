package org.TianYa.entity;

public class User {
    private String name;
    private String pwd;
    private String sex;
    private String mailBox;

    public User() {
    }

    public User(String name, String pwd, String sex, String mailBox) {
        this.name = name;
        this.pwd = pwd;
        this.sex = sex;
        this.mailBox = mailBox;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSex() {
        return sex;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }
}
