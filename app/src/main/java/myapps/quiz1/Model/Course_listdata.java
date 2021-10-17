package myapps.quiz1.Model;

/**
 * Created by comsol on 28-May-18.
 */
public class Course_listdata {
    private int id;
    private String course;

    public Course_listdata() {
    }

    public Course_listdata(int id, String course) {
        this.id = id;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getcourse() {
        return course;
    }

}
