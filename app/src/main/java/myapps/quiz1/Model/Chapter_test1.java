package myapps.quiz1.Model;

/**
 * Created by comsol on 31-May-18.
 */
public class Chapter_test1 {

    private int id;
    private String model;
    private int model_id;

    public Chapter_test1() {
    }

    public Chapter_test1(int id, int model_id, String model) {
        this.id = id;
        this.model_id = model_id;
        this.model = model;

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }



    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }





}
