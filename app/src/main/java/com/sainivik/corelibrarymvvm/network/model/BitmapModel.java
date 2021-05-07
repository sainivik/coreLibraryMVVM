package com.sainivik.corelibrarymvvm.network.model;

import android.graphics.Bitmap;

public class BitmapModel {
    private int pos;

    public BitmapModel(int pos, Bitmap bitmap) {
        this.pos = pos;
        this.bitmap = bitmap;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    private Bitmap bitmap;

}
