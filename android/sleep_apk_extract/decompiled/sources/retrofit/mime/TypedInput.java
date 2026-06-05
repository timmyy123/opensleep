package retrofit.mime;

import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public interface TypedInput {
    InputStream in();

    long length();

    String mimeType();
}
