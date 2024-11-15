
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.*;
import javax.swing.border.LineBorder;


public class about extends JFrame implements MouseListener{
    JFrame about;
    JButton back,back1,next;
    JPanel members,teacher;
    JPanel profiles,info,characters;
    JLabel dev,mamel;
    ImageIcon bonnie,gem,mic,reyniel;
    JLabel ibonnie,igem,ireyniel,imic,us;
    JLabel devs;

    //INfos
    JLabel name,role,content,hobby,motto;

    //maam melene
    JLabel m_akil,prog,note,line;

    LinkedList <String> names = 
    new LinkedList<>(Arrays.asList(
        "  Bonnie Boy Franco III",
        "   Ejvind Gem Gimotea",
        "   John Mic Khael Sumbing",
        "    Reyniel Josh Rojo",
        "Melene Akil"
    ));
    LinkedList <Color> colors = 
    new LinkedList<>(Arrays.asList((new Color(1,50,32)),(new Color(107,0,0)),(new Color(0,45,114)),(new Color(80,35,128))));
    
    LinkedList <Color> colorful = 
    new LinkedList<>(Arrays.asList((new Color(1,50,32)),(new Color(21,1,11)),(new Color(21,34,59)),(new Color(21,12,37))));
   
    LinkedList <String> title = 
    new LinkedList<>(Arrays.asList("    Lead Developer","Back-end Developer","Back-end Developer","     Designer","Programming Teacher"));

    LinkedList <String> cont =
    new LinkedList<>(Arrays.asList(
        "<html>▶ Quiz it developer<br>▶ Designed user interface<br>▶ Managed team tasks<br>▶ Hulog ng Heaven<br>▶ \"may plite kapa da?\"</html>",
        "<html>▶ UX Design<br>▶ Audio director<br>▶ Fish are food not friends<br>▶ \"What time taka sugaton bon?\"</html>",
        "<html>▶ Game functions for UI<br>▶ QA tester<br>▶ Pancit Canton<br>▶ \"What time taka pukawon bon?\"<br>▶ \"Halong kamo tol\"</html>",
        "<html>▶ UI Design<br>▶ Game assets & fonts<br>▶ Bike > Laptop<br>▶ Chef<br>▶ \"Mauna ko uli\"</html>")
    );

    
    


    Color blo = new Color(37,49,64);
    Color main_color = new Color(112233);
    Color hover_color = Color.YELLOW;
    Font Myfont = new Font("Eight Bit Dragon",Font.BOLD,15);

    about() {
        //Labels
        name = new JLabel(names.get(0));
        name.setBounds(15,0,400,80);
        bitFont(name, 30);

        role = new JLabel(title.get(0));
        role.setBounds(155,20,400,100);
        bitFont(role,13);
        role.setForeground(Color.black); 
        
        content = new JLabel();
        content.setBounds(50,90,400,120);
        pixeFont(content, 20);
        content.setForeground(Color.darkGray);
        content.setVisible(true);

        m_akil = new JLabel(names.get(4));
        m_akil.setBounds(285,310,400,80);
        m_akil.setForeground(new Color(197,75,140));
        bitFont(m_akil, 30);
        m_akil.setVisible(true);

        prog = new JLabel(title.get(4));
        prog.setBounds(300,350,400,50);
        bitFont(prog,13);
        prog.setForeground(Color.black); 

        line = new JLabel("<html>ITE 186 Finals Capstone S.Y 2023-2024</html>");
        bitFont(line, 11);
        line.setBounds(250,550,400,80);
        line.setForeground(Color.black);
        
        note = new JLabel("<html><br>▶ Our idol<br>▶ Our Inspiration<br>▶ Amen</html>");
        bitFont(note, 15);
        note.setBounds(285,385,400,80);
        note.setForeground(Color.black);
        

        

        
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

        back1 = new JButton("<");
        back1.setBounds(10,10,30,30);
        back1.setBackground(Color.BLACK);
        back1.setForeground(Color.red);
        back1.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        back1.setBorder(new LineBorder(Color.BLACK, 1));
        back1.setFocusable(false);
        back1.setVisible(true);
        back1.addMouseListener(this);

        next = new JButton(">");
        next.setBounds(690,10,30,30);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.red);
        next.setFont(new Font("Eight Bit Dragon",Font.BOLD,20));
        next.setBorder(new LineBorder(Color.BLACK, 1));
        next.setFocusable(false);
        next.setVisible(true);
        next.addMouseListener(this);

        

        devs = new JLabel("The Developers");
        devs.setBounds(175,45,500,60);
        devs.setForeground(Color.yellow);
        devs.setFont(new Font("Eight Bit Dragon",Font.BOLD,40));
        devs.setVisible(true);

        //Profile Images
        int x =225;
        int y =305;
        dev = new JLabel();
        dev.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("Icons/B.png")).getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT))));
        dev.setBounds(4,4,x,y);

        bonnie = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/B.png")).getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT)));
        gem = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/G.jpg")).getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT)));
        reyniel = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/R.png")).getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT)));
        mic = (new ImageIcon(new ImageIcon(getClass().getResource("Icons/J.jpg")).getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT)));
        
        
        mamel = new JLabel();
        mamel.setIcon(((new ImageIcon(new ImageIcon(getClass().getResource("Icons/M.png")).getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT)))));
        mamel.setBorder(BorderFactory.createLineBorder(Color.black, 4));
        mamel.setBounds(270,20,x,y);
        mamel.setVisible(true);

        

        //Profile Icons
        int iwid=75;
        int ihit=75;
        ibonnie = new JLabel();
        ibonnie.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("Icons/B_icon.png")).getImage().getScaledInstance(iwid, ihit, Image.SCALE_DEFAULT))));
        ibonnie.setBounds(25,13,iwid,ihit);
        ibonnie.setOpaque(true);
        ibonnie.setBorder(BorderFactory.createLineBorder(Color.black,1));
        ibonnie.setBackground(new Color(1,50,32));
        ibonnie.addMouseListener(this);

        igem = new JLabel();
        igem.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("Icons/G_icon.png")).getImage().getScaledInstance(iwid, 75, Image.SCALE_DEFAULT))));
        igem.setBounds(125,13,iwid,ihit);
        igem.setOpaque(true);
        igem.setBorder(BorderFactory.createLineBorder(Color.black,1));
        igem.setBackground(new Color(21,1,11));
        igem.addMouseListener(this);
        
        imic = new JLabel();
        imic.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("Icons/J_icon.png")).getImage().getScaledInstance(iwid, 75, Image.SCALE_DEFAULT))));
        imic.setBounds(225,13,iwid,ihit);
        imic.setOpaque(true);
        imic.setBorder(BorderFactory.createLineBorder(Color.black,1));
        imic.setBackground(new Color(21,34,59));
        imic.addMouseListener(this);
        
        ireyniel = new JLabel();
        ireyniel.setIcon((new ImageIcon(new ImageIcon(getClass().getResource("Icons/R_icon.png")).getImage().getScaledInstance(iwid, 75, Image.SCALE_DEFAULT))));
        ireyniel.setBounds(325,13,iwid,ihit);
        ireyniel.setOpaque(true);
        ireyniel.setBorder(BorderFactory.createLineBorder(Color.black,1));
        ireyniel.setBackground(new Color(21,12,37));
        ireyniel.addMouseListener(this);

        ImageIcon [] egg = {
            (new ImageIcon(new ImageIcon(getClass().getResource("Icons/quizitit.jpg")).getImage().getScaledInstance(408, 306, Image.SCALE_DEFAULT))),
            (new ImageIcon(new ImageIcon(getClass().getResource("Icons/it2.jpg")).getImage().getScaledInstance(512, 384, Image.SCALE_DEFAULT)))
        };
        Random rand = new Random(); 
        int r = rand.nextInt(2);
        System.out.println(r);
        us = new JLabel();
        us.setIcon(egg[r]);
        if(r==1){us.setBounds(110,110,512, 384);}
        else{us.setBounds(150,140,408, 306);}
        us.setBorder(BorderFactory.createLineBorder(Color.yellow,4));
        



        

        //Panels for Cards
        info =  new JPanel();
        info.setBounds(280,120,440,345);
        info.setBackground(Color.lightGray);
        info.setLayout(null);
        info.setBorder(BorderFactory.createLineBorder(Color.black,4));
        info.add(name);
        info.add(role);
        info.add(content);
        


        profiles = new JPanel();
        profiles.setBounds(40,140,x+8,y+8);
        profiles.setBackground(Color.white);
        profiles.setBorder(BorderFactory.createLineBorder(Color.black,4));
        profiles.setLayout(null);
        profiles.add(dev);
        
        us.setVisible(true);
        info.setVisible(false);
        profiles.setVisible(false);
        


        characters = new JPanel();
        characters.setBounds(150,500,425,100);
        characters.setLayout(null);
        characters.setBorder(BorderFactory.createLineBorder(Color.black,2));
        characters.setBackground(Color.darkGray);
        characters.add(ibonnie);
        characters.add(igem);
        characters.add(imic);
        characters.add(ireyniel);
        characters.setVisible(true);
        

        

        //Main panels
        members = new JPanel();
        members.setBounds(0,0,750,650);
        members.setLayout(null);
        members.setBackground(main_color);
        members.add(devs);
        members.add(info);
        members.add(profiles);
        members.add(us);
        members.add(back);
        members.add(next);
        members.add(characters);
        members.setVisible(true);

        teacher = new JPanel();
        teacher.setBounds(0,0,750,650);
        teacher.setLayout(null);
        teacher.add(back1);
        teacher.setBackground(Color.pink);
        teacher.add(mamel);
        teacher.add(m_akil);
        teacher.add(prog);
        teacher.add(line);
        teacher.add(note);
        teacher.setVisible(false);



        about = new JFrame("Quiz IT");
        about.setSize(750,650);
        about.getContentPane().setBackground(main_color);
        about.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        about.setLocationRelativeTo(null);
        about.setResizable(false);
        about.setLayout(null);
       
        about.add(members);
        about.add(teacher);
        
        about.setVisible(true);

        music.togglebkg("stop");
        music.togglebkg(database.music_littleroot);
            
            
    }
    public static void bitFont(JLabel label,int size){
        label.setFont(new Font("Eight Bit Dragon",Font.BOLD,size));
    }

    public static void pixeFont(JLabel label,int size){
        label.setFont(new Font("Pixeboy",Font.BOLD,size));
    }

    public void update_avatar(int x){
        if(x==2){bitFont(name, 25);}
        else{bitFont(name, 30);}
        name.setText(names.get(x));
        role.setText(title.get(x));
        members.setBackground(colorful.get(x));
        name.setForeground(colors.get(x));
        content.setText(cont.get(x));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource()==back){
            new Menu();
            about.dispose();
            music.playsfx(database.sfx_button4);
            music.togglebkg("stop");
            music.togglebkg(database.music_shindig);    
        }

        else if(e.getSource()==back1){
            music.playsfx(database.sfx_button4);
            teacher.setVisible(false);
            members.setVisible(true);

        }

        else if(e.getSource()==next){
            music.playsfx(database.sfx_button4);
            teacher.setVisible(true);
            members.setVisible(false);

        }

        else if ((e.getSource()==ibonnie)||(e.getSource()==igem)||(e.getSource()==ireyniel)||(e.getSource()==imic)){
            us.setVisible(false);
            info.setVisible(true);
            profiles.setVisible(true);
            if(e.getSource()==ibonnie){music.playsfx(database.sfx_button3);dev.setIcon(bonnie);update_avatar(0);}
            else if(e.getSource()==igem){music.playsfx(database.sfx_button3);dev.setIcon(gem);update_avatar(1);}
            else if(e.getSource()==ireyniel){music.playsfx(database.sfx_button3);dev.setIcon(reyniel);update_avatar(3);}
            else if(e.getSource()==imic){music.playsfx(database.sfx_button3);dev.setIcon(mic);update_avatar(2);}
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
        if(e.getSource()==ibonnie){ibonnie.setBorder(BorderFactory.createLineBorder(hover_color,3));}
        if(e.getSource()==igem){igem.setBorder(BorderFactory.createLineBorder(hover_color,3));}
        if(e.getSource()==imic){imic.setBorder(BorderFactory.createLineBorder(hover_color,3));}
        if(e.getSource()==ireyniel){ireyniel.setBorder(BorderFactory.createLineBorder(hover_color,3));}
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==ibonnie){ibonnie.setBorder(BorderFactory.createLineBorder(Color.black,1));}
        if(e.getSource()==ireyniel){ireyniel.setBorder(BorderFactory.createLineBorder(Color.black,1));}
        if(e.getSource()==igem){igem.setBorder(BorderFactory.createLineBorder(Color.black,1));}
        if(e.getSource()==imic){imic.setBorder(BorderFactory.createLineBorder(Color.black,1));}
    }
    
}
