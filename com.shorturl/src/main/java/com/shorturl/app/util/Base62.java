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
	
	
}
