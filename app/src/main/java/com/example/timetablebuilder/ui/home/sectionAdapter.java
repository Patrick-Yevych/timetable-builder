package com.example.timetablebuilder.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetablebuilder.R;

import model.Graph;
import model.Section;

public class sectionAdapter extends RecyclerView.Adapter<sectionAdapter.sectionViewHolder> {
    private Graph S;

    public static class sectionViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public sectionViewHolder(View itemView) {
            super(itemView);
            this.textView = (TextView) itemView.findViewById(R.id.section_info);
        }
    }

    public sectionAdapter(Graph S) {
        this.S = S;
    }

    @Override
    public sectionAdapter.sectionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.section_layout, parent, false);
        sectionViewHolder vh = new sectionViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(sectionViewHolder holder, int position) {
        Section s = this.S.getSection(position);
        holder.textView.setText("COURSE: " + s.getCode() + " TYPE: " + s.getTypeString() + " TIME: " + s.getDayString() +  " " + s.getStartTime() + " to " + s.getFinishTime());
    }

    @Override
    public int getItemCount() {
        return this.S.getSize();
    }
}
