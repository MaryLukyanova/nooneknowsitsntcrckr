package model.compare;


import model.myEntitys.Stone;
import java.util.Comparator;

public class ValuePriceComparator implements Comparator<Stone> {

	@Override
	public int compare(Stone o1, Stone o2) {


		if (o1.getStonePrice() >= o2.getStonePrice()) {
            return -1;
        } else {
            return 1;
        }
	}
}