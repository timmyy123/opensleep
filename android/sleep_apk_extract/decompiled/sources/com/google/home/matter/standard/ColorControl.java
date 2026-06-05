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
import com.google.home.matter.standard.ColorControlTrait;
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
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u00062\u00020\u00012\u00020\u00022\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005:\u0002\u0007\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/google/home/matter/standard/ColorControl;", "Lcom/google/home/matter/standard/ColorControlTrait$Attributes;", "Lcom/google/home/matter/MatterTrait;", "", "Lcom/google/home/matter/standard/ColorControlTrait$MutableAttributes;", "Lcom/google/home/matter/standard/ColorControlCommands;", "Companion", "Attribute", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ColorControl extends ColorControlTrait.Attributes, MatterTrait, ColorControlCommands {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bK\b\u0086\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bU¨\u0006V"}, d2 = {"Lcom/google/home/matter/standard/ColorControl$Attribute;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "currentHue", "currentSaturation", "remainingTime", "currentX", "currentY", "driftCompensation", "compensationText", "colorTemperatureMireds", "colorMode", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "numberOfPrimaries", "primary1X", "primary1Y", "primary1Intensity", "primary2X", "primary2Y", "primary2Intensity", "primary3X", "primary3Y", "primary3Intensity", "primary4X", "primary4Y", "primary4Intensity", "primary5X", "primary5Y", "primary5Intensity", "primary6X", "primary6Y", "primary6Intensity", "whitePointX", "whitePointY", "colorPointRx", "colorPointRy", "colorPointRIntensity", "colorPointGx", "colorPointGy", "colorPointGIntensity", "colorPointBx", "colorPointBy", "colorPointBIntensity", "enhancedCurrentHue", "enhancedColorMode", "colorLoopActive", "colorLoopDirection", "colorLoopTime", "colorLoopStartEnhancedHue", "colorLoopStoredEnhancedHue", "colorCapabilities", "colorTempPhysicalMinMireds", "colorTempPhysicalMaxMireds", "coupleColorTempToLevelMinMireds", "startUpColorTemperatureMireds", "generatedCommandList", "acceptedCommandList", "attributeList", "featureMap", "clusterRevision", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Attribute implements Field {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Attribute[] $VALUES;
        public static final Attribute acceptedCommandList;
        public static final Attribute attributeList;
        public static final Attribute clusterRevision;
        public static final Attribute colorCapabilities;
        public static final Attribute colorLoopActive;
        public static final Attribute colorLoopDirection;
        public static final Attribute colorLoopStartEnhancedHue;
        public static final Attribute colorLoopStoredEnhancedHue;
        public static final Attribute colorLoopTime;
        public static final Attribute colorMode;
        public static final Attribute colorPointBIntensity;
        public static final Attribute colorPointBx;
        public static final Attribute colorPointBy;
        public static final Attribute colorPointGIntensity;
        public static final Attribute colorPointGx;
        public static final Attribute colorPointGy;
        public static final Attribute colorPointRIntensity;
        public static final Attribute colorPointRx;
        public static final Attribute colorPointRy;
        public static final Attribute colorTempPhysicalMaxMireds;
        public static final Attribute colorTempPhysicalMinMireds;
        public static final Attribute colorTemperatureMireds;
        public static final Attribute compensationText;
        public static final Attribute coupleColorTempToLevelMinMireds;
        public static final Attribute currentHue;
        public static final Attribute currentSaturation;
        public static final Attribute currentX;
        public static final Attribute currentY;
        public static final Attribute driftCompensation;
        public static final Attribute enhancedColorMode;
        public static final Attribute enhancedCurrentHue;
        public static final Attribute featureMap;
        public static final Attribute generatedCommandList;
        public static final Attribute numberOfPrimaries;
        public static final Attribute options;
        public static final Attribute primary1Intensity;
        public static final Attribute primary1X;
        public static final Attribute primary1Y;
        public static final Attribute primary2Intensity;
        public static final Attribute primary2X;
        public static final Attribute primary2Y;
        public static final Attribute primary3Intensity;
        public static final Attribute primary3X;
        public static final Attribute primary3Y;
        public static final Attribute primary4Intensity;
        public static final Attribute primary4X;
        public static final Attribute primary4Y;
        public static final Attribute primary5Intensity;
        public static final Attribute primary5X;
        public static final Attribute primary5Y;
        public static final Attribute primary6Intensity;
        public static final Attribute primary6X;
        public static final Attribute primary6Y;
        public static final Attribute remainingTime;
        public static final Attribute startUpColorTemperatureMireds;
        public static final Attribute whitePointX;
        public static final Attribute whitePointY;
        private final Descriptor descriptor;
        private final boolean isNullable;
        private final int tag;
        private final Type typeEnum;
        private final String typeName;

        private static final /* synthetic */ Attribute[] $values() {
            return new Attribute[]{currentHue, currentSaturation, remainingTime, currentX, currentY, driftCompensation, compensationText, colorTemperatureMireds, colorMode, options, numberOfPrimaries, primary1X, primary1Y, primary1Intensity, primary2X, primary2Y, primary2Intensity, primary3X, primary3Y, primary3Intensity, primary4X, primary4Y, primary4Intensity, primary5X, primary5Y, primary5Intensity, primary6X, primary6Y, primary6Intensity, whitePointX, whitePointY, colorPointRx, colorPointRy, colorPointRIntensity, colorPointGx, colorPointGy, colorPointGIntensity, colorPointBx, colorPointBy, colorPointBIntensity, enhancedCurrentHue, enhancedColorMode, colorLoopActive, colorLoopDirection, colorLoopTime, colorLoopStartEnhancedHue, colorLoopStoredEnhancedHue, colorCapabilities, colorTempPhysicalMinMireds, colorTempPhysicalMaxMireds, coupleColorTempToLevelMinMireds, startUpColorTemperatureMireds, generatedCommandList, acceptedCommandList, attributeList, featureMap, clusterRevision};
        }

        static {
            Type type = Type.UByte;
            NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
            currentHue = new Attribute("currentHue", 0, 0, "UByte", type, noOpDescriptor, false);
            currentSaturation = new Attribute("currentSaturation", 1, 1, "UByte", type, noOpDescriptor, false);
            Type type2 = Type.UShort;
            remainingTime = new Attribute("remainingTime", 2, 2, "UShort", type2, noOpDescriptor, false);
            currentX = new Attribute("currentX", 3, 3, "UShort", type2, noOpDescriptor, false);
            currentY = new Attribute("currentY", 4, 4, "UShort", type2, noOpDescriptor, false);
            driftCompensation = new Attribute("driftCompensation", 5, 5, "UByte", type, noOpDescriptor, false);
            compensationText = new Attribute("compensationText", 6, 6, "String", Type.String, noOpDescriptor, false);
            colorTemperatureMireds = new Attribute("colorTemperatureMireds", 7, 7, "UShort", type2, noOpDescriptor, false);
            colorMode = new Attribute("colorMode", 8, 8, "UByte", type, noOpDescriptor, false);
            options = new Attribute(SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, 9, 15, "UByte", type, noOpDescriptor, false);
            numberOfPrimaries = new Attribute("numberOfPrimaries", 10, 16, "UByte", type, noOpDescriptor, true);
            primary1X = new Attribute("primary1X", 11, 17, "UShort", type2, noOpDescriptor, false);
            primary1Y = new Attribute("primary1Y", 12, 18, "UShort", type2, noOpDescriptor, false);
            primary1Intensity = new Attribute("primary1Intensity", 13, 19, "UByte", type, noOpDescriptor, true);
            primary2X = new Attribute("primary2X", 14, 21, "UShort", type2, noOpDescriptor, false);
            primary2Y = new Attribute("primary2Y", 15, 22, "UShort", type2, noOpDescriptor, false);
            primary2Intensity = new Attribute("primary2Intensity", 16, 23, "UByte", type, noOpDescriptor, true);
            primary3X = new Attribute("primary3X", 17, 25, "UShort", type2, noOpDescriptor, false);
            primary3Y = new Attribute("primary3Y", 18, 26, "UShort", type2, noOpDescriptor, false);
            primary3Intensity = new Attribute("primary3Intensity", 19, 27, "UByte", type, noOpDescriptor, true);
            primary4X = new Attribute("primary4X", 20, 32, "UShort", type2, noOpDescriptor, false);
            primary4Y = new Attribute("primary4Y", 21, 33, "UShort", type2, noOpDescriptor, false);
            primary4Intensity = new Attribute("primary4Intensity", 22, 34, "UByte", type, noOpDescriptor, true);
            primary5X = new Attribute("primary5X", 23, 36, "UShort", type2, noOpDescriptor, false);
            primary5Y = new Attribute("primary5Y", 24, 37, "UShort", type2, noOpDescriptor, false);
            primary5Intensity = new Attribute("primary5Intensity", 25, 38, "UByte", type, noOpDescriptor, true);
            primary6X = new Attribute("primary6X", 26, 40, "UShort", type2, noOpDescriptor, false);
            primary6Y = new Attribute("primary6Y", 27, 41, "UShort", type2, noOpDescriptor, false);
            primary6Intensity = new Attribute("primary6Intensity", 28, 42, "UByte", type, noOpDescriptor, true);
            whitePointX = new Attribute("whitePointX", 29, 48, "UShort", type2, noOpDescriptor, false);
            whitePointY = new Attribute("whitePointY", 30, 49, "UShort", type2, noOpDescriptor, false);
            colorPointRx = new Attribute("colorPointRx", 31, 50, "UShort", type2, noOpDescriptor, false);
            colorPointRy = new Attribute("colorPointRy", 32, 51, "UShort", type2, noOpDescriptor, false);
            colorPointRIntensity = new Attribute("colorPointRIntensity", 33, 52, "UByte", type, noOpDescriptor, true);
            colorPointGx = new Attribute("colorPointGx", 34, 54, "UShort", type2, noOpDescriptor, false);
            colorPointGy = new Attribute("colorPointGy", 35, 55, "UShort", type2, noOpDescriptor, false);
            colorPointGIntensity = new Attribute("colorPointGIntensity", 36, 56, "UByte", type, noOpDescriptor, true);
            colorPointBx = new Attribute("colorPointBx", 37, 58, "UShort", type2, noOpDescriptor, false);
            colorPointBy = new Attribute("colorPointBy", 38, 59, "UShort", type2, noOpDescriptor, false);
            colorPointBIntensity = new Attribute("colorPointBIntensity", 39, 60, "UByte", type, noOpDescriptor, true);
            enhancedCurrentHue = new Attribute("enhancedCurrentHue", 40, 16384, "UShort", type2, noOpDescriptor, false);
            enhancedColorMode = new Attribute("enhancedColorMode", 41, 16385, "UByte", type, noOpDescriptor, false);
            colorLoopActive = new Attribute("colorLoopActive", 42, 16386, "UByte", type, noOpDescriptor, false);
            colorLoopDirection = new Attribute("colorLoopDirection", 43, 16387, "UByte", type, noOpDescriptor, false);
            colorLoopTime = new Attribute("colorLoopTime", 44, 16388, "UShort", type2, noOpDescriptor, false);
            colorLoopStartEnhancedHue = new Attribute("colorLoopStartEnhancedHue", 45, 16389, "UShort", type2, noOpDescriptor, false);
            colorLoopStoredEnhancedHue = new Attribute("colorLoopStoredEnhancedHue", 46, 16390, "UShort", type2, noOpDescriptor, false);
            colorCapabilities = new Attribute("colorCapabilities", 47, 16394, "UShort", type2, noOpDescriptor, false);
            colorTempPhysicalMinMireds = new Attribute("colorTempPhysicalMinMireds", 48, 16395, "UShort", type2, noOpDescriptor, false);
            colorTempPhysicalMaxMireds = new Attribute("colorTempPhysicalMaxMireds", 49, 16396, "UShort", type2, noOpDescriptor, false);
            coupleColorTempToLevelMinMireds = new Attribute("coupleColorTempToLevelMinMireds", 50, 16397, "UShort", type2, noOpDescriptor, false);
            startUpColorTemperatureMireds = new Attribute("startUpColorTemperatureMireds", 51, 16400, "UShort", type2, noOpDescriptor, true);
            Type type3 = Type.UInt;
            generatedCommandList = new Attribute("generatedCommandList", 52, 65528, "UInt", type3, noOpDescriptor, false);
            acceptedCommandList = new Attribute("acceptedCommandList", 53, 65529, "UInt", type3, noOpDescriptor, false);
            attributeList = new Attribute("attributeList", 54, 65531, "UInt", type3, noOpDescriptor, false);
            featureMap = new Attribute("featureMap", 55, 65532, "Feature", Type.Bitmap, noOpDescriptor, false);
            clusterRevision = new Attribute("clusterRevision", 56, 65533, "UShort", type2, noOpDescriptor, false);
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0017¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/google/home/matter/standard/ColorControl$Companion;", "Lcom/google/home/TraitFactory;", "Lcom/google/home/matter/standard/ColorControl;", "<init>", "()V", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getAttributeById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getAttributeById", "", "name", "getAttributeByName", "(Ljava/lang/String;)Lcom/google/home/Field;", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "java.com.google.home.matter.standard_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends TraitFactory<ColorControl> {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        /* JADX INFO: renamed from: com.google.home.matter.standard.ColorControl$Companion$1, reason: invalid class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function3<Trait.TraitMetadata, MatterTraitClient, ColorControlTrait.Attributes, ColorControlImpl> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(3, ColorControlImpl.class, "<init>", "<init>(Lcom/google/home/Trait$TraitMetadata;Lcom/google/home/matter/MatterTraitClient;Lcom/google/home/matter/standard/ColorControlTrait$Attributes;)V", 0);
            }

            @Override // kotlin.jvm.functions.Function3
            public final ColorControlImpl invoke(Trait.TraitMetadata traitMetadata, MatterTraitClient matterTraitClient, ColorControlTrait.Attributes attributes) {
                traitMetadata.getClass();
                matterTraitClient.getClass();
                attributes.getClass();
                return new ColorControlImpl(traitMetadata, matterTraitClient, attributes);
            }
        }

        /* JADX WARN: Illegal instructions before constructor call */
        private Companion() {
            ClusterId id = ColorControlTrait.INSTANCE.getId();
            ColorControlTrait.Attributes.Companion companion = ColorControlTrait.Attributes.INSTANCE;
            Map mapMapOf = MapsKt.mapOf(TuplesKt.to("ColorLoopAction", ColorControlTrait.ColorLoopAction.INSTANCE.getAdapter()), TuplesKt.to("ColorLoopDirection", ColorControlTrait.ColorLoopDirection.INSTANCE.getAdapter()), TuplesKt.to("ColorMode", ColorControlTrait.ColorMode.INSTANCE.getAdapter()), TuplesKt.to("HueDirection", ColorControlTrait.HueDirection.INSTANCE.getAdapter()), TuplesKt.to("HueMoveMode", ColorControlTrait.HueMoveMode.INSTANCE.getAdapter()), TuplesKt.to("HueStepMode", ColorControlTrait.HueStepMode.INSTANCE.getAdapter()), TuplesKt.to("SaturationMoveMode", ColorControlTrait.SaturationMoveMode.INSTANCE.getAdapter()), TuplesKt.to("SaturationStepMode", ColorControlTrait.SaturationStepMode.INSTANCE.getAdapter()));
            Map mapMapOf2 = MapsKt.mapOf(TuplesKt.to("ColorCapabilities", ColorControlTrait.ColorCapabilities.INSTANCE), TuplesKt.to("ColorLoopUpdateFlags", ColorControlTrait.ColorLoopUpdateFlags.INSTANCE), TuplesKt.to("Feature", ColorControlTrait.Feature.INSTANCE));
            AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
            Map mapEmptyMap = MapsKt.emptyMap();
            ColorControlTrait.MoveToHueCommand moveToHueCommand = ColorControlTrait.MoveToHueCommand.INSTANCE;
            Pair pair = TuplesKt.to(moveToHueCommand.getRequestId().toString(), moveToHueCommand);
            ColorControlTrait.MoveHueCommand moveHueCommand = ColorControlTrait.MoveHueCommand.INSTANCE;
            Pair pair2 = TuplesKt.to(moveHueCommand.getRequestId().toString(), moveHueCommand);
            ColorControlTrait.StepHueCommand stepHueCommand = ColorControlTrait.StepHueCommand.INSTANCE;
            Pair pair3 = TuplesKt.to(stepHueCommand.getRequestId().toString(), stepHueCommand);
            ColorControlTrait.MoveToSaturationCommand moveToSaturationCommand = ColorControlTrait.MoveToSaturationCommand.INSTANCE;
            Pair pair4 = TuplesKt.to(moveToSaturationCommand.getRequestId().toString(), moveToSaturationCommand);
            ColorControlTrait.MoveSaturationCommand moveSaturationCommand = ColorControlTrait.MoveSaturationCommand.INSTANCE;
            Pair pair5 = TuplesKt.to(moveSaturationCommand.getRequestId().toString(), moveSaturationCommand);
            ColorControlTrait.StepSaturationCommand stepSaturationCommand = ColorControlTrait.StepSaturationCommand.INSTANCE;
            Pair pair6 = TuplesKt.to(stepSaturationCommand.getRequestId().toString(), stepSaturationCommand);
            ColorControlTrait.MoveToHueAndSaturationCommand moveToHueAndSaturationCommand = ColorControlTrait.MoveToHueAndSaturationCommand.INSTANCE;
            Pair pair7 = TuplesKt.to(moveToHueAndSaturationCommand.getRequestId().toString(), moveToHueAndSaturationCommand);
            ColorControlTrait.MoveToColorCommand moveToColorCommand = ColorControlTrait.MoveToColorCommand.INSTANCE;
            Pair pair8 = TuplesKt.to(moveToColorCommand.getRequestId().toString(), moveToColorCommand);
            ColorControlTrait.MoveColorCommand moveColorCommand = ColorControlTrait.MoveColorCommand.INSTANCE;
            Pair pair9 = TuplesKt.to(moveColorCommand.getRequestId().toString(), moveColorCommand);
            ColorControlTrait.StepColorCommand stepColorCommand = ColorControlTrait.StepColorCommand.INSTANCE;
            Pair pair10 = TuplesKt.to(stepColorCommand.getRequestId().toString(), stepColorCommand);
            ColorControlTrait.MoveToColorTemperatureCommand moveToColorTemperatureCommand = ColorControlTrait.MoveToColorTemperatureCommand.INSTANCE;
            Pair pair11 = TuplesKt.to(moveToColorTemperatureCommand.getRequestId().toString(), moveToColorTemperatureCommand);
            ColorControlTrait.EnhancedMoveToHueCommand enhancedMoveToHueCommand = ColorControlTrait.EnhancedMoveToHueCommand.INSTANCE;
            Pair pair12 = TuplesKt.to(enhancedMoveToHueCommand.getRequestId().toString(), enhancedMoveToHueCommand);
            ColorControlTrait.EnhancedMoveHueCommand enhancedMoveHueCommand = ColorControlTrait.EnhancedMoveHueCommand.INSTANCE;
            Pair pair13 = TuplesKt.to(enhancedMoveHueCommand.getRequestId().toString(), enhancedMoveHueCommand);
            ColorControlTrait.EnhancedStepHueCommand enhancedStepHueCommand = ColorControlTrait.EnhancedStepHueCommand.INSTANCE;
            Pair pair14 = TuplesKt.to(enhancedStepHueCommand.getRequestId().toString(), enhancedStepHueCommand);
            ColorControlTrait.EnhancedMoveToHueAndSaturationCommand enhancedMoveToHueAndSaturationCommand = ColorControlTrait.EnhancedMoveToHueAndSaturationCommand.INSTANCE;
            Pair pair15 = TuplesKt.to(enhancedMoveToHueAndSaturationCommand.getRequestId().toString(), enhancedMoveToHueAndSaturationCommand);
            ColorControlTrait.ColorLoopSetCommand colorLoopSetCommand = ColorControlTrait.ColorLoopSetCommand.INSTANCE;
            Pair pair16 = TuplesKt.to(colorLoopSetCommand.getRequestId().toString(), colorLoopSetCommand);
            ColorControlTrait.StopMoveStepCommand stopMoveStepCommand = ColorControlTrait.StopMoveStepCommand.INSTANCE;
            Pair pair17 = TuplesKt.to(stopMoveStepCommand.getRequestId().toString(), stopMoveStepCommand);
            ColorControlTrait.MoveColorTemperatureCommand moveColorTemperatureCommand = ColorControlTrait.MoveColorTemperatureCommand.INSTANCE;
            Pair pair18 = TuplesKt.to(moveColorTemperatureCommand.getRequestId().toString(), moveColorTemperatureCommand);
            ColorControlTrait.StepColorTemperatureCommand stepColorTemperatureCommand = ColorControlTrait.StepColorTemperatureCommand.INSTANCE;
            super(new MatterTraitFactory(id, companion, mapMapOf, mapMapOf2, anonymousClass1, mapEmptyMap, MapsKt.mapOf(pair, pair2, pair3, pair4, pair5, pair6, pair7, pair8, pair9, pair10, pair11, pair12, pair13, pair14, pair15, pair16, pair17, pair18, TuplesKt.to(stepColorTemperatureCommand.getRequestId().toString(), stepColorTemperatureCommand))));
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
            return "ColorControl";
        }
    }
}
