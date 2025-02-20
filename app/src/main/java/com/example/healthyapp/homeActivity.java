package com.example.healthyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class homeActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        // Find the Logout button
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button logoutButton;
        logoutButton = findViewById(R.id.btnButton3);

        // Set click listener for logout button
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirect to Login Activity
                Intent intent = new Intent(homeActivity.this, LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // Clear back stack
                startActivity(intent);
                finish(); // Close current activity
            }
        });
        CardView Lab_Test= findViewById(R.id.cardLabTest);
        Lab_Test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(homeActivity.this, LabTestHomeActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }

        });
        CardView Buy_Medicine= findViewById(R.id.CardBuyMedicine);
        Buy_Medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(homeActivity.this, BuyMedicine.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }

        });
        CardView Find_Doctors= findViewById(R.id.CardFindDcotor);
        Find_Doctors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(homeActivity.this, FindDoctorsActivity.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }
        });
        CardView Order_Details= findViewById(R.id.CardOrderDetails);
        Order_Details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(homeActivity.this, OrderDetails.class);
                it.putExtra("title","Family Physicians");
                startActivity(it);
            }
        });
    }
}
