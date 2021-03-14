package com.example.olasubomisflashcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
        TextView flashcard_answer = findViewById(R.id.flashcard_answer);
        ImageView no_eye = findViewById(R.id.toggle_visibility_no);
        ImageView eye = findViewById(R.id.toggle_visibility);


        findViewById(R.id.answer_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.green));
            }

        });
        findViewById(R.id.answer_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flashcardAnswer_2.setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.green));

            }

        });
        findViewById(R.id.answer_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                flashcardAnswer_1.setBackgroundColor(getResources().getColor(R.color.red));
                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.green));
            }


        });
        eye.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_6);
                eye.setVisibility(View.INVISIBLE);
                no_eye.setVisibility(View.VISIBLE);
                flashcardAnswer_1.setVisibility(View.VISIBLE);
                flashcardAnswer_2.setVisibility(View.VISIBLE);
                findViewById(R.id.answer_3).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.toggle_visibility_no).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_no);
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_6);
                eye.setVisibility(View.VISIBLE);
                no_eye.setVisibility(View.INVISIBLE);
                flashcardAnswer_1.setVisibility(View.INVISIBLE);
                flashcardAnswer_2.setVisibility(View.INVISIBLE);
                findViewById(R.id.answer_3).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
            }

        });
        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
            }

        });

        findViewById(R.id.add_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent,100);
                findViewById(R.id.add_icon).setVisibility(View.INVISIBLE);

            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setContentView(R.layout.activity_main);
        if (requestCode == 100 && resultCode==RESULT_OK) {
            String question = data.getExtras().getString("question");
            String answer = data.getExtras().getString("answer");
            Log.d(question, answer);
            ((TextView) findViewById(R.id.flashcard_question)).setText(question);
            ((TextView) findViewById(R.id.flashcard_answer)).setText(answer);

            findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                    findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);
                }
            });
            findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                    findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                }
            });
            findViewById(R.id.answer_1).setVisibility(View.INVISIBLE);
            findViewById(R.id.answer_2).setVisibility(View.INVISIBLE);
            findViewById(R.id.answer_3).setVisibility(View.INVISIBLE);

        }
    }

}



