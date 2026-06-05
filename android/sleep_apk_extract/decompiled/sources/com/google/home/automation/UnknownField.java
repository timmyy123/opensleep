package com.google.home.automation;

import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.google.home.Field;
import com.google.home.NoOpDescriptor;
import com.google.home.Type;
import kotlin.Metadata;
import kotlin.UInt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016R\u0016\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\nX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001c"}, d2 = {"Lcom/google/home/automation/UnknownField;", "Lcom/google/home/Field;", "tag", "Lkotlin/UInt;", "<init>", "(ILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTag-pVg5ArA", "()I", "I", "typeName", "", "getTypeName", "()Ljava/lang/String;", "typeEnum", "Lcom/google/home/Type;", "getTypeEnum", "()Lcom/google/home/Type;", "descriptor", "Lcom/google/home/NoOpDescriptor;", "getDescriptor", "()Lcom/google/home/NoOpDescriptor;", "equals", "", "other", "", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class UnknownField implements Field {
    private final NoOpDescriptor descriptor;
    private final int tag;
    private final Type typeEnum;
    private final String typeName;

    private UnknownField(int i) {
        this.tag = i;
        this.typeName = "";
        this.typeEnum = Type.Dynamic;
        this.descriptor = NoOpDescriptor.INSTANCE;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof UnknownField) && getTag() == ((UnknownField) other).getTag();
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

    public int hashCode() {
        return UInt.m2391hashCodeimpl(getTag());
    }

    public String toString() {
        String strM2392toStringimpl = UInt.m2392toStringimpl(getTag());
        return Fragment$$ExternalSyntheticOutline1.m(new StringBuilder(String.valueOf(strM2392toStringimpl).length() + 18), "UnknownField(tag=", strM2392toStringimpl, ")");
    }

    @Override // com.google.home.Field
    public NoOpDescriptor getDescriptor() {
        return this.descriptor;
    }

    public /* synthetic */ UnknownField(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
