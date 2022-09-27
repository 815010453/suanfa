public class FindBST {
    public ReturnType process(Node x) {
        if (x == null) return new ReturnType(null, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        ReturnType lData = process(x.left);
        ReturnType rData = process(x.right);
        int min = Math.min(x.value, Math.min(lData.min, rData.min));
        int max = Math.max(x.value, Math.max(lData.max, rData.max));
        int maxBSTSize = Math.max(lData.maxBSTSize, rData.maxBSTSize);
        Node maxBSTHead = lData.maxBSTSize >= rData.maxBSTSize ? lData.maxBSTHead : rData.maxBSTHead;
        if (lData.maxBSTHead == x.left && rData.maxBSTHead == x.right && x.value > lData.max && x.value < rData.min) {
            maxBSTSize = lData.maxBSTSize + rData.maxBSTSize + 1;
            maxBSTHead = x;
        }
        return new ReturnType(maxBSTHead, maxBSTSize, min, max);
    }
    public void print(Node head){
        if(head == null) return;
        print(head.left);
        System.out.println(head.value + " ");
        print(head.right);
    }
    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(4);
        head.right = new Node(14);
        head.left.left = new Node(2);
        head.left.right = new Node(5);
        head.right.left = new Node(11);
        head.right.right = new Node(15);
        FindBST f = new FindBST();

        Node BSTHead = f.process(head).maxBSTHead;
        f.print(head);
        f.print(BSTHead);

    }
}