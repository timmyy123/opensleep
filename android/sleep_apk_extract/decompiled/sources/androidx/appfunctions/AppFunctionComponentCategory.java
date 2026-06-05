package androidx.appfunctions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Retention(RetentionPolicy.SOURCE)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0081\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Landroidx/appfunctions/AppFunctionComponentCategory;", "", "Companion", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
public @interface AppFunctionComponentCategory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.$$INSTANCE;
    public static final String FUNCTION = "FUNCTION";
    public static final String INVENTORY = "INVENTORY";
    public static final String INVOKER = "INVOKER";
    public static final String SCHEMA_DEFINITION = "SCHEMA_DEFINITION";
    public static final String SERIALIZABLE = "SERIALIZABLE";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Landroidx/appfunctions/AppFunctionComponentCategory$Companion;", "", "<init>", "()V", "INVENTORY", "", "INVOKER", "FUNCTION", "SCHEMA_DEFINITION", "SERIALIZABLE", "appfunctions"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String FUNCTION = "FUNCTION";
        public static final String INVENTORY = "INVENTORY";
        public static final String INVOKER = "INVOKER";
        public static final String SCHEMA_DEFINITION = "SCHEMA_DEFINITION";
        public static final String SERIALIZABLE = "SERIALIZABLE";

        private Companion() {
        }
    }
}
