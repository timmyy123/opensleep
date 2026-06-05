package com.google.home.google;

import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.Type;
import com.google.home.google.AutomationExecutionTrait$Attributes;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B!\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0007\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000b\u0010\fR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00000\r8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/google/home/google/AutomationExecution;", "Lcom/google/home/google/PlatformTrait;", "Lcom/google/home/google/AutomationExecutionTrait$Attributes;", "Lcom/google/home/Trait$TraitMetadata;", "metadata", "Lcom/google/home/google/PlatformTraitClient;", "client", "attributes", "<init>", "(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/google/PlatformTraitClient;Lcom/google/home/google/AutomationExecutionTrait$Attributes;)V", "Lcom/google/home/google/AutomationExecutionTrait$Attributes;", "getAttributes$home_platform_traits_automation_automation_execution_trait_kmp_library_android", "()Lcom/google/home/google/AutomationExecutionTrait$Attributes;", "Lcom/google/home/TraitFactory;", "factory", "Lcom/google/home/TraitFactory;", "getFactory", "()Lcom/google/home/TraitFactory;", "", "getRunning", "()Ljava/lang/Boolean;", "running", "Companion", "Attribute", "home.platform.traits.automation_automation_execution_trait_kmp_library-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AutomationExecution extends PlatformTrait implements AutomationExecutionTrait$Attributes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final com.google.home.automation.Attribute<Boolean> running = new com.google.home.automation.Attribute<>("home.platform.traits.automation.AutomationExecutionTrait", Attribute.running.getTag(), null);
    private final AutomationExecutionTrait$Attributes attributes;
    private final TraitFactory<AutomationExecution> factory;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/home/google/AutomationExecution$Attribute;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "running", "home.platform.traits.automation_automation_execution_trait_kmp_library-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Attribute implements Field {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Attribute[] $VALUES;
        public static final Attribute running = new Attribute("running", 0, 1, "Boolean", Type.Boolean, NoOpDescriptor.INSTANCE, false);
        private final Descriptor descriptor;
        private final boolean isNullable;
        private final int tag;
        private final Type typeEnum;
        private final String typeName;

        private static final /* synthetic */ Attribute[] $values() {
            return new Attribute[]{running};
        }

        static {
            Attribute[] attributeArr$values = $values();
            $VALUES = attributeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(attributeArr$values);
        }

        private Attribute(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
            this.tag = i2;
            this.typeName = str2;
            this.typeEnum = type;
            this.descriptor = descriptor;
            this.isNullable = z;
        }

        public static Attribute valueOf(String str) {
            return (Attribute) Enum.valueOf(Attribute.class, str);
        }

        public static Attribute[] values() {
            return (Attribute[]) $VALUES.clone();
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

    private AutomationExecution(Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient, AutomationExecutionTrait$Attributes automationExecutionTrait$Attributes) {
        super(traitMetadata, platformTraitClient);
        this.attributes = automationExecutionTrait$Attributes;
        this.factory = INSTANCE;
    }

    @Override // com.google.home.google.AutomationExecutionTrait$Attributes
    public Boolean getRunning() {
        return this.attributes.getRunning();
    }

    public /* synthetic */ AutomationExecution(Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient, AutomationExecutionTrait$Attributes automationExecutionTrait$Attributes, DefaultConstructorMarker defaultConstructorMarker) {
        this(traitMetadata, platformTraitClient, automationExecutionTrait$Attributes);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/google/home/google/AutomationExecution$Companion;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/google/AutomationExecution;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getAttributeById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getAttributeById", "", "name", "getAttributeByName", "(Ljava/lang/String;)Lcom/google/home/Field;", "home.platform.traits.automation_automation_execution_trait_kmp_library-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends TraitFactory<AutomationExecution> {

        /* JADX INFO: renamed from: com.google.home.google.AutomationExecution$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Trait.TraitMetadata, PlatformTraitClient, AutomationExecutionTrait$Attributes, AutomationExecution> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(3, AutomationExecution.class, "<init>", "<init>(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/google/PlatformTraitClient;Lcom/google/home/google/AutomationExecutionTrait$Attributes;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final AutomationExecution invoke(Trait.TraitMetadata traitMetadata, PlatformTraitClient platformTraitClient, AutomationExecutionTrait$Attributes automationExecutionTrait$Attributes) {
                traitMetadata.getClass();
                platformTraitClient.getClass();
                automationExecutionTrait$Attributes.getClass();
                return new AutomationExecution(traitMetadata, platformTraitClient, automationExecutionTrait$Attributes, null);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Companion() {
            AutomationExecutionTrait$Attributes.Companion companion = AutomationExecutionTrait$Attributes.INSTANCE;
            Map mapEmptyMap = MapsKt.emptyMap();
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            Map mapEmptyMap2 = MapsKt.emptyMap();
            AutomationExecutionTrait$ExecuteAutomationCommand automationExecutionTrait$ExecuteAutomationCommand = AutomationExecutionTrait$ExecuteAutomationCommand.INSTANCE;
            Pair pair = TuplesKt.to(automationExecutionTrait$ExecuteAutomationCommand.getCommandId(), automationExecutionTrait$ExecuteAutomationCommand);
            AutomationExecutionTrait$StopAutomationCommand automationExecutionTrait$StopAutomationCommand = AutomationExecutionTrait$StopAutomationCommand.INSTANCE;
            super(new PlatformTraitFactory("home.platform.traits.automation.AutomationExecutionTrait", companion, mapEmptyMap, anonymousClass1, mapEmptyMap2, MapsKt.mapOf(pair, TuplesKt.to(automationExecutionTrait$StopAutomationCommand.getCommandId(), automationExecutionTrait$StopAutomationCommand))));
        }

        @Override // com.google.home.TraitFactory
        /* JADX INFO: renamed from: getAttributeById-WZ4Q5Ns */
        public Field mo449getAttributeByIdWZ4Q5Ns(int tagId) {
            for (Attribute attribute : Attribute.values()) {
                if (attribute.getTag() == tagId) {
                    return attribute;
                }
            }
            return null;
        }

        @Override // com.google.home.TraitFactory
        public Field getAttributeByName(String name) {
            name.getClass();
            for (Attribute attribute : Attribute.values()) {
                if (Intrinsics.areEqual(attribute.name(), name)) {
                    return attribute;
                }
            }
            return null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
