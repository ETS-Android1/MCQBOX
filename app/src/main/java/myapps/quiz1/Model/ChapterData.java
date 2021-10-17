package myapps.quiz1.Model;

/**
 * Created by comsol on 29-May-18.
 */
public class ChapterData {

    private int id, chap_id;
    private String course, chapter, chapter_name;


    public ChapterData() {
    }

    public ChapterData(int id, int chap_id, String course, String chapter, String chapter_name) {
        this.id = id;
        this.chap_id = chap_id;
        this.course = course;
        this.chapter = chapter;
        this.chapter_name = chapter_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChap_id() {
        return chap_id;
    }

    public void setChap_id(int chap_id) {
        this.chap_id = chap_id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }
}
