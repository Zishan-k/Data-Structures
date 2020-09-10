class ListNode {
    public ListNode prev = null;
    ListNode next;
    int data;

    public ListNode(int data,ListNode next) {
        this.next = next;
        this.data = data;
    }
}
