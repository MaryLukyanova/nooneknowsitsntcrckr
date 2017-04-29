package model.myEntitys;

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
	
	public Semiprecious (int id, String name, double carat){
		super(id, name, carat);
	};
	
	public double getStonePrice() {
		Name name = Name.valueOf(getName());
		double price=0;
		switch(name){
			case QUARTZ :  price = 100; break;
			case AMBER :  price = 90; break;
			case LAPISLAZULI : price = 110; break;
			case MALACHITE : price = 80; break;
			case ONYX : price = 65; break;
			case JASPER : price = 40; break;
			case AGATE : price = 70; break;
		}
		return  price*getCarat();
	}
}
