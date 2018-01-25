package com.oradt.allen.magiccube.shape;

import javax.microedition.khronos.opengles.GL10;

import static com.oradt.allen.magiccube.utils.Color.COLOR_INDEX;
import static com.oradt.allen.magiccube.utils.Constants.BACK;
import static com.oradt.allen.magiccube.utils.Constants.BASE_LEN;
import static com.oradt.allen.magiccube.utils.Constants.BOTTOM;
import static com.oradt.allen.magiccube.utils.Constants.FRONT;
import static com.oradt.allen.magiccube.utils.Constants.LEFT;
import static com.oradt.allen.magiccube.utils.Constants.RIGHT;
import static com.oradt.allen.magiccube.utils.Constants.SMALL_BASE_LEN;
import static com.oradt.allen.magiccube.utils.Constants.TOP;

/**
 * Created by allen on 18-1-23.
 */
public class Cube {
    private final float[] vertices = {
            -SMALL_BASE_LEN, -BASE_LEN,       -SMALL_BASE_LEN,
            -SMALL_BASE_LEN, -BASE_LEN,        SMALL_BASE_LEN,
             SMALL_BASE_LEN, -BASE_LEN,        SMALL_BASE_LEN,
             SMALL_BASE_LEN, -BASE_LEN,       -SMALL_BASE_LEN,
            -BASE_LEN,       -SMALL_BASE_LEN, -BASE_LEN,
            -BASE_LEN,       -SMALL_BASE_LEN,  BASE_LEN,
             BASE_LEN,       -SMALL_BASE_LEN,  BASE_LEN,
             BASE_LEN,       -SMALL_BASE_LEN, -BASE_LEN,
            -BASE_LEN,        SMALL_BASE_LEN, -BASE_LEN,
            -BASE_LEN,        SMALL_BASE_LEN,  BASE_LEN,
             BASE_LEN,        SMALL_BASE_LEN,  BASE_LEN,
             BASE_LEN,        SMALL_BASE_LEN, -BASE_LEN,
            -SMALL_BASE_LEN,  BASE_LEN,       -SMALL_BASE_LEN,
            -SMALL_BASE_LEN,  BASE_LEN,        SMALL_BASE_LEN,
             SMALL_BASE_LEN,  BASE_LEN,        SMALL_BASE_LEN,
             SMALL_BASE_LEN,  BASE_LEN,       -SMALL_BASE_LEN,
    };

    private Square[] mSquare;
    private float mTranslateX;
    private float mTranslateY;
    private float mTranslateZ;

    public Cube(){
        mSquare = new Square[6];
        mSquare[BOTTOM] = new BottomSquare();
        mSquare[BACK] = new BackSquare();
        mSquare[LEFT] = new LeftSquare();
        mSquare[FRONT] = new FrontSquare();
        mSquare[RIGHT] = new RightSquare();
        mSquare[TOP] = new TopSquare();
    }

    public void enableFace(int face) {
        mSquare[face].setColor(COLOR_INDEX[face]);
    }

    public void setPosition(float tx, float ty, float tz) {
        mTranslateX = tx;
        mTranslateY = ty;
        mTranslateZ = tz;
    }

    public void draw(GL10 gl) {
        gl.glTranslatef(mTranslateX, mTranslateY, mTranslateZ);
        for (int i = 0; i < mSquare.length; i++) {
//            if(! mSquare[i].isBlack()){
//
//            }
            mSquare[i].draw(gl);
        }
//        gl.glLoadIdentity();
    }

    public Square getSquare(int i){
        return mSquare[i];
    }
}
