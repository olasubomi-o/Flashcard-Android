package com.example.olasubomisflashcard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
                Intent intent = new Intent(AddCardActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

        save_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((EditText) findViewById(R.id.input_question)).getText().toString();
                Intent data = new Intent();
                data.putExtra("string1","some string");
                data.putExtra("string2", "another string");
                setResult(RESULT_OK,data);
                finish();

            }
        });
    }
}

