package pl.ozodbek.examples.Examples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import pl.ozodbek.examples.R;

public class example extends AppCompatActivity implements Animation.AnimationListener, View.OnClickListener {
    private ImageView change_image1,change_image2;
    private Boolean a = false, b = false;
    private List<ImageView> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        findID();
        change_image1.setOnClickListener(this);
        change_image2.setOnClickListener(this);

        list = new ArrayList<>();
        list.add(change_image1);
        list.add(change_image2);


    }


    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (list.size() == 2) {
            if (list.get(0).getTag() == list.get(1).getTag()) {
                list.get(0).setVisibility(View.INVISIBLE);
                list.get(1).setVisibility(View.INVISIBLE);
            } else {
                Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.game_scale2);
                if (a) {
                    change_image1.setImageResource(R.drawable.uzb_flag);
                    change_image1.setAnimation(animation1);
                    list.add(change_image1);
                    a = false;
                } else if (b) {
                    change_image2.setImageResource(R.drawable.uzb_flag);
                    change_image2.setAnimation(animation1);
                    list.add(change_image2);
                    b = false;
                }
                animation1.setAnimationListener(this);
            }
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.game_scale1);
        switch (v.getId()) {
            case R.id.change_image1:
                change_image1.startAnimation(animation);
                animation.setAnimationListener(this);
                a = true;
                break;
            case R.id.change_image2:
                change_image2.startAnimation(animation);
                animation.setAnimationListener(this);
                b = true;
                break;
        }
    }

    private void findID() {
        change_image1 = findViewById(R.id.change_image1);
        change_image2 = findViewById(R.id.change_image2);

    }
}
