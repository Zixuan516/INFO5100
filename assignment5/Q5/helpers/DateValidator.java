package assignment5.Q5.helpers;

public final class DateValidator {

    private DateValidator() {}

    public static void validateDate(int month, int day, int year) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException(String.format("Month %d is invalid.", month));
        }

        if (day < 1 || day > 31) {
            throw new IllegalArgumentException(String.format("Day %d is invalid.", day));
        }

        if (year < 1000 || year > 9999) {
            throw new IllegalArgumentException(String.format("Year %d is invalid.", year));
        }
    }
}
