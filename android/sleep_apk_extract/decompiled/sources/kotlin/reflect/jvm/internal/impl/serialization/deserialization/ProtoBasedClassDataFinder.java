package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.BinaryVersion;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.name.ClassId;

/* JADX INFO: loaded from: classes5.dex */
public final class ProtoBasedClassDataFinder implements ClassDataFinder {
    private final Map<ClassId, ProtoBuf$Class> classIdToProto;
    private final Function1<ClassId, SourceElement> classSource;
    private final BinaryVersion metadataVersion;
    private final NameResolver nameResolver;

    /* JADX WARN: Multi-variable type inference failed */
    public ProtoBasedClassDataFinder(ProtoBuf$PackageFragment protoBuf$PackageFragment, NameResolver nameResolver, BinaryVersion binaryVersion, Function1<? super ClassId, ? extends SourceElement> function1) {
        protoBuf$PackageFragment.getClass();
        nameResolver.getClass();
        binaryVersion.getClass();
        function1.getClass();
        this.nameResolver = nameResolver;
        this.metadataVersion = binaryVersion;
        this.classSource = function1;
        List<ProtoBuf$Class> class_List = protoBuf$PackageFragment.getClass_List();
        class_List.getClass();
        List<ProtoBuf$Class> list = class_List;
        LinkedHashMap linkedHashMap = new LinkedHashMap(FileInsert$$ExternalSyntheticOutline0.m((Iterable) list, 10, 16));
        for (Object obj : list) {
            linkedHashMap.put(NameResolverUtilKt.getClassId(this.nameResolver, ((ProtoBuf$Class) obj).getFqName()), obj);
        }
        this.classIdToProto = linkedHashMap;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.ClassDataFinder
    public ClassData findClassData(ClassId classId) {
        classId.getClass();
        ProtoBuf$Class protoBuf$Class = this.classIdToProto.get(classId);
        if (protoBuf$Class == null) {
            return null;
        }
        return new ClassData(this.nameResolver, protoBuf$Class, this.metadataVersion, this.classSource.invoke(classId));
    }

    public final Collection<ClassId> getAllClassIds() {
        return this.classIdToProto.keySet();
    }
}
