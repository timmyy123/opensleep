package com.google.firebase.components;

import com.google.firebase.inject.Provider;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class ComponentRuntime$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Provider f$0;
    public final /* synthetic */ Provider f$1;

    public /* synthetic */ ComponentRuntime$$ExternalSyntheticLambda2(Provider provider, Provider provider2, int i) {
        this.$r8$classId = i;
        this.f$0 = provider;
        this.f$1 = provider2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.$r8$classId) {
            case 0:
                ((OptionalProvider) this.f$0).set(this.f$1);
                break;
            default:
                ((LazySet) this.f$0).add(this.f$1);
                break;
        }
    }
}
