ข้อ 6: การค้นหาอาร์เรย์ย่อยที่มีผลรวมมากที่สุด (Maximum Subarray Sum)
1. หลักการของอัลกอริทึม
โจทย์

กำหนดอาร์เรย์จำนวนเต็ม A แล้วต้องการหาช่วงข้อมูลที่อยู่ติดกัน (Subarray) ซึ่งมีผลรวมของสมาชิกมากที่สุด

อัลกอริทึมที่ 1 : Brute Force

แนวคิดของวิธีนี้คือทดลองสร้าง Subarray ที่เป็นไปได้ทุกช่วง แล้วหาว่าช่วงใดมีผลรวมมากที่สุด

ขั้นตอนการทำงาน

ใช้ลูปตัวแรกกำหนดตำแหน่งเริ่มต้นของ Subarray
ใช้ลูปตัวที่สองกำหนดตำแหน่งสิ้นสุด
คำนวณผลรวมของสมาชิกตั้งแต่ตำแหน่งเริ่มต้นจนถึงตำแหน่งสิ้นสุด
หากผลรวมที่ได้มากกว่าค่าสูงสุดเดิม ให้ปรับปรุงค่า maxSum

ข้อเสียของวิธีนี้คือจำเป็นต้องตรวจสอบทุกช่วงของข้อมูล ทำให้ใช้เวลาค่อนข้างมากเมื่ออาร์เรย์มีขนาดใหญ่

อัลกอริทึมที่ 2 : Kadane's Algorithm

Kadane's Algorithm อาศัยหลักการของ Dynamic Programming โดยพิจารณาข้อมูลทีละตำแหน่ง

สำหรับสมาชิกแต่ละตัว จะเลือกอย่างใดอย่างหนึ่ง

นำค่าปัจจุบันไปต่อกับผลรวมเดิม
เริ่มสร้าง Subarray ใหม่จากสมาชิกตัวปัจจุบัน

ใช้สมการ

currentMax = max(A[i], currentMax + A[i])

จากนั้นเปรียบเทียบกับค่าผลรวมสูงสุดที่พบ (maxSum) และอัปเดตเมื่อพบค่าที่มากกว่า

ข้อดีคือใช้อาร์เรย์เพียงรอบเดียว จึงทำงานได้รวดเร็วและใช้หน่วยความจำเพียงเล็กน้อย

2. Pseudocode
Algorithm maxSubarrayBruteForce(A)

If A is null or empty Then Return 0

maxSum = A[0]

For i = 0 To length(A)-1

    currentSum = 0

    For j = i To length(A)-1

        currentSum = currentSum + A[j]

        If currentSum > maxSum Then
            maxSum = currentSum
        End If

    End For

End For

Return maxSum
Algorithm maxSubarrayKadane(A)

If A is null or empty Then Return 0

currentMax = A[0]
maxSum = A[0]

For i = 1 To length(A)-1

    currentMax = Max(A[i], currentMax + A[i])

    maxSum = Max(maxSum, currentMax)

End For

Return maxSum
3. ภาษา Java
public class MaxSubarray {

    // Algorithm 1 : Brute Force
    public static int maxSubarrayBruteForce(int[] a) {

        if (a == null || a.length == 0)
            return 0;

        int maxSum = a[0];

        for (int i = 0; i < a.length; i++) {

            int currentSum = 0;

            for (int j = i; j < a.length; j++) {

                currentSum += a[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }

        return maxSum;
    }

    // Algorithm 2 : Kadane's Algorithm
    public static int maxSubarrayKadane(int[] a) {

        if (a == null || a.length == 0)
            return 0;

        int currentMax = a[0];
        int maxSum = a[0];

        for (int i = 1; i < a.length; i++) {

            currentMax = Math.max(a[i], currentMax + a[i]);
            maxSum = Math.max(maxSum, currentMax);

        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] input1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Input 1");
        System.out.println("Brute Force : " + maxSubarrayBruteForce(input1));
        System.out.println("Kadane      : " + maxSubarrayKadane(input1));

        int[] input2 = {-8, -3, -6, -2, -5};

        System.out.println("\nInput 2");
        System.out.println("Brute Force : " + maxSubarrayBruteForce(input2));
        System.out.println("Kadane      : " + maxSubarrayKadane(input2));
    }
}
4. ตัวอย่างข้อมูลเข้าและผลลัพธ์

Input 1

[-2, 1, -3, 4, -1, 2, 1, -5, 4]

ผลลัพธ์

Subarray ที่ให้ผลรวมสูงสุด = [4, -1, 2, 1]

Maximum Sum = 6

Input 2

[-8, -3, -6, -2, -5]

ผลลัพธ์

Subarray ที่ให้ผลรวมสูงสุด = [-2]

Maximum Sum = -2
5. วิเคราะห์ Time Complexity
Brute Force

Time Complexity : O(n²)

เหตุผล

อัลกอริทึมใช้ลูปซ้อนกันสองชั้นเพื่อตรวจสอบทุกช่วงของ Subarray ทำให้จำนวนครั้งในการทำงานเพิ่มขึ้นตามกำลังสองของจำนวนข้อมูล

Kadane's Algorithm

Time Complexity : O(n)

เหตุผล

อัลกอริทึมเดินผ่านอาร์เรย์เพียงครั้งเดียว และแต่ละตำแหน่งใช้การคำนวณกับการเปรียบเทียบเพียงค่าคงที่ จึงมีความซับซ้อนเป็นเชิงเส้น

6. วิเคราะห์ Space Complexity
Brute Force

Space Complexity : O(1)

เหตุผล

ใช้เพียงตัวแปรสำหรับเก็บผลรวมปัจจุบันและผลรวมสูงสุด โดยไม่มีการสร้างโครงสร้างข้อมูลเพิ่มเติม

Kadane's Algorithm

Space Complexity : O(1)

เหตุผล

ใช้ตัวแปรเพียงไม่กี่ตัว เช่น currentMax และ maxSum จึงใช้หน่วยความจำคงที่ตลอดการทำงาน

7. วิเคราะห์เพิ่มเติม
กรณีอาร์เรย์มีค่าติดลบทั้งหมด

Kadane's Algorithm ที่เริ่มต้นค่าด้วยสมาชิกตัวแรกสามารถหาคำตอบได้อย่างถูกต้อง แม้ว่าข้อมูลทุกตัวจะเป็นค่าลบก็ตาม โดยจะเลือกค่าที่มีค่ามากที่สุด (ติดลบน้อยที่สุด)

ตัวอย่าง

[-8, -3, -6, -2, -5]

คำตอบคือ

-2
เปรียบเทียบกับ Divide and Conquer

อีกวิธีหนึ่งคือ Divide and Conquer ซึ่งแบ่งอาร์เรย์ออกเป็นสองส่วน แล้วหาคำตอบจากฝั่งซ้าย ฝั่งขวา และช่วงที่คร่อมตรงกลาง

วิธีนี้มีเวลาในการทำงาน O(n log n) และต้องใช้พื้นที่จาก Recursion Stack ประมาณ O(log n)

ในขณะที่ Kadane's Algorithm ใช้เวลาเพียง O(n) และใช้หน่วยความจำเพียง O(1) จึงมีประสิทธิภาพดีกว่าในภาพรวม

8. เปรียบเทียบข้อดีและข้อจำกัด
หัวข้อ	Brute Force	Kadane's Algorithm
ข้อดี	หลักการไม่ซับซ้อน เข้าใจง่าย และตรวจสอบทุก Subarray ได้	ประมวลผลรวดเร็ว ใช้การสแกนข้อมูลเพียงครั้งเดียว
ข้อจำกัด	ใช้เวลามากเมื่อข้อมูลมีขนาดใหญ่	ต้องเข้าใจแนวคิดของ Dynamic Programming
Time Complexity	O(n²)	O(n)
Space Complexity	O(1)	O(1)

สรุป Kadane's Algorithm เป็นวิธีที่เหมาะสมที่สุดสำหรับการหา Maximum Subarray Sum เนื่องจากสามารถหาคำตอบได้ในเวลา O(n) พร้อมทั้งใช้หน่วยความจำเพียง O(1) จึงมีประสิทธิภาพเหนือกว่า Brute Force โดยเฉพาะเมื่อทำงานกับอาร์เรย์ที่มีข้อมูลจำนวนมาก