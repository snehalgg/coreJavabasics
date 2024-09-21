interface add{
	void calculate(int a, int b);
}
class Calculator implements add
{
	public void calculate(int a, int b)
	{
		System.out.println("The area of rectangle is " + (a+b));
	}
}
class Main
{
	public static void main(String args[])
	{
		Calculator c = new Calculator();
		c.calculate(10,20);
	}
}