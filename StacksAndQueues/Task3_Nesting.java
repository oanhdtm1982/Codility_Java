// A string S consisting of N characters is called properly nested if:

// S is empty;
// S has the form "(U)" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// For example, string "(()(())())" is properly nested but string "())" isn't.

// Write a function:

// class Solution { public int solution(String S); }

// that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

// For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

package StacksAndQueues;

import java.util.Stack;

public class Task3_Nesting {
    public int solution(String S) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return 0;
                char top = stack.pop();
                if (c == ')' && top != '(')
                    return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        Task3_Nesting task3 = new Task3_Nesting();
        String S = "(()(())())";
        int res = task3.solution(S);
        System.out.println(res);
    }
}
