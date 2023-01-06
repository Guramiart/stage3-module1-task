package com.mjc.school.util;

import com.mjc.school.constants.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;
import java.util.Random;

public class Utils {

    private Utils() {}

    public static String getRandomData(String filename) {
        String randomData = "";
        try(BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(Objects.requireNonNull(
                        Thread.currentThread().getContextClassLoader().getResourceAsStream(filename)))
        )) {
            int counter = 0;
            int randomLineNum = new Random().nextInt(Constants.LINE_LIMIT);
            while ((randomData = bufferedReader.readLine()) != null && counter != randomLineNum) {
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return randomData;
    }

    public static LocalDateTime getRandomDate() {
        Random random = new Random();
        LocalDate day = LocalDate.now().minusDays(random.nextInt(Constants.DAY_SHIFT));
        LocalTime time = LocalTime.of(
                random.nextInt(Constants.HOUR_LIMIT),
                random.nextInt(Constants.MINUTE_LIMIT),
                random.nextInt(Constants.SECOND_LIMIT));
        return LocalDateTime.of(day, time);
    }
}
