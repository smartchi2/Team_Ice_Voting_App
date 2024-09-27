package org.voting_app.voting_app.util;

import java.time.Year;

public class RegistrationNumber {

    public static String generateUserRegistrationNumber() {

        Year currentYear = Year.now();
        int minDigits = 100;
        int maxDigits = 5000;

        int randomNumber = (int) Math.floor(Math.random() + (maxDigits - minDigits + 1) + minDigits);
        String year = String.valueOf(currentYear);
        String number = String.valueOf(randomNumber);
        return year + number;
    }
}

