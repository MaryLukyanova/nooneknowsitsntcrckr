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
	
	public Gem (String name, double carat){
		super(name, carat);
	};
	
	public double getStonePrice() {
		Name name = Name.valueOf(getName());
		double price=0;
		switch(name){
			case DIAMOND : price = 300;
			case RUBY : price = 150;
			case EMERALD : price = 200;
			case SAPPHIRE : price = 220;
			case OPAL : price = 270;
			case AQUAMARINE : price = 255;
			case TOPAZ : price = 190;
			case AMETIST : price = 120;
			case PERL : price = 100;
		}
		return  price*getCarat();
	}	
}
