package examples.MLR;


public class MLRClass {
    
    private static double[][] dataSet = null;
    private static double beta0 = 0.0;
    private static double beta1 = 0.0;
    private static double beta2 = 0.0;
    

    public static void main() {
    
    }


    public static void print(String[] ax) {
            
        ConjuntoDatos();
        System.out.println("(" + ax[0] + ", " + ax[1] + "): " + (beta0 + Double.parseDouble(ax[0]) * beta1 + Double.parseDouble(ax[1]) * beta2));
        System.out.println("La ecuacion linear es: y = " + beta0 + " + " + beta1 + " * x1 + " + beta2 + " * x2");
        
    }

    private static void ConjuntoDatos() {
        dataSet = new double[3][20];

        
        dataSet[0][0] = 1; dataSet[0][1] = 2; dataSet[0][2] = 2;
        dataSet[0][3] = 4; dataSet[0][4] = 2; dataSet[0][5] = 1;
        dataSet[0][6] = 5; dataSet[0][7] = 4; dataSet[0][8] = 2;
        dataSet[0][9] = 4; dataSet[0][10] = 4; dataSet[0][11] = 3;
        dataSet[0][12] = 6; dataSet[0][13] = 5; dataSet[0][14] = 3;
        dataSet[0][15] = 4; dataSet[0][16] = 6; dataSet[0][17] = 2;
        dataSet[0][18] = 1; dataSet[0][19] = 2;

        
        dataSet[1][0] = 1; dataSet[1][1] = 3; dataSet[1][2] = 3;
        dataSet[1][3] = 5; dataSet[1][4] = 2; dataSet[1][5] = 2;
        dataSet[1][6] = 1; dataSet[1][7] = 1; dataSet[1][8] = 0;
        dataSet[1][9] = 3; dataSet[1][10] = 4; dataSet[1][11] = 3;
        dataSet[1][12] = 2; dataSet[1][13] = 4; dataSet[1][14] = 4;
        dataSet[1][15] = 4; dataSet[1][16] = 5; dataSet[1][17] = 1;
        dataSet[1][18] = 0; dataSet[1][19] = 1;

        
        dataSet[2][0] = 76; dataSet[2][1] = 78; dataSet[2][2] = 85;
        dataSet[2][3] = 88; dataSet[2][4] = 72; dataSet[2][5] = 69;
        dataSet[2][6] = 94; dataSet[2][7] = 94; dataSet[2][8] = 88;
        dataSet[2][9] = 92; dataSet[2][10] = 90; dataSet[2][11] = 75;
        dataSet[2][12] = 96; dataSet[2][13] = 90; dataSet[2][14] = 82;
        dataSet[2][15] = 85; dataSet[2][16] = 99; dataSet[2][17] = 83;
        dataSet[2][18] = 62; dataSet[2][19] = 76;
        
        calcularBeta0(20);
        calcularBeta1(20);
        calcularBeta2(20);
    }

    private static double Suma(int row, int i, int n) {
        double suma = 0.0;
        for(int j = i - 1; j <= n - 1; j++) 
            suma += dataSet[row][j];
        return suma;
    }

    private static double SumaProd(int row1, int row2, int i, int n) {
        double suma = 0.0;
        for(int j = i - 1; j <= n - 1; j++) 
            suma += dataSet[row1][j] * dataSet[row2][j];
        return suma;
    }

    private static double calcularBeta0(int n) {
        
        beta0 = (((Suma(2, 1, 20) * SumaProd(0, 0, 1, 20) * SumaProd(1, 1, 1, 20))
                + (Suma(0, 1, 20) * SumaProd(0, 1, 1, 20) * SumaProd(1, 2, 1, 20))
                + (Suma(1, 1, 20) * SumaProd(0, 2, 1, 20) * SumaProd(0, 1, 1, 20))
                - (Suma(1, 1, 20) * SumaProd(0, 0, 1, 20) * SumaProd(1, 2, 1, 20))
                - (Suma(2, 1, 20) * Math.pow(SumaProd(0, 1, 1, 20), 2.0))
                - (Suma(0, 1, 20) * SumaProd(0, 2, 1, 20) * SumaProd(1, 1, 1, 20))
                 ) / 
                 ((n * SumaProd(0, 0, 1, 20) * SumaProd(1, 1, 1, 20))
                + (Suma(0, 1, 20) * SumaProd(0, 1, 1, 20) * Suma(1, 1, 20))
                + (Suma(1, 1, 20) * Suma(0, 1, 20) * SumaProd(0, 1, 1, 20))
                - (SumaProd(0, 0, 1, 20) * Math.pow(Suma(1, 1, 20), 2.0))
                - (n * Math.pow(SumaProd(0, 1, 1, 20), 2.0))
                - (Math.pow(Suma(0, 1, 20), 2.0) * SumaProd(1, 1, 1, 20))
                 )
                );
        return beta0;
    }

    private static double calcularBeta1(int n) {
        beta1 = (((n * SumaProd(0, 2, 1, 20) * SumaProd(1, 1, 1, 20))
                + (Suma(2, 1, 20) * SumaProd(0, 1, 1, 20) * Suma(1, 1, 20))
                + (Suma(1, 1, 20) * Suma(0, 1, 20) * SumaProd(1, 2, 1, 20))
                - (Math.pow(Suma(1, 1, 20), 2.0) * SumaProd(0, 2, 1, 20))
                - (n * SumaProd(0, 1, 1, 20) * SumaProd(1, 2, 1, 20))
                - (Suma(2, 1, 20) * Suma(0, 1, 20) * SumaProd(1, 1, 1, 20))
                 ) / 
                 ((n * SumaProd(0, 0, 1, 20) * SumaProd(1, 1, 1, 20))
                + (Suma(0, 1, 20) * SumaProd(0, 1, 1, 20) * Suma(1, 1, 20))
                + (Suma(1, 1, 20) * Suma(0, 1, 20) * SumaProd(0, 1, 1, 20))
                - (SumaProd(0, 0, 1, 20) * Math.pow(Suma(1, 1, 20), 2.0))
                - (n * Math.pow(SumaProd(0, 1, 1, 20), 2.0))
                - (Math.pow(Suma(0, 1, 20), 2.0) * SumaProd(1, 1, 1, 20))
                 )
                );
        return beta1;
    }

    private static double calcularBeta2(int n) {
        beta2 = (((n * SumaProd(0, 0, 1, 20) * SumaProd(1, 2, 1, 20))
                + (Suma(0, 1, 20) * SumaProd(0, 2, 1, 20) * Suma(1, 1, 20))
                + (Suma(2, 1, 20) * Suma(0, 1, 20) * SumaProd(0, 1, 1, 20))
                - (Suma(2, 1, 20) * SumaProd(0, 0, 1, 20) * Suma(1, 1, 20))
                - (n * SumaProd(0, 2, 1, 20) * SumaProd(0, 1, 1, 20))
                - (Math.pow(Suma(0, 1, 20), 2.0) * SumaProd(1, 2, 1, 20))
                 ) / 
                 ((n * SumaProd(0, 0, 1, 20) * SumaProd(1, 1, 1, 20))
                 + (Suma(0, 1, 20) * SumaProd(0, 1, 1, 20) * Suma(1, 1, 20))
                 + (Suma(1, 1, 20) * Suma(0, 1, 20) * SumaProd(0, 1, 1, 20))
                 - (SumaProd(0, 0, 1, 20) * Math.pow(Suma(1, 1, 20), 2.0))
                 - (n * Math.pow(SumaProd(0, 1, 1, 20), 2.0))
                 - (Math.pow(Suma(0, 1, 20), 2.0) * SumaProd(1, 1, 1, 20))
                 )
                );
        return beta2;
    }
}