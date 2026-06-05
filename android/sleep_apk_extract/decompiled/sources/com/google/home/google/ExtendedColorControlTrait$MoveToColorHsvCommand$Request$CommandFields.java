package com.google.home.google;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.home.Descriptor;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.Type;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\u0087\u0081\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B1\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0005\u001a\u00020\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u00020\n8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\r\u0010\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b ¨\u0006!"}, d2 = {"com/google/home/google/ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields", "Lcom/google/home/Field;", "", "Lcom/google/home/google/ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields;", "Lkotlin/UInt;", "tag", "", "typeName", "Lcom/google/home/Type;", "typeEnum", "Lcom/google/home/Descriptor;", "descriptor", "", "isNullable", "<init>", "(Ljava/lang/String;IILjava/lang/String;Lcom/google/home/Type;Lcom/google/home/Descriptor;Z)V", "I", "getTag-pVg5ArA", "()I", "Ljava/lang/String;", "getTypeName", "()Ljava/lang/String;", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "Lcom/google/home/Descriptor;", "getDescriptor", "()Lcom/google/home/Descriptor;", "Z", "()Z", "hue", "saturation", SDKConstants.PARAM_VALUE, "home.platform.traits.google.common_clusters-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields implements Field {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields[] $VALUES;
    public static final ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields hue;
    public static final ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields saturation;
    public static final ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields value;
    private final Descriptor descriptor;
    private final boolean isNullable;
    private final int tag;
    private final Type typeEnum;
    private final String typeName;

    private static final /* synthetic */ ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields[] $values() {
        return new ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields[]{hue, saturation, value};
    }

    static {
        Type type = Type.Float;
        NoOpDescriptor noOpDescriptor = NoOpDescriptor.INSTANCE;
        hue = new ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields("hue", 0, 0, "Float", type, noOpDescriptor, false);
        saturation = new ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields("saturation", 1, 1, "Float", type, noOpDescriptor, false);
        value = new ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields(SDKConstants.PARAM_VALUE, 2, 2, "Float", type, noOpDescriptor, false);
        ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields[] extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFieldsArr$values = $values();
        $VALUES = extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFieldsArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(extendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFieldsArr$values);
    }

    private ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields(String str, int i, int i2, String str2, Type type, Descriptor descriptor, boolean z) {
        this.tag = i2;
        this.typeName = str2;
        this.typeEnum = type;
        this.descriptor = descriptor;
        this.isNullable = z;
    }

    public static ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields valueOf(String str) {
        return (ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields) Enum.valueOf(ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields.class, str);
    }

    public static ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields[] values() {
        return (ExtendedColorControlTrait$MoveToColorHsvCommand$Request$CommandFields[]) $VALUES.clone();
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
