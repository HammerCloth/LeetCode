import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 3*3的锯齿数组
 *
 * @ClassName Case3
 * @Description TODO
 * @Author SiYiXiong
 * @Date 2022/3/17 19:24
 * @Version v0.1
 **/
public class Case3 {
    static List<char[][]> result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        int n = sc.nextInt();//测试的次数
        char[][] array = new char[3][3];
        int[][] indexArray = new int[3][6];
        for (int i = 0; i < n; i++) {
            result = new ArrayList<>();
            for (int j = 0; j < 3; j++) { //3 行的棋盘
                String temp = sc.next();
                char[] chars = temp.toCharArray();
                for (int k = 0; k < 3; k++) {
                    array[j][k] = chars[k]; //将每一个char放入棋盘中'*''1''2''3'
                }
            }
            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 6; l++) {
                    indexArray[k][l] = sc.nextInt();
                }
            }

            // 求解问题
            result(array, indexArray);
            if (result.size() == 0) {
                System.out.println("No");
            } else if (result.size() == 1) {
                System.out.println("Unique");
                char[][] temp = result.get(0);
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        System.out.print(temp[j][k]);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Multiple");
            }
        }

    }

    public static void result(char[][] array, int[][] indexArray) {
        int x = -1;//需要进行填空的坐标
        int y = -1;//需要进行填空的坐标
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == '*' && flag) {
                    x = i;
                    y = j;
                    flag = !flag;
                }
            }
        }
        if (x == -1 && y == -1) {
            result.add(array);
            return;
        }

        if (check(array, x, y, indexArray, '1')) {
            char[][] temp = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    temp[i][j] = array[i][j];
                }
            }
            temp[x][y] = '1';
            result(temp, indexArray);
        }
        if (check(array, x, y, indexArray, '2')) {
            char[][] temp = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    temp[i][j] = array[i][j];
                }
            }
            temp[x][y] = '2';
            result(temp, indexArray);
        }
        if (check(array, x, y, indexArray, '3')) {
            char[][] temp = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    temp[i][j] = array[i][j];
                }
            }
            temp[x][y] = '3';
            result(temp, indexArray);
        }


    }

    public static boolean check(char[][] array, int x, int y, int[][] indexArray, char m) {
        return checkArea(array, x, y, indexArray, m) && checkX(array, x, y, m) && checkY(array, x, y, m);
    }

    public static boolean checkX(char[][] array, int x, int y, char m) {
        char temp = m;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (array[i][y] == temp) {
                count++;
            }
        }
        if (count == 0) return true;
        else return false;

    }

    public static boolean checkY(char[][] array, int x, int y, char m) {
        char temp = m;
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (array[x][i] == temp) {
                count++;
            }
        }
        if (count == 0) return true;
        else return false;
    }

    public static boolean checkArea(char[][] array, int x, int y, int[][] indexArray, char m) {
        int area = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j += 2) {
                if (indexArray[i][j] == x && indexArray[i][j + 1] == y) {
                    area = i;
                    break;
                }
            }
        }
        int count = 0;
        char temp = m;
        for (int i = 0; i < 6; i += 2) {
            if (array[indexArray[area][i]][indexArray[area][i + 1]] == temp) {
                count++;
            }
        }
        if (count == 0) return true;
        else return false;

    }

}
