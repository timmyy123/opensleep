package com.google.home.google;

import com.google.android.gms.internal.serialization.zzwr;
import com.google.home.platform.traits.ValidationResult;
import com.google.home.platform.traits.automation.AutomationEntityTrait;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u0000 #2\u00020\u0001:\u0001#R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\u000b\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\f8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u00148&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0012R\u0014\u0010\u001b\u001a\u00020\u00108&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0012R\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0004R \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001e8&X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006$À\u0006\u0001"}, d2 = {"com/google/home/google/AutomationEntityTrait$Attributes", "", "", "getIqsAutomationId", "()Ljava/lang/String;", "iqsAutomationId", "getStructureObjectId", "structureObjectId", "getName", "name", "getDescription", "description", "", "getAutomationGraph", "()[B", "automationGraph", "", "getValid", "()Z", "valid", "", "getValidationResults", "()Ljava/util/List;", "validationResults", "getActive", "active", "getManuallyExecutable", "manuallyExecutable", "getClientFeatureGroup", "clientFeatureGroup", "", "Lcom/google/protobuf/ByteString;", "getClientMetadata", "()Ljava/util/Map;", "clientMetadata", "Companion", "java.com.google.home.whdm.src.com.google.home.google_automation_entity_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface AutomationEntityTrait$Attributes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/google/home/google/AutomationEntityTrait$Attributes$Companion;", "Lcom/google/home/google/Parser;", "Lcom/google/home/google/AutomationEntityTrait$Attributes;", "<init>", "()V", "", "byteArray", "parseFrom", "([B)Lcom/google/home/google/AutomationEntityTrait$Attributes;", "java.com.google.home.whdm.src.com.google.home.google_automation_entity_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion implements Parser<AutomationEntityTrait$Attributes> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.home.google.Parser
        public AutomationEntityTrait$Attributes parseFrom(byte[] byteArray) {
            byteArray.getClass();
            AutomationEntityTrait from = AutomationEntityTrait.parseFrom(byteArray);
            from.getClass();
            final String clientFeatureGroup = from.hasClientFeatureGroup() ? from.getClientFeatureGroup() : null;
            final String iqsAutomationId = from.getIqsAutomationId();
            iqsAutomationId.getClass();
            final String structureObjectId = from.getStructureObjectId();
            structureObjectId.getClass();
            final String name = from.getName();
            name.getClass();
            final String description = from.getDescription();
            description.getClass();
            final byte[] byteArray2 = from.getAutomationGraph().toByteArray();
            byteArray2.getClass();
            final boolean valid = from.getValid();
            List<ValidationResult> validationResultsList = from.getValidationResultsList();
            validationResultsList.getClass();
            List<ValidationResult> list = validationResultsList;
            final ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                byte[] byteArray3 = ((ValidationResult) it.next()).toByteArray();
                byteArray3.getClass();
                arrayList.add(byteArray3);
            }
            final boolean active = from.getActive();
            final boolean manuallyExecutable = from.getManuallyExecutable();
            final Map<String, zzwr> clientMetadataMap = from.getClientMetadataMap();
            clientMetadataMap.getClass();
            return new AutomationEntityTrait$Attributes(iqsAutomationId, structureObjectId, name, description, byteArray2, valid, arrayList, active, manuallyExecutable, clientMetadataMap, clientFeatureGroup) { // from class: com.google.home.google.AutomationEntityTrait$AttributesImpl
                private final boolean active;
                private final byte[] automationGraph;
                private final String clientFeatureGroup;
                private final Map<String, zzwr> clientMetadata;
                private final String description;
                private final String iqsAutomationId;
                private final boolean manuallyExecutable;
                private final String name;
                private final String structureObjectId;
                private final boolean valid;
                private final List<byte[]> validationResults;

                /* JADX WARN: Multi-variable type inference failed */
                {
                    iqsAutomationId.getClass();
                    structureObjectId.getClass();
                    name.getClass();
                    description.getClass();
                    byteArray2.getClass();
                    arrayList.getClass();
                    clientMetadataMap.getClass();
                    this.iqsAutomationId = iqsAutomationId;
                    this.structureObjectId = structureObjectId;
                    this.name = name;
                    this.description = description;
                    this.automationGraph = byteArray2;
                    this.valid = valid;
                    this.validationResults = arrayList;
                    this.active = active;
                    this.manuallyExecutable = manuallyExecutable;
                    this.clientMetadata = clientMetadataMap;
                    this.clientFeatureGroup = clientFeatureGroup;
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof AutomationEntityTrait$AttributesImpl)) {
                        return false;
                    }
                    AutomationEntityTrait$AttributesImpl automationEntityTrait$AttributesImpl = (AutomationEntityTrait$AttributesImpl) other;
                    return Intrinsics.areEqual(getIqsAutomationId(), automationEntityTrait$AttributesImpl.getIqsAutomationId()) && Intrinsics.areEqual(getStructureObjectId(), automationEntityTrait$AttributesImpl.getStructureObjectId()) && Intrinsics.areEqual(getName(), automationEntityTrait$AttributesImpl.getName()) && Intrinsics.areEqual(getDescription(), automationEntityTrait$AttributesImpl.getDescription()) && Arrays.equals(getAutomationGraph(), automationEntityTrait$AttributesImpl.getAutomationGraph()) && getValid() == automationEntityTrait$AttributesImpl.getValid() && Intrinsics.areEqual(getValidationResults(), automationEntityTrait$AttributesImpl.getValidationResults()) && getActive() == automationEntityTrait$AttributesImpl.getActive() && getManuallyExecutable() == automationEntityTrait$AttributesImpl.getManuallyExecutable() && Intrinsics.areEqual(getClientMetadata(), automationEntityTrait$AttributesImpl.getClientMetadata()) && Intrinsics.areEqual(getClientFeatureGroup(), automationEntityTrait$AttributesImpl.getClientFeatureGroup());
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public boolean getActive() {
                    return this.active;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public byte[] getAutomationGraph() {
                    return this.automationGraph;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public String getClientFeatureGroup() {
                    return this.clientFeatureGroup;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public Map<String, zzwr> getClientMetadata() {
                    return this.clientMetadata;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public String getDescription() {
                    return this.description;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public String getIqsAutomationId() {
                    return this.iqsAutomationId;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public boolean getManuallyExecutable() {
                    return this.manuallyExecutable;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public String getName() {
                    return this.name;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public String getStructureObjectId() {
                    return this.structureObjectId;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public boolean getValid() {
                    return this.valid;
                }

                @Override // com.google.home.google.AutomationEntityTrait$Attributes
                public List<byte[]> getValidationResults() {
                    return this.validationResults;
                }

                public int hashCode() {
                    int iHashCode = ((((((((((((((((getStructureObjectId().hashCode() + (getIqsAutomationId().hashCode() * 31)) * 31) + getName().hashCode()) * 31) + getDescription().hashCode()) * 31) + Arrays.hashCode(getAutomationGraph())) * 31) + Boolean.hashCode(getValid())) * 31) + getValidationResults().hashCode()) * 31) + Boolean.hashCode(getActive())) * 31) + Boolean.hashCode(getManuallyExecutable())) * 31) + getClientMetadata().hashCode();
                    String clientFeatureGroup2 = getClientFeatureGroup();
                    return (iHashCode * 31) + (clientFeatureGroup2 != null ? clientFeatureGroup2.hashCode() : 0);
                }
            };
        }
    }

    boolean getActive();

    byte[] getAutomationGraph();

    String getClientFeatureGroup();

    Map<String, zzwr> getClientMetadata();

    String getDescription();

    String getIqsAutomationId();

    boolean getManuallyExecutable();

    String getName();

    String getStructureObjectId();

    boolean getValid();

    List<byte[]> getValidationResults();
}
