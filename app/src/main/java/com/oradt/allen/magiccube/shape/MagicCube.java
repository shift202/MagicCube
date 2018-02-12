package com.oradt.allen.magiccube.shape;

import com.oradt.allen.magiccube.utils.Constants;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by allen on 18-1-22.
 */
public class MagicCube {
    private Cube[] mCubes;
    private int mLevel;

    private float mRotateX = 0;
    private float mRotateY = 0;
    private float mRotateZ = 0;

    public MagicCube(){
        this(3);
    }

    public MagicCube(int level){
        mLevel = level;
        mCubes = new Cube[level * level * level];
        float offset = (level - 1) * Constants.BASE_LEN;
        for(int i = 0; i < level; i++){
            for(int j = 0; j < level; j++){
                for (int k = 0; k < level; k++){
                    Cube cube = new Cube();
                    if(i == 0){
                        cube.enableFace(Constants.LEFT);
                    }
                    if (i == level - 1){
                        cube.enableFace(Constants.RIGHT);
                    }
                    if(j == 0){
                        cube.enableFace(Constants.BOTTOM);
                    }
                    if (j == level - 1){
                        cube.enableFace(Constants.TOP);
                    }
                    if(k == 0){
                        cube.enableFace(Constants.BACK);
                    }
                    if (k == level - 1){
                        cube.enableFace(Constants.FRONT);
                    }
                    cube.setPosition(
                            i * Constants.BASE_LEN * 2 - offset,
                            j * Constants.BASE_LEN * 2 - offset,
                            k * Constants.BASE_LEN * 2 - offset);
                    mCubes[getIndex(i, j, k)] = cube;
                }
            }
        }
    }

    public void draw(GL10 gl) {
        gl.glRotatef(mRotateX, 1, 0, 0);
        if(mRotateX > 90 && mRotateX < 270){
            gl.glRotatef(-mRotateY, 0, 1, 0);
        }
        else {
            gl.glRotatef(mRotateY, 0, 1, 0);
        }
        for (int i = 0; i < mCubes.length; i++) {
            gl.glPushMatrix();
            mCubes[i].draw(gl);
            gl.glPopMatrix();
        }
    }

    public void setRotate(float rx, float ry){
        setRotate(rx, ry, 0);
    }

    public void setRotate(float rx, float ry, float rz){
        mRotateX += rx;
        mRotateX = normalizeRotate(mRotateX);
        mRotateY += ry;
        mRotateY = normalizeRotate(mRotateY);
        mRotateZ += rz;
        mRotateZ = normalizeRotate(mRotateZ);
    }

    private float normalizeRotate(float angle){
        while (angle < 0) {
            angle += 360;
        }
        while (angle > 360){
            angle -= 360;
        }
        return angle;
    }

    public Cube getCube(int x, int y, int z){
        return mCubes[getIndex(x, y, z)];
    }

    private int getIndex(int x, int y, int z){
        return x  + y * mLevel + z * mLevel * mLevel;
    }
}
