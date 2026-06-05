package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.Type;
import com.google.home.matter.MatterTrait;
import com.google.home.matter.MatterTraitClient;
import com.google.home.matter.MatterTraitFactory;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.standard.LevelControlTrait;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002\u0007\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/LevelControl;", "Lcom/google/home/matter/standard/LevelControlTrait$Attributes;", "Lcom/google/home/matter/MatterTrait;", "", "Lcom/google/home/matter/standard/LevelControlTrait$MutableAttributes;", "Lcom/google/home/matter/standard/LevelControlCommands;", "Companion", "Attribute", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface LevelControl extends LevelControlTrait.Attributes, MatterTrait, LevelControlCommands {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b%\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/¨\u00060"}, d2 = {"Lcom/google/home/matter/standard/LevelControl$Attribute;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "currentLevel", "remainingTime", "minLevel", "maxLevel", "currentFrequency", "minFrequency", "maxFrequency", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "onOffTransitionTime", "onLevel", "onTransitionTime", "offTransitionTime", "defaultMoveRate", "startUpCurrentLevel", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Attribute implements Field {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Attribute[] $VALUES;
        public static final Attribute acceptedCommandList;
        public static final Attribute attributeList;
        public static final Attribute clusterRevision;
        public static final Attribute currentFrequency;
        public static final Attribute currentLevel;
        public static final Attribute defaultMoveRate;
        public static final Attribute featureMap;
        public static final Attribute generatedCommandList;
        public static final Attribute maxFrequency;
        public static final Attribute maxLevel;
        public static final Attribute minFrequency;
        public static final Attribute minLevel;
        public static final Attribute offTransitionTime;
        public static final Attribute onLevel;
        public static final Attribute onOffTransitionTime;
        public static final Attribute onTransitionTime;
        public static final Attribute options;
        public static final Attribute remainingTime;
        public static final Attribute startUpCurrentLevel;
        private final Descriptor descriptor;
        private final boolean isNullable;
        private final int tag;
        private final Type typeEnum;
        private final String typeName;

        private static final /* synthetic */ Attribute[] $values() {
            return new Attribute[]{currentLevel, remainingTime, minLevel, maxLevel, currentFrequency, minFrequency, maxFrequency, options, onOffTransitionTime, onLevel, onTransitionTime, offTransitionTime, defaultMoveRate, startUpCurrentLevel, generatedCommandList, acceptedCommandList, attributeList, featureMap, clusterRevision};
        }

        static {
            Type type = Type.UByte;
            NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
            currentLevel = new Attribute("currentLevel", 0, 0, "UByte", type, noOpDescriptor, true);
            Type type2 = Type.UShort;
            remainingTime = new Attribute("remainingTime", 1, 1, "UShort", type2, noOpDescriptor, false);
            minLevel = new Attribute("minLevel", 2, 2, "UByte", type, noOpDescriptor, false);
            maxLevel = new Attribute("maxLevel", 3, 3, "UByte", type, noOpDescriptor, false);
            currentFrequency = new Attribute("currentFrequency", 4, 4, "UShort", type2, noOpDescriptor, false);
            minFrequency = new Attribute("minFrequency", 5, 5, "UShort", type2, noOpDescriptor, false);
            maxFrequency = new Attribute("maxFrequency", 6, 6, "UShort", type2, noOpDescriptor, false);
            Type type3 = Type.Bitmap;
            options = new Attribute(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, 7, 15, "OptionsBitmap", type3, noOpDescriptor, false);
            onOffTransitionTime = new Attribute("onOffTransitionTime", 8, 16, "UShort", type2, noOpDescriptor, false);
            onLevel = new Attribute("onLevel", 9, 17, "UByte", type, noOpDescriptor, true);
            onTransitionTime = new Attribute("onTransitionTime", 10, 18, "UShort", type2, noOpDescriptor, true);
            offTransitionTime = new Attribute("offTransitionTime", 11, 19, "UShort", type2, noOpDescriptor, true);
            defaultMoveRate = new Attribute("defaultMoveRate", 12, 20, "UByte", type, noOpDescriptor, true);
            startUpCurrentLevel = new Attribute("startUpCurrentLevel", 13, 16384, "UByte", type, noOpDescriptor, true);
            Type type4 = Type.UInt;
            generatedCommandList = new Attribute("generatedCommandList", 14, 65528, "UInt", type4, noOpDescriptor, false);
            acceptedCommandList = new Attribute("acceptedCommandList", 15, 65529, "UInt", type4, noOpDescriptor, false);
            attributeList = new Attribute("attributeList", 16, 65531, "UInt", type4, noOpDescriptor, false);
            featureMap = new Attribute("featureMap", 17, 65532, "Feature", type3, noOpDescriptor, false);
            clusterRevision = new Attribute("clusterRevision", 18, 65533, "UShort", type2, noOpDescriptor, false);
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/home/matter/standard/LevelControl$Companion;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/matter/standard/LevelControl;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getAttributeById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getAttributeById", "", "name", "getAttributeByName", "(Ljava/lang/String;)Lcom/google/home/Field;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends TraitFactory<LevelControl> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: com.google.home.matter.standard.LevelControl$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Trait.TraitMetadata, MatterTraitClient, LevelControlTrait.Attributes, LevelControlImpl> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(3, LevelControlImpl.class, "<init>", "<init>(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/LevelControlTrait$Attributes;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final LevelControlImpl invoke(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, LevelControlTrait.Attributes attributes) {
                traitMetadata.getClass();
                matterTraitClient.getClass();
                attributes.getClass();
                return new LevelControlImpl(traitMetadata, matterTraitClient, attributes);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Companion() {
            ClusterId id = LevelControlTrait.INSTANCE.getId();
            LevelControlTrait.Attributes.Companion companion = LevelControlTrait.Attributes.INSTANCE;
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("MoveModeEnum", LevelControlTrait.MoveModeEnum.INSTANCE.getAdapter()), TuplesKt.to("StepModeEnum", LevelControlTrait.StepModeEnum.INSTANCE.getAdapter()));
            Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("Feature", LevelControlTrait.Feature.INSTANCE), TuplesKt.to("OptionsBitmap", LevelControlTrait.OptionsBitmap.INSTANCE));
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            Map mapEmptyMap = MapsKt.emptyMap();
            LevelControlTrait.MoveToLevelCommand moveToLevelCommand = LevelControlTrait.MoveToLevelCommand.INSTANCE;
            Pair pair = TuplesKt.to(moveToLevelCommand.getRequestId().toString(), moveToLevelCommand);
            LevelControlTrait.MoveCommand moveCommand = LevelControlTrait.MoveCommand.INSTANCE;
            Pair pair2 = TuplesKt.to(moveCommand.getRequestId().toString(), moveCommand);
            LevelControlTrait.StepCommand stepCommand = LevelControlTrait.StepCommand.INSTANCE;
            Pair pair3 = TuplesKt.to(stepCommand.getRequestId().toString(), stepCommand);
            LevelControlTrait.StopCommand stopCommand = LevelControlTrait.StopCommand.INSTANCE;
            Pair pair4 = TuplesKt.to(stopCommand.getRequestId().toString(), stopCommand);
            LevelControlTrait.MoveToLevelWithOnOffCommand moveToLevelWithOnOffCommand = LevelControlTrait.MoveToLevelWithOnOffCommand.INSTANCE;
            Pair pair5 = TuplesKt.to(moveToLevelWithOnOffCommand.getRequestId().toString(), moveToLevelWithOnOffCommand);
            LevelControlTrait.MoveWithOnOffCommand moveWithOnOffCommand = LevelControlTrait.MoveWithOnOffCommand.INSTANCE;
            Pair pair6 = TuplesKt.to(moveWithOnOffCommand.getRequestId().toString(), moveWithOnOffCommand);
            LevelControlTrait.StepWithOnOffCommand stepWithOnOffCommand = LevelControlTrait.StepWithOnOffCommand.INSTANCE;
            Pair pair7 = TuplesKt.to(stepWithOnOffCommand.getRequestId().toString(), stepWithOnOffCommand);
            LevelControlTrait.StopWithOnOffCommand stopWithOnOffCommand = LevelControlTrait.StopWithOnOffCommand.INSTANCE;
            Pair pair8 = TuplesKt.to(stopWithOnOffCommand.getRequestId().toString(), stopWithOnOffCommand);
            LevelControlTrait.MoveToClosestFrequencyCommand moveToClosestFrequencyCommand = LevelControlTrait.MoveToClosestFrequencyCommand.INSTANCE;
            super(new MatterTraitFactory(id, companion, mapMapOf, mapMapOf2, anonymousClass1, mapEmptyMap, MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, TuplesKt.to(moveToClosestFrequencyCommand.getRequestId().toString(), moveToClosestFrequencyCommand))));
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

        public String toString() {
            return "LevelControl";
        }
    }
}
