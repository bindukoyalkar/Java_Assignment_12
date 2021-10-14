public class Student {
    int id;
    String name;
    int age;
   /* public enum Gender {
        "Male",
        "Female"
    } */
    String gender;
    String engDepartment;
    int yearOfEnrollment ;
    double perTillDate;
    int getId(){
        return id;
    }
    String getName(){
        return name;
    }
    int getAge(){
        return age;
    }
    String getGender(){
        return gender;
    }
    String getEngDepartment(){
        return engDepartment;
    }
    int getYearOfEnrollment(){
        return yearOfEnrollment;
    }
    double getPerTillDate(){
        return perTillDate;
    }
    public Student(int id, String name, int age , String gender, String engDepartment, int yearOfEnrollment
            ,double perTillDate){
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.engDepartment=engDepartment;
        this.yearOfEnrollment=yearOfEnrollment;
        this.perTillDate=perTillDate;
    }
    String details(){
        return id+" "+name+" "+age+" "+gender+" "+engDepartment+" "+
                yearOfEnrollment+" "+perTillDate;    }
}
