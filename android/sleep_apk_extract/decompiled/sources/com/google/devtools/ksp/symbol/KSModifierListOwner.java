package com.google.devtools.ksp.symbol;

import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSModifierListOwner;", "Lcom/google/devtools/ksp/symbol/KSNode;", "modifiers", "", "Lcom/google/devtools/ksp/symbol/Modifier;", "getModifiers", "()Ljava/util/Set;", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KSModifierListOwner extends KSNode {
    Set<Modifier> getModifiers();
}
