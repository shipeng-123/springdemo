package com.example.heimajava;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class crawl {
    public static void main(String[] args) throws IOException {


        String url1 = " https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&from=kg0";
        String url12 = " http://www.haoming8.cn/baobao/10881.html";
        String url13 = " http://www.haoming8.cn/baobao/7641.html";
        String familystr = webCrawler(url1);
        String boynamestr = webCrawler(url12);
        String girlNamestr = webCrawler(url13);
        ArrayList<String> familyTempList = getData(familystr, "(.{4})(，)(.{4})(。)",0);
        ArrayList<String> boyNameTempList=  getData(boynamestr,  "([\u4e00-\u9fa5·]{2})(、|。)",1);
        ArrayList<String> girlNameTempList=  getData(girlNamestr,  "([\u4e00-\u9fa5·]{2} ){4}..",0);
        System.out.println(girlNameTempList);
        System.out.println(familyTempList);
        System.out.println(boyNameTempList);
//        for (String s : familyTempList) {
//            for (int i = 0; i < s.length(); i++) {
//                System.out.println(s.charAt(i));
//            }
//        }
        ArrayList<String> boyNameList = new ArrayList<>();
//        HashSet<String > boyname
    }

    private static ArrayList<String> getData(String familystr, String regex,int inedx) {
        ArrayList<String> list = new ArrayList<>();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(familystr);
        while(matcher.find()){
            String group = matcher.group(inedx);
            list.add(group);
        }
        return list;
    }

    public static String webCrawler(String net) throws IOException {
        StringBuilder sb = new StringBuilder();
        URL url = new URL(net);
        URLConnection connection = url.openConnection();
        InputStreamReader ips = new InputStreamReader(connection.getInputStream());
        int b;
        while ((b = ips.read()) != -1) {
            sb.append((char) b);
        }
        ips.close();
        return sb.toString();
    }
}
