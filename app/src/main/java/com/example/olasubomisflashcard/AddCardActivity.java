package com.example.olasubomisflashcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class AddCardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ImageView cancel_icon = findViewById(R.id.cancel_icon);
        ImageView save_icon = findViewById(R.id.save_icon);
        cancel_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

        findViewById(R.id.save_icon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("OnClickListener", "Saved");
                String input_question = ((EditText) findViewById(R.id.input_question)).getText().toString();
                String input_answer = ((EditText) findViewById(R.id.input_answer)).getText().toString();
                Log.d(input_question.toString(), input_answer.toString());
                Intent data = new Intent();
                data.putExtra("question",input_question);
                data.putExtra("answer",input_answer);
                setResult(RESULT_OK,data);
                finish();

            }
        });
    }
}

