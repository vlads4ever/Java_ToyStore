package model.toy.comparators;

import model.toy.Toys;
import java.util.Comparator;

public class CompareByName<E extends Toys> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        int firstStage = o1.getName().compareTo(o2.getName());
        if (firstStage == 0) {
            int secondStage = o1.getMaterial().compareTo(o2.getMaterial());
            if (secondStage == 0) {
                int thirdStage = Integer.compare(o1.getLength() + o1.getHeight() + o1.getWidth(),
                        o2.getLength() + o2.getHeight() + o2.getWidth());
                return thirdStage;
            }
            return secondStage;
        }
        return firstStage;
    }
}
