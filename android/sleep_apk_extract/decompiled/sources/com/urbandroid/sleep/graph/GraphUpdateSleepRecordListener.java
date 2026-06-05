package com.urbandroid.sleep.graph;

import android.content.Context;
import android.os.Handler;
import com.urbandroid.sleep.SleepRecordFilterFilterAsyncTask;
import com.urbandroid.sleep.domain.SleepRecord;
import com.urbandroid.sleep.domain.SleepRecordChangeListener;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class GraphUpdateSleepRecordListener implements SleepRecordChangeListener {
    private final Context context;
    private final GraphView graph;
    private int updateCounter = 0;
    private Handler h = new Handler();

    public GraphUpdateSleepRecordListener(GraphView graphView, Context context) {
        this.graph = graphView;
        this.context = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean skipUpdate(SleepRecord sleepRecord) {
        return this.updateCounter % 6 != 0 && sleepRecord.getRecordCount() > 600;
    }

    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // com.urbandroid.sleep.domain.SleepRecordChangeListener
    public void onDataAdded(final SleepRecord sleepRecord) {
        this.h.post(new Runnable() { // from class: com.urbandroid.sleep.graph.GraphUpdateSleepRecordListener.1
            @Override // java.lang.Runnable
            public void run() {
                if (!GraphUpdateSleepRecordListener.this.skipUpdate(sleepRecord)) {
                    new SleepRecordFilterFilterAsyncTask(sleepRecord) { // from class: com.urbandroid.sleep.graph.GraphUpdateSleepRecordListener.1.1
                        @Override // android.os.AsyncTask
                        public void onPostExecute(List<Float> list) {
                            super.onPostExecute(list);
                            if (list != null) {
                                GraphUpdateSleepRecordListener.this.graph.setXAxisLabels(new TimeAxisLabels(GraphUpdateSleepRecordListener.this.context, sleepRecord.getFrom(), new Date(), null, list.size()));
                                GraphUpdateSleepRecordListener.this.graph.setEquidistantValues(list, sleepRecord.shouldUseExactFitView());
                                GraphUpdateSleepRecordListener.this.graph.setYAxisLabels(null);
                            }
                        }
                    }.execute(new Void[0]);
                }
                GraphUpdateSleepRecordListener.this.updateCounter++;
            }
        });
    }
}
