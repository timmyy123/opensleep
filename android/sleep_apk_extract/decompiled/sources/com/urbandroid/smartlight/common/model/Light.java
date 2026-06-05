package com.urbandroid.smartlight.common.model;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u001fB#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J'\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\n\"\u0004\b\u0014\u0010\u0011¨\u0006 "}, d2 = {"Lcom/urbandroid/smartlight/common/model/Light;", "", "id", "", "name", "type", "Lcom/urbandroid/smartlight/common/model/Light$Type;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/urbandroid/smartlight/common/model/Light$Type;)V", "getId", "()Ljava/lang/String;", "getName", "getType", "()Lcom/urbandroid/smartlight/common/model/Light$Type;", DeviceRequestsHelper.DEVICE_INFO_MODEL, "getModel", "setModel", "(Ljava/lang/String;)V", "version", "getVersion", "setVersion", "equals", "", "other", "hashCode", "", "component1", "component2", "component3", "copy", InAppPurchaseConstants.METHOD_TO_STRING, "Type", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final /* data */ class Light {
    private final String id;
    private String model;
    private final String name;
    private final Type type;
    private String version;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Light$Type;", "", "<init>", "(Ljava/lang/String;I)V", "COLOR", "CT", "DIM", "SWITCH", "UNKNOWN", "Companion", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        public static final Type COLOR = new Type("COLOR", 0);
        public static final Type CT = new Type("CT", 1);
        public static final Type DIM = new Type("DIM", 2);
        public static final Type SWITCH = new Type("SWITCH", 3);
        public static final Type UNKNOWN = new Type("UNKNOWN", 4);

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/smartlight/common/model/Light$Type$Companion;", "", "<init>", "()V", "findOrNull", "Lcom/urbandroid/smartlight/common/model/Light$Type;", "name", "", "smartlight_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Type findOrNull(String name) {
                name.getClass();
                for (Type type : Type.values()) {
                    if (Intrinsics.areEqual(type.name(), name)) {
                        return type;
                    }
                }
                return null;
            }

            private Companion() {
            }
        }

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{COLOR, CT, DIM, SWITCH, UNKNOWN};
        }

        static {
            Type[] typeArr$values = $values();
            $VALUES = typeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(typeArr$values);
            INSTANCE = new Companion(null);
        }

        private Type(String str, int i) {
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    public Light(String str, String str2, Type type) {
        str.getClass();
        str2.getClass();
        type.getClass();
        this.id = str;
        this.name = str2;
        this.type = type;
    }

    public static /* synthetic */ Light copy$default(Light light, String str, String str2, Type type, int i, Object obj) {
        if ((i & 1) != 0) {
            str = light.id;
        }
        if ((i & 2) != 0) {
            str2 = light.name;
        }
        if ((i & 4) != 0) {
            type = light.type;
        }
        return light.copy(str, str2, type);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Type getType() {
        return this.type;
    }

    public final Light copy(String id, String name, Type type) {
        id.getClass();
        name.getClass();
        type.getClass();
        return new Light(id, name, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(Light.class, other != null ? other.getClass() : null)) {
            return false;
        }
        other.getClass();
        return Intrinsics.areEqual(this.id, ((Light) other).id);
    }

    public final String getId() {
        return this.id;
    }

    public final String getModel() {
        return this.model;
    }

    public final String getName() {
        return this.name;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return this.id.hashCode();
    }

    public final void setModel(String str) {
        this.model = str;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public String toString() {
        return "Light(id=" + this.id + ", name=" + this.name + ", type=" + this.type + ')';
    }

    public /* synthetic */ Light(String str, String str2, Type type, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? str : str2, (i & 4) != 0 ? Type.UNKNOWN : type);
    }
}
