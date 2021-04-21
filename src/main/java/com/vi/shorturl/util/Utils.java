package com.vi.shorturl.util;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.constants.Constants;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {

    /**
     * Buils array of letters and numbers
     */
    public static char[] buildCharsFromInt() {
        // build Integer list from 0 to 62
        List<Integer> numeric = new ArrayList<>();
        for(int k=0; k<62; k++) {
            numeric.add(k);
        }

        Map<Integer, Character> firstGroupChars = new HashMap();
        Map<Integer, Character> secondGroupChars = new HashMap();
        Map<Integer, Character> thirdGroupChars = new HashMap();

        firstGroupChars = numeric.stream().filter(n -> n.intValue() < 10).collect(Collectors.toMap(n -> n, n -> (char)(n+48)) );
        secondGroupChars = numeric.stream().filter(n -> n.intValue() > 9 && n.intValue() <= 35).collect(Collectors.toMap(n -> n, n -> (char)(n+55)) );
        thirdGroupChars = numeric.stream().filter(n -> n.intValue() >36).collect(Collectors.toMap(n -> n, n -> (char)(n+61)) );
        firstGroupChars.putAll(secondGroupChars);
        firstGroupChars.putAll(thirdGroupChars);

        firstGroupChars.values().stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
        firstGroupChars.values().stream().map(String::valueOf).collect(Collectors.joining());
        firstGroupChars.values().stream().map(String::valueOf);

        return firstGroupChars.values().stream().map(String::valueOf).collect(Collectors.joining()).toCharArray();
    }

    /**
     * This method should take care various issues with a valid url
     * e.g. www.google.com, or with http(s) http://www.google.com.
     * All the above URL should point to same shortened URL
     *
     * @return cleard URL
     */
    public static String clearingURL(String url) {
        if (url.substring(0, 7).equals("http://"))
            url = url.substring(7);

        if (url.substring(0, 8).equals("https://"))
            url = url.substring(8);

        if (url.charAt(url.length() - 1) == '/')
            url = url.substring(0, url.length() - 1);
        return url;
    }


    /**
     *
     * @return generated key
     */
    public static String generateKey() {
        String key = "";
        boolean flag = true;
        while (flag) {
            key = "";
            for (int i = 0; i <= Constants.urlKeyLength; i++) {
                key += Constants.myChars[Constants.myRand.nextInt(62)];
            }
            if (!Constants.generatedKey2originUrlMap.containsKey(key)) {
                flag = false;
            }
        }
        return key;
    }

}
