package com.google.home.automation;

import com.google.home.InternalDeviceTypeFactory;
import com.google.home.TraitFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005¢\u0006\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"com/google/home/automation/UnknownDeviceType$Factory", "Lcom/google/home/InternalDeviceTypeFactory;", "", "Lcom/google/home/Id;", "typeId", "", "Lcom/google/home/TraitFactory;", "traits", "<init>", "(Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "Ljava/lang/String;", "getTypeId-sJHuco4", "()Ljava/lang/String;", "Ljava/util/List;", "getTraits", "()Ljava/util/List;", "java.com.google.nest.platform.mesh.semantic.src.com.google.home_public_api-android"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class UnknownDeviceType$Factory implements InternalDeviceTypeFactory<Object> {
    private final List<TraitFactory<?>> traits;
    private final String typeId;

    /* JADX WARN: Multi-variable type inference failed */
    private UnknownDeviceType$Factory(String str, List<? extends TraitFactory<?>> list) {
        str.getClass();
        list.getClass();
        this.typeId = str;
        this.traits = list;
    }

    @Override // com.google.home.InternalTypeFactory
    public List<TraitFactory<?>> getTraits() {
        return this.traits;
    }

    @Override // com.google.home.InternalTypeFactory
    /* JADX INFO: renamed from: getTypeId-sJHuco4, reason: from getter */
    public String getTypeId() {
        return this.typeId;
    }

    public /* synthetic */ UnknownDeviceType$Factory(String str, List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list);
    }

    public /* synthetic */ UnknownDeviceType$Factory(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? CollectionsKt.emptyList() : list, null);
    }
}
