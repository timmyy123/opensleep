package com.getkeepsafe.taptargetview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import okio.Utf8$$ExternalSyntheticBUOutline0;

/* JADX INFO: loaded from: classes3.dex */
class ViewTapTarget extends TapTarget {
    final View view;

    public ViewTapTarget(View view, CharSequence charSequence, CharSequence charSequence2) {
        super(charSequence, charSequence2);
        if (view != null) {
            this.view = view;
        } else {
            Utf8$$ExternalSyntheticBUOutline0.m$2("Given null view to target");
            throw null;
        }
    }

    @Override // com.getkeepsafe.taptargetview.TapTarget
    public void onReady(final Runnable runnable) {
        ViewUtil.onLaidOut(this.view, new Runnable() { // from class: com.getkeepsafe.taptargetview.ViewTapTarget.1
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = new int[2];
                ViewTapTarget.this.view.getLocationOnScreen(iArr);
                ViewTapTarget viewTapTarget = ViewTapTarget.this;
                int i = iArr[0];
                viewTapTarget.bounds = new Rect(i, iArr[1], ViewTapTarget.this.view.getWidth() + i, ViewTapTarget.this.view.getHeight() + iArr[1]);
                ViewTapTarget viewTapTarget2 = ViewTapTarget.this;
                if (viewTapTarget2.icon == null && viewTapTarget2.view.getWidth() > 0 && ViewTapTarget.this.view.getHeight() > 0) {
                    Bitmap bitmapCreateBitmap = Bitmap.createBitmap(ViewTapTarget.this.view.getWidth(), ViewTapTarget.this.view.getHeight(), Bitmap.Config.ARGB_8888);
                    ViewTapTarget.this.view.draw(new Canvas(bitmapCreateBitmap));
                    ViewTapTarget.this.icon = new BitmapDrawable(ViewTapTarget.this.view.getContext().getResources(), bitmapCreateBitmap);
                    Drawable drawable = ViewTapTarget.this.icon;
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), ViewTapTarget.this.icon.getIntrinsicHeight());
                }
                runnable.run();
            }
        });
    }
}
