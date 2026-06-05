package com.google.devtools.ksp.symbol;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/google/devtools/ksp/symbol/KSNode;", "", "Lcom/google/devtools/ksp/symbol/Location;", "getLocation", "()Lcom/google/devtools/ksp/symbol/Location;", "location", "getParent", "()Lcom/google/devtools/ksp/symbol/KSNode;", "parent", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface KSNode {
    Location getLocation();

    KSNode getParent();
}
