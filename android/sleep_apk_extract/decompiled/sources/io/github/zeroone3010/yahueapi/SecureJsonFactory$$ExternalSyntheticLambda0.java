package io.github.zeroone3010.yahueapi;

import com.urbandroid.smartlight.ikea.dirigera.DirigeraClient;
import com.urbandroid.smartlight.ikea.dirigera.DirigeraController;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class SecureJsonFactory$$ExternalSyntheticLambda0 implements HostnameVerifier {
    public final /* synthetic */ int $r8$classId;

    public /* synthetic */ SecureJsonFactory$$ExternalSyntheticLambda0(int i) {
        this.$r8$classId = i;
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(String str, SSLSession sSLSession) {
        switch (this.$r8$classId) {
            case 0:
                return SecureJsonFactory.lambda$new$0(str, sSLSession);
            case 1:
                return DirigeraClient.createInsecureOkHttpClient$lambda$0(str, sSLSession);
            default:
                return DirigeraController.createInsecureOkHttpClient$lambda$0(str, sSLSession);
        }
    }
}
