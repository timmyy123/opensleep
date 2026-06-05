package kotlin.reflect.jvm.internal.impl.serialization;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Annotation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
import kotlin.reflect.jvm.internal.impl.protobuf.GeneratedMessageLite;

/* JADX INFO: loaded from: classes5.dex */
public abstract class SerializerExtensionProtocol {
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Annotation>> classAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> compileTimeValue;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> constructorAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> enumEntryAnnotation;
    private final ExtensionRegistryLite extensionRegistry;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> functionAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> functionExtensionReceiverAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Package, Integer> packageFqName;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> parameterAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyBackingFieldAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyDelegatedFieldAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyExtensionReceiverAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertyGetterAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> propertySetterAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> typeAnnotation;
    private final GeneratedMessageLite.GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> typeParameterAnnotation;

    public SerializerExtensionProtocol(ExtensionRegistryLite extensionRegistryLite, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Package, Integer> generatedExtension, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> generatedExtension2, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Annotation>> generatedExtension3, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> generatedExtension4, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> generatedExtension5, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension6, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension7, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension8, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension9, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension10, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> generatedExtension11, GeneratedMessageLite.GeneratedExtension<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> generatedExtension12, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> generatedExtension13, GeneratedMessageLite.GeneratedExtension<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> generatedExtension14, GeneratedMessageLite.GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> generatedExtension15, GeneratedMessageLite.GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> generatedExtension16) {
        extensionRegistryLite.getClass();
        generatedExtension.getClass();
        generatedExtension2.getClass();
        generatedExtension3.getClass();
        generatedExtension4.getClass();
        generatedExtension6.getClass();
        generatedExtension7.getClass();
        generatedExtension8.getClass();
        generatedExtension12.getClass();
        generatedExtension13.getClass();
        generatedExtension14.getClass();
        generatedExtension15.getClass();
        generatedExtension16.getClass();
        this.extensionRegistry = extensionRegistryLite;
        this.packageFqName = generatedExtension;
        this.constructorAnnotation = generatedExtension2;
        this.classAnnotation = generatedExtension3;
        this.functionAnnotation = generatedExtension4;
        this.functionExtensionReceiverAnnotation = generatedExtension5;
        this.propertyAnnotation = generatedExtension6;
        this.propertyGetterAnnotation = generatedExtension7;
        this.propertySetterAnnotation = generatedExtension8;
        this.propertyExtensionReceiverAnnotation = generatedExtension9;
        this.propertyBackingFieldAnnotation = generatedExtension10;
        this.propertyDelegatedFieldAnnotation = generatedExtension11;
        this.enumEntryAnnotation = generatedExtension12;
        this.compileTimeValue = generatedExtension13;
        this.parameterAnnotation = generatedExtension14;
        this.typeAnnotation = generatedExtension15;
        this.typeParameterAnnotation = generatedExtension16;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Class, List<ProtoBuf$Annotation>> getClassAnnotation() {
        return this.classAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, ProtoBuf$Annotation.Argument.Value> getCompileTimeValue() {
        return this.compileTimeValue;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Constructor, List<ProtoBuf$Annotation>> getConstructorAnnotation() {
        return this.constructorAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$EnumEntry, List<ProtoBuf$Annotation>> getEnumEntryAnnotation() {
        return this.enumEntryAnnotation;
    }

    public final ExtensionRegistryLite getExtensionRegistry() {
        return this.extensionRegistry;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> getFunctionAnnotation() {
        return this.functionAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Function, List<ProtoBuf$Annotation>> getFunctionExtensionReceiverAnnotation() {
        return this.functionExtensionReceiverAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$ValueParameter, List<ProtoBuf$Annotation>> getParameterAnnotation() {
        return this.parameterAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> getPropertyAnnotation() {
        return this.propertyAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> getPropertyBackingFieldAnnotation() {
        return this.propertyBackingFieldAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> getPropertyDelegatedFieldAnnotation() {
        return this.propertyDelegatedFieldAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> getPropertyExtensionReceiverAnnotation() {
        return this.propertyExtensionReceiverAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> getPropertyGetterAnnotation() {
        return this.propertyGetterAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Property, List<ProtoBuf$Annotation>> getPropertySetterAnnotation() {
        return this.propertySetterAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$Type, List<ProtoBuf$Annotation>> getTypeAnnotation() {
        return this.typeAnnotation;
    }

    public final GeneratedMessageLite.GeneratedExtension<ProtoBuf$TypeParameter, List<ProtoBuf$Annotation>> getTypeParameterAnnotation() {
        return this.typeParameterAnnotation;
    }
}
