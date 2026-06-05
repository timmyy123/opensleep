package org.tensorflow.lite;

import java.nio.ByteBuffer;
import java.util.Map;
import org.tensorflow.lite.InterpreterImpl;

/* JADX INFO: loaded from: classes5.dex */
public final class Interpreter extends InterpreterImpl implements AutoCloseable {
    private final String[] signatureKeyList;
    private final NativeInterpreterWrapperExperimental wrapperExperimental;

    public static class Options extends InterpreterImpl.Options {
    }

    private Interpreter(NativeInterpreterWrapperExperimental nativeInterpreterWrapperExperimental) {
        super(nativeInterpreterWrapperExperimental);
        this.wrapperExperimental = nativeInterpreterWrapperExperimental;
        this.signatureKeyList = getSignatureKeys();
    }

    @Override // org.tensorflow.lite.InterpreterImpl, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public String[] getSignatureKeys() {
        checkNotClosed();
        return this.wrapper.getSignatureKeys();
    }

    @Override // org.tensorflow.lite.InterpreterImpl
    public /* bridge */ /* synthetic */ void run(Object obj, Object obj2) {
        super.run(obj, obj2);
    }

    @Override // org.tensorflow.lite.InterpreterImpl
    public /* bridge */ /* synthetic */ void runForMultipleInputsOutputs(Object[] objArr, Map map) {
        super.runForMultipleInputsOutputs(objArr, map);
    }

    public Interpreter(ByteBuffer byteBuffer, Options options) {
        this(new NativeInterpreterWrapperExperimental(byteBuffer, options));
    }

    public Interpreter(ByteBuffer byteBuffer) {
        this(byteBuffer, null);
    }
}
