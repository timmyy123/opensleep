package com.google.android.material.motion;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.PathParser;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.fragment.app.Fragment$$ExternalSyntheticBUOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.google.android.material.R$styleable;
import com.google.android.material.resources.MaterialAttributes;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MotionUtils {
    private static float getLegacyControlPoint(String[] strArr, int i) {
        float f = Float.parseFloat(strArr[i]);
        if (f >= 0.0f && f <= 1.0f) {
            return f;
        }
        Events$$ExternalSyntheticBUOutline0.m("Motion easing control point value must be between 0 and 1; instead got: ", f);
        return 0.0f;
    }

    private static String getLegacyEasingContent(String str, String str2) {
        return Fragment$$ExternalSyntheticOutline1.m(1, str2.length() + 1, str);
    }

    private static TimeInterpolator getLegacyThemeInterpolator(String str) {
        if (!isLegacyEasingType(str, "cubic-bezier")) {
            if (isLegacyEasingType(str, "path")) {
                return new PathInterpolator(PathParser.createPathFromPathData(getLegacyEasingContent(str, "path")));
            }
            Utf8$$ExternalSyntheticBUOutline0.m$2(FileInsert$$ExternalSyntheticOutline0.m("Invalid motion easing type: ", str));
            return null;
        }
        String[] strArrSplit = getLegacyEasingContent(str, "cubic-bezier").split(",");
        if (strArrSplit.length == 4) {
            return new PathInterpolator(getLegacyControlPoint(strArrSplit, 0), getLegacyControlPoint(strArrSplit, 1), getLegacyControlPoint(strArrSplit, 2), getLegacyControlPoint(strArrSplit, 3));
        }
        Fragment$$ExternalSyntheticBUOutline0.m(strArrSplit.length, "Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
        return null;
    }

    private static boolean isLegacyEasingAttribute(String str) {
        return isLegacyEasingType(str, "cubic-bezier") || isLegacyEasingType(str, "path");
    }

    private static boolean isLegacyEasingType(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("(");
        return str.startsWith(sb.toString()) && str.endsWith(")");
    }

    public static int resolveThemeDuration(Context context, int i, int i2) {
        return MaterialAttributes.resolveInteger(context, i, i2);
    }

    public static TimeInterpolator resolveThemeInterpolator(Context context, int i, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String strValueOf = String.valueOf(typedValue.string);
            return isLegacyEasingAttribute(strValueOf) ? getLegacyThemeInterpolator(strValueOf) : AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        Utf8$$ExternalSyntheticBUOutline0.m$2("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        return null;
    }

    public static SpringForce resolveThemeSpringForce(Context context, int i, int i2) {
        TypedValue typedValueResolve = MaterialAttributes.resolve(context, i);
        TypedArray typedArrayObtainStyledAttributes = typedValueResolve == null ? context.obtainStyledAttributes(null, R$styleable.MaterialSpring, 0, i2) : context.obtainStyledAttributes(typedValueResolve.resourceId, R$styleable.MaterialSpring);
        SpringForce springForce = new SpringForce();
        try {
            float f = typedArrayObtainStyledAttributes.getFloat(R$styleable.MaterialSpring_stiffness, Float.MIN_VALUE);
            if (f == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have stiffness value.");
            }
            float f2 = typedArrayObtainStyledAttributes.getFloat(R$styleable.MaterialSpring_damping, Float.MIN_VALUE);
            if (f2 == Float.MIN_VALUE) {
                throw new IllegalArgumentException("A MaterialSpring style must have a damping value.");
            }
            springForce.setStiffness(f);
            springForce.setDampingRatio(f2);
            return springForce;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }
}
