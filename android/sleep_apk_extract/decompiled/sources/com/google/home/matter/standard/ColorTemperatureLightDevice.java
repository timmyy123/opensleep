package com.google.home.matter.standard;

import com.android.billingclient.api.zzba$$ExternalSyntheticOutline0;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.HasEvents;
import com.google.home.Id;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.TraitProvider;
import com.google.home.google.ExtendedColorControl;
import com.google.home.google.LightEffects;
import com.google.home.matter.MatterDeviceTypeFactory;
import com.google.home.matter.standard.ColorControl;
import com.google.home.matter.standard.Identify;
import com.google.home.matter.standard.LevelControl;
import com.google.home.matter.standard.OnOff;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0004'()*B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/google/home/matter/standard/ColorTemperatureLightDevice;", "Lcom/google/home/DeviceType;", "Lcom/google/home/DeviceType$Metadata;", "metadata", "Lcom/google/home/TraitProvider;", "traitProvider", "Lcom/google/home/HasEvents;", "eventProvider", "Lcom/google/home/matter/standard/ColorTemperatureLightDevice$GoogleTraits;", "googleTraits", "Lcom/google/home/matter/standard/ColorTemperatureLightDevice$StandardTraits;", "standardTraits", "<init>", "(Lcom/google/home/DeviceType$Metadata;Lcom/google/home/TraitProvider;Lcom/google/home/HasEvents;Lcom/google/home/matter/standard/ColorTemperatureLightDevice$GoogleTraits;Lcom/google/home/matter/standard/ColorTemperatureLightDevice$StandardTraits;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/DeviceType$Metadata;", "getMetadata", "()Lcom/google/home/DeviceType$Metadata;", "Lcom/google/home/matter/standard/ColorTemperatureLightDevice$GoogleTraits;", "getGoogleTraits", "()Lcom/google/home/matter/standard/ColorTemperatureLightDevice$GoogleTraits;", "Lcom/google/home/matter/standard/ColorTemperatureLightDevice$StandardTraits;", "getStandardTraits", "()Lcom/google/home/matter/standard/ColorTemperatureLightDevice$StandardTraits;", "Lcom/google/home/DeviceTypeFactory;", "factory", "Lcom/google/home/DeviceTypeFactory;", "getFactory", "()Lcom/google/home/DeviceTypeFactory;", "Companion", "GoogleTraits", "StandardTraits", "Factory", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ColorTemperatureLightDevice extends DeviceType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DeviceTypeFactory<ColorTemperatureLightDevice> factory;
    private final GoogleTraits googleTraits;
    private final DeviceType.Metadata metadata;
    private final StandardTraits standardTraits;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/ColorTemperatureLightDevice$GoogleTraits;", "", "Lcom/google/home/google/LightEffects;", "lightEffects", "Lcom/google/home/google/ExtendedColorControl;", "extendedColorControl", "<init>", "(Lcom/google/home/google/LightEffects;Lcom/google/home/google/ExtendedColorControl;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/google/LightEffects;", "getLightEffects", "()Lcom/google/home/google/LightEffects;", "Lcom/google/home/google/ExtendedColorControl;", "getExtendedColorControl", "()Lcom/google/home/google/ExtendedColorControl;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GoogleTraits {
        private final ExtendedColorControl extendedColorControl;
        private final LightEffects lightEffects;

        public GoogleTraits(LightEffects lightEffects, ExtendedColorControl extendedColorControl) {
            this.lightEffects = lightEffects;
            this.extendedColorControl = extendedColorControl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoogleTraits)) {
                return false;
            }
            GoogleTraits googleTraits = (GoogleTraits) other;
            return Intrinsics.areEqual(this.lightEffects, googleTraits.lightEffects) && Intrinsics.areEqual(this.extendedColorControl, googleTraits.extendedColorControl);
        }

        public int hashCode() {
            LightEffects lightEffects = this.lightEffects;
            int iHashCode = lightEffects != null ? lightEffects.hashCode() : 0;
            ExtendedColorControl extendedColorControl = this.extendedColorControl;
            return iHashCode + 1 + (extendedColorControl != null ? extendedColorControl.hashCode() : 0);
        }

        public String toString() {
            return zze.zza(this.extendedColorControl, this.lightEffects, (byte) 2, (byte) 48, "GoogleTraits(lightEffects=", ",extendedColorControl=", ",)");
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!¨\u0006\""}, d2 = {"Lcom/google/home/matter/standard/ColorTemperatureLightDevice$StandardTraits;", "", "Lcom/google/home/matter/standard/Identify;", "identify", "Lcom/google/home/matter/standard/OnOff;", "onOff", "Lcom/google/home/matter/standard/LevelControl;", "levelControl", "Lcom/google/home/matter/standard/ColorControl;", "colorControl", "<init>", "(Lcom/google/home/matter/standard/Identify;Lcom/google/home/matter/standard/OnOff;Lcom/google/home/matter/standard/LevelControl;Lcom/google/home/matter/standard/ColorControl;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/matter/standard/Identify;", "getIdentify", "()Lcom/google/home/matter/standard/Identify;", "Lcom/google/home/matter/standard/OnOff;", "getOnOff", "()Lcom/google/home/matter/standard/OnOff;", "Lcom/google/home/matter/standard/LevelControl;", "getLevelControl", "()Lcom/google/home/matter/standard/LevelControl;", "Lcom/google/home/matter/standard/ColorControl;", "getColorControl", "()Lcom/google/home/matter/standard/ColorControl;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StandardTraits {
        private final ColorControl colorControl;
        private final Identify identify;
        private final LevelControl levelControl;
        private final OnOff onOff;

        public StandardTraits(Identify identify, OnOff onOff, LevelControl levelControl, ColorControl colorControl) {
            this.identify = identify;
            this.onOff = onOff;
            this.levelControl = levelControl;
            this.colorControl = colorControl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StandardTraits)) {
                return false;
            }
            StandardTraits standardTraits = (StandardTraits) other;
            return Intrinsics.areEqual(this.identify, standardTraits.identify) && Intrinsics.areEqual(this.onOff, standardTraits.onOff) && Intrinsics.areEqual(this.levelControl, standardTraits.levelControl) && Intrinsics.areEqual(this.colorControl, standardTraits.colorControl);
        }

        public final ColorControl getColorControl() {
            return this.colorControl;
        }

        public int hashCode() {
            Identify identify = this.identify;
            int iHashCode = identify != null ? identify.hashCode() : 0;
            OnOff onOff = this.onOff;
            int iHashCode2 = onOff != null ? onOff.hashCode() : 0;
            int i = iHashCode + 1;
            LevelControl levelControl = this.levelControl;
            int iHashCode3 = levelControl != null ? levelControl.hashCode() : 0;
            int i2 = i + iHashCode2;
            ColorControl colorControl = this.colorControl;
            return i2 + iHashCode3 + (colorControl != null ? colorControl.hashCode() : 0);
        }

        public String toString() {
            Identify identify = this.identify;
            int length = String.valueOf(identify).length();
            OnOff onOff = this.onOff;
            int length2 = String.valueOf(onOff).length();
            LevelControl levelControl = this.levelControl;
            int length3 = String.valueOf(levelControl).length();
            ColorControl colorControl = this.colorControl;
            return zzg.zza(colorControl, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 31, length2, 14, length3, 14, String.valueOf(colorControl).length()) + 2), levelControl, onOff, identify, "StandardTraits(identify=", ",onOff=", ",levelControl=", ",colorControl=", ",)");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ColorTemperatureLightDevice(DeviceType.Metadata metadata, TraitProvider traitProvider, HasEvents hasEvents, GoogleTraits googleTraits, StandardTraits standardTraits) {
        super(traitProvider, hasEvents);
        metadata.getClass();
        traitProvider.getClass();
        hasEvents.getClass();
        googleTraits.getClass();
        standardTraits.getClass();
        this.metadata = metadata;
        this.googleTraits = googleTraits;
        this.standardTraits = standardTraits;
        this.factory = INSTANCE;
    }

    @Override // com.google.home.DeviceType
    public boolean equals(Object other) {
        if (!super.equals(other)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorTemperatureLightDevice)) {
            return false;
        }
        ColorTemperatureLightDevice colorTemperatureLightDevice = (ColorTemperatureLightDevice) other;
        return Intrinsics.areEqual(this.googleTraits, colorTemperatureLightDevice.googleTraits) && Intrinsics.areEqual(this.standardTraits, colorTemperatureLightDevice.standardTraits) && Intrinsics.areEqual(colorTemperatureLightDevice.getMetadata(), getMetadata());
    }

    @Override // com.google.home.DeviceType
    public DeviceTypeFactory<ColorTemperatureLightDevice> getFactory() {
        return this.factory;
    }

    @Override // com.google.home.DeviceType
    public DeviceType.Metadata getMetadata() {
        return this.metadata;
    }

    public final StandardTraits getStandardTraits() {
        return this.standardTraits;
    }

    public int hashCode() {
        return this.standardTraits.hashCode() + this.googleTraits.hashCode() + 1;
    }

    public String toString() {
        DeviceType.Metadata metadata = getMetadata();
        int length = String.valueOf(metadata).length();
        GoogleTraits googleTraits = this.googleTraits;
        int length2 = String.valueOf(googleTraits).length();
        GoogleTraits googleTraits2 = this.googleTraits;
        int length3 = String.valueOf(googleTraits2).length();
        GoogleTraits googleTraits3 = this.googleTraits;
        int length4 = String.valueOf(googleTraits3).length();
        StandardTraits standardTraits = this.standardTraits;
        int length5 = String.valueOf(standardTraits).length();
        StandardTraits standardTraits2 = this.standardTraits;
        int length6 = String.valueOf(standardTraits2).length();
        StandardTraits standardTraits3 = this.standardTraits;
        int length7 = String.valueOf(standardTraits3).length();
        StandardTraits standardTraits4 = this.standardTraits;
        int length8 = String.valueOf(standardTraits4).length();
        StandardTraits standardTraits5 = this.standardTraits;
        return zzy.zza(standardTraits5, standardTraits4, standardTraits3, standardTraits2, standardTraits, googleTraits3, googleTraits2, googleTraits, new StringBuilder(length + 51 + length2 + 14 + length3 + 35 + length4 + 39 + length5 + 10 + length6 + 16 + length7 + 20 + length8 + 27 + String.valueOf(standardTraits5).length() + 17), metadata, "ColorTemperatureLightDevice(metadata=", ".extendedColorControl,),standardTraits=", ".lightEffects,extendedColorControl=", "(identify=", ".identify,onOff=", ".onOff,levelControl=", ".levelControl,colorControl=", ",googleTraits=", "(lightEffects=", ".colorControl,),)");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/google/home/matter/standard/ColorTemperatureLightDevice$Companion;", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/matter/standard/ColorTemperatureLightDevice;", "<init>", "()V", "TYPE_ID", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends DeviceTypeFactory<ColorTemperatureLightDevice> {
        private Companion() {
            super(Factory.INSTANCE);
        }

        public String toString() {
            return "matter.standard.type.ColorTemperatureLightDevice";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004JN\u0010\u0005\u001a\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/google/home/matter/standard/ColorTemperatureLightDevice$Factory;", "Lcom/google/home/matter/MatterDeviceTypeFactory;", "Lcom/google/home/matter/standard/ColorTemperatureLightDevice;", "<init>", "()V", "createType", "traits", "", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "metadataBuilder", "Lkotlin/Function1;", "", "Lcom/google/home/DeviceType$Metadata;", "traitProvider", "Lcom/google/home/TraitProvider;", "eventProvider", "Lcom/google/home/HasEvents;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory extends MatterDeviceTypeFactory<ColorTemperatureLightDevice> {
        public static final Factory INSTANCE = new Factory();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Factory() {
            super("home.matter.0000.types.010c", CollectionsKt.listOf((Object[]) new TraitFactory[]{Identify.INSTANCE, OnOff.INSTANCE, LevelControl.INSTANCE, ColorControl.INSTANCE, LightEffects.INSTANCE, ExtendedColorControl.INSTANCE}), null);
            Id.m441constructorimpl("home.matter.0000.types.010c");
        }

        @Override // com.google.home.matter.MatterDeviceTypeFactory
        public ColorTemperatureLightDevice createType(Map<TraitFactory<?>, ? extends Trait> traits, Function1<? super List<? extends Trait>, DeviceType.Metadata> metadataBuilder, TraitProvider traitProvider, HasEvents eventProvider) {
            traits.getClass();
            metadataBuilder.getClass();
            traitProvider.getClass();
            eventProvider.getClass();
            Identify.Companion companion = Identify.INSTANCE;
            Trait as = getAs(traits, companion);
            OnOff.Companion companion2 = OnOff.INSTANCE;
            Trait as2 = getAs(traits, companion2);
            LevelControl.Companion companion3 = LevelControl.INSTANCE;
            Trait as3 = getAs(traits, companion3);
            ColorControl.Companion companion4 = ColorControl.INSTANCE;
            Trait as4 = getAs(traits, companion4);
            LightEffects.Companion companion5 = LightEffects.INSTANCE;
            Trait as5 = getAs(traits, companion5);
            ExtendedColorControl.Companion companion6 = ExtendedColorControl.INSTANCE;
            return new ColorTemperatureLightDevice(metadataBuilder.invoke(CollectionsKt.listOfNotNull((Object[]) new Trait[]{as, as2, as3, as4, as5, getAs(traits, companion6)})), traitProvider, eventProvider, new GoogleTraits((LightEffects) getAs(traits, companion5), (ExtendedColorControl) getAs(traits, companion6)), new StandardTraits((Identify) getAs(traits, companion), (OnOff) getAs(traits, companion2), (LevelControl) getAs(traits, companion3), (ColorControl) getAs(traits, companion4)));
        }

        @Override // com.google.home.matter.MatterDeviceTypeFactory
        public /* bridge */ /* synthetic */ DeviceType createType(Map map, Function1 function1, TraitProvider traitProvider, HasEvents hasEvents) {
            return createType((Map<TraitFactory<?>, ? extends Trait>) map, (Function1<? super List<? extends Trait>, DeviceType.Metadata>) function1, traitProvider, hasEvents);
        }
    }
}
