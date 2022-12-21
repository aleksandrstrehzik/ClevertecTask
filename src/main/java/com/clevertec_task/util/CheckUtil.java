package com.clevertec_task.util;

public class CheckUtil {

    public static int[] getIdArray(String[] d) {
        int num = CheckUtil.getItemNumber(d);
        int[] id = new int[num];
        for (int i = 0; i < num; i++) {
            String[] split = d[i].split("-");
            int first = Integer.parseInt(split[0]);
            id[i] = first;
        }
        return id;
    }

    public static int[] getNumArray(String[] d) {
        int num = CheckUtil.getItemNumber(d);
        int[] number = new int[num];
        for (int i = 0; i < num; i++) {
            String[] split = d[i].split("-");
            int first = Integer.parseInt(split[1]);
            number[i] = first;
        }
        return number;
    }

    public static String getDiscountCard(String[] b) {
        return  b[b.length - 1];
    }

    private static int getItemNumber(String[] d) {
        if (Character.isDigit((d[d.length - 1]).charAt(0)))
            return d.length;
        else return d.length - 1;
    }

    public static boolean IsCardPresent(String[] b) {
        return b[b.length - 1].startsWith("Card");
    }
}
