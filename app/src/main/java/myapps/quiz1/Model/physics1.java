package myapps.quiz1.Model;

/**
 * Created by comsol on 24-Jan-18.
 */
public class physics1 {
    private String question;
    private String option1;
    private String option2;

    private int ans;
    private int id;
    private String option3;
    private String option4;

    public physics1(String question,String option1,String option2, String option3,
                String option4){

        this.question=question;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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


    public int getAns() {
        return ans;
    }

    public void setAns(int ans) {
        this.ans = ans;
    }

}
