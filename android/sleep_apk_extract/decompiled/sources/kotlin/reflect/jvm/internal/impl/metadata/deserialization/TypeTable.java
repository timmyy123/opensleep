package kotlin.reflect.jvm.internal.impl.metadata.deserialization;

import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeTable;

/* JADX INFO: loaded from: classes5.dex */
public final class TypeTable {
    private final List<ProtoBuf$Type> types;

    public TypeTable(ProtoBuf$TypeTable protoBuf$TypeTable) {
        protoBuf$TypeTable.getClass();
        List<ProtoBuf$Type> typeList = protoBuf$TypeTable.getTypeList();
        if (protoBuf$TypeTable.hasFirstNullable()) {
            int firstNullable = protoBuf$TypeTable.getFirstNullable();
            List<ProtoBuf$Type> typeList2 = protoBuf$TypeTable.getTypeList();
            typeList2.getClass();
            List<ProtoBuf$Type> list = typeList2;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            int i = 0;
            for (Object obj : list) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ProtoBuf$Type protoBuf$TypeBuild = (ProtoBuf$Type) obj;
                if (i >= firstNullable) {
                    protoBuf$TypeBuild = protoBuf$TypeBuild.toBuilder().setNullable(true).build();
                }
                arrayList.add(protoBuf$TypeBuild);
                i = i2;
            }
            typeList = arrayList;
        }
        typeList.getClass();
        this.types = typeList;
    }

    public final ProtoBuf$Type get(int i) {
        return this.types.get(i);
    }
}
