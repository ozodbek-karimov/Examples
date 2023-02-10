package pl.ozodbek.examples.Examples;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import pl.ozodbek.examples.databinding.ActivitySwitchBinding;

public class Switch extends AppCompatActivity {


    private ActivitySwitchBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Boolean isChecked1;
    private Boolean isChecked2;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivitySwitchBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        binding.incr.setOnClickListener(v ->{
            count+=1;
            binding.incr.setText("" + count);
        });

        retriveData();
    }

    @SuppressLint("SetTextI18n")
    private void retriveData() {
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        String name = sharedPreferences.getString("name", null);
        String surename = sharedPreferences.getString("surename", null);
        String message = sharedPreferences.getString("message", null);
        String incr = sharedPreferences.getString("incr", null);
        isChecked1 = sharedPreferences.getBoolean("male", false);
        isChecked2 = sharedPreferences.getBoolean("female", false);


        if (binding.male.isChecked()) {
            binding.male.setChecked(true);
        } else {
            binding.male.setChecked(false);
        }
        if (binding.male.isChecked()) {
            binding.female.setChecked(true);
        } else {
            binding.female.setChecked(false);
        }

        binding.tv.setText(
                         "Name: " + name +
                        "\nSurename: " + surename +
                        "\nMessage: " + message +
                        "\n Increment: " + incr +
                        "\nMale: " + isChecked1 +
                        "\nFemale: " + isChecked2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();
    }

    private void saveData() {
        sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        String name = binding.name.getText().toString();
        String surename = binding.surename.getText().toString();
        String message = binding.message.getText().toString();
        String incr = binding.incr.getText().toString();

        if (binding.male.isChecked()) {
            isChecked1 = true;
        } else {
            isChecked1 = false;
        }
        if (binding.male.isChecked()) {
            isChecked2 = true;
        } else {
            isChecked2 = false;
        }

        editor.putString("name", name);
        editor.putString("surename", surename);
        editor.putString("message", message);
        editor.putString("incr", incr);
        editor.putBoolean("male", isChecked1);
        editor.putBoolean("female", isChecked2);
        editor.apply();

    }
}
