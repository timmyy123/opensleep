package com.urbandroid.sleep.media.lullaby;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.tabs.TabLayout;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.gui.KeyguardUtil;
import com.urbandroid.sleep.media.MediaListActivity;
import com.urbandroid.sleep.media.lullaby.LullabyFragment;
import com.urbandroid.sleep.media.lullaby.LullabyItem;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0019B\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyCategoriesItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "Lcom/urbandroid/sleep/media/lullaby/LullabyCategoriesItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "", "selected", "Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "adapter", "<init>", "(Landroid/content/Context;ILcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/media/lullaby/LullabyCategoriesItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/media/lullaby/LullabyCategoriesItem$ViewHolder;)V", "I", "getSelected", "()I", "Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "getAdapter", "()Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyCategoriesItem extends LullabyItem<ViewHolder> {
    private final LullabyRecyclerViewAdapter adapter;
    private final int selected;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyCategoriesItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Lcom/google/android/material/tabs/TabLayout;", "categories", "Lcom/google/android/material/tabs/TabLayout;", "getCategories", "()Lcom/google/android/material/tabs/TabLayout;", "setCategories", "(Lcom/google/android/material/tabs/TabLayout;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private TabLayout categories;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.categories);
            viewFindViewById.getClass();
            this.categories = (TabLayout) viewFindViewById;
        }

        public final TabLayout getCategories() {
            return this.categories;
        }
    }

    /* JADX INFO: renamed from: com.urbandroid.sleep.media.lullaby.LullabyCategoriesItem$createViewHolder$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/urbandroid/sleep/media/lullaby/LullabyCategoriesItem$createViewHolder$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabSelected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabUnselected", "onTabReselected", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class AnonymousClass1 implements TabLayout.OnTabSelectedListener {
        final /* synthetic */ ViewHolder $viewHolder;
        final /* synthetic */ LullabyCategoriesItem this$0;

        public AnonymousClass1(ViewHolder viewHolder, LullabyCategoriesItem lullabyCategoriesItem) {
            this.$viewHolder = viewHolder;
            this.this$0 = lullabyCategoriesItem;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void onTabSelected$lambda$0(LullabyCategoriesItem lullabyCategoriesItem) {
            lullabyCategoriesItem.getAdapter().notifyDataSetChanged();
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabReselected(TabLayout.Tab tab) {
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabSelected(TabLayout.Tab tab) {
            int selectedTabPosition = this.$viewHolder.getCategories().getSelectedTabPosition();
            if (selectedTabPosition == 0) {
                Logger.logInfo("Lullaby: click NATURE");
                this.this$0.getAdapter().changeSection(LullabyFragment.Section.LULLABY);
                return;
            }
            if (selectedTabPosition != 1) {
                if (selectedTabPosition != 2) {
                    return;
                }
                Logger.logInfo("Lullaby: click RADIO");
                this.this$0.getAdapter().changeSection(LullabyFragment.Section.RADIO);
                return;
            }
            Logger.logInfo("Lullaby: click SPOTIFY");
            this.this$0.getAdapter().changeSection(LullabyFragment.Section.SPOTIFY);
            if ((this.this$0.getContext() instanceof Activity) && SharedApplicationContext.getSettings().isSpotify() && !KeyguardUtil.isKeyguard(this.this$0.getContext())) {
                MediaListActivity.loadSpotifyAlbums((Activity) this.this$0.getContext(), new LullabyAddRadioItem$$ExternalSyntheticLambda0(this.this$0));
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LullabyCategoriesItem(Context context, int i, LullabyRecyclerViewAdapter lullabyRecyclerViewAdapter) {
        super(context, R.layout.fragment_lullaby_item_categories, LullabyItem.Type.CATEGORIES);
        context.getClass();
        lullabyRecyclerViewAdapter.getClass();
        this.selected = i;
        this.adapter = lullabyRecyclerViewAdapter;
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
    }

    @Override // com.urbandroid.sleep.media.lullaby.LullabyItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        Logger.logInfo("Lullaby: adding listener " + this.selected);
        ViewHolder viewHolder = new ViewHolder(v);
        TabLayout categories = viewHolder.getCategories();
        int i = this.selected;
        viewHolder.getCategories().selectTab(categories.getTabAt(i == R.id.categoryNature ? 0 : i == R.id.categorySpotify ? 1 : 2));
        viewHolder.getCategories().addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new AnonymousClass1(viewHolder, this));
        return viewHolder;
    }

    public final LullabyRecyclerViewAdapter getAdapter() {
        return this.adapter;
    }
}
