package ca.bcit.rai_a2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class age_group extends AppCompatActivity {

    DatabaseReference databasePost;
    RelativeLayout lvPosts;
    List<Post> postList = new ArrayList<>();
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



    TextView tvAgeGroup1;
    TextView tvAgeGroup2;
    TextView tvAgeGroup3;
    TextView tvAgeGroup4;
    TextView tvAgeGroup5;
    TextView tvAgeGroup6;
    TextView tvAgeGroup7;
    TextView tvAgeGroup8;
    TextView tvAgeGroup9;
    TextView tvAgeGroup10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_group);
        databasePost = FirebaseDatabase.getInstance().getReference();
        int ageCount1 = 0;
        int ageCount2 = 0;
        int ageCount3 = 0;
        int ageCount4 = 0;
        int ageCount5 = 0;
        int ageCount6 = 0;
        int ageCount7 = 0;
        int ageCount8 = 0;
        int ageCount9 = 0;
        int ageCount10 = 0;
        tvAgeGroup1 = findViewById(R.id.lessThan10Value);
        tvAgeGroup2 = findViewById(R.id.TenTo19Value);
        tvAgeGroup3 = findViewById(R.id.TwentyTo29Value);
        tvAgeGroup4 = findViewById(R.id.ThirtyTo39Value);
        tvAgeGroup5 = findViewById(R.id.FortyTo49Value);
        tvAgeGroup6 = findViewById(R.id.FiftyTo59Value);
        tvAgeGroup7 = findViewById(R.id.SixtyTo69Value);
        tvAgeGroup8 = findViewById(R.id.SeventyTo79Value);
        tvAgeGroup9 = findViewById(R.id.EightyTo89Value);
        tvAgeGroup10 = findViewById(R.id.NinetyPlusValue);
    }

    @Override
    protected void onStart() {
        super.onStart();

        lvPosts = (RelativeLayout) findViewById(R.id.lvPosts);
        Query myquery = databasePost;
        myquery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    postList.add(post);
                }
                //PostListAdapter adapter = new PostListAdapter(gender.this, postList);
                //lvPosts.setAdapter(adapter);
                updateAgeGroupCount(postList);
                tvAgeGroup1.setText(String.valueOf(ageCount1));
                tvAgeGroup2.setText(String.valueOf(ageCount2));
                tvAgeGroup3.setText(String.valueOf(ageCount3));
                tvAgeGroup4.setText(String.valueOf(ageCount4));
                tvAgeGroup1.setText(String.valueOf(ageCount5));
                tvAgeGroup2.setText(String.valueOf(ageCount6));
                tvAgeGroup3.setText(String.valueOf(ageCount7));
                tvAgeGroup4.setText(String.valueOf(ageCount8));
                tvAgeGroup1.setText(String.valueOf(ageCount9));
                tvAgeGroup2.setText(String.valueOf(ageCount10));
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }

    public void updateAgeGroupCount(List<Post> p){
        for (int i = 0; i < p.size(); i++){
            if (p.get(i).getAge_Group().equals("<10")){
                ageCount1++;
            } else if (p.get(i).getSex().equals("10-19")){
                ageCount2++;
            } else if (p.get(i).getSex().equals("20-29")){
                ageCount3++;
            } else if (p.get(i).getSex().equals("30-39")){
                ageCount4++;
            } else if (p.get(i).getSex().equals("40-49")){
                ageCount5++;
            } else if (p.get(i).getSex().equals("50-59")){
                ageCount6++;
            } else if (p.get(i).getSex().equals("60-69")){
                ageCount7++;
            } else if (p.get(i).getSex().equals("70-79")){
                ageCount8++;
            } else if (p.get(i).getSex().equals("80-89")){
                ageCount9++;
            } else {
                ageCount10++;
            }
        }
    }
}