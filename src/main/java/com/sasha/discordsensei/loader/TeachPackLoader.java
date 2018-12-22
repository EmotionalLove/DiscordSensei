package com.sasha.discordsensei.loader;

import com.sasha.discordsensei.Main;
import com.sasha.discordsensei.interpreter.ActivityInterpreter;
import com.sasha.discordsensei.teach.TeacherActivityContainer;

import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by Sasha at 3:23 PM on 12/21/2018
 */
public class TeachPackLoader {

    @SuppressWarnings({"ResultOfMethodCallIgnored", "ConstantConditions"})
    public void discoverPacks(String dir) throws IOException {
        File dirf = new File(dir);
        File tmp = new File("tmp_" + dir);
        Runtime.getRuntime().addShutdownHook(new Thread(tmp::delete));
        if (dirf.exists()) {
            dirf.delete();
        }
        dirf.mkdir();
        for (File file : dirf.listFiles()) {
            if (file.isDirectory()) continue;
            if (file.getName().endsWith(".zip")) {
                unzip(file, tmp);
                System.out.println("Discovered " + file.getName());
            }
        }
    }
    
    public void loadPacks() {
        File dir = new File("tmp_" + Main.config.teachingpacksDir);
        if (!dir.exists()) return;
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                System.out.println("Reading " + file.getName());
                File f = new File(file, "info.tpk");
                if (!f.exists()) continue;
                String[] info;
                try {
                    info = readInfo(f);
                } catch (IOException e) {
                    e.printStackTrace();
                    continue;
                }
                TeacherActivityContainer container = new TeacherActivityContainer(info[0], info[1]);
                for (File listFile : file.listFiles()) {
                    if (listFile.isDirectory() || !listFile.getName().endsWith(".txt")) {
                        continue;
                    }
                    try {
                        ArrayList<String> lines = new ArrayList<>();
                        String l;
                        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(listFile)));
                        while ((l = reader.readLine()) != null) {
                            lines.add(l);
                        }
                        new ActivityInterpreter(lines, container).interpret();
                    }catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                Main.loadedContainers.add(container);
            }
        }
    }

    public String[] readInfo(File file) throws IOException {
        FileInputStream stream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(stream);
        BufferedReader buff = new BufferedReader(reader);
        return buff.readLine().split(":");
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
        zipStream.closeEntry();
        zipStream.close();
        stream.close();
    }

}
