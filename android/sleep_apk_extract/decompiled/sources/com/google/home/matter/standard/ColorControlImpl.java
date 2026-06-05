package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Trait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitImpl;
import com.google.home.matter.standard.ColorControlTrait;
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
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\bq\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004B\u001f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J8\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u001a\u0010\u001bJ0\u0010 \u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0096@¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010$\u001a\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u00038\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010'\u001a\u0004\b(\u0010)R\u0016\u0010,\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R\u0016\u0010.\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b-\u0010+R\u0016\u00101\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00103\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00100R\u0016\u00105\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b4\u00100R\u0016\u00107\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u0010+R\u0016\u00109\u001a\u0004\u0018\u00010!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b8\u0010#R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b:\u00100R\u0016\u0010<\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b;\u0010+R\u0016\u0010>\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b=\u0010+R\u0016\u0010@\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b?\u0010+R\u0016\u0010B\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bA\u00100R\u0016\u0010D\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bC\u00100R\u0016\u0010F\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bE\u0010+R\u0016\u0010H\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bG\u00100R\u0016\u0010J\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bI\u00100R\u0016\u0010L\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bK\u0010+R\u0016\u0010N\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u00100R\u0016\u0010P\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bO\u00100R\u0016\u0010R\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bQ\u0010+R\u0016\u0010T\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bS\u00100R\u0016\u0010V\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bU\u00100R\u0016\u0010X\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bW\u0010+R\u0016\u0010Z\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bY\u00100R\u0016\u0010\\\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b[\u00100R\u0016\u0010^\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b]\u0010+R\u0016\u0010`\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b_\u00100R\u0016\u0010b\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\ba\u00100R\u0016\u0010d\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bc\u0010+R\u0016\u0010f\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\be\u00100R\u0016\u0010h\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bg\u00100R\u0016\u0010j\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bi\u00100R\u0016\u0010l\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bk\u00100R\u0016\u0010n\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bm\u0010+R\u0016\u0010p\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bo\u00100R\u0016\u0010r\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bq\u00100R\u0016\u0010t\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bs\u0010+R\u0016\u0010v\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bu\u00100R\u0016\u0010x\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bw\u00100R\u0016\u0010z\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\by\u0010+R\u0016\u0010|\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b{\u00100R\u0016\u0010~\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b}\u0010+R\u0017\u0010\u0080\u0001\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u007f\u0010+R\u0018\u0010\u0082\u0001\u001a\u0004\u0018\u00010\u00118\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0081\u0001\u0010+R\u0018\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0083\u0001\u00100R\u0018\u0010\u0086\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0085\u0001\u00100R\u0018\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0087\u0001\u00100R\u0018\u0010\u008a\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0089\u0001\u00100R\u0018\u0010\u008c\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008b\u0001\u00100R\u0018\u0010\u008e\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008d\u0001\u00100R\u0018\u0010\u0090\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u00100R\u0018\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00158\u0016X\u0096\u0005¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u00100R\u001f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001f\u0010\u0099\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u0098\u0001\u0010\u0096\u0001R\u001f\u0010\u009b\u0001\u001a\n\u0012\u0005\u0012\u00030\u0094\u00010\u0093\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u009a\u0001\u0010\u0096\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009c\u00018\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001R\u0017\u0010¢\u0001\u001a\u00020\u00158\u0016X\u0096\u0005¢\u0006\b\u001a\u0006\b \u0001\u0010¡\u0001¨\u0006£\u0001"}, d2 = {"Lcom/google/home/matter/standard/ColorControlImpl;", "Lcom/google/home/matter/standard/ColorControl;", "Lcom/google/home/matter/MatterTraitImpl;", "Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "", "Lcom/google/home/matter/standard/ColorControlTrait$MutableAttributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/matter/MatterTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/ColorControlTrait$Attributes;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lkotlin/UByte;", "hue", "Lcom/google/home/matter/standard/ColorControlTrait$HueDirection;", "direction", "Lkotlin/UShort;", "transitionTime", "optionsMask", "optionsOverride", "", "moveToHue-B-LVVrw", "(BLcom/google/home/matter/standard/ColorControlTrait$HueDirection;SBBLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveToHue", "colorTemperatureMireds", "moveToColorTemperature-ods4cfk", "(SSBBLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "moveToColorTemperature", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/Trait$TraitMetadata;", "getMetadata", "()Lcom/google/home/Trait$TraitMetadata;", "Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "getAttributes$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "getCurrentHue-7PGSa80", "()Lkotlin/UByte;", "currentHue", "getCurrentSaturation-7PGSa80", "currentSaturation", "getRemainingTime-XRpZGF0", "()Lkotlin/UShort;", "remainingTime", "getCurrentX-XRpZGF0", "currentX", "getCurrentY-XRpZGF0", "currentY", "getDriftCompensation-7PGSa80", "driftCompensation", "getCompensationText", "compensationText", "getColorTemperatureMireds-XRpZGF0", "getColorMode-7PGSa80", "colorMode", "getOptions-7PGSa80", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "getNumberOfPrimaries-7PGSa80", "numberOfPrimaries", "getPrimary1X-XRpZGF0", "primary1X", "getPrimary1Y-XRpZGF0", "primary1Y", "getPrimary1Intensity-7PGSa80", "primary1Intensity", "getPrimary2X-XRpZGF0", "primary2X", "getPrimary2Y-XRpZGF0", "primary2Y", "getPrimary2Intensity-7PGSa80", "primary2Intensity", "getPrimary3X-XRpZGF0", "primary3X", "getPrimary3Y-XRpZGF0", "primary3Y", "getPrimary3Intensity-7PGSa80", "primary3Intensity", "getPrimary4X-XRpZGF0", "primary4X", "getPrimary4Y-XRpZGF0", "primary4Y", "getPrimary4Intensity-7PGSa80", "primary4Intensity", "getPrimary5X-XRpZGF0", "primary5X", "getPrimary5Y-XRpZGF0", "primary5Y", "getPrimary5Intensity-7PGSa80", "primary5Intensity", "getPrimary6X-XRpZGF0", "primary6X", "getPrimary6Y-XRpZGF0", "primary6Y", "getPrimary6Intensity-7PGSa80", "primary6Intensity", "getWhitePointX-XRpZGF0", "whitePointX", "getWhitePointY-XRpZGF0", "whitePointY", "getColorPointRx-XRpZGF0", "colorPointRx", "getColorPointRy-XRpZGF0", "colorPointRy", "getColorPointRIntensity-7PGSa80", "colorPointRIntensity", "getColorPointGx-XRpZGF0", "colorPointGx", "getColorPointGy-XRpZGF0", "colorPointGy", "getColorPointGIntensity-7PGSa80", "colorPointGIntensity", "getColorPointBx-XRpZGF0", "colorPointBx", "getColorPointBy-XRpZGF0", "colorPointBy", "getColorPointBIntensity-7PGSa80", "colorPointBIntensity", "getEnhancedCurrentHue-XRpZGF0", "enhancedCurrentHue", "getEnhancedColorMode-7PGSa80", "enhancedColorMode", "getColorLoopActive-7PGSa80", "colorLoopActive", "getColorLoopDirection-7PGSa80", "colorLoopDirection", "getColorLoopTime-XRpZGF0", "colorLoopTime", "getColorLoopStartEnhancedHue-XRpZGF0", "colorLoopStartEnhancedHue", "getColorLoopStoredEnhancedHue-XRpZGF0", "colorLoopStoredEnhancedHue", "getColorCapabilities-XRpZGF0", "colorCapabilities", "getColorTempPhysicalMinMireds-XRpZGF0", "colorTempPhysicalMinMireds", "getColorTempPhysicalMaxMireds-XRpZGF0", "colorTempPhysicalMaxMireds", "getCoupleColorTempToLevelMinMireds-XRpZGF0", "coupleColorTempToLevelMinMireds", "getStartUpColorTemperatureMireds-XRpZGF0", "startUpColorTemperatureMireds", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "generatedCommandList", "getAcceptedCommandList", "acceptedCommandList", "getAttributeList", "attributeList", "Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "featureMap", "getClusterRevision-Mh2AYeg", "()S", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorControlImpl extends MatterTraitImpl implements ColorControl, ColorControlTrait.Attributes {
    private final ColorControlTrait.Attributes attributes;
    private final Trait.TraitMetadata metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorControlImpl(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, ColorControlTrait.Attributes attributes) {
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
        if (!(other instanceof ColorControlImpl)) {
            return false;
        }
        ColorControlImpl colorControlImpl = (ColorControlImpl) other;
        return Intrinsics.areEqual(getMetadata(), colorControlImpl.getMetadata()) && Intrinsics.areEqual(this.attributes, colorControlImpl.attributes);
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    public List<UInt> getAcceptedCommandList() {
        return this.attributes.getAcceptedCommandList();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    public List<UInt> getAttributeList() {
        return this.attributes.getAttributeList();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: not valid java name */
    public short getClusterRevision() {
        return this.attributes.getClusterRevision();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorCapabilities-XRpZGF0, reason: not valid java name */
    public UShort getColorCapabilities() {
        return this.attributes.getColorCapabilities();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorLoopActive-7PGSa80, reason: not valid java name */
    public UByte getColorLoopActive() {
        return this.attributes.getColorLoopActive();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorLoopDirection-7PGSa80, reason: not valid java name */
    public UByte getColorLoopDirection() {
        return this.attributes.getColorLoopDirection();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorLoopStartEnhancedHue-XRpZGF0, reason: not valid java name */
    public UShort getColorLoopStartEnhancedHue() {
        return this.attributes.getColorLoopStartEnhancedHue();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorLoopStoredEnhancedHue-XRpZGF0, reason: not valid java name */
    public UShort getColorLoopStoredEnhancedHue() {
        return this.attributes.getColorLoopStoredEnhancedHue();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorLoopTime-XRpZGF0, reason: not valid java name */
    public UShort getColorLoopTime() {
        return this.attributes.getColorLoopTime();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorMode-7PGSa80, reason: not valid java name */
    public UByte getColorMode() {
        return this.attributes.getColorMode();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointBIntensity-7PGSa80, reason: not valid java name */
    public UByte getColorPointBIntensity() {
        return this.attributes.getColorPointBIntensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointBx-XRpZGF0, reason: not valid java name */
    public UShort getColorPointBx() {
        return this.attributes.getColorPointBx();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointBy-XRpZGF0, reason: not valid java name */
    public UShort getColorPointBy() {
        return this.attributes.getColorPointBy();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointGIntensity-7PGSa80, reason: not valid java name */
    public UByte getColorPointGIntensity() {
        return this.attributes.getColorPointGIntensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointGx-XRpZGF0, reason: not valid java name */
    public UShort getColorPointGx() {
        return this.attributes.getColorPointGx();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointGy-XRpZGF0, reason: not valid java name */
    public UShort getColorPointGy() {
        return this.attributes.getColorPointGy();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointRIntensity-7PGSa80, reason: not valid java name */
    public UByte getColorPointRIntensity() {
        return this.attributes.getColorPointRIntensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointRx-XRpZGF0, reason: not valid java name */
    public UShort getColorPointRx() {
        return this.attributes.getColorPointRx();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorPointRy-XRpZGF0, reason: not valid java name */
    public UShort getColorPointRy() {
        return this.attributes.getColorPointRy();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorTempPhysicalMaxMireds-XRpZGF0, reason: not valid java name */
    public UShort getColorTempPhysicalMaxMireds() {
        return this.attributes.getColorTempPhysicalMaxMireds();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorTempPhysicalMinMireds-XRpZGF0, reason: not valid java name */
    public UShort getColorTempPhysicalMinMireds() {
        return this.attributes.getColorTempPhysicalMinMireds();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getColorTemperatureMireds-XRpZGF0, reason: not valid java name */
    public UShort getColorTemperatureMireds() {
        return this.attributes.getColorTemperatureMireds();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    public String getCompensationText() {
        return this.attributes.getCompensationText();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getCoupleColorTempToLevelMinMireds-XRpZGF0, reason: not valid java name */
    public UShort getCoupleColorTempToLevelMinMireds() {
        return this.attributes.getCoupleColorTempToLevelMinMireds();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getCurrentHue-7PGSa80, reason: not valid java name */
    public UByte getCurrentHue() {
        return this.attributes.getCurrentHue();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getCurrentSaturation-7PGSa80, reason: not valid java name */
    public UByte getCurrentSaturation() {
        return this.attributes.getCurrentSaturation();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getCurrentX-XRpZGF0, reason: not valid java name */
    public UShort getCurrentX() {
        return this.attributes.getCurrentX();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getCurrentY-XRpZGF0, reason: not valid java name */
    public UShort getCurrentY() {
        return this.attributes.getCurrentY();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getDriftCompensation-7PGSa80, reason: not valid java name */
    public UByte getDriftCompensation() {
        return this.attributes.getDriftCompensation();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getEnhancedColorMode-7PGSa80, reason: not valid java name */
    public UByte getEnhancedColorMode() {
        return this.attributes.getEnhancedColorMode();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getEnhancedCurrentHue-XRpZGF0, reason: not valid java name */
    public UShort getEnhancedCurrentHue() {
        return this.attributes.getEnhancedCurrentHue();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    public ColorControlTrait.Feature getFeatureMap() {
        return this.attributes.getFeatureMap();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    public List<UInt> getGeneratedCommandList() {
        return this.attributes.getGeneratedCommandList();
    }

    @Override // com.google.home.Trait
    public Trait.TraitMetadata getMetadata() {
        return this.metadata;
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getNumberOfPrimaries-7PGSa80, reason: not valid java name */
    public UByte getNumberOfPrimaries() {
        return this.attributes.getNumberOfPrimaries();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getOptions-7PGSa80, reason: not valid java name */
    public UByte getOptions() {
        return this.attributes.getOptions();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary1Intensity-7PGSa80, reason: not valid java name */
    public UByte getPrimary1Intensity() {
        return this.attributes.getPrimary1Intensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary1X-XRpZGF0, reason: not valid java name */
    public UShort getPrimary1X() {
        return this.attributes.getPrimary1X();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary1Y-XRpZGF0, reason: not valid java name */
    public UShort getPrimary1Y() {
        return this.attributes.getPrimary1Y();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary2Intensity-7PGSa80, reason: not valid java name */
    public UByte getPrimary2Intensity() {
        return this.attributes.getPrimary2Intensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary2X-XRpZGF0, reason: not valid java name */
    public UShort getPrimary2X() {
        return this.attributes.getPrimary2X();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary2Y-XRpZGF0, reason: not valid java name */
    public UShort getPrimary2Y() {
        return this.attributes.getPrimary2Y();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary3Intensity-7PGSa80, reason: not valid java name */
    public UByte getPrimary3Intensity() {
        return this.attributes.getPrimary3Intensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary3X-XRpZGF0, reason: not valid java name */
    public UShort getPrimary3X() {
        return this.attributes.getPrimary3X();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary3Y-XRpZGF0, reason: not valid java name */
    public UShort getPrimary3Y() {
        return this.attributes.getPrimary3Y();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary4Intensity-7PGSa80, reason: not valid java name */
    public UByte getPrimary4Intensity() {
        return this.attributes.getPrimary4Intensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary4X-XRpZGF0, reason: not valid java name */
    public UShort getPrimary4X() {
        return this.attributes.getPrimary4X();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary4Y-XRpZGF0, reason: not valid java name */
    public UShort getPrimary4Y() {
        return this.attributes.getPrimary4Y();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary5Intensity-7PGSa80, reason: not valid java name */
    public UByte getPrimary5Intensity() {
        return this.attributes.getPrimary5Intensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary5X-XRpZGF0, reason: not valid java name */
    public UShort getPrimary5X() {
        return this.attributes.getPrimary5X();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary5Y-XRpZGF0, reason: not valid java name */
    public UShort getPrimary5Y() {
        return this.attributes.getPrimary5Y();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary6Intensity-7PGSa80, reason: not valid java name */
    public UByte getPrimary6Intensity() {
        return this.attributes.getPrimary6Intensity();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary6X-XRpZGF0, reason: not valid java name */
    public UShort getPrimary6X() {
        return this.attributes.getPrimary6X();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getPrimary6Y-XRpZGF0, reason: not valid java name */
    public UShort getPrimary6Y() {
        return this.attributes.getPrimary6Y();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getRemainingTime-XRpZGF0, reason: not valid java name */
    public UShort getRemainingTime() {
        return this.attributes.getRemainingTime();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getStartUpColorTemperatureMireds-XRpZGF0, reason: not valid java name */
    public UShort getStartUpColorTemperatureMireds() {
        return this.attributes.getStartUpColorTemperatureMireds();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getWhitePointX-XRpZGF0, reason: not valid java name */
    public UShort getWhitePointX() {
        return this.attributes.getWhitePointX();
    }

    @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
    /* JADX INFO: renamed from: getWhitePointY-XRpZGF0, reason: not valid java name */
    public UShort getWhitePointY() {
        return this.attributes.getWhitePointY();
    }

    @Override // com.google.home.matter.standard.ColorControlCommands
    /* JADX INFO: renamed from: moveToColorTemperature-ods4cfk */
    public Object mo609moveToColorTemperatureods4cfk(short s, short s2, byte b, byte b2, Continuation<? super Unit> continuation) {
        Object objSendCommand = sendCommand(ColorControlTrait.MoveToColorTemperatureCommand.INSTANCE.getRequestId(), new ColorControlTrait.MoveToColorTemperatureCommand.Request(s, s2, b, b2, null), ColorControlTrait.MoveToColorTemperatureCommand.Request.INSTANCE, false, continuation);
        return objSendCommand == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendCommand : Unit.INSTANCE;
    }

    @Override // com.google.home.matter.standard.ColorControlCommands
    /* JADX INFO: renamed from: moveToHue-B-LVVrw */
    public Object mo610moveToHueBLVVrw(byte b, ColorControlTrait.HueDirection hueDirection, short s, byte b2, byte b3, Continuation<? super Unit> continuation) {
        Object objSendCommand = sendCommand(ColorControlTrait.MoveToHueCommand.INSTANCE.getRequestId(), new ColorControlTrait.MoveToHueCommand.Request(b, hueDirection, s, b2, b3, null), ColorControlTrait.MoveToHueCommand.Request.INSTANCE, false, continuation);
        return objSendCommand == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objSendCommand : Unit.INSTANCE;
    }

    public String toString() {
        return this.attributes.toString();
    }
}
