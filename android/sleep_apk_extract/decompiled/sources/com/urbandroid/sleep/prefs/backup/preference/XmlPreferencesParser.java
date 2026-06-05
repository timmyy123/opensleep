package com.urbandroid.sleep.prefs.backup.preference;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.SharedPreferences;
import com.urbandroid.common.logging.Logger;
import java.io.IOException;
import java.io.Reader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: loaded from: classes4.dex */
public class XmlPreferencesParser {
    public void importPrefs(Reader reader, SharedPreferences sharedPreferences) throws XmlPullParserException, IOException {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(reader);
        String attributeValue = null;
        String text = null;
        for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
            if (eventType == 2) {
                String attributeValue2 = xmlPullParserNewPullParser.getAttributeCount() > 0 ? xmlPullParserNewPullParser.getAttributeValue(0) : null;
                if (xmlPullParserNewPullParser.getAttributeCount() > 1) {
                    StringBuilder sbM5m = FileInsert$$ExternalSyntheticOutline0.m5m("Export: restoring key '", attributeValue2, "' = '");
                    sbM5m.append(xmlPullParserNewPullParser.getAttributeValue(1));
                    sbM5m.append("'");
                    Logger.logInfo(sbM5m.toString());
                }
                String name = xmlPullParserNewPullParser.getName();
                if ("boolean".equals(name)) {
                    editorEdit.putBoolean(attributeValue2, Boolean.parseBoolean(xmlPullParserNewPullParser.getAttributeValue(1)));
                } else if ("int".equals(name)) {
                    editorEdit.putInt(attributeValue2, Integer.parseInt(xmlPullParserNewPullParser.getAttributeValue(1)));
                } else if ("float".equals(name)) {
                    editorEdit.putFloat(attributeValue2, Float.parseFloat(xmlPullParserNewPullParser.getAttributeValue(1)));
                } else if ("long".equals(name)) {
                    editorEdit.putLong(attributeValue2, Long.parseLong(xmlPullParserNewPullParser.getAttributeValue(1)));
                } else if ("string".equals(name)) {
                    attributeValue = xmlPullParserNewPullParser.getAttributeValue(0);
                }
            } else if (eventType == 3) {
                if ("string".equals(xmlPullParserNewPullParser.getName())) {
                    Logger.logInfo("IMPORT: Prefs '" + attributeValue + "' '" + text + "'");
                    editorEdit.putString(attributeValue, text);
                }
            } else if (eventType == 4) {
                text = xmlPullParserNewPullParser.getText();
            }
        }
        editorEdit.commit();
        Logger.logInfo("IMPORT: Prefs commmit ");
    }
}
