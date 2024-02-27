package util;

public class ValidateData {
    public static void validateData(String surname, String firstName, String middleName, String birthDate,
                                    String phoneNumber, String gender) throws InvalidDataException {

        if (surname.isEmpty() || firstName.isEmpty() || middleName.isEmpty() || birthDate.isEmpty()
                || phoneNumber.isEmpty() || gender.isEmpty()) {
            throw new InvalidDataException("Некоторые данные отсутствуют");
        }

        if (!birthDate.matches("\\d{2}.\\d{2}.\\d{4}")) {
            throw new InvalidDataException("Неверный формат даты рождения");
        }

        try {
            Long.parseLong(phoneNumber);
        } catch (NumberFormatException e) {
            throw new InvalidDataException("Неверный формат номера телефона");
        }

        if (!gender.equalsIgnoreCase("f") && !gender.equalsIgnoreCase("m")) {
            throw new InvalidDataException("Неверное значение пола");
        }
    }
}
