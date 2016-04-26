package com.chenliuliu.mymenu;

import android.graphics.Path;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chenliuliu.mymenu.utils.viewanimation.ViewAnimator;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {
    boolean isOpen = false;

    @Bind(R.id.btn_meun)
    Button mBtnMeun;
    @Bind(R.id.btn_one)
    Button mBtnOne;
    @Bind(R.id.btn_two)
    Button mBtnTwo;
    @Bind(R.id.btn_three)
    Button mBtnThree;
    @Bind(R.id.btn_four)
    Button mBtnFour;
    @Bind(R.id.btn_five)
    Button mBtnFive;
    @Bind(R.id.btn_six)
    Button mBtnSix;
    @Bind(R.id.rl_menu_back)
    RelativeLayout mRlMenuBack;
    @Bind(R.id.btn_shake)
    Button mBtnShake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mBtnMeun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isOpen) {
                    openMenu();
                } else {
                    closeMenu();
                }
            }
        });
        mBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "one", Toast.LENGTH_SHORT).show();
                closeMenu();

            }
        });
        mBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "two", Toast.LENGTH_SHORT).show();
                closeMenu();

            }
        });
        mBtnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "three", Toast.LENGTH_SHORT).show();
                closeMenu();
            }
        });
        mBtnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "four", Toast.LENGTH_SHORT).show();
                closeMenu();

            }
        });
        mBtnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "five", Toast.LENGTH_SHORT).show();
                closeMenu();

            }
        });
        mBtnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "six", Toast.LENGTH_SHORT).show();
                closeMenu();

            }
        });

        Path path = new Path();
        path.moveTo(0, 0);
        path.lineTo(20, 60);
        path.lineTo(90, 200);
        path.lineTo(120, 400);
        path.lineTo(300, 400);
        path.lineTo(400, 400);
        path.lineTo(400, 700);
        path.lineTo(0, 0);


        ViewAnimator.animate(mBtnShake).path(path).duration(6000).repeatCount(-1)
                .start();
        ViewAnimator.animate(findViewById(R.id.btn_wobble)).dp().wobble().width(80, 120).duration(6000).repeatCount(-1)
                .start();


        findViewById(R.id.btn_wobble).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAnimator.animate(v).slideTop().duration(4000).start();

            }
        });


    }

    private void openMenu() {
        isOpen = true;
        ViewAnimator.animate(mBtnOne).dp().translationY(0, -210, -190, -200).duration(600).translationX(0, -110, -90, -100)
                .andAnimate(mBtnTwo).dp().translationY(0, -130, -110, -120).translationX(0, -180, -160, -170)
                .andAnimate(mBtnThree).dp().translationY(0, -130, -110, -120)
                .andAnimate(mBtnFour).dp().translationY(0, -210, -190, -200)
                .andAnimate(mBtnFive).dp().translationX(0, -210, -190, -200)
                .andAnimate(mBtnSix).dp().translationX(0, -110, -90, -100)
                .andAnimate(mBtnMeun).rotation(45)

                .andAnimate(mBtnOne).scale(0.5f, 1)
                .andAnimate(mBtnTwo).scale(0.5f, 1)
                .andAnimate(mBtnThree).scale(0.5f, 1)
                .andAnimate(mBtnFour).scale(0.5f, 1)
                .andAnimate(mBtnFive).scale(0.5f, 1)
                .andAnimate(mBtnSix).scale(0.5f, 1)


                .descelerate().start();
    }

    private void closeMenu() {
        isOpen = false;
        ViewAnimator.animate(mBtnOne).dp().translationY(-200, -220, 0).duration(600).translationX(-100, -120, 0)
                .andAnimate(mBtnTwo).dp().translationY(-120, -130, 0).translationX(-170, -180, 0)
                .andAnimate(mBtnThree).dp().translationY(-120, -140, 0)
                .andAnimate(mBtnFour).dp().translationY(-200, -220, 0)
                .andAnimate(mBtnFive).dp().translationX(-200, -220, 0)
                .andAnimate(mBtnSix).dp().translationX(-100, -110, 0)
                .andAnimate(mBtnMeun).rotation(0).shake()

                .andAnimate(mBtnOne).scale(1, 0.5f)
                .andAnimate(mBtnTwo).scale(1, 0.5f)
                .andAnimate(mBtnThree).scale(1, 0.5f)
                .andAnimate(mBtnFour).scale(1, 0.5f)
                .andAnimate(mBtnFive).scale(1, 0.5f)
                .andAnimate(mBtnSix).scale(1, 0.5f)
                .accelerate().start();
    }

    @Override
    public void onBackPressed() {
        if (isOpen) {
            closeMenu();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                if (isOpen) {
                    closeMenu();
                }
                break;
        }
        return super.onTouchEvent(event);
    }
}
