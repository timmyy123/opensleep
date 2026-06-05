package androidx.appcompat.view.menu;

import android.widget.ListView;

/* JADX INFO: loaded from: classes.dex */
public interface ShowableListMenu {
    void dismiss();

    ListView getListView();

    boolean isShowing();

    void show();
}
