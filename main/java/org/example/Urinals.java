package org.example;
import java.util.Scanner;
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
    public void write_To_File(String optfile,int uri_cnt){
        try {
            FileWriter w = new FileWriter(optfile, true);
            BufferedWriter bufwri=new BufferedWriter(w);
            bufwri.write(Integer.toString(uri_cnt));
            bufwri.newLine();
            bufwri.close();
        }
        catch(IOException e){
            System.out.println("Error in opening output file");
            e.printStackTrace();
        }
    }
    public void open_File(String filepath) {
        try{
            Urinals u1=new Urinals();
            File f=new File(filepath);

            if(f==null)
                throw new IOException();

            File cf=new File("src/fileCount.txt");
            if(cf==null)
                throw new IOException();
            Scanner c = new Scanner(cf);
            int counter=Integer.parseInt(c.nextLine());

            String optFile="src/rule.txt";
            if(counter!=0)
                optFile="src/rule"+counter+".txt";

            Scanner sc=new Scanner(f);
            while(sc.hasNextLine()){
                String str=sc.nextLine();
                if(str.equals("-1")) break;
                int uri_cnt = u1.countUrinals(str);
                u1.write_To_File(optFile,uri_cnt);
                System.out.println(uri_cnt);
                }
            FileWriter cw=new FileWriter("src/fileCount.txt");
            if(cw==null)
                throw new IOException();
            cw.write(Integer.toString(counter+1));
            cw.close();
            System.out.println("Output is successfully written to rule file"+optFile);

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