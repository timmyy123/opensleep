package com.urbandroid.sleep.audio.event;

import android.content.Intent;
import com.google.gson.Gson$$ExternalSyntheticBUOutline0;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.urbandroid.sleep.snoring.SoundClass;

/* JADX INFO: loaded from: classes4.dex */
public class SoundEvent {
    private final SoundClass soundClass;
    private final long timestamp;
    private final Type type;
    private final double weight;

    public enum Type {
        RAW,
        AGGREGATED
    }

    private SoundEvent(Type type, long j, SoundClass soundClass, double d) {
        type.getClass();
        this.type = type;
        this.timestamp = j;
        soundClass.getClass();
        this.soundClass = soundClass;
        if (d < 0.0d || d > 1.0d || Double.isNaN(d)) {
            Home$$ExternalSyntheticBUOutline0.m("Invalid weight: ", d);
            throw null;
        }
        this.weight = d;
    }

    public static SoundEvent fromIntent(Intent intent) {
        String action = intent.getAction();
        if ((action.equals("action_sound_event_raw") || action.equals("action_sound_event_aggregated")) && intent.hasExtra("extra_sound_event_timestamp") && intent.hasExtra("extra_sound_event_class") && intent.hasExtra("extra_sound_event_weight")) {
            return new SoundEvent(action.equals("action_sound_event_raw") ? Type.RAW : Type.AGGREGATED, intent.getLongExtra("extra_sound_event_timestamp", System.currentTimeMillis()), (SoundClass) intent.getSerializableExtra("extra_sound_event_class"), intent.getDoubleExtra("extra_sound_event_weight", 0.0d));
        }
        Gson$$ExternalSyntheticBUOutline0.m("Cannot construct SoundEvent from intent ", intent);
        return null;
    }

    public static SoundEvent newAggregatedEvent(SoundClass soundClass, double d) {
        return new SoundEvent(Type.AGGREGATED, System.currentTimeMillis(), soundClass, d);
    }

    public static SoundEvent newRawEvent(SoundClass soundClass, double d) {
        return new SoundEvent(Type.RAW, System.currentTimeMillis(), soundClass, d);
    }

    public SoundClass getSoundClass() {
        return this.soundClass;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public double getWeight() {
        return this.weight;
    }

    public boolean isGeneralNoise() {
        return this.soundClass == SoundClass.OTHER;
    }

    public boolean isMeaningfulSound() {
        return !isGeneralNoise();
    }

    public Intent toIntent() {
        Intent intent = new Intent(this.type == Type.RAW ? "action_sound_event_raw" : "action_sound_event_aggregated");
        intent.putExtra("extra_sound_event_timestamp", this.timestamp);
        intent.putExtra("extra_sound_event_class", this.soundClass);
        intent.putExtra("extra_sound_event_weight", this.weight);
        return intent;
    }

    public Intent toPublicIntent() {
        Intent intent = new Intent("com.urbandroid.sleep.audio.SOUND_EVENT_" + this.soundClass.name());
        intent.putExtra("TIMESTAMP", this.timestamp);
        return intent;
    }

    public String toString() {
        return "SoundEvent{type=" + this.type + ", timestamp=" + this.timestamp + ", soundClass=" + this.soundClass + ", weight=" + this.weight + '}';
    }
}
