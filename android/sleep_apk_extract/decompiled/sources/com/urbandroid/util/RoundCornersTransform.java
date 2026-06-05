package com.urbandroid.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.ShareConstants;
import com.squareup.picasso.Transformation;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/util/RoundCornersTransform;", "Lcom/squareup/picasso/Transformation;", "radiusInPx", "", "<init>", "(F)V", "transform", "Landroid/graphics/Bitmap;", ShareConstants.FEED_SOURCE_PARAM, SDKConstants.PARAM_KEY, "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RoundCornersTransform implements Transformation {
    private final float radiusInPx;

    public RoundCornersTransform(float f) {
        this.radiusInPx = f;
    }

    @Override // com.squareup.picasso.Transformation
    public String key() {
        return "round_corners";
    }

    @Override // com.squareup.picasso.Transformation
    public Bitmap transform(Bitmap source) {
        source.getClass();
        int width = source.getWidth();
        int height = source.getHeight();
        Bitmap.Config config = source.getConfig();
        config.getClass();
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, config);
        bitmapCreateBitmap.getClass();
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint(5);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(source, tileMode, tileMode));
        RectF rectF = new RectF(0.0f, 0.0f, source.getWidth(), source.getHeight());
        float f = this.radiusInPx;
        canvas.drawRoundRect(rectF, f, f, paint);
        source.recycle();
        return bitmapCreateBitmap;
    }
}
