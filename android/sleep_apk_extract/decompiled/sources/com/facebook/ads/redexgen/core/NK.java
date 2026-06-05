package com.facebook.ads.redexgen.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class NK extends BroadcastReceiver {
    public static String[] A03 = {"dggRIwntGnoxWZ7BDQUg45Sl6NQgoMuN", "38c9H60yn2P1pt17", "STlEyQPStERy8tSXGvH8F24LWNUxdBhq", "hCwe", "bKRxwQpiW0PmVHVfGUn2RavmyNEFkRji", "VPPe2MO9HED0sxCZzVAB8cvkabJHsXeP", "uH31h0PRXTyVkIOgrCb5PcgaQIfZ1AyX", "pPlbIWWtmQkYN3MHTwcOdVUNUzBLXTby"};
    public AbstractC1590jh A00;
    public NJ A01;
    public String A02;

    public NK(String str, AbstractC1590jh abstractC1590jh, NJ nj) {
        this.A00 = abstractC1590jh;
        this.A01 = nj;
        this.A02 = str;
    }

    public final IntentFilter A00() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(EnumC1314ez.A06.A04(this.A02));
        intentFilter.addAction(EnumC1314ez.A09.A04(this.A02));
        intentFilter.addAction(EnumC1314ez.A04.A04(this.A02));
        intentFilter.addAction(EnumC1314ez.A0A.A04(this.A02));
        intentFilter.addAction(EnumC1314ez.A05.A04(this.A02));
        intentFilter.addAction(EnumC1314ez.A0C.A04(this.A02));
        intentFilter.addAction(EnumC1314ez.A0B.A04(this.A02));
        intentFilter.addAction(EnumC1314ez.A03.A04(this.A02));
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        EnumC1314ez enumC1314ez = EnumC1314ez.A06;
        String action2 = this.A02;
        if (enumC1314ez.A04(action2).equals(action)) {
            this.A01.AFo(this.A00);
            return;
        }
        EnumC1314ez enumC1314ez2 = EnumC1314ez.A09;
        String action3 = this.A02;
        if (enumC1314ez2.A04(action3).equals(action)) {
            if (C0871Up.A1y(context)) {
                this.A01.AFp(this.A00, AdError.AD_PRESENTATION_ERROR);
                return;
            } else {
                this.A01.AFp(this.A00, AdError.INTERNAL_ERROR);
                return;
            }
        }
        EnumC1314ez enumC1314ez3 = EnumC1314ez.A04;
        String action4 = this.A02;
        if (enumC1314ez3.A04(action4).equals(action)) {
            this.A01.AFl(this.A00);
            return;
        }
        EnumC1314ez enumC1314ez4 = EnumC1314ez.A0A;
        String action5 = this.A02;
        if (enumC1314ez4.A04(action5).equals(action)) {
            this.A01.AFn(this.A00);
            return;
        }
        EnumC1314ez enumC1314ez5 = EnumC1314ez.A05;
        String action6 = this.A02;
        boolean zEquals = enumC1314ez5.A04(action6).equals(action);
        if (A03[6].charAt(8) != 'X') {
            throw new RuntimeException();
        }
        A03[6] = "gVjZHTAPXXqW3paCpGTUxeCgOEd4dSxo";
        if (zEquals) {
            this.A01.onRewardedVideoClosed();
            return;
        }
        EnumC1314ez enumC1314ez6 = EnumC1314ez.A0B;
        String action7 = this.A02;
        if (enumC1314ez6.A04(action7).equals(action)) {
            NJ nj = this.A01;
            AbstractC1590jh abstractC1590jh = this.A00;
            String[] strArr = A03;
            if (strArr[2].charAt(25) != strArr[4].charAt(25)) {
                throw new RuntimeException();
            }
            A03[6] = "QgP7tKiwXm5h6JnagwUE7gN68w8IQRlz";
            nj.AFj(abstractC1590jh);
            return;
        }
        EnumC1314ez enumC1314ez7 = EnumC1314ez.A0C;
        String action8 = this.A02;
        if (enumC1314ez7.A04(action8).equals(action)) {
            this.A01.AFk(this.A00);
            return;
        }
        EnumC1314ez enumC1314ez8 = EnumC1314ez.A03;
        String str = this.A02;
        if (A03[0].charAt(19) != 'F') {
            A03[1] = "4VvB4uonEo2HdG2J";
            String action9 = enumC1314ez8.A04(str);
            if (!action9.equals(action)) {
                return;
            }
        } else {
            String action10 = enumC1314ez8.A04(str);
            if (!action10.equals(action)) {
                return;
            }
        }
        this.A01.onRewardedVideoActivityDestroyed();
    }
}
