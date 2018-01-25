package com.oradt.allen.magiccube.shape;

import com.oradt.allen.magiccube.utils.Color;

import static com.oradt.allen.magiccube.utils.Constants.BASE_LEN;

/**
 * Created by allen on 18-1-24.
 */
public class BackSquare extends Square {
    private final float[] vertices = {
            -BASE_LEN, -BASE_LEN, -BASE_LEN,
            -BASE_LEN,  BASE_LEN, -BASE_LEN,
             BASE_LEN,  BASE_LEN, -BASE_LEN,
             BASE_LEN, -BASE_LEN, -BASE_LEN,
    };

    public BackSquare(){
        float[] colorVertices = new float[vertices.length];
        for (int i = 0; i < vertices.length; i++){
            if(i % 3 == 2){
                colorVertices[i] = vertices[i];
            }
            else {
                colorVertices[i] = vertices[i] * 0.9f;
            }
        }
        setVertices(vertices, colorVertices);
        setColor(Color.BLACK);
    }
}
