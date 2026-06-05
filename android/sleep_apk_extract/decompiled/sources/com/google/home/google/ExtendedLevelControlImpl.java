package com.google.home.google;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Trait;
import com.google.home.google.ExtendedLevelControlTrait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\b\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0014\u0010'\u001a\u00020\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/google/home/google/ExtendedLevelControlImpl;", "Lcom/google/home/google/ExtendedLevelControl;", "Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/google/ExtendedLevelControlTrait$Attributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/google/ExtendedLevelControlTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/google/ExtendedLevelControlTrait$Attributes;", "getAttributes$home_platform_traits_google_common_clusters_android", "()Lcom/google/home/google/ExtendedLevelControlTrait$Attributes;", "Lkotlin/UInt;", "getDefaultStepSize-0hXNFcg", "()Lkotlin/UInt;", "defaultStepSize", "", "getGeneratedCommandList", "()Ljava/util/List;", "generatedCommandList", "getAcceptedCommandList", "acceptedCommandList", "getAttributeList", "attributeList", "getFeatureMap-pVg5ArA", "()I", "featureMap", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "clusterRevision", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedLevelControlImpl extends MatterTraitImpl implements ExtendedLevelControl, ExtendedLevelControlTrait.Attributes {
    private final ExtendedLevelControlTrait.Attributes attributes;
    private final Trait.TraitMetadata metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedLevelControlImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, ExtendedLevelControlTrait.Attributes attributes) {
        super(traitMetadata, matterTraitClient);
        traitMetadata.getClass();
        matterTraitClient.getClass();
        attributes.getClass();
        this.metadata = traitMetadata;
        this.attributes = attributes;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExtendedLevelControlImpl)) {
            return false;
        }
        ExtendedLevelControlImpl extendedLevelControlImpl = (ExtendedLevelControlImpl) other;
        return Intrinsics.areEqual(getMetadata(), extendedLevelControlImpl.getMetadata()) && Intrinsics.areEqual(this.attributes, extendedLevelControlImpl.attributes);
    }

    @Override // com.google.home.google.ExtendedLevelControlTrait.Attributes
    public List<UInt> getAcceptedCommandList() {
        return this.attributes.getAcceptedCommandList();
    }

    @Override // com.google.home.google.ExtendedLevelControlTrait.Attributes
    public List<UInt> getAttributeList() {
        return this.attributes.getAttributeList();
    }

    @Override // com.google.home.google.ExtendedLevelControlTrait.Attributes
    /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: not valid java name */
    public short getClusterRevision() {
        return this.attributes.getClusterRevision();
    }

    @Override // com.google.home.google.ExtendedLevelControlTrait.Attributes
    /* JADX INFO: renamed from: getDefaultStepSize-0hXNFcg, reason: not valid java name */
    public UInt getDefaultStepSize() {
        return this.attributes.getDefaultStepSize();
    }

    @Override // com.google.home.google.ExtendedLevelControlTrait.Attributes
    /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: not valid java name */
    public int getFeatureMap() {
        return this.attributes.getFeatureMap();
    }

    @Override // com.google.home.google.ExtendedLevelControlTrait.Attributes
    public List<UInt> getGeneratedCommandList() {
        return this.attributes.getGeneratedCommandList();
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }

    public String toString() {
        return this.attributes.toString();
    }
}
