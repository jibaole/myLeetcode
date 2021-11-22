package leetcode.editor.cn.designmode.chainresponsibility;

/**
 * @description：
 * @author：JBL
 * @date：2021/10/25 11:13 上午
 */
public class WashFaceFilter extends AbstractPrepareFilter{
    public WashFaceFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashFace()) {
            System.out.println("洗脸");
        }

    }
}
