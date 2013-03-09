/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gradecalculator;

/**
 *
 * @author tangrRufus@gmail.com
 */
public class GraduateStudent extends Student {
    private double quiz;
    
    public GraduateStudent(String id) {
        super(id);
        quiz = 0;
    }
    
    public double getQuiz() {
        return quiz;
    }
    
    public void setQuiz(double score) {
        
        score = (score > 100) ? 100 : score;
        score = (score < 0) ? 0 : score;
        
        quiz = score;
    }
    
    public void computeCourseGrade() {
        
        super.computeCourseGrade();
        
        double _totalScore = this.getTotalScore();
        _totalScore = _totalScore * 0.65 + quiz * 0.35;
        this.setTotalScore(_totalScore);
        
        String _courseGrade = (_totalScore >= 60) ? "Pass" : "Fail";
        this.setCourseGrade(_courseGrade);
    }
}

    