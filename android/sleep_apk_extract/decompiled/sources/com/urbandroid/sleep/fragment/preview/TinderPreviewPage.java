package com.urbandroid.sleep.fragment.preview;

import com.urbandroid.sleep.R;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0002\u0016\u0017BM\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage;", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "", "tinderId", "Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage$LikeCallback;", "callback", "", "title", "text", "", "backgroundResource", "bottomBackgroundResource", "imageResource", "anim", "<init>", "(Ljava/lang/String;Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage$LikeCallback;Ljava/lang/CharSequence;Ljava/lang/CharSequence;IIII)V", "Ljava/lang/String;", "getTinderId", "()Ljava/lang/String;", "Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage$LikeCallback;", "getCallback", "()Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage$LikeCallback;", "LikeCallback", "EmptyLikeCallback", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TinderPreviewPage extends PreviewPage {
    private final LikeCallback callback;
    private final String tinderId;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage$EmptyLikeCallback;", "Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage$LikeCallback;", "Ljava/io/Serializable;", "<init>", "()V", "like", "", "dislike", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static class EmptyLikeCallback implements LikeCallback, Serializable {
        @Override // com.urbandroid.sleep.fragment.preview.TinderPreviewPage.LikeCallback
        public void dislike() {
        }

        @Override // com.urbandroid.sleep.fragment.preview.TinderPreviewPage.LikeCallback
        public void like() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/TinderPreviewPage$LikeCallback;", "Ljava/io/Serializable;", "like", "", "dislike", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface LikeCallback extends Serializable {
        void dislike();

        void like();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TinderPreviewPage(String str, LikeCallback likeCallback, CharSequence charSequence, CharSequence charSequence2, int i, int i2, int i3, int i4) {
        super(str, charSequence, charSequence2, i, i2, i3, i4);
        str.getClass();
        likeCallback.getClass();
        this.tinderId = str;
        this.callback = likeCallback;
        setPageLayout(R.layout.fragment_preview_page_tinder);
    }

    public final LikeCallback getCallback() {
        return this.callback;
    }
}
