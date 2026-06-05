package com.urbandroid.sleep.smartlight;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\u0003J\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\f\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0016\u0010\u0003J\u000f\u0010\u0017\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0017\u0010\u0003J\u000f\u0010\u0018\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0018\u0010\u0003J\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0018\u0010\u0011J\u000f\u0010\u001a\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001a\u0010\u0003J\u000f\u0010\u001b\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001b\u0010\u0003R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, d2 = {"Lcom/urbandroid/sleep/smartlight/EnsembleSmartLight;", "Lcom/urbandroid/sleep/smartlight/SmartLight;", "<init>", "()V", "smartLight", "", "add", "(Lcom/urbandroid/sleep/smartlight/SmartLight;)Z", "", "size", "()I", "", "off", "force", "(Z)V", "timeoutSeconds", "nightLight", "(I)V", "progress", "max", "sunrise", "(II)V", "sunriseStart", "sunriseFull", ViewHierarchyConstants.HINT_KEY, "loop", "shortHint", "close", "", "smartLights", "Ljava/util/Set;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnsembleSmartLight implements SmartLight {
    private final Set<SmartLight> smartLights = new LinkedHashSet();

    public final boolean add(SmartLight smartLight) {
        smartLight.getClass();
        return this.smartLights.add(smartLight);
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void close() {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).close();
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint() {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).hint();
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void nightLight(int timeoutSeconds) {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).nightLight(timeoutSeconds);
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off() {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).off();
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void shortHint() {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).shortHint();
        }
    }

    public final int size() {
        return this.smartLights.size();
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunrise(int progress, int max) {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).sunrise(progress, max);
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseFull() {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).sunriseFull();
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void sunriseStart() {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).sunriseStart();
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void hint(int loop) {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).hint(loop);
        }
    }

    @Override // com.urbandroid.sleep.smartlight.SmartLight
    public void off(boolean force) {
        Iterator<T> it = this.smartLights.iterator();
        while (it.hasNext()) {
            ((SmartLight) it.next()).off(force);
        }
    }
}
