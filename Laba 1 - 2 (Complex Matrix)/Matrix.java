public class Matrix {
    private int m,n;
    private ComplexNumber[][] arr;

    public Matrix(int n, int m){
        this.m = m;
        this.n = n;
        arr = new ComplexNumber[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = new ComplexNumber();
            }
        }
    }

    public Matrix(ComplexNumber[][] arr){
        m = arr.length;
        n = arr[0].length;
        this.arr = new ComplexNumber[m][n];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                this.arr[i][j] = new ComplexNumber(arr[i][j].getA(), arr[i][j].getB());
            }
        }
    }

    public int getM(){
        return m;
    }

    public int getN(){
        return n;
    }

    public ComplexNumber getValue(int i, int j){
        return arr[i][j];
    }

    public void setValue(ComplexNumber x, int i, int j){
        arr[i][j].setValue(x);
    }

    public void usualMatrix(){
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = new ComplexNumber(1 + (int) (Math.random() * 10), 0);
            }
        }
    }

    public void complexMatrix(){
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                arr[i][j] = new ComplexNumber(1 + (int) (Math.random() * 10), 1 + (int) (Math.random() * 10));
            }
        }
    }

    public String toString() {
        StringBuilder S= new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                S.append(arr[i][j].toString()).append(" ");
            S.append('\n');
        }
        return S.toString();
    }

    public Matrix tranponir(){
        Matrix x = new Matrix(n,m);
        //int[][] tmp = new int[n][m];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                x.setValue(arr[i][j], j, i);
            }
        }
        return x;
    }

    public Matrix plus(Matrix x){
        Matrix tmp = new Matrix(n,m);
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                tmp.setValue(this.arr[i][j].plus(x.arr[i][j]), i, j);
            }
        }
        return tmp;
    }

    public Matrix multip(Matrix arr){
        Matrix tmp = new Matrix(n,arr.getM());
        //int[][] tmp = new int[m][x.getN()];
        for(int i = 0;i < n;i++){
            for(int j = 0;j < arr.getM();j++){
                ComplexNumber x = new ComplexNumber();
                for(int k = 0;k < arr.getN();k++) {

                    x = x.plus(this.arr[i][k].multip(arr.getValue(k, j)));
                }
                tmp.setValue(x,i,j);
            }
        }
        return tmp;
    }

}
