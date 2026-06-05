package kotlin.reflect.jvm.internal.impl.km.jvm.internal;

import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.jvm.internal.impl.km.KmProperty;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmClassExtension;
import kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtensionType;

/* JADX INFO: loaded from: classes5.dex */
public final class JvmClassExtension implements KmClassExtension {
    public static final Companion Companion = new Companion(null);
    private static final KmExtensionType TYPE = new KmExtensionType(Reflection.getOrCreateKotlinClass(JvmClassExtension.class));
    private String anonymousObjectOriginName;
    private int jvmFlags;
    private final List<KmProperty> localDelegatedProperties = new ArrayList(0);
    private String moduleName;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KmExtensionType getTYPE() {
            return JvmClassExtension.TYPE;
        }

        private Companion() {
        }
    }

    public final int getJvmFlags() {
        return this.jvmFlags;
    }

    public final List<KmProperty> getLocalDelegatedProperties() {
        return this.localDelegatedProperties;
    }

    public final String getModuleName() {
        return this.moduleName;
    }

    @Override // kotlin.reflect.jvm.internal.impl.km.internal.extensions.KmExtension
    public KmExtensionType getType() {
        return TYPE;
    }

    public final void setAnonymousObjectOriginName(String str) {
        this.anonymousObjectOriginName = str;
    }

    public final void setJvmFlags(int i) {
        this.jvmFlags = i;
    }

    public final void setModuleName(String str) {
        this.moduleName = str;
    }
}
