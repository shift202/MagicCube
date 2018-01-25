package com.oradt.allen.magiccube.shape;

import com.oradt.allen.magiccube.utils.Color;

import static com.oradt.allen.magiccube.utils.Constants.BASE_LEN;

/**
 * Created by allen on 18-1-24.
 */
public class TopSquare extends Square {
    private final float[] vertices = {
            -BASE_LEN, BASE_LEN, -BASE_LEN,
            -BASE_LEN, BASE_LEN,  BASE_LEN,
             BASE_LEN, BASE_LEN,  BASE_LEN,
             BASE_LEN, BASE_LEN, -BASE_LEN,
    };

    public TopSquare(){
        float[] colorVertices = new float[vertices.length];
        for (int i = 0; i < vertices.length; i++){
            if(i % 3 == 1){
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
