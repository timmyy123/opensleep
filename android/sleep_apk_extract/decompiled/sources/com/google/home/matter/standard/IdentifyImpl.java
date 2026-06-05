package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Trait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitImpl;
import com.google.home.matter.standard.IdentifyTrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u0004\u0018\u00010\u001e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001a\u0010(\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b)\u0010%R\u0014\u0010-\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u00100\u001a\u00020\u001a8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00061"}, d2 = {"Lcom/google/home/matter/standard/IdentifyImpl;", "Lcom/google/home/matter/standard/Identify;", "Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/matter/standard/IdentifyTrait$Attributes;", "", "Lcom/google/home/matter/standard/IdentifyTrait$MutableAttributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/IdentifyTrait$Attributes;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/matter/standard/IdentifyTrait$Attributes;", "getAttributes$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/IdentifyTrait$Attributes;", "Lkotlin/UShort;", "getIdentifyTime-XRpZGF0", "()Lkotlin/UShort;", "identifyTime", "Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "getIdentifyType", "()Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "identifyType", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "generatedCommandList", "getAcceptedCommandList", "acceptedCommandList", "getAttributeList", "attributeList", "getFeatureMap-pVg5ArA", "()I", "featureMap", "getClusterRevision-Mh2AYeg", "()S", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IdentifyImpl extends MatterTraitImpl implements Identify, IdentifyTrait.Attributes {
    private final IdentifyTrait.Attributes attributes;
    private final Trait.TraitMetadata metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IdentifyImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, IdentifyTrait.Attributes attributes) {
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
        if (!(other instanceof IdentifyImpl)) {
            return false;
        }
        IdentifyImpl identifyImpl = (IdentifyImpl) other;
        return Intrinsics.areEqual(getMetadata(), identifyImpl.getMetadata()) && Intrinsics.areEqual(this.attributes, identifyImpl.attributes);
    }

    @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
    public List<UInt> getAcceptedCommandList() {
        return this.attributes.getAcceptedCommandList();
    }

    @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
    public List<UInt> getAttributeList() {
        return this.attributes.getAttributeList();
    }

    @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
    /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: not valid java name */
    public short getClusterRevision() {
        return this.attributes.getClusterRevision();
    }

    @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
    /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: not valid java name */
    public int getFeatureMap() {
        return this.attributes.getFeatureMap();
    }

    @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
    public List<UInt> getGeneratedCommandList() {
        return this.attributes.getGeneratedCommandList();
    }

    @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
    /* JADX INFO: renamed from: getIdentifyTime-XRpZGF0, reason: not valid java name */
    public UShort getIdentifyTime() {
        return this.attributes.getIdentifyTime();
    }

    @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
    public IdentifyTrait.IdentifyTypeEnum getIdentifyType() {
        return this.attributes.getIdentifyType();
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }

    public String toString() {
        return this.attributes.toString();
    }
}
