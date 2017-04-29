package model.myEntitys;


import model.compare.ValueComparator;
import model.compare.ValuePriceComparator;
import model.creator.ClassStone;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Necklace {
	
	private ArrayList<Stone> necklace;


	public Necklace() {
		necklace = new ArrayList<>();
	}
	public Necklace(List<Stone> list) {
		necklace = (ArrayList<Stone>) list;
	}

	public ArrayList<Stone> getNecklace() {
		return necklace;
	}
	public void setNecklace(ArrayList<Stone> necklace) {
		this.necklace = necklace;
	}
	
	public void addStone(Stone stone)
	{
		necklace.add(stone);
	}
	
	public double getNecklaceCarat(){
		double carat=0;
		for(Stone st : necklace)
		{
			carat += st.getCarat();
		}
		return carat;
	}

	public double getNecklacePrice(){
		double price=0;
		for(Stone st : necklace)
		{
			price += st.getStonePrice();
		}
		return price;
	}
	
	public void sortByCarat()
	{
		Collections.sort(necklace, new ValueComparator());
	}

	public void sortByStonePrice()
	{
		Collections.sort(necklace, new ValuePriceComparator());
	}
	
	public ArrayList<Stone> findStonesInCaratRange(double a, double b)
	{
		ArrayList<Stone> stones = new ArrayList<>();
		for(Stone st : necklace)
		{
			if(st.getCarat() > a && st.getCarat() < b)
				stones.add(st);
		}
		return  stones;
	}

	@Override
	public String toString() {
		String necklaceString="";
		for(Stone st : necklace)
		{
			necklaceString += "[" + st.getId() + "," + st.getName() + "," + st.getCarat() +"] ";
		}

		return necklaceString;
	}

	public static Necklace getFromString(String line, String type){
		Necklace necklace = new Necklace();
		Stone stone = null;
		String[] string = line.split("[ ],");
		if(line.compareTo("")!=0)
			for(int i=0; i<string.length; i+=3){
				stone = ClassStone.createStone(type, Integer.parseInt(string[i]), string[i+1], Double.valueOf(string[i+2]));
				necklace.addStone(stone);
			}
		return necklace;
	}
}
