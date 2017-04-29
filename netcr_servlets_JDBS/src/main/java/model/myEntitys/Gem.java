package model.myEntitys;

public class Gem extends Stone{
	
	public enum Name {
		DIAMOND,
		RUBY,
		EMERALD,
		SAPPHIRE,
		OPAL,
		AQUAMARINE,
		TOPAZ,
		AMETIST,
		PERL
	};
	
	public Gem (int id, String name, double carat){
		super(id, name, carat);
	};
	
	public double getStonePrice() {
		Name name = Name.valueOf(getName());
		double price=0;
		switch(name){
			case DIAMOND : price = 300; break;
			case RUBY : price = 150; break;
			case EMERALD : price = 200; break;
			case SAPPHIRE : price = 220; break;
			case OPAL : price = 270; break;
			case AQUAMARINE : price = 255; break;
			case TOPAZ : price = 190; break;
			case AMETIST : price = 120; break;
			case PERL : price = 100; break;
		}
		return  price*getCarat();
	}	
}
