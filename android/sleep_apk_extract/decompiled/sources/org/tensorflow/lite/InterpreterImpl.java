package org.tensorflow.lite;

import java.util.HashMap;
import java.util.Map;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
abstract class InterpreterImpl implements AutoCloseable {
    NativeInterpreterWrapper wrapper;

    public static class Options extends InterpreterApi$Options {
        Boolean allowBufferHandleOutput;
        Boolean allowFp16PrecisionForFp32;
    }

    public InterpreterImpl(NativeInterpreterWrapper nativeInterpreterWrapper) {
        this.wrapper = nativeInterpreterWrapper;
    }

    public void checkNotClosed() {
        if (this.wrapper != null) {
            return;
        }
        Utf8$$ExternalSyntheticBUOutline0.m$3("Internal error: The Interpreter has already been closed.");
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        NativeInterpreterWrapper nativeInterpreterWrapper = this.wrapper;
        if (nativeInterpreterWrapper != null) {
            nativeInterpreterWrapper.close();
            this.wrapper = null;
        }
    }

    public void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    public void run(Object obj, Object obj2) {
        HashMap map = new HashMap();
        map.put(0, obj2);
        runForMultipleInputsOutputs(new Object[]{obj}, map);
    }

    public void runForMultipleInputsOutputs(Object[] objArr, Map<Integer, Object> map) {
        checkNotClosed();
        this.wrapper.run(objArr, map);
    }
}
