package ru.sbt.school.collections.entity;
import java.util.ArrayList;


// класс LoadedText  , в ктором входной текст файла разбит на слова и строки

public class LoadedText  {

   public static ArrayList<String> words;
   public static ArrayList<String> textlines;

   public LoadedText(){
       this.textlines = new ArrayList<>();
       this.words = new ArrayList<>();
   }

   public ArrayList<String> getLines(){ return this.textlines; }

    public ArrayList<String> getWords(){ return this.words; }


}
