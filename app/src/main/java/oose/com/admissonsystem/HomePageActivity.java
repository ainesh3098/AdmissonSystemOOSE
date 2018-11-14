package oose.com.admissonsystem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {


    CardView result, preferences, feePayment, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


        result = findViewById(R.id.resultCardView);
        preferences = findViewById(R.id.preferencesCardView);
        feePayment = findViewById(R.id.feePaymentCard);
        logout = findViewById(R.id.logoutCard);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this , ResultActivty.class));
                finish();
            }
        });

        preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this , PreferencesActivity.class));
                finish();
            }
        });

        feePayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //startActivity(new Intent(HomePageActivity.this , .class));
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
