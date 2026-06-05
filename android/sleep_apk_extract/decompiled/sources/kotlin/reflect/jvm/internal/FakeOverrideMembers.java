package kotlin.reflect.jvm.internal;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import androidx.fragment.app.Fragment$$ExternalSyntheticOutline1;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.EqualityMode;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B9\u0012 \u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0003j\u0002`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0012\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0003j\u0002`\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J\t\u0010\u0014\u001a\u00020\tHÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\"\b\u0002\u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0003j\u0002`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R+\u0010\u0002\u001a\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0003j\u0002`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lkotlin/reflect/jvm/internal/FakeOverrideMembers;", "", "members", "", "Lkotlin/reflect/jvm/internal/EquatableCallableSignature;", "Lkotlin/reflect/jvm/internal/EqualityMode$JavaSignature;", "Lkotlin/reflect/jvm/internal/DescriptorKCallable;", "Lkotlin/reflect/jvm/internal/MembersJavaSignatureMap;", "containsInheritedStatics", "", "containsPackagePrivate", "<init>", "(Ljava/util/Map;ZZ)V", "getMembers", "()Ljava/util/Map;", "getContainsInheritedStatics", "()Z", "getContainsPackagePrivate", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", InAppPurchaseConstants.METHOD_TO_STRING, "", "kotlin-reflection"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class FakeOverrideMembers {
    private final boolean containsInheritedStatics;
    private final boolean containsPackagePrivate;
    private final Map<EquatableCallableSignature<EqualityMode.JavaSignature>, DescriptorKCallable<?>> members;

    /* JADX WARN: Multi-variable type inference failed */
    public FakeOverrideMembers(Map<EquatableCallableSignature<EqualityMode.JavaSignature>, ? extends DescriptorKCallable<?>> map, boolean z, boolean z2) {
        map.getClass();
        this.members = map;
        this.containsInheritedStatics = z;
        this.containsPackagePrivate = z2;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FakeOverrideMembers)) {
            return false;
        }
        FakeOverrideMembers fakeOverrideMembers = (FakeOverrideMembers) other;
        return Intrinsics.areEqual(this.members, fakeOverrideMembers.members) && this.containsInheritedStatics == fakeOverrideMembers.containsInheritedStatics && this.containsPackagePrivate == fakeOverrideMembers.containsPackagePrivate;
    }

    public final boolean getContainsInheritedStatics() {
        return this.containsInheritedStatics;
    }

    public final boolean getContainsPackagePrivate() {
        return this.containsPackagePrivate;
    }

    public final Map<EquatableCallableSignature<EqualityMode.JavaSignature>, DescriptorKCallable<?>> getMembers() {
        return this.members;
    }

    public int hashCode() {
        return Boolean.hashCode(this.containsPackagePrivate) + FileInsert$$ExternalSyntheticOutline0.m(this.containsInheritedStatics, this.members.hashCode() * 31, 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FakeOverrideMembers(members=");
        sb.append(this.members);
        sb.append(", containsInheritedStatics=");
        sb.append(this.containsInheritedStatics);
        sb.append(", containsPackagePrivate=");
        return Fragment$$ExternalSyntheticOutline1.m(sb, this.containsPackagePrivate, ')');
    }
}
