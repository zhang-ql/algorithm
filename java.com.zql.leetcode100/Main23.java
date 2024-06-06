public class Main23 {
//反转链表
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode head) {
        ListNode dump = new ListNode(0);
        while (head != null) {
            ListNode next = head.next;
            head.next = dump.next;
            dump.next = head;
            head = next;
        }
        return dump.next;
    }
    public static ListNode reverseList1(ListNode head) {
        ListNode dump = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = dump;
            dump.next = head;
            head = next;
        }
        return dump;
    }

}
