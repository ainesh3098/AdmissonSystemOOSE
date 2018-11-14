package oose.com.admissonsystem;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PreferencesActivity extends AppCompatActivity {

    TextView sub1 , sub2 , sub3 , sub4 , sub5;
    TextView preference1, preference2 , preference3;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    FloatingActionButton savePreferencesFAB;

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

        savePreferencesFAB = findViewById(R.id.savePreferencesFAB);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        /*databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String str = dataSnapshot.child("Candidate").child(firebaseUser.getUid()).child("Choices").child("Choice1").getValue(String.class);
                if (str.isEmpty()) {

                    AlertDialog.Builder builder = new AlertDialog.Builder(PreferencesActivity.this);
                    builder.setTitle("Error");
                    builder.setMessage("You have already selected your preferences.");
                    builder.setCancelable(false);
                    builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            startActivity(new Intent(PreferencesActivity.this, ResultActivty.class));
                            finish();

                        }
                    });
                    builder.show();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/

        savePreferencesFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (preference1.getText().toString().length() != 0) {

                    databaseReference.child("Candidate").child(firebaseUser.getUid()).child("Choices").child("Choice1").setValue(preference1.getText().toString());

                }
                else {
                    databaseReference.child("Candidate").child(firebaseUser.getUid()).child("Choices").child("Choice1").setValue("None");

                }

                if (preference2.getText().toString().length() != 0) {

                    databaseReference.child("Candidate").child(firebaseUser.getUid()).child("Choices").child("Choice2").setValue(preference2.getText().toString());

                }
                else {
                    databaseReference.child("Candidate").child(firebaseUser.getUid()).child("Choices").child("Choice2").setValue("None");

                }

                if (preference1.getText().toString().length() != 0) {

                    databaseReference.child("Candidate").child(firebaseUser.getUid()).child("Choices").child("Choice3").setValue(preference3.getText().toString());

                }
                else {
                    databaseReference.child("Candidate").child(firebaseUser.getUid()).child("Choices").child("Choice3").setValue("None");

                }

            }
        });

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
