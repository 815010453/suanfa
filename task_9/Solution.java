public class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        int offset = 1;
        int temp = x;
        while(temp > 9){
            offset *= 10;
            temp /= 10;
        }
        while(x>9){
            int m = x/offset;
            int n = x % 10;
            System.out.println(m);
            System.out.println(n);
            if(m!=n) return false;
            x /= 10;
            offset /= 10;
        }
        return true;
    }
    public static void main(String[] args) {
        boolean res = isPalindrome(121);
        System.out.println(res);
    }
}
