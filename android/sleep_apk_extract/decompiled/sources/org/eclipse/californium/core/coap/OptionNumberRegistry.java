package org.eclipse.californium.core.coap;

/* JADX INFO: loaded from: classes5.dex */
public abstract class OptionNumberRegistry {

    public enum optionFormats {
        INTEGER,
        STRING,
        OPAQUE,
        UNKNOWN,
        EMPTY
    }

    public static optionFormats getFormatByNr(int i) {
        if (i != 1) {
            if (i != 17) {
                if (i != 20) {
                    if (i != 23) {
                        if (i != 35 && i != 39) {
                            if (i != 60) {
                                if (i != 11) {
                                    if (i != 12 && i != 14) {
                                        if (i != 15) {
                                            if (i != 27 && i != 28) {
                                                switch (i) {
                                                    case 3:
                                                    case 8:
                                                        break;
                                                    case 4:
                                                    case 9:
                                                        break;
                                                    case 5:
                                                        return optionFormats.EMPTY;
                                                    case 6:
                                                    case 7:
                                                        break;
                                                    default:
                                                        return optionFormats.UNKNOWN;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return optionFormats.STRING;
            }
            return optionFormats.INTEGER;
        }
        return optionFormats.OPAQUE;
    }

    public static String toString(int i) {
        if (i == 0) {
            return "Reserved";
        }
        if (i == 1) {
            return "If-Match";
        }
        if (i == 11) {
            return "Uri-Path";
        }
        if (i == 12) {
            return "Content-Format";
        }
        if (i == 14) {
            return "Max-Age";
        }
        if (i == 15) {
            return "Uri-Query";
        }
        if (i == 17) {
            return "Accept";
        }
        if (i == 20) {
            return "Location-Query";
        }
        if (i == 23) {
            return "Block2";
        }
        if (i == 35) {
            return "Proxy-Uri";
        }
        if (i == 39) {
            return "Proxy-Scheme";
        }
        if (i == 60) {
            return "Size1";
        }
        if (i == 128 || i == 132 || i == 136 || i == 140) {
            return "Reserved";
        }
        if (i == 27) {
            return "Block1";
        }
        if (i == 28) {
            return "Size2";
        }
        switch (i) {
            case 3:
                return "Uri-Host";
            case 4:
                return "ETag";
            case 5:
                return "If-None-Match";
            case 6:
                return "Observe";
            case 7:
                return "Uri-Port";
            case 8:
                return "Location-Path";
            case 9:
                return "Object-Security";
            default:
                return String.format("Unknown (%d)", Integer.valueOf(i));
        }
    }
}
