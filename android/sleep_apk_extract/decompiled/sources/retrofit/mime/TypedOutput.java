package retrofit.mime;

import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface TypedOutput {
    String fileName();

    long length();

    String mimeType();

    void writeTo(OutputStream outputStream);
}
