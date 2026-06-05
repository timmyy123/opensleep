package androidx.core.app;

import androidx.core.app.JobIntentService;
import com.urbandroid.common.logging.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0010¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/core/app/FixedJobIntentService;", "Landroidx/core/app/JobIntentService;", "<init>", "()V", "dequeueWork", "Landroidx/core/app/JobIntentService$GenericWorkItem;", "dequeueWork$Sleep_prodRelease", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class FixedJobIntentService extends JobIntentService {
    @Override // androidx.core.app.JobIntentService
    /* JADX INFO: renamed from: dequeueWork$Sleep_prodRelease, reason: merged with bridge method [inline-methods] */
    public JobIntentService.GenericWorkItem dequeueWork() {
        try {
            return super.dequeueWork();
        } catch (IllegalArgumentException e) {
            Logger.logSevere(null, e);
            return null;
        } catch (SecurityException unused) {
            return null;
        }
    }
}
