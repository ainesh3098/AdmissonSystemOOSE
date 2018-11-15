package oose.com.admissonsystem;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SeatMaintenanceActivity extends AppCompatActivity {

    TextView seatsAllotted, remainingSeatstextview;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    long counter = 0;

    long remaining = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat_maintenance);

        seatsAllotted = findViewById(R.id.seatsAllotted);
        remainingSeatstextview = findViewById(R.id.remainingSeatsTextView);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();



        databaseReference.child("Candidate").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                counter = dataSnapshot.getChildrenCount();
                seatsAllotted.setText(Long.toString(counter));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        remaining = 5 - counter;

        remainingSeatstextview.setText(Long.toString(remaining));

        }
}
