package com.example.pilltracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MedicationRVA extends RecyclerView.Adapter<MedicationRVA.ViewHolder> {
    private Context context;
    private ArrayList<Medication> medicationArrayList = new ArrayList<>();

    public MedicationRVA(Context context) {
        this.context = context;
    }

    public void setMedications(ArrayList<Medication> medications) {
        this.medicationArrayList = medications;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.medications_list_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.medicationName.setText(medicationArrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return medicationArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView medicationName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            medicationName = itemView.findViewById(R.id.medicationName);
        }
    }
}
