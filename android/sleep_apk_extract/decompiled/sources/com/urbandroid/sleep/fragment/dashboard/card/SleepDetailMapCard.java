package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordStringBuilder;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.location.Location;
import com.urbandroid.sleep.location.LocationService;
import kotlin.Metadata;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u001dB\u0019\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailMapCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailMapCard$SleepRecordViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/domain/SleepRecord;", "sleepRecord", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/domain/SleepRecord;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailMapCard$SleepRecordViewHolder;", ViewHierarchyConstants.VIEW_KEY, "", "onCardClicked", "(Landroid/view/View;)V", "viewHolder", "bindView", "(Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailMapCard$SleepRecordViewHolder;)V", "", "getNameResource", "()I", "", "isScreenReady", "()Z", "Lcom/urbandroid/sleep/domain/SleepRecord;", "getSleepRecord", "()Lcom/urbandroid/sleep/domain/SleepRecord;", "SleepRecordViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SleepDetailMapCard extends DashboardCard<SleepRecordViewHolder> {
    private final SleepRecord sleepRecord;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailMapCard$SleepRecordViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "subtitle", "getSubtitle", "setSubtitle", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class SleepRecordViewHolder extends LayeredViewHolder {
        private TextView subtitle;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SleepRecordViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.subtitle);
            viewFindViewById2.getClass();
            this.subtitle = (TextView) viewFindViewById2;
        }

        public final TextView getSubtitle() {
            return this.subtitle;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SleepDetailMapCard(Activity activity, SleepRecord sleepRecord) {
        super(activity, DashboardCard.Type.SLEEP_DETAIL_MAP, R.layout.card_sleep_detail_map);
        sleepRecord.getClass();
        this.sleepRecord = sleepRecord;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepRecordViewHolder viewHolder) {
        viewHolder.getClass();
        if (this.sleepRecord.hasTag(Tag.HOME)) {
            viewHolder.getSubtitle().setText(getContext().getString(R.string.geo_home));
            return;
        }
        if (this.sleepRecord.hasTag(Tag.GEO1)) {
            viewHolder.getSubtitle().setText(getContext().getString(R.string.location) + " 1");
            return;
        }
        if (this.sleepRecord.hasTag(Tag.GEO2)) {
            viewHolder.getSubtitle().setText(getContext().getString(R.string.location) + " 2");
            return;
        }
        if (!this.sleepRecord.hasTag(Tag.GEO3)) {
            viewHolder.getSubtitle().setText(getContext().getString(R.string.geo_unknown));
            return;
        }
        viewHolder.getSubtitle().setText(getContext().getString(R.string.location) + " 3");
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.show_map;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isScreenReady() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        Location locationComputeLocation = LocationService.computeLocation(this.sleepRecord.getGeo());
        locationComputeLocation.getClass();
        try {
            Uri uri = Uri.parse("geo:" + locationComputeLocation.getLat() + "," + locationComputeLocation.getLon() + "?q=" + locationComputeLocation.getLat() + "," + locationComputeLocation.getLon() + "(" + new SleepRecordStringBuilder(getContext()).build(this.sleepRecord) + MqttTopic.SINGLE_LEVEL_WILDCARD + getContext().getString(R.string.app_name) + ")");
            uri.getClass();
            getContext().startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException unused) {
            Toast.makeText(getContext(), R.string.general_unspecified_error, 0).show();
        }
    }
}
