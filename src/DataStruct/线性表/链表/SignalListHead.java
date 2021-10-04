package DataStruct.线性表.链表;

import DataStruct.线性表.List;

/**
 * Author: hanzy
 * Date: 2021/10/1, 13:07
 * introduce:
 *      线性表之链式存储结构之带头结点的单链表
 *      此类中的length采用的是随着插入删除而变化，
 *          优点是在使用时可以减少一次遍历表所需的时间，且可以直接调用length变量；
 *          缺点是在编写某些函数时需要注意不要忘记改变length的值。
 */
public class SignalListHead<Item> extends List {

    private String name = "带头结点的单链表";
    private Node head;

    public SignalListHead(){
        length = 0;
        head = new Node(null);
        head.next = null;
        head.data = null;
    }

    @Override
    public boolean empty() {
        return head.next == null ? true : false;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public void printList() {
        if(empty()){
            System.out.println("{空表}");
            return ;
        }
        Node temp = head.next;
        System.out.print("{");
        printData(temp);
        System.out.println("}");
    }

    /**
     * 递归来输出链表中的元素
     * @param node
     */
    private void printData(Node node){
        if(node == null){
            return ;
        }
        System.out.print("[" + node.data + "],");
        printData(node.next);
    }

    @Override
    public Item getElem(int i) {
        if(i > length || i < 1){
            return null;
        }
        Node temp = head.next;
        int len = 1;
        while (len < i){
            len++;
            temp = temp.next;
        }
        return (Item) temp.data;
    }

    @Override
    public int locateElem(Object o) {
        if(empty()){
            return -1;
        }
        int len = 1;
        Node temp = head.next;
        while (temp != null && temp.data != o){
            len++;
            temp = temp.next;
        }
        if(temp == null){
            return -1;
        }
        return len;
    }

    @Override
    public boolean listInsert(int i, Object e) {
        if(i > length+1 || i < 1){
            return false;
        }
        int len = 1;
        // 给位序一个例子，带头结点(head)的单链表，在插入一个元素后，表中存在一个元素，则temp = head.next, temp的位序为 1，而因为head不含元素，所以让他的位序为 0
        Node temp = head; // 此处的head就是第0个元素，所以从位序上来说，此时的 temp == len - 1 == 0 (和不带头结点链表的对比看)
                        // 最终的目的是要让 temp = i - 1 (只看temp在表中的位置，找到i位置元素的前一个结点)
        while (len < i){ // 因为 temp = len - 1; 所以当 len = i时， temp = i-1;
            temp = temp.next;
            len++;
        }
        // 分配空间
        Node node = new Node(e);
        // 插入操作
        node.next = temp.next;
        temp.next = node;
        length++;
//        System.out.println("length = " + length);
        return true;
    }

    @Override
    public Item listDelete(int i) {
//        System.out.println("length = " + length);
        if(i < 1 || i > length){
            return null;
        }

        int len = 1;
        Node temp = head;

        while (len < i){
            temp = temp.next;
            len++;
        }

        Node node = temp.next;
        temp.next = node.next;
        node.next = null;
        length--;

        return (Item) node.data;
    }

    @Override
    public String name() {
        return name;
    }
}
