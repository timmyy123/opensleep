package com.urbandroid.sleep.captcha.barcode;

import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.Tracker;
import com.google.android.gms.vision.barcode.Barcode;
import com.urbandroid.sleep.captcha.camera.GraphicOverlay;

/* JADX INFO: loaded from: classes4.dex */
class BarcodeGraphicTracker extends Tracker<Barcode> {
    private BarcodeGraphic mGraphic;
    private GraphicOverlay<BarcodeGraphic> mOverlay;

    public BarcodeGraphicTracker(GraphicOverlay<BarcodeGraphic> graphicOverlay, BarcodeGraphic barcodeGraphic) {
        this.mOverlay = graphicOverlay;
        this.mGraphic = barcodeGraphic;
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onDone() {
        this.mOverlay.remove(this.mGraphic);
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onMissing(Detector.Detections<Barcode> detections) {
        this.mOverlay.remove(this.mGraphic);
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onUpdate(Detector.Detections<Barcode> detections, Barcode barcode) {
        this.mOverlay.add(this.mGraphic);
        this.mGraphic.updateItem(barcode);
    }

    @Override // com.google.android.gms.vision.Tracker
    public void onNewItem(int i, Barcode barcode) {
        this.mGraphic.setId(i);
    }
}
