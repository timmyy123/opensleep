package com.urbandroid.sleep.service;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SettingKeys {
    public static final String[] NO_ALARM_BEDTIME_ARRAY = {"no_alarm_bedtime_0", "no_alarm_bedtime_1", "no_alarm_bedtime_2", "no_alarm_bedtime_3", "no_alarm_bedtime_4", "no_alarm_bedtime_5", "no_alarm_bedtime_6"};
    public static final String[] boolsToInit = {"alarm_with_flashlight", "force_english", "offscreen_tracking_support"};
    public static final boolean[] boolsToInitValue = {false, false, false};
    public static final List<String> EU_COUNTRIES = Arrays.asList("at", "be", "bg", "cy", "cz", "de", "dk", "ee", "es", "fi", "fr", "gb", "gr", "hr", "hu", "ie", "it", "lt", "lu", "lv", "mt", "nl", "pl", "pt", "ro", "se", "si", "sk");
}
