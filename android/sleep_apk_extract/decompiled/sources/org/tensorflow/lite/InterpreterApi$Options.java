package org.tensorflow.lite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.acceleration.ValidatedAccelerationConfig;

/* JADX INFO: loaded from: classes5.dex */
public abstract class InterpreterApi$Options {
    Boolean allowCancellation;
    Boolean useNNAPI;
    Boolean useXNNPACK;
    TfLiteRuntime runtime = TfLiteRuntime.FROM_APPLICATION_ONLY;
    int numThreads = -1;
    final List<Delegate> delegates = new ArrayList();
    private final List<Object> delegateFactories = new ArrayList();

    public enum TfLiteRuntime {
        FROM_APPLICATION_ONLY,
        FROM_SYSTEM_ONLY,
        PREFER_SYSTEM_OVER_APPLICATION
    }

    public ValidatedAccelerationConfig getAccelerationConfig() {
        return null;
    }

    public List<Object> getDelegateFactories() {
        return Collections.unmodifiableList(this.delegateFactories);
    }

    public List<Delegate> getDelegates() {
        return Collections.unmodifiableList(this.delegates);
    }

    public int getNumThreads() {
        return this.numThreads;
    }

    public TfLiteRuntime getRuntime() {
        return this.runtime;
    }

    public boolean getUseNNAPI() {
        Boolean bool = this.useNNAPI;
        return bool != null && bool.booleanValue();
    }

    public boolean getUseXNNPACK() {
        Boolean bool = this.useXNNPACK;
        return bool == null || bool.booleanValue();
    }

    public boolean isCancellable() {
        Boolean bool = this.allowCancellation;
        return bool != null && bool.booleanValue();
    }
}
