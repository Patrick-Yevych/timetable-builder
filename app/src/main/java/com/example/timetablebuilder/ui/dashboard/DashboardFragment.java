package com.example.timetablebuilder.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetablebuilder.MainActivity;
import com.example.timetablebuilder.R;
import com.example.timetablebuilder.ui.home.sectionAdapter;

import model.Graph;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private RecyclerView sectionRecyclerViewObj;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        final Graph S = MainActivity.S;

        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        sectionRecyclerViewObj = (RecyclerView) root.findViewById(R.id.sectionRecyclerView);
        sectionRecyclerViewObj.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this.getActivity());
        sectionRecyclerViewObj.setLayoutManager(layoutManager);

        adapter = new sectionAdapter(S);
        sectionRecyclerViewObj.setAdapter(adapter);


        return root;
    }
}