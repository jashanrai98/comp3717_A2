package ca.bcit.rai_xu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    TextView tvLogout;
    DatabaseReference databasePost;
    List<Post> postList = new ArrayList<>();
    int femaleCount;
    int maleCount;
    int unknownCount;
    int fraserCount;
    int interiorCount;
    int northernCount;
    int outsideCount;
    int coastalCount;
    int islandCount;
    int ageCount1;
    int ageCount2;
    int ageCount3;
    int ageCount4;
    int ageCount5;
    int ageCount6;
    int ageCount7;
    int ageCount8;
    int ageCount9;
    int ageCount10;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLogout = findViewById(R.id.tvLogout);

        databasePost = FirebaseDatabase.getInstance().getReference();

        //Gender activity variable initiation
        femaleCount = 0;
        maleCount = 0;
        unknownCount = 0;

        //HA activity variable initiation
        fraserCount = 0;
        interiorCount = 0;
        northernCount = 0;
        outsideCount = 0;
        coastalCount = 0;
        islandCount = 0;

        //Age group variable initiation
        ageCount1 = 0;
        ageCount2 = 0;
        ageCount3 = 0;
        ageCount4 = 0;
        ageCount5 = 0;
        ageCount6 = 0;
        ageCount7 = 0;
        ageCount8 = 0;
        ageCount9 = 0;
        ageCount10 = 0;

        // Hide all buttons until data loads.
        ProgressBar progressBar = findViewById(R.id.progressBar5);
        progressBar.setVisibility(View.VISIBLE);
        TextView name1 = findViewById(R.id.jashanInfo);
        name1.setVisibility(View.GONE);

        TextView name2 = findViewById(R.id.lillianInfo);
        name2.setVisibility(View.GONE);

        Button monthYearButton = findViewById(R.id.monthYear);
        monthYearButton.setVisibility(View.GONE);

        Button haButton = findViewById(R.id.ha);
        haButton.setVisibility(View.GONE);

        Button genderButton = findViewById(R.id.gender);
        genderButton.setVisibility(View.GONE);

        Button ageGroupButton = findViewById(R.id.ageGroup);
        ageGroupButton.setVisibility(View.GONE);

        TextView waitMessage = findViewById(R.id.waitMessage);
        waitMessage.setVisibility(View.VISIBLE);

        tvLogout.setVisibility(View.GONE);


        databasePost.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                postList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    postList.add(post);
                }
                updateGenderCount(postList);
                updateHACount(postList);
                updateAgeGroupCount(postList);
                progressBar.setVisibility(View.GONE);
                waitMessage.setVisibility(View.GONE);
                name1.setVisibility(View.VISIBLE);
                name2.setVisibility(View.VISIBLE);
                monthYearButton.setVisibility(View.VISIBLE);
                haButton.setVisibility(View.VISIBLE);
                genderButton.setVisibility(View.VISIBLE);
                ageGroupButton.setVisibility(View.VISIBLE);
                tvLogout.setVisibility(View.VISIBLE);


            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut(); // logout
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
            }
        });
    }

    public void startMonthYear(View view) {
        Intent intent = new Intent(this, month_Year.class);
        intent.putExtra("maleCount", maleCount);
        startActivity(intent);
    }
    public void startGender(View view) {
        Intent intent = new Intent(this, gender.class);
        intent.putExtra("maleCount", Integer.toString(maleCount));
        intent.putExtra("femaleCount", Integer.toString(femaleCount));
        intent.putExtra("unknownCount", Integer.toString(unknownCount));
        startActivity(intent);
    }
    public void startAgeGroup(View view) {
        Intent intent = new Intent(this, age_group.class);
        intent.putExtra("ageCount1", Integer.toString(ageCount1));
        intent.putExtra("ageCount2", Integer.toString(ageCount2));
        intent.putExtra("ageCount3", Integer.toString(ageCount3));
        intent.putExtra("ageCount4", Integer.toString(ageCount4));
        intent.putExtra("ageCount5", Integer.toString(ageCount5));
        intent.putExtra("ageCount6", Integer.toString(ageCount6));
        intent.putExtra("ageCount7", Integer.toString(ageCount7));
        intent.putExtra("ageCount8", Integer.toString(ageCount8));
        intent.putExtra("ageCount9", Integer.toString(ageCount9));
        intent.putExtra("ageCount10", Integer.toString(ageCount10));
        startActivity(intent);
    }
    public void startHA(View view) {
        Intent intent = new Intent(this, health_authority.class);
        intent.putExtra("fraser", Integer.toString(fraserCount));
        intent.putExtra("interior", Integer.toString(interiorCount));
        intent.putExtra("outside", Integer.toString(outsideCount));
        intent.putExtra("coastal", Integer.toString(coastalCount));
        intent.putExtra("island", Integer.toString(islandCount));
        intent.putExtra("northern", Integer.toString(northernCount));
        startActivity(intent);
    }

    //gets the gender count for the gender activity.
    public void updateGenderCount(List<Post> p){
        for (int i = 0; i < p.size(); i++){
            if (p.get(i).getSex().equals("M")){
                maleCount++;
            } else if (p.get(i).getSex().equals("F")){
                femaleCount++;
            } else {
                unknownCount++;
            }
        }
    }

    //gets the health authority count for the HA activity.
    public void updateHACount(List<Post> p){
        for (int i = 0; i < p.size(); i++){
            if (p.get(i).getHA().equals("Fraser")){
                fraserCount++;
            } else if (p.get(i).getHA().equals("Interior")){
                interiorCount++;
            } else if (p.get(i).getHA().equals("Out of Canada")){
                outsideCount++;
            } else if (p.get(i).getHA().equals("Vancouver Coastal")){
                coastalCount++;
            } else if (p.get(i).getHA().equals("Vancouver Island")){
                islandCount++;
            } else {
                northernCount++;
            }
        }

    }

    //gets the age group count for the age group activity.
    public void updateAgeGroupCount(List<Post> p){
        for (int i = 0; i < p.size(); i++){
            if (p.get(i).getAge_Group().equals("<10")){
                ageCount1++;
            } else if (p.get(i).getAge_Group().equals("10-19")){
                ageCount2++;
            } else if (p.get(i).getAge_Group().equals("20-29")){
                ageCount3++;
            } else if (p.get(i).getAge_Group().equals("30-39")){
                ageCount4++;
            } else if (p.get(i).getAge_Group().equals("40-49")){
                ageCount5++;
            } else if (p.get(i).getAge_Group().equals("50-59")){
                ageCount6++;
            } else if (p.get(i).getAge_Group().equals("60-69")){
                ageCount7++;
            } else if (p.get(i).getAge_Group().equals("70-79")){
                ageCount8++;
            } else if (p.get(i).getAge_Group().equals("80-89")){
                ageCount9++;
            } else {
                ageCount10++;
            }
        }
    }
}