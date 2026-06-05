package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.ads.androidx.media3.common.MediaItem;
import com.facebook.ads.androidx.media3.common.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2u, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C01772u {
    public static String[] A0B = {"HPaW60WB4gFqlzK247iq3uDphWK03Iif", "KBvaSaTKxPBSHh58MHpb5CG0KegQKkr9", "b1r5E5Hd4zdNoyuaEQVQsO4l4ctoImRB", "nKy6zg3qdMWmj624cOZmm65wxaqanW8E", "pbs", "7xj4kZWUPnGFCehZwFfpDVbkpfFBWPXP", "TYkILCf2Xs5AkCVGSR3QMYIpsRVtVxUs", "J3EyGmSR6mO6g6CSn2CxG4G4HI4UvZHg"};
    public Uri A00;
    public C1965q2 A04;
    public Object A05;
    public String A06;
    public String A07;
    public String A08;
    public C01782v A01 = new C01782v();
    public C01802x A02 = new C01802x();
    public List<StreamKey> A09 = Collections.emptyList();
    public List<MediaItem.SubtitleConfiguration> A0A = Collections.emptyList();
    public AnonymousClass30 A03 = new AnonymousClass30();

    public final C01772u A00(Uri uri) {
        this.A00 = uri;
        return this;
    }

    public final C01772u A01(Object obj) {
        this.A05 = obj;
        return this;
    }

    public final C01772u A02(String str) {
        this.A06 = str;
        return this;
    }

    public final C01772u A03(String str) {
        this.A07 = (String) AbstractC02053y.A01(str);
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C01772u A04(List<StreamKey> list) {
        List<StreamKey> listEmptyList;
        if (list != null) {
            boolean zIsEmpty = list.isEmpty();
            String[] strArr = A0B;
            if (strArr[1].charAt(26) == strArr[2].charAt(26)) {
                throw new RuntimeException();
            }
            A0B[3] = "MqTMGNvSZ5CI9kiBQqDgyIk0OkVIIG8t";
            if (!zIsEmpty) {
                listEmptyList = Collections.unmodifiableList(new ArrayList(list));
            } else {
                listEmptyList = Collections.emptyList();
            }
        }
        this.A09 = listEmptyList;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C1970q7 A05() {
        boolean z;
        if (this.A02.A00 != null) {
            C01802x c01802x = this.A02;
            if (A0B[3].charAt(22) == '1') {
                throw new RuntimeException();
            }
            A0B[5] = "LsaTJZF6o4X1Tfg01qMfqEHPxyZhwdJj";
            z = c01802x.A03 != null;
        }
        AbstractC02053y.A08(z);
        C1972q9 c1972q9 = null;
        Uri uri = this.A00;
        if (uri != null) {
            c1972q9 = new C1972q9(uri, this.A08, this.A02.A03 != null ? this.A02.A08() : null, null, this.A09, this.A06, this.A0A, this.A05);
        }
        return new C1970q7(this.A07 != null ? this.A07 : "", this.A01.A0B(), c1972q9, this.A03.A05(), this.A04 != null ? this.A04 : C1965q2.A0Z);
    }
}
