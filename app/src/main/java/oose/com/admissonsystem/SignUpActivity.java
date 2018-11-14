package oose.com.admissonsystem;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {


    String sName, sEmail, sRoll, sPassword, sConfirmPassword , sRank;

    FirebaseAuth firebaseAuth;

    FirebaseUser firebaseUser;

    FirebaseDatabase firebaseDatabase;

    DatabaseReference databaseReference;

    EditText name, email , rollNo , password, passwordConfirm, rank;
    CardView register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.rgb(250,250,250));
            }
        }

        name = findViewById(R.id.candidateNameEditText);
        email = findViewById(R.id.candidateEmailEditText);
        rollNo = findViewById(R.id.candidateRoll);
        password = findViewById(R.id.password);
        rank = findViewById(R.id.candidateRank);
        passwordConfirm = findViewById(R.id.passwordConfirm);
        register = findViewById(R.id.RegisterCard);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference();

      /*  if(firebaseUser != null)
        {
            start
        }*/


      register.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              sName = name.getText().toString();
              sEmail = email.getText().toString();
              sRoll = rollNo.getText().toString();
              sPassword = password.getText().toString();
              sConfirmPassword = passwordConfirm.getText().toString();
              sRank = rank.getText().toString();

              if(!sName.isEmpty() || !sEmail.isEmpty() || !sRank.isEmpty() || !sRoll.isEmpty() || !sPassword.isEmpty() || !sConfirmPassword.isEmpty())
              {
                  if(!sPassword.equals(sConfirmPassword))
                  {
                      Toast.makeText(SignUpActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                  }
                  else
                  {
                      firebaseAuth.createUserWithEmailAndPassword(sEmail,sPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {

                              if(task.isSuccessful())
                              {
                                  databaseReference.child("Candidate").child(firebaseUser.getUid()).child("rollNumber").setValue(sRoll);
                                  databaseReference.child("Candidate").child(firebaseUser.getUid()).child("name").setValue(sName);
                                  databaseReference.child("Candidate").child(firebaseUser.getUid()).child("email").setValue(sEmail);
                                  databaseReference.child("Candidate").child(firebaseUser.getUid()).child("rank").setValue(sRank).addOnCompleteListener(new OnCompleteListener<Void>() {
                                      @Override
                                      public void onComplete(@NonNull Task<Void> task) {

                                          startActivity( new Intent(SignUpActivity.this , HomePageActivity.class));
                                          finish();
                                      }
                                  });



                              }
                          }
                      });
                  }
              }

              else
              {
                  if(sName.isEmpty())
                  {
                      name.setError("Required");
                  }
                  if(sEmail.isEmpty())
                  {
                      email.setError("Required");
                  }
                  if(sRank.isEmpty())
                  {
                      rank.setError("Required");
                  }
                  if(sRoll.isEmpty())
                  {
                      rollNo.setError("Required");
                  }
                  if(sPassword.isEmpty())
                  {
                      password.setError("Required");
                  }
                  if(sConfirmPassword.isEmpty())
                  {
                      passwordConfirm.setError("Required");
                  }


              }


          }
      });





 }
}
