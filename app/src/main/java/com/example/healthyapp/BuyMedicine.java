package com.example.healthyapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuyMedicine extends AppCompatActivity {

    Button btnBack, btnCart;
    Button btnBuy1, btnBuy2, btnBuy3, btnBuy4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine); // Make sure this matches your XML file name

        // Buttons for Back and Cart
        btnBack = findViewById(R.id.btn_back1);
        btnCart = findViewById(R.id.btnCart);

        // Medicine item buttons
        btnBuy1 = findViewById(R.id.btnBuy1);
        btnBuy2 = findViewById(R.id.btnBuy2);
        btnBuy3 = findViewById(R.id.btnBuy3);
        btnBuy4 = findViewById(R.id.btnBuy4);

        // Set onClickListeners for Add to Cart buttons
        btnBuy1.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Paracetamol added to cart!", Toast.LENGTH_SHORT).show());

        btnBuy2.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Amoxicillin added to cart!", Toast.LENGTH_SHORT).show());

        btnBuy3.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Mefen added to cart!", Toast.LENGTH_SHORT).show());

        btnBuy4.setOnClickListener(v ->
                Toast.makeText(BuyMedicine.this, "Dexa added to cart!", Toast.LENGTH_SHORT).show());

        // Back button action
        btnBack.setOnClickListener(v -> {
            Intent intent = new Intent(BuyMedicine.this, homeActivity.class);
            startActivity(intent);
        });

        // Cart button action
        btnCart.setOnClickListener(v -> {
            Intent intent = new Intent(BuyMedicine.this, CartActivity.class);
            startActivity(intent);
        });
    }
}

