package com.example.ordersystem;



public class Feedback {
    private int id;
    private String title2, email2, description2;
    private long started2, finished2;

    public Feedback(){

    }

    public Feedback(int id, String title2,  String email2 , String description2 , long started2, long finished2) {
        this.id = id;
        this.title2 = title2;
        this.email2 = email2;
        this.description2 = description2;
        this.started2 = started2;
        this.finished2 = finished2;
    }

    public Feedback(String title2, String email2 , String description2, long started2, long finished2) {
        this.title2 = title2;
        this.email2 = email2;
        this.description2 = description2;
        this.started2 = started2;
        this.finished2 = finished2;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getTitle2() {

        return title2;
    }

    public void setTitle2(String title2) {

        this.title2 = title2;
    }

    public String getEmail2() {

        return email2;
    }

    public void setEmail2(String email2) {

        this.email2 = email2;
    }

    public String getDescription2() {

        return description2;
    }

    public void setDescription2(String description2) {

        this.description2 = description2;
    }

    public long getStarted2() {

        return started2;
    }

    public void setStarted2(long started2) {

        this.started2 = started2;
    }

    public long getFinished2() {

        return finished2;
    }

    public void setFinished2(long finished2) {

        this.finished2 = finished2;
    }
}
