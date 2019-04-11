package com.challenge.simpledaggerapplication2.ui;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.challenge.simpledaggerapplication2.MyApp;
import com.challenge.simpledaggerapplication2.R;
import com.challenge.simpledaggerapplication2.common.PreferenceHelper;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Inject
    PreferenceHelper preferenceHelper;

    @BindView(R.id.enter_name_edit)
    EditText nameEditText;
    @BindView(R.id.save_name_button)
    Button saveButton;
    @BindView(R.id.log_button)
    Button logButton;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApp.inject(this);
        initView();
    }

    private void initView() {
        saveButton.setOnClickListener(view -> {
            counter++;
            String name = nameEditText.getText().toString();
            boolean isSuccess = preferenceHelper.add("user_name" + counter, name);

            if (isSuccess) {
                Toast.makeText(this, name + " added successfully.", Toast.LENGTH_SHORT).show();
            }
        });

        logButton.setOnClickListener(view -> {
            preferenceHelper.log();
        });
    }
}
