Note:
1.Complete All Questions
2.Deadline : 30th September 2019, 12:00pm

Q1. Write a Java class named 'Course'
It should have following members
courseId
courseName
maxCapacity
professorId
credits
int[] studentIds

Function: registerStudent(int studentId)

There should be 3 ways to create Course Object (Hint : Use Constructor)
courseId
courseId, professorId
courseId, professorId, credits

Class should provide getters/setters for all members
registerStudent method should store all ids in studentIds array.



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Course {
    private int courseId;
    private String courseName;
    private int maxCapacity;
    private int capacity;
    private int professorId;
    private int credits;
    private int[] studentIds;

    public Course(int courseId) {
        this.setCourseId(courseId);
    }

    public Course(int courseId, int professorId) {
        this.setCourseId(courseId);
        this.setProfessorId(professorId);
    }

    public Course(int courseId, int professorId, int credits) {
        this.setCourseId(courseId);
        this.setProfessorId(professorId);
        this.setCredits(credits);
    }


    public void registerStudent(int studentId){
        if (capacity == maxCapacity) {
            throw new MaxCapacityException("Maximum students reached, unable to register new student.");
        }
        studentIds[capacity] = studentId;
        capacity++;
        if(capacity == maxCapacity){
            studentIds = this.removeDuplicates(studentIds);
        }
    }

    public int getCoueseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        if (courseId <= 0) {
            throw new IllegalArgumentException("courseId should bigger than 0.");
        }
        this.courseId = courseId;
    }

    public String getCoueseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if(courseName.length() < 10 || courseName.length() > 60){
            throw new IllegalArgumentException("courseName should be a string with minimum length 10 and maximum 60.");
        }else{
            this.courseName = courseName;
        }
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        if(maxCapacity < 10 || maxCapacity > 100){
            throw new IllegalArgumentException("maxCapacity should not be less than 10 greater than 100.");
        }else{
            this.maxCapacity = maxCapacity;
        }
    }

    //Since capacity tracks the current number of registered students, it shouldn't have setter method.
    public int getCapacity() {
        return capacity;
    }

    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        if(professorId < 100000 || professorId > 999999){
            throw new IllegalArgumentException("professId should be a six digit integer.");
        }else{
            this.professorId = professorId;
        }

    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        if(credits < 0 || credits >9){
            throw new IllegalArgumentException("credits should be a single digit but greater than 0.");
        }
        this.credits = credits;
    }

    public int[] getStudentIds() {
        return studentIds;
    }

    public void setStudentIds(int[] studentIds) {
        this.studentIds = studentIds;
    }

    public int[] removeDuplicates(int[] studentIds) {
        Set<Integer> studentIdsSet = new HashSet<>();
        for(int id : studentIds) {
            studentIdsSet.add(id);
        }
        int[] uniqueStudentIds = new int[maxCapacity];
        int i = 0;
        for(Integer id : studentIdsSet){
            uniqueStudentIds[i] = id;
            i++;
        }
        capacity = studentIdsSet.size();
        return studentIds;
    }

    public int groupsOfStudents(int[] studentIds) {
        int sum = 0;
        int oddCount = 0, evenCount = 0;

        for (int id : studentIds) {
            if (id % 2 == 0) {
                sum += evenCount++;
            } else {
                sum += oddCount++;
            }
        }

        return sum;
    }
}

class MaxCapacityException extends RuntimeException {
    public MaxCapacityException(String message) {
        super(message);
    }
}

-----------------------------------------------------------------------------------------------------------------------

Q2. In the above example, add following validations to setters/constructors
courseId - should not be negative or 0
courseName- should be a string with minimum length 10 and maximum 60
maxCapacity - should not be less than 10 greater than 100
professorId - should be a six digit integer
credits - should be a single digit but greater than 0

-----------------------------------------------------------------------------------------------------------------------

Q3. Add a function called removeDuplicates in Course class
This function should be called if course has reached the maximum capacity and
remove all duplicate student Ids and return the new ids

Ex: Input :[1,6,2,3,2,4,5,6]
Output: [1,6,2,3,4,5]

public int[] removeDuplicates(int[] studentIds) {
}

-----------------------------------------------------------------------------------------------------------------------

Q4. Implement the following method in Course class.

public int groupsOfStudents(int[] studentIds) {

}

The above method takes an array of studentIds as an argument. Find number of pairs of studentsIds whose sum is even
Example:
Input : [1,2,3,4,5,6]
Output : 6
Explanation: (1 + 3), (1 + 5), (3 + 5), (2 + 4), (2 + 6), (4 + 6)

-----------------------------------------------------------------------------------------------------------------------

Q5.
The count-and-say sequence is a sequence of integers with the first five terms as following:
1.     1
2.     11
3.     21
4.     1211
5.     111221

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
Note: Each term of the sequence of integers will be represented as a string.

Example 1:
Input: 1
Output: "1"

Example 2:
Input: 4
Output: "1211"



public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++){
          s = say(s);
        }
        return s;
    }

    public String say(String s) {
        Integer count = 1;
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 1; i < s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1)){
                count++;
            }else {
                sb.append(count);
                sb.append(s.charAt(i-1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(i-1));
        return sb.toString();
    }
-----------------------------------------------------------------------------------------------------------------------

Q6. Given an input string , reverse the string word by word.
Example:
Input : “the sky is blue”
Output : “blue is sky the”
Assumptions:
A word is defined as a sequence of non-space characters.
The input string does not contain leading or trailing spaces.
The words are always separated by a single space.


public String reverse(String s){
        String[] splitS = s.trim().split("\\s+"); 
        StringBuilder reversedS = new StringBuilder();

        for(int i = splitS.length - 1; i >= 0; i--){
            reversedS.append(splitS[i] + " ");
        }
        return reversedS.toString().trim();
    }
-----------------------------------------------------------------------------------------------------------------------


Q7.
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
Example 1:
Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:
Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

    public int[] spiralOrder(int[][] matrix) {
	    if (matrix.length == 0) return new int[0];
        int row = matrix.length;
        int column = matrix[0].length;
        int loop;
        int p;
        if(row < column){
            loop = (row + 1) / 2;
        }else {
            loop = (column + 1) / 2;
        }

        ArrayList<Integer> spiraledArray = new ArrayList<>();

        for(int i = 1; i <= loop; i++){
            int r=i-1, c =i-1;
            while(c < column - i + 1){
                spiraledArray.add(matrix[r][c++]);
            }
            c--;
            p = r;
            r++;

            while (r < row - i + 1){
                spiraledArray.add(matrix[r++][c]);
            }
            r--;
            if(p == r){
                break;
            }
            p = c;
            c--;
            while (c >= i-1){
                spiraledArray.add(matrix[r][c--]);
            }
            c++;
            if(p == c){
                break;
            }
            r--;
            while (r > i-1){
                spiraledArray.add(matrix[r--][c]);
            }
        }
        return spiraledArray.stream().mapToInt(n -> n).toArray();
    }

-----------------------------------------------------------------------------------------------------------------------

Q8.
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:
String convert(string s, int numRows);
Example 1:
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"

Example 2:
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            rows.add(new StringBuilder());
        }
        int i = 0;
        while(i < s.length()){
            for(int r = 0; r < numRows; r++, i++){
                if (i < s.length()) {
                    rows.get(r).append(s.charAt(i));
                }
            }
            for (int r = numRows -2; r > 0; r--, i++) {
                if (i < s.length()) {
                    rows.get(r).append(s.charAt(i));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p = 0; p < numRows; p++){
            sb = sb.append(rows.get(p));
        }
        return sb.toString();
    }

-----------------------------------------------------------------------------------------------------------------------

Q9. Explain Encapsulation with an example. (Write at least 30-40 words).

Encapsulation is a way to wrap the data of a class securely, so that outside worlds don't have access to it directly. Class can declare non-private methods to access the data or mutate the data.
For example, a Student class has member "name", "age", "sex", "scores". It also provides setter and getter methods for each of the member. When outside world wants to get a Student s name, it has to call s.getName().
In this way, members of Student s are encapsulated as a single unit within the instance.


-----------------------------------------------------------------------------------------------------------------------

Q10. What is the difference between Encapsulation and Abstraction
The aim of Encapsulation is to protect the inner logic and make it easier to change codes without impacting outside worlds.
While the aim of Abstraction is to simplify the logic visible to outside worlds, so that consumer quickly understands the functionality, without knowing unnecessary details.

	


