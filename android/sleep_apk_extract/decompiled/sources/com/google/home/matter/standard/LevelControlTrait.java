package com.google.home.matter.standard;

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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001:\u0010\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "MoveModeEnum", "StepModeEnum", "Feature", "OptionsBitmap", "Attributes", "AttributesImpl", "MutableAttributes", "MoveToLevelCommand", "MoveCommand", "StepCommand", "StopCommand", "MoveToLevelWithOnOffCommand", "MoveWithOnOffCommand", "StepWithOnOffCommand", "StopWithOnOffCommand", "MoveToClosestFrequencyCommand", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class LevelControlTrait {
    public static final LevelControlTrait INSTANCE = new LevelControlTrait();
    private static final ClusterId Id = new ClusterId(8, "LevelControl", null, 4, null);

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 42\u00020\u0001:\u00014R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0014\u0010\f\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\tR\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tR\u0014\u0010\u0012\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\tR\u0014\u0010\u0014\u001a\u0004\u0018\u00010\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\tR\u0014\u0010\u001a\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0005R\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\tR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\tR\u0014\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005R\u0014\u0010\"\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0005R\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%X¦\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0018\u0010)\u001a\b\u0012\u0004\u0012\u00020&0%X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010(R\u0018\u0010+\u001a\b\u0012\u0004\u0012\u00020&0%X¦\u0004¢\u0006\u0006\u001a\u0004\b,\u0010(R\u0012\u0010-\u001a\u00020.X¦\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0012\u00101\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b2\u00103ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u00065À\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "", "currentLevel", "Lkotlin/UByte;", "getCurrentLevel-7PGSa80", "()Lkotlin/UByte;", "remainingTime", "Lkotlin/UShort;", "getRemainingTime-XRpZGF0", "()Lkotlin/UShort;", "minLevel", "getMinLevel-7PGSa80", "maxLevel", "getMaxLevel-7PGSa80", "currentFrequency", "getCurrentFrequency-XRpZGF0", "minFrequency", "getMinFrequency-XRpZGF0", "maxFrequency", "getMaxFrequency-XRpZGF0", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "getOptions", "()Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "onOffTransitionTime", "getOnOffTransitionTime-XRpZGF0", "onLevel", "getOnLevel-7PGSa80", "onTransitionTime", "getOnTransitionTime-XRpZGF0", "offTransitionTime", "getOffTransitionTime-XRpZGF0", "defaultMoveRate", "getDefaultMoveRate-7PGSa80", "startUpCurrentLevel", "getStartUpCurrentLevel-7PGSa80", "generatedCommandList", "", "Lkotlin/UInt;", "getGeneratedCommandList", "()Ljava/util/List;", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "clusterRevision", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.matter.standard.LevelControlTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, LevelControlTrait.INSTANCE.getId());
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                ArrayList arrayList = new ArrayList();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi0 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(0, "CurrentLevel");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                UByte orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi02 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(1, "RemainingTime");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                UShort orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi03 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(2, "MinLevel");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                Unit unit = Unit.INSTANCE;
                UByte orNull3 = optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi04 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(3, "MaxLevel");
                if (optionalValueMo549getOptionalNullableqim9Vi04.isPresent() && optionalValueMo549getOptionalNullableqim9Vi04.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                UByte orNull4 = optionalValueMo549getOptionalNullableqim9Vi04.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi05 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(4, "CurrentFrequency");
                if (optionalValueMo549getOptionalNullableqim9Vi05.isPresent() && optionalValueMo549getOptionalNullableqim9Vi05.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                UShort orNull5 = optionalValueMo549getOptionalNullableqim9Vi05.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi06 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(5, "MinFrequency");
                if (optionalValueMo549getOptionalNullableqim9Vi06.isPresent() && optionalValueMo549getOptionalNullableqim9Vi06.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(5));
                }
                UShort orNull6 = optionalValueMo549getOptionalNullableqim9Vi06.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi07 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(6, "MaxFrequency");
                if (optionalValueMo549getOptionalNullableqim9Vi07.isPresent() && optionalValueMo549getOptionalNullableqim9Vi07.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(6));
                }
                UShort orNull7 = optionalValueMo549getOptionalNullableqim9Vi07.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi08 = payload$default.bitmap(OptionsBitmap.INSTANCE).mo549getOptionalNullableqim9Vi0(15, "Options");
                if (optionalValueMo549getOptionalNullableqim9Vi08.isPresent() && optionalValueMo549getOptionalNullableqim9Vi08.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(15));
                }
                OptionsBitmap optionsBitmap = (OptionsBitmap) optionalValueMo549getOptionalNullableqim9Vi08.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi09 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(16, "OnOffTransitionTime");
                if (optionalValueMo549getOptionalNullableqim9Vi09.isPresent() && optionalValueMo549getOptionalNullableqim9Vi09.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(16));
                }
                UShort orNull8 = optionalValueMo549getOptionalNullableqim9Vi09.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi010 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(17, "OnLevel");
                if (optionalValueMo549getOptionalNullableqim9Vi010.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(17));
                }
                UByte orNull9 = optionalValueMo549getOptionalNullableqim9Vi010.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi011 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(18, "OnTransitionTime");
                if (optionalValueMo549getOptionalNullableqim9Vi011.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(18));
                }
                UShort orNull10 = optionalValueMo549getOptionalNullableqim9Vi011.getOrNull();
                OptionalValue<UShort> optionalValueMo549getOptionalNullableqim9Vi012 = payload$default.getUshort().mo549getOptionalNullableqim9Vi0(19, "OffTransitionTime");
                if (optionalValueMo549getOptionalNullableqim9Vi012.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(19));
                }
                UShort orNull11 = optionalValueMo549getOptionalNullableqim9Vi012.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi013 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(20, "DefaultMoveRate");
                if (optionalValueMo549getOptionalNullableqim9Vi013.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(20));
                }
                UByte orNull12 = optionalValueMo549getOptionalNullableqim9Vi013.getOrNull();
                OptionalValue<UByte> optionalValueMo549getOptionalNullableqim9Vi014 = payload$default.getUbyte().mo549getOptionalNullableqim9Vi0(16384, "StartUpCurrentLevel");
                if (optionalValueMo549getOptionalNullableqim9Vi014.isPresent()) {
                    arrayList.add(UInt.m2388boximpl(16384));
                }
                UByte orNull13 = optionalValueMo549getOptionalNullableqim9Vi014.getOrNull();
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
                return new AttributesImpl(orNull, orNull2, orNull3, orNull4, orNull5, orNull6, orNull7, optionsBitmap, orNull8, orNull9, orNull10, orNull11, orNull12, orNull13, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, feature, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) throws HomeException {
                writer.getClass();
                value.getClass();
                if (value instanceof MutableAttributes) {
                    MutableAttributes.INSTANCE.write(writer, (MutableAttributes) value);
                    return;
                }
                ClusterPayloadWriterKt.wrapPayload(writer, LevelControlTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.getUbyte().mo554writeqim9Vi0(0, value.getCurrentLevel());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.getUshort().mo554writeqim9Vi0(1, value.getRemainingTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.getUbyte().mo554writeqim9Vi0(2, value.getMinLevel());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.getUbyte().mo554writeqim9Vi0(3, value.getMaxLevel());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.getUshort().mo554writeqim9Vi0(4, value.getCurrentFrequency());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(5))) {
                    writer.getUshort().mo554writeqim9Vi0(5, value.getMinFrequency());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(6))) {
                    writer.getUshort().mo554writeqim9Vi0(6, value.getMaxFrequency());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(15))) {
                    writer.bitmap(OptionsBitmap.INSTANCE).mo554writeqim9Vi0(15, value.getOptions());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16))) {
                    writer.getUshort().mo554writeqim9Vi0(16, value.getOnOffTransitionTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(17))) {
                    writer.getUbyte().mo554writeqim9Vi0(17, value.getOnLevel());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(18))) {
                    writer.getUshort().mo554writeqim9Vi0(18, value.getOnTransitionTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(19))) {
                    writer.getUshort().mo554writeqim9Vi0(19, value.getOffTransitionTime());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(20))) {
                    writer.getUbyte().mo554writeqim9Vi0(20, value.getDefaultMoveRate());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(16384))) {
                    writer.getUbyte().mo554writeqim9Vi0(16384, value.getStartUpCurrentLevel());
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

        /* JADX INFO: renamed from: getCurrentFrequency-XRpZGF0 */
        UShort getCurrentFrequency();

        /* JADX INFO: renamed from: getCurrentLevel-7PGSa80 */
        UByte getCurrentLevel();

        /* JADX INFO: renamed from: getDefaultMoveRate-7PGSa80 */
        UByte getDefaultMoveRate();

        Feature getFeatureMap();

        List<UInt> getGeneratedCommandList();

        /* JADX INFO: renamed from: getMaxFrequency-XRpZGF0 */
        UShort getMaxFrequency();

        /* JADX INFO: renamed from: getMaxLevel-7PGSa80 */
        UByte getMaxLevel();

        /* JADX INFO: renamed from: getMinFrequency-XRpZGF0 */
        UShort getMinFrequency();

        /* JADX INFO: renamed from: getMinLevel-7PGSa80 */
        UByte getMinLevel();

        /* JADX INFO: renamed from: getOffTransitionTime-XRpZGF0 */
        UShort getOffTransitionTime();

        /* JADX INFO: renamed from: getOnLevel-7PGSa80 */
        UByte getOnLevel();

        /* JADX INFO: renamed from: getOnOffTransitionTime-XRpZGF0 */
        UShort getOnOffTransitionTime();

        /* JADX INFO: renamed from: getOnTransitionTime-XRpZGF0 */
        UShort getOnTransitionTime();

        OptionsBitmap getOptions();

        /* JADX INFO: renamed from: getRemainingTime-XRpZGF0 */
        UShort getRemainingTime();

        /* JADX INFO: renamed from: getStartUpCurrentLevel-7PGSa80 */
        UByte getStartUpCurrentLevel();
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b#\b\u0016\u0018\u0000 H2\u00020\u00012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002:\u0001HBó\u0001\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0004\u0012\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u000e\b\u0002\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002H\u0096\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010+R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010.R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010)\u001a\u0004\b/\u0010+R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010)\u001a\u0004\b0\u0010+R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010,\u001a\u0004\b1\u0010.R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010,\u001a\u0004\b2\u0010.R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010,\u001a\u0004\b3\u0010.R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u00104\u001a\u0004\b5\u00106R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010,\u001a\u0004\b7\u0010.R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010)\u001a\u0004\b8\u0010+R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0011\u0010,\u001a\u0004\b9\u0010.R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010,\u001a\u0004\b:\u0010.R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b;\u0010+R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b<\u0010+R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0017\u0010=\u001a\u0004\b>\u0010?R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0018\u0010=\u001a\u0004\b@\u0010?R \u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0019\u0010=\u001a\u0004\bA\u0010?R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001b\u0010B\u001a\u0004\bC\u0010DR\u001a\u0010\u001c\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010E\u001a\u0004\bF\u0010G¨\u0006I"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$AttributesImpl;", "Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "", "Lcom/google/home/matter/standard/LevelControlTrait$MutableAttributes;", "Lkotlin/UByte;", "currentLevel", "Lkotlin/UShort;", "remainingTime", "minLevel", "maxLevel", "currentFrequency", "minFrequency", "maxFrequency", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "onOffTransitionTime", "onLevel", "onTransitionTime", "offTransitionTime", "defaultMoveRate", "startUpCurrentLevel", "", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "featureMap", "clusterRevision", "<init>", "(Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UShort;Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UShort;Lkotlin/UShort;Lkotlin/UByte;Lkotlin/UByte;Ljava/util/List;Ljava/util/List;Ljava/util/List;Lcom/google/home/matter/standard/LevelControlTrait$Feature;SLkotlin/jvm/internal/DefaultConstructorMarker;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lkotlin/UByte;", "getCurrentLevel-7PGSa80", "()Lkotlin/UByte;", "Lkotlin/UShort;", "getRemainingTime-XRpZGF0", "()Lkotlin/UShort;", "getMinLevel-7PGSa80", "getMaxLevel-7PGSa80", "getCurrentFrequency-XRpZGF0", "getMinFrequency-XRpZGF0", "getMaxFrequency-XRpZGF0", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "getOptions", "()Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "getOnOffTransitionTime-XRpZGF0", "getOnLevel-7PGSa80", "getOnTransitionTime-XRpZGF0", "getOffTransitionTime-XRpZGF0", "getDefaultMoveRate-7PGSa80", "getStartUpCurrentLevel-7PGSa80", "Ljava/util/List;", "getGeneratedCommandList", "()Ljava/util/List;", "getAcceptedCommandList", "getAttributeList", "Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "getFeatureMap", "()Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class AttributesImpl implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final short clusterRevision;
        private final UShort currentFrequency;
        private final UByte currentLevel;
        private final UByte defaultMoveRate;
        private final Feature featureMap;
        private final List<UInt> generatedCommandList;
        private final UShort maxFrequency;
        private final UByte maxLevel;
        private final UShort minFrequency;
        private final UByte minLevel;
        private final UShort offTransitionTime;
        private final UByte onLevel;
        private final UShort onOffTransitionTime;
        private final UShort onTransitionTime;
        private final OptionsBitmap options;
        private final UShort remainingTime;
        private final UByte startUpCurrentLevel;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private AttributesImpl(UByte uByte, UShort uShort, UByte uByte2, UByte uByte3, UShort uShort2, UShort uShort3, UShort uShort4, OptionsBitmap optionsBitmap, UShort uShort5, UByte uByte4, UShort uShort6, UShort uShort7, UByte uByte5, UByte uByte6, List<UInt> list, List<UInt> list2, List<UInt> list3, Feature feature, short s) {
            list.getClass();
            list2.getClass();
            list3.getClass();
            feature.getClass();
            this.currentLevel = uByte;
            this.remainingTime = uShort;
            this.minLevel = uByte2;
            this.maxLevel = uByte3;
            this.currentFrequency = uShort2;
            this.minFrequency = uShort3;
            this.maxFrequency = uShort4;
            this.options = optionsBitmap;
            this.onOffTransitionTime = uShort5;
            this.onLevel = uByte4;
            this.onTransitionTime = uShort6;
            this.offTransitionTime = uShort7;
            this.defaultMoveRate = uByte5;
            this.startUpCurrentLevel = uByte6;
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
            return Intrinsics.areEqual(getCurrentLevel(), attributes.getCurrentLevel()) && Intrinsics.areEqual(getRemainingTime(), attributes.getRemainingTime()) && Intrinsics.areEqual(getMinLevel(), attributes.getMinLevel()) && Intrinsics.areEqual(getMaxLevel(), attributes.getMaxLevel()) && Intrinsics.areEqual(getCurrentFrequency(), attributes.getCurrentFrequency()) && Intrinsics.areEqual(getMinFrequency(), attributes.getMinFrequency()) && Intrinsics.areEqual(getMaxFrequency(), attributes.getMaxFrequency()) && Intrinsics.areEqual(getOptions(), attributes.getOptions()) && Intrinsics.areEqual(getOnOffTransitionTime(), attributes.getOnOffTransitionTime()) && Intrinsics.areEqual(getOnLevel(), attributes.getOnLevel()) && Intrinsics.areEqual(getOnTransitionTime(), attributes.getOnTransitionTime()) && Intrinsics.areEqual(getOffTransitionTime(), attributes.getOffTransitionTime()) && Intrinsics.areEqual(getDefaultMoveRate(), attributes.getDefaultMoveRate()) && Intrinsics.areEqual(getStartUpCurrentLevel(), attributes.getStartUpCurrentLevel()) && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && Intrinsics.areEqual(getFeatureMap(), attributes.getFeatureMap()) && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentFrequency-XRpZGF0, reason: from getter */
        public UShort getCurrentFrequency() {
            return this.currentFrequency;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getCurrentLevel-7PGSa80, reason: from getter */
        public UByte getCurrentLevel() {
            return this.currentLevel;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getDefaultMoveRate-7PGSa80, reason: from getter */
        public UByte getDefaultMoveRate() {
            return this.defaultMoveRate;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        public Feature getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getMaxFrequency-XRpZGF0, reason: from getter */
        public UShort getMaxFrequency() {
            return this.maxFrequency;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getMaxLevel-7PGSa80, reason: from getter */
        public UByte getMaxLevel() {
            return this.maxLevel;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getMinFrequency-XRpZGF0, reason: from getter */
        public UShort getMinFrequency() {
            return this.minFrequency;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getMinLevel-7PGSa80, reason: from getter */
        public UByte getMinLevel() {
            return this.minLevel;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOffTransitionTime-XRpZGF0, reason: from getter */
        public UShort getOffTransitionTime() {
            return this.offTransitionTime;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOnLevel-7PGSa80, reason: from getter */
        public UByte getOnLevel() {
            return this.onLevel;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOnOffTransitionTime-XRpZGF0, reason: from getter */
        public UShort getOnOffTransitionTime() {
            return this.onOffTransitionTime;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOnTransitionTime-XRpZGF0, reason: from getter */
        public UShort getOnTransitionTime() {
            return this.onTransitionTime;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        public OptionsBitmap getOptions() {
            return this.options;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getRemainingTime-XRpZGF0, reason: from getter */
        public UShort getRemainingTime() {
            return this.remainingTime;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getStartUpCurrentLevel-7PGSa80, reason: from getter */
        public UByte getStartUpCurrentLevel() {
            return this.startUpCurrentLevel;
        }

        public int hashCode() {
            UByte currentLevel = getCurrentLevel();
            int iM2369hashCodeimpl = currentLevel != null ? UByte.m2369hashCodeimpl(currentLevel.getData()) : 0;
            UShort remainingTime = getRemainingTime();
            int iM2435hashCodeimpl = remainingTime != null ? UShort.m2435hashCodeimpl(remainingTime.getData()) : 0;
            int i = iM2369hashCodeimpl + 31;
            UByte minLevel = getMinLevel();
            int iM2369hashCodeimpl2 = ((((i * 31) + iM2435hashCodeimpl) * 31) + (minLevel != null ? UByte.m2369hashCodeimpl(minLevel.getData()) : 0)) * 31;
            UByte maxLevel = getMaxLevel();
            int iM2369hashCodeimpl3 = (iM2369hashCodeimpl2 + (maxLevel != null ? UByte.m2369hashCodeimpl(maxLevel.getData()) : 0)) * 31;
            UShort currentFrequency = getCurrentFrequency();
            int iM2435hashCodeimpl2 = (iM2369hashCodeimpl3 + (currentFrequency != null ? UShort.m2435hashCodeimpl(currentFrequency.getData()) : 0)) * 31;
            UShort minFrequency = getMinFrequency();
            int iM2435hashCodeimpl3 = (iM2435hashCodeimpl2 + (minFrequency != null ? UShort.m2435hashCodeimpl(minFrequency.getData()) : 0)) * 31;
            UShort maxFrequency = getMaxFrequency();
            int iM2435hashCodeimpl4 = (iM2435hashCodeimpl3 + (maxFrequency != null ? UShort.m2435hashCodeimpl(maxFrequency.getData()) : 0)) * 31;
            OptionsBitmap options = getOptions();
            int iHashCode = (iM2435hashCodeimpl4 + (options != null ? options.hashCode() : 0)) * 31;
            UShort onOffTransitionTime = getOnOffTransitionTime();
            int iM2435hashCodeimpl5 = (iHashCode + (onOffTransitionTime != null ? UShort.m2435hashCodeimpl(onOffTransitionTime.getData()) : 0)) * 31;
            UByte onLevel = getOnLevel();
            int iM2369hashCodeimpl4 = (iM2435hashCodeimpl5 + (onLevel != null ? UByte.m2369hashCodeimpl(onLevel.getData()) : 0)) * 31;
            UShort onTransitionTime = getOnTransitionTime();
            int iM2435hashCodeimpl6 = (iM2369hashCodeimpl4 + (onTransitionTime != null ? UShort.m2435hashCodeimpl(onTransitionTime.getData()) : 0)) * 31;
            UShort offTransitionTime = getOffTransitionTime();
            int iM2435hashCodeimpl7 = (iM2435hashCodeimpl6 + (offTransitionTime != null ? UShort.m2435hashCodeimpl(offTransitionTime.getData()) : 0)) * 31;
            UByte defaultMoveRate = getDefaultMoveRate();
            int iM2369hashCodeimpl5 = (iM2435hashCodeimpl7 + (defaultMoveRate != null ? UByte.m2369hashCodeimpl(defaultMoveRate.getData()) : 0)) * 31;
            UByte startUpCurrentLevel = getStartUpCurrentLevel();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((getFeatureMap().hashCode() + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iM2369hashCodeimpl5 + (startUpCurrentLevel != null ? UByte.m2369hashCodeimpl(startUpCurrentLevel.getData()) : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            UByte currentLevel = getCurrentLevel();
            UShort remainingTime = getRemainingTime();
            UByte minLevel = getMinLevel();
            UByte maxLevel = getMaxLevel();
            UShort currentFrequency = getCurrentFrequency();
            UShort minFrequency = getMinFrequency();
            UShort maxFrequency = getMaxFrequency();
            OptionsBitmap options = getOptions();
            UShort onOffTransitionTime = getOnOffTransitionTime();
            UByte onLevel = getOnLevel();
            UShort onTransitionTime = getOnTransitionTime();
            UShort offTransitionTime = getOffTransitionTime();
            UByte defaultMoveRate = getDefaultMoveRate();
            UByte startUpCurrentLevel = getStartUpCurrentLevel();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            Feature featureMap = getFeatureMap();
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(currentLevel).length();
            int length2 = String.valueOf(remainingTime).length();
            int length3 = String.valueOf(minLevel).length();
            int length4 = String.valueOf(maxLevel).length();
            int length5 = String.valueOf(currentFrequency).length();
            int length6 = String.valueOf(minFrequency).length();
            int length7 = String.valueOf(maxFrequency).length();
            int length8 = String.valueOf(options).length();
            int length9 = String.valueOf(onOffTransitionTime).length();
            int length10 = String.valueOf(onLevel).length();
            int length11 = String.valueOf(onTransitionTime).length();
            int length12 = String.valueOf(offTransitionTime).length();
            int length13 = String.valueOf(defaultMoveRate).length();
            int length14 = String.valueOf(startUpCurrentLevel).length();
            int length15 = String.valueOf(generatedCommandList).length();
            int length16 = String.valueOf(acceptedCommandList).length();
            int length17 = String.valueOf(attributeList).length();
            StringBuilder sb = new StringBuilder(length + 42 + length2 + 11 + length3 + 11 + length4 + 19 + length5 + 15 + length6 + 15 + length7 + 10 + length8 + 22 + length9 + 10 + length10 + 19 + length11 + 20 + length12 + 18 + length13 + 22 + length14 + 23 + length15 + 22 + length16 + 16 + length17 + 13 + String.valueOf(featureMap).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1);
            sb.append("LevelControl(currentLevel=");
            sb.append(currentLevel);
            sb.append(", remainingTime=");
            sb.append(remainingTime);
            sb.append(", minLevel=");
            sb.append(minLevel);
            sb.append(", maxLevel=");
            sb.append(maxLevel);
            sb.append(", currentFrequency=");
            sb.append(currentFrequency);
            sb.append(", minFrequency=");
            sb.append(minFrequency);
            sb.append(", maxFrequency=");
            sb.append(maxFrequency);
            sb.append(", options=");
            sb.append(options);
            sb.append(", onOffTransitionTime=");
            sb.append(onOffTransitionTime);
            sb.append(", onLevel=");
            sb.append(onLevel);
            sb.append(", onTransitionTime=");
            sb.append(onTransitionTime);
            sb.append(", offTransitionTime=");
            sb.append(offTransitionTime);
            sb.append(", defaultMoveRate=");
            sb.append(defaultMoveRate);
            sb.append(", startUpCurrentLevel=");
            sb.append(startUpCurrentLevel);
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

        public /* synthetic */ AttributesImpl(UByte uByte, UShort uShort, UByte uByte2, UByte uByte3, UShort uShort2, UShort uShort3, UShort uShort4, OptionsBitmap optionsBitmap, UShort uShort5, UByte uByte4, UShort uShort6, UShort uShort7, UByte uByte5, UByte uByte6, List list, List list2, List list3, Feature feature, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(uByte, uShort, uByte2, uByte3, uShort2, uShort3, uShort4, optionsBitmap, uShort5, uByte4, uShort6, uShort7, uByte5, uByte6, list, list2, list3, feature, s);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\n\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B%\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "onOff", "lighting", "frequency", "<init>", "(ZZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getOnOff", "()Z", "getLighting", "getFrequency", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class Feature extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean frequency;
        private final boolean lighting;
        private final boolean onOff;

        /* JADX INFO: renamed from: com.google.home.matter.standard.LevelControlTrait$Feature$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\t\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$Feature$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/LevelControlTrait$Feature;", "<init>", "()V", "ON_OFF_FLAG", "Lkotlin/ULong;", "J", "LIGHTING_FLAG", "FREQUENCY_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<Feature> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(Feature value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getOnOff());
                mutableBitmap.m564set4PLdz1A(2L, value.getLighting());
                mutableBitmap.m564set4PLdz1A(4L, value.getFrequency());
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
            super(zza$$ExternalSyntheticOutline0.m(8, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "Feature");
            this.onOff = z;
            this.lighting = z2;
            this.frequency = z3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Feature)) {
                return false;
            }
            Feature feature = (Feature) other;
            return this.onOff == feature.onOff && this.lighting == feature.lighting && this.frequency == feature.frequency;
        }

        public final boolean getFrequency() {
            return this.frequency;
        }

        public final boolean getLighting() {
            return this.lighting;
        }

        public final boolean getOnOff() {
            return this.onOff;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.lighting) + (Boolean.hashCode(this.onOff) * 31);
            return Boolean.hashCode(this.frequency) + (iHashCode * 31);
        }

        public String toString() {
            boolean z = this.onOff;
            int length = String.valueOf(z).length();
            boolean z2 = this.lighting;
            int length2 = String.valueOf(z2).length();
            boolean z3 = this.frequency;
            return zzw.zza(z3, z2, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 25, length2, 12, String.valueOf(z3).length()) + 1), z, "Feature(onOff=", ", lighting=", ", frequency=");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveCommand implements CommandDescriptor {
        public static final MoveCommand INSTANCE = new MoveCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$MoveCommand$Request$CommandFields levelControlTrait$MoveCommand$Request$CommandFields : LevelControlTrait$MoveCommand$Request$CommandFields.values()) {
                if (levelControlTrait$MoveCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$MoveCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$MoveCommand$Request$CommandFields levelControlTrait$MoveCommand$Request$CommandFields : LevelControlTrait$MoveCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$MoveCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$MoveCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveToClosestFrequencyCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToClosestFrequencyCommand implements CommandDescriptor {
        public static final MoveToClosestFrequencyCommand INSTANCE = new MoveToClosestFrequencyCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 8, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToClosestFrequencyCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields levelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields : LevelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields.values()) {
                if (levelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields levelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields : LevelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$MoveToClosestFrequencyCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveToLevelCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "Request", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToLevelCommand implements CommandDescriptor {
        public static final MoveToLevelCommand INSTANCE = new MoveToLevelCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0013\u0010\u0002\u001a\u00020\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveToLevelCommand$Request;", "", "level", "Lkotlin/UByte;", "transitionTime", "Lkotlin/UShort;", "optionsMask", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "optionsOverride", "<init>", "(BLkotlin/UShort;Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getLevel-w2LRezQ", "()B", "B", "getTransitionTime-XRpZGF0", "()Lkotlin/UShort;", "getOptionsMask", "()Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "getOptionsOverride", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "CommandFields", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Request {

            /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
            public static final Companion INSTANCE = new Companion(null);
            private final byte level;
            private final OptionsBitmap optionsMask;
            private final OptionsBitmap optionsOverride;
            private final UShort transitionTime;

            /* JADX INFO: renamed from: com.google.home.matter.standard.LevelControlTrait$MoveToLevelCommand$Request$Adapter, reason: from kotlin metadata */
            @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveToLevelCommand$Request$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/LevelControlTrait$MoveToLevelCommand$Request;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class Companion implements StructAdapter<Request> {
                private Companion() {
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.home.matter.serialization.StructAdapter
                public Request read(ClusterPayloadReader reader) {
                    reader.getClass();
                    ClusterPayloadReaderKt.unwrapPayload(reader, MoveToLevelCommand.INSTANCE.getRequestId());
                    ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                    byte data2 = payload$default.getUbyte().mo546getqim9Vi0(0, "Level").getData();
                    UShort uShortMo548getNullableqim9Vi0 = payload$default.getUshort().mo548getNullableqim9Vi0(1, "TransitionTime");
                    OptionsBitmap.Companion companion = OptionsBitmap.INSTANCE;
                    return new Request(data2, uShortMo548getNullableqim9Vi0, (OptionsBitmap) payload$default.bitmap(companion).mo546getqim9Vi0(2, "OptionsMask"), (OptionsBitmap) payload$default.bitmap(companion).mo546getqim9Vi0(3, "OptionsOverride"), null);
                }

                @Override // com.google.home.matter.serialization.StructAdapter
                public void write(ClusterPayloadWriter writer, Request value) {
                    writer.getClass();
                    value.getClass();
                    ClusterPayloadWriterKt.wrapPayload(writer, MoveToLevelCommand.INSTANCE.getRequestId());
                    writer.getUbyte().mo554writeqim9Vi0(0, UByte.m2366boximpl(value.getLevel()));
                    writer.getUshort().mo554writeqim9Vi0(1, value.getTransitionTime());
                    OptionsBitmap.Companion companion = OptionsBitmap.INSTANCE;
                    writer.bitmap(companion).mo554writeqim9Vi0(2, value.getOptionsMask());
                    writer.bitmap(companion).mo554writeqim9Vi0(3, value.getOptionsOverride());
                }

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }
            }

            /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
            /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
            @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveToLevelCommand$Request$CommandFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "level", "transitionTime", "optionsMask", "optionsOverride", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
            public static final class CommandFields implements Field {
                private static final /* synthetic */ EnumEntries $ENTRIES;
                private static final /* synthetic */ CommandFields[] $VALUES;
                public static final CommandFields level;
                public static final CommandFields optionsMask;
                public static final CommandFields optionsOverride;
                public static final CommandFields transitionTime;
                private final Descriptor descriptor;
                private final boolean isNullable;
                private final int tag;
                private final Type typeEnum;
                private final String typeName;

                private static final /* synthetic */ CommandFields[] $values() {
                    return new CommandFields[]{level, transitionTime, optionsMask, optionsOverride};
                }

                static {
                    Type type = Type.UByte;
                    NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                    level = new CommandFields("level", 0, 0, "UByte", type, noOpDescriptor, false);
                    transitionTime = new CommandFields("transitionTime", 1, 1, "UShort", Type.UShort, noOpDescriptor, true);
                    Type type2 = Type.Bitmap;
                    optionsMask = new CommandFields("optionsMask", 2, 2, "OptionsBitmap", type2, noOpDescriptor, false);
                    optionsOverride = new CommandFields("optionsOverride", 3, 3, "OptionsBitmap", type2, noOpDescriptor, false);
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

            private Request(byte b, UShort uShort, OptionsBitmap optionsBitmap, OptionsBitmap optionsBitmap2) {
                optionsBitmap.getClass();
                optionsBitmap2.getClass();
                this.level = b;
                this.transitionTime = uShort;
                this.optionsMask = optionsBitmap;
                this.optionsOverride = optionsBitmap2;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Request)) {
                    return false;
                }
                Request request = (Request) other;
                return this.level == request.level && Intrinsics.areEqual(this.transitionTime, request.transitionTime) && Intrinsics.areEqual(this.optionsMask, request.optionsMask) && Intrinsics.areEqual(this.optionsOverride, request.optionsOverride);
            }

            /* JADX INFO: renamed from: getLevel-w2LRezQ, reason: not valid java name and from getter */
            public final byte getLevel() {
                return this.level;
            }

            public final OptionsBitmap getOptionsMask() {
                return this.optionsMask;
            }

            public final OptionsBitmap getOptionsOverride() {
                return this.optionsOverride;
            }

            /* JADX INFO: renamed from: getTransitionTime-XRpZGF0, reason: not valid java name and from getter */
            public final UShort getTransitionTime() {
                return this.transitionTime;
            }

            public int hashCode() {
                int iM2369hashCodeimpl = UByte.m2369hashCodeimpl(this.level) + 31;
                UShort uShort = this.transitionTime;
                return this.optionsOverride.hashCode() + ((this.optionsMask.hashCode() + zzba$$ExternalSyntheticOutline0.m(iM2369hashCodeimpl, 31, uShort != null ? UShort.m2435hashCodeimpl(uShort.getData()) : 0, 31)) * 31);
            }

            public String toString() {
                String strM2370toStringimpl = UByte.m2370toStringimpl(this.level);
                int length = String.valueOf(strM2370toStringimpl).length();
                UShort uShort = this.transitionTime;
                int length2 = String.valueOf(uShort).length();
                OptionsBitmap optionsBitmap = this.optionsMask;
                int length3 = String.valueOf(optionsBitmap).length();
                OptionsBitmap optionsBitmap2 = this.optionsOverride;
                StringBuilder sb = new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 50, length2, 14, length3, 18, String.valueOf(optionsBitmap2).length()) + 1);
                sb.append("MoveToLevelCommand.Request(level=");
                sb.append(strM2370toStringimpl);
                sb.append(", transitionTime=");
                sb.append(uShort);
                sb.append(", optionsMask=");
                sb.append(optionsBitmap);
                sb.append(", optionsOverride=");
                sb.append(optionsBitmap2);
                sb.append(")");
                return sb.toString();
            }

            public /* synthetic */ Request(byte b, UShort uShort, OptionsBitmap optionsBitmap, OptionsBitmap optionsBitmap2, DefaultConstructorMarker defaultConstructorMarker) {
                this(b, uShort, optionsBitmap, optionsBitmap2);
            }
        }

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToLevelCommand() {
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveToLevelWithOnOffCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveToLevelWithOnOffCommand implements CommandDescriptor {
        public static final MoveToLevelWithOnOffCommand INSTANCE = new MoveToLevelWithOnOffCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 4, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveToLevelWithOnOffCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields levelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields : LevelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields.values()) {
                if (levelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields levelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields : LevelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$MoveToLevelWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveWithOnOffCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveWithOnOffCommand implements CommandDescriptor {
        public static final MoveWithOnOffCommand INSTANCE = new MoveWithOnOffCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 5, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private MoveWithOnOffCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$MoveWithOnOffCommand$Request$CommandFields levelControlTrait$MoveWithOnOffCommand$Request$CommandFields : LevelControlTrait$MoveWithOnOffCommand$Request$CommandFields.values()) {
                if (levelControlTrait$MoveWithOnOffCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$MoveWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$MoveWithOnOffCommand$Request$CommandFields levelControlTrait$MoveWithOnOffCommand$Request$CommandFields : LevelControlTrait$MoveWithOnOffCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$MoveWithOnOffCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$MoveWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b4\u0018\u0000 O2\u00020\u0001:\u0001OB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010#\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R$\u0010)\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010\u0017\u001a\u0004\b*\u0010\u0019\"\u0004\b+\u0010\u001bR\"\u0010,\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010$\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R$\u0010/\u001a\u0004\u0018\u00010\u00158\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0017\u001a\u0004\b0\u0010\u0019\"\u0004\b1\u0010\u001bR\"\u00102\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R$\u00105\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010\u001e\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R\"\u00108\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b8\u0010$\u001a\u0004\b9\u0010&\"\u0004\b:\u0010(R$\u0010;\u001a\u0004\u0018\u00010\u001c8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b;\u0010\u001e\u001a\u0004\b<\u0010 \"\u0004\b=\u0010\"R\"\u0010>\u001a\u00020\b8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b>\u0010$\u001a\u0004\b?\u0010&\"\u0004\b@\u0010(R\u0016\u0010B\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bA\u0010\u0012R\u0016\u0010D\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bC\u0010\u0019R\u0016\u0010F\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010 R\u0016\u0010H\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bG\u0010\u0019R\u0016\u0010J\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010\u0019R\u0016\u0010L\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bK\u0010 R\u0016\u0010N\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bM\u0010 ¨\u0006P"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MutableAttributes;", "Lcom/google/home/matter/standard/LevelControlTrait$AttributesImpl;", "Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "attributes", "<init>", "(Lcom/google/home/matter/standard/LevelControlTrait$Attributes;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "_options", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "get_options$java_com_google_home_matter_standard_clusters_android", "()Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "set_options$java_com_google_home_matter_standard_clusters_android", "(Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;)V", "Lkotlin/UShort;", "_onOffTransitionTime", "Lkotlin/UShort;", "get_onOffTransitionTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UShort;", "set_onOffTransitionTime-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UShort;)V", "Lkotlin/UByte;", "_onLevel", "Lkotlin/UByte;", "get_onLevel-7PGSa80$java_com_google_home_matter_standard_clusters_android", "()Lkotlin/UByte;", "set_onLevel-3swpYEE$java_com_google_home_matter_standard_clusters_android", "(Lkotlin/UByte;)V", "_isOnLevelSet", "Z", "get_isOnLevelSet$java_com_google_home_matter_standard_clusters_android", "()Z", "set_isOnLevelSet$java_com_google_home_matter_standard_clusters_android", "(Z)V", "_onTransitionTime", "get_onTransitionTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_onTransitionTime-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_isOnTransitionTimeSet", "get_isOnTransitionTimeSet$java_com_google_home_matter_standard_clusters_android", "set_isOnTransitionTimeSet$java_com_google_home_matter_standard_clusters_android", "_offTransitionTime", "get_offTransitionTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android", "set_offTransitionTime-ffyZV3s$java_com_google_home_matter_standard_clusters_android", "_isOffTransitionTimeSet", "get_isOffTransitionTimeSet$java_com_google_home_matter_standard_clusters_android", "set_isOffTransitionTimeSet$java_com_google_home_matter_standard_clusters_android", "_defaultMoveRate", "get_defaultMoveRate-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_defaultMoveRate-3swpYEE$java_com_google_home_matter_standard_clusters_android", "_isDefaultMoveRateSet", "get_isDefaultMoveRateSet$java_com_google_home_matter_standard_clusters_android", "set_isDefaultMoveRateSet$java_com_google_home_matter_standard_clusters_android", "_startUpCurrentLevel", "get_startUpCurrentLevel-7PGSa80$java_com_google_home_matter_standard_clusters_android", "set_startUpCurrentLevel-3swpYEE$java_com_google_home_matter_standard_clusters_android", "_isStartUpCurrentLevelSet", "get_isStartUpCurrentLevelSet$java_com_google_home_matter_standard_clusters_android", "set_isStartUpCurrentLevelSet$java_com_google_home_matter_standard_clusters_android", "getOptions", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "getOnOffTransitionTime-XRpZGF0", "onOffTransitionTime", "getOnLevel-7PGSa80", "onLevel", "getOnTransitionTime-XRpZGF0", "onTransitionTime", "getOffTransitionTime-XRpZGF0", "offTransitionTime", "getDefaultMoveRate-7PGSa80", "defaultMoveRate", "getStartUpCurrentLevel-7PGSa80", "startUpCurrentLevel", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MutableAttributes extends AttributesImpl {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private UByte _defaultMoveRate;
        private boolean _isDefaultMoveRateSet;
        private boolean _isOffTransitionTimeSet;
        private boolean _isOnLevelSet;
        private boolean _isOnTransitionTimeSet;
        private boolean _isStartUpCurrentLevelSet;
        private UShort _offTransitionTime;
        private UByte _onLevel;
        private UShort _onOffTransitionTime;
        private UShort _onTransitionTime;
        private OptionsBitmap _options;
        private UByte _startUpCurrentLevel;

        /* JADX INFO: renamed from: com.google.home.matter.standard.LevelControlTrait$MutableAttributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MutableAttributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/matter/standard/LevelControlTrait$MutableAttributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
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
                ClusterPayloadWriterKt.wrapPayload(writer, LevelControlTrait.INSTANCE.getId());
                if (value.get_options() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(15))) {
                        throw HomeException.INSTANCE.invalidArgument(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                    }
                    writer.bitmap(OptionsBitmap.INSTANCE).mo554writeqim9Vi0(15, value.get_options());
                }
                if (value.get_onOffTransitionTime() != null) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(16))) {
                        throw HomeException.INSTANCE.invalidArgument("onOffTransitionTime");
                    }
                    writer.getUshort().mo554writeqim9Vi0(16, value.get_onOffTransitionTime());
                }
                if (value.get_isOnLevelSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(17))) {
                        throw HomeException.INSTANCE.invalidArgument("onLevel");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(17, value.get_onLevel());
                }
                if (value.get_isOnTransitionTimeSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(18))) {
                        throw HomeException.INSTANCE.invalidArgument("onTransitionTime");
                    }
                    writer.getUshort().mo554writeqim9Vi0(18, value.get_onTransitionTime());
                }
                if (value.get_isOffTransitionTimeSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(19))) {
                        throw HomeException.INSTANCE.invalidArgument("offTransitionTime");
                    }
                    writer.getUshort().mo554writeqim9Vi0(19, value.get_offTransitionTime());
                }
                if (value.get_isDefaultMoveRateSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(20))) {
                        throw HomeException.INSTANCE.invalidArgument("defaultMoveRate");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(20, value.get_defaultMoveRate());
                }
                if (value.get_isStartUpCurrentLevelSet()) {
                    if (writer.getStrictOperationValidation() && !value.getAttributeList().contains(UInt.m2388boximpl(16384))) {
                        throw HomeException.INSTANCE.invalidArgument("startUpCurrentLevel");
                    }
                    writer.getUbyte().mo554writeqim9Vi0(16384, value.get_startUpCurrentLevel());
                }
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MutableAttributes(Attributes attributes) {
            super(attributes.getCurrentLevel(), attributes.getRemainingTime(), attributes.getMinLevel(), attributes.getMaxLevel(), attributes.getCurrentFrequency(), attributes.getMinFrequency(), attributes.getMaxFrequency(), attributes.getOptions(), attributes.getOnOffTransitionTime(), attributes.getOnLevel(), attributes.getOnTransitionTime(), attributes.getOffTransitionTime(), attributes.getDefaultMoveRate(), attributes.getStartUpCurrentLevel(), attributes.getGeneratedCommandList(), attributes.getAcceptedCommandList(), attributes.getAttributeList(), attributes.getFeatureMap(), attributes.getClusterRevision(), null);
            attributes.getClass();
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (other instanceof MutableAttributes) {
                return super.equals(other);
            }
            return false;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl, com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getDefaultMoveRate-7PGSa80 */
        public UByte getDefaultMoveRate() {
            return this._isDefaultMoveRateSet ? this._defaultMoveRate : super.getDefaultMoveRate();
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl, com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOffTransitionTime-XRpZGF0 */
        public UShort getOffTransitionTime() {
            return this._isOffTransitionTimeSet ? this._offTransitionTime : super.getOffTransitionTime();
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl, com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOnLevel-7PGSa80 */
        public UByte getOnLevel() {
            return this._isOnLevelSet ? this._onLevel : super.getOnLevel();
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl, com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOnOffTransitionTime-XRpZGF0 */
        public UShort getOnOffTransitionTime() {
            UShort uShort = this._onOffTransitionTime;
            return uShort == null ? super.getOnOffTransitionTime() : uShort;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl, com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getOnTransitionTime-XRpZGF0 */
        public UShort getOnTransitionTime() {
            return this._isOnTransitionTimeSet ? this._onTransitionTime : super.getOnTransitionTime();
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl, com.google.home.matter.standard.LevelControlTrait.Attributes
        public OptionsBitmap getOptions() {
            OptionsBitmap optionsBitmap = this._options;
            return optionsBitmap == null ? super.getOptions() : optionsBitmap;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl, com.google.home.matter.standard.LevelControlTrait.Attributes
        /* JADX INFO: renamed from: getStartUpCurrentLevel-7PGSa80 */
        public UByte getStartUpCurrentLevel() {
            return this._isStartUpCurrentLevelSet ? this._startUpCurrentLevel : super.getStartUpCurrentLevel();
        }

        /* JADX INFO: renamed from: get_defaultMoveRate-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_defaultMoveRate() {
            return this._defaultMoveRate;
        }

        /* JADX INFO: renamed from: get_isDefaultMoveRateSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isDefaultMoveRateSet() {
            return this._isDefaultMoveRateSet;
        }

        /* JADX INFO: renamed from: get_isOffTransitionTimeSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isOffTransitionTimeSet() {
            return this._isOffTransitionTimeSet;
        }

        /* JADX INFO: renamed from: get_isOnLevelSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isOnLevelSet() {
            return this._isOnLevelSet;
        }

        /* JADX INFO: renamed from: get_isOnTransitionTimeSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isOnTransitionTimeSet() {
            return this._isOnTransitionTimeSet;
        }

        /* JADX INFO: renamed from: get_isStartUpCurrentLevelSet$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final boolean get_isStartUpCurrentLevelSet() {
            return this._isStartUpCurrentLevelSet;
        }

        /* JADX INFO: renamed from: get_offTransitionTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_offTransitionTime() {
            return this._offTransitionTime;
        }

        /* JADX INFO: renamed from: get_onLevel-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_onLevel() {
            return this._onLevel;
        }

        /* JADX INFO: renamed from: get_onOffTransitionTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_onOffTransitionTime() {
            return this._onOffTransitionTime;
        }

        /* JADX INFO: renamed from: get_onTransitionTime-XRpZGF0$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UShort get_onTransitionTime() {
            return this._onTransitionTime;
        }

        /* JADX INFO: renamed from: get_options$java_com_google_home_matter_standard_clusters_android, reason: from getter */
        public final OptionsBitmap get_options() {
            return this._options;
        }

        /* JADX INFO: renamed from: get_startUpCurrentLevel-7PGSa80$java_com_google_home_matter_standard_clusters_android, reason: not valid java name and from getter */
        public final UByte get_startUpCurrentLevel() {
            return this._startUpCurrentLevel;
        }

        @Override // com.google.home.matter.standard.LevelControlTrait.AttributesImpl
        public String toString() {
            String string = super.toString();
            return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(string.length() + 32), "LevelControl.MutableAttributes(", string, ")");
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "Lcom/google/home/matter/serialization/ClusterBitmap;", "", "executeIfOff", "coupleColorTempToLevel", "<init>", "(ZZ)V", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getExecuteIfOff", "()Z", "getCoupleColorTempToLevel", "Adapter", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final /* data */ class OptionsBitmap extends ClusterBitmap {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean coupleColorTempToLevel;
        private final boolean executeIfOff;

        /* JADX INFO: renamed from: com.google.home.matter.standard.LevelControlTrait$OptionsBitmap$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007R\u0010\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap$Adapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "Lcom/google/home/matter/standard/LevelControlTrait$OptionsBitmap;", "<init>", "()V", "EXECUTE_IF_OFF_FLAG", "Lkotlin/ULong;", "J", "COUPLE_COLOR_TEMP_TO_LEVEL_FLAG", "toRaw", "Lcom/google/home/matter/serialization/Bitmap;", SDKConstants.PARAM_VALUE, "toRuntime", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements BitmapAdapter<OptionsBitmap> {
            private Companion() {
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public Bitmap toRaw(OptionsBitmap value) {
                value.getClass();
                MutableBitmap mutableBitmap = new MutableBitmap(0L, 1, null);
                mutableBitmap.m564set4PLdz1A(1L, value.getExecuteIfOff());
                mutableBitmap.m564set4PLdz1A(2L, value.getCoupleColorTempToLevel());
                return mutableBitmap;
            }

            @Override // com.google.home.matter.serialization.FieldAdapter
            public OptionsBitmap toRuntime(Bitmap value) {
                value.getClass();
                return new OptionsBitmap(value.m525getVKZWuLQ(1L), value.m525getVKZWuLQ(2L));
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public OptionsBitmap(boolean z, boolean z2) {
            super(zza$$ExternalSyntheticOutline0.m(8, (String) null, (String) null, 6, (DefaultConstructorMarker) null), "OptionsBitmap");
            this.executeIfOff = z;
            this.coupleColorTempToLevel = z2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof OptionsBitmap)) {
                return false;
            }
            OptionsBitmap optionsBitmap = (OptionsBitmap) other;
            return this.executeIfOff == optionsBitmap.executeIfOff && this.coupleColorTempToLevel == optionsBitmap.coupleColorTempToLevel;
        }

        public final boolean getCoupleColorTempToLevel() {
            return this.coupleColorTempToLevel;
        }

        public final boolean getExecuteIfOff() {
            return this.executeIfOff;
        }

        public int hashCode() {
            return Boolean.hashCode(this.coupleColorTempToLevel) + (Boolean.hashCode(this.executeIfOff) * 31);
        }

        public String toString() {
            return zzu.zza(this.coupleColorTempToLevel, this.executeIfOff, (byte) 52, "OptionsBitmap(executeIfOff=", ", coupleColorTempToLevel=");
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$StepCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepCommand implements CommandDescriptor {
        public static final StepCommand INSTANCE = new StepCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StepCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$StepCommand$Request$CommandFields levelControlTrait$StepCommand$Request$CommandFields : LevelControlTrait$StepCommand$Request$CommandFields.values()) {
                if (levelControlTrait$StepCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$StepCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$StepCommand$Request$CommandFields levelControlTrait$StepCommand$Request$CommandFields : LevelControlTrait$StepCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$StepCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$StepCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$StepWithOnOffCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepWithOnOffCommand implements CommandDescriptor {
        public static final StepWithOnOffCommand INSTANCE = new StepWithOnOffCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 6, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StepWithOnOffCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$StepWithOnOffCommand$Request$CommandFields levelControlTrait$StepWithOnOffCommand$Request$CommandFields : LevelControlTrait$StepWithOnOffCommand$Request$CommandFields.values()) {
                if (levelControlTrait$StepWithOnOffCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$StepWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$StepWithOnOffCommand$Request$CommandFields levelControlTrait$StepWithOnOffCommand$Request$CommandFields : LevelControlTrait$StepWithOnOffCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$StepWithOnOffCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$StepWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$StopCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StopCommand implements CommandDescriptor {
        public static final StopCommand INSTANCE = new StopCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 3, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StopCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$StopCommand$Request$CommandFields levelControlTrait$StopCommand$Request$CommandFields : LevelControlTrait$StopCommand$Request$CommandFields.values()) {
                if (levelControlTrait$StopCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$StopCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$StopCommand$Request$CommandFields levelControlTrait$StopCommand$Request$CommandFields : LevelControlTrait$StopCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$StopCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$StopCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$StopWithOnOffCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StopWithOnOffCommand implements CommandDescriptor {
        public static final StopWithOnOffCommand INSTANCE = new StopWithOnOffCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(LevelControlTrait.INSTANCE.getId(), 7, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private StopWithOnOffCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (LevelControlTrait$StopWithOnOffCommand$Request$CommandFields levelControlTrait$StopWithOnOffCommand$Request$CommandFields : LevelControlTrait$StopWithOnOffCommand$Request$CommandFields.values()) {
                if (levelControlTrait$StopWithOnOffCommand$Request$CommandFields.getTag() == tagId) {
                    return levelControlTrait$StopWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (LevelControlTrait$StopWithOnOffCommand$Request$CommandFields levelControlTrait$StopWithOnOffCommand$Request$CommandFields : LevelControlTrait$StopWithOnOffCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(levelControlTrait$StopWithOnOffCommand$Request$CommandFields.name(), name)) {
                    return levelControlTrait$StopWithOnOffCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private LevelControlTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveModeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Up", "Down", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MoveModeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MoveModeEnum[] $VALUES;
        private static final EnumAdapter<MoveModeEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final MoveModeEnum Down;
        public static final MoveModeEnum UnknownValue;
        public static final MoveModeEnum Up;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$MoveModeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/LevelControlTrait$MoveModeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<MoveModeEnum> getAdapter() {
                return MoveModeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ MoveModeEnum[] $values() {
            return new MoveModeEnum[]{Up, Down, UnknownValue};
        }

        static {
            String str = null;
            Up = new MoveModeEnum("Up", 0, 0L, null, str, 6, null);
            String str2 = null;
            Down = new MoveModeEnum("Down", 1, 1L, str, str2, 6, null);
            UnknownValue = new MoveModeEnum("UnknownValue", 2, -1L, str2, null, 6, null);
            MoveModeEnum[] moveModeEnumArr$values = $values();
            $VALUES = moveModeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(moveModeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ MoveModeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(8, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "MoveModeEnum" : str3);
        }

        public static MoveModeEnum valueOf(String str) {
            return (MoveModeEnum) Enum.valueOf(MoveModeEnum.class, str);
        }

        public static MoveModeEnum[] values() {
            return (MoveModeEnum[]) $VALUES.clone();
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

        private MoveModeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u0000 \u00132\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0013B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$StepModeEnum;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Up", "Down", "UnknownValue", "Companion", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StepModeEnum implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StepModeEnum[] $VALUES;
        private static final EnumAdapter<StepModeEnum> Adapter;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final StepModeEnum Down;
        public static final StepModeEnum UnknownValue;
        public static final StepModeEnum Up;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/matter/standard/LevelControlTrait$StepModeEnum$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/matter/standard/LevelControlTrait$StepModeEnum;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<StepModeEnum> getAdapter() {
                return StepModeEnum.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ StepModeEnum[] $values() {
            return new StepModeEnum[]{Up, Down, UnknownValue};
        }

        static {
            String str = null;
            Up = new StepModeEnum("Up", 0, 0L, null, str, 6, null);
            String str2 = null;
            Down = new StepModeEnum("Down", 1, 1L, str, str2, 6, null);
            UnknownValue = new StepModeEnum("UnknownValue", 2, -1L, str2, null, 6, null);
            StepModeEnum[] stepModeEnumArr$values = $values();
            $VALUES = stepModeEnumArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(stepModeEnumArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ StepModeEnum(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(8, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "StepModeEnum" : str3);
        }

        public static StepModeEnum valueOf(String str) {
            return (StepModeEnum) Enum.valueOf(StepModeEnum.class, str);
        }

        public static StepModeEnum[] values() {
            return (StepModeEnum[]) $VALUES.clone();
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

        private StepModeEnum(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}
