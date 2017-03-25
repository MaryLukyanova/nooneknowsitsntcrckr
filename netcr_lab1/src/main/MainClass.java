package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Necklace;
import entity.Stone;
import creator.ClassStone;


public class MainClass {

	public static final String OUTPUT_FILE_NAME = "output.txt";
	public static final String INPUT_FILE_NAME = "input.txt";

	public static void main(String[] args) {

		cleanFile(OUTPUT_FILE_NAME);
		Necklace necklace = getNecklaceFromFile();
		ArrayList<Stone> stones;

		String q="";
		while (q!="Exit")
		{
			Scanner sc = new Scanner(System.in,"utf-8");
			System.setProperty("console.encoding","utf-8");

			showMenu();

			double sw = getCorrectNumber();

			switch ((int)sw)
			{
				case 1:
					System.out.println(necklace.toString());
					break;

				case 2:
					showStones();
					System.out.println("Enter type: ");
					sc.nextLine();
					String type = sc.nextLine();
					System.out.println("Enter name: ");
					String name = sc.nextLine();
					System.out.println("Enter carat: ");
					double carat = getCorrectNumber();

					Stone stone = ClassStone.createStone(type, name, carat);
					necklace.addStone(stone);

					addStoneToFile(type + " " + name + " " + carat);
					break;

				case 3:
					necklace.sortByCarat();
					stones = necklace.getNecklace();
					for(Stone st: stones)
					{
						System.out.println(st.getName() + "\t" + st.getCarat());
					}

					writeResultsToFile("Sorted by carat:", necklace.toString());
					break;

				case 4:
					necklace.sortByStonePrice();
					stones = necklace.getNecklace();
					for(Stone st: stones)
					{
						System.out.println(st.getName() + "\t" + st.getCarat() + "\t" + st.getStonePrice());
					}

					writeResultsToFile("Sorted by stone price:", necklace.toString());
					break;

				case 5:
					double necklaceCarat = necklace.getNecklaceCarat();
					System.out.println("Carat amount: " + necklaceCarat);

					writeResultsToFile("Carat amount:", Double.toString(necklaceCarat));
					break;

				case 6:
					double necklacePrice = necklace.getNecklacePrice();
					System.out.println("Price: " + necklacePrice);

					writeResultsToFile("Price:", Double.toString(necklacePrice));
					break;

				case 7:
					System.out.println("Enter a: ");
					double a = getCorrectNumber();
					System.out.println("Enter b: ");
					double b = getCorrectNumber();

					stones = necklace.findStonesInCaratRange(a, b);
					String stringStones="";
					for(Stone st: stones)
					{
						System.out.println(st.getName() + "\t" + st.getCarat());
						stringStones += st.getName() + " " + st.getCarat() + "\r\n";
					}
					writeResultsToFile("Stones in a range " + a + " " + b +":", stringStones);

					break;

				case 8: q = "Exit";
					break;
			}
		}
	}

	public static Necklace getNecklaceFromFile(){
		Necklace necklace = new Necklace();
		Stone stone;
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(INPUT_FILE_NAME));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNext())
		{
			String line = scanner.nextLine();
			String[] string = line.split("[ \r\n]");
			stone = ClassStone.createStone(string[0], string[1], Double.valueOf(string[2]));
			necklace.addStone(stone);
		}

		scanner.close();
		return  necklace;
	}

	public static void writeResultsToFile(String name, String text){
		try(FileWriter writer = new FileWriter(OUTPUT_FILE_NAME, true))
		{
			writer.write("\r\n");
			writer.write(name);
			writer.write("\r\n");
			writer.write(text);
			writer.flush();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public static void addStoneToFile(String text){
		try(FileWriter writer = new FileWriter(INPUT_FILE_NAME, true))
		{
			writer.write("\r\n");
			writer.write(text);
			writer.flush();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public static void cleanFile(String filename){
		try(FileWriter writer = new FileWriter(filename, false))
		{
			writer.write("");
			writer.flush();
		}
		catch(IOException ex){
			ex.printStackTrace();
		}
	}

	public static Double getCorrectNumber()
	{
		Scanner sc = new Scanner(System.in,"utf-8");
		double number=0;
		while (true){
			String inputLine = sc.nextLine();

			try {
				number = Double.parseDouble(inputLine);
				break;
			}
			catch (NumberFormatException e){
				System.out.println("Invalid input. Please, try again");
			}
		}
		return number;
	}

	public static void showMenu()
	{
		System.out.println("1.Show the necklace\n" +
				"2.Add stone in necklace\n" +
				"3.Sort necklace by carat\n" +
				"4.Sort necklace by stone price\n" +
				"5.Get necklace carat\n" +
				"6.Get necklace price\n" +
				"7.Find stones in range of carat\n" +
				"8.Exit");
	}

	public static void showStones()
	{
		System.out.println("GEM: DIAMOND,RUBY,EMERALD,SAPPHIRE,OPAL,AQUAMARINE,TOPAZ,AMETIST,PERL"
				+ "\nSEMIPRECIOUS: QUARTZ,AMBER,LAPISLAZULI,MALACHITE,ONYX,JASPER,AGATE");
	}

}
