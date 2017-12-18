package com.tel_ran;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        File file1 = new File("box/1.txt");
        File file2 = new File("resourses/pass.txt");
        FileWriter fw = null;

        fw = new FileWriter(file1, true);
        fw.write(br.readLine());
        fw.close();

        List<String> list1 = getFileContent(file1);
        List<String> list2 = getFileContent(file2);

        System.out.println(compareTwoFiles(list1, list2));
    }


    private static boolean compareTwoFiles(List<String> list1, List<String> list2) {
        for (String str1 : list1) {
            for(String str2 : list2){
                if(list1.equals(list2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<String> getFileContent(File file) {
        BufferedReader br = null;
        List<String> result = new LinkedList<String>();
        String str;
        try {
            br = new BufferedReader(new FileReader(file));

            try {
                while ((str = br.readLine()) != null) {
                    result.add(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}
