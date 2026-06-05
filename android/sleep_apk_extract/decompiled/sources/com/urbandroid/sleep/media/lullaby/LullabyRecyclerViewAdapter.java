package com.urbandroid.sleep.media.lullaby;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.home.Home$$ExternalSyntheticBUOutline0;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.media.OnlineRadioRingtones;
import com.urbandroid.sleep.media.lullaby.LullabyFragment;
import com.urbandroid.sleep.media.lullaby.LullabyPlayer;
import com.urbandroid.sleep.media.spotify.SpotifyServiceExecutor;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.util.ResourceUtil;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010\u0014R!\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030$0#8\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u0017\u0010*\u001a\u00020)8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-¨\u0006."}, d2 = {"Lcom/urbandroid/sleep/media/lullaby/LullabyRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "<init>", "(Landroid/app/Activity;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "getItemViewType", "(I)I", "Lcom/urbandroid/sleep/media/lullaby/LullabyFragment$Section;", "section", "", "changeSection", "(Lcom/urbandroid/sleep/media/lullaby/LullabyFragment$Section;)V", "loadSection", "()V", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemCount", "()I", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "Lcom/urbandroid/sleep/media/lullaby/LullabyFragment$Section;", "getSection", "()Lcom/urbandroid/sleep/media/lullaby/LullabyFragment$Section;", "setSection", "", "Lcom/urbandroid/sleep/media/lullaby/LullabyItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class LullabyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Activity context;
    private final Handler handler;
    private final List<LullabyItem<?>> items;
    private LullabyFragment.Section section;

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LullabyFragment.Section.values().length];
            try {
                iArr[LullabyFragment.Section.LULLABY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LullabyFragment.Section.SPOTIFY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LullabyFragment.Section.RADIO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LullabyRecyclerViewAdapter(Activity activity) {
        activity.getClass();
        this.context = activity;
        this.section = LullabyFragment.Section.LULLABY;
        this.items = new ArrayList();
        this.handler = new Handler();
    }

    public final void changeSection(LullabyFragment.Section section) {
        section.getClass();
        this.section = section;
        loadSection();
        this.handler.post(new LullabySpotifyItem$$ExternalSyntheticLambda1(this, 1));
    }

    public final Activity getContext() {
        return this.context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getType().ordinal();
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.urbandroid.sleep.media.lullaby.LullabyRecyclerViewAdapter$loadSection$$inlined$sortBy$1] */
    public final void loadSection() throws CloneNotSupportedException {
        this.items.clear();
        Settings settings = new Settings(this.context);
        Logger.logInfo("Lullaby: load section " + this.section);
        int i = WhenMappings.$EnumSwitchMapping$0[this.section.ordinal()];
        int i2 = 0;
        if (i != 1) {
            String str = "";
            if (i == 2) {
                this.items.add(new LullabyCategoriesItem(this.context, R.id.categorySpotify, this));
                boolean zIsSpotify = TrialFilter.getInstance().isSpotify();
                List<LullabyItem<?>> list = this.items;
                Activity activity = this.context;
                if (!zIsSpotify) {
                    list.add(new LullabySpotifyConnectItem(activity));
                    return;
                }
                String string = activity.getString(R.string.spotify_current_playlist);
                string.getClass();
                list.add(new LullabySpotifyItem(activity, string, "spotify-play-last-song", null, null, null, 32, null));
                List<SpotifyServiceExecutor.SpotifyUri> spotifyAlbums = new Settings(this.context).getSpotifyAlbums();
                zza$$ExternalSyntheticOutline0.m(spotifyAlbums.size(), "Lullaby: spotify albums ");
                for (Object obj : spotifyAlbums) {
                    int i3 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SpotifyServiceExecutor.SpotifyUri spotifyUri = (SpotifyServiceExecutor.SpotifyUri) obj;
                    this.items.add(new LullabySpotifyItem(this.context, spotifyUri.getTitle(), spotifyUri.getUri(), spotifyUri.getArtistString(), spotifyUri.getImg(), Integer.valueOf(ResourceUtil.getResourceByName(this.context, "color", "t" + (i2 % 7) + (i2 % 2 == 0 ? "a" : "")))));
                    i2 = i3;
                }
                if (spotifyAlbums.size() == 0) {
                    this.items.add(new LullabySpotifyConnectItem(this.context));
                    return;
                }
                return;
            }
            if (i != 3) {
                Home$$ExternalSyntheticBUOutline0.m();
                return;
            }
            this.items.add(new LullabyCategoriesItem(this.context, R.id.categoryRadio, this));
            this.items.add(new LullabyAddRadioItem(this.context, this));
            ArrayList arrayList = new ArrayList();
            List<OnlineRadioRingtones.Radio> onlineRadios = settings.getOnlineRadios("key_online_radios");
            onlineRadios.getClass();
            arrayList.addAll(onlineRadios);
            List<OnlineRadioRingtones.Radio> onlineRadios2 = settings.getOnlineRadios("key_online_radios_featured");
            onlineRadios2.getClass();
            arrayList.addAll(onlineRadios2);
            Logger.logInfo("Lullaby: " + arrayList.size());
            for (Object obj2 : arrayList) {
                int i4 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                OnlineRadioRingtones.Radio radio = (OnlineRadioRingtones.Radio) obj2;
                zza$$ExternalSyntheticOutline0.m("Lullaby: ", radio.title);
                List<LullabyItem<?>> list2 = this.items;
                Activity activity2 = this.context;
                int i5 = i2;
                String str2 = radio.title;
                str2.getClass();
                String str3 = radio.url;
                str3.getClass();
                list2.add(new LullabyRadioItem(activity2, str2, str3, this, Integer.valueOf(ResourceUtil.getResourceByName(this.context, "color", "t" + (i5 % 7) + (i5 % 2 == 0 ? "a" : str))), null, 32, null));
                i2 = i4;
                str = str;
            }
            return;
        }
        this.items.add(new LullabyCategoriesItem(this.context, R.id.categoryNature, this));
        boolean zIsAddonLullaby = TrialFilter.getInstance().isAddonLullaby();
        boolean zIsAddonLullabyFree = TrialFilter.getInstance().isAddonLullabyFree();
        boolean zIsTrial = TrialFilter.getInstance().isTrial();
        boolean zIsLullabyUsed = settings.isLullabyUsed();
        LullabyPlayer.Lullaby[] lullabyByUsed = settings.getLullabyByUsed();
        lullabyByUsed.getClass();
        List mutableList = ArraysKt.toMutableList(lullabyByUsed);
        mutableList.remove(LullabyPlayer.Lullaby.NONE);
        if (zIsLullabyUsed && (zIsAddonLullaby || zIsAddonLullabyFree || !zIsTrial)) {
            this.items.add(new LullabySectionItem(this.context, settings.getLullabyAutoPlaylistSize() > 1 ? R.string.alert_playlist : R.string.last_used));
            int lullabyAutoPlaylistSize = settings.getLullabyAutoPlaylistSize() > 1 ? settings.getLullabyAutoPlaylistSize() : 5;
            if (mutableList.size() > lullabyAutoPlaylistSize) {
                for (LullabyPlayer.Lullaby lullaby : CollectionsKt.take(mutableList, lullabyAutoPlaylistSize)) {
                    List<LullabyItem<?>> list3 = this.items;
                    Activity activity3 = this.context;
                    String displayName = lullaby.getDisplayName(activity3);
                    displayName.getClass();
                    String strName = lullaby.name();
                    String strAttribution = lullaby.attribution();
                    Drawable icon = lullaby.getIcon(this.context);
                    icon.getClass();
                    list3.add(new LullabyIconItem(activity3, displayName, strName, strAttribution, icon));
                }
            } else {
                List<LullabyItem<?>> list4 = this.items;
                Activity activity4 = this.context;
                String displayName2 = ((LullabyPlayer.Lullaby) mutableList.get(0)).getDisplayName(this.context);
                displayName2.getClass();
                String strName2 = ((LullabyPlayer.Lullaby) mutableList.get(0)).name();
                String strAttribution2 = ((LullabyPlayer.Lullaby) mutableList.get(0)).attribution();
                Drawable icon2 = ((LullabyPlayer.Lullaby) mutableList.get(0)).getIcon(this.context);
                icon2.getClass();
                list4.add(new LullabyIconItem(activity4, displayName2, strName2, strAttribution2, icon2));
            }
            if (zIsTrial && zIsAddonLullaby) {
                this.items.add(new LullabyPremiumCardItem(this.context));
            }
            this.items.add(new LullabySectionItem(this.context, R.string.a_z));
        }
        LullabyPlayer.Lullaby[] lullabyArrValues = LullabyPlayer.Lullaby.values();
        if (lullabyArrValues.length > 1) {
            ArraysKt___ArraysJvmKt.sortWith(lullabyArrValues, new Comparator() { // from class: com.urbandroid.sleep.media.lullaby.LullabyRecyclerViewAdapter$loadSection$$inlined$sortBy$1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    return ComparisonsKt.compareValues(((LullabyPlayer.Lullaby) t).getDisplayName(this.this$0.getContext()), ((LullabyPlayer.Lullaby) t2).getDisplayName(this.this$0.getContext()));
                }
            });
        }
        int length = lullabyArrValues.length;
        while (i2 < length) {
            LullabyPlayer.Lullaby lullaby2 = lullabyArrValues[i2];
            if (lullaby2 != LullabyPlayer.Lullaby.NONE && ((lullaby2.isTrial() || !zIsTrial || !lullaby2.isLocalPackage()) && (lullaby2.isLocalPackage() || zIsAddonLullaby || zIsAddonLullabyFree))) {
                List<LullabyItem<?>> list5 = this.items;
                Activity activity5 = this.context;
                String displayName3 = lullaby2.getDisplayName(activity5);
                displayName3.getClass();
                String strName3 = lullaby2.name();
                String strAttribution3 = lullaby2.attribution();
                Drawable icon3 = lullaby2.getIcon(this.context);
                icon3.getClass();
                list5.add(new LullabyIconItem(activity5, displayName3, strName3, strAttribution3, icon3));
            }
            i2++;
        }
        if (zIsTrial && !zIsAddonLullaby) {
            this.items.add(new LullabyPremiumCardItem(this.context));
        }
        if (!TrialFilter.getInstance().isTrial()) {
            if (zIsAddonLullabyFree || zIsAddonLullaby) {
                this.items.add(new LullabyAddonRateItem(this.context));
                return;
            } else {
                this.items.add(new LullabyAddonFreeCardItem(this.context));
                return;
            }
        }
        List<LullabyItem<?>> list6 = this.items;
        Activity activity6 = this.context;
        if (zIsAddonLullaby) {
            list6.add(new LullabyAddonRateItem(activity6));
        } else {
            list6.add(new LullabyAddonCardItem(activity6));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.getClass();
        LullabyItem<?> lullabyItem = this.items.get(position);
        lullabyItem.getClass();
        lullabyItem.bindView(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parent.getClass();
        for (LullabyItem<?> lullabyItem : this.items) {
            if (lullabyItem.getType().ordinal() == viewType) {
                return lullabyItem.getViewHolder(parent);
            }
        }
        return new LullabySectionItem(this.context, R.string.lullaby).createViewHolder((View) parent);
    }
}
