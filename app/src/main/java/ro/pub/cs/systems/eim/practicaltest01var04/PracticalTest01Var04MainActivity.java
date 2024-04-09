package ro.pub.cs.systems.eim.practicaltest01var04;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private EditText studentNameEditText;
    private EditText classNumberEditText;
    private CheckBox studentNameCheckBox;
    private CheckBox classNumberCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var04_main);

        studentNameEditText = findViewById(R.id.edit_box_student_name);
        classNumberEditText = findViewById(R.id.edit_box_class_number);
        studentNameCheckBox = findViewById(R.id.check_box_student_name);
        classNumberCheckBox = findViewById(R.id.check_box_class_number);

        Button displayInformationButton = findViewById(R.id.display_information);
        displayInformationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayInformation();
            }
        });
    }

    private void displayInformation() {
        String studentName = studentNameEditText.getText().toString();
        String classNumber = classNumberEditText.getText().toString();
        String info = "";

        if (studentNameCheckBox.isChecked()) {
            if (studentName.isEmpty()) {
                showToast("Error: Please fill in the student name");
                return;
            }
            info += studentName + " ";
        }

        if (classNumberCheckBox.isChecked()) {
            if (classNumber.isEmpty()) {
                showToast("Error: Please fill in the class number");
                return;
            }
            info += classNumber;
        }

        TextView studentInfoTextView = findViewById(R.id.text_view_student_info);
        studentInfoTextView.setText(info);
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Constants.STUDENT_NAME, studentNameEditText.getText().toString());
        outState.putString(Constants.CLASS_NUMBER, classNumberEditText.getText().toString());
        outState.putBoolean(Constants.STUDENT_NAME_CHECKBOX, studentNameCheckBox.isChecked());
        outState.putBoolean(Constants.CLASS_NUMBER_CHECKBOX, classNumberCheckBox.isChecked());
    }

    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey(Constants.STUDENT_NAME)) {
            studentNameEditText.setText(savedInstanceState.getString(Constants.STUDENT_NAME));
        }
        if (savedInstanceState.containsKey(Constants.CLASS_NUMBER)) {
            classNumberEditText.setText(savedInstanceState.getString(Constants.CLASS_NUMBER));
        }
        if (savedInstanceState.containsKey(Constants.STUDENT_NAME_CHECKBOX)) {
            studentNameCheckBox.setChecked(savedInstanceState.getBoolean(Constants.STUDENT_NAME_CHECKBOX));
        }
        if (savedInstanceState.containsKey(Constants.CLASS_NUMBER_CHECKBOX)) {
            classNumberCheckBox.setChecked(savedInstanceState.getBoolean(Constants.CLASS_NUMBER_CHECKBOX));
        }
    }
}
