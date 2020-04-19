import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    System.out.print("ФИО и дата рождения: ");
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        Person p = new Person(data);
        System.out.println(p.getPerson());
    }
}
