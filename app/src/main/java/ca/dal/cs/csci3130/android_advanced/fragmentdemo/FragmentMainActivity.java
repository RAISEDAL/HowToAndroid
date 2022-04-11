package ca.dal.cs.csci3130.android_advanced.fragmentdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import ca.dal.cs.csci3130.android_advanced.R;

public class FragmentMainActivity extends AppCompatActivity {

    SimpleFragment fragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        Button fragmentButton = (Button) findViewById(R.id.simpleFragButton);
        fragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment = new SimpleFragment();
                addNewFragment(fragment);
                Toast.makeText(getBaseContext(), "Fragment added!", Toast.LENGTH_SHORT).show();
            }
        });

        Button removeButton = (Button) findViewById(R.id.removeFragButton);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fragment != null) {
                    removeFragment(fragment);
                    Toast.makeText(getBaseContext(), "Fragment removed!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    protected void removeFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.remove(fragment);
        transaction.commit();
    }

    protected void addNewFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.commit();
    }

}