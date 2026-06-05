package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

/* JADX INFO: loaded from: classes5.dex */
public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    @Override // java.lang.Comparable
    public int compareTo(DeprecationInfo deprecationInfo) {
        deprecationInfo.getClass();
        int iCompareTo = getDeprecationLevel().compareTo(deprecationInfo.getDeprecationLevel());
        if (iCompareTo == 0 && !getPropagatesToOverrides() && deprecationInfo.getPropagatesToOverrides()) {
            return 1;
        }
        return iCompareTo;
    }

    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();
}
