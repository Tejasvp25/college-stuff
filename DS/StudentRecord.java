/*
    Name - Tejas Vijay Patil
    Gr No - xxxxxxxx
    Roll No - xxxxxxx
    Div - xxxxxxx

*/

import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.Scanner;

class StudentRecord {

    int roll_no;
    String name;

    void acceptAndWrite(RandomAccessFile f, Scanner s) {
        System.out.println("Enter Roll no : ");
        roll_no = s.nextInt();
        System.out.println("Enter Name : ");
        name = s.next();
        System.out.println();

        try {
            f.write((name + "!" + String.valueOf(roll_no) + "\n").getBytes());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void display(String str) {
        String[] org = str.split("!");
        System.out.println("Name : " + org[1]);
        System.out.println("Roll no : " + org[0]);

    }

    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        RandomAccessFile rFile;
        StudentRecord[] str = new StudentRecord[10];
        try {
            rFile = new RandomAccessFile("StudentDb.txt", "rw");
            for (int i = 0; i < str.length; i++) {
                str[i] = new StudentRecord();
                str[i].acceptAndWrite(rFile, s);
            }
            rFile.close();

            rFile = new RandomAccessFile("StudentDb.txt", "r");
            for (int i = 0; i < str.length; i++) {
                str[i].display(rFile.readLine());
            }
            rFile.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        s.close();
    }
}
