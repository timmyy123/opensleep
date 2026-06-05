package com.google.home.google;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.CommandDescriptor;
import com.google.home.Field;
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
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0005\b\t\n\u000b\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/home/google/ExtendedColorControlTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "Attributes", "AttributesImpl", "MoveToColorNameCommand", "MoveToColorRgbCommand", "MoveToColorHsvCommand", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedColorControlTrait {
    public static final ExtendedColorControlTrait INSTANCE = new ExtendedColorControlTrait();
    private static final ClusterId Id = new ClusterId(1611070529, "ExtendedColorControl", null, 4, null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 *2\u00020\u0001:\u0001*R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u001eR\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\u001eR\u0012\u0010#\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u0012\u0010&\u001a\u00020'X¦\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006+À\u0006\u0001"}, d2 = {"Lcom/google/home/google/ExtendedColorControlTrait$Attributes;", "", "colorLoopEndTimestampSeconds", "Lkotlin/ULong;", "getColorLoopEndTimestampSeconds-6VbMDqA", "()Lkotlin/ULong;", "currentName", "", "getCurrentName", "()Ljava/lang/String;", "currentRed", "Lkotlin/UByte;", "getCurrentRed-7PGSa80", "()Lkotlin/UByte;", "currentGreen", "getCurrentGreen-7PGSa80", "currentBlue", "getCurrentBlue-7PGSa80", "currentHue", "", "getCurrentHue", "()Ljava/lang/Float;", "currentSaturation", "getCurrentSaturation", "currentValue", "getCurrentValue", "generatedCommandList", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "getFeatureMap-pVg5ArA", "()I", "clusterRevision", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedColorControlTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/google/ExtendedColorControlTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedColorControlTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, ExtendedColorControlTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue<ULong> optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.getUlong().mo549getOptionalNullableqim9Vi0(0, "ColorLoopEndTimestampSeconds");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                ULong orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<String> optionalValueMo549getOptionalNullableqim9Vi02 = payload$default.getString().mo549getOptionalNullableqim9Vi0(1, "CurrentName");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                String orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi03 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(2, "CurrentRed");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                Unit unit = Unit.INSTANCE;
                UByte orNull3 = optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi04 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(3, "CurrentGreen");
                if (optionalValueMo549getOptionalNullableqim9Vi04.isPresent() && optionalValueMo549getOptionalNullableqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                UByte orNull4 = optionalValueMo549getOptionalNullableqim9Vi04.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi05 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(4, "CurrentBlue");
                if (optionalValueMo549getOptionalNullableqim9Vi05.isPresent() && optionalValueMo549getOptionalNullableqim9Vi05.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                UByte orNull5 = optionalValueMo549getOptionalNullableqim9Vi05.getOrNull();
                OptionalValue<Float> optionalValueMo549getOptionalNullableqim9Vi06 = payload$default.getFloat().mo549getOptionalNullableqim9Vi0(5, "CurrentHue");
                if (optionalValueMo549getOptionalNullableqim9Vi06.isPresent() && optionalValueMo549getOptionalNullableqim9Vi06.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(5));
                }
                Float orNull6 = optionalValueMo549getOptionalNullableqim9Vi06.getOrNull();
                OptionalValue<Float> optionalValueMo549getOptionalNullableqim9Vi07 = payload$default.getFloat().mo549getOptionalNullableqim9Vi0(6, "CurrentSaturation");
                if (optionalValueMo549getOptionalNullableqim9Vi07.isPresent() && optionalValueMo549getOptionalNullableqim9Vi07.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(6));
                }
                Float orNull7 = optionalValueMo549getOptionalNullableqim9Vi07.getOrNull();
                OptionalValue<Float> optionalValueMo549getOptionalNullableqim9Vi08 = payload$default.getFloat().mo549getOptionalNullableqim9Vi0(7, "CurrentValue");
                if (optionalValueMo549getOptionalNullableqim9Vi08.isPresent() && optionalValueMo549getOptionalNullableqim9Vi08.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(7));
                }
                Float orNull8 = optionalValueMo549getOptionalNullableqim9Vi08.getOrNull();
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
                return new AttributesImpl(orNull, orNull2, orNull3, orNull4, orNull5, orNull6, orNull7, orNull8, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, data2, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) {
                writer.getClass();
                value.getClass();
                ClusterPayloadWriterKt.wrapPayload(writer, ExtendedColorControlTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getUlong().mo554writeqim9Vi0(0, value.getColorLoopEndTimestampSeconds());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.getString().mo554writeqim9Vi0(1, value.getCurrentName());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.getUbyte().mo554writeqim9Vi0(2, value.getCurrentRed());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.getUbyte().mo554writeqim9Vi0(3, value.getCurrentGreen());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.getUbyte().mo554writeqim9Vi0(4, value.getCurrentBlue());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(5))) {
                    writer.getFloat().mo554writeqim9Vi0(5, value.getCurrentHue());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(6))) {
                    writer.getFloat().mo554writeqim9Vi0(6, value.getCurrentSaturation());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(7))) {
                    writer.getFloat().mo554writeqim9Vi0(7, value.getCurrentValue());
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

        /* JADX INFO: renamed from: getColorLoopEndTimestampSeconds-6VbMDqA */
        ULong getColorLoopEndTimestampSeconds();

        /* JADX INFO: renamed from: getCurrentBlue-7PGSa80 */
        UByte getCurrentBlue();

        /* JADX INFO: renamed from: getCurrentGreen-7PGSa80 */
        UByte getCurrentGreen();

        Float getCurrentHue();

        String getCurrentName();

        /* JADX INFO: renamed from: getCurrentRed-7PGSa80 */
        UByte getCurrentRed();

        Float getCurrentSaturation();

        Float getCurrentValue();

        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA */
        int getFeatureMap();

        List<UInt> getGeneratedCommandList();
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001f\b\u0016\u0018\u0000 ;2\u00020\u0001:\u0001;B«\u0001\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\n\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0004H\u0016¢\u0006\u0004\b \u0010!R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010!R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b*\u0010)R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010'\u001a\u0004\b+\u0010)R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\f\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b/\u0010.R\u001c\u0010\r\u001a\u0004\u0018\u00010\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010,\u001a\u0004\b0\u0010.R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u00101\u001a\u0004\b2\u00103R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u00101\u001a\u0004\b4\u00103R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u00101\u001a\u0004\b5\u00103R\u001a\u0010\u0013\u001a\u00020\u000f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u00106\u001a\u0004\b7\u0010\u001fR\u001a\u0010\u0015\u001a\u00020\u00148\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0015\u00108\u001a\u0004\b9\u0010:¨\u0006<"}, d2 = {"Lcom/google/home/google/ExtendedColorControlTrait$AttributesImpl;", "Lcom/google/home/google/ExtendedColorControlTrait$Attributes;", "Lkotlin/ULong;", "colorLoopEndTimestampSeconds", "", "currentName", "Lkotlin/UByte;", "currentRed", "currentGreen", "currentBlue", "", "currentHue", "currentSaturation", "currentValue", "", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "Lkotlin/UShort;", "clusterRevision", "<init>", "(Lkotlin/ULong;Ljava/lang/String;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UByte;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;Ljava/util/List;Ljava/util/List;ISLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/ULong;", "getColorLoopEndTimestampSeconds-6VbMDqA", "()Lkotlin/ULong;", "Ljava/lang/String;", "getCurrentName", "Lkotlin/UByte;", "getCurrentRed-7PGSa80", "()Lkotlin/UByte;", "getCurrentGreen-7PGSa80", "getCurrentBlue-7PGSa80", "Ljava/lang/Float;", "getCurrentHue", "()Ljava/lang/Float;", "getCurrentSaturation", "getCurrentValue", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "I", "getFeatureMap-pVg5ArA", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final ULong colorLoopEndTimestampSeconds;
        private final UByte currentBlue;
        private final UByte currentGreen;
        private final Float currentHue;
        private final String currentName;
        private final UByte currentRed;
        private final Float currentSaturation;
        private final Float currentValue;
        private final int featureMap;
        private final List<UInt> generatedCommandList;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private AttributesImpl(ULong uLong, String str, UByte uByte, UByte uByte2, UByte uByte3, Float f, Float f2, Float f3, List<UInt> list, List<UInt> list2, List<UInt> list3, int i, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            this.colorLoopEndTimestampSeconds = uLong;
            this.currentName = str;
            this.currentRed = uByte;
            this.currentGreen = uByte2;
            this.currentBlue = uByte3;
            this.currentHue = f;
            this.currentSaturation = f2;
            this.currentValue = f3;
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
            return Intrinsics.areEqual(getColorLoopEndTimestampSeconds(), attributes.getColorLoopEndTimestampSeconds()) && Intrinsics.areEqual(getCurrentName(), attributes.getCurrentName()) && Intrinsics.areEqual(getCurrentRed(), attributes.getCurrentRed()) && Intrinsics.areEqual(getCurrentGreen(), attributes.getCurrentGreen()) && Intrinsics.areEqual(getCurrentBlue(), attributes.getCurrentBlue()) && Intrinsics.areEqual(getCurrentHue(), attributes.getCurrentHue()) && Intrinsics.areEqual(getCurrentSaturation(), attributes.getCurrentSaturation()) && Intrinsics.areEqual(getCurrentValue(), attributes.getCurrentValue()) && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && getFeatureMap() == attributes.getFeatureMap() && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        /* JADX INFO: renamed from: getColorLoopEndTimestampSeconds-6VbMDqA, reason: from getter */
        public ULong getColorLoopEndTimestampSeconds() {
            return this.colorLoopEndTimestampSeconds;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentBlue-7PGSa80, reason: from getter */
        public UByte getCurrentBlue() {
            return this.currentBlue;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentGreen-7PGSa80, reason: from getter */
        public UByte getCurrentGreen() {
            return this.currentGreen;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        public Float getCurrentHue() {
            return this.currentHue;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        public String getCurrentName() {
            return this.currentName;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentRed-7PGSa80, reason: from getter */
        public UByte getCurrentRed() {
            return this.currentRed;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        public Float getCurrentSaturation() {
            return this.currentSaturation;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        public Float getCurrentValue() {
            return this.currentValue;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: from getter */
        public int getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.google.ExtendedColorControlTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        public int hashCode() {
            ULong colorLoopEndTimestampSeconds = getColorLoopEndTimestampSeconds();
            int iM2413hashCodeimpl = colorLoopEndTimestampSeconds != null ? ULong.m2413hashCodeimpl(colorLoopEndTimestampSeconds.getData()) : 0;
            String currentName = getCurrentName();
            int iHashCode = currentName != null ? currentName.hashCode() : 0;
            int i = iM2413hashCodeimpl + 31;
            UByte currentRed = getCurrentRed();
            int iM2369hashCodeimpl = ((((i * 31) + iHashCode) * 31) + (currentRed != null ? UByte.m2369hashCodeimpl(currentRed.getData()) : 0)) * 31;
            UByte currentGreen = getCurrentGreen();
            int iM2369hashCodeimpl2 = (iM2369hashCodeimpl + (currentGreen != null ? UByte.m2369hashCodeimpl(currentGreen.getData()) : 0)) * 31;
            UByte currentBlue = getCurrentBlue();
            int iM2369hashCodeimpl3 = (iM2369hashCodeimpl2 + (currentBlue != null ? UByte.m2369hashCodeimpl(currentBlue.getData()) : 0)) * 31;
            Float currentHue = getCurrentHue();
            int iHashCode2 = (iM2369hashCodeimpl3 + (currentHue != null ? currentHue.hashCode() : 0)) * 31;
            Float currentSaturation = getCurrentSaturation();
            int iHashCode3 = (iHashCode2 + (currentSaturation != null ? currentSaturation.hashCode() : 0)) * 31;
            Float currentValue = getCurrentValue();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((UInt.m2391hashCodeimpl(getFeatureMap()) + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iHashCode3 + (currentValue != null ? currentValue.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            ULong colorLoopEndTimestampSeconds = getColorLoopEndTimestampSeconds();
            String currentName = getCurrentName();
            UByte currentRed = getCurrentRed();
            UByte currentGreen = getCurrentGreen();
            UByte currentBlue = getCurrentBlue();
            Float currentHue = getCurrentHue();
            Float currentSaturation = getCurrentSaturation();
            Float currentValue = getCurrentValue();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            String strM2392toStringimpl = UInt.m2392toStringimpl(getFeatureMap());
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(colorLoopEndTimestampSeconds).length();
            int length2 = String.valueOf(currentName).length();
            int length3 = String.valueOf(currentRed).length();
            int length4 = String.valueOf(currentGreen).length();
            int length5 = String.valueOf(currentBlue).length();
            int length6 = String.valueOf(currentHue).length();
            int length7 = String.valueOf(currentSaturation).length();
            int length8 = String.valueOf(currentValue).length();
            int length9 = String.valueOf(generatedCommandList).length();
            int length10 = String.valueOf(acceptedCommandList).length();
            int length11 = String.valueOf(attributeList).length();
            StringBuilder sb = new StringBuilder(length + 64 + length2 + 13 + length3 + 15 + length4 + 14 + length5 + 13 + length6 + 20 + length7 + 15 + length8 + 23 + length9 + 22 + length10 + 16 + length11 + 13 + String.valueOf(strM2392toStringimpl).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1);
            sb.append("ExtendedColorControl(colorLoopEndTimestampSeconds=");
            sb.append(colorLoopEndTimestampSeconds);
            sb.append(", currentName=");
            sb.append(currentName);
            sb.append(", currentRed=");
            sb.append(currentRed);
            sb.append(", currentGreen=");
            sb.append(currentGreen);
            sb.append(", currentBlue=");
            sb.append(currentBlue);
            sb.append(", currentHue=");
            sb.append(currentHue);
            sb.append(", currentSaturation=");
            sb.append(currentSaturation);
            sb.append(", currentValue=");
            sb.append(currentValue);
            sb.append(", generatedCommandList=");
            sb.append(generatedCommandList);
            sb.append(", acceptedCommandList=");
            sb.append(acceptedCommandList);
            sb.append(", attributeList=");
            sb.append(attributeList);
            sb.append(", featureMap=");
            sb.append(strM2392toStringimpl);
            return Fragment$$ExternalSyntheticOutline1.m(sb, ", clusterRevision=", strM2436toStringimpl, ")");
        }

        public /* synthetic */ AttributesImpl(ULong uLong, String str, UByte uByte, UByte uByte2, UByte uByte3, Float f, Float f2, Float f3, List list, List list2, List list3, int i, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(uLong, str, uByte, uByte2, uByte3, f, f2, f3, list, list2, list3, i, s);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedColorControlTrait$MoveToColorHsvCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToColorHsvCommand implements CommandDescriptor {
        public static final MoveToColorHsvCommand INSTANCE = new MoveToColorHsvCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedColorControlTrait.INSTANCE.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToColorHsvCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields : ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields.values()) {
                if (extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields : ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields.name(), name)) {
                    return extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedColorControlTrait$MoveToColorNameCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToColorNameCommand implements CommandDescriptor {
        public static final MoveToColorNameCommand INSTANCE = new MoveToColorNameCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedColorControlTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToColorNameCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields extendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields : ExtendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields.values()) {
                if (extendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields extendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields : ExtendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields.name(), name)) {
                    return extendedColorControlTrait$MoveToColorNameCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedColorControlTrait$MoveToColorRgbCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToColorRgbCommand implements CommandDescriptor {
        public static final MoveToColorRgbCommand INSTANCE = new MoveToColorRgbCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedColorControlTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToColorRgbCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields extendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields : ExtendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields.values()) {
                if (extendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields extendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields : ExtendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields.name(), name)) {
                    return extendedColorControlTrait$MoveToColorRgbCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private ExtendedColorControlTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }
}
