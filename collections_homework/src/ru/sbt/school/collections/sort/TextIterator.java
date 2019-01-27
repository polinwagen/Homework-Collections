package ru.sbt.school.collections.sort;

import ru.sbt.school.collections.entity.LoadedText;

import java.util.ArrayList;
import java.util.Iterator;

public class TextIterator implements Iterable<String> {

    public TextIterator(ArrayList<String> lines){};

    @Override
    public Iterator<String> iterator() {
        Iterator<String> it = new Iterator<String>() {

            private int currentIndex = LoadedText.textlines.size()-1;

            @Override
            public boolean hasNext() {
                return currentIndex >= 0 && LoadedText.textlines.get(currentIndex) != null;
            }

            @Override
            public String next() {
                return  LoadedText.textlines.get(currentIndex--);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
