package com.example.healthyapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class LabTestsAdapter extends RecyclerView.Adapter<LabTestsAdapter.ViewHolder> {

    private final List<LabTest> labTestsList;

    public LabTestsAdapter(List<LabTest> labTestsList) {
        this.labTestsList = labTestsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lab_test, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       LabTest labTest = labTestsList.get(position);
        holder.testName.setText(labTest.getName());
        holder.testImage.setImageResource(labTest.getImageResId());
    }

    @Override
    public int getItemCount() {
        return labTestsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView testName;
        ImageView testImage;

        ViewHolder(View itemView) {
            super(itemView);
            testName = itemView.findViewById(R.id.textViewLabTest);
            testImage = itemView.findViewById(R.id.imageViewLabTest);
        }
    }
}
