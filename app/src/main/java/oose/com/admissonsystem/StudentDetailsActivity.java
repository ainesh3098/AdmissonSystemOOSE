package oose.com.admissonsystem;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StudentDetailsActivity extends AppCompatActivity {

    TextInputLayout nameTIL;
    TextInputLayout rollNoTIL;
    TextInputLayout rankTIL;
    TextInputLayout emailTIL;
    TextInputLayout regNoTIL;
    TextInputLayout addressTIL;
    TextInputLayout guardianTIL;
    TextInputLayout guardianMobileTIL;

    FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    TextInputEditText name;
    TextInputEditText rollNo;
    TextInputEditText rank;
    TextInputEditText email;
    TextInputEditText regNo;
    TextInputEditText address;
    TextInputEditText guardian;
    TextInputEditText guardianMobile;

    Button saveButton, editButton, deleteButton;

    @Override
    public void onBackPressed() {
        startActivity(new Intent(StudentDetailsActivity.this, HomePageActivity.class));
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        nameTIL = findViewById(R.id.pgNameTIL);
        rollNoTIL = findViewById(R.id.rollNoTIL);
        rankTIL = findViewById(R.id.rankTIL);
        emailTIL = findViewById(R.id.emailTIL);
        regNoTIL = findViewById(R.id.registrationNumberTIL);
        addressTIL = findViewById(R.id.addressTIL);
        guardianTIL = findViewById(R.id.guardianTIL);
        guardianMobileTIL = findViewById(R.id.guardianMobileTIL);

        name = findViewById(R.id.pgNameTextView);
        rollNo = findViewById(R.id.rollNoEditText);
        rank = findViewById(R.id.rankEditText);
        email = findViewById(R.id.emailEditText);
        regNo = findViewById(R.id.registrationNumberEditText);
        address = findViewById(R.id.addressEditText);
        guardian = findViewById(R.id.guardianEditText);
        guardianMobile = findViewById(R.id.guardianMobileEditText);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        saveButton = findViewById(R.id.saveButton);
        editButton = findViewById(R.id.editButton);
        deleteButton = findViewById(R.id.deleteButton);

        nameTIL.setHintAnimationEnabled(false);
        nameTIL.setEnabled(false);


        rollNoTIL.setHintAnimationEnabled(false);
        rollNoTIL.setEnabled(false);

        rankTIL.setHintAnimationEnabled(false);
        rankTIL.setEnabled(false);

        emailTIL.setHintAnimationEnabled(false);
        emailTIL.setEnabled(false);

        regNoTIL.setHintAnimationEnabled(false);
        regNoTIL.setEnabled(false);

        addressTIL.setHintAnimationEnabled(false);
        addressTIL.setEnabled(false);

        guardianMobileTIL.setHintAnimationEnabled(false);
        guardianMobileTIL.setEnabled(false);

        guardianTIL.setHintAnimationEnabled(false);
        guardianTIL.setEnabled(false);

        databaseReference.child("Candidate").child(firebaseUser.getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String name1 = dataSnapshot.child("name").getValue(String.class);
                String roll1 = dataSnapshot.child("rollNumber").getValue(String.class);
                String rank1 = dataSnapshot.child("rank").getValue(String.class);
                String email1 = dataSnapshot.child("email").getValue(String.class);
                String regNumber1 = dataSnapshot.child("regNumber").getValue(String.class);
                String address1 = dataSnapshot.child("address").getValue(String.class);
                String guardian1 = dataSnapshot.child("guardian").getValue(String.class);
                String guardianMobile1 = dataSnapshot.child("guardianMobile").getValue(String.class);

                name.setText(name1);
                rollNo.setText(roll1);
                rank.setText(rank1);
                email.setText(email1);
                regNo.setText(regNumber1);
                address.setText(address1);
                guardian.setText(guardian1);
                guardianMobile.setText(guardianMobile1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nameString = name.getText().toString().trim();
                String emailString = email.getText().toString().trim();
                String rollNoString = rollNo.getText().toString().trim();
                String rankString = rank.getText().toString().trim();
                String regNoString = regNo.getText().toString().trim();
                String addressString = address.getText().toString().trim();
                String guardianString = guardian.getText().toString().trim();
                String guardianMobileString = guardianMobile.getText().toString().trim();

                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("rollNumber").setValue(rollNoString);
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("name").setValue(nameString);
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("email").setValue(emailString);
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("rank").setValue(rankString);
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("regNumber").setValue(regNoString);
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("address").setValue(addressString);
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("guardian").setValue(guardianString);
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("guardianMobile").setValue(guardianMobileString);


                addressTIL.setHintAnimationEnabled(false);
                addressTIL.setEnabled(false);
                addressTIL.setFocusable(false);

                guardianMobileTIL.setHintAnimationEnabled(false);
                guardianMobileTIL.setEnabled(false);
                guardianMobileTIL.setFocusable(false);

                guardianTIL.setHintAnimationEnabled(false);
                guardianTIL.setEnabled(false);
                guardianTIL.setFocusable(false);





            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("rollNumber").setValue("");
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("name").setValue("");
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("email").setValue("");
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("rank").setValue("");
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("regNumber").setValue("");
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("address").setValue("");
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("guardian").setValue("");
                databaseReference.child("Candidate").child(firebaseUser.getUid()).child("guardianMobile").setValue("");

                Toast.makeText(StudentDetailsActivity.this, "Deleted!", Toast.LENGTH_SHORT).show();

            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* nameTIL.setHintAnimationEnabled(true);
                nameTIL.setEnabled(true);

                rollNoTIL.setHintAnimationEnabled(true);
                rollNoTIL.setEnabled(true);

                rankTIL.setHintAnimationEnabled(true);
                rankTIL.setEnabled(true);

                emailTIL.setHintAnimationEnabled(true);
                emailTIL.setEnabled(true);

                regNoTIL.setHintAnimationEnabled(true);
                regNoTIL.setEnabled(true);*/

                addressTIL.setHintAnimationEnabled(true);
                addressTIL.setEnabled(true);
                addressTIL.setFocusable(true);

                guardianMobileTIL.setHintAnimationEnabled(true);
                guardianMobileTIL.setEnabled(true);
                guardianMobileTIL.setFocusable(true);

                guardianTIL.setHintAnimationEnabled(true);
                guardianTIL.setEnabled(true);
                guardianTIL.setFocusable(true);
            }
        });




    }
}
