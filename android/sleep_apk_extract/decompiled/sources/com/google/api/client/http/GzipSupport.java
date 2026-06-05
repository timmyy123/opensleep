package com.google.api.client.http;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

/* JADX INFO: loaded from: classes4.dex */
abstract class GzipSupport {
    public static GZIPInputStream newGzipInputStream(InputStream inputStream) {
        return new GZIPInputStream(new OptimisticAvailabilityInputStream(inputStream));
    }

    public static final class OptimisticAvailabilityInputStream extends FilterInputStream {
        private int lastRead;

        public OptimisticAvailabilityInputStream(InputStream inputStream) {
            super(inputStream);
            this.lastRead = 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() {
            return this.lastRead > -1 ? Integer.MAX_VALUE : 0;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int i = super.read();
            this.lastRead = i;
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            int i = super.read(bArr);
            this.lastRead = i;
            return i;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = super.read(bArr, i, i2);
            this.lastRead = i3;
            return i3;
        }
    }
}
