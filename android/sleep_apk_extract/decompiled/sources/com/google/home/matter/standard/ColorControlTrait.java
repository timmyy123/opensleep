package com.google.home.matter.standard;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.HomeException;
import com.google.home.NoOpDescriptor;
import com.google.home.Type;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.google.home.matter.serialization.Bitmap;
import com.google.home.matter.serialization.BitmapAdapter;
import com.google.home.matter.serialization.ClusterBitmap;
import com.google.home.matter.serialization.ClusterEnum;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadReaderKt;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.ClusterPayloadWriterKt;
import com.google.home.matter.serialization.EnumAdapter;
import com.google.home.matter.serialization.MutableBitmap;
import com.google.home.matter.serialization.OptionalValue;
import com.google.home.matter.serialization.ScopedCommandId;
import com.google.home.matter.serialization.StructAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b$\bÆ\u0002\u0018\u00002\u00020\u0001:!\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'(B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006)"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "ColorLoopAction", "ColorLoopDirection", "ColorMode", "HueDirection", "HueMoveMode", "HueStepMode", "SaturationMoveMode", "SaturationStepMode", "ColorCapabilities", "ColorLoopUpdateFlags", "Feature", "Attributes", "AttributesImpl", "MutableAttributes", "MoveToHueCommand", "MoveHueCommand", "StepHueCommand", "MoveToSaturationCommand", "MoveSaturationCommand", "StepSaturationCommand", "MoveToHueAndSaturationCommand", "MoveToColorCommand", "MoveColorCommand", "StepColorCommand", "MoveToColorTemperatureCommand", "EnhancedMoveToHueCommand", "EnhancedMoveHueCommand", "EnhancedStepHueCommand", "EnhancedMoveToHueAndSaturationCommand", "ColorLoopSetCommand", "StopMoveStepCommand", "MoveColorTemperatureCommand", "StepColorTemperatureCommand", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorControlTrait {
    public static final ColorControlTrait INSTANCE = new ColorControlTrait();
    private static final ClusterId Id = new ClusterId(768, "ColorControl", null, 4, null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b]\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u0080\u00012\u00020\u0001:\u0002\u0080\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005R\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005R\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0005R\u0014\u0010\u001e\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000bR\u0014\u0010 \u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u000bR\u0014\u0010\"\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0014\u0010$\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u000bR\u0014\u0010&\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u000bR\u0014\u0010(\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0005R\u0014\u0010*\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b+\u0010\u000bR\u0014\u0010,\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u000bR\u0014\u0010.\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u0010\u0005R\u0014\u00100\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b1\u0010\u000bR\u0014\u00102\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b3\u0010\u000bR\u0014\u00104\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b5\u0010\u0005R\u0014\u00106\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u000bR\u0014\u00108\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b9\u0010\u000bR\u0014\u0010:\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b;\u0010\u0005R\u0014\u0010<\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b=\u0010\u000bR\u0014\u0010>\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b?\u0010\u000bR\u0014\u0010@\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0005R\u0014\u0010B\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u000bR\u0014\u0010D\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bE\u0010\u000bR\u0014\u0010F\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u000bR\u0014\u0010H\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u000bR\u0014\u0010J\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bK\u0010\u0005R\u0014\u0010L\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bM\u0010\u000bR\u0014\u0010N\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u000bR\u0014\u0010P\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010\u0005R\u0014\u0010R\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u000bR\u0014\u0010T\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bU\u0010\u000bR\u0014\u0010V\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\bW\u0010\u0005R\u0014\u0010X\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bY\u0010\u000bR\u0014\u0010Z\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\u0005R\u0014\u0010\\\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b]\u0010\u0005R\u0014\u0010^\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b_\u0010\u0005R\u0014\u0010`\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\ba\u0010\u000bR\u0014\u0010b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bc\u0010\u000bR\u0014\u0010d\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\be\u0010\u000bR\u0014\u0010f\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bg\u0010\u000bR\u0014\u0010h\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bi\u0010\u000bR\u0014\u0010j\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bk\u0010\u000bR\u0014\u0010l\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bm\u0010\u000bR\u0014\u0010n\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\bo\u0010\u000bR\u0018\u0010p\u001a\b\u0012\u0004\u0012\u00020r0qX¦\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0018\u0010u\u001a\b\u0012\u0004\u0012\u00020r0qX¦\u0004¢\u0006\u0006\u001a\u0004\bv\u0010tR\u0018\u0010w\u001a\b\u0012\u0004\u0012\u00020r0qX¦\u0004¢\u0006\u0006\u001a\u0004\bx\u0010tR\u0012\u0010y\u001a\u00020zX¦\u0004¢\u0006\u0006\u001a\u0004\b{\u0010|R\u0012\u0010}\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b~\u0010\u007fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0081\u0001À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "", "currentHue", "Lkotlin/UByte;", "getCurrentHue-7PGSa80", "()Lkotlin/UByte;", "currentSaturation", "getCurrentSaturation-7PGSa80", "remainingTime", "Lkotlin/UShort;", "getRemainingTime-XRpZGF0", "()Lkotlin/UShort;", "currentX", "getCurrentX-XRpZGF0", "currentY", "getCurrentY-XRpZGF0", "driftCompensation", "getDriftCompensation-7PGSa80", "compensationText", "", "getCompensationText", "()Ljava/lang/String;", "colorTemperatureMireds", "getColorTemperatureMireds-XRpZGF0", "colorMode", "getColorMode-7PGSa80", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "getOptions-7PGSa80", "numberOfPrimaries", "getNumberOfPrimaries-7PGSa80", "primary1X", "getPrimary1X-XRpZGF0", "primary1Y", "getPrimary1Y-XRpZGF0", "primary1Intensity", "getPrimary1Intensity-7PGSa80", "primary2X", "getPrimary2X-XRpZGF0", "primary2Y", "getPrimary2Y-XRpZGF0", "primary2Intensity", "getPrimary2Intensity-7PGSa80", "primary3X", "getPrimary3X-XRpZGF0", "primary3Y", "getPrimary3Y-XRpZGF0", "primary3Intensity", "getPrimary3Intensity-7PGSa80", "primary4X", "getPrimary4X-XRpZGF0", "primary4Y", "getPrimary4Y-XRpZGF0", "primary4Intensity", "getPrimary4Intensity-7PGSa80", "primary5X", "getPrimary5X-XRpZGF0", "primary5Y", "getPrimary5Y-XRpZGF0", "primary5Intensity", "getPrimary5Intensity-7PGSa80", "primary6X", "getPrimary6X-XRpZGF0", "primary6Y", "getPrimary6Y-XRpZGF0", "primary6Intensity", "getPrimary6Intensity-7PGSa80", "whitePointX", "getWhitePointX-XRpZGF0", "whitePointY", "getWhitePointY-XRpZGF0", "colorPointRx", "getColorPointRx-XRpZGF0", "colorPointRy", "getColorPointRy-XRpZGF0", "colorPointRIntensity", "getColorPointRIntensity-7PGSa80", "colorPointGx", "getColorPointGx-XRpZGF0", "colorPointGy", "getColorPointGy-XRpZGF0", "colorPointGIntensity", "getColorPointGIntensity-7PGSa80", "colorPointBx", "getColorPointBx-XRpZGF0", "colorPointBy", "getColorPointBy-XRpZGF0", "colorPointBIntensity", "getColorPointBIntensity-7PGSa80", "enhancedCurrentHue", "getEnhancedCurrentHue-XRpZGF0", "enhancedColorMode", "getEnhancedColorMode-7PGSa80", "colorLoopActive", "getColorLoopActive-7PGSa80", "colorLoopDirection", "getColorLoopDirection-7PGSa80", "colorLoopTime", "getColorLoopTime-XRpZGF0", "colorLoopStartEnhancedHue", "getColorLoopStartEnhancedHue-XRpZGF0", "colorLoopStoredEnhancedHue", "getColorLoopStoredEnhancedHue-XRpZGF0", "colorCapabilities", "getColorCapabilities-XRpZGF0", "colorTempPhysicalMinMireds", "getColorTempPhysicalMinMireds-XRpZGF0", "colorTempPhysicalMaxMireds", "getColorTempPhysicalMaxMireds-XRpZGF0", "coupleColorTempToLevelMinMireds", "getCoupleColorTempToLevelMinMireds-XRpZGF0", "startUpColorTemperatureMireds", "getStartUpColorTemperatureMireds-XRpZGF0", "generatedCommandList", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "clusterRevision", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControlTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, ColorControlTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(0, "CurrentHue");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                Unit unit = Unit.INSTANCE;
                UByte orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi02 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(1, "CurrentSaturation");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                UByte orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi03 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(2, "RemainingTime");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                UShort orNull3 = optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi04 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(3, "CurrentX");
                if (optionalValueMo549getOptionalNullableqim9Vi04.isPresent() && optionalValueMo549getOptionalNullableqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                UShort orNull4 = optionalValueMo549getOptionalNullableqim9Vi04.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi05 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(4, "CurrentY");
                if (optionalValueMo549getOptionalNullableqim9Vi05.isPresent() && optionalValueMo549getOptionalNullableqim9Vi05.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                UShort orNull5 = optionalValueMo549getOptionalNullableqim9Vi05.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi06 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(5, "DriftCompensation");
                if (optionalValueMo549getOptionalNullableqim9Vi06.isPresent() && optionalValueMo549getOptionalNullableqim9Vi06.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(5));
                }
                UByte orNull6 = optionalValueMo549getOptionalNullableqim9Vi06.getOrNull();
                OptionalValue<String> optionalValueMo549getOptionalNullableqim9Vi07 = payload$default.getString().mo549getOptionalNullableqim9Vi0(6, "CompensationText");
                if (optionalValueMo549getOptionalNullableqim9Vi07.isPresent() && optionalValueMo549getOptionalNullableqim9Vi07.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(6));
                }
                String orNull7 = optionalValueMo549getOptionalNullableqim9Vi07.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi08 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(7, "ColorTemperatureMireds");
                if (optionalValueMo549getOptionalNullableqim9Vi08.isPresent() && optionalValueMo549getOptionalNullableqim9Vi08.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(7));
                }
                UShort orNull8 = optionalValueMo549getOptionalNullableqim9Vi08.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi09 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(8, "ColorMode");
                if (optionalValueMo549getOptionalNullableqim9Vi09.isPresent() && optionalValueMo549getOptionalNullableqim9Vi09.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(8));
                }
                UByte orNull9 = optionalValueMo549getOptionalNullableqim9Vi09.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi010 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(15, "Options");
                if (optionalValueMo549getOptionalNullableqim9Vi010.isPresent() && optionalValueMo549getOptionalNullableqim9Vi010.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(15));
                }
                UByte orNull10 = optionalValueMo549getOptionalNullableqim9Vi010.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi011 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(16, "NumberOfPrimaries");
                if (optionalValueMo549getOptionalNullableqim9Vi011.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(16));
                }
                UByte orNull11 = optionalValueMo549getOptionalNullableqim9Vi011.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi012 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(17, "Primary1X");
                if (optionalValueMo549getOptionalNullableqim9Vi012.isPresent() && optionalValueMo549getOptionalNullableqim9Vi012.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(17));
                }
                UShort orNull12 = optionalValueMo549getOptionalNullableqim9Vi012.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi013 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(18, "Primary1Y");
                if (optionalValueMo549getOptionalNullableqim9Vi013.isPresent() && optionalValueMo549getOptionalNullableqim9Vi013.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(18));
                }
                UShort orNull13 = optionalValueMo549getOptionalNullableqim9Vi013.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi014 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(19, "Primary1Intensity");
                if (optionalValueMo549getOptionalNullableqim9Vi014.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(19));
                }
                UByte orNull14 = optionalValueMo549getOptionalNullableqim9Vi014.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi015 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(21, "Primary2X");
                if (optionalValueMo549getOptionalNullableqim9Vi015.isPresent() && optionalValueMo549getOptionalNullableqim9Vi015.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(21));
                }
                UShort orNull15 = optionalValueMo549getOptionalNullableqim9Vi015.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi016 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(22, "Primary2Y");
                if (optionalValueMo549getOptionalNullableqim9Vi016.isPresent() && optionalValueMo549getOptionalNullableqim9Vi016.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(22));
                }
                UShort orNull16 = optionalValueMo549getOptionalNullableqim9Vi016.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi017 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(23, "Primary2Intensity");
                if (optionalValueMo549getOptionalNullableqim9Vi017.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(23));
                }
                UByte orNull17 = optionalValueMo549getOptionalNullableqim9Vi017.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi018 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(25, "Primary3X");
                if (optionalValueMo549getOptionalNullableqim9Vi018.isPresent() && optionalValueMo549getOptionalNullableqim9Vi018.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(25));
                }
                UShort orNull18 = optionalValueMo549getOptionalNullableqim9Vi018.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi019 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(26, "Primary3Y");
                if (optionalValueMo549getOptionalNullableqim9Vi019.isPresent() && optionalValueMo549getOptionalNullableqim9Vi019.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(26));
                }
                UShort orNull19 = optionalValueMo549getOptionalNullableqim9Vi019.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi020 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(27, "Primary3Intensity");
                if (optionalValueMo549getOptionalNullableqim9Vi020.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(27));
                }
                UByte orNull20 = optionalValueMo549getOptionalNullableqim9Vi020.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi021 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(32, "Primary4X");
                if (optionalValueMo549getOptionalNullableqim9Vi021.isPresent() && optionalValueMo549getOptionalNullableqim9Vi021.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(32));
                }
                UShort orNull21 = optionalValueMo549getOptionalNullableqim9Vi021.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi022 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(33, "Primary4Y");
                if (optionalValueMo549getOptionalNullableqim9Vi022.isPresent() && optionalValueMo549getOptionalNullableqim9Vi022.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(33));
                }
                UShort orNull22 = optionalValueMo549getOptionalNullableqim9Vi022.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi023 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(34, "Primary4Intensity");
                if (optionalValueMo549getOptionalNullableqim9Vi023.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(34));
                }
                UByte orNull23 = optionalValueMo549getOptionalNullableqim9Vi023.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi024 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(36, "Primary5X");
                if (optionalValueMo549getOptionalNullableqim9Vi024.isPresent() && optionalValueMo549getOptionalNullableqim9Vi024.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(36));
                }
                UShort orNull24 = optionalValueMo549getOptionalNullableqim9Vi024.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi025 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(37, "Primary5Y");
                if (optionalValueMo549getOptionalNullableqim9Vi025.isPresent() && optionalValueMo549getOptionalNullableqim9Vi025.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(37));
                }
                UShort orNull25 = optionalValueMo549getOptionalNullableqim9Vi025.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi026 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(38, "Primary5Intensity");
                if (optionalValueMo549getOptionalNullableqim9Vi026.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(38));
                }
                UByte orNull26 = optionalValueMo549getOptionalNullableqim9Vi026.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi027 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(40, "Primary6X");
                if (optionalValueMo549getOptionalNullableqim9Vi027.isPresent() && optionalValueMo549getOptionalNullableqim9Vi027.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(40));
                }
                UShort orNull27 = optionalValueMo549getOptionalNullableqim9Vi027.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi028 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(41, "Primary6Y");
                if (optionalValueMo549getOptionalNullableqim9Vi028.isPresent() && optionalValueMo549getOptionalNullableqim9Vi028.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(41));
                }
                UShort orNull28 = optionalValueMo549getOptionalNullableqim9Vi028.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi029 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(42, "Primary6Intensity");
                if (optionalValueMo549getOptionalNullableqim9Vi029.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(42));
                }
                UByte orNull29 = optionalValueMo549getOptionalNullableqim9Vi029.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi030 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(48, "WhitePointX");
                if (optionalValueMo549getOptionalNullableqim9Vi030.isPresent() && optionalValueMo549getOptionalNullableqim9Vi030.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(48));
                }
                UShort orNull30 = optionalValueMo549getOptionalNullableqim9Vi030.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi031 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(49, "WhitePointY");
                if (optionalValueMo549getOptionalNullableqim9Vi031.isPresent() && optionalValueMo549getOptionalNullableqim9Vi031.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(49));
                }
                UShort orNull31 = optionalValueMo549getOptionalNullableqim9Vi031.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi032 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(50, "ColorPointRx");
                if (optionalValueMo549getOptionalNullableqim9Vi032.isPresent() && optionalValueMo549getOptionalNullableqim9Vi032.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(50));
                }
                UShort orNull32 = optionalValueMo549getOptionalNullableqim9Vi032.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi033 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(51, "ColorPointRy");
                if (optionalValueMo549getOptionalNullableqim9Vi033.isPresent() && optionalValueMo549getOptionalNullableqim9Vi033.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(51));
                }
                UShort orNull33 = optionalValueMo549getOptionalNullableqim9Vi033.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi034 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(52, "ColorPointRIntensity");
                if (optionalValueMo549getOptionalNullableqim9Vi034.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(52));
                }
                UByte orNull34 = optionalValueMo549getOptionalNullableqim9Vi034.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi035 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(54, "ColorPointGx");
                if (optionalValueMo549getOptionalNullableqim9Vi035.isPresent() && optionalValueMo549getOptionalNullableqim9Vi035.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(54));
                }
                UShort orNull35 = optionalValueMo549getOptionalNullableqim9Vi035.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi036 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(55, "ColorPointGy");
                if (optionalValueMo549getOptionalNullableqim9Vi036.isPresent() && optionalValueMo549getOptionalNullableqim9Vi036.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(55));
                }
                UShort orNull36 = optionalValueMo549getOptionalNullableqim9Vi036.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi037 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(56, "ColorPointGIntensity");
                if (optionalValueMo549getOptionalNullableqim9Vi037.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(56));
                }
                UByte orNull37 = optionalValueMo549getOptionalNullableqim9Vi037.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi038 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(58, "ColorPointBx");
                if (optionalValueMo549getOptionalNullableqim9Vi038.isPresent() && optionalValueMo549getOptionalNullableqim9Vi038.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(58));
                }
                UShort orNull38 = optionalValueMo549getOptionalNullableqim9Vi038.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi039 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(59, "ColorPointBy");
                if (optionalValueMo549getOptionalNullableqim9Vi039.isPresent() && optionalValueMo549getOptionalNullableqim9Vi039.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(59));
                }
                UShort orNull39 = optionalValueMo549getOptionalNullableqim9Vi039.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi040 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(60, "ColorPointBIntensity");
                if (optionalValueMo549getOptionalNullableqim9Vi040.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(60));
                }
                UByte orNull40 = optionalValueMo549getOptionalNullableqim9Vi040.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi041 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16384, "EnhancedCurrentHue");
                if (optionalValueMo549getOptionalNullableqim9Vi041.isPresent() && optionalValueMo549getOptionalNullableqim9Vi041.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16384));
                }
                UShort orNull41 = optionalValueMo549getOptionalNullableqim9Vi041.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi042 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(16385, "EnhancedColorMode");
                if (optionalValueMo549getOptionalNullableqim9Vi042.isPresent() && optionalValueMo549getOptionalNullableqim9Vi042.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16385));
                }
                UByte orNull42 = optionalValueMo549getOptionalNullableqim9Vi042.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi043 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(16386, "ColorLoopActive");
                if (optionalValueMo549getOptionalNullableqim9Vi043.isPresent() && optionalValueMo549getOptionalNullableqim9Vi043.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16386));
                }
                UByte orNull43 = optionalValueMo549getOptionalNullableqim9Vi043.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi044 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(16387, "ColorLoopDirection");
                if (optionalValueMo549getOptionalNullableqim9Vi044.isPresent() && optionalValueMo549getOptionalNullableqim9Vi044.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16387));
                }
                UByte orNull44 = optionalValueMo549getOptionalNullableqim9Vi044.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi045 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16388, "ColorLoopTime");
                if (optionalValueMo549getOptionalNullableqim9Vi045.isPresent() && optionalValueMo549getOptionalNullableqim9Vi045.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16388));
                }
                UShort orNull45 = optionalValueMo549getOptionalNullableqim9Vi045.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi046 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16389, "ColorLoopStartEnhancedHue");
                if (optionalValueMo549getOptionalNullableqim9Vi046.isPresent() && optionalValueMo549getOptionalNullableqim9Vi046.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16389));
                }
                UShort orNull46 = optionalValueMo549getOptionalNullableqim9Vi046.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi047 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16390, "ColorLoopStoredEnhancedHue");
                if (optionalValueMo549getOptionalNullableqim9Vi047.isPresent() && optionalValueMo549getOptionalNullableqim9Vi047.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16390));
                }
                UShort orNull47 = optionalValueMo549getOptionalNullableqim9Vi047.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi048 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16394, "ColorCapabilities");
                if (optionalValueMo549getOptionalNullableqim9Vi048.isPresent() && optionalValueMo549getOptionalNullableqim9Vi048.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16394));
                }
                UShort orNull48 = optionalValueMo549getOptionalNullableqim9Vi048.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi049 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16395, "ColorTempPhysicalMinMireds");
                if (optionalValueMo549getOptionalNullableqim9Vi049.isPresent() && optionalValueMo549getOptionalNullableqim9Vi049.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16395));
                }
                UShort orNull49 = optionalValueMo549getOptionalNullableqim9Vi049.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi050 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16396, "ColorTempPhysicalMaxMireds");
                if (optionalValueMo549getOptionalNullableqim9Vi050.isPresent() && optionalValueMo549getOptionalNullableqim9Vi050.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16396));
                }
                UShort orNull50 = optionalValueMo549getOptionalNullableqim9Vi050.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi051 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16397, "CoupleColorTempToLevelMinMireds");
                if (optionalValueMo549getOptionalNullableqim9Vi051.isPresent() && optionalValueMo549getOptionalNullableqim9Vi051.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16397));
                }
                UShort orNull51 = optionalValueMo549getOptionalNullableqim9Vi051.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi052 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16400, "StartUpColorTemperatureMireds");
                if (optionalValueMo549getOptionalNullableqim9Vi052.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(16400));
                }
                UShort orNull52 = optionalValueMo549getOptionalNullableqim9Vi052.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload$default.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                List<UInt> listMo547getListqim9Vi02 = payload$default.getUint().mo547getListqim9Vi0(65529, "AcceptedCommandList");
                arrayList.add(UInt.m2388boximpl(65529));
                arrayList.add(UInt.m2388boximpl(65531));
                Feature feature = (Feature) payload$default.bitmap(Feature.INSTANCE).mo546getqim9Vi0(65532, "FeatureMap");
                arrayList.add(UInt.m2388boximpl(65532));
                UShort uShortMo546getqim9Vi0 = payload$default.getUshort().mo546getqim9Vi0(65533, "ClusterRevision");
                uShortMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65533));
                return new AttributesImpl(orNull, orNull2, orNull3, orNull4, orNull5, orNull6, orNull7, orNull8, orNull9, orNull10, orNull11, orNull12, orNull13, orNull14, orNull15, orNull16, orNull17, orNull18, orNull19, orNull20, orNull21, orNull22, orNull23, orNull24, orNull25, orNull26, orNull27, orNull28, orNull29, orNull30, orNull31, orNull32, orNull33, orNull34, orNull35, orNull36, orNull37, orNull38, orNull39, orNull40, orNull41, orNull42, orNull43, orNull44, orNull45, orNull46, orNull47, orNull48, orNull49, orNull50, orNull51, orNull52, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, feature, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                if (value instanceof MutableAttributes) {
                    MutableAttributes.INSTANCE.write(writer, (MutableAttributes) value);
                    return;
                }
                ClusterPayloadWriterKt.wrapPayload(writer, ColorControlTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getUbyte().mo554writeqim9Vi0(0, value.getCurrentHue());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.getUbyte().mo554writeqim9Vi0(1, value.getCurrentSaturation());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.getUshort().mo554writeqim9Vi0(2, value.getRemainingTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.getUshort().mo554writeqim9Vi0(3, value.getCurrentX());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.getUshort().mo554writeqim9Vi0(4, value.getCurrentY());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(5))) {
                    writer.getUbyte().mo554writeqim9Vi0(5, value.getDriftCompensation());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(6))) {
                    writer.getString().mo554writeqim9Vi0(6, value.getCompensationText());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(7))) {
                    writer.getUshort().mo554writeqim9Vi0(7, value.getColorTemperatureMireds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(8))) {
                    writer.getUbyte().mo554writeqim9Vi0(8, value.getColorMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(15))) {
                    writer.getUbyte().mo554writeqim9Vi0(15, value.getOptions());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16))) {
                    writer.getUbyte().mo554writeqim9Vi0(16, value.getNumberOfPrimaries());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(17))) {
                    writer.getUshort().mo554writeqim9Vi0(17, value.getPrimary1X());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(18))) {
                    writer.getUshort().mo554writeqim9Vi0(18, value.getPrimary1Y());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(19))) {
                    writer.getUbyte().mo554writeqim9Vi0(19, value.getPrimary1Intensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(21))) {
                    writer.getUshort().mo554writeqim9Vi0(21, value.getPrimary2X());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(22))) {
                    writer.getUshort().mo554writeqim9Vi0(22, value.getPrimary2Y());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(23))) {
                    writer.getUbyte().mo554writeqim9Vi0(23, value.getPrimary2Intensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(25))) {
                    writer.getUshort().mo554writeqim9Vi0(25, value.getPrimary3X());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(26))) {
                    writer.getUshort().mo554writeqim9Vi0(26, value.getPrimary3Y());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(27))) {
                    writer.getUbyte().mo554writeqim9Vi0(27, value.getPrimary3Intensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(32))) {
                    writer.getUshort().mo554writeqim9Vi0(32, value.getPrimary4X());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(33))) {
                    writer.getUshort().mo554writeqim9Vi0(33, value.getPrimary4Y());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(34))) {
                    writer.getUbyte().mo554writeqim9Vi0(34, value.getPrimary4Intensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(36))) {
                    writer.getUshort().mo554writeqim9Vi0(36, value.getPrimary5X());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(37))) {
                    writer.getUshort().mo554writeqim9Vi0(37, value.getPrimary5Y());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(38))) {
                    writer.getUbyte().mo554writeqim9Vi0(38, value.getPrimary5Intensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(40))) {
                    writer.getUshort().mo554writeqim9Vi0(40, value.getPrimary6X());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(41))) {
                    writer.getUshort().mo554writeqim9Vi0(41, value.getPrimary6Y());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(42))) {
                    writer.getUbyte().mo554writeqim9Vi0(42, value.getPrimary6Intensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(48))) {
                    writer.getUshort().mo554writeqim9Vi0(48, value.getWhitePointX());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(49))) {
                    writer.getUshort().mo554writeqim9Vi0(49, value.getWhitePointY());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(50))) {
                    writer.getUshort().mo554writeqim9Vi0(50, value.getColorPointRx());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(51))) {
                    writer.getUshort().mo554writeqim9Vi0(51, value.getColorPointRy());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(52))) {
                    writer.getUbyte().mo554writeqim9Vi0(52, value.getColorPointRIntensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(54))) {
                    writer.getUshort().mo554writeqim9Vi0(54, value.getColorPointGx());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(55))) {
                    writer.getUshort().mo554writeqim9Vi0(55, value.getColorPointGy());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(56))) {
                    writer.getUbyte().mo554writeqim9Vi0(56, value.getColorPointGIntensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(58))) {
                    writer.getUshort().mo554writeqim9Vi0(58, value.getColorPointBx());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(59))) {
                    writer.getUshort().mo554writeqim9Vi0(59, value.getColorPointBy());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(60))) {
                    writer.getUbyte().mo554writeqim9Vi0(60, value.getColorPointBIntensity());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16384))) {
                    writer.getUshort().mo554writeqim9Vi0(16384, value.getEnhancedCurrentHue());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16385))) {
                    writer.getUbyte().mo554writeqim9Vi0(16385, value.getEnhancedColorMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16386))) {
                    writer.getUbyte().mo554writeqim9Vi0(16386, value.getColorLoopActive());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16387))) {
                    writer.getUbyte().mo554writeqim9Vi0(16387, value.getColorLoopDirection());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16388))) {
                    writer.getUshort().mo554writeqim9Vi0(16388, value.getColorLoopTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16389))) {
                    writer.getUshort().mo554writeqim9Vi0(16389, value.getColorLoopStartEnhancedHue());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16390))) {
                    writer.getUshort().mo554writeqim9Vi0(16390, value.getColorLoopStoredEnhancedHue());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16394))) {
                    writer.getUshort().mo554writeqim9Vi0(16394, value.getColorCapabilities());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16395))) {
                    writer.getUshort().mo554writeqim9Vi0(16395, value.getColorTempPhysicalMinMireds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16396))) {
                    writer.getUshort().mo554writeqim9Vi0(16396, value.getColorTempPhysicalMaxMireds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16397))) {
                    writer.getUshort().mo554writeqim9Vi0(16397, value.getCoupleColorTempToLevelMinMireds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16400))) {
                    writer.getUshort().mo554writeqim9Vi0(16400, value.getStartUpColorTemperatureMireds());
                }
                writer.getUint().mo555writeListqim9Vi0(65528, value.getGeneratedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65529, value.getAcceptedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65531, value.getAttributeList());
                writer.bitmap(Feature.INSTANCE).mo554writeqim9Vi0(65532, value.getFeatureMap());
                writer.getUshort().mo554writeqim9Vi0(65533, UShort.m2432boximpl(value.getClusterRevision()));
            }
        }

        List<UInt> getAcceptedCommandList();

        List<UInt> getAttributeList();

        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg */
        short getClusterRevision();

        /* JADX INFO: renamed from: getColorCapabilities-XRpZGF0 */
        UShort getColorCapabilities();

        /* JADX INFO: renamed from: getColorLoopActive-7PGSa80 */
        UByte getColorLoopActive();

        /* JADX INFO: renamed from: getColorLoopDirection-7PGSa80 */
        UByte getColorLoopDirection();

        /* JADX INFO: renamed from: getColorLoopStartEnhancedHue-XRpZGF0 */
        UShort getColorLoopStartEnhancedHue();

        /* JADX INFO: renamed from: getColorLoopStoredEnhancedHue-XRpZGF0 */
        UShort getColorLoopStoredEnhancedHue();

        /* JADX INFO: renamed from: getColorLoopTime-XRpZGF0 */
        UShort getColorLoopTime();

        /* JADX INFO: renamed from: getColorMode-7PGSa80 */
        UByte getColorMode();

        /* JADX INFO: renamed from: getColorPointBIntensity-7PGSa80 */
        UByte getColorPointBIntensity();

        /* JADX INFO: renamed from: getColorPointBx-XRpZGF0 */
        UShort getColorPointBx();

        /* JADX INFO: renamed from: getColorPointBy-XRpZGF0 */
        UShort getColorPointBy();

        /* JADX INFO: renamed from: getColorPointGIntensity-7PGSa80 */
        UByte getColorPointGIntensity();

        /* JADX INFO: renamed from: getColorPointGx-XRpZGF0 */
        UShort getColorPointGx();

        /* JADX INFO: renamed from: getColorPointGy-XRpZGF0 */
        UShort getColorPointGy();

        /* JADX INFO: renamed from: getColorPointRIntensity-7PGSa80 */
        UByte getColorPointRIntensity();

        /* JADX INFO: renamed from: getColorPointRx-XRpZGF0 */
        UShort getColorPointRx();

        /* JADX INFO: renamed from: getColorPointRy-XRpZGF0 */
        UShort getColorPointRy();

        /* JADX INFO: renamed from: getColorTempPhysicalMaxMireds-XRpZGF0 */
        UShort getColorTempPhysicalMaxMireds();

        /* JADX INFO: renamed from: getColorTempPhysicalMinMireds-XRpZGF0 */
        UShort getColorTempPhysicalMinMireds();

        /* JADX INFO: renamed from: getColorTemperatureMireds-XRpZGF0 */
        UShort getColorTemperatureMireds();

        String getCompensationText();

        /* JADX INFO: renamed from: getCoupleColorTempToLevelMinMireds-XRpZGF0 */
        UShort getCoupleColorTempToLevelMinMireds();

        /* JADX INFO: renamed from: getCurrentHue-7PGSa80 */
        UByte getCurrentHue();

        /* JADX INFO: renamed from: getCurrentSaturation-7PGSa80 */
        UByte getCurrentSaturation();

        /* JADX INFO: renamed from: getCurrentX-XRpZGF0 */
        UShort getCurrentX();

        /* JADX INFO: renamed from: getCurrentY-XRpZGF0 */
        UShort getCurrentY();

        /* JADX INFO: renamed from: getDriftCompensation-7PGSa80 */
        UByte getDriftCompensation();

        /* JADX INFO: renamed from: getEnhancedColorMode-7PGSa80 */
        UByte getEnhancedColorMode();

        /* JADX INFO: renamed from: getEnhancedCurrentHue-XRpZGF0 */
        UShort getEnhancedCurrentHue();

        Feature getFeatureMap();

        List<UInt> getGeneratedCommandList();

        /* JADX INFO: renamed from: getNumberOfPrimaries-7PGSa80 */
        UByte getNumberOfPrimaries();

        /* JADX INFO: renamed from: getOptions-7PGSa80 */
        UByte getOptions();

        /* JADX INFO: renamed from: getPrimary1Intensity-7PGSa80 */
        UByte getPrimary1Intensity();

        /* JADX INFO: renamed from: getPrimary1X-XRpZGF0 */
        UShort getPrimary1X();

        /* JADX INFO: renamed from: getPrimary1Y-XRpZGF0 */
        UShort getPrimary1Y();

        /* JADX INFO: renamed from: getPrimary2Intensity-7PGSa80 */
        UByte getPrimary2Intensity();

        /* JADX INFO: renamed from: getPrimary2X-XRpZGF0 */
        UShort getPrimary2X();

        /* JADX INFO: renamed from: getPrimary2Y-XRpZGF0 */
        UShort getPrimary2Y();

        /* JADX INFO: renamed from: getPrimary3Intensity-7PGSa80 */
        UByte getPrimary3Intensity();

        /* JADX INFO: renamed from: getPrimary3X-XRpZGF0 */
        UShort getPrimary3X();

        /* JADX INFO: renamed from: getPrimary3Y-XRpZGF0 */
        UShort getPrimary3Y();

        /* JADX INFO: renamed from: getPrimary4Intensity-7PGSa80 */
        UByte getPrimary4Intensity();

        /* JADX INFO: renamed from: getPrimary4X-XRpZGF0 */
        UShort getPrimary4X();

        /* JADX INFO: renamed from: getPrimary4Y-XRpZGF0 */
        UShort getPrimary4Y();

        /* JADX INFO: renamed from: getPrimary5Intensity-7PGSa80 */
        UByte getPrimary5Intensity();

        /* JADX INFO: renamed from: getPrimary5X-XRpZGF0 */
        UShort getPrimary5X();

        /* JADX INFO: renamed from: getPrimary5Y-XRpZGF0 */
        UShort getPrimary5Y();

        /* JADX INFO: renamed from: getPrimary6Intensity-7PGSa80 */
        UByte getPrimary6Intensity();

        /* JADX INFO: renamed from: getPrimary6X-XRpZGF0 */
        UShort getPrimary6X();

        /* JADX INFO: renamed from: getPrimary6Y-XRpZGF0 */
        UShort getPrimary6Y();

        /* JADX INFO: renamed from: getRemainingTime-XRpZGF0 */
        UShort getRemainingTime();

        /* JADX INFO: renamed from: getStartUpColorTemperatureMireds-XRpZGF0 */
        UShort getStartUpColorTemperatureMireds();

        /* JADX INFO: renamed from: getWhitePointX-XRpZGF0 */
        UShort getWhitePointX();

        /* JADX INFO: renamed from: getWhitePointY-XRpZGF0 */
        UShort getWhitePointY();
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\bJ\b\u0016\u0018\u0000 \u0092\u00012\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u0092\u0001B»\u0005\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010:\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;\u0012\u000e\b\u0002\u0010>\u001a\b\u0012\u0004\u0012\u00020<0;\u0012\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;\u0012\b\b\u0002\u0010A\u001a\u00020@\u0012\b\b\u0002\u0010B\u001a\u00020\u0007¢\u0006\u0004\bC\u0010DJ\u001a\u0010G\u001a\u00020F2\b\u0010E\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\bG\u0010HJ\u000f\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bJ\u0010KJ\u000f\u0010L\u001a\u00020\fH\u0016¢\u0006\u0004\bL\u0010MR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010N\u001a\u0004\bQ\u0010PR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010R\u001a\u0004\bS\u0010TR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010R\u001a\u0004\bU\u0010TR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010R\u001a\u0004\bV\u0010TR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010N\u001a\u0004\bW\u0010PR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010X\u001a\u0004\bY\u0010MR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010R\u001a\u0004\bZ\u0010TR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010N\u001a\u0004\b[\u0010PR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010N\u001a\u0004\b\\\u0010PR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010N\u001a\u0004\b]\u0010PR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010R\u001a\u0004\b^\u0010TR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010R\u001a\u0004\b_\u0010TR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010N\u001a\u0004\b`\u0010PR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u0010R\u001a\u0004\ba\u0010TR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0016\u0010R\u001a\u0004\bb\u0010TR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010N\u001a\u0004\bc\u0010PR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010R\u001a\u0004\bd\u0010TR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010R\u001a\u0004\be\u0010TR\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001a\u0010N\u001a\u0004\bf\u0010PR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010R\u001a\u0004\bg\u0010TR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010R\u001a\u0004\bh\u0010TR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010N\u001a\u0004\bi\u0010PR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001e\u0010R\u001a\u0004\bj\u0010TR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001f\u0010R\u001a\u0004\bk\u0010TR\u001c\u0010 \u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b \u0010N\u001a\u0004\bl\u0010PR\u001c\u0010!\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010R\u001a\u0004\bm\u0010TR\u001c\u0010\"\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010R\u001a\u0004\bn\u0010TR\u001c\u0010#\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010N\u001a\u0004\bo\u0010PR\u001c\u0010$\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b$\u0010R\u001a\u0004\bp\u0010TR\u001c\u0010%\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b%\u0010R\u001a\u0004\bq\u0010TR\u001c\u0010&\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b&\u0010R\u001a\u0004\br\u0010TR\u001c\u0010'\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b'\u0010R\u001a\u0004\bs\u0010TR\u001c\u0010(\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b(\u0010N\u001a\u0004\bt\u0010PR\u001c\u0010)\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b)\u0010R\u001a\u0004\bu\u0010TR\u001c\u0010*\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b*\u0010R\u001a\u0004\bv\u0010TR\u001c\u0010+\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b+\u0010N\u001a\u0004\bw\u0010PR\u001c\u0010,\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b,\u0010R\u001a\u0004\bx\u0010TR\u001c\u0010-\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b-\u0010R\u001a\u0004\by\u0010TR\u001c\u0010.\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b.\u0010N\u001a\u0004\bz\u0010PR\u001c\u0010/\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b/\u0010R\u001a\u0004\b{\u0010TR\u001c\u00100\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b0\u0010N\u001a\u0004\b|\u0010PR\u001c\u00101\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b1\u0010N\u001a\u0004\b}\u0010PR\u001c\u00102\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b2\u0010N\u001a\u0004\b~\u0010PR\u001c\u00103\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b3\u0010R\u001a\u0004\b\u007f\u0010TR\u001d\u00104\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b4\u0010R\u001a\u0005\b\u0080\u0001\u0010TR\u001d\u00105\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b5\u0010R\u001a\u0005\b\u0081\u0001\u0010TR\u001d\u00106\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b6\u0010R\u001a\u0005\b\u0082\u0001\u0010TR\u001d\u00107\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b7\u0010R\u001a\u0005\b\u0083\u0001\u0010TR\u001d\u00108\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b8\u0010R\u001a\u0005\b\u0084\u0001\u0010TR\u001d\u00109\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b9\u0010R\u001a\u0005\b\u0085\u0001\u0010TR\u001d\u0010:\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\r\n\u0004\b:\u0010R\u001a\u0005\b\u0086\u0001\u0010TR#\u0010=\u001a\b\u0012\u0004\u0012\u00020<0;8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b=\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R#\u0010>\u001a\b\u0012\u0004\u0012\u00020<0;8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b>\u0010\u0087\u0001\u001a\u0006\b\u008a\u0001\u0010\u0089\u0001R#\u0010?\u001a\b\u0012\u0004\u0012\u00020<0;8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b?\u0010\u0087\u0001\u001a\u0006\b\u008b\u0001\u0010\u0089\u0001R\u001d\u0010A\u001a\u00020@8\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bA\u0010\u008c\u0001\u001a\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001d\u0010B\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\bB\u0010\u008f\u0001\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001¨\u0006\u0093\u0001"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$AttributesImpl;", "Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "", "Lcom/google/home/matter/standard/ColorControlTrait$MutableAttributes;", "Lkotlin/UByte;", "currentHue", "currentSaturation", "Lkotlin/UShort;", "remainingTime", "currentX", "currentY", "driftCompensation", "", "compensationText", "colorTemperatureMireds", "colorMode", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "numberOfPrimaries", "primary1X", "primary1Y", "primary1Intensity", "primary2X", "primary2Y", "primary2Intensity", "primary3X", "primary3Y", "primary3Intensity", "primary4X", "primary4Y", "primary4Intensity", "primary5X", "primary5Y", "primary5Intensity", "primary6X", "primary6Y", "primary6Intensity", "whitePointX", "whitePointY", "colorPointRx", "colorPointRy", "colorPointRIntensity", "colorPointGx", "colorPointGy", "colorPointGIntensity", "colorPointBx", "colorPointBy", "colorPointBIntensity", "enhancedCurrentHue", "enhancedColorMode", "colorLoopActive", "colorLoopDirection", "colorLoopTime", "colorLoopStartEnhancedHue", "colorLoopStoredEnhancedHue", "colorCapabilities", "colorTempPhysicalMinMireds", "colorTempPhysicalMaxMireds", "coupleColorTempToLevelMinMireds", "startUpColorTemperatureMireds", "", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "featureMap", "clusterRevision", "<init>", "(Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Ljava/lang/String;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/google/home/matter/standard/ColorControlTrait$Feature;SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UByte;", "getCurrentHue-7PGSa80", "()Lkotlin/UByte;", "getCurrentSaturation-7PGSa80", "Lkotlin/UShort;", "getRemainingTime-XRpZGF0", "()Lkotlin/UShort;", "getCurrentX-XRpZGF0", "getCurrentY-XRpZGF0", "getDriftCompensation-7PGSa80", "Ljava/lang/String;", "getCompensationText", "getColorTemperatureMireds-XRpZGF0", "getColorMode-7PGSa80", "getOptions-7PGSa80", "getNumberOfPrimaries-7PGSa80", "getPrimary1X-XRpZGF0", "getPrimary1Y-XRpZGF0", "getPrimary1Intensity-7PGSa80", "getPrimary2X-XRpZGF0", "getPrimary2Y-XRpZGF0", "getPrimary2Intensity-7PGSa80", "getPrimary3X-XRpZGF0", "getPrimary3Y-XRpZGF0", "getPrimary3Intensity-7PGSa80", "getPrimary4X-XRpZGF0", "getPrimary4Y-XRpZGF0", "getPrimary4Intensity-7PGSa80", "getPrimary5X-XRpZGF0", "getPrimary5Y-XRpZGF0", "getPrimary5Intensity-7PGSa80", "getPrimary6X-XRpZGF0", "getPrimary6Y-XRpZGF0", "getPrimary6Intensity-7PGSa80", "getWhitePointX-XRpZGF0", "getWhitePointY-XRpZGF0", "getColorPointRx-XRpZGF0", "getColorPointRy-XRpZGF0", "getColorPointRIntensity-7PGSa80", "getColorPointGx-XRpZGF0", "getColorPointGy-XRpZGF0", "getColorPointGIntensity-7PGSa80", "getColorPointBx-XRpZGF0", "getColorPointBy-XRpZGF0", "getColorPointBIntensity-7PGSa80", "getEnhancedCurrentHue-XRpZGF0", "getEnhancedColorMode-7PGSa80", "getColorLoopActive-7PGSa80", "getColorLoopDirection-7PGSa80", "getColorLoopTime-XRpZGF0", "getColorLoopStartEnhancedHue-XRpZGF0", "getColorLoopStoredEnhancedHue-XRpZGF0", "getColorCapabilities-XRpZGF0", "getColorTempPhysicalMinMireds-XRpZGF0", "getColorTempPhysicalMaxMireds-XRpZGF0", "getCoupleColorTempToLevelMinMireds-XRpZGF0", "getStartUpColorTemperatureMireds-XRpZGF0", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final UShort colorCapabilities;
        private final UByte colorLoopActive;
        private final UByte colorLoopDirection;
        private final UShort colorLoopStartEnhancedHue;
        private final UShort colorLoopStoredEnhancedHue;
        private final UShort colorLoopTime;
        private final UByte colorMode;
        private final UByte colorPointBIntensity;
        private final UShort colorPointBx;
        private final UShort colorPointBy;
        private final UByte colorPointGIntensity;
        private final UShort colorPointGx;
        private final UShort colorPointGy;
        private final UByte colorPointRIntensity;
        private final UShort colorPointRx;
        private final UShort colorPointRy;
        private final UShort colorTempPhysicalMaxMireds;
        private final UShort colorTempPhysicalMinMireds;
        private final UShort colorTemperatureMireds;
        private final String compensationText;
        private final UShort coupleColorTempToLevelMinMireds;
        private final UByte currentHue;
        private final UByte currentSaturation;
        private final UShort currentX;
        private final UShort currentY;
        private final UByte driftCompensation;
        private final UByte enhancedColorMode;
        private final UShort enhancedCurrentHue;
        private final Feature featureMap;
        private final List<UInt> generatedCommandList;
        private final UByte numberOfPrimaries;
        private final UByte options;
        private final UByte primary1Intensity;
        private final UShort primary1X;
        private final UShort primary1Y;
        private final UByte primary2Intensity;
        private final UShort primary2X;
        private final UShort primary2Y;
        private final UByte primary3Intensity;
        private final UShort primary3X;
        private final UShort primary3Y;
        private final UByte primary4Intensity;
        private final UShort primary4X;
        private final UShort primary4Y;
        private final UByte primary5Intensity;
        private final UShort primary5X;
        private final UShort primary5Y;
        private final UByte primary6Intensity;
        private final UShort primary6X;
        private final UShort primary6Y;
        private final UShort remainingTime;
        private final UShort startUpColorTemperatureMireds;
        private final UShort whitePointX;
        private final UShort whitePointY;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private AttributesImpl(UByte uByte, UByte uByte2, UShort uShort, UShort uShort2, UShort uShort3, UByte uByte3, String str, UShort uShort4, UByte uByte4, UByte uByte5, UByte uByte6, UShort uShort5, UShort uShort6, UByte uByte7, UShort uShort7, UShort uShort8, UByte uByte8, UShort uShort9, UShort uShort10, UByte uByte9, UShort uShort11, UShort uShort12, UByte uByte10, UShort uShort13, UShort uShort14, UByte uByte11, UShort uShort15, UShort uShort16, UByte uByte12, UShort uShort17, UShort uShort18, UShort uShort19, UShort uShort20, UByte uByte13, UShort uShort21, UShort uShort22, UByte uByte14, UShort uShort23, UShort uShort24, UByte uByte15, UShort uShort25, UByte uByte16, UByte uByte17, UByte uByte18, UShort uShort26, UShort uShort27, UShort uShort28, UShort uShort29, UShort uShort30, UShort uShort31, UShort uShort32, UShort uShort33, List<UInt> list, List<UInt> list2, List<UInt> list3, Feature feature, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            feature.getClass();
            this.currentHue = uByte;
            this.currentSaturation = uByte2;
            this.remainingTime = uShort;
            this.currentX = uShort2;
            this.currentY = uShort3;
            this.driftCompensation = uByte3;
            this.compensationText = str;
            this.colorTemperatureMireds = uShort4;
            this.colorMode = uByte4;
            this.options = uByte5;
            this.numberOfPrimaries = uByte6;
            this.primary1X = uShort5;
            this.primary1Y = uShort6;
            this.primary1Intensity = uByte7;
            this.primary2X = uShort7;
            this.primary2Y = uShort8;
            this.primary2Intensity = uByte8;
            this.primary3X = uShort9;
            this.primary3Y = uShort10;
            this.primary3Intensity = uByte9;
            this.primary4X = uShort11;
            this.primary4Y = uShort12;
            this.primary4Intensity = uByte10;
            this.primary5X = uShort13;
            this.primary5Y = uShort14;
            this.primary5Intensity = uByte11;
            this.primary6X = uShort15;
            this.primary6Y = uShort16;
            this.primary6Intensity = uByte12;
            this.whitePointX = uShort17;
            this.whitePointY = uShort18;
            this.colorPointRx = uShort19;
            this.colorPointRy = uShort20;
            this.colorPointRIntensity = uByte13;
            this.colorPointGx = uShort21;
            this.colorPointGy = uShort22;
            this.colorPointGIntensity = uByte14;
            this.colorPointBx = uShort23;
            this.colorPointBy = uShort24;
            this.colorPointBIntensity = uByte15;
            this.enhancedCurrentHue = uShort25;
            this.enhancedColorMode = uByte16;
            this.colorLoopActive = uByte17;
            this.colorLoopDirection = uByte18;
            this.colorLoopTime = uShort26;
            this.colorLoopStartEnhancedHue = uShort27;
            this.colorLoopStoredEnhancedHue = uShort28;
            this.colorCapabilities = uShort29;
            this.colorTempPhysicalMinMireds = uShort30;
            this.colorTempPhysicalMaxMireds = uShort31;
            this.coupleColorTempToLevelMinMireds = uShort32;
            this.startUpColorTemperatureMireds = uShort33;
            this.generatedCommandList = list;
            this.acceptedCommandList = list2;
            this.attributeList = list3;
            this.featureMap = feature;
            this.clusterRevision = s;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Attributes)) {
                return false;
            }
            Attributes attributes = (Attributes) other;
            return Intrinsics.areEqual(getCurrentHue(), attributes.getCurrentHue()) && Intrinsics.areEqual(getCurrentSaturation(), attributes.getCurrentSaturation()) && Intrinsics.areEqual(getRemainingTime(), attributes.getRemainingTime()) && Intrinsics.areEqual(getCurrentX(), attributes.getCurrentX()) && Intrinsics.areEqual(getCurrentY(), attributes.getCurrentY()) && Intrinsics.areEqual(getDriftCompensation(), attributes.getDriftCompensation()) && Intrinsics.areEqual(getCompensationText(), attributes.getCompensationText()) && Intrinsics.areEqual(getColorTemperatureMireds(), attributes.getColorTemperatureMireds()) && Intrinsics.areEqual(getColorMode(), attributes.getColorMode()) && Intrinsics.areEqual(getOptions(), attributes.getOptions()) && Intrinsics.areEqual(getNumberOfPrimaries(), attributes.getNumberOfPrimaries()) && Intrinsics.areEqual(getPrimary1X(), attributes.getPrimary1X()) && Intrinsics.areEqual(getPrimary1Y(), attributes.getPrimary1Y()) && Intrinsics.areEqual(getPrimary1Intensity(), attributes.getPrimary1Intensity()) && Intrinsics.areEqual(getPrimary2X(), attributes.getPrimary2X()) && Intrinsics.areEqual(getPrimary2Y(), attributes.getPrimary2Y()) && Intrinsics.areEqual(getPrimary2Intensity(), attributes.getPrimary2Intensity()) && Intrinsics.areEqual(getPrimary3X(), attributes.getPrimary3X()) && Intrinsics.areEqual(getPrimary3Y(), attributes.getPrimary3Y()) && Intrinsics.areEqual(getPrimary3Intensity(), attributes.getPrimary3Intensity()) && Intrinsics.areEqual(getPrimary4X(), attributes.getPrimary4X()) && Intrinsics.areEqual(getPrimary4Y(), attributes.getPrimary4Y()) && Intrinsics.areEqual(getPrimary4Intensity(), attributes.getPrimary4Intensity()) && Intrinsics.areEqual(getPrimary5X(), attributes.getPrimary5X()) && Intrinsics.areEqual(getPrimary5Y(), attributes.getPrimary5Y()) && Intrinsics.areEqual(getPrimary5Intensity(), attributes.getPrimary5Intensity()) && Intrinsics.areEqual(getPrimary6X(), attributes.getPrimary6X()) && Intrinsics.areEqual(getPrimary6Y(), attributes.getPrimary6Y()) && Intrinsics.areEqual(getPrimary6Intensity(), attributes.getPrimary6Intensity()) && Intrinsics.areEqual(getWhitePointX(), attributes.getWhitePointX()) && Intrinsics.areEqual(getWhitePointY(), attributes.getWhitePointY()) && Intrinsics.areEqual(getColorPointRx(), attributes.getColorPointRx()) && Intrinsics.areEqual(getColorPointRy(), attributes.getColorPointRy()) && Intrinsics.areEqual(getColorPointRIntensity(), attributes.getColorPointRIntensity()) && Intrinsics.areEqual(getColorPointGx(), attributes.getColorPointGx()) && Intrinsics.areEqual(getColorPointGy(), attributes.getColorPointGy()) && Intrinsics.areEqual(getColorPointGIntensity(), attributes.getColorPointGIntensity()) && Intrinsics.areEqual(getColorPointBx(), attributes.getColorPointBx()) && Intrinsics.areEqual(getColorPointBy(), attributes.getColorPointBy()) && Intrinsics.areEqual(getColorPointBIntensity(), attributes.getColorPointBIntensity()) && Intrinsics.areEqual(getEnhancedCurrentHue(), attributes.getEnhancedCurrentHue()) && Intrinsics.areEqual(getEnhancedColorMode(), attributes.getEnhancedColorMode()) && Intrinsics.areEqual(getColorLoopActive(), attributes.getColorLoopActive()) && Intrinsics.areEqual(getColorLoopDirection(), attributes.getColorLoopDirection()) && Intrinsics.areEqual(getColorLoopTime(), attributes.getColorLoopTime()) && Intrinsics.areEqual(getColorLoopStartEnhancedHue(), attributes.getColorLoopStartEnhancedHue()) && Intrinsics.areEqual(getColorLoopStoredEnhancedHue(), attributes.getColorLoopStoredEnhancedHue()) && Intrinsics.areEqual(getColorCapabilities(), attributes.getColorCapabilities()) && Intrinsics.areEqual(getColorTempPhysicalMinMireds(), attributes.getColorTempPhysicalMinMireds()) && Intrinsics.areEqual(getColorTempPhysicalMaxMireds(), attributes.getColorTempPhysicalMaxMireds()) && Intrinsics.areEqual(getCoupleColorTempToLevelMinMireds(), attributes.getCoupleColorTempToLevelMinMireds()) && Intrinsics.areEqual(getStartUpColorTemperatureMireds(), attributes.getStartUpColorTemperatureMireds()) && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && Intrinsics.areEqual(getFeatureMap(), attributes.getFeatureMap()) && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorCapabilities-XRpZGF0, reason: from getter */
        public UShort getColorCapabilities() {
            return this.colorCapabilities;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorLoopActive-7PGSa80, reason: from getter */
        public UByte getColorLoopActive() {
            return this.colorLoopActive;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorLoopDirection-7PGSa80, reason: from getter */
        public UByte getColorLoopDirection() {
            return this.colorLoopDirection;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorLoopStartEnhancedHue-XRpZGF0, reason: from getter */
        public UShort getColorLoopStartEnhancedHue() {
            return this.colorLoopStartEnhancedHue;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorLoopStoredEnhancedHue-XRpZGF0, reason: from getter */
        public UShort getColorLoopStoredEnhancedHue() {
            return this.colorLoopStoredEnhancedHue;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorLoopTime-XRpZGF0, reason: from getter */
        public UShort getColorLoopTime() {
            return this.colorLoopTime;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorMode-7PGSa80, reason: from getter */
        public UByte getColorMode() {
            return this.colorMode;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointBIntensity-7PGSa80, reason: from getter */
        public UByte getColorPointBIntensity() {
            return this.colorPointBIntensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointBx-XRpZGF0, reason: from getter */
        public UShort getColorPointBx() {
            return this.colorPointBx;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointBy-XRpZGF0, reason: from getter */
        public UShort getColorPointBy() {
            return this.colorPointBy;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointGIntensity-7PGSa80, reason: from getter */
        public UByte getColorPointGIntensity() {
            return this.colorPointGIntensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointGx-XRpZGF0, reason: from getter */
        public UShort getColorPointGx() {
            return this.colorPointGx;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointGy-XRpZGF0, reason: from getter */
        public UShort getColorPointGy() {
            return this.colorPointGy;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointRIntensity-7PGSa80, reason: from getter */
        public UByte getColorPointRIntensity() {
            return this.colorPointRIntensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointRx-XRpZGF0, reason: from getter */
        public UShort getColorPointRx() {
            return this.colorPointRx;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointRy-XRpZGF0, reason: from getter */
        public UShort getColorPointRy() {
            return this.colorPointRy;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorTempPhysicalMaxMireds-XRpZGF0, reason: from getter */
        public UShort getColorTempPhysicalMaxMireds() {
            return this.colorTempPhysicalMaxMireds;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorTempPhysicalMinMireds-XRpZGF0, reason: from getter */
        public UShort getColorTempPhysicalMinMireds() {
            return this.colorTempPhysicalMinMireds;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorTemperatureMireds-XRpZGF0, reason: from getter */
        public UShort getColorTemperatureMireds() {
            return this.colorTemperatureMireds;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        public String getCompensationText() {
            return this.compensationText;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCoupleColorTempToLevelMinMireds-XRpZGF0, reason: from getter */
        public UShort getCoupleColorTempToLevelMinMireds() {
            return this.coupleColorTempToLevelMinMireds;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentHue-7PGSa80, reason: from getter */
        public UByte getCurrentHue() {
            return this.currentHue;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentSaturation-7PGSa80, reason: from getter */
        public UByte getCurrentSaturation() {
            return this.currentSaturation;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentX-XRpZGF0, reason: from getter */
        public UShort getCurrentX() {
            return this.currentX;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentY-XRpZGF0, reason: from getter */
        public UShort getCurrentY() {
            return this.currentY;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getDriftCompensation-7PGSa80, reason: from getter */
        public UByte getDriftCompensation() {
            return this.driftCompensation;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getEnhancedColorMode-7PGSa80, reason: from getter */
        public UByte getEnhancedColorMode() {
            return this.enhancedColorMode;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getEnhancedCurrentHue-XRpZGF0, reason: from getter */
        public UShort getEnhancedCurrentHue() {
            return this.enhancedCurrentHue;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        public Feature getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getNumberOfPrimaries-7PGSa80, reason: from getter */
        public UByte getNumberOfPrimaries() {
            return this.numberOfPrimaries;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getOptions-7PGSa80, reason: from getter */
        public UByte getOptions() {
            return this.options;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary1Intensity-7PGSa80, reason: from getter */
        public UByte getPrimary1Intensity() {
            return this.primary1Intensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary1X-XRpZGF0, reason: from getter */
        public UShort getPrimary1X() {
            return this.primary1X;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary1Y-XRpZGF0, reason: from getter */
        public UShort getPrimary1Y() {
            return this.primary1Y;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary2Intensity-7PGSa80, reason: from getter */
        public UByte getPrimary2Intensity() {
            return this.primary2Intensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary2X-XRpZGF0, reason: from getter */
        public UShort getPrimary2X() {
            return this.primary2X;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary2Y-XRpZGF0, reason: from getter */
        public UShort getPrimary2Y() {
            return this.primary2Y;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary3Intensity-7PGSa80, reason: from getter */
        public UByte getPrimary3Intensity() {
            return this.primary3Intensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary3X-XRpZGF0, reason: from getter */
        public UShort getPrimary3X() {
            return this.primary3X;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary3Y-XRpZGF0, reason: from getter */
        public UShort getPrimary3Y() {
            return this.primary3Y;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary4Intensity-7PGSa80, reason: from getter */
        public UByte getPrimary4Intensity() {
            return this.primary4Intensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary4X-XRpZGF0, reason: from getter */
        public UShort getPrimary4X() {
            return this.primary4X;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary4Y-XRpZGF0, reason: from getter */
        public UShort getPrimary4Y() {
            return this.primary4Y;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary5Intensity-7PGSa80, reason: from getter */
        public UByte getPrimary5Intensity() {
            return this.primary5Intensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary5X-XRpZGF0, reason: from getter */
        public UShort getPrimary5X() {
            return this.primary5X;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary5Y-XRpZGF0, reason: from getter */
        public UShort getPrimary5Y() {
            return this.primary5Y;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary6Intensity-7PGSa80, reason: from getter */
        public UByte getPrimary6Intensity() {
            return this.primary6Intensity;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary6X-XRpZGF0, reason: from getter */
        public UShort getPrimary6X() {
            return this.primary6X;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getPrimary6Y-XRpZGF0, reason: from getter */
        public UShort getPrimary6Y() {
            return this.primary6Y;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getRemainingTime-XRpZGF0, reason: from getter */
        public UShort getRemainingTime() {
            return this.remainingTime;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getStartUpColorTemperatureMireds-XRpZGF0, reason: from getter */
        public UShort getStartUpColorTemperatureMireds() {
            return this.startUpColorTemperatureMireds;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getWhitePointX-XRpZGF0, reason: from getter */
        public UShort getWhitePointX() {
            return this.whitePointX;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getWhitePointY-XRpZGF0, reason: from getter */
        public UShort getWhitePointY() {
            return this.whitePointY;
        }

        public int hashCode() {
            UByte currentHue = getCurrentHue();
            int iM2369hashCodeimpl = currentHue != null ? UByte.m2369hashCodeimpl(currentHue.getData()) : 0;
            UByte currentSaturation = getCurrentSaturation();
            int iM2369hashCodeimpl2 = currentSaturation != null ? UByte.m2369hashCodeimpl(currentSaturation.getData()) : 0;
            int i = iM2369hashCodeimpl + 31;
            UShort remainingTime = getRemainingTime();
            int iM2435hashCodeimpl = ((((i * 31) + iM2369hashCodeimpl2) * 31) + (remainingTime != null ? UShort.m2435hashCodeimpl(remainingTime.getData()) : 0)) * 31;
            UShort currentX = getCurrentX();
            int iM2435hashCodeimpl2 = (iM2435hashCodeimpl + (currentX != null ? UShort.m2435hashCodeimpl(currentX.getData()) : 0)) * 31;
            UShort currentY = getCurrentY();
            int iM2435hashCodeimpl3 = (iM2435hashCodeimpl2 + (currentY != null ? UShort.m2435hashCodeimpl(currentY.getData()) : 0)) * 31;
            UByte driftCompensation = getDriftCompensation();
            int iM2369hashCodeimpl3 = (iM2435hashCodeimpl3 + (driftCompensation != null ? UByte.m2369hashCodeimpl(driftCompensation.getData()) : 0)) * 31;
            String compensationText = getCompensationText();
            int iHashCode = (iM2369hashCodeimpl3 + (compensationText != null ? compensationText.hashCode() : 0)) * 31;
            UShort colorTemperatureMireds = getColorTemperatureMireds();
            int iM2435hashCodeimpl4 = (iHashCode + (colorTemperatureMireds != null ? UShort.m2435hashCodeimpl(colorTemperatureMireds.getData()) : 0)) * 31;
            UByte colorMode = getColorMode();
            int iM2369hashCodeimpl4 = (iM2435hashCodeimpl4 + (colorMode != null ? UByte.m2369hashCodeimpl(colorMode.getData()) : 0)) * 31;
            UByte options = getOptions();
            int iM2369hashCodeimpl5 = (iM2369hashCodeimpl4 + (options != null ? UByte.m2369hashCodeimpl(options.getData()) : 0)) * 31;
            UByte numberOfPrimaries = getNumberOfPrimaries();
            int iM2369hashCodeimpl6 = (iM2369hashCodeimpl5 + (numberOfPrimaries != null ? UByte.m2369hashCodeimpl(numberOfPrimaries.getData()) : 0)) * 31;
            UShort primary1X = getPrimary1X();
            int iM2435hashCodeimpl5 = (iM2369hashCodeimpl6 + (primary1X != null ? UShort.m2435hashCodeimpl(primary1X.getData()) : 0)) * 31;
            UShort primary1Y = getPrimary1Y();
            int iM2435hashCodeimpl6 = (iM2435hashCodeimpl5 + (primary1Y != null ? UShort.m2435hashCodeimpl(primary1Y.getData()) : 0)) * 31;
            UByte primary1Intensity = getPrimary1Intensity();
            int iM2369hashCodeimpl7 = (iM2435hashCodeimpl6 + (primary1Intensity != null ? UByte.m2369hashCodeimpl(primary1Intensity.getData()) : 0)) * 31;
            UShort primary2X = getPrimary2X();
            int iM2435hashCodeimpl7 = (iM2369hashCodeimpl7 + (primary2X != null ? UShort.m2435hashCodeimpl(primary2X.getData()) : 0)) * 31;
            UShort primary2Y = getPrimary2Y();
            int iM2435hashCodeimpl8 = (iM2435hashCodeimpl7 + (primary2Y != null ? UShort.m2435hashCodeimpl(primary2Y.getData()) : 0)) * 31;
            UByte primary2Intensity = getPrimary2Intensity();
            int iM2369hashCodeimpl8 = (iM2435hashCodeimpl8 + (primary2Intensity != null ? UByte.m2369hashCodeimpl(primary2Intensity.getData()) : 0)) * 31;
            UShort primary3X = getPrimary3X();
            int iM2435hashCodeimpl9 = (iM2369hashCodeimpl8 + (primary3X != null ? UShort.m2435hashCodeimpl(primary3X.getData()) : 0)) * 31;
            UShort primary3Y = getPrimary3Y();
            int iM2435hashCodeimpl10 = (iM2435hashCodeimpl9 + (primary3Y != null ? UShort.m2435hashCodeimpl(primary3Y.getData()) : 0)) * 31;
            UByte primary3Intensity = getPrimary3Intensity();
            int iM2369hashCodeimpl9 = (iM2435hashCodeimpl10 + (primary3Intensity != null ? UByte.m2369hashCodeimpl(primary3Intensity.getData()) : 0)) * 31;
            UShort primary4X = getPrimary4X();
            int iM2435hashCodeimpl11 = (iM2369hashCodeimpl9 + (primary4X != null ? UShort.m2435hashCodeimpl(primary4X.getData()) : 0)) * 31;
            UShort primary4Y = getPrimary4Y();
            int iM2435hashCodeimpl12 = (iM2435hashCodeimpl11 + (primary4Y != null ? UShort.m2435hashCodeimpl(primary4Y.getData()) : 0)) * 31;
            UByte primary4Intensity = getPrimary4Intensity();
            int iM2369hashCodeimpl10 = (iM2435hashCodeimpl12 + (primary4Intensity != null ? UByte.m2369hashCodeimpl(primary4Intensity.getData()) : 0)) * 31;
            UShort primary5X = getPrimary5X();
            int iM2435hashCodeimpl13 = (iM2369hashCodeimpl10 + (primary5X != null ? UShort.m2435hashCodeimpl(primary5X.getData()) : 0)) * 31;
            UShort primary5Y = getPrimary5Y();
            int iM2435hashCodeimpl14 = (iM2435hashCodeimpl13 + (primary5Y != null ? UShort.m2435hashCodeimpl(primary5Y.getData()) : 0)) * 31;
            UByte primary5Intensity = getPrimary5Intensity();
            int iM2369hashCodeimpl11 = (iM2435hashCodeimpl14 + (primary5Intensity != null ? UByte.m2369hashCodeimpl(primary5Intensity.getData()) : 0)) * 31;
            UShort primary6X = getPrimary6X();
            int iM2435hashCodeimpl15 = (iM2369hashCodeimpl11 + (primary6X != null ? UShort.m2435hashCodeimpl(primary6X.getData()) : 0)) * 31;
            UShort primary6Y = getPrimary6Y();
            int iM2435hashCodeimpl16 = (iM2435hashCodeimpl15 + (primary6Y != null ? UShort.m2435hashCodeimpl(primary6Y.getData()) : 0)) * 31;
            UByte primary6Intensity = getPrimary6Intensity();
            int iM2369hashCodeimpl12 = (iM2435hashCodeimpl16 + (primary6Intensity != null ? UByte.m2369hashCodeimpl(primary6Intensity.getData()) : 0)) * 31;
            UShort whitePointX = getWhitePointX();
            int iM2435hashCodeimpl17 = (iM2369hashCodeimpl12 + (whitePointX != null ? UShort.m2435hashCodeimpl(whitePointX.getData()) : 0)) * 31;
            UShort whitePointY = getWhitePointY();
            int iM2435hashCodeimpl18 = (iM2435hashCodeimpl17 + (whitePointY != null ? UShort.m2435hashCodeimpl(whitePointY.getData()) : 0)) * 31;
            UShort colorPointRx = getColorPointRx();
            int iM2435hashCodeimpl19 = (iM2435hashCodeimpl18 + (colorPointRx != null ? UShort.m2435hashCodeimpl(colorPointRx.getData()) : 0)) * 31;
            UShort colorPointRy = getColorPointRy();
            int iM2435hashCodeimpl20 = (iM2435hashCodeimpl19 + (colorPointRy != null ? UShort.m2435hashCodeimpl(colorPointRy.getData()) : 0)) * 31;
            UByte colorPointRIntensity = getColorPointRIntensity();
            int iM2369hashCodeimpl13 = (iM2435hashCodeimpl20 + (colorPointRIntensity != null ? UByte.m2369hashCodeimpl(colorPointRIntensity.getData()) : 0)) * 31;
            UShort colorPointGx = getColorPointGx();
            int iM2435hashCodeimpl21 = (iM2369hashCodeimpl13 + (colorPointGx != null ? UShort.m2435hashCodeimpl(colorPointGx.getData()) : 0)) * 31;
            UShort colorPointGy = getColorPointGy();
            int iM2435hashCodeimpl22 = (iM2435hashCodeimpl21 + (colorPointGy != null ? UShort.m2435hashCodeimpl(colorPointGy.getData()) : 0)) * 31;
            UByte colorPointGIntensity = getColorPointGIntensity();
            int iM2369hashCodeimpl14 = (iM2435hashCodeimpl22 + (colorPointGIntensity != null ? UByte.m2369hashCodeimpl(colorPointGIntensity.getData()) : 0)) * 31;
            UShort colorPointBx = getColorPointBx();
            int iM2435hashCodeimpl23 = (iM2369hashCodeimpl14 + (colorPointBx != null ? UShort.m2435hashCodeimpl(colorPointBx.getData()) : 0)) * 31;
            UShort colorPointBy = getColorPointBy();
            int iM2435hashCodeimpl24 = (iM2435hashCodeimpl23 + (colorPointBy != null ? UShort.m2435hashCodeimpl(colorPointBy.getData()) : 0)) * 31;
            UByte colorPointBIntensity = getColorPointBIntensity();
            int iM2369hashCodeimpl15 = (iM2435hashCodeimpl24 + (colorPointBIntensity != null ? UByte.m2369hashCodeimpl(colorPointBIntensity.getData()) : 0)) * 31;
            UShort enhancedCurrentHue = getEnhancedCurrentHue();
            int iM2435hashCodeimpl25 = (iM2369hashCodeimpl15 + (enhancedCurrentHue != null ? UShort.m2435hashCodeimpl(enhancedCurrentHue.getData()) : 0)) * 31;
            UByte enhancedColorMode = getEnhancedColorMode();
            int iM2369hashCodeimpl16 = (iM2435hashCodeimpl25 + (enhancedColorMode != null ? UByte.m2369hashCodeimpl(enhancedColorMode.getData()) : 0)) * 31;
            UByte colorLoopActive = getColorLoopActive();
            int iM2369hashCodeimpl17 = (iM2369hashCodeimpl16 + (colorLoopActive != null ? UByte.m2369hashCodeimpl(colorLoopActive.getData()) : 0)) * 31;
            UByte colorLoopDirection = getColorLoopDirection();
            int iM2369hashCodeimpl18 = (iM2369hashCodeimpl17 + (colorLoopDirection != null ? UByte.m2369hashCodeimpl(colorLoopDirection.getData()) : 0)) * 31;
            UShort colorLoopTime = getColorLoopTime();
            int iM2435hashCodeimpl26 = (iM2369hashCodeimpl18 + (colorLoopTime != null ? UShort.m2435hashCodeimpl(colorLoopTime.getData()) : 0)) * 31;
            UShort colorLoopStartEnhancedHue = getColorLoopStartEnhancedHue();
            int iM2435hashCodeimpl27 = (iM2435hashCodeimpl26 + (colorLoopStartEnhancedHue != null ? UShort.m2435hashCodeimpl(colorLoopStartEnhancedHue.getData()) : 0)) * 31;
            UShort colorLoopStoredEnhancedHue = getColorLoopStoredEnhancedHue();
            int iM2435hashCodeimpl28 = (iM2435hashCodeimpl27 + (colorLoopStoredEnhancedHue != null ? UShort.m2435hashCodeimpl(colorLoopStoredEnhancedHue.getData()) : 0)) * 31;
            UShort colorCapabilities = getColorCapabilities();
            int iM2435hashCodeimpl29 = (iM2435hashCodeimpl28 + (colorCapabilities != null ? UShort.m2435hashCodeimpl(colorCapabilities.getData()) : 0)) * 31;
            UShort colorTempPhysicalMinMireds = getColorTempPhysicalMinMireds();
            int iM2435hashCodeimpl30 = (iM2435hashCodeimpl29 + (colorTempPhysicalMinMireds != null ? UShort.m2435hashCodeimpl(colorTempPhysicalMinMireds.getData()) : 0)) * 31;
            UShort colorTempPhysicalMaxMireds = getColorTempPhysicalMaxMireds();
            int iM2435hashCodeimpl31 = (iM2435hashCodeimpl30 + (colorTempPhysicalMaxMireds != null ? UShort.m2435hashCodeimpl(colorTempPhysicalMaxMireds.getData()) : 0)) * 31;
            UShort coupleColorTempToLevelMinMireds = getCoupleColorTempToLevelMinMireds();
            int iM2435hashCodeimpl32 = (iM2435hashCodeimpl31 + (coupleColorTempToLevelMinMireds != null ? UShort.m2435hashCodeimpl(coupleColorTempToLevelMinMireds.getData()) : 0)) * 31;
            UShort startUpColorTemperatureMireds = getStartUpColorTemperatureMireds();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((getFeatureMap().hashCode() + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iM2435hashCodeimpl32 + (startUpColorTemperatureMireds != null ? UShort.m2435hashCodeimpl(startUpColorTemperatureMireds.getData()) : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            UByte currentHue = getCurrentHue();
            UByte currentSaturation = getCurrentSaturation();
            UShort remainingTime = getRemainingTime();
            UShort currentX = getCurrentX();
            UShort currentY = getCurrentY();
            UByte driftCompensation = getDriftCompensation();
            String compensationText = getCompensationText();
            UShort colorTemperatureMireds = getColorTemperatureMireds();
            UByte colorMode = getColorMode();
            UByte options = getOptions();
            UByte numberOfPrimaries = getNumberOfPrimaries();
            UShort primary1X = getPrimary1X();
            UShort primary1Y = getPrimary1Y();
            UByte primary1Intensity = getPrimary1Intensity();
            UShort primary2X = getPrimary2X();
            UShort primary2Y = getPrimary2Y();
            UByte primary2Intensity = getPrimary2Intensity();
            UShort primary3X = getPrimary3X();
            UShort primary3Y = getPrimary3Y();
            UByte primary3Intensity = getPrimary3Intensity();
            UShort primary4X = getPrimary4X();
            UShort primary4Y = getPrimary4Y();
            UByte primary4Intensity = getPrimary4Intensity();
            UShort primary5X = getPrimary5X();
            UShort primary5Y = getPrimary5Y();
            UByte primary5Intensity = getPrimary5Intensity();
            UShort primary6X = getPrimary6X();
            UShort primary6Y = getPrimary6Y();
            UByte primary6Intensity = getPrimary6Intensity();
            UShort whitePointX = getWhitePointX();
            UShort whitePointY = getWhitePointY();
            UShort colorPointRx = getColorPointRx();
            UShort colorPointRy = getColorPointRy();
            UByte colorPointRIntensity = getColorPointRIntensity();
            UShort colorPointGx = getColorPointGx();
            UShort colorPointGy = getColorPointGy();
            UByte colorPointGIntensity = getColorPointGIntensity();
            UShort colorPointBx = getColorPointBx();
            UShort colorPointBy = getColorPointBy();
            UByte colorPointBIntensity = getColorPointBIntensity();
            UShort enhancedCurrentHue = getEnhancedCurrentHue();
            UByte enhancedColorMode = getEnhancedColorMode();
            UByte colorLoopActive = getColorLoopActive();
            UByte colorLoopDirection = getColorLoopDirection();
            UShort colorLoopTime = getColorLoopTime();
            UShort colorLoopStartEnhancedHue = getColorLoopStartEnhancedHue();
            UShort colorLoopStoredEnhancedHue = getColorLoopStoredEnhancedHue();
            UShort colorCapabilities = getColorCapabilities();
            UShort colorTempPhysicalMinMireds = getColorTempPhysicalMinMireds();
            UShort colorTempPhysicalMaxMireds = getColorTempPhysicalMaxMireds();
            UShort coupleColorTempToLevelMinMireds = getCoupleColorTempToLevelMinMireds();
            UShort startUpColorTemperatureMireds = getStartUpColorTemperatureMireds();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            Feature featureMap = getFeatureMap();
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(currentHue).length();
            int length2 = String.valueOf(currentSaturation).length();
            int length3 = String.valueOf(remainingTime).length();
            int length4 = String.valueOf(currentX).length();
            int length5 = String.valueOf(currentY).length();
            int length6 = String.valueOf(driftCompensation).length();
            int length7 = length + 44 + length2 + 16 + length3 + 11 + length4 + 11 + length5 + 20 + length6 + 19 + String.valueOf(compensationText).length() + 25 + String.valueOf(colorTemperatureMireds).length();
            int length8 = String.valueOf(colorMode).length();
            int length9 = String.valueOf(options).length();
            int length10 = String.valueOf(numberOfPrimaries).length();
            int length11 = String.valueOf(primary1X).length();
            int length12 = String.valueOf(primary1Y).length();
            int length13 = String.valueOf(primary1Intensity).length();
            int length14 = String.valueOf(primary2X).length();
            int length15 = String.valueOf(primary2Y).length();
            int length16 = String.valueOf(primary2Intensity).length();
            int length17 = String.valueOf(primary3X).length();
            int length18 = String.valueOf(primary3Y).length();
            int length19 = String.valueOf(primary3Intensity).length();
            int length20 = String.valueOf(primary4X).length();
            int length21 = String.valueOf(primary4Y).length();
            int length22 = String.valueOf(primary4Intensity).length();
            int length23 = String.valueOf(primary5X).length();
            int length24 = String.valueOf(primary5Y).length();
            int length25 = String.valueOf(primary5Intensity).length();
            int length26 = String.valueOf(primary6X).length();
            int length27 = String.valueOf(primary6Y).length();
            int length28 = String.valueOf(primary6Intensity).length();
            int length29 = String.valueOf(whitePointX).length();
            int length30 = String.valueOf(whitePointY).length();
            int length31 = String.valueOf(colorPointRx).length();
            StringBuilder sb = new StringBuilder(String.valueOf(strM2436toStringimpl).length() + zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(zzba$$ExternalSyntheticOutline0.m(length7 + 12 + length8 + 10 + length9 + 20 + length10 + 12 + length11 + 12 + length12 + 20 + length13 + 12 + length14 + 12 + length15 + 20 + length16 + 12 + length17 + 12 + length18 + 20 + length19 + 12 + length20 + 12 + length21 + 20 + length22 + 12 + length23 + 12 + length24 + 20 + length25 + 12 + length26 + 12 + length27 + 20 + length28 + 14 + length29 + 14 + length30 + 15 + length31 + 15 + String.valueOf(colorPointRy).length() + 23 + String.valueOf(colorPointRIntensity).length() + 15 + String.valueOf(colorPointGx).length() + 15 + String.valueOf(colorPointGy).length() + 23 + String.valueOf(colorPointGIntensity).length() + 15 + String.valueOf(colorPointBx).length() + 15 + String.valueOf(colorPointBy).length() + 23 + String.valueOf(colorPointBIntensity).length() + 21, 20, String.valueOf(enhancedCurrentHue)) + String.valueOf(enhancedColorMode).length() + 18 + String.valueOf(colorLoopActive).length() + 21, 16, String.valueOf(colorLoopDirection)) + String.valueOf(colorLoopTime).length() + 28 + String.valueOf(colorLoopStartEnhancedHue).length() + 29, 20, String.valueOf(colorLoopStoredEnhancedHue)) + String.valueOf(colorCapabilities).length() + 29 + String.valueOf(colorTempPhysicalMinMireds).length() + 29 + String.valueOf(colorTempPhysicalMaxMireds).length() + 34 + String.valueOf(coupleColorTempToLevelMinMireds).length() + 32 + String.valueOf(startUpColorTemperatureMireds).length() + 23 + String.valueOf(generatedCommandList).length() + 22, 16, String.valueOf(acceptedCommandList)) + String.valueOf(attributeList).length() + 13 + String.valueOf(featureMap).length() + 18 + 1);
            sb.append("ColorControl(currentHue=");
            sb.append(currentHue);
            sb.append(", currentSaturation=");
            sb.append(currentSaturation);
            sb.append(", remainingTime=");
            sb.append(remainingTime);
            sb.append(", currentX=");
            sb.append(currentX);
            sb.append(", currentY=");
            sb.append(currentY);
            sb.append(", driftCompensation=");
            sb.append(driftCompensation);
            sb.append(", compensationText=");
            sb.append(compensationText);
            sb.append(", colorTemperatureMireds=");
            sb.append(colorTemperatureMireds);
            sb.append(", colorMode=");
            sb.append(colorMode);
            sb.append(", options=");
            sb.append(options);
            sb.append(", numberOfPrimaries=");
            sb.append(numberOfPrimaries);
            sb.append(", primary1X=");
            sb.append(primary1X);
            sb.append(", primary1Y=");
            sb.append(primary1Y);
            sb.append(", primary1Intensity=");
            sb.append(primary1Intensity);
            sb.append(", primary2X=");
            sb.append(primary2X);
            sb.append(", primary2Y=");
            sb.append(primary2Y);
            sb.append(", primary2Intensity=");
            sb.append(primary2Intensity);
            sb.append(", primary3X=");
            sb.append(primary3X);
            sb.append(", primary3Y=");
            sb.append(primary3Y);
            sb.append(", primary3Intensity=");
            sb.append(primary3Intensity);
            sb.append(", primary4X=");
            sb.append(primary4X);
            sb.append(", primary4Y=");
            sb.append(primary4Y);
            sb.append(", primary4Intensity=");
            sb.append(primary4Intensity);
            sb.append(", primary5X=");
            sb.append(primary5X);
            sb.append(", primary5Y=");
            sb.append(primary5Y);
            sb.append(", primary5Intensity=");
            sb.append(primary5Intensity);
            sb.append(", primary6X=");
            sb.append(primary6X);
            sb.append(", primary6Y=");
            sb.append(primary6Y);
            sb.append(", primary6Intensity=");
            sb.append(primary6Intensity);
            sb.append(", whitePointX=");
            sb.append(whitePointX);
            sb.append(", whitePointY=");
            sb.append(whitePointY);
            sb.append(", colorPointRx=");
            sb.append(colorPointRx);
            sb.append(", colorPointRy=");
            sb.append(colorPointRy);
            sb.append(", colorPointRIntensity=");
            sb.append(colorPointRIntensity);
            sb.append(", colorPointGx=");
            sb.append(colorPointGx);
            sb.append(", colorPointGy=");
            sb.append(colorPointGy);
            sb.append(", colorPointGIntensity=");
            return zzaf.zza(strM2436toStringimpl, featureMap, attributeList, acceptedCommandList, generatedCommandList, startUpColorTemperatureMireds, coupleColorTempToLevelMinMireds, colorTempPhysicalMaxMireds, colorTempPhysicalMinMireds, colorCapabilities, colorLoopStoredEnhancedHue, colorLoopStartEnhancedHue, colorLoopTime, colorLoopDirection, colorLoopActive, enhancedColorMode, enhancedCurrentHue, sb, colorPointBIntensity, colorPointBy, colorPointBx, colorPointGIntensity, ", colorTempPhysicalMinMireds=", ", colorPointBy=", ", colorLoopStartEnhancedHue=", ", colorPointBIntensity=", ", colorLoopDirection=", ", enhancedColorMode=", ", colorLoopActive=", ", colorLoopTime=", ", colorLoopStoredEnhancedHue=", ", colorPointBx=", ", enhancedCurrentHue=", ", colorCapabilities=", ", startUpColorTemperatureMireds=", ", colorTempPhysicalMaxMireds=", ", coupleColorTempToLevelMinMireds=");
        }

        public /* synthetic */ AttributesImpl(UByte uByte, UByte uByte2, UShort uShort, UShort uShort2, UShort uShort3, UByte uByte3, String str, UShort uShort4, UByte uByte4, UByte uByte5, UByte uByte6, UShort uShort5, UShort uShort6, UByte uByte7, UShort uShort7, UShort uShort8, UByte uByte8, UShort uShort9, UShort uShort10, UByte uByte9, UShort uShort11, UShort uShort12, UByte uByte10, UShort uShort13, UShort uShort14, UByte uByte11, UShort uShort15, UShort uShort16, UByte uByte12, UShort uShort17, UShort uShort18, UShort uShort19, UShort uShort20, UByte uByte13, UShort uShort21, UShort uShort22, UByte uByte14, UShort uShort23, UShort uShort24, UByte uByte15, UShort uShort25, UByte uByte16, UByte uByte17, UByte uByte18, UShort uShort26, UShort uShort27, UShort uShort28, UShort uShort29, UShort uShort30, UShort uShort31, UShort uShort32, UShort uShort33, List list, List list2, List list3, Feature feature, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(uByte, uByte2, uShort, uShort2, uShort3, uByte3, str, uShort4, uByte4, uByte5, uByte6, uShort5, uShort6, uByte7, uShort7, uShort8, uByte8, uShort9, uShort10, uByte9, uShort11, uShort12, uByte10, uShort13, uShort14, uByte11, uShort15, uShort16, uByte12, uShort17, uShort18, uShort19, uShort20, uByte13, uShort21, uShort22, uByte14, uShort23, uShort24, uByte15, uShort25, uByte16, uByte17, uByte18, uShort26, uShort27, uShort28, uShort29, uShort30, uShort31, uShort32, uShort33, list, list2, list3, feature, s);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorCapabilities;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "hueSaturationSupported", "enhancedHueSupported", "colorLoopSupported", "xyAttributesSupported", "colorTemperatureSupported", "<init>", "(ZZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHueSaturationSupported", "()Z", "getEnhancedHueSupported", "getColorLoopSupported", "getXyAttributesSupported", "getColorTemperatureSupported", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ColorCapabilities extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean colorLoopSupported;
        private final boolean colorTemperatureSupported;
        private final boolean enhancedHueSupported;
        private final boolean hueSaturationSupported;
        private final boolean xyAttributesSupported;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControlTrait$ColorCapabilities$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorCapabilities$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$ColorCapabilities;", "<init>", "()V", "HUE_SATURATION_SUPPORTED_FLAG", "Lkotlin/ULong;", "J", "ENHANCED_HUE_SUPPORTED_FLAG", "COLOR_LOOP_SUPPORTED_FLAG", "XY_ATTRIBUTES_SUPPORTED_FLAG", "COLOR_TEMPERATURE_SUPPORTED_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ColorCapabilities> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ColorCapabilities value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getHueSaturationSupported());
                mutableBitmap.m564set4PLdz1A(2L, value.getEnhancedHueSupported());
                mutableBitmap.m564set4PLdz1A(4L, value.getColorLoopSupported());
                mutableBitmap.m564set4PLdz1A(8L, value.getXyAttributesSupported());
                mutableBitmap.m564set4PLdz1A(16L, value.getColorTemperatureSupported());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ColorCapabilities toRuntime(Bitmap value) {
                value.getClass();
                return new ColorCapabilities(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L), value.m525getVKZWuLQ(16L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ColorCapabilities(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            super(zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ColorCapabilities");
            this.hueSaturationSupported = z;
            this.enhancedHueSupported = z2;
            this.colorLoopSupported = z3;
            this.xyAttributesSupported = z4;
            this.colorTemperatureSupported = z5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorCapabilities)) {
                return false;
            }
            ColorCapabilities colorCapabilities = (ColorCapabilities) other;
            return this.hueSaturationSupported == colorCapabilities.hueSaturationSupported && this.enhancedHueSupported == colorCapabilities.enhancedHueSupported && this.colorLoopSupported == colorCapabilities.colorLoopSupported && this.xyAttributesSupported == colorCapabilities.xyAttributesSupported && this.colorTemperatureSupported == colorCapabilities.colorTemperatureSupported;
        }

        public final boolean getColorLoopSupported() {
            return this.colorLoopSupported;
        }

        public final boolean getColorTemperatureSupported() {
            return this.colorTemperatureSupported;
        }

        public final boolean getEnhancedHueSupported() {
            return this.enhancedHueSupported;
        }

        public final boolean getHueSaturationSupported() {
            return this.hueSaturationSupported;
        }

        public final boolean getXyAttributesSupported() {
            return this.xyAttributesSupported;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.enhancedHueSupported) + (Boolean.hashCode(this.hueSaturationSupported) * 31);
            int iHashCode2 = Boolean.hashCode(this.colorLoopSupported) + (iHashCode * 31);
            int iHashCode3 = Boolean.hashCode(this.xyAttributesSupported);
            return Boolean.hashCode(this.colorTemperatureSupported) + ((iHashCode3 + (iHashCode2 * 31)) * 31);
        }

        public String toString() {
            boolean z = this.hueSaturationSupported;
            int length = String.valueOf(z).length();
            boolean z2 = this.enhancedHueSupported;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.colorLoopSupported;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.xyAttributesSupported;
            int length4 = String.valueOf(z4).length();
            boolean z5 = this.colorTemperatureSupported;
            return zzp.zza(new StringBuilder(length + 64 + length2 + 21 + length3 + 24 + length4 + 28 + String.valueOf(z5).length() + 1), z5, z4, z3, z2, z, "ColorCapabilities(hueSaturationSupported=", ", enhancedHueSupported=", ", colorLoopSupported=", ", xyAttributesSupported=", ", colorTemperatureSupported=");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopSetCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ColorLoopSetCommand implements CommandDescriptor {
        public static final ColorLoopSetCommand INSTANCE = new ColorLoopSetCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 68, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private ColorLoopSetCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$ColorLoopSetCommand$Request$CommandFields colorControlTrait$ColorLoopSetCommand$Request$CommandFields : ColorControlTrait$ColorLoopSetCommand$Request$CommandFields.values()) {
                if (colorControlTrait$ColorLoopSetCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$ColorLoopSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$ColorLoopSetCommand$Request$CommandFields colorControlTrait$ColorLoopSetCommand$Request$CommandFields : ColorControlTrait$ColorLoopSetCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$ColorLoopSetCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$ColorLoopSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B/\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0016\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015¨\u0006\u001a"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopUpdateFlags;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "updateAction", "updateDirection", "updateTime", "updateStartHue", "<init>", "(ZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getUpdateAction", "()Z", "getUpdateDirection", "getUpdateTime", "getUpdateStartHue", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class ColorLoopUpdateFlags extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean updateAction;
        private final boolean updateDirection;
        private final boolean updateStartHue;
        private final boolean updateTime;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControlTrait$ColorLoopUpdateFlags$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopUpdateFlags$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopUpdateFlags;", "<init>", "()V", "UPDATE_ACTION_FLAG", "Lkotlin/ULong;", "J", "UPDATE_DIRECTION_FLAG", "UPDATE_TIME_FLAG", "UPDATE_START_HUE_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<ColorLoopUpdateFlags> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(ColorLoopUpdateFlags value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getUpdateAction());
                mutableBitmap.m564set4PLdz1A(2L, value.getUpdateDirection());
                mutableBitmap.m564set4PLdz1A(4L, value.getUpdateTime());
                mutableBitmap.m564set4PLdz1A(8L, value.getUpdateStartHue());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public ColorLoopUpdateFlags toRuntime(Bitmap value) {
                value.getClass();
                return new ColorLoopUpdateFlags(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public ColorLoopUpdateFlags(boolean z, boolean z2, boolean z3, boolean z4) {
            super(zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "ColorLoopUpdateFlags");
            this.updateAction = z;
            this.updateDirection = z2;
            this.updateTime = z3;
            this.updateStartHue = z4;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ColorLoopUpdateFlags)) {
                return false;
            }
            ColorLoopUpdateFlags colorLoopUpdateFlags = (ColorLoopUpdateFlags) other;
            return this.updateAction == colorLoopUpdateFlags.updateAction && this.updateDirection == colorLoopUpdateFlags.updateDirection && this.updateTime == colorLoopUpdateFlags.updateTime && this.updateStartHue == colorLoopUpdateFlags.updateStartHue;
        }

        public final boolean getUpdateAction() {
            return this.updateAction;
        }

        public final boolean getUpdateDirection() {
            return this.updateDirection;
        }

        public final boolean getUpdateStartHue() {
            return this.updateStartHue;
        }

        public final boolean getUpdateTime() {
            return this.updateTime;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.updateDirection) + (Boolean.hashCode(this.updateAction) * 31);
            int iHashCode2 = Boolean.hashCode(this.updateTime);
            return Boolean.hashCode(this.updateStartHue) + ((iHashCode2 + (iHashCode * 31)) * 31);
        }

        public String toString() {
            boolean z = this.updateAction;
            int length = String.valueOf(z).length();
            boolean z2 = this.updateDirection;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.updateTime;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.updateStartHue;
            return zzs.zza(z4, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 52, length2, 13, length3, 17, String.valueOf(z4).length()) + 1), z3, z2, z, "ColorLoopUpdateFlags(updateAction=", ", updateDirection=", ", updateTime=", ", updateStartHue=");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$EnhancedMoveHueCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EnhancedMoveHueCommand implements CommandDescriptor {
        public static final EnhancedMoveHueCommand INSTANCE = new EnhancedMoveHueCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 65, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private EnhancedMoveHueCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$EnhancedMoveHueCommand$Request$CommandFields colorControlTrait$EnhancedMoveHueCommand$Request$CommandFields : ColorControlTrait$EnhancedMoveHueCommand$Request$CommandFields.values()) {
                if (colorControlTrait$EnhancedMoveHueCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$EnhancedMoveHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$EnhancedMoveHueCommand$Request$CommandFields colorControlTrait$EnhancedMoveHueCommand$Request$CommandFields : ColorControlTrait$EnhancedMoveHueCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$EnhancedMoveHueCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$EnhancedMoveHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$EnhancedMoveToHueAndSaturationCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EnhancedMoveToHueAndSaturationCommand implements CommandDescriptor {
        public static final EnhancedMoveToHueAndSaturationCommand INSTANCE = new EnhancedMoveToHueAndSaturationCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 67, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private EnhancedMoveToHueAndSaturationCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields colorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields : ColorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields.values()) {
                if (colorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields colorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields : ColorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$EnhancedMoveToHueAndSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$EnhancedMoveToHueCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EnhancedMoveToHueCommand implements CommandDescriptor {
        public static final EnhancedMoveToHueCommand INSTANCE = new EnhancedMoveToHueCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 64, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private EnhancedMoveToHueCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields colorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields : ColorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields.values()) {
                if (colorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields colorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields : ColorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$EnhancedMoveToHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$EnhancedStepHueCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EnhancedStepHueCommand implements CommandDescriptor {
        public static final EnhancedStepHueCommand INSTANCE = new EnhancedStepHueCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 66, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private EnhancedStepHueCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$EnhancedStepHueCommand$Request$CommandFields colorControlTrait$EnhancedStepHueCommand$Request$CommandFields : ColorControlTrait$EnhancedStepHueCommand$Request$CommandFields.values()) {
                if (colorControlTrait$EnhancedStepHueCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$EnhancedStepHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$EnhancedStepHueCommand$Request$CommandFields colorControlTrait$EnhancedStepHueCommand$Request$CommandFields : ColorControlTrait$EnhancedStepHueCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$EnhancedStepHueCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$EnhancedStepHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "hueAndSaturation", "enhancedHue", "colorLoop", "xy", "colorTemperature", "<init>", "(ZZZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getHueAndSaturation", "()Z", "getEnhancedHue", "getColorLoop", "getXy", "getColorTemperature", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Feature extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean colorLoop;
        private final boolean colorTemperature;
        private final boolean enhancedHue;
        private final boolean hueAndSaturation;
        private final boolean xy;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControlTrait$Feature$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\u0010\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\n\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\u000b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$Feature$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$Feature;", "<init>", "()V", "HUE_AND_SATURATION_FLAG", "Lkotlin/ULong;", "J", "ENHANCED_HUE_FLAG", "COLOR_LOOP_FLAG", "XY_FLAG", "COLOR_TEMPERATURE_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<Feature> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(Feature value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getHueAndSaturation());
                mutableBitmap.m564set4PLdz1A(2L, value.getEnhancedHue());
                mutableBitmap.m564set4PLdz1A(4L, value.getColorLoop());
                mutableBitmap.m564set4PLdz1A(8L, value.getXy());
                mutableBitmap.m564set4PLdz1A(16L, value.getColorTemperature());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Feature toRuntime(Bitmap value) {
                value.getClass();
                return new Feature(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L), value.m525getVKZWuLQ(8L), value.m525getVKZWuLQ(16L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Feature(boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            super(zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "Feature");
            this.hueAndSaturation = z;
            this.enhancedHue = z2;
            this.colorLoop = z3;
            this.xy = z4;
            this.colorTemperature = z5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Feature)) {
                return false;
            }
            Feature feature = (Feature) other;
            return this.hueAndSaturation == feature.hueAndSaturation && this.enhancedHue == feature.enhancedHue && this.colorLoop == feature.colorLoop && this.xy == feature.xy && this.colorTemperature == feature.colorTemperature;
        }

        public final boolean getColorLoop() {
            return this.colorLoop;
        }

        public final boolean getColorTemperature() {
            return this.colorTemperature;
        }

        public final boolean getEnhancedHue() {
            return this.enhancedHue;
        }

        public final boolean getHueAndSaturation() {
            return this.hueAndSaturation;
        }

        public final boolean getXy() {
            return this.xy;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.enhancedHue) + (Boolean.hashCode(this.hueAndSaturation) * 31);
            int iHashCode2 = Boolean.hashCode(this.colorLoop) + (iHashCode * 31);
            int iHashCode3 = Boolean.hashCode(this.xy);
            return Boolean.hashCode(this.colorTemperature) + ((iHashCode3 + (iHashCode2 * 31)) * 31);
        }

        public String toString() {
            boolean z = this.hueAndSaturation;
            int length = String.valueOf(z).length();
            boolean z2 = this.enhancedHue;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.colorLoop;
            int length3 = String.valueOf(z3).length();
            boolean z4 = this.xy;
            int length4 = String.valueOf(z4).length();
            boolean z5 = this.colorTemperature;
            return zzp.zza(new StringBuilder(length + 39 + length2 + 12 + length3 + 5 + length4 + 19 + String.valueOf(z5).length() + 1), z5, z4, z3, z2, z, "Feature(hueAndSaturation=", ", enhancedHue=", ", colorLoop=", ", xy=", ", colorTemperature=");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveColorCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveColorCommand implements CommandDescriptor {
        public static final MoveColorCommand INSTANCE = new MoveColorCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 8, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveColorCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$MoveColorCommand$Request$CommandFields colorControlTrait$MoveColorCommand$Request$CommandFields : ColorControlTrait$MoveColorCommand$Request$CommandFields.values()) {
                if (colorControlTrait$MoveColorCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$MoveColorCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$MoveColorCommand$Request$CommandFields colorControlTrait$MoveColorCommand$Request$CommandFields : ColorControlTrait$MoveColorCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$MoveColorCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$MoveColorCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveColorTemperatureCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveColorTemperatureCommand implements CommandDescriptor {
        public static final MoveColorTemperatureCommand INSTANCE = new MoveColorTemperatureCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 75, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveColorTemperatureCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$MoveColorTemperatureCommand$Request$CommandFields colorControlTrait$MoveColorTemperatureCommand$Request$CommandFields : ColorControlTrait$MoveColorTemperatureCommand$Request$CommandFields.values()) {
                if (colorControlTrait$MoveColorTemperatureCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$MoveColorTemperatureCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$MoveColorTemperatureCommand$Request$CommandFields colorControlTrait$MoveColorTemperatureCommand$Request$CommandFields : ColorControlTrait$MoveColorTemperatureCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$MoveColorTemperatureCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$MoveColorTemperatureCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveHueCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveHueCommand implements CommandDescriptor {
        public static final MoveHueCommand INSTANCE = new MoveHueCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveHueCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$MoveHueCommand$Request$CommandFields colorControlTrait$MoveHueCommand$Request$CommandFields : ColorControlTrait$MoveHueCommand$Request$CommandFields.values()) {
                if (colorControlTrait$MoveHueCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$MoveHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$MoveHueCommand$Request$CommandFields colorControlTrait$MoveHueCommand$Request$CommandFields : ColorControlTrait$MoveHueCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$MoveHueCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$MoveHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveSaturationCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveSaturationCommand implements CommandDescriptor {
        public static final MoveSaturationCommand INSTANCE = new MoveSaturationCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 4, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveSaturationCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$MoveSaturationCommand$Request$CommandFields colorControlTrait$MoveSaturationCommand$Request$CommandFields : ColorControlTrait$MoveSaturationCommand$Request$CommandFields.values()) {
                if (colorControlTrait$MoveSaturationCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$MoveSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$MoveSaturationCommand$Request$CommandFields colorControlTrait$MoveSaturationCommand$Request$CommandFields : ColorControlTrait$MoveSaturationCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$MoveSaturationCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$MoveSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToColorCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToColorCommand implements CommandDescriptor {
        public static final MoveToColorCommand INSTANCE = new MoveToColorCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 7, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToColorCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$MoveToColorCommand$Request$CommandFields colorControlTrait$MoveToColorCommand$Request$CommandFields : ColorControlTrait$MoveToColorCommand$Request$CommandFields.values()) {
                if (colorControlTrait$MoveToColorCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$MoveToColorCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$MoveToColorCommand$Request$CommandFields colorControlTrait$MoveToColorCommand$Request$CommandFields : ColorControlTrait$MoveToColorCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$MoveToColorCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$MoveToColorCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToColorTemperatureCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "Request", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToColorTemperatureCommand implements CommandDescriptor {
        public static final MoveToColorTemperatureCommand INSTANCE = new MoveToColorTemperatureCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0002\u0019\u001aB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0007\u001a\u00020\u0006¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToColorTemperatureCommand$Request;", "", "colorTemperatureMireds", "Lkotlin/UShort;", "transitionTime", "optionsMask", "Lkotlin/UByte;", "optionsOverride", "<init>", "(SSBBLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getColorTemperatureMireds-Mh2AYeg", "()S", "S", "getTransitionTime-Mh2AYeg", "getOptionsMask-w2LRezQ", "()B", "B", "getOptionsOverride-w2LRezQ", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "CommandFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Request {

            /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final short colorTemperatureMireds;
            private final byte optionsMask;
            private final byte optionsOverride;
            private final short transitionTime;

            /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControlTrait$MoveToColorTemperatureCommand$Request$Adapter, reason: from kotlin metadata */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToColorTemperatureCommand$Request$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$MoveToColorTemperatureCommand$Request;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion implements StructAdapter<Request> {
                private Companion() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.home.matter.serialization.StructAdapter
                public Request read(ClusterPayloadReader reader) {
                    reader.getClass();
                    ClusterPayloadReaderKt.unwrapPayload(reader, MoveToColorTemperatureCommand.INSTANCE.getRequestId());
                    ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                    return new Request(payload$default.getUshort().mo546getqim9Vi0(0, "ColorTemperatureMireds").getData(), payload$default.getUshort().mo546getqim9Vi0(1, "TransitionTime").getData(), payload$default.getUbyte().mo546getqim9Vi0(2, "OptionsMask").getData(), payload$default.getUbyte().mo546getqim9Vi0(3, "OptionsOverride").getData(), null);
                }

                @Override // com.google.home.matter.serialization.StructAdapter
                public void write(ClusterPayloadWriter writer, Request value) {
                    writer.getClass();
                    value.getClass();
                    ClusterPayloadWriterKt.wrapPayload(writer, MoveToColorTemperatureCommand.INSTANCE.getRequestId());
                    writer.getUshort().mo554writeqim9Vi0(0, UShort.m2432boximpl(value.getColorTemperatureMireds()));
                    writer.getUshort().mo554writeqim9Vi0(1, UShort.m2432boximpl(value.getTransitionTime()));
                    writer.getUbyte().mo554writeqim9Vi0(2, UByte.m2366boximpl(value.getOptionsMask()));
                    writer.getUbyte().mo554writeqim9Vi0(3, UByte.m2366boximpl(value.getOptionsOverride()));
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToColorTemperatureCommand$Request$CommandFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "colorTemperatureMireds", "transitionTime", "optionsMask", "optionsOverride", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class CommandFields implements Field {
                private static final /* synthetic */ EnumEntries $ENTRIES;
                private static final /* synthetic */ CommandFields[] $VALUES;
                public static final CommandFields colorTemperatureMireds;
                public static final CommandFields optionsMask;
                public static final CommandFields optionsOverride;
                public static final CommandFields transitionTime;
                private final Descriptor descriptor;
                private final boolean isNullable;
                private final int tag;
                private final Type typeEnum;
                private final String typeName;

                private static final /* synthetic */ CommandFields[] $values() {
                    return new CommandFields[]{colorTemperatureMireds, transitionTime, optionsMask, optionsOverride};
                }

                static {
                    Type type = Type.UShort;
                    NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                    colorTemperatureMireds = new CommandFields("colorTemperatureMireds", 0, 0, "UShort", type, noOpDescriptor, false);
                    transitionTime = new CommandFields("transitionTime", 1, 1, "UShort", type, noOpDescriptor, false);
                    Type type2 = Type.UByte;
                    optionsMask = new CommandFields("optionsMask", 2, 2, "UByte", type2, noOpDescriptor, false);
                    optionsOverride = new CommandFields("optionsOverride", 3, 3, "UByte", type2, noOpDescriptor, false);
                    CommandFields[] commandFieldsArr$values = $values();
                    $VALUES = commandFieldsArr$values;
                    $ENTRIES = EnumEntriesKt.enumEntries(commandFieldsArr$values);
                }

                private CommandFields(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
                    this.tag = i2;
                    this.typeName = str2;
                    this.typeEnum = type;
                    this.descriptor = descriptor;
                    this.isNullable = z;
                }

                public static CommandFields valueOf(String str) {
                    return (CommandFields) Enum.valueOf(CommandFields.class, str);
                }

                public static CommandFields[] values() {
                    return (CommandFields[]) $VALUES.clone();
                }

                @Override // com.google.home.Field
                public Descriptor getDescriptor() {
                    return this.descriptor;
                }

                /* JADX INFO: renamed from: getTag-pVg5ArA, reason: not valid java name and from getter */
                public int getTag() {
                    return this.tag;
                }

                @Override // com.google.home.Field
                public Type getTypeEnum() {
                    return this.typeEnum;
                }

                @Override // com.google.home.Field
                public String getTypeName() {
                    return this.typeName;
                }
            }

            private Request(short s, short s2, byte b, byte b2) {
                this.colorTemperatureMireds = s;
                this.transitionTime = s2;
                this.optionsMask = b;
                this.optionsOverride = b2;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Request)) {
                    return false;
                }
                Request request = (Request) other;
                return this.colorTemperatureMireds == request.colorTemperatureMireds && this.transitionTime == request.transitionTime && this.optionsMask == request.optionsMask && this.optionsOverride == request.optionsOverride;
            }

            /* JADX INFO: renamed from: getColorTemperatureMireds-Mh2AYeg, reason: not valid java name and from getter */
            public final short getColorTemperatureMireds() {
                return this.colorTemperatureMireds;
            }

            /* JADX INFO: renamed from: getOptionsMask-w2LRezQ, reason: not valid java name and from getter */
            public final byte getOptionsMask() {
                return this.optionsMask;
            }

            /* JADX INFO: renamed from: getOptionsOverride-w2LRezQ, reason: not valid java name and from getter */
            public final byte getOptionsOverride() {
                return this.optionsOverride;
            }

            /* JADX INFO: renamed from: getTransitionTime-Mh2AYeg, reason: not valid java name and from getter */
            public final short getTransitionTime() {
                return this.transitionTime;
            }

            public int hashCode() {
                int iM2435hashCodeimpl = UShort.m2435hashCodeimpl(this.colorTemperatureMireds) + 31;
                int iM2435hashCodeimpl2 = UShort.m2435hashCodeimpl(this.transitionTime) + (iM2435hashCodeimpl * 31);
                int iM2369hashCodeimpl = UByte.m2369hashCodeimpl(this.optionsMask);
                return UByte.m2369hashCodeimpl(this.optionsOverride) + ((iM2369hashCodeimpl + (iM2435hashCodeimpl2 * 31)) * 31);
            }

            public String toString() {
                byte b = this.optionsOverride;
                byte b2 = this.optionsMask;
                short s = this.transitionTime;
                String strM2436toStringimpl = UShort.m2436toStringimpl(this.colorTemperatureMireds);
                String strM2436toStringimpl2 = UShort.m2436toStringimpl(s);
                String strM2370toStringimpl = UByte.m2370toStringimpl(b2);
                String strM2370toStringimpl2 = UByte.m2370toStringimpl(b);
                StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(String.valueOf(strM2436toStringimpl).length(), 78, String.valueOf(strM2436toStringimpl2).length(), 14, String.valueOf(strM2370toStringimpl).length(), 18, String.valueOf(strM2370toStringimpl2).length()) + 1);
                FileInsert$$ExternalSyntheticOutline0.m(sb, "MoveToColorTemperatureCommand.Request(colorTemperatureMireds=", strM2436toStringimpl, ", transitionTime=", strM2436toStringimpl2);
                FileInsert$$ExternalSyntheticOutline0.m(sb, ", optionsMask=", strM2370toStringimpl, ", optionsOverride=", strM2370toStringimpl2);
                sb.append(")");
                return sb.toString();
            }

            public /* synthetic */ Request(short s, short s2, byte b, byte b2, DefaultConstructorMarker defaultConstructorMarker) {
                this(s, s2, b, b2);
            }
        }

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 10, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToColorTemperatureCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (Request.CommandFields commandFields : Request.CommandFields.values()) {
                if (commandFields.getTag() == tagId) {
                    return commandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (Request.CommandFields commandFields : Request.CommandFields.values()) {
                if (Intrinsics.areEqual(commandFields.name(), name)) {
                    return commandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToHueAndSaturationCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToHueAndSaturationCommand implements CommandDescriptor {
        public static final MoveToHueAndSaturationCommand INSTANCE = new MoveToHueAndSaturationCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 6, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToHueAndSaturationCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields colorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields : ColorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields.values()) {
                if (colorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields colorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields : ColorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$MoveToHueAndSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToHueCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "Request", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToHueCommand implements CommandDescriptor {
        public static final MoveToHueCommand INSTANCE = new MoveToHueCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u0007¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0014\u0010\rR\u0013\u0010\t\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0015\u0010\r¨\u0006\u001f"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToHueCommand$Request;", "", "hue", "Lkotlin/UByte;", "direction", "Lcom/google/home/matter/standard/ColorControlTrait$HueDirection;", "transitionTime", "Lkotlin/UShort;", "optionsMask", "optionsOverride", "<init>", "(BLcom/google/home/matter/standard/ColorControlTrait$HueDirection;SBBLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getHue-w2LRezQ", "()B", "B", "getDirection", "()Lcom/google/home/matter/standard/ColorControlTrait$HueDirection;", "getTransitionTime-Mh2AYeg", "()S", "S", "getOptionsMask-w2LRezQ", "getOptionsOverride-w2LRezQ", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "CommandFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Request {

            /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final HueDirection direction;
            private final byte hue;
            private final byte optionsMask;
            private final byte optionsOverride;
            private final short transitionTime;

            /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControlTrait$MoveToHueCommand$Request$Adapter, reason: from kotlin metadata */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToHueCommand$Request$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$MoveToHueCommand$Request;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion implements StructAdapter<Request> {
                private Companion() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.home.matter.serialization.StructAdapter
                public Request read(ClusterPayloadReader reader) {
                    reader.getClass();
                    ClusterPayloadReaderKt.unwrapPayload(reader, MoveToHueCommand.INSTANCE.getRequestId());
                    ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                    return new Request(payload$default.getUbyte().mo546getqim9Vi0(0, "Hue").getData(), (HueDirection) payload$default.m545enum(HueDirection.INSTANCE.getAdapter()).mo546getqim9Vi0(1, "Direction"), payload$default.getUshort().mo546getqim9Vi0(2, "TransitionTime").getData(), payload$default.getUbyte().mo546getqim9Vi0(3, "OptionsMask").getData(), payload$default.getUbyte().mo546getqim9Vi0(4, "OptionsOverride").getData(), null);
                }

                @Override // com.google.home.matter.serialization.StructAdapter
                public void write(ClusterPayloadWriter writer, Request value) {
                    writer.getClass();
                    value.getClass();
                    ClusterPayloadWriterKt.wrapPayload(writer, MoveToHueCommand.INSTANCE.getRequestId());
                    writer.getUbyte().mo554writeqim9Vi0(0, UByte.m2366boximpl(value.getHue()));
                    writer.m552enum(HueDirection.INSTANCE.getAdapter()).mo554writeqim9Vi0(1, value.getDirection());
                    writer.getUshort().mo554writeqim9Vi0(2, UShort.m2432boximpl(value.getTransitionTime()));
                    writer.getUbyte().mo554writeqim9Vi0(3, UByte.m2366boximpl(value.getOptionsMask()));
                    writer.getUbyte().mo554writeqim9Vi0(4, UByte.m2366boximpl(value.getOptionsOverride()));
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!¨\u0006\""}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToHueCommand$Request$CommandFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "hue", "direction", "transitionTime", "optionsMask", "optionsOverride", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class CommandFields implements Field {
                private static final /* synthetic */ EnumEntries $ENTRIES;
                private static final /* synthetic */ CommandFields[] $VALUES;
                public static final CommandFields direction;
                public static final CommandFields hue;
                public static final CommandFields optionsMask;
                public static final CommandFields optionsOverride;
                public static final CommandFields transitionTime;
                private final Descriptor descriptor;
                private final boolean isNullable;
                private final int tag;
                private final Type typeEnum;
                private final String typeName;

                private static final /* synthetic */ CommandFields[] $values() {
                    return new CommandFields[]{hue, direction, transitionTime, optionsMask, optionsOverride};
                }

                static {
                    Type type = Type.UByte;
                    NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                    hue = new CommandFields("hue", 0, 0, "UByte", type, noOpDescriptor, false);
                    direction = new CommandFields("direction", 1, 1, "HueDirection", Type.Enum, noOpDescriptor, false);
                    transitionTime = new CommandFields("transitionTime", 2, 2, "UShort", Type.UShort, noOpDescriptor, false);
                    optionsMask = new CommandFields("optionsMask", 3, 3, "UByte", type, noOpDescriptor, false);
                    optionsOverride = new CommandFields("optionsOverride", 4, 4, "UByte", type, noOpDescriptor, false);
                    CommandFields[] commandFieldsArr$values = $values();
                    $VALUES = commandFieldsArr$values;
                    $ENTRIES = EnumEntriesKt.enumEntries(commandFieldsArr$values);
                }

                private CommandFields(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
                    this.tag = i2;
                    this.typeName = str2;
                    this.typeEnum = type;
                    this.descriptor = descriptor;
                    this.isNullable = z;
                }

                public static CommandFields valueOf(String str) {
                    return (CommandFields) Enum.valueOf(CommandFields.class, str);
                }

                public static CommandFields[] values() {
                    return (CommandFields[]) $VALUES.clone();
                }

                @Override // com.google.home.Field
                public Descriptor getDescriptor() {
                    return this.descriptor;
                }

                /* JADX INFO: renamed from: getTag-pVg5ArA, reason: not valid java name and from getter */
                public int getTag() {
                    return this.tag;
                }

                @Override // com.google.home.Field
                public Type getTypeEnum() {
                    return this.typeEnum;
                }

                @Override // com.google.home.Field
                public String getTypeName() {
                    return this.typeName;
                }
            }

            private Request(byte b, HueDirection hueDirection, short s, byte b2, byte b3) {
                hueDirection.getClass();
                this.hue = b;
                this.direction = hueDirection;
                this.transitionTime = s;
                this.optionsMask = b2;
                this.optionsOverride = b3;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Request)) {
                    return false;
                }
                Request request = (Request) other;
                return this.hue == request.hue && this.direction == request.direction && this.transitionTime == request.transitionTime && this.optionsMask == request.optionsMask && this.optionsOverride == request.optionsOverride;
            }

            public final HueDirection getDirection() {
                return this.direction;
            }

            /* JADX INFO: renamed from: getHue-w2LRezQ, reason: not valid java name and from getter */
            public final byte getHue() {
                return this.hue;
            }

            /* JADX INFO: renamed from: getOptionsMask-w2LRezQ, reason: not valid java name and from getter */
            public final byte getOptionsMask() {
                return this.optionsMask;
            }

            /* JADX INFO: renamed from: getOptionsOverride-w2LRezQ, reason: not valid java name and from getter */
            public final byte getOptionsOverride() {
                return this.optionsOverride;
            }

            /* JADX INFO: renamed from: getTransitionTime-Mh2AYeg, reason: not valid java name and from getter */
            public final short getTransitionTime() {
                return this.transitionTime;
            }

            public int hashCode() {
                int iM2369hashCodeimpl = UByte.m2369hashCodeimpl(this.hue) + 31;
                int iHashCode = this.direction.hashCode() + (iM2369hashCodeimpl * 31);
                int iM2435hashCodeimpl = UShort.m2435hashCodeimpl(this.transitionTime) + (iHashCode * 31);
                int iM2369hashCodeimpl2 = UByte.m2369hashCodeimpl(this.optionsMask);
                return UByte.m2369hashCodeimpl(this.optionsOverride) + ((iM2369hashCodeimpl2 + (iM2435hashCodeimpl * 31)) * 31);
            }

            public String toString() {
                byte b = this.optionsOverride;
                byte b2 = this.optionsMask;
                short s = this.transitionTime;
                String strM2370toStringimpl = UByte.m2370toStringimpl(this.hue);
                String strM2436toStringimpl = UShort.m2436toStringimpl(s);
                String strM2370toStringimpl2 = UByte.m2370toStringimpl(b2);
                String strM2370toStringimpl3 = UByte.m2370toStringimpl(b);
                int length = String.valueOf(strM2370toStringimpl).length();
                HueDirection hueDirection = this.direction;
                int length2 = String.valueOf(hueDirection).length();
                int length3 = String.valueOf(strM2436toStringimpl).length();
                StringBuilder sb = new StringBuilder(length + 41 + length2 + 17 + length3 + 14 + String.valueOf(strM2370toStringimpl2).length() + 18 + String.valueOf(strM2370toStringimpl3).length() + 1);
                sb.append("MoveToHueCommand.Request(hue=");
                sb.append(strM2370toStringimpl);
                sb.append(", direction=");
                sb.append(hueDirection);
                FileInsert$$ExternalSyntheticOutline0.m(sb, ", transitionTime=", strM2436toStringimpl, ", optionsMask=", strM2370toStringimpl2);
                return Fragment$$ExternalSyntheticOutline1.m(sb, ", optionsOverride=", strM2370toStringimpl3, ")");
            }

            public /* synthetic */ Request(byte b, HueDirection hueDirection, short s, byte b2, byte b3, DefaultConstructorMarker defaultConstructorMarker) {
                this(b, hueDirection, s, b2, b3);
            }
        }

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToHueCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (Request.CommandFields commandFields : Request.CommandFields.values()) {
                if (commandFields.getTag() == tagId) {
                    return commandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (Request.CommandFields commandFields : Request.CommandFields.values()) {
                if (Intrinsics.areEqual(commandFields.name(), name)) {
                    return commandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MoveToSaturationCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToSaturationCommand implements CommandDescriptor {
        public static final MoveToSaturationCommand INSTANCE = new MoveToSaturationCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 3, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToSaturationCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$MoveToSaturationCommand$Request$CommandFields colorControlTrait$MoveToSaturationCommand$Request$CommandFields : ColorControlTrait$MoveToSaturationCommand$Request$CommandFields.values()) {
                if (colorControlTrait$MoveToSaturationCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$MoveToSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$MoveToSaturationCommand$Request$CommandFields colorControlTrait$MoveToSaturationCommand$Request$CommandFields : ColorControlTrait$MoveToSaturationCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$MoveToSaturationCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$MoveToSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bR\u0018\u0000 f2\u00020\u0001:\u0001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR$\u0010\u001f\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010\u0017\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR$\u0010\"\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR$\u0010%\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0010\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R\"\u0010(\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR$\u00101\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b1\u0010\u0017\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR$\u00104\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b4\u0010\u0010\u001a\u0004\b5\u0010\u0012\"\u0004\b6\u0010\u0014R\"\u00107\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u0010)\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-R$\u0010:\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b:\u0010\u0017\u001a\u0004\b;\u0010\u0019\"\u0004\b<\u0010\u001bR$\u0010=\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0017\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR$\u0010@\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0010\u001a\u0004\bA\u0010\u0012\"\u0004\bB\u0010\u0014R\"\u0010C\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bC\u0010)\u001a\u0004\bD\u0010+\"\u0004\bE\u0010-R$\u0010F\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0017\u001a\u0004\bG\u0010\u0019\"\u0004\bH\u0010\u001bR\"\u0010I\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bI\u0010)\u001a\u0004\bJ\u0010+\"\u0004\bK\u0010-R\u0016\u0010M\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bL\u0010\u0012R\u0016\u0010O\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bN\u0010\u0019R\u0016\u0010Q\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bP\u0010\u0019R\u0016\u0010S\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bR\u0010\u0019R\u0016\u0010U\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010\u0019R\u0016\u0010W\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0012R\u0016\u0010Y\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010\u0019R\u0016\u0010[\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0019R\u0016\u0010]\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010\u0012R\u0016\u0010_\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b^\u0010\u0019R\u0016\u0010a\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010\u0019R\u0016\u0010c\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u0012R\u0016\u0010e\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010\u0019¨\u0006g"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MutableAttributes;", "Lcom/google/home/matter/standard/ColorControlTrait$AttributesImpl;", "Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "attributes", "<init>", "(Lcom/google/home/matter/standard/ColorControlTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UByte;", "_options", "Lkotlin/UByte;", "get_options-7PGSa80$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UByte;", "set_options-3swpYEE$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UByte;)V", "Lkotlin/UShort;", "_whitePointX", "Lkotlin/UShort;", "get_whitePointX-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UShort;", "set_whitePointX-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UShort;)V", "_whitePointY", "get_whitePointY-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_whitePointY-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_colorPointRx", "get_colorPointRx-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_colorPointRx-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_colorPointRy", "get_colorPointRy-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_colorPointRy-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_colorPointRIntensity", "get_colorPointRIntensity-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_colorPointRIntensity-3swpYEE$java_com_google_home_matter_standard_clusters_android", "_isColorPointRIntensitySet", "Z", "get_isColorPointRIntensitySet$java_com_google_home_matter_standard_clusters_android", "()Z", "set_isColorPointRIntensitySet$java_com_google_home_matter_standard_clusters_android", "(Z)V", "_colorPointGx", "get_colorPointGx-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_colorPointGx-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_colorPointGy", "get_colorPointGy-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_colorPointGy-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_colorPointGIntensity", "get_colorPointGIntensity-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_colorPointGIntensity-3swpYEE$java_com_google_home_matter_standard_clusters_android", "_isColorPointGIntensitySet", "get_isColorPointGIntensitySet$java_com_google_home_matter_standard_clusters_android", "set_isColorPointGIntensitySet$java_com_google_home_matter_standard_clusters_android", "_colorPointBx", "get_colorPointBx-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_colorPointBx-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_colorPointBy", "get_colorPointBy-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_colorPointBy-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_colorPointBIntensity", "get_colorPointBIntensity-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_colorPointBIntensity-3swpYEE$java_com_google_home_matter_standard_clusters_android", "_isColorPointBIntensitySet", "get_isColorPointBIntensitySet$java_com_google_home_matter_standard_clusters_android", "set_isColorPointBIntensitySet$java_com_google_home_matter_standard_clusters_android", "_startUpColorTemperatureMireds", "get_startUpColorTemperatureMireds-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_startUpColorTemperatureMireds-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_isStartUpColorTemperatureMiredsSet", "get_isStartUpColorTemperatureMiredsSet$java_com_google_home_matter_standard_clusters_android", "set_isStartUpColorTemperatureMiredsSet$java_com_google_home_matter_standard_clusters_android", "getOptions-7PGSa80", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "getWhitePointX-XRpZGF0", "whitePointX", "getWhitePointY-XRpZGF0", "whitePointY", "getColorPointRx-XRpZGF0", "colorPointRx", "getColorPointRy-XRpZGF0", "colorPointRy", "getColorPointRIntensity-7PGSa80", "colorPointRIntensity", "getColorPointGx-XRpZGF0", "colorPointGx", "getColorPointGy-XRpZGF0", "colorPointGy", "getColorPointGIntensity-7PGSa80", "colorPointGIntensity", "getColorPointBx-XRpZGF0", "colorPointBx", "getColorPointBy-XRpZGF0", "colorPointBy", "getColorPointBIntensity-7PGSa80", "colorPointBIntensity", "getStartUpColorTemperatureMireds-XRpZGF0", "startUpColorTemperatureMireds", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableAttributes extends AttributesImpl {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private UByte _colorPointBIntensity;
        private UShort _colorPointBx;
        private UShort _colorPointBy;
        private UByte _colorPointGIntensity;
        private UShort _colorPointGx;
        private UShort _colorPointGy;
        private UByte _colorPointRIntensity;
        private UShort _colorPointRx;
        private UShort _colorPointRy;
        private boolean _isColorPointBIntensitySet;
        private boolean _isColorPointGIntensitySet;
        private boolean _isColorPointRIntensitySet;
        private boolean _isStartUpColorTemperatureMiredsSet;
        private UByte _options;
        private UShort _startUpColorTemperatureMireds;
        private UShort _whitePointX;
        private UShort _whitePointY;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControlTrait$MutableAttributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$MutableAttributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$MutableAttributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<MutableAttributes> {
            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public MutableAttributes read(ClusterPayloadReader reader) {
                reader.getClass();
                return new MutableAttributes(Attributes.INSTANCE.read(reader));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, MutableAttributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                ClusterPayloadWriterKt.wrapPayload(writer, ColorControlTrait.INSTANCE.getId());
                if (value.get_options() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(15))) {
                        throw HomeException.INSTANCE.invalidArgument(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    }
                    writer.getUbyte().mo554writeqim9Vi0(15, value.get_options());
                }
                if (value.get_whitePointX() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(48))) {
                        throw HomeException.INSTANCE.invalidArgument("whitePointX");
                    }
                    writer.getUshort().mo554writeqim9Vi0(48, value.get_whitePointX());
                }
                if (value.get_whitePointY() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(49))) {
                        throw HomeException.INSTANCE.invalidArgument("whitePointY");
                    }
                    writer.getUshort().mo554writeqim9Vi0(49, value.get_whitePointY());
                }
                if (value.get_colorPointRx() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(50))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointRx");
                    }
                    writer.getUshort().mo554writeqim9Vi0(50, value.get_colorPointRx());
                }
                if (value.get_colorPointRy() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(51))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointRy");
                    }
                    writer.getUshort().mo554writeqim9Vi0(51, value.get_colorPointRy());
                }
                if (value.get_isColorPointRIntensitySet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(52))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointRIntensity");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(52, value.get_colorPointRIntensity());
                }
                if (value.get_colorPointGx() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(54))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointGx");
                    }
                    writer.getUshort().mo554writeqim9Vi0(54, value.get_colorPointGx());
                }
                if (value.get_colorPointGy() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(55))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointGy");
                    }
                    writer.getUshort().mo554writeqim9Vi0(55, value.get_colorPointGy());
                }
                if (value.get_isColorPointGIntensitySet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(56))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointGIntensity");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(56, value.get_colorPointGIntensity());
                }
                if (value.get_colorPointBx() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(58))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointBx");
                    }
                    writer.getUshort().mo554writeqim9Vi0(58, value.get_colorPointBx());
                }
                if (value.get_colorPointBy() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(59))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointBy");
                    }
                    writer.getUshort().mo554writeqim9Vi0(59, value.get_colorPointBy());
                }
                if (value.get_isColorPointBIntensitySet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(60))) {
                        throw HomeException.INSTANCE.invalidArgument("colorPointBIntensity");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(60, value.get_colorPointBIntensity());
                }
                if (value.get_isStartUpColorTemperatureMiredsSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(16400))) {
                        throw HomeException.INSTANCE.invalidArgument("startUpColorTemperatureMireds");
                    }
                    writer.getUshort().mo554writeqim9Vi0(16400, value.get_startUpColorTemperatureMireds());
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutableAttributes(Attributes attributes) {
            super(attributes.getCurrentHue(), attributes.getCurrentSaturation(), attributes.getRemainingTime(), attributes.getCurrentX(), attributes.getCurrentY(), attributes.getDriftCompensation(), attributes.getCompensationText(), attributes.getColorTemperatureMireds(), attributes.getColorMode(), attributes.getOptions(), attributes.getNumberOfPrimaries(), attributes.getPrimary1X(), attributes.getPrimary1Y(), attributes.getPrimary1Intensity(), attributes.getPrimary2X(), attributes.getPrimary2Y(), attributes.getPrimary2Intensity(), attributes.getPrimary3X(), attributes.getPrimary3Y(), attributes.getPrimary3Intensity(), attributes.getPrimary4X(), attributes.getPrimary4Y(), attributes.getPrimary4Intensity(), attributes.getPrimary5X(), attributes.getPrimary5Y(), attributes.getPrimary5Intensity(), attributes.getPrimary6X(), attributes.getPrimary6Y(), attributes.getPrimary6Intensity(), attributes.getWhitePointX(), attributes.getWhitePointY(), attributes.getColorPointRx(), attributes.getColorPointRy(), attributes.getColorPointRIntensity(), attributes.getColorPointGx(), attributes.getColorPointGy(), attributes.getColorPointGIntensity(), attributes.getColorPointBx(), attributes.getColorPointBy(), attributes.getColorPointBIntensity(), attributes.getEnhancedCurrentHue(), attributes.getEnhancedColorMode(), attributes.getColorLoopActive(), attributes.getColorLoopDirection(), attributes.getColorLoopTime(), attributes.getColorLoopStartEnhancedHue(), attributes.getColorLoopStoredEnhancedHue(), attributes.getColorCapabilities(), attributes.getColorTempPhysicalMinMireds(), attributes.getColorTempPhysicalMaxMireds(), attributes.getCoupleColorTempToLevelMinMireds(), attributes.getStartUpColorTemperatureMireds(), attributes.getGeneratedCommandList(), attributes.getAcceptedCommandList(), attributes.getAttributeList(), attributes.getFeatureMap(), attributes.getClusterRevision(), null);
            attributes.getClass();
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MutableAttributes) {
                return super.equals(other);
            }
            return false;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointBIntensity-7PGSa80 */
        public UByte getColorPointBIntensity() {
            return this._isColorPointBIntensitySet ? this._colorPointBIntensity : super.getColorPointBIntensity();
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointBx-XRpZGF0 */
        public UShort getColorPointBx() {
            UShort uShort = this._colorPointBx;
            return uShort == null ? super.getColorPointBx() : uShort;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointBy-XRpZGF0 */
        public UShort getColorPointBy() {
            UShort uShort = this._colorPointBy;
            return uShort == null ? super.getColorPointBy() : uShort;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointGIntensity-7PGSa80 */
        public UByte getColorPointGIntensity() {
            return this._isColorPointGIntensitySet ? this._colorPointGIntensity : super.getColorPointGIntensity();
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointGx-XRpZGF0 */
        public UShort getColorPointGx() {
            UShort uShort = this._colorPointGx;
            return uShort == null ? super.getColorPointGx() : uShort;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointGy-XRpZGF0 */
        public UShort getColorPointGy() {
            UShort uShort = this._colorPointGy;
            return uShort == null ? super.getColorPointGy() : uShort;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointRIntensity-7PGSa80 */
        public UByte getColorPointRIntensity() {
            return this._isColorPointRIntensitySet ? this._colorPointRIntensity : super.getColorPointRIntensity();
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointRx-XRpZGF0 */
        public UShort getColorPointRx() {
            UShort uShort = this._colorPointRx;
            return uShort == null ? super.getColorPointRx() : uShort;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorPointRy-XRpZGF0 */
        public UShort getColorPointRy() {
            UShort uShort = this._colorPointRy;
            return uShort == null ? super.getColorPointRy() : uShort;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getOptions-7PGSa80 */
        public UByte getOptions() {
            UByte uByte = this._options;
            return uByte == null ? super.getOptions() : uByte;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getStartUpColorTemperatureMireds-XRpZGF0 */
        public UShort getStartUpColorTemperatureMireds() {
            return this._isStartUpColorTemperatureMiredsSet ? this._startUpColorTemperatureMireds : super.getStartUpColorTemperatureMireds();
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getWhitePointX-XRpZGF0 */
        public UShort getWhitePointX() {
            UShort uShort = this._whitePointX;
            return uShort == null ? super.getWhitePointX() : uShort;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl, com.google.home.matter.standard.ColorControlTrait.Attributes
        /* JADX INFO: renamed from: getWhitePointY-XRpZGF0 */
        public UShort getWhitePointY() {
            UShort uShort = this._whitePointY;
            return uShort == null ? super.getWhitePointY() : uShort;
        }

        /* JADX INFO: renamed from: get_colorPointBIntensity-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_colorPointBIntensity() {
            return this._colorPointBIntensity;
        }

        /* JADX INFO: renamed from: get_colorPointBx-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_colorPointBx() {
            return this._colorPointBx;
        }

        /* JADX INFO: renamed from: get_colorPointBy-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_colorPointBy() {
            return this._colorPointBy;
        }

        /* JADX INFO: renamed from: get_colorPointGIntensity-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_colorPointGIntensity() {
            return this._colorPointGIntensity;
        }

        /* JADX INFO: renamed from: get_colorPointGx-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_colorPointGx() {
            return this._colorPointGx;
        }

        /* JADX INFO: renamed from: get_colorPointGy-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_colorPointGy() {
            return this._colorPointGy;
        }

        /* JADX INFO: renamed from: get_colorPointRIntensity-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_colorPointRIntensity() {
            return this._colorPointRIntensity;
        }

        /* JADX INFO: renamed from: get_colorPointRx-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_colorPointRx() {
            return this._colorPointRx;
        }

        /* JADX INFO: renamed from: get_colorPointRy-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_colorPointRy() {
            return this._colorPointRy;
        }

        /* JADX INFO: renamed from: get_isColorPointBIntensitySet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isColorPointBIntensitySet() {
            return this._isColorPointBIntensitySet;
        }

        /* JADX INFO: renamed from: get_isColorPointGIntensitySet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isColorPointGIntensitySet() {
            return this._isColorPointGIntensitySet;
        }

        /* JADX INFO: renamed from: get_isColorPointRIntensitySet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isColorPointRIntensitySet() {
            return this._isColorPointRIntensitySet;
        }

        /* JADX INFO: renamed from: get_isStartUpColorTemperatureMiredsSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isStartUpColorTemperatureMiredsSet() {
            return this._isStartUpColorTemperatureMiredsSet;
        }

        /* JADX INFO: renamed from: get_options-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_options() {
            return this._options;
        }

        /* JADX INFO: renamed from: get_startUpColorTemperatureMireds-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_startUpColorTemperatureMireds() {
            return this._startUpColorTemperatureMireds;
        }

        /* JADX INFO: renamed from: get_whitePointX-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_whitePointX() {
            return this._whitePointX;
        }

        /* JADX INFO: renamed from: get_whitePointY-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_whitePointY() {
            return this._whitePointY;
        }

        @Override // com.google.home.matter.standard.ColorControlTrait.AttributesImpl
        public String toString() {
            String string = super.toString();
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 32), "ColorControl.MutableAttributes(", string, ")");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$StepColorCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepColorCommand implements CommandDescriptor {
        public static final StepColorCommand INSTANCE = new StepColorCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 9, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StepColorCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$StepColorCommand$Request$CommandFields colorControlTrait$StepColorCommand$Request$CommandFields : ColorControlTrait$StepColorCommand$Request$CommandFields.values()) {
                if (colorControlTrait$StepColorCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$StepColorCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$StepColorCommand$Request$CommandFields colorControlTrait$StepColorCommand$Request$CommandFields : ColorControlTrait$StepColorCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$StepColorCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$StepColorCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$StepColorTemperatureCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepColorTemperatureCommand implements CommandDescriptor {
        public static final StepColorTemperatureCommand INSTANCE = new StepColorTemperatureCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 76, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StepColorTemperatureCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$StepColorTemperatureCommand$Request$CommandFields colorControlTrait$StepColorTemperatureCommand$Request$CommandFields : ColorControlTrait$StepColorTemperatureCommand$Request$CommandFields.values()) {
                if (colorControlTrait$StepColorTemperatureCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$StepColorTemperatureCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$StepColorTemperatureCommand$Request$CommandFields colorControlTrait$StepColorTemperatureCommand$Request$CommandFields : ColorControlTrait$StepColorTemperatureCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$StepColorTemperatureCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$StepColorTemperatureCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$StepHueCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepHueCommand implements CommandDescriptor {
        public static final StepHueCommand INSTANCE = new StepHueCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StepHueCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$StepHueCommand$Request$CommandFields colorControlTrait$StepHueCommand$Request$CommandFields : ColorControlTrait$StepHueCommand$Request$CommandFields.values()) {
                if (colorControlTrait$StepHueCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$StepHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$StepHueCommand$Request$CommandFields colorControlTrait$StepHueCommand$Request$CommandFields : ColorControlTrait$StepHueCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$StepHueCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$StepHueCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$StepSaturationCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepSaturationCommand implements CommandDescriptor {
        public static final StepSaturationCommand INSTANCE = new StepSaturationCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 5, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StepSaturationCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$StepSaturationCommand$Request$CommandFields colorControlTrait$StepSaturationCommand$Request$CommandFields : ColorControlTrait$StepSaturationCommand$Request$CommandFields.values()) {
                if (colorControlTrait$StepSaturationCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$StepSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$StepSaturationCommand$Request$CommandFields colorControlTrait$StepSaturationCommand$Request$CommandFields : ColorControlTrait$StepSaturationCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$StepSaturationCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$StepSaturationCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$StopMoveStepCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StopMoveStepCommand implements CommandDescriptor {
        public static final StopMoveStepCommand INSTANCE = new StopMoveStepCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ColorControlTrait.INSTANCE.getId(), 71, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StopMoveStepCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ColorControlTrait$StopMoveStepCommand$Request$CommandFields colorControlTrait$StopMoveStepCommand$Request$CommandFields : ColorControlTrait$StopMoveStepCommand$Request$CommandFields.values()) {
                if (colorControlTrait$StopMoveStepCommand$Request$CommandFields.getTag() == tagId) {
                    return colorControlTrait$StopMoveStepCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ColorControlTrait$StopMoveStepCommand$Request$CommandFields colorControlTrait$StopMoveStepCommand$Request$CommandFields : ColorControlTrait$StopMoveStepCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(colorControlTrait$StopMoveStepCommand$Request$CommandFields.name(), name)) {
                    return colorControlTrait$StopMoveStepCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private ColorControlTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopAction;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Deactivate", "ActivateFromColorLoopStartEnhancedHue", "ActivateFromEnhancedCurrentHue", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ColorLoopAction implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ColorLoopAction[] $VALUES;
        public static final ColorLoopAction ActivateFromColorLoopStartEnhancedHue;
        public static final ColorLoopAction ActivateFromEnhancedCurrentHue;
        private static final EnumAdapter<ColorLoopAction> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ColorLoopAction Deactivate;
        public static final ColorLoopAction UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopAction$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopAction;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ColorLoopAction> getAdapter() {
                return ColorLoopAction.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ColorLoopAction[] $values() {
            return new ColorLoopAction[]{Deactivate, ActivateFromColorLoopStartEnhancedHue, ActivateFromEnhancedCurrentHue, UnknownValue};
        }

        static {
            String str = null;
            Deactivate = new ColorLoopAction("Deactivate", 0, 0L, null, str, 6, null);
            String str2 = null;
            ActivateFromColorLoopStartEnhancedHue = new ColorLoopAction("ActivateFromColorLoopStartEnhancedHue", 1, 1L, str, str2, 6, null);
            String str3 = null;
            ActivateFromEnhancedCurrentHue = new ColorLoopAction("ActivateFromEnhancedCurrentHue", 2, 2L, str2, str3, 6, null);
            UnknownValue = new ColorLoopAction("UnknownValue", 3, -1L, str3, null, 6, null);
            ColorLoopAction[] colorLoopActionArr$values = $values();
            $VALUES = colorLoopActionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(colorLoopActionArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ColorLoopAction(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ColorLoopAction" : str3);
        }

        public static ColorLoopAction valueOf(String str) {
            return (ColorLoopAction) Enum.valueOf(ColorLoopAction.class, str);
        }

        public static ColorLoopAction[] values() {
            return (ColorLoopAction[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private ColorLoopAction(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopDirection;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "DecrementHue", "IncrementHue", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ColorLoopDirection implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ColorLoopDirection[] $VALUES;
        private static final EnumAdapter<ColorLoopDirection> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ColorLoopDirection DecrementHue;
        public static final ColorLoopDirection IncrementHue;
        public static final ColorLoopDirection UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopDirection$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$ColorLoopDirection;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ColorLoopDirection> getAdapter() {
                return ColorLoopDirection.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ColorLoopDirection[] $values() {
            return new ColorLoopDirection[]{DecrementHue, IncrementHue, UnknownValue};
        }

        static {
            String str = null;
            DecrementHue = new ColorLoopDirection("DecrementHue", 0, 0L, null, str, 6, null);
            String str2 = null;
            IncrementHue = new ColorLoopDirection("IncrementHue", 1, 1L, str, str2, 6, null);
            UnknownValue = new ColorLoopDirection("UnknownValue", 2, -1L, str2, null, 6, null);
            ColorLoopDirection[] colorLoopDirectionArr$values = $values();
            $VALUES = colorLoopDirectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(colorLoopDirectionArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ColorLoopDirection(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ColorLoopDirection" : str3);
        }

        public static ColorLoopDirection valueOf(String str) {
            return (ColorLoopDirection) Enum.valueOf(ColorLoopDirection.class, str);
        }

        public static ColorLoopDirection[] values() {
            return (ColorLoopDirection[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private ColorLoopDirection(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorMode;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "CurrentHueAndCurrentSaturation", "CurrentXAndCurrentY", "ColorTemperature", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ColorMode implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ColorMode[] $VALUES;
        private static final EnumAdapter<ColorMode> Adapter;
        public static final ColorMode ColorTemperature;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ColorMode CurrentHueAndCurrentSaturation;
        public static final ColorMode CurrentXAndCurrentY;
        public static final ColorMode UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$ColorMode$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$ColorMode;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ColorMode> getAdapter() {
                return ColorMode.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ColorMode[] $values() {
            return new ColorMode[]{CurrentHueAndCurrentSaturation, CurrentXAndCurrentY, ColorTemperature, UnknownValue};
        }

        static {
            String str = null;
            CurrentHueAndCurrentSaturation = new ColorMode("CurrentHueAndCurrentSaturation", 0, 0L, null, str, 6, null);
            String str2 = null;
            CurrentXAndCurrentY = new ColorMode("CurrentXAndCurrentY", 1, 1L, str, str2, 6, null);
            String str3 = null;
            ColorTemperature = new ColorMode("ColorTemperature", 2, 2L, str2, str3, 6, null);
            UnknownValue = new ColorMode("UnknownValue", 3, -1L, str3, null, 6, null);
            ColorMode[] colorModeArr$values = $values();
            $VALUES = colorModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(colorModeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ColorMode(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ColorMode" : str3);
        }

        public static ColorMode valueOf(String str) {
            return (ColorMode) Enum.valueOf(ColorMode.class, str);
        }

        public static ColorMode[] values() {
            return (ColorMode[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private ColorMode(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0015B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$HueDirection;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "ShortestDistance", "LongestDistance", "Up", "Down", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HueDirection implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HueDirection[] $VALUES;
        private static final EnumAdapter<HueDirection> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final HueDirection Down;
        public static final HueDirection LongestDistance;
        public static final HueDirection ShortestDistance;
        public static final HueDirection UnknownValue;
        public static final HueDirection Up;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$HueDirection$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$HueDirection;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<HueDirection> getAdapter() {
                return HueDirection.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ HueDirection[] $values() {
            return new HueDirection[]{ShortestDistance, LongestDistance, Up, Down, UnknownValue};
        }

        static {
            String str = null;
            ShortestDistance = new HueDirection("ShortestDistance", 0, 0L, null, str, 6, null);
            String str2 = null;
            LongestDistance = new HueDirection("LongestDistance", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Up = new HueDirection("Up", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Down = new HueDirection("Down", 3, 3L, str3, str4, 6, null);
            UnknownValue = new HueDirection("UnknownValue", 4, -1L, str4, null, 6, null);
            HueDirection[] hueDirectionArr$values = $values();
            $VALUES = hueDirectionArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hueDirectionArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ HueDirection(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "HueDirection" : str3);
        }

        public static HueDirection valueOf(String str) {
            return (HueDirection) Enum.valueOf(HueDirection.class, str);
        }

        public static HueDirection[] values() {
            return (HueDirection[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private HueDirection(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$HueMoveMode;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Stop", "Up", "Down", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HueMoveMode implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HueMoveMode[] $VALUES;
        private static final EnumAdapter<HueMoveMode> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final HueMoveMode Down;
        public static final HueMoveMode Stop;
        public static final HueMoveMode UnknownValue;
        public static final HueMoveMode Up;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$HueMoveMode$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$HueMoveMode;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<HueMoveMode> getAdapter() {
                return HueMoveMode.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ HueMoveMode[] $values() {
            return new HueMoveMode[]{Stop, Up, Down, UnknownValue};
        }

        static {
            String str = null;
            Stop = new HueMoveMode("Stop", 0, 0L, null, str, 6, null);
            String str2 = null;
            Up = new HueMoveMode("Up", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Down = new HueMoveMode("Down", 2, 3L, str2, str3, 6, null);
            UnknownValue = new HueMoveMode("UnknownValue", 3, -1L, str3, null, 6, null);
            HueMoveMode[] hueMoveModeArr$values = $values();
            $VALUES = hueMoveModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hueMoveModeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ HueMoveMode(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "HueMoveMode" : str3);
        }

        public static HueMoveMode valueOf(String str) {
            return (HueMoveMode) Enum.valueOf(HueMoveMode.class, str);
        }

        public static HueMoveMode[] values() {
            return (HueMoveMode[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private HueMoveMode(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$HueStepMode;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Up", "Down", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class HueStepMode implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ HueStepMode[] $VALUES;
        private static final EnumAdapter<HueStepMode> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final HueStepMode Down;
        public static final HueStepMode UnknownValue;
        public static final HueStepMode Up;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$HueStepMode$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$HueStepMode;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<HueStepMode> getAdapter() {
                return HueStepMode.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ HueStepMode[] $values() {
            return new HueStepMode[]{Up, Down, UnknownValue};
        }

        static {
            String str = null;
            Up = new HueStepMode("Up", 0, 1L, null, str, 6, null);
            String str2 = null;
            Down = new HueStepMode("Down", 1, 3L, str, str2, 6, null);
            UnknownValue = new HueStepMode("UnknownValue", 2, -1L, str2, null, 6, null);
            HueStepMode[] hueStepModeArr$values = $values();
            $VALUES = hueStepModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(hueStepModeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ HueStepMode(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "HueStepMode" : str3);
        }

        public static HueStepMode valueOf(String str) {
            return (HueStepMode) Enum.valueOf(HueStepMode.class, str);
        }

        public static HueStepMode[] values() {
            return (HueStepMode[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private HueStepMode(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$SaturationMoveMode;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Stop", "Up", "Down", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SaturationMoveMode implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SaturationMoveMode[] $VALUES;
        private static final EnumAdapter<SaturationMoveMode> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SaturationMoveMode Down;
        public static final SaturationMoveMode Stop;
        public static final SaturationMoveMode UnknownValue;
        public static final SaturationMoveMode Up;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$SaturationMoveMode$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$SaturationMoveMode;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<SaturationMoveMode> getAdapter() {
                return SaturationMoveMode.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ SaturationMoveMode[] $values() {
            return new SaturationMoveMode[]{Stop, Up, Down, UnknownValue};
        }

        static {
            String str = null;
            Stop = new SaturationMoveMode("Stop", 0, 0L, null, str, 6, null);
            String str2 = null;
            Up = new SaturationMoveMode("Up", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Down = new SaturationMoveMode("Down", 2, 3L, str2, str3, 6, null);
            UnknownValue = new SaturationMoveMode("UnknownValue", 3, -1L, str3, null, 6, null);
            SaturationMoveMode[] saturationMoveModeArr$values = $values();
            $VALUES = saturationMoveModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(saturationMoveModeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ SaturationMoveMode(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "SaturationMoveMode" : str3);
        }

        public static SaturationMoveMode valueOf(String str) {
            return (SaturationMoveMode) Enum.valueOf(SaturationMoveMode.class, str);
        }

        public static SaturationMoveMode[] values() {
            return (SaturationMoveMode[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private SaturationMoveMode(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$SaturationStepMode;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Up", "Down", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SaturationStepMode implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SaturationStepMode[] $VALUES;
        private static final EnumAdapter<SaturationStepMode> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SaturationStepMode Down;
        public static final SaturationStepMode UnknownValue;
        public static final SaturationStepMode Up;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ColorControlTrait$SaturationStepMode$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ColorControlTrait$SaturationStepMode;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<SaturationStepMode> getAdapter() {
                return SaturationStepMode.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ SaturationStepMode[] $values() {
            return new SaturationStepMode[]{Up, Down, UnknownValue};
        }

        static {
            String str = null;
            Up = new SaturationStepMode("Up", 0, 1L, null, str, 6, null);
            String str2 = null;
            Down = new SaturationStepMode("Down", 1, 3L, str, str2, 6, null);
            UnknownValue = new SaturationStepMode("UnknownValue", 2, -1L, str2, null, 6, null);
            SaturationStepMode[] saturationStepModeArr$values = $values();
            $VALUES = saturationStepModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(saturationStepModeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ SaturationStepMode(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(768, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "SaturationStepMode" : str3);
        }

        public static SaturationStepMode valueOf(String str) {
            return (SaturationStepMode) Enum.valueOf(SaturationStepMode.class, str);
        }

        public static SaturationStepMode[] values() {
            return (SaturationStepMode[]) $VALUES.clone();
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTraitId() {
            return this.traitId;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        public String getTypeName() {
            return this.typeName;
        }

        @Override // com.google.home.matter.serialization.ClusterEnum
        /* JADX INFO: renamed from: getValue-s-VKNKU, reason: from getter */
        public long getValue() {
            return this.value;
        }

        private SaturationStepMode(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}
