package com.google.android.gms.internal.ads;

/* JADX INFO: loaded from: classes3.dex */
public enum zzdyu {
    PUBLIC_API_CALL("api-call"),
    DYNAMITE_ENTER("dynamite-enter"),
    READ_FROM_DISK_START("read-from-disk-start"),
    READ_FROM_DISK_END("read-from-disk-end"),
    CLIENT_SIGNALS_START("client-signals-start"),
    CLIENT_SIGNALS_END("client-signals-end"),
    SERVICE_CONNECTED("service-connected"),
    GMS_SIGNALS_START("gms-signals-start"),
    GMS_SIGNALS_END("gms-signals-end"),
    GET_SIGNALS_SDKCORE_START("get-signals-sdkcore-start"),
    GET_SIGNALS_SDKCORE_END("get-signals-sdkcore-end"),
    GET_AD_DICTIONARY_SDKCORE_START("get-ad-dictionary-sdkcore-start"),
    GET_AD_DICTIONARY_SDKCORE_END("get-ad-dictionary-sdkcore-end"),
    HTTP_RESPONSE_READY("http-response-ready"),
    SCAR_PRELOADER_READY("scar-preloader-ready"),
    SCAR_PRELOADER_PROCESSING_DONE("scar-preloader-processing-done"),
    NORMALIZATION_AD_RESPONSE_START("normalize-ad-response-start"),
    NORMALIZATION_AD_RESPONSE_END("normalize-ad-response-end"),
    BINDER_CALL_START("binder-call-start"),
    SERVER_RESPONSE_PARSE_START("server-response-parse-start"),
    RENDERING_START("rendering-start"),
    PUBLIC_API_CALLBACK("public-api-callback"),
    RENDERING_NATIVE_ADS_NATIVE_JS_WEBVIEW_START("rendering-native-ads-native-js-webview-start"),
    RENDERING_NATIVE_ADS_PREPROCESS_START("rendering-native-ads-preprocess-start"),
    RENDERING_NATIVE_ADS_PREPROCESS_END("rendering-native-ads-preprocess-end"),
    RENDERING_NATIVE_ASSETS_LOADING_START("rendering-native-assets-loading-start"),
    RENDERING_NATIVE_ASSETS_LOADING_END("rendering-native-assets-loading-end"),
    RENDERING_WEBVIEW_CREATION_START("rendering-webview-creation-start"),
    RENDERING_WEBVIEW_CREATION_END("rendering-webview-creation-end"),
    RENDERING_AD_COMPONENT_CREATION_END("rendering-ad-component-creation-end"),
    RENDERING_CONFIGURE_WEBVIEW_START("rendering-configure-webview-start"),
    RENDERING_CONFIGURE_WEBVIEW_END("rendering-configure-webview-end"),
    RENDERING_WEBVIEW_LOAD_HTML_START("rendering-webview-load-html-start"),
    RENDERING_WEBVIEW_LOAD_HTML_END("rendering-webview-load-html-end"),
    RENDERING_ADSTRING_TYPE2_FETCH_START("type2-fetch-start"),
    RENDERING_ADSTRING_TYPE2_FETCH_END("type2-fetch-end"),
    SIGNAL_ON_DISK_VALIDATION_START("sod-validation-start"),
    SIGNAL_ON_DISK_VALIDATION_END("sod-validation-end"),
    SIGNAL_ON_DISK_CACHE_KEY_START("sod-cache-key-start"),
    SIGNAL_ON_DISK_CACHE_KEY_END("sod-cache-key-end"),
    SIGNAL_ON_DISK_READ_AND_REMOVE_START("sod-read-and-remove-start"),
    SIGNAL_ON_DISK_READ_AND_REMOVE_END("sod-read-and-remove-end"),
    SIGNAL_ON_DISK_DECODE_START("sod-decode-start"),
    SIGNAL_ON_DISK_DECODE_END("sod-decode-end"),
    NATIVE_ASSETS_LOADING_BASIC_START("native-assets-loading-basic-start"),
    NATIVE_ASSETS_LOADING_BASIC_END("native-assets-loading-basic-end"),
    NATIVE_ASSETS_LOADING_IMAGE_START("native-assets-loading-image-start"),
    NATIVE_ASSETS_LOADING_IMAGE_END("native-assets-loading-image-end"),
    NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_START("native-assets-loading-image-composition-start"),
    NATIVE_ASSETS_LOADING_IMAGE_COMPOSITION_END("native-assets-loading-image-composition-end"),
    NATIVE_ASSETS_LOADING_LOGO_START("native-assets-loading-logo-start"),
    NATIVE_ASSETS_LOADING_LOGO_END("native-assets-loading-logo-end"),
    NATIVE_ASSETS_LOADING_ICON_START("native-assets-loading-icon-start"),
    NATIVE_ASSETS_LOADING_ICON_END("native-assets-loading-icon-end"),
    NATIVE_ASSETS_LOADING_ATTRIBUTION_START("native-assets-loading-attribution-start"),
    NATIVE_ASSETS_LOADING_ATTRIBUTION_END("native-assets-loading-attribution-end"),
    NATIVE_ASSETS_LOADING_VIDEO_START("native-assets-loading-video-start"),
    NATIVE_ASSETS_LOADING_VIDEO_END("native-assets-loading-video-end"),
    NATIVE_ASSETS_LOADING_VIDEO_COMPOSITION_START("native-assets-loading-video-composition-start"),
    NATIVE_ASSETS_LOADING_MEDIA_START("native-assets-loading-media-start"),
    NATIVE_ASSETS_LOADING_MEDIA_END("native-assets-loading-media-end"),
    NATIVE_ASSETS_LOADING_CUSTOM_START("native-assets-loading-custom-start"),
    NATIVE_ASSETS_LOADING_CUSTOM_END("native-assets-loading-custom-end"),
    NATIVE_ASSETS_LOADING_OMID_START("native-assets-loading-omid-start"),
    NATIVE_ASSETS_LOADING_OMID_END("native-assets-loading-omid-end");

    private final String zzan;

    zzdyu(String str) {
        this.zzan = str;
    }

    public final String zza() {
        return this.zzan;
    }
}
