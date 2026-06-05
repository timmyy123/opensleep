package androidx.appsearch.app;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.appsearch.exceptions.AppSearchException;
import androidx.core.util.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class DocumentClassFactoryRegistry {
    private static volatile DocumentClassFactoryRegistry sInstance;
    private final Map<Class<?>, DocumentClassFactory<?>> mFactories = new HashMap();

    private DocumentClassFactoryRegistry() {
    }

    public static DocumentClassFactoryRegistry getInstance() {
        if (sInstance == null) {
            synchronized (DocumentClassFactoryRegistry.class) {
                try {
                    if (sInstance == null) {
                        sInstance = new DocumentClassFactoryRegistry();
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    private DocumentClassFactory<?> loadFactoryByReflection(Class<?> cls) throws AppSearchException {
        String str;
        Package r0 = cls.getPackage();
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new AppSearchException(2, "Failed to find simple name for document class \"" + cls + "\". Perhaps it is anonymous?");
        }
        if (r0 != null) {
            str = r0.getName() + ".";
            canonicalName = canonicalName.substring(str.length()).replace(".", "$$__");
        } else {
            str = "";
        }
        String strM$1 = FileInsert$$ExternalSyntheticOutline0.m$1(str, "$$__AppSearch__", canonicalName);
        try {
            try {
                return (DocumentClassFactory) Class.forName(strM$1).getDeclaredConstructor(null).newInstance(null);
            } catch (Exception e) {
                throw new AppSearchException(2, FileInsert$$ExternalSyntheticOutline0.m("Failed to construct document class converter \"", strM$1, "\""), e);
            }
        } catch (ClassNotFoundException e2) {
            Class<? super Object> superclass = cls.getSuperclass();
            Class<?>[] interfaces = cls.getInterfaces();
            Class<? super Object> cls2 = superclass != Object.class ? superclass : null;
            int length = interfaces.length;
            if (cls2 != null) {
                length++;
            }
            if (length == 1) {
                return cls2 != null ? this.loadFactoryByReflection(cls2) : this.loadFactoryByReflection(interfaces[0]);
            }
            String strM = FileInsert$$ExternalSyntheticOutline0.m("Failed to find document class converter \"", strM$1, "\". Perhaps the annotation processor was not run or the class was proguarded out?");
            if (length > 1) {
                strM = strM.concat(" Or, this class may not have been annotated with @Document, and there is an ambiguity to determine a unique @Document annotated parent class/interface.");
            }
            throw new AppSearchException(2, strM, e2);
        }
    }

    public <T> DocumentClassFactory<T> getOrCreateFactory(Class<T> cls) {
        DocumentClassFactory<T> documentClassFactory;
        Preconditions.checkNotNull(cls);
        synchronized (this) {
            documentClassFactory = (DocumentClassFactory) this.mFactories.get(cls);
        }
        if (documentClassFactory != null) {
            return documentClassFactory;
        }
        DocumentClassFactory<?> documentClassFactory2 = (DocumentClassFactory<T>) loadFactoryByReflection(cls);
        synchronized (this) {
            try {
                DocumentClassFactory<?> documentClassFactory3 = this.mFactories.get(cls);
                if (documentClassFactory3 == null) {
                    this.mFactories.put((Class<?>) cls, documentClassFactory2);
                } else {
                    documentClassFactory2 = (DocumentClassFactory<T>) documentClassFactory3;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return (DocumentClassFactory<T>) documentClassFactory2;
    }

    public <T> DocumentClassFactory<T> getOrCreateFactory(T t) {
        Preconditions.checkNotNull(t);
        return getOrCreateFactory((Class) t.getClass());
    }
}
