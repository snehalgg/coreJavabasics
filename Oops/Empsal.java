package Oops;




class Employee1{

    int salary,hours;

    void getInfo(int salary,int hours){

        this.salary=salary;

        this.hours=hours;

    }

    void AddSal(){

        if(this.salary<500){

            this.salary+=10;

        }

    }

    void AddWork(){

        if(this.hours>6 ){

            this.salary+=5*28;

        }

    }

    void disp(){

        System.out.println("Salary: "+this.salary);

    }

}

public class Empsal {

    public static void main(String[] args){

        Employee1 ob=new Employee1();

        ob.getInfo(400,8 );

        ob.AddSal();

        ob.AddWork();

        ob.disp();

    }

}