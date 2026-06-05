package io.reactivex.rxjava3.exceptions;

/* JADX INFO: loaded from: classes5.dex */
public final class MissingBackpressureException extends RuntimeException {
    private static final long serialVersionUID = 8517344746016032542L;

    public MissingBackpressureException(String str) {
        super(str);
    }

    public static MissingBackpressureException createDefault() {
        return new MissingBackpressureException("Could not emit value due to lack of requests");
    }
}
