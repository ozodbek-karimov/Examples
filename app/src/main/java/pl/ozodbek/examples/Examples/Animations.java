package pl.ozodbek.examples.Examples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import pl.ozodbek.examples.R;

public class Animations extends AppCompatActivity {
private Button alpha_button,scale_button,translate_button,rotate_button,combined_button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
        alpha_button = findViewById(R.id.alpha_button);
        scale_button = findViewById(R.id.scale_button);
        translate_button = findViewById(R.id.translate_button);
        rotate_button = findViewById(R.id.rotate_button);
        combined_button = findViewById(R.id.combined_button);

        Animation alphaAnimation =  AnimationUtils.loadAnimation(this,R.anim.alpha_animation);
        alpha_button.startAnimation(alphaAnimation);

        Animation scaleAnimation = AnimationUtils.loadAnimation(this,R.anim.scale_animation);
        scale_button.startAnimation(scaleAnimation);

        Animation translateAnimation = AnimationUtils.loadAnimation(this,R.anim.translate_animation);
        translate_button.startAnimation(translateAnimation);

        Animation rotateAnimation = AnimationUtils.loadAnimation(this,R.anim.rotate_animation);
        rotate_button.startAnimation(rotateAnimation);


        combined_button.startAnimation(AnimationUtils.loadAnimation(this,R.anim.combined_animation));

        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}