package storage;

import java.io.*;

public class CountStorage {

    public int load() {
        int count = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/storage/SavingCount"))) {
            String countFromFile = bufferedReader.readLine();
            if (countFromFile != null) {
                try {
                    count = Integer.parseInt(countFromFile);
                } catch (NumberFormatException e) {
                    throw new RuntimeException("В файле должно быть сохранено только одно число");
                }
            }
        } catch (IOException ioException) {
            System.out.println("файл с сохранения записей не найден");
        }
        System.out.println("Загрузка состояния счётчика произведена.");
        System.out.println("Приложение запущено." + "\n");
        return count;
    }

    public void save(int count) {
        try (FileWriter fileWriter = new FileWriter("src/storage/SavingCount")) {
            fileWriter.write("" + count);
        } catch (IOException e) {
            throw new RuntimeException("Файл не найден.");
        }
        System.out.println("Сохранение значения count выполнено." + "\n");
    }
}
