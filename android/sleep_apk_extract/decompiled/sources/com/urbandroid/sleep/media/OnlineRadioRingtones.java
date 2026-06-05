package com.urbandroid.sleep.media;

import adamb.util.FileInsert$$ExternalSyntheticOutline0;
import android.content.Context;
import android.os.AsyncTask;
import com.urbandroid.common.connectivity.WaitForConnectivityService;
import com.urbandroid.common.logging.Logger;
import com.urbandroid.sleep.service.Settings;
import com.urbandroid.sleep.service.SharedApplicationContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class OnlineRadioRingtones {

    public static class Radio {
        public String genre;
        public String title;
        public String url;

        public Radio(String str, String str2, String str3) {
            this.title = str;
            this.genre = str2;
            this.url = str3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && getClass() == obj.getClass()) {
                String str = this.url;
                String str2 = ((Radio) obj).url;
                if (str == null ? str2 == null : str.equals(str2)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            String str = this.url;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("Radio{title='");
            sb.append(this.title);
            sb.append("', genre='");
            sb.append(this.genre);
            sb.append("', url='");
            return FileInsert$$ExternalSyntheticOutline0.m(sb, this.url, "'}");
        }
    }

    public static class RadioListResult {
        List<Radio> radios;
        boolean wasUpdated;

        public RadioListResult(List<Radio> list, boolean z) {
            this.radios = list;
            this.wasUpdated = z;
        }
    }

    private List<Radio> getRadiosFromInputStream(BufferedReader bufferedReader) {
        try {
            ArrayList arrayList = new ArrayList();
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    String[] strArrSplit = line.split("\\;");
                    if (strArrSplit.length != 3) {
                        Logger.logWarning("Radio: unparsable line " + line);
                    } else {
                        arrayList.add(new Radio(strArrSplit[0], strArrSplit[1], strArrSplit[2]));
                        Logger.logInfo("Radio: slip " + strArrSplit[0] + " " + strArrSplit[1] + " " + strArrSplit[2]);
                    }
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            bufferedReader.close();
            return arrayList;
        } catch (Throwable th) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static void syncRadiosIfRequired(Context context) {
        if (new Settings(context).isTimeForAction("radio", 259200000L)) {
            Logger.logInfo("Radio: syncing after X days");
            new AsyncTask<Void, Void, Void>() { // from class: com.urbandroid.sleep.media.OnlineRadioRingtones.1
                @Override // android.os.AsyncTask
                public Void doInBackground(Void... voidArr) {
                    try {
                        new OnlineRadioRingtones().getRadiosFromNet();
                        return null;
                    } catch (IOException e) {
                        Logger.logSevere("Radio: cannot sync ", e);
                        return null;
                    }
                }
            }.execute(new Void[0]);
        }
    }

    public List<Radio> getRadios(boolean z) {
        Settings settings = SharedApplicationContext.getSettings();
        ArrayList arrayList = new ArrayList(settings.getOnlineRadios("key_online_radios"));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Logger.logInfo("Radio " + ((Radio) it.next()));
        }
        if (z || !WaitForConnectivityService.isRequiredNetworkAvailable(SharedApplicationContext.getInstance().getContext())) {
            if (!z) {
                Logger.logWarning("No connectivity");
            }
            arrayList.addAll(settings.getOnlineRadios("key_online_radios_featured"));
            if (arrayList.size() == 0) {
                Logger.logInfo("Radio: getting from offline list ");
                try {
                    arrayList.addAll(getRadiosFromInputStream(new BufferedReader(new StringReader("Ancient FM;Classic;https://mediaserv73.live-streams.nl:18058/stream\nBagel Rock;Alternative Rock;http://ais-sa3.cdnstream1.com/2606_128.mp3\nBeat Blender;Downtempo;http://ice1.somafm.com/beatblender-128-mp3\nChillout Lounge;Chillout;http://strm112.1.fm/chilloutlounge_mobile_mp3\nCovers;Pop;http://ice1.somafm.com/covers-128-mp3\nFolk Forward;Folk;http://ice1.somafm.com/folkfwd-128-mp3\nGroove Salad;Ambient;http://ice1.somafm.com/groovesalad-128-mp3\nIllinois Street Lounge;Lounge;http://ice1.somafm.com/illstreet-128-mp3\nLush;Electronic;http://ice1.somafm.com/lush-128-mp3\nSonic Universe;Electro Jazz;http://ice1.somafm.com/sonicuniverse-128-mp3\nSpace Station;Electronic;http://ice1.somafm.com/spacestation-128-mp3\nSleeping Pill;Ambient;https://radio.stereoscenic.com/asp-s\nUnderground 80s;Alternative Pop;http://ice1.somafm.com/u80s-128-mp3\n"))));
                    return arrayList;
                } catch (IOException e) {
                    Logger.logSevere(e);
                }
            }
        } else {
            try {
                arrayList.addAll(getRadiosFromNet().radios);
                return arrayList;
            } catch (Exception e2) {
                Logger.logSevere(e2);
                arrayList.addAll(settings.getOnlineRadios("key_online_radios_featured"));
            }
        }
        return arrayList;
    }

    public RadioListResult getRadiosFromNet() {
        boolean z;
        boolean z2;
        InputStream inputStream = null;
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Settings settings = SharedApplicationContext.getSettings();
            Logger.logInfo("Online radios: getting from https://sleep-cloud.appspot.com/radio.txt");
            URLConnection uRLConnectionOpenConnection = new URL("http://sleep.urbandroid.org/radio/radio.txt").openConnection();
            uRLConnectionOpenConnection.setReadTimeout(4000);
            uRLConnectionOpenConnection.setConnectTimeout(8000);
            inputStream = uRLConnectionOpenConnection.getInputStream();
            List<Radio> radiosFromInputStream = getRadiosFromInputStream(new BufferedReader(new InputStreamReader(inputStream)));
            ArrayList<Radio> arrayList = new ArrayList();
            List<Radio> onlineRadios = settings.getOnlineRadios("key_online_radios_featured");
            Iterator<Radio> it = radiosFromInputStream.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                if (!onlineRadios.contains(it.next())) {
                    z2 = true;
                    break;
                }
            }
            Iterator<Radio> it2 = onlineRadios.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z = z2;
                    break;
                }
                if (!radiosFromInputStream.contains(it2.next())) {
                    break;
                }
            }
            arrayList.addAll(radiosFromInputStream);
            if (z || onlineRadios.size() != arrayList.size()) {
                settings.removeAllOnlineRadios("key_online_radios_featured");
                for (Radio radio : arrayList) {
                    settings.addOnlineRadio(radio.title, radio.url, "key_online_radios_featured");
                }
            }
            Logger.logInfo("OnlineRadioRingtones: loading took " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms   changeFound: " + z);
            RadioListResult radioListResult = new RadioListResult(arrayList, z);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return radioListResult;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public List<Radio> getRadios() {
        return getRadios(false);
    }
}
