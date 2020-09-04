package com.example.timetablebuilder.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.timetablebuilder.MainActivity;
import com.example.timetablebuilder.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Graph;
import model.Section;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        final Graph S = MainActivity.S;

        final Spinner typeSpinnerObj = (Spinner)root.findViewById(R.id.typeSpinner);
        final Spinner startSpinnerObj = (Spinner)root.findViewById(R.id.startSpinner);
        final Spinner finishSpinnerObj = (Spinner)root.findViewById(R.id.finishSpinner);
        final Spinner daySpinnerObj = (Spinner)root.findViewById(R.id.daySpinner);
        final EditText codeTextObj = (EditText)root.findViewById(R.id.codeInput);

        final Button addBtnObj = root.findViewById(R.id.addBtn);
        addBtnObj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int type = Section.LEC;
                int startTime = 9;
                int finishTime = 9;
                int day = 0;
                String code = codeTextObj.getText().toString();


                switch (typeSpinnerObj.getSelectedItem().toString()) {
                    case "Lecture":
                        type = Section.LEC;
                        break;
                    case "Tutorial":
                        type = Section.TUT;
                }

                Pattern timePattern = Pattern.compile("^(\\d{1,2}):00\\w\\w$");
                Matcher matcher = timePattern.matcher(startSpinnerObj.getSelectedItem().toString());
                if (matcher.find()) {
                    startTime = Integer.parseInt(matcher.group(1));
                }
                matcher = timePattern.matcher(finishSpinnerObj.getSelectedItem().toString());
                if (matcher.find()) {
                    finishTime = Integer.parseInt(matcher.group(1));
                }

                switch(daySpinnerObj.getSelectedItem().toString()) {
                    case "Monday":
                        day = 0;
                        break;
                    case "Tuesday":
                        day = 1;
                        break;
                    case "Wednesday":
                        day = 2;
                        break;
                    case "Thursday":
                        day = 3;
                        break;
                    case "Friday":
                        day = 4;
                        break;
                }

                S.insert(startTime, finishTime, day, type, code);
            }
        });

        return root;
    }
}