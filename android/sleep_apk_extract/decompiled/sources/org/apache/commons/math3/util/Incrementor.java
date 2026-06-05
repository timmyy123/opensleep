package org.apache.commons.math3.util;

import org.apache.commons.math3.exception.MaxCountExceededException;
import org.apache.commons.math3.exception.NullArgumentException;

/* JADX INFO: loaded from: classes5.dex */
public class Incrementor {
    private int count;
    private final MaxCountExceededCallback maxCountCallback;
    private int maximalCount;

    public interface MaxCountExceededCallback {
        void trigger(int i);
    }

    public Incrementor(int i, MaxCountExceededCallback maxCountExceededCallback) {
        this.count = 0;
        if (maxCountExceededCallback == null) {
            throw new NullArgumentException();
        }
        this.maximalCount = i;
        this.maxCountCallback = maxCountExceededCallback;
    }

    public void incrementCount() {
        int i = this.count + 1;
        this.count = i;
        int i2 = this.maximalCount;
        if (i > i2) {
            this.maxCountCallback.trigger(i2);
        }
    }

    public void resetCount() {
        this.count = 0;
    }

    public void setMaximalCount(int i) {
        this.maximalCount = i;
    }

    public Incrementor(int i) {
        this(i, new MaxCountExceededCallback() { // from class: org.apache.commons.math3.util.Incrementor.1
            @Override // org.apache.commons.math3.util.Incrementor.MaxCountExceededCallback
            public void trigger(int i2) {
                throw new MaxCountExceededException(Integer.valueOf(i2));
            }
        });
    }

    public Incrementor() {
        this(0);
    }
}
