package com.facebook.internal;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u00038gX¦\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/facebook/internal/DialogFeature;", "", "name", "", "name$annotations", "()V", "()Ljava/lang/String;", "getAction", "getMinVersion", "", "facebook-common_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface DialogFeature {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void name$annotations() {
        }
    }

    String getAction();

    int getMinVersion();

    String name();
}
