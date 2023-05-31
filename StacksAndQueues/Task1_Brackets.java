// A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

// S is empty;
// S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// For example, the string "{[()()]}" is properly nested but "([)()]" is not.

// Write a function:

// class Solution { public int solution(String S); }

// that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

// For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

package StacksAndQueues;

import java.util.Stack;

public class Task1_Brackets {
    public int solution(String S) {
        int N = S.length();
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < N; i++) {
            char c = S.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return 0;
                char top = stack.pop();
                if (c == '}' && top != '{')
                    return 0;
                if (c == ']' && top != '[')
                    return 0;
                if (c == ')' && top != '(')
                    return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Task1_Brackets task1 = new Task1_Brackets();
        String S = "{[()()]}";
        int res = task1.solution(S);
        System.out.println(res);
    }
}
