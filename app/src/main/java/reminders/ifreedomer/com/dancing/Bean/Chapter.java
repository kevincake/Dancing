package reminders.ifreedomer.com.dancing.bean;

/**
 * Created by eavawu on 2/21/16.
 */
public class Chapter {
    private int id;
    private String name;
    private String time;
    private String video;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getLessonid() {
        return lessonid;
    }

    public void setLessonid(int lessonid) {
        this.lessonid = lessonid;
    }

    public int getChapterorder() {
        return chapterorder;
    }

    public void setChapterorder(int chapterorder) {
        this.chapterorder = chapterorder;
    }

    private int lessonid;
    private int chapterorder;
}
