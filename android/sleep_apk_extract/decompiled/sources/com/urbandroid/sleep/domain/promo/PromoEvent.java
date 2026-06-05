package com.urbandroid.sleep.domain.promo;

import android.content.Context;
import com.urbandroid.common.connectivity.WaitForConnectivityService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.common.util.InputStreamUtil;
import com.urbandroid.sleep.domain.interval.Interval;
import com.urbandroid.sleep.service.Settings;
import j$.util.DesugarTimeZone;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes4.dex */
public class PromoEvent {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHH");
    private Interval interval;
    private int sale;
    private long updated;

    public PromoEvent(Interval interval, int i) {
        this.interval = interval;
        this.sale = i;
        format.setTimeZone(DesugarTimeZone.getTimeZone("UTC"));
    }

    public static PromoEvent fromString(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.trim().replaceAll("(\\r|\\n)", "").split("\\:");
        try {
            SimpleDateFormat simpleDateFormat = format;
            PromoEvent promoEvent = new PromoEvent(new Interval(simpleDateFormat.parse(strArrSplit[0]), simpleDateFormat.parse(strArrSplit[1])), Integer.parseInt(strArrSplit[2]));
            if (strArrSplit.length != 4) {
                return promoEvent;
            }
            promoEvent.setUpdated(Long.parseLong(strArrSplit[3]));
            return promoEvent;
        } catch (ParseException e) {
            Logger.logSevere(str, e);
            return null;
        }
    }

    public static PromoEvent retreive() {
        try {
            Logger.logDebug("PROMO: check http://sleep.urbandroid.org/promo/promo.txt");
            URLConnection uRLConnectionOpenConnection = new URL("http://sleep.urbandroid.org/promo/promo.txt").openConnection();
            uRLConnectionOpenConnection.setReadTimeout(4000);
            uRLConnectionOpenConnection.setConnectTimeout(8000);
            String str = InputStreamUtil.read(uRLConnectionOpenConnection.getInputStream());
            PromoEvent promoEvent = "".equals(str) ? new PromoEvent(new Interval(-1L, -1L), 0) : fromString(str);
            if (promoEvent != null) {
                promoEvent.setUpdated(System.currentTimeMillis());
            }
            Logger.logDebug("PROMO: new " + promoEvent);
            return promoEvent;
        } catch (Exception e) {
            Logger.logSevere(e);
            return null;
        }
    }

    public static void update(Context context) {
        final Settings settings = new Settings(context);
        PromoEvent nextPromo = settings.getNextPromo();
        if (nextPromo != null && nextPromo.getUpdated() != -1 && nextPromo.getUpdated() + 259200000 >= System.currentTimeMillis()) {
            Logger.logDebug("PROMO: saved " + nextPromo);
            return;
        }
        long promoAttemptTime = settings.getPromoAttemptTime();
        if ((promoAttemptTime == -1 || System.currentTimeMillis() - promoAttemptTime > 14400000) && WaitForConnectivityService.isRequiredNetworkAvailable(context)) {
            settings.setPromoAttemptTime(System.currentTimeMillis());
            new Thread(new Runnable() { // from class: com.urbandroid.sleep.domain.promo.PromoEvent.1
                @Override // java.lang.Runnable
                public void run() {
                    PromoEvent promoEventRetreive = PromoEvent.retreive();
                    if (promoEventRetreive != null) {
                        settings.saveNextPromo(promoEventRetreive);
                    }
                }
            }).start();
        } else {
            Logger.logDebug("PROMO: No time update or no connectivity " + nextPromo);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            PromoEvent promoEvent = (PromoEvent) obj;
            if (this.sale != promoEvent.sale || this.updated != promoEvent.updated) {
                return false;
            }
            Interval interval = this.interval;
            Interval interval2 = promoEvent.interval;
            if (interval != null) {
                return interval.equals(interval2);
            }
            if (interval2 == null) {
                return true;
            }
        }
        return false;
    }

    public Interval getInterval() {
        return this.interval;
    }

    public int getSale() {
        return this.sale;
    }

    public long getUpdated() {
        return this.updated;
    }

    public int hashCode() {
        Interval interval = this.interval;
        int iHashCode = (((interval != null ? interval.hashCode() : 0) * 31) + this.sale) * 31;
        long j = this.updated;
        return iHashCode + ((int) (j ^ (j >>> 32)));
    }

    public void setUpdated(long j) {
        this.updated = j;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        SimpleDateFormat simpleDateFormat = format;
        sb.append(simpleDateFormat.format(new Date(this.interval.getFrom())));
        sb.append(":");
        sb.append(simpleDateFormat.format(new Date(this.interval.getTo())));
        sb.append(":");
        sb.append(this.sale);
        sb.append(":");
        sb.append(this.updated);
        return sb.toString();
    }
}
