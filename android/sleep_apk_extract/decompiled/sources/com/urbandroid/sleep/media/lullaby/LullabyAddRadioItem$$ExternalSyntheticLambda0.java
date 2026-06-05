package com.urbandroid.sleep.media.lullaby;

import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.lullaby.LullabyCategoriesItem;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class LullabyAddRadioItem$$ExternalSyntheticLambda0 implements MediaListActivity.OnChangeListener, MediaListActivity.LoadAlbumListener {
    public final /* synthetic */ LullabyItem f$0;

    public /* synthetic */ LullabyAddRadioItem$$ExternalSyntheticLambda0(LullabyItem lullabyItem) {
        this.f$0 = lullabyItem;
    }

    @Override // com.urbandroid.sleep.media.MediaListActivity.LoadAlbumListener
    public void finished() {
        LullabyCategoriesItem.AnonymousClass1.onTabSelected$lambda$0((LullabyCategoriesItem) this.f$0);
    }

    @Override // com.urbandroid.sleep.media.MediaListActivity.OnChangeListener
    public void onChange() {
        LullabyAddRadioItem.onItemClicked$lambda$0((LullabyAddRadioItem) this.f$0);
    }
}
