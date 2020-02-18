package com.rujira.retrofitfetchdataservicealbums.Model;

public class Album {
//    {
//        "userId":1,
//            "id":2,
//            "title":"sunt qui excepturi placeat culpa"
//    }

    private int userId;
    private int id;
    private String title;

    public Album() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
