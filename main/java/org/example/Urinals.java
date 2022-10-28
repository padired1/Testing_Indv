package org.example;
import java.util.*;
import java.io.File;
import java.io.*;

/*Author
  Prathyusha Adireddi
*/
public class Urinals {
    public static void main(String[] args) {
        Urinals u=new Urinals();
        Scanner sc=new Scanner(System.in);
        System.out.println("Select an Option \n1.Keyboard\n2.File");
        int option=sc.nextInt();
        String str;
        if(option==1)
        {
            System.out.println("Enter input String");
            str=sc.next();
            int count=u.countUrinals(str);
            if(count==-1)
            {
                System.out.println("-1");
            }
            else {
                System.out.println(count);
            }
        }
        else {
            u.open_File("src/urinal.dat");
        }

    }
    public void open_File(String filepath) {
        try{
            Urinals u1=new Urinals();
            File f=new File(filepath);
            Scanner sc=new Scanner(f);
            while(sc.hasNextLine()){
                String str=sc.nextLine();
                if(str.equals("-1")){
                    break;}
                int uri_cnt = u1.countUrinals(str);

                System.out.println(uri_cnt);
                }
        }
        catch(IOException e)
        {
            System.out.println("Error in opening");
            e.printStackTrace();
        }

    }
     public boolean goodString(String str)
    {
        char[] ch=str.toCharArray();
        boolean good=true;
        int len=ch.length;
        if(str.matches("^[01]+$"))
        {
            for(int i=0;i<len-1;i++)
            {
                int start_index=Integer.parseInt(String.valueOf(ch[i]));
                int next_index=Integer.parseInt(String.valueOf(ch[i+1]));
                if(start_index==1 && next_index==1 )
                {
                    good=false;
                    break;
                }
            }
            return good;
        }
        else {
            return false;
        }
    }
    public int countUrinals(String str){
         Urinals ur=new Urinals();
         boolean flag=ur.goodString(str);
         if(!flag){
             return -1;
         }
        char[] ch=str.toCharArray();
         int total=0;
        int len=ch.length;
        int[] a =new int[len];
        for(int i=0;i<len;i++){
            a[i]=Integer.parseInt(String.valueOf(ch[i]));
        }
        if(len==1)
        {
            if(a[0]==0)
            {
                total=1;
                a[0]=1;
            }
        }
        else {
            int i=0;
            if(a[i]==0 && a[i+1]==0){
                a[i]=1;
                total++;
            }
            for(i=1;i<len-1;i++)
           {
              if(a[i]==0 && a[i-1]==0 && a[i+1]==0){
                a[i]=1;
                total++;
              }
           }
           if(a[i]==0 && a[i-1]==0)
          {
            total++;
            a[i] = 1;
          }
        }
      return total;
    }

}