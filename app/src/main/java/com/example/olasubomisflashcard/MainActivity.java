package com.example.olasubomisflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView flashcardQuestion = findViewById(R.id.flashcard_question);
        TextView flashcardAnswer_1 = findViewById(R.id.answer_1);
        TextView flashcardAnswer_2 = findViewById(R.id.answer_2);
        TextView flashcardAnswer_3 = findViewById(R.id.answer_3);
        TextView flashcard_answer = findViewById(R.id.flashcard_answer);
        ImageView no_eye= findViewById(R.id.toggle_visibility_no);
        ImageView eye= findViewById(R.id.toggle_visibility);
        flashcardAnswer_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flashcardAnswer_3.setBackgroundColor(getResources().getColor(R.color.green));
            }

        });
        flashcardAnswer_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flashcardAnswer_2.setBackgroundColor(getResources().getColor(R.color.red));
                flashcardAnswer_3.setBackgroundColor(getResources().getColor(R.color.green));

            }

        });
        flashcardAnswer_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flashcardAnswer_1.setBackgroundColor(getResources().getColor(R.color.red));
                flashcardAnswer_3.setBackgroundColor(getResources().getColor(R.color.green));
            }



        });
        eye.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_6);
                eye.setVisibility(View.INVISIBLE);
                no_eye.setVisibility(View.VISIBLE);
                flashcardAnswer_1.setVisibility(View.VISIBLE);
                flashcardAnswer_2.setVisibility(View.VISIBLE);
                flashcardAnswer_3.setVisibility(View.VISIBLE);
            }
        });
        no_eye.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_no);
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_6);
                eye.setVisibility(View.VISIBLE);
                no_eye.setVisibility(View.INVISIBLE);
                flashcardAnswer_1.setVisibility(View.INVISIBLE);
                flashcardAnswer_2.setVisibility(View.INVISIBLE);
                flashcardAnswer_3.setVisibility(View.INVISIBLE);
            }
        });

            flashcardQuestion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flashcardQuestion.setVisibility(View.INVISIBLE);
                    flashcard_answer.setVisibility(View.VISIBLE);
                }

            });
            flashcard_answer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    flashcardQuestion.setVisibility(View.VISIBLE);
                    flashcard_answer.setVisibility(View.INVISIBLE);
                }

            });


        }
    }
