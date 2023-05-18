package com.ncepu.bigdata.entity;
public class User {
    private int user_ID;
    private String username;
    private String password;
    private String email;
    private String nickname;


    public User(String nickname, String username, String password, String email) {
        this.nickname = nickname;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
        this.user_ID = 0;
        this.username = null;
        this.password = null;
        this.email = null;
    }

    public User(int user_ID, String username, String password, String email) {
        this.user_ID = user_ID;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getUser_ID() {
        return user_ID;
    }

    public void setUser_ID(int user_ID) {
        this.user_ID = user_ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
