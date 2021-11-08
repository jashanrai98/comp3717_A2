package ca.bcit.rai_xu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class health_authority extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_authority);
        String fraserCount = getIntent().getStringExtra("fraser");
        String interiorCount = getIntent().getStringExtra("interior");
        String northernCount = getIntent().getStringExtra("northern");
        String outsideCount = getIntent().getStringExtra("outside");;
        String coastalCount = getIntent().getStringExtra("coastal");;
        String islandCount = getIntent().getStringExtra("island");;
        TextView fraser = findViewById(R.id.fraserCount);
        TextView interior = findViewById(R.id.interiorCount);
        TextView northern = findViewById(R.id.northernCount);
        TextView outside = findViewById(R.id.outsideCount);
        TextView coastal = findViewById(R.id.coastalCount);
        TextView island = findViewById(R.id.islandCount);
        fraser.setText(String.valueOf(fraserCount));
        interior.setText(String.valueOf(interiorCount));
        northern.setText(String.valueOf(northernCount));
        outside.setText(String.valueOf(outsideCount));
        coastal.setText(String.valueOf(coastalCount));
        island.setText(String.valueOf(islandCount));
    }

}