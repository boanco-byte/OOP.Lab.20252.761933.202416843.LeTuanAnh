import java.util.Scanner;

public class AddTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so hang: ");
        int n = sc.nextInt();
        System.out.print("Nhap so cot: ");
        int m = sc.nextInt();

        int[][] A = new int[n][m];
        int[][] B = new int[n][m];
        int[][] C = new int[n][m];

        System.out.println("Nhap gia tri cho ma tran A:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                A[i][j] = sc.nextInt();
            }
        }

        System.out.println("Nhap gia tri cho ma tran B:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                B[i][j] = sc.nextInt();
            }
        }

        System.out.println("Tong cua 2 ma tran:");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                C[i][j] = A[i][j] + B[i][j];
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }
    }
}