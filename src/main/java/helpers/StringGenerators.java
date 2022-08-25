package helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class StringGenerators {

    public String generateRandomEmail() {
        String randomEmail;
        String generatedString = RandomStringUtils.randomAlphanumeric(10);
        randomEmail = generatedString + "@gmail.com";
        return randomEmail;
    }
}
