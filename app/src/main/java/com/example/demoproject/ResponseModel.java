package com.example.demoproject;


class ResponseModel {
    private Integer userId;
    private Integer id;
    private String title;
    private String completed;
    public ResponseModel() {
    }
    public ResponseModel(Integer userId, Integer id, String title, String completed) {
        super();
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompleted() {
        return completed;
    }

    public void setCompleted(String completed) {
        this.completed = completed;
    }

}