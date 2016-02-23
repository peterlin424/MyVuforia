package com.example.peter.myvuforia.Unit;

import android.os.Handler;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.qualcomm.vuforia.CameraDevice;

/**
 * Created by Peter on 16/1/29.
 */
public class GestureListener extends GestureDetector.SimpleOnGestureListener {
    // Used to set autofocus one second after a manual focus is triggered
    private final Handler autofocusHandler = new Handler();

    @Override
    public boolean onDown(MotionEvent e)
    {
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {
        // Generates a Handler to trigger autofocus
        // after 1 second
        autofocusHandler.postDelayed(new Runnable()
        {
            public void run()
            {
                boolean result = CameraDevice.getInstance().setFocusMode(
                        CameraDevice.FOCUS_MODE.FOCUS_MODE_TRIGGERAUTO);

                if (!result)
                    Log.e("SingleTapUp", "Unable to trigger focus");
            }
        }, 1000L);

        return true;
    }
}
