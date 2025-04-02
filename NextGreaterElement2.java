/*
 * TC: O(n)
 * SC: O(n)
 */
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int i;
        int l = nums.length;
        int[] result = new int[l];
        // monotonically decreasing stack
        Stack<Integer> mStack = new Stack<>();
        for (i = 0; i < l; i++) result[i] = -1;
        // go over the array twice, since it is circular
        for (i = 0; i < 2 * l; i++) {
            int idx = i % l; // get index by modulo for second round
            // whenever we find an element greater than the stack's top,
            // start popping. that element is the next greater element
            // for the popped elements. (that's why we store the index, for easy setting)
            while (!mStack.isEmpty() && nums[mStack.peek()] < nums[idx]) {
                result[mStack.pop()] = nums[idx];
            }
            // push the index onto the stack for further processing
            mStack.push(idx);
        }
        return result;
    }
}
