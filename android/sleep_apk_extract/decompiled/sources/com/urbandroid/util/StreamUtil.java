package com.urbandroid.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/urbandroid/util/StreamUtil;", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class StreamUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0007J4\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¨\u0006\u000e"}, d2 = {"Lcom/urbandroid/util/StreamUtil$Companion;", "", "<init>", "()V", "copyStreamAndClose", "", "input", "Ljava/io/File;", "out", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", "prependBytes", "", "appendBytes", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void copyStreamAndClose$default(Companion companion, InputStream inputStream, OutputStream outputStream, byte[] bArr, byte[] bArr2, int i, Object obj) throws IOException {
            if ((i & 4) != 0) {
                bArr = null;
            }
            if ((i & 8) != 0) {
                bArr2 = null;
            }
            companion.copyStreamAndClose(inputStream, outputStream, bArr, bArr2);
        }

        public final void copyStreamAndClose(InputStream input, OutputStream out, byte[] prependBytes, byte[] appendBytes) throws IOException {
            int i;
            if (input == null || out == null) {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Stream is null");
                return;
            }
            try {
                if (prependBytes != null) {
                    try {
                        out.write(prependBytes);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                byte[] bArr = new byte[1024];
                do {
                    i = input.read(bArr, 0, 1024);
                    if (i > 0) {
                        out.write(bArr, 0, i);
                    }
                } while (i >= 0);
                if (appendBytes != null) {
                    out.write(appendBytes);
                }
                out.flush();
                out.close();
                input.close();
            } catch (Throwable th) {
                out.flush();
                out.close();
                input.close();
                throw th;
            }
        }

        private Companion() {
        }

        public final void copyStreamAndClose(File input, File out) throws IOException {
            if (input != null && out != null) {
                copyStreamAndClose$default(this, new FileInputStream(input), new FileOutputStream(out), null, null, 12, null);
            } else {
                Utf8$$ExternalSyntheticBUOutline0.m$2("Stream is null");
            }
        }

        public final void copyStreamAndClose(InputStream inputStream, OutputStream outputStream) throws IOException {
            copyStreamAndClose$default(this, inputStream, outputStream, null, null, 12, null);
        }
    }

    public static final void copyStreamAndClose(File file, File file2) throws IOException {
        INSTANCE.copyStreamAndClose(file, file2);
    }

    public static final void copyStreamAndClose(InputStream inputStream, OutputStream outputStream) throws IOException {
        INSTANCE.copyStreamAndClose(inputStream, outputStream);
    }
}
