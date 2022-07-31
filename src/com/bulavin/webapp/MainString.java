package com.bulavin.webapp;

public class MainString {

    public static void main(String[] args) {
        String[] strArr = new String[]{"1", "2", "3", "4", "5"};
        StringBuilder sb = new StringBuilder();

        for (String str : strArr) {
            sb.append(str).append(", ");
        }
        System.out.println(sb.toString());

        String str1 = "abc";
        String str2 = "c";
        String str3 = ("ab" + str2).intern();
        System.out.println(str1 == str3);
    }
}
