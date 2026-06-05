package com.urbandroid.sleep.alarmclock.settings;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.alarmclock.GlobalInitializator;
import com.urbandroid.sleep.fragment.preview.PreviewPage;
import com.urbandroid.sleep.fragment.preview.PreviewPagerAdapter;
import com.urbandroid.sleep.gui.SystemBarTintManager;
import com.urbandroid.util.ColorUtil;
import com.urbandroid.util.EdgeToEdgeUtil;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004H\u0082\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0014¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\f\u0010\u0003J\u000f\u0010\r\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\r\u0010\u0003J\u000f\u0010\u000e\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u000e\u0010\u0003J)\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\"\u001a\u00020\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/alarmclock/settings/NoEscapeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "", "next", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", "(Landroid/os/Bundle;)V", "savedInstanceState", "onCreate", "onStart", "onResume", "onDestroy", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroidx/viewpager/widget/ViewPager;", "pager", "Landroidx/viewpager/widget/ViewPager;", "Lcom/urbandroid/sleep/alarmclock/settings/NoEscapeManager;", "manager", "Lcom/urbandroid/sleep/alarmclock/settings/NoEscapeManager;", "", "isLastPage", "()Z", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "getCurrentPage", "()Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "currentPage", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NoEscapeActivity extends AppCompatActivity {
    private NoEscapeManager manager;
    private ViewPager pager;

    public static final /* synthetic */ SystemBarTintManager access$getTintManager$p(NoEscapeActivity noEscapeActivity) {
        noEscapeActivity.getClass();
        return null;
    }

    private final PreviewPage getCurrentPage() {
        ViewPager viewPager = this.pager;
        viewPager.getClass();
        PreviewPagerAdapter previewPagerAdapter = (PreviewPagerAdapter) viewPager.getAdapter();
        previewPagerAdapter.getClass();
        List<PreviewPage> pages = previewPagerAdapter.getPages();
        ViewPager viewPager2 = this.pager;
        viewPager2.getClass();
        return pages.get(viewPager2.getCurrentItem());
    }

    private final boolean isLastPage() {
        ViewPager viewPager = this.pager;
        viewPager.getClass();
        PagerAdapter adapter = viewPager.getAdapter();
        adapter.getClass();
        int count = adapter.getCount();
        ViewPager viewPager2 = this.pager;
        viewPager2.getClass();
        return count == viewPager2.getCurrentItem() + 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void next() {
        if (isLastPage()) {
            setResult(-1);
            finish();
            return;
        }
        ViewPager viewPager = this.pager;
        viewPager.getClass();
        ViewPager viewPager2 = this.pager;
        viewPager2.getClass();
        viewPager.setCurrentItem(viewPager2.getCurrentItem() + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(NoEscapeActivity noEscapeActivity, int i) {
        ViewPager viewPager = noEscapeActivity.pager;
        if (viewPager != null) {
            viewPager.setCurrentItem(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(NoEscapeActivity noEscapeActivity, View view) {
        PreviewPage currentPage = noEscapeActivity.getCurrentPage();
        if (currentPage != null) {
            currentPage.action();
            noEscapeActivity.next();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$lambda$0(NoEscapeActivity noEscapeActivity) {
        View viewFindViewById = noEscapeActivity.findViewById(R.id.image);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility(0);
            viewFindViewById.startAnimation(AnimationUtils.loadAnimation(noEscapeActivity.getApplicationContext(), R.anim.unfade));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data2) {
        super.onActivityResult(requestCode, resultCode, data2);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GlobalInitializator.initializeIfRequired(this);
        setContentView(R.layout.activity_noescape);
        findViewById(R.id.next).setVisibility(8);
        final int i = 0;
        findViewById(R.id.agree).setVisibility(0);
        findViewById(R.id.skip).setVisibility(0);
        EdgeToEdgeUtil.Companion companion = EdgeToEdgeUtil.INSTANCE;
        EdgeToEdgeUtil.Companion.insetsBottom$default(companion, findViewById(R.id.next), 0, false, 6, null);
        EdgeToEdgeUtil.Companion.insetsBottom$default(companion, findViewById(R.id.skip), 0, false, 6, null);
        EdgeToEdgeUtil.Companion.insetsBottom$default(companion, findViewById(R.id.agree), 0, false, 6, null);
        EdgeToEdgeUtil.Companion.insetsBottom$default(companion, findViewById(R.id.indicator), 0, false, 6, null);
        this.manager = new NoEscapeManager(this);
        View viewFindViewById = findViewById(R.id.viewpager);
        viewFindViewById.getClass();
        ViewPager viewPager = (ViewPager) viewFindViewById;
        this.pager = viewPager;
        viewPager.setOffscreenPageLimit(0);
        ViewPager viewPager2 = this.pager;
        PreviewPagerAdapter previewPagerAdapter = (PreviewPagerAdapter) (viewPager2 != null ? viewPager2.getAdapter() : null);
        previewPagerAdapter.getClass();
        List<PreviewPage> pages = previewPagerAdapter.getPages();
        if (pages == null || pages.isEmpty()) {
            finish();
            return;
        }
        ViewPager viewPager3 = this.pager;
        PreviewPagerAdapter previewPagerAdapter2 = (PreviewPagerAdapter) (viewPager3 != null ? viewPager3.getAdapter() : null);
        previewPagerAdapter2.getClass();
        PreviewPage previewPage = previewPagerAdapter2.getPages().get(0);
        getWindow().setStatusBarColor(ColorUtil.i(this, previewPage.getBackgroundResource()));
        getWindow().setNavigationBarColor(ColorUtil.i(this, previewPage.getBottomBackgroundResource()));
        final int i2 = 1;
        new Handler().post(new NoEscapeActivity$$ExternalSyntheticLambda0(this, i2));
        ViewPager viewPager4 = this.pager;
        if (viewPager4 != null) {
            viewPager4.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.urbandroid.sleep.alarmclock.settings.NoEscapeActivity.onCreate.2
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int state) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int position) {
                    NoEscapeActivity.access$getTintManager$p(NoEscapeActivity.this);
                    ViewPager viewPager5 = NoEscapeActivity.this.pager;
                    PreviewPagerAdapter previewPagerAdapter3 = (PreviewPagerAdapter) (viewPager5 != null ? viewPager5.getAdapter() : null);
                    previewPagerAdapter3.getClass();
                    PreviewPage previewPage2 = previewPagerAdapter3.getPages().get(position);
                    NoEscapeActivity.this.getWindow().setStatusBarColor(ColorUtil.i(NoEscapeActivity.this, previewPage2.getBackgroundResource()));
                    NoEscapeActivity.this.getWindow().setNavigationBarColor(ColorUtil.i(NoEscapeActivity.this, previewPage2.getBottomBackgroundResource()));
                }
            });
        }
        findViewById(R.id.next).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.NoEscapeActivity$$ExternalSyntheticLambda2
            public final /* synthetic */ NoEscapeActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i;
                NoEscapeActivity noEscapeActivity = this.f$0;
                switch (i3) {
                    case 0:
                        noEscapeActivity.next();
                        break;
                    case 1:
                        NoEscapeActivity.onCreate$lambda$2(noEscapeActivity, view);
                        break;
                    default:
                        noEscapeActivity.next();
                        break;
                }
            }
        });
        findViewById(R.id.agree).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.NoEscapeActivity$$ExternalSyntheticLambda2
            public final /* synthetic */ NoEscapeActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i3 = i2;
                NoEscapeActivity noEscapeActivity = this.f$0;
                switch (i3) {
                    case 0:
                        noEscapeActivity.next();
                        break;
                    case 1:
                        NoEscapeActivity.onCreate$lambda$2(noEscapeActivity, view);
                        break;
                    default:
                        noEscapeActivity.next();
                        break;
                }
            }
        });
        final int i3 = 2;
        findViewById(R.id.skip).setOnClickListener(new View.OnClickListener(this) { // from class: com.urbandroid.sleep.alarmclock.settings.NoEscapeActivity$$ExternalSyntheticLambda2
            public final /* synthetic */ NoEscapeActivity f$0;

            {
                this.f$0 = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i32 = i3;
                NoEscapeActivity noEscapeActivity = this.f$0;
                switch (i32) {
                    case 0:
                        noEscapeActivity.next();
                        break;
                    case 1:
                        NoEscapeActivity.onCreate$lambda$2(noEscapeActivity, view);
                        break;
                    default:
                        noEscapeActivity.next();
                        break;
                }
            }
        });
        new Handler();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ViewPager viewPager = this.pager;
        viewPager.getClass();
        if (viewPager.getAdapter() != null) {
            ViewPager viewPager2 = this.pager;
            viewPager2.getClass();
            PagerAdapter adapter = viewPager2.getAdapter();
            adapter.getClass();
            if (adapter.getCount() == 0) {
                finish();
            }
        }
    }

    @Override // androidx.view.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        outState.getClass();
        super.onSaveInstanceState(outState);
        ViewPager viewPager = this.pager;
        viewPager.getClass();
        outState.putInt("page", viewPager.getCurrentItem());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        new Handler().postDelayed(new NoEscapeActivity$$ExternalSyntheticLambda0(this, 0), 500L);
    }
}
