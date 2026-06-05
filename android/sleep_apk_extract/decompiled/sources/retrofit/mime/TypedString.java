package retrofit.mime;

import java.io.UnsupportedEncodingException;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class TypedString extends TypedByteArray {
    public TypedString(String str) {
        super("text/plain; charset=UTF-8", convertToBytes(str));
    }

    private static byte[] convertToBytes(String str) {
        try {
            return str.getBytes(OAuth.ENCODING);
        } catch (UnsupportedEncodingException e) {
            Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
            return null;
        }
    }

    @Override // retrofit.mime.TypedByteArray
    public String toString() {
        try {
            return "TypedString[" + new String(getBytes(), OAuth.ENCODING) + "]";
        } catch (UnsupportedEncodingException unused) {
            Utf8$$ExternalSyntheticBUOutline0.m$1((Object) "Must be able to decode UTF-8");
            return null;
        }
    }
}
