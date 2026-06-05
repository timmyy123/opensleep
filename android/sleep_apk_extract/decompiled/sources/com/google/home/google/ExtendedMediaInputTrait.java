package com.google.home.google;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.StructDescriptor;
import com.google.home.Type;
import com.google.home.google.ExtendedMediaInputTrait;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadReaderKt;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.ClusterPayloadWriterKt;
import com.google.home.matter.serialization.OptionalValue;
import com.google.home.matter.serialization.ScopedCommandId;
import com.google.home.matter.serialization.StructAdapter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007\b\t\n\u000b\f\r\u000eB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "InputNames", "AvailableInput", "Attributes", "AttributesImpl", "SelectCustomInputCommand", "PreviousInputCommand", "NextInputCommand", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedMediaInputTrait {
    public static final ExtendedMediaInputTrait INSTANCE = new ExtendedMediaInputTrait();
    private static final ClusterId Id = new ClusterId(1611070516, "ExtendedMediaInput", null, 4, null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dR\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\nR\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\nR\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\nR\u0012\u0010\u0016\u001a\u00020\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u001eÀ\u0006\u0001"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$Attributes;", "", "customInputsOrdered", "", "getCustomInputsOrdered", "()Ljava/lang/Boolean;", "customInputsList", "", "Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput;", "getCustomInputsList", "()Ljava/util/List;", "currentCustomInput", "", "getCurrentCustomInput", "()Ljava/lang/String;", "generatedCommandList", "Lkotlin/UInt;", "getGeneratedCommandList", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "getFeatureMap-pVg5ArA", "()I", "clusterRevision", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedMediaInputTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedMediaInputTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, ExtendedMediaInputTrait.INSTANCE.getId());
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(1), AvailableInput.INSTANCE)));
                ArrayList arrayList = new ArrayList();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi0 = payload.getBoolean().mo549getOptionalNullableqim9Vi0(0, "CustomInputsOrdered");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                Boolean orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<List<T>> optionalValueMo550getOptionalNullableListqim9Vi0 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<AvailableInput>() { // from class: com.google.home.google.ExtendedMediaInputTrait$Attributes$Adapter$read$2
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    public final ExtendedMediaInputTrait.AvailableInput invoke() {
                        return new ExtendedMediaInputTrait.AvailableInput(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                    }
                }, Reflection.getOrCreateKotlinClass(AvailableInput.class)).mo550getOptionalNullableListqim9Vi0(1, "CustomInputsList");
                if (optionalValueMo550getOptionalNullableListqim9Vi0.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                List list = (List) optionalValueMo550getOptionalNullableListqim9Vi0.getOrNull();
                OptionalValue<String> optionalValueMo549getOptionalNullableqim9Vi02 = payload.getString().mo549getOptionalNullableqim9Vi0(3, "CurrentCustomInput");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                Unit unit = Unit.INSTANCE;
                String orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                List<UInt> listMo547getListqim9Vi0 = payload.getUint().mo547getListqim9Vi0(65528, "GeneratedCommandList");
                arrayList.add(UInt.m2388boximpl(65528));
                List<UInt> listMo547getListqim9Vi02 = payload.getUint().mo547getListqim9Vi0(65529, "AcceptedCommandList");
                arrayList.add(UInt.m2388boximpl(65529));
                arrayList.add(UInt.m2388boximpl(65531));
                UInt uIntMo546getqim9Vi0 = payload.getUint().mo546getqim9Vi0(65532, "FeatureMap");
                uIntMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65532));
                int data2 = uIntMo546getqim9Vi0.getData();
                UShort uShortMo546getqim9Vi0 = payload.getUshort().mo546getqim9Vi0(65533, "ClusterRevision");
                uShortMo546getqim9Vi0.getData();
                arrayList.add(UInt.m2388boximpl(65533));
                return new ExtendedMediaInput(orNull, list, orNull2, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, data2, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) {
                writer.getClass();
                value.getClass();
                ClusterPayloadWriterKt.wrapPayload(writer, ExtendedMediaInputTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getBoolean().mo554writeqim9Vi0(0, value.getCustomInputsOrdered());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.struct(AvailableInput.INSTANCE).mo555writeListqim9Vi0(1, value.getCustomInputsList());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.getString().mo554writeqim9Vi0(3, value.getCurrentCustomInput());
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

        String getCurrentCustomInput();

        List<AvailableInput> getCustomInputsList();

        Boolean getCustomInputsOrdered();

        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA */
        int getFeatureMap();

        List<UInt> getGeneratedCommandList();
    }

    /* JADX INFO: renamed from: com.google.home.google.ExtendedMediaInputTrait$AttributesImpl, reason: from toString */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\b\u0016\u0018\u0000 +2\u00020\u0001:\u0001+Bu\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b\"\u0010\u001aR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u001e\u001a\u0004\b#\u0010 R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b$\u0010 R \u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b%\u0010 R\u001a\u0010\r\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010&\u001a\u0004\b'\u0010\u0018R\u001a\u0010\u000f\u001a\u00020\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$AttributesImpl;", "Lcom/google/home/google/ExtendedMediaInputTrait$Attributes;", "", "customInputsOrdered", "", "Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput;", "customInputsList", "", "currentCustomInput", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "Lkotlin/UShort;", "clusterRevision", "<init>", "(Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;ISLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/lang/Boolean;", "getCustomInputsOrdered", "()Ljava/lang/Boolean;", "Ljava/util/List;", "getCustomInputsList", "()Ljava/util/List;", "Ljava/lang/String;", "getCurrentCustomInput", "getGeneratedCommandList", "getAcceptedCommandList", "getAttributeList", "I", "getFeatureMap-pVg5ArA", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class ExtendedMediaInput implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final String currentCustomInput;
        private final List<AvailableInput> customInputsList;
        private final Boolean customInputsOrdered;
        private final int featureMap;
        private final List<UInt> generatedCommandList;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private ExtendedMediaInput(Boolean bool, List<AvailableInput> list, String str, List<UInt> list2, List<UInt> list3, List<UInt> list4, int i, short s) {
            list2.getClass();
            list3.getClass();
            list4.getClass();
            this.customInputsOrdered = bool;
            this.customInputsList = list;
            this.currentCustomInput = str;
            this.generatedCommandList = list2;
            this.acceptedCommandList = list3;
            this.attributeList = list4;
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
            return Intrinsics.areEqual(getCustomInputsOrdered(), attributes.getCustomInputsOrdered()) && Intrinsics.areEqual(getCustomInputsList(), attributes.getCustomInputsList()) && Intrinsics.areEqual(getCurrentCustomInput(), attributes.getCurrentCustomInput()) && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && getFeatureMap() == attributes.getFeatureMap() && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        public String getCurrentCustomInput() {
            return this.currentCustomInput;
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        public List<AvailableInput> getCustomInputsList() {
            return this.customInputsList;
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        public Boolean getCustomInputsOrdered() {
            return this.customInputsOrdered;
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: from getter */
        public int getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.google.ExtendedMediaInputTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        public int hashCode() {
            Boolean customInputsOrdered = getCustomInputsOrdered();
            int iHashCode = customInputsOrdered != null ? customInputsOrdered.hashCode() : 0;
            List<AvailableInput> customInputsList = getCustomInputsList();
            int iHashCode2 = customInputsList != null ? customInputsList.hashCode() : 0;
            int i = iHashCode + 31;
            String currentCustomInput = getCurrentCustomInput();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((UInt.m2391hashCodeimpl(getFeatureMap()) + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + (((((i * 31) + iHashCode2) * 31) + (currentCustomInput != null ? currentCustomInput.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            Boolean customInputsOrdered = getCustomInputsOrdered();
            List<AvailableInput> customInputsList = getCustomInputsList();
            String currentCustomInput = getCurrentCustomInput();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            String strM2392toStringimpl = UInt.m2392toStringimpl(getFeatureMap());
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(customInputsOrdered).length();
            int length2 = String.valueOf(customInputsList).length();
            int length3 = String.valueOf(currentCustomInput).length();
            int length4 = String.valueOf(generatedCommandList).length();
            int length5 = String.valueOf(acceptedCommandList).length();
            int length6 = String.valueOf(attributeList).length();
            StringBuilder sb = new StringBuilder(length + 58 + length2 + 21 + length3 + 23 + length4 + 22 + length5 + 16 + length6 + 13 + String.valueOf(strM2392toStringimpl).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1);
            sb.append("ExtendedMediaInput(customInputsOrdered=");
            sb.append(customInputsOrdered);
            sb.append(", customInputsList=");
            sb.append(customInputsList);
            sb.append(", currentCustomInput=");
            sb.append(currentCustomInput);
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

        public /* synthetic */ ExtendedMediaInput(Boolean bool, List list, String str, List list2, List list3, List list4, int i, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(bool, list, str, list2, list3, list4, i, s);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$NextInputCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class NextInputCommand implements CommandDescriptor {
        public static final NextInputCommand INSTANCE = new NextInputCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedMediaInputTrait.INSTANCE.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private NextInputCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$PreviousInputCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class PreviousInputCommand implements CommandDescriptor {
        public static final PreviousInputCommand INSTANCE = new PreviousInputCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedMediaInputTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private PreviousInputCommand() {
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$SelectCustomInputCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SelectCustomInputCommand implements CommandDescriptor {
        public static final SelectCustomInputCommand INSTANCE = new SelectCustomInputCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedMediaInputTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SelectCustomInputCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields extendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields : ExtendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields.values()) {
                if (extendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields extendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields : ExtendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields.name(), name)) {
                    return extendedMediaInputTrait$SelectCustomInputCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private ExtendedMediaInputTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput;", "", SDKConstants.PARAM_KEY, "", "names", "", "Lcom/google/home/google/ExtendedMediaInputTrait$InputNames;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getNames", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AvailableInput {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String key;
        private final List<InputNames> names;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedMediaInputTrait$AvailableInput$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<AvailableInput>, StructDescriptor {
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
            public AvailableInput read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(1), InputNames.INSTANCE)));
                return new AvailableInput(payload.getString().mo546getqim9Vi0(0, "Key"), new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<InputNames>() { // from class: com.google.home.google.ExtendedMediaInputTrait$AvailableInput$Adapter$read$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    public final ExtendedMediaInputTrait.InputNames invoke() {
                        return new ExtendedMediaInputTrait.InputNames(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                    }
                }, Reflection.getOrCreateKotlinClass(InputNames.class)).mo547getListqim9Vi0(1, "Names"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, AvailableInput value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getKey());
                writer.struct(InputNames.INSTANCE).mo555writeListqim9Vi0(1, value.getNames());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$AvailableInput$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", SDKConstants.PARAM_KEY, "names", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields key = new StructFields(SDKConstants.PARAM_KEY, 0, 0, "String", Type.String, NoOpDescriptor.INSTANCE, false);
            public static final StructFields names = new StructFields("names", 1, 1, "InputNames", Type.Struct, InputNames.INSTANCE, false);
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{key, names};
            }

            static {
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

        public /* synthetic */ AvailableInput(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvailableInput)) {
                return false;
            }
            AvailableInput availableInput = (AvailableInput) other;
            return Intrinsics.areEqual(this.key, availableInput.key) && Intrinsics.areEqual(this.names, availableInput.names);
        }

        public final String getKey() {
            return this.key;
        }

        public final List<InputNames> getNames() {
            return this.names;
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() + 31;
            return this.names.hashCode() + (iHashCode * 31);
        }

        public String toString() {
            return zzl.zza(this.names, this.key, (byte) 27, "AvailableInput(key=", ", names=");
        }

        public AvailableInput(String str, List<InputNames> list) {
            str.getClass();
            list.getClass();
            this.key = str;
            this.names = list;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$InputNames;", "", "lang", "", "nameSynonym", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getLang", "()Ljava/lang/String;", "getNameSynonym", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InputNames {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String lang;
        private final List<String> nameSynonym;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedMediaInputTrait$InputNames$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$InputNames$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedMediaInputTrait$InputNames;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/ExtendedMediaInputTrait$InputNames;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/ExtendedMediaInputTrait$InputNames;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<InputNames>, StructDescriptor {
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
            public InputNames read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new InputNames(payload$default.getString().mo546getqim9Vi0(0, "Lang"), payload$default.getString().mo547getListqim9Vi0(1, "NameSynonym"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, InputNames value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getLang());
                writer.getString().mo555writeListqim9Vi0(1, value.getNameSynonym());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/ExtendedMediaInputTrait$InputNames$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "lang", "nameSynonym", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields lang;
            public static final StructFields nameSynonym;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{lang, nameSynonym};
            }

            static {
                Type type = Type.String;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                lang = new StructFields("lang", 0, 0, "String", type, noOpDescriptor, false);
                nameSynonym = new StructFields("nameSynonym", 1, 1, "String", type, noOpDescriptor, false);
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

        public /* synthetic */ InputNames(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof InputNames)) {
                return false;
            }
            InputNames inputNames = (InputNames) other;
            return Intrinsics.areEqual(this.lang, inputNames.lang) && Intrinsics.areEqual(this.nameSynonym, inputNames.nameSynonym);
        }

        public final String getLang() {
            return this.lang;
        }

        public final List<String> getNameSynonym() {
            return this.nameSynonym;
        }

        public int hashCode() {
            int iHashCode = this.lang.hashCode() + 31;
            return this.nameSynonym.hashCode() + (iHashCode * 31);
        }

        public String toString() {
            return zzl.zza(this.nameSynonym, this.lang, (byte) 30, "InputNames(lang=", ", nameSynonym=");
        }

        public InputNames(String str, List<String> list) {
            str.getClass();
            list.getClass();
            this.lang = str;
            this.nameSynonym = list;
        }
    }
}
