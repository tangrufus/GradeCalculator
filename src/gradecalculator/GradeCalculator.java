/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecalculator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author tangrRufus@gmail.com
 */
public class GradeCalculator {
    
    private int numStudents;
    //An integer denoting the number of students in the course
    private Student[] students;
    //An array of Student for storing all the students in the course
    private Scanner scanner;
    //The scanner for reading data inputs
    
    public GradeCalculator(Scanner sc) {
        scanner = sc;
        numStudents = 0;
        students = new Student[50];
    }
    
    public void computeResult() {
            System.out.println("Results of " + 
            numStudents + " students:" );
            for(int i = 0; i < numStudents; i++) {
            students[i].computeCourseGrade();
            System.out.println(students[i].getID() + " " + 
            String.format("%.2f", 
            students[i].getTotalScore()) + 
            " " + students[i].getCourseGrade());
        }
    }
        
    public void readData() {
         
        while (scanner.hasNext()) {
            
            Student s = null;
            String type = scanner.next();
            String id = scanner.next();
            
            switch(type) {
                case "NOS":
                    s = new Student(id);
                    break;
                case "GRS":
                    s = new GraduateStudent(id);
                    break;
                case "PTS":
                    s = new PartTimeGraduateStudent(id);
                    break;
            }
            
            for (int i=1; i<6; i++) {
                s.setAssignmentScore(i, scanner.nextDouble());
            }
            
            if (!type.contains("NOS")) {
                ((GraduateStudent) s).setQuiz(scanner.nextDouble());
            }
            students[numStudents++] = s;
        }
    }
    
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            Scanner sc = new Scanner(new BufferedReader(
                new FileReader("data.txt")));
                GradeCalculator gc = new GradeCalculator(sc);
                gc.readData(); 
                gc.computeResult();
            } catch (FileNotFoundException exp) {
                System.err.println("Error, Input File Not Found!");
        }
    }
}
