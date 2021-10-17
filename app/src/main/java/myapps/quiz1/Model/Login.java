package myapps.quiz1.Model;

/**
 * Created by comsol on 16-Jan-18.
 */
public class Login {
    private String username;


    private String phone;

    private String password;



    public Login(String username,String fullname,String password){

        this.username=username;
        this.phone=fullname;
        this.password=password;



    }

    public String getName()
    {
        return username;
    }
    public String getPhone()
    {
        return phone;
    }
    public String getPassword() {
        return password;
    }

}
