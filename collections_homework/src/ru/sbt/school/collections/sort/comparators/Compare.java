package ru.sbt.school.collections.sort.comparators;


public class Compare implements Comparable<Object>{

    private String  str;
    private  int     len;

    public Compare(String str)
    {
        this.str = str;
        this.len = str.length();
    }

    @Override
    public int compareTo(Object obj)
    {
        int result;
        Compare entry = (Compare) obj;

        result = len - entry.len;
        if(result != 0)
            return result;

       result = str.compareTo(entry.str); //-1 если  аргумент лексически  больше сравниваемой
        if(result != 0)
            return result;

        return 0;
    }
    @Override
    public String toString()
    {
        return str;
    }

}
