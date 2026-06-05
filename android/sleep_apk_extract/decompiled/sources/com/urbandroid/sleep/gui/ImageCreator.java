package com.urbandroid.sleep.gui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.sleep.R;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.ResourceUtil;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes4.dex */
public abstract class ImageCreator {
    public static Bitmap addLogoToBitmap(Context context, Bitmap bitmap, int i) {
        Bitmap bitmap2 = ResourceUtil.getBitmap(context, R.drawable.share_logo);
        Bitmap bitmap3 = ResourceUtil.getBitmap(context, R.drawable.share_logo_right);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), ActivityUtils.getDip(context, 16) + bitmap2.getHeight() + bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        if (i == -1) {
            i = R.color.bg_main;
        }
        canvas.drawColor(ColorUtil.i(context, i));
        canvas.drawBitmap(bitmap, 0.0f, ActivityUtils.getDip(context, 8) + bitmap2.getHeight(), new Paint());
        canvas.drawBitmap(bitmap2, ActivityUtils.getDip(context, 8), ActivityUtils.getDip(context, 8), new Paint());
        canvas.drawBitmap(bitmap3, (r2 - bitmap3.getWidth()) - ActivityUtils.getDip(context, 8), ActivityUtils.getDip(context, 8), new Paint());
        return bitmapCreateBitmap;
    }

    public static byte[] convertBitmapIntoPNGBytes(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 1, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static Bitmap convertViewIntoBitmap(int i, int i2, View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        view.draw(new Canvas(bitmapCreateBitmap));
        return bitmapCreateBitmap;
    }

    public static Bitmap createBitmapWithLogo(View view, int i) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(ColorUtil.i(view.getContext(), i == -1 ? R.color.bg_main : i));
        view.draw(canvas);
        return addLogoToBitmap(view.getContext(), bitmapCreateBitmap, i);
    }

    public static Bitmap createBitmapWithLogo(View view) {
        return createBitmapWithLogo(view, -1);
    }

    public static Bitmap addLogoToBitmap(Context context, Bitmap bitmap) {
        return addLogoToBitmap(context, bitmap, -1);
    }
}
