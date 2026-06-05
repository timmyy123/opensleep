package androidx.core.text;

import android.text.Html;
import android.text.Spanned;

/* JADX INFO: loaded from: classes.dex */
public abstract class HtmlCompat {

    public static class Api24Impl {
        public static Spanned fromHtml(String str, int i) {
            return Html.fromHtml(str, i);
        }
    }

    public static Spanned fromHtml(String str, int i) {
        return Api24Impl.fromHtml(str, i);
    }
}
