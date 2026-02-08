class Solution {
    public int[] asteroidCollision(int[] asteroids) {
         Stack<Integer> stack = new Stack<>();
        
        for (int asteroid : asteroids) {
            boolean alive = true;
            
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -asteroid) {
                    stack.pop(); // top explodes
                } else if (top == -asteroid) {
                    stack.pop(); // both explode
                    alive = false;
                } else {
                    alive = false; // asteroid explodes
                }
            }
            
            if (alive) {
                stack.push(asteroid);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;        
    }
}