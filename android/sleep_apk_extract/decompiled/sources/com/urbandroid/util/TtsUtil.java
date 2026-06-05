package com.urbandroid.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.Environment;
import com.urbandroid.sleep.service.Settings;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: classes4.dex */
public class TtsUtil {
    private TextToSpeech tts;

    private void doSpeak(final Context context, final int i, final String str, final String str2, final float f, final int i2) {
        if (new Settings(context).isTextToSpeech()) {
            Logger.logInfo("TTS: enabled " + Locale.getDefault());
            this.tts = new TextToSpeech(context, new TextToSpeech.OnInitListener() { // from class: com.urbandroid.util.TtsUtil$$ExternalSyntheticLambda0
                @Override // android.speech.tts.TextToSpeech.OnInitListener
                public final void onInit(int i3) {
                    this.f$0.lambda$doSpeak$0(str2, context, i, str, i2, f, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$doSpeak$0(String str, Context context, int i, String str2, int i2, float f, int i3) {
        try {
            if (i3 != 0) {
                Logger.logInfo("TTS: failed");
                return;
            }
            Logger.logInfo("TTS: init SUCCESS ");
            this.tts.setLanguage(Locale.getDefault());
            this.tts.setSpeechRate(0.7f);
            if (str == null) {
                str = context.getString(i, str2);
                if (this.tts.isLanguageAvailable(Locale.getDefault()) < 0) {
                    Logger.logInfo("TTS: Locale " + Locale.getDefault() + " not available using English, available " + this.tts.isLanguageAvailable(Locale.getDefault()));
                    Configuration configuration = context.getResources().getConfiguration();
                    Locale locale = Locale.ENGLISH;
                    configuration.locale = locale;
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
                    str = new Resources(context.getAssets(), displayMetrics, configuration).getString(i, str2);
                    this.tts.setLanguage(locale);
                }
            }
            Logger.logInfo("TTS: text:" + str);
            boolean zIsIcsOrGreater = Environment.isIcsOrGreater();
            TextToSpeech textToSpeech = this.tts;
            if (zIsIcsOrGreater) {
                textToSpeech.setOnUtteranceProgressListener(new UtteranceProgressListener() { // from class: com.urbandroid.util.TtsUtil.1
                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onDone(String str3) {
                        TtsUtil.this.tts.shutdown();
                    }

                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onError(String str3) {
                    }

                    @Override // android.speech.tts.UtteranceProgressListener
                    public void onStart(String str3) {
                    }
                });
            } else {
                textToSpeech.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() { // from class: com.urbandroid.util.TtsUtil.2
                    @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
                    public void onUtteranceCompleted(String str3) {
                        TtsUtil.this.tts.shutdown();
                    }
                });
            }
            if (Environment.isLollipopOrGreater()) {
                int i4 = i2 >= 0 ? i2 : 4;
                Bundle bundle = new Bundle();
                bundle.putInt("streamType", i4);
                bundle.putFloat("volume", f);
                this.tts.speak(str, 1, bundle, "SleepAsAndroid");
                this.tts.setAudioAttributes(new AudioAttributes.Builder().setContentType(1).setUsage(i2 == 4 ? 4 : 1).build());
                return;
            }
            HashMap<String, String> map = new HashMap<>();
            if (i2 < 0) {
                i2 = 4;
            }
            map.put("streamType", String.valueOf(i2));
            map.put("utteranceId", "SleepAsAndroid");
            if (Environment.isIcsOrGreater()) {
                map.put("volume", String.valueOf(f));
            }
            this.tts.speak(str, 1, map);
        } catch (Exception e) {
            Logger.logSevere("TTS: failed", e);
        }
    }

    public void speak(Context context, int i, String str, float f, int i2) {
        doSpeak(context, i, str, null, f, i2);
    }

    public void speak(Context context, String str, float f, int i) {
        doSpeak(context, -1, null, str, f, i);
    }
}
