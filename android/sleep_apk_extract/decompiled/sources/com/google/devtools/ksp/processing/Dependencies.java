package com.google.devtools.ksp.processing;

import com.google.devtools.ksp.symbol.KSFile;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\n\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B'\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tB%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\n\"\u00020\u0006¢\u0006\u0004\b\b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u0003\u0010\u000eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\r\u001a\u0004\b\u000f\u0010\u000eR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/google/devtools/ksp/processing/Dependencies;", "", "", "isAllSources", "aggregating", "", "Lcom/google/devtools/ksp/symbol/KSFile;", "originatingFiles", "<init>", "(ZZLjava/util/List;)V", "", "sources", "(Z[Lcom/google/devtools/ksp/symbol/KSFile;)V", "Z", "()Z", "getAggregating", "Ljava/util/List;", "getOriginatingFiles", "()Ljava/util/List;", "Companion", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Dependencies {
    private final boolean aggregating;
    private final boolean isAllSources;
    private final List<KSFile> originatingFiles;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Dependencies ALL_FILES = new Dependencies(true, true, CollectionsKt.emptyList());

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/google/devtools/ksp/processing/Dependencies$Companion;", "", "()V", "ALL_FILES", "Lcom/google/devtools/ksp/processing/Dependencies;", "getALL_FILES", "()Lcom/google/devtools/ksp/processing/Dependencies;", "api"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Dependencies getALL_FILES() {
            return Dependencies.ALL_FILES;
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Dependencies(boolean z, KSFile... kSFileArr) {
        this(false, z, ArraysKt.toList(kSFileArr));
        kSFileArr.getClass();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Dependencies(boolean z, boolean z2, List<? extends KSFile> list) {
        this.isAllSources = z;
        this.aggregating = z2;
        this.originatingFiles = list;
    }
}
