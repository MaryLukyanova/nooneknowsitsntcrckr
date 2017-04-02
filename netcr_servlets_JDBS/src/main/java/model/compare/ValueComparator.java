package model.compare;


import model.myEntitys.Stone;
import java.util.Comparator;

public class ValueComparator implements Comparator<Stone> {

	@Override
	public int compare(Stone o1, Stone o2) {
		if (o1.getCarat() >= o2.getCarat()) {
            return -1;
        } else {
            return 1;
        }
	}
}