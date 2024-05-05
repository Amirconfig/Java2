public class DynamicBindingDemo2 {
    public static void main(String[] args) {
      Object o = new GraduateStudent();
    
      if (o instanceof GraduateStudent) {
        GraduateStudent gs = (GraduateStudent) o;
        System.out.println("The object is a GraduateStudent");
      } else {
        System.out.println("The object is not a GraduateStudent");
      }
    
      m(o);
      m(new Student());
      m(new Person());
      m(new Object());
    }
  
    public static void m(Object x) {
      System.out.println(x.toString());
    }
  }
  
  class GraduateStudent extends Student {
  }
  
  class Student extends Person {
    public String toString() {
      return "Student";
    }
  }
  
  class Person extends Object {
    public String toString() {
      return "Person";
    }
  }
  