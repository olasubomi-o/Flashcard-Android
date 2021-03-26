package com.example.olasubomisflashcard;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    FlashcardDatabase flashcardDatabase;
    List <Flashcard> allFlashcards;
    int currentCardDisplayedIndex = 0;
    CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flashcardDatabase = new FlashcardDatabase(this);
        allFlashcards = flashcardDatabase.getAllCards();

        if (allFlashcards != null && allFlashcards.size() > 0) {
            ((TextView) findViewById(R.id.flashcard_question)).setText(allFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.flashcard_answer)).setText(allFlashcards.get(0).getAnswer());
        }


        TextView flashcardQuestion = findViewById(R.id.flashcard_question);
//        TextView flashcardAnswer_1 = findViewById(R.id.answer_1);
//        TextView flashcardAnswer_2 = findViewById(R.id.answer_2);
        TextView flashcard_answer = findViewById(R.id.flashcard_answer);
        ImageView no_eye = findViewById(R.id.toggle_visibility_no);
        ImageView eye = findViewById(R.id.toggle_visibility);


//        findViewById(R.id.answer_3).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.green));
//            }
//
//        });
//        findViewById(R.id.answer_2).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                flashcardAnswer_2.setBackgroundColor(getResources().getColor(R.color.red));
//                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.green));
//
//            }
//
//        });
//        findViewById(R.id.answer_1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                flashcardAnswer_1.setBackgroundColor(getResources().getColor(R.color.red));
//                findViewById(R.id.answer_3).setBackgroundColor(getResources().getColor(R.color.green));
//            }


       // });
        eye.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_6);
                eye.setVisibility(View.INVISIBLE);
                no_eye.setVisibility(View.VISIBLE);
//                flashcardAnswer_1.setVisibility(View.VISIBLE);
//                flashcardAnswer_2.setVisibility(View.VISIBLE);
       //         findViewById(R.id.answer_3).setVisibility(View.VISIBLE);
            }
        });
        findViewById(R.id.toggle_visibility_no).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_no);
                eye.setImageResource(R.drawable.ic_iconmonstr_eye_6);
                eye.setVisibility(View.VISIBLE);
                no_eye.setVisibility(View.INVISIBLE);
//                flashcardAnswer_1.setVisibility(View.INVISIBLE);
//                flashcardAnswer_2.setVisibility(View.INVISIBLE);
      //          findViewById(R.id.answer_3).setVisibility(View.INVISIBLE);
            }
        });

        findViewById(R.id.flashcard_question).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.VISIBLE);

                View answerSideView = findViewById(R.id.flashcard_answer);
                View questionSideView = findViewById(R.id.flashcard_question);
                int cx = answerSideView.getWidth() / 2;
                int cy = answerSideView.getHeight() / 2;

                // get the final radius for the clipping circle
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(answerSideView, cx, cy, 0f, finalRadius);

                // hide the question and show the answer to prepare for playing the animation!
                questionSideView.setVisibility(View.INVISIBLE);
                answerSideView.setVisibility(View.VISIBLE);

                anim.setDuration(1000);
                anim.start();
            }

        });
        findViewById(R.id.flashcard_answer).setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                findViewById(R.id.flashcard_question).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcard_answer).setVisibility(View.INVISIBLE);
                View answerSideView = findViewById(R.id.flashcard_answer);
                View questionSideView = findViewById(R.id.flashcard_question);
                int cx = answerSideView.getWidth() / 2;
                int cy = answerSideView.getHeight() / 2;

                // get the final radius for the clipping circle
                float finalRadius = (float) Math.hypot(cx, cy);

                // create the animator for this view (the start radius is zero)
                Animator anim = ViewAnimationUtils.createCircularReveal(questionSideView, cx, cy, 0f, finalRadius);

                // hide the question and show the answer to prepare for playing the animation!
                questionSideView.setVisibility(View.VISIBLE);
                answerSideView.setVisibility(View.INVISIBLE);

                anim.setDuration(1000);
                anim.start();
            }

        });



        findViewById(R.id.add_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent,100);
                startActivity(intent);
                overridePendingTransition(R.anim.right_in,R.anim.left_out);
                findViewById(R.id.add_icon).setVisibility(View.INVISIBLE);

            }
        });

        findViewById(R.id.next_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(allFlashcards.size()==0)
                    return;
                currentCardDisplayedIndex++;

                Log.i("click", "Next slide");
                //Implement snackbar

                Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);
           ((TextView) findViewById(R.id.flashcard_question)).setText(flashcard.getQuestion());
              ((TextView) findViewById(R.id.flashcard_answer)).setText(flashcard.getAnswer());

                final Animation leftOutAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.left_out);
                final Animation rightInAnim = AnimationUtils.loadAnimation(v.getContext(), R.anim.right_in);

                leftOutAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        // this method is called when the animation first starts
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        // this method is called when the animation is finished playing
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        // we don't need to worry about this method
                    }
                });

                findViewById(R.id.flashcard_question).startAnimation(rightInAnim);

            }

        });

        countDownTimer = new CountDownTimer(16000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                ((TextView) findViewById(R.id.timer)).setText("" + millisUntilFinished/1000);


            }

            @Override
            public void onFinish() {

            }
        };


    }
    private void startTimer(){
        countDownTimer.cancel();
        countDownTimer.start();
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
            flashcardDatabase.insertCard(new Flashcard(question,answer));
            allFlashcards = flashcardDatabase.getAllCards();

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
//            findViewById(R.id.answer_1).setVisibility(View.INVISIBLE);
//            findViewById(R.id.answer_2).setVisibility(View.INVISIBLE);
//            findViewById(R.id.answer_3).setVisibility(View.INVISIBLE);

            findViewById(R.id.next_arrow).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if(allFlashcards.size()==0)
                        return;
                    currentCardDisplayedIndex++;

                    Log.i("click", "Next slide");
                    //Implement snackbar

                    Flashcard flashcard = allFlashcards.get(currentCardDisplayedIndex);
                    ((TextView) findViewById(R.id.flashcard_question)).setText(flashcard.getQuestion());
                    ((TextView) findViewById(R.id.flashcard_answer)).setText(flashcard.getAnswer());

                }

            });



        }
    }

}



