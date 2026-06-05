package com.google.home.matter.standard;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Field;
import com.google.home.HomeException;
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
import kotlin.UInt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001:\u000f\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "DelayedAllOffEffectVariantEnum", "DyingLightEffectVariantEnum", "EffectIdentifierEnum", "StartUpOnOffEnum", "Feature", "OnOffControlBitmap", "Attributes", "AttributesImpl", "MutableAttributes", "OffCommand", "OnCommand", "ToggleCommand", "OffWithEffectCommand", "OnWithRecallGlobalSceneCommand", "OnWithTimedOffCommand", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class OnOffTrait {
    public static final OnOffTrait INSTANCE = new OnOffTrait();
    private static final ClusterId Id = new ClusterId(6, "OnOff", null, 4, null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \"2\u00020\u0001:\u0001\"R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0018\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0016R\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006#À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$Attributes;", "", "onOff", "", "getOnOff", "()Ljava/lang/Boolean;", "globalSceneControl", "getGlobalSceneControl", "onTime", "Lkotlin/UShort;", "getOnTime-XRpZGF0", "()Lkotlin/UShort;", "offWaitTime", "getOffWaitTime-XRpZGF0", "startUpOnOff", "Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "getStartUpOnOff", "()Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "generatedCommandList", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "Lcom/google/home/matter/standard/OnOffTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/OnOffTrait$Feature;", "clusterRevision", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.matter.standard.OnOffTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, OnOffTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.getBoolean().mo549getOptionalNullableqim9Vi0(0, "OnOff");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                Boolean orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi02 = payload$default.getBoolean().mo549getOptionalNullableqim9Vi0(16384, "GlobalSceneControl");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16384));
                }
                Boolean orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi03 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16385, "OnTime");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16385));
                }
                Unit unit = Unit.INSTANCE;
                UShort orNull3 = optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi04 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16386, "OffWaitTime");
                if (optionalValueMo549getOptionalNullableqim9Vi04.isPresent() && optionalValueMo549getOptionalNullableqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16386));
                }
                UShort orNull4 = optionalValueMo549getOptionalNullableqim9Vi04.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi05 = payload$default.m545enum(StartUpOnOffEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(16387, "StartUpOnOff");
                if (optionalValueMo549getOptionalNullableqim9Vi05.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(16387));
                }
                StartUpOnOffEnum startUpOnOffEnum = (StartUpOnOffEnum) optionalValueMo549getOptionalNullableqim9Vi05.getOrNull();
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
                return new OnOff(orNull, orNull2, orNull3, orNull4, startUpOnOffEnum, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, feature, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                if (value instanceof MutableAttributes) {
                    MutableAttributes.INSTANCE.write(writer, (MutableAttributes) value);
                    return;
                }
                ClusterPayloadWriterKt.wrapPayload(writer, OnOffTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getBoolean().mo554writeqim9Vi0(0, value.getOnOff());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16384))) {
                    writer.getBoolean().mo554writeqim9Vi0(16384, value.getGlobalSceneControl());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16385))) {
                    writer.getUshort().mo554writeqim9Vi0(16385, value.getOnTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16386))) {
                    writer.getUshort().mo554writeqim9Vi0(16386, value.getOffWaitTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16387))) {
                    writer.m552enum(StartUpOnOffEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(16387, value.getStartUpOnOff());
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

        Feature getFeatureMap();

        List<UInt> getGeneratedCommandList();

        Boolean getGlobalSceneControl();

        /* JADX INFO: renamed from: getOffWaitTime-XRpZGF0 */
        UShort getOffWaitTime();

        Boolean getOnOff();

        /* JADX INFO: renamed from: getOnTime-XRpZGF0 */
        UShort getOnTime();

        StartUpOnOffEnum getStartUpOnOff();
    }

    /* JADX INFO: renamed from: com.google.home.matter.standard.OnOffTrait$AttributesImpl, reason: from toString */
    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0016\u0018\u0000 52\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u00015B\u0087\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001f\u001a\u0004\b \u0010!R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001f\u001a\u0004\b\"\u0010!R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b&\u0010%R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010'\u001a\u0004\b(\u0010)R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010*\u001a\u0004\b+\u0010,R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010*\u001a\u0004\b-\u0010,R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010*\u001a\u0004\b.\u0010,R\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b0\u00101R\u001a\u0010\u0013\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u00102\u001a\u0004\b3\u00104¨\u00066"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$AttributesImpl;", "Lcom/google/home/matter/standard/OnOffTrait$Attributes;", "", "Lcom/google/home/matter/standard/OnOffTrait$MutableAttributes;", "", "onOff", "globalSceneControl", "Lkotlin/UShort;", "onTime", "offWaitTime", "Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "startUpOnOff", "", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "Lcom/google/home/matter/standard/OnOffTrait$Feature;", "featureMap", "clusterRevision", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/UShort;Lkotlin/UShort;Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/google/home/matter/standard/OnOffTrait$Feature;SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getOnOff", "()Ljava/lang/Boolean;", "getGlobalSceneControl", "Lkotlin/UShort;", "getOnTime-XRpZGF0", "()Lkotlin/UShort;", "getOffWaitTime-XRpZGF0", "Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "getStartUpOnOff", "()Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "Lcom/google/home/matter/standard/OnOffTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/OnOffTrait$Feature;", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class OnOff implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final Feature featureMap;
        private final List<UInt> generatedCommandList;
        private final Boolean globalSceneControl;
        private final UShort offWaitTime;
        private final Boolean onOff;
        private final UShort onTime;
        private final StartUpOnOffEnum startUpOnOff;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private OnOff(Boolean bool, Boolean bool2, UShort uShort, UShort uShort2, StartUpOnOffEnum startUpOnOffEnum, List<UInt> list, List<UInt> list2, List<UInt> list3, Feature feature, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            feature.getClass();
            this.onOff = bool;
            this.globalSceneControl = bool2;
            this.onTime = uShort;
            this.offWaitTime = uShort2;
            this.startUpOnOff = startUpOnOffEnum;
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
            return Intrinsics.areEqual(getOnOff(), attributes.getOnOff()) && Intrinsics.areEqual(getGlobalSceneControl(), attributes.getGlobalSceneControl()) && Intrinsics.areEqual(getOnTime(), attributes.getOnTime()) && Intrinsics.areEqual(getOffWaitTime(), attributes.getOffWaitTime()) && getStartUpOnOff() == attributes.getStartUpOnOff() && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && Intrinsics.areEqual(getFeatureMap(), attributes.getFeatureMap()) && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        public Feature getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        public Boolean getGlobalSceneControl() {
            return this.globalSceneControl;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        /* JADX INFO: renamed from: getOffWaitTime-XRpZGF0, reason: from getter */
        public UShort getOffWaitTime() {
            return this.offWaitTime;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        public Boolean getOnOff() {
            return this.onOff;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        /* JADX INFO: renamed from: getOnTime-XRpZGF0, reason: from getter */
        public UShort getOnTime() {
            return this.onTime;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.Attributes
        public StartUpOnOffEnum getStartUpOnOff() {
            return this.startUpOnOff;
        }

        public int hashCode() {
            Boolean onOff = getOnOff();
            int iHashCode = onOff != null ? onOff.hashCode() : 0;
            Boolean globalSceneControl = getGlobalSceneControl();
            int iHashCode2 = globalSceneControl != null ? globalSceneControl.hashCode() : 0;
            int i = iHashCode + 31;
            UShort onTime = getOnTime();
            int iM2435hashCodeimpl = ((((i * 31) + iHashCode2) * 31) + (onTime != null ? UShort.m2435hashCodeimpl(onTime.getData()) : 0)) * 31;
            UShort offWaitTime = getOffWaitTime();
            int iM2435hashCodeimpl2 = (iM2435hashCodeimpl + (offWaitTime != null ? UShort.m2435hashCodeimpl(offWaitTime.getData()) : 0)) * 31;
            StartUpOnOffEnum startUpOnOff = getStartUpOnOff();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((getFeatureMap().hashCode() + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iM2435hashCodeimpl2 + (startUpOnOff != null ? startUpOnOff.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            Boolean onOff = getOnOff();
            Boolean globalSceneControl = getGlobalSceneControl();
            UShort onTime = getOnTime();
            UShort offWaitTime = getOffWaitTime();
            StartUpOnOffEnum startUpOnOff = getStartUpOnOff();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            Feature featureMap = getFeatureMap();
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(onOff).length();
            int length2 = String.valueOf(globalSceneControl).length();
            int length3 = String.valueOf(onTime).length();
            int length4 = String.valueOf(offWaitTime).length();
            int length5 = String.valueOf(startUpOnOff).length();
            int length6 = String.valueOf(generatedCommandList).length();
            int length7 = String.valueOf(acceptedCommandList).length();
            int length8 = String.valueOf(attributeList).length();
            StringBuilder sb = new StringBuilder(length + 33 + length2 + 9 + length3 + 14 + length4 + 15 + length5 + 23 + length6 + 22 + length7 + 16 + length8 + 13 + String.valueOf(featureMap).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1);
            sb.append("OnOff(onOff=");
            sb.append(onOff);
            sb.append(", globalSceneControl=");
            sb.append(globalSceneControl);
            sb.append(", onTime=");
            sb.append(onTime);
            sb.append(", offWaitTime=");
            sb.append(offWaitTime);
            sb.append(", startUpOnOff=");
            sb.append(startUpOnOff);
            sb.append(", generatedCommandList=");
            sb.append(generatedCommandList);
            sb.append(", acceptedCommandList=");
            sb.append(acceptedCommandList);
            sb.append(", attributeList=");
            sb.append(attributeList);
            sb.append(", featureMap=");
            sb.append(featureMap);
            sb.append(", clusterRevision=");
            sb.append(strM2436toStringimpl);
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ OnOff(Boolean bool, Boolean bool2, UShort uShort, UShort uShort2, StartUpOnOffEnum startUpOnOffEnum, List list, List list2, List list3, Feature feature, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool, bool2, uShort, uShort2, startUpOnOffEnum, list, list2, list3, feature, s);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$Feature;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "lighting", "deadFrontBehavior", "offOnly", "<init>", "(ZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getLighting", "()Z", "getDeadFrontBehavior", "getOffOnly", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Feature extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean deadFrontBehavior;
        private final boolean lighting;
        private final boolean offOnly;

        /* JADX INFO: renamed from: com.google.home.matter.standard.OnOffTrait$Feature$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$Feature$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$Feature;", "<init>", "()V", "LIGHTING_FLAG", "Lkotlin/ULong;", "J", "DEAD_FRONT_BEHAVIOR_FLAG", "OFF_ONLY_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<Feature> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(Feature value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getLighting());
                mutableBitmap.m564set4PLdz1A(2L, value.getDeadFrontBehavior());
                mutableBitmap.m564set4PLdz1A(4L, value.getOffOnly());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Feature toRuntime(Bitmap value) {
                value.getClass();
                return new Feature(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L), value.m525getVKZWuLQ(4L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Feature(boolean z, boolean z2, boolean z3) {
            super(zza$$ExternalSyntheticOutline0.m(6, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "Feature");
            this.lighting = z;
            this.deadFrontBehavior = z2;
            this.offOnly = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Feature)) {
                return false;
            }
            Feature feature = (Feature) other;
            return this.lighting == feature.lighting && this.deadFrontBehavior == feature.deadFrontBehavior && this.offOnly == feature.offOnly;
        }

        public final boolean getDeadFrontBehavior() {
            return this.deadFrontBehavior;
        }

        public final boolean getLighting() {
            return this.lighting;
        }

        public final boolean getOffOnly() {
            return this.offOnly;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.deadFrontBehavior) + (Boolean.hashCode(this.lighting) * 31);
            return Boolean.hashCode(this.offOnly) + (iHashCode * 31);
        }

        public String toString() {
            boolean z = this.lighting;
            int length = String.valueOf(z).length();
            boolean z2 = this.deadFrontBehavior;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.offOnly;
            return zzw.zza(z3, z2, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 37, length2, 10, String.valueOf(z3).length()) + 1), z, "Feature(lighting=", ", deadFrontBehavior=", ", offOnly=");
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 +2\u00020\u0001:\u0001+B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0016\u0010&\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0012R\u0016\u0010(\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\u0012R\u0016\u0010*\u001a\u0004\u0018\u00010\u00188VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u001c¨\u0006,"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$MutableAttributes;", "Lcom/google/home/matter/standard/OnOffTrait$AttributesImpl;", "Lcom/google/home/matter/standard/OnOffTrait$Attributes;", "attributes", "<init>", "(Lcom/google/home/matter/standard/OnOffTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UShort;", "_onTime", "Lkotlin/UShort;", "get_onTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UShort;", "set_onTime-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UShort;)V", "_offWaitTime", "get_offWaitTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_offWaitTime-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "_startUpOnOff", "Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "get_startUpOnOff$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "set_startUpOnOff$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;)V", "_isStartUpOnOffSet", "Z", "get_isStartUpOnOffSet$java_com_google_home_matter_standard_clusters_android", "()Z", "set_isStartUpOnOffSet$java_com_google_home_matter_standard_clusters_android", "(Z)V", "getOnTime-XRpZGF0", "onTime", "getOffWaitTime-XRpZGF0", "offWaitTime", "getStartUpOnOff", "startUpOnOff", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableAttributes extends OnOff {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private boolean _isStartUpOnOffSet;
        private UShort _offWaitTime;
        private UShort _onTime;
        private StartUpOnOffEnum _startUpOnOff;

        /* JADX INFO: renamed from: com.google.home.matter.standard.OnOffTrait$MutableAttributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$MutableAttributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$MutableAttributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                ClusterPayloadWriterKt.wrapPayload(writer, OnOffTrait.INSTANCE.getId());
                if (value.get_onTime() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(16385))) {
                        throw HomeException.INSTANCE.invalidArgument("onTime");
                    }
                    writer.getUshort().mo554writeqim9Vi0(16385, value.get_onTime());
                }
                if (value.get_offWaitTime() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(16386))) {
                        throw HomeException.INSTANCE.invalidArgument("offWaitTime");
                    }
                    writer.getUshort().mo554writeqim9Vi0(16386, value.get_offWaitTime());
                }
                if (value.get_isStartUpOnOffSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(16387))) {
                        throw HomeException.INSTANCE.invalidArgument("startUpOnOff");
                    }
                    writer.m552enum(StartUpOnOffEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(16387, value.get_startUpOnOff());
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutableAttributes(Attributes attributes) {
            super(attributes.getOnOff(), attributes.getGlobalSceneControl(), attributes.getOnTime(), attributes.getOffWaitTime(), attributes.getStartUpOnOff(), attributes.getGeneratedCommandList(), attributes.getAcceptedCommandList(), attributes.getAttributeList(), attributes.getFeatureMap(), attributes.getClusterRevision(), null);
            attributes.getClass();
        }

        @Override // com.google.home.matter.standard.OnOffTrait.OnOff
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MutableAttributes) {
                return super.equals(other);
            }
            return false;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.OnOff, com.google.home.matter.standard.OnOffTrait.Attributes
        /* JADX INFO: renamed from: getOffWaitTime-XRpZGF0 */
        public UShort getOffWaitTime() {
            UShort uShort = this._offWaitTime;
            return uShort == null ? super.getOffWaitTime() : uShort;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.OnOff, com.google.home.matter.standard.OnOffTrait.Attributes
        /* JADX INFO: renamed from: getOnTime-XRpZGF0 */
        public UShort getOnTime() {
            UShort uShort = this._onTime;
            return uShort == null ? super.getOnTime() : uShort;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.OnOff, com.google.home.matter.standard.OnOffTrait.Attributes
        public StartUpOnOffEnum getStartUpOnOff() {
            return this._isStartUpOnOffSet ? this._startUpOnOff : super.getStartUpOnOff();
        }

        /* JADX INFO: renamed from: get_isStartUpOnOffSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isStartUpOnOffSet() {
            return this._isStartUpOnOffSet;
        }

        /* JADX INFO: renamed from: get_offWaitTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_offWaitTime() {
            return this._offWaitTime;
        }

        /* JADX INFO: renamed from: get_onTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_onTime() {
            return this._onTime;
        }

        /* JADX INFO: renamed from: get_startUpOnOff$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final StartUpOnOffEnum get_startUpOnOff() {
            return this._startUpOnOff;
        }

        @Override // com.google.home.matter.standard.OnOffTrait.OnOff
        public String toString() {
            String string = super.toString();
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 25), "OnOff.MutableAttributes(", string, ")");
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OffCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "Request", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OffCommand implements CommandDescriptor {
        public static final OffCommand INSTANCE = new OffCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OffCommand$Request;", "", "<init>", "()V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Request {

            /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            /* JADX INFO: renamed from: com.google.home.matter.standard.OnOffTrait$OffCommand$Request$Adapter, reason: from kotlin metadata */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OffCommand$Request$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$OffCommand$Request;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion implements StructAdapter<Request> {
                private Companion() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.home.matter.serialization.StructAdapter
                public Request read(ClusterPayloadReader reader) {
                    reader.getClass();
                    return new Request();
                }

                @Override // com.google.home.matter.serialization.StructAdapter
                public void write(ClusterPayloadWriter writer, Request value) {
                    writer.getClass();
                    value.getClass();
                    ClusterPayloadWriterKt.wrapPayload(writer, OffCommand.INSTANCE.getRequestId());
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Request);
            }

            public int hashCode() {
                return toString().hashCode() + 31;
            }

            public String toString() {
                return "OffCommand.Request()";
            }
        }

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(OnOffTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private OffCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OffWithEffectCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OffWithEffectCommand implements CommandDescriptor {
        public static final OffWithEffectCommand INSTANCE = new OffWithEffectCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(OnOffTrait.INSTANCE.getId(), 64, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private OffWithEffectCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (OnOffTrait$OffWithEffectCommand$Request$CommandFields onOffTrait$OffWithEffectCommand$Request$CommandFields : OnOffTrait$OffWithEffectCommand$Request$CommandFields.values()) {
                if (onOffTrait$OffWithEffectCommand$Request$CommandFields.getTag() == tagId) {
                    return onOffTrait$OffWithEffectCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (OnOffTrait$OffWithEffectCommand$Request$CommandFields onOffTrait$OffWithEffectCommand$Request$CommandFields : OnOffTrait$OffWithEffectCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(onOffTrait$OffWithEffectCommand$Request$CommandFields.name(), name)) {
                    return onOffTrait$OffWithEffectCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OnCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "Request", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OnCommand implements CommandDescriptor {
        public static final OnCommand INSTANCE = new OnCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OnCommand$Request;", "", "<init>", "()V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Request {

            /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);

            /* JADX INFO: renamed from: com.google.home.matter.standard.OnOffTrait$OnCommand$Request$Adapter, reason: from kotlin metadata */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OnCommand$Request$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$OnCommand$Request;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion implements StructAdapter<Request> {
                private Companion() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.home.matter.serialization.StructAdapter
                public Request read(ClusterPayloadReader reader) {
                    reader.getClass();
                    return new Request();
                }

                @Override // com.google.home.matter.serialization.StructAdapter
                public void write(ClusterPayloadWriter writer, Request value) {
                    writer.getClass();
                    value.getClass();
                    ClusterPayloadWriterKt.wrapPayload(writer, OnCommand.INSTANCE.getRequestId());
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            public boolean equals(Object other) {
                return this == other || (other instanceof Request);
            }

            public int hashCode() {
                return toString().hashCode() + 31;
            }

            public String toString() {
                return "OnCommand.Request()";
            }
        }

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(OnOffTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private OnCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\u00022\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OnOffControlBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "acceptOnlyWhenOn", "<init>", "(Z)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getAcceptOnlyWhenOn", "()Z", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class OnOffControlBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean acceptOnlyWhenOn;

        /* JADX INFO: renamed from: com.google.home.matter.standard.OnOffTrait$OnOffControlBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OnOffControlBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$OnOffControlBitmap;", "<init>", "()V", "ACCEPT_ONLY_WHEN_ON_FLAG", "Lkotlin/ULong;", "J", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<OnOffControlBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(OnOffControlBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getAcceptOnlyWhenOn());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public OnOffControlBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new OnOffControlBitmap(value.m525getVKZWuLQ(1L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public OnOffControlBitmap(boolean z) {
            super(zza$$ExternalSyntheticOutline0.m(6, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "OnOffControlBitmap");
            this.acceptOnlyWhenOn = z;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof OnOffControlBitmap) && this.acceptOnlyWhenOn == ((OnOffControlBitmap) other).acceptOnlyWhenOn;
        }

        public final boolean getAcceptOnlyWhenOn() {
            return this.acceptOnlyWhenOn;
        }

        public int hashCode() {
            return Boolean.hashCode(this.acceptOnlyWhenOn);
        }

        public String toString() {
            return zzc.zza(this.acceptOnlyWhenOn, "OnOffControlBitmap(acceptOnlyWhenOn=", (byte) 37);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OnWithRecallGlobalSceneCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OnWithRecallGlobalSceneCommand implements CommandDescriptor {
        public static final OnWithRecallGlobalSceneCommand INSTANCE = new OnWithRecallGlobalSceneCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(OnOffTrait.INSTANCE.getId(), 65, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private OnWithRecallGlobalSceneCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$OnWithTimedOffCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class OnWithTimedOffCommand implements CommandDescriptor {
        public static final OnWithTimedOffCommand INSTANCE = new OnWithTimedOffCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(OnOffTrait.INSTANCE.getId(), 66, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private OnWithTimedOffCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (OnOffTrait$OnWithTimedOffCommand$Request$CommandFields onOffTrait$OnWithTimedOffCommand$Request$CommandFields : OnOffTrait$OnWithTimedOffCommand$Request$CommandFields.values()) {
                if (onOffTrait$OnWithTimedOffCommand$Request$CommandFields.getTag() == tagId) {
                    return onOffTrait$OnWithTimedOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (OnOffTrait$OnWithTimedOffCommand$Request$CommandFields onOffTrait$OnWithTimedOffCommand$Request$CommandFields : OnOffTrait$OnWithTimedOffCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(onOffTrait$OnWithTimedOffCommand$Request$CommandFields.name(), name)) {
                    return onOffTrait$OnWithTimedOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$ToggleCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ToggleCommand implements CommandDescriptor {
        public static final ToggleCommand INSTANCE = new ToggleCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(OnOffTrait.INSTANCE.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private ToggleCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private OnOffTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$DelayedAllOffEffectVariantEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "DelayedOffFastFade", "NoFade", "DelayedOffSlowFade", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DelayedAllOffEffectVariantEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DelayedAllOffEffectVariantEnum[] $VALUES;
        private static final EnumAdapter<DelayedAllOffEffectVariantEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final DelayedAllOffEffectVariantEnum DelayedOffFastFade;
        public static final DelayedAllOffEffectVariantEnum DelayedOffSlowFade;
        public static final DelayedAllOffEffectVariantEnum NoFade;
        public static final DelayedAllOffEffectVariantEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$DelayedAllOffEffectVariantEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$DelayedAllOffEffectVariantEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<DelayedAllOffEffectVariantEnum> getAdapter() {
                return DelayedAllOffEffectVariantEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ DelayedAllOffEffectVariantEnum[] $values() {
            return new DelayedAllOffEffectVariantEnum[]{DelayedOffFastFade, NoFade, DelayedOffSlowFade, UnknownValue};
        }

        static {
            String str = null;
            DelayedOffFastFade = new DelayedAllOffEffectVariantEnum("DelayedOffFastFade", 0, 0L, null, str, 6, null);
            String str2 = null;
            NoFade = new DelayedAllOffEffectVariantEnum("NoFade", 1, 1L, str, str2, 6, null);
            String str3 = null;
            DelayedOffSlowFade = new DelayedAllOffEffectVariantEnum("DelayedOffSlowFade", 2, 2L, str2, str3, 6, null);
            UnknownValue = new DelayedAllOffEffectVariantEnum("UnknownValue", 3, -1L, str3, null, 6, null);
            DelayedAllOffEffectVariantEnum[] delayedAllOffEffectVariantEnumArr$values = $values();
            $VALUES = delayedAllOffEffectVariantEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(delayedAllOffEffectVariantEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ DelayedAllOffEffectVariantEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(6, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "DelayedAllOffEffectVariantEnum" : str3);
        }

        public static DelayedAllOffEffectVariantEnum valueOf(String str) {
            return (DelayedAllOffEffectVariantEnum) Enum.valueOf(DelayedAllOffEffectVariantEnum.class, str);
        }

        public static DelayedAllOffEffectVariantEnum[] values() {
            return (DelayedAllOffEffectVariantEnum[]) $VALUES.clone();
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

        private DelayedAllOffEffectVariantEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$DyingLightEffectVariantEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "DyingLightFadeOff", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class DyingLightEffectVariantEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DyingLightEffectVariantEnum[] $VALUES;
        private static final EnumAdapter<DyingLightEffectVariantEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final DyingLightEffectVariantEnum DyingLightFadeOff;
        public static final DyingLightEffectVariantEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$DyingLightEffectVariantEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$DyingLightEffectVariantEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<DyingLightEffectVariantEnum> getAdapter() {
                return DyingLightEffectVariantEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ DyingLightEffectVariantEnum[] $values() {
            return new DyingLightEffectVariantEnum[]{DyingLightFadeOff, UnknownValue};
        }

        static {
            String str = null;
            DyingLightFadeOff = new DyingLightEffectVariantEnum("DyingLightFadeOff", 0, 0L, null, str, 6, null);
            UnknownValue = new DyingLightEffectVariantEnum("UnknownValue", 1, -1L, str, null, 6, null);
            DyingLightEffectVariantEnum[] dyingLightEffectVariantEnumArr$values = $values();
            $VALUES = dyingLightEffectVariantEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(dyingLightEffectVariantEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ DyingLightEffectVariantEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(6, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "DyingLightEffectVariantEnum" : str3);
        }

        public static DyingLightEffectVariantEnum valueOf(String str) {
            return (DyingLightEffectVariantEnum) Enum.valueOf(DyingLightEffectVariantEnum.class, str);
        }

        public static DyingLightEffectVariantEnum[] values() {
            return (DyingLightEffectVariantEnum[]) $VALUES.clone();
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

        private DyingLightEffectVariantEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$EffectIdentifierEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "DelayedAllOff", "DyingLight", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EffectIdentifierEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EffectIdentifierEnum[] $VALUES;
        private static final EnumAdapter<EffectIdentifierEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final EffectIdentifierEnum DelayedAllOff;
        public static final EffectIdentifierEnum DyingLight;
        public static final EffectIdentifierEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$EffectIdentifierEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$EffectIdentifierEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<EffectIdentifierEnum> getAdapter() {
                return EffectIdentifierEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ EffectIdentifierEnum[] $values() {
            return new EffectIdentifierEnum[]{DelayedAllOff, DyingLight, UnknownValue};
        }

        static {
            String str = null;
            DelayedAllOff = new EffectIdentifierEnum("DelayedAllOff", 0, 0L, null, str, 6, null);
            String str2 = null;
            DyingLight = new EffectIdentifierEnum("DyingLight", 1, 1L, str, str2, 6, null);
            UnknownValue = new EffectIdentifierEnum("UnknownValue", 2, -1L, str2, null, 6, null);
            EffectIdentifierEnum[] effectIdentifierEnumArr$values = $values();
            $VALUES = effectIdentifierEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(effectIdentifierEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ EffectIdentifierEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(6, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "EffectIdentifierEnum" : str3);
        }

        public static EffectIdentifierEnum valueOf(String str) {
            return (EffectIdentifierEnum) Enum.valueOf(EffectIdentifierEnum.class, str);
        }

        public static EffectIdentifierEnum[] values() {
            return (EffectIdentifierEnum[]) $VALUES.clone();
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

        private EffectIdentifierEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Off", "On", "Toggle", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StartUpOnOffEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StartUpOnOffEnum[] $VALUES;
        private static final EnumAdapter<StartUpOnOffEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final StartUpOnOffEnum Off;
        public static final StartUpOnOffEnum On;
        public static final StartUpOnOffEnum Toggle;
        public static final StartUpOnOffEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/OnOffTrait$StartUpOnOffEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<StartUpOnOffEnum> getAdapter() {
                return StartUpOnOffEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ StartUpOnOffEnum[] $values() {
            return new StartUpOnOffEnum[]{Off, On, Toggle, UnknownValue};
        }

        static {
            String str = null;
            Off = new StartUpOnOffEnum("Off", 0, 0L, null, str, 6, null);
            String str2 = null;
            On = new StartUpOnOffEnum("On", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Toggle = new StartUpOnOffEnum("Toggle", 2, 2L, str2, str3, 6, null);
            UnknownValue = new StartUpOnOffEnum("UnknownValue", 3, -1L, str3, null, 6, null);
            StartUpOnOffEnum[] startUpOnOffEnumArr$values = $values();
            $VALUES = startUpOnOffEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(startUpOnOffEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ StartUpOnOffEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(6, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "StartUpOnOffEnum" : str3);
        }

        public static StartUpOnOffEnum valueOf(String str) {
            return (StartUpOnOffEnum) Enum.valueOf(StartUpOnOffEnum.class, str);
        }

        public static StartUpOnOffEnum[] values() {
            return (StartUpOnOffEnum[]) $VALUES.clone();
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

        private StartUpOnOffEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}
