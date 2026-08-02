ข้อ 4: การแยกกลุ่มจำนวนคู่และจำนวนคี่
1. แนวคิดของอัลกอริทึม

โจทย์ต้องการปรับตำแหน่งข้อมูลในอาร์เรย์จำนวนเต็ม A โดยให้ ค่าที่เป็นเลขคู่ไปอยู่ด้านหน้า และ เลขคี่อยู่ด้านหลัง โดย ไม่จำเป็นต้องเรียงค่าภายในแต่ละกลุ่ม

 วิธีที่ 1: Recursive Two-Pointer (rearrangeRecursive)

หลักการ:
ใช้ตัวชี้สองฝั่ง

left เริ่มต้นที่ต้นอาร์เรย์
right เริ่มจากท้ายอาร์เรย์

เงื่อนไขหยุด (Base Case):

เมื่อ left >= right แปลว่าตัวชี้มาชนหรือข้ามกันแล้ว

ขั้นตอนการทำงาน:

ถ้าค่าทางซ้ายเป็นเลขคู่ → เลื่อน left ไปข้างหน้า
ถ้าค่าทางขวาเป็นเลขคี่ → เลื่อน right ถอยหลัง
ถ้าซ้ายเป็นคี่และขวาเป็นคู่ → สลับค่า แล้วเลื่อนทั้งสองด้าน
เรียกฟังก์ชันซ้ำในช่วงที่เหลือ
 วิธีที่ 2: Iterative Two-Pointer (rearrangeTwoPointer)

หลักการ:
ใช้แนวคิดเดียวกับแบบแรก แต่เปลี่ยนเป็นการวนลูป while แทนการเรียกซ้ำ

ขั้นตอน:

ใช้ลูปทำงานตราบใดที่ left < right
เลื่อน left ข้ามเลขคู่
เลื่อน right ข้ามเลขคี่
เมื่อพบตำแหน่งที่ต้องสลับ → ทำการ swap แล้วขยับตัวชี้
 วิธีที่ 3: Extra Array (rearrangeExtraArray)

หลักการ:
สร้างอาร์เรย์ใหม่ขนาดเท่าของเดิม

ขั้นตอน:

วนรอบแรก → เก็บเลขคู่ลงในอาร์เรย์ใหม่ก่อน
วนรอบสอง → เติมเลขคี่ต่อท้าย

จุดเด่น:

รักษาลำดับเดิมของข้อมูลได้ (Stable Algorithm)
2. Pseudocode
วิธีที่ 1: Recursive
Algorithm rearrangeRecursive(A, left, right)
    If left >= right Then
        Return
    End If

    If A[left] เป็นเลขคู่ Then
        เรียกซ้ำ(left+1, right)
    Else If A[right] เป็นเลขคี่ Then
        เรียกซ้ำ(left, right-1)
    Else
        สลับค่า A[left], A[right]
        เรียกซ้ำ(left+1, right-1)
    End If
End
วิธีที่ 2: Iterative
Algorithm rearrangeTwoPointer(A)
    left = 0
    right = n-1

    While left < right
        เลื่อน left ข้ามเลขคู่
        เลื่อน right ข้ามเลขคี่

        If left < right Then
            สลับค่า
            left++
            right--
        End If
    End While
End
วิธีที่ 3: Extra Array
Algorithm rearrangeExtraArray(A)
    สร้าง result ขนาดเท่า A
    index = 0

    // ใส่เลขคู่
    For ทุกค่าใน A
        ถ้าเป็นเลขคู่ → result[index++]

    // ใส่เลขคี่
    For ทุกค่าใน A
        ถ้าเป็นเลขคี่ → result[index++]

    Return result
End
3. ตัวอย่างผลลัพธ์

Input:
[7, 2, 9, 4, 1, 6, 3, 8]

Recursive → [8, 2, 6, 4, 1, 9, 3, 7] (ไม่รักษาลำดับ)
Iterative → [8, 2, 6, 4, 1, 9, 3, 7] (ไม่รักษาลำดับ)
Extra Array → [2, 4, 6, 8, 7, 9, 1, 3] (รักษาลำดับ)
4. การวิเคราะห์ Time Complexity
Recursive Two-Pointer → O(n)
Iterative Two-Pointer → O(n)
Extra Array → O(n)

เหตุผล: ทุกวิธีต้องตรวจสอบข้อมูลครบทุกตำแหน่ง

5. การวิเคราะห์ Space Complexity
Recursive → O(n) (ใช้ stack จากการเรียกซ้ำ)
Iterative → O(1) (ไม่ใช้หน่วยความจำเพิ่ม)
Extra Array → O(n) (มีอาร์เรย์ใหม่)
6. ประเด็นเพิ่มเติม
การแก้ไขข้อมูลเดิม
Recursive / Iterative → แก้ในอาร์เรย์เดิม (In-place)
Extra Array → คืนค่าเป็นอาร์เรย์ใหม่
ความคงลำดับ (Stability)
Two-Pointer → ไม่คงลำดับ
Extra Array → คงลำดับเดิมทั้งหมด
7. สรุปเปรียบเทียบ
ประเด็น	Recursive	Iterative	Extra Array
การใช้หน่วยความจำ	O(n)	O(1)	O(n)
เวลา	O(n)	O(n)	O(n)
แก้ค่าเดิม	✔	✔	✘
ความคงลำดับ	✘	✘	✔
ความเสี่ยง	Stack Overflow	ไม่มี	ใช้พื้นที่เพิ่ม
สรุป ถ้าต้องการ เร็ว + ใช้หน่วยความจำน้อยที่สุด → ใช้ Iterative Two-Pointer
ถ้าจำเป็นต้อง คงลำดับข้อมูลเดิม → ต้องใช้ Extra Array