package com.example.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {

    // *******************************************************************
    // Basic File method
    // *******************************************************************
    /**
     * getPath_Terminal
     * @return - Environment.getExternalStorageDirectory().getPath()
     */
    public static String getPath_Terminal() {
        String path = Environment.getExternalStorageDirectory().getPath();
        return path;
    }

    /**
     * getPath_CacheDir
     * @param  - context
     * @param cacheDirName
     * @return context.getCacheDir().getPath()
     */
    public static String getPath_CacheDir(Context con, String cacheDirName) {
        File file = new File(con.getCacheDir(), cacheDirName);
        if (file.exists() == false) {
            return "";
        } else {
            String path = file.getPath();
            return path;
        }
    }

    /**
     * Directory All Delete
     * file path sample {@code Environment.getExternalStorageDirectory() + "/folderName"}
     * failed example {@code "file:/" + Environment.getExternalStorageDirectory() + "/folderName"}
     * @param file
     */
    public static void deleteFolder(File file) {
        if (file.exists() == false) {
            return;
        }
        if (file.isFile()) {
            file.delete();
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                deleteFolder(files[i]);
            }
            file.delete();
        }
    }


    // *******************************************************************
    // SD Card
    // *******************************************************************
    /**
     * getSDpath
     *
     * @return - return SDpath
     */
    @TargetApi(9)
    public static String getPath_SD() {
        List<String> mountList = new ArrayList<String>();
        String mount_sdcard = null;
        Scanner scanner = null;
        try {
            File vold_fstab = new File("/system/etc/vold.fstab");
            scanner = new Scanner(new FileInputStream(vold_fstab));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("dev_mount") || line.startsWith("fuse_mount")) {
                    String path = line.replaceAll("\t", " ").split(" ")[2];
                    if (!mountList.contains(path)) {
                        mountList.add(path);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if (!Environment.isExternalStorageRemovable()) {
                mountList.remove(Environment.getExternalStorageDirectory().getPath());
            }
        }
        for (int i = 0; i < mountList.size(); i++) {
            if (!isMounted(mountList.get(i))) {
                mountList.remove(i--);
            }
        }
        if (mountList.size() > 0) {
            mount_sdcard = mountList.get(0);
        }
        return mount_sdcard;
    }

    /**
     * path Mounted check
     *
     * @return path
     */
    private static boolean isMounted(String path) {
        boolean isMounted = false;
        Scanner scanner = null;
        try {
            File mounts = new File("/proc/mounts");
            scanner = new Scanner(new FileInputStream(mounts));
            while (scanner.hasNextLine()) {
                if (scanner.nextLine().contains(path)) {
                    isMounted = true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return isMounted;
    }

    /**
     * AddList<E> -
     */
    public void doAddList() {}

    /**
     * Get cellphon's allImage
     * @param contextWrapper
     */
    public void getAllImage(ContextWrapper contextWrapper) {
        Uri imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = contextWrapper.getContentResolver().query(imageUri, null, null, null, null);
        cursor.moveToFirst();
        String[] path = new String[cursor.getCount()];
        for (int i = 0; i < path.length; i++) {
            path[i] = cursor.getString(1);
//            doAddList();
//            Constants.DCIM_LIST.add(new ImageData("file:/" + cursor.getString(1), id, false, "camera"));
            cursor.moveToNext();
        }
        cursor.close();
    }
}
