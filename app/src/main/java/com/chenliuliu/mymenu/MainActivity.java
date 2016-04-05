package com.chenliuliu.mymenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    }

    private void openMenu() {
        isOpen = true;
        ViewAnimator.animate(mBtnOne).dp().translationY(0, -210,-190, -200).duration(600).translationX(0, -110, -90,-100)
                .andAnimate(mBtnTwo).dp().translationY(0, -110,-90 ,-100).translationX(0, -160,-140, -150)
                .andAnimate(mBtnThree).dp().translationY(0, -110, -90,-100)
                .andAnimate(mBtnFour).dp().translationY(0, -210,-190, -200)
                .andAnimate(mBtnFive).dp().translationX(0, -210,-190, -200)
                .andAnimate(mBtnMeun).rotation(45)
                .thenAnimate(mBtnOne, mBtnTwo, mBtnThree, mBtnFour, mBtnFive).tada().wave()
                .descelerate().start();
    }

    private void closeMenu() {
        isOpen = false;
        ViewAnimator.animate(mBtnOne).dp().translationY(-200, -210, 0).duration(600).translationX(-100, -110, 0)
                .andAnimate(mBtnTwo).dp().translationY(-100, -110, 0).translationX(-150, -160, 0)
                .andAnimate(mBtnThree).dp().translationY(-100, -110, 0)
                .andAnimate(mBtnFour).dp().translationY(-200, -210, 0)
                .andAnimate(mBtnFive).dp().translationX(-200, -210, 0)
                .andAnimate(mBtnMeun).rotation(0).shake()
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
}
