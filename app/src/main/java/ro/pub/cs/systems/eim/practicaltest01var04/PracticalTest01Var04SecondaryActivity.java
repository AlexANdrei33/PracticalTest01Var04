package ro.pub.cs.systems.eim.practicaltest01var04;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class PracticalTest01Var04SecondaryActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_secondary);

        TextView studentNameTextView = findViewById(R.id.text_view_student_name);
        TextView classNumberTextView = findViewById(R.id.text_view_class_number);

        Intent intent = getIntent();
        if (intent != null && Objects.requireNonNull(intent.getExtras()).containsKey(Constants.STUDENT_NAME)) {
            String name = intent.getStringExtra(Constants.STUDENT_NAME);
            studentNameTextView.setText(name);
        }
        if (intent != null && intent.getExtras().containsKey(Constants.CLASS_NUMBER)) {
            String number = intent.getStringExtra(Constants.CLASS_NUMBER);
            classNumberTextView.setText(number);
        }

        Button okButton = findViewById(R.id.ok_button);
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_OK, null);
                finish();
            }
        });

        Button cancelButton = findViewById(R.id.cancel_button);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED, null);
                finish();
            }
        });
    }
}