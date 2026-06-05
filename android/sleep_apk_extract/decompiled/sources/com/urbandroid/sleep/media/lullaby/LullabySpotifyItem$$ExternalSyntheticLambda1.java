package com.urbandroid.sleep.media.lullaby;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabySpotifyItem$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ Object f$0;

    public /* synthetic */ LullabySpotifyItem$$ExternalSyntheticLambda1(Object obj, int i) {
        this.$r8$classId = i;
        this.f$0 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.$r8$classId;
        Object obj = this.f$0;
        switch (i) {
            case 0:
                LullabySpotifyItem.bindView$lambda$0$0((LullabySpotifyItem) obj);
                break;
            default:
                ((LullabyRecyclerViewAdapter) obj).notifyDataSetChanged();
                break;
        }
    }
}
