package DataStruct.线性表.顺序表;

import DataStruct.线性表.List;

/**
 * Author: hanzy
 * Date: 2021/9/30, 9:53
 * introduce:
 */
public class SqList<Item> extends List  {

    private final String name = "顺序表";
    private int maxsize;
    private Item[] list;

    public SqList(int maxsize){
        this.maxsize = maxsize;
        list = (Item[]) new Object[maxsize];
        length = 0;
    }

    @Override
    public String name() {
        return name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public int locateElem(Object o) {
        for(int i = 0; i < list.length; i++){
            if (list[i].equals(o)){
                return i+1; // 线性表中的位序从1开始，而数组是从0开始的，所以应当返回i+1;
            }
        }
        return -1; // 没有查找到该元素，返回-1
    }

    @Override
    public Object getElem(int i) {
        if(i > length || i < 1){
            return null;
        }
        return list[i-1];
    }

    @Override
    public void printList() {
        if(length == 0){
            System.out.println("{空表}");
            return ;
        }
        System.out.print("{");
        for(int i = 0; i < length; i++){
            System.out.print("[" + list[i] + "],");
        }
        System.out.println("}");
    }

    @Override
    public boolean empty() {
        if(length == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean listInsert(int i, Object e) {
        if(i > length+1 || i < 1){
            return false;
        }
        if(length >= maxsize){
            return false;
        }
        for(int j = length; j >= i; j--){
            /**
             * 考研出题点：移动了多少个元素？
             * 答：一共n个元素，i之后的元素向后移动，即从i+1开始一直到n的元素向后移动一个位置 ①
             * 再问：从i到n有多少个元素?
             * 答：有n-i+1个元素，故从i+1到n有?个元素 ②
             * *
             *  结合①，②，立即推--->移动了n-i个元素
             */
            list[j] = list[j-1];
        }
        list[i-1] = (Item) e;
        length++;
        return true;
    }

    @Override
    public Item listDelete(int i) {
        if(i > length || i < 1){
            return null;
        }
        Item e = list[i-1];
        for(int j = i; j < length; j++){
            /**
             * 移动多少个元素？
             *  将第i个位置后的元素全部向前移动一个位置，结合插入操作中的问题。
             *  立即推--->移动 n-i 个元素
             */
            list[j-1] = list[j];
        }
        this.length--;
        return e;
    }
}
