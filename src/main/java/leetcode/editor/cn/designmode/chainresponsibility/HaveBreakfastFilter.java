package leetcode.editor.cn.designmode.chainresponsibility;

/**
 * @description：
 * @author：JBL
 * @date：2021/10/25 11:14 上午
 */
public class HaveBreakfastFilter extends  AbstractPrepareFilter{
    public HaveBreakfastFilter(AbstractPrepareFilter nextPrepareFilter) {
        super(nextPrepareFilter);
    }

    @Override
    public void prepare(PreparationList preparationList) {
        if (preparationList.isHaveBreakfast()) {
            System.out.println("吃早餐");
        }

    }

}
