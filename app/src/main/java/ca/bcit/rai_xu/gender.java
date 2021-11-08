package ca.bcit.rai_xu;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class gender extends AppCompatActivity {
    DatabaseReference databasePost;
    String femaleCount;
    String maleCount;
    String unknownCount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        databasePost = FirebaseDatabase.getInstance().getReference();
        maleCount = getIntent().getStringExtra("maleCount");
        femaleCount = getIntent().getStringExtra("femaleCount");
        unknownCount = getIntent().getStringExtra("unknownCount");
        TextView tvSexM = findViewById(R.id.maleCountValue);
        TextView tvSexF = findViewById(R.id.femaleCountValue);
        TextView tvSexU = findViewById(R.id.unknownCountValue);
        tvSexM.setText(String.valueOf(maleCount));
        tvSexF.setText(String.valueOf(femaleCount));
        tvSexU.setText(String.valueOf(unknownCount));
    }

}
