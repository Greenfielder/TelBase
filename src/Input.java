import util.InvalidDataException;
import util.ValidateData;

import java.io.IOException;
import java.util.Scanner;

import static util.WriteToFile.writeToFile;

public class Input {
    public static void input() {

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите данные в формате:\nФамилия Имя Отчество дата_рождения номер_телефона пол");
            String input = scanner.nextLine();
            String[] data = input.split(" ");

            if (data.length != 6) {
                throw new InvalidDataException("Неверное количество данных");
            }

            String surname = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDate = data[3];
            String phoneNumber = data[4];
            String gender = data[5];
            ValidateData.validateData(surname, firstName, middleName, birthDate, phoneNumber, gender);
            String filename = surname + ".txt";
            String fileContent = surname + " " + firstName + " " + middleName + " " + birthDate + " " + phoneNumber + " "
                    + gender;
            writeToFile(filename, fileContent);
            System.out.println("Данные успешно записаны в файл " + filename);
        } catch (InvalidDataException e) {
            System.out.println("Ошибка валидации данных: " + e.getMessage());
        } catch (
                IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }
}