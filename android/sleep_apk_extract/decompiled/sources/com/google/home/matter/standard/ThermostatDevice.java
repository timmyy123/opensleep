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
import com.google.home.google.ExtendedThermostat;
import com.google.home.matter.MatterDeviceTypeFactory;
import com.google.home.matter.standard.Identify;
import com.google.home.matter.standard.Thermostat;
import com.google.home.matter.standard.ThermostatUserInterfaceConfiguration;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0004'()*B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/google/home/matter/standard/ThermostatDevice;", "Lcom/google/home/DeviceType;", "Lcom/google/home/DeviceType$Metadata;", "metadata", "Lcom/google/home/TraitProvider;", "traitProvider", "Lcom/google/home/HasEvents;", "eventProvider", "Lcom/google/home/matter/standard/ThermostatDevice$GoogleTraits;", "googleTraits", "Lcom/google/home/matter/standard/ThermostatDevice$StandardTraits;", "standardTraits", "<init>", "(Lcom/google/home/DeviceType$Metadata;Lcom/google/home/TraitProvider;Lcom/google/home/HasEvents;Lcom/google/home/matter/standard/ThermostatDevice$GoogleTraits;Lcom/google/home/matter/standard/ThermostatDevice$StandardTraits;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/DeviceType$Metadata;", "getMetadata", "()Lcom/google/home/DeviceType$Metadata;", "Lcom/google/home/matter/standard/ThermostatDevice$GoogleTraits;", "getGoogleTraits", "()Lcom/google/home/matter/standard/ThermostatDevice$GoogleTraits;", "Lcom/google/home/matter/standard/ThermostatDevice$StandardTraits;", "getStandardTraits", "()Lcom/google/home/matter/standard/ThermostatDevice$StandardTraits;", "Lcom/google/home/DeviceTypeFactory;", "factory", "Lcom/google/home/DeviceTypeFactory;", "getFactory", "()Lcom/google/home/DeviceTypeFactory;", "Companion", "GoogleTraits", "StandardTraits", "Factory", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ThermostatDevice extends DeviceType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DeviceTypeFactory<ThermostatDevice> factory;
    private final GoogleTraits googleTraits;
    private final DeviceType.Metadata metadata;
    private final StandardTraits standardTraits;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/google/home/matter/standard/ThermostatDevice$GoogleTraits;", "", "Lcom/google/home/google/ExtendedThermostat;", "extendedThermostat", "<init>", "(Lcom/google/home/google/ExtendedThermostat;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/google/ExtendedThermostat;", "getExtendedThermostat", "()Lcom/google/home/google/ExtendedThermostat;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GoogleTraits {
        private final ExtendedThermostat extendedThermostat;

        public GoogleTraits(ExtendedThermostat extendedThermostat) {
            this.extendedThermostat = extendedThermostat;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof GoogleTraits) && Intrinsics.areEqual(this.extendedThermostat, ((GoogleTraits) other).extendedThermostat);
        }

        public int hashCode() {
            ExtendedThermostat extendedThermostat = this.extendedThermostat;
            return (extendedThermostat != null ? extendedThermostat.hashCode() : 0) + 1;
        }

        public String toString() {
            return zzf.zza(this.extendedThermostat, "GoogleTraits(extendedThermostat=", (byte) 34, ",)");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Lcom/google/home/matter/standard/ThermostatDevice$StandardTraits;", "", "Lcom/google/home/matter/standard/Identify;", "identify", "Lcom/google/home/matter/standard/Thermostat;", "thermostat", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfiguration;", "thermostatUserInterfaceConfiguration", "<init>", "(Lcom/google/home/matter/standard/Identify;Lcom/google/home/matter/standard/Thermostat;Lcom/google/home/matter/standard/ThermostatUserInterfaceConfiguration;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/matter/standard/Identify;", "getIdentify", "()Lcom/google/home/matter/standard/Identify;", "Lcom/google/home/matter/standard/Thermostat;", "getThermostat", "()Lcom/google/home/matter/standard/Thermostat;", "Lcom/google/home/matter/standard/ThermostatUserInterfaceConfiguration;", "getThermostatUserInterfaceConfiguration", "()Lcom/google/home/matter/standard/ThermostatUserInterfaceConfiguration;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StandardTraits {
        private final Identify identify;
        private final Thermostat thermostat;
        private final ThermostatUserInterfaceConfiguration thermostatUserInterfaceConfiguration;

        public StandardTraits(Identify identify, Thermostat thermostat, ThermostatUserInterfaceConfiguration thermostatUserInterfaceConfiguration) {
            this.identify = identify;
            this.thermostat = thermostat;
            this.thermostatUserInterfaceConfiguration = thermostatUserInterfaceConfiguration;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StandardTraits)) {
                return false;
            }
            StandardTraits standardTraits = (StandardTraits) other;
            return Intrinsics.areEqual(this.identify, standardTraits.identify) && Intrinsics.areEqual(this.thermostat, standardTraits.thermostat) && Intrinsics.areEqual(this.thermostatUserInterfaceConfiguration, standardTraits.thermostatUserInterfaceConfiguration);
        }

        public int hashCode() {
            Identify identify = this.identify;
            int iHashCode = identify != null ? identify.hashCode() : 0;
            Thermostat thermostat = this.thermostat;
            int iHashCode2 = thermostat != null ? thermostat.hashCode() : 0;
            int i = iHashCode + 1;
            ThermostatUserInterfaceConfiguration thermostatUserInterfaceConfiguration = this.thermostatUserInterfaceConfiguration;
            return i + iHashCode2 + (thermostatUserInterfaceConfiguration != null ? thermostatUserInterfaceConfiguration.hashCode() : 0);
        }

        public String toString() {
            Identify identify = this.identify;
            int length = String.valueOf(identify).length();
            Thermostat thermostat = this.thermostat;
            int length2 = String.valueOf(thermostat).length();
            ThermostatUserInterfaceConfiguration thermostatUserInterfaceConfiguration = this.thermostatUserInterfaceConfiguration;
            return zzi.zza(thermostatUserInterfaceConfiguration, thermostat, new StringBuilder(zzba$$ExternalSyntheticOutline0.m(length, 36, length2, 38, String.valueOf(thermostatUserInterfaceConfiguration).length()) + 2), identify, "StandardTraits(identify=", ",thermostat=", ",thermostatUserInterfaceConfiguration=", ",)");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThermostatDevice(DeviceType.Metadata metadata, TraitProvider traitProvider, HasEvents hasEvents, GoogleTraits googleTraits, StandardTraits standardTraits) {
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
        if (!(other instanceof ThermostatDevice)) {
            return false;
        }
        ThermostatDevice thermostatDevice = (ThermostatDevice) other;
        return Intrinsics.areEqual(this.googleTraits, thermostatDevice.googleTraits) && Intrinsics.areEqual(this.standardTraits, thermostatDevice.standardTraits) && Intrinsics.areEqual(thermostatDevice.getMetadata(), getMetadata());
    }

    @Override // com.google.home.DeviceType
    public DeviceTypeFactory<ThermostatDevice> getFactory() {
        return this.factory;
    }

    @Override // com.google.home.DeviceType
    public DeviceType.Metadata getMetadata() {
        return this.metadata;
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
        StandardTraits standardTraits = this.standardTraits;
        int length4 = String.valueOf(standardTraits).length();
        StandardTraits standardTraits2 = this.standardTraits;
        int length5 = String.valueOf(standardTraits2).length();
        StandardTraits standardTraits3 = this.standardTraits;
        int length6 = String.valueOf(standardTraits3).length();
        StandardTraits standardTraits4 = this.standardTraits;
        return zzz.zza(standardTraits4, standardTraits3, standardTraits2, standardTraits, googleTraits2, new StringBuilder(length + 40 + length2 + 20 + length3 + 37 + length4 + 10 + length5 + 21 + length6 + 49 + String.valueOf(standardTraits4).length() + 41), googleTraits, metadata, "(extendedThermostat=", ",googleTraits=", ".extendedThermostat,),standardTraits=", "(identify=", ".identify,thermostat=", ".thermostat,thermostatUserInterfaceConfiguration=", "ThermostatDevice(metadata=", ".thermostatUserInterfaceConfiguration,),)");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/google/home/matter/standard/ThermostatDevice$Companion;", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/matter/standard/ThermostatDevice;", "<init>", "()V", "TYPE_ID", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends DeviceTypeFactory<ThermostatDevice> {
        private Companion() {
            super(Factory.INSTANCE);
        }

        public String toString() {
            return "matter.standard.type.ThermostatDevice";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004JN\u0010\u0005\u001a\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/google/home/matter/standard/ThermostatDevice$Factory;", "Lcom/google/home/matter/MatterDeviceTypeFactory;", "Lcom/google/home/matter/standard/ThermostatDevice;", "<init>", "()V", "createType", "traits", "", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "metadataBuilder", "Lkotlin/Function1;", "", "Lcom/google/home/DeviceType$Metadata;", "traitProvider", "Lcom/google/home/TraitProvider;", "eventProvider", "Lcom/google/home/HasEvents;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory extends MatterDeviceTypeFactory<ThermostatDevice> {
        public static final Factory INSTANCE = new Factory();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Factory() {
            super("home.matter.0000.types.0301", CollectionsKt.listOf((Object[]) new TraitFactory[]{Identify.INSTANCE, Thermostat.INSTANCE, ThermostatUserInterfaceConfiguration.INSTANCE, ExtendedThermostat.INSTANCE}), null);
            Id.m441constructorimpl("home.matter.0000.types.0301");
        }

        @Override // com.google.home.matter.MatterDeviceTypeFactory
        public ThermostatDevice createType(Map<TraitFactory<?>, ? extends Trait> traits, Function1<? super List<? extends Trait>, DeviceType.Metadata> metadataBuilder, TraitProvider traitProvider, HasEvents eventProvider) {
            traits.getClass();
            metadataBuilder.getClass();
            traitProvider.getClass();
            eventProvider.getClass();
            Identify.Companion companion = Identify.INSTANCE;
            Trait as = getAs(traits, companion);
            Thermostat.Companion companion2 = Thermostat.INSTANCE;
            Trait as2 = getAs(traits, companion2);
            ThermostatUserInterfaceConfiguration.Companion companion3 = ThermostatUserInterfaceConfiguration.INSTANCE;
            Trait as3 = getAs(traits, companion3);
            ExtendedThermostat.Companion companion4 = ExtendedThermostat.INSTANCE;
            return new ThermostatDevice(metadataBuilder.invoke(CollectionsKt.listOfNotNull((Object[]) new Trait[]{as, as2, as3, getAs(traits, companion4)})), traitProvider, eventProvider, new GoogleTraits((ExtendedThermostat) getAs(traits, companion4)), new StandardTraits((Identify) getAs(traits, companion), (Thermostat) getAs(traits, companion2), (ThermostatUserInterfaceConfiguration) getAs(traits, companion3)));
        }

        @Override // com.google.home.matter.MatterDeviceTypeFactory
        public /* bridge */ /* synthetic */ DeviceType createType(Map map, Function1 function1, TraitProvider traitProvider, HasEvents hasEvents) {
            return createType((Map<TraitFactory<?>, ? extends Trait>) map, (Function1<? super List<? extends Trait>, DeviceType.Metadata>) function1, traitProvider, hasEvents);
        }
    }
}
