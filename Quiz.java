public class Quiz{
    public static void main(String [] args){
        database.import_quiz( database.quizes, database.ques,database.ans, database.x, database.y, database.z,database.quiz_outer);
        database.addquizname(0,"Java Quiz");
        new Menu();
        music.togglebkg(database.music_shindig);
    } 
    
}   