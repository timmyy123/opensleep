package com.facebook.ads.redexgen.core;

import android.media.AudioTrack;
import android.media.AudioTrack$StreamEventCallback;
import android.os.Handler;
import android.os.Looper;
import java.util.Objects;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C9P {
    public final AudioTrack$StreamEventCallback A00;
    public final Handler A01 = new Handler(Looper.myLooper());
    public final /* synthetic */ C1862oM A02;

    public C9P(final C1862oM c1862oM) {
        this.A02 = c1862oM;
        this.A00 = new AudioTrack$StreamEventCallback() { // from class: com.facebook.ads.redexgen.X.9O
            public static String[] A02 = {"8abdE8ICHAnxwFMUcOcB2jRAyUCGhoJo", "eSG1FX4JUeB6EOGXBLLAS9lOPW1", "25OZd6V", "MAJYraeiFmbj", "mUQNxKLiPMNWcUO6nW3zZtqSV9cqGhZ8", "VvmkF0iz3WmQeVV4Hfojcs5Qu1q9OORp", "gntz5ah2KiglLn2nngo2Gr7V9oibD8w7", "BsUxp7JWgCvt"};

            public final void onDataRequest(AudioTrack audioTrack, int i) {
                if (audioTrack.equals(this.A00.A02.A0D) && this.A00.A02.A0I != null) {
                    C1862oM c1862oM2 = this.A00.A02;
                    String[] strArr = A02;
                    if (strArr[1].length() == strArr[2].length()) {
                        throw new RuntimeException();
                    }
                    A02[0] = "JFsW9FWtG581w4rAGivIJch2V9mOeS5l";
                    if (!c1862oM2.A0X) {
                        return;
                    }
                    this.A00.A02.A0I.AF2();
                }
            }

            public final void onTearDown(AudioTrack audioTrack) {
                if (audioTrack.equals(this.A00.A02.A0D) && this.A00.A02.A0I != null) {
                    C9P c9p = this.A00;
                    String[] strArr = A02;
                    if (strArr[3].length() != strArr[7].length()) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A02;
                    strArr2[3] = "n6LYwQPnbsiV";
                    strArr2[7] = "LQIZIXydZbX4";
                    if (!c9p.A02.A0X) {
                        return;
                    }
                    this.A00.A02.A0I.AF2();
                }
            }
        };
    }

    public final void A00(AudioTrack audioTrack) {
        Handler handler = this.A01;
        Objects.requireNonNull(handler);
        audioTrack.registerStreamEventCallback(new C9N(handler), this.A00);
    }

    public final void A01(AudioTrack audioTrack) {
        audioTrack.unregisterStreamEventCallback(this.A00);
        this.A01.removeCallbacksAndMessages(null);
    }
}
