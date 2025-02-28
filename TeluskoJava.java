public class TeluskoJava {
    public static void main(String a[]) {
        // Ternary Operator

        int n = 15;
        String s = n%2 == 0 ? "even" : "odd";
        // System.out.println(s);

        // Switch Statement

        int dayNo = 1;
        switch(dayNo){
            case 1:
                // System.out.println("Monday");
                break;
            case 2:
                // System.out.println("Tuesday");
                break;
            case 3:
                // System.out.println("Wednesday");
                break;
            case 4:
                // System.out.println("Thursday");
                break;
            case 5:
                // System.out.println("Friday");
                break;
            case 6:
                // System.out.println("Saturday");
                break;
            case 7:
                // System.out.println("Sunday");
                break;
            default:
                // System.out.println("Enter a valid number");
                break;
        }

        // While loop

        int i = 1;
        while (i <=3){        
            // System.out.println(i);
            i++;
        }

        // Do-while loop

        int j = 5;
        do{
            // System.out.println(j);
        }while(j<=4);

        // For loop

        for (int k = 1; k<4; k++){
            // System.out.println(k);
        }
    
        // Calling classes

        int num1 = 4;
        int num2 = 7;
        Calculator calc = new Calculator();
        // System.out.println(calc.num); 
        // System.out.println(calc.add(num1, num2));

        // Arrays

        int[] arr1 = new int[5];
        int[] arr2 = new int[]{1,2,3,4,5,6};
        int[] arr3 = {1,2,3,4,5,6};
        // System.out.println(arr3[3]);
        // 2D Array
        int[][] nums = new int[4][5];
        for (i=0; i<4; i++){
            for (j=0; j<5; j++){
                nums[i][j] = (int)(Math.random()*10);
                // System.out.print(nums[i][j] + " ");
            }
            // System.out.println();
        }
        // System.out.println("printing Array elements by using enhanced for loop:");
        for (int k[] : nums){
            for(int m : k){
                // System.out.print(m + " ");
            }
            // System.out.println();
        }
        // Jagged Array
        int[][] jagged = new int[3][];
        jagged[0] = new int[3];
        jagged[1] = new int[4];
        jagged[2] = new int[2];
        for (i=0; i<jagged.length; i++){
            for (j=0; j<jagged[i].length; j++){
                jagged[i][j] = (int)(Math.random()*10);
            }
        }
        // System.out.println("printing JaggedArray elements by using enhanced for loop:");
        for (int[] l : jagged){
            for(int o : l){
                // System.out.print(o + " ");
            }
            // System.out.println();
        }

        // Array of Objects
        Student s1 = new Student();
        s1.roll = 1;
        s1.name = "Ram";
        s1.marks = 88;

        Student s2 = new Student();
        s2.roll = 2;
        s2.name = "Shyam";
        s2.marks = 80;

        Student s3 = new Student();
        s3.roll = 3;
        s3.name = "Ghyam";
        s3.marks = 97;

        Student[] students = new Student[3] ;
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;

        for(i=0;i<students.length;i++){
            // System.out.println(students[i].roll + " : " + students[i].name + " : " + students[i].marks);
        }
        
        // For-each loop

        for (Student student : students){
            // System.out.println(student.name);
        }

        // StringBuffer

        StringBuffer sb = new StringBuffer("Biswadip");
        // System.out.println(sb.capacity()); // default is 16 and on passing values it consumes required space + 16
        // System.out.println(sb.length());
        // System.out.println(sb.append(" Saha"));
        // String str = sb.toString();

        // Static 

        // Static variables
        Mobile.type = "Smartphone";

        Mobile phone1 = new Mobile();
        phone1.name = "Samsung";
        phone1.price = 1000;

        Mobile phone2 = new Mobile();
        phone2.name = "Apple";
        phone2.price = 1100;

        // phone1.show();
        // phone2.show();
        // Mobile.showAgain(phone1);

        // Encapsulation

        Human hum1 = new Human();
        hum1.setName("Biswadip");
        hum1.setAge(18);
        // System.out.println(hum1.getName() + " : " + hum1.getAge());

        // Inheritance

        // this and super methods

        // B objB1 = new B();
        // B objB2 = new B(5);
        // B objB3 = new B(5, 6);

        // final - variable, method, class

        final int finalNum = 8;

        // Dynamic Method Dispatch

        C objC1 = new D(); // refrence of super class and object of sub-class
        // objC1.show1();

        // Upcasting and Downcasting

        C objC2 = new D();
        // objC1.show1();

        D objD1 = (D) objC2;
        // objD1.show2();

        // Abstract

        BMW objCar = new BMW();
        // objCar.playMusic();
        // objCar.drive();

    }
}


// OOP
// Object - Properties and Behaviours
class Calculator{
    int num = 5; // instance variable

    public int add(int num1, int num2){
        int r = num1 + num2;
        return r;
    }
    public double add(double num1, double num2){
        double r = num1 + num2;
        return r;
    }
    public int add(int num1, int num2, int num3){
        return num1 + num2 + num3;
    } // Method Overloading
}

class Student{
    int roll;
    String name;
    int marks;
}

class Mobile{
    String name;
    int price;
    static String type;

    static{
        type = "Smartphone"; 
        // System.out.println("In static");
    }

    public Mobile(){
        name = "";
        price = 0;
        // System.out.println("In constructor");
    }

    public void show () {
        // System.out.println(name + " : " + price + " : " + type);
    }

    public static void showAgain(Mobile phone){
        // System.out.println(phone.name + " : " + phone.price + " : " + type);
    }
}

class Human{
    private String name;
    private int age;

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

// Every class in java extends to Object class if you don't define super class, Syntax : class A extends Object
class A{                                                
    public A(){
        super(); // calling Object() constructor
        System.out.println("in A");
    }
    public A(int n){
        super(); // calling Object() constructor
        System.out.println("in A int");
    }
}

class B extends A{
    public B(){
        super(); // calling A() constructor
        System.out.println("in B");
    }
    public B(int n){
        super(n); // calling A(n) constructor
        System.out.println("in B int");
    }
    public B(int n, int m){
        this(); // calling B() constructor
        System.out.println("in B int, int");
    }
}

class C{
    public void show1(){
        System.out.println("in C show");
    }
}

class D extends C{
    public void show2(){
        System.out.println("in D show");
    }
}

abstract class Car{
    public abstract void drive();
    public void playMusic(){
        System.out.println("PLay Music");
    }
}

class BMW extends Car{
    public void drive(){
        System.out.println("Driving ...");
    }
}
