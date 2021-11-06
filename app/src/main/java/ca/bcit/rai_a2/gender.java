package ca.bcit.rai_a2;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
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

public class gender extends AppCompatActivity {
    ProgressBar progressBar;
    DatabaseReference databasePost;
    RelativeLayout lvPosts;
    List<Post> postList = new ArrayList<>();;
    int femaleCount;
    int maleCount;
    int unknownCount;
    TextView tvSexM;
    TextView tvSexF;
    TextView tvSexU;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        databasePost = FirebaseDatabase.getInstance().getReference();
        femaleCount = 0;
        maleCount = 0;
        unknownCount = 0;
        tvSexM = findViewById(R.id.maleCountValue);
        tvSexF = findViewById(R.id.femaleCountValue);
        tvSexU = findViewById(R.id.unknownCountValue);

    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar = findViewById(R.id.progressBar3);
        progressBar.setVisibility(View.VISIBLE);

        lvPosts = (RelativeLayout) findViewById(R.id.lvPosts);
        Query myquery = databasePost.limitToFirst(150);
        Query male = databasePost;
        databasePost.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Log.v("Async101", "Done loading bookmarks");
                postList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    postList.add(post);
                    Log.v("Async102", post.getSex().toString());

                }
                //PostListAdapter adapter = new PostListAdapter(gender.this, postList);
                //lvPosts.setAdapter(adapter);
                updateGenderCount(postList);
                tvSexM.setText(String.valueOf(maleCount));
                tvSexF.setText(String.valueOf(femaleCount));
                tvSexU.setText(String.valueOf(unknownCount));
                progressBar.setVisibility(View.GONE);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

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

}
