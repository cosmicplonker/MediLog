package com.jengmedia.medilog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jengmedia.medilog.database.DatabaseHandler;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tValue = findViewById(R.id.tValue);


        Button tButton = findViewById(R.id.tButton);

        tButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHandler db = new DatabaseHandler(view.getContext());
                db.insertTimestamp(Calendar.getInstance().getTime().toString());

                tValue.setText(db.getStamps());
            }
        });
    }
}
