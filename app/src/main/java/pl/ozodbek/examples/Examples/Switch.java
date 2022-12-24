package pl.ozodbek.examples.Examples;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.LinearProgressIndicator;

import pl.ozodbek.examples.R;

public class Switch extends AppCompatActivity {

    private ProgressBar progressBar;
    private LinearProgressIndicator linearProgressIndicator;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        progressBar = findViewById(R.id.progress);
        linearProgressIndicator = findViewById(R.id.linearProgress);

        progressBar.setIndeterminate(false);
        progressBar.setMax(200);
        linearProgressIndicator.setMax(200);

        thread = new Thread(runnable);
        thread.start();

    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            runOnUiThread(() -> {
                progressBar.setProgress(progressBar.getProgress() + 5);
                linearProgressIndicator.setProgress(linearProgressIndicator.getProgress() + 5);
            });
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            thread = new Thread(this);
            thread.start();
        }
    };
}