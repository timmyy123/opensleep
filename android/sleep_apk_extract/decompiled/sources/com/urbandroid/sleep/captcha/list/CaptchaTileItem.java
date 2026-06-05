package com.urbandroid.sleep.captcha.list;

import android.R;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.getpebble.android.kit.Constants;
import com.google.home.automation.zza$$ExternalSyntheticOutline0;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.captcha.CaptchaDrawableUtil;
import com.urbandroid.sleep.captcha.list.CaptchaItem;
import com.urbandroid.sleep.fragment.dashboard.card.AnimatedViewHolder;
import com.urbandroid.sleep.service.SharedApplicationContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0010\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\"B5\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0019\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001e\u0010\u001dR\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/CaptchaTileItem;", "Lcom/urbandroid/sleep/captcha/list/CaptchaItem;", "Lcom/urbandroid/sleep/captcha/list/CaptchaTileItem$ViewHolder;", "Landroid/content/Context;", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "list", "", "text", "summary", "", "captchaId", "<init>", "(Landroid/content/Context;Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;Ljava/lang/String;Ljava/lang/String;I)V", "Landroid/view/View;", "v", "createViewHolder", "(Landroid/view/View;)Lcom/urbandroid/sleep/captcha/list/CaptchaTileItem$ViewHolder;", "viewHolder", "", "bindView", "(Lcom/urbandroid/sleep/captcha/list/CaptchaTileItem$ViewHolder;)V", "onItemClicked", "()V", "Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "getList", "()Lcom/urbandroid/sleep/captcha/list/ICaptchaTileList;", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "getSummary", "I", "getCaptchaId", "()I", "ViewHolder", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class CaptchaTileItem extends CaptchaItem<ViewHolder> {
    private final int captchaId;
    private final ICaptchaTileList list;
    private final String summary;
    private final String text;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\r\u0010\b\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/urbandroid/sleep/captcha/list/CaptchaTileItem$ViewHolder;", "Lcom/urbandroid/sleep/fragment/dashboard/card/AnimatedViewHolder;", "Landroid/view/View;", ViewHierarchyConstants.VIEW_KEY, "<init>", "(Landroid/view/View;)V", "Landroid/widget/TextView;", "title", "Landroid/widget/TextView;", "getTitle", "()Landroid/widget/TextView;", "setTitle", "(Landroid/widget/TextView;)V", "summary", "getSummary", "setSummary", "Landroid/widget/ImageView;", Constants.CUST_ICON, "Landroid/widget/ImageView;", "getIcon", "()Landroid/widget/ImageView;", "setIcon", "(Landroid/widget/ImageView;)V", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ViewHolder extends AnimatedViewHolder {
        private ImageView icon;
        private TextView summary;
        private TextView title;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view) {
            super(view);
            view.getClass();
            View viewFindViewById = view.findViewById(R.id.title);
            viewFindViewById.getClass();
            this.title = (TextView) viewFindViewById;
            View viewFindViewById2 = view.findViewById(R.id.summary);
            viewFindViewById2.getClass();
            this.summary = (TextView) viewFindViewById2;
            View viewFindViewById3 = view.findViewById(R.id.icon);
            viewFindViewById3.getClass();
            this.icon = (ImageView) viewFindViewById3;
        }

        public final ImageView getIcon() {
            return this.icon;
        }

        public final TextView getSummary() {
            return this.summary;
        }

        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CaptchaTileItem(Context context, ICaptchaTileList iCaptchaTileList, String str, String str2, int i) {
        super(context, com.urbandroid.sleep.R.layout.fragment_captcha_list_item2, CaptchaItem.Type.CAPTCHA);
        context.getClass();
        iCaptchaTileList.getClass();
        str.getClass();
        this.list = iCaptchaTileList;
        this.text = str;
        this.summary = str2;
        this.captchaId = i;
    }

    @Override // com.urbandroid.sleep.captcha.list.CaptchaItem
    public void bindView(ViewHolder viewHolder) {
        viewHolder.getClass();
        super.bindView(viewHolder);
        Logger.logInfo("CAPTCHA " + this.text + " " + this.captchaId);
        viewHolder.getTitle().setText(this.text);
        viewHolder.getIcon().setImageDrawable(CaptchaDrawableUtil.INSTANCE.getDrawable(getContext(), this.captchaId));
        if (this.summary == null) {
            viewHolder.getSummary().setText("");
        } else {
            viewHolder.getSummary().setText(this.summary);
        }
    }

    @Override // com.urbandroid.sleep.captcha.list.CaptchaItem
    public ViewHolder createViewHolder(View v) {
        v.getClass();
        return new ViewHolder(v);
    }

    @Override // com.urbandroid.sleep.captcha.list.CaptchaItem
    public void onItemClicked() {
        if (!this.list.getPerAlarm()) {
            SharedApplicationContext.getSettings().setDefaultCaptchaId(this.captchaId);
        }
        this.list.setSelectedCaptchaId(this.captchaId);
        zza$$ExternalSyntheticOutline0.m(this.captchaId, "Selected CAPTCHA ");
        this.list.dismiss();
    }
}
