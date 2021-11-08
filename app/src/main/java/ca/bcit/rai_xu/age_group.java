package ca.bcit.rai_xu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class age_group extends AppCompatActivity {

    String ageCount1;
    String ageCount2;
    String ageCount3;
    String ageCount4;
    String ageCount5;
    String ageCount6;
    String ageCount7;
    String ageCount8;
    String ageCount9;
    String ageCount10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_group);
        TextView tvAgeGroup1 = findViewById(R.id.lessThan10Value);
        TextView tvAgeGroup2 = findViewById(R.id.TenTo19Value);
        TextView tvAgeGroup3 = findViewById(R.id.TwentyTo29Value);
        TextView tvAgeGroup4 = findViewById(R.id.ThirtyTo39Value);
        TextView tvAgeGroup5 = findViewById(R.id.FortyTo49Value);
        TextView tvAgeGroup6 = findViewById(R.id.FiftyTo59Value);
        TextView tvAgeGroup7 = findViewById(R.id.SixtyTo69Value);
        TextView tvAgeGroup8 = findViewById(R.id.SeventyTo79Value);
        TextView tvAgeGroup9 = findViewById(R.id.EightyTo89Value);
        TextView tvAgeGroup10 = findViewById(R.id.NinetyPlusValue);

        ageCount1 = getIntent().getStringExtra("ageCount1");
        ageCount2 = getIntent().getStringExtra("ageCount2");
        ageCount3 = getIntent().getStringExtra("ageCount3");
        ageCount4 = getIntent().getStringExtra("ageCount4");
        ageCount5 = getIntent().getStringExtra("ageCount5");
        ageCount6 = getIntent().getStringExtra("ageCount6");
        ageCount7 = getIntent().getStringExtra("ageCount7");
        ageCount8 = getIntent().getStringExtra("ageCount8");
        ageCount9 = getIntent().getStringExtra("ageCount9");
        ageCount10 = getIntent().getStringExtra("ageCount10");

        tvAgeGroup1.setText(String.valueOf(ageCount1));
        tvAgeGroup2.setText(String.valueOf(ageCount2));
        tvAgeGroup3.setText(String.valueOf(ageCount3));
        tvAgeGroup4.setText(String.valueOf(ageCount4));
        tvAgeGroup5.setText(String.valueOf(ageCount5));
        tvAgeGroup6.setText(String.valueOf(ageCount6));
        tvAgeGroup7.setText(String.valueOf(ageCount7));
        tvAgeGroup8.setText(String.valueOf(ageCount8));
        tvAgeGroup9.setText(String.valueOf(ageCount9));
        tvAgeGroup10.setText(String.valueOf(ageCount10));
    }

}