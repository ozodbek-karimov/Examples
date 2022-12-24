package pl.ozodbek.examples.Examples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import pl.ozodbek.examples.R;

public class Scroll extends AppCompatActivity {
    private CardView card1, card2, card3, card4;
    private ConstraintLayout layout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        layout = findViewById(R.id.layout);
        registerForContextMenu(card1);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.my_menues, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }




    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.france:
                Toast.makeText(this, "France", Toast.LENGTH_SHORT).show();
                break;
            case R.id.open:
                Toast.makeText(this, "open", Toast.LENGTH_SHORT).show();
                break;
            case R.id.save:
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menues, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.france:
                Toast.makeText(this, "France", Toast.LENGTH_SHORT).show();
                break;
            case R.id.open:
                Toast.makeText(this, "open", Toast.LENGTH_SHORT).show();
                break;
            case R.id.save:
                Toast.makeText(this, "save", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}