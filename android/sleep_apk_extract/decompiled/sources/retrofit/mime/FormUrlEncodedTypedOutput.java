package retrofit.mime;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import oauth.signpost.OAuth;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import retrofit.Types$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public final class FormUrlEncodedTypedOutput implements TypedOutput {
    final ByteArrayOutputStream content = new ByteArrayOutputStream();

    public void addField(String str, boolean z, String str2, boolean z2) {
        if (str == null) {
            Types$$ExternalSyntheticBUOutline0.m$1("name");
            return;
        }
        if (str2 == null) {
            Types$$ExternalSyntheticBUOutline0.m$1(SDKConstants.PARAM_VALUE);
            return;
        }
        if (this.content.size() > 0) {
            this.content.write(38);
        }
        if (z) {
            try {
                str = URLEncoder.encode(str, OAuth.ENCODING);
            } catch (IOException e) {
                Utf8$$ExternalSyntheticBUOutline0.m((Throwable) e);
                return;
            }
        }
        if (z2) {
            str2 = URLEncoder.encode(str2, OAuth.ENCODING);
        }
        this.content.write(str.getBytes(OAuth.ENCODING));
        this.content.write(61);
        this.content.write(str2.getBytes(OAuth.ENCODING));
    }

    @Override // retrofit.mime.TypedOutput
    public String fileName() {
        return null;
    }

    @Override // retrofit.mime.TypedOutput
    public long length() {
        return this.content.size();
    }

    @Override // retrofit.mime.TypedOutput
    public String mimeType() {
        return "application/x-www-form-urlencoded; charset=UTF-8";
    }

    @Override // retrofit.mime.TypedOutput
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(this.content.toByteArray());
    }
}
