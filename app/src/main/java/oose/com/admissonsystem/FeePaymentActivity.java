package oose.com.admissonsystem;

import android.content.DialogInterface;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

public class FeePaymentActivity extends AppCompatActivity {

    CardView card, net;

    ConstraintLayout B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fee_payment);

        card = findViewById(R.id.cardPaymentCard);
        net = findViewById(R.id.netbankingCardView);

        B = findViewById(R.id.parentB);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(FeePaymentActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(FeePaymentActivity.this);
                }
                builder.setTitle("Card Payment")
                        .setMessage("Are you sure you want to pay using Card?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(FeePaymentActivity.this, "Payment Made! You are Admitted in DTU", Toast.LENGTH_SHORT).show();

                                Snackbar.make(B, "Download Payment Receipt", Snackbar.LENGTH_LONG)
                                        .setAction("DOWNLOAD", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                            }
                                        })
                                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                                        .show();
                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });


        net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    builder = new AlertDialog.Builder(FeePaymentActivity.this, android.R.style.Theme_Material_Dialog_Alert);
                } else {
                    builder = new AlertDialog.Builder(FeePaymentActivity.this);
                }
                builder.setTitle("NetBanking Payment")
                        .setMessage("Are you sure you want to pay using NetBanking")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(FeePaymentActivity.this, "Payment Made! You are Admitted in DTU", Toast.LENGTH_SHORT).show();

                                Snackbar.make(B, "Download Payment Receipt", Snackbar.LENGTH_LONG)
                                        .setAction("DOWNLOAD", new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {

                                            }
                                        })
                                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
                                        .show();

                                // continue with delete
                            }
                        })
                        .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // do nothing
                                dialog.dismiss();
                            }
                        })
                        .show();
            }
        });



    }
}
