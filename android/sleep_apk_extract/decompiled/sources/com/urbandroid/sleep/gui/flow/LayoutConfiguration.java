package com.urbandroid.sleep.gui.flow;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.urbandroid.sleep.R;

/* JADX INFO: loaded from: classes.dex */
class LayoutConfiguration {
    private int orientation = 0;
    private boolean debugDraw = false;
    private float weightDefault = 0.0f;
    private int gravity = 51;
    private int layoutDirection = 0;

    public LayoutConfiguration(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlowLayout);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInteger(1, 0));
            setDebugDraw(typedArrayObtainStyledAttributes.getBoolean(2, false));
            setWeightDefault(typedArrayObtainStyledAttributes.getFloat(6, 0.0f));
            setGravity(typedArrayObtainStyledAttributes.getInteger(0, 0));
            setLayoutDirection(typedArrayObtainStyledAttributes.getInteger(4, 0));
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public int getGravity() {
        return this.gravity;
    }

    public int getLayoutDirection() {
        return this.layoutDirection;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public float getWeightDefault() {
        return this.weightDefault;
    }

    public boolean isDebugDraw() {
        return this.debugDraw;
    }

    public void setDebugDraw(boolean z) {
        this.debugDraw = z;
    }

    public void setGravity(int i) {
        this.gravity = i;
    }

    public void setLayoutDirection(int i) {
        if (i == 1) {
            this.layoutDirection = i;
        } else {
            this.layoutDirection = 0;
        }
    }

    public void setOrientation(int i) {
        if (i == 1) {
            this.orientation = i;
        } else {
            this.orientation = 0;
        }
    }

    public void setWeightDefault(float f) {
        this.weightDefault = Math.max(0.0f, f);
    }
}
