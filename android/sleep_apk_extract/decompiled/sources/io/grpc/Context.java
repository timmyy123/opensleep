package io.grpc;

import java.io.Closeable;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes5.dex */
public class Context {
    private static final PersistentHashArrayMappedTrie<Key<?>, Object> EMPTY_ENTRIES;
    public static final Context ROOT;
    static final Logger log = Logger.getLogger(Context.class.getName());
    final int generation;
    final PersistentHashArrayMappedTrie<Key<?>, Object> keyValueEntries;
    private CancellationListener parentListener = new ParentListener(this, null);

    /* JADX INFO: renamed from: io.grpc.Context$1, reason: invalid class name */
    abstract class AnonymousClass1 implements Runnable {
    }

    public static final class CancellableContext extends Context implements Closeable {
    }

    public interface CancellationListener {
    }

    public static final class LazyStorage {
        static final Storage storage;

        static {
            AtomicReference atomicReference = new AtomicReference();
            storage = createStorage(atomicReference);
            Throwable th = (Throwable) atomicReference.get();
            if (th != null) {
                Context.log.log(Level.FINE, "Storage override doesn't exist. Using default", th);
            }
        }

        private static Storage createStorage(AtomicReference<? super ClassNotFoundException> atomicReference) {
            try {
                return (Storage) Class.forName("io.grpc.override.ContextStorageOverride").asSubclass(Storage.class).getConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e) {
                atomicReference.set(e);
                return new ThreadLocalContextStorage();
            } catch (Exception e2) {
                Utf8$$ExternalSyntheticBUOutline0.m("Storage override failed to initialize", (Throwable) e2);
                return null;
            }
        }
    }

    public static abstract class Storage {
        public abstract Context current();

        public abstract void detach(Context context, Context context2);

        public abstract Context doAttach(Context context);
    }

    static {
        PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie = new PersistentHashArrayMappedTrie<>();
        EMPTY_ENTRIES = persistentHashArrayMappedTrie;
        ROOT = new Context(null, persistentHashArrayMappedTrie);
    }

    private Context(Context context, PersistentHashArrayMappedTrie<Key<?>, Object> persistentHashArrayMappedTrie) {
        cancellableAncestor(context);
        this.keyValueEntries = persistentHashArrayMappedTrie;
        int i = context == null ? 0 : context.generation + 1;
        this.generation = i;
        validateGeneration(i);
    }

    public static CancellableContext cancellableAncestor(Context context) {
        return null;
    }

    public static <T> T checkNotNull(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static Context current() {
        Context contextCurrent = storage().current();
        return contextCurrent == null ? ROOT : contextCurrent;
    }

    public static <T> Key<T> key(String str) {
        return new Key<>(str);
    }

    public static Storage storage() {
        return LazyStorage.storage;
    }

    private static void validateGeneration(int i) {
        if (i == 1000) {
            log.log(Level.SEVERE, "Context ancestry chain length is abnormally long. This suggests an error in application code. Length exceeded: 1000", (Throwable) new Exception());
        }
    }

    public Context attach() {
        Context contextDoAttach = storage().doAttach(this);
        return contextDoAttach == null ? ROOT : contextDoAttach;
    }

    public void detach(Context context) {
        checkNotNull(context, "toAttach");
        storage().detach(this, context);
    }

    public Object lookup(Key<?> key) {
        return this.keyValueEntries.get(key);
    }

    public <V> Context withValue(Key<V> key, V v) {
        return new Context(this, this.keyValueEntries.put(key, v));
    }

    public final class ParentListener implements CancellationListener {
        private ParentListener() {
        }

        public /* synthetic */ ParentListener(Context context, AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public static final class Key<T> {
        private final T defaultValue;
        private final String name;

        public Key(String str, T t) {
            this.name = (String) Context.checkNotNull(str, "name");
            this.defaultValue = t;
        }

        public T get(Context context) {
            T t = (T) context.lookup(this);
            return t == null ? this.defaultValue : t;
        }

        public String toString() {
            return this.name;
        }

        public Key(String str) {
            this(str, null);
        }
    }
}
