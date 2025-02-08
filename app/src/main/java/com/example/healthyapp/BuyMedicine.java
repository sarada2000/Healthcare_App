package com.example.healthyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuyMedicine extends AppCompatActivity {

    Button btnBuy1;
    Button btnBuy2;
    Button btnBuy3;
    Button btnBuy4;
    Button btn_back1;
    Button btnCart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);



        // Buy buttons functionality
        btnBuy1 = findViewById(R.id.btnBuy1);
        btnBuy2 = findViewById(R.id.btnBuy2);
        btnBuy3 = findViewById(R.id.btnBuy3);
        btnBuy4 = findViewById(R.id.btnBuy4);

        // Show toast message when any "Buy" button is clicked
        btnBuy1.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Added to cart successfully", Toast.LENGTH_SHORT).show()
        );
        btnBuy2.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Added to cart successfully", Toast.LENGTH_SHORT).show()
        );
        btnBuy3.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Added to cart successfully", Toast.LENGTH_SHORT).show()
        );
        btnBuy4.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Added to cart successfully", Toast.LENGTH_SHORT).show()
        );

        // Back button functionality
        btn_back1 = findViewById(R.id.btn_back1); // Assuming you have a "Home" button in your layout
        btn_back1.setOnClickListener(v -> {
            // Moving to Home Activity
            Intent homeIntent = new Intent(BuyMedicine.this, MainActivity.class);
            startActivity(homeIntent);
        });

        //Go to Cart button functionality
        btnCart = findViewById(R.id.btnCart); // Assuming you have a "Cart" button in your layout
        btnCart.setOnClickListener(v -> {
            // Moving to Cart Activity
            Intent cartIntent = new Intent(BuyMedicine.this, CartActivity.class);
            startActivity(cartIntent);
        });
    }
}
