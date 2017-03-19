package main;

import java.util.ArrayList;
import java.util.Scanner;

import entity.Necklace;
import abstraction.Stone;
import creator.ClassStone;


public class MainClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in,"utf-8");
		System.setProperty("console.encoding","utf-8");

		Necklace necklace = new Necklace();
		ArrayList<Stone> stones;

		String q="";
		while (q!="Exit")
		{
			showMenu();
			int sw = sc.nextInt();
			switch (sw)
			{
				case 1:
					showStones();
					System.out.println("Enter type: ");
					sc.nextLine();
					String type = sc.nextLine();
					System.out.println("Enter name: ");
					String name = sc.nextLine();
					System.out.println("Enter carat: ");
					double carat = sc.nextDouble();

					Stone stone = ClassStone.createStone(type, name, carat);
					necklace.addStone(stone);
					break;

				case 2:
					necklace.sortByCarat();
					stones = necklace.getNecklace();
					for(Stone st: stones)
					{
						System.out.println(st.getName() + "\t" + st.getCarat());
					}
					break;

				case 3:
					necklace.sortByStonePrice();
					stones = necklace.getNecklace();
					for(Stone st: stones)
					{
						System.out.println(st.getName() + "\t" + st.getCarat() + "\t" + st.getStonePrice());
					}
					break;

				case 4:
					double necklaceCarat = necklace.getNecklaceCarat();
					System.out.println("Carat amount: " + necklaceCarat);
					break;

				case 5:
					double necklacePrice = necklace.getNecklacePrice();
					System.out.println("Price: " + necklacePrice);
					break;

				case 6:
					System.out.println("Enter a: ");
					double a = sc.nextDouble();
					System.out.println("Enter b: ");
					double b = sc.nextDouble();

					stones = necklace.findStonesInCaratRange(a, b);
					for(Stone st: stones)
					{
						System.out.println(st.getName() + "\t" + st.getCarat());
					}

					break;

				case 7: q = "Exit";
					break;
			}
		}
	}

	public static void showMenu()
	{
		System.out.println("1.Add stone in necklace\n" +
				"2.Sort necklace by carat\n" +
				"3.Sort necklace by stone price\n" +
				"4.Get necklace carat\n" +
				"5.Get necklace price\n" +
				"6.Find stones in range of carat\n" +
				"7.Exit");
	}

	public static void showStones()
	{
		System.out.println("GEM: DIAMOND,RUBY,EMERALD,SAPPHIRE,OPAL,AQUAMARINE,TOPAZ,AMETIST,PERL"
				+ "\nSEMIPRECIOUS: QUARTZ,AMBER,LAPISLAZULI,MALACHITE,ONYX,JASPER,AGATE");
	}

}
