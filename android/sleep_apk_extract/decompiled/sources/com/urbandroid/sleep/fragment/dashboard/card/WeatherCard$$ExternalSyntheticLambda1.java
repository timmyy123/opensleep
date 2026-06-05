package com.urbandroid.sleep.fragment.dashboard.card;

import android.view.View;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class WeatherCard$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ int $r8$classId;
    public final /* synthetic */ WeatherCard f$0;

    public /* synthetic */ WeatherCard$$ExternalSyntheticLambda1(WeatherCard weatherCard, int i) {
        this.$r8$classId = i;
        this.f$0 = weatherCard;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.$r8$classId;
        WeatherCard weatherCard = this.f$0;
        switch (i) {
            case 0:
                WeatherCard.renderWeather$lambda$0(weatherCard, view);
                break;
            default:
                WeatherCard.cannotGetLocation$lambda$0(weatherCard, view);
                break;
        }
    }
}
