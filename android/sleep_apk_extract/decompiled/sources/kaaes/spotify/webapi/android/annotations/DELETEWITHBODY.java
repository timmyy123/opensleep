package kaaes.spotify.webapi.android.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import retrofit.http.RestMethod;

/* JADX INFO: loaded from: classes5.dex */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@RestMethod(hasBody = MqttConnectOptions.CLEAN_SESSION_DEFAULT, value = "DELETE")
public @interface DELETEWITHBODY {
    String value();
}
