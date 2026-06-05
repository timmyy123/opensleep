package com.urbandroid.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.integrity.IntegrityManager;
import com.urbandroid.common.logging.Logger;
import java.lang.reflect.Field;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes.dex */
public abstract class ResourceUtil {
    public static Bitmap getBitmap(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (!(drawable instanceof VectorDrawable)) {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bitmapCreateBitmap;
    }

    public static int getResourceByName(Class<?> cls, String str) {
        if (cls != null) {
            try {
                Field field = cls.getField(str);
                if (field != null) {
                    return field.getInt(null);
                }
            } catch (Exception e) {
                Logger.logSevere(e);
            }
        }
        return -1;
    }

    public static String getResourceName(Context context, int i) {
        try {
            String resourceName = context.getResources().getResourceName(i);
            int iIndexOf = resourceName.indexOf(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            if (iIndexOf <= 0) {
                return resourceName;
            }
            try {
                return resourceName.substring(iIndexOf + 1);
            } catch (Exception unused) {
                return resourceName;
            }
        } catch (Resources.NotFoundException unused2) {
            return IntegrityManager.INTEGRITY_TYPE_NONE;
        }
    }

    public static int getResourceByName(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str2, str, context.getPackageName());
    }
}
