package com.google.home;

import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J-\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\b\b\u0000\u0010\u0007*\u00020\u00062\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\bH'¢\u0006\u0004\b\t\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/google/home/HomeDevice;", "Lcom/google/home/HasId;", "Lcom/google/home/HasTraits;", "Lcom/google/home/HasDeviceTypes;", "Lcom/google/home/HasConnectivityState;", "", "Lcom/google/home/Trait;", "T", "Lcom/google/home/TraitFactory;", "trait", "Lkotlinx/coroutines/flow/Flow;", "(Lcom/google/home/TraitFactory;)Lkotlinx/coroutines/flow/Flow;", "", "getName", "()Ljava/lang/String;", "name", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface HomeDevice extends HasId, HasTraits, HasDeviceTypes, HasConnectivityState {
    /* JADX INFO: renamed from: getName */
    String getZzb();

    <T extends Trait> Flow<T> trait(TraitFactory<T> trait);
}
