import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[]dict = new int[52];
        String text = "";
        System.out.print("Введите располржение файла: ");
        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();
        try(FileInputStream fin=new FileInputStream(filename))
        {
            System.out.printf("File size: %d bytes \n", fin.available());

            int i=-1, n;
            while((i=fin.read())!=-1){
                n = translate((int)i);
                dict[n]++;
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println();


        for (int i=0;i<dict.length/2;i++) {
            System.out.printf("%c : %d \n", (i+(int)'A'), dict[i]);
            text = text.concat((char)(i+(int)'A') + " : " + dict[i] + "\n");
        }
        for (int i=dict.length/2;i<dict.length;i++) {
            System.out.printf("%c : %d \n", (i+(int)'a'-26), dict[i]);
            text = text.concat((char)(i+(int)'a'-26) + " : " + dict[i] + "\n");
        }


        try(FileOutputStream fos=new FileOutputStream("notes2.txt"))
        {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }

    public static int translate(int x) {
        if (x >= (int)'A' && x <= (int)'Z') {
            return x - (int)'A';
        }
        else if (x >= (int)'a' && x <= (int)'z') {
            return x - (int)'a' + 26;
        }
        return -1;

    }
}
