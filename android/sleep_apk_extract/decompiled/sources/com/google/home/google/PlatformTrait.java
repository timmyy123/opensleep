package com.google.home.google;

import com.google.home.Trait;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b&\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\b\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/google/PlatformTrait;", "Lcom/google/home/Trait;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/google/PlatformTraitClient;", "traitClient", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/google/PlatformTraitClient;)V", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/google/PlatformTraitClient;", "getTraitClient", "()Lcom/google/home/google/PlatformTraitClient;", "java.com.google.home.whdm.src.com.google.home.google_whdm-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class PlatformTrait implements Trait {
    private final Trait.TraitMetadata metadata;
    private final PlatformTraitClient traitClient;

    public PlatformTrait(Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient) {
        traitMetadata.getClass();
        platformTraitClient.getClass();
        this.metadata = traitMetadata;
        this.traitClient = platformTraitClient;
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }
}
