import java.util.Scanner;

public class DaysOfMonth {

    public static int month(String str) {
        switch (str) {
            case "1": case "Jan": case "Jan.": case "January": return 1;
            case "2": case "Feb": case "Feb.": case "February": return 2;
            case "3": case "Mar": case "Mar.": case "March": return 3;
            case "4": case "Apr": case "Apr.": case "April": return 4;
            case "5": case "May": return 5;
            case "6": case "Jun": case "June": return 6;
            case "7": case "Jul": case "July": return 7;
            case "8": case "Aug": case "Aug.": case "August": return 8;
            case "9": case "Sep": case "Sept": case "September": return 9;
            case "10": case "Oct": case "Oct.": case "October": return 10;
            case "11": case "Nov": case "Nov.": case "November": return 11;
            case "12": case "Dec": case "Dec.": case "December": return 12;
            default: return -1;
       }
    }

    public static boolean NamNhuan(int year) {
        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) return true;
        return false;
    }

    public static int day(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12: return 31;
            case 4: case 6: case 9: case 11: return 30;
            case 2: return NamNhuan(year) ? 29: 28;
            default: return -1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m, y;

        while (true) {
            System.out.print("Nhap thang: ");
            String s = sc.nextLine().trim();
            m = month(s);

            if (m != -1) break;
            System.out.println("Thang khong hop le, nhap lai!");
        }

        while (true) {
            System.out.print("Nhap nam: ");
            String s = sc.nextLine().trim();

            if (s.matches("\\d+")) {
                y = Integer.parseInt(s);
                break;
            }

            System.out.println("Nam khong hop le, nhap lai!");
        }

        int days = day(m, y);
        System.out.println("Thang " + m + " nam " + y + " co " + days + " ngay.");
    }
}