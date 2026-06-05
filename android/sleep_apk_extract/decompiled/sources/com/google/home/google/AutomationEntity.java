package com.google.home.google;

import com.google.android.gms.internal.serialization.zzwr;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B!\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u001b\u001a\u00020\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0014R\u0014\u0010\u001f\u001a\u00020\u001c8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001c0$8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010\"R\u0014\u0010+\u001a\u00020 8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010\"R\u0016\u0010-\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\u0014R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020/0.8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u00101¨\u00064"}, d2 = {"Lcom/google/home/google/AutomationEntity;", "Lcom/google/home/google/PlatformTrait;", "Lcom/google/home/google/AutomationEntityTrait$Attributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/google/PlatformTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/google/PlatformTraitClient;Lcom/google/home/google/AutomationEntityTrait$Attributes;)V", "Lcom/google/home/google/AutomationEntityTrait$Attributes;", "getAttributes$java_com_google_home_whdm_src_com_google_home_google_automation_entity_trait_android", "()Lcom/google/home/google/AutomationEntityTrait$Attributes;", "Lcom/google/home/TraitFactory;", "factory", "Lcom/google/home/TraitFactory;", "getFactory", "()Lcom/google/home/TraitFactory;", "", "getIqsAutomationId", "()Ljava/lang/String;", "iqsAutomationId", "getStructureObjectId", "structureObjectId", "getName", "name", "getDescription", "description", "", "getAutomationGraph", "()[B", "automationGraph", "", "getValid", "()Z", "valid", "", "getValidationResults", "()Ljava/util/List;", "validationResults", "getActive", "active", "getManuallyExecutable", "manuallyExecutable", "getClientFeatureGroup", "clientFeatureGroup", "", "Lcom/google/protobuf/ByteString;", "getClientMetadata", "()Ljava/util/Map;", "clientMetadata", "Companion", "java.com.google.home.whdm.src.com.google.home.google_automation_entity_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutomationEntity extends PlatformTrait implements AutomationEntityTrait$Attributes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final AutomationEntityTrait$Attributes attributes;
    private final TraitFactory<AutomationEntity> factory;

    private AutomationEntity(Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient, AutomationEntityTrait$Attributes automationEntityTrait$Attributes) {
        super(traitMetadata, platformTraitClient);
        this.attributes = automationEntityTrait$Attributes;
        this.factory = INSTANCE;
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public boolean getActive() {
        return this.attributes.getActive();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public byte[] getAutomationGraph() {
        return this.attributes.getAutomationGraph();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public String getClientFeatureGroup() {
        return this.attributes.getClientFeatureGroup();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public Map<String, zzwr> getClientMetadata() {
        return this.attributes.getClientMetadata();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public String getDescription() {
        return this.attributes.getDescription();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public String getIqsAutomationId() {
        return this.attributes.getIqsAutomationId();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public boolean getManuallyExecutable() {
        return this.attributes.getManuallyExecutable();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public String getName() {
        return this.attributes.getName();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public String getStructureObjectId() {
        return this.attributes.getStructureObjectId();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public boolean getValid() {
        return this.attributes.getValid();
    }

    @Override // com.google.home.google.AutomationEntityTrait$Attributes
    public List<byte[]> getValidationResults() {
        return this.attributes.getValidationResults();
    }

    public /* synthetic */ AutomationEntity(Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient, AutomationEntityTrait$Attributes automationEntityTrait$Attributes, DefaultConstructorMarker defaultConstructorMarker) {
        this(traitMetadata, platformTraitClient, automationEntityTrait$Attributes);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/google/home/google/AutomationEntity$Companion;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/google/AutomationEntity;", "<init>", "()V", "java.com.google.home.whdm.src.com.google.home.google_automation_entity_trait-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends TraitFactory<AutomationEntity> {

        /* JADX INFO: renamed from: com.google.home.google.AutomationEntity$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Trait.TraitMetadata, PlatformTraitClient, AutomationEntityTrait$Attributes, AutomationEntity> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(3, AutomationEntity.class, "<init>", "<init>(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/google/PlatformTraitClient;Lcom/google/home/google/AutomationEntityTrait$Attributes;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final AutomationEntity invoke(Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient, AutomationEntityTrait$Attributes automationEntityTrait$Attributes) {
                traitMetadata.getClass();
                platformTraitClient.getClass();
                automationEntityTrait$Attributes.getClass();
                return new AutomationEntity(traitMetadata, platformTraitClient, automationEntityTrait$Attributes, null);
            }
        }

        private Companion() {
            super(new PlatformTraitFactory("home.platform.traits.automation.AutomationEntityTrait", AutomationEntityTrait$Attributes.INSTANCE, MapsKt.emptyMap(), AnonymousClass1.INSTANCE, null, null, 48, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
