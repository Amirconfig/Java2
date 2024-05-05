public class CourseNew {
    private String courseName;
    private String[] students;
    private int numberOfStudents;
      
    public CourseNew(String courseName) {
      this.courseName = courseName;
      students = new String[1];
      numberOfStudents = 0;
    }
    
    public void addStudent(String student) {
      if(numberOfStudents == students.length) {
        String[] temp = new String[students.length + 1];
        for (int i = 0; i < students.length; i++) {
          temp[i] = students[i];
        }
        students = temp;
      }
      students[numberOfStudents] = student;
      numberOfStudents++;
    }
    
    public String[] getStudents() {
      String[] studentList = new String[numberOfStudents];
      for (int i = 0; i < numberOfStudents; i++) {
        studentList[i] = students[i];
      }
      return studentList;
    }
  
    public int getNumberOfStudents() {
      return numberOfStudents;
    }  
  
    public String getCourseName() {
      return courseName;
    }  
    
    public void dropStudent(String student) {
      for (int i = 0; i < numberOfStudents; i++) {
        if(students[i].equals(student)) {
          for (int j = i + 1; j < numberOfStudents; j++) {
            students[j - 1] = students[j];
          }
          numberOfStudents--;
          return;
        }
      }
    }
    
    public void clear() {
      for (int i = 0; i < numberOfStudents; i++) {
        students[i] = null;
      }
      numberOfStudents = 0;
    }
  
  }
  