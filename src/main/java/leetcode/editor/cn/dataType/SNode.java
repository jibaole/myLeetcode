package leetcode.editor.cn.dataType;

/**
 * @description：
 * @author：JBL
 * @date：2021/9/29 5:34 下午
 */
public class SNode {
    private String data;
    private SNode nextNode;

    public SNode() {
    }
    public SNode(String data) {
        this.data = data;
        this.nextNode = new SNode();
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public SNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(SNode nextSNode) {
        this.nextNode = nextSNode;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data='" + data + '\'' +
                ", nextNode=" + nextNode +
                '}';
    }
}
