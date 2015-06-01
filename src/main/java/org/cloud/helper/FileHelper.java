package org.cloud.helper;


import com.alibaba.fastjson.JSON;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class FileHelper {

    public static String fileData(String path) {
        //�����ܵ����ݽṹ
        Map<String, Map<String, List<String>>> mapFiles = new TreeMap<String, Map<String, List<String>>>();
        //�ļ�·��
        File folder = new File(path);
        File[] files = folder.listFiles();
        //���ָ�ʽ�����ڷ�ʽ�Ա�õ�year day
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdfDay = new SimpleDateFormat("MMdd");
        //�����ļ�����
        for (int i = 0; i < files.length; i++) {

            File f = files[i];
            //�õ��ļ���year & day
            String year = sdfYear.format(f.lastModified());
            String day = sdfDay.format(f.lastModified());
            Map<String, List<String>> yearMap = mapFiles.get(year);
            List<String> fileList = null;
            if (yearMap == null) {
                yearMap = new TreeMap<String, List<String>>();
            }

            fileList = yearMap.get(day);
            if (fileList == null) {
                fileList = new ArrayList<String>();
            }
            //���μ����ϲ�Ľṹ��ȥ
            yearMap.put(day, fileList);
            mapFiles.put(year, yearMap);
            fileList.add(f.getName());
        }
        //fastjson
        String str = JSON.toJSONString(mapFiles);
        return str;
    }
}