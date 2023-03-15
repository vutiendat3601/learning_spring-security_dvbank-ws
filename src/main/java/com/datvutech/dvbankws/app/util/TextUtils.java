package com.datvutech.dvbankws.app.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class TextUtils {
    private Random random = new Random();

    public String genRandomTextNumber(long biggerThan, long smallerThan) {
        String result = "" + (random.nextLong(smallerThan - biggerThan - 1) + biggerThan + 1);
        return result;
    }

}
