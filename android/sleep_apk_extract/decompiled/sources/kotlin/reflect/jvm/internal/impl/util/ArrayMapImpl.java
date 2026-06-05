package kotlin.reflect.jvm.internal.impl.util;

import java.util.Arrays;
import java.util.Iterator;
import kotlin.collections.AbstractIterator;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes5.dex */
public final class ArrayMapImpl<T> extends ArrayMap<T> {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: renamed from: data, reason: collision with root package name */
    private Object[] f102data;
    private int size;

    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private ArrayMapImpl(Object[] objArr, int i) {
        super(null);
        this.f102data = objArr;
        this.size = i;
    }

    private final void ensureCapacity(int i) {
        Object[] objArr = this.f102data;
        if (objArr.length > i) {
            return;
        }
        int length = objArr.length;
        do {
            length *= 2;
        } while (length <= i);
        this.f102data = Arrays.copyOf(this.f102data, length);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public T get(int i) {
        return (T) ArraysKt.getOrNull(this.f102data, i);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap, java.lang.Iterable
    public Iterator<T> iterator() {
        return new AbstractIterator<T>(this) { // from class: kotlin.reflect.jvm.internal.impl.util.ArrayMapImpl.iterator.1
            private int index = -1;
            final /* synthetic */ ArrayMapImpl<T> this$0;

            {
                this.this$0 = this;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.collections.AbstractIterator
            public void computeNext() {
                do {
                    int i = this.index + 1;
                    this.index = i;
                    if (i >= ((ArrayMapImpl) this.this$0).f102data.length) {
                        break;
                    }
                } while (((ArrayMapImpl) this.this$0).f102data[this.index] == null);
                if (this.index >= ((ArrayMapImpl) this.this$0).f102data.length) {
                    done();
                    return;
                }
                Object obj = ((ArrayMapImpl) this.this$0).f102data[this.index];
                obj.getClass();
                setNext(obj);
            }
        };
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.ArrayMap
    public void set(int i, T t) {
        t.getClass();
        ensureCapacity(i);
        if (this.f102data[i] == null) {
            this.size = getSize() + 1;
        }
        this.f102data[i] = t;
    }

    public ArrayMapImpl() {
        this(new Object[20], 0);
    }
}
