package io.ktor.client.plugins;

import io.ktor.client.plugins.DefaultTransformKt;
import io.ktor.client.plugins.internal.ByteChannelReplay;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CompletableJob;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class DefaultTransformKt$defaultTransformers$2$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ DefaultTransformKt$defaultTransformers$2$$ExternalSyntheticLambda0(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                return DefaultTransformKt.AnonymousClass2.invokeSuspend$lambda$1$lambda$0((CompletableJob) obj);
            default:
                return ((ByteChannelReplay) obj).replay();
        }
    }
}
