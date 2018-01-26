package com.oradt.allen.magiccube.shape;

import javax.microedition.khronos.opengles.GL10;

import static com.oradt.allen.magiccube.utils.Color.COLOR_INDEX;
import static com.oradt.allen.magiccube.utils.Constants.BACK;
import static com.oradt.allen.magiccube.utils.Constants.BASE_LEN;
import static com.oradt.allen.magiccube.utils.Constants.BOTTOM;
import static com.oradt.allen.magiccube.utils.Constants.CORNER;
import static com.oradt.allen.magiccube.utils.Constants.EDGE;
import static com.oradt.allen.magiccube.utils.Constants.FRONT;
import static com.oradt.allen.magiccube.utils.Constants.LEFT;
import static com.oradt.allen.magiccube.utils.Constants.RIGHT;
import static com.oradt.allen.magiccube.utils.Constants.SMALL_BASE_LEN;
import static com.oradt.allen.magiccube.utils.Constants.TOP;

/**
 * Created by allen on 18-1-23.
 */
public class Cube {
    private final float[] mVertices = {
            -SMALL_BASE_LEN, -BASE_LEN,       -SMALL_BASE_LEN, //0
            -SMALL_BASE_LEN, -BASE_LEN,        SMALL_BASE_LEN, //1
             SMALL_BASE_LEN, -BASE_LEN,        SMALL_BASE_LEN, //2
             SMALL_BASE_LEN, -BASE_LEN,       -SMALL_BASE_LEN, //3
            -BASE_LEN,       -SMALL_BASE_LEN, -SMALL_BASE_LEN, //4
            -BASE_LEN,       -SMALL_BASE_LEN,  SMALL_BASE_LEN, //5
            -SMALL_BASE_LEN, -SMALL_BASE_LEN,  BASE_LEN,       //6
             SMALL_BASE_LEN, -SMALL_BASE_LEN,  BASE_LEN,       //7
             BASE_LEN,       -SMALL_BASE_LEN,  SMALL_BASE_LEN, //8
             BASE_LEN,       -SMALL_BASE_LEN, -SMALL_BASE_LEN, //9
             SMALL_BASE_LEN, -SMALL_BASE_LEN, -BASE_LEN,       //10
            -SMALL_BASE_LEN, -SMALL_BASE_LEN, -BASE_LEN,       //11
            -BASE_LEN,        SMALL_BASE_LEN, -SMALL_BASE_LEN, //12
            -BASE_LEN,        SMALL_BASE_LEN,  SMALL_BASE_LEN, //13
            -SMALL_BASE_LEN,  SMALL_BASE_LEN,  BASE_LEN,       //14
             SMALL_BASE_LEN,  SMALL_BASE_LEN,  BASE_LEN,       //15
             BASE_LEN,        SMALL_BASE_LEN,  SMALL_BASE_LEN, //16
             BASE_LEN,        SMALL_BASE_LEN, -SMALL_BASE_LEN, //17
             SMALL_BASE_LEN,  SMALL_BASE_LEN, -BASE_LEN,       //18
            -SMALL_BASE_LEN,  SMALL_BASE_LEN, -BASE_LEN,       //19
            -SMALL_BASE_LEN,  BASE_LEN,       -SMALL_BASE_LEN, //20
            -SMALL_BASE_LEN,  BASE_LEN,        SMALL_BASE_LEN, //21
             SMALL_BASE_LEN,  BASE_LEN,        SMALL_BASE_LEN, //22
             SMALL_BASE_LEN,  BASE_LEN,       -SMALL_BASE_LEN, //23
    };

    private Square[] mSquare;
    private float mTranslateX = 0;
    private float mTranslateY = 0;
    private float mTranslateZ = 0;

    public Cube(){
        mSquare = new Square[26];
        mSquare[BOTTOM] = new Square(pickupVertices(3, 2, 1, 0));
        mSquare[BACK] = new Square(pickupVertices(10, 11, 19, 18));
        mSquare[LEFT] = new Square(pickupVertices(4, 5, 13, 12));
        mSquare[FRONT] = new Square(pickupVertices(6, 7, 15, 14));
        mSquare[RIGHT] = new Square(pickupVertices(8, 9, 17, 16));
        mSquare[TOP] = new Square(pickupVertices(20, 21, 22, 23));

        mSquare[EDGE] = new Square(pickupVertices(0, 1, 5, 4));
        mSquare[EDGE + 1] = new Square(pickupVertices(1, 2, 7, 6));
        mSquare[EDGE + 2] = new Square(pickupVertices(2, 3, 9, 8));
        mSquare[EDGE + 3] = new Square(pickupVertices(11, 10, 3, 0));
        mSquare[EDGE + 4] = new Square(pickupVertices(4, 12, 19, 11));
        mSquare[EDGE + 5] = new Square(pickupVertices(5, 6, 14, 13));
        mSquare[EDGE + 6] = new Square(pickupVertices(7, 8, 16, 15));
        mSquare[EDGE + 7] = new Square(pickupVertices(9, 10, 18, 17));
        mSquare[EDGE + 8] = new Square(pickupVertices(12, 13, 21, 20));
        mSquare[EDGE + 9] = new Square(pickupVertices(14, 15, 22, 21));
        mSquare[EDGE + 10] = new Square(pickupVertices(16, 17, 23, 22));
        mSquare[EDGE + 11] = new Square(pickupVertices(18, 19, 20, 23));

        mSquare[CORNER] = new Square(pickupVertices(0, 4, 11));
        mSquare[CORNER + 1] = new Square(pickupVertices(1, 6, 5));
        mSquare[CORNER + 2] = new Square(pickupVertices(2, 8, 7));
        mSquare[CORNER + 3] = new Square(pickupVertices(3, 10, 9));
        mSquare[CORNER + 4] = new Square(pickupVertices(12, 20, 19));
        mSquare[CORNER + 5] = new Square(pickupVertices(13, 14, 21));
        mSquare[CORNER + 6] = new Square(pickupVertices(15, 16, 22));
        mSquare[CORNER + 7] = new Square(pickupVertices(17, 18, 23));
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

    public float[] pickupVertices(int... points){
        float[] vertices = new float[points.length * 3];
        int index = 0;
        for (int point: points) {
            vertices[index] = mVertices[point * 3];
            vertices[index + 1] = mVertices[point * 3 + 1];
            vertices[index + 2] = mVertices[point * 3 + 2];
            index += 3;
        }
        return vertices;
    }
}
