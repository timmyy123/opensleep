package com.urbandroid.sleep.media;

import com.google.android.material.slider.LabelFormatter;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.sleep.media.MediaListActivity;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class MediaListActivity$$ExternalSyntheticLambda3 implements MediaListActivity.OnChangeListener, MediaListActivity.LoadAlbumListener, LabelFormatter {
    public final /* synthetic */ BaseActivity f$0;

    public /* synthetic */ MediaListActivity$$ExternalSyntheticLambda3(BaseActivity baseActivity) {
        this.f$0 = baseActivity;
    }

    @Override // com.urbandroid.sleep.media.MediaListActivity.LoadAlbumListener
    public void finished() {
        ((MediaListActivity) this.f$0).lambda$onCreateDialog$5();
    }

    @Override // com.google.android.material.slider.LabelFormatter
    public String getFormattedValue(float f) {
        return ((PlayAudioActivity) this.f$0).lambda$onCreate$3(f);
    }

    @Override // com.urbandroid.sleep.media.MediaListActivity.OnChangeListener
    public void onChange() {
        ((MediaListActivity) this.f$0).lambda$onCreateDialog$5();
    }
}
