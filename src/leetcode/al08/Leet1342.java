package leetcode.al08;

public class Leet1342 {
    public static void main(String[] args) {
        Leet1342 l = new Leet1342();
        System.out.println(l.numberOfSteps(14));    // 6
        System.out.println(l.numberOfSteps(8));        // 4
        System.out.println(l.numberOfSteps(123));    // 12
    }

    public int numberOfSteps(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num - 1;
            }
            count++;
        }
        return count;
    }
}
