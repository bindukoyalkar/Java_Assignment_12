import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
public class Main {
    public static void main(String[] args) {
        List<Student> studentList=new ArrayList<>();
        studentList.add(new Student(111, "Jiya Brein", 17, "Female", "Computer Science",
                2018, 70.8));
        studentList.add(new Student(122, "Paul Niksui", 18, "Male", "Mechanical",
                2016, 50.2));
        studentList.add(new Student(133, "Martin Theron", 17, "Male", "Electronic",
                2017, 90.3));
        studentList.add(new Student(144, "Murali Gowda", 18, "Male","Electrical",
                2018, 80));
        studentList.add(new Student(155, "Nima Roy", 19, "Female", "Textile",
                2016, 70));
        studentList.add(new Student(166, "Iqbal Hussain", 18, "Male", "Security",
                2016, 70));
        studentList.add(new Student(177, "Manu Sharma", 16, "Male", "Chemical",
                2018, 70));
        studentList.add(new Student(188, "Wang Liu", 20, "Male", "Computer Science",
                2015, 80));
        studentList.add(new Student(199, "Amelia Zoe", 18, "Female", "Computer Science",
                2016, 85));
        studentList.add(new Student(200, "Jaden Dough", 18, "Male", "Security",
                2015, 82));
        studentList.add(new Student(211, "Jasna Kaur", 20, "Female", "Electronic",
                2019, 83));
        studentList.add(new Student(222, "Nitin Joshi", 19, "Male", "Textile",
                2016, 60.4));
        studentList.add(new Student(233, "Jyothi Reddy", 16, "Female", "Computer Science",
                2015, 45.6));
        studentList.add(new Student(244, "Nicolus Den", 16, "Male", "Electronic",
                2017, 95.8));
        studentList.add(new Student(255, "Ali Baig", 17, "Male", "Electronic",
                2018, 88.4));
        studentList.add(new Student(266, "Sanvi Pandey", 17, "Female", "Electric",
                2019, 72.4));
        studentList.add(new Student(277, "Anuj Chettiar", 18, "Male", "Computer Science",
                2017, 57.5));

        getAllDepartmentNames(studentList);

        studentsEnrolledAfter2018(studentList);

        getDetailsOfComputerScienceMaleStudents(studentList);

        noOfFemalesAndMales(studentList);

        averageAgeOfFemaleAndMaleStudents(studentList);

        getDetailsOfTopper(studentList);

        noOfStudentsInEachDepartment(studentList);

        averagePercentageInEachDepartment(studentList);

        youngestInElectronicDepartment(studentList);

        noOfFemalesAndMalesInComputerScienceDept(studentList);


        //OptionalDouble rank1=  studentList.stream().map(o->o.getPerTillDate()).summaryStatistics();
    }
    public static void getAllDepartmentNames(List<Student> studentList){
        System.out.println("Department names are:");
        studentList.stream().map(o->o.getEngDepartment()).distinct().forEach(System.out::println);
        System.out.println();
    }
    public static void studentsEnrolledAfter2018(List<Student> studentList){
        System.out.println("Students enrolled after 2018");
        studentList.stream().filter(o->o.getYearOfEnrollment()> 2018).map(o->o.getName()).forEach(System.out::println);
        System.out.println();
    }
    public static void getDetailsOfComputerScienceMaleStudents(List<Student> studentList){
        System.out.println("Details of Computer Science Male Students");
        studentList.stream().filter(o->o.getGender().equals("Male") && o.getEngDepartment().equals("Computer Science"))
                .forEach(s-> System.out.println(s.details()));
        System.out.println();
    }
    public static void noOfFemalesAndMales(List<Student> studentList){
        System.out.println("Number of Female and Male Students:");
        studentList.stream().collect(Collectors.groupingBy(o->o.getGender())).forEach((a,b)-> System.out.println(a +" "+ b.size()));
        System.out.println();
    }

    public static void averageAgeOfFemaleAndMaleStudents(List<Student> studentList){
        System.out.println("Average age of Female and Male Students:");
        studentList.stream().collect(Collectors.groupingBy((o->o.getGender()),Collectors.averagingInt((o->o.getAge()))))
                .forEach((a,b)-> System.out.println(a+" "+b));
        System.out.println();
    }

    public static void getDetailsOfTopper(List<Student> studentList){
        System.out.println("Topper details:");
        Optional<Student> topper=  studentList.stream().max((o1,o2)-> Double.compare(o1.getPerTillDate() , o2.getPerTillDate()));
        System.out.println(topper.get().details());
        System.out.println();
    }
    public static void noOfStudentsInEachDepartment(List<Student> studentList){
        System.out.println("Number of students in each Department:");
        studentList.stream().collect(Collectors.groupingBy(o->o.getEngDepartment())).forEach((a,b)-> System.out.println(a+"="+b.size()));
        System.out.println();
    }

    public static void averagePercentageInEachDepartment(List<Student> studentList){
        System.out.println("Average Percentage in each Department is:");
        studentList.stream().collect(Collectors.groupingBy((o->o.getEngDepartment()),Collectors.averagingDouble((o-> o.getPerTillDate()))))
                .forEach((a,b)-> System.out.println(a+" "+b));
        System.out.println();
    }

    public static void youngestInElectronicDepartment(List<Student> studentList){
        System.out.println("Youngest student in Electronics Department:");
        Optional<Student> a= studentList.stream().filter(o->o.getEngDepartment().equals("Electronic") && o.getGender().equals("Male"))
                .min((o1, o2) -> Integer.compare(o1.getAge() , o2.getAge()));
        System.out.println(a.get().details());
        System.out.println();
    }

    public static void noOfFemalesAndMalesInComputerScienceDept(List<Student> studentList){
        System.out.println("Number of Female and Male in Computer Science Department:");
        studentList.stream().filter(o->o.getEngDepartment().equals("Computer Science")).collect(Collectors.groupingBy(o->o.getGender()))
                .forEach((a,b)-> System.out.println(a+" "+b.size()));
        System.out.println();
    }
}
//studentList.stream().collect(Collectors.groupingBy(o->o.getEngDepartment()));
