package oose.com.admissonsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        sub1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub1.setVisibility(View.GONE);

            }
        });
        sub2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub2.setVisibility(View.GONE);
            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub3.setVisibility(View.GONE);
            }
        });

        sub4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub4.setVisibility(View.GONE);
            }
        });

        sub3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sub1.setVisibility(View.GONE);
            }
        });








    }
}
