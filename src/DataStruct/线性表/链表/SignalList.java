package DataStruct.线性表.链表;

import DataStruct.线性表.List;

/**
 * Author: hanzy
 * Date: 2021/9/30, 14:00
 * introduce:
 *  DataStruct.线性表，链式存储结构之单链表，不带头结点
 *  此类中的length是遍历一遍表中数据来计算表的长度
 *      优点是不需注意length的改变，编写更舒心；
 *      缺点是在不能使用length属性的时候需要用length（）方法进行初始化，且需要遍历一遍表，增加了时间开销。
 */
public class SignalList<Item> extends List {

    private String name = "不带头结点的单链表";
    private Node head;

    @Override
    public String name() {
        return name;
    }

    public SignalList(){
        length = 0;
    }

    @Override
    public boolean empty() {
        if(head == null){
            return true;
        }
        return false;
    }

    @Override
    public int length() {
        length = getLength(head);
        return length;
    }

    private int getLength(Node node){
        if(node == null){
            return 0;
        }
        return getLength(node.next) + 1;
    }

    @Override
    public void printList() {
        if(head == null){
            System.out.println("{空表}");
            return ;
        }
        System.out.print("{");
        printData(head);
        System.out.println("}");
    }

    private void printData(Node node){
        if(node == null){
            return ;
        }
        System.out.print("[" + node.data + "],");
        printData(node.next);
    }

    @Override
    public Item getElem(int i) {
        length = getLength(head);
        if(i > length || i < 1){
            return null;
        }
        Node temp = head;
        int len = 1;
        while (len < i){ // 查找时不需要找到前一个结点，所以直接到该位置就行
            len++;
            temp = temp.next;
        }
        return (Item) temp.data;
    }

    @Override
    public boolean listInsert(int i, Object e) {
        length = getLength(head);
        if(i > length+1 || i < 1){
            return false;
        }

        // 头结点特殊处理
        if(i == 1){
            Node node = new Node(e);
            node.next = head;
            head = node;
            return true;
        }

        // 不是头结点一般处理
        int len = 1;
        Node temp = head; // head就是第一个元素，所以从位序上来说，此时的 len == temp == 1 (和带头结点链表的对比看)
                            // 最终的目的是要让 temp = i - 1 (只看temp在表中的位置)
        while (len < i-1){ // 因为 len = temp; 所以当 len = i-1时， temp = i-1;
            len++;
            temp = temp.next; // 从位序上来讲，它可以等于 temp++;
        }
        Node node = new Node(e);
        node.data = (Item) e;
        node.next = temp.next;
        temp.next = node;
        length++;
        return true;
    }

    @Override
    public Item listDelete(int i) {
        length = getLength(head);
//        System.out.println("length = "+ length);
        if(i > length || i < 1){
            return null;
        }

        if(i == 1){
            Node node = head;
            head = head.next;
            node.next = null;
            return (Item) node.data;
        }

        Node temp = head;
        int len = 1;
        while (len < i-1){
            len++;
            temp = temp.next;
        }
        Node node = temp.next;
        temp.next = node.next;
        return (Item) node.data;
    }

    @Override
    public int locateElem(Object o) {
        length = getLength(head);
        if(empty()){
            return -1;
        }
        int len = 1;
        Node temp = head;
        while (temp != null && temp.data != o){
            len++;
            temp = temp.next;
        }
        if(temp == null){
            return -1;
        }
        return len;
    }
}
