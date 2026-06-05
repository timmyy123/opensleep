package com.urbandroid.sleep.sensor;

import android.content.Context;
import android.content.Intent;
import com.urbandroid.sleep.ContextExtKt;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class FlipGestureDetector {
    private Context context;
    private Map<Position, PositionCounter> counterMap;
    private Position currentPosition;
    private Position lastPosition;

    public enum Position {
        BACK,
        FRONT,
        NONE,
        UNKNOWN
    }

    public FlipGestureDetector(Context context) {
        HashMap map = new HashMap();
        this.counterMap = map;
        Position position = Position.NONE;
        this.currentPosition = position;
        this.lastPosition = position;
        this.context = context;
        int i = 0;
        map.put(Position.BACK, new PositionCounter(this, i));
        this.counterMap.put(Position.FRONT, new PositionCounter(this, i));
        this.counterMap.put(position, new PositionCounter(this, i));
    }

    private void sentFlipIntent() {
        ContextExtKt.sendExplicitBroadcast(this.context, new Intent("com.urbandroid.sleep.ACCEL_GESTURE_FLIP_ACTION"));
    }

    private void updatePosition(Position position) {
        if (this.currentPosition == Position.UNKNOWN) {
            this.currentPosition = position;
            this.lastPosition = position;
        }
        if (this.lastPosition != position) {
            for (Position position2 : Position.values()) {
                if (position2 != Position.UNKNOWN && position2 != position) {
                    this.counterMap.get(position2).reset();
                }
            }
        } else if (this.currentPosition != position && this.counterMap.get(position).inc()) {
            Position position3 = this.currentPosition;
            Position position4 = Position.NONE;
            if (position3 != position4 && position != position4) {
                sentFlipIntent();
            }
            this.currentPosition = position;
        }
        this.lastPosition = position;
    }

    public void update(float f, float f2, float f3) {
        if (f3 != 0.0f) {
            if (Math.abs(f3) > (Math.abs(f2) * 2.0f) + Math.abs(f)) {
                if (f3 > 0.0f) {
                    updatePosition(Position.BACK);
                    return;
                } else {
                    if (f3 < 0.0f) {
                        updatePosition(Position.FRONT);
                        return;
                    }
                    return;
                }
            }
        }
        updatePosition(Position.NONE);
    }

    public class PositionCounter {
        private long lastTimestamp;
        private boolean reset;

        private PositionCounter() {
            this.reset = true;
        }

        public boolean inc() {
            if (this.reset) {
                this.lastTimestamp = System.currentTimeMillis();
                this.reset = false;
            } else if (System.currentTimeMillis() - this.lastTimestamp > 2000) {
                return true;
            }
            return false;
        }

        public void reset() {
            this.reset = true;
        }

        public /* synthetic */ PositionCounter(FlipGestureDetector flipGestureDetector, int i) {
            this();
        }
    }
}
