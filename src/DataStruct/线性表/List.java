package DataStruct.线性表;

/**
 * Author: hanzy
 * Date: 2021/9/30, 9:46
 * introduce:
 *  一种数据结构的基本操作是指其最核心，最基本的操作，其它比较复杂的操作可以通过调用其基本操作来实现。
 *  而此接口中则包含线性表对应的数据结构应该有的基本操作。
 *
 *  需要注意的是：
 *      1. 查找元素在表中的位置，所有的实现方法都只找到了它在表中的第一个位置；
 */
public abstract class List<Item> {

    protected int length;
    protected String name;

    /**
     * 获取表的长度
     * @return
     */
    public int length(){
        return 0;
    }

    public String name(){
        return null;
    }

    /**
     * 获取某个元素在表中的位置
     * @param item
     * @return
     */
    public int locateElem(Item item){
        return -1;
    }

    /**
     * 获取表中某个位置的元素
     * @param i
     * @return
     */
    public Item getElem(int i){
        return null;
    }

    /**
     * 输出表中的元素
     */
    public void printList(){
        return ;
    }

    /**
     * 判断表是否为空
     * @return
     */
    public boolean empty(){
        return false;
    }

    /**
     * 往表中指定位置插入一个元素
     * @param i
     * @param e
     * @return
     */
    public boolean listInsert(int i, Item e){
        return false;
    }

    /**
     * 删除表中指定位置的元素，并将其值返回，若没有找到，返回null
     * @param i
     * @return
     */
    public Item listDelete(int i){
        return null;
    }

}
