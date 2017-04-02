package model.creator;


import model.myEntitys.Gem;
import model.myEntitys.Semiprecious;
import model.myEntitys.Stone;

public class ClassStone {

	public static Stone createStone(String type, String name, double carat){
		Stone stone = null;
		switch(type.toUpperCase()){
			case "GEM" :
				stone = new Gem(name, carat);
				break;
			case "SEMIPRECIOUS" :
				stone = new Semiprecious(name, carat);
				break;
		}
		return stone;
	}
}
