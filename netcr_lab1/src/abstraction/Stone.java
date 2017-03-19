package abstraction;


public abstract class Stone {

	private String name;
	private double carat;

	public Stone (String name, double carat){
		this.carat = carat;
		this.name = name.toUpperCase();
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

	public abstract double getStonePrice();
}
