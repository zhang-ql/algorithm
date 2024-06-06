public class Main22 {
//
    //相交链表
    //走到尽头见不到你，于是走过你来时的路，等到相遇时才发现，你也走过我来时的路。
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(5);
        ListNode b3 = new ListNode(3);
        ListNode b4 = new ListNode(2);
        ListNode b5 = new ListNode(4);

        a1.next = a2; a2.next = a3; a3.next = a4;
        b1.next = b2; b2.next = b3; b3.next = b4; b4.next = b5;

        // 让链表A和链表B在节点a3处相交
        a4.next = b3;
        System.out.println(new Main22().getIntersectionNode(a1,b1).val);
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}
