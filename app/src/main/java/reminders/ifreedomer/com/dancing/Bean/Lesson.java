package reminders.ifreedomer.com.dancing.bean;

import java.io.Serializable;

/**
 * Created by eavawu on 1/30/16.
 */
public class Lesson implements Serializable {
    private int id;
    private int userid;
    private String name;
    private String time;
    private String deploytime;
    private int likers;
    private String photo;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDeploytime() {
        return deploytime;
    }

    public void setDeploytime(String deploytime) {
        this.deploytime = deploytime;
    }

    public int getLikers() {
        return likers;
    }

    public void setLikers(int likers) {
        this.likers = likers;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getVedio() {
        return vedio;
    }

    public void setVedio(String vedio) {
        this.vedio = vedio;
    }

    public Lesson(int id, int userid, String name, String time, String deploytime, int likers, String photo, String vedio) {
        this.id = id;
        this.userid = userid;
        this.name = name;

        this.time = time;
        this.deploytime = deploytime;
        this.likers = likers;
        this.photo = photo;
        this.vedio = vedio;
    }

    private String vedio;
}
