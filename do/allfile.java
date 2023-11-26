import java.io.*;
public class allfile {
    public static void main(String[] args){
        try{
        File f=new File ("C:\\Users\\Prassanna\\Desktop\\vs code\\hi.txt");
        File f3=new File ("C:\\Users\\Prassanna\\Desktop\\vs code\\hi1.txt");
        if(f.createNewFile()){
            System.out.println("The File has been Created Successfully");
        }
            else{
                System.out.println("File is Already Existed");
             }
        FileWriter f1=new FileWriter("C:\\Users\\Prassanna\\Desktop\\vs code\\hi.txt");
        f1.write ("Hello! This is a File Concept...");
        f1.close();
        FileReader f2=new FileReader("C:\\Users\\Prassanna\\Desktop\\vs code\\hi.txt");
        BufferedReader bf=new BufferedReader(f2);
        String S;
        while ((S=bf.readLine())!=null)
        {
            System.out.println(S);
        }
        f2.close();
        System.out.println(f.length());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.renameTo(f3));
        System.out.println(f3.delete());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}