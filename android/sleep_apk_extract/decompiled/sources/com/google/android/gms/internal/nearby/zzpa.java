package com.google.android.gms.internal.nearby;

import android.net.Uri;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes3.dex */
public abstract class zzpa {
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
}
