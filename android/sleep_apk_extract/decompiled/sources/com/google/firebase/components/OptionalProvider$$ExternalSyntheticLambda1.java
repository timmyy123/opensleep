package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class OptionalProvider$$ExternalSyntheticLambda1 implements Provider {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ OptionalProvider$$ExternalSyntheticLambda1(int i) {
        this.$r8$classId = i;
    }

    @Override // com.google.firebase.inject.Provider
    public final Object get() {
        switch (this.$r8$classId) {
            case 0:
                return OptionalProvider.lambda$static$1();
            default:
                return Collections.EMPTY_SET;
        }
    }
}
