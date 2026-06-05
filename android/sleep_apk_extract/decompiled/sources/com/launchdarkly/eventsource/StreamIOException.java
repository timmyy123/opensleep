package com.launchdarkly.eventsource;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes4.dex */
public final class StreamIOException extends StreamException {
    private final IOException ioException;

    public StreamIOException(IOException iOException) {
        super(iOException);
        this.ioException = iOException;
    }

    @Override // com.launchdarkly.eventsource.StreamException
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || StreamIOException.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.ioException, ((StreamIOException) obj).ioException);
    }

    @Override // com.launchdarkly.eventsource.StreamException
    public int hashCode() {
        return Objects.hash(this.ioException);
    }
}
