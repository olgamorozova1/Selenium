package org.issoft.automation.page.FinalTask.Utils;

import org.apache.commons.text.RandomStringGenerator;

import java.util.Random;

public class EmailAndPasswordGenerator {
    public static String generateEmailAddress() {
        Random randomInt = new Random();
        String emailAddress = "TestEmail" + randomInt.nextInt() + "@mail.com";
        return emailAddress;
    }

    public static String generatePassword() {
        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
                .selectFrom(chars.toCharArray())
                .build();
        return randomStringGenerator.generate(8);
    }
}
