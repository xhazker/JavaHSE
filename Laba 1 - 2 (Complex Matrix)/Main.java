public class Main {
    public static void main(String[] args) {
//        ComplexNumber x = new ComplexNumber(2.0, 3.0);
//        ComplexNumber y = new ComplexNumber(3.0, 2.0);
//        System.out.println("z=" + x.plus(y).printComplex());
//        System.out.println(x.plus(y).printTrigon());

        Matrix x = new Matrix(2,2);
        Matrix y = new Matrix(2,3);
        x.usualMatrix();
        y.usualMatrix();
        System.out.println("Первая комплексная матрица");
        System.out.println(x);
        System.out.println("Вторая комплексная матрица");
        System.out.println(y);
        System.out.println("Транспонированная первая матрица");
        System.out.println(x.tranponir());
        System.out.println("Сложение матрицы с самой собой");
        System.out.println(x.plus(x));
        System.out.println("Умножение первой матрицы на вторую");
        System.out.println(x.multip(y));

        System.out.println("С мнимой частью");

        x.complexMatrix();
        y.complexMatrix();
        System.out.println("Первая комплексная матрица");
        System.out.println(x);
        System.out.println("Вторая комплексная матрица");
        System.out.println(y);
        System.out.println("Транспонированная первая матрица");
        System.out.println(x.tranponir());
        System.out.println("Сложение матрицы с самой собой");
        System.out.println(x.plus(x));
        System.out.println("Умножение первой матрицы на вторую");
        System.out.println(x.multip(y));
    }
}
