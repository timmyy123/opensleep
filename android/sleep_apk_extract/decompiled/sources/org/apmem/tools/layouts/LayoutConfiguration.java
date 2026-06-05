package org.apmem.tools.layouts;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: loaded from: classes.dex */
class LayoutConfiguration {
    private int orientation = 0;
    private boolean debugDraw = false;
    private float weightDefault = 0.0f;
    private int gravity = 51;
    private int layoutDirection = 0;

    public LayoutConfiguration(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FlowLayout);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInteger(R$styleable.FlowLayout_android_orientation, 0));
            setDebugDraw(typedArrayObtainStyledAttributes.getBoolean(R$styleable.FlowLayout_debugDraw, false));
            setWeightDefault(typedArrayObtainStyledAttributes.getFloat(R$styleable.FlowLayout_weightDefault, 0.0f));
            setGravity(typedArrayObtainStyledAttributes.getInteger(R$styleable.FlowLayout_android_gravity, 0));
            setLayoutDirection(typedArrayObtainStyledAttributes.getInteger(R$styleable.FlowLayout_layoutDirection, 0));
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
