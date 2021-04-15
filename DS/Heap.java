/*
 * Name : Tejas Patil
 * Roll No : xxxxxx
 * Gr No : xxxxxxx
 * Div : SY-C (C3 Batch)
 */
import java.util.Scanner;

/**
 *
 * @author Tejas-PC
 */
public class Heap {

    int[] maxHeap, minHeap;
    int noStud;
    Scanner sc;

    Heap() {
        sc = new Scanner(System.in);
    }

    void acceptMarks() {
        println("Enter Number of Students : ");
        this.noStud = sc.nextInt();
        sc.nextLine();
        this.maxHeap = new int[20];
        this.minHeap = new int[20];
        this.maxHeap[0] = 0;
        this.minHeap[0] = 0;
        int temp;
        println("Enter Marks : ");
        for (int i = 0; i < noStud; i++) {
            temp = sc.nextInt();
            if(temp == this.noStud){
                println("kek");
            }
            insertToMaxHeap(temp);
            insertToMinHeap(temp);
        }
     }

    void insertToMaxHeap(int val) {
        int n = this.maxHeap[0];
        this.maxHeap[n + 1] = val;
        this.maxHeap[0] = n + 1;
        int temp;
        int np = n + 1;
        while (np > 1 && this.maxHeap[np] > this.maxHeap[np / 2]) {
            temp = this.maxHeap[np];
            this.maxHeap[np] = this.maxHeap[np / 2];
            this.maxHeap[np / 2] = temp;
            np = np / 2;
        }
    }

    void insertToMinHeap(int val) {
        int n = this.minHeap[0];
        this.minHeap[n + 1] = val;
        this.minHeap[0] = n + 1;
        int temp;
        int np = n + 1;
        while (np > 1 && this.minHeap[np] < this.minHeap[np / 2]) {
            temp = this.minHeap[np];
            this.minHeap[np] = this.minHeap[np / 2];
            this.minHeap[np / 2] = temp;
            np = np / 2;
        }
    }

    void println(Object obj) {
        System.out.println(obj);
    }

    void minMax() {
        println("Maximum Marks : " + this.maxHeap[1]);
        for (int i = 1; i <= this.noStud ; i++) {
            println(this.maxHeap[i]);
        }
        println("Minimum Marks : "+this.minHeap[1]);
        for (int i = 1; i <= this.noStud; i++) {
            println(this.minHeap[i]);
        }
    }

    void release() {
        sc.close();
    }

    public static void main(String args[]) {
        
        Heap h = new Heap();
        h.acceptMarks();
        h.minMax();
        h.release();
        
    }
}
