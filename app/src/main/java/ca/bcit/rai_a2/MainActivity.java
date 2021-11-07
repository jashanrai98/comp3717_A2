package ca.bcit.rai_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {

    TextView tvLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvLogout = findViewById(R.id.tvLogout);
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
        startActivity(intent);
    }
    public void startGender(View view) {
        Intent intent = new Intent(this, gender.class);
        startActivity(intent);
    }
    public void startAgeGroup(View view) {
        Intent intent = new Intent(this, age_group.class);
        startActivity(intent);
    }
    public void startHA(View view) {
        Intent intent = new Intent(this, health_authority.class);
        startActivity(intent);
    }
}