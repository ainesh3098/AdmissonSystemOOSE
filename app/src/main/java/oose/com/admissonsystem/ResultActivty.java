package oose.com.admissonsystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultActivty extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextView courseAllotted, courseName;

    long rank;
    long count;

    String course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activty);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        courseAllotted = findViewById(R.id.courseAllotted);
        courseName = findViewById(R.id.courseName);

        databaseReference = firebaseDatabase.getReference();

        databaseReference.child("Candidate").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                count = dataSnapshot.getChildrenCount();
                rank = Long.parseLong(dataSnapshot.child(firebaseUser.getUid()).child("rank").getValue(String.class));

                if (count < 6) {

                    if (rank < 1000) {
                        course = "Computer Engineering";
                    }
                    else if (rank < 2000) {
                        course = "Information Technology";
                    }
                    else if (rank < 3000) {
                        course = "Software Engineering";
                    }
                    else if (rank < 4000) {
                        course = "Electronics and Communication";
                    }
                    else if (rank < 5000) {
                        course = "Mechanical Engineering";
                    }

                }
                else {

                    courseAllotted.setText("Course not allotted");
                    courseName.setVisibility(View.GONE);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
