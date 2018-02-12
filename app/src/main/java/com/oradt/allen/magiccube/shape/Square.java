package com.oradt.allen.magiccube.shape;

import com.oradt.allen.magiccube.utils.Color;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by allen on 18-1-23.
 */
public class Square {

    private float[] mColor;
    // Our vertex buffer.
    protected FloatBuffer vertexBuffer;
    private int mVertexBufferLen;
    private float rotateX;
    private float rotateY;
    private float rotateZ;

    public Square(){
        mColor = Color.BLACK;
    }

    public Square(float[] vertices){
        mColor = Color.BLACK;
        mVertexBufferLen = vertices.length / 3;
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 2 * Float.SIZE / Byte.SIZE);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.position(0);
    }

    public void setVertices(float[] vertices, float[] colorVertices){
        mVertexBufferLen = vertices.length / 3;
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 2 * Float.SIZE / Byte.SIZE);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer();
        vertexBuffer.put(vertices);
        vertexBuffer.put(colorVertices);
        vertexBuffer.position(0);
    }

    public void setRotate(float rx, float ry, float rz){
        rotateX = rx;
        rotateY = ry;
        rotateZ = rz;
    }

    public void setColor(float[] Color) {
        mColor = Color;
    }

    public boolean isBlack(){
        for(int i = 0; i < 3; i++){
            if(mColor[i] > 0.001){
                return false;
            }
        }
        if(mColor[3] < 0.999){
            return false;
        }
        return true;
    }

    public void draw(GL10 gl) {
        // Counter-clockwise winding.
        gl.glFrontFace(GL10.GL_CCW);
        // Enable face culling.
        gl.glEnable(GL10.GL_CULL_FACE);
        // What faces to remove with the face culling.
        gl.glCullFace(GL10.GL_BACK);
        // Enabled the vertices buffer for writing
        // and to be used during rendering.
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        // Specifies the location and data format of
        // an array of vertex coordinates to use
        // when rendering.
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);


        gl.glColor4f(mColor[0], mColor[1], mColor[2], mColor[3]);
        gl.glDrawArrays(GL10.GL_TRIANGLE_FAN, 0, mVertexBufferLen);

        // Disable the vertices buffer.
        gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
        // Disable face culling.
        gl.glDisable(GL10.GL_CULL_FACE);

    }
}
