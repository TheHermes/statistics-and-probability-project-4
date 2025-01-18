package fi.arcada.regressionsanalys;

public class RegressionLine {

    // deklarera k, m, x  och correlationCoefficient som double

    double k, m, x, correlationCoefficient;
    String correlationGrade;
    double[] xVals;
    double[] yVals;

    // Skapa en konstruktor som tar emot data-arrays för x och y
    // Uträkningen för k och m kan ske i konstruktorn m.h.a.
    // formeln för minsta kvadratmetoden
    // Del 3: uträkningen för correlationCoefficient kan också ske i konstruktorn
    // (det är förstås också ok att ha en skild metod för uträknigarna om man vill
    // hålla konstruktorn simpel.)

    public RegressionLine(double[] xVals, double[] yVals) {
        // Summan av alla värden x * y
        double sumXY = 0;
        int size = xVals.length;
        for(int i = 0; i < size; i++) {
            sumXY += xVals[i] * yVals[i];
        }
        System.out.println("Summan av X och Y: " + sumXY);
        // Summan av alla x-värden
        double sumX = 0;
        for (double xVal : xVals) {
            sumX += xVal;
        }
        System.out.println("Summan av X: " + sumX);
        // Summan av alla y-värden
        double sumY = 0;
        for (int i = 0; i < size;i++){
            sumY += yVals[i];
        }
        System.out.println("Summan av Y: " + sumY);

        // Summan av all x i kvadrat
        double sumXSqrt = 0;
        for (double xVal : xVals) {
            sumXSqrt += Math.pow(xVal, 2);
        }
        System.out.println("Summan av x i kvadrat" + sumXSqrt);

        // Summan av all y i kvadrat
        double sumYSqrt = 0;
        for (int i = 0; i < size; i++) {
            sumYSqrt += Math.pow(yVals[i], 2);
        }
        System.out.println("Summan av x i kvadrat" + sumYSqrt);

        this.k = ( size * sumXY - (sumX * sumY) ) / ( (size * sumXSqrt) - Math.pow(sumX, 2) );
        System.out.println("k : " + k);

        this.m = (sumY / size) - k * (sumX / size);
        System.out.println("m : " + m);

        // Korrelationskoefficient
        this.correlationCoefficient = ( ( size * sumXY ) - ( sumX * sumY ) ) / Math.sqrt( ( ( size * sumXSqrt ) - Math.pow( sumX, 2 ) ) * ( (size * sumYSqrt) - Math.pow( sumY, 2 )) );
        System.out.println("Korrelationskoefficient: " + correlationCoefficient);
    }

    // skapa en metod getX som tar emot ett y-värde, räknar ut x
    // m.h.a. räta linjens ekvation y=kx+m, och returnerar x

    public double getX(double y){
        x = (y - m) / k;
        System.out.println("x: " + x);
        return x;
    }

    // Del 3:
    // - skapa en getter-metod för correlationCoefficient
    // - skapa en String-metod getCorrelationGrade() för uträkning av korrelationsgra
    public double getCorrelationCoefficient(){
        return correlationCoefficient;
    }

    public String getCorrelationGrade(){

        if (correlationCoefficient == 0) {
            this.correlationGrade = "Ingen";
        } else if (correlationCoefficient > 0 && correlationCoefficient < 0.25) {
            this.correlationGrade = "Låg";
        } else if (correlationCoefficient > 0.25 && correlationCoefficient < 0.75) {
            this.correlationGrade = "Måttlig";
        } else if (correlationCoefficient > 0.75 && correlationCoefficient < 1) {
            this.correlationGrade = "Hög";
        } else if (correlationCoefficient == 1) {
            this.correlationGrade = "Perfekt";
        }
        return correlationGrade;
    }
}