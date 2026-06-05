package androidx.core.graphics;

import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.provider.FontsContractCompat;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class TypefaceCompatApi31Impl extends TypefaceCompatApi29Impl {
    private static Typeface getSystemFontFamily(String str) {
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }

    @Override // androidx.core.graphics.TypefaceCompatApi29Impl
    public Font getFontFromSystemFont(FontsContractCompat.FontInfo fontInfo) {
        Typeface systemFontFamily;
        Font fontGuessPrimaryFont;
        String systemFont = fontInfo.getSystemFont();
        if (systemFont == null || (systemFontFamily = getSystemFontFamily(systemFont)) == null || (fontGuessPrimaryFont = TypefaceCompat.guessPrimaryFont(systemFontFamily)) == null) {
            return null;
        }
        if (TextUtils.isEmpty(fontInfo.getVariationSettings())) {
            return fontGuessPrimaryFont;
        }
        try {
            return new Font.Builder(fontGuessPrimaryFont).setFontVariationSettings(fontInfo.getVariationSettings()).build();
        } catch (IOException unused) {
            Log.e("TypefaceCompatApi31Impl", "Failed to clone Font instance. Fall back to provider font.");
            return null;
        }
    }
}
