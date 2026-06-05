package com.urbandroid.sleep.fragment.dashboard.share;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.LruCache;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.urbandroid.common.util.ColorUtil;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.DashboardAdapter;
import com.urbandroid.sleep.fragment.dashboard.card.DashboardCard;
import io.ktor.client.HttpClientConfig$$ExternalSyntheticLambda4;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001d\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0016\u001a\u00020\u001b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\u0006\u0010!\u001a\u00020\u0005H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007R'\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/urbandroid/sleep/fragment/dashboard/share/BitmapComposer;", "", "<init>", "()V", "maxMemory", "", "getMaxMemory", "()I", "maxMemory$delegate", "Lkotlin/Lazy;", "cacheSize", "getCacheSize", "cacheSize$delegate", "bitmapCache", "Landroid/util/LruCache;", "Landroid/graphics/Bitmap;", "getBitmapCache", "()Landroid/util/LruCache;", "bitmapCache$delegate", "cacheIndex", "bigHeight", "getViewAsBitmap", ViewHierarchyConstants.VIEW_KEY, "Landroid/view/View;", "drawBigBitmap", "addRecyclerViewToBitmapCache", "", "Landroidx/recyclerview/widget/RecyclerView;", "addViewToBitmapCache", "getItemView", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "i", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class BitmapComposer {
    private int bigHeight;

    /* JADX INFO: renamed from: bitmapCache$delegate, reason: from kotlin metadata */
    private final Lazy bitmapCache;
    private int cacheIndex;

    /* JADX INFO: renamed from: cacheSize$delegate, reason: from kotlin metadata */
    private final Lazy cacheSize;

    /* JADX INFO: renamed from: maxMemory$delegate, reason: from kotlin metadata */
    private final Lazy maxMemory = LazyKt.lazy(new HttpClientConfig$$ExternalSyntheticLambda4(1));

    public BitmapComposer() {
        final int i = 0;
        this.cacheSize = LazyKt.lazy(new Function0(this) { // from class: com.urbandroid.sleep.fragment.dashboard.share.BitmapComposer$$ExternalSyntheticLambda1
            public final /* synthetic */ BitmapComposer f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                BitmapComposer bitmapComposer = this.f$0;
                switch (i2) {
                    case 0:
                        return Integer.valueOf(BitmapComposer.cacheSize_delegate$lambda$0(bitmapComposer));
                    default:
                        return BitmapComposer.bitmapCache_delegate$lambda$0(bitmapComposer);
                }
            }
        });
        final int i2 = 1;
        this.bitmapCache = LazyKt.lazy(new Function0(this) { // from class: com.urbandroid.sleep.fragment.dashboard.share.BitmapComposer$$ExternalSyntheticLambda1
            public final /* synthetic */ BitmapComposer f$0;

            {
                this.f$0 = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                BitmapComposer bitmapComposer = this.f$0;
                switch (i22) {
                    case 0:
                        return Integer.valueOf(BitmapComposer.cacheSize_delegate$lambda$0(bitmapComposer));
                    default:
                        return BitmapComposer.bitmapCache_delegate$lambda$0(bitmapComposer);
                }
            }
        });
    }

    private final void addRecyclerViewToBitmapCache(RecyclerView view) throws Exception {
        RecyclerView.Adapter adapter = view.getAdapter();
        if (adapter == null) {
            throw new Exception("No adapter found");
        }
        int itemCount = adapter.getItemCount();
        for (int i = 0; i < itemCount; i++) {
            View itemView = getItemView(view, adapter, i);
            if (itemView != null) {
                addViewToBitmapCache(itemView);
            }
        }
    }

    private final void addViewToBitmapCache(View view) {
        if (view instanceof RecyclerView) {
            addRecyclerViewToBitmapCache((RecyclerView) view);
            return;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
        bitmapCreateBitmap.getClass();
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(ColorUtil.i(view.getContext(), R.color.bg_main));
        view.draw(canvas);
        LruCache<Integer, Bitmap> bitmapCache = getBitmapCache();
        int i = this.cacheIndex;
        this.cacheIndex = i + 1;
        bitmapCache.put(Integer.valueOf(i), bitmapCreateBitmap);
        this.bigHeight = view.getMeasuredHeight() + this.bigHeight;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LruCache bitmapCache_delegate$lambda$0(BitmapComposer bitmapComposer) {
        return new LruCache(bitmapComposer.getCacheSize());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int cacheSize_delegate$lambda$0(BitmapComposer bitmapComposer) {
        return bitmapComposer.getMaxMemory() / 7;
    }

    private final Bitmap drawBigBitmap(View view) {
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getMeasuredWidth(), this.bigHeight, Bitmap.Config.ARGB_8888);
        bitmapCreateBitmap.getClass();
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        canvas.drawColor(-1);
        Paint paint = new Paint();
        int size = getBitmapCache().size();
        int height = 0;
        for (int i = 0; i < size; i++) {
            Bitmap bitmap = getBitmapCache().get(Integer.valueOf(i));
            bitmap.getClass();
            Bitmap bitmap2 = bitmap;
            canvas.drawBitmap(bitmap2, 0.0f, height, paint);
            height += bitmap2.getHeight();
            bitmap2.recycle();
        }
        return bitmapCreateBitmap;
    }

    private final LruCache<Integer, Bitmap> getBitmapCache() {
        return (LruCache) this.bitmapCache.getValue();
    }

    private final int getCacheSize() {
        return ((Number) this.cacheSize.getValue()).intValue();
    }

    private final View getItemView(RecyclerView view, RecyclerView.Adapter<RecyclerView.ViewHolder> adapter, int i) {
        adapter.getClass();
        DashboardAdapter dashboardAdapter = (DashboardAdapter) adapter;
        DashboardCard<?> dashboardCard = dashboardAdapter.getCards().get(i);
        if (!dashboardCard.isScreenReady()) {
            return null;
        }
        dashboardCard.setScreenshot(true);
        RecyclerView.ViewHolder viewHolderCreateViewHolder = dashboardAdapter.createViewHolder(view, dashboardAdapter.getItemViewType(i));
        dashboardAdapter.onBindViewHolder(viewHolderCreateViewHolder, i);
        viewHolderCreateViewHolder.itemView.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        View view2 = viewHolderCreateViewHolder.itemView;
        view2.layout(0, 0, view2.getMeasuredWidth(), viewHolderCreateViewHolder.itemView.getMeasuredHeight());
        dashboardCard.setScreenshot(false);
        return viewHolderCreateViewHolder.itemView;
    }

    private final int getMaxMemory() {
        return ((Number) this.maxMemory.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int maxMemory_delegate$lambda$0() {
        return (int) (Runtime.getRuntime().maxMemory() / 1024);
    }

    public final Bitmap getViewAsBitmap(View view) throws Exception {
        view.getClass();
        if (view instanceof LinearLayoutCompat) {
            Iterator<View> it = ViewGroupKt.getChildren((ViewGroup) view).iterator();
            while (it.hasNext()) {
                addViewToBitmapCache(it.next());
            }
        } else if (view instanceof RecyclerView) {
            addRecyclerViewToBitmapCache((RecyclerView) view);
        }
        return drawBigBitmap(view);
    }
}
