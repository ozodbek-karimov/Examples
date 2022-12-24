package pl.ozodbek.examples.QUIZ;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import pl.ozodbek.examples.R;
import pl.ozodbek.examples.Singleton.MyGson;
import pl.ozodbek.examples.Singleton.MySharedPreferences;
import pl.ozodbek.examples.UserData;

public class SignIn extends AppCompatActivity {
    private Button signin, signup;
    private EditText name, age;
    private TextView welcome;
    private MySharedPreferences mySharedPreferences;

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        findId();

        mySharedPreferences = MySharedPreferences.getInstance(this);

        signin.setOnClickListener(v -> {
            String usersJsonString = mySharedPreferences.getUsers();
            if (usersJsonString.equals("")) {
                Toast.makeText(this, "List shouldn't be empty !", Toast.LENGTH_SHORT).show();
            } else {
                Type type = new TypeToken<List<UserData>>() {
                }.getType();
                List<UserData> userList = MyGson.getInstance().getGson().fromJson(usersJsonString, type);
                String fullName = name.getText().toString();
                String password = age.getText().toString();
                boolean isHave = false;
                for (UserData userData : userList) {
                    if (userData.getFullName().equals(fullName) && userData.getPassword().equals(password)) {
                        isHave = true;
                        break;
                    }
                }
                if (isHave) {
                    String s = name.getText().toString();
                    Intent intent = new Intent(SignIn.this, Quiz.class);
                    ParcelableVersion parcelableVersion = new ParcelableVersion(s);
                    intent.putExtra("exported_data", parcelableVersion);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Please enter Full name and password !!", Toast.LENGTH_SHORT).show();
                }

            }
        });

        signup.setOnClickListener(v -> {
            Intent intent = new Intent(SignIn.this, SignUp.class);
            someActivityResultLauncher.launch(intent);
        });

    }

    ActivityResultLauncher<Intent> someActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String fullName = data.getStringExtra("fullName");
                        String password = data.getStringExtra("password");
                        String wel = data.getStringExtra("Welcome");
                        name.setText(fullName);
                        age.setText(password);
                        welcome.setText(wel);
                    }
                }
            });


    private void findId() {
        signin = findViewById(R.id.signin);
        signup = findViewById(R.id.signup);
        name = findViewById(R.id.name);
        age = findViewById(R.id.age);
        welcome = findViewById(R.id.welcome);
    }
}

 /*private void saveAndRead() {
        save.setOnClickListener(v -> {
            String getSavedName = name.getText().toString();
            String getSavedSureName = age.getText().toString();
            editor.putString("Exported_name", getSavedName);
            editor.putString("Exported_sureName", getSavedSureName);
            editor.commit();
            Toast.makeText(this, "Your data's has been saved", Toast.LENGTH_SHORT).show();

        });*/

       /* read.setOnClickListener(v -> {
            String received_name = sharedPreferences.getString("Exported_name", "");
            String received_age = sharedPreferences.getString("Exported_sureName", "");
            show.setText("Saved name: " + received_name + "\n" + "Saved age: " + received_age);
            Toast.makeText(this, "Your data's has been read", Toast.LENGTH_SHORT).show();
            show.setVisibility(View.VISIBLE);

            show.setOnClickListener(v1 -> show.setVisibility(View.INVISIBLE));
        });*/
