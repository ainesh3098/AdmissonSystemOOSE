package oose.com.admissonsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PreferencesActivity extends AppCompatActivity {

    TextView sub1 , sub2 , sub3 , sub4 , sub5;
    TextView preference1, preference2 , preference3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        sub1 = findViewById(R.id.subject1);
        sub2 = findViewById(R.id.subject2);
        sub3 = findViewById(R.id.subject3);
        sub4 = findViewById(R.id.subject4);
        sub5 = findViewById(R.id.subject5);
        preference1 = findViewById(R.id.preference1);
        preference2 = findViewById(R.id.preference2);
        preference3 = findViewById(R.id.preference3);


        preference1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference1.getText().toString().length() == 0) {

                    Toast.makeText(PreferencesActivity.this, "You must select a preference.", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (preference1.getText().toString().equals("Subject 1")) {

                        sub1.setVisibility(View.VISIBLE);
                    }
                    else if (preference1.getText().toString().equals("Subject 2")) {

                        sub2.setVisibility(View.VISIBLE);
                    }
                    else if (preference1.getText().toString().equals("Subject 3")) {

                        sub3.setVisibility(View.VISIBLE);
                    }
                    else if (preference1.getText().toString().equals("Subject 4")) {

                        sub4.setVisibility(View.VISIBLE);
                    }
                    else if (preference1.getText().toString().equals("Subject 5")) {

                        sub5.setVisibility(View.VISIBLE);
                    }


                    if (preference2.getText().toString().length() != 0) {

                        preference1.setText(preference2.getText().toString());

                        if (preference3.getText().toString().length() != 0) {

                            preference2.setText(preference3.getText().toString());
                            preference3.setText("");

                        }
                        else {
                            preference2.setText("");
                        }
                    }
                    else {
                        preference1.setText("");
                    }

                }

            }
        });


        preference2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference2.getText().toString().length() == 0) {

                    Toast.makeText(PreferencesActivity.this, "You must select a preference.", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (preference2.getText().toString().equals("Subject 1")) {

                        sub1.setVisibility(View.VISIBLE);
                    }
                    else if (preference2.getText().toString().equals("Subject 2")) {

                        sub2.setVisibility(View.VISIBLE);
                    }
                    else if (preference2.getText().toString().equals("Subject 3")) {

                        sub3.setVisibility(View.VISIBLE);
                    }
                    else if (preference2.getText().toString().equals("Subject 4")) {

                        sub4.setVisibility(View.VISIBLE);
                    }
                    else if (preference2.getText().toString().equals("Subject 5")) {

                        sub5.setVisibility(View.VISIBLE);
                    }

                    if (preference3.getText().toString().length() != 0) {

                        preference2.setText(preference3.getText().toString());
                        preference3.setText("");
                    }
                    else {

                        preference2.setText("");
                    }

                }

            }
        });


        preference3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference3.getText().toString().length() == 0) {

                    Toast.makeText(PreferencesActivity.this, "You must select a preference.", Toast.LENGTH_SHORT).show();
                }
                else {

                    if (preference3.getText().toString().equals("Subject 1")) {

                        sub1.setVisibility(View.VISIBLE);
                    }
                    else if (preference3.getText().toString().equals("Subject 2")) {

                        sub2.setVisibility(View.VISIBLE);
                    }
                    else if (preference3.getText().toString().equals("Subject 3")) {

                        sub3.setVisibility(View.VISIBLE);
                    }
                    else if (preference3.getText().toString().equals("Subject 4")) {

                        sub4.setVisibility(View.VISIBLE);
                    }
                    else if (preference3.getText().toString().equals("Subject 5")) {

                        sub5.setVisibility(View.VISIBLE);
                    }

                    preference3.setText("");

                }

            }
        });


        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference1.getText().toString().length() == 0) {

                    preference1.setText(sub1.getText().toString());
                    sub1.setVisibility(View.GONE);
                }
                else if (preference2.getText().toString().length() == 0){

                    preference2.setText(sub1.getText().toString());
                    sub1.setVisibility(View.GONE);
                }
                else if (preference3.getText().toString().length() == 0){

                    preference3.setText(sub1.getText().toString());
                    sub1.setVisibility(View.GONE);
                }
                else {

                    Toast.makeText(PreferencesActivity.this, "You can select three choices at most.", Toast.LENGTH_SHORT).show();
                }

            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference1.getText().toString().length() == 0) {

                    preference1.setText(sub2.getText().toString());
                    sub2.setVisibility(View.GONE);

                }
                else if (preference2.getText().toString().length() == 0){

                    preference2.setText(sub2.getText().toString());
                    sub2.setVisibility(View.GONE);

                }
                else if (preference3.getText().toString().length() == 0){

                    preference3.setText(sub2.getText().toString());
                    sub2.setVisibility(View.GONE);

                }
                else {

                    Toast.makeText(PreferencesActivity.this, "You can select three choices at most.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference1.getText().toString().length() == 0) {

                    preference1.setText(sub3.getText().toString());
                    sub3.setVisibility(View.GONE);

                }
                else if (preference2.getText().toString().length() == 0){

                    preference2.setText(sub3.getText().toString());
                    sub3.setVisibility(View.GONE);

                }
                else if (preference3.getText().toString().length() == 0){

                    preference3.setText(sub3.getText().toString());
                    sub3.setVisibility(View.GONE);

                }
                else {

                    Toast.makeText(PreferencesActivity.this, "You can select three choices at most.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference1.getText().toString().length() == 0) {

                    preference1.setText(sub4.getText().toString());
                    sub4.setVisibility(View.GONE);

                }
                else if (preference2.getText().toString().length() == 0){

                    preference2.setText(sub4.getText().toString());
                    sub4.setVisibility(View.GONE);

                }
                else if (preference3.getText().toString().length() == 0){

                    preference3.setText(sub4.getText().toString());
                    sub4.setVisibility(View.GONE);

                }
                else {

                    Toast.makeText(PreferencesActivity.this, "You can select three choices at most.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        sub5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference1.getText().toString().length() == 0) {

                    preference1.setText(sub5.getText().toString());
                    sub5.setVisibility(View.GONE);

                }
                else if (preference2.getText().toString().length() == 0){

                    preference2.setText(sub5.getText().toString());
                    sub5.setVisibility(View.GONE);

                }
                else if (preference3.getText().toString().length() == 0){

                    preference3.setText(sub5.getText().toString());
                    sub5.setVisibility(View.GONE);

                }
                else {

                    Toast.makeText(PreferencesActivity.this, "You can select three choices at most.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
