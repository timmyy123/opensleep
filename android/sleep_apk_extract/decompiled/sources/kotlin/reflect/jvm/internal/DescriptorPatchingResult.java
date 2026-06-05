package kotlin.reflect.jvm.internal;

import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lkotlin/reflect/jvm/internal/DescriptorPatchingResult;", "", "newDescriptor", "", "boxedIndices", "", "", "<init>", "(Ljava/lang/String;Ljava/util/Set;)V", "getNewDescriptor", "()Ljava/lang/String;", "getBoxedIndices", "()Ljava/util/Set;", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class DescriptorPatchingResult {
    private final Set<Integer> boxedIndices;
    private final String newDescriptor;

    public DescriptorPatchingResult(String str, Set<Integer> set) {
        str.getClass();
        set.getClass();
        this.newDescriptor = str;
        this.boxedIndices = set;
    }

    public final Set<Integer> getBoxedIndices() {
        return this.boxedIndices;
    }

    public final String getNewDescriptor() {
        return this.newDescriptor;
    }
}
