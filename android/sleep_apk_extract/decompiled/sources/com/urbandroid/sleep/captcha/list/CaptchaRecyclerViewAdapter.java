package com.urbandroid.sleep.captcha.list;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.app.Activity;
import android.os.Handler;
import android.view.ViewGroup;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButtonGroup$$ExternalSyntheticLambda0;
import com.urbandroid.sleep.R;
import com.urbandroid.sleep.TrialFilter;
import com.urbandroid.sleep.captcha.domain.CaptchaGroup;
import com.urbandroid.sleep.captcha.domain.CaptchaInfo;
import com.urbandroid.sleep.captcha.finder.filter.AndCaptchaInfoFilter;
import com.urbandroid.sleep.captcha.finder.filter.NotCaptchaInfoFilter;
import com.urbandroid.sleep.captcha.finder.filter.PackageCaptchaInfoFilter;
import com.urbandroid.sleep.captcha.list.CaptchaTileItem;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CombinedContext$$ExternalSyntheticLambda1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.mp4parser.boxes.apple.TrackLoadSettingsAtom;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u001b\u0010\u0017\u001a\u00020\u00122\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019¢\u0006\u0004\b\u0017\u0010\u001cJ\u0015\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u0017\u0010\u001eJ\u001f\u0010 \u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\"\u0010#R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010$\u001a\u0004\b%\u0010&R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b(\u0010)R!\u0010,\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030+0*8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00101\u001a\u0002008\u0006¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00065"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/CaptchaRecyclerViewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/app/Activity;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "list", "<init>", "(Landroid/app/Activity;Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;)V", "Landroid/view/ViewGroup;", "parent", "", "viewType", "onCreateViewHolder", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "getItemViewType", "(I)I", "", TrackLoadSettingsAtom.TYPE, "()V", "Lcom/urbandroid/sleep/captcha/domain/CaptchaInfo;", "captchaInfo", "add", "(Lcom/urbandroid/sleep/captcha/domain/CaptchaInfo;)V", "", "Lcom/urbandroid/sleep/captcha/domain/CaptchaGroup;", "groups", "(Ljava/util/List;)V", "group", "(Lcom/urbandroid/sleep/captcha/domain/CaptchaGroup;)V", "holder", "onBindViewHolder", "(Landroidx/recyclerview/widget/RecyclerView$ViewHolder;I)V", "getItemCount", "()I", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "getList", "()Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "", "Lcom/urbandroid/sleep/captcha/list/CaptchaItem;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final Activity context;
    private final Handler handler;
    private final List<CaptchaItem<?>> items;
    private final ICaptchaTileList list;

    public CaptchaRecyclerViewAdapter(Activity activity, ICaptchaTileList iCaptchaTileList) {
        activity.getClass();
        iCaptchaTileList.getClass();
        this.context = activity;
        this.list = iCaptchaTileList;
        this.items = new ArrayList();
        this.handler = new Handler();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int add$lambda$0(CaptchaInfo captchaInfo, CaptchaInfo captchaInfo2) {
        captchaInfo.getClass();
        captchaInfo2.getClass();
        return Intrinsics.compare(captchaInfo.getOrder(), captchaInfo2.getOrder());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int add$lambda$1(Function2 function2, Object obj, Object obj2) {
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    public final void add(CaptchaGroup group) {
        group.getClass();
        List<CaptchaInfo> captchaInfos = group.getCaptchaInfos();
        captchaInfos.getClass();
        if (captchaInfos.isEmpty()) {
            return;
        }
        int i = 1;
        CollectionsKt.sortWith(captchaInfos, new MaterialButtonGroup$$ExternalSyntheticLambda0(new CombinedContext$$ExternalSyntheticLambda1(i), i));
        for (CaptchaInfo captchaInfo : captchaInfos) {
            captchaInfo.getClass();
            add(captchaInfo);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.items.get(position).getType().ordinal();
    }

    public final void load() {
        this.items.clear();
        PackageCaptchaInfoFilter packageCaptchaInfoFilter = new PackageCaptchaInfoFilter(this.context);
        PackageCaptchaInfoFilter packageCaptchaInfoFilter2 = new PackageCaptchaInfoFilter("com.urbandroid.sleep.captchapack");
        TrialFilter.getInstance().reevaluate();
        List<CaptchaGroup> listFindGroups = SharedApplicationContext.getCaptchaManager().getFinder().findGroups(packageCaptchaInfoFilter);
        listFindGroups.getClass();
        List<CaptchaGroup> listFindGroups2 = SharedApplicationContext.getCaptchaManager().getFinder().findGroups(packageCaptchaInfoFilter2);
        listFindGroups2.getClass();
        List<CaptchaGroup> listFindGroups3 = SharedApplicationContext.getCaptchaManager().getFinder().findGroups(new AndCaptchaInfoFilter(new NotCaptchaInfoFilter(packageCaptchaInfoFilter), new NotCaptchaInfoFilter(packageCaptchaInfoFilter2)));
        listFindGroups3.getClass();
        if (this.list.getPerAlarm()) {
            CaptchaInfo defaultCaptcha = SharedApplicationContext.getSettings().getDefaultCaptcha();
            List<CaptchaItem<?>> list = this.items;
            if (defaultCaptcha != null) {
                Activity activity = this.context;
                list.add(new CaptchaTileItem(activity, this.list, FileInsert$$ExternalSyntheticOutline0.m$1(activity.getString(R.string.settings_category_alarm), ":"), defaultCaptcha.getLabel(), defaultCaptcha.getId()));
            } else {
                Activity activity2 = this.context;
                list.add(new CaptchaTileItem(activity2, this.list, FileInsert$$ExternalSyntheticOutline0.m$1(activity2.getString(R.string.settings_category_alarm), ":"), this.context.getString(R.string.disabled), 0));
            }
        }
        List<CaptchaItem<?>> list2 = this.items;
        Activity activity3 = this.context;
        ICaptchaTileList iCaptchaTileList = this.list;
        String string = activity3.getString(R.string.disabled);
        string.getClass();
        list2.add(new CaptchaTileItem(activity3, iCaptchaTileList, string, "", 0));
        add(listFindGroups);
        add(listFindGroups2);
        add(listFindGroups3);
        if (listFindGroups2.size() >= 1 || this.items.size() <= 6) {
            this.items.add(6, new CaptchaRateItem(this.context));
        } else {
            this.items.add(6, new CaptchaAddonItem(this.context));
        }
        this.items.add(new CaptchaTileEmpty(this.context));
        this.items.add(new CaptchaTileEmpty(this.context));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.getClass();
        CaptchaItem<?> captchaItem = this.items.get(position);
        captchaItem.getClass();
        captchaItem.bindView(holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        parent.getClass();
        for (CaptchaItem<?> captchaItem : this.items) {
            if (captchaItem.getType().ordinal() == viewType) {
                return captchaItem.getViewHolder(parent);
            }
        }
        return new CaptchaTileItem.ViewHolder(parent);
    }

    public final void add(List<? extends CaptchaGroup> groups) {
        groups.getClass();
        Iterator<? extends CaptchaGroup> it = groups.iterator();
        while (it.hasNext()) {
            add(it.next());
        }
    }

    public final void add(CaptchaInfo captchaInfo) {
        captchaInfo.getClass();
        List<CaptchaItem<?>> list = this.items;
        Activity activity = this.context;
        ICaptchaTileList iCaptchaTileList = this.list;
        String label = captchaInfo.getLabel();
        label.getClass();
        list.add(new CaptchaTileItem(activity, iCaptchaTileList, label, "", captchaInfo.getId()));
    }
}
