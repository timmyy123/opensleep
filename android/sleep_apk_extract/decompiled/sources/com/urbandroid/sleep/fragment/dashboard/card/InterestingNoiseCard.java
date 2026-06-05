package com.urbandroid.sleep.fragment.dashboard.card;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.core.util.Pair;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ai.AiPrompt$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.domain.Noise;
import com.urbandroid.sleep.domain.tag.Tag;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import com.urbandroid.sleep.fragment.dashboard.card.SleepDetailHypnogramCard;
import com.urbandroid.sleep.graph.GraphView;
import com.urbandroid.sleep.media.PlayAudioActivity;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ColorUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u00192\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\rH\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000f0\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/InterestingNoiseCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/DashboardCard;", "Lcom/urbandroid/sleep/fragment/dashboard/card/SleepDetailHypnogramCard$SleepRecordViewHolder;", "activity", "Landroid/app/Activity;", "noises", "", "Lcom/urbandroid/sleep/domain/Noise;", "<init>", "(Landroid/app/Activity;Ljava/util/List;)V", "onCardClicked", "", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "getNameResource", "", "interestingSoundTagsCount", "", "Lcom/urbandroid/sleep/domain/tag/Tag;", "bindView", "viewHolder", "createViewHolder", "v", "isThemeCard", "", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InterestingNoiseCard extends DashboardCard<SleepDetailHypnogramCard.SleepRecordViewHolder> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Tag[] interestingSoundTags;
    private static final Map<Tag, Integer> interestingSoundTagsString;
    private final Map<Tag, Integer> interestingSoundTagsCount;
    private final List<Noise> noises;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R&\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/card/InterestingNoiseCard$Companion;", "", "<init>", "()V", "", "Lcom/urbandroid/sleep/domain/tag/Tag;", "interestingSoundTags", "[Lcom/urbandroid/sleep/domain/tag/Tag;", "getInterestingSoundTags", "()[Lcom/urbandroid/sleep/domain/tag/Tag;", "getInterestingSoundTags$annotations", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Tag[] getInterestingSoundTags() {
            return InterestingNoiseCard.interestingSoundTags;
        }

        private Companion() {
        }
    }

    static {
        Tag tag = Tag.LAUGH;
        Tag tag2 = Tag.SICK;
        Tag tag3 = Tag.TALK;
        Tag tag4 = Tag.SNORE;
        Tag tag5 = Tag.BABY;
        interestingSoundTags = new Tag[]{tag, tag2, tag3, tag4, tag5};
        interestingSoundTagsString = MapsKt.mapOf(TuplesKt.to(tag, Integer.valueOf(R.string.sound_laughter)), TuplesKt.to(tag2, Integer.valueOf(R.string.sound_sick)), TuplesKt.to(tag3, Integer.valueOf(R.string.sleep_talk)), TuplesKt.to(tag4, Integer.valueOf(R.string.stats_caption_snore)), TuplesKt.to(tag5, Integer.valueOf(R.string.sound_baby_cry)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public InterestingNoiseCard(Activity activity, List<? extends Noise> list) {
        super(activity, DashboardCard.Type.SLEEP_TALK, R.layout.card_interesting_noise);
        activity.getClass();
        list.getClass();
        this.noises = list;
        this.interestingSoundTagsCount = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable bindView$lambda$1(Noise noise) {
        noise.getClass();
        return Boolean.valueOf(Tag.hasTag(noise.getComment(), Tag.SNORE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Comparable bindView$lambda$2(Noise noise) {
        noise.getClass();
        return Long.valueOf(noise.getFromTime());
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void bindView(SleepDetailHypnogramCard.SleepRecordViewHolder viewHolder) {
        GraphView graphView;
        ImageView imageView;
        Integer num;
        viewHolder.getClass();
        TextView textView = viewHolder.title;
        if (textView != null) {
            textView.setText(R.string.interesting_noise_recordings);
        }
        View view = viewHolder.foreground;
        view.getClass();
        ((CardView) view).setCardBackgroundColor(ColorUtil.i(getContext(), R.color.tint_background));
        for (Tag tag : interestingSoundTags) {
            Map<Tag, Integer> map = this.interestingSoundTagsCount;
            List<Noise> list = this.noises;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (Tag.hasTag(((Noise) obj).getComment(), tag)) {
                    arrayList.add(obj);
                }
            }
            map.put(tag, Integer.valueOf(arrayList.size()));
        }
        CollectionsKt.sortedWith(this.noises, ComparisonsKt.compareBy(new AiPrompt$$ExternalSyntheticLambda0(10), new AiPrompt$$ExternalSyntheticLambda0(11)));
        StringBuilder sb = new StringBuilder();
        for (Tag tag2 : interestingSoundTags) {
            Integer num2 = this.interestingSoundTagsCount.get(tag2);
            if (num2 != null && num2.intValue() > 0 && (num = interestingSoundTagsString.get(tag2)) != null) {
                int iIntValue = num.intValue();
                sb.append(num2.intValue());
                sb.append("x ");
                sb.append(getContext().getString(iIntValue));
                sb.append("\n");
            }
        }
        if (sb.length() > 2) {
            sb.setLength(sb.length() - 1);
        }
        TextView textView2 = viewHolder.subtitle;
        if (textView2 != null) {
            textView2.setText(sb.toString());
        }
        CardView cardView = viewHolder.card;
        if (cardView != null && (imageView = (ImageView) cardView.findViewById(R.id.play_button)) != null) {
            imageView.setImageResource(R.drawable.ex_play_white);
        }
        if (this.noises.isEmpty() || (graphView = viewHolder.graph) == null) {
            return;
        }
        graphView.setRotateYAxisLabels(false);
        graphView.setDoGradient(false);
        graphView.setDrawYAxis(false);
        graphView.setDrawAverage(false);
        graphView.setDoTrimming(false);
        graphView.setDoDrawGraphLine(false);
        graphView.setDrawXAxisBars(false);
        graphView.setCardColor(ContextCompat.getColor(graphView.getContext(), R.color.transparent));
        graphView.setForceXAxisOffset(false);
        graphView.setDoMirrorGraph(true);
        graphView.setEquidistantValues(this.noises.get(0).getData(), true);
        graphView.setGradientFullColor(ColorUtil.i(graphView.getContext(), R.color.transparent));
        graphView.setGradientTransColor(ColorUtil.i(graphView.getContext(), R.color.transparent));
        graphView.setSleepGraphColor(ColorUtil.i(graphView.getContext(), R.color.white_tertiary));
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public SleepDetailHypnogramCard.SleepRecordViewHolder createViewHolder(View v) {
        v.getClass();
        return new SleepDetailHypnogramCard.SleepRecordViewHolder(v);
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public int getNameResource() {
        return R.string.interesting_noise_recordings;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public boolean isThemeCard() {
        return false;
    }

    @Override // com.urbandroid.sleep.fragment.dashboard.card.DashboardCard
    public void onCardClicked(View view) {
        view.getClass();
        if (this.noises.isEmpty()) {
            return;
        }
        int size = this.noises.size();
        long[] jArr = new long[size];
        for (int i = 0; i < size; i++) {
            Long id = this.noises.get(i).getId();
            id.getClass();
            jArr[i] = id.longValue();
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.play_button);
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ex_pause_white);
        }
        Intent intent = new Intent(getContext(), (Class<?>) PlayAudioActivity.class);
        intent.putExtra("noise_ids", jArr);
        if (!new Settings(getContext()).isTransitionAnimation()) {
            getContext().startActivity(intent);
            return;
        }
        Pair pairCreate = Pair.create(view.findViewById(R.id.foreground), "box");
        pairCreate.getClass();
        Pair pairCreate2 = Pair.create(view.findViewById(R.id.play_button), "fab");
        pairCreate2.getClass();
        ActivityOptionsCompat activityOptionsCompatMakeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(getContext(), pairCreate, pairCreate2);
        activityOptionsCompatMakeSceneTransitionAnimation.getClass();
        ContextCompat.startActivity(getContext(), intent, activityOptionsCompatMakeSceneTransitionAnimation.toBundle());
    }
}
