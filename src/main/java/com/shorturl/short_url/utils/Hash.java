package com.shorturl.short_url.utils;

public class Hash {

    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();


    public static String coded(long value) {
        if (value == 0) {
            return String.valueOf(ALPHABET.charAt(0));
        }

        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            int remainder = (int) (value % BASE);
            sb.append(ALPHABET.charAt(remainder));
            value /= BASE;
        }

        return sb.reverse().toString();
    }


    public static long decoded(String str) {
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int value = ALPHABET.indexOf(c);
            result = result * BASE + value;
        }
        return result;
    }


}
