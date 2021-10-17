package myapps.quiz1.Model;

/**
 * Created by comsol on 30-May-18.
 */
public class Chapter_question {
    private String question;
    private String option1;
    private String option2;
     private int id;
    private int check_question;
    private String option3;
    private String option4;
    private String course;
    private String ans;

    public Chapter_question(String course,String question, String option1, String option2, String option3,
                   String option4, String ans,int check_question,int id){
        this.id=id;
        this.course=course;
        this.question=question;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.ans=ans;
        this.check_question=check_question;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCheck_question() {
        return check_question;
    }

    public void setCheck_question(int check_question) {
        this.check_question = check_question;
    }
    public String getquestion() {
        return question;
    }

    public String getoption1() {
        return option1;
    }

    public String getoption2() {
        return option2;
    }

    public String getoption3() {
        return option3;
    }

    public String getoption4()
    {
        return option4;
    }

    public String getAns()
    {
        return ans;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}


