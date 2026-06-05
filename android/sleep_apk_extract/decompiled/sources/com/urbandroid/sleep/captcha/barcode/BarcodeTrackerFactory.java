package com.urbandroid.sleep.captcha.barcode;

import com.google.android.gms.vision.MultiProcessor;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;
import com.urbandroid.sleep.captcha.camera.GraphicOverlay;

/* JADX INFO: loaded from: classes4.dex */
class BarcodeTrackerFactory implements MultiProcessor.Factory<Barcode> {
    private GraphicOverlay<BarcodeGraphic> mGraphicOverlay;

    public BarcodeTrackerFactory(GraphicOverlay<BarcodeGraphic> graphicOverlay) {
        this.mGraphicOverlay = graphicOverlay;
    }

    @Override // com.google.android.gms.vision.MultiProcessor.Factory
    public Tracker<Barcode> create(Barcode barcode) {
        return new BarcodeGraphicTracker(this.mGraphicOverlay, new BarcodeGraphic(this.mGraphicOverlay));
    }
}
