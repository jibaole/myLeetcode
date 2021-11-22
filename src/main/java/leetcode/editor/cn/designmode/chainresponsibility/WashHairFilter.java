package leetcode.editor.cn.designmode.chainresponsibility;

/**
 * @description：
 * @author：JBL
 * @date：2021/10/25 11:13 上午
 */
public class WashHairFilter extends  AbstractPrepareFilter {
    public WashHairFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isWashHair()) {
            System.out.println("洗头");
        }

    }
}
