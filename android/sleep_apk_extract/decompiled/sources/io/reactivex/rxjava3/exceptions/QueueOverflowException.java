package io.reactivex.rxjava3.exceptions;

/* JADX INFO: loaded from: classes5.dex */
public final class QueueOverflowException extends RuntimeException {
    private static final long serialVersionUID = 8517344746016032542L;

    public QueueOverflowException() {
        this("Queue overflow due to illegal concurrent onNext calls or a bug in an operator");
    }

    public QueueOverflowException(String str) {
        super(str);
    }
}
