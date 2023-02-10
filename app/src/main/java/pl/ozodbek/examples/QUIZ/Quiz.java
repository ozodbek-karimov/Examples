package pl.ozodbek.examples.Quiz;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import pl.ozodbek.examples.Parcelable.ParcelableVersion;
import pl.ozodbek.examples.Quiz.Questions;
import pl.ozodbek.examples.R;

public class Quiz extends AppCompatActivity {


    private List<Questions> list;
    private int index = 0;
    private TextView name;

    private RadioGroup radioGroup;
    private RadioButton variant1, variant2, variant3, variant4;
    private Button submit_btn,contact,web;
    private TextView question_tv;
    private String myAnswer;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        findId();
        loadData();
        setQuestions();
        implicitIntent();
        parcelable();






        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId != -1) {
                myAnswer = ((RadioButton) findViewById(checkedId)).getText().toString();
            }
        });

        submit_btn.setOnClickListener(v -> {
            if (myAnswer == null) {
                Toast.makeText(this, "Javob belgilanmagan !!", Toast.LENGTH_SHORT).show();
            } else {
                if (myAnswer.equals(list.get(index).getAnswer())) {
                    Toast.makeText(this, "Javob to'gri", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Javob Noto'gri", Toast.LENGTH_SHORT).show();

                }
            }

            if (index < list.size() - 1) {
                radioGroup.clearCheck();
                index++;
                setQuestions();
            } else {
                Toast.makeText(this, "Savollar tugadi !!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void parcelable() {
        Intent intent = getIntent();
        ParcelableVersion parcelableVersion = intent.getParcelableExtra("exported_data");
        String names = parcelableVersion.getName();
        name.setText(names + " is playing !😃");
    }

    private void implicitIntent() {
        web.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com")));
        });

        contact.setOnClickListener(v -> {
            startActivity(new Intent(Intent.ACTION_DIAL,Uri.parse("tel:579101372")));
        });
    }

    private void setQuestions() {
        Questions questions = list.get(index);
        question_tv.setText(questions.getQuestion());
        variant1.setText(questions.getVariant1());
        variant2.setText(questions.getVariant2());
        variant3.setText(questions.getVariant3());
        variant4.setText(questions.getVariant4());
        myAnswer = null;
    }

    private void loadData() {
        list = new ArrayList<>();
        list.add(new Questions("Strive Jobs kim ? ", "Usta", "CEO", "Coder", "Tester", "CEO"));
        list.add(new Questions("Asadbek akasi kim ? ", "FullStack", "Web", "Yusta", "Usta", "FullStack"));
        list.add(new Questions("Jahangir akasi kim ? ", "Androidchi", "Kotlin", "Motlin", "Dotlin", "Androidchi"));
    }

    private void findId() {
        radioGroup = findViewById(R.id.radio_group);
        submit_btn = findViewById(R.id.submit_btn);
        variant1 = findViewById(R.id.variant1);
        variant2 = findViewById(R.id.variant2);
        variant3 = findViewById(R.id.variant3);
        variant4 = findViewById(R.id.variant4);
        question_tv = findViewById(R.id.question_tv);
        name = findViewById(R.id.name);
        contact = findViewById(R.id.contact);
        web = findViewById(R.id.web);

    }
}