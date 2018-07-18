package teamkunle.co.uk.schoolapiandroid.api.model;

import com.google.gson.annotations.SerializedName;

public class StudentModel {

    @SerializedName("_id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("surname")
    private String surname;

    @SerializedName("age")
    private Integer age;

    @SerializedName("__v")
    private Integer versionKey;


    public StudentModel(String id, String name, String surname, Integer age, Integer versionKey) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.versionKey = versionKey;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getVersionKey() {
        return versionKey;
    }

}
