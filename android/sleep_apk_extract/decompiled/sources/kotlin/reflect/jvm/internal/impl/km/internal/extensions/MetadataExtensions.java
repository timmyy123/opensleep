package kotlin.reflect.jvm.internal.impl.km.internal.extensions;

import java.util.List;
import java.util.ServiceLoader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmConstructor;
import kotlin.reflect.jvm.internal.impl.km.KmEnumEntry;
import kotlin.reflect.jvm.internal.impl.km.KmFunction;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.KmType;
import kotlin.reflect.jvm.internal.impl.km.KmTypeAlias;
import kotlin.reflect.jvm.internal.impl.km.KmTypeParameter;
import kotlin.reflect.jvm.internal.impl.km.KmValueParameter;
import kotlin.reflect.jvm.internal.impl.km.internal.ReadContext;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Class;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Constructor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$EnumEntry;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Function;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Package;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Property;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$Type;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeAlias;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$TypeParameter;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$ValueParameter;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public interface MetadataExtensions {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy<List<MetadataExtensions>> INSTANCES$delegate = LazyKt.lazy(new Function0() { // from class: kotlin.reflect.jvm.internal.impl.km.internal.extensions.MetadataExtensions$Companion$$Lambda$0
            @Override // kotlin.jvm.functions.Function0
            public Object invoke() {
                return MetadataExtensions.Companion.INSTANCES_delegate$lambda$0();
            }
        });

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final List INSTANCES_delegate$lambda$0() {
            ServiceLoader serviceLoaderLoad = ServiceLoader.load(MetadataExtensions.class, MetadataExtensions.class.getClassLoader());
            serviceLoaderLoad.getClass();
            List list = CollectionsKt.toList(serviceLoaderLoad);
            if (!list.isEmpty()) {
                return list;
            }
            Utf8$$ExternalSyntheticBUOutline0.m$3("No MetadataExtensions instances found in the classpath. Please ensure that the META-INF/services/ is not stripped from your application and that the Java virtual machine is not running under a security manager");
            return null;
        }

        public final List<MetadataExtensions> getINSTANCES$kotlin_metadata() {
            return INSTANCES$delegate.getValue();
        }
    }

    KmClassExtension createClassExtension();

    KmConstructorExtension createConstructorExtension();

    KmEnumEntryExtension createEnumEntryExtension();

    KmFunctionExtension createFunctionExtension();

    KmPackageExtension createPackageExtension();

    KmPropertyExtension createPropertyExtension();

    KmTypeAliasExtension createTypeAliasExtension();

    KmTypeExtension createTypeExtension();

    KmTypeParameterExtension createTypeParameterExtension();

    KmValueParameterExtension createValueParameterExtension();

    void readClassExtensions(KmClass kmClass, ProtoBuf$Class protoBuf$Class, ReadContext readContext);

    void readConstructorExtensions(KmConstructor kmConstructor, ProtoBuf$Constructor protoBuf$Constructor, ReadContext readContext);

    void readEnumEntryExtensions(KmEnumEntry kmEnumEntry, ProtoBuf$EnumEntry protoBuf$EnumEntry, ReadContext readContext);

    void readFunctionExtensions(KmFunction kmFunction, ProtoBuf$Function protoBuf$Function, ReadContext readContext);

    void readPackageExtensions(KmPackage kmPackage, ProtoBuf$Package protoBuf$Package, ReadContext readContext);

    void readPropertyExtensions(KmProperty kmProperty, ProtoBuf$Property protoBuf$Property, ReadContext readContext);

    void readTypeAliasExtensions(KmTypeAlias kmTypeAlias, ProtoBuf$TypeAlias protoBuf$TypeAlias, ReadContext readContext);

    void readTypeExtensions(KmType kmType, ProtoBuf$Type protoBuf$Type, ReadContext readContext);

    void readTypeParameterExtensions(KmTypeParameter kmTypeParameter, ProtoBuf$TypeParameter protoBuf$TypeParameter, ReadContext readContext);

    void readValueParameterExtensions(KmValueParameter kmValueParameter, ProtoBuf$ValueParameter protoBuf$ValueParameter, ReadContext readContext);
}
