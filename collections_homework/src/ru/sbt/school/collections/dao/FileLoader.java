package ru.sbt.school.collections.dao;
import java.io.*;
import java.util.ArrayList;

//Загрузка файла по строчкам в ArrayList класса LoadedText
public class FileLoader {

    public static  ArrayList<String> read(String fileName,ArrayList<String> arrline ) throws FileNotFoundException {

        StringBuilder sb = new StringBuilder();

            try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), "Cp1251"))){
                String line;
                while ((line = br.readLine()) != null) {

                    arrline.add(line); //добавить строку из файла
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            } finally {
                return arrline;
            }


    }
}
