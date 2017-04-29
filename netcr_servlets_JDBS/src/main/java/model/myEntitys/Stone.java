package model.myEntitys;


public abstract class Stone {

	private String name;
	private double carat;
	private int id;
	private double price;

	public Stone (int id, String name, double carat){
		this.carat = carat;
		this.name = name.toUpperCase();
		this.id = id;
		this.price = getStonePrice();
	};

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name.toUpperCase();
	}
	public double getCarat()
	{
		return carat;
	}
	public  void setCarat(double carat)
	{
		this.carat = carat;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getPrice(){
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public abstract double getStonePrice();

}
