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
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.google.home.google.ExtendedApplicationLauncherTrait;
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
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\b\b\t\n\u000b\f\r\u000e\u000fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait;", "", "<init>", "()V", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "ApplicationType", "ApplicationNames", "AvailableApplication", "Attributes", "AttributesImpl", "InstallAppCommand", "SearchAppCommand", "LaunchAppCommand", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedApplicationLauncherTrait {
    public static final ExtendedApplicationLauncherTrait INSTANCE = new ExtendedApplicationLauncherTrait();
    private static final ClusterId Id = new ClusterId(1611070469, "ExtendedApplicationLauncher", null, 4, null);

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 #2\u00020\u0001:\u0001#R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u0010X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0006R\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0006R\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00160\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0006R\u0012\u0010\u001c\u001a\u00020\u0016X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0012\u0010\u001f\u001a\u00020 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$Attributes;", "", "availableApplications", "", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication;", "getAvailableApplications", "()Ljava/util/List;", "currentApplicationKey", "", "getCurrentApplicationKey", "()Ljava/lang/String;", "useGlobalApplicationCatalog", "", "getUseGlobalApplicationCatalog", "()Ljava/lang/Boolean;", "type", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;", "getType", "()Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;", "globalApplicationCatalog", "getGlobalApplicationCatalog", "generatedCommandList", "Lkotlin/UInt;", "getGeneratedCommandList", "acceptedCommandList", "getAcceptedCommandList", "attributeList", "getAttributeList", "featureMap", "getFeatureMap-pVg5ArA", "()I", "clusterRevision", "Lkotlin/UShort;", "getClusterRevision-Mh2AYeg", "()S", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface Attributes {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedApplicationLauncherTrait$Attributes$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$Attributes$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$Attributes;", "<init>", "()V", "write", "", "writer", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", SDKConstants.PARAM_VALUE, "read", "reader", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<Attributes> {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            private Companion() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.home.matter.serialization.StructAdapter
            public Attributes read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayloadReaderKt.unwrapPayload(reader, ExtendedApplicationLauncherTrait.INSTANCE.getId());
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(0), AvailableApplication.INSTANCE)));
                ArrayList arrayList = new ArrayList();
                OptionalValue<List<T>> optionalValueMo550getOptionalNullableListqim9Vi0 = new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<AvailableApplication>() { // from class: com.google.home.google.ExtendedApplicationLauncherTrait$Attributes$Adapter$read$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    public final ExtendedApplicationLauncherTrait.AvailableApplication invoke() {
                        return new ExtendedApplicationLauncherTrait.AvailableApplication(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                    }
                }, Reflection.getOrCreateKotlinClass(AvailableApplication.class)).mo550getOptionalNullableListqim9Vi0(0, "AvailableApplications");
                if (optionalValueMo550getOptionalNullableListqim9Vi0.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(0));
                }
                List list = (List) optionalValueMo550getOptionalNullableListqim9Vi0.getOrNull();
                OptionalValue<String> optionalValueMo549getOptionalNullableqim9Vi0 = payload.getString().mo549getOptionalNullableqim9Vi0(1, "CurrentApplicationKey");
                if (optionalValueMo549getOptionalNullableqim9Vi0.isPresent() && optionalValueMo549getOptionalNullableqim9Vi0.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(1));
                }
                String orNull = optionalValueMo549getOptionalNullableqim9Vi0.getOrNull();
                OptionalValue<Boolean> optionalValueMo549getOptionalNullableqim9Vi02 = payload.getBoolean().mo549getOptionalNullableqim9Vi0(2, "UseGlobalApplicationCatalog");
                if (optionalValueMo549getOptionalNullableqim9Vi02.isPresent() && optionalValueMo549getOptionalNullableqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(2));
                }
                Unit unit = Unit.INSTANCE;
                Boolean orNull2 = optionalValueMo549getOptionalNullableqim9Vi02.getOrNull();
                OptionalValue optionalValueMo549getOptionalNullableqim9Vi03 = payload.m545enum(ApplicationType.INSTANCE.getAdapter()).mo549getOptionalNullableqim9Vi0(3, "Type");
                if (optionalValueMo549getOptionalNullableqim9Vi03.isPresent() && optionalValueMo549getOptionalNullableqim9Vi03.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(3));
                }
                ApplicationType applicationType = (ApplicationType) optionalValueMo549getOptionalNullableqim9Vi03.getOrNull();
                OptionalValue<List<String>> optionalValueMo550getOptionalNullableListqim9Vi02 = payload.getString().mo550getOptionalNullableListqim9Vi0(4, "GlobalApplicationCatalog");
                if (optionalValueMo550getOptionalNullableListqim9Vi02.isPresent() && optionalValueMo550getOptionalNullableListqim9Vi02.getValue() != null) {
                    arrayList.add(UInt.m2388boximpl(4));
                }
                List<String> orNull3 = optionalValueMo550getOptionalNullableListqim9Vi02.getOrNull();
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
                return new ExtendedApplicationLauncher(list, orNull, orNull2, applicationType, orNull3, listMo547getListqim9Vi0, listMo547getListqim9Vi02, arrayList, data2, uShortMo546getqim9Vi0.getData(), null);
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, Attributes value) {
                writer.getClass();
                value.getClass();
                ClusterPayloadWriterKt.wrapPayload(writer, ExtendedApplicationLauncherTrait.INSTANCE.getId());
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(0))) {
                    writer.struct(AvailableApplication.INSTANCE).mo555writeListqim9Vi0(0, value.getAvailableApplications());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(1))) {
                    writer.getString().mo554writeqim9Vi0(1, value.getCurrentApplicationKey());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(2))) {
                    writer.getBoolean().mo554writeqim9Vi0(2, value.getUseGlobalApplicationCatalog());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(3))) {
                    writer.m552enum(ApplicationType.INSTANCE.getAdapter()).mo554writeqim9Vi0(3, value.getType());
                }
                if (!writer.getStrictOperationValidation() || value.getAttributeList().contains(UInt.m2388boximpl(4))) {
                    writer.getString().mo555writeListqim9Vi0(4, value.getGlobalApplicationCatalog());
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

        List<AvailableApplication> getAvailableApplications();

        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg */
        short getClusterRevision();

        String getCurrentApplicationKey();

        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA */
        int getFeatureMap();

        List<UInt> getGeneratedCommandList();

        List<String> getGlobalApplicationCatalog();

        ApplicationType getType();

        Boolean getUseGlobalApplicationCatalog();
    }

    /* JADX INFO: renamed from: com.google.home.google.ExtendedApplicationLauncherTrait$AttributesImpl, reason: from toString */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001a\b\u0016\u0018\u0000 22\u00020\u0001:\u00012B\u0093\u0001\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u0002\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0017\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0096\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010\u001dR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b$\u0010%R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010&\u001a\u0004\b'\u0010(R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001e\u001a\u0004\b)\u0010 R \u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b*\u0010 R \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b+\u0010 R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b,\u0010 R\u001a\u0010\u0010\u001a\u00020\f8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0010\u0010-\u001a\u0004\b.\u0010\u001bR\u001a\u0010\u0012\u001a\u00020\u00118\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010/\u001a\u0004\b0\u00101¨\u00063"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$AttributesImpl;", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$Attributes;", "", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication;", "availableApplications", "", "currentApplicationKey", "", "useGlobalApplicationCatalog", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;", "type", "globalApplicationCatalog", "Lkotlin/UInt;", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "Lkotlin/UShort;", "clusterRevision", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Boolean;Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;ISLkotlin/jvm/internal/DefaultConstructorMarker;)V", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/List;", "getAvailableApplications", "()Ljava/util/List;", "Ljava/lang/String;", "getCurrentApplicationKey", "Ljava/lang/Boolean;", "getUseGlobalApplicationCatalog", "()Ljava/lang/Boolean;", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;", "getType", "()Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;", "getGlobalApplicationCatalog", "getGeneratedCommandList", "getAcceptedCommandList", "getAttributeList", "I", "getFeatureMap-pVg5ArA", "S", "getClusterRevision-Mh2AYeg", "()S", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static class ExtendedApplicationLauncher implements Attributes {
        private final List<UInt> acceptedCommandList;
        private final List<UInt> attributeList;
        private final List<AvailableApplication> availableApplications;
        private final short clusterRevision;
        private final String currentApplicationKey;
        private final int featureMap;
        private final List<UInt> generatedCommandList;
        private final List<String> globalApplicationCatalog;
        private final ApplicationType type;
        private final Boolean useGlobalApplicationCatalog;
        private static final Attributes.Companion Adapter = Attributes.INSTANCE;

        private ExtendedApplicationLauncher(List<AvailableApplication> list, String str, Boolean bool, ApplicationType applicationType, List<String> list2, List<UInt> list3, List<UInt> list4, List<UInt> list5, int i, short s) {
            list3.getClass();
            list4.getClass();
            list5.getClass();
            this.availableApplications = list;
            this.currentApplicationKey = str;
            this.useGlobalApplicationCatalog = bool;
            this.type = applicationType;
            this.globalApplicationCatalog = list2;
            this.generatedCommandList = list3;
            this.acceptedCommandList = list4;
            this.attributeList = list5;
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
            return Intrinsics.areEqual(getAvailableApplications(), attributes.getAvailableApplications()) && Intrinsics.areEqual(getCurrentApplicationKey(), attributes.getCurrentApplicationKey()) && Intrinsics.areEqual(getUseGlobalApplicationCatalog(), attributes.getUseGlobalApplicationCatalog()) && getType() == attributes.getType() && Intrinsics.areEqual(getGlobalApplicationCatalog(), attributes.getGlobalApplicationCatalog()) && Intrinsics.areEqual(getGeneratedCommandList(), attributes.getGeneratedCommandList()) && Intrinsics.areEqual(getAcceptedCommandList(), attributes.getAcceptedCommandList()) && Intrinsics.areEqual(getAttributeList(), attributes.getAttributeList()) && getFeatureMap() == attributes.getFeatureMap() && getClusterRevision() == attributes.getClusterRevision();
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public List<UInt> getAcceptedCommandList() {
            return this.acceptedCommandList;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public List<UInt> getAttributeList() {
            return this.attributeList;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public List<AvailableApplication> getAvailableApplications() {
            return this.availableApplications;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        /* JADX INFO: renamed from: getClusterRevision-Mh2AYeg, reason: from getter */
        public short getClusterRevision() {
            return this.clusterRevision;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public String getCurrentApplicationKey() {
            return this.currentApplicationKey;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        /* JADX INFO: renamed from: getFeatureMap-pVg5ArA, reason: from getter */
        public int getFeatureMap() {
            return this.featureMap;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public List<UInt> getGeneratedCommandList() {
            return this.generatedCommandList;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public List<String> getGlobalApplicationCatalog() {
            return this.globalApplicationCatalog;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public ApplicationType getType() {
            return this.type;
        }

        @Override // com.google.home.google.ExtendedApplicationLauncherTrait.Attributes
        public Boolean getUseGlobalApplicationCatalog() {
            return this.useGlobalApplicationCatalog;
        }

        public int hashCode() {
            List<AvailableApplication> availableApplications = getAvailableApplications();
            int iHashCode = availableApplications != null ? availableApplications.hashCode() : 0;
            String currentApplicationKey = getCurrentApplicationKey();
            int iHashCode2 = currentApplicationKey != null ? currentApplicationKey.hashCode() : 0;
            int i = iHashCode + 31;
            Boolean useGlobalApplicationCatalog = getUseGlobalApplicationCatalog();
            int iHashCode3 = ((((i * 31) + iHashCode2) * 31) + (useGlobalApplicationCatalog != null ? useGlobalApplicationCatalog.hashCode() : 0)) * 31;
            ApplicationType type = getType();
            int iHashCode4 = (iHashCode3 + (type != null ? type.hashCode() : 0)) * 31;
            List<String> globalApplicationCatalog = getGlobalApplicationCatalog();
            return UShort.m2435hashCodeimpl(getClusterRevision()) + ((UInt.m2391hashCodeimpl(getFeatureMap()) + ((getAttributeList().hashCode() + ((getAcceptedCommandList().hashCode() + ((getGeneratedCommandList().hashCode() + ((iHashCode4 + (globalApplicationCatalog != null ? globalApplicationCatalog.hashCode() : 0)) * 31)) * 31)) * 31)) * 31)) * 31);
        }

        public String toString() {
            List<AvailableApplication> availableApplications = getAvailableApplications();
            String currentApplicationKey = getCurrentApplicationKey();
            Boolean useGlobalApplicationCatalog = getUseGlobalApplicationCatalog();
            ApplicationType type = getType();
            List<String> globalApplicationCatalog = getGlobalApplicationCatalog();
            List<UInt> generatedCommandList = getGeneratedCommandList();
            List<UInt> acceptedCommandList = getAcceptedCommandList();
            List<UInt> attributeList = getAttributeList();
            String strM2392toStringimpl = UInt.m2392toStringimpl(getFeatureMap());
            String strM2436toStringimpl = UShort.m2436toStringimpl(getClusterRevision());
            int length = String.valueOf(availableApplications).length();
            int length2 = String.valueOf(currentApplicationKey).length();
            int length3 = String.valueOf(useGlobalApplicationCatalog).length();
            int length4 = String.valueOf(type).length();
            int length5 = String.valueOf(globalApplicationCatalog).length();
            int length6 = String.valueOf(generatedCommandList).length();
            int length7 = String.valueOf(acceptedCommandList).length();
            int length8 = String.valueOf(attributeList).length();
            StringBuilder sb = new StringBuilder(length + 74 + length2 + 30 + length3 + 7 + length4 + 27 + length5 + 23 + length6 + 22 + length7 + 16 + length8 + 13 + String.valueOf(strM2392toStringimpl).length() + 18 + String.valueOf(strM2436toStringimpl).length() + 1);
            sb.append("ExtendedApplicationLauncher(availableApplications=");
            sb.append(availableApplications);
            sb.append(", currentApplicationKey=");
            sb.append(currentApplicationKey);
            sb.append(", useGlobalApplicationCatalog=");
            sb.append(useGlobalApplicationCatalog);
            sb.append(", type=");
            sb.append(type);
            sb.append(", globalApplicationCatalog=");
            sb.append(globalApplicationCatalog);
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

        public /* synthetic */ ExtendedApplicationLauncher(List list, String str, Boolean bool, ApplicationType applicationType, List list2, List list3, List list4, List list5, int i, short s, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, str, bool, applicationType, list2, list3, list4, list5, i, s);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$InstallAppCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class InstallAppCommand implements CommandDescriptor {
        public static final InstallAppCommand INSTANCE = new InstallAppCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedApplicationLauncherTrait.INSTANCE.getId(), 0, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private InstallAppCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields extendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields : ExtendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields.values()) {
                if (extendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields extendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields : ExtendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields.name(), name)) {
                    return extendedApplicationLauncherTrait$InstallAppCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$LaunchAppCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class LaunchAppCommand implements CommandDescriptor {
        public static final LaunchAppCommand INSTANCE = new LaunchAppCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedApplicationLauncherTrait.INSTANCE.getId(), 2, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private LaunchAppCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields extendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields : ExtendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields.values()) {
                if (extendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields extendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields : ExtendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields.name(), name)) {
                    return extendedApplicationLauncherTrait$LaunchAppCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0017¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$SearchAppCommand;", "Lcom/google/home/CommandDescriptor;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getCommandRequestFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getCommandRequestFieldById", "", "name", "getCommandRequestFieldByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "Lcom/google/home/matter/serialization/ScopedCommandId;", "requestId", "Lcom/google/home/matter/serialization/ScopedCommandId;", "getRequestId", "()Lcom/google/home/matter/serialization/ScopedCommandId;", "commandId", "Ljava/lang/String;", "getCommandId", "()Ljava/lang/String;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SearchAppCommand implements CommandDescriptor {
        public static final SearchAppCommand INSTANCE = new SearchAppCommand();
        private static final String commandId;
        private static final ScopedCommandId requestId;

        static {
            ScopedCommandId scopedCommandId = new ScopedCommandId(ExtendedApplicationLauncherTrait.INSTANCE.getId(), 1, null);
            requestId = scopedCommandId;
            commandId = scopedCommandId.toString();
        }

        private SearchAppCommand() {
        }

        @Override // com.google.home.CommandDescriptor
        /* JADX INFO: renamed from: getCommandRequestFieldById-WZ4Q5Ns */
        public Field mo436getCommandRequestFieldByIdWZ4Q5Ns(int tagId) {
            for (ExtendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields extendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields : ExtendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields.values()) {
                if (extendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields.getTag() == tagId) {
                    return extendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields;
                }
            }
            return null;
        }

        @Override // com.google.home.CommandDescriptor
        public Field getCommandRequestFieldByName(String name) {
            name.getClass();
            for (ExtendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields extendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields : ExtendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields.values()) {
                if (Intrinsics.areEqual(extendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields.name(), name)) {
                    return extendedApplicationLauncherTrait$SearchAppCommand$Request$CommandFields;
                }
            }
            return null;
        }

        public final ScopedCommandId getRequestId() {
            return requestId;
        }
    }

    private ExtendedApplicationLauncherTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0002\u0012\u0013B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationNames;", "", "language", "", "nameSynonym", "", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getLanguage", "()Ljava/lang/String;", "getNameSynonym", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ApplicationNames {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String language;
        private final List<String> nameSynonym;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedApplicationLauncherTrait$ApplicationNames$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationNames$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationNames;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationNames;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationNames;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<ApplicationNames>, StructDescriptor {
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
            public ApplicationNames read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new ApplicationNames(payload$default.getString().mo546getqim9Vi0(0, "Language"), payload$default.getString().mo547getListqim9Vi0(1, "NameSynonym"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, ApplicationNames value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getLanguage());
                writer.getString().mo555writeListqim9Vi0(1, value.getNameSynonym());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationNames$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "language", "nameSynonym", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields language;
            public static final StructFields nameSynonym;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{language, nameSynonym};
            }

            static {
                Type type = Type.String;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                language = new StructFields("language", 0, 0, "String", type, noOpDescriptor, false);
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

        public /* synthetic */ ApplicationNames(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApplicationNames)) {
                return false;
            }
            ApplicationNames applicationNames = (ApplicationNames) other;
            return Intrinsics.areEqual(this.language, applicationNames.language) && Intrinsics.areEqual(this.nameSynonym, applicationNames.nameSynonym);
        }

        public final String getLanguage() {
            return this.language;
        }

        public final List<String> getNameSynonym() {
            return this.nameSynonym;
        }

        public int hashCode() {
            int iHashCode = this.language.hashCode() + 31;
            return this.nameSynonym.hashCode() + (iHashCode * 31);
        }

        public String toString() {
            return zzl.zza(this.nameSynonym, this.language, (byte) 40, "ApplicationNames(language=", ", nameSynonym=");
        }

        public ApplicationNames(String str, List<String> list) {
            str.getClass();
            list.getClass();
            this.language = str;
            this.nameSynonym = list;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication;", "", SDKConstants.PARAM_KEY, "", "names", "", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationNames;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getKey", "()Ljava/lang/String;", "getNames", "()Ljava/util/List;", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class AvailableApplication {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String key;
        private final List<ApplicationNames> names;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedApplicationLauncherTrait$AvailableApplication$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<AvailableApplication>, StructDescriptor {
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
            public AvailableApplication read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload = reader.readPayload(MapsKt.mapOf(TuplesKt.to(UInt.m2388boximpl(1), ApplicationNames.INSTANCE)));
                return new AvailableApplication(payload.getString().mo546getqim9Vi0(0, "Key"), new ClusterPayload.RawFieldReader(payload, (Function0) new Function0<ApplicationNames>() { // from class: com.google.home.google.ExtendedApplicationLauncherTrait$AvailableApplication$Adapter$read$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // kotlin.jvm.functions.Function0
                    public final ExtendedApplicationLauncherTrait.ApplicationNames invoke() {
                        return new ExtendedApplicationLauncherTrait.ApplicationNames(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
                    }
                }, Reflection.getOrCreateKotlinClass(ApplicationNames.class)).mo547getListqim9Vi0(1, "Names"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, AvailableApplication value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getKey());
                writer.struct(ApplicationNames.INSTANCE).mo555writeListqim9Vi0(1, value.getNames());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$AvailableApplication$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", SDKConstants.PARAM_KEY, "names", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields key = new StructFields(SDKConstants.PARAM_KEY, 0, 0, "String", Type.String, NoOpDescriptor.INSTANCE, false);
            public static final StructFields names = new StructFields("names", 1, 1, "ApplicationNames", Type.Struct, ApplicationNames.INSTANCE, false);
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

        public /* synthetic */ AvailableApplication(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(1 == (i & 1) ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AvailableApplication)) {
                return false;
            }
            AvailableApplication availableApplication = (AvailableApplication) other;
            return Intrinsics.areEqual(this.key, availableApplication.key) && Intrinsics.areEqual(this.names, availableApplication.names);
        }

        public final String getKey() {
            return this.key;
        }

        public final List<ApplicationNames> getNames() {
            return this.names;
        }

        public int hashCode() {
            int iHashCode = this.key.hashCode() + 31;
            return this.names.hashCode() + (iHashCode * 31);
        }

        public String toString() {
            return zzl.zza(this.names, this.key, (byte) 33, "AvailableApplication(key=", ", names=");
        }

        public AvailableApplication(String str, List<ApplicationNames> list) {
            str.getClass();
            list.getClass();
            this.key = str;
            this.names = list;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001\u0014B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;", "Lcom/google/home/matter/serialization/ClusterEnum;", "", SDKConstants.PARAM_VALUE, "Lkotlin/ULong;", "traitId", "", "typeName", "<init>", "(Ljava/lang/String;IJLjava/lang/String;Ljava/lang/String;)V", "getValue-s-VKNKU", "()J", "J", "getTraitId", "()Ljava/lang/String;", "getTypeName", "Unspecified", "Application", "Game", "UnknownValue", "Companion", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ApplicationType implements ClusterEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ApplicationType[] $VALUES;
        private static final EnumAdapter<ApplicationType> Adapter;
        public static final ApplicationType Application;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final ApplicationType Game;
        public static final ApplicationType UnknownValue;
        public static final ApplicationType Unspecified;
        private final String traitId;
        private final String typeName;
        private final long value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType$Companion;", "", "<init>", "()V", "Adapter", "Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/ExtendedApplicationLauncherTrait$ApplicationType;", "getAdapter", "()Lcom/google/home/matter/serialization/EnumAdapter;", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public final EnumAdapter<ApplicationType> getAdapter() {
                return ApplicationType.Adapter;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private static final /* synthetic */ ApplicationType[] $values() {
            return new ApplicationType[]{Unspecified, Application, Game, UnknownValue};
        }

        static {
            String str = null;
            Unspecified = new ApplicationType("Unspecified", 0, 0L, null, str, 6, null);
            String str2 = null;
            Application = new ApplicationType("Application", 1, 1L, str, str2, 6, null);
            String str3 = null;
            Game = new ApplicationType("Game", 2, 2L, str2, str3, 6, null);
            UnknownValue = new ApplicationType("UnknownValue", 3, -1L, str3, null, 6, null);
            ApplicationType[] applicationTypeArr$values = $values();
            $VALUES = applicationTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(applicationTypeArr$values);
            INSTANCE = new Companion(null);
            Adapter = new EnumAdapter<>(values());
        }

        public /* synthetic */ ApplicationType(String str, int i, long j, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, j, (i2 & 2) != 0 ? zza$$ExternalSyntheticOutline0.m(1611070469, (String) null, (String) null, 6, (DefaultConstructorMarker) null) : str2, (i2 & 4) != 0 ? "ApplicationType" : str3);
        }

        public static ApplicationType valueOf(String str) {
            return (ApplicationType) Enum.valueOf(ApplicationType.class, str);
        }

        public static ApplicationType[] values() {
            return (ApplicationType[]) $VALUES.clone();
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

        private ApplicationType(String str, int i, long j, String str2, String str3) {
            this.value = j;
            this.traitId = str2;
            this.typeName = str3;
        }
    }
}
