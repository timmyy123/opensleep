package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Trait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitImpl;
import com.google.home.matter.standard.OnOffTrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\n\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u0004\u0018\u00010\u000e8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0016\u0010&\u001a\u0004\u0018\u00010#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b'\u0010%R\u0016\u0010,\u001a\u0004\u0018\u00010)8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020.0-8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020.0-8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00100R\u001a\u00105\u001a\b\u0012\u0004\u0012\u00020.0-8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00100R\u0014\u00109\u001a\u0002068\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b7\u00108R\u0014\u0010<\u001a\u00020#8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010;¨\u0006="}, d2 = {"Lcom/google/home/matter/standard/OnOffImpl;", "Lcom/google/home/matter/standard/OnOff;", "Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/matter/standard/OnOffTrait$Attributes;", "", "Lcom/google/home/matter/standard/OnOffTrait$MutableAttributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/OnOffTrait$Attributes;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "off", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "on", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/matter/standard/OnOffTrait$Attributes;", "getAttributes$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/OnOffTrait$Attributes;", "getOnOff", "()Ljava/lang/Boolean;", "onOff", "getGlobalSceneControl", "globalSceneControl", "Lkotlin/UShort;", "getOnTime-XRpZGF0", "()Lkotlin/UShort;", "onTime", "getOffWaitTime-XRpZGF0", "offWaitTime", "Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "getStartUpOnOff", "()Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "startUpOnOff", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "generatedCommandList", "getAcceptedCommandList", "acceptedCommandList", "getAttributeList", "attributeList", "Lcom/google/home/matter/standard/OnOffTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/OnOffTrait$Feature;", "featureMap", "getClusterRevision-Mh2AYeg", "()S", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OnOffImpl extends MatterTraitImpl implements OnOff, OnOffTrait.Attributes {
    private final OnOffTrait.Attributes attributes;
    private final Trait.TraitMetadata metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OnOffImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, OnOffTrait.Attributes attributes) {
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
        if (!(other instanceof OnOffImpl)) {
            return false;
        }
        OnOffImpl onOffImpl = (OnOffImpl) other;
        return Intrinsics.areEqual(getMetadata(), onOffImpl.getMetadata()) && Intrinsics.areEqual(this.attributes, onOffImpl.attributes);
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    public List<UInt> getAcceptedCommandList() {
        return this.attributes.getAcceptedCommandList();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    public List<UInt> getAttributeList() {
        return this.attributes.getAttributeList();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: not valid java name */
    public short getClusterRevision() {
        return this.attributes.getClusterRevision();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    public OnOffTrait.Feature getFeatureMap() {
        return this.attributes.getFeatureMap();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    public List<UInt> getGeneratedCommandList() {
        return this.attributes.getGeneratedCommandList();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    public Boolean getGlobalSceneControl() {
        return this.attributes.getGlobalSceneControl();
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    /* JADX INFO: renamed from: getOffWaitTime-XRpZGF0, reason: not valid java name */
    public UShort getOffWaitTime() {
        return this.attributes.getOffWaitTime();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    public Boolean getOnOff() {
        return this.attributes.getOnOff();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    /* JADX INFO: renamed from: getOnTime-XRpZGF0, reason: not valid java name */
    public UShort getOnTime() {
        return this.attributes.getOnTime();
    }

    @Override // com.google.home.matter.standard.OnOffTrait.Attributes
    public OnOffTrait.StartUpOnOffEnum getStartUpOnOff() {
        return this.attributes.getStartUpOnOff();
    }

    @Override // com.google.home.matter.standard.OnOffCommands
    public Object off(Continuation<? super Unit> continuation) {
        Object objSendCommand = sendCommand(OnOffTrait.OffCommand.INSTANCE.getRequestId(), new OnOffTrait.OffCommand.Request(), OnOffTrait.OffCommand.Request.INSTANCE, false, continuation);
        return objSendCommand == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendCommand : Unit.INSTANCE;
    }

    @Override // com.google.home.matter.standard.OnOffCommands
    public Object on(Continuation<? super Unit> continuation) {
        Object objSendCommand = sendCommand(OnOffTrait.OnCommand.INSTANCE.getRequestId(), new OnOffTrait.OnCommand.Request(), OnOffTrait.OnCommand.Request.INSTANCE, false, continuation);
        return objSendCommand == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendCommand : Unit.INSTANCE;
    }

    public String toString() {
        return this.attributes.toString();
    }
}
