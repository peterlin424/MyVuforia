package com.example.peter.myvuforia.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.peter.myvuforia.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt_start_ar = (Button) findViewById(R.id.bt_start_ar);
        Button bt_start_3d = (Button) findViewById(R.id.bt_start_3d);
        Button bt_start_mix = (Button) findViewById(R.id.bt_start_mix);
        bt_start_ar.setOnClickListener(this);
        bt_start_3d.setOnClickListener(this);
        bt_start_mix.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_start_ar:
                startActivity(new Intent(this, VuforiaActivity.class));
                break;
            case R.id.bt_start_3d:
                startActivity(new Intent(this, RajawaliActivity.class));
                break;
            case R.id.bt_start_mix:
                startActivity(new Intent(this, MixAR_Activity.class));
                break;
        }
    }
}
