package com.oradt.allen.magiccube;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.oradt.allen.magiccube.shape.MagicCube;

public class MainActivity extends Activity {
    private OpenGLRenderer mOpenGLRenderer = null;
    private MagicCube mMagicCube;
    private float downX = 0;
    private float downY = 0;
    private float currentX = 0;
    private float currentY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        GLSurfaceView view = new GLSurfaceView(this);
        mMagicCube = new MagicCube();
        mOpenGLRenderer = new OpenGLRenderer(mMagicCube);
        view.setRenderer(mOpenGLRenderer);
        setContentView(view);
    }
}
