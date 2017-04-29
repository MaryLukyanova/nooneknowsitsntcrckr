package model.creator;


import model.myEntitys.Gem;
import model.myEntitys.Semiprecious;
import model.myEntitys.Stone;

public class ClassStone {

	public static Stone createStone(String type, int id, String name, double carat){
		Stone stone = null;
		switch(type.toUpperCase()){
			case "GEMS" :
				stone = new Gem(id, name, carat);
				break;
			case "SEMIPRECIOUS" :
				stone = new Semiprecious(id, name, carat);
				break;
		}
		return stone;
	}
}
