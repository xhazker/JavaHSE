import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String Name, Surname, MiddleName, Birth;

    public Person(String data) {
        String[] words = data.split(" ");
        if (words.length == 4) {
            Surname = words[0];
            Name = words[1];
            MiddleName = words[2];
            Birth = words[3];
        }
        else {
            System.out.println("Недостаточно информации");
        }
    }

    public String getPerson() {
        return "ФИО:" + fio() + "  Пол:" + sex() + "  Возраст:" + age();
    }

    public String sex () {
        if (MiddleName == null){
            return "";
        }
        char a = MiddleName.charAt(MiddleName.length()-1);
        if (a == 'ч') {
            return "Муж";
        }
        else {
            return "Жен";
        }
    }

    public int age () {
        if (Birth == null){
            return -1;
        }
        String[] date = Birth.split("\\.");
        if(Integer.parseInt(date[1])>12 || Integer.parseInt(date[1])<1) {
            System.out.println("Wrong date");
            return -1;
        }

        if((Integer.parseInt(date[0])>31 || Integer.parseInt(date[0])<1) && (Integer.parseInt(date[1]) == 1
                                            || Integer.parseInt(date[1]) == 3 || Integer.parseInt(date[1]) == 5
                                            || Integer.parseInt(date[1]) == 7|| Integer.parseInt(date[1]) == 8
                                            || Integer.parseInt(date[1]) == 10 || Integer.parseInt(date[1]) == 12)) {
            System.out.println("Wrong date");
            return -1;
        }

        if((Integer.parseInt(date[0])>30 || Integer.parseInt(date[0])<1) && (Integer.parseInt(date[1]) == 4
                                            || Integer.parseInt(date[1]) == 6 || Integer.parseInt(date[1]) == 9
                                            || Integer.parseInt(date[1]) == 11 || Integer.parseInt(date[1]) == 2)) {
            System.out.println("Wrong date");
            return -1;
        }

        if(Integer.parseInt(date[2]) % 4 != 0 || Integer.parseInt(date[2]) % 100 == 0 && Integer.parseInt(date[2]) % 400 != 0){
            if (Integer.parseInt(date[0])>29) {
                System.out.println("Wrong date");
                return -1;
            }
        }

        Date date2 = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
        String[] currentDate = formatForDateNow.format(date2).split("\\.");
        int age = Integer.parseInt(currentDate[2]) - Integer.parseInt(date[2]);

        if (age > 120) {
            System.out.println("Walking Dead");
            age = -1;
        }
        else if (age < 0) {
            System.out.println("Please wait a few years...");
            age = -1;
        }

        if (Integer.parseInt(currentDate[1]) - Integer.parseInt(date[1]) < 0) {
            age--;
        }
        else if (Integer.parseInt(currentDate[1]) - Integer.parseInt(date[1]) == 0){
            if(Integer.parseInt(currentDate[0]) - Integer.parseInt(date[0]) < 0) {
                age--;
            }
        }


        return age;
    }

    public String fio () {
        if (Name != null && !Name.isEmpty() && Surname != null && !Surname.isEmpty()
                && MiddleName != null && !MiddleName.isEmpty())
            return Surname + "." + Name.charAt(0) + "." + MiddleName.charAt(0);
        return "";
    }
}
