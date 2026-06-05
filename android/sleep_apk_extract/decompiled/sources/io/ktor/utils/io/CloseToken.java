package io.ktor.utils.io;

import java.io.IOException;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;
import kotlinx.coroutines.ExceptionsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0003\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lio/ktor/utils/io/CloseToken;", "", "", "origin", "<init>", "(Ljava/lang/Throwable;)V", "closedException", "Ljava/lang/Throwable;", "getCause", "()Ljava/lang/Throwable;", "cause", "ktor-io"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CloseToken {
    private final Throwable closedException;

    /* JADX WARN: Multi-variable type inference failed */
    public CloseToken(Throwable th) {
        Throwable iOException;
        if (th == 0) {
            iOException = null;
        } else if (th instanceof CancellationException) {
            if (th instanceof CopyableThrowable) {
                iOException = ((CopyableThrowable) th).createCopy();
            } else {
                String message = ((CancellationException) th).getMessage();
                iOException = ExceptionsKt.CancellationException(message == null ? "Channel was cancelled" : message, th);
            }
        } else if ((th instanceof IOException) && (th instanceof CopyableThrowable)) {
            iOException = ((CopyableThrowable) th).createCopy();
        } else {
            String message2 = th.getMessage();
            iOException = new IOException(message2 == null ? "Channel was closed" : message2, th);
        }
        this.closedException = iOException;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Throwable getCause() {
        Throwable th = this.closedException;
        if (th == 0) {
            return null;
        }
        if (th instanceof IOException) {
            return th instanceof CopyableThrowable ? ((CopyableThrowable) th).createCopy() : new IOException(((IOException) th).getMessage(), this.closedException);
        }
        if (!(th instanceof CopyableThrowable)) {
            return ExceptionsKt.CancellationException(th.getMessage(), this.closedException);
        }
        Throwable thCreateCopy = ((CopyableThrowable) th).createCopy();
        return thCreateCopy == null ? ExceptionsKt.CancellationException(this.closedException.getMessage(), this.closedException) : thCreateCopy;
    }
}
