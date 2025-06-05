import java.util.Stack;

public class Solution {

    public static void largestArea(){
        int[] arr = new int[]{1,1,1,10,2};
        int n = arr.length;
        if(n==1){
            System.out.println(arr[0]);
            return;
        }
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ;i<=n;i++){
            int currentHeight = (i ==n)?0:arr[i];
            while(!stack.isEmpty() && currentHeight<arr[stack.peek()]){
                int height= arr[stack.pop()];
                int width = stack.isEmpty()?i:i-1-stack.peek();
                maxArea = Math.max(maxArea,height*width);
            }
            stack.push(i);
        }
        System.out.println(maxArea);
    }
    public static void main(String[] args) {
        largestArea();

    }
}
