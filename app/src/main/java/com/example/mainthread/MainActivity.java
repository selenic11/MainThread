package com.example.mainthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button startInMainThread, startInAnotherThread;

    ProgressBar progressBar;

    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startInMainThread = findViewById(R.id.start1);
        startInAnotherThread = findViewById(R.id.start2);
        progressBar = findViewById(R.id.progress_b);
        text = findViewById(R.id.text);

        startInMainThread.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Я начал работу в главном потоке!", Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(1000 * 10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Toast.makeText(MainActivity.this, "Я закончил работу в главном потоке!", Toast.LENGTH_SHORT).show();
        });

        startInAnotherThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //запуск в новом потоке

            }
        });


        class LoadImage extends AsyncTask<Void, Void, Void> {
            @Override
            protected void onPreExecute() {
                Toast.makeText(MainActivity.this, "Я начал выполняться!", Toast.LENGTH_SHORT).show();
                super.onPreExecute();
            }

            @Override
            protected Void doInBackground(Void... voids) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void unused) {
                Toast.makeText(MainActivity.this, "Я закончил выполняться!", Toast.LENGTH_SHORT).show();

                super.onPostExecute(unused);
            }
        }




    }
}