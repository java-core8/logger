package ru.tcreator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static public void main(String ...args) {


        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести данные для списка");
        System.out.print("Введите размер списка: ");
        int size = scanner.nextInt();
        System.out.print("\nВведите размер списка: ");
        int limit = scanner.nextInt();
        System.out.println();
        List<Integer> list = getRandomList(size, limit);
        logger.log("Создаём и наполняем список...");
        StringBuilder intBuilder = new StringBuilder();

        list.stream().forEach(el -> intBuilder.append(el).append(" "));
        System.out.println("Вот случайный список: " + intBuilder);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int f = scanner.nextInt();
        Filter filter = new Filter(f);
        logger.log("Запускаем фильтрацию");
        List<Integer> filterList = filter.filterOut(list);
        logger.log("Прошло фильтр " + filterList.size() + " элемента из " + list.size());
        logger.log("Выводим результат");
        StringBuilder newIntBuilder = new StringBuilder();
        filterList.stream().forEach(el -> newIntBuilder.append(el).append(" "));
        System.out.println("Отфильтрованный список: " + newIntBuilder);
        logger.log("завершаем программу");
    }

    static List<Integer> getRandomList(int size, int limit) {
        List<Integer> integerList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            integerList.add(rand.nextInt(limit));
        }
        return integerList;
    }
}
