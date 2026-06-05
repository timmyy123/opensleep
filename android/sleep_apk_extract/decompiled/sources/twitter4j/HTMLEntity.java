package twitter4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
abstract class HTMLEntity {
    private static final Map<String, String> entityEscapeMap = new HashMap();
    private static final Map<String, String> escapeEntityMap = new HashMap();

    static {
        String[][] strArr = {new String[]{"&nbsp;", "&#160;", " "}, new String[]{"&iexcl;", "&#161;", "¡"}, new String[]{"&cent;", "&#162;", "¢"}, new String[]{"&pound;", "&#163;", "£"}, new String[]{"&curren;", "&#164;", "¤"}, new String[]{"&yen;", "&#165;", "¥"}, new String[]{"&brvbar;", "&#166;", "¦"}, new String[]{"&sect;", "&#167;", "§"}, new String[]{"&uml;", "&#168;", "¨"}, new String[]{"&copy;", "&#169;", "©"}, new String[]{"&ordf;", "&#170;", "ª"}, new String[]{"&laquo;", "&#171;", "«"}, new String[]{"&not;", "&#172;", "¬"}, new String[]{"&shy;", "&#173;", "\u00ad"}, new String[]{"&reg;", "&#174;", "®"}, new String[]{"&macr;", "&#175;", "¯"}, new String[]{"&deg;", "&#176;", "°"}, new String[]{"&plusmn;", "&#177;", "±"}, new String[]{"&sup2;", "&#178;", "²"}, new String[]{"&sup3;", "&#179;", "³"}, new String[]{"&acute;", "&#180;", "´"}, new String[]{"&micro;", "&#181;", "µ"}, new String[]{"&para;", "&#182;", "¶"}, new String[]{"&middot;", "&#183;", "·"}, new String[]{"&cedil;", "&#184;", "¸"}, new String[]{"&sup1;", "&#185;", "¹"}, new String[]{"&ordm;", "&#186;", "º"}, new String[]{"&raquo;", "&#187;", "»"}, new String[]{"&frac14;", "&#188;", "¼"}, new String[]{"&frac12;", "&#189;", "½"}, new String[]{"&frac34;", "&#190;", "¾"}, new String[]{"&iquest;", "&#191;", "¿"}, new String[]{"&Agrave;", "&#192;", "À"}, new String[]{"&Aacute;", "&#193;", "Á"}, new String[]{"&Acirc;", "&#194;", "Â"}, new String[]{"&Atilde;", "&#195;", "Ã"}, new String[]{"&Auml;", "&#196;", "Ä"}, new String[]{"&Aring;", "&#197;", "Å"}, new String[]{"&AElig;", "&#198;", "Æ"}, new String[]{"&Ccedil;", "&#199;", "Ç"}, new String[]{"&Egrave;", "&#200;", "È"}, new String[]{"&Eacute;", "&#201;", "É"}, new String[]{"&Ecirc;", "&#202;", "Ê"}, new String[]{"&Euml;", "&#203;", "Ë"}, new String[]{"&Igrave;", "&#204;", "Ì"}, new String[]{"&Iacute;", "&#205;", "Í"}, new String[]{"&Icirc;", "&#206;", "Î"}, new String[]{"&Iuml;", "&#207;", "Ï"}, new String[]{"&ETH;", "&#208;", "Ð"}, new String[]{"&Ntilde;", "&#209;", "Ñ"}, new String[]{"&Ograve;", "&#210;", "Ò"}, new String[]{"&Oacute;", "&#211;", "Ó"}, new String[]{"&Ocirc;", "&#212;", "Ô"}, new String[]{"&Otilde;", "&#213;", "Õ"}, new String[]{"&Ouml;", "&#214;", "Ö"}, new String[]{"&times;", "&#215;", "×"}, new String[]{"&Oslash;", "&#216;", "Ø"}, new String[]{"&Ugrave;", "&#217;", "Ù"}, new String[]{"&Uacute;", "&#218;", "Ú"}, new String[]{"&Ucirc;", "&#219;", "Û"}, new String[]{"&Uuml;", "&#220;", "Ü"}, new String[]{"&Yacute;", "&#221;", "Ý"}, new String[]{"&THORN;", "&#222;", "Þ"}, new String[]{"&szlig;", "&#223;", "ß"}, new String[]{"&agrave;", "&#224;", "à"}, new String[]{"&aacute;", "&#225;", "á"}, new String[]{"&acirc;", "&#226;", "â"}, new String[]{"&atilde;", "&#227;", "ã"}, new String[]{"&auml;", "&#228;", "ä"}, new String[]{"&aring;", "&#229;", "å"}, new String[]{"&aelig;", "&#230;", "æ"}, new String[]{"&ccedil;", "&#231;", "ç"}, new String[]{"&egrave;", "&#232;", "è"}, new String[]{"&eacute;", "&#233;", "é"}, new String[]{"&ecirc;", "&#234;", "ê"}, new String[]{"&euml;", "&#235;", "ë"}, new String[]{"&igrave;", "&#236;", "ì"}, new String[]{"&iacute;", "&#237;", "í"}, new String[]{"&icirc;", "&#238;", "î"}, new String[]{"&iuml;", "&#239;", "ï"}, new String[]{"&eth;", "&#240;", "ð"}, new String[]{"&ntilde;", "&#241;", "ñ"}, new String[]{"&ograve;", "&#242;", "ò"}, new String[]{"&oacute;", "&#243;", "ó"}, new String[]{"&ocirc;", "&#244;", "ô"}, new String[]{"&otilde;", "&#245;", "õ"}, new String[]{"&ouml;", "&#246;", "ö"}, new String[]{"&divide;", "&#247;", "÷"}, new String[]{"&oslash;", "&#248;", "ø"}, new String[]{"&ugrave;", "&#249;", "ù"}, new String[]{"&uacute;", "&#250;", "ú"}, new String[]{"&ucirc;", "&#251;", "û"}, new String[]{"&uuml;", "&#252;", "ü"}, new String[]{"&yacute;", "&#253;", "ý"}, new String[]{"&thorn;", "&#254;", "þ"}, new String[]{"&yuml;", "&#255;", "ÿ"}, new String[]{"&fnof;", "&#402;", "ƒ"}, new String[]{"&Alpha;", "&#913;", "Α"}, new String[]{"&Beta;", "&#914;", "Β"}, new String[]{"&Gamma;", "&#915;", "Γ"}, new String[]{"&Delta;", "&#916;", "Δ"}, new String[]{"&Epsilon;", "&#917;", "Ε"}, new String[]{"&Zeta;", "&#918;", "Ζ"}, new String[]{"&Eta;", "&#919;", "Η"}, new String[]{"&Theta;", "&#920;", "Θ"}, new String[]{"&Iota;", "&#921;", "Ι"}, new String[]{"&Kappa;", "&#922;", "Κ"}, new String[]{"&Lambda;", "&#923;", "Λ"}, new String[]{"&Mu;", "&#924;", "Μ"}, new String[]{"&Nu;", "&#925;", "Ν"}, new String[]{"&Xi;", "&#926;", "Ξ"}, new String[]{"&Omicron;", "&#927;", "Ο"}, new String[]{"&Pi;", "&#928;", "Π"}, new String[]{"&Rho;", "&#929;", "Ρ"}, new String[]{"&Sigma;", "&#931;", "Σ"}, new String[]{"&Tau;", "&#932;", "Τ"}, new String[]{"&Upsilon;", "&#933;", "Υ"}, new String[]{"&Phi;", "&#934;", "Φ"}, new String[]{"&Chi;", "&#935;", "Χ"}, new String[]{"&Psi;", "&#936;", "Ψ"}, new String[]{"&Omega;", "&#937;", "Ω"}, new String[]{"&alpha;", "&#945;", "α"}, new String[]{"&beta;", "&#946;", "β"}, new String[]{"&gamma;", "&#947;", "γ"}, new String[]{"&delta;", "&#948;", "δ"}, new String[]{"&epsilon;", "&#949;", "ε"}, new String[]{"&zeta;", "&#950;", "ζ"}, new String[]{"&eta;", "&#951;", "η"}, new String[]{"&theta;", "&#952;", "θ"}, new String[]{"&iota;", "&#953;", "ι"}, new String[]{"&kappa;", "&#954;", "κ"}, new String[]{"&lambda;", "&#955;", "λ"}, new String[]{"&mu;", "&#956;", "μ"}, new String[]{"&nu;", "&#957;", "ν"}, new String[]{"&xi;", "&#958;", "ξ"}, new String[]{"&omicron;", "&#959;", "ο"}, new String[]{"&pi;", "&#960;", "π"}, new String[]{"&rho;", "&#961;", "ρ"}, new String[]{"&sigmaf;", "&#962;", "ς"}, new String[]{"&sigma;", "&#963;", "σ"}, new String[]{"&tau;", "&#964;", "τ"}, new String[]{"&upsilon;", "&#965;", "υ"}, new String[]{"&phi;", "&#966;", "φ"}, new String[]{"&chi;", "&#967;", "χ"}, new String[]{"&psi;", "&#968;", "ψ"}, new String[]{"&omega;", "&#969;", "ω"}, new String[]{"&thetasym;", "&#977;", "ϑ"}, new String[]{"&upsih;", "&#978;", "ϒ"}, new String[]{"&piv;", "&#982;", "ϖ"}, new String[]{"&bull;", "&#8226;", "•"}, new String[]{"&hellip;", "&#8230;", "…"}, new String[]{"&prime;", "&#8242;", "′"}, new String[]{"&Prime;", "&#8243;", "″"}, new String[]{"&oline;", "&#8254;", "‾"}, new String[]{"&frasl;", "&#8260;", "⁄"}, new String[]{"&weierp;", "&#8472;", "℘"}, new String[]{"&image;", "&#8465;", "ℑ"}, new String[]{"&real;", "&#8476;", "ℜ"}, new String[]{"&trade;", "&#8482;", "™"}, new String[]{"&alefsym;", "&#8501;", "ℵ"}, new String[]{"&larr;", "&#8592;", "←"}, new String[]{"&uarr;", "&#8593;", "↑"}, new String[]{"&rarr;", "&#8594;", "→"}, new String[]{"&darr;", "&#8595;", "↓"}, new String[]{"&harr;", "&#8596;", "↔"}, new String[]{"&crarr;", "&#8629;", "↵"}, new String[]{"&lArr;", "&#8656;", "⇐"}, new String[]{"&uArr;", "&#8657;", "⇑"}, new String[]{"&rArr;", "&#8658;", "⇒"}, new String[]{"&dArr;", "&#8659;", "⇓"}, new String[]{"&hArr;", "&#8660;", "⇔"}, new String[]{"&forall;", "&#8704;", "∀"}, new String[]{"&part;", "&#8706;", "∂"}, new String[]{"&exist;", "&#8707;", "∃"}, new String[]{"&empty;", "&#8709;", "∅"}, new String[]{"&nabla;", "&#8711;", "∇"}, new String[]{"&isin;", "&#8712;", "∈"}, new String[]{"&notin;", "&#8713;", "∉"}, new String[]{"&ni;", "&#8715;", "∋"}, new String[]{"&prod;", "&#8719;", "∏"}, new String[]{"&sum;", "&#8721;", "∑"}, new String[]{"&minus;", "&#8722;", "−"}, new String[]{"&lowast;", "&#8727;", "∗"}, new String[]{"&radic;", "&#8730;", "√"}, new String[]{"&prop;", "&#8733;", "∝"}, new String[]{"&infin;", "&#8734;", "∞"}, new String[]{"&ang;", "&#8736;", "∠"}, new String[]{"&and;", "&#8743;", "∧"}, new String[]{"&or;", "&#8744;", "∨"}, new String[]{"&cap;", "&#8745;", "∩"}, new String[]{"&cup;", "&#8746;", "∪"}, new String[]{"&int;", "&#8747;", "∫"}, new String[]{"&there4;", "&#8756;", "∴"}, new String[]{"&sim;", "&#8764;", "∼"}, new String[]{"&cong;", "&#8773;", "≅"}, new String[]{"&asymp;", "&#8776;", "≈"}, new String[]{"&ne;", "&#8800;", "≠"}, new String[]{"&equiv;", "&#8801;", "≡"}, new String[]{"&le;", "&#8804;", "≤"}, new String[]{"&ge;", "&#8805;", "≥"}, new String[]{"&sub;", "&#8834;", "⊂"}, new String[]{"&sup;", "&#8835;", "⊃"}, new String[]{"&sube;", "&#8838;", "⊆"}, new String[]{"&supe;", "&#8839;", "⊇"}, new String[]{"&oplus;", "&#8853;", "⊕"}, new String[]{"&otimes;", "&#8855;", "⊗"}, new String[]{"&perp;", "&#8869;", "⊥"}, new String[]{"&sdot;", "&#8901;", "⋅"}, new String[]{"&lceil;", "&#8968;", "⌈"}, new String[]{"&rceil;", "&#8969;", "⌉"}, new String[]{"&lfloor;", "&#8970;", "⌊"}, new String[]{"&rfloor;", "&#8971;", "⌋"}, new String[]{"&lang;", "&#9001;", "〈"}, new String[]{"&rang;", "&#9002;", "〉"}, new String[]{"&loz;", "&#9674;", "◊"}, new String[]{"&spades;", "&#9824;", "♠"}, new String[]{"&clubs;", "&#9827;", "♣"}, new String[]{"&hearts;", "&#9829;", "♥"}, new String[]{"&diams;", "&#9830;", "♦"}, new String[]{"&quot;", "&#34;", "\""}, new String[]{"&amp;", "&#38;", "&"}, new String[]{"&lt;", "&#60;", "<"}, new String[]{"&gt;", "&#62;", ">"}, new String[]{"&OElig;", "&#338;", "Œ"}, new String[]{"&oelig;", "&#339;", "œ"}, new String[]{"&Scaron;", "&#352;", "Š"}, new String[]{"&scaron;", "&#353;", "š"}, new String[]{"&Yuml;", "&#376;", "Ÿ"}, new String[]{"&circ;", "&#710;", "ˆ"}, new String[]{"&tilde;", "&#732;", "˜"}, new String[]{"&ensp;", "&#8194;", "\u2002"}, new String[]{"&emsp;", "&#8195;", "\u2003"}, new String[]{"&thinsp;", "&#8201;", "\u2009"}, new String[]{"&zwnj;", "&#8204;", "\u200c"}, new String[]{"&zwj;", "&#8205;", "\u200d"}, new String[]{"&lrm;", "&#8206;", "\u200e"}, new String[]{"&rlm;", "&#8207;", "\u200f"}, new String[]{"&ndash;", "&#8211;", "–"}, new String[]{"&mdash;", "&#8212;", "—"}, new String[]{"&lsquo;", "&#8216;", "‘"}, new String[]{"&rsquo;", "&#8217;", "’"}, new String[]{"&sbquo;", "&#8218;", "‚"}, new String[]{"&ldquo;", "&#8220;", "“"}, new String[]{"&rdquo;", "&#8221;", "”"}, new String[]{"&bdquo;", "&#8222;", "„"}, new String[]{"&dagger;", "&#8224;", "†"}, new String[]{"&Dagger;", "&#8225;", "‡"}, new String[]{"&permil;", "&#8240;", "‰"}, new String[]{"&lsaquo;", "&#8249;", "‹"}, new String[]{"&rsaquo;", "&#8250;", "›"}, new String[]{"&euro;", "&#8364;", "€"}};
        for (int i = 0; i < 251; i++) {
            String[] strArr2 = strArr[i];
            entityEscapeMap.put(strArr2[2], strArr2[0]);
            Map<String, String> map = escapeEntityMap;
            map.put(strArr2[0], strArr2[2]);
            map.put(strArr2[1], strArr2[2]);
        }
    }

    public static void unescape(StringBuilder sb) {
        int iIndexOf;
        int iIndexOf2;
        int i = 0;
        while (i < sb.length() && -1 != (iIndexOf = sb.indexOf("&", i)) && -1 != (iIndexOf2 = sb.indexOf(";", iIndexOf))) {
            int i2 = iIndexOf2 + 1;
            String str = escapeEntityMap.get(sb.substring(iIndexOf, i2));
            if (str != null) {
                sb.replace(iIndexOf, i2, str);
            }
            i = iIndexOf + 1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String unescapeAndSlideEntityIncdices(String str, UserMentionEntity[] userMentionEntityArr, URLEntity[] uRLEntityArr, HashtagEntity[] hashtagEntityArr, MediaEntity[] mediaEntityArr) {
        int length;
        int iIndexOf;
        int length2;
        String strSubstring;
        String str2;
        int length3 = (userMentionEntityArr == null ? 0 : userMentionEntityArr.length) + (uRLEntityArr == null ? 0 : uRLEntityArr.length) + (hashtagEntityArr == null ? 0 : hashtagEntityArr.length) + (mediaEntityArr == null ? 0 : mediaEntityArr.length);
        EntityIndex[] entityIndexArr = new EntityIndex[length3];
        if (userMentionEntityArr != null) {
            System.arraycopy(userMentionEntityArr, 0, entityIndexArr, 0, userMentionEntityArr.length);
            length = userMentionEntityArr.length;
        } else {
            length = 0;
        }
        if (uRLEntityArr != null) {
            System.arraycopy(uRLEntityArr, 0, entityIndexArr, length, uRLEntityArr.length);
            length += uRLEntityArr.length;
        }
        if (hashtagEntityArr != null) {
            System.arraycopy(hashtagEntityArr, 0, entityIndexArr, length, hashtagEntityArr.length);
            length += hashtagEntityArr.length;
        }
        if (mediaEntityArr != null) {
            System.arraycopy(mediaEntityArr, 0, entityIndexArr, length, mediaEntityArr.length);
        }
        Arrays.sort(entityIndexArr);
        StringBuilder sb = new StringBuilder(str.length());
        int iCodePointCount = str.codePointCount(0, str.length());
        boolean z = true;
        int iCharCount = 0;
        int i = 0;
        int iCodePointCount2 = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt != 38 || -1 == (iIndexOf = str.indexOf(";", iCharCount)) || (str2 = escapeEntityMap.get((strSubstring = str.substring(iCharCount, iIndexOf + 1)))) == null) {
                sb.appendCodePoint(iCodePointAt);
                iIndexOf = iCharCount;
                length2 = 0;
                if (i < length3) {
                    if (z) {
                        if (entityIndexArr[i].getStart() == length2 + iCodePointCount2) {
                            entityIndexArr[i].setStart(sb.length() - Character.charCount(str.codePointAt(iIndexOf)));
                            z = false;
                        }
                    } else if (entityIndexArr[i].getEnd() == length2 + iCodePointCount2) {
                        entityIndexArr[i].setEnd(sb.length() - Character.charCount(str.codePointAt(iIndexOf)));
                        i++;
                        z = true;
                    }
                }
                iCharCount = Character.charCount(iCodePointAt) + iIndexOf;
                iCodePointCount2++;
            } else {
                sb.append(str2);
                iCodePointCount2 = str.codePointCount(0, iIndexOf);
                length2 = 1 - strSubstring.length();
                if (i < length3) {
                }
                iCharCount = Character.charCount(iCodePointAt) + iIndexOf;
                iCodePointCount2++;
            }
        }
        if (i < length3 && entityIndexArr[i].getEnd() == iCodePointCount) {
            entityIndexArr[i].setEnd(sb.length());
        }
        return sb.toString();
    }

    public static String unescape(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(str);
        unescape(sb);
        return sb.toString();
    }
}
