package androidx.constraintlayout.core;

import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes.dex */
public class Cache {
    Pools$Pool<ArrayRow> mArrayRowPool;
    SolverVariable[] mIndexedVariables = new SolverVariable[32];
    Pools$Pool<ArrayRow> mOptimizedArrayRowPool;
    Pools$Pool<SolverVariable> mSolverVariablePool;

    public Cache() {
        final int i = 256;
        this.mOptimizedArrayRowPool = new Pools$Pool<T>(i) { // from class: androidx.constraintlayout.core.Pools$SimplePool
            private final Object[] mPool;
            private int mPoolSize;

            {
                if (i > 0) {
                    this.mPool = new Object[i];
                } else {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("The max pool size must be > 0");
                    throw null;
                }
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public T acquire() {
                int i2 = this.mPoolSize;
                if (i2 <= 0) {
                    return null;
                }
                int i3 = i2 - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i3];
                objArr[i3] = null;
                this.mPoolSize = i2 - 1;
                return t;
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public boolean release(T t) {
                int i2 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i2 >= objArr.length) {
                    return false;
                }
                objArr[i2] = t;
                this.mPoolSize = i2 + 1;
                return true;
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public void releaseAll(T[] tArr, int i2) {
                if (i2 > tArr.length) {
                    i2 = tArr.length;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    T t = tArr[i3];
                    int i4 = this.mPoolSize;
                    Object[] objArr = this.mPool;
                    if (i4 < objArr.length) {
                        objArr[i4] = t;
                        this.mPoolSize = i4 + 1;
                    }
                }
            }
        };
        this.mArrayRowPool = new Pools$Pool<T>(i) { // from class: androidx.constraintlayout.core.Pools$SimplePool
            private final Object[] mPool;
            private int mPoolSize;

            {
                if (i > 0) {
                    this.mPool = new Object[i];
                } else {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("The max pool size must be > 0");
                    throw null;
                }
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public T acquire() {
                int i2 = this.mPoolSize;
                if (i2 <= 0) {
                    return null;
                }
                int i3 = i2 - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i3];
                objArr[i3] = null;
                this.mPoolSize = i2 - 1;
                return t;
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public boolean release(T t) {
                int i2 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i2 >= objArr.length) {
                    return false;
                }
                objArr[i2] = t;
                this.mPoolSize = i2 + 1;
                return true;
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public void releaseAll(T[] tArr, int i2) {
                if (i2 > tArr.length) {
                    i2 = tArr.length;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    T t = tArr[i3];
                    int i4 = this.mPoolSize;
                    Object[] objArr = this.mPool;
                    if (i4 < objArr.length) {
                        objArr[i4] = t;
                        this.mPoolSize = i4 + 1;
                    }
                }
            }
        };
        this.mSolverVariablePool = new Pools$Pool<T>(i) { // from class: androidx.constraintlayout.core.Pools$SimplePool
            private final Object[] mPool;
            private int mPoolSize;

            {
                if (i > 0) {
                    this.mPool = new Object[i];
                } else {
                    Utf8$$ExternalSyntheticBUOutline0.m$2("The max pool size must be > 0");
                    throw null;
                }
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public T acquire() {
                int i2 = this.mPoolSize;
                if (i2 <= 0) {
                    return null;
                }
                int i3 = i2 - 1;
                Object[] objArr = this.mPool;
                T t = (T) objArr[i3];
                objArr[i3] = null;
                this.mPoolSize = i2 - 1;
                return t;
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public boolean release(T t) {
                int i2 = this.mPoolSize;
                Object[] objArr = this.mPool;
                if (i2 >= objArr.length) {
                    return false;
                }
                objArr[i2] = t;
                this.mPoolSize = i2 + 1;
                return true;
            }

            @Override // androidx.constraintlayout.core.Pools$Pool
            public void releaseAll(T[] tArr, int i2) {
                if (i2 > tArr.length) {
                    i2 = tArr.length;
                }
                for (int i3 = 0; i3 < i2; i3++) {
                    T t = tArr[i3];
                    int i4 = this.mPoolSize;
                    Object[] objArr = this.mPool;
                    if (i4 < objArr.length) {
                        objArr[i4] = t;
                        this.mPoolSize = i4 + 1;
                    }
                }
            }
        };
    }
}
