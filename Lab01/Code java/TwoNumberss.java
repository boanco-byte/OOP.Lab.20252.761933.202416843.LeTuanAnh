import javax.swing.JOptionPane;

public class TwoNumberss {
    public static void main(String[] args) {
        String strNum1, strNum2;

        while (true) {
            strNum1 = JOptionPane.showInputDialog(null, "Nhap so thuc thu 1", "", JOptionPane.INFORMATION_MESSAGE);
            if (strNum1 == null || strNum1.isEmpty()) continue;
            break;
        }

        while (true) {
            strNum2 = JOptionPane.showInputDialog(null, "Nhap so thuc thu 2", "", JOptionPane.INFORMATION_MESSAGE);
            if (strNum2 == null || strNum2.isEmpty()) continue;
            break;
        }

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double tong = num1 + num2;
        double hieu = num1 - num2;
        double tich = num1 * num2;

        String result = "Tong: " + tong +
                        "\nHieu: " + hieu +
                        "\nTich: " + tich;

        if (num2 != 0) {
            result += "\nThuong: " + (num1 / num2);
        } else {
            result += "\nKhong the chia cho 0";
        }

        JOptionPane.showMessageDialog(null, result);
        System.exit(0);
    }
}