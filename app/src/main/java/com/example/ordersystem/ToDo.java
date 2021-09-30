package com.example.ordersystem;

public class ToDo {
    private int id;
    private String title, prices, description, sizes, extra;
    private long started, finished;

    public ToDo(){

    }

    public ToDo(int id, String title, String prices, String description, String sizes, String extra, long started, long finished) {
        this.id = id;
        this.title = title;
        this.prices = prices;
        this.description = description;
        this.sizes = sizes;
        this.extra = extra;
        this.started = started;
        this.finished = finished;
    }

    public ToDo(String title, String prices, String description, String sizes, String extra, long started, long finished) {
        this.title = title;
        this.prices = prices;
        this.description = description;
        this.sizes = sizes;
        this.extra = extra;
        this.started = started;
        this.finished = finished;
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

    public String getPrices() {

        return prices;
    }

    public void setPrices(String prices) {

        this.prices = prices;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getSizes() {

        return sizes;
    }

    public void setSizes(String sizes) {

        this.sizes = sizes;
    }

    public String getExtra() {

        return extra;
    }

    public void setExtra(String extra) {

        this.extra = extra;
    }

    public long getStarted() {

        return started;
    }

    public void setStarted(long started) {

        this.started = started;
    }

    public long getFinished() {

        return finished;
    }

    public void setFinished(long finished) {

        this.finished = finished;
    }
}
