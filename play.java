import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;



public class play extends JFrame implements ActionListener{
    


    //Custom Fonts and Colors
    Color blo = new Color(37,49,64);
    Color main_Color = new Color(112233);
    Font Myfont = new Font("Eight Bit Dragon",Font.BOLD,15);

    //Labels and Buttons
    JLabel quest,no,score_display,items_display,trophy,comment;
    JButton A,B,C,D,back,play_yes,play_no;
    JPanel question;
    JFrame playarea;
    //Image icons
    ImageIcon gold,silver,bronze;
    
    //Comments
    LinkedList <LinkedList<String>> comms = new LinkedList<>(Arrays.asList(
        new LinkedList<>(Arrays.asList("Well, you tried...","WOW, you suck ***","you good??")),
        new LinkedList<>(Arrays.asList("Not bad","Good Job!","you're close, try again!")),
        new LinkedList<>(Arrays.asList("Wow, You're a great Singer!","Sheeeeeeeeeeeeeeshh","I knew you could do it!"))
        )); 
    //Medals
    LinkedList <ImageIcon> medals = new LinkedList<>();

    //Variables 
    int rand = 0;//TEMPORARY
    int grade=0;
    Random random = new Random();
    LinkedList <Integer> used = new LinkedList<>();					//Storage for index of used questions
    LinkedList <String> used_abcd = new LinkedList <>();           //Storage for used abcd 
    int guide;
    int quiz_items;	
    int q;
    int abcd = 4;
    public static int score = 0;
    String a,b,c,d; //Choices text
    String attempt; 
    String correct;
    Scanner sc = new Scanner(System.in);

    //Panels
    JPanel gaming,score_panel;  
    
    
    play(int terminal){
        music.togglebkg("stop");
        guide = terminal;
        quiz_items = database.quizes.get(guide).get(database.quiz_semi).size();

        playarea = new JFrame("Quiz IT");
        
        //Random Question Selector

        //question no. label
        no = new JLabel("Question no. "+(rand+1));
        no.setFont(new Font("Pixeboy",Font.BOLD,25));
        no.setBounds(250,20,200,50);

        

        //Question Panel
        question = new JPanel();
        question.setBounds(20,70,640,100);
        question.setVisible(true);
        question.setBorder(new LineBorder(Color.BLACK, 1));

        //First Question random selector
        int q = random.nextInt(quiz_items);
        used.add(q);
        //Index of the selected question
        int question_index =(database.quizes.get(guide).get(database.quiz_semi).indexOf(database.quizes.get(guide).get(database.quiz_semi).get(q)));
        

        //Question Text
        quest = new JLabel(database.quizes.get(guide).get(database.quiz_semi).get(q));
        quest.setFont(new Font("Info Story",Font.PLAIN,25));
        quest.setVisible(true);
        quest.setHorizontalAlignment(SwingConstants.CENTER);
        quest.setVerticalAlignment(SwingConstants.CENTER);
        question.add(quest);

        //Randomizing choices for Question 1
        correct = database.quizes.get(guide).get(database.quiz_semi+1).get(q);//correct answer

        String [] selection = new String[abcd];
		for(int j = 0; j<abcd;j++) {
			selection[j]=database.quizes.get(guide).get(database.quiz_semi+j+1).get(question_index);	//Looping to add questions to Array
		}
		a=" ";
        b=" ";
        c=" ";
        d=" ";

        //Assigning values sa String a, b, c, and d
        for(int k = 0;k<selection.length;k++) {
			int choice = random.nextInt(abcd);
			while(used_abcd.contains(selection[choice])) {										//While loop to make sure a/b/c/d does not repeat
					choice = random.nextInt(abcd);}
					if(a.equals(" ")) {a=selection[choice];used_abcd.add(a);}
					else if(b.equals(" ")) {b=selection[choice];used_abcd.add(b);}
					else if(c.equals(" ")) {c=selection[choice];used_abcd.add(c);}
					else if(d.equals(" ")){d=selection[choice];used_abcd.add(d);}
					else {System.out.println("Error Catching rand int");}
			}
            used_abcd.clear();//Clearing storage for next number

        System.out.println(a);


        //Buttons
        int x_value = 80;
        A = new JButton("A. "+a);
        A.setBounds(x_value,230,500,50);
        A.setFont(Myfont);
        A.setBackground(blo);
        A.setForeground(Color.white);
        A.setFocusable(false);
        A.addActionListener(this);
        A.setVisible(true);

        B = new JButton("B. "+b);
        B.setBounds(x_value,300,500,50);
        B.setFont(Myfont);
        B.setBackground(blo);
        B.setForeground(Color.white);
        B.setFocusable(false);
        B.addActionListener(this);
        B.setVisible(true);

        C = new JButton("C. "+c);
        C.setBounds(x_value,370,500,50);
        C.setFont(Myfont);
        C.setBackground(blo);
        C.setForeground(Color.white);
        C.setFocusable(false);
        C.addActionListener(this);
        C.setVisible(true);

        D = new JButton("D. "+d);
        D.setBounds(x_value,440,500,50);
        D.setFont(Myfont);
        D.setBackground(blo);
        D.setForeground(Color.white);
        D.setFocusable(false);
        D.addActionListener(this);
        D.setVisible(true);
        
        back = new JButton("<");  //BACK Button
        back.setBounds(10,10,30,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.red);
        back.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        back.setBorder(new LineBorder(Color.BLACK, 1));
        back.setFocusable(false);
        back.setVisible(true);
        back.addActionListener(this);

        //Score Display Elements
        bronze  = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/1star.png")).getImage().getScaledInstance(155, 153, Image.SCALE_DEFAULT)));
        silver  = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/2star.png")).getImage().getScaledInstance(155, 153, Image.SCALE_DEFAULT)));
        gold  = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/3star.png")).getImage().getScaledInstance(155, 153, Image.SCALE_DEFAULT)));
        medals.add(bronze);
        medals.add(silver);
        medals.add(gold);
        


        trophy = new JLabel();
        trophy.setIcon(medals.get(0));
        trophy.setBounds(390,135,155,153);

        JLabel gameover = new JLabel("GAME OVER");
        gameover.setBounds(120,10,500,150);
        gameover.setFont(new Font("Eight Bit Dragon",Font.BOLD  ,70));
        gameover.setForeground(Color.yellow);
        gameover.setVisible(true); 

        score_display= new JLabel("20/23");
        score_display.setBounds(170,170,300,100);
        score_display.setFont(new Font("Eight Bit Dragon",Font.BOLD  ,60));
        score_display.setVisible(true);
        
        comment = new JLabel("NA");
        comment.setFont(new Font("Eight Bit Dragon",Font.BOLD  ,20));
        comment.setBounds(160,250,500,100);
        comment.setVisible(true);

        play_no = new JButton("Exit");
        play_no.setBounds(150,350,150,60);
        play_no.setForeground(Color.red);
        play_no.setFont(new Font("Eight Bit Dragon",Font.BOLD  ,20));
        play_no.setBackground(Color.darkGray);
        play_no.setBorder(BorderFactory.createLineBorder(Color.black,2));
        play_no.setFocusable(false);
        play_no.setVisible(true);
        play_no.addActionListener(this);

        play_yes = new JButton("Try Again");
        play_yes.setBounds(350,350,150,60);
        play_yes.setForeground(Color.GREEN);
        play_yes.setFont(new Font("Eight Bit Dragon",Font.BOLD  ,20));
        play_yes.setBackground(Color.darkGray);
        play_yes.setBorder(BorderFactory.createLineBorder(Color.black,2));
        play_yes.setFocusable(false);
        play_yes.setVisible(true);
        play_yes.addActionListener(this);



        //Panel
        gaming = new JPanel();
        gaming.setBounds(0,0,700,600);
        gaming.setLayout(null);
        gaming.setBackground(new Color(112233));
        gaming.add(question);
        gaming.add(no);
        gaming.add(A);
        gaming.add(B);
        gaming.add(C);
        gaming.add(D);
        gaming.add(back);
        gaming.setVisible(true);

        score_panel = new JPanel();
        score_panel.setBounds(0,0,700,600);
        score_panel.setLayout(null);
        score_panel.setBackground(new Color(112233));
        score_panel.add(gameover);
        score_panel.add(score_display);
        score_panel.add(trophy);
        score_panel.add(play_no);
        score_panel.add(play_yes);
        score_panel.add(comment);
        score_panel.setVisible(false);

        

        //THE FRAME
        playarea.setSize(700,600);
        playarea.getContentPane().setBackground(new Color(112233));
        playarea.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        playarea.setLocationRelativeTo(null);
        playarea.setLayout(null);
        playarea.setResizable(false);   
        playarea.add(score_panel);
        playarea.add(gaming);
        
        
        
        playarea.setVisible(true);
        music.togglebkg(database.music_hope);
        
   
    }


    public void endgame(){
        music.togglebkg("stop");
        gaming.setVisible(false);
        score_panel.setVisible(true);
        System.out.println("Your score is "+ score+"/"+quiz_items);
        score_display.setText(" "+score+"/"+quiz_items);
        grade= grade(score, quiz_items);
        System.out.println("Grade = "+grade);
        trophy.setIcon(medals.get(grade));
        comment.setText(comms.get(grade).get(random.nextInt(3)));
        String [] bkg = {database.sfx_fail,database.sfx_good,database.sfx_high};
        music.playsfx(bkg[grade]);

        

    }

    public static int grade(int point,int items){
        int mid = items/2;
        int x=0;
        int good_score=items-2;
        if(point<=mid){x=0;}
        else if((point>mid)&&(point<good_score)){x+=1;}
        else{x+=2;}
        return x;    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==A){
        music.playsfx(database.sfx_button1);
        //Check if correct or not and adding points 
        System.out.println(correct+", "+ a);
        if(correct==a){
            System.out.println("Correct");
            score+=1;
        }
        else{System.out.println("Incorrect");}


            //Next QUestion Code from here
            rand+=1;
            if(used.size()!=quiz_items){
                System.out.println("Button A"); 

                q = random.nextInt(quiz_items);
                while(used.contains(q)) {q = random.nextInt(quiz_items);}//while loop is neccessary after frst question
                used.add(q);
                int question_index =(database.quizes.get(guide).get(database.quiz_semi).indexOf(database.quizes.get(guide).get(database.quiz_semi).get(q)));

                
                quest.setText(database.quizes.get(guide).get(database.quiz_semi).get(q));
                no.setText("Question no. "+(rand+1));

                //NEW CHOICES HERE
                correct = database.quizes.get(guide).get(database.quiz_semi+1).get(q);//correct answer
                

                //Getting selections 
                String [] selection = new String[abcd]; //add the selection here so random can choose from it by indexing
                for(int j = 0; j<abcd;j++) {
                    selection[j]=database.quizes.get(guide).get(database.quiz_semi+j+1).get(question_index);	//Looping to add questions to Array
                }
                

                a=" ";
                b=" ";
                c=" ";
                d=" ";        
                //assigning values to a,b,c, and d
                for(int k = 0;k<selection.length;k++) {
                    int choice = random.nextInt(abcd);
                    while(used_abcd.contains(selection[choice])) {										//While loop to make sure a/b/c/d does not repeat
                            choice = random.nextInt(abcd);}
                            if(a.equals(" ")) {a=selection[choice];used_abcd.add(a);}
                            else if(b.equals(" ")) {b=selection[choice];used_abcd.add(b);}
                            else if(c.equals(" ")) {c=selection[choice];used_abcd.add(c);}
                            else if(d.equals(" ")){d=selection[choice];used_abcd.add(d);}
                            else {System.out.println("Error Catching rand int");}
                    }
                    System.out.println(used_abcd);
                
                
                //Setting the button texts to the new choices
                A.setText("A. "+a);
                B.setText("B. "+b);    
                C.setText("C. "+c);
                D.setText("D. "+d);
                used_abcd.clear();//Clearing storage for next number

                }
            else{
                endgame();
            }
            
        
        }
        else if(e.getSource()==B){
        //Check if correct or not and adding points 
        music.playsfx(database.sfx_button1);
        System.out.println(correct+", "+ b);
        if(correct==b){
            System.out.println("Correct");
            score+=1;
        }
        else{System.out.println("Incorrect");}


            //Next QUestion Code from here
            rand+=1;
            if(used.size()!=quiz_items){
                System.out.println("Button A"); 

                q = random.nextInt(quiz_items);
                while(used.contains(q)) {q = random.nextInt(quiz_items);}//while loop is neccessary after frst question
                used.add(q);
                int question_index =(database.quizes.get(guide).get(database.quiz_semi).indexOf(database.quizes.get(guide).get(database.quiz_semi).get(q)));

                
                quest.setText(database.quizes.get(guide).get(database.quiz_semi).get(q));
                no.setText("Question no. "+(rand+1));

                //NEW CHOICES HERE
                correct = database.quizes.get(guide).get(database.quiz_semi+1).get(q);//correct answer
                

                //Getting selections 
                String [] selection = new String[abcd]; //add the selection here so random can choose from it by indexing
                for(int j = 0; j<abcd;j++) {
                    selection[j]=database.quizes.get(guide).get(database.quiz_semi+j+1).get(question_index);	//Looping to add questions to Array
                }
                

                a=" ";
                b=" ";
                c=" ";
                d=" ";        
                //assigning values to a,b,c, and d
                for(int k = 0;k<selection.length;k++) {
                    int choice = random.nextInt(abcd);
                    while(used_abcd.contains(selection[choice])) {										//While loop to make sure a/b/c/d does not repeat
                            choice = random.nextInt(abcd);}
                            if(a.equals(" ")) {a=selection[choice];used_abcd.add(a);}
                            else if(b.equals(" ")) {b=selection[choice];used_abcd.add(b);}
                            else if(c.equals(" ")) {c=selection[choice];used_abcd.add(c);}
                            else if(d.equals(" ")){d=selection[choice];used_abcd.add(d);}
                            else {System.out.println("Error Catching rand int");}
                    }
                    System.out.println(used_abcd);
                
                
                //Setting the button texts to the new choices
                A.setText("A. "+a);
                B.setText("B. "+b);    
                C.setText("C. "+c);
                D.setText("D. "+d);
                used_abcd.clear();//Clearing storage for next number

                }
            else{
                endgame();
            }

        }
        else if(e.getSource()==C){
        //Check if correct or not and adding points 
        music.playsfx(database.sfx_button1);
        System.out.println(correct+", "+ c);
        if(correct==c){
            System.out.println("Correct");
            score+=1;
        }
        else{System.out.println("Incorrect");}


            //Next QUestion Code from here
            rand+=1;
            if(used.size()!=quiz_items){
                System.out.println("Button C"); 

                q = random.nextInt(quiz_items);
                while(used.contains(q)) {q = random.nextInt(quiz_items);}//while loop is neccessary after frst question
                used.add(q);
                int question_index =(database.quizes.get(guide).get(database.quiz_semi).indexOf(database.quizes.get(guide).get(database.quiz_semi).get(q)));

                
                quest.setText(database.quizes.get(guide).get(database.quiz_semi).get(q));
                no.setText("Question no. "+(rand+1));

                //NEW CHOICES HERE
                correct = database.quizes.get(guide).get(database.quiz_semi+1).get(q);//correct answer
                

                //Getting selections 
                String [] selection = new String[abcd]; //add the selection here so random can choose from it by indexing
                for(int j = 0; j<abcd;j++) {
                    selection[j]=database.quizes.get(guide).get(database.quiz_semi+j+1).get(question_index);	//Looping to add questions to Array
                }
                

                a=" ";
                b=" ";
                c=" ";
                d=" ";        
                //assigning values to a,b,c, and d
                for(int k = 0;k<selection.length;k++) {
                    int choice = random.nextInt(abcd);
                    while(used_abcd.contains(selection[choice])) {										//While loop to make sure a/b/c/d does not repeat
                            choice = random.nextInt(abcd);}
                            if(a.equals(" ")) {a=selection[choice];used_abcd.add(a);}
                            else if(b.equals(" ")) {b=selection[choice];used_abcd.add(b);}
                            else if(c.equals(" ")) {c=selection[choice];used_abcd.add(c);}
                            else if(d.equals(" ")){d=selection[choice];used_abcd.add(d);}
                            else {System.out.println("Error Catching rand int");}
                    }
                    System.out.println(used_abcd);
                
                
                //Setting the button texts to the new choices
                A.setText("A. "+a);
                B.setText("B. "+b);    
                C.setText("C. "+c);
                D.setText("D. "+d);
                used_abcd.clear();//Clearing storage for next number

                }
            else{
                endgame();
            }
        
        }
        else if(e.getSource()==D){
            //Check if correct or not and adding points 
            music.playsfx(database.sfx_button1);
            System.out.println(correct+", "+ d);
            if(correct==d){
                System.out.println("Correct");
                score+=1;
            }
            else{System.out.println("Incorrect");}


            //Next QUestion Code from here
            rand+=1;
            if(used.size()!=quiz_items){
                System.out.println("Button D"); 

                q = random.nextInt(quiz_items);
                while(used.contains(q)) {q = random.nextInt(quiz_items);}//while loop is neccessary after frst question
                used.add(q);
                int question_index =(database.quizes.get(guide).get(database.quiz_semi).indexOf(database.quizes.get(guide).get(database.quiz_semi).get(q)));

                
                quest.setText(database.quizes.get(guide).get(database.quiz_semi).get(q));
                no.setText("Question no. "+(rand+1));

                //NEW CHOICES HERE
                correct = database.quizes.get(guide).get(database.quiz_semi+1).get(q);//correct answer
                

                //Getting selections 
                String [] selection = new String[abcd]; //add the selection here so random can choose from it by indexing
                for(int j = 0; j<abcd;j++) {
                    selection[j]=database.quizes.get(guide).get(database.quiz_semi+j+1).get(question_index);	//Looping to add questions to Array
                }
                

                a=" ";
                b=" ";
                c=" ";
                d=" ";        
                //assigning values to a,b,c, and d
                for(int k = 0;k<selection.length;k++) {
                    int choice = random.nextInt(abcd);
                    while(used_abcd.contains(selection[choice])) {										//While loop to make sure a/b/c/d does not repeat
                            choice = random.nextInt(abcd);}
                            if(a.equals(" ")) {a=selection[choice];used_abcd.add(a);}
                            else if(b.equals(" ")) {b=selection[choice];used_abcd.add(b);}
                            else if(c.equals(" ")) {c=selection[choice];used_abcd.add(c);}
                            else if(d.equals(" ")){d=selection[choice];used_abcd.add(d);}
                            else {System.out.println("Error Catching rand int");}
                    }
                    System.out.println(used_abcd);
                
                
                //Setting the button texts to the new choices
                A.setText("A. "+a);
                B.setText("B. "+b);    
                C.setText("C. "+c);
                D.setText("D. "+d);
                used_abcd.clear();//Clearing storage for next number

                }
            else{
                endgame();
            }
        
        }
        else if(e.getSource()==play_no){
            score=0;
            new Select();
            music.sfx.stop();
            music.togglebkg("stop");
            music.togglebkg(database.music_shindig);
            playarea.dispose();
        }

        else if(e.getSource()==play_yes){
            score=0;
            music.sfx.stop();
            new play(guide);
            playarea.dispose();
        }


        else if(e.getSource()==back){
            music.playsfx(database.sfx_button4);
            music.togglebkg("stop");
            new Select();
            music.togglebkg(database.music_shindig);
            playarea.dispose();
        }

    }
}
