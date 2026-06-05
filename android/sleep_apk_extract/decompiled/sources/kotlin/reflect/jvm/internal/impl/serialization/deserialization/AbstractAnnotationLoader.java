package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.metadata.deserialization.NameResolver;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.SerializerExtensionProtocol;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.ProtoContainer;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractAnnotationLoader<A> implements AnnotationLoader<A> {

    /* JADX INFO: renamed from: protocol, reason: collision with root package name */
    private final SerializerExtensionProtocol f101protocol;

    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotatedCallableKind.values().length];
            try {
                iArr[AnnotatedCallableKind.PROPERTY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_GETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotatedCallableKind.PROPERTY_SETTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AbstractAnnotationLoader(SerializerExtensionProtocol serializerExtensionProtocol) {
        serializerExtensionProtocol.getClass();
        this.f101protocol = serializerExtensionProtocol;
    }

    private final List<A> loadAnnotations(List<ProtoBuf$Annotation> list, List<ProtoBuf$Annotation> list2, NameResolver nameResolver) {
        List<ProtoBuf$Annotation> list3 = list;
        if (list3.isEmpty()) {
            if (list2 == null) {
                list2 = CollectionsKt.emptyList();
            }
            list3 = list2;
        }
        List<ProtoBuf$Annotation> list4 = list3;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
        Iterator<T> it = list4.iterator();
        while (it.hasNext()) {
            arrayList.add(loadAnnotation((ProtoBuf$Annotation) it.next(), nameResolver));
        }
        return arrayList;
    }

    public final SerializerExtensionProtocol getProtocol() {
        return this.f101protocol;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadCallableAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        if (messageLite instanceof ProtoBuf$Constructor) {
            ProtoBuf$Constructor protoBuf$Constructor = (ProtoBuf$Constructor) messageLite;
            List<ProtoBuf$Annotation> annotationList = protoBuf$Constructor.getAnnotationList();
            annotationList.getClass();
            return loadAnnotations(annotationList, (List) protoBuf$Constructor.getExtension(this.f101protocol.getConstructorAnnotation()), protoContainer.getNameResolver());
        }
        if (messageLite instanceof ProtoBuf$Function) {
            ProtoBuf$Function protoBuf$Function = (ProtoBuf$Function) messageLite;
            List<ProtoBuf$Annotation> annotationList2 = protoBuf$Function.getAnnotationList();
            annotationList2.getClass();
            return loadAnnotations(annotationList2, (List) protoBuf$Function.getExtension(this.f101protocol.getFunctionAnnotation()), protoContainer.getNameResolver());
        }
        if (!(messageLite instanceof ProtoBuf$Property)) {
            Utf8$$ExternalSyntheticBUOutline0.m("Unknown message: ", messageLite);
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
        if (i == 1) {
            ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) messageLite;
            List<ProtoBuf$Annotation> annotationList3 = protoBuf$Property.getAnnotationList();
            annotationList3.getClass();
            return loadAnnotations(annotationList3, (List) protoBuf$Property.getExtension(this.f101protocol.getPropertyAnnotation()), protoContainer.getNameResolver());
        }
        if (i == 2) {
            ProtoBuf$Property protoBuf$Property2 = (ProtoBuf$Property) messageLite;
            List<ProtoBuf$Annotation> getterAnnotationList = protoBuf$Property2.getGetterAnnotationList();
            getterAnnotationList.getClass();
            return loadAnnotations(getterAnnotationList, (List) protoBuf$Property2.getExtension(this.f101protocol.getPropertyGetterAnnotation()), protoContainer.getNameResolver());
        }
        if (i != 3) {
            Utf8$$ExternalSyntheticBUOutline0.m$3("Unsupported callable kind with property proto");
            return null;
        }
        ProtoBuf$Property protoBuf$Property3 = (ProtoBuf$Property) messageLite;
        List<ProtoBuf$Annotation> setterAnnotationList = protoBuf$Property3.getSetterAnnotationList();
        setterAnnotationList.getClass();
        return loadAnnotations(setterAnnotationList, (List) protoBuf$Property3.getExtension(this.f101protocol.getPropertySetterAnnotation()), protoContainer.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadClassAnnotations(ProtoContainer.Class r4) {
        r4.getClass();
        List<ProtoBuf$Annotation> annotationList = r4.getClassProto().getAnnotationList();
        annotationList.getClass();
        return loadAnnotations(annotationList, (List) r4.getClassProto().getExtension(this.f101protocol.getClassAnnotation()), r4.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadContextParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        List<A> listLoadValueParameterAnnotations = protoBuf$ValueParameter != null ? loadValueParameterAnnotations(protoContainer, messageLite, annotatedCallableKind, i, protoBuf$ValueParameter) : null;
        return listLoadValueParameterAnnotations == null ? CollectionsKt.emptyList() : listLoadValueParameterAnnotations;
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadEnumEntryAnnotations(ProtoContainer protoContainer, ProtoBuf$EnumEntry protoBuf$EnumEntry) {
        protoContainer.getClass();
        protoBuf$EnumEntry.getClass();
        List<ProtoBuf$Annotation> annotationList = protoBuf$EnumEntry.getAnnotationList();
        annotationList.getClass();
        return loadAnnotations(annotationList, (List) protoBuf$EnumEntry.getExtension(this.f101protocol.getEnumEntryAnnotation()), protoContainer.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadExtensionReceiverParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        if (messageLite instanceof ProtoBuf$Function) {
            ProtoBuf$Function protoBuf$Function = (ProtoBuf$Function) messageLite;
            List<ProtoBuf$Annotation> extensionReceiverAnnotationList = protoBuf$Function.getExtensionReceiverAnnotationList();
            extensionReceiverAnnotationList.getClass();
            GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> functionExtensionReceiverAnnotation = this.f101protocol.getFunctionExtensionReceiverAnnotation();
            return loadAnnotations(extensionReceiverAnnotationList, functionExtensionReceiverAnnotation != null ? (List) protoBuf$Function.getExtension(functionExtensionReceiverAnnotation) : null, protoContainer.getNameResolver());
        }
        if (!(messageLite instanceof ProtoBuf$Property)) {
            Utf8$$ExternalSyntheticBUOutline0.m("Unknown message: ", messageLite);
            return null;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[annotatedCallableKind.ordinal()];
        if (i != 1 && i != 2 && i != 3) {
            Utf8$$ExternalSyntheticBUOutline0.m("Unsupported callable kind with property proto for receiver annotations: ", annotatedCallableKind);
            return null;
        }
        ProtoBuf$Property protoBuf$Property = (ProtoBuf$Property) messageLite;
        List<ProtoBuf$Annotation> extensionReceiverAnnotationList2 = protoBuf$Property.getExtensionReceiverAnnotationList();
        extensionReceiverAnnotationList2.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyExtensionReceiverAnnotation = this.f101protocol.getPropertyExtensionReceiverAnnotation();
        return loadAnnotations(extensionReceiverAnnotationList2, propertyExtensionReceiverAnnotation != null ? (List) protoBuf$Property.getExtension(propertyExtensionReceiverAnnotation) : null, protoContainer.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyBackingFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        protoContainer.getClass();
        protoBuf$Property.getClass();
        List<ProtoBuf$Annotation> backingFieldAnnotationList = protoBuf$Property.getBackingFieldAnnotationList();
        backingFieldAnnotationList.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyBackingFieldAnnotation = this.f101protocol.getPropertyBackingFieldAnnotation();
        return loadAnnotations(backingFieldAnnotationList, propertyBackingFieldAnnotation != null ? (List) protoBuf$Property.getExtension(propertyBackingFieldAnnotation) : null, protoContainer.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadPropertyDelegateFieldAnnotations(ProtoContainer protoContainer, ProtoBuf$Property protoBuf$Property) {
        protoContainer.getClass();
        protoBuf$Property.getClass();
        List<ProtoBuf$Annotation> delegateFieldAnnotationList = protoBuf$Property.getDelegateFieldAnnotationList();
        delegateFieldAnnotationList.getClass();
        GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyDelegatedFieldAnnotation = this.f101protocol.getPropertyDelegatedFieldAnnotation();
        return loadAnnotations(delegateFieldAnnotationList, propertyDelegatedFieldAnnotation != null ? (List) protoBuf$Property.getExtension(propertyDelegatedFieldAnnotation) : null, protoContainer.getNameResolver());
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeAnnotations(ProtoBuf$Type protoBuf$Type, NameResolver nameResolver) {
        protoBuf$Type.getClass();
        nameResolver.getClass();
        List<ProtoBuf$Annotation> annotationList = protoBuf$Type.getAnnotationList();
        annotationList.getClass();
        return loadAnnotations(annotationList, (List) protoBuf$Type.getExtension(this.f101protocol.getTypeAnnotation()), nameResolver);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadTypeParameterAnnotations(ProtoBuf$TypeParameter protoBuf$TypeParameter, NameResolver nameResolver) {
        protoBuf$TypeParameter.getClass();
        nameResolver.getClass();
        List<ProtoBuf$Annotation> annotationList = protoBuf$TypeParameter.getAnnotationList();
        annotationList.getClass();
        return loadAnnotations(annotationList, (List) protoBuf$TypeParameter.getExtension(this.f101protocol.getTypeParameterAnnotation()), nameResolver);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.AnnotationLoader
    public List<A> loadValueParameterAnnotations(ProtoContainer protoContainer, MessageLite messageLite, AnnotatedCallableKind annotatedCallableKind, int i, ProtoBuf$ValueParameter protoBuf$ValueParameter) {
        protoContainer.getClass();
        messageLite.getClass();
        annotatedCallableKind.getClass();
        protoBuf$ValueParameter.getClass();
        List<ProtoBuf$Annotation> annotationList = protoBuf$ValueParameter.getAnnotationList();
        annotationList.getClass();
        return loadAnnotations(annotationList, (List) protoBuf$ValueParameter.getExtension(this.f101protocol.getParameterAnnotation()), protoContainer.getNameResolver());
    }
}
