package io.github.zeroone3010.yahueapi.v2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.zeroone3010.yahueapi.HueApiException;
import io.github.zeroone3010.yahueapi.v2.domain.LightResource;
import io.github.zeroone3010.yahueapi.v2.domain.LightResourceRoot;
import io.github.zeroone3010.yahueapi.v2.domain.update.UpdateLight;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: loaded from: classes5.dex */
public class LightFactory {
    private final Hue hue;
    private final ObjectMapper objectMapper;

    public LightFactory(Hue hue, ObjectMapper objectMapper) {
        this.hue = hue;
        this.objectMapper = objectMapper;
    }

    private Supplier<LightResource> createStateProvider(URL url) {
        return new LightFactory$$ExternalSyntheticLambda1(this, url, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ LightResource lambda$createStateProvider$0(URL url) {
        try {
            InputStream inputStream = this.hue.getUrlConnection(url).getInputStream();
            try {
                LightResource lightResource = ((LightResourceRoot) this.objectMapper.readValue(inputStream, LightResourceRoot.class)).getData().get(0);
                if (inputStream != null) {
                    inputStream.close();
                }
                return lightResource;
            } finally {
            }
        } catch (IOException e) {
            throw new HueApiException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$stateSetter$1(URL url, UpdateLight updateLight) {
        try {
            return HttpUtil.put(this.hue, url, "", this.objectMapper.writeValueAsString(updateLight));
        } catch (JsonProcessingException e) {
            throw new HueApiException(e);
        }
    }

    private Function<UpdateLight, String> stateSetter(URL url) {
        return new Hue$$ExternalSyntheticLambda2(this, url, 1);
    }

    public LightImpl buildLight(LightResource lightResource, URL url) {
        try {
            UUID id = lightResource.getId();
            URL url2 = new URL(url, "/clip/v2/resource/light/" + id);
            return new LightImpl(id, lightResource, createStateProvider(url2), stateSetter(url2));
        } catch (MalformedURLException e) {
            throw new HueApiException(e);
        }
    }
}
