package com.google.home.google;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.StructDescriptor;
import com.google.home.Type;
import com.google.home.matter.serialization.ClusterId;
import com.google.home.matter.serialization.ClusterPayload;
import com.google.home.matter.serialization.ClusterPayloadReader;
import com.google.home.matter.serialization.ClusterPayloadWriter;
import com.google.home.matter.serialization.StructAdapter;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/google/home/google/ExtendedModeSelectTrait;", "", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterId;", "Id", "Lcom/google/home/matter/serialization/ClusterId;", "getId", "()Lcom/google/home/matter/serialization/ClusterId;", "ModeSetting", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedModeSelectTrait {
    public static final ExtendedModeSelectTrait INSTANCE = new ExtendedModeSelectTrait();
    private static final ClusterId Id = new ClusterId(1611070538, "ExtendedModeSelect", null, 4, null);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0010\u0011B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting;", "", "modeNameKey", "", "modeValueKey", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getModeNameKey", "()Ljava/lang/String;", "getModeValueKey", "equals", "", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "StructFields", "Adapter", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ModeSetting {

        /* JADX INFO: renamed from: Adapter, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final String modeNameKey;
        private final String modeValueKey;

        /* JADX INFO: renamed from: com.google.home.google.ExtendedModeSelectTrait$ModeSetting$Adapter, reason: from kotlin metadata */
        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\t\b\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0017¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting$Adapter;", "Lcom/google/home/matter/serialization/StructAdapter;", "Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting;", "Lcom/google/home/StructDescriptor;", "<init>", "()V", "Lcom/google/home/matter/serialization/ClusterPayloadWriter;", "writer", SDKConstants.PARAM_VALUE, "", "write", "(Lcom/google/home/matter/serialization/ClusterPayloadWriter;Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting;)V", "Lcom/google/home/matter/serialization/ClusterPayloadReader;", "reader", "read", "(Lcom/google/home/matter/serialization/ClusterPayloadReader;)Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting;", "Lkotlin/UInt;", "tagId", "Lcom/google/home/Field;", "getFieldById-WZ4Q5Ns", "(I)Lcom/google/home/Field;", "getFieldById", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion implements StructAdapter<ModeSetting>, StructDescriptor {
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
            public ModeSetting read(ClusterPayloadReader reader) {
                reader.getClass();
                ClusterPayload payload$default = ClusterPayloadReader.readPayload$default(reader, null, 1, null);
                return new ModeSetting(payload$default.getString().mo546getqim9Vi0(0, "ModeNameKey"), payload$default.getString().mo546getqim9Vi0(1, "ModeValueKey"));
            }

            @Override // com.google.home.matter.serialization.StructAdapter
            public void write(ClusterPayloadWriter writer, ModeSetting value) {
                writer.getClass();
                value.getClass();
                writer.getString().mo554writeqim9Vi0(0, value.getModeNameKey());
                writer.getString().mo554writeqim9Vi0(1, value.getModeValueKey());
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0014\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B1\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u00078\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\t8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\u001b\u001a\u0004\b\f\u0010\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/google/home/google/ExtendedModeSelectTrait$ModeSetting$StructFields;", "Lcom/google/home/Field;", "", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "modeNameKey", "modeValueKey", "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class StructFields implements Field {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ StructFields[] $VALUES;
            public static final StructFields modeNameKey;
            public static final StructFields modeValueKey;
            private final Descriptor descriptor;
            private final boolean isNullable;
            private final int tag;
            private final Type typeEnum;
            private final String typeName;

            private static final /* synthetic */ StructFields[] $values() {
                return new StructFields[]{modeNameKey, modeValueKey};
            }

            static {
                Type type = Type.String;
                NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
                modeNameKey = new StructFields("modeNameKey", 0, 0, "String", type, noOpDescriptor, false);
                modeValueKey = new StructFields("modeValueKey", 1, 1, "String", type, noOpDescriptor, false);
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

        public ModeSetting(String str, String str2) {
            str.getClass();
            str2.getClass();
            this.modeNameKey = str;
            this.modeValueKey = str2;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ModeSetting)) {
                return false;
            }
            ModeSetting modeSetting = (ModeSetting) other;
            return Intrinsics.areEqual(this.modeNameKey, modeSetting.modeNameKey) && Intrinsics.areEqual(this.modeValueKey, modeSetting.modeValueKey);
        }

        public final String getModeNameKey() {
            return this.modeNameKey;
        }

        public final String getModeValueKey() {
            return this.modeValueKey;
        }

        public int hashCode() {
            int iHashCode = this.modeNameKey.hashCode() + 31;
            return this.modeValueKey.hashCode() + (iHashCode * 31);
        }

        public String toString() {
            return zzb.zza(this.modeValueKey, this.modeNameKey, (byte) 39, "ModeSetting(modeNameKey=", ", modeValueKey=");
        }
    }

    private ExtendedModeSelectTrait() {
    }

    public final ClusterId getId() {
        return Id;
    }
}
