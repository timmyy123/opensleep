package com.google.home.matter.standard;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Field;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\b\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "EffectIdentifierEnum", "EffectVariantEnum", "IdentifyTypeEnum", "Attributes", "AttributesImpl", "MutableAttributes", "IdentifyCommand", "TriggerEffectCommand", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IdentifyTrait {
    public static final IdentifyTrait INSTANCE = new IdentifyTrait();
    private static final ClusterId Id = new ClusterId(3, "Identify", null, 4, null);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\bf\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0012\u0010\u0013\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$Attributes;", "", "identifyTime", "Lkotlin/UShort;", "getIdentifyTime-XRpZGF0", "()Lkotlin/UShort;", "identifyType", "Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "getIdentifyType", "()Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "generatedCommandList", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "getFeatureMap-pVg5ArA", "()I", "clusterRevision", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.matter.standard.IdentifyTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/IdentifyTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, IdentifyTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(0, "IdentifyTime");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                UShort orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi02 = payload$default.m545enum(IdentifyTypeEnum.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(1, "IdentifyType");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                IdentifyTypeEnum identifyTypeEnum = (IdentifyTypeEnum) optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload$default.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                Unit unit = Unit.INSTANCE;
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
                return new AttributesImpl(orNull, identifyTypeEnum, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, data2, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                if (value instanceof MutableAttributes) {
                    MutableAttributes.INSTANCE.write(writer, (MutableAttributes) value);
                    return;
                }
                ClusterPayloadWriterKt.wrapPayload(writer, IdentifyTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getUshort().mo554writeqim9Vi0(0, value.getIdentifyTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.m552enum(IdentifyTypeEnum.INSTANCE.getAdapter()).mo554writeqim9Vi0(1, value.getIdentifyType());
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

        /* JADX INFO: renamed from: getIdentifyTime-XRpZGF0 */
        UShort getIdentifyTime();

        IdentifyTypeEnum getIdentifyType();
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0016\u0018\u0000 +2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001+Bc\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b$\u0010#R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b%\u0010#R\u001a\u0010\r\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$AttributesImpl;", "Lcom/google/home/matter/standard/IdentifyTrait$Attributes;", "", "Lcom/google/home/matter/standard/IdentifyTrait$MutableAttributes;", "Lkotlin/UShort;", "identifyTime", "Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "identifyType", "", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "clusterRevision", "<init>", "(Lkotlin/UShort;Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;Ljava/util/List;Ljava/util/List;Ljava/util/List;ISLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UShort;", "getIdentifyTime-XRpZGF0", "()Lkotlin/UShort;", "Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "getIdentifyType", "()Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "I", "getFeatureMap-pVg5ArA", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final int featureMap;
        private final List<UInt> generatedCommandList;
        private final UShort identifyTime;
        private final IdentifyTypeEnum identifyType;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private AttributesImpl(UShort uShort, IdentifyTypeEnum identifyTypeEnum, List<UInt> list, List<UInt> list2, List<UInt> list3, int i, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            this.identifyTime = uShort;
            this.identifyType = identifyTypeEnum;
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
            return Intrinsics.areEqual(getIdentifyTime(), attributes.getIdentifyTime()) && getIdentifyType() == attributes.getIdentifyType() && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && getFeatureMap() == attributes.getFeatureMap() && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: from getter */
        public int getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
        /* JADX INFO: renamed from: getIdentifyTime-XRpZGF0, reason: from getter */
        public UShort getIdentifyTime() {
            return this.identifyTime;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.Attributes
        public IdentifyTypeEnum getIdentifyType() {
            return this.identifyType;
        }

        public int hashCode() {
            UShort identifyTime = getIdentifyTime();
            int iM2435hashCodeimpl = identifyTime != null ? UShort.m2435hashCodeimpl(identifyTime.getData()) : 0;
            IdentifyTypeEnum identifyType = getIdentifyType();
            int iHashCode = identifyType != null ? identifyType.hashCode() : 0;
            int iHashCode2 = getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + zzba$$ExternalSyntheticOutline0.m(iM2435hashCodeimpl + 31, 31, iHashCode, 31)) * 31)) * 31);
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((UInt.m2391hashCodeimpl(getFeatureMap()) + (iHashCode2 * 31)) * 31);
        }

        public String toString() {
            UShort identifyTime = getIdentifyTime();
            IdentifyTypeEnum identifyType = getIdentifyType();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            String strM2392toStringimpl = UInt.m2392toStringimpl(getFeatureMap());
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(identifyTime).length();
            int length2 = String.valueOf(identifyType).length();
            int length3 = String.valueOf(generatedCommandList).length();
            int length4 = String.valueOf(acceptedCommandList).length();
            int length5 = String.valueOf(attributeList).length();
            return zzk.zza(strM2436toStringimpl, strM2392toStringimpl, attributeList, acceptedCommandList, generatedCommandList, new StringBuilder(length + 37 + length2 + 23 + length3 + 22 + length4 + 16 + length5 + 13 + String.valueOf(strM2392toStringimpl).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1), identifyType, identifyTime, ", identifyType=", "Identify(identifyTime=");
        }

        public /* synthetic */ AttributesImpl(UShort uShort, IdentifyTypeEnum identifyTypeEnum, List list, List list2, List list3, int i, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(uShort, identifyTypeEnum, list, list2, list3, i, s);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$IdentifyCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class IdentifyCommand implements CommandDescriptor {
        public static final IdentifyCommand INSTANCE = new IdentifyCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(IdentifyTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private IdentifyCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (IdentifyTrait$IdentifyCommand$Request$CommandFields identifyTrait$IdentifyCommand$Request$CommandFields : IdentifyTrait$IdentifyCommand$Request$CommandFields.values()) {
                if (identifyTrait$IdentifyCommand$Request$CommandFields.getTag() == tagId) {
                    return identifyTrait$IdentifyCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (IdentifyTrait$IdentifyCommand$Request$CommandFields identifyTrait$IdentifyCommand$Request$CommandFields : IdentifyTrait$IdentifyCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(identifyTrait$IdentifyCommand$Request$CommandFields.name(), name)) {
                    return identifyTrait$IdentifyCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$MutableAttributes;", "Lcom/google/home/matter/standard/IdentifyTrait$AttributesImpl;", "Lcom/google/home/matter/standard/IdentifyTrait$Attributes;", "attributes", "<init>", "(Lcom/google/home/matter/standard/IdentifyTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UShort;", "_identifyTime", "Lkotlin/UShort;", "get_identifyTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UShort;", "set_identifyTime-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UShort;)V", "getIdentifyTime-XRpZGF0", "identifyTime", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableAttributes extends AttributesImpl {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private UShort _identifyTime;

        /* JADX INFO: renamed from: com.google.home.matter.standard.IdentifyTrait$MutableAttributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$MutableAttributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/IdentifyTrait$MutableAttributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                ClusterPayloadWriterKt.wrapPayload(writer, IdentifyTrait.INSTANCE.getId());
                if (value.get_identifyTime() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                        throw HomeException.INSTANCE.invalidArgument("identifyTime");
                    }
                    writer.getUshort().mo554writeqim9Vi0(0, value.get_identifyTime());
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutableAttributes(Attributes attributes) {
            super(attributes.getIdentifyTime(), attributes.getIdentifyType(), attributes.getGeneratedCommandList(), attributes.getAcceptedCommandList(), attributes.getAttributeList(), attributes.getFeatureMap(), attributes.getClusterRevision(), null);
            attributes.getClass();
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.AttributesImpl
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MutableAttributes) {
                return super.equals(other);
            }
            return false;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.AttributesImpl, com.google.home.matter.standard.IdentifyTrait.Attributes
        /* JADX INFO: renamed from: getIdentifyTime-XRpZGF0 */
        public UShort getIdentifyTime() {
            UShort uShort = this._identifyTime;
            return uShort == null ? super.getIdentifyTime() : uShort;
        }

        /* JADX INFO: renamed from: get_identifyTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_identifyTime() {
            return this._identifyTime;
        }

        @Override // com.google.home.matter.standard.IdentifyTrait.AttributesImpl
        public String toString() {
            String string = super.toString();
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 28), "Identify.MutableAttributes(", string, ")");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$TriggerEffectCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class TriggerEffectCommand implements CommandDescriptor {
        public static final TriggerEffectCommand INSTANCE = new TriggerEffectCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(IdentifyTrait.INSTANCE.getId(), 64, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private TriggerEffectCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (IdentifyTrait$TriggerEffectCommand$Request$CommandFields identifyTrait$TriggerEffectCommand$Request$CommandFields : IdentifyTrait$TriggerEffectCommand$Request$CommandFields.values()) {
                if (identifyTrait$TriggerEffectCommand$Request$CommandFields.getTag() == tagId) {
                    return identifyTrait$TriggerEffectCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (IdentifyTrait$TriggerEffectCommand$Request$CommandFields identifyTrait$TriggerEffectCommand$Request$CommandFields : IdentifyTrait$TriggerEffectCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(identifyTrait$TriggerEffectCommand$Request$CommandFields.name(), name)) {
                    return identifyTrait$TriggerEffectCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private IdentifyTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0017B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$EffectIdentifierEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Blink", "Breathe", "Okay", "ChannelChange", "FinishEffect", "StopEffect", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EffectIdentifierEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EffectIdentifierEnum[] $VALUES;
        private static final EnumAdapter<EffectIdentifierEnum> Adapter;
        public static final EffectIdentifierEnum Blink;
        public static final EffectIdentifierEnum Breathe;
        public static final EffectIdentifierEnum ChannelChange;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final EffectIdentifierEnum FinishEffect;
        public static final EffectIdentifierEnum Okay;
        public static final EffectIdentifierEnum StopEffect;
        public static final EffectIdentifierEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$EffectIdentifierEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/IdentifyTrait$EffectIdentifierEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
            return new EffectIdentifierEnum[]{Blink, Breathe, Okay, ChannelChange, FinishEffect, StopEffect, UnknownValue};
        }

        static {
            String str = null;
            Blink = new EffectIdentifierEnum("Blink", 0, 0L, null, str, 6, null);
            String str2 = null;
            Breathe = new EffectIdentifierEnum("Breathe", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Okay = new EffectIdentifierEnum("Okay", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            ChannelChange = new EffectIdentifierEnum("ChannelChange", 3, 11L, str3, str4, 6, null);
            String str5 = null;
            FinishEffect = new EffectIdentifierEnum("FinishEffect", 4, 254L, str4, str5, 6, null);
            String str6 = null;
            StopEffect = new EffectIdentifierEnum("StopEffect", 5, 255L, str5, str6, 6, null);
            UnknownValue = new EffectIdentifierEnum("UnknownValue", 6, -1L, str6, null, 6, null);
            EffectIdentifierEnum[] effectIdentifierEnumArr$values = $values();
            $VALUES = effectIdentifierEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(effectIdentifierEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ EffectIdentifierEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(3, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "EffectIdentifierEnum" : str3);
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
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0012B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0013"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$EffectVariantEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Default", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class EffectVariantEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ EffectVariantEnum[] $VALUES;
        private static final EnumAdapter<EffectVariantEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final EffectVariantEnum Default;
        public static final EffectVariantEnum UnknownValue;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$EffectVariantEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/IdentifyTrait$EffectVariantEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<EffectVariantEnum> getAdapter() {
                return EffectVariantEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ EffectVariantEnum[] $values() {
            return new EffectVariantEnum[]{Default, UnknownValue};
        }

        static {
            String str = null;
            Default = new EffectVariantEnum("Default", 0, 0L, null, str, 6, null);
            UnknownValue = new EffectVariantEnum("UnknownValue", 1, -1L, str, null, 6, null);
            EffectVariantEnum[] effectVariantEnumArr$values = $values();
            $VALUES = effectVariantEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(effectVariantEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ EffectVariantEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(3, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "EffectVariantEnum" : str3);
        }

        public static EffectVariantEnum valueOf(String str) {
            return (EffectVariantEnum) Enum.valueOf(EffectVariantEnum.class, str);
        }

        public static EffectVariantEnum[] values() {
            return (EffectVariantEnum[]) $VALUES.clone();
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

        private EffectVariantEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0086\u0081\u0002\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0017B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "None", "LightOutput", "VisibleIndicator", "AudibleBeep", "Display", "Actuator", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class IdentifyTypeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ IdentifyTypeEnum[] $VALUES;
        public static final IdentifyTypeEnum Actuator;
        private static final EnumAdapter<IdentifyTypeEnum> Adapter;
        public static final IdentifyTypeEnum AudibleBeep;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final IdentifyTypeEnum Display;
        public static final IdentifyTypeEnum LightOutput;
        public static final IdentifyTypeEnum None;
        public static final IdentifyTypeEnum UnknownValue;
        public static final IdentifyTypeEnum VisibleIndicator;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/IdentifyTrait$IdentifyTypeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<IdentifyTypeEnum> getAdapter() {
                return IdentifyTypeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ IdentifyTypeEnum[] $values() {
            return new IdentifyTypeEnum[]{None, LightOutput, VisibleIndicator, AudibleBeep, Display, Actuator, UnknownValue};
        }

        static {
            String str = null;
            None = new IdentifyTypeEnum("None", 0, 0L, null, str, 6, null);
            String str2 = null;
            LightOutput = new IdentifyTypeEnum("LightOutput", 1, 1L, str, str2, 6, null);
            String str3 = null;
            VisibleIndicator = new IdentifyTypeEnum("VisibleIndicator", 2, 2L, str2, str3, 6, null);
            String str4 = null;
            AudibleBeep = new IdentifyTypeEnum("AudibleBeep", 3, 3L, str3, str4, 6, null);
            String str5 = null;
            Display = new IdentifyTypeEnum("Display", 4, 4L, str4, str5, 6, null);
            String str6 = null;
            Actuator = new IdentifyTypeEnum("Actuator", 5, 5L, str5, str6, 6, null);
            UnknownValue = new IdentifyTypeEnum("UnknownValue", 6, -1L, str6, null, 6, null);
            IdentifyTypeEnum[] identifyTypeEnumArr$values = $values();
            $VALUES = identifyTypeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(identifyTypeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ IdentifyTypeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(3, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "IdentifyTypeEnum" : str3);
        }

        public static IdentifyTypeEnum valueOf(String str) {
            return (IdentifyTypeEnum) Enum.valueOf(IdentifyTypeEnum.class, str);
        }

        public static IdentifyTypeEnum[] values() {
            return (IdentifyTypeEnum[]) $VALUES.clone();
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

        private IdentifyTypeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}
