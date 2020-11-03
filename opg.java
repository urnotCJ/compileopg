import java.io.*;
import java.util.ArrayList;

public class opg {
    public static void main(String[] args) throws Exception{
        File file = new File(args[0]);
        //File file = new File("src/work.txt");
        FileReader reader = new FileReader(file);
        BufferedReader breader = new BufferedReader(reader);
        String sb = "";
        String s = "";
        String letters = "";
        int a[] = new int[1005];
        int b[] = new int[1005];
        int c[] = new int[1005];
        a[0] = 0;
        b[0] = 0;
        int j = 1;
        while ((sb =breader.readLine()) != null) {
            s = s+sb;
        }
        breader.close();
        int length = s.length();
        for(int i = 0;i < length;i ++){
            if(s.charAt(i)=='\r'&&s.charAt(i+1)=='\n'){
                break;
            }
            if(s.charAt(i)=='+'){
                a[j] = 1;
                j++;
            }
            else if(s.charAt(i)=='*'){
                a[j] = 2;
                j++;
            }
            else if(s.charAt(i)=='i'){
                a[j] = 3;
                j++;
            }
            else if(s.charAt(i)=='('){
                a[j] = 4;
                j++;
            }
            else if(s.charAt(i)==')'){
                a[j] = 5;
                j++;
            }
            else {
                a[j] = 7;
                j++;
            }
        }
        a[j]=0;
        int seta = 1,setb = 0,setc = 0,controla=1,coc = 0,coc1=0;
        while(seta<=j&&setb>=0){
            if(fail(a[seta-1],a[seta])==1){
                setc=1;
                setb=0;
                seta=j;
                System.out.println("E");
                break;
            }
            if(a[seta]==3){
                System.out.println("Ii");
                setc++;
                seta++;
                controla=1;
                coc = 1;
            }
            else{
                if(a[seta-1]==3&&controla==1){
                    System.out.println("R");
                    controla=0;
                }
                if(power(b[setb],a[seta])==1){
                    if(setc==0&&a[seta]!=4){
                        break;
                    }
                    setb++;
                    b[setb]=a[seta];
                    seta++;
                    if(b[setb]==1){
                        System.out.println("I+");
                        coc = 0;
                    }
                    else if (b[setb]==2){
                        System.out.println("I*");
                        coc = 0;
                    }
                    else if (b[setb]==4){
                        System.out.println("I(");
                    }
                }
                else if(power(b[setb],a[seta])==4){
                    if(a[seta]!=0){
                        System.out.println("E");
                    }
                    else {
                        System.out.println("RE");
                    }
                    setc=1;
                    setb=0;
                    seta=j;
                    break;
                }
                else{
                    while((power(b[setb],a[seta])==2||power(b[setb],a[seta])==3)){
                        if(coc==0){
                            coc1=1;
                            break;
                        }
                        if(setb==0){
                            break;
                        }
                        if(power(b[setb],a[seta])==2){
                            setb--;
                            setc--;
                            if(setc<=0||setb<0){
                                break;
                            }
                            System.out.println("R");
                        }
                        else if (power(b[setb],a[seta])==3){
                            setb--;
                            seta++;
                            if(setc<=0||setb<0){
                                break;
                            }
                            System.out.println("I)\nR");
                        }
                    }
                    if(coc1==1){
                        break;
                    }
                }
                if(setb==0&&seta==j){
                    break;
                }
            }
        }
        if(setc!=1||setb!=0||seta!=j){
            System.out.println("RE");
        }
    }
    public static int fail(int a,int b){
        if(a==3&&b==3||a==3&&b==4||a==5&&b==3||a==5&&b==4||a==0&&b==5||a==4&&b==0){
            return 1;
        }
        return 0;
    }
    public static int power(int a,int b){
        if(a==0){
            if(b==0)
                return 3;
            else if(b==1)
                return 1;
            else if(b==2)
                return 1;
            else if (b==3)
                return 1;
            else if (b==4)
                return 1;
            else if (b==5)
                return 4;
            return 4;
        }
        else if(a==1){
            if(b==0)
                return 2;
            else if(b==1)
                return 2;
            else if(b==2)
                return 1;
            else if (b==3)
                return 1;
            else if (b==4)
                return 1;
            else if (b==5)
                return 2;
            return 4;
        }
        else if(a==2){
            if(b==0)
                return 2;
            else if(b==1)
                return 2;
            else if(b==2)
                return 2;
            else if (b==3)
                return 1;
            else if (b==4)
                return 1;
            else if (b==5)
                return 2;
            return 4;
        }
        else if(a==3){
            if(b==0)
                return 2;
            else if(b==1)
                return 2;
            else if(b==2)
                return 2;
            else if (b==3)
                return 4;
            else if (b==4)
                return 4;
            else if (b==5)
                return 2;
            return 4;
        }
        else if(a==4){
            if(b==0)
                return 4;
            else if(b==1)
                return 1;
            else if(b==2)
                return 1;
            else if (b==3)
                return 1;
            else if (b==4)
                return 1;
            else if (b==5)
                return 3;
            return 4;
        }
        else if(a==5){
            if(b==0)
                return 2;
            else if(b==1)
                return 2;
            else if(b==2)
                return 2;
            else if (b==3)
                return 4;
            else if (b==4)
                return 4;
            else if (b==5)
                return 2;
            return 4;
        }
//        else if(a==6){
//            if(b==0)
//                return 2;
//            else if(b==1)
//                return 1;
//            else if(b==2)
//                return 1;
//            else if (b==3)
//                return 1;
//            else if (b==4)
//                return 4;
//            else if (b==5)
//                return 2;
//            return 4;
//        }
        return 4;
    }
}
