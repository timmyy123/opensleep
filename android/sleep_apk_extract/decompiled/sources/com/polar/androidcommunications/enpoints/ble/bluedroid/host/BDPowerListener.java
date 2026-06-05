package com.polar.androidcommunications.enpoints.ble.bluedroid.host;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* JADX INFO: loaded from: classes4.dex */
class BDPowerListener {
    private final BluetoothAdapter bluetoothAdapter;
    private final Context context;
    private final BlePowerState powerState;
    private BroadcastReceiver receiver;

    public interface BlePowerState {
        void blePoweredOff();

        void blePoweredOn();
    }

    public BDPowerListener(BluetoothAdapter bluetoothAdapter, Context context, BlePowerState blePowerState) {
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.polar.androidcommunications.enpoints.ble.bluedroid.host.BDPowerListener.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context2, Intent intent) {
                String action = intent.getAction();
                if (action == null || !action.equals("android.bluetooth.adapter.action.STATE_CHANGED")) {
                    return;
                }
                int state = BDPowerListener.this.bluetoothAdapter.getState();
                BDPowerListener bDPowerListener = BDPowerListener.this;
                if (state == 10) {
                    bDPowerListener.powerState.blePoweredOff();
                } else if (bDPowerListener.bluetoothAdapter.getState() == 12) {
                    BDPowerListener.this.powerState.blePoweredOn();
                }
            }
        };
        this.receiver = broadcastReceiver;
        this.bluetoothAdapter = bluetoothAdapter;
        this.context = context;
        context.registerReceiver(broadcastReceiver, new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED"));
        this.powerState = blePowerState;
    }

    public void stopBroadcastReceiver() {
        BroadcastReceiver broadcastReceiver = this.receiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.receiver = null;
        }
    }
}
