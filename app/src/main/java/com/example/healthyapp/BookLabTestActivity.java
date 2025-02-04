package com.example.healthyapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class BookLabTestActivity extends AppCompatActivity {

    private Spinner spinnerLabTests;
    private TextView tvSelectedDate;
    private EditText etPatientName, etContactNumber;
    private Button btnSelectDate, btnSubmitBooking, btnBookBack;
    private String selectedTest, selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_lab_test);

        // Initialize UI Elements
        spinnerLabTests = findViewById(R.id.spinnerLabTests);
        tvSelectedDate = findViewById(R.id.tvSelectedDate);
        etPatientName = findViewById(R.id.etPatientName);
        etContactNumber = findViewById(R.id.etContactNumber);
        btnSelectDate = findViewById(R.id.btnSelectDate);
        btnSubmitBooking = findViewById(R.id.btnSubmitBooking);
        btnBookBack = findViewById(R.id.btnBookBack);

        // Inside onCreate method
        btnBookBack.setOnClickListener(view -> {
            Intent intent = new Intent(BookLabTestActivity.this, LabTestHomeActivity.class);
            startActivity(intent);
            finish();  // Optional: finish the current activity to remove it from the back stack
        });


        // Set up Spinner for Lab Tests
        String[] labTests = {"Complete Blood Count (CBC)", "Lipid Profile", "Blood Sugar Test", "Thyroid Function Test"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, labTests);
        spinnerLabTests.setAdapter(adapter);

        spinnerLabTests.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedTest = labTests[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        // Date Picker
        btnSelectDate.setOnClickListener(view -> showDatePicker());

        // Submit Booking
        btnSubmitBooking.setOnClickListener(view -> submitBooking());

    }

    private void showDatePicker() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (DatePicker view, int selectedYear, int selectedMonth, int selectedDay) -> {
            selectedDate = selectedDay + "/" + (selectedMonth + 1) + "/" + selectedYear;
            tvSelectedDate.setText(selectedDate);
        }, year, month, day);

        datePickerDialog.show();
    }

    private void submitBooking() {
        String patientName = etPatientName.getText().toString().trim();
        String contactNumber = etContactNumber.getText().toString().trim();

        if (patientName.isEmpty() || contactNumber.isEmpty() || selectedDate == null) {
            Toast.makeText(this, "Please fill all details!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Show confirmation message
        String confirmationMessage = "Test: " + selectedTest + "\nDate: " + selectedDate + "\nPatient: " + patientName + "\nContact: " + contactNumber;
        Toast.makeText(this, "Booking Confirmed!\n\n" + confirmationMessage, Toast.LENGTH_LONG).show();
    }
}
