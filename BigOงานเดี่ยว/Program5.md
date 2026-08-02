ข้อ 5: การแบ่งอาร์เรย์โดยใช้ค่า Pivot (Partition Array Around Pivot k)
1. หลักการทำงานของอัลกอริทึม

โจทย์ต้องการแบ่งสมาชิกในอาร์เรย์ A ออกเป็น 3 ส่วน โดยใช้ค่า k เป็นจุดอ้างอิง (Pivot)

สมาชิกที่มีค่าน้อยกว่า k จะอยู่ด้านซ้าย
สมาชิกที่มีค่าเท่ากับ k จะอยู่ตรงกลาง
สมาชิกที่มีค่ามากกว่า k จะอยู่ด้านขวา
อัลกอริทึมที่ 1 : Three-Way Partitioning (Dutch National Flag)

วิธีนี้ใช้ตัวชี้ทั้งหมด 3 ตัว คือ

low สำหรับกำหนดตำแหน่งของกลุ่มค่าที่น้อยกว่า k
mid สำหรับตรวจสอบข้อมูลทีละตำแหน่ง
high สำหรับกำหนดขอบเขตของกลุ่มค่าที่มากกว่า k

หลักการทำงานคือ

ถ้า A[mid] < k ให้นำข้อมูลไปไว้ด้านซ้ายโดยสลับกับ A[low] แล้วเลื่อนทั้ง low และ mid
ถ้า A[mid] == k ถือว่าอยู่ตำแหน่งถูกต้องแล้ว จึงเลื่อน mid
ถ้า A[mid] > k ให้นำไปไว้ด้านขวาโดยสลับกับ A[high] จากนั้นลดค่า high โดยยังไม่เลื่อน mid เพราะต้องตรวจค่าที่เพิ่งสลับเข้ามา

จุดเด่นของวิธีนี้คือสามารถจัดกลุ่มข้อมูลได้ภายในการสแกนอาร์เรย์เพียงครั้งเดียว และไม่ต้องสร้างอาร์เรย์ใหม่

อัลกอริทึมที่ 2 : Extra Array Partitioning

วิธีนี้สร้างอาร์เรย์ผลลัพธ์ขึ้นมาใหม่ แล้วแบ่งการทำงานออกเป็น 3 รอบ ได้แก่

เก็บสมาชิกที่มีค่าน้อยกว่า k
เก็บสมาชิกที่มีค่าเท่ากับ k
เก็บสมาชิกที่มีค่ามากกว่า k

เมื่อจบทั้งสามรอบ จะได้อาร์เรย์ใหม่ที่เรียงตามเงื่อนไขครบถ้วน

ข้อดีคือสามารถรักษาลำดับเดิมของข้อมูลที่มีค่าเท่ากันไว้ได้ (Stable Algorithm) และขั้นตอนค่อนข้างเข้าใจง่าย

2. Pseudocode
Algorithm partitionThreeWay(A, k)

If A is null Then Return

low = 0
mid = 0
high = length(A) - 1

While mid <= high Do

    If A[mid] < k Then
        Swap A[low] and A[mid]
        low = low + 1
        mid = mid + 1

    Else If A[mid] == k Then
        mid = mid + 1

    Else
        Swap A[mid] and A[high]
        high = high - 1
    End If

End While
Algorithm partitionExtraArray(A, k)

If A is null Then Return null

Create result[] same size as A
index = 0

For each element in A
    If value < k
        result[index] = value
        index++
End For

For each element in A
    If value == k
        result[index] = value
        index++
End For

For each element in A
    If value > k
        result[index] = value
        index++
End For

Return result
3. ภาษา Java
import java.util.Arrays;

public class ArrayPartitioner {

    // Algorithm 1 : Three-Way Partitioning
    public static void partitionThreeWay(int[] a, int k) {

        if (a == null || a.length <= 1)
            return;

        int low = 0;
        int mid = 0;
        int high = a.length - 1;

        while (mid <= high) {

            if (a[mid] < k) {

                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;

                low++;
                mid++;

            } else if (a[mid] == k) {

                mid++;

            } else {

                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;

                high--;
            }
        }
    }

    // Algorithm 2 : Extra Array
    public static int[] partitionExtraArray(int[] a, int k) {

        if (a == null)
            return new int[0];

        int[] result = new int[a.length];
        int index = 0;

        for (int value : a)
            if (value < k)
                result[index++] = value;

        for (int value : a)
            if (value == k)
                result[index++] = value;

        for (int value : a)
            if (value > k)
                result[index++] = value;

        return result;
    }

    public static void main(String[] args) {

        int[] input = {9, 12, 3, 5, 14, 10, 10, 2, 7, 10};
        int k = 10;

        System.out.println("Original : " + Arrays.toString(input));

        int[] arr1 = input.clone();
        partitionThreeWay(arr1, k);
        System.out.println("Three-Way : " + Arrays.toString(arr1));

        int[] arr2 = partitionExtraArray(input, k);
        System.out.println("Extra Array : " + Arrays.toString(arr2));
    }
}
4. ตัวอย่างข้อมูลเข้าและผลลัพธ์

Input

A = [9, 12, 3, 5, 14, 10, 10, 2, 7, 10]
k = 10

Output

Three-Way Partition
[9, 7, 3, 5, 2, 10, 10, 10, 14, 12]

Extra Array Partition
[9, 3, 5, 2, 7, 10, 10, 10, 12, 14]

หมายเหตุ

วิธี Three-Way ไม่รับประกันลำดับเดิมของข้อมูล
วิธี Extra Array ยังคงลำดับเดิมของข้อมูลไว้ได้
5. วิเคราะห์ Time Complexity
Three-Way Partitioning

Time Complexity : O(n)

เหตุผล

อัลกอริทึมตรวจสอบสมาชิกในอาร์เรย์เพียงรอบเดียว โดยแต่ละตำแหน่งถูกประมวลผลไม่กี่ครั้ง จึงใช้เวลาแปรผันตรงกับจำนวนข้อมูล

Extra Array Partitioning

Time Complexity : O(n)

เหตุผล

แม้ว่าจะต้องวนลูปทั้งหมด 3 รอบ แต่รวมแล้วเป็น 3n ซึ่งเมื่อตัดค่าคงที่ออกจะเหลือ O(n)

6. วิเคราะห์ Space Complexity
Three-Way Partitioning

Space Complexity : O(1)

เหตุผล

ใช้งานเพียงตัวแปรไม่กี่ตัวในการสลับข้อมูล และไม่ต้องสร้างอาร์เรย์เพิ่มเติม

Extra Array Partitioning

Space Complexity : O(n)

เหตุผล

ต้องสร้างอาร์เรย์ใหม่ที่มีขนาดเท่ากับข้อมูลเดิม จึงต้องใช้พื้นที่เพิ่มตามจำนวนสมาชิก

7. วิเคราะห์เพิ่มเติม
จำนวนรอบในการสแกนข้อมูล
Three-Way Partitioning ใช้การสแกนเพียง 1 รอบ
Extra Array Partitioning ต้องสแกนทั้งหมด 3 รอบ
ความเสถียรของอัลกอริทึม
Three-Way Partitioning เป็น Unstable Algorithm เพราะการสลับตำแหน่งอาจทำให้ลำดับเดิมของข้อมูลเปลี่ยนไป
Extra Array Partitioning เป็น Stable Algorithm เนื่องจากนำข้อมูลมาเก็บตามลำดับที่พบในอาร์เรย์เดิม
8. เปรียบเทียบข้อดีและข้อจำกัด
หัวข้อ	Three-Way Partitioning	Extra Array Partitioning
ข้อดี	ใช้หน่วยความจำเพียง O(1) และทำงานได้ในรอบเดียว	เข้าใจง่าย และรักษาลำดับข้อมูลเดิมได้
ข้อจำกัด	ไม่รักษาลำดับเดิมของข้อมูล	ต้องใช้อาร์เรย์เพิ่มเติมขนาด O(n)
Time Complexity	O(n)	O(n)
Space Complexity	O(1)	O(n)

สรุปหากต้องการประหยัดหน่วยความจำและให้โปรแกรมทำงานได้รวดเร็ว Three-Way Partitioning ถือว่าเหมาะสมกว่า เพราะทำงานแบบ In-place ใช้เวลา O(n) และใช้พื้นที่เพิ่มเติมเพียง O(1) ส่วน Extra Array Partitioning เหมาะกับกรณีที่ต้องการคงลำดับเดิมของข้อมูล แม้ว่าจะต้องใช้พื้นที่หน่วยความจำเพิ่มก็ตาม.