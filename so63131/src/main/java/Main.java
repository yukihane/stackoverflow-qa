import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Main {
    public static void Welch_test() {
        System.out.println("Test population mean in two different populations are same or not");
        System.out.println("This program works only for two-tailed ");

        final Scanner in = new Scanner(System.in);
        System.out.println("Do you want population with same variation(Type 1) or different variation(Type 2):");
        final int type = in.nextInt();

        System.out.println("How many samples did you take from first population:");
        final double na = in.nextDouble();

        System.out.println("How many samples did you take from second population:");
        final double nb = in.nextDouble();

        System.out.println("What is your Sample mean for first population:");
        final double Xa = in.nextDouble();

        System.out.println("What is your Sample mean for second population:");
        final double Xb = in.nextDouble();

        System.out.println("What is unbiased variance for first population:");
        final double Ua = in.nextDouble();

        System.out.println("What is unbiased variance for second population:");
        final double Ub = in.nextDouble();

        System.out.println("What is Level of Significance (Type with %-value)");
        final double L = in.nextDouble();
        final double l = L / 100;

        if (type == 1) {
            final double k = na + nb - 2;
            final double p = Math.abs(Xa - Xb);
            final double one = ((1 / na) + (1 / nb));
            final double two = ((((Ua) * (na - 1)) + ((Ub) * (nb - 1))) / (na + nb - 2));
            final double three = one * two;
            final double q = Math.sqrt(three);
            final double T = p / q;
            System.out.println("Degree of freedom is " + k);
            System.out.println("Test statistic is " + T);

            final Workbook wb = new XSSFWorkbook();
            final Sheet sheet = wb.createSheet();
            final Row row1 = sheet.createRow(1);
            final Row row2 = sheet.createRow(2);

            final Cell cell1_1 = row1.createCell(1);
            final Cell cell1_2 = row1.createCell(2);
            final Cell cell1_3 = row1.createCell(3);
            final Cell cell2_3 = row2.createCell(3);

            cell1_1.setCellValue(l);
            cell1_2.setCellValue(k);
            cell2_3.setCellFormula("_xlfn.T.INV.2T(B2,C2)");

            FileOutputStream out = null;
            try {
                out = new FileOutputStream("T-inverse.xlsx");
                wb.write(out);
            } catch (final IOException e) {
                System.out.println(e.toString());
            } finally {
                try {
                    out.close();
                } catch (final IOException e) {
                    System.out.println(e.toString());
                }
            }
        } else {
            final double x = Math.abs(Xa - Xb);
            final double y = Math.sqrt(((Ua) / na) + ((Ub) / nb));
            final double z = x / y;
            System.out.println(z);
            final double parta = ((((Ua) / na) + ((Ub) / nb)) * (((Ua) / na) + ((Ub) / nb)));
            final double partb = ((((Ub) / nb) * ((Ub) / nb)) / (nb - 1));
            final double partc = ((((Ua) / na) * ((Ua) / na)) / (na - 1));
            final double partd = partc + partb;
            double j = parta / partd;
            j = Math.round(j);
            System.out.println("Degree of Freedom is " + j);
            System.out.println("Test statistic is " + z);

            final Workbook wb = new XSSFWorkbook();
            final Sheet sheet = wb.createSheet();
            final Row row1 = sheet.createRow(1);
            final Row row2 = sheet.createRow(2);

            final Cell cell1_1 = row1.createCell(1);
            final Cell cell1_2 = row1.createCell(2);
            final Cell cell1_3 = row1.createCell(3);
            final Cell cell2_3 = row2.createCell(3);

            cell1_1.setCellValue(l);
            cell1_2.setCellValue(j);
            cell2_3.setCellFormula("T.INV.2T(B2,C2)");

            FileOutputStream out = null;
            try {
                out = new FileOutputStream("T-inverse.xlsx");
                wb.write(out);
            } catch (final IOException e) {
                System.out.println(e.toString());
            } finally {
                try {
                    out.close();
                } catch (final IOException e) {
                    System.out.println(e.toString());
                }
            }
        }


    }

    public static void main(final String[] args) {
        Welch_test();
    }
}
