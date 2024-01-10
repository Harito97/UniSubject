package DataStructureAndAlgorithms.AssignmentTH.Hw2_21002139.Ex6AndEx7;

import java.util.Arrays;
import java.util.Comparator;

public class SortPokerCards<T> {
    public void sort(T[] pokerCards, Comparator<? super T> compareCard) {
        Arrays.sort(pokerCards, 0, pokerCards.length, compareCard);
    }
}
