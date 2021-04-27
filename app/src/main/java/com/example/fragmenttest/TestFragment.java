package com.example.fragmenttest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TestFragment extends Fragment {

    public TestFragment() {
        super(R.layout.test_fragment);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int value = requireArguments().getInt("key");
        TextView textView = getView().findViewById(R.id.textView);
        textView.setText(String.valueOf(value));
    }
}
