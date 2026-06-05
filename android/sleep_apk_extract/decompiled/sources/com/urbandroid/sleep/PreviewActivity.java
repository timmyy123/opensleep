package com.urbandroid.sleep;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.view.OnBackPressedCallback;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.contract.ActivityResultContracts$RequestPermission;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.facebook.FacebookSdk$$ExternalSyntheticLambda9;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import com.facebook.internal.ServerProtocol;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.BaseActivity;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.PreviewActivity;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.fragment.preview.PreviewPage;
import com.urbandroid.sleep.fragment.preview.PreviewPageFragment;
import com.urbandroid.sleep.fragment.preview.PreviewPagerAdapter;
import com.urbandroid.sleep.fragment.preview.TinderPreviewPage;
import com.urbandroid.sleep.gui.NoSwipeViewPager;
import com.urbandroid.sleep.service.PrefStore;
import com.urbandroid.sleep.service.SharedApplicationContext;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.mp4parser.boxes.iso14496.part12.FreeSpaceBox;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000e\b&\u0018\u00002\u00020\u0001:\u0001?B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u0010\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0011\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0011\u0010\u0003J\u000f\u0010\u0012\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0012\u0010\u0003J\u000f\u0010\u0013\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0013\u0010\u0003J\u000f\u0010\u0014\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0014\u0010\u0003J'\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001c\u0010\u001dR\u001d\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00103\u001a\u0002028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001f\u0010:\u001a\n 9*\u0004\u0018\u00010\u001f0\u001f8\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R\u0014\u0010>\u001a\u00020\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010\u000e¨\u0006@"}, d2 = {"Lcom/urbandroid/sleep/PreviewActivity;", "Lcom/urbandroid/common/BaseActivity;", "<init>", "()V", "", "getLayoutRes", "()I", "Landroid/os/Bundle;", "outState", "", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "", "canSkip", "()Z", "savedInstanceState", "onCreate", FreeSpaceBox.TYPE, "onStart", "onStop", "onDestroy", "Lcom/urbandroid/sleep/service/PrefStore;", "prefs", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "page", "currentPage", "autoDislike", "(Lcom/urbandroid/sleep/service/PrefStore;Lcom/urbandroid/sleep/fragment/preview/PreviewPage;I)V", "nextPage", "(I)V", "", "", "skippedPages", "Ljava/util/Set;", "getSkippedPages", "()Ljava/util/Set;", "Lcom/urbandroid/sleep/gui/NoSwipeViewPager;", "pager", "Lcom/urbandroid/sleep/gui/NoSwipeViewPager;", "getPager", "()Lcom/urbandroid/sleep/gui/NoSwipeViewPager;", "setPager", "(Lcom/urbandroid/sleep/gui/NoSwipeViewPager;)V", "Lcom/urbandroid/sleep/PreviewActivity$PreviewListener;", "listener", "Lcom/urbandroid/sleep/PreviewActivity$PreviewListener;", "getListener", "()Lcom/urbandroid/sleep/PreviewActivity$PreviewListener;", InAppPurchaseConstants.METHOD_SET_LISTENER, "(Lcom/urbandroid/sleep/PreviewActivity$PreviewListener;)V", "", "ts", "J", "getTs", "()J", "setTs", "(J)V", "kotlin.jvm.PlatformType", "subClassName", "Ljava/lang/String;", "getSubClassName", "()Ljava/lang/String;", "isLastPage", "PreviewListener", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class PreviewActivity extends BaseActivity {
    private PreviewListener listener;
    public NoSwipeViewPager pager;
    private final Set<String> skippedPages = new LinkedHashSet();
    private long ts = -1;
    private final String subClassName = getClass().getSimpleName();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005À\u0006\u0003"}, d2 = {"Lcom/urbandroid/sleep/PreviewActivity$PreviewListener;", "Ljava/io/Serializable;", "onFinish", "", "onSkip", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public interface PreviewListener extends Serializable {
        void onFinish();

        void onSkip();
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.PreviewActivity$onCreate$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/urbandroid/sleep/PreviewActivity$onCreate$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "onPageScrollStateChanged", ServerProtocol.DIALOG_PARAM_STATE, "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 implements ViewPager.OnPageChangeListener {
        final /* synthetic */ ActivityResultLauncher<String> $requestPermissionLauncher;

        public AnonymousClass1(ActivityResultLauncher<String> activityResultLauncher) {
            this.$requestPermissionLauncher = activityResultLauncher;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageSelected$lambda$0$1(PreviewPage previewPage, ActivityResultLauncher activityResultLauncher, PreviewActivity previewActivity, int i, PrefStore prefStore, View view) {
            Logger.logInfo("Preview: " + previewPage.getId() + " LIKE ");
            if (previewPage.getPermission() != null) {
                String permission = previewPage.getPermission();
                permission.getClass();
                activityResultLauncher.launch(permission);
            } else {
                previewActivity.nextPage(i);
            }
            prefStore.save(previewPage.getId(), 1);
            ((TinderPreviewPage) previewPage).getCallback().like();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageSelected$lambda$0$2(PreviewPage previewPage, PreviewActivity previewActivity, int i, PrefStore prefStore, View view) {
            Logger.logInfo("Preview: " + previewPage.getId() + " DISLIKE ");
            previewActivity.nextPage(i);
            prefStore.save(previewPage.getId(), 0);
            ((TinderPreviewPage) previewPage).getCallback().dislike();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onPageSelected$lambda$0$3(PreviewActivity previewActivity, PreviewPage previewPage, ActivityResultLauncher activityResultLauncher, int i, View view) {
            if (previewActivity.isLastPage()) {
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialFinished(previewActivity.getSubClassName());
                PreviewListener listener = previewActivity.getListener();
                if (listener != null) {
                    listener.onFinish();
                }
                previewActivity.supportFinishAfterTransition();
            } else if (previewPage.getPermission() != null) {
                String permission = previewPage.getPermission();
                permission.getClass();
                activityResultLauncher.launch(permission);
            } else {
                previewActivity.nextPage(i);
            }
            previewPage.action();
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:131:0x0370  */
        /* JADX WARN: Removed duplicated region for block: B:132:0x039a  */
        /* JADX WARN: Removed duplicated region for block: B:135:0x03a7  */
        /* JADX WARN: Removed duplicated region for block: B:136:0x03f1  */
        /* JADX WARN: Removed duplicated region for block: B:139:0x03fc  */
        /* JADX WARN: Removed duplicated region for block: B:153:0x0487  */
        /* JADX WARN: Removed duplicated region for block: B:161:0x04c0  */
        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onPageSelected(int position) {
            PreviewPage previewPage;
            PreviewActivity previewActivity;
            View viewFindViewById = PreviewActivity.this.findViewById(R.id.next);
            if (viewFindViewById != null) {
                viewFindViewById.setVisibility(8);
            }
            View viewFindViewById2 = PreviewActivity.this.findViewById(R.id.tinder_bar);
            if (viewFindViewById2 != null) {
                viewFindViewById2.setVisibility(8);
            }
            if (PreviewActivity.this.canSkip()) {
                Logger.logInfo("Preview: SKIP VISIBLE 1");
                View viewFindViewById3 = PreviewActivity.this.findViewById(R.id.skip);
                if (viewFindViewById3 != null) {
                    viewFindViewById3.setVisibility(0);
                }
            }
            View viewFindViewById4 = PreviewActivity.this.findViewById(R.id.done);
            if (viewFindViewById4 != null) {
                viewFindViewById4.setVisibility(8);
            }
            View viewFindViewById5 = PreviewActivity.this.findViewById(R.id.done);
            viewFindViewById5.getClass();
            ((TextView) viewFindViewById5).setText(R.string.done);
            PreviewPagerAdapter previewPagerAdapter = (PreviewPagerAdapter) PreviewActivity.this.getPager().getAdapter();
            final PreviewPage previewPage2 = previewPagerAdapter != null ? previewPagerAdapter.getPages().get(position) : null;
            PreviewPagerAdapter previewPagerAdapter2 = (PreviewPagerAdapter) PreviewActivity.this.getPager().getAdapter();
            Fragment item = previewPagerAdapter2 != null ? previewPagerAdapter2.getItem(position) : null;
            item.getClass();
            final int currentItem = PreviewActivity.this.getPager().getCurrentItem();
            Logger.logInfo("Preview: '" + (previewPage2 != null ? previewPage2.getId() : null) + "' pageSelected(" + position + ") init NEXT GONE");
            if (previewPage2 != null) {
                final PreviewActivity previewActivity2 = PreviewActivity.this;
                final ActivityResultLauncher<String> activityResultLauncher = this.$requestPermissionLauncher;
                SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialPage("", previewPage2.getId());
                previewActivity2.getWindow().setStatusBarColor(ColorUtil.i(previewActivity2, previewPage2.getBackgroundResource()));
                previewActivity2.getWindow().setNavigationBarColor(ColorUtil.i(previewActivity2, previewPage2.getBottomBackgroundResource()));
                PreviewPagerAdapter previewPagerAdapter3 = (PreviewPagerAdapter) previewActivity2.getPager().getAdapter();
                Fragment item2 = previewPagerAdapter3 != null ? previewPagerAdapter3.getItem(position) : null;
                item2.getClass();
                PreviewPageFragment previewPageFragment = (PreviewPageFragment) item2;
                String permission = previewPage2.getPermission();
                if (permission != null && ContextCompat.checkSelfPermission(previewActivity2, permission) == -1 && !(previewPage2 instanceof TinderPreviewPage) && !previewActivity2.shouldShowRequestPermissionRationale(permission)) {
                    Logger.logInfo("Preview: " + previewPage2.getId() + " permission required");
                    previewPage2.setButtonText(previewActivity2.getString(R.string.no_permission));
                }
                final PrefStore prefStore = new PrefStore(previewActivity2, "onboarding_prefs");
                prefStore.append("page", previewPage2.getId() + ":" + (previewActivity2.getTs() == -1 ? AppEventsConstants.EVENT_PARAM_VALUE_NO : Long.valueOf((System.currentTimeMillis() - previewActivity2.getTs()) / 1000)) + "|");
                boolean z = previewPage2 instanceof TinderPreviewPage;
                if (z) {
                    Logger.logInfo("Preview: tinder NEXT GONE");
                    View viewFindViewById6 = previewActivity2.findViewById(R.id.next);
                    if (viewFindViewById6 != null) {
                        viewFindViewById6.setVisibility(8);
                    }
                    View viewFindViewById7 = previewActivity2.findViewById(R.id.skip);
                    if (viewFindViewById7 != null) {
                        viewFindViewById7.setVisibility(8);
                    }
                    Logger.logInfo("Preview: SKIP GONE 1");
                    View viewFindViewById8 = previewActivity2.findViewById(R.id.tinder_bar);
                    if (viewFindViewById8 != null) {
                        viewFindViewById8.setVisibility(0);
                    }
                    View viewFindViewById9 = previewActivity2.findViewById(R.id.like);
                    if (viewFindViewById9 != null) {
                        viewFindViewById9.setOnClickListener(new View.OnClickListener() { // from class: com.urbandroid.sleep.PreviewActivity$onCreate$1$$ExternalSyntheticLambda0
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                PreviewActivity.AnonymousClass1.onPageSelected$lambda$0$1(previewPage2, activityResultLauncher, previewActivity2, currentItem, prefStore, view);
                            }
                        });
                    }
                    View viewFindViewById10 = previewActivity2.findViewById(R.id.dislike);
                    if (viewFindViewById10 != null) {
                        viewFindViewById10.setOnClickListener(new PreviewActivity$onCreate$1$$ExternalSyntheticLambda1(previewActivity2, prefStore, previewPage2, currentItem));
                    }
                } else {
                    View viewFindViewById11 = previewActivity2.findViewById(R.id.tinder_bar);
                    if (viewFindViewById11 != null) {
                        viewFindViewById11.setVisibility(8);
                    }
                    Logger.logInfo("Preview: page NEXT VISIBLE");
                    View viewFindViewById12 = previewActivity2.findViewById(R.id.next);
                    if (viewFindViewById12 != null) {
                        viewFindViewById12.setVisibility(0);
                    }
                    if (previewActivity2.canSkip()) {
                        Logger.logInfo("Preview: SKIP VISIBLE 2");
                        View viewFindViewById13 = previewActivity2.findViewById(R.id.skip);
                        if (viewFindViewById13 != null) {
                            viewFindViewById13.setVisibility(0);
                        }
                    }
                }
                PreviewPage previewPage3 = previewPage2;
                Logger.logInfo("Preview: auto dislike? " + previewPage2.getId() + " bad " + prefStore.noneChecked("bad") + " good " + prefStore.noneChecked("good") + " " + (!prefStore.checked("good", 0)) + " " + (!prefStore.checked("good", 1)) + " " + (!prefStore.checked("good", 2)) + " " + (!prefStore.checked("good", 3)) + " " + (!prefStore.checked("bad", 0)) + " " + (!prefStore.checked("bad", 1)) + " " + (!prefStore.checked("bad", 2)));
                String id = previewPage3.getId();
                switch (id.hashCode()) {
                    case -1408347418:
                        previewPage = previewPage3;
                        previewActivity = previewActivity2;
                        if (id.equals("asnore") && !prefStore.noneChecked("bad") && !prefStore.checked("bad", 2)) {
                            previewActivity.autoDislike(prefStore, previewPage, currentItem);
                        }
                        if (previewPage.getButtonText() != null) {
                            Logger.logInfo("Preview: DONE text '" + previewPage.getButtonText() + "'");
                            View viewFindViewById14 = previewActivity.findViewById(R.id.done);
                            viewFindViewById14.getClass();
                            ((TextView) viewFindViewById14).setText(previewPage.getButtonText());
                        } else {
                            zza$$ExternalSyntheticOutline0.m("Preview: DONE text is 'Done' ", previewPage.getButtonText());
                        }
                        if (previewPage.getCancelText() != null) {
                            Logger.logInfo("Preview: DONE text '" + previewPage.getButtonText() + "'");
                            View viewFindViewById15 = previewActivity.findViewById(R.id.skip);
                            viewFindViewById15.getClass();
                            ((TextView) viewFindViewById15).setText(previewPage.getCancelText());
                            Logger.logInfo("Preview: SKIP VISIBLE " + previewPage.getCancelText());
                            previewActivity.findViewById(R.id.skip).setVisibility(0);
                        } else {
                            zza$$ExternalSyntheticOutline0.m("Preview: DONE text is 'Done' ", previewPage.getButtonText());
                        }
                        if (z || (!previewActivity.isLastPage() && previewPage.getButtonText() == null)) {
                            Logger.logInfo("Preview: enable scroll ");
                            previewActivity.getPager().setPagingEnabled(true);
                            if ((previewActivity.canSkip() || previewPage.getCancelText() != null) && !z) {
                                Logger.logInfo("Preview: SKIP VISIBLE 3");
                                previewActivity.findViewById(R.id.skip).setVisibility(0);
                            }
                        } else {
                            if (previewPage.getButtonText() == null || Intrinsics.areEqual(previewPage.getButtonText(), PreviewPage.INSTANCE.getNO_BUTTON())) {
                                Logger.logInfo("Preview: enable scroll ");
                                previewActivity.getPager().setPagingEnabled(true);
                            } else {
                                Logger.logInfo("Preview: block scroll ");
                                previewActivity.getPager().setPagingEnabled(false);
                            }
                            Logger.logInfo("Preview: last NEXT GONE " + previewPage.getButtonText());
                            previewActivity.findViewById(R.id.next).setVisibility(8);
                            if (previewPage.getCancelText() == null) {
                                Logger.logInfo("Preview: SKIP GONE no cancel text");
                                previewActivity.findViewById(R.id.skip).setVisibility(8);
                            }
                            previewActivity.findViewById(R.id.done).setVisibility(0);
                            previewActivity.findViewById(R.id.done).setOnClickListener(new PreviewActivity$onCreate$1$$ExternalSyntheticLambda1(previewActivity, previewPage, activityResultLauncher, currentItem));
                        }
                        if (Intrinsics.areEqual(PreviewPage.INSTANCE.getNO_BUTTON(), previewPage.getButtonText())) {
                            Logger.logInfo("Preview: NO_BUTTON NEXT GONE");
                            previewActivity.findViewById(R.id.next).setVisibility(8);
                            previewActivity.findViewById(R.id.done).setVisibility(8);
                        }
                        ((BaseActivity) previewActivity).h.postDelayed(new PreviewActivity$$ExternalSyntheticLambda1(previewPageFragment, 2), 1000L);
                        break;
                    case -231495986:
                        previewPage = previewPage3;
                        previewActivity = previewActivity2;
                        if (id.equals("bedtime") && !prefStore.noneChecked("bad") && !prefStore.checked("bad", 0)) {
                            previewActivity.autoDislike(prefStore, previewPage, currentItem);
                        }
                        if (previewPage.getButtonText() != null) {
                        }
                        if (previewPage.getCancelText() != null) {
                        }
                        if (z) {
                            Logger.logInfo("Preview: enable scroll ");
                            previewActivity.getPager().setPagingEnabled(true);
                            if (previewActivity.canSkip()) {
                                Logger.logInfo("Preview: SKIP VISIBLE 3");
                                previewActivity.findViewById(R.id.skip).setVisibility(0);
                            } else {
                                Logger.logInfo("Preview: SKIP VISIBLE 3");
                                previewActivity.findViewById(R.id.skip).setVisibility(0);
                            }
                        }
                        if (Intrinsics.areEqual(PreviewPage.INSTANCE.getNO_BUTTON(), previewPage.getButtonText())) {
                        }
                        ((BaseActivity) previewActivity).h.postDelayed(new PreviewActivity$$ExternalSyntheticLambda1(previewPageFragment, 2), 1000L);
                        break;
                    case 109846679:
                        previewPage = previewPage3;
                        previewActivity = previewActivity2;
                        if (id.equals("swake") && !prefStore.noneChecked("good") && !prefStore.checked("good", 2)) {
                            previewActivity.autoDislike(prefStore, previewPage, currentItem);
                        }
                        if (previewPage.getButtonText() != null) {
                        }
                        if (previewPage.getCancelText() != null) {
                        }
                        if (z) {
                        }
                        if (Intrinsics.areEqual(PreviewPage.INSTANCE.getNO_BUTTON(), previewPage.getButtonText())) {
                        }
                        ((BaseActivity) previewActivity).h.postDelayed(new PreviewActivity$$ExternalSyntheticLambda1(previewPageFragment, 2), 1000L);
                        break;
                    case 518814479:
                        previewPage = previewPage3;
                        previewActivity = previewActivity2;
                        if (id.equals("lullaby") && !prefStore.noneChecked("bad") && !prefStore.checked("bad", 0) && !prefStore.noneChecked("good") && !prefStore.checked("good", 0)) {
                            previewActivity.autoDislike(prefStore, previewPage, currentItem);
                        }
                        if (previewPage.getButtonText() != null) {
                        }
                        if (previewPage.getCancelText() != null) {
                        }
                        if (z) {
                        }
                        if (Intrinsics.areEqual(PreviewPage.INSTANCE.getNO_BUTTON(), previewPage.getButtonText())) {
                        }
                        ((BaseActivity) previewActivity).h.postDelayed(new PreviewActivity$$ExternalSyntheticLambda1(previewPageFragment, 2), 1000L);
                        break;
                    case 552567418:
                        if (id.equals("captcha") && !prefStore.noneChecked("bad") && !prefStore.checked("bad", 1) && prefStore.noneChecked("good") && !prefStore.checked("good", 4)) {
                            previewActivity2.autoDislike(prefStore, previewPage3, currentItem);
                            break;
                        }
                    default:
                        previewPage = previewPage3;
                        previewActivity = previewActivity2;
                        if (previewPage.getButtonText() != null) {
                        }
                        if (previewPage.getCancelText() != null) {
                        }
                        if (z) {
                        }
                        if (Intrinsics.areEqual(PreviewPage.INSTANCE.getNO_BUTTON(), previewPage.getButtonText())) {
                        }
                        ((BaseActivity) previewActivity).h.postDelayed(new PreviewActivity$$ExternalSyntheticLambda1(previewPageFragment, 2), 1000L);
                        break;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void autoDislike(PrefStore prefs, PreviewPage page, int currentPage) {
        if (this.skippedPages.contains(page.getId())) {
            Logger.logInfo("Preview: " + page.getId() + " AUTO DISLIKE do nothing");
            return;
        }
        Logger.logInfo("Preview: " + page.getId() + " AUTO DISLIKE ");
        nextPage(currentPage);
        if (page instanceof TinderPreviewPage) {
            prefs.save(page.getId(), 0);
            ((TinderPreviewPage) page).getCallback().dislike();
        }
        this.skippedPages.add(page.getId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isLastPage() {
        NoSwipeViewPager pager = getPager();
        pager.getClass();
        int currentItem = pager.getCurrentItem();
        NoSwipeViewPager pager2 = getPager();
        pager2.getClass();
        PagerAdapter adapter = pager2.getAdapter();
        adapter.getClass();
        return currentItem >= adapter.getCount() - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void nextPage(int currentPage) {
        PagerAdapter adapter = getPager().getAdapter();
        adapter.getClass();
        int i = currentPage + 1;
        PreviewPage previewPage = ((PreviewPagerAdapter) adapter).getPages().get(i);
        Logger.logInfo("Preview: nextPage() current:" + currentPage + " ");
        if (previewPage != PreviewPage.INSTANCE.getLAST_PAGE()) {
            getPager().setCurrentItem(i, true);
            return;
        }
        PreviewListener previewListener = this.listener;
        if (previewListener != null) {
            previewListener.onFinish();
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(PreviewActivity previewActivity, boolean z) {
        previewActivity.nextPage(previewActivity.getPager().getCurrentItem());
        if (z) {
            previewActivity.log("Preview: permission granted");
        } else {
            previewActivity.log("Preview: permission denied");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(PreviewActivity previewActivity) {
        previewActivity.getPager().setCurrentItem(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(PreviewActivity previewActivity, Bundle bundle) {
        previewActivity.getPager().setCurrentItem(bundle.getInt("page", 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(PreviewActivity previewActivity, View view) {
        if (previewActivity.isLastPage()) {
            previewActivity.finish();
        } else {
            previewActivity.nextPage(previewActivity.getPager().getCurrentItem());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$4(PreviewActivity previewActivity, View view) {
        if (previewActivity.isLastPage()) {
            previewActivity.finish();
        } else {
            previewActivity.nextPage(previewActivity.getPager().getCurrentItem());
        }
    }

    public boolean canSkip() {
        return true;
    }

    public abstract int getLayoutRes();

    public final PreviewListener getListener() {
        return this.listener;
    }

    public final NoSwipeViewPager getPager() {
        NoSwipeViewPager noSwipeViewPager = this.pager;
        if (noSwipeViewPager != null) {
            return noSwipeViewPager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pager");
        return null;
    }

    public final String getSubClassName() {
        return this.subClassName;
    }

    public final long getTs() {
        return this.ts;
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.ts == -1) {
            this.ts = System.currentTimeMillis();
        }
        setContentView(getLayoutRes());
        GlobalInitializator.initializeIfRequired(getApplicationContext());
        View viewFindViewById = findViewById(R.id.viewpager);
        viewFindViewById.getClass();
        setPager((NoSwipeViewPager) viewFindViewById);
        final int i = 0;
        getPager().setOffscreenPageLimit(0);
        EdgeToEdgeUtil.Companion companion = EdgeToEdgeUtil.INSTANCE;
        EdgeToEdgeUtil.Companion.insetsBottom$default(companion, findViewById(R.id.control_bar), 0, false, 6, null);
        EdgeToEdgeUtil.Companion.insetsBottom$default(companion, findViewById(R.id.tinder_bar), 0, false, 6, null);
        ActivityResultLauncher activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new ActivityResultCallback() { // from class: com.urbandroid.sleep.PreviewActivity$$ExternalSyntheticLambda0
            @Override // androidx.view.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                PreviewActivity.onCreate$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        NoSwipeViewPager pager = getPager();
        if (pager != null) {
            pager.addOnPageChangeListener(new AnonymousClass1(activityResultLauncherRegisterForActivityResult));
        }
        PagerAdapter adapter = getPager().getAdapter();
        adapter.getClass();
        PreviewPage previewPage = ((PreviewPagerAdapter) adapter).getPages().get(0);
        getWindow().setStatusBarColor(ColorUtil.i(this, previewPage.getBackgroundResource()));
        getWindow().setNavigationBarColor(ColorUtil.i(this, previewPage.getBottomBackgroundResource()));
        Handler handler = new Handler();
        if (savedInstanceState == null) {
            handler.post(new PreviewActivity$$ExternalSyntheticLambda1(this, i));
        } else {
            handler.post(new FacebookSdk$$ExternalSyntheticLambda9(this, savedInstanceState, 26));
            this.ts = savedInstanceState.getLong("ts");
        }
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.PreviewActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ PreviewActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                PreviewActivity previewActivity = this.f$0;
                switch (i2) {
                    case 0:
                        PreviewActivity.onCreate$lambda$3(previewActivity, view);
                        break;
                    case 1:
                        PreviewActivity.onCreate$lambda$4(previewActivity, view);
                        break;
                    default:
                        previewActivity.skip();
                        break;
                }
            }
        });
        final int i2 = 1;
        findViewById(R.id.skip).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.PreviewActivity$$ExternalSyntheticLambda3
            public final /* synthetic */ PreviewActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                PreviewActivity previewActivity = this.f$0;
                switch (i22) {
                    case 0:
                        PreviewActivity.onCreate$lambda$3(previewActivity, view);
                        break;
                    case 1:
                        PreviewActivity.onCreate$lambda$4(previewActivity, view);
                        break;
                    default:
                        previewActivity.skip();
                        break;
                }
            }
        });
        if (canSkip()) {
            findViewById(R.id.skip).setVisibility(0);
            final int i3 = 2;
            findViewById(R.id.skip).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.PreviewActivity$$ExternalSyntheticLambda3
                public final /* synthetic */ PreviewActivity f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    int i22 = i3;
                    PreviewActivity previewActivity = this.f$0;
                    switch (i22) {
                        case 0:
                            PreviewActivity.onCreate$lambda$3(previewActivity, view);
                            break;
                        case 1:
                            PreviewActivity.onCreate$lambda$4(previewActivity, view);
                            break;
                        default:
                            previewActivity.skip();
                            break;
                    }
                }
            });
        } else {
            findViewById(R.id.skip).setVisibility(8);
        }
        if (this instanceof FirstUsePreviewActivity) {
            return;
        }
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback() { // from class: com.urbandroid.sleep.PreviewActivity$onCreate$callback$1
            {
                super(true);
            }

            @Override // androidx.view.OnBackPressedCallback
            public void handleOnBackPressed() {
                int currentItem = this.this$0.getPager().getCurrentItem();
                this.this$0.getPager().getAdapter().getClass();
                if (currentItem != r1.getCount() - 1) {
                    SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialSkipped(this.this$0.getSubClassName(), this.this$0.getPager().getCurrentItem());
                } else {
                    SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialFinished(this.this$0.getSubClassName());
                }
                setEnabled(false);
                this.this$0.getOnBackPressedDispatcher().onBackPressed();
            }
        });
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        NoSwipeViewPager pager = getPager();
        if (pager != null) {
            outState.putInt("page", pager.getCurrentItem());
        }
        outState.putLong("ts", this.ts);
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
    }

    @Override // com.urbandroid.common.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
    }

    public final void setListener(PreviewListener previewListener) {
        this.listener = previewListener;
    }

    public final void setPager(NoSwipeViewPager noSwipeViewPager) {
        noSwipeViewPager.getClass();
        this.pager = noSwipeViewPager;
    }

    public void skip() {
        int currentItem = getPager().getCurrentItem();
        getPager().getAdapter().getClass();
        if (currentItem != r1.getCount() - 1) {
            NoSwipeViewPager pager = getPager();
            Logger.logDebug("Skipped tutorial " + this.subClassName + " " + pager.getCurrentItem());
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialSkipped(this.subClassName, pager.getCurrentItem());
        } else {
            SharedApplicationContext.getInstance().getFirebaseAnalyticsManager().setEventTutorialFinished(this.subClassName);
        }
        PreviewListener previewListener = this.listener;
        if (previewListener != null) {
            previewListener.getClass();
            previewListener.onSkip();
        }
        supportFinishAfterTransition();
    }
}
