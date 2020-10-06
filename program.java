import java.io.*;
import java.util.ArrayList;

public class program {
    public static void main(String[] args) throws Exception{
//        File file = new File(args[0]);
        File file = new File("src/work.txt");
        FileReader reader = new FileReader(file);
        BufferedReader breader = new BufferedReader(reader);
        StringBuilder sb = new StringBuilder();
        String s = "";
        String letters = "";
        while ((s =breader.readLine()) != null) {
            sb.append(s + "\n");
        }
        breader.close();
        String str = sb.toString();
        int slength = str.length();
        int set = -1;
        int tokenlength = 0;
        int num;
        while(set<slength){
            set++;
            tokenlength=0;
            while(str.charAt(set)==' '||str.charAt(set)=='\n'||str.charAt(set)=='\r'){
                set++;
            }
            if((str.charAt(set)>='A'&&str.charAt(set)<='Z')||(str.charAt(set)>='a'&&str.charAt(set)<='z')){
                while((str.charAt(set)>='A'&&str.charAt(set)<='Z')||(str.charAt(set)>='a'&&str.charAt(set)<='z')||(str.charAt(set)>='0'&&str.charAt(set)<='9')){
                    tokenlength++;
                    set++;
                }
                set--;
                letters = str.substring(set+1-tokenlength,set+1);
                if(letters.equals("BEGIN")||letters.equals("END")||letters.equals("FOR")||letters.equals("IF")||letters.equals("THEN")||letters.equals("ELSE")){
                    char[] cs=letters.toCharArray();
                    for(int i = 1;i < letters.length();i++){
                        cs[i]+=32;
                    }
                    letters = String.valueOf(cs);
                    System.out.println(letters);
                }
                else {
                    System.out.println("Ident("+letters+")");
                }
            }
            else if(str.charAt(set)>='0'&&str.charAt(set)<='9'){
                while(str.charAt(set)>='0'&&str.charAt(set)<='9'){
                    tokenlength++;
                    set++;
                }
                set--;
                letters = str.substring(set+1-tokenlength,set+1);
                System.out.println("Int("+Integer.parseInt(letters)+")");
            }
            else if (str.charAt(set)==':'){
                set++;
                if(str.charAt(set)=='='){
                    System.out.println("Assign");
                }
                else {
                    System.out.println("Colon");
                    set--;
                }
            }
            else if (str.charAt(set)=='+'){
                System.out.println("Plus");
            }
            else if (str.charAt(set)=='*'){
                System.out.println("Star");
            }
            else if (str.charAt(set)==','){
                System.out.println("Comma");
            }
            else if (str.charAt(set)=='('){
                System.out.println("LParenthesis");
            }
            else if (str.charAt(set)==')'){
                System.out.println("RParenthesis");
            }
            else {
                System.out.println("Unknown");
                break;
            }
        }
    }
}
