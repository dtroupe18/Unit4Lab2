/*
 * Created by Dave on 2/7/17.
 */
import java.util.*;

public class UglyNumbers {
    public static void main(String[] args) {
        TreeSet<Integer> ugly = (TreeSet) listUgly(100);
        System.out.println(ugly);
    }
    public static Collection<Integer> listUgly(int N) {
        TreeSet<Integer> uglyNumbers = new TreeSet<>();
        uglyNumbers.add(1);
        uglyNumbers.add(2);
        uglyNumbers.add(3);
        uglyNumbers.add(5);
        Integer current = 1;
        while (uglyNumbers.size() < N) {
            TreeSet<Integer> tailSet = new TreeSet<>(uglyNumbers.tailSet(current));
            tailSet.remove(tailSet.first());
            Integer nextInteger = new Integer (tailSet.first());
            current = nextInteger;
            if (uglyNumbers.size() < N)
                uglyNumbers.add(nextInteger * 2);
            if (uglyNumbers.size() < N)
                uglyNumbers.add(nextInteger * 3);
            if (uglyNumbers.size() < N)
                uglyNumbers.add(nextInteger * 5);
        }
        return uglyNumbers;
    }
}

