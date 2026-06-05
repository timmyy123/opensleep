package androidx.appfunctions.compiler;

import androidx.appfunctions.compiler.core.ProcessingException;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;", "", "aggregateAppFunctions", "", "generateMetadataFromSchema", "appFunctionsXmlLocation", "", "<init>", "(ZZLjava/lang/String;)V", "getAggregateAppFunctions", "()Z", "getGenerateMetadataFromSchema", "getAppFunctionsXmlLocation", "()Ljava/lang/String;", "Companion", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AppFunctionCompilerOptions {
    private static final String AGGREGATE_APP_FUNCTIONS_OPTION_KEY = "appfunctions:aggregateAppFunctions";
    private static final String APP_FUNCTIONS_XML_LOCATION_KEY = "appfunctions:appFunctionsXmlLocation";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SUPPORT_LEGACY_INDEXER_OPTION_KEY = "appfunctions:generateMetadataFromSchema";
    private final boolean aggregateAppFunctions;
    private final String appFunctionsXmlLocation;
    private final boolean generateMetadataFromSchema;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bJ\u001c\u0010\f\u001a\u00020\r2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH\u0002J\u001c\u0010\u000e\u001a\u00020\r2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/appfunctions/compiler/AppFunctionCompilerOptions$Companion;", "", "<init>", "()V", "AGGREGATE_APP_FUNCTIONS_OPTION_KEY", "", "SUPPORT_LEGACY_INDEXER_OPTION_KEY", "APP_FUNCTIONS_XML_LOCATION_KEY", "from", "Landroidx/appfunctions/compiler/AppFunctionCompilerOptions;", SDKConstants.PARAM_GAME_REQUESTS_OPTIONS, "", "getAggregateAppFunctionsOption", "", "getGenerateMetadataFromSchemaOption", "appfunctions-compiler"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean getAggregateAppFunctionsOption(Map<String, String> options) throws ProcessingException {
            try {
                String str = options.get(AppFunctionCompilerOptions.AGGREGATE_APP_FUNCTIONS_OPTION_KEY);
                if (str != null) {
                    return StringsKt.toBooleanStrict(str);
                }
                return false;
            } catch (Exception e) {
                throw new ProcessingException("Compiler option appfunctions:aggregateAppFunctions should be either `true` or `false`", null, e);
            }
        }

        private final boolean getGenerateMetadataFromSchemaOption(Map<String, String> options) throws ProcessingException {
            try {
                String str = options.get(AppFunctionCompilerOptions.SUPPORT_LEGACY_INDEXER_OPTION_KEY);
                if (str != null) {
                    return StringsKt.toBooleanStrict(str);
                }
                return false;
            } catch (Exception e) {
                throw new ProcessingException("Compiler option appfunctions:generateMetadataFromSchema should be either `true` or `false`", null, e);
            }
        }

        public final AppFunctionCompilerOptions from(Map<String, String> options) {
            options.getClass();
            return new AppFunctionCompilerOptions(getAggregateAppFunctionsOption(options), getGenerateMetadataFromSchemaOption(options), options.get(AppFunctionCompilerOptions.APP_FUNCTIONS_XML_LOCATION_KEY), null);
        }

        private Companion() {
        }
    }

    private AppFunctionCompilerOptions(boolean z, boolean z2, String str) {
        this.aggregateAppFunctions = z;
        this.generateMetadataFromSchema = z2;
        this.appFunctionsXmlLocation = str;
    }

    public final boolean getAggregateAppFunctions() {
        return this.aggregateAppFunctions;
    }

    public final String getAppFunctionsXmlLocation() {
        return this.appFunctionsXmlLocation;
    }

    public final boolean getGenerateMetadataFromSchema() {
        return this.generateMetadataFromSchema;
    }

    public /* synthetic */ AppFunctionCompilerOptions(boolean z, boolean z2, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, z2, str);
    }
}
