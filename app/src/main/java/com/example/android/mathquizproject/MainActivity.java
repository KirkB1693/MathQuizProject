package com.example.android.mathquizproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //@totalQuestions is a global variable to track the total number of questions in the quiz
    int totalQuestions = 4;


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        }

    public void getScore(View view) {
        int rightAnswers = 0;
        int rightAnswer1 = 0;
        int rightAnswer2 = 0;
        int rightAnswer3 = 0;
        int rightAnswer4 = 0;

        RadioButton rb1 = (RadioButton) findViewById(R.id.radio_question1_answer2);
        if (rb1.isChecked()) {
            rightAnswer1 = 1;
        }

        CheckBox checkBoxShape1 = (CheckBox) findViewById(R.id.checkbox_shape1);
        CheckBox checkBoxShape2 = (CheckBox) findViewById(R.id.checkbox_shape2);
        CheckBox checkBoxShape3 = (CheckBox) findViewById(R.id.checkbox_shape3);
        CheckBox checkBoxShape4 = (CheckBox) findViewById(R.id.checkbox_shape4);
        CheckBox checkBoxShape5 = (CheckBox) findViewById(R.id.checkbox_shape5);
        CheckBox checkBoxShape6 = (CheckBox) findViewById(R.id.checkbox_shape6);

        if (checkBoxShape1.isChecked()) {
            if (checkBoxShape2.isChecked()) {
                rightAnswer2 = 0;
            } else {
                if (checkBoxShape3.isChecked()) {
                    if (checkBoxShape4.isChecked()) {
                        if (checkBoxShape5.isChecked()) {
                            rightAnswer2 = 0;
                        } else {
                            if (checkBoxShape6.isChecked()) {
                                rightAnswer2 = 1;
                            }
                        }
                    } else {
                        rightAnswer2 = 0;
                    }
                } else {
                    rightAnswer2 = 0;
                }

            }

        } else {
            rightAnswer2 = 0;
        }

        TextView question3Text = (TextView) findViewById(R.id.question3_text);
        int question3Answer = Integer.parseInt(question3Text.getText().toString());
        if (question3Answer == 198) {
            rightAnswer3 = 1;
        }

        RadioButton rb2 = (RadioButton) findViewById(R.id.radio_question4_answer3);
        if (rb2.isChecked()) {
            rightAnswer4 = 1;
        }

        rightAnswers = rightAnswer1 + rightAnswer2 + rightAnswer3 + rightAnswer4;
        displayScore(rightAnswers);
    }

    private void displayScore(int totalRightAnswers) {
        CharSequence text = getString(R.string.toast, totalRightAnswers, totalQuestions);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(this, text, duration);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);

        toast.show();
    }
}

