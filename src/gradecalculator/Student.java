/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecalculator;

import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author tangrRufus@gmail.com
 */
public class Student {
    private String sid;
    //A string denoting the 10-digit student ID of the student
    private double[] assignment;
    //An array of double for storing the five assignment scores of the student
    private double totalScore;
    //The total score of the student
    private String courseGrade;
    //A string denoting the course grade (i.e. “Pass” or “Fail”) of the student
    
    public Student(String id) {
     
        while (id.length() < 10) {
            id = "0" + id;
        }
        sid = id;
    
        assignment = new double[5];
        courseGrade = "****";
        totalScore = 0;
    }
    
    public String getID() {
        return sid;
    }
    
    public double getAssignmentScore(int i) {
        return assignment[i-1];
    }
    
    public void setAssignmentScore(int i, double score) {
        
        score = (score > 100) ? 100 : score;
        score = (score < 0) ? 0 : score;
        
        assignment[i-1] = score;
    }
    
    protected void sortAssignmentScore() {
        Arrays.sort(assignment);
    }
    
    public double getTotalScore() {
        return totalScore;
    }
    
    protected void setTotalScore(double total) {
        totalScore = total;
    }
    
    public void computeCourseGrade() {

        double result=0.0;
        int i=0;
        for(i=0; i < assignment.length; i++){
            result += assignment[i];
        }
        totalScore = result / assignment.length;  

        courseGrade = (totalScore > 50) ? "Pass" : "Fail";    
    }
    
    public String getCourseGrade() {
        return courseGrade;
    }
    
    protected void setCourseGrade(String grade) {
        courseGrade = grade;
    }
}