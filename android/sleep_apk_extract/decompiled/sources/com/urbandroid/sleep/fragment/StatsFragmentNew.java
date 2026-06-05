package com.urbandroid.sleep.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.LifecycleOwnerKt;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.button.MaterialButton;
import com.urbandroid.common.FeatureLogger;
import com.urbandroid.common.util.ActivityUtils;
import com.urbandroid.common.util.DateUtil;
import com.urbandroid.common.util.Environment;
import com.urbandroid.common.util.intent.ViewIntent;
import com.urbandroid.sleep.ContextExtKt$contextScope$scope$1;
import com.urbandroid.sleep.ContextScope;
import com.urbandroid.sleep.FirstUsePreviewActivity;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.ViewExtKt;
import com.urbandroid.sleep.addon.stats.FilterAdapter;
import com.urbandroid.sleep.addon.stats.StatsRepoLoader;
import com.urbandroid.sleep.addon.stats.advice.CountrySleepRecordProvider;
import com.urbandroid.sleep.addon.stats.filter.AcceptAllFilter;
import com.urbandroid.sleep.addon.stats.filter.FilterFactory;
import com.urbandroid.sleep.addon.stats.filter.IFilter;
import com.urbandroid.sleep.addon.stats.model.IMeasureRecord;
import com.urbandroid.sleep.addon.stats.model.MeasureRecord;
import com.urbandroid.sleep.addon.stats.model.StatRepo;
import com.urbandroid.sleep.alarmclock.StatsActivity;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.fragment.StatsFragmentNew;
import com.urbandroid.sleep.fragment.dashboard.card.BackupCard;
import com.urbandroid.sleep.gui.fab.ScrollAnimator;
import com.urbandroid.sleep.gui.view.ComponentColorUtilKt;
import com.urbandroid.util.ColorUtil;
import io.ktor.events.Events$$ExternalSyntheticBUOutline0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import okio.Utf8$$ExternalSyntheticBUOutline0;
import org.eclipse.paho.client.mqttv3.MqttTopic;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u00012\u00020\u0002:\u0005+,-./B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\"\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010\u001dJ$\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\"\u0010%\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010)\u001a\u00020\u00162\u0006\u0010&\u001a\u00020\u0007H\u0016J\f\u0010*\u001a\u00020\u001a*\u00020\u001aH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew;", "Lcom/urbandroid/sleep/fragment/LazyFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", "fabs", "", "Landroid/view/View;", "fadeIn", "Landroid/view/animation/Animation;", "fadeOut", "fab", "Lcom/google/android/material/button/MaterialButton;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onResume", "", "onSetVisible", "loadData", "periodPosition", "", "filter", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder;", "(ILcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createBaseView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "populateBaseView", ViewHierarchyConstants.VIEW_KEY, "scrollAnimator", "Lcom/urbandroid/sleep/gui/fab/ScrollAnimator;", "onClick", "positionToPeriod", "FilterHolder", "ScoreAdapter", "DayAdapter", "CountryAdapter", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class StatsFragmentNew extends LazyFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private MaterialButton fab;
    private final List<View> fabs = new ArrayList();
    private Animation fadeIn;
    private Animation fadeOut;
    private LinearLayoutManager linearLayoutManager;
    public RecyclerView recyclerView;
    private ScrollAnimator scrollAnimator;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\n"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$Companion;", "", "<init>", "()V", "showNoRecords", "", "activity", "Landroid/app/Activity;", "mainView", "Landroid/view/ViewGroup;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showNoRecords$lambda$0$0(Activity activity, View view) {
            activity.startActivity(new Intent(view.getContext(), (Class<?>) FirstUsePreviewActivity.class));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showNoRecords$lambda$0$3(Activity activity, View view) {
            BackupCard.importData(activity, new Events$$ExternalSyntheticBUOutline0(6));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void showNoRecords$lambda$0$3$0() {
        }

        public final void showNoRecords(final Activity activity, ViewGroup mainView) {
            activity.getClass();
            if (mainView != null) {
                View viewFindViewById = mainView.findViewById(R.id.no_records);
                if (viewFindViewById != null) {
                    ViewExtKt.show(viewFindViewById);
                }
                View viewFindViewById2 = mainView.findViewById(R.id.get_started_tutorial);
                if (viewFindViewById2 != null) {
                    final int i = 0;
                    viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$Companion$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i2 = i;
                            Activity activity2 = activity;
                            switch (i2) {
                                case 0:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$0(activity2, view);
                                    break;
                                case 1:
                                    ViewIntent.url(activity2, "https://sleep.urbandroid.org/support");
                                    break;
                                case 2:
                                    ViewIntent.url(activity2, "https://youtu.be/whUibMSqkO4");
                                    break;
                                default:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$3(activity2, view);
                                    break;
                            }
                        }
                    });
                }
                View viewFindViewById3 = mainView.findViewById(R.id.get_started_support);
                if (viewFindViewById3 != null) {
                    final int i2 = 1;
                    viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$Companion$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i22 = i2;
                            Activity activity2 = activity;
                            switch (i22) {
                                case 0:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$0(activity2, view);
                                    break;
                                case 1:
                                    ViewIntent.url(activity2, "https://sleep.urbandroid.org/support");
                                    break;
                                case 2:
                                    ViewIntent.url(activity2, "https://youtu.be/whUibMSqkO4");
                                    break;
                                default:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$3(activity2, view);
                                    break;
                            }
                        }
                    });
                }
                View viewFindViewById4 = mainView.findViewById(R.id.get_started_video);
                if (viewFindViewById4 != null) {
                    final int i3 = 2;
                    viewFindViewById4.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$Companion$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i22 = i3;
                            Activity activity2 = activity;
                            switch (i22) {
                                case 0:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$0(activity2, view);
                                    break;
                                case 1:
                                    ViewIntent.url(activity2, "https://sleep.urbandroid.org/support");
                                    break;
                                case 2:
                                    ViewIntent.url(activity2, "https://youtu.be/whUibMSqkO4");
                                    break;
                                default:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$3(activity2, view);
                                    break;
                            }
                        }
                    });
                }
                View viewFindViewById5 = mainView.findViewById(R.id.get_started_import);
                if (viewFindViewById5 != null) {
                    final int i4 = 3;
                    viewFindViewById5.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$Companion$$ExternalSyntheticLambda0
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            int i22 = i4;
                            Activity activity2 = activity;
                            switch (i22) {
                                case 0:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$0(activity2, view);
                                    break;
                                case 1:
                                    ViewIntent.url(activity2, "https://sleep.urbandroid.org/support");
                                    break;
                                case 2:
                                    ViewIntent.url(activity2, "https://youtu.be/whUibMSqkO4");
                                    break;
                                default:
                                    StatsFragmentNew.Companion.showNoRecords$lambda$0$3(activity2, view);
                                    break;
                            }
                        }
                    });
                }
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder;", "", "", "item", "Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "filter", "<init>", "(Ljava/lang/String;Lcom/urbandroid/sleep/addon/stats/filter/IFilter;)V", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getItem", "Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "getFilter", "()Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "Companion", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final /* data */ class FilterHolder {
        private final IFilter filter;
        private final String item;

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private static final FilterHolder ALL = new FilterHolder(null, new AcceptAllFilter());

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder$Companion;", "", "<init>", "()V", "ALL", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder;", "getALL", "()Lcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final FilterHolder getALL() {
                return FilterHolder.ALL;
            }

            private Companion() {
            }
        }

        public FilterHolder(String str, IFilter iFilter) {
            iFilter.getClass();
            this.item = str;
            this.filter = iFilter;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FilterHolder)) {
                return false;
            }
            FilterHolder filterHolder = (FilterHolder) other;
            return Intrinsics.areEqual(this.item, filterHolder.item) && Intrinsics.areEqual(this.filter, filterHolder.filter);
        }

        public final IFilter getFilter() {
            return this.filter;
        }

        public final String getItem() {
            return this.item;
        }

        public int hashCode() {
            String str = this.item;
            return this.filter.hashCode() + ((str == null ? 0 : str.hashCode()) * 31);
        }

        public String toString() {
            return "FilterHolder(item=" + this.item + ", filter=" + this.filter + ")";
        }
    }

    @Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u0010\u0012\f\u0012\n0\u0002R\u00060\u0000R\u00020\u00030\u00012\u00020\u0004:\u0001 B/\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0014\u0010\u0015\u001a\u00020\u000e*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\fH\u0002J \u0010\u0018\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\fH\u0016J \u0010\u001c\u001a\u00020\u001d2\u000e\u0010\u001e\u001a\n0\u0002R\u00060\u0000R\u00020\u00032\u0006\u0010\u0017\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\u0012X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$ScoreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$ScoreAdapter$Holder;", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew;", "Lcom/urbandroid/common/FeatureLogger;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "statRepo", "Lcom/urbandroid/sleep/addon/stats/model/StatRepo;", "periodPosition", "", "filter", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder;", "<init>", "(Lcom/urbandroid/sleep/fragment/StatsFragmentNew;Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;Lcom/urbandroid/sleep/addon/stats/model/StatRepo;ILcom/urbandroid/sleep/fragment/StatsFragmentNew$FilterHolder;)V", "tag", "", "getTag", "()Ljava/lang/String;", "toFilterHolder", "Lcom/urbandroid/sleep/addon/stats/FilterAdapter;", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "getItemCount", "Holder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public final class ScoreAdapter extends RecyclerView.Adapter<Holder> implements FeatureLogger {
        private final Activity context;
        private final FilterHolder filter;
        private final int periodPosition;
        private final CoroutineScope scope;
        private final StatRepo statRepo;
        private final String tag;
        final /* synthetic */ StatsFragmentNew this$0;

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$ScoreAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/ViewGroup;", "<init>", "(Lcom/urbandroid/sleep/fragment/StatsFragmentNew$ScoreAdapter;Landroid/view/ViewGroup;)V", "bind", "", "addDebtToView", "textView", "Landroid/widget/TextView;", "minutes", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public final class Holder extends RecyclerView.ViewHolder {
            final /* synthetic */ ScoreAdapter this$0;
            private final ViewGroup view;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Holder(ScoreAdapter scoreAdapter, ViewGroup viewGroup) {
                super(viewGroup);
                viewGroup.getClass();
                this.this$0 = scoreAdapter;
                this.view = viewGroup;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final void addDebtToView(TextView textView, int minutes) {
                if (textView != null) {
                    Context context = textView.getContext();
                    context.getClass();
                    ContextExtKt$contextScope$scope$1 contextExtKt$contextScope$scope$1 = new ContextExtKt$contextScope$scope$1(context);
                    if (minutes < 0) {
                        textView.setTextColor(contextExtKt$contextScope$scope$1.getArgb(R.color.negative_light));
                        textView.setText("-" + DateUtil.formatMinutes(Integer.valueOf(minutes)));
                        return;
                    }
                    textView.setTextColor(contextExtKt$contextScope$scope$1.getArgb(R.color.positive));
                    textView.setText(MqttTopic.SINGLE_LEVEL_WILDCARD + DateUtil.formatMinutes(Integer.valueOf(minutes)));
                }
            }

            public final void bind() {
                CoroutineScope coroutineScope = this.this$0.scope;
                ScoreAdapter scoreAdapter = this.this$0;
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new StatsFragmentNew$ScoreAdapter$Holder$bind$1(scoreAdapter, this, scoreAdapter.this$0, null), 3, null);
            }
        }

        public ScoreAdapter(StatsFragmentNew statsFragmentNew, Activity activity, CoroutineScope coroutineScope, StatRepo statRepo, int i, FilterHolder filterHolder) {
            activity.getClass();
            coroutineScope.getClass();
            statRepo.getClass();
            filterHolder.getClass();
            this.this$0 = statsFragmentNew;
            this.context = activity;
            this.scope = coroutineScope;
            this.statRepo = statRepo;
            this.periodPosition = i;
            this.filter = filterHolder;
            this.tag = "ScoreAdapter";
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final FilterHolder toFilterHolder(FilterAdapter filterAdapter, int i) {
            String item = filterAdapter.getItem(i);
            IFilter filter = FilterFactory.getFilter(i, filterAdapter.getItem(i));
            filter.getClass();
            return new FilterHolder(item, filter);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return this.tag;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(Holder holder, int position) {
            holder.getClass();
            holder.bind();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            parent.getClass();
            View viewInflate = ViewExtKt.inflate(parent, R.layout.stats_recycler_score, false);
            viewInflate.getClass();
            return new Holder(this, (ViewGroup) viewInflate);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.StatsFragmentNew$loadData$1, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.fragment.StatsFragmentNew", f = "StatsFragmentNew.kt", l = {105}, m = "loadData", v = 2)
    public static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StatsFragmentNew.this.loadData(0, null, this);
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.fragment.StatsFragmentNew$onResume$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 3, 0}, xi = 48)
    @DebugMetadata(c = "com.urbandroid.sleep.fragment.StatsFragmentNew$onResume$1", f = "StatsFragmentNew.kt", l = {91}, m = "invokeSuspend", v = 2)
    public static final class C20981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C20981(Continuation<? super C20981> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return StatsFragmentNew.this.new C20981(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C20981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StatsFragmentNew statsFragmentNew = StatsFragmentNew.this;
                this.label = 1;
                if (StatsFragmentNew.loadData$default(statsFragmentNew, 0, null, this, 3, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00cb A[Catch: all -> 0x0131, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0131, blocks: (B:34:0x0097, B:45:0x00cb), top: B:75:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadData(int i, FilterHolder filterHolder, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        Throwable th;
        StatsFragmentNew statsFragmentNew;
        FragmentActivity fragmentActivity;
        ProgressBar progressBar;
        Object objLoad;
        FilterHolder filterHolder2;
        FragmentActivity fragmentActivity2;
        StatRepo statRepo;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ViewExtKt.hide(getRecyclerView());
            FragmentActivity activity = getActivity();
            if (activity == null) {
                return Unit.INSTANCE;
            }
            ProgressBar progressBar2 = (ProgressBar) activity.findViewById(R.id.progress);
            if (progressBar2 != null) {
                try {
                    ViewExtKt.show(progressBar2);
                    try {
                        StatsRepoLoader statsRepoLoader = StatsRepoLoader.INSTANCE;
                        Context applicationContext = activity.getApplicationContext();
                        applicationContext.getClass();
                        int iPositionToPeriod = positionToPeriod(i);
                        StatRepo.Mode mode = StatRepo.Mode.STATS;
                        anonymousClass1.L$0 = filterHolder;
                        anonymousClass1.L$1 = activity;
                        anonymousClass1.L$2 = progressBar2;
                        anonymousClass1.I$0 = i;
                        anonymousClass1.label = 1;
                        objLoad = statsRepoLoader.load(applicationContext, iPositionToPeriod, mode, anonymousClass1);
                        if (objLoad != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        filterHolder2 = filterHolder;
                        fragmentActivity2 = activity;
                        obj = objLoad;
                        progressBar = progressBar2;
                        int i4 = i;
                        statRepo = (StatRepo) obj;
                        if (statRepo != null) {
                        }
                        fragmentActivity = fragmentActivity2;
                    } catch (Throwable th2) {
                        statsFragmentNew = this;
                        th = th2;
                        fragmentActivity = activity;
                        progressBar = progressBar2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    statsFragmentNew = this;
                    fragmentActivity = activity;
                    progressBar = progressBar2;
                    if (progressBar != null) {
                    }
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(fragmentActivity.getApplicationContext(), R.anim.unfade_stats);
                    animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew.loadData.2
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation p0) {
                            ViewExtKt.show(StatsFragmentNew.this.getRecyclerView());
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation p0) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation p0) {
                        }
                    });
                    statsFragmentNew.getRecyclerView().startAnimation(animationLoadAnimation);
                    throw th;
                }
            } else {
                StatsRepoLoader statsRepoLoader2 = StatsRepoLoader.INSTANCE;
                Context applicationContext2 = activity.getApplicationContext();
                applicationContext2.getClass();
                int iPositionToPeriod2 = positionToPeriod(i);
                StatRepo.Mode mode2 = StatRepo.Mode.STATS;
                anonymousClass1.L$0 = filterHolder;
                anonymousClass1.L$1 = activity;
                anonymousClass1.L$2 = progressBar2;
                anonymousClass1.I$0 = i;
                anonymousClass1.label = 1;
                objLoad = statsRepoLoader2.load(applicationContext2, iPositionToPeriod2, mode2, anonymousClass1);
                if (objLoad != coroutine_suspended) {
                }
            }
        } else {
            if (i3 != 1) {
                Utf8$$ExternalSyntheticBUOutline0.m$3("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            i = anonymousClass1.I$0;
            progressBar = (ProgressBar) anonymousClass1.L$2;
            fragmentActivity = (FragmentActivity) anonymousClass1.L$1;
            FilterHolder filterHolder3 = (FilterHolder) anonymousClass1.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                filterHolder2 = filterHolder3;
                fragmentActivity2 = fragmentActivity;
                int i42 = i;
                try {
                    statRepo = (StatRepo) obj;
                    if (statRepo != null) {
                        try {
                            Toast.makeText(fragmentActivity2, R.string.general_unspecified_error, 1).show();
                            Unit unit = Unit.INSTANCE;
                            if (progressBar != null) {
                                ViewExtKt.hide(progressBar);
                            }
                            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(fragmentActivity2.getApplicationContext(), R.anim.unfade_stats);
                            animationLoadAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew.loadData.2
                                @Override // android.view.animation.Animation.AnimationListener
                                public void onAnimationEnd(Animation p0) {
                                    ViewExtKt.show(StatsFragmentNew.this.getRecyclerView());
                                }

                                @Override // android.view.animation.Animation.AnimationListener
                                public void onAnimationRepeat(Animation p0) {
                                }

                                @Override // android.view.animation.Animation.AnimationListener
                                public void onAnimationStart(Animation p0) {
                                }
                            });
                            getRecyclerView().startAnimation(animationLoadAnimation2);
                            return unit;
                        } catch (Throwable th4) {
                            th = th4;
                            statsFragmentNew = this;
                        }
                    } else {
                        statsFragmentNew = this;
                        try {
                            try {
                                getRecyclerView().setAdapter(new ConcatAdapter(new ScoreAdapter(statsFragmentNew, fragmentActivity2, LifecycleOwnerKt.getLifecycleScope(this), statRepo, i42, filterHolder2), new CountryAdapter(fragmentActivity2, LifecycleOwnerKt.getLifecycleScope(statsFragmentNew), false), new DayAdapter(fragmentActivity2, LifecycleOwnerKt.getLifecycleScope(statsFragmentNew), statRepo, filterHolder2.getFilter())));
                                if (progressBar != null) {
                                    ViewExtKt.hide(progressBar);
                                }
                                try {
                                    Animation animationLoadAnimation3 = AnimationUtils.loadAnimation(fragmentActivity2.getApplicationContext(), R.anim.unfade_stats);
                                    animationLoadAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew.loadData.2
                                        @Override // android.view.animation.Animation.AnimationListener
                                        public void onAnimationEnd(Animation p0) {
                                            ViewExtKt.show(StatsFragmentNew.this.getRecyclerView());
                                        }

                                        @Override // android.view.animation.Animation.AnimationListener
                                        public void onAnimationRepeat(Animation p0) {
                                        }

                                        @Override // android.view.animation.Animation.AnimationListener
                                        public void onAnimationStart(Animation p0) {
                                        }
                                    });
                                    statsFragmentNew.getRecyclerView().startAnimation(animationLoadAnimation3);
                                } catch (Exception unused) {
                                    ViewExtKt.show(statsFragmentNew.getRecyclerView());
                                }
                                return Unit.INSTANCE;
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            th = th;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                    statsFragmentNew = this;
                }
                fragmentActivity = fragmentActivity2;
            } catch (Throwable th8) {
                th = th8;
                statsFragmentNew = this;
            }
        }
        if (progressBar != null) {
            ViewExtKt.hide(progressBar);
        }
        try {
            Animation animationLoadAnimation4 = AnimationUtils.loadAnimation(fragmentActivity.getApplicationContext(), R.anim.unfade_stats);
            animationLoadAnimation4.setAnimationListener(new Animation.AnimationListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew.loadData.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation p0) {
                    ViewExtKt.show(StatsFragmentNew.this.getRecyclerView());
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation p0) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation p0) {
                }
            });
            statsFragmentNew.getRecyclerView().startAnimation(animationLoadAnimation4);
            throw th;
        } catch (Exception unused2) {
            ViewExtKt.show(statsFragmentNew.getRecyclerView());
            throw th;
        }
    }

    public static /* synthetic */ Object loadData$default(StatsFragmentNew statsFragmentNew, int i, FilterHolder filterHolder, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 1;
        }
        if ((i2 & 2) != 0) {
            filterHolder = FilterHolder.INSTANCE.getALL();
        }
        return statsFragmentNew.loadData(i, filterHolder, continuation);
    }

    private final int positionToPeriod(int i) {
        String str = getResources().getStringArray(R.array.period_entries)[i];
        str.getClass();
        return Integer.parseInt(str);
    }

    public static final void showNoRecords(Activity activity, ViewGroup viewGroup) {
        INSTANCE.showNoRecords(activity, viewGroup);
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public View createBaseView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        inflater.getClass();
        View viewInflate = inflater.inflate(R.layout.fragment_stats_new, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.stats_recycler);
        viewFindViewById.getClass();
        setRecyclerView((RecyclerView) viewFindViewById);
        FragmentActivity activity = getActivity();
        LinearLayoutManager linearLayoutManager = null;
        this.linearLayoutManager = new LinearLayoutManager(activity != null ? activity.getApplicationContext() : null);
        RecyclerView recyclerView = getRecyclerView();
        LinearLayoutManager linearLayoutManager2 = this.linearLayoutManager;
        if (linearLayoutManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayoutManager");
        } else {
            linearLayoutManager = linearLayoutManager2;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        ViewExtKt.hide(getRecyclerView());
        return viewInflate;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        return null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        view.getClass();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C20981(null), 3, null);
    }

    @Override // com.urbandroid.sleep.fragment.LazyFragment
    public void onSetVisible() {
        isAlreadyLoaded();
    }

    @Override // com.urbandroid.sleep.fragment.ILazyFragment
    public void populateBaseView(View view, LayoutInflater inflater, Bundle savedInstanceState) {
        view.getClass();
        inflater.getClass();
        final FragmentActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        this.fadeIn = AnimationUtils.loadAnimation(activity.getApplicationContext(), R.anim.show);
        this.fadeOut = AnimationUtils.loadAnimation(activity.getApplicationContext(), R.anim.hide);
        MaterialButton materialButton = (MaterialButton) activity.findViewById(R.id.fab);
        ComponentColorUtilKt.color(materialButton);
        this.fab = materialButton;
        CardView cardView = (CardView) activity.findViewById(R.id.foreground);
        if (cardView != null) {
            cardView.setCardBackgroundColor(ColorUtil.i(getContext(), R.color.tint_background));
        }
        RecyclerView recyclerView = getRecyclerView();
        recyclerView.setVerticalFadingEdgeEnabled(false);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$populateBaseView$2$1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView2, int dx, int dy) {
                recyclerView2.getClass();
                if (this.this$0.isFramentVisible()) {
                    int iComputeVerticalScrollOffset = recyclerView2.computeVerticalScrollOffset();
                    if (Math.abs(dy) > ActivityUtils.getDip(recyclerView2.getContext(), 8)) {
                        for (View view2 : this.this$0.fabs) {
                            if (dy > 0) {
                                if (view2.getVisibility() != 4) {
                                    view2.startAnimation(this.this$0.fadeOut);
                                    ViewExtKt.hide(view2);
                                }
                            } else if (dy < 0 && view2.getVisibility() == 4) {
                                ViewExtKt.show(view2);
                                view2.startAnimation(this.this$0.fadeIn);
                            }
                        }
                    }
                    if (this.this$0.scrollAnimator == null) {
                        this.this$0.scrollAnimator = new ScrollAnimator(this.this$0.getActivity(), this.this$0.fab, 0, activity instanceof StatsActivity, 4, null);
                    }
                    ScrollAnimator scrollAnimator = this.this$0.scrollAnimator;
                    if (scrollAnimator != null) {
                        StatsFragmentNew statsFragmentNew = this.this$0;
                        scrollAnimator.scrollDelta(dy);
                        scrollAnimator.position(iComputeVerticalScrollOffset);
                        for (View view3 : statsFragmentNew.fabs) {
                            if (iComputeVerticalScrollOffset == 0 && view3.getVisibility() == 4) {
                                ViewExtKt.show(view3);
                                view3.startAnimation(statsFragmentNew.fadeIn);
                            }
                        }
                    }
                }
            }
        });
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        recyclerView.getClass();
        this.recyclerView = recyclerView;
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001.B'\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001bR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001cR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020 8\u0016X\u0096D¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R6\u0010*\u001a$\u0012\f\u0012\n '*\u0004\u0018\u00010&0&\u0012\u0012\u0012\u0010\u0012\f\u0012\n '*\u0004\u0018\u00010)0)0(0%8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020&0(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u0006/"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$DayAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$DayAdapter$Holder;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lcom/urbandroid/sleep/addon/stats/model/StatRepo;", "statRepo", "Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "filter", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;Lcom/urbandroid/sleep/addon/stats/model/StatRepo;Lcom/urbandroid/sleep/addon/stats/filter/IFilter;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/urbandroid/sleep/fragment/StatsFragmentNew$DayAdapter$Holder;", "holder", "position", "", "onBindViewHolder", "(Lcom/urbandroid/sleep/fragment/StatsFragmentNew$DayAdapter$Holder;I)V", "getItemCount", "()I", "Landroid/app/Activity;", "Lkotlinx/coroutines/CoroutineScope;", "Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "getFilter", "()Lcom/urbandroid/sleep/addon/stats/filter/IFilter;", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "Lcom/urbandroid/sleep/addon/stats/model/StatRepo$DayMonth;", "kotlin.jvm.PlatformType", "", "Lcom/urbandroid/sleep/domain/SleepRecord;", "recordMap", "Ljava/util/Map;", "days", "Ljava/util/List;", "Holder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class DayAdapter extends RecyclerView.Adapter<Holder> implements FeatureLogger {
        private final Activity context;
        private final List<StatRepo.DayMonth> days;
        private final IFilter filter;
        private final Map<StatRepo.DayMonth, List<SleepRecord>> recordMap;
        private final CoroutineScope scope;
        private final String tag;

        public DayAdapter(Activity activity, CoroutineScope coroutineScope, StatRepo statRepo, IFilter iFilter) {
            activity.getClass();
            coroutineScope.getClass();
            statRepo.getClass();
            iFilter.getClass();
            this.context = activity;
            this.scope = coroutineScope;
            this.filter = iFilter;
            this.tag = "DayAdapter";
            Map<StatRepo.DayMonth, List<SleepRecord>> recordMap = statRepo.getRecordMap();
            recordMap.getClass();
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<StatRepo.DayMonth, List<SleepRecord>> entry : recordMap.entrySet()) {
                StatRepo.DayMonth key = entry.getKey();
                List<SleepRecord> value = entry.getValue();
                value.getClass();
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : value) {
                    SleepRecord sleepRecord = (SleepRecord) obj;
                    IFilter iFilter2 = this.filter;
                    sleepRecord.getClass();
                    if (iFilter2.filter(sleepRecord)) {
                        arrayList2.add(obj);
                    }
                }
                arrayList2 = arrayList2.isEmpty() ? null : arrayList2;
                Pair pair = arrayList2 != null ? TuplesKt.to(key, arrayList2) : null;
                if (pair != null) {
                    arrayList.add(pair);
                }
            }
            Map<StatRepo.DayMonth, List<SleepRecord>> map = MapsKt.toMap(arrayList);
            this.recordMap = map;
            Set<StatRepo.DayMonth> setKeySet = map.keySet();
            final Comparator comparator = new Comparator() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$DayAdapter$special$$inlined$compareByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((StatRepo.DayMonth) t2).getYear()), Integer.valueOf(((StatRepo.DayMonth) t).getYear()));
                }
            };
            final Comparator comparator2 = new Comparator() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$DayAdapter$special$$inlined$thenByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Integer.valueOf(((StatRepo.DayMonth) t2).getMonth()), Integer.valueOf(((StatRepo.DayMonth) t).getMonth()));
                }
            };
            this.days = CollectionsKt.sortedWith(setKeySet, new Comparator() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$DayAdapter$special$$inlined$thenByDescending$2
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    int iCompare = comparator2.compare(t, t2);
                    return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Integer.valueOf(((StatRepo.DayMonth) t2).getDay()), Integer.valueOf(((StatRepo.DayMonth) t).getDay()));
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.days.size();
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return this.tag;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(Holder holder, int position) {
            List<? extends SleepRecord> listEmptyList;
            List<SleepRecord> listEmptyList2;
            holder.getClass();
            StatRepo.DayMonth dayMonth = this.days.get(position);
            StatRepo.DayMonth dayMonth2 = (StatRepo.DayMonth) CollectionsKt.getOrNull(this.days, position + 1);
            List<SleepRecord> list = this.recordMap.get(dayMonth);
            if (list == null || (listEmptyList = CollectionsKt.sortedWith(list, new Comparator() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$DayAdapter$onBindViewHolder$$inlined$sortedByDescending$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((SleepRecord) t2).getTo(), ((SleepRecord) t).getTo());
                }
            })) == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            if (dayMonth2 == null || (listEmptyList2 = this.recordMap.get(dayMonth2)) == null) {
                listEmptyList2 = CollectionsKt.emptyList();
            }
            holder.bind(dayMonth, listEmptyList, CollectionsKt.plus((Collection) listEmptyList, (Iterable) listEmptyList2), position == this.days.size() - 1);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            parent.getClass();
            Activity activity = this.context;
            CoroutineScope coroutineScope = this.scope;
            View viewInflate = ViewExtKt.inflate(parent, R.layout.row_stats, false);
            viewInflate.getClass();
            return new Holder(activity, coroutineScope, (ViewGroup) viewInflate);
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ4\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$DayAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/urbandroid/sleep/ContextScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "parentLayout", "Landroid/view/ViewGroup;", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;Landroid/view/ViewGroup;)V", "getContext", "()Landroid/app/Activity;", "getParentLayout", "()Landroid/view/ViewGroup;", "job", "Lkotlinx/coroutines/Job;", "bind", "", "day", "Lcom/urbandroid/sleep/addon/stats/model/StatRepo$DayMonth;", "records", "", "Lcom/urbandroid/sleep/domain/SleepRecord;", "sriRecords", "last", "", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static final class Holder extends RecyclerView.ViewHolder implements ContextScope {
            private final Activity context;
            private Job job;
            private final ViewGroup parentLayout;
            private final CoroutineScope scope;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Holder(Activity activity, CoroutineScope coroutineScope, ViewGroup viewGroup) {
                super(viewGroup);
                activity.getClass();
                coroutineScope.getClass();
                viewGroup.getClass();
                this.context = activity;
                this.scope = coroutineScope;
                this.parentLayout = viewGroup;
            }

            public final void bind(StatRepo.DayMonth day, List<? extends SleepRecord> records, List<? extends SleepRecord> sriRecords, boolean last) {
                day.getClass();
                records.getClass();
                sriRecords.getClass();
                Job job = this.job;
                if (job != null) {
                    Job.cancel$default(job, null, 1, null);
                }
                this.job = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new StatsFragmentNew$DayAdapter$Holder$bind$1(day, this, records, sriRecords, last, null), 3, null);
            }

            @Override // com.urbandroid.sleep.ContextScope
            public /* bridge */ int getArgb(int i) {
                return super.getArgb(i);
            }

            @Override // com.urbandroid.sleep.ContextScope
            public /* bridge */ ColorStateList getAsColorStateList(int i) {
                return super.getAsColorStateList(i);
            }

            @Override // com.urbandroid.sleep.ContextScope
            public /* bridge */ int getDip(int i) {
                return super.getDip(i);
            }

            public final ViewGroup getParentLayout() {
                return this.parentLayout;
            }

            @Override // com.urbandroid.sleep.ContextScope
            public /* bridge */ String getValue(int i) {
                return super.getValue(i);
            }

            @Override // com.urbandroid.sleep.ContextScope
            /* JADX INFO: renamed from: getContext, reason: from getter */
            public Activity get$context() {
                return this.context;
            }
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001*B!\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001f\u001a\u00020\u001e8\u0016X\u0096D¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R*\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010#8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u0006+"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter$Holder;", "Lcom/urbandroid/common/FeatureLogger;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "all", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;Z)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter$Holder;", "holder", "position", "", "onBindViewHolder", "(Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter$Holder;I)V", "getItemCount", "()I", "Landroid/app/Activity;", "Lkotlinx/coroutines/CoroutineScope;", "Z", "getAll", "()Z", "", "tag", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "", "countries", "Ljava/util/List;", "getCountries", "()Ljava/util/List;", "setCountries", "(Ljava/util/List;)V", "Holder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CountryAdapter extends RecyclerView.Adapter<Holder> implements FeatureLogger {
        private final boolean all;
        private final Activity context;
        private List<String> countries;
        private final CoroutineScope scope;
        private final String tag;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0006B\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0001\u0001\u0007¨\u0006\b"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "CountryStats", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter$Holder$CountryStats;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
        public static abstract class Holder extends RecyclerView.ViewHolder {
            public /* synthetic */ Holder(ViewGroup viewGroup, DefaultConstructorMarker defaultConstructorMarker) {
                this(viewGroup);
            }

            private Holder(ViewGroup viewGroup) {
                super(viewGroup);
            }

            @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter$Holder$CountryStats;", "Lcom/urbandroid/sleep/fragment/StatsFragmentNew$CountryAdapter$Holder;", "Lcom/urbandroid/sleep/ContextScope;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Landroid/app/Activity;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "parentLayout", "Landroid/view/ViewGroup;", "all", "", "<init>", "(Landroid/app/Activity;Lkotlinx/coroutines/CoroutineScope;Landroid/view/ViewGroup;Z)V", "getContext", "()Landroid/app/Activity;", "getParentLayout", "()Landroid/view/ViewGroup;", "getAll", "()Z", "job", "Lkotlinx/coroutines/Job;", "bind", "", "country", "", "record", "Lcom/urbandroid/sleep/addon/stats/model/IMeasureRecord;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
            public static final class CountryStats extends Holder implements ContextScope {
                private final boolean all;
                private final Activity context;
                private Job job;
                private final ViewGroup parentLayout;
                private final CoroutineScope scope;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public CountryStats(Activity activity, CoroutineScope coroutineScope, ViewGroup viewGroup, boolean z) {
                    super(viewGroup, null);
                    activity.getClass();
                    coroutineScope.getClass();
                    viewGroup.getClass();
                    this.context = activity;
                    this.scope = coroutineScope;
                    this.parentLayout = viewGroup;
                    this.all = z;
                }

                public final void bind(String country, IMeasureRecord record) {
                    record.getClass();
                    Job job = this.job;
                    if (job != null) {
                        Job.cancel$default(job, null, 1, null);
                    }
                    this.job = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new StatsFragmentNew$CountryAdapter$Holder$CountryStats$bind$1(this, record, country, null), 3, null);
                }

                public final boolean getAll() {
                    return this.all;
                }

                @Override // com.urbandroid.sleep.ContextScope
                public /* bridge */ int getArgb(int i) {
                    return super.getArgb(i);
                }

                @Override // com.urbandroid.sleep.ContextScope
                public /* bridge */ ColorStateList getAsColorStateList(int i) {
                    return super.getAsColorStateList(i);
                }

                public final ViewGroup getParentLayout() {
                    return this.parentLayout;
                }

                @Override // com.urbandroid.sleep.ContextScope
                public /* bridge */ String getValue(int i) {
                    return super.getValue(i);
                }

                @Override // com.urbandroid.sleep.ContextScope
                /* JADX INFO: renamed from: getContext, reason: from getter */
                public Activity get$context() {
                    return this.context;
                }
            }
        }

        public CountryAdapter(Activity activity, CoroutineScope coroutineScope, boolean z) {
            activity.getClass();
            coroutineScope.getClass();
            this.context = activity;
            this.scope = coroutineScope;
            this.all = z;
            this.tag = "CountryAdapter";
            String countryCode = Environment.getCountryCode(activity);
            countryCode = CountrySleepRecordProvider.getMeasureRecord(countryCode) == null ? Locale.getDefault().getCountry() : countryCode;
            if (!z) {
                this.countries = CollectionsKt.listOf(countryCode);
                return;
            }
            List listSortedWith = CollectionsKt.sortedWith(CollectionsKt.toList(CountrySleepRecordProvider.getMap().entrySet()), new Comparator() { // from class: com.urbandroid.sleep.fragment.StatsFragmentNew$CountryAdapter$special$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(Integer.valueOf(((MeasureRecord) ((Map.Entry) t2).getValue()).getEvidence()), Integer.valueOf(((MeasureRecord) ((Map.Entry) t).getValue()).getEvidence()));
                }
            });
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSortedWith, 10));
            Iterator it = listSortedWith.iterator();
            while (it.hasNext()) {
                arrayList.add((String) ((Map.Entry) it.next()).getKey());
            }
            this.countries = arrayList;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List<String> list = this.countries;
            if (list != null) {
                return list.size();
            }
            return 0;
        }

        @Override // com.urbandroid.common.FeatureLogger
        public String getTag() {
            return this.tag;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(Holder holder, int position) {
            holder.getClass();
            List<String> list = this.countries;
            String str = list != null ? list.get(position) : null;
            MeasureRecord measureRecord = CountrySleepRecordProvider.getMeasureRecord(str);
            measureRecord.getClass();
            ((Holder.CountryStats) holder).bind(str, measureRecord);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            parent.getClass();
            Activity activity = this.context;
            CoroutineScope coroutineScope = this.scope;
            View viewInflate = ViewExtKt.inflate(parent, R.layout.row_stats_country, false);
            viewInflate.getClass();
            return new Holder.CountryStats(activity, coroutineScope, (ViewGroup) viewInflate, this.all);
        }

        public /* synthetic */ CountryAdapter(Activity activity, CoroutineScope coroutineScope, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(activity, coroutineScope, (i & 4) != 0 ? true : z);
        }
    }
}
