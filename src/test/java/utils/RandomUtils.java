package utils;

import com.github.javafaker.Faker;

import java.time.Month;
import java.util.Date;
import java.util.Random;

public class RandomUtils {

    private static Faker faker = new Faker();

    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getEmail() {
        return faker.internet().emailAddress();
    }

    public static String getGender() {
        return getRandomItemFromArray(new String[] {"Male", "Female", "Other"});
    }

    public static String getNumber() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String getDayOfBirthDate() {
        return Integer.toString(getRandomInt(1, 28));
    }

    public static String getMonthOfBirthDate() {
        String month = Month.of(getRandomInt(1, 12)).name();

        return month.charAt(0) + month.substring(1).toLowerCase();
    }

    public static String getYearOfBirthDate() {
        return Integer.toString(getRandomInt(1900, 2010));
    }

    public static String getSubject() {
        return getRandomItemFromArray(new String[] {"Maths", "Chemistry", "Commerce", "Economics", "English"});
    }

    public static String getHobby() {
        return getRandomItemFromArray(new String[] {"Sports", "Reading", "Music"});
    }

    public static String getPicture() {
        return "smile.png";
    }

    public static String getAddress() {
        return faker.address().fullAddress();
    }

    public static String getState() {
        return getRandomItemFromArray(new String[] {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"});
    }

    public static String getCity(String state) {
        return switch (state) {
            case "NCR" -> getRandomItemFromArray(new String[] {"Delhi", "Gurgaon", "Noida"});
            case "Uttar Pradesh" -> getRandomItemFromArray(new String[] {"Agra", "Lucknow", "Merrut"});
            case "Haryana" -> getRandomItemFromArray(new String[] {"Panipat", "Karnal"});
            case "Rajasthan" -> getRandomItemFromArray(new String[] {"Jaipur", "Jaisalmer"});
            default -> throw new IllegalArgumentException("Invalid state");
        };
    }

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt(min, max);
    }

    public static String getRandomItemFromArray(String[] array) {
        return array[getRandomInt(0, array.length - 1)];
    }
}
