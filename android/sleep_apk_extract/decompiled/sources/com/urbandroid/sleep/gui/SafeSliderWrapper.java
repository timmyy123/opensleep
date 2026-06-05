package com.urbandroid.sleep.gui;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.material.slider.Slider;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005¨\u0006\u0013"}, d2 = {"Lcom/urbandroid/sleep/gui/SafeSliderWrapper;", "", "Lcom/google/android/material/slider/Slider;", "slider", "<init>", "(Lcom/google/android/material/slider/Slider;)V", "", SDKConstants.PARAM_VALUE, "", "setValue", "(F)V", "valueFrom", "setValueFrom", "valueTo", "setValueTo", "Lcom/google/android/material/slider/Slider;", "getSlider", "()Lcom/google/android/material/slider/Slider;", "setSlider", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SafeSliderWrapper {
    private Slider slider;

    public SafeSliderWrapper(Slider slider) {
        slider.getClass();
        this.slider = slider;
    }

    public final Slider getSlider() {
        return this.slider;
    }

    public final void setValue(float value) {
        if (this.slider.getValueFrom() > value) {
            this.slider.setValueFrom(value);
        }
        if (this.slider.getValueTo() < value) {
            this.slider.setValueTo(value);
        }
        if (this.slider.getValueFrom() >= this.slider.getValueTo()) {
            Slider slider = this.slider;
            slider.setValueTo(slider.getValueFrom() + 0.001f);
        }
        this.slider.setValue(value);
    }

    public final void setValueFrom(float valueFrom) {
        float valueTo = this.slider.getValueTo();
        Slider slider = this.slider;
        if (valueTo <= valueFrom) {
            slider.setValueTo(valueFrom + 0.001f);
            return;
        }
        float value = slider.getValue();
        Slider slider2 = this.slider;
        if (value >= valueFrom) {
            slider2.setValueFrom(valueFrom);
        } else {
            slider2.setValue(valueFrom);
            this.slider.setValueFrom(valueFrom);
        }
    }

    public final void setValueTo(float valueTo) {
        float valueTo2 = this.slider.getValueTo();
        float valueFrom = this.slider.getValueFrom();
        Slider slider = this.slider;
        if (valueTo2 <= valueFrom) {
            slider.setValueTo(slider.getValueFrom() + 0.001f);
            return;
        }
        float valueTo3 = slider.getValueTo();
        float value = this.slider.getValue();
        Slider slider2 = this.slider;
        if (valueTo3 < value) {
            slider2.setValueTo(slider2.getValue());
        } else {
            slider2.setValueTo(valueTo);
        }
    }
}
