package io.ktor.http;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.ktor.util.StringValuesBuilder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/ktor/http/ParametersBuilder;", "Lio/ktor/util/StringValuesBuilder;", "Lio/ktor/http/Parameters;", InAppPurchaseConstants.METHOD_BUILD, "()Lio/ktor/http/Parameters;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public interface ParametersBuilder extends StringValuesBuilder {
    Parameters build();
}
