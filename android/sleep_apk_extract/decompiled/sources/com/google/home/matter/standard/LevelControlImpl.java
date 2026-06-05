package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Trait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitImpl;
import com.google.home.matter.standard.LevelControlTrait;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J2\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0096@¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!R\u001a\u0010\n\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u0016\u0010'\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010*\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b+\u0010&R\u0016\u0010.\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010&R\u0016\u00100\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u0010)R\u0016\u00102\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b1\u0010)R\u0016\u00104\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b3\u0010)R\u0016\u00107\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b5\u00106R\u0016\u00109\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010)R\u0016\u0010;\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u0010&R\u0016\u0010=\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b<\u0010)R\u0016\u0010?\u001a\u0004\u0018\u00010\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b>\u0010)R\u0016\u0010A\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b@\u0010&R\u0016\u0010C\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010&R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020E0D8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bF\u0010GR\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020E0D8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bI\u0010GR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020E0D8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010GR\u0014\u0010P\u001a\u00020M8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0014\u0010S\u001a\u00020\u00138\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010R¨\u0006T"}, d2 = {"Lcom/google/home/matter/standard/LevelControlImpl;", "Lcom/google/home/matter/standard/LevelControl;", "Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "", "Lcom/google/home/matter/standard/LevelControlTrait$MutableAttributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/LevelControlTrait$Attributes;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/UByte;", "level", "Lkotlin/UShort;", "transitionTime", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "optionsMask", "optionsOverride", "", "moveToLevel-igwrCe0", "(BLkotlin/UShort;Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveToLevel", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "getAttributes$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "getCurrentLevel-7PGSa80", "()Lkotlin/UByte;", "currentLevel", "getRemainingTime-XRpZGF0", "()Lkotlin/UShort;", "remainingTime", "getMinLevel-7PGSa80", "minLevel", "getMaxLevel-7PGSa80", "maxLevel", "getCurrentFrequency-XRpZGF0", "currentFrequency", "getMinFrequency-XRpZGF0", "minFrequency", "getMaxFrequency-XRpZGF0", "maxFrequency", "getOptions", "()Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "getOnOffTransitionTime-XRpZGF0", "onOffTransitionTime", "getOnLevel-7PGSa80", "onLevel", "getOnTransitionTime-XRpZGF0", "onTransitionTime", "getOffTransitionTime-XRpZGF0", "offTransitionTime", "getDefaultMoveRate-7PGSa80", "defaultMoveRate", "getStartUpCurrentLevel-7PGSa80", "startUpCurrentLevel", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "generatedCommandList", "getAcceptedCommandList", "acceptedCommandList", "getAttributeList", "attributeList", "Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "featureMap", "getClusterRevision-Mh2AYeg", "()S", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LevelControlImpl extends MatterTraitImpl implements LevelControl, LevelControlTrait.Attributes {
    private final LevelControlTrait.Attributes attributes;
    private final Trait.TraitMetadata metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LevelControlImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, LevelControlTrait.Attributes attributes) {
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
        if (!(other instanceof LevelControlImpl)) {
            return false;
        }
        LevelControlImpl levelControlImpl = (LevelControlImpl) other;
        return Intrinsics.areEqual(getMetadata(), levelControlImpl.getMetadata()) && Intrinsics.areEqual(this.attributes, levelControlImpl.attributes);
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    public List<UInt> getAcceptedCommandList() {
        return this.attributes.getAcceptedCommandList();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    public List<UInt> getAttributeList() {
        return this.attributes.getAttributeList();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: not valid java name */
    public short getClusterRevision() {
        return this.attributes.getClusterRevision();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getCurrentFrequency-XRpZGF0, reason: not valid java name */
    public UShort getCurrentFrequency() {
        return this.attributes.getCurrentFrequency();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getCurrentLevel-7PGSa80, reason: not valid java name */
    public UByte getCurrentLevel() {
        return this.attributes.getCurrentLevel();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getDefaultMoveRate-7PGSa80, reason: not valid java name */
    public UByte getDefaultMoveRate() {
        return this.attributes.getDefaultMoveRate();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    public LevelControlTrait.Feature getFeatureMap() {
        return this.attributes.getFeatureMap();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    public List<UInt> getGeneratedCommandList() {
        return this.attributes.getGeneratedCommandList();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getMaxFrequency-XRpZGF0, reason: not valid java name */
    public UShort getMaxFrequency() {
        return this.attributes.getMaxFrequency();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getMaxLevel-7PGSa80, reason: not valid java name */
    public UByte getMaxLevel() {
        return this.attributes.getMaxLevel();
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getMinFrequency-XRpZGF0, reason: not valid java name */
    public UShort getMinFrequency() {
        return this.attributes.getMinFrequency();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getMinLevel-7PGSa80, reason: not valid java name */
    public UByte getMinLevel() {
        return this.attributes.getMinLevel();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getOffTransitionTime-XRpZGF0, reason: not valid java name */
    public UShort getOffTransitionTime() {
        return this.attributes.getOffTransitionTime();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getOnLevel-7PGSa80, reason: not valid java name */
    public UByte getOnLevel() {
        return this.attributes.getOnLevel();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getOnOffTransitionTime-XRpZGF0, reason: not valid java name */
    public UShort getOnOffTransitionTime() {
        return this.attributes.getOnOffTransitionTime();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getOnTransitionTime-XRpZGF0, reason: not valid java name */
    public UShort getOnTransitionTime() {
        return this.attributes.getOnTransitionTime();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    public LevelControlTrait.OptionsBitmap getOptions() {
        return this.attributes.getOptions();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getRemainingTime-XRpZGF0, reason: not valid java name */
    public UShort getRemainingTime() {
        return this.attributes.getRemainingTime();
    }

    @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
    /* JADX INFO: renamed from: getStartUpCurrentLevel-7PGSa80, reason: not valid java name */
    public UByte getStartUpCurrentLevel() {
        return this.attributes.getStartUpCurrentLevel();
    }

    @Override // com.google.home.matter.standard.LevelControlCommands
    /* JADX INFO: renamed from: moveToLevel-igwrCe0 */
    public Object mo711moveToLeveligwrCe0(byte b, UShort uShort, LevelControlTrait.OptionsBitmap optionsBitmap, LevelControlTrait.OptionsBitmap optionsBitmap2, Continuation<? super Unit> continuation) {
        Object objSendCommand = sendCommand(LevelControlTrait.MoveToLevelCommand.INSTANCE.getRequestId(), new LevelControlTrait.MoveToLevelCommand.Request(b, uShort, optionsBitmap, optionsBitmap2, null), LevelControlTrait.MoveToLevelCommand.Request.INSTANCE, false, continuation);
        return objSendCommand == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendCommand : Unit.INSTANCE;
    }

    public String toString() {
        return this.attributes.toString();
    }
}
