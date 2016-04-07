package com.example.peter.myvuforia.Unit;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

import com.example.peter.myvuforia.Activity.MixAR_Activity;
import com.example.peter.myvuforia.SampleApplication.SampleApplicationSession;
import com.example.peter.myvuforia.SampleApplication.utils.LoadingDialogHandler;
import com.example.peter.myvuforia.SampleApplication.utils.SampleUtils;
import com.qualcomm.vuforia.Matrix44F;
import com.qualcomm.vuforia.Renderer;
import com.qualcomm.vuforia.State;
import com.qualcomm.vuforia.Tool;
import com.qualcomm.vuforia.Trackable;
import com.qualcomm.vuforia.TrackableResult;
import com.qualcomm.vuforia.VIDEO_BACKGROUND_REFLECTION;
import com.qualcomm.vuforia.Vuforia;

import java.util.Vector;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Peter on 16/1/29.
 */
public class Mix_Vuforia_Render implements GLSurfaceView.Renderer {

    private static final String LOGTAG = "ImageTargetRenderer";

    private SampleApplicationSession vuforiaAppSession;
    private MixAR_Activity mActivity;

    private Vector<com.example.peter.myvuforia.SampleApplication.utils.Texture> mTextures;

    private Renderer mRenderer;

    public boolean mIsActive = false;

    // TODO 顯示模型放大倍數
    private static final float OBJECT_SCALE_FLOAT = 0.5f;

    public Mix_Vuforia_Render(MixAR_Activity activity,
                              SampleApplicationSession session)
    {
        mActivity = activity;
        vuforiaAppSession = session;
    }

    /**
     * GLSurfaceView.Renderer method
     * */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        Log.d(LOGTAG, "GLRenderer.onSurfaceCreated");

        initRendering();

        // Call Vuforia function to (re)initialize rendering after first use
        // or after OpenGL ES context was lost (e.g. after onPause/onResume):
        vuforiaAppSession.onSurfaceCreated();
    }

    // Function for initializing the renderer.
    private void initRendering()
    {

        mRenderer = Renderer.getInstance();

        GLES20.glClearColor(0.0f, 0.0f, 0.0f, Vuforia.requiresAlpha() ? 0.0f
                : 1.0f);

        for (com.example.peter.myvuforia.SampleApplication.utils.Texture t : mTextures)
        {
            GLES20.glGenTextures(1, t.mTextureID, 0);
            GLES20.glBindTexture(GLES20.GL_TEXTURE_2D, t.mTextureID[0]);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,
                    GLES20.GL_TEXTURE_MIN_FILTER, GLES20.GL_LINEAR);
            GLES20.glTexParameterf(GLES20.GL_TEXTURE_2D,
                    GLES20.GL_TEXTURE_MAG_FILTER, GLES20.GL_LINEAR);
            GLES20.glTexImage2D(GLES20.GL_TEXTURE_2D, 0, GLES20.GL_RGBA,
                    t.mWidth, t.mHeight, 0, GLES20.GL_RGBA,
                    GLES20.GL_UNSIGNED_BYTE, t.mData);
        }

        // Hide the Loading Dialog
        mActivity.loadingDialogHandler
                .sendEmptyMessage(LoadingDialogHandler.HIDE_LOADING_DIALOG);

    }

    // The render function.
    private void renderFrame()
    {
        GLES20.glClear(GLES20.GL_COLOR_BUFFER_BIT | GLES20.GL_DEPTH_BUFFER_BIT);

        State state = mRenderer.begin();
        mRenderer.drawVideoBackground();

        GLES20.glEnable(GLES20.GL_DEPTH_TEST);

        // handle face culling, we need to detect if we are using reflection
        // to determine the direction of the culling
        GLES20.glEnable(GLES20.GL_CULL_FACE);
        GLES20.glCullFace(GLES20.GL_BACK);
        if (Renderer.getInstance().getVideoBackgroundConfig().getReflection() == VIDEO_BACKGROUND_REFLECTION.VIDEO_BACKGROUND_REFLECTION_ON)
            GLES20.glFrontFace(GLES20.GL_CW); // Front camera
        else
            GLES20.glFrontFace(GLES20.GL_CCW); // Back camera

        // TODO 檢查偵測辨識物結果 和 狀態
        // did we find any trackables this frame?
        if (state.getNumTrackableResults()>0){

            for(int tIdx=0; tIdx<state.getNumTrackableResults(); tIdx++){
                TrackableResult result = state.getTrackableResult(tIdx);
                Trackable trackable = result.getTrackable();
                printUserData(trackable);
                Matrix44F modelViewMatrix_Vuforia = Tool.convertPose2GLMatrix(result.getPose());
                float[] modelViewMatrix = modelViewMatrix_Vuforia.getData();

                int textureIndex = trackable.getName().equalsIgnoreCase("low_resolution_image") ? 0 : 1;

                // deal with the modelview and projection matrices
                float[] modelViewProjection = new float[16];

//                Matrix.translateM(modelViewMatrix, 0, 0.0f, 0.0f,
//                        -150.0f);
                Matrix.translateM(modelViewMatrix, 0, -100.0f, -80.0f,
                        OBJECT_SCALE_FLOAT);
                Matrix.rotateM(modelViewMatrix, 0, 90.0f, 1.0f, 0, 0);
                Matrix.scaleM(modelViewMatrix, 0, OBJECT_SCALE_FLOAT,
                        OBJECT_SCALE_FLOAT, OBJECT_SCALE_FLOAT);

                Matrix.multiplyMM(modelViewProjection, 0, vuforiaAppSession.getProjectionMatrix().getData(), 0, modelViewMatrix, 0);
                MixAR_Activity.renderer.moveObject3D(modelViewProjection, vuforiaAppSession.getProjectionMatrix().getData(), modelViewMatrix);

                SampleUtils.checkGLError("Render Frame");
            }
            MixAR_Activity.renderer.isShowObject(true);

        } else {
            MixAR_Activity.renderer.isShowObject(false);
        }

        mRenderer.end();
    }

    private void printUserData(Trackable trackable)
    {
        String userData = (String) trackable.getUserData();
        Log.d(LOGTAG, "UserData:Retreived User Data	\"" + userData + "\"");
    }


    public void setTextures(Vector<com.example.peter.myvuforia.SampleApplication.utils.Texture> textures)
    {
        mTextures = textures;

    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        Log.d(LOGTAG, "GLRenderer.onSurfaceChanged");

        // Call Vuforia function to handle render surface size changes:
        vuforiaAppSession.onSurfaceChanged(width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {
        if (!mIsActive)
            return;

        // Call our function to render content
        renderFrame();
    }
}
