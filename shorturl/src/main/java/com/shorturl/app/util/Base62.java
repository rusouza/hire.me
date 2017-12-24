package com.shorturl.app.util;

public class Base62 {
	
	public static final String ALFABETO = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	public static final int BASE62 = ALFABETO.length();
	
	public static String paraBase62(long value) {
        final StringBuilder sb = new StringBuilder(1);
        do {
            sb.insert(0, ALFABETO.charAt((int) (value % BASE62)));
            value /= BASE62;
        } while (value > 0);
        return sb.toString();
    }
	
	public static long paraBase10(String str) {
		return paraBase10(new StringBuilder(str).reverse().toString().toCharArray());
	}
	
	private static long paraBase10(char[] chars) {
		long result = 0;
		for (int i = chars.length - 1; i >= 0; i--) {
			result += paraBase10(ALFABETO.indexOf(chars[i]), i);
		}
		return result;
	}
	
	private static long paraBase10(long result, int pow) {
		return result * (int) Math.pow(BASE62, pow);
	}
}