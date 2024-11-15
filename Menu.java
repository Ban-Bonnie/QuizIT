import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
//NAME
//BACK END DEVELOPERS
//START OUR PROGRAM
// WE HAVE A MUTE BUTTON ON THE BOTTOM RIGHT
//NOW WE WILL PROCEED TO THE DEFAULT GAME WHICH IS JAVA QUIZ
// THE QUESTIONS AND ANSWERS ARE RANDOMIZED
//U CAN GET DIFFERENT RESULT DEPENDING ON THE SCORE

public class Menu extends JFrame implements MouseListener{
    JFrame frame;
    ImageIcon quit;
    JButton play,create,about_us;
    Font buttfont = new Font("Eight Bit Dragon",Font.BOLD,30);
    Color blo = new Color(37,49,64);
    Color main_color = new Color(112233);
    public static JLabel settings;
    public static ImageIcon mute,unmute;

    //QUIZ SELECTION PAGE
    JFrame start,Quiz_Maker,about;
    JButton back,quiz1,quiz2,quiz3;
    Scanner sc = new Scanner(System.in);


    //PLAY AREA FRAME

    Menu(){

    mute = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/mute.png")).getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT)));
    unmute = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/unmute.png")).getImage().getScaledInstance(72, 72, Image.SCALE_DEFAULT)));
       
    settings = new JLabel();
    if(database.muted){settings.setIcon(mute);}
    else{settings.setIcon(unmute);}
    settings.setBounds(600,480,72,72);
    settings.addMouseListener(this);
    settings.setVisible(true);


    frame = new JFrame("Quiz IT");
    JLabel name = new JLabel("Quiz IT");
    name.setFont(new Font("Pixeboy",Font.BOLD,150));
    name.setBounds(100,0,500,300);
    


    
    play = new JButton("PLAY");
    play.setBounds(250,200,200,60);
    play.setBackground(blo);
    play.setForeground(Color.green);
    play.setFont(buttfont);
    play.setBorder(new LineBorder(Color.BLACK, 2));
    play.setFocusable(false);
    play.setVisible(true);
    play.addMouseListener(this);
        
    create = new JButton("Create");
    create.setBounds(250,280,200,60);
    create.setBackground(blo);
    create.setForeground(Color.green);
    create.setBorder(new LineBorder(Color.BLACK, 2));
    create.setFont(new Font("Eight Bit Dragon",Font.BOLD,30));
    create.setFocusable(false);
    create.setVisible(true);
    create.addMouseListener(this);


    about_us = new JButton("about us");
    about_us.setBounds(290,360,120,35);
    about_us.setBackground(blo);
    about_us.setForeground(Color.green);
    about_us.setBorder(new LineBorder(Color.BLACK, 2));
    about_us.setFont(new Font("Eight Bit Dragon",Font.BOLD,10));
    about_us.setFocusable(false);
    about_us.setVisible(true);
    about_us.addMouseListener(this);

    





    frame.setSize(700,600);
    frame.getContentPane().setBackground(main_color);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setLayout(null);

    frame.add(play);
    frame.add(create);
    frame.add(about_us);
    frame.add(name);
    frame.add(settings);
    frame.setVisible(true);

 
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==play){
            System.out.println("Play");
            music.playsfx(database.sfx_button5);
            new Select();
            frame.dispose();
            
             
        }
        else if(e.getSource()==create){
            System.out.println("CREATE QUIZ");
            music.playsfx(database.sfx_button5);
            new create();
            frame.dispose();
            
        }
        else if(e.getSource()==about_us){
            System.out.println("about us");
            music.playsfx(database.sfx_button5);
            new about();
            frame.dispose();

        //EXTRA BUTTONS
        }
        else if(e.getSource()==settings){   
            System.out.println("Settings");
            database.mute_switch();
            music.togglebkg(database.music_shindig);

        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}








    //GAME FUNCTIONS
    


