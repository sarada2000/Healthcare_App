package com.example.healthyapp;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ResultAdapter extends RecyclerView.Adapter<ResultAdapter.TestResultsViewHolder> {
    private List<TestResult> ResultsList;

    public ResultAdapter(List<TestResult> testResultsList) {
        this.ResultsList = testResultsList;
    }

    public static class TestResultsViewHolder extends RecyclerView.ViewHolder {
        TextView testName, testResult, testDate;

        public TestResultsViewHolder(@NonNull View itemView) {
            super(itemView);
            testName = itemView.findViewById(R.id.tvTestName);
            testResult = itemView.findViewById(R.id.tvResult);
            testDate = itemView.findViewById(R.id.tvDate);
        }
    }

    @NonNull
    @Override
    public TestResultsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lab_result, parent, false);
        return new TestResultsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestResultsViewHolder holder, int position) {
        TestResult test = ResultsList.get(position);
        holder.testName.setText(test.getTestName());
        holder.testResult.setText("Result: " + test.getResult());
        holder.testDate.setText("Date: " + test.getDate());
    }

    @Override
    public int getItemCount() {
        return ResultsList.size();
    }
}
