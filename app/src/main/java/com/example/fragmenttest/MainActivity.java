package com.example.fragmenttest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;

/*
A demonstration of efficiently switching between Fragments without destroying to replace by using hide and show.
 */

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    LinearLayout linearLayout;
    Button button1, button2, dumpButton;
    String tag1, tag2;

    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linearLayout);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        dumpButton = findViewById(R.id.dump);

        manager = getSupportFragmentManager();

        tag1 = "frag_1";
        tag2 = "frag_2";

        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("key", 1);
            manager
                    .beginTransaction()
                    .add(R.id.container_view, TestFragment.class, bundle, tag1)
                    .addToBackStack(tag1)
                    .commit();
        }

        // Click button1
        button1.setOnClickListener(view -> {

            String current = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1).getName();
            if (manager.findFragmentByTag(tag1) != null && current != tag1) {
                manager
                        .beginTransaction()
                        .hide(manager.findFragmentByTag(current))
                        .show(manager.findFragmentByTag(tag1))
                        .addToBackStack(tag1)
                        .commit();
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putInt("key", 1);

                manager
                        .beginTransaction()
                        .hide(manager.findFragmentByTag(current))
                        .add(R.id.container_view, TestFragment.class, bundle, tag1)
                        .addToBackStack(tag1)
                        .commit();
            }
        });

        // Click button2
        button2.setOnClickListener(view -> {

            String current = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1).getName();
            if (manager.findFragmentByTag(tag2) != null && current != tag2) {
                manager
                        .beginTransaction()
                        .hide(manager.findFragmentByTag(current))
                        .show(manager.findFragmentByTag(tag2))
                        .addToBackStack(tag2)
                        .commit();
            }
            else {
                Bundle bundle = new Bundle();
                bundle.putInt("key", 2);

                manager
                        .beginTransaction()
                        .hide(manager.findFragmentByTag(current))
                        .add(R.id.container_view, TestFragment.class, bundle, tag2)
                        .addToBackStack(tag2)
                        .commit();
            }

        });

        dumpButton.setOnClickListener(view -> {
            for (int i = 0; i < manager.getBackStackEntryCount(); i++) {
                Log.d(TAG, manager.getBackStackEntryAt(i).getName());
                String currentTag = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1).getName();
                manager
                        .beginTransaction()
                        .hide(manager.findFragmentByTag(currentTag))
                        .addToBackStack(tag1)
                        .commit();
            }
        });

    }
}