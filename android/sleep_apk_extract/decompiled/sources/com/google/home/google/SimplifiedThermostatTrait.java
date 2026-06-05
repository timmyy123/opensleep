package com.google.home.google;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Field;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\b\t\n\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/google/home/google/SimplifiedThermostatTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "SystemModeEnum", "Attributes", "AttributesImpl", "SetSystemModeCommand", "home.platform.traits.google.simplified_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SimplifiedThermostatTrait {
    public static final SimplifiedThermostatTrait INSTANCE = new SimplifiedThermostatTrait();
    private static final ClusterId Id = new ClusterId(1611070540, "SimplifiedThermostat", null, 4, null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\nR\u0012\u0010\u000f\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, d2 = {"Lcom/google/home/google/SimplifiedThermostatTrait$Attributes;", "", "systemMode", "Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;", "getSystemMode", "()Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;", "generatedCommandList", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "getFeatureMap-pVg5ArA", "()I", "clusterRevision", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "home.platform.traits.google.simplified_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.google.SimplifiedThermostatTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/google/SimplifiedThermostatTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/SimplifiedThermostatTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "home.platform.traits.google.simplified_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, SimplifiedThermostatTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.m545enum(SystemModeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(4, "SystemMode");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                SystemModeEnum systemModeEnum = (SystemModeEnum) optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload$default.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                List<UInt> listMo547getListqim9Vi02 = payload$default.getUint().mo547getListqim9Vi0(65529, "AcceptedCommandList");
                arrayList.add(UInt.m2388boximpl(65529));
                Unit unit = Unit.INSTANCE;
                arrayList.add(UInt.m2388boximpl(65531));
                UInt uIntMo546getqim9Vi0 = payload$default.getUint().mo546getqim9Vi0(65532, "FeatureMap");
                uIntMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65532));
                int data2 = uIntMo546getqim9Vi0.getData();
                UShort uShortMo546getqim9Vi0 = payload$default.getUshort().mo546getqim9Vi0(65533, "ClusterRevision");
                uShortMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65533));
                return new AttributesImpl(systemModeEnum, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, data2, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) {
                writer.getClass();
                value.getClass();
                ClusterPayloadWriterKt.wrapPayload(writer, SimplifiedThermostatTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.m552enum(SystemModeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(4, value.getSystemMode());
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

        SystemModeEnum getSystemMode();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0016\u0018\u0000 &2\u00020\u0001:\u0001&BW\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b \u0010\u001eR\u001a\u0010\t\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010#\u001a\u0004\b$\u0010%¨\u0006'"}, d2 = {"Lcom/google/home/google/SimplifiedThermostatTrait$AttributesImpl;", "Lcom/google/home/google/SimplifiedThermostatTrait$Attributes;", "Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;", "systemMode", "", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "Lkotlin/UShort;", "clusterRevision", "<init>", "(Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;Ljava/util/List;Ljava/util/List;Ljava/util/List;ISLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;", "getSystemMode", "()Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "I", "getFeatureMap-pVg5ArA", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "home.platform.traits.google.simplified_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final int featureMap;
        private final List<UInt> generatedCommandList;
        private final SystemModeEnum systemMode;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private AttributesImpl(SystemModeEnum systemModeEnum, List<UInt> list, List<UInt> list2, List<UInt> list3, int i, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            this.systemMode = systemModeEnum;
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
            return getSystemMode() == attributes.getSystemMode() && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && getFeatureMap() == attributes.getFeatureMap() && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.google.SimplifiedThermostatTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.google.SimplifiedThermostatTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.google.SimplifiedThermostatTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.google.SimplifiedThermostatTrait.Attributes
        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: from getter */
        public int getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.google.SimplifiedThermostatTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.google.SimplifiedThermostatTrait.Attributes
        public SystemModeEnum getSystemMode() {
            return this.systemMode;
        }

        public int hashCode() {
            SystemModeEnum systemMode = getSystemMode();
            int iHashCode = getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + (((systemMode != null ? systemMode.hashCode() : 0) + 31) * 31)) * 31)) * 31);
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((UInt.m2391hashCodeimpl(getFeatureMap()) + (iHashCode * 31)) * 31);
        }

        public String toString() {
            SystemModeEnum systemMode = getSystemMode();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            String strM2392toStringimpl = UInt.m2392toStringimpl(getFeatureMap());
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(systemMode).length();
            int length2 = String.valueOf(generatedCommandList).length();
            int length3 = String.valueOf(acceptedCommandList).length();
            int length4 = String.valueOf(attributeList).length();
            return zzk.zza(strM2436toStringimpl, strM2392toStringimpl, attributeList, acceptedCommandList, generatedCommandList, new StringBuilder(length + 55 + length2 + 22 + length3 + 16 + length4 + 13 + String.valueOf(strM2392toStringimpl).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1), systemMode, "SimplifiedThermostat(systemMode=");
        }

        public /* synthetic */ AttributesImpl(SystemModeEnum systemModeEnum, List list, List list2, List list3, int i, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(systemModeEnum, list, list2, list3, i, s);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/SimplifiedThermostatTrait$SetSystemModeCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.simplified_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SetSystemModeCommand implements CommandDescriptor {
        public static final SetSystemModeCommand INSTANCE = new SetSystemModeCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(SimplifiedThermostatTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SetSystemModeCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (SimplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields simplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields : SimplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields.values()) {
                if (simplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields.getTag() == tagId) {
                    return simplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (SimplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields simplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields : SimplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(simplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields.name(), name)) {
                    return simplifiedThermostatTrait$SetSystemModeCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private SimplifiedThermostatTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u0000 \u001d2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u001dB%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001e"}, d2 = {"Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Unspecified", "Off", "Auto", "Cool", "Heat", "EmergencyHeat", "Precooling", "FanOnly", "Dry", "Sleep", "Eco", "Purifier", "UnknownValue", "Companion", "home.platform.traits.google.simplified_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SystemModeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SystemModeEnum[] $VALUES;
        private static final EnumAdapter<SystemModeEnum> Adapter;
        public static final SystemModeEnum Auto;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final SystemModeEnum Cool;
        public static final SystemModeEnum Dry;
        public static final SystemModeEnum Eco;
        public static final SystemModeEnum EmergencyHeat;
        public static final SystemModeEnum FanOnly;
        public static final SystemModeEnum Heat;
        public static final SystemModeEnum Off;
        public static final SystemModeEnum Precooling;
        public static final SystemModeEnum Purifier;
        public static final SystemModeEnum Sleep;
        public static final SystemModeEnum UnknownValue;
        public static final SystemModeEnum Unspecified;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/SimplifiedThermostatTrait$SystemModeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.simplified_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<SystemModeEnum> getAdapter() {
                return SystemModeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ SystemModeEnum[] $values() {
            return new SystemModeEnum[]{Unspecified, Off, Auto, Cool, Heat, EmergencyHeat, Precooling, FanOnly, Dry, Sleep, Eco, Purifier, UnknownValue};
        }

        static {
            String str = null;
            Unspecified = new SystemModeEnum("Unspecified", 0, 0L, null, str, 6, null);
            String str2 = null;
            Off = new SystemModeEnum("Off", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Auto = new SystemModeEnum("Auto", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            Cool = new SystemModeEnum("Cool", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            Heat = new SystemModeEnum("Heat", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            EmergencyHeat = new SystemModeEnum("EmergencyHeat", 5, 5L, str5, str6, 6, null);
            String str7 = null;
            Precooling = new SystemModeEnum("Precooling", 6, 6L, str6, str7, 6, null);
            String str8 = null;
            FanOnly = new SystemModeEnum("FanOnly", 7, 7L, str7, str8, 6, null);
            String str9 = null;
            Dry = new SystemModeEnum("Dry", 8, 8L, str8, str9, 6, null);
            Sleep = new SystemModeEnum("Sleep", 9, 9L, str9, null, 6, null);
            String str10 = null;
            Eco = new SystemModeEnum("Eco", 10, 10L, null, str10, 6, null);
            String str11 = null;
            Purifier = new SystemModeEnum("Purifier", 11, 11L, str10, str11, 6, null);
            UnknownValue = new SystemModeEnum("UnknownValue", 12, -1L, str11, null, 6, null);
            SystemModeEnum[] systemModeEnumArr$values = $values();
            $VALUES = systemModeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(systemModeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ SystemModeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070540, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "SystemModeEnum" : str3);
        }

        public static SystemModeEnum valueOf(String str) {
            return (SystemModeEnum) Enum.valueOf(SystemModeEnum.class, str);
        }

        public static SystemModeEnum[] values() {
            return (SystemModeEnum[]) $VALUES.clone();
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

        private SystemModeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}
