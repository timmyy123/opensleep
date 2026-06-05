package androidx.work;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.work.impl.WorkManagerImpl;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b'\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u0007\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0011"}, d2 = {"Landroidx/work/WorkManager;", "", "<init>", "()V", "Landroidx/work/WorkRequest;", "request", "Landroidx/work/Operation;", "enqueue", "(Landroidx/work/WorkRequest;)Landroidx/work/Operation;", "", "requests", "(Ljava/util/List;)Landroidx/work/Operation;", "", "tag", "cancelAllWorkByTag", "(Ljava/lang/String;)Landroidx/work/Operation;", "Companion", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class WorkManager {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0017¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0017¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/work/WorkManager$Companion;", "", "<init>", "()V", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroidx/work/WorkManager;", "getInstance", "(Landroid/content/Context;)Landroidx/work/WorkManager;", "Landroidx/work/Configuration;", "configuration", "", "initialize", "(Landroid/content/Context;Landroidx/work/Configuration;)V", "work-runtime_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public WorkManager getInstance(Context context) {
            context.getClass();
            WorkManagerImpl workManagerImpl = WorkManagerImpl.getInstance(context);
            workManagerImpl.getClass();
            return workManagerImpl;
        }

        public void initialize(Context context, Configuration configuration) {
            context.getClass();
            configuration.getClass();
            WorkManagerImpl.initialize(context, configuration);
        }

        private Companion() {
        }
    }

    public static WorkManager getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    public static void initialize(Context context, Configuration configuration) {
        INSTANCE.initialize(context, configuration);
    }

    public abstract Operation cancelAllWorkByTag(String tag);

    public final Operation enqueue(WorkRequest request) {
        request.getClass();
        return enqueue(CollectionsKt.listOf(request));
    }

    public abstract Operation enqueue(List<? extends WorkRequest> requests);
}
