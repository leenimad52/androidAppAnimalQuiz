package com.xyz.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import model.Animal;
import model.animalDa;
import model.animalFactory;
import model.mokupDB;

public class MainActivity extends AppCompatActivity {
    int[] images = {R.drawable.panda, R.drawable.fish, R.drawable.octopus, R.drawable.tiger, R.drawable.monkey,
            R.drawable.frog, R.drawable.birds, R.drawable.fish, R.drawable.dogtail, R.drawable.fins};
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private ImageView img;
    private int current;
    private Button btnNext;
    private TextView numOfQ;
    private TextView question;
    private TextView result;
    private TextView score;

    animalFactory factory = new animalFactory();
    animalDa objAnimal = factory.getModel();


    //////////////////////////////////////////////////////////////////////////////////////////////////
    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonClick();
        radioOnclick();
        btnNext = findViewById(R.id.btnNext);
        numOfQ = findViewById(R.id.numOfQ);
        question = findViewById(R.id.question);
        result = findViewById(R.id.result);
        score = findViewById(R.id.score);
        radioButton1 = findViewById(R.id.op1);
        radioButton2 = findViewById(R.id.op2);
        radioButton3 = findViewById(R.id.op3);
        radioButton4 = findViewById(R.id.op4);
    }

    ///////////////////////////////////////////////////////////////////////////
    private void buttonClick() {
        img = (ImageView) findViewById(R.id.firstImg);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View f) {
                        if (!(numOfQ.getText().equals("Q10"))) {
                            current++;
                            current = current % images.length;
                            img.setImageResource(images[current]);
                            getRightAnswer(numOfQ.getText().toString().trim());
                            getOptions();
                            getNextQuestion();
                            getNextNumOfQ();
                            getNextAnswer();
                            result.setText("");
                            radioButton1.setEnabled(true);
                            radioButton2.setEnabled(true);
                            radioButton3.setEnabled(true);
                            radioButton4.setEnabled(true);
                            ///
                            radioButton1.setChecked(false);
                            radioButton2.setChecked(false);
                            radioButton3.setChecked(false);
                            radioButton4.setChecked(false);
                        } else {
                            btnNext.setEnabled(false);
                            Toast.makeText(MainActivity.this, "No more questions", Toast.LENGTH_SHORT).show();
                        }
                    }//////

                }
        ); //
    }

    ////////////////////////////////////////////////////////////////////////////
    private void radioOnclick() {
        radioButton1 = (RadioButton) findViewById(R.id.op1);
        radioButton2 = (RadioButton) findViewById(R.id.op2);
        radioButton3 = (RadioButton) findViewById(R.id.op3);
        radioButton4 = (RadioButton) findViewById(R.id.op4);
        radioButton1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View f) {
                        radioButton2.setEnabled(false);
                        radioButton3.setEnabled(false);
                        radioButton4.setEnabled(false);
                        getRightAnswerOf(radioButton1.getText().toString());
                        btnNext.setEnabled(true);

                    }
                }
        );//
        radioButton2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View f) {
                        radioButton1.setEnabled(false);
                        radioButton3.setEnabled(false);
                        radioButton4.setEnabled(false);
                        getRightAnswerOf(radioButton2.getText().toString());
                        btnNext.setEnabled(true);

                    }
                }
        );//
        radioButton3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View f) {
                        radioButton1.setEnabled(false);
                        radioButton2.setEnabled(false);
                        radioButton4.setEnabled(false);
                        getRightAnswerOf(radioButton3.getText().toString());
                        btnNext.setEnabled(true);

                    }
                }
        );
        radioButton4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View f) {
                        radioButton1.setEnabled(false);
                        radioButton2.setEnabled(false);
                        radioButton3.setEnabled(false);
                        getRightAnswerOf(radioButton4.getText().toString());
                        btnNext.setEnabled(true);

                    }
                }
        );
    }

    ////////////////////////////////////////////////////////////////////////////
    public void getRightAnswer(String question) {
        System.out.println("right answer: " + numOfQ.getText().toString() + objAnimal.getRightAnswer(numOfQ.getText().toString()));

    }

    ////////////////////////////////////////
    int currentQuestionIndex = 1;

    public void getOptions() {

        String[] OptionsByQuestionNo = objAnimal.getNextOptions(currentQuestionIndex);
        if (currentQuestionIndex < objAnimal.getAnimalListSize()) {

            for (String s : OptionsByQuestionNo) {
                radioButton1.setText(OptionsByQuestionNo[0].toString());
                radioButton2.setText(OptionsByQuestionNo[1].toString());
                radioButton3.setText(OptionsByQuestionNo[2].toString());
                radioButton4.setText(OptionsByQuestionNo[3].toString());
            }
            currentQuestionIndex++;
        } else {
            Toast.makeText(MainActivity.this, "No more questions", Toast.LENGTH_SHORT).show();
        }
    }

    public void getNextQuestion() {
        question.setText(objAnimal.getNextQuestion());
    }

    public void getNextNumOfQ() {
        numOfQ.setText(objAnimal.getNextNumOfQ());
    }

    public void getNextAnswer() {
    }

    int score1=0;
    public void getRightAnswerOf(String ans) {
        if (ans.equals(objAnimal.getRightAnswer(numOfQ.getText().toString()))) {
            result.setText("True");
            result.setTextColor(Color.GREEN);
            score1++;
            score.setText("Score: "+score1+"\\10");
        } else {
            result.setText("False");
            score.setText("Score: "+score1+"\\10");
            result.setTextColor(Color.RED);

        }
    }



}

