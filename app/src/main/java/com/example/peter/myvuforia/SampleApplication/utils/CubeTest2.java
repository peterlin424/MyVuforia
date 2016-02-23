package com.example.peter.myvuforia.SampleApplication.utils;

import java.nio.Buffer;

/**
 * Created by Peter on 16/1/19.
 */
public class CubeTest2 extends MeshObject{
    private Buffer mVertBuff;
    private Buffer mTexCoordBuff;
    private Buffer mNormBuff;
    private Buffer mIndBuff;

    private int indicesNumber = 0;
    private int verticesNumber = 0;

    public CubeTest2()
    {
        setVerts();
        setTexCoords();
        setNorms();
        setIndices();
    }

    int bananaNumVerts = 24168;
    private void setIndices(){
        short[] indice = new short[]{};
        mIndBuff = fillBuffer(indice);
        indicesNumber = indice.length;
    }
    private void setVerts(){
        //double[] verts = new double[] {};

        double[] verts = new double[] {
                // f 2/1/1 3/2/1 4/3/1
                0.499999812500094, -0.499999750000125, 0.499999625000188,
                -0.499999687500156, -0.499999750000125, 0.499999625000188,
                -0.499999687500156, -0.499999750000125, -0.499999875000063,
                // f 8/4/2 7/5/2 6/6/2
                -0.499999687500156, 0.499999750000125, -0.499999875000063,
                -0.499999687500156, 0.499999750000125, 0.499999625000188,
                0.499999312500344, 0.499999750000125, 0.500000124999938,
                // f 1/7/3 5/8/3 6/9/3
                0.499999812500094, -0.499999750000125, -0.499999875000063,
                0.499999812500094, 0.499999750000125, -0.499999375000313,
                0.499999312500344, 0.499999750000125, 0.500000124999938,
                // f 2/10/4 6/11/4 7/12/4
                0.499999812500094, -0.499999750000125, 0.499999625000188,
                0.499999312500344, 0.499999750000125, 0.500000124999938,
                -0.499999687500156, 0.499999750000125, 0.499999625000188,
                // f 3/13/5 7/14/5 8/15/5
                -0.499999687500156, -0.499999750000125, 0.499999625000188,
                -0.499999687500156, 0.499999750000125, 0.499999625000188,
                -0.499999687500156, 0.499999750000125, -0.499999875000063,
                // f 1/7/6 4/16/6 8/4/6
                0.499999812500094, -0.499999750000125, -0.499999875000063,
                -0.499999687500156, -0.499999750000125, -0.499999875000063,
                -0.499999687500156, 0.499999750000125, -0.499999875000063,
                // f 1/17/1 2/1/1 4/3/1
                0.499999812500094, -0.499999750000125, -0.499999875000063,
                0.499999812500094, -0.499999750000125, 0.499999625000188,
                -0.499999687500156, -0.499999750000125, -0.499999875000063,
                // f 5/8/2 8/4/2 6/6/2
                0.499999812500094, 0.499999750000125, -0.499999375000313,
                -0.499999687500156, 0.499999750000125, -0.499999875000063,
                0.499999312500344, 0.499999750000125, 0.500000124999938,
                // f 2/18/3 1/7/3 6/9/3
                0.499999812500094, -0.499999750000125, 0.499999625000188,
                0.499999812500094, -0.499999750000125, -0.499999875000063,
                0.499999312500344, 0.499999750000125, 0.500000124999938,
                // f 3/19/4 2/10/4 7/12/4
                -0.499999687500156, -0.499999750000125, 0.499999625000188,
                0.499999812500094, -0.499999750000125, 0.499999625000188,
                -0.499999687500156, 0.499999750000125, 0.499999625000188,
                // f 4/20/5 3/13/5 8/15/5
                -0.499999687500156, -0.499999750000125, -0.499999875000063,
                -0.499999687500156, -0.499999750000125, 0.499999625000188,
                -0.499999687500156, 0.499999750000125, -0.499999875000063,
                // f 5/8/6 1/7/6 8/4/6
                0.499999812500094, 0.499999750000125, -0.499999375000313,
                0.499999812500094, -0.499999750000125, -0.499999875000063,
                -0.499999687500156, 0.499999750000125, -0.499999875000063,
        };
        mVertBuff = fillBuffer(verts);
        verticesNumber = verts.length / 3;
    }
    private void setNorms(){
        double[] norms = new double []{
                // f 2/1/1 3/2/1 4/3/1
                0, -1, 0,
                0, -1, 0,
                0, -1, 0,
                // f 8/4/2 7/5/2 6/6/2
                0, 1, 0,
                0, 1, 0,
                0, 1, 0,
                // f 1/7/3 5/8/3 6/9/3
                1, 0, 0,
                1, 0, 0,
                1, 0, 0,
                // f 2/10/4 6/11/4 7/12/4
                0, 0, 1,
                0, 0, 1,
                0, 0, 1,
                // f 3/13/5 7/14/5 8/15/5
                -1, 0, 0,
                -1, 0, 0,
                -1, 0, 0,
                // f 1/7/6 4/16/6 8/4/6
                0, 0, -1,
                0, 0, -1,
                0, 0, -1,
                // f 1/17/1 2/1/1 4/3/1
                0, -1, 0,
                0, -1, 0,
                0, -1, 0,
                // f 5/8/2 8/4/2 6/6/2
                0, 1, 0,
                0, 1, 0,
                0, 1, 0,
                // f 2/18/3 1/7/3 6/9/3
                1, 0, 0,
                1, 0, 0,
                1, 0, 0,
                // f 3/19/4 2/10/4 7/12/4
                0, 0, 1,
                0, 0, 1,
                0, 0, 1,
                // f 4/20/5 3/13/5 8/15/5
                -1, 0, 0,
                -1, 0, 0,
                -1, 0, 0,
                // f 5/8/6 1/7/6 8/4/6
                0, 0, -1,
                0, 0, -1,
                0, 0, -1,
        };
        mNormBuff = fillBuffer(norms);
    }
    private void setTexCoords(){
        double[] cords = new double[]{
                // f 2/1/1 3/2/1 4/3/1
                0.877166, 0.254588,
                0.874705, 0.00246100000000005,
                0.625039, 0.00492199999999998,
                // f 8/4/2 7/5/2 6/6/2
                0.372706, 0.00112699999999999,
                0.123039, 0.00358800000000004,
                0.127961, 0.248333,
                // f 1/7/3 5/8/3 6/9/3
                0.627294, 0.250794,
                0.377627, 0.250794,
                0.375167, 0.500461,
                // f 2/10/4 6/11/4 7/12/4
                0.376500, 0.504255,
                0.374039, 0.749,
                0.626166, 0.751461,
                // f 3/13/5 7/14/5 8/15/5
                0.625961, 0.755255,
                0.376294, 0.752794,
                0.373834, 1,
                // f 1/7/6 4/16/6 8/4/6
                0.627294, 0.250794,
                0.622373, 0.00112800000000002,
                0.372706, 0.00112699999999999,
                // f 1/17/1 2/1/1 4/3/1
                0.627500, 0.257049,
                0.877166, 0.254588,
                0.625039, 0.00492199999999998,
                // f 5/8/2 8/4/2 6/6/2
                0.377627, 0.250794,
                0.372706, 0.00112699999999999,
                0.127961, 0.248333,
                // f 2/18/3 1/7/3 6/9/3
                0.622373, 0.500461,
                0.627294, 0.250794,
                0.375167, 0.500461,
                // f 3/19/4 2/10/4 7/12/4
                0.628627, 0.506716,
                0.376500, 0.504255,
                0.626166, 0.751461,
                // f 4/20/5 3/13/5 8/15/5
                0.623500, 1.002461,
                0.625961, 0.755255,
                0.373834, 1,
                // f 5/8/6 1/7/6 8/4/6
                0.377627, 0.250794,
                0.627294, 0.250794,
                0.372706, 0.00112699999999999,
        };
        mTexCoordBuff = fillBuffer(cords);

    }
    public int getNumObjectIndex()
    {
        return indicesNumber;
    }


    @Override
    public int getNumObjectVertex()
    {
        return verticesNumber;
    }


    @Override
    public Buffer getBuffer(BUFFER_TYPE bufferType)
    {
        Buffer result = null;
        switch (bufferType)
        {
            case BUFFER_TYPE_VERTEX:
                result = mVertBuff;
                break;
            case BUFFER_TYPE_TEXTURE_COORD:
                result = mTexCoordBuff;
                break;
            case BUFFER_TYPE_NORMALS:
                result = mNormBuff;
                break;
            case BUFFER_TYPE_INDICES:
                result = mIndBuff;
            default:
                break;

        }

        return result;
    }
}
