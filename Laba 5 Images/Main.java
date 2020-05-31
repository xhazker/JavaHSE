import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    private static ArrayList<MyImage> images = new ArrayList<MyImage>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите путь до папки с картинками: ");
        String imagePath = in.nextLine();
        //imagePath = "D:\\HSE\\2019-2020\\ImageSort";
        addFiles(imagePath);

        while(true) {
            System.out.println("Выберите пункт меню: \n" +
                                "1) Сортировать\n" +
                                "2) Определить похожесть картинки\n" +
                                "3) Пример работы программы\n" +
                                "4) Выход");
            int menu = in.nextInt();
            if (menu == 1) {
                System.out.println("Выберите по какому столбцу будете сортировать: \n" +
                                    "1) Name\n 2) Similarity\n 3) Date\n 4) Size");
                int sort = in.nextInt();
                switch (sort){
                    case 1:
                        sortByName(); break;
                    case 2:
                        sortBySimilarity(); break;
                    case 3:
                        sortByDate(); break;
                    case 4:
                        sortBySize(); break;
                }
                print();
            }
            else if (menu == 2) {
                System.out.println("Выберите картинку:");
                print();
                int picNum = in.nextInt();
                similarity(picNum-1,8,8);
                print();
            }
            else if (menu == 3) {
                System.out.println("Определяет похожесть 2 картинки и сортирует по имени");
                similarity(1,8,8);
                sortByName();
                print();
                System.out.println("Определяет похожесть 3 картинки и сортирует по похожести");
                sortBySimilarity();
                print();
                System.out.println("Определяет похожесть 4 картинки и сортирует по дате создания");
                sortByDate();
                print();
                System.out.println("Определяет похожесть 1 картинки и сортирует по размеру");
                sortBySize();
                print();
            }
            else if (menu == 4) {
                System.out.println();
                break;
            }
        }
    }



    public static void print() {
        int i = 0;
        for (MyImage image : images) {
            i++;
            System.out.println(i + ") " +image.getName() + "\t"
                                + image.getSizeImage() + " байт\t\t"
                                + image.getSemilarity() +" %\t\t"
                                + image.getDate() + "\t\t"
                                + image.getPath());
        }
        System.out.println();
    }

    public static void addFiles(String imagePath) {
        File myFolder = new File(imagePath);
        File[] files = myFolder.listFiles();
        assert files != null;
        for (File file : files) {
            if (Objects.equals(getFileExtension(file.getName()), ".png") ||
                    Objects.equals(getFileExtension(file.getName()), ".jpg")) {
                images.add(new MyImage(imagePath + "\\", file.getName()));
            }
        }
    }

    public static void sortByName() {
        images.sort(new Comparator<MyImage>() {
            public int compare(MyImage o1, MyImage o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
    }

    public static void sortBySimilarity() {
        images.sort(new Comparator<MyImage>() {
            public int compare(MyImage o1, MyImage o2) {
                return (int) (o1.getSemilarity() - o2.getSemilarity());
            }
        });
    }

    public static void sortBySize() {
        images.sort(new Comparator<MyImage>() {
            public int compare(MyImage o1, MyImage o2) {
                return (int) (o1.getSizeImage() - o2.getSizeImage());
            }
        });
    }

    public static void sortByDate() {
        images.sort(new Comparator<MyImage>() {
            public int compare(MyImage o1, MyImage o2) {
                return (int)(o1.getDateInMillisec() - (o2.getDateInMillisec()));
            }
        });
    }

    public static void similarity(int n, int height, int width) {
        int red1, green1, blue1, red2, green2, blue2, sumDifferent = 0;
        for (MyImage image1 : images) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    int rgb1 = images.get(n).getPixel(i,j);
                    int rgb2 = image1.getPixel(i,j);
                    red1 = (rgb1 >> 16) & 0xff; green1 = (rgb1 >>  8) & 0xff; blue1 = rgb1 & 0xff;
                    red2 = (rgb2 >> 16) & 0xff; green2 = (rgb2 >>  8) & 0xff; blue2 = rgb2 & 0xff;
                    sumDifferent += Math.abs(red1 - red2) + Math.abs(green1 - green2) + Math.abs(blue1 - blue2);
                }
            }
            float similarity = 100 - (float) sumDifferent / (float) (255*height*width*3) * 100;
            image1.setSemilarity(similarity);
            sumDifferent = 0;
        }
    }

    private static String getFileExtension(String mystr) {
        int index = mystr.indexOf('.');
        return index == -1? null : mystr.substring(index);
    }
}
