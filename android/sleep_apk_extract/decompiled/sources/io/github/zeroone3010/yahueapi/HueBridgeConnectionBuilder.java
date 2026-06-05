package io.github.zeroone3010.yahueapi;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zeroone3010.yahueapi.v2.Hue$$ExternalSyntheticLambda43;
import io.github.zeroone3010.yahueapi.v2.LightFactory$$ExternalSyntheticLambda1;
import io.github.zeroone3010.yahueapi.v2.domain.ApiInitializationStatus;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: loaded from: classes5.dex */
public class HueBridgeConnectionBuilder {
    private static final int MAX_TRIES = 30;
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) HueBridgeConnectionBuilder.class);
    private final String bridgeIp;
    private final String urlString;

    public HueBridgeConnectionBuilder(String str) {
        this.urlString = FileInsert$$ExternalSyntheticOutline0.m("https://", str);
        this.bridgeIp = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$initializeApiConnection$1(String str) {
        String strM = FileInsert$$ExternalSyntheticOutline0.m("{\"devicetype\":\"yetanotherhueapi#", str, "\"}");
        try {
            URL url = new URL(this.urlString + "/api");
            String description = null;
            for (int i = 30; i > 0; i--) {
                try {
                    Logger logger2 = logger;
                    logger2.info("Please push the button on the Hue Bridge now (" + i + " seconds left).");
                    String strPost = io.github.zeroone3010.yahueapi.v2.HttpUtil.post(url, "", strM);
                    logger2.info(strPost);
                    ApiInitializationStatus apiInitializationStatus = (ApiInitializationStatus) ((ArrayList) new ObjectMapper().readValue(strPost, new TypeReference<ArrayList<ApiInitializationStatus>>() { // from class: io.github.zeroone3010.yahueapi.HueBridgeConnectionBuilder.1
                    })).get(0);
                    if (apiInitializationStatus.getSuccess() != null) {
                        return apiInitializationStatus.getSuccess().getUsername();
                    }
                    description = apiInitializationStatus.getError().getDescription();
                    TimeUnit.SECONDS.sleep(1L);
                } catch (Exception e) {
                    throw new HueApiException(e);
                }
            }
            throw new HueApiException(description);
        } catch (MalformedURLException e2) {
            throw new HueApiException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean lambda$isHueBridgeEndpoint$0() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.urlString);
            sb.append("/api/config");
            return Boolean.valueOf(200 == io.github.zeroone3010.yahueapi.v2.HttpUtil.getAnonymousUrlConnection(new URL(sb.toString())).getResponseCode());
        } catch (IOException unused) {
            return Boolean.FALSE;
        }
    }

    public CompletableFuture<String> initializeApiConnection(String str) {
        return CompletableFuture.supplyAsync(new LightFactory$$ExternalSyntheticLambda1(this, str, 1));
    }

    public CompletableFuture<Boolean> isHueBridgeEndpoint() {
        return CompletableFuture.supplyAsync(new Hue$$ExternalSyntheticLambda43(this, 1));
    }
}
