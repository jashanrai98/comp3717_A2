package ca.bcit.rai_a2;

import androidx.appcompat.app.AppCompatActivity;
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

import android.os.Bundle;

public class health_authority extends AppCompatActivity {
    ProgressBar progressBar;
    DatabaseReference databasePost;
    RelativeLayout lvPosts;
    List<Post> postList = new ArrayList<>();;
    int fraserCount;
    int interiorCount;
    int northernCount;
    int outsideCount;
    int coastalCount;
    int islandCount;
    TextView fraser;
    TextView interior;
    TextView northern;
    TextView outside;
    TextView coastal;
    TextView island;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_authority);
        databasePost = FirebaseDatabase.getInstance().getReference();
        fraserCount = 0;
        interiorCount = 0;
        northernCount = 0;
        outsideCount = 0;
        coastalCount = 0;
        islandCount = 0;
        fraser = findViewById(R.id.fraserCount);
        interior = findViewById(R.id.interiorCount);
        northern = findViewById(R.id.northernCount);
        outside = findViewById(R.id.outsideCount);
        coastal = findViewById(R.id.coastalCount);
        island = findViewById(R.id.islandCount);

    }

    @Override
    protected void onStart() {
        super.onStart();
        progressBar = findViewById(R.id.progressBar4);
        progressBar.setVisibility(View.VISIBLE);
        RelativeLayout insideContainer = findViewById(R.id.insideContainer);
        insideContainer.setVisibility(View.GONE);
        lvPosts = (RelativeLayout) findViewById(R.id.lvPosts);
        databasePost.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    postList.add(post);

                }
                //PostListAdapter adapter = new PostListAdapter(gender.this, postList);
                //lvPosts.setAdapter(adapter);
                updateHACount(postList);
                fraser.setText(String.valueOf(fraserCount));
                interior.setText(String.valueOf(interiorCount));
                northern.setText(String.valueOf(northernCount));
                outside.setText(String.valueOf(outsideCount));
                coastal.setText(String.valueOf(coastalCount));
                island.setText(String.valueOf(islandCount));

                progressBar.setVisibility(View.GONE);
                insideContainer.setVisibility(View.VISIBLE);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

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

}