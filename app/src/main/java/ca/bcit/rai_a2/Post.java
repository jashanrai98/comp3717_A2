package ca.bcit.rai_a2;

public class Post {
    public String ageGroup;
    public String classificationReported;
    public String healthAuthority;
    public String reportedDate;
    public String sex;

    public Post(String ageGroup, String classificationReported,String healthAuthority, String reportedDate,
                String sex ) {
        this.ageGroup = ageGroup;
        this.classificationReported = classificationReported;
        this.healthAuthority = healthAuthority;
        this.reportedDate = reportedDate;
        this.sex = sex;

    }
}