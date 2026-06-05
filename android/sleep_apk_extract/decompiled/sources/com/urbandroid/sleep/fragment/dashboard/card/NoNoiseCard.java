package com.urbandroid.sleep.fragment.dashboard.card;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.settings.NoiseSettingsActivity;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.service.Settings;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0018\u00010\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\u0014\u0010\r\u001a\u00020\u000b2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u0000H\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016¨\u0006\u0014"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/NoNoiseCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/NoNoiseCard$NoNoiseViewHolder;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "<init>", "(Landroid/app/Activity;)V", "createViewHolder", "v", "Landroid/view/View;", "onCardClicked", "", ViewHierarchyConstants.VIEW_KEY, "bindView", "viewHolder", "isThemeCard", "", "getNameResource", "", "NoNoiseViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoNoiseCard extends DashboardCard<NoNoiseViewHolder> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/NoNoiseCard$NoNoiseViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/LayeredViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "<init>", "(Lcom/urbandroid/sleep/fragment/dashboard/card/NoNoiseCard;Landroid/view/View;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class NoNoiseViewHolder extends LayeredViewHolder {
        public NoNoiseViewHolder(View view) {
            super(view);
        }
    }

    public NoNoiseCard(Activity activity) {
        super(activity, DashboardCard.Type.NO_NOISE, R.layout.card_no_noise);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(NoNoiseViewHolder viewHolder) {
        viewHolder.getClass();
        if (new Settings(getContext()).isRecordingMasterSwitchEnabled()) {
            Activity context = getContext();
            View view = viewHolder.itemView;
            view.getClass();
            setCardVisibility(context, (ViewGroup) view, false);
        }
        View viewFindViewById = viewHolder.itemView.findViewById(R.id.summary);
        viewFindViewById.getClass();
        String string = getContext().getString(R.string.sound_recognition);
        String string2 = getContext().getString(R.string.sleep_recording_summary);
        String string3 = getContext().getString(R.string.anti_snoring_title);
        StringBuilder sbM6m = FileInsert$$ExternalSyntheticOutline0.m6m("• ", string, "\n• ", string2, "\n• ");
        sbM6m.append(string3);
        ((TextView) viewFindViewById).setText(sbM6m.toString());
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public NoNoiseViewHolder createViewHolder(View v) {
        v.getClass();
        return new NoNoiseViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.no_recordings;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        getContext().startActivity(new Intent(getContext(), (Class<?>) NoiseSettingsActivity.class));
    }
}
