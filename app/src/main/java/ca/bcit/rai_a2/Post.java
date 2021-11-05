package ca.bcit.rai_a2;

public class Post {
    String Age_Group;
    String Classification_Reported;
    String HA;
    String Reported_Date;

    public String getAge_Group() {
        return Age_Group;
    }

    public void setAge_Group(String age_Group) {
        Age_Group = age_Group;
    }

    public String getClassification_Reported() {
        return Classification_Reported;
    }

    public void setClassification_Reported(String classification_Reported) {
        Classification_Reported = classification_Reported;
    }

    public String getHA() {
        return HA;
    }

    public void setHA(String HA) {
        this.HA = HA;
    }

    public String getReported_Date() {
        return Reported_Date;
    }

    public void setReported_Date(String Reported_Date) {
        this.Reported_Date = Reported_Date;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    String Sex;


    public Post() {}

    public Post(String Age_Group, String Classification_Reported,
                   String HA, String Reported_Date, String Sex) {
        this.Age_Group = Age_Group;
        this.Classification_Reported = Classification_Reported;
        this.HA = HA;
        this.Reported_Date = Reported_Date;
        this.Sex = Sex;
    }

}