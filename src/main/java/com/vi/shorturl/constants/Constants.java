package com.vi.shorturl.constants;
/*
 * This is confidential material created by myself
 *
 * @author varuzhan iritsyan
 * @version 1.0: $
 * @since x.y
 */

import com.vi.shorturl.util.Utils;

import java.util.HashMap;
import java.util.Random;

public interface Constants {
    public static final String NEW_DOMAIN = "www.miele.de";
    public static int urlKeyLength=8;
    public  Random myRand = new Random();
    // generatedKey to originUrl Map
    public HashMap<String, String> generatedKey2originUrlMap = new HashMap<String, String>();;
    // originUrl to generatedKey  Map
    public HashMap<String, String> originUrl2generatedKeyMap = new HashMap<String, String>();;
    //
    public char myChars[]= Utils.buildCharsFromInt();


}
