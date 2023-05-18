package com.ncepu.bigdata.entity;

public class UserTag {
    private int userTagId;
    private int userId;
    private int tagId;

    public UserTag() {
        this.userTagId = 0;
        this.userId = 0;
        this.tagId = 0;
    }

    public UserTag(int userTagId, int userId, int tagId) {
        this.userTagId = userTagId;
        this.userId = userId;
        this.tagId = tagId;
    }

    public int getUserTagId() {
        return userTagId;
    }

    public void setUserTagId(int userTagId) {
        this.userTagId = userTagId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    @Override
    public String toString() {
        return "UserTag{" +
                "userTagId=" + userTagId +
                ", userId=" + userId +
                ", tagId=" + tagId +
                '}';
    }
}
