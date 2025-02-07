package com.example.healthyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TestResultActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ResultAdapter adapter;
    private List<TestResult> testResultsList;
    private Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_result);


        recyclerView = findViewById(R.id.recyclerViewTestResults);
        btnBackToHome = findViewById(R.id.btnBackToHome);

        // Sample Test Results Data
        testResultsList = new ArrayList<>();
        testResultsList.add(new TestResult("Complete Blood Count (CBC)", "Normal", "2025-01-20"));
        testResultsList.add(new TestResult("Lipid Profile", "High Cholesterol", "2025-01-18"));
        testResultsList.add(new TestResult("Blood Sugar Test", "Diabetic", "2025-01-15"));
        testResultsList.add(new TestResult("Thyroid Function Test", "Normal", "2025-01-10"));

        // Setting up RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ResultAdapter(testResultsList);
        recyclerView.setAdapter(adapter);

        // Back Button Click Listener
        btnBackToHome.setOnClickListener(v -> {
            Intent intent = new Intent(TestResultActivity.this, LabTestHomeActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
