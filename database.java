import java.util.*;
public  class database {
        public static LinkedList<LinkedList<LinkedList<String>>> quizes = new LinkedList<>();
        

        //DEFAULT QUIZ                                                                        Question 1             									   Question2                 				 
        public static LinkedList <String> ques =  new LinkedList <> (Arrays.asList("<html><br>What is a correct syntax to output \"Hello World\" in Java?</html>","<html><br>How do you insert COMMENTS in Java code?</html>",
			//Question 3											Qustion 4
		"<html><br>What data type is used to store text?</html>","<html><br>Which method can be used to find the lenght of a string?</html>","Best Teacher!!","<html><br>Which keyword is used to import a package from the java API Library?</html>","Which statement is used to stop a while loop")); //Question
        
		
		
		
		
		public static LinkedList <String> ans = new LinkedList <> (Arrays.asList(      "System.out.println(\"Hello World\");",                 "//this is a comment",               				"String",             "lenght();",                   		  "Maam Melene",  "import",      "break"));//Answer
        public static LinkedList <String> x = new LinkedList <> (Arrays.asList(        "print(\"Hello World\")",                      		"#this is a comment",            						  "string",               "getSize()",   					  "Jommanuel",    "package",		"return"));//x Answer
        public static LinkedList <String> y = new LinkedList <> (Arrays.asList(        "echo(\"Hello World\");",                    			 "/*this is a comment",            					 "myString",             "len()",                		    "Maam Zesty",   "getlib",		"stop"));//x Answer
        public static LinkedList <String> z = new LinkedList <> (Arrays.asList(        "System.out.println(\"Hello World\")",                   "Comment(\"this is a comment\")",           		  "Txt",         		  "getLenght()",                      "Jezzrill",     "lib",		"exit"));//x Answer
        public static String [] quiz_names = new String[5];		
        public static int quiz_outer=0;
        public static int quiz_semi=0;
        public static int quiz_inner=0;
        
        public static void addquizname(int index, String name){
            quiz_names[index]= name;

        }


        //Importing quiz
        public static void import_quiz(LinkedList<LinkedList<LinkedList<String>>> quizes,LinkedList<String> ques,LinkedList<String> ans,LinkedList<String> x,
        LinkedList<String> y,LinkedList<String> z,int outer){
        int progress = 0;
    	quizes.add(new LinkedList<>());
    	quizes.get(outer).add(new LinkedList<>());
    	quizes.get(outer).add(new LinkedList<>());
    	quizes.get(outer).add(new LinkedList<>());
    	quizes.get(outer).add(new LinkedList<>());
    	quizes.get(outer).add(new LinkedList<>());

        for(int i=0;i<ques.size();i++)
		{quizes.get(outer).get(progress).add(legibleString(ques.get(i)));}
    	progress+=1;
    	quizes.get(outer).get(progress).addAll(ans);
    	progress+=1;
    	quizes.get(outer).get(progress).addAll(x);
    	progress+=1;
    	quizes.get(outer).get(progress).addAll(y);
    	progress+=1;
    	quizes.get(outer).get(progress).addAll(z);
        }

		//music/fx strings
		public static String music_shindig = "Audio/music_shindig8bit.wav";
		public static String music_littleroot = "Audio/music_Littleroot Town.wav";
		public static String music_hope = "Audio/A Bit Of Hope-David Fesliyan.wav";


		public static String sfx_fail = "Audio/score_fail.wav";
		public static String sfx_good = "Audio/score_good.wav";
		public static String sfx_high = "Audio/score_high.wav";
		public static String sfx_recover = "Audio/fx_recovery.wav";
		public static String sfx_button1 = "Audio/button1.wav";
		public static String sfx_button2 = "Audio/button2.wav";
		public static String sfx_button3 = "Audio/button3.wav";
		public static String sfx_button4 = "Audio/button4.wav";
		public static String sfx_button5 = "Audio/button5.wav";

		//mute switch
		public static boolean muted = false;
		public static boolean mute_switch(){
			if(muted==false){Menu.settings.setIcon(Menu.mute); return muted=true; }
			else{Menu.settings.setIcon(Menu.unmute); return muted=false;}
		}


		
		
		
		








        //Question HTMLifier by Sumbing
        public static String legibleString(String txt){
        int lentxt=txt.length();
        String y = "";
        if (lentxt<=50){return"<html><br>"+txt+"</html>";}
		else if(lentxt>50){
		String word="<html>";
		LinkedList<Character> txtarray= new LinkedList<>();
		for (int i=0;i<lentxt;i++){
			txtarray.add(txt.charAt(i));
		}
		for (int x=50;x<lentxt;x++){
		if (txtarray.get(x).equals(' ')){
			txtarray.remove(x);                    
			txtarray.add(x,'>');txtarray.add(x,'r');  
			txtarray.add(x,'b');txtarray.add(x,'<');       
			x=x+50;   
			}      
		}
		for (int b=0;b<txtarray.size();b++){  
			word=word+(txtarray.get(b));
		} 
                y= word+"</html>";	
	}
        return y;
        }
    
}
