package com.google.android.gms.internal.serialization;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "word", "", "invoke"}, k = 3, mv = {2, 0, 0}, xi = 48)
final class zzkc extends Lambda implements Function1 {
    public static final zzkc zza = new zzkc();

    public zzkc() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public final /* bridge */ /* synthetic */ Object invoke(Object obj) {
        String str = (String) obj;
        str.getClass();
        if (str.length() <= 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str.charAt(0));
        String strSubstring = str.substring(1);
        StringBuilder sb = new StringBuilder(String.valueOf(upperCase).length() + strSubstring.length());
        sb.append(upperCase);
        sb.append(strSubstring);
        return sb.toString();
    }
}
