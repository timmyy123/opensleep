package com.google.home.google;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.StructDescriptor;
import com.google.home.Type;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.google.home.google.LightEffectsTrait;
import com.google.home.matter.serialization.Bitmap;
import com.google.home.matter.serialization.BitmapAdapter;
import com.google.home.matter.serialization.ClusterBitmap;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadReaderKt;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.ClusterPayloadWriterKt;
import com.google.home.matter.serialization.MutableBitmap;
import com.google.home.matter.serialization.OptionalValue;
import com.google.home.matter.serialization.ScopedCommandId;
import com.google.home.matter.serialization.StructAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\t\b\t\n\u000b\f\r\u000e\u000f\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/google/home/google/LightEffectsTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "LightEffectsFeature", "SpectrumHsv", "Color", "Attributes", "AttributesImpl", "PulseEffectSetCommand", "SleepEffectSetCommand", "WakeEffectSetCommand", "StopEffectCommand", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LightEffectsTrait {
    public static final LightEffectsTrait INSTANCE = new LightEffectsTrait();
    private static final ClusterId Id = new ClusterId(1611070528, "LightEffects", null, 4, null);

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 $2\u00020\u0001:\u0001$R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R\u0012\u0010\u001c\u001a\u00020\u001dX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0012\u0010 \u001a\u00020!X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006%À\u0006\u0001"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$Attributes;", "", "defaultSleepDurationSeconds", "Lkotlin/UInt;", "getDefaultSleepDurationSeconds-0hXNFcg", "()Lkotlin/UInt;", "defaultWakeDurationSeconds", "getDefaultWakeDurationSeconds-0hXNFcg", "effectEndTimestampSeconds", "", "getEffectEndTimestampSeconds", "()Ljava/lang/Long;", "pulseEffectSet", "", "getPulseEffectSet", "()Ljava/lang/Boolean;", "sleepEffectSet", "getSleepEffectSet", "wakeEffectSet", "getWakeEffectSet", "generatedCommandList", "", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;", "getFeatureMap", "()Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;", "clusterRevision", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.google.LightEffectsTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/LightEffectsTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, LightEffectsTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue<UInt> optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.getUint().mo549getOptionalNullableqim9Vi0(0, "DefaultSleepDurationSeconds");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                UInt orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<UInt> optionalValueMo549getOptionalNullableqim9Vi02 = payload$default.getUint().mo549getOptionalNullableqim9Vi0(1, "DefaultWakeDurationSeconds");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                UInt orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue<Long> optionalValueMo549getOptionalNullableqim9Vi03 = payload$default.getLong().mo549getOptionalNullableqim9Vi0(2, "EffectEndTimestampSeconds");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                Unit unit = Unit.INSTANCE;
                Long orNull3 = optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi04 = payload$default.getBoolean().mo549getOptionalNullableqim9Vi0(3, "PulseEffectSet");
                if (optionalValueMo549getOptionalNullableqim9Vi04.isPresent() && optionalValueMo549getOptionalNullableqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                Boolean orNull4 = optionalValueMo549getOptionalNullableqim9Vi04.getOrNull();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi05 = payload$default.getBoolean().mo549getOptionalNullableqim9Vi0(4, "SleepEffectSet");
                if (optionalValueMo549getOptionalNullableqim9Vi05.isPresent() && optionalValueMo549getOptionalNullableqim9Vi05.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                Boolean orNull5 = optionalValueMo549getOptionalNullableqim9Vi05.getOrNull();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi06 = payload$default.getBoolean().mo549getOptionalNullableqim9Vi0(5, "WakeEffectSet");
                if (optionalValueMo549getOptionalNullableqim9Vi06.isPresent() && optionalValueMo549getOptionalNullableqim9Vi06.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(5));
                }
                Boolean orNull6 = optionalValueMo549getOptionalNullableqim9Vi06.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload$default.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                List<UInt> listMo547getListqim9Vi02 = payload$default.getUint().mo547getListqim9Vi0(65529, "AcceptedCommandList");
                arrayList.add(UInt.m2388boximpl(65529));
                arrayList.add(UInt.m2388boximpl(65531));
                LightEffectsFeature lightEffectsFeature = (LightEffectsFeature) payload$default.bitmap(LightEffectsFeature.INSTANCE).mo546getqim9Vi0(65532, "FeatureMap");
                arrayList.add(UInt.m2388boximpl(65532));
                UShort uShortMo546getqim9Vi0 = payload$default.getUshort().mo546getqim9Vi0(65533, "ClusterRevision");
                uShortMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65533));
                return new AttributesImpl(orNull, orNull2, orNull3, orNull4, orNull5, orNull6, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, lightEffectsFeature, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) {
                writer.getClass();
                value.getClass();
                ClusterPayloadWriterKt.wrapPayload(writer, LightEffectsTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getUint().mo554writeqim9Vi0(0, value.getDefaultSleepDurationSeconds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.getUint().mo554writeqim9Vi0(1, value.getDefaultWakeDurationSeconds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.getLong().mo554writeqim9Vi0(2, value.getEffectEndTimestampSeconds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.getBoolean().mo554writeqim9Vi0(3, value.getPulseEffectSet());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.getBoolean().mo554writeqim9Vi0(4, value.getSleepEffectSet());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(5))) {
                    writer.getBoolean().mo554writeqim9Vi0(5, value.getWakeEffectSet());
                }
                writer.getUint().mo555writeListqim9Vi0(65528, value.getGeneratedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65529, value.getAcceptedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65531, value.getAttributeList());
                writer.bitmap(LightEffectsFeature.INSTANCE).mo554writeqim9Vi0(65532, value.getFeatureMap());
                writer.getUshort().mo554writeqim9Vi0(65533, UShort.m2432boximpl(value.getClusterRevision()));
            }
        }

        List<UInt> getAcceptedCommandList();

        List<UInt> getAttributeList();

        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg */
        short getClusterRevision();

        /* JADX INFO: renamed from: getDefaultSleepDurationSeconds-0hXNFcg */
        UInt getDefaultSleepDurationSeconds();

        /* JADX INFO: renamed from: getDefaultWakeDurationSeconds-0hXNFcg */
        UInt getDefaultWakeDurationSeconds();

        Long getEffectEndTimestampSeconds();

        LightEffectsFeature getFeatureMap();

        List<UInt> getGeneratedCommandList();

        Boolean getPulseEffectSet();

        Boolean getSleepEffectSet();

        Boolean getWakeEffectSet();
    }

    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001b\b\u0016\u0018\u0000 62\u00020\u0001:\u00016B\u0093\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b\"\u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010&\u001a\u0004\b)\u0010(R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b*\u0010(R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010+\u001a\u0004\b,\u0010-R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010+\u001a\u0004\b.\u0010-R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010+\u001a\u0004\b/\u0010-R\u001a\u0010\u0010\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u00100\u001a\u0004\b1\u00102R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u00103\u001a\u0004\b4\u00105¨\u00067"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$AttributesImpl;", "Lcom/google/home/google/LightEffectsTrait$Attributes;", "Lkotlin/UInt;", "defaultSleepDurationSeconds", "defaultWakeDurationSeconds", "", "effectEndTimestampSeconds", "", "pulseEffectSet", "sleepEffectSet", "wakeEffectSet", "", "generatedCommandList", "acceptedCommandList", "attributeList", "Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;", "featureMap", "Lkotlin/UShort;", "clusterRevision", "<init>", "(Lkotlin/UInt;Lkotlin/UInt;Ljava/lang/Long;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UInt;", "getDefaultSleepDurationSeconds-0hXNFcg", "()Lkotlin/UInt;", "getDefaultWakeDurationSeconds-0hXNFcg", "Ljava/lang/Long;", "getEffectEndTimestampSeconds", "()Ljava/lang/Long;", "Ljava/lang/Boolean;", "getPulseEffectSet", "()Ljava/lang/Boolean;", "getSleepEffectSet", "getWakeEffectSet", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;", "getFeatureMap", "()Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final UInt defaultSleepDurationSeconds;
        private final UInt defaultWakeDurationSeconds;
        private final Long effectEndTimestampSeconds;
        private final LightEffectsFeature featureMap;
        private final List<UInt> generatedCommandList;
        private final Boolean pulseEffectSet;
        private final Boolean sleepEffectSet;
        private final Boolean wakeEffectSet;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private AttributesImpl(UInt uInt, UInt uInt2, Long l, Boolean bool, Boolean bool2, Boolean bool3, List<UInt> list, List<UInt> list2, List<UInt> list3, LightEffectsFeature lightEffectsFeature, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            lightEffectsFeature.getClass();
            this.defaultSleepDurationSeconds = uInt;
            this.defaultWakeDurationSeconds = uInt2;
            this.effectEndTimestampSeconds = l;
            this.pulseEffectSet = bool;
            this.sleepEffectSet = bool2;
            this.wakeEffectSet = bool3;
            this.generatedCommandList = list;
            this.acceptedCommandList = list2;
            this.attributeList = list3;
            this.featureMap = lightEffectsFeature;
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
            return Intrinsics.areEqual(getDefaultSleepDurationSeconds(), attributes.getDefaultSleepDurationSeconds()) && Intrinsics.areEqual(getDefaultWakeDurationSeconds(), attributes.getDefaultWakeDurationSeconds()) && Intrinsics.areEqual(getEffectEndTimestampSeconds(), attributes.getEffectEndTimestampSeconds()) && Intrinsics.areEqual(getPulseEffectSet(), attributes.getPulseEffectSet()) && Intrinsics.areEqual(getSleepEffectSet(), attributes.getSleepEffectSet()) && Intrinsics.areEqual(getWakeEffectSet(), attributes.getWakeEffectSet()) && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && Intrinsics.areEqual(getFeatureMap(), attributes.getFeatureMap()) && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        /* JADX INFO: renamed from: getDefaultSleepDurationSeconds-0hXNFcg, reason: from getter */
        public UInt getDefaultSleepDurationSeconds() {
            return this.defaultSleepDurationSeconds;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        /* JADX INFO: renamed from: getDefaultWakeDurationSeconds-0hXNFcg, reason: from getter */
        public UInt getDefaultWakeDurationSeconds() {
            return this.defaultWakeDurationSeconds;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public Long getEffectEndTimestampSeconds() {
            return this.effectEndTimestampSeconds;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public LightEffectsFeature getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public Boolean getPulseEffectSet() {
            return this.pulseEffectSet;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public Boolean getSleepEffectSet() {
            return this.sleepEffectSet;
        }

        @Override // com.google.home.google.LightEffectsTrait.Attributes
        public Boolean getWakeEffectSet() {
            return this.wakeEffectSet;
        }

        public int hashCode() {
            UInt defaultSleepDurationSeconds = getDefaultSleepDurationSeconds();
            int iM2391hashCodeimpl = defaultSleepDurationSeconds != null ? UInt.m2391hashCodeimpl(defaultSleepDurationSeconds.getData()) : 0;
            UInt defaultWakeDurationSeconds = getDefaultWakeDurationSeconds();
            int iM2391hashCodeimpl2 = defaultWakeDurationSeconds != null ? UInt.m2391hashCodeimpl(defaultWakeDurationSeconds.getData()) : 0;
            int i = iM2391hashCodeimpl + 31;
            Long effectEndTimestampSeconds = getEffectEndTimestampSeconds();
            int iHashCode = ((((i * 31) + iM2391hashCodeimpl2) * 31) + (effectEndTimestampSeconds != null ? effectEndTimestampSeconds.hashCode() : 0)) * 31;
            Boolean pulseEffectSet = getPulseEffectSet();
            int iHashCode2 = (iHashCode + (pulseEffectSet != null ? pulseEffectSet.hashCode() : 0)) * 31;
            Boolean sleepEffectSet = getSleepEffectSet();
            int iHashCode3 = (iHashCode2 + (sleepEffectSet != null ? sleepEffectSet.hashCode() : 0)) * 31;
            Boolean wakeEffectSet = getWakeEffectSet();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((getFeatureMap().hashCode() + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iHashCode3 + (wakeEffectSet != null ? wakeEffectSet.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            UInt defaultSleepDurationSeconds = getDefaultSleepDurationSeconds();
            UInt defaultWakeDurationSeconds = getDefaultWakeDurationSeconds();
            Long effectEndTimestampSeconds = getEffectEndTimestampSeconds();
            Boolean pulseEffectSet = getPulseEffectSet();
            Boolean sleepEffectSet = getSleepEffectSet();
            Boolean wakeEffectSet = getWakeEffectSet();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            LightEffectsFeature featureMap = getFeatureMap();
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(defaultSleepDurationSeconds).length();
            int length2 = String.valueOf(defaultWakeDurationSeconds).length();
            int length3 = String.valueOf(effectEndTimestampSeconds).length();
            int length4 = String.valueOf(pulseEffectSet).length();
            int length5 = String.valueOf(sleepEffectSet).length();
            int length6 = String.valueOf(wakeEffectSet).length();
            int length7 = String.valueOf(generatedCommandList).length();
            int length8 = String.valueOf(acceptedCommandList).length();
            int length9 = String.valueOf(attributeList).length();
            StringBuilder sb = new StringBuilder(length + 70 + length2 + 28 + length3 + 17 + length4 + 17 + length5 + 16 + length6 + 23 + length7 + 22 + length8 + 16 + length9 + 13 + String.valueOf(featureMap).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1);
            sb.append("LightEffects(defaultSleepDurationSeconds=");
            sb.append(defaultSleepDurationSeconds);
            sb.append(", defaultWakeDurationSeconds=");
            sb.append(defaultWakeDurationSeconds);
            sb.append(", effectEndTimestampSeconds=");
            sb.append(effectEndTimestampSeconds);
            sb.append(", pulseEffectSet=");
            sb.append(pulseEffectSet);
            sb.append(", sleepEffectSet=");
            sb.append(sleepEffectSet);
            sb.append(", wakeEffectSet=");
            sb.append(wakeEffectSet);
            sb.append(", generatedCommandList=");
            sb.append(generatedCommandList);
            sb.append(", acceptedCommandList=");
            sb.append(acceptedCommandList);
            sb.append(", attributeList=");
            sb.append(attributeList);
            sb.append(", featureMap=");
            sb.append(featureMap);
            return Fragment$$ExternalSyntheticOutline1.m(sb, ", clusterRevision=", strM2436toStringimpl, ")");
        }

        public /* synthetic */ AttributesImpl(UInt uInt, UInt uInt2, Long l, Boolean bool, Boolean bool2, Boolean bool3, List list, List list2, List list3, LightEffectsFeature lightEffectsFeature, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(uInt, uInt2, l, bool, bool2, bool3, list, list2, list3, lightEffectsFeature, s);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001c\u001dB/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u00020\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$Color;", "", "name", "", "temperature", "Lkotlin/UInt;", "spectrumHsv", "Lcom/google/home/google/LightEffectsTrait$SpectrumHsv;", "spectrumRgb", "Lkotlin/ULong;", "<init>", "(Ljava/lang/String;ILcom/google/home/google/LightEffectsTrait$SpectrumHsv;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getName", "()Ljava/lang/String;", "getTemperature-pVg5ArA", "()I", "I", "getSpectrumHsv", "()Lcom/google/home/google/LightEffectsTrait$SpectrumHsv;", "getSpectrumRgb-s-VKNKU", "()J", "J", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Color {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String name;
        private final SpectrumHsv spectrumHsv;
        private final long spectrumRgb;
        private final int temperature;

        /* JADX INFO: renamed from: com.google.home.google.LightEffectsTrait$Color$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$Color$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/LightEffectsTrait$Color;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/LightEffectsTrait$Color;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/LightEffectsTrait$Color;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Color>, StructDescriptor {
            private Companion() {
            }

            @Override // com.google.home.StructDescriptor
            /* JADX INFO: renamed from: getFieldById-WZ4Q5Ns */
            public Field mo448getFieldByIdWZ4Q5Ns(int tagId) {
                for (StructFields structFields : StructFields.values()) {
                    if (structFields.getTag() == tagId) {
                        return structFields;
                    }
                }
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Color read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(2), SpectrumHsv.INSTANCE)));
                return new Color(payload.getString().mo546getqim9Vi0(0, "Name"), payload.getUint().mo546getqim9Vi0(1, "Temperature").getData(), (SpectrumHsv) new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<SpectrumHsv>() { // from class: com.google.home.google.LightEffectsTrait$Color$Adapter$read$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final LightEffectsTrait.SpectrumHsv invoke() {
                        return new LightEffectsTrait.SpectrumHsv(0.0d, 0.0d, 0.0d, 7, null);
                    }
                }, Reflection.getOrCreateKotlinClass(SpectrumHsv.class)).mo546getqim9Vi0(2, "SpectrumHsv"), payload.getUlong().mo546getqim9Vi0(3, "SpectrumRgb").getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Color value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getName());
                writer.getUint().mo554writeqim9Vi0(1, UInt.m2388boximpl(value.getTemperature()));
                writer.struct(SpectrumHsv.INSTANCE).mo554writeqim9Vi0(2, value.getSpectrumHsv());
                writer.getUlong().mo554writeqim9Vi0(3, ULong.m2410boximpl(value.getSpectrumRgb()));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$Color$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "Name", "temperature", "spectrumHsv", "spectrumRgb", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields Name;
            public static final StructFields spectrumHsv;
            public static final StructFields spectrumRgb;
            public static final StructFields temperature;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{Name, temperature, spectrumHsv, spectrumRgb};
            }

            static {
                Type type = Type.String;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                Name = new StructFields("Name", 0, 0, "String", type, noOpDescriptor, false);
                temperature = new StructFields("temperature", 1, 1, "UInt", Type.UInt, noOpDescriptor, false);
                spectrumHsv = new StructFields("spectrumHsv", 2, 2, "SpectrumHSV", Type.Struct, SpectrumHsv.INSTANCE, false);
                spectrumRgb = new StructFields("spectrumRgb", 3, 3, "ULong", Type.ULong, noOpDescriptor, false);
                StructFields[] structFieldsArr$values = $values();
                $VALUES = structFieldsArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(structFieldsArr$values);
            }

            private StructFields(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
                this.tag = i2;
                this.typeName = str2;
                this.typeEnum = type;
                this.descriptor = descriptor;
                this.isNullable = z;
            }

            public static StructFields valueOf(String str) {
                return (StructFields) Enum.valueOf(StructFields.class, str);
            }

            public static StructFields[] values() {
                return (StructFields[]) $VALUES.clone();
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

        private Color(String str, int i, SpectrumHsv spectrumHsv, long j) {
            str.getClass();
            spectrumHsv.getClass();
            this.name = str;
            this.temperature = i;
            this.spectrumHsv = spectrumHsv;
            this.spectrumRgb = j;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Color)) {
                return false;
            }
            Color color = (Color) other;
            return Intrinsics.areEqual(this.name, color.name) && this.temperature == color.temperature && Intrinsics.areEqual(this.spectrumHsv, color.spectrumHsv) && this.spectrumRgb == color.spectrumRgb;
        }

        public final String getName() {
            return this.name;
        }

        public final SpectrumHsv getSpectrumHsv() {
            return this.spectrumHsv;
        }

        /* JADX INFO: renamed from: getSpectrumRgb-s-VKNKU, reason: not valid java name and from getter */
        public final long getSpectrumRgb() {
            return this.spectrumRgb;
        }

        /* JADX INFO: renamed from: getTemperature-pVg5ArA, reason: not valid java name and from getter */
        public final int getTemperature() {
            return this.temperature;
        }

        public int hashCode() {
            int iHashCode = this.name.hashCode() + 31;
            int iM2391hashCodeimpl = UInt.m2391hashCodeimpl(this.temperature) + (iHashCode * 31);
            int iHashCode2 = this.spectrumHsv.hashCode() + (iM2391hashCodeimpl * 31);
            return ULong.m2413hashCodeimpl(this.spectrumRgb) + (iHashCode2 * 31);
        }

        public String toString() {
            long j = this.spectrumRgb;
            String strM2392toStringimpl = UInt.m2392toStringimpl(this.temperature);
            String strM2414toStringimpl = ULong.m2414toStringimpl(j);
            String str = this.name;
            int length = String.valueOf(str).length();
            int length2 = String.valueOf(strM2392toStringimpl).length();
            SpectrumHsv spectrumHsv = this.spectrumHsv;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 25, length2, 14, String.valueOf(spectrumHsv).length(), 14, String.valueOf(strM2414toStringimpl).length()) + 1);
            FileInsert$$ExternalSyntheticOutline0.m(sb, "Color(name=", str, ", temperature=", strM2392toStringimpl);
            sb.append(", spectrumHsv=");
            sb.append(spectrumHsv);
            sb.append(", spectrumRgb=");
            sb.append(strM2414toStringimpl);
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ Color(String str, int i, SpectrumHsv spectrumHsv, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, spectrumHsv, j);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "pulse", "sleep", "wake", "<init>", "(ZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getPulse", "()Z", "getSleep", "getWake", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class LightEffectsFeature extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean pulse;
        private final boolean sleep;
        private final boolean wake;

        /* JADX INFO: renamed from: com.google.home.google.LightEffectsTrait$LightEffectsFeature$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/google/LightEffectsTrait$LightEffectsFeature;", "<init>", "()V", "PULSE_FLAG", "Lkotlin/ULong;", "J", "SLEEP_FLAG", "WAKE_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<LightEffectsFeature> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(LightEffectsFeature value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getPulse());
                mutableBitmap.m564set4PLdz1A(2L, value.getSleep());
                mutableBitmap.m564set4PLdz1A(4L, value.getWake());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public LightEffectsFeature toRuntime(Bitmap value) {
                value.getClass();
                return new LightEffectsFeature(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public LightEffectsFeature(boolean z, boolean z2, boolean z3) {
            super(zza$$ExternalSyntheticOutline0.m(1611070528, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "LightEffectsFeature");
            this.pulse = z;
            this.sleep = z2;
            this.wake = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LightEffectsFeature)) {
                return false;
            }
            LightEffectsFeature lightEffectsFeature = (LightEffectsFeature) other;
            return this.pulse == lightEffectsFeature.pulse && this.sleep == lightEffectsFeature.sleep && this.wake == lightEffectsFeature.wake;
        }

        public final boolean getPulse() {
            return this.pulse;
        }

        public final boolean getSleep() {
            return this.sleep;
        }

        public final boolean getWake() {
            return this.wake;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.sleep) + (Boolean.hashCode(this.pulse) * 31);
            return Boolean.hashCode(this.wake) + (iHashCode * 31);
        }

        public String toString() {
            boolean z = this.pulse;
            int length = String.valueOf(z).length();
            boolean z2 = this.sleep;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.wake;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 34, length2, 7, String.valueOf(z3).length()) + 1);
            zza$$ExternalSyntheticOutline0.m(sb, "LightEffectsFeature(pulse=", z, ", sleep=", z2);
            sb.append(", wake=");
            sb.append(z3);
            sb.append(")");
            return sb.toString();
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$PulseEffectSetCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PulseEffectSetCommand implements CommandDescriptor {
        public static final PulseEffectSetCommand INSTANCE = new PulseEffectSetCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LightEffectsTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private PulseEffectSetCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LightEffectsTrait$PulseEffectSetCommand$Request$CommandFields lightEffectsTrait$PulseEffectSetCommand$Request$CommandFields : LightEffectsTrait$PulseEffectSetCommand$Request$CommandFields.values()) {
                if (lightEffectsTrait$PulseEffectSetCommand$Request$CommandFields.getTag() == tagId) {
                    return lightEffectsTrait$PulseEffectSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LightEffectsTrait$PulseEffectSetCommand$Request$CommandFields lightEffectsTrait$PulseEffectSetCommand$Request$CommandFields : LightEffectsTrait$PulseEffectSetCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(lightEffectsTrait$PulseEffectSetCommand$Request$CommandFields.name(), name)) {
                    return lightEffectsTrait$PulseEffectSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$SleepEffectSetCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SleepEffectSetCommand implements CommandDescriptor {
        public static final SleepEffectSetCommand INSTANCE = new SleepEffectSetCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LightEffectsTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SleepEffectSetCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LightEffectsTrait$SleepEffectSetCommand$Request$CommandFields lightEffectsTrait$SleepEffectSetCommand$Request$CommandFields : LightEffectsTrait$SleepEffectSetCommand$Request$CommandFields.values()) {
                if (lightEffectsTrait$SleepEffectSetCommand$Request$CommandFields.getTag() == tagId) {
                    return lightEffectsTrait$SleepEffectSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LightEffectsTrait$SleepEffectSetCommand$Request$CommandFields lightEffectsTrait$SleepEffectSetCommand$Request$CommandFields : LightEffectsTrait$SleepEffectSetCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(lightEffectsTrait$SleepEffectSetCommand$Request$CommandFields.name(), name)) {
                    return lightEffectsTrait$SleepEffectSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$StopEffectCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StopEffectCommand implements CommandDescriptor {
        public static final StopEffectCommand INSTANCE = new StopEffectCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LightEffectsTrait.INSTANCE.getId(), 3, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StopEffectCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$WakeEffectSetCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class WakeEffectSetCommand implements CommandDescriptor {
        public static final WakeEffectSetCommand INSTANCE = new WakeEffectSetCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LightEffectsTrait.INSTANCE.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private WakeEffectSetCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LightEffectsTrait$WakeEffectSetCommand$Request$CommandFields lightEffectsTrait$WakeEffectSetCommand$Request$CommandFields : LightEffectsTrait$WakeEffectSetCommand$Request$CommandFields.values()) {
                if (lightEffectsTrait$WakeEffectSetCommand$Request$CommandFields.getTag() == tagId) {
                    return lightEffectsTrait$WakeEffectSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LightEffectsTrait$WakeEffectSetCommand$Request$CommandFields lightEffectsTrait$WakeEffectSetCommand$Request$CommandFields : LightEffectsTrait$WakeEffectSetCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(lightEffectsTrait$WakeEffectSetCommand$Request$CommandFields.name(), name)) {
                    return lightEffectsTrait$WakeEffectSetCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private LightEffectsTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$SpectrumHsv;", "", "saturation", "", "hue", SDKConstants.PARAM_VALUE, "<init>", "(DDD)V", "getSaturation", "()D", "getHue", "getValue", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SpectrumHsv {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final double hue;
        private final double saturation;
        private final double value;

        /* JADX INFO: renamed from: com.google.home.google.LightEffectsTrait$SpectrumHsv$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/LightEffectsTrait$SpectrumHsv$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/LightEffectsTrait$SpectrumHsv;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/LightEffectsTrait$SpectrumHsv;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/LightEffectsTrait$SpectrumHsv;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<SpectrumHsv>, StructDescriptor {
            private Companion() {
            }

            @Override // com.google.home.StructDescriptor
            /* JADX INFO: renamed from: getFieldById-WZ4Q5Ns */
            public Field mo448getFieldByIdWZ4Q5Ns(int tagId) {
                for (StructFields structFields : StructFields.values()) {
                    if (structFields.getTag() == tagId) {
                        return structFields;
                    }
                }
                return null;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public SpectrumHsv read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new SpectrumHsv(payload$default.getDouble().mo546getqim9Vi0(0, "Saturation").doubleValue(), payload$default.getDouble().mo546getqim9Vi0(1, "Hue").doubleValue(), payload$default.getDouble().mo546getqim9Vi0(2, "Value").doubleValue());
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, SpectrumHsv value) {
                writer.getClass();
                value.getClass();
                writer.getDouble().mo554writeqim9Vi0(0, Double.valueOf(value.getSaturation()));
                writer.getDouble().mo554writeqim9Vi0(1, Double.valueOf(value.getHue()));
                writer.getDouble().mo554writeqim9Vi0(2, Double.valueOf(value.getValue()));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001f¨\u0006 "}, d2 = {"Lcom/google/home/google/LightEffectsTrait$SpectrumHsv$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "saturation", "hue", SDKConstants.PARAM_VALUE, "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields hue;
            public static final StructFields saturation;
            public static final StructFields value;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{saturation, hue, value};
            }

            static {
                Type type = Type.Double;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                saturation = new StructFields("saturation", 0, 0, "Double", type, noOpDescriptor, false);
                hue = new StructFields("hue", 1, 1, "Double", type, noOpDescriptor, false);
                value = new StructFields(SDKConstants.PARAM_VALUE, 2, 2, "Double", type, noOpDescriptor, false);
                StructFields[] structFieldsArr$values = $values();
                $VALUES = structFieldsArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(structFieldsArr$values);
            }

            private StructFields(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
                this.tag = i2;
                this.typeName = str2;
                this.typeEnum = type;
                this.descriptor = descriptor;
                this.isNullable = z;
            }

            public static StructFields valueOf(String str) {
                return (StructFields) Enum.valueOf(StructFields.class, str);
            }

            public static StructFields[] values() {
                return (StructFields[]) $VALUES.clone();
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

        public /* synthetic */ SpectrumHsv(double d, double d2, double d3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? 0.0d : d, (i & 2) != 0 ? 0.0d : d2, (i & 4) != 0 ? 0.0d : d3);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SpectrumHsv)) {
                return false;
            }
            SpectrumHsv spectrumHsv = (SpectrumHsv) other;
            return this.saturation == spectrumHsv.saturation && this.hue == spectrumHsv.hue && this.value == spectrumHsv.value;
        }

        public final double getHue() {
            return this.hue;
        }

        public final double getSaturation() {
            return this.saturation;
        }

        public final double getValue() {
            return this.value;
        }

        public int hashCode() {
            int iHashCode = Double.hashCode(this.saturation) + 31;
            int iHashCode2 = Double.hashCode(this.hue);
            return Double.hashCode(this.value) + ((iHashCode2 + (iHashCode * 31)) * 31);
        }

        public String toString() {
            double d = this.saturation;
            int length = String.valueOf(d).length();
            double d2 = this.hue;
            int length2 = String.valueOf(d2).length();
            double d3 = this.value;
            StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 29, length2, 8, String.valueOf(d3).length()) + 1);
            sb.append("SpectrumHsv(saturation=");
            sb.append(d);
            sb.append(", hue=");
            sb.append(d2);
            sb.append(", value=");
            sb.append(d3);
            sb.append(")");
            return sb.toString();
        }

        public SpectrumHsv(double d, double d2, double d3) {
            this.saturation = d;
            this.hue = d2;
            this.value = d3;
        }
    }
}
