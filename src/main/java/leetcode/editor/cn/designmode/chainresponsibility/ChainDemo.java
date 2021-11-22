package leetcode.editor.cn.designmode.chainresponsibility;

import org.junit.jupiter.api.Test;

/**
 * @description：
 * @author：JBL
 * @date：2021/10/25 11:14 上午
 */
public class ChainDemo {
    @Test
    public void testResponsibility() {
        PreparationList preparationList = new PreparationList();
        preparationList.setWashFace(true);
        preparationList.setWashHair(false);
        preparationList.setHaveBreakfast(true);

        Study study = new Study();

        AbstractPrepareFilter haveBreakfastFilter = new HaveBreakfastFilter(null);
        AbstractPrepareFilter washFaceFilter = new WashFaceFilter(haveBreakfastFilter);
        AbstractPrepareFilter washHairFilter = new WashHairFilter(washFaceFilter);

        washHairFilter.doFilter(preparationList, study);
    }
}
