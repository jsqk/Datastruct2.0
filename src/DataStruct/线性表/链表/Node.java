package DataStruct.线性表.链表;

/**
 * Author: hanzy
 * Date: 2021/9/30, 14:02
 * introduce:
 */
public class Node<Item> {
    public Item data;
    public Node next;

    public Node(Item data){
        this.data = data;
        this.next = null;
    }
}
