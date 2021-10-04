package DataStruct.线性表;

import DataStruct.Basic;
import DataStruct.线性表.链表.SignalList;
import DataStruct.线性表.链表.SignalListHead;
import DataStruct.线性表.顺序表.SqList;

import java.util.Scanner;

/**
 * Author: hanzy
 * Date: 2021/9/30, 10:26
 * introduce:
 */
public class Test {
//    public static void main(String[] args) {
//        List list = new SqList(10);
//        int[] arr = {8, 9, 0, 6 ,5};
//        for(int i = 0; i < arr.length; i++){
//           list.listInsert(list.length()+1, arr[i]);
//        }
//        System.out.println("当前表长为：" + list.length());
//        Integer len = (Integer) list.listDelete(2);
//        System.out.println("当前表长为：" + list.length());
//        System.out.println("删除元素为：" + len);
//        list.printList();
//    }

//    public static void main(String[] args) {
//        List list = new SignalList();
//        int[] arr = {8, 0, 10, 2, 5};
//        for(int i = 0; i < arr.length; i++){
//            System.out.println("插入"+list.listInsert(list.length+1, arr[i]));
//        }
//        System.out.println("当前表长为：" + list.length());
//        list.printList();
//        Integer len = (Integer) list.listDelete(2);
//        System.out.println("当前表长为：" + list.length());
//        System.out.println("删除元素为：" + len);
//        list.printList();
//    }


    public static void main(String[] args) {
//        List list = new SignalList();
//        List list = new SignalListHead();
        List list = new SqList(6);
        int[] arr = Basic.getRandomArray(6, 0, 10);
        for(int i = 0; i < arr.length; i++){
            list.listInsert(1, arr[i]);
        }
        System.out.println("线性表初始化为：");
        list.printList();
        Scanner sc = new Scanner(System.in);
        int a = -1;
        while (a != 0){
            System.out.print("请输入你的选择（输入-1显示操作选项）: ");
            a = sc.nextInt();
            switch (a){
                case 0: break;
                case 1: {
                    System.out.print("请输入位置（从1开始）：");
                    int index = sc.nextInt();
                    System.out.print("请输入元素：");
                    int data = sc.nextInt();
                    System.out.println("操作（插入）" + (list.listInsert(index, data) ? "成功" : "失败"));
                }; break;
                case 2: {
                    System.out.print("请输入位置：");
                    int index = sc.nextInt();
                    System.out.println("操作（删除）" + (list.listDelete(index) != null ? "成功" : "失败"));
                }; break;
                case 3:{
                    list.printList();
                }; break;
                case 4:{
                    System.out.print("请输入位置：");
                    int index = sc.nextInt();
                    Object o = list.getElem(index);
                    System.out.println("操作（查找）" + (o != null ? "成功" : "失败"));
                    System.out.println("返回值为：" + (o != null ? (int) o : -1));
                }; break;
                case 5:{
                    System.out.print("请输入元素：");
                    int data = sc.nextInt();
                    int index = list.locateElem(data);
                    System.out.println("操作（查找）" + (index != -1 ? "成功" : "失败"));
                    System.out.println("返回值为：" + index);
                }; break;
                case -1:{
                    elect();
                }
            }
        }
        System.out.println(list.name() + "测试结束");
    }

    public static void elect(){
        System.out.println("1.在指定位置插入数据");
        System.out.println("2.删除指定位置的元素");
        System.out.println("3.展示表中的所有元素");
        System.out.println("4.获取某个位置的元素");
        System.out.println("5.获取元素在表中的位置");
        System.out.println("0.退出");
    }
}
