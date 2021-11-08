package ca.bcit.rai_xu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class month_Year extends AppCompatActivity {
    LinearLayout lvPosts;
    ProgressBar progressBar;
    DatabaseReference databasePost;
    private EditText editYear;
    private EditText editMonth;
    Button search;
    private RecyclerView personsList;
    List<Post> postList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_month_year);
        progressBar = findViewById(R.id.progressBar);
        databasePost = FirebaseDatabase.getInstance().getReference();
        personsList = findViewById(R.id.showList);
        personsList.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        editYear = findViewById(R.id.search_year);
        editMonth = findViewById(R.id.search_month);
        search = findViewById(R.id.btnSearch);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);
                lvPosts = (LinearLayout) findViewById(R.id.lvPosts);
                editYear.getText().toString();
                editMonth.getText().toString();
                updateMonthYearCount(postList);
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        databasePost.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                postList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Post post = postSnapshot.getValue(Post.class);
                    postList.add(post);
                }
                updateMonthYearCount(postList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });
    }
    public void updateMonthYearCount(@NonNull List<Post> p) {
        ArrayList<Post> persons = new ArrayList<>();
        String input = editYear.getText().toString() + "-" + editMonth.getText().toString();
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getReported_Date().startsWith(input)) {
                persons.add(p.get(i));
            }
        }
        progressBar.setVisibility(View.GONE);
        personsList.setAdapter(new PersonsAdapter(persons));
    }


}