/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecalculator;

/**
 *
 * @author tangrRufus@gmail.com
 */
public class PartTimeGraduateStudent extends GraduateStudent {
    
    public PartTimeGraduateStudent(String id) {
        super(id);
    }
    
    public void computeCourseGrade() {
     
        this.sortAssignmentScore();
        double result=0.0;
        for(int i = 5; i > 2; i--){
            result += this.getAssignmentScore(i);
        }
        double _totalScore = (result / 3) * 0.75 + this.getQuiz() * 0.25;
        
        this.setTotalScore(_totalScore);
        
        String _courseGrade = (_totalScore >= 40) ? "Pass" : "Fail";
        this.setCourseGrade(_courseGrade);
    }
    
}
