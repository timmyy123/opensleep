package io.ktor.http;

import com.facebook.appevents.iap.InAppPurchaseConstants;
import io.ktor.util.StringValuesBuilderImpl;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lio/ktor/http/ParametersBuilderImpl;", "Lio/ktor/util/StringValuesBuilderImpl;", "Lio/ktor/http/ParametersBuilder;", "", "size", "<init>", "(I)V", "Lio/ktor/http/Parameters;", InAppPurchaseConstants.METHOD_BUILD, "()Lio/ktor/http/Parameters;", "ktor-http"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ParametersBuilderImpl extends StringValuesBuilderImpl implements ParametersBuilder {
    public ParametersBuilderImpl(int i) {
        super(true, i);
    }

    @Override // io.ktor.http.ParametersBuilder
    public Parameters build() {
        return new ParametersImpl(getValues());
    }
}
