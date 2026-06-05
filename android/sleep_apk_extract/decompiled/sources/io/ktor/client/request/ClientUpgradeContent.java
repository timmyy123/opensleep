package io.ktor.client.request;

import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import io.ktor.http.content.OutgoingContent;
import io.ktor.utils.io.ByteChannel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lio/ktor/client/request/ClientUpgradeContent;", "Lio/ktor/http/content/OutgoingContent$NoContent;", "<init>", "()V", "Lio/ktor/utils/io/ByteChannel;", "content$delegate", "Lkotlin/Lazy;", "getContent", "()Lio/ktor/utils/io/ByteChannel;", "content", "ktor-client-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
public abstract class ClientUpgradeContent extends OutgoingContent.NoContent {

    /* JADX INFO: renamed from: content$delegate, reason: from kotlin metadata */
    private final Lazy content = LazyKt.lazy(new HttpClientConfig$$ExternalSyntheticLambda4(15));

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteChannel content_delegate$lambda$0() {
        return new ByteChannel(false, 1, null);
    }
}
