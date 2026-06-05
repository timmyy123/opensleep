package com.facebook.ads.redexgen.core;

import com.google.common.collect.ParametricNullness;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2N, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2N extends C2L<K, V>.WrappedList implements RandomAccess {
    public final /* synthetic */ C2L A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.2N != com.google.common.collect.AbstractMapBasedMultimap<K, V>$RandomAccessWrappedList */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.lp != com.google.common.collect.AbstractMapBasedMultimap<K, V>$WrappedCollection */
    /* JADX WARN: Incorrect inner types in method signature: (TK;Ljava/util/List<TV;>;Lcom/facebook/ads/redexgen/X/2L<TK;TV;>.WrappedCollection;)V */
    public C2N(@ParametricNullness final C2L this$0, @CheckForNull Object key, List delegate, C1719lp ancestor) {
        super(this$0, key, delegate, ancestor);
        this.A00 = this$0;
    }
}
