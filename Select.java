import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Select extends JFrame implements ActionListener{
    JFrame start;
    JButton quiz1,quiz2,quiz3,quiz4,quiz5,back;
    JButton del2,del3,del4,del5;
    Color blo = new Color(37,49,64);
    Color main_color = new Color(112233);
    Font Myfont = new Font("Eight Bit Dragon",Font.BOLD,15);
    int index = 0;
    int buttonnum;
    LineBorder Default_border = new LineBorder(Color.white, 3);
    JLayeredPane layers;

    Select(){

        //Back Button
        back = new JButton("<");
        back.setBounds(10,10,30,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.red);
        back.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        back.setBorder(new LineBorder(Color.BLACK, 1));
        back.setFocusable(false);
        back.setVisible(true);
        back.addActionListener(this);

       
        
        


        quiz1 = new JButton(database.quiz_names[0]);
        quiz1.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        quiz1.setForeground(Color.white);
        quiz1.setBounds(10,50,500,80);
        quiz1.setBorder(Default_border);
        quiz1.setBackground(Color.black);
        quiz1.setVisible(true);
        quiz1.setFocusable(false);
        quiz1.addActionListener(this);


        //Non-Custom Quiz buttons
        quiz2 = new JButton(database.quiz_names[1]);
        quiz2.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        quiz2.setForeground(Color.white);
        quiz2.setBorder(Default_border);
        quiz2.setBounds(10,150,500,80);
        quiz2.setBackground(Color.BLACK);
        quiz2.addActionListener(this);
        quiz2.setFocusable(false);
        quiz2.setVisible(true);


        //Button to clear the 2nd quiz
        del2 = new JButton("X");
        del2.setBounds(510,173,50,30);
        del2.setForeground(Color.black);
        del2.setBorder(new LineBorder(Color.red, 3));
        del2.setFont(new Font("Comic sans",Font.BOLD,15));
        del2.setBackground(Color.red);
        del2.setFocusable(false);
        del2.setVisible(true);
        del2.addActionListener(this);

        quiz3 = new JButton(database.quiz_names[2]);
        quiz3.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        quiz3.setForeground(Color.white);
        quiz3.setBounds(10,250,500,80);
        quiz3.setBackground(Color.BLACK);
        quiz3.setVisible(true);
        quiz3.setBorder(Default_border);
        quiz3.setFocusable(false);
        quiz3.addActionListener(this);

        del3 = new JButton("X");
        del3.setBounds(510,273,50,30);
        del3.setForeground(Color.black);
        del3.setBorder(new LineBorder(Color.red, 3));
        del3.setFont(new Font("Comic sans",Font.BOLD,15));
        del3.setBackground(Color.red);
        del3.setFocusable(false);
        del3.setVisible(true);
        del3.addActionListener(this);

    

        quiz4 = new JButton(database.quiz_names[3]);
        quiz4.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        quiz4.setForeground(Color.white);
        quiz4.setBounds(10,350,500,80);
        quiz4.setBorder(Default_border);
        quiz4.setBackground(Color.BLACK);
        quiz4.setFocusable(false);
        quiz4.addActionListener(this);
        quiz4.setVisible(true);
        
        del4 = new JButton("X");
        del4.setBounds(510,373,50,30);
        del4.setForeground(Color.black);
        del4.setBorder(new LineBorder(Color.red, 3));
        del4.setFont(new Font("Comic sans",Font.BOLD,15));
        del4.setBackground(Color.red);
        del4.setFocusable(false);
        del4.setVisible(true);
        del4.addActionListener(this);
        


        quiz5 = new JButton(database.quiz_names[4]);
        quiz5.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        quiz5.setForeground(Color.white);
        quiz5.setBounds(10,450,500,80);
        quiz5.setBackground(Color.BLACK);
        quiz5.setBorder(Default_border);
        quiz5.setVisible(true);
        quiz5.setFocusable(false);
        quiz5.addActionListener(this);

        del5 = new JButton("X");
        del5.setBounds(510,473,50,30);
        del5.setForeground(Color.black);
        del5.setBorder(new LineBorder(Color.red, 3));
        del5.setFont(new Font("Comic sans",Font.BOLD,15));
        del5.setBackground(Color.red);
        del5.setFocusable(false);
        del5.setVisible(true);
        del5.addActionListener(this);

        //Modifications if Quiz is Empty
        if(database.quiz_names[4]==null){
            quiz5.setEnabled(false);
            quiz5.setText("Empty");
            del5.setVisible(false);
        }
        if(database.quiz_names[3]==null){
            quiz4.setEnabled(false);
            quiz4.setText("Empty");
            del4.setVisible(false);            
        }
        if(database.quiz_names[2]==null){
            quiz3.setEnabled(false);
            quiz3.setText("Empty");
            del3.setVisible(false);
            
        }

        if(database.quiz_names[1]==null){
            quiz2.setEnabled(false);
            quiz2.setText("Empty");
            del2.setVisible(false);
        }
     
        
        //JFRAME
        start = new JFrame("Quiz IT");
        start.setSize(700,600);
        start.getContentPane().setBackground(main_color);
        start.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        start.setLocationRelativeTo(null);
        start.setResizable(false);
        start.setLayout(null);
        
        start.add(back);
        start.add(quiz1);
        start.add(quiz2);start.add(del2);
        start.add(quiz3);start.add(del3);
        start.add(quiz4);start.add(del4);
        start.add(quiz5);start.add(del5);
        start.setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){//BACKBUTTON -> Home
            music.playsfx(database.sfx_button4);
            new Menu();
            start.dispose();
            
            
          
        }
        else if(e.getSource()==quiz1){//START QUIZ DEFAULT
            new play(0);
            start.dispose();
        }

        else if(e.getSource()==quiz2){//START QUIZ DEFAULT
            new play(1);
            start.dispose();
        }

        else if(e.getSource()==quiz3){//START QUIZ DEFAULT
            new play(2);
            start.dispose();
        }

        else if(e.getSource()==quiz4){//START QUIZ DEFAULT
            new play(3);
            start.dispose();
        }
        else if(e.getSource()==quiz5){//START QUIZ DEFAULT
            new play(4);
            start.dispose();
        }
        


        else if(e.getSource()==del2){
            System.out.println(database.quiz_names[1] +"Has beeen deleted");
            database.quiz_names[1]= null;
            //CODE TO DELETE FROM ques Linked List
            new Select();
            start.dispose();

            
        }
        else if(e.getSource()==del3){
            System.out.println(database.quiz_names[2] +"Has beeen deleted");
            database.quiz_names[2]= null;
            //CODE TO DELETE FROM ques Linked List
            new Select();
            start.dispose();

            
        }
        else if(e.getSource()==del4){
            System.out.println(database.quiz_names[3] +"Has beeen deleted");
            database.quiz_names[3]= null;
            //CODE TO DELETE FROM ques Linked List
            new Select();
            start.dispose();

            
        }
        else if(e.getSource()==del5){
            System.out.println(database.quiz_names[4] +"Has beeen deleted");
            database.quiz_names[4]= null;
            //CODE TO DELETE FROM ques Linked List
            new Select();
            start.dispose();

            
        }
        
    
    

    }
}
