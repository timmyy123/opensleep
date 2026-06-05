package com.facebook.ads.redexgen.core;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.ads.internal.context.Repairable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.gi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1421gi extends T8 {
    public static String[] A06 = {"4Fl94EIzOk67aYUPduHJ8UazEL", "sAhktSZOOrm35xxj8Imdq8RPkj", "oRYwVa3KjTvntAfrBK1sqTqE8vcnrhu1", "DAigVkrFkMuOUy14T2FK5zmWgvJcIn3a", "an5oIaHMQLp81wCZBnKMJTBSx7KtQFJf", "wEWpxEoKGSO43ttKCSegU3t35jPnkl3s", "WpWdxAQuBweGThqHfmbUTgqTG7", "dWX8I2VlCkDjmK6jHvJYkvPP690yaesv"};
    public WeakReference<Activity> A00;
    public WeakHashMap<Repairable, Boolean> A01;
    public final T6 A02;
    public final AtomicReference<T5> A03;
    public final AtomicReference<Object> A04;
    public final AtomicReference<InterfaceC0647Lt> A05;

    public C1421gi(Activity activity, TA ta, InterfaceC0647Lt interfaceC0647Lt) {
        super(activity.getApplicationContext(), ta);
        this.A01 = new WeakHashMap<>();
        this.A05 = new AtomicReference<>();
        this.A03 = new AtomicReference<>();
        this.A02 = new T6();
        this.A04 = new AtomicReference<>();
        this.A05.set(interfaceC0647Lt);
        this.A00 = new WeakReference<>(activity);
    }

    public C1421gi(Context context, TA ta, InterfaceC0647Lt interfaceC0647Lt) {
        super(context.getApplicationContext(), ta);
        this.A01 = new WeakHashMap<>();
        this.A05 = new AtomicReference<>();
        this.A03 = new AtomicReference<>();
        this.A02 = new T6();
        this.A04 = new AtomicReference<>();
        this.A05.set(interfaceC0647Lt);
        Activity activityA00 = A00(context);
        if (activityA00 != null) {
            this.A00 = new WeakReference<>(activityA00);
        } else {
            this.A00 = new WeakReference<>(null);
        }
    }

    public static Activity A00(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if ((context instanceof C1421gi) && ((C1421gi) context).A0E() != null) {
                return ((C1421gi) context).A0E();
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final Activity A0E() {
        return this.A00.get();
    }

    public InterfaceC0647Lt A0F() {
        InterfaceC0647Lt funnel = this.A05.get();
        if (funnel == null) {
            return new C1641kX();
        }
        return funnel;
    }

    public final T5 A0G() {
        return this.A03.get();
    }

    public final T6 A0H() {
        return this.A02;
    }

    public final Object A0I() {
        return this.A04.get();
    }

    public final void A0J(Activity activity) {
        this.A00 = new WeakReference<>(activity);
    }

    public final void A0K(InterfaceC0647Lt interfaceC0647Lt) {
        this.A05.set(interfaceC0647Lt);
    }

    public final void A0L(C1421gi c1421gi) {
        c1421gi.A01.putAll(this.A01);
        this.A01 = c1421gi.A01;
    }

    public final void A0M(C1421gi c1421gi) {
        A0K(c1421gi.A0F());
        A0D(c1421gi.A0C());
        A0N(c1421gi.A0G());
    }

    public final void A0N(T5 t5) {
        this.A03.set(t5);
    }

    public final void A0O(Repairable repairable) {
        this.A01.put(repairable, true);
    }

    public final void A0P(Object obj) {
        this.A04.set(obj);
    }

    public final void A0Q(Throwable th) {
        Iterator<Map.Entry<Repairable, Boolean>> it = this.A01.entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            String[] strArr = A06;
            if (strArr[4].charAt(18) == strArr[2].charAt(18)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[0] = "cq4W2mN05Su2gaFDi5CYFjM7nJ";
            strArr2[6] = "g7MgkZWMqMCaiMVBRzNoHUUy7c";
            if (zHasNext) {
                it.next().getKey().repair(th);
            } else {
                return;
            }
        }
    }
}
