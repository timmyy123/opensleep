package kotlin.reflect.jvm.internal.impl.km;

import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface KmDeclarationContainer {
    List<KmFunction> getFunctions();

    List<KmProperty> getProperties();

    List<KmTypeAlias> getTypeAliases();
}
