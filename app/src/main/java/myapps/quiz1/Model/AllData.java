package myapps.quiz1.Model;

/**
 * Created by comsol on 25-Jan-18.
 */
public class AllData {
    private String question;
    private String option1;
    private String option2;
    //private int id;
    private String option3;
    private String option4;
   // private int ans;
   private String ans;

    public AllData(String question, String option1, String option2, String option3,
                   String option4, String ans){

        this.question=question;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.ans=ans;

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


}
