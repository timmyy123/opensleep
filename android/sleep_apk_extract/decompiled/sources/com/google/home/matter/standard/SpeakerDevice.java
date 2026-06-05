package com.google.home.matter.standard;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.DeviceType;
import com.google.home.DeviceTypeFactory;
import com.google.home.HasEvents;
import com.google.home.Id;
import com.google.home.Trait;
import com.google.home.TraitFactory;
import com.google.home.TraitProvider;
import com.google.home.google.ExtendedApplicationLauncher;
import com.google.home.google.ExtendedLevelControl;
import com.google.home.google.ExtendedMediaInput;
import com.google.home.google.ExtendedMediaPlayback;
import com.google.home.google.MediaActivityState;
import com.google.home.matter.MatterDeviceTypeFactory;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 '2\u00020\u0001:\u0004'()*B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0096\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!R \u0010#\u001a\b\u0012\u0004\u0012\u00020\u00000\"8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006+"}, d2 = {"Lcom/google/home/matter/standard/SpeakerDevice;", "Lcom/google/home/DeviceType;", "Lcom/google/home/DeviceType$Metadata;", "metadata", "Lcom/google/home/TraitProvider;", "traitProvider", "Lcom/google/home/HasEvents;", "eventProvider", "Lcom/google/home/matter/standard/SpeakerDevice$GoogleTraits;", "googleTraits", "Lcom/google/home/matter/standard/SpeakerDevice$StandardTraits;", "standardTraits", "<init>", "(Lcom/google/home/DeviceType$Metadata;Lcom/google/home/TraitProvider;Lcom/google/home/HasEvents;Lcom/google/home/matter/standard/SpeakerDevice$GoogleTraits;Lcom/google/home/matter/standard/SpeakerDevice$StandardTraits;)V", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/DeviceType$Metadata;", "getMetadata", "()Lcom/google/home/DeviceType$Metadata;", "Lcom/google/home/matter/standard/SpeakerDevice$GoogleTraits;", "getGoogleTraits", "()Lcom/google/home/matter/standard/SpeakerDevice$GoogleTraits;", "Lcom/google/home/matter/standard/SpeakerDevice$StandardTraits;", "getStandardTraits", "()Lcom/google/home/matter/standard/SpeakerDevice$StandardTraits;", "Lcom/google/home/DeviceTypeFactory;", "factory", "Lcom/google/home/DeviceTypeFactory;", "getFactory", "()Lcom/google/home/DeviceTypeFactory;", "Companion", "GoogleTraits", "StandardTraits", "Factory", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SpeakerDevice extends DeviceType {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final DeviceTypeFactory<SpeakerDevice> factory;
    private final GoogleTraits googleTraits;
    private final DeviceType.Metadata metadata;
    private final StandardTraits standardTraits;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b\"\u0010#R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010$\u001a\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/google/home/matter/standard/SpeakerDevice$GoogleTraits;", "", "Lcom/google/home/google/ExtendedApplicationLauncher;", "extendedApplicationLauncher", "Lcom/google/home/google/ExtendedMediaInput;", "extendedMediaInput", "Lcom/google/home/google/ExtendedMediaPlayback;", "extendedMediaPlayback", "Lcom/google/home/google/MediaActivityState;", "mediaActivityState", "Lcom/google/home/google/ExtendedLevelControl;", "extendedLevelControl", "<init>", "(Lcom/google/home/google/ExtendedApplicationLauncher;Lcom/google/home/google/ExtendedMediaInput;Lcom/google/home/google/ExtendedMediaPlayback;Lcom/google/home/google/MediaActivityState;Lcom/google/home/google/ExtendedLevelControl;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/google/ExtendedApplicationLauncher;", "getExtendedApplicationLauncher", "()Lcom/google/home/google/ExtendedApplicationLauncher;", "Lcom/google/home/google/ExtendedMediaInput;", "getExtendedMediaInput", "()Lcom/google/home/google/ExtendedMediaInput;", "Lcom/google/home/google/ExtendedMediaPlayback;", "getExtendedMediaPlayback", "()Lcom/google/home/google/ExtendedMediaPlayback;", "Lcom/google/home/google/MediaActivityState;", "getMediaActivityState", "()Lcom/google/home/google/MediaActivityState;", "Lcom/google/home/google/ExtendedLevelControl;", "getExtendedLevelControl", "()Lcom/google/home/google/ExtendedLevelControl;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class GoogleTraits {
        private final ExtendedApplicationLauncher extendedApplicationLauncher;
        private final ExtendedLevelControl extendedLevelControl;
        private final ExtendedMediaInput extendedMediaInput;
        private final ExtendedMediaPlayback extendedMediaPlayback;
        private final MediaActivityState mediaActivityState;

        public GoogleTraits(ExtendedApplicationLauncher extendedApplicationLauncher, ExtendedMediaInput extendedMediaInput, ExtendedMediaPlayback extendedMediaPlayback, MediaActivityState mediaActivityState, ExtendedLevelControl extendedLevelControl) {
            this.extendedApplicationLauncher = extendedApplicationLauncher;
            this.extendedMediaInput = extendedMediaInput;
            this.extendedMediaPlayback = extendedMediaPlayback;
            this.mediaActivityState = mediaActivityState;
            this.extendedLevelControl = extendedLevelControl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GoogleTraits)) {
                return false;
            }
            GoogleTraits googleTraits = (GoogleTraits) other;
            return Intrinsics.areEqual(this.extendedApplicationLauncher, googleTraits.extendedApplicationLauncher) && Intrinsics.areEqual(this.extendedMediaInput, googleTraits.extendedMediaInput) && Intrinsics.areEqual(this.extendedMediaPlayback, googleTraits.extendedMediaPlayback) && Intrinsics.areEqual(this.mediaActivityState, googleTraits.mediaActivityState) && Intrinsics.areEqual(this.extendedLevelControl, googleTraits.extendedLevelControl);
        }

        public int hashCode() {
            ExtendedApplicationLauncher extendedApplicationLauncher = this.extendedApplicationLauncher;
            int iHashCode = extendedApplicationLauncher != null ? extendedApplicationLauncher.hashCode() : 0;
            ExtendedMediaInput extendedMediaInput = this.extendedMediaInput;
            int iHashCode2 = extendedMediaInput != null ? extendedMediaInput.hashCode() : 0;
            int i = iHashCode + 1;
            ExtendedMediaPlayback extendedMediaPlayback = this.extendedMediaPlayback;
            int iHashCode3 = extendedMediaPlayback != null ? extendedMediaPlayback.hashCode() : 0;
            int i2 = i + iHashCode2;
            MediaActivityState mediaActivityState = this.mediaActivityState;
            int iHashCode4 = mediaActivityState != null ? mediaActivityState.hashCode() : 0;
            int i3 = i2 + iHashCode3;
            ExtendedLevelControl extendedLevelControl = this.extendedLevelControl;
            return i3 + iHashCode4 + (extendedLevelControl != null ? extendedLevelControl.hashCode() : 0);
        }

        public String toString() {
            ExtendedApplicationLauncher extendedApplicationLauncher = this.extendedApplicationLauncher;
            int length = String.valueOf(extendedApplicationLauncher).length();
            ExtendedMediaInput extendedMediaInput = this.extendedMediaInput;
            int length2 = String.valueOf(extendedMediaInput).length();
            ExtendedMediaPlayback extendedMediaPlayback = this.extendedMediaPlayback;
            int length3 = String.valueOf(extendedMediaPlayback).length();
            MediaActivityState mediaActivityState = this.mediaActivityState;
            int length4 = String.valueOf(mediaActivityState).length();
            ExtendedLevelControl extendedLevelControl = this.extendedLevelControl;
            return zzt.zza(new StringBuilder(length + 61 + length2 + 23 + length3 + 20 + length4 + 22 + String.valueOf(extendedLevelControl).length() + 2), extendedLevelControl, mediaActivityState, extendedMediaPlayback, extendedMediaInput, extendedApplicationLauncher, "GoogleTraits(extendedApplicationLauncher=", ",extendedMediaInput=", ",extendedMediaPlayback=", ",mediaActivityState=", ",extendedLevelControl=", ",)");
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/google/home/matter/standard/SpeakerDevice$StandardTraits;", "", "Lcom/google/home/matter/standard/OnOff;", "onOff", "Lcom/google/home/matter/standard/LevelControl;", "levelControl", "<init>", "(Lcom/google/home/matter/standard/OnOff;Lcom/google/home/matter/standard/LevelControl;)V", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Lcom/google/home/matter/standard/OnOff;", "getOnOff", "()Lcom/google/home/matter/standard/OnOff;", "Lcom/google/home/matter/standard/LevelControl;", "getLevelControl", "()Lcom/google/home/matter/standard/LevelControl;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class StandardTraits {
        private final LevelControl levelControl;
        private final OnOff onOff;

        public StandardTraits(OnOff onOff, LevelControl levelControl) {
            this.onOff = onOff;
            this.levelControl = levelControl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StandardTraits)) {
                return false;
            }
            StandardTraits standardTraits = (StandardTraits) other;
            return Intrinsics.areEqual(this.onOff, standardTraits.onOff) && Intrinsics.areEqual(this.levelControl, standardTraits.levelControl);
        }

        public int hashCode() {
            OnOff onOff = this.onOff;
            int iHashCode = onOff != null ? onOff.hashCode() : 0;
            LevelControl levelControl = this.levelControl;
            return iHashCode + 1 + (levelControl != null ? levelControl.hashCode() : 0);
        }

        public String toString() {
            return zze.zza(this.levelControl, this.onOff, (byte) 2, (byte) 35, "StandardTraits(onOff=", ",levelControl=", ",)");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpeakerDevice(DeviceType.Metadata metadata, TraitProvider traitProvider, HasEvents hasEvents, GoogleTraits googleTraits, StandardTraits standardTraits) {
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
        if (!(other instanceof SpeakerDevice)) {
            return false;
        }
        SpeakerDevice speakerDevice = (SpeakerDevice) other;
        return Intrinsics.areEqual(this.googleTraits, speakerDevice.googleTraits) && Intrinsics.areEqual(this.standardTraits, speakerDevice.standardTraits) && Intrinsics.areEqual(speakerDevice.getMetadata(), getMetadata());
    }

    @Override // com.google.home.DeviceType
    public DeviceTypeFactory<SpeakerDevice> getFactory() {
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
        GoogleTraits googleTraits3 = this.googleTraits;
        int length4 = String.valueOf(googleTraits3).length();
        GoogleTraits googleTraits4 = this.googleTraits;
        int length5 = String.valueOf(googleTraits4).length();
        GoogleTraits googleTraits5 = this.googleTraits;
        int length6 = String.valueOf(googleTraits5).length();
        GoogleTraits googleTraits6 = this.googleTraits;
        int length7 = String.valueOf(googleTraits6).length();
        StandardTraits standardTraits = this.standardTraits;
        int length8 = String.valueOf(standardTraits).length();
        StandardTraits standardTraits2 = this.standardTraits;
        int length9 = String.valueOf(standardTraits2).length();
        StandardTraits standardTraits3 = this.standardTraits;
        return zzx.zza(standardTraits3, standardTraits2, standardTraits, googleTraits6, new StringBuilder(length + 37 + length2 + 29 + length3 + 48 + length4 + 42 + length5 + 42 + length6 + 41 + length7 + 39 + length8 + 7 + length9 + 20 + String.valueOf(standardTraits3).length() + 17), googleTraits5, googleTraits4, googleTraits3, googleTraits2, googleTraits, metadata, ",googleTraits=", "SpeakerDevice(metadata=", ".extendedMediaPlayback,mediaActivityState=", ".extendedMediaInput,extendedMediaPlayback=", ".mediaActivityState,extendedLevelControl=", ".extendedLevelControl,),standardTraits=", "(onOff=", ".onOff,levelControl=", "(extendedApplicationLauncher=", ".extendedApplicationLauncher,extendedMediaInput=", ".levelControl,),)");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/google/home/matter/standard/SpeakerDevice$Companion;", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/matter/standard/SpeakerDevice;", "<init>", "()V", "TYPE_ID", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion extends DeviceTypeFactory<SpeakerDevice> {
        private Companion() {
            super(Factory.INSTANCE);
        }

        public String toString() {
            return "matter.standard.type.SpeakerDevice";
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004JN\u0010\u0005\u001a\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u001a\u0010\n\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¨\u0006\u0012"}, d2 = {"Lcom/google/home/matter/standard/SpeakerDevice$Factory;", "Lcom/google/home/matter/MatterDeviceTypeFactory;", "Lcom/google/home/matter/standard/SpeakerDevice;", "<init>", "()V", "createType", "traits", "", "Lcom/google/home/TraitFactory;", "Lcom/google/home/Trait;", "metadataBuilder", "Lkotlin/Function1;", "", "Lcom/google/home/DeviceType$Metadata;", "traitProvider", "Lcom/google/home/TraitProvider;", "eventProvider", "Lcom/google/home/HasEvents;", "java.com.google.home.matter.standard_device_types-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Factory extends MatterDeviceTypeFactory<SpeakerDevice> {
        public static final Factory INSTANCE = new Factory();

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private Factory() {
            super("home.matter.0000.types.0022", CollectionsKt.listOf((Object[]) new TraitFactory[]{OnOff.INSTANCE, LevelControl.INSTANCE, ExtendedApplicationLauncher.INSTANCE, ExtendedMediaInput.INSTANCE, ExtendedMediaPlayback.INSTANCE, MediaActivityState.INSTANCE, ExtendedLevelControl.INSTANCE}), null);
            Id.m441constructorimpl("home.matter.0000.types.0022");
        }

        @Override // com.google.home.matter.MatterDeviceTypeFactory
        public SpeakerDevice createType(Map<TraitFactory<?>, ? extends Trait> traits, Function1<? super List<? extends Trait>, DeviceType.Metadata> metadataBuilder, TraitProvider traitProvider, HasEvents eventProvider) {
            traits.getClass();
            metadataBuilder.getClass();
            traitProvider.getClass();
            eventProvider.getClass();
            OnOff.Companion companion = OnOff.INSTANCE;
            Trait as = getAs(traits, companion);
            LevelControl.Companion companion2 = LevelControl.INSTANCE;
            Trait as2 = getAs(traits, companion2);
            ExtendedApplicationLauncher.Companion companion3 = ExtendedApplicationLauncher.INSTANCE;
            Trait as3 = getAs(traits, companion3);
            ExtendedMediaInput.Companion companion4 = ExtendedMediaInput.INSTANCE;
            Trait as4 = getAs(traits, companion4);
            ExtendedMediaPlayback.Companion companion5 = ExtendedMediaPlayback.INSTANCE;
            Trait as5 = getAs(traits, companion5);
            MediaActivityState.Companion companion6 = MediaActivityState.INSTANCE;
            Trait as6 = getAs(traits, companion6);
            ExtendedLevelControl.Companion companion7 = ExtendedLevelControl.INSTANCE;
            return new SpeakerDevice(metadataBuilder.invoke(CollectionsKt.listOfNotNull((Object[]) new Trait[]{as, as2, as3, as4, as5, as6, getAs(traits, companion7)})), traitProvider, eventProvider, new GoogleTraits((ExtendedApplicationLauncher) getAs(traits, companion3), (ExtendedMediaInput) getAs(traits, companion4), (ExtendedMediaPlayback) getAs(traits, companion5), (MediaActivityState) getAs(traits, companion6), (ExtendedLevelControl) getAs(traits, companion7)), new StandardTraits((OnOff) getAs(traits, companion), (LevelControl) getAs(traits, companion2)));
        }

        @Override // com.google.home.matter.MatterDeviceTypeFactory
        public /* bridge */ /* synthetic */ DeviceType createType(Map map, Function1 function1, TraitProvider traitProvider, HasEvents hasEvents) {
            return createType((Map<TraitFactory<?>, ? extends Trait>) map, (Function1<? super List<? extends Trait>, DeviceType.Metadata>) function1, traitProvider, hasEvents);
        }
    }
}
