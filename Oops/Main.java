package Oops;

class Sample{
Sample()
{
System.out.println("Hello");
}
}
class Sample1 extends Sample
{
Sample1()
{
    super();
System.out.println("Child class");
}
public static void main(String a[])
{
Sample1 s = new Sample1();
}
    }
