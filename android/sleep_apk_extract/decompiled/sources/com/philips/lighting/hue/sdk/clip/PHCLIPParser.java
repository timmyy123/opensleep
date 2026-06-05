package com.philips.lighting.hue.sdk.clip;

import com.philips.lighting.model.PHHueError;
import com.philips.lighting.model.PHHueParsingError;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public interface PHCLIPParser {
    void clearErrors();

    List<PHHueParsingError> getParsingErrors();

    List<PHHueError> parseError(String str);

    boolean parseIsSuccess(String str);

    Map<String, String> parseSuccess(String str);
}
