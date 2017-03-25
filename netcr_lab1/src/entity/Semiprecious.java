package entity;

public class Semiprecious extends Stone{
	
	public enum Name {
		QUARTZ,
		AMBER,
		LAPISLAZULI,
		MALACHITE,
		ONYX,
		JASPER,
		AGATE
	};
	
	public Semiprecious (String name, double carat){
		super(name, carat);
	};
	
	public double getStonePrice() {
		Name name = Name.valueOf(getName());
		double price=0;
		switch(name){
			case QUARTZ :  price = 100;
			case AMBER :  price = 90;
			case LAPISLAZULI : price = 110;
			case MALACHITE : price = 80;
			case ONYX : price = 65;
			case JASPER : price = 40;
			case AGATE : price = 70;
		}
		return  price*getCarat();
	}
}
