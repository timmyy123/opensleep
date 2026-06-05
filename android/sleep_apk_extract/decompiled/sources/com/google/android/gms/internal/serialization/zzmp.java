package com.google.android.gms.internal.serialization;

import com.google.home.HomeException;
import com.google.home.google.PlatformEnumAdapter;
import com.google.home.google.PlatformTraitFactory;
import com.google.home.matter.MatterTraitFactory;
import com.google.home.matter.serialization.BitmapAdapter;
import com.google.home.matter.serialization.EnumAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\t\u001a\u0004\u0018\u00010\b\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\t\u0010\n\u001a=\u0010\t\u001a\u0004\u0018\u00010\b\"\b\b\u0000\u0010\u0001*\u00020\u000b*\u00020\u00022\u0010\u0010\u0005\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f¢\u0006\u0004\b\t\u0010\u000e\u001a=\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0014\"\b\b\u0000\u0010\u0001*\u00020\u000f\"\b\b\u0001\u0010\u0010*\u00020\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016\u001a=\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0019\"\b\b\u0000\u0010\u0001*\u00020\u0017\"\b\b\u0001\u0010\u0010*\u00020\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u001a\u001a=\u0010\u001c\u001a\u0006\u0012\u0002\b\u00030\u001b\"\b\b\u0000\u0010\u0001*\u00020\u000f\"\b\b\u0001\u0010\u0010*\u00020\u000b*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/google/home/Trait;", "T", "Lcom/google/home/HomeDevice;", "Lcom/google/home/DeviceTypeFactory;", "Lcom/google/home/DeviceType;", "type", "Lcom/google/home/TraitFactory;", "trait", "Lcom/google/home/Id;", "getEntityId", "(Lcom/google/home/HomeDevice;Lcom/google/home/DeviceTypeFactory;Lcom/google/home/TraitFactory;)Ljava/lang/String;", "", "Lcom/google/home/EventFactory;", "event", "(Lcom/google/home/HomeDevice;Lcom/google/home/DeviceTypeFactory;Lcom/google/home/EventFactory;)Ljava/lang/String;", "Lcom/google/home/matter/MatterTrait;", "A", "Lcom/google/home/matter/MatterTraitFactory;", "", "typeName", "Lcom/google/home/matter/serialization/EnumAdapter;", "getEnumAdapter", "(Lcom/google/home/matter/MatterTraitFactory;Ljava/lang/String;)Lcom/google/home/matter/serialization/EnumAdapter;", "Lcom/google/home/google/PlatformTrait;", "Lcom/google/home/google/PlatformTraitFactory;", "Lcom/google/home/google/PlatformEnumAdapter;", "(Lcom/google/home/google/PlatformTraitFactory;Ljava/lang/String;)Lcom/google/home/google/PlatformEnumAdapter;", "Lcom/google/home/matter/serialization/BitmapAdapter;", "getBitmapAdapter", "(Lcom/google/home/matter/MatterTraitFactory;Ljava/lang/String;)Lcom/google/home/matter/serialization/BitmapAdapter;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_impl-android"}, k = 2, mv = {2, 0, 0}, xi = 48)
public abstract class zzmp {
    public static final EnumAdapter zza(MatterTraitFactory matterTraitFactory, String str) throws HomeException {
        matterTraitFactory.getClass();
        str.getClass();
        EnumAdapter<?> enumAdapter = matterTraitFactory.getEnumAdapters().get(str);
        if (enumAdapter != null) {
            return enumAdapter;
        }
        throw HomeException.INSTANCE.invalidArgument("Unsupported enum type name: ".concat(String.valueOf(str)));
    }

    public static final PlatformEnumAdapter zzb(PlatformTraitFactory platformTraitFactory, String str) throws HomeException {
        platformTraitFactory.getClass();
        str.getClass();
        if (platformTraitFactory.getEnumAdapters().get(str) == null) {
            throw HomeException.INSTANCE.invalidArgument("Unsupported enum type name: ".concat(str));
        }
        throw new ClassCastException();
    }

    public static final BitmapAdapter zzc(MatterTraitFactory matterTraitFactory, String str) throws HomeException {
        matterTraitFactory.getClass();
        str.getClass();
        BitmapAdapter<?> bitmapAdapter = matterTraitFactory.getBitmapAdapters().get(str);
        if (bitmapAdapter != null) {
            return bitmapAdapter;
        }
        throw HomeException.INSTANCE.invalidArgument("Unsupported bitmap type name: ".concat(String.valueOf(str)));
    }
}
