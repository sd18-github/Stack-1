/*
 * TC: O(n)
 * SC: O(n)
 */
import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int l = temperatures.length;

        int[] result = new int[l];
        Stack<Integer> mStack = new Stack<>();

        for(int i = 0; i < l; i++) {
            // whenever we find a temperature greater than the stack's top,
            // start popping until the top is greater than the current temperature
            while(!mStack.isEmpty() && temperatures[i] > temperatures[mStack.peek()]) {
                int top = mStack.pop();
                // store the difference in indices in the result array
                result[top] = i - top;
            }
            mStack.push(i);
        }
        return result;
    }
}
