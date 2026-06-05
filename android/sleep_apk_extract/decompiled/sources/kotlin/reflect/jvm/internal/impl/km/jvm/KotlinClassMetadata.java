package kotlin.reflect.jvm.internal.impl.km.jvm;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.km.KmClass;
import kotlin.reflect.jvm.internal.impl.km.KmLambda;
import kotlin.reflect.jvm.internal.impl.km.KmPackage;
import kotlin.reflect.jvm.internal.impl.km.jvm.internal.JvmReadUtils;

/* JADX INFO: loaded from: classes5.dex */
public abstract class KotlinClassMetadata {
    public static final Companion Companion = new Companion(null);
    private boolean isAllowedToWrite;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KotlinClassMetadata readLenient(Metadata metadata) {
            metadata.getClass();
            return JvmReadUtils.INSTANCE.readMetadataImpl$kotlin_metadata_jvm(metadata, true);
        }

        private Companion() {
        }
    }

    public static final class Unknown extends KotlinClassMetadata {
        private int flags;
        private final boolean lenient;
        private final Metadata original;
        private JvmMetadataVersion version;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Unknown(Metadata metadata, boolean z) {
            super(null);
            metadata.getClass();
            this.original = metadata;
            this.lenient = z;
            this.version = new JvmMetadataVersion(metadata.mv());
            this.flags = metadata.xi();
        }
    }

    private KotlinClassMetadata() {
        this.isAllowedToWrite = true;
    }

    public final void setAllowedToWrite$kotlin_metadata_jvm(boolean z) {
        this.isAllowedToWrite = z;
    }

    public /* synthetic */ KotlinClassMetadata(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final class Class extends KotlinClassMetadata {
        private int flags;
        private KmClass kmClass;
        private JvmMetadataVersion version;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Class(Metadata metadata, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmClass$kotlin_metadata_jvm(metadata), new JvmMetadataVersion(metadata.mv()), metadata.xi());
            metadata.getClass();
            setAllowedToWrite$kotlin_metadata_jvm(!z);
        }

        public final KmClass getKmClass() {
            return this.kmClass;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Class(KmClass kmClass, JvmMetadataVersion jvmMetadataVersion, int i) {
            super(null);
            kmClass.getClass();
            jvmMetadataVersion.getClass();
            this.kmClass = kmClass;
            this.version = jvmMetadataVersion;
            this.flags = i;
        }
    }

    public static final class FileFacade extends KotlinClassMetadata {
        private int flags;
        private KmPackage kmPackage;
        private JvmMetadataVersion version;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public FileFacade(Metadata metadata, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmPackage$kotlin_metadata_jvm(metadata), new JvmMetadataVersion(metadata.mv()), metadata.xi());
            metadata.getClass();
            setAllowedToWrite$kotlin_metadata_jvm(!z);
        }

        public final KmPackage getKmPackage() {
            return this.kmPackage;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FileFacade(KmPackage kmPackage, JvmMetadataVersion jvmMetadataVersion, int i) {
            super(null);
            kmPackage.getClass();
            jvmMetadataVersion.getClass();
            this.kmPackage = kmPackage;
            this.version = jvmMetadataVersion;
            this.flags = i;
        }
    }

    public static final class SyntheticClass extends KotlinClassMetadata {
        private int flags;
        private KmLambda kmLambda;
        private JvmMetadataVersion version;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public SyntheticClass(Metadata metadata, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmLambda$kotlin_metadata_jvm(metadata), new JvmMetadataVersion(metadata.mv()), metadata.xi());
            metadata.getClass();
            setAllowedToWrite$kotlin_metadata_jvm(!z);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SyntheticClass(KmLambda kmLambda, JvmMetadataVersion jvmMetadataVersion, int i) {
            super(null);
            jvmMetadataVersion.getClass();
            this.kmLambda = kmLambda;
            this.version = jvmMetadataVersion;
            this.flags = i;
        }
    }

    public static final class MultiFileClassFacade extends KotlinClassMetadata {
        private int flags;
        private List<String> partClassNames;
        private JvmMetadataVersion version;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MultiFileClassFacade(Metadata metadata, boolean z) {
            this(ArraysKt.asList(metadata.d1()), new JvmMetadataVersion(metadata.mv()), metadata.xi());
            metadata.getClass();
            setAllowedToWrite$kotlin_metadata_jvm(!z);
        }

        public final List<String> getPartClassNames() {
            return this.partClassNames;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiFileClassFacade(List<String> list, JvmMetadataVersion jvmMetadataVersion, int i) {
            super(null);
            list.getClass();
            jvmMetadataVersion.getClass();
            this.partClassNames = list;
            this.version = jvmMetadataVersion;
            this.flags = i;
        }
    }

    public static final class MultiFileClassPart extends KotlinClassMetadata {
        private String facadeClassName;
        private int flags;
        private KmPackage kmPackage;
        private JvmMetadataVersion version;

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public MultiFileClassPart(Metadata metadata, boolean z) {
            this(JvmReadUtils.INSTANCE.readKmPackage$kotlin_metadata_jvm(metadata), metadata.xs(), new JvmMetadataVersion(metadata.mv()), metadata.xi());
            metadata.getClass();
            setAllowedToWrite$kotlin_metadata_jvm(!z);
        }

        public final KmPackage getKmPackage() {
            return this.kmPackage;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiFileClassPart(KmPackage kmPackage, String str, JvmMetadataVersion jvmMetadataVersion, int i) {
            super(null);
            kmPackage.getClass();
            str.getClass();
            jvmMetadataVersion.getClass();
            this.kmPackage = kmPackage;
            this.facadeClassName = str;
            this.version = jvmMetadataVersion;
            this.flags = i;
        }
    }
}
