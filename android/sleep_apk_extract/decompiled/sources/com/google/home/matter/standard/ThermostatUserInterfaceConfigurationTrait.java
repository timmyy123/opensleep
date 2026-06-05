package com.google.home.matter.standard;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.HomeException;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.google.home.matter.serialization.ClusterEnum;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadReaderKt;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.ClusterPayloadWriterKt;
import com.google.home.matter.serialization.EnumAdapter;
import com.google.home.matter.serialization.OptionalValue;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0006\b\t\n\u000b\f\rB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "KeypadLockoutEnum", "ScheduleProgrammingVisibilityEnum", "TemperatureDisplayModeEnum", "Attributes", "AttributesImpl", "MutableAttributes", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThermostatUserInterfaceConfigurationTrait {
    public static final ThermostatUserInterfaceConfigurationTrait INSTANCE = new ThermostatUserInterfaceConfigurationTrait();
    private static final ClusterId Id = new ClusterId(516, "ThermostatUserInterfaceConfiguration", null, 4, null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\u0012\u0010\u0017\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001fÀ\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$Attributes;", "", "temperatureDisplayMode", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "getTemperatureDisplayMode", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "keypadLockout", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "getKeypadLockout", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "scheduleProgrammingVisibility", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "getScheduleProgrammingVisibility", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "generatedCommandList", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "getFeatureMap-pVg5ArA", "()I", "clusterRevision", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, ThermostatUserInterfaceConfigurationTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.m545enum(TemperatureDisplayModeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(0, "TemperatureDisplayMode");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                TemperatureDisplayModeEnum temperatureDisplayModeEnum = (TemperatureDisplayModeEnum) optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi02 = payload$default.m545enum(KeypadLockoutEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(1, "KeypadLockout");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                KeypadLockoutEnum keypadLockoutEnum = (KeypadLockoutEnum) optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi03 = payload$default.m545enum(ScheduleProgrammingVisibilityEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(2, "ScheduleProgrammingVisibility");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                Unit unit = Unit.INSTANCE;
                ScheduleProgrammingVisibilityEnum scheduleProgrammingVisibilityEnum = (ScheduleProgrammingVisibilityEnum) optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload$default.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                List<UInt> listMo547getListqim9Vi02 = payload$default.getUint().mo547getListqim9Vi0(65529, "AcceptedCommandList");
                arrayList.add(UInt.m2388boximpl(65529));
                arrayList.add(UInt.m2388boximpl(65531));
                UInt uIntMo546getqim9Vi0 = payload$default.getUint().mo546getqim9Vi0(65532, "FeatureMap");
                uIntMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65532));
                int data2 = uIntMo546getqim9Vi0.getData();
                UShort uShortMo546getqim9Vi0 = payload$default.getUshort().mo546getqim9Vi0(65533, "ClusterRevision");
                uShortMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65533));
                return new ThermostatUserInterfaceConfiguration(temperatureDisplayModeEnum, keypadLockoutEnum, scheduleProgrammingVisibilityEnum, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, data2, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                if (value instanceof MutableAttributes) {
                    MutableAttributes.INSTANCE.write(writer, (MutableAttributes) value);
                    return;
                }
                ClusterPayloadWriterKt.wrapPayload(writer, ThermostatUserInterfaceConfigurationTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.m552enum(TemperatureDisplayModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(0, value.getTemperatureDisplayMode());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.m552enum(KeypadLockoutEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(1, value.getKeypadLockout());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.m552enum(ScheduleProgrammingVisibilityEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(2, value.getScheduleProgrammingVisibility());
                }
                writer.getUint().mo555writeListqim9Vi0(65528, value.getGeneratedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65529, value.getAcceptedCommandList());
                writer.getUint().mo555writeListqim9Vi0(65531, value.getAttributeList());
                writer.getUint().mo554writeqim9Vi0(65532, UInt.m2388boximpl(value.getFeatureMap()));
                writer.getUshort().mo554writeqim9Vi0(65533, UShort.m2432boximpl(value.getClusterRevision()));
            }
        }

        List<UInt> getAcceptedCommandList();

        List<UInt> getAttributeList();

        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg */
        short getClusterRevision();

        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA */
        int getFeatureMap();

        List<UInt> getGeneratedCommandList();

        KeypadLockoutEnum getKeypadLockout();

        ScheduleProgrammingVisibilityEnum getScheduleProgrammingVisibility();

        TemperatureDisplayModeEnum getTemperatureDisplayMode();
    }

    /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait$AttributesImpl, reason: from toString */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0016\u0018\u0000 12\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u00011Bo\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010'\u001a\u0004\b(\u0010)R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010'\u001a\u0004\b*\u0010)R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010'\u001a\u0004\b+\u0010)R\u001a\u0010\u000f\u001a\u00020\u000b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b-\u0010\u001aR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b/\u00100¨\u00062"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$AttributesImpl;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$Attributes;", "", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$MutableAttributes;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "temperatureDisplayMode", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "keypadLockout", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "scheduleProgrammingVisibility", "", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "Lkotlin/UShort;", "clusterRevision", "<init>", "(Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;Ljava/util/List;Ljava/util/List;Ljava/util/List;ISLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "getTemperatureDisplayMode", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "getKeypadLockout", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "getScheduleProgrammingVisibility", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "I", "getFeatureMap-pVg5ArA", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class ThermostatUserInterfaceConfiguration implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final int featureMap;
        private final List<UInt> generatedCommandList;
        private final KeypadLockoutEnum keypadLockout;
        private final ScheduleProgrammingVisibilityEnum scheduleProgrammingVisibility;
        private final TemperatureDisplayModeEnum temperatureDisplayMode;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private ThermostatUserInterfaceConfiguration(TemperatureDisplayModeEnum temperatureDisplayModeEnum, KeypadLockoutEnum keypadLockoutEnum, ScheduleProgrammingVisibilityEnum scheduleProgrammingVisibilityEnum, List<UInt> list, List<UInt> list2, List<UInt> list3, int i, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            this.temperatureDisplayMode = temperatureDisplayModeEnum;
            this.keypadLockout = keypadLockoutEnum;
            this.scheduleProgrammingVisibility = scheduleProgrammingVisibilityEnum;
            this.generatedCommandList = list;
            this.acceptedCommandList = list2;
            this.attributeList = list3;
            this.featureMap = i;
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
            return getTemperatureDisplayMode() == attributes.getTemperatureDisplayMode() && getKeypadLockout() == attributes.getKeypadLockout() && getScheduleProgrammingVisibility() == attributes.getScheduleProgrammingVisibility() && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && getFeatureMap() == attributes.getFeatureMap() && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: from getter */
        public int getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public KeypadLockoutEnum getKeypadLockout() {
            return this.keypadLockout;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public ScheduleProgrammingVisibilityEnum getScheduleProgrammingVisibility() {
            return this.scheduleProgrammingVisibility;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public TemperatureDisplayModeEnum getTemperatureDisplayMode() {
            return this.temperatureDisplayMode;
        }

        public int hashCode() {
            TemperatureDisplayModeEnum temperatureDisplayMode = getTemperatureDisplayMode();
            int iHashCode = temperatureDisplayMode != null ? temperatureDisplayMode.hashCode() : 0;
            KeypadLockoutEnum keypadLockout = getKeypadLockout();
            int iHashCode2 = keypadLockout != null ? keypadLockout.hashCode() : 0;
            int i = iHashCode + 31;
            ScheduleProgrammingVisibilityEnum scheduleProgrammingVisibility = getScheduleProgrammingVisibility();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((UInt.m2391hashCodeimpl(getFeatureMap()) + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + (((((i * 31) + iHashCode2) * 31) + (scheduleProgrammingVisibility != null ? scheduleProgrammingVisibility.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            TemperatureDisplayModeEnum temperatureDisplayMode = getTemperatureDisplayMode();
            KeypadLockoutEnum keypadLockout = getKeypadLockout();
            ScheduleProgrammingVisibilityEnum scheduleProgrammingVisibility = getScheduleProgrammingVisibility();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            String strM2392toStringimpl = UInt.m2392toStringimpl(getFeatureMap());
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(temperatureDisplayMode).length();
            int length2 = String.valueOf(keypadLockout).length();
            int length3 = String.valueOf(scheduleProgrammingVisibility).length();
            int length4 = String.valueOf(generatedCommandList).length();
            int length5 = String.valueOf(acceptedCommandList).length();
            int length6 = String.valueOf(attributeList).length();
            StringBuilder sb = new StringBuilder(length + 76 + length2 + 32 + length3 + 23 + length4 + 22 + length5 + 16 + length6 + 13 + String.valueOf(strM2392toStringimpl).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1);
            sb.append("ThermostatUserInterfaceConfiguration(temperatureDisplayMode=");
            sb.append(temperatureDisplayMode);
            sb.append(", keypadLockout=");
            sb.append(keypadLockout);
            sb.append(", scheduleProgrammingVisibility=");
            sb.append(scheduleProgrammingVisibility);
            sb.append(", generatedCommandList=");
            sb.append(generatedCommandList);
            sb.append(", acceptedCommandList=");
            sb.append(acceptedCommandList);
            sb.append(", attributeList=");
            sb.append(attributeList);
            FileInsert$$ExternalSyntheticOutline0.m(sb, ", featureMap=", strM2392toStringimpl, ", clusterRevision=", strM2436toStringimpl);
            sb.append(")");
            return sb.toString();
        }

        public /* synthetic */ ThermostatUserInterfaceConfiguration(TemperatureDisplayModeEnum temperatureDisplayModeEnum, KeypadLockoutEnum keypadLockoutEnum, ScheduleProgrammingVisibilityEnum scheduleProgrammingVisibilityEnum, List list, List list2, List list3, int i, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(temperatureDisplayModeEnum, keypadLockoutEnum, scheduleProgrammingVisibilityEnum, list, list2, list3, i, s);
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0016\u0010$\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0012R\u0016\u0010&\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\u0019R\u0016\u0010(\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010 ¨\u0006*"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$MutableAttributes;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$AttributesImpl;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$Attributes;", "attributes", "<init>", "(Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "_temperatureDisplayMode", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "get_temperatureDisplayMode$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "set_temperatureDisplayMode$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;)V", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "_keypadLockout", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "get_keypadLockout$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "set_keypadLockout$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;)V", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "_scheduleProgrammingVisibility", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "get_scheduleProgrammingVisibility$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "set_scheduleProgrammingVisibility$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;)V", "getTemperatureDisplayMode", "temperatureDisplayMode", "getKeypadLockout", "keypadLockout", "getScheduleProgrammingVisibility", "scheduleProgrammingVisibility", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableAttributes extends ThermostatUserInterfaceConfiguration {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private KeypadLockoutEnum _keypadLockout;
        private ScheduleProgrammingVisibilityEnum _scheduleProgrammingVisibility;
        private TemperatureDisplayModeEnum _temperatureDisplayMode;

        /* JADX INFO: renamed from: com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait$MutableAttributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$MutableAttributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$MutableAttributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                ClusterPayloadWriterKt.wrapPayload(writer, ThermostatUserInterfaceConfigurationTrait.INSTANCE.getId());
                if (value.get_temperatureDisplayMode() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                        throw HomeException.INSTANCE.invalidArgument("temperatureDisplayMode");
                    }
                    writer.m552enum(TemperatureDisplayModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(0, value.get_temperatureDisplayMode());
                }
                if (value.get_keypadLockout() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                        throw HomeException.INSTANCE.invalidArgument("keypadLockout");
                    }
                    writer.m552enum(KeypadLockoutEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(1, value.get_keypadLockout());
                }
                if (value.get_scheduleProgrammingVisibility() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                        throw HomeException.INSTANCE.invalidArgument("scheduleProgrammingVisibility");
                    }
                    writer.m552enum(ScheduleProgrammingVisibilityEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(2, value.get_scheduleProgrammingVisibility());
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutableAttributes(Attributes attributes) {
            super(attributes.getTemperatureDisplayMode(), attributes.getKeypadLockout(), attributes.getScheduleProgrammingVisibility(), attributes.getGeneratedCommandList(), attributes.getAcceptedCommandList(), attributes.getAttributeList(), attributes.getFeatureMap(), attributes.getClusterRevision(), null);
            attributes.getClass();
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.ThermostatUserInterfaceConfiguration
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MutableAttributes) {
                return super.equals(other);
            }
            return false;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.ThermostatUserInterfaceConfiguration, com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public KeypadLockoutEnum getKeypadLockout() {
            KeypadLockoutEnum keypadLockoutEnum = this._keypadLockout;
            return keypadLockoutEnum == null ? super.getKeypadLockout() : keypadLockoutEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.ThermostatUserInterfaceConfiguration, com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public ScheduleProgrammingVisibilityEnum getScheduleProgrammingVisibility() {
            ScheduleProgrammingVisibilityEnum scheduleProgrammingVisibilityEnum = this._scheduleProgrammingVisibility;
            return scheduleProgrammingVisibilityEnum == null ? super.getScheduleProgrammingVisibility() : scheduleProgrammingVisibilityEnum;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.ThermostatUserInterfaceConfiguration, com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.Attributes
        public TemperatureDisplayModeEnum getTemperatureDisplayMode() {
            TemperatureDisplayModeEnum temperatureDisplayModeEnum = this._temperatureDisplayMode;
            return temperatureDisplayModeEnum == null ? super.getTemperatureDisplayMode() : temperatureDisplayModeEnum;
        }

        /* JADX INFO: renamed from: get_keypadLockout$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final KeypadLockoutEnum get_keypadLockout() {
            return this._keypadLockout;
        }

        /* JADX INFO: renamed from: get_scheduleProgrammingVisibility$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final ScheduleProgrammingVisibilityEnum get_scheduleProgrammingVisibility() {
            return this._scheduleProgrammingVisibility;
        }

        /* JADX INFO: renamed from: get_temperatureDisplayMode$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final TemperatureDisplayModeEnum get_temperatureDisplayMode() {
            return this._temperatureDisplayMode;
        }

        @Override // com.google.home.matter.standard.ThermostatUserInterfaceConfigurationTrait.ThermostatUserInterfaceConfiguration
        public String toString() {
            String string = super.toString();
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 56), "ThermostatUserInterfaceConfiguration.MutableAttributes(", string, ")");
        }
    }

    private ThermostatUserInterfaceConfigurationTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0017B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "NoLockout", "Lockout1", "Lockout2", "Lockout3", "Lockout4", "Lockout5", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class KeypadLockoutEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ KeypadLockoutEnum[] $VALUES;
        private static final EnumAdapter<KeypadLockoutEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final KeypadLockoutEnum Lockout1;
        public static final KeypadLockoutEnum Lockout2;
        public static final KeypadLockoutEnum Lockout3;
        public static final KeypadLockoutEnum Lockout4;
        public static final KeypadLockoutEnum Lockout5;
        public static final KeypadLockoutEnum NoLockout;
        public static final KeypadLockoutEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$KeypadLockoutEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<KeypadLockoutEnum> getAdapter() {
                return KeypadLockoutEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ KeypadLockoutEnum[] $values() {
            return new KeypadLockoutEnum[]{NoLockout, Lockout1, Lockout2, Lockout3, Lockout4, Lockout5, UnknownValue};
        }

        static {
            String str = null;
            NoLockout = new KeypadLockoutEnum("NoLockout", 0, 0L, null, str, 6, null);
            String str2 = null;
            Lockout1 = new KeypadLockoutEnum("Lockout1", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Lockout2 = new KeypadLockoutEnum("Lockout2", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Lockout3 = new KeypadLockoutEnum("Lockout3", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            Lockout4 = new KeypadLockoutEnum("Lockout4", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            Lockout5 = new KeypadLockoutEnum("Lockout5", 5, 5L, str5, str6, 6, null);
            UnknownValue = new KeypadLockoutEnum("UnknownValue", 6, -1L, str6, null, 6, null);
            KeypadLockoutEnum[] keypadLockoutEnumArr$values = $values();
            $VALUES = keypadLockoutEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(keypadLockoutEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ KeypadLockoutEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(516, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "KeypadLockoutEnum" : str3);
        }

        public static KeypadLockoutEnum valueOf(String str) {
            return (KeypadLockoutEnum) Enum.valueOf(KeypadLockoutEnum.class, str);
        }

        public static KeypadLockoutEnum[] values() {
            return (KeypadLockoutEnum[]) $VALUES.clone();
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

        private KeypadLockoutEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "ScheduleProgrammingPermitted", "ScheduleProgrammingDenied", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ScheduleProgrammingVisibilityEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ScheduleProgrammingVisibilityEnum[] $VALUES;
        private static final EnumAdapter<ScheduleProgrammingVisibilityEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ScheduleProgrammingVisibilityEnum ScheduleProgrammingDenied;
        public static final ScheduleProgrammingVisibilityEnum ScheduleProgrammingPermitted;
        public static final ScheduleProgrammingVisibilityEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$ScheduleProgrammingVisibilityEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ScheduleProgrammingVisibilityEnum> getAdapter() {
                return ScheduleProgrammingVisibilityEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ScheduleProgrammingVisibilityEnum[] $values() {
            return new ScheduleProgrammingVisibilityEnum[]{ScheduleProgrammingPermitted, ScheduleProgrammingDenied, UnknownValue};
        }

        static {
            String str = null;
            ScheduleProgrammingPermitted = new ScheduleProgrammingVisibilityEnum("ScheduleProgrammingPermitted", 0, 0L, null, str, 6, null);
            String str2 = null;
            ScheduleProgrammingDenied = new ScheduleProgrammingVisibilityEnum("ScheduleProgrammingDenied", 1, 1L, str, str2, 6, null);
            UnknownValue = new ScheduleProgrammingVisibilityEnum("UnknownValue", 2, -1L, str2, null, 6, null);
            ScheduleProgrammingVisibilityEnum[] scheduleProgrammingVisibilityEnumArr$values = $values();
            $VALUES = scheduleProgrammingVisibilityEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(scheduleProgrammingVisibilityEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ScheduleProgrammingVisibilityEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(516, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ScheduleProgrammingVisibilityEnum" : str3);
        }

        public static ScheduleProgrammingVisibilityEnum valueOf(String str) {
            return (ScheduleProgrammingVisibilityEnum) Enum.valueOf(ScheduleProgrammingVisibilityEnum.class, str);
        }

        public static ScheduleProgrammingVisibilityEnum[] values() {
            return (ScheduleProgrammingVisibilityEnum[]) $VALUES.clone();
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

        private ScheduleProgrammingVisibilityEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Celsius", "Fahrenheit", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TemperatureDisplayModeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ TemperatureDisplayModeEnum[] $VALUES;
        private static final EnumAdapter<TemperatureDisplayModeEnum> Adapter;
        public static final TemperatureDisplayModeEnum Celsius;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final TemperatureDisplayModeEnum Fahrenheit;
        public static final TemperatureDisplayModeEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfigurationTrait$TemperatureDisplayModeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<TemperatureDisplayModeEnum> getAdapter() {
                return TemperatureDisplayModeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ TemperatureDisplayModeEnum[] $values() {
            return new TemperatureDisplayModeEnum[]{Celsius, Fahrenheit, UnknownValue};
        }

        static {
            String str = null;
            Celsius = new TemperatureDisplayModeEnum("Celsius", 0, 0L, null, str, 6, null);
            String str2 = null;
            Fahrenheit = new TemperatureDisplayModeEnum("Fahrenheit", 1, 1L, str, str2, 6, null);
            UnknownValue = new TemperatureDisplayModeEnum("UnknownValue", 2, -1L, str2, null, 6, null);
            TemperatureDisplayModeEnum[] temperatureDisplayModeEnumArr$values = $values();
            $VALUES = temperatureDisplayModeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(temperatureDisplayModeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ TemperatureDisplayModeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(516, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "TemperatureDisplayModeEnum" : str3);
        }

        public static TemperatureDisplayModeEnum valueOf(String str) {
            return (TemperatureDisplayModeEnum) Enum.valueOf(TemperatureDisplayModeEnum.class, str);
        }

        public static TemperatureDisplayModeEnum[] values() {
            return (TemperatureDisplayModeEnum[]) $VALUES.clone();
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

        private TemperatureDisplayModeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}
