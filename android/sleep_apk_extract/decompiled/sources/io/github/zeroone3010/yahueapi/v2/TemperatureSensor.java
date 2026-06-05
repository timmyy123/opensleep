package io.github.zeroone3010.yahueapi.v2;

import j$.time.ZonedDateTime;
import java.math.BigDecimal;

/* JADX INFO: loaded from: classes5.dex */
public interface TemperatureSensor extends Device {
    BigDecimal getDegreesCelsius();

    BigDecimal getDegreesFahrenheit();

    ZonedDateTime getLastChanged();
}
