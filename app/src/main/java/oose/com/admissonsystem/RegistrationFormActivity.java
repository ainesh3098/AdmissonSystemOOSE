package oose.com.admissonsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class RegistrationFormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_form);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(RegistrationFormActivity.this , HomePageActivity.class));
        finish();
    }
}
