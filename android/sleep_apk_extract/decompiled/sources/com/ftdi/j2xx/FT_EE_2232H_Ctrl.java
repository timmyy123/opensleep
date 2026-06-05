package com.ftdi.j2xx;

import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;

/* JADX INFO: loaded from: classes3.dex */
class FT_EE_2232H_Ctrl extends FT_EE_Ctrl {
    public FT_EE_2232H_Ctrl(FT_Device fT_Device) {
        super(fT_Device);
        getEepromSize(MqttWireMessage.MESSAGE_TYPE_PINGREQ);
    }
}
