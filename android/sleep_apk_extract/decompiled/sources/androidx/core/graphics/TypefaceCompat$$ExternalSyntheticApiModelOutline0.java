package androidx.core.graphics;

import android.app.appsearch.GenericDocument;
import android.content.ClipData;
import android.graphics.fonts.Font;
import android.view.ContentInfo;
import android.widget.RemoteViews;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class TypefaceCompat$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ GenericDocument.Builder m(String str) {
        return new GenericDocument.Builder("", "", str);
    }

    public static /* synthetic */ GenericDocument.Builder m(String str, String str2) {
        return new GenericDocument.Builder("", str, str2);
    }

    public static /* synthetic */ Font.Builder m(Font font) {
        return new Font.Builder(font);
    }

    public static /* synthetic */ ContentInfo.Builder m(ClipData clipData, int i) {
        return new ContentInfo.Builder(clipData, i);
    }

    public static /* synthetic */ RemoteViews m(HashMap map) {
        return new RemoteViews(map);
    }

    public static /* synthetic */ void m() {
    }
}
