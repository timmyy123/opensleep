package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSTypeReference;", "Lcom/google/devtools/ksp/symbol/KSAnnotated;", "Lcom/google/devtools/ksp/symbol/KSModifierListOwner;", "Lcom/google/devtools/ksp/symbol/KSType;", "resolve", "()Lcom/google/devtools/ksp/symbol/KSType;", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KSTypeReference extends KSAnnotated, KSModifierListOwner {
    KSType resolve();
}
