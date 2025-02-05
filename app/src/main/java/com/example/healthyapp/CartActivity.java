package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CartActivity extends AppCompatActivity {
    Button checkout_btn;

    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        // Initialize buttons
        checkout_btn = findViewById(R.id.checkout_btn);
        btnBack = findViewById(R.id.btnBack1);  // Assuming you have these in your layout


        // Checkout button functionality
        checkout_btn.setOnClickListener(v -> {
            Toast.makeText(CartActivity.this, "Order Successful!", Toast.LENGTH_SHORT).show();

        });

        // Back button functionality
        btnBack = findViewById(R.id.btnBack1); // Assuming you have a "Home" button in your layout
        btnBack.setOnClickListener(v -> {
            // Moving to Home Activity
            Intent homeIntent = new Intent(CartActivity.this, OrderDetails.class);
            startActivity(homeIntent);
        });


    }
}
