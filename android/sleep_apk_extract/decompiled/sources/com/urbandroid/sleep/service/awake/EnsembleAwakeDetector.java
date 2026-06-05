package com.urbandroid.sleep.service.awake;

import com.urbandroid.common.logging.Logger;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\u0007J%\u0010\u000b\u001a\u00020\u0005\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0003J\u000f\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0003R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/service/awake/EnsembleAwakeDetector;", "Lcom/urbandroid/sleep/service/awake/AwakeDetector;", "<init>", "()V", "detector", "", "add", "(Lcom/urbandroid/sleep/service/awake/AwakeDetector;)Z", "T", "Ljava/lang/Class;", "type", "hasDetector", "(Ljava/lang/Class;)Z", "isAwake", "()Z", "", "stop", "forceNotAwake", "forceAwakeNow", "onScreenOn", "onScreenOff", "", "detectors", "Ljava/util/Set;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnsembleAwakeDetector implements AwakeDetector {
    private final Set<AwakeDetector> detectors = new LinkedHashSet();

    public final boolean add(AwakeDetector detector) {
        detector.getClass();
        return this.detectors.add(detector);
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void forceAwakeNow() {
        Iterator<T> it = this.detectors.iterator();
        while (it.hasNext()) {
            ((AwakeDetector) it.next()).forceAwakeNow();
        }
        Unit unit = Unit.INSTANCE;
        Logger.logInfo("Awake: forceAwakeNow()");
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void forceNotAwake() {
        Iterator<T> it = this.detectors.iterator();
        while (it.hasNext()) {
            ((AwakeDetector) it.next()).forceNotAwake();
        }
        Unit unit = Unit.INSTANCE;
        Logger.logInfo("Awake: forceNotAwake()");
    }

    public final <T extends AwakeDetector> boolean hasDetector(Class<T> type) {
        type.getClass();
        return !CollectionsKt.filterIsInstance(this.detectors, type).isEmpty();
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public boolean isAwake() {
        Set<AwakeDetector> set = this.detectors;
        if (set != null && set.isEmpty()) {
            return false;
        }
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            if (((AwakeDetector) it.next()).isAwake()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void onScreenOff() {
        Iterator<T> it = this.detectors.iterator();
        while (it.hasNext()) {
            ((AwakeDetector) it.next()).onScreenOff();
        }
        Unit unit = Unit.INSTANCE;
        Logger.logInfo("Awake: onScreenOff()");
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void onScreenOn() {
        Iterator<T> it = this.detectors.iterator();
        while (it.hasNext()) {
            ((AwakeDetector) it.next()).onScreenOn();
        }
        Unit unit = Unit.INSTANCE;
        Logger.logInfo("Awake: onScreenOn()");
    }

    @Override // com.urbandroid.sleep.service.awake.AwakeDetector
    public void stop() {
        Iterator<T> it = this.detectors.iterator();
        while (it.hasNext()) {
            ((AwakeDetector) it.next()).stop();
        }
    }
}
