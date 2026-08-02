**ข้อ 2: การตรวจสอบ Palindrome**

---

### 1. แนวคิดของอัลกอริทึม

**การเตรียมข้อมูล (Preprocessing)**
เพื่อให้รองรับกรณีที่ไม่สนตัวพิมพ์เล็ก-ใหญ่ ช่องว่าง และเครื่องหมายวรรคตอน จึงมีเมธอด `cleanString(String s)` สำหรับจัดรูปแบบข้อมูลก่อนใช้งาน โดยทำ 2 ขั้นตอนหลักคือ

* แปลงตัวอักษรทั้งหมดให้เป็นตัวพิมพ์เล็ก
* ลบอักขระที่ไม่ใช่ตัวอักษรภาษาอังกฤษหรือเลข ด้วย Regular Expression

---

### อัลกอริทึมที่ 1: Reverse and Compare

แนวคิดของวิธีนี้คือ นำสตริงที่ผ่านการทำความสะอาดแล้วมาสร้าง “สตริงกลับด้าน” ด้วย `StringBuilder.reverse()` จากนั้นนำผลลัพธ์ที่ได้ไปเปรียบเทียบกับสตริงเดิม หากทั้งสองค่าเท่ากัน แสดงว่าเป็น Palindrome

---

### อัลกอริทึมที่ 2: Recursive Two-Pointer

แนวคิดคือใช้ตัวชี้สองด้าน (ซ้ายและขวา) เพื่อตรวจสอบตัวอักษรทีละคู่จากขอบเข้าหาศูนย์กลาง

* **Base Case 1:** ถ้า left ≥ right แสดงว่าตรวจสอบครบแล้ว → คืนค่า true
* **Base Case 2:** หากตัวอักษรซ้ายไม่เท่ากับขวา → คืนค่า false ทันที (หยุดก่อน)
* **Recursive Case:** ถ้าตัวอักษรตรงกัน ให้เลื่อน pointer เข้าด้านใน แล้วเรียกฟังก์ชันซ้ำ

---

### 2. Pseudocode

**เมธอดจัดการสตริง**

```
Algorithm cleanString(s)
    If s is null Then
        Return ""
    End If
    Remove non-alphanumeric characters
    Convert to lowercase
    Return s
End Algorithm
```

**Reverse and Compare**

```
Algorithm isPalindromeByReverse(s)
    cleanS = cleanString(s)
    reversedS = reverse(cleanS)
    Return cleanS equals reversedS
End Algorithm
```

**Recursive Two-Pointer**

```
Algorithm isPalindromeRecursive(cleanS, left, right)
    If left >= right Then
        Return true
    End If
    If cleanS[left] != cleanS[right] Then
        Return false
    End If
    Return isPalindromeRecursive(cleanS, left+1, right-1)
End Algorithm
```

---

### 3. ตัวอย่าง Input / Output

* "racecar" → true
* "level" → true
* "algorithm" → false
* "gohangasalamiimalasagnahog" → true
* "A man, a plan, a canal: Panama" → true

---

### 4. วิเคราะห์ Time Complexity

**Reverse and Compare: O(n)**
ทุกขั้นตอน (clean, reverse, compare) ต้องอ่านข้อมูลครบ n ตัว จึงรวมเป็น O(n)

**Recursive Two-Pointer:**

* Best-case: O(1) → เจอความต่างตั้งแต่คู่แรก
* Worst-case: O(n) → ต้องตรวจจนถึงกึ่งกลางของสตริง

---

### 5. วิเคราะห์ Space Complexity

**Reverse and Compare: O(n)**
ต้องสร้างสตริงใหม่และ StringBuilder ขนาด n

**Recursive Two-Pointer: O(n)**
ใช้พื้นที่ Call Stack สูงสุดประมาณ n/2 ระดับ

---

### 6. วิเคราะห์เชิงพฤติกรรม

* หากสตริงเป็น Palindrome

  * ทั้งสองวิธีใช้เวลา O(n)
* หากไม่ใช่ Palindrome และต่างกันตั้งแต่ต้น

  * Reverse: ยังต้องสร้างสตริงกลับครบก่อน
  * Recursive: หยุดทันที (เร็วมาก)

---

### 7. Early Exit

* Reverse & Compare → ไม่มี (ต้องทำครบทุกขั้นตอน)
* Recursive Two-Pointer → มี (หยุดทันทีเมื่อเจอข้อผิดพลาด)

---

### 8. เปรียบเทียบ

| ประเด็น    | Reverse & Compare      | Recursive Two-Pointer        |
| ---------- | ---------------------- | ---------------------------- |
| ข้อดี      | เข้าใจง่าย ใช้งานสะดวก | มี Early Exit เร็วในหลายกรณี |
| ข้อจำกัด   | ต้องสร้างสตริงใหม่เสมอ | ใช้ Stack อาจล้นได้          |
| Best-case  | O(n)                   | O(1)                         |
| Worst-case | O(n)                   | O(n)                         |
| Space      | O(n)                   | O(n)                         |

---

### สรุป

แม้ว่าวิธี Reverse and Compare จะเขียนง่ายและตรงไปตรงมา แต่ Recursive Two-Pointer มีความยืดหยุ่นและมีประสิทธิภาพมากกว่าในหลายสถานการณ์ โดยเฉพาะเมื่อข้อมูลไม่ใช่ Palindrome ซึ่งสามารถหยุดการทำงานได้ตั้งแต่ต้น ทำให้ประหยัดเวลาอย่างมาก
