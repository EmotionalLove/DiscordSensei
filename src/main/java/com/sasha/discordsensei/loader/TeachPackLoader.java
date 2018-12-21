package com.sasha.discordsensei.loader;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/**
 * Created by Sasha at 3:23 PM on 12/21/2018
 */
public class TeachPackLoader {

    @SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
    public void discoverPacks(String dir) throws IOException {
        File dirf = new File(dir);
        File tmp = new File("tmp_" + dir);
        if (dirf.exists()) {
            dirf.delete();
        }
        dirf.mkdir();
        for (File file : dirf.listFiles()) {
            if (file.isDirectory()) continue;
            if (file.getName().endsWith(".zip")) {
                unzip(file, tmp);
            }
        }
    }

    private void unzip(File zip, File extdir) throws IOException {
        byte[] buff = new byte[1024];
        File dir = new File(extdir, zip.getName().replace(".zip", ""));
        if (dir.exists()) dir.delete();
        dir.mkdir();
        FileInputStream stream = new FileInputStream(zip);
        ZipInputStream zipStream = new ZipInputStream(stream);
        ZipEntry entry;
        while ((entry = zipStream.getNextEntry()) != null) {
            File newFile = new File(dir + File.separator + entry.getName());
            new File(newFile.getParent()).mkdirs();
            FileOutputStream fos = new FileOutputStream(newFile);
            int len;
            while ((len = zipStream.read(buff)) > 0) {
                fos.write(buff, 0, len);
            }
            fos.close();
            zipStream.closeEntry();
        }
        zipStream.close();
        stream.close();
    }

}
