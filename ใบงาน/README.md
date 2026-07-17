ใบงานทบทวนภาษา Java
คำชี้แจงสำหรับนักศึกษา
ให้นักศึกษาทำใบงานนี้เพื่อทบทวนความรู้ภาษา Java ที่จำเป็นต่อการเรียนเรื่องอัลกอริทึม ได้แก่ ตัวแปร เงื่อนไข วนซ้ำ อาร์เรย์ เมธอด และการเขียนโปรแกรมแก้ปัญหาเบื้องต้น
ให้นักศึกษาเขียนโปรแกรมด้วยภาษา Java และส่งไฟล์.java หรืออัปโหลดลง GitHub ตามที่ผู้สอนกำหนด
จุดประสงค์การเรียนรู้
หลังจากทำใบงานนี้ นักศึกษาสามารถ
1. เขียนโปรแกรม Java รับข้อมูลและแสดงผลได้
2. ใช้คำสั่ง if-else เพื่อตัดสินใจได้
3. ใช้คำสั่ง for และ while เพื่อวนซ ้าได้
4. ใช้ Array ในการเก็บและประมวลผลข้อมูลได้
5. เขียน Method เพื่อแบ่งการท างานของโปรแกรมได้
6. อธิบายขั้นตอนการท างานของโปรแกรมในรูปแบบ Pseudocode ได้

ตอนที่ 1: คำสั่งพื้นฐาน Java

อ้างอิงจากโจทย์

1.1 คำสั่งแสดงผลข้อความในภาษา Java คืออะไร

ตอบ:
System.out.println();

1.2 คำสั่งรับค่าจากแป้นพิมพ์โดยใช้ Scanner ต้อง import อะไร

ตอบ:
import java.util.Scanner;

1.3 คำสั่งใดใช้ตรวจสอบเงื่อนไข

ตอบ:
if-else

1.4 คำสั่งใดใช้วนซ้ำเมื่อทราบจำนวนรอบแน่นอน

ตอบ:
for

1.5 คำสั่งใดใช้วนซ้ำเมื่อยังไม่ทราบจำนวนรอบแน่นอน

ตอบ:
while

ตอนที่ 2: วิเคราะห์โค้ด

โค้ด:


int sum = 0;
for (int i = 1; i <= 5; i++) {
 sum = sum + i;
}
System.out.println(sum);

โปรแกรมนี้วนซ้ำทั้งหมดกี่รอบ

ตอบ: 5 รอบ

ค่าของตัวแปร sum หลังจบการทำงานคือเท่าใด

ตอบ: 15


(1+2+3+4+5 = 15)

ผลลัพธ์ที่แสดงออกหน้าจอคืออะไร

ตอบ:
15

โปรแกรมนี้ทำหน้าที่อะไร

ตอบ:
หาผลรวมของตัวเลขตั้งแต่ 1 ถึง 5

ตอนที่ 3: เลขคู่/เลขคี่
Pseudocode
เริ่ม
รับค่าตัวเลข
ถ้า ตัวเลข % 2 == 0
แสดง Even number
ไม่เช่นนั้น
แสดง Odd number
จบ
Java Code


import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();

        if (num % 2 == 0) {
            System.out.println("Even number");
        } else {
            System.out.println("Odd number");
        }
    }
}
ตอนที่ 4: คะแนนผ่าน/ไม่ผ่าน
Pseudocode
เริ่ม
รับคะแนนกลางภาค
รับคะแนนปลายภาค
รวมคะแนน
ถ้า >= 50
แสดง Pass
ไม่เช่นนั้น
แสดง Fail
จบ
Java Code

import java.util.Scanner;

public class PassFail {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter midterm score: ");
        int mid = sc.nextInt();

        System.out.print("Enter final score: ");
        int fin = sc.nextInt();

        int total = mid + fin;

        System.out.println("Total score = " + total);

        if (total >= 50) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }
    }
}
ตอนที่ 5: หาค่ามากสุด
Java Code

import java.util.Scanner;

public class Max3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int a = sc.nextInt();

        System.out.print("Enter number 2: ");
        int b = sc.nextInt();

        System.out.print("Enter number 3: ");
        int c = sc.nextInt();

        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;

        System.out.println("Maximum number = " + max);
    }
}
ตอนที่ 6: Array + ค่าเฉลี่ย

import java.util.Scanner;

public class ArrayScore {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] score = new int[5];
        int sum = 0;

        for (int i = 0; i < 5; i++) {
            System.out.print("Enter score " + (i+1) + ": ");
            score[i] = sc.nextInt();
            sum += score[i];
        }

        double avg = (double) sum / 5;

        System.out.println("Total score = " + sum);
        System.out.println("Average score = " + avg);
    }
}
ตอนที่ 7: ค้นหาใน Array

import java.util.Scanner;

public class SearchName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = {"Somchai", "Suda", "Anan", "Mali", "Krit"};

        System.out.print("Enter name to search: ");
        String search = sc.nextLine();

        boolean found = false;

        for (String name : names) {
            if (name.equalsIgnoreCase(search)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
    }
}
ตอนที่ 8: Method


import java.util.Scanner;

public class ReviewMethod {

    public static int findMax(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number 1: ");
        int a = sc.nextInt();

        System.out.print("Enter number 2: ");
        int b = sc.nextInt();

        int max = findMax(a, b);

        System.out.println("Maximum number = " + max);
    }
}
ตอนที่ 9: Debug

1. ผิดที่บรรทัดใด

ตอบ:
for (int i = 0; i <= numbers.length; i++)

2. เพราะเหตุใด

ตอบ:
เพราะ index เกิน (ArrayIndexOutOfBoundsException)
index สูงสุดคือ length - 1

3. แก้ไขอย่างไร

ตอบ:
เปลี่ยน <= เป็น <

โค้ดที่แก้แล้ว

public class DebugExample {
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}
ตอนที่ 10: Mini Challenge (เลือกข้อ 1)

import java.util.Scanner;

public class EvenOddCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        int even = 0, odd = 0;

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter number: ");
            arr[i] = sc.nextInt();

            if (arr[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        System.out.println("Even count = " + even);
        System.out.println("Odd count = " + odd);
    }
}
ตอนที่ 11 (ตัวอย่างตอบ)

1. AI พบข้อผิดพลาดอะไรหรือไม่
ตอบ: พบ เช่น index เกิน

2. คำแนะนำถูกต้องไหม
ตอบ: ถูกต้อง เพราะอธิบาย logic ได้ตรง

3. แก้ตาม AI ไหม
ตอบ: แก้ตาม

4. ได้เรียนรู้อะไร
ตอบ: เข้าใจerrorและdebugมากขึ้น

5. ข้อควรระวัง
ตอบ: AI อาจผิด ต้องตรวจสอบด้วยตัวเอง


ให้นักศึกษาตอบคำถามต่อไปนี้
1. ส่วนใดของ Java ที่นักศึกษายังไม่มั่นใจมากที่สุด
ตอบ: OOPกับoverride
2. โจทย์ข้อใดยากที่สุด เพราะเหตุใด
ตอบ: ข้อ10ครับเพราะงงครับ
3. การทบทวน Java ครั้งนี้ช่วยเตรียมตัวเรียน Algorithm อย่างไร
ตอบ: อ่านสไลด์อาจารย์ครับ
4. นักศึกษาคิดว่า Java ส่วนใดสำคัญที่สุดต่อการเรียน Algorithm
ตอบ: ดูการรันโค้ดให้ออกว่ามันคืออะไรยังไง
5. นักศึกษาจะฝึกเพิ่มเติมเรื่องใดก่อนเรียนสัปดาห์ถัดไป
ตอบ: จะทำความเข้าใจโค้ดให้มากขึ้นครับ
