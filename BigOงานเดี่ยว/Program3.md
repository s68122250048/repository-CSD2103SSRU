ข้อ 3: การเปรียบเทียบจำนวนสระและพยัญชนะ
1. แนวคิดของอัลกอริทึม
กฎและเงื่อนไขในการพิจารณา
ตัวอักษรที่จัดเป็น สระ ได้แก่ a, e, i, o, u (ไม่คำนึงถึงตัวพิมพ์เล็กหรือใหญ่)
ตัวอักษรภาษาอังกฤษอื่น ๆ ในช่วง a–z ที่ไม่ใช่สระ ถือเป็น พยัญชนะ
ไม่นำมาคิดรวม:
ตัวเลข
ช่องว่าง
สัญลักษณ์พิเศษทุกชนิด
อัลกอริทึมที่ 1: Recursive Counting (hasMoreVowelsRecursive)

แนวทาง:
ใช้เทคนิคการเรียกฟังก์ชันซ้ำ โดยไล่ตรวจสอบตัวอักษรทีละตำแหน่ง พร้อมส่งค่าตัวนับสะสมไปยังการเรียกครั้งถัดไป

พารามิเตอร์ที่ใช้:
index สำหรับตำแหน่งปัจจุบัน
vowelCount สำหรับนับสระ
consonantCount สำหรับนับพยัญชนะ

เงื่อนไขสิ้นสุด (Base Case):
เมื่อ index เท่ากับความยาวของสตริง
→ เปรียบเทียบว่า vowelCount > consonantCount แล้วคืนค่า

ขั้นตอนการทำซ้ำ (Recursive Case):

อ่านตัวอักษรตำแหน่งปัจจุบัน
ถ้าเป็นสระ → เพิ่มตัวนับสระ
ถ้าเป็นพยัญชนะ → เพิ่มตัวนับพยัญชนะ
ถ้าไม่ใช่ตัวอักษร → ไม่เปลี่ยนค่า
จากนั้นเรียกฟังก์ชันต่อด้วย index + 1
อัลกอริทึมที่ 2: Iterative Counting (hasMoreVowelsIterative)

แนวทาง:
ใช้ลูป for เพื่อวนอ่านตัวอักษรตั้งแต่ต้นจนจบ โดยมีตัวแปรสำหรับนับจำนวนสระและพยัญชนะ จากนั้นจึงเปรียบเทียบผลเมื่อสิ้นสุดการวนลูป

2. Pseudocode
Algorithm isVowel(ch)
    Convert ch to lowercase
    Return true if ch is one of {'a','e','i','o','u'}
End Algorithm

Algorithm isConsonant(ch)
    Convert ch to lowercase
    Return true if ch อยู่ระหว่าง 'a' ถึง 'z' และไม่ใช่สระ
End Algorithm

Algorithm countRecursive(s, index, vCount, cCount)
    If index == length(s) Then
        Return vCount > cCount
    End If

    ch = s[index]

    If isVowel(ch) Then
        vCount = vCount + 1
    Else If isConsonant(ch) Then
        cCount = cCount + 1
    End If

    Return countRecursive(s, index + 1, vCount, cCount)
End Algorithm

Algorithm hasMoreVowelsRecursive(s)
    If s is null Then Return false
    Return countRecursive(s, 0, 0, 0)
End Algorithm

Algorithm hasMoreVowelsIterative(s)
    If s is null Then Return false

    vCount = 0
    cCount = 0

    For i = 0 to length(s) - 1 Do
        ch = s[i]
        If isVowel(ch) Then
            vCount = vCount + 1
        Else If isConsonant(ch) Then
            cCount = cCount + 1
        End If
    End For

    Return vCount > cCount
End Algorithm
3. ตัวอย่างโค้ดภาษา Java
public class VowelConsonantCounter {

    private static boolean isVowel(char c) {
        char ch = Character.toLowerCase(c);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static boolean isConsonant(char c) {
        char ch = Character.toLowerCase(c);
        return ch >= 'a' && ch <= 'z' && !isVowel(ch);
    }

    private static boolean countRecursive(String s, int index, int v, int c) {
        if (index == s.length()) {
            return v > c;
        }

        char ch = s.charAt(index);

        if (isVowel(ch)) {
            v++;
        } else if (isConsonant(ch)) {
            c++;
        }

        return countRecursive(s, index + 1, v, c);
    }

    public static boolean hasMoreVowelsRecursive(String s) {
        if (s == null) return false;
        return countRecursive(s, 0, 0, 0);
    }

    public static boolean hasMoreVowelsIterative(String s) {
        if (s == null) return false;

        int v = 0, c = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isVowel(ch)) {
                v++;
            } else if (isConsonant(ch)) {
                c++;
            }
        }

        return v > c;
    }
}
4. ตัวอย่างข้อมูลเข้าและผลลัพธ์
"education" → สระ 5, พยัญชนะ 4 → true
"Hello World 123!!!" → สระ 3, พยัญชนะ 7 → false
"aeiou" → สระ 5, พยัญชนะ 0 → true
"123456" → ไม่มีตัวอักษร → false
5. การวิเคราะห์ Time Complexity
Recursive Counting: O(n)
Iterative Counting: O(n)

เนื่องจากทั้งสองวิธีต้องตรวจสอบอักขระทุกตัวในสตริง โดยแต่ละขั้นตอนใช้เวลาคงที่

6. การวิเคราะห์ Space Complexity
Recursive Counting: O(n)
เกิดจากการใช้ call stack ตามจำนวนการเรียกซ้ำ
Iterative Counting: O(1)
ใช้เพียงตัวแปรนับจำนวนเล็กน้อย ไม่มีการใช้หน่วยความจำเพิ่มเติม
7. วิเคราะห์เพิ่มเติม
จำนวนครั้งของการเรียกแบบ recursion ≈ n + 1
Recursive:
มีโอกาสเกิด StackOverflowError หากสตริงมีขนาดใหญ่มาก
Iterative:
ไม่เกิดปัญหา stack ล้น
รองรับข้อมูลขนาดใหญ่ได้ดีกว่า
8. เปรียบเทียบและสรุป
ประเด็น	Recursive Counting	Iterative Counting
Time Complexity	O(n)	O(n)
Space Complexity	O(n)	O(1)
ความเสี่ยง Stack Overflow	มี	ไม่มี
ลักษณะเด่น	แสดงแนวคิด recursion ชัดเจน	ทำงานจริงได้มีประสิทธิภาพ

สรุปแม้ทั้งสองวิธีจะมีเวลาในการทำงานเท่ากัน แต่
Iterative Counting เป็นทางเลือกที่ดีกว่าในทางปฏิบัติ
เพราะใช้หน่วยความจำน้อยกว่า และไม่เกิดปัญหา stack overflow เมื่อประมวลผลข้อมูลขนาดใหญ่