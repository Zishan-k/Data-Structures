package TestLinkedList;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerList = null, node = null;
        int res, mod, ans, flag=0;
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new ListNode(0);
            } else if (l2 == null) {
                node = answerList;
                while (node.next != null) {
                    node = node.next;
                }
                node.next = new ListNode(0);
            }

            else if ((l1.val + l2.val) > 9 ) {
                res = l1.val + l2.val;
                mod = res / 10;
                try {
                    l1.next.val = l1.next.val + mod;
                }catch (NullPointerException e){
                    flag =1;
                }
                ans = res % 10;
                if (answerList == null) {
                    answerList = new ListNode(ans, null);
                } else {
                    node = answerList;
                    while (node.next != null) {
                        node = node.next;
                    }
                    node.next = new ListNode(ans, null);
                }
            } else {
                if (answerList == null) {
                    answerList = new ListNode((l1.val + l2.val), null);
                } else {
                    node = answerList;
                    while (node.next != null) {
                        node = node.next;
                    }
                    node.next = new ListNode((l1.val + l2.val), null);
                }
            }
            if(l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        if(flag == 1) {
            node = answerList;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new ListNode(1, null);
        }
            return answerList;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, null);
        l1.next = new ListNode(9, null);
        l1.next.next = new ListNode(9, null);
        l1.next.next.next = new ListNode(9, null);
        l1.next.next.next.next = new ListNode(9, null);
        l1.next.next.next.next.next = new ListNode(9, null);
        l1.next.next.next.next.next.next = new ListNode(9, null);

        ListNode l2 = new ListNode(9, null);
        l2.next = new ListNode(9, null);
        l2.next.next = new ListNode(9, null);
        l2.next.next.next = new ListNode(9, null);

        Solution sol = new Solution();
        ListNode ans = sol.addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.print(" " + ans.val);
            ans = ans.next;
        }
    }
}
