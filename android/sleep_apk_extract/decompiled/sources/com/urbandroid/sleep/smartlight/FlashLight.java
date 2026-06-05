package com.urbandroid.sleep.smartlight;

import android.os.Handler;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.nearby.core.Endpoint$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.service.IFlashlightService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\nJ\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\fH\u0096\u0001¢\u0006\u0004\b\u000b\u0010\u000eJ\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0017\u0010\nJ\u0010\u0010\u0018\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0010\u0010\u0019\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\nJ\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u000fH\u0096\u0001¢\u0006\u0004\b\u0019\u0010\u0012J\u0010\u0010\u001b\u001a\u00020\bH\u0096\u0001¢\u0006\u0004\b\u001b\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/smartlight/FlashLight;", "Lcom/urbandroid/sleep/smartlight/SmartLight;", "Lcom/urbandroid/sleep/service/IFlashlightService;", "flashlightService", "Landroid/os/Handler;", "h", "<init>", "(Lcom/urbandroid/sleep/service/IFlashlightService;Landroid/os/Handler;)V", "", "shortHint", "()V", "off", "", "force", "(Z)V", "", "timeoutSeconds", "nightLight", "(I)V", "progress", "max", "sunrise", "(II)V", "sunriseStart", "sunriseFull", ViewHierarchyConstants.HINT_KEY, "loop", "close", "Lcom/urbandroid/sleep/service/IFlashlightService;", "Landroid/os/Handler;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class FlashLight implements SmartLight {
    private final /* synthetic */ Dummy $$delegate_0;
    private final IFlashlightService flashlightService;
    private final Handler h;

    public FlashLight(IFlashlightService iFlashlightService, Handler handler) {
        iFlashlightService.getClass();
        handler.getClass();
        this.$$delegate_0 = new Dummy();
        this.flashlightService = iFlashlightService;
        this.h = handler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void shortHint$lambda$0(FlashLight flashLight) {
        flashLight.flashlightService.turnOff();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void close() {
        this.$$delegate_0.close();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint() {
        this.$$delegate_0.hint();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void nightLight(int timeoutSeconds) {
        this.$$delegate_0.nightLight(timeoutSeconds);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off() {
        this.$$delegate_0.off();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void shortHint() {
        this.flashlightService.turnOn();
        this.h.postDelayed(new Endpoint$$ExternalSyntheticLambda0(this, 7), 2L);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunrise(int progress, int max) {
        this.$$delegate_0.sunrise(progress, max);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseFull() {
        this.$$delegate_0.sunriseFull();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseStart() {
        this.$$delegate_0.sunriseStart();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint(int loop) {
        this.$$delegate_0.hint(loop);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off(boolean force) {
        this.$$delegate_0.off(force);
    }
}
