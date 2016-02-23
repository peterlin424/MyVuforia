//package com.example.peter.myvuforia.Activity;
//
//import android.content.pm.ActivityInfo;
//import android.os.Bundle;
//
//import com.example.peter.myvuforia.Unit.TestRenderer;
//
//import org.rajawali3d.util.RajLog;
//import org.rajawali3d.vuforia.RajawaliVuforiaActivity;
//
//public class TestActivity extends RajawaliVuforiaActivity {
//
//    private TestRenderer mRenderer;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setScreenOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//        startVuforia();
//    }
//
//    @Override
//    protected void setupTracker() {
//        int result = initTracker(TRACKER_TYPE_MARKER);
//        if (result == 1) {
//            result = initTracker(TRACKER_TYPE_IMAGE);
//            if (result == 1) {
//                super.setupTracker();
//            } else {
//                RajLog.e("Couldn't initialize image tracker.");
//            }
//        } else {
//            RajLog.e("Couldn't initialize marker tracker.");
//        }
//    }
//
//    @Override
//    protected void initApplicationAR() {
//        super.initApplicationAR();
//
////        createFrameMarker(0, "Marker0", 250, 250);
//
//        createImageMarker("Watch.xml");
//
//        // -- this is how you add a cylinder target:
//        // https://developer.vuforia.com/resources/dev-guide/cylinder-targets
//        // createImageMarker("sodacan.xml");
//
//        // -- this is how you add a multi-target:
//        // https://developer.vuforia.com/resources/dev-guide/multi-targets
//        // createImageMarker("MyMultiTarget.xml");
//    }
//
//    @Override
//    protected void initRajawali() {
//        super.initRajawali();
//        mRenderer = new TestRenderer(this);
////        mRenderer.setSurfaceView(mSurfaceView);
//        super.setRenderer(mRenderer);
///*
//		ToggleButton extendedTrackingButton = new ToggleButton(this);
//		extendedTrackingButton.setTextOn("Extended Tracking On");
//		extendedTrackingButton.setTextOff("Extended Tracking Off");
//		extendedTrackingButton.setChecked(false);
//		extendedTrackingButton.setOnClickListener(new View.OnClickListener() {
//			public void onClick(View v) {
//				if (((ToggleButton) v).isChecked()) {
//					if (!startExtendedTracking())
//						RajLog.e("Could not start extended tracking");
//				} else {
//					if (!stopExtendedTracking())
//						RajLog.e("Could not stop extended tracking");
//				}
//			}
//		});
//
//		mUILayout = this;
//		LinearLayout ll = new LinearLayout(this);
//		ll.addView(extendedTrackingButton);
//		mUILayout.addContentView(ll, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
//*/
//    }
//}
