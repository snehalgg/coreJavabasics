 package set;


// import java.util.Set;
// import java.util.TreeSet;

// class Student implements Comparable<Student> {
//     private String name;
//     private int age;

//     public Student(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     public String getName() {
//         return name;
//     }

//     public int getAge() {
//         return age;
//     }

//     @Override
//     public int compareTo(Student other) {
//         return Integer.compare(this.age, other.age);
//     }

//     @Override
//     public String toString() {
//         return "Name: " + name + ", Age: " + age;
//     }
// }

// public class StudentAgeSorter {
//     public static void main(String[] args) {
//         Set<Student> students = new TreeSet<>();

//         students.add(new Student("Ayush", 24));
//         students.add(new Student("Manoj", 23));
//         students.add(new Student("Snehal", 22));
//         students.add(new Student("Muazzam", 18));
//         students.add(new Student("Monis", 19));
//         students.add(new Student("Saima", 18));
//         students.add(new Student("Dhruv", 18));
//         students.add(new Student("Kalpesh", 20));
//         students.add(new Student("Rutika", 21));
//         students.add(new Student("Samruddhi", 20));
//         students.add(new Student("Jagruti", 23));

//         System.out.println("Welcome to Student Age Sorting!");

//     //     while (true) {
//     //         System.out.println("\nMenu:");
//     //         System.out.println("1. Sort by Age in Ascending Order");
//     //         System.out.println("2. Sort by Age in Descending Order");
//     //         System.out.println("3. Exit");
//     //         System.out.print("Enter your choice: ");

//     //         int choice = 0;
//     //         try {
//     //             choice = Integer.parseInt(System.console().readLine());
//     //         } catch (NumberFormatException e) {
//     //             System.out.println("Invalid choice. Please enter a valid number.");
//     //             continue;
//     //         }

//     //         switch (choice) {
//     //             case 1:
//     //                 System.out.println("Students sorted by age in ascending order:");
//     //                 for (Student student : students) {
//     //                     System.out.println(student.getName() + ", " + student.getAge() + " years old");
//     //                 }
//     //                 break;

//     //             case 2:
//     //                 Set<Student> descendingOrderSet = new TreeSet<>((s1, s2) -> s2.getAge() - s1.getAge());
//     //                 descendingOrderSet.addAll(students);
//     //                 System.out.println("Students sorted by age in descending order:");
//     //                 for (Student student : descendingOrderSet) {
//     //                     System.out.println(student.getName() + ", " + student.getAge() + " years old");
//     //                 }
//     //                 break;

//     //             case 3:
//     //                 System.out.println("Exiting Student Age Sorting.");
//     //                 System.exit(0);
//     //                 break;

//     //             default:
//     //                 System.out.println("Invalid choice. Please try again.");
//     //         }
//     //     }
//     // }

//     // for (Student s : students) {
//     //     System.out.println(s);
//     // }

//    // students.forEach(student -> System.out.println(student.getName() + ", " + student.getAge() + " years old"));
// }
// }



//Code2

import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student other) {
        if (this.age != other.age) {
            return other.age - this.age; 
        } else {
            return this.name.compareTo(other.name); 
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

public class StudentAgeSorter {
    public static void main(String[] args) {
        Set<Student> students = new TreeSet<>();

        students.add(new Student("Ayush", 24));
        students.add(new Student("Manoj", 23));
        students.add(new Student("Snehal", 22));
        students.add(new Student("Muazzam", 18));
        students.add(new Student("Monis", 19));
        students.add(new Student("Saima", 18));
        students.add(new Student("Dhruv", 18));
        students.add(new Student("Kalpesh", 20));
        students.add(new Student("Rutika", 21));
        students.add(new Student("Samruddhi", 20));
        students.add(new Student("Jagruti", 20));

        System.out.println("Welcome to Student Age Sorting!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Sort by Age in Ascending Order");
            System.out.println("2. Sort by Age in Descending Order");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = 0;
            try {
                choice = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice. Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Students sorted by age in ascending order:");
                    for (Student student : students) {
                        System.out.println(student);
                    }
                    break;

                case 2:
                    System.out.println("Students sorted by age in descending order:");
                    students.forEach(System.out::println);
                    break;

                case 3:
                    System.out.println("Exiting Student Age Sorting.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
