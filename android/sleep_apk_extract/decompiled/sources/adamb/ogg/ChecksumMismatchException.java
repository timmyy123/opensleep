package adamb.ogg;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class ChecksumMismatchException extends IOException {
    public ChecksumMismatchException() {
        super("Mismatch between declared and calculated checksum value due to data corruption.");
    }
}
