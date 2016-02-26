package com.example.peter.myvuforia.Unit;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;

import com.example.peter.myvuforia.R;

import org.rajawali3d.Object3D;
import org.rajawali3d.lights.DirectionalLight;
import org.rajawali3d.lights.PointLight;
import org.rajawali3d.loader.LoaderOBJ;
import org.rajawali3d.materials.Material;
import org.rajawali3d.materials.methods.DiffuseMethod;
import org.rajawali3d.materials.textures.Texture;
import org.rajawali3d.math.Matrix4;
import org.rajawali3d.math.Quaternion;
import org.rajawali3d.math.vector.Vector3;

/**
 * Created by Peter on 16/2/1.
 */
public class Mix_Rajawali_Render extends org.rajawali3d.renderer.RajawaliRenderer {

    public Context context;
    private DirectionalLight directionalLight;
    private Object3D WatchObj;
    private ArcballCamera arcball;
    private Material material;

    public Mix_Rajawali_Render(Context context) {
        super(context);
        this.context = context;
        setFrameRate(60);
    }

    public void showObject3D(boolean isShow){
        WatchObj.setVisible(isShow);
    }
    public void moveObject3D(float[] vMatrix){   // 變形矩陣
        // TODO 判斷出辨識物了，但缺少模型處理
        Matrix4 newMatrix = new Matrix4(vMatrix);

        Vector3 translation = newMatrix.getTranslation();
        Vector3 scale = newMatrix.getScaling();

//        arcball.setProjectionMatrix(1000,2000);
//        arcball.setPosition(translation);

//        arcball.Rotaion((float)translation.x, (float)translation.y);
//        arcball.Scaleing((float)scale.y);

//        arcball.setPosition(translation);
        arcball.setPosition(0.1f + translation.x, 40.0f + translation.y, 0.0f + translation.z);

    }


    @Override
    protected void initScene() {
        try {

            /** 定向光 */
            directionalLight = new DirectionalLight(0.1f, -10.0f, 0.0f); // 座標
            directionalLight.setColor(1.0f, 1.0f, 1.0f);             // 燈光色
            directionalLight.setPower(2);                            // 燈光強度
            getCurrentScene().addLight(directionalLight);

            PointLight mLight = new PointLight();//物件本身亮度
            mLight.setPosition(0.1f, 40.0f, 0.0f);//設定光亮動畫位置
            mLight.setPower(25); //3D物件亮度調整
            getCurrentScene().addLight(mLight);

//            /** debug 隔線 */
//            DebugVisualizer debugViz = new DebugVisualizer(this);
//            debugViz.addChild(new GridFloor());
//            getCurrentScene().addChild(debugViz);

            /** 載入模型 */
//                final LoaderAWD parser = new LoaderAWD(mContext.getResources(), mTextureManager, R.raw.awd_suzanne);
//                parser.parse();
            final LoaderOBJ parser = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.watch_obj);
            parser.parse();

            WatchObj = parser.getParsedObject();

            /** 模型材質貼皮 */
            material = new Material();
            material.enableLighting(true);
            material.setDiffuseMethod(new DiffuseMethod.Lambert());
            material.addTexture(new Texture("Watch1", R.drawable.watch001));
            material.addTexture(new Texture("Watch2", R.drawable.watch002));
            material.setColor(0x990000);

            WatchObj.setMaterial(material);
            WatchObj.setScale(2.5f);
            getCurrentScene().addChild(WatchObj);

            /** 視角相機設定 */
            arcball = new ArcballCamera(mContext, ((Activity)mContext).findViewById(R.id.drawer_layout));
            arcball.setPosition(0.1f, 40.0f, 0.0f);
            getCurrentScene().replaceAndSwitchCamera(getCurrentCamera(), arcball);

            WatchObj.setVisible(false);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {

    }

    @Override
    public void onTouchEvent(MotionEvent event) {

    }

    @Override
    public void onRender(final long elapsedTime, final double deltaTime) {
        super.onRender(elapsedTime, deltaTime);
    }
}
