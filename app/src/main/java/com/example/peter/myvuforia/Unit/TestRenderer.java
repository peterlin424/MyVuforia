//package com.example.peter.myvuforia.Unit;
//
//import android.content.Context;
//import android.opengl.GLSurfaceView;
//import android.view.MotionEvent;
//
//import com.example.peter.myvuforia.R;
//
//import org.rajawali3d.Object3D;
//import org.rajawali3d.lights.DirectionalLight;
//import org.rajawali3d.loader.LoaderOBJ;
//import org.rajawali3d.materials.Material;
//import org.rajawali3d.materials.methods.DiffuseMethod;
//import org.rajawali3d.materials.textures.Texture;
//import org.rajawali3d.math.Quaternion;
//import org.rajawali3d.math.vector.Vector3;
//import org.rajawali3d.vuforia.RajawaliVuforiaRenderer;
//
//import java.util.ArrayList;
//
//import javax.microedition.khronos.egl.EGLConfig;
//import javax.microedition.khronos.opengles.GL10;
//
///**
// * Created by Peter on 16/1/30.
// */
//public class TestRenderer extends RajawaliVuforiaRenderer implements GLSurfaceView.Renderer{
//
//    private DirectionalLight directionalLight;
//
//    private Object3D WatchObj;
//
//    private ArrayList<Object3D> Object3DList;
//
//    public TestRenderer(Context context) {
//        super(context);
//    }
//
//    private Object3D loadShowObj(int resourceId, double scale) {
//        Object3D object = null;
//        try {
//            LoaderOBJ objParser = new LoaderOBJ(mContext.getResources(), mTextureManager, resourceId);
//            objParser.parse();
//            object = objParser.getParsedObject();
//            object.setScale(scale);
//            getCurrentScene().addChild(object);
//            Object3DList.add(object);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return object;
//    }
//
//    @Override
//    protected void foundFrameMarker(int markerId, Vector3 position, Quaternion orientation) {
//
//    }
//
//    @Override
//    protected void foundImageMarker(String trackableName, Vector3 position, Quaternion orientation) {
//
//        if (trackableName.equals("low_resolution_image")) {
//            WatchObj.setVisible(true);
//        }
//    }
//
//    @Override
//    public void noFrameMarkersFound() {
//
//    }
//
//    @Override
//    protected void initScene() {
//
//        /** 定向光 */
//        directionalLight = new DirectionalLight(1f, .2f, -1.0f); // 座標
//        directionalLight.setColor(1.0f, 1.0f, 1.0f);             // 燈光色
//        directionalLight.setPower(2);                            // 燈光強度
//        getCurrentScene().addLight(directionalLight);
//
//        Object3DList = new ArrayList<Object3D>(0);
//
//        try {
//            /** 載入模型 */
//            final LoaderOBJ parser = new LoaderOBJ(mContext.getResources(), mTextureManager, R.raw.watch_obj);
//            parser.parse();
//
//            WatchObj = parser.getParsedObject();
//
//            /** 模型材質貼皮 */
//            Material material = new Material();
//            material.enableLighting(true);
//            material.setDiffuseMethod(new DiffuseMethod.Lambert());
//            material.addTexture(new Texture("Watch1", R.drawable.watch001));
//            material.addTexture(new Texture("Watch2", R.drawable.watch002));
//            material.setColor(0x990000);
//
//            WatchObj.setMaterial(material);
//            getCurrentScene().addChild(WatchObj);
//
//            WatchObj.setVisible(false);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void onOffsetsChanged(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
//
//    }
//
//    @Override
//    public void onTouchEvent(MotionEvent event) {
//
//    }
//
//
//
//    /** GLSurfaceView.Renderer */
//    @Override
//    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
//
//    }
//
//    @Override
//    public void onSurfaceChanged(GL10 gl, int width, int height) {
//
//    }
//
//    @Override
//    public void onDrawFrame(GL10 gl) {
//        for (Object3D object : Object3DList) {
//            object.setVisible(false);
//        }
//    }
//}
