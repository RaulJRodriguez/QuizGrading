import javax.swing.JOptionPane;
 
public class GradeBook_RR{
   final static int MAX = 30; 
   public static void main(String[] args){
      //declare data structures
      String[] stuName = new String[MAX];
      String[] stuID = new String[MAX];
      String[] stuAnswer = new String[MAX];
     
      
      //mainline logic. Calling methods
      int numStudent = addStudent(stuName, stuID, stuAnswer);
      printReport(stuName, stuAnswer, stuID, numStudent);
      
   }
   // Add students until user type the sentinel Q. 
   public static int addStudent(String[] stuName, String[] stuID, String[] stuAnswer){
      int num = 0;
      stuName[num] = getName(num);
      
      do{
         stuID[num] = getID(num);
         stuAnswer[num] = getScore(num);
         num++;
         stuName[num] = getName(num);
      }while(!stuName[num].equals("Q"));
      return num;
   }
   // populate student name array.
   public static String getName(int num){
      String name = "";
      while(name.equals("") || name==null){
         name = JOptionPane.showInputDialog("Enter student " +(num+1)+ " name. \n Type Q to quit");
      }
            return name;
   }
   public static String getID(int num){
      String id = "";
      while(id.equals("") || id==null){
         id = JOptionPane.showInputDialog("Enter student " +(num+1)+ " student's ID.");
         }
      return id;
     }
   
   //populate student score array 
   public static String getScore(int num){
      int officialScore = 0;
      String result = "";
      String score = "";
      String score2 = "";
      String score3 = "";
      String score4 = "";
      String score5 = "";
      double sum = 0.0;
      boolean valid = false;
      while(!valid){
         try{
            score = JOptionPane.showInputDialog("Enter student " + (num+1) + " answer's for question 1");
            if (score.equals("D"))
            {
               sum += 0.20;
            }
            score2 = JOptionPane.showInputDialog("Enter student " + (num+1) + " answer's for question 2");
            if (score2.equals("B"))
            {
               sum += 0.20;
            }
            score3 = JOptionPane.showInputDialog("Enter student " + (num+1) + " answer's for question 3");
            if (score3.equals("C"))
            {
               sum += 0.20;
            }
            score4 = JOptionPane.showInputDialog("Enter student " + (num+1) + " answer's for question 4");
            if (score4.equals("A"))
            {
               sum += 0.20;
            }
            score5 = JOptionPane.showInputDialog("Enter student " + (num+1) + " answer's for question 5");
            if (score5.equals("B"))
            {
               sum += 0.20;
            }
            
            officialScore += (sum * 100);
            result = String.valueOf(officialScore);
            JOptionPane.showMessageDialog(null, "The sum of the quiz grade is " + officialScore);
            if(!score.equals(" "))
               valid = true;
         }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(null, "Error! Score should be either A, B, C, D");
         }
      }
     return result; 
   }
   

   
   public static void printReport(String[] stuName, String[] stuAnswer, String[] stuID, int numStudent){
      String output = "The list of Students Name/ID/Grade \n";
      for(int i=0; i<numStudent; i++){
         output += stuName[i] + " / " + stuID[i] + " / " + stuAnswer[i] + "(" + numStudent + ")\n" ; 
      }
      JOptionPane.showMessageDialog(null, output);
   }
}