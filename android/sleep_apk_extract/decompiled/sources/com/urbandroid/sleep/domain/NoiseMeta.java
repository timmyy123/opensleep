package com.urbandroid.sleep.domain;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.R;
import java.io.ByteArrayOutputStream;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\nJ\r\u0010\f\u001a\u00020\b¢\u0006\u0004\b\f\u0010\nJ\r\u0010\r\u001a\u00020\b¢\u0006\u0004\b\r\u0010\nJ\r\u0010\u000e\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\nJ\r\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/domain/NoiseMeta;", "", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/Noise;", "noise", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/domain/Noise;)V", "", "getTitle", "()Ljava/lang/String;", "getAlbum", "getArtist", "getGenre", "getComment", "", "getAlbumArt", "()[B", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Lcom/urbandroid/sleep/domain/Noise;", "getNoise", "()Lcom/urbandroid/sleep/domain/Noise;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoiseMeta {
    private final Context context;
    private final Noise noise;

    public NoiseMeta(Context context, Noise noise) {
        context.getClass();
        noise.getClass();
        this.context = context;
        this.noise = noise;
    }

    public final String getAlbum() {
        String string = this.context.getString(R.string.interesting_noise_recordings);
        string.getClass();
        return string;
    }

    public final byte[] getAlbumArt() {
        Drawable drawable = this.context.getDrawable(R.drawable.album_art);
        drawable.getClass();
        drawable.getClass();
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArray.getClass();
        return byteArray;
    }

    public final String getArtist() {
        String string = this.context.getString(R.string.app_name_long);
        string.getClass();
        return string;
    }

    public final String getComment() {
        String comment = this.noise.getComment();
        comment.getClass();
        return comment;
    }

    public final String getGenre() {
        String string = this.context.getString(R.string.noise);
        string.getClass();
        return string;
    }

    public final String getTitle() {
        String humanReadableTitle = this.noise.getHumanReadableTitle();
        humanReadableTitle.getClass();
        return humanReadableTitle;
    }
}
