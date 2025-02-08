package com.example.healthyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {

    Button check_outbtn;

    Button btnBack;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);



        // Back button functionality
        btnBack = findViewById(R.id.btnBack); // Assuming you have a "Home" button in your layout
        btnBack.setOnClickListener(v -> {
            // Moving to Home Activity
            Intent homeIntent = new Intent(CartActivity.this, OrderDetails.class);
            startActivity(homeIntent);
        });

        // checkout button functionality
        check_outbtn = findViewById(R.id.check_outbtn);
        check_outbtn.setOnClickListener(v -> {
            // Moving to  checkout
            Intent homeIntent = new Intent(CartActivity.this, CheckOut.class);
            startActivity(homeIntent);
        });


    }
}
