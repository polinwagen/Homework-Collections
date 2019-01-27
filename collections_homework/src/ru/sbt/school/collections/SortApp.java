package ru.sbt.school.collections;
import ru.sbt.school.collections.dao.FileLoader;
import java.io.*;
import ru.sbt.school.collections.entity.LoadedText;
import ru.sbt.school.collections.sort.TextIterator;
import ru.sbt.school.collections.sort.comparators.Compare;
import ru.sbt.school.collections.sort.Sorter;
import java.util.Scanner;
import java.util.TreeSet;


public class SortApp {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        LoadedText TextFromFile = new LoadedText();
        System.out.println("Введите полный путь и название файла, который необходимо проанализированть: ");
        String name = in.nextLine();
        try {
            FileLoader.read(name, TextFromFile.getLines()); //читаем строки файла и записываем в ArrayList
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }
        //разделить на слова

        for (String s : TextFromFile.getLines()) {
            String[] results = s.split("(?U)\\W+");
            for(String m :results) {
                TextFromFile.getWords().add(m);
            }

        }

        System.out.println("Задание №1 ");
        //ЗАДАНИЕ 1 : Подсчитайте количество различных слов в файле.
        System.out.println("Всего слов в файле " + TextFromFile.getWords().size());


        System.out.println("Задание №2 ");
        //ЗАДАНИЕ 2 : Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
        TreeSet<Compare> data = new TreeSet<>();

        for (String s :TextFromFile.getWords())
            data.add(new Compare(s));

        for (Compare e : data)
            System.out.println(e.toString());

        //ЗАДАНИЕ 3 :Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
        System.out.println("Задание №3 ");
        Sorter.uniqueWords(TextFromFile.getWords());

        //ЗАДАНИЕ 4 : Выведите на экран все строки файла в обратном порядке.
        System.out.println("Задание №4 ");

        for (int i = TextFromFile.getLines().size()-1;i >= 0; i--){
            System.out.println(TextFromFile.getLines().get(i));
        }

        //Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
        System.out.println("Задание №5 ");
        TextIterator textLines = new TextIterator(TextFromFile.getLines());

        for(String lines: textLines) {
            System.out.println(lines);
        }


        //Задание 6: Выведите на экран строки, номера которых задаются пользователем в произвольном порядке.
        System.out.println("Задание №6 ");

        System.out.println("Введите номера строк, которые необходимо вывести ( номер первой строки начинается с нуля): ");

        try {
            String names = in.nextLine();
            String[] numbers = names.split("(?U)\\W+");
            for(String m : numbers) {
                if (Integer.parseInt(m) > TextFromFile.getLines().size()) throw new Exception();
                System.out.println(TextFromFile.getLines().get(Integer.parseInt(m)));
            }
        }catch (Exception e){
            System.out.println("Номер строки не должен привышать колличества строк!");
        }

    }
}
