package leetcode.editor.cn.dataType;

import java.util.Map;

/**
 * @description：
 * @author：JBL
 * @date：2021/9/29 5:34 下午
 */
public interface ICommOperate<T> {

    public boolean insertNode(T node);

    public boolean insertPosNode(int pos, T node);

    public boolean deleteNode(int pos);

    public boolean updateNode(int pos, Map<String, Object> map);

    public T getNode(int pos, Map<String, Object> map);

    public void printLink();
}
