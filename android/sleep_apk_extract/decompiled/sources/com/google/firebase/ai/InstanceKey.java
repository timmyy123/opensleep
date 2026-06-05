package com.google.firebase.ai;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.firebase.ai.type.GenerativeBackend;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/ai/InstanceKey;", "", "Lcom/google/firebase/ai/type/GenerativeBackend;", "backend", "", "useLimitedUseAppCheckTokens", "<init>", "(Lcom/google/firebase/ai/type/GenerativeBackend;Z)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Lcom/google/firebase/ai/type/GenerativeBackend;", "getBackend", "()Lcom/google/firebase/ai/type/GenerativeBackend;", "Z", "getUseLimitedUseAppCheckTokens", "()Z", "com.google.firebase-ai-logic-firebase-ai"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class InstanceKey {
    private final GenerativeBackend backend;
    private final boolean useLimitedUseAppCheckTokens;

    public InstanceKey(GenerativeBackend generativeBackend, boolean z) {
        generativeBackend.getClass();
        this.backend = generativeBackend;
        this.useLimitedUseAppCheckTokens = z;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InstanceKey)) {
            return false;
        }
        InstanceKey instanceKey = (InstanceKey) other;
        return Intrinsics.areEqual(this.backend, instanceKey.backend) && this.useLimitedUseAppCheckTokens == instanceKey.useLimitedUseAppCheckTokens;
    }

    public final GenerativeBackend getBackend() {
        return this.backend;
    }

    public final boolean getUseLimitedUseAppCheckTokens() {
        return this.useLimitedUseAppCheckTokens;
    }

    public int hashCode() {
        return Boolean.hashCode(this.useLimitedUseAppCheckTokens) + (this.backend.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("InstanceKey(backend=");
        sb.append(this.backend);
        sb.append(", useLimitedUseAppCheckTokens=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.useLimitedUseAppCheckTokens, ')');
    }
}
