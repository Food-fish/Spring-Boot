package com.mybatis.many.entity;

public class User{
    private String id;//主键
    private String uuid;//UUID
    private String uid_a;
    private String uid_b;
    private String uid_c;
    private String passWord;//密码
    private String nickName;//昵称
    private String email;//邮箱
    private String img;//图片(头像)
    private String status;//状态
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUid_a() {
        return uid_a;
    }

    public void setUid_a(String uid_a) {
        this.uid_a = uid_a;
    }

    public String getUid_b() {
        return uid_b;
    }

    public void setUid_b(String uid_b) {
        this.uid_b = uid_b;
    }

    public String getUid_c() {
        return uid_c;
    }

    public void setUid_c(String uid_c) {
        this.uid_c = uid_c;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getStatus() {
        return status;
    }

    public User(String uuid, String uid_a, String uid_b, String uid_c, String passWord, String nickName, String email, String img, String status) {
        this.uuid = uuid;
        this.uid_a = uid_a;
        this.uid_b = uid_b;
        this.uid_c = uid_c;
        this.passWord = passWord;
        this.nickName = nickName;
        this.email = email;
        this.img = img;
        this.status = status;
    }

    public User(){}

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", uuid='" + uuid + '\'' +
                ", uid_a='" + uid_a + '\'' +
                ", uid_b='" + uid_b + '\'' +
                ", uid_c='" + uid_c + '\'' +
                ", passWord='" + passWord + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", img='" + img + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
