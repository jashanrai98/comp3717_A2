package ca.bcit.rai_a2;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.core.Repo;

import java.io.Serializable;

public class Post implements Serializable, Parcelable {
    String Age_Group;
    String Classification_Reported;
    String HA;
    String Reported_Date;

    protected Post(Parcel in) {
        Age_Group = in.readString();
        Classification_Reported = in.readString();
        HA = in.readString();
        Reported_Date = in.readString();
        Sex = in.readString();
    }

    public static final Creator<Post> CREATOR = new Creator<Post>() {
        @Override
        public Post createFromParcel(Parcel in) {
            return new Post(in);
        }

        @Override
        public Post[] newArray(int size) {
            return new Post[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(Age_Group);
        parcel.writeString(Classification_Reported);
        parcel.writeString(HA);
        parcel.writeString(Reported_Date);
        parcel.writeString(Sex);
    }
}