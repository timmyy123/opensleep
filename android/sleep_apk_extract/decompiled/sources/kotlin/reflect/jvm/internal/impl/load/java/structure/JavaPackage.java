package kotlin.reflect.jvm.internal.impl.load.java.structure;

import java.util.Collection;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* JADX INFO: loaded from: classes5.dex */
public interface JavaPackage extends JavaAnnotationOwner {
    Collection<JavaClass> getClasses(Function1<? super Name, Boolean> function1);

    FqName getFqName();

    Collection<JavaPackage> getSubPackages();
}
