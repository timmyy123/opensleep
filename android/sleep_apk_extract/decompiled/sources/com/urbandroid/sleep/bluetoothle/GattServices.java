package com.urbandroid.sleep.bluetoothle;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import com.facebook.appevents.iap.InAppPurchaseConstants;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u0004\u0018\u00010\u00032\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/urbandroid/sleep/bluetoothle/GattServices;", "", "", "Landroid/bluetooth/BluetoothGattService;", "services", "<init>", "(Ljava/util/List;)V", "Ljava/util/UUID;", "serviceId", "getService", "(Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattService;", "characteristicId", "Landroid/bluetooth/BluetoothGattCharacteristic;", "getCharacteristic", "(Ljava/util/UUID;Ljava/util/UUID;)Landroid/bluetooth/BluetoothGattCharacteristic;", "", "contains", "(Ljava/util/UUID;Ljava/util/UUID;)Z", "", InAppPurchaseConstants.METHOD_TO_STRING, "()Ljava/lang/String;", "Ljava/util/List;", "getServices", "()Ljava/util/List;", "Sleep_prodRelease"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class GattServices {
    private final List<BluetoothGattService> services;

    /* JADX WARN: Multi-variable type inference failed */
    public GattServices(List<? extends BluetoothGattService> list) {
        list.getClass();
        this.services = list;
    }

    public final boolean contains(UUID serviceId, UUID characteristicId) {
        serviceId.getClass();
        characteristicId.getClass();
        return getCharacteristic(serviceId, characteristicId) != null;
    }

    public final BluetoothGattCharacteristic getCharacteristic(UUID serviceId, UUID characteristicId) {
        serviceId.getClass();
        characteristicId.getClass();
        BluetoothGattService service = getService(serviceId);
        if (service != null) {
            return service.getCharacteristic(characteristicId);
        }
        return null;
    }

    public final BluetoothGattService getService(UUID serviceId) {
        Object next;
        serviceId.getClass();
        Iterator<T> it = this.services.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (Intrinsics.areEqual(((BluetoothGattService) next).getUuid(), serviceId)) {
                break;
            }
        }
        return (BluetoothGattService) next;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (BluetoothGattService bluetoothGattService : this.services) {
            if (sb.length() > 0) {
                sb.append("\n");
            }
            sb.append("Service: " + bluetoothGattService.getUuid());
            Iterator<BluetoothGattCharacteristic> it = bluetoothGattService.getCharacteristics().iterator();
            while (it.hasNext()) {
                sb.append("\nCharacteristic: " + it.next().getUuid());
            }
        }
        return sb.toString();
    }
}
