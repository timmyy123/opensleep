package com.urbandroid.sleep.fragment.preview;

import android.content.Context;
import androidx.appfunctions.compiler.core.IntrospectionHelper;
import com.urbandroid.sleep.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u000f"}, d2 = {"Lcom/urbandroid/sleep/fragment/preview/RestoreInappPreviewFragment;", "Lcom/urbandroid/sleep/fragment/preview/AbstractPreviewFragment;", "<init>", "()V", "getLayout", "", "getPages", "", "Lcom/urbandroid/sleep/fragment/preview/PreviewPage;", "c", "Landroid/content/Context;", "r", "", IntrospectionHelper.AppFunctionContextClass.CONTEXT_PROPERTY_NAME, "resource", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class RestoreInappPreviewFragment extends AbstractPreviewFragment {
    private final CharSequence r(Context context, int resource) {
        CharSequence text = context.getText(resource);
        text.getClass();
        return text;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public int getLayout() {
        return R.layout.fragment_preview;
    }

    @Override // com.urbandroid.sleep.fragment.preview.AbstractPreviewFragment
    public List<PreviewPage> getPages(Context c) {
        c.getClass();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new PreviewPage(r(c, R.string.unlock_restore_unlock_tutorial_title_1), r(c, R.string.unlock_restore_unlock_tutorial_desc_1), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_account, -1));
        arrayList.add(new PreviewPage(r(c, R.string.did_not_help), r(c, R.string.unlock_restore_unlock_tutorial_desc_3), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_install_account, -1));
        arrayList.add(new PreviewPage(r(c, R.string.unlock_restore_unlock_tutorial_title_6), r(c, R.string.unlock_restore_unlock_tutorial_desc_6), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_uninstall, -1));
        arrayList.add(new PreviewPage(r(c, R.string.unlock_restore_unlock_tutorial_title_4), r(c, R.string.unlock_restore_unlock_tutorial_desc_4), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_my_apps, -1));
        arrayList.add(new PreviewPage(r(c, R.string.unlock_restore_unlock_tutorial_title_5), r(c, R.string.unlock_restore_unlock_tutorial_desc_5), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_library, -1));
        arrayList.add(new PreviewPage(r(c, R.string.unlock_restore_unlock_tutorial_title_4), r(c, R.string.unlock_restore_unlock_tutorial_desc_1), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_account, -1));
        arrayList.add(new PreviewPage(r(c, R.string.unlock_restore_unlock_tutorial_title_2b), r(c, R.string.unlock_restore_unlock_tutorial_desc_2), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_install_main, -1));
        arrayList.add(new PreviewPage(r(c, R.string.did_not_help), r(c, R.string.unlock_restore_unlock_tutorial_desc_7), R.color.tint_background, R.color.tint_background, R.drawable.restore_unlock_pc, -1));
        return arrayList;
    }
}
