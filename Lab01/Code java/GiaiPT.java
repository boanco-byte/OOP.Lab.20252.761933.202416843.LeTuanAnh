import javax.swing.JOptionPane;

public class GiaiPT {

    public static void main(String[] args) {
        String choice = menu();

        if (choice.equals("1")) {
            double[] hs = nhapPTBac1();
            giaiPTBac1(hs[0], hs[1]);
        } 
        else if (choice.equals("2")) {
            double[] hs = nhapHePT();
            giaiHePT(hs);
        } 
        else if (choice.equals("3")) {
            22double[] hs = nhapPTBac2();
            giaiPTBac2(hs[0], hs[1], hs[2]);
        }
    }

    public static String menu() {
        String k;
        while (true) {
            k = JOptionPane.showInputDialog(
                null,
                "1. Giai PT bac 1\n2. Giai he PT 2 an\n3. Giai PT bac 2\nNhap lua chon:",
                "Menu",
                JOptionPane.INFORMATION_MESSAGE
            );

            if (k == null) continue;
            if (k.equals("1") || k.equals("2") || k.equals("3")) return k;

            JOptionPane.showMessageDialog(null, "Nhap sai!");
        }
    }

    public static double nhapSo(String ten) {
        while (true) {
            String s = JOptionPane.showInputDialog("Nhap " + ten + ":");
            if (s == null) continue;

            try {
                return Double.parseDouble(s);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Nhap so hop le!");
            }
        }
    }

    public static double[] nhapPTBac1() {
        double a = nhapSo("a");
        double b = nhapSo("b");
        return new double[]{a, b};
    }

    public static void giaiPTBac1(double a, double b) {
        if (a == 0) {
            if (b == 0)
                JOptionPane.showMessageDialog(null, "Vo so nghiem");
            else
                JOptionPane.showMessageDialog(null, "Vo nghiem");
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "x = " + x);
        }
    }

    public static double[] nhapHePT() {
        double a11 = nhapSo("a11");
        double a12 = nhapSo("a12");
        double b1  = nhapSo("b1");
        double a21 = nhapSo("a21");
        double a22 = nhapSo("a22");
        double b2  = nhapSo("b2");

        return new double[]{a11, a12, b1, a21, a22, b2};
    }

    public static void giaiHePT(double[] hs) {
        double a11 = hs[0], a12 = hs[1], b1 = hs[2];
        double a21 = hs[3], a22 = hs[4], b2 = hs[5];

        double D  = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x = D1 / D;
            double y = D2 / D;
            JOptionPane.showMessageDialog(null, "x = " + x + "\ny = " + y);
        } else {
            if (D1 == 0 && D2 == 0)
                JOptionPane.showMessageDialog(null, "Vo so nghiem");
            else
                JOptionPane.showMessageDialog(null, "Vo nghiem");
        }
    }

    public static double[] nhapPTBac2() {
        double a = nhapSo("a");
        double b = nhapSo("b");
        double c = nhapSo("c");
        return new double[]{a, b, c};
    }

    public static void giaiPTBac2(double a, double b, double c) {
        if (a == 0) {
            giaiPTBac1(b, c); // suy ve bac 1
            return;
        }

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "x1 = " + x1 + "\nx2 = " + x2);
        } 
        else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Nghiem kep x = " + x);
        } 
        else {
            JOptionPane.showMessageDialog(null, "Vo nghiem (khong co nghiem thuc)");
        }
    }
}