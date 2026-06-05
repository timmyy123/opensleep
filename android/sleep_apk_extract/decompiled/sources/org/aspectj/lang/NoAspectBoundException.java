package org.aspectj.lang;

/* JADX INFO: loaded from: classes5.dex */
public class NoAspectBoundException extends RuntimeException {
    Throwable cause;

    /* JADX WARN: Illegal instructions before constructor call */
    public NoAspectBoundException(String str, Throwable th) {
        if (th != null) {
            str = "Exception while initializing " + str + ": " + th;
        }
        super(str);
        this.cause = th;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
