import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class create extends JFrame implements MouseListener {
    //Data holders
    LinkedList <String> ques =  new LinkedList <> ();
    LinkedList <String> ok =  new LinkedList <> ();
    LinkedList <String> x =  new LinkedList <> ();
    LinkedList <String> y =  new LinkedList <> ();
    LinkedList <String> z =  new LinkedList <> ();
    
    //Layout
    JFrame create;
    JLabel title,teemo,publish_title,items;
    JButton back;
    Color blo = new Color(37,49,64);
    Color main_color = new Color(112233);
    Font Myfont = new Font("Eight Bit Dragon",Font.BOLD,15);
    ImageIcon emote1,emote2;
    int quescount=0;
    JButton done,next,finish,redirect;
    //Interface and inputs
    JTextField correct,wrong1,wrong2,wrong3,name;
    JTextArea question;
    JLabel verifier,confirm;
    JPanel quiz_create,quiz_publish,quiz_exported;
  
    

    create(){

        //Back Button
        back = new JButton("<");
        back.setBounds(10,10,30,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.red);
        back.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        back.setBorder(new LineBorder(Color.BLACK, 1));
        back.setFocusable(false);
        back.setVisible(true);
        back.addMouseListener(this);       

        //LABELS
        verifier = new JLabel("");
        verifier.setBounds(380,260,250,130);
        verifier.setFont(new Font("Serif",Font.BOLD,15));
        verifier.setForeground(Color.red);
        verifier.setVisible(false);
        verifier.addMouseListener(this);

        title = new JLabel("Create Quiz");
        title.setBounds(230,0,250,80);
        title.setFont(new Font("Eight Bit Dragon",Font.BOLD,30));

        publish_title = new JLabel("Name Your Quiz");
        publish_title.setBounds(250,40,250,80);
        publish_title.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));

        confirm = new JLabel("Successfully Added Quiz");
        confirm.setBounds(190,40,400,80);
        confirm.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));


        items = new JLabel();
        items.setBounds(290,100,250,20);
        items.setFont(new Font("Eight Bit Dragon",Font.BOLD,13));
        items.setForeground(Color.white);


        


        //IMAGES
        emote1 = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/teemolike.png")).getImage().getScaledInstance(256, 256, Image.SCALE_DEFAULT)));
        emote2 = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/teemopikachu.png")).getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT)));
        
        teemo = new JLabel();
        teemo.setIcon(emote1);
        teemo.setOpaque(false);
       
        teemo.setBounds(444,350,256,256);
        teemo.setVisible(true);    

        //Textfiels or Prompts
        question = new JTextArea("\n\n   Enter Question No. "+(quescount+1));
        question.setBounds(50,100,600,60);
        question.setFont(new Font("Eight Bit Dragon",Font.PLAIN,12));
        question.setBorder(new LineBorder(Color.black,1,true));
        question.setCaretColor(Color.lightGray);
        question.addMouseListener(this);

        correct = new JTextField("   Correct Answer here");
        correct.setBounds(350,180,250,40);
        correct.setFont(new Font("Eight Bit Dragon",Font.BOLD,12));
        correct.setForeground(main_color);
        correct.setBorder(new LineBorder(Color.green,1,true));
        correct.setCaretColor(Color.lightGray);
        correct.addMouseListener(this);

        wrong1 = new JTextField("   Wrong Answer here");
        wrong1.setBounds(50,180,250,40);
        wrong1.setFont(new Font("Eight Bit Dragon",Font.BOLD,12));
        wrong1.setForeground(Color.red);
        wrong1.setBorder(new LineBorder(Color.red,1,true));
        wrong1.setCaretColor(Color.lightGray);
        wrong1.addMouseListener(this);

        wrong2 = new JTextField("   Wrong Answer here");
        wrong2.setBounds(50,240,250,40);
        wrong2.setFont(new Font("Eight Bit Dragon",Font.BOLD,12));
        wrong2.setForeground(Color.red);
        wrong2.setBorder(new LineBorder(Color.red,1,true));
        wrong2.setCaretColor(Color.lightGray);
        wrong2.addMouseListener(this);

        wrong3 = new JTextField("   Wrong Answer here");
        wrong3.setBounds(50,300,250,40);
        wrong3.setFont(new Font("Eight Bit Dragon",Font.BOLD,12));
        wrong3.setForeground(Color.red);
        wrong3.setBorder(new LineBorder(Color.red,1,true));
        wrong3.setCaretColor(Color.lightGray);
        wrong3.addMouseListener(this);

        name = new JTextField();
        name.setBounds(210,130,250,40);
        name.setFont(new Font("Eight Bit Dragon",Font.BOLD,12));
        name.setForeground(Color.blue);
        name.setBorder(new LineBorder(Color.blue,1,true));
        name.setCaretColor(Color.lightGray);
        name.addMouseListener(this);

        


        //BUTTONS
        next = new JButton("Next Question");
        next.setBounds(380,240,180,40);
        next.setFocusable(false);
        next.setBorder(new LineBorder(Color.black,1));
        next.setBackground(blo);
        next.setForeground(Color.yellow);
        next.setFont(new Font("Eight Bit Dragon",Font.BOLD,13));
        next.setEnabled(false);
        next.addMouseListener(this);

        done = new JButton("Publish");
        done.setFont(new Font("Eight Bit Dragon",Font.BOLD,15));
        done.setFocusable(false);
        done.setBackground(blo);
        done.setForeground(Color.green);
        done.setBorder(new LineBorder(Color.black,1));
        done.setBounds(70,400,200,70);
        done.setEnabled(false);
        done.addMouseListener(this);

        finish = new JButton("Finish");
        finish.setFont(new Font("Eight Bit Dragon",Font.BOLD,15));
        finish.setFocusable(false);
        finish.setBackground(blo);
        finish.setForeground(Color.green);
        finish.setBorder(new LineBorder(Color.black,1));
        finish.setBounds(250,230,170,50);
        finish.addMouseListener(this);

        redirect = new JButton("Play Game");
        redirect.setBounds(260,120,150,50);
        redirect.setFont(new Font("Eight Bit Dragon",Font.BOLD,15));
        redirect.setBorder(new LineBorder(Color.black,1));
        redirect.setFocusable(false);
        redirect.setBackground(blo);
        redirect.setForeground(Color.green);
        redirect.addMouseListener(this);
        redirect.setVisible(true);


        
        //PANELSS
        quiz_create = new JPanel();
        quiz_create.setBounds(0,0,700,600);
        quiz_create.setBackground(main_color);
        quiz_create.setLayout(null);
        quiz_create.add(title);
        quiz_create.add(teemo);
        quiz_create.add(question);
        quiz_create.add(correct);
        quiz_create.add(wrong1);
        quiz_create.add(wrong2);
        quiz_create.add(wrong3);
        quiz_create.add(next);
        quiz_create.add(done);
        quiz_create.add(verifier);
        quiz_create.add(teemo);
        quiz_create.setVisible(true);

        quiz_publish = new JPanel();
        quiz_publish.setBounds(0,60,700,600);
        quiz_publish.setBackground(main_color);
        quiz_publish.setLayout(null);
        quiz_publish.add(publish_title);
        quiz_publish.add(items);
        quiz_publish.add(name);
        quiz_publish.add(finish);
        quiz_publish.setVisible(false);

        quiz_exported = new JPanel();
        quiz_exported.setBounds(0,60,700,600);
        quiz_exported.setBackground(main_color);
        quiz_exported.setLayout(null);
        quiz_exported.add(confirm);
        quiz_exported.add(redirect);
        quiz_exported.setVisible(false);
        


        


        

        create = new JFrame("Quiz IT");
        create.setSize(700,600);
        create.getContentPane().setBackground(main_color);
        create.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        create.setLocationRelativeTo(null);
        create.setResizable(false);
        create.setLayout(null);
        create.add(back);
        create.add(quiz_create);
        create.add(quiz_publish);
        create.add(quiz_exported);
        
        create.setVisible(true);
        //create.add(question);



    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==back){
            music.playsfx(database.sfx_button4);
            new Menu();
            create.dispose();
            System.out.println(database.quizes.size());//remove
          }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        String Q = question.getText();
        String newQ = "";
        String yes = correct.getText();
        String no1 = wrong1.getText();
        String no2 = wrong2.getText();
        String no3 = wrong3.getText();

        if(e.getSource()==question){
            if (question.getText().equals("\n\n   Enter Question No. "+(quescount+1)))
            {question.setText("\n ");}}
        else if(e.getSource()==correct){
            if(correct.getText().equals("   Correct Answer here"))
            {correct.setText("");}}
        else if(e.getSource()==wrong1){if(wrong1.getText().equals("   Wrong Answer here"))
            {wrong1.setText("");}}
        else if(e.getSource()==wrong2){if(wrong2.getText().equals("   Wrong Answer here"))
            {wrong2.setText("");}}
        else if(e.getSource()==wrong3){if(wrong3.getText().equals("   Wrong Answer here"))
            {wrong3.setText("");}}   

        
        else if(e.getSource()==next){
            if(next.isEnabled()==false){
                verifier.setText("<html>Requirements not met</html>");
                verifier.setVisible(true);
            } 
            else{//Minor adjust kasi if new Line  law ay present ya sa PLay
                if(Q.startsWith("\n")){
                    for(int i=2;i<Q.length();i++){
                        newQ += Q.charAt(i);
                    }
                    System.out.println(newQ);
                    ques.add(newQ);
                }
                else{ques.add(Q);}
                



                //Adding input to Linked our Local Linked List
                ok.add(yes);
                x.add(no1);
                y.add(no2);
                z.add(no3);

                quescount+=1;
                question.setText("\n\n   Enter Question No. "+(quescount+1));
                correct.setText("   Correct Answer here");
                wrong1.setText(("   Wrong Answer here"));
                wrong2.setText(("   Wrong Answer here"));
                wrong3.setText(("   Wrong Answer here"));
                if(ques.size()>=5){//SET MINIMUM ITEMS FOR QUIZ
                    done.setEnabled(true);
                }
                System.out.println(ques);//REMOVE THESE
                System.out.println(ok);
                System.out.println(x);
                System.out.println(y);
                System.out.println(z);
                next.setEnabled(false);


            } 
             
        }
        else if(e.getSource()==done){
            System.out.println("Donee");
            if(done.isEnabled()==false){
                verifier.setText("<html>You need at least 5<br>Items to publish a Quiz.</html>");
                verifier.setVisible(true);
            }
            else{
                quiz_create.setVisible(false);
                items.setText("Quiz items: "+ (quescount));
                quiz_publish.setVisible(true);
                
            }
        }
        else if(e.getSource()==finish){
            music.playsfx(database.sfx_recover);
            String n = name.getText();
            database.addquizname(database.quizes.size(), n);
            database.import_quiz(database.quizes, ques, ok, x, y, z, database.quizes.size());
            finish.setEnabled(false);
            quiz_publish.setVisible(false);
            quiz_exported.setVisible(true);
            System.out.println(database.quizes.size()-1);
        }
        else if(e.getSource()==redirect){
            new play(database.quizes.size()-1);
            create.dispose();
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
      
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==back){
            teemo.setIcon(emote2);
            teemo.setBounds(450,350,256,256);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==back){
            teemo.setIcon(emote1);
            teemo.setBounds(444,350,256,256);
        }
        if((e.getSource()==question)||(e.getSource()==correct)||(e.getSource()==wrong1)
            ||(e.getSource()==wrong2)||(e.getSource()==wrong3)){
            String Q = question.getText();
            String yes = correct.getText();
            String no1 = wrong1.getText();
            String no2 = wrong2.getText();
            String no3 = wrong3.getText();
            if((!Q.equals("n\n   Enter Question No. "+(quescount+1)))&&(!yes.equals("   Correct Answer here"))
                &&(!no1.equals("   Wrong Answer here"))&&(!no2.equals("   Wrong Answer here"))
                &&(!no3.equals("   Wrong Answer here"))){
                if(Q.length()>150){
                    verifier.setText("<html>Question Cannot contain more <br>than 150 Characters</html>");
                    verifier.setVisible(true);
                    next.setEnabled(false);
                }
                else if((yes.equals(no1))||(yes.equals(no2))||(yes.equals(no3))||
                        (no1.equals(no2))||(no1.equals(no3))||
                        (no2.equals(no3))){
                            verifier.setText("<html>Each Answer must be Unique</html>");
                            verifier.setVisible(true);
                            next.setEnabled(false);
                        }
                else{
                    verifier.setVisible(false);
                    next.setEnabled(true);
                }
            }
        }
    }
}
//HI