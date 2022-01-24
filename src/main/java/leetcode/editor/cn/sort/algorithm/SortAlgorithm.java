package leetcode.editor.cn.sort.algorithm;

import java.util.Arrays;

/**
 * @description：排序算法 https://zhuanlan.zhihu.com/p/335048580
 * @author：JBL
 * @date：2021/11/14 10:06 下午
 */
public class SortAlgorithm {

    public static void main(String[] args) {
       int[] array = {4, 7, 1, 19, 12, 44, 67};
        bubbleSort(array);
        /* fib(10);*/

       // System.out.println(fib(10));
    }


    /**
     * 冒泡排序
     * 基本思想：持续比较相邻的元素。如果第一个比第二个大，就交换他们两个。直到没有任何一对数字需要比较。
     * 冒泡排序最好的时间复杂度为O(n)。冒泡排序的最坏时间复杂度为O(n^2)。因此冒泡排序总的平均时间复杂度为O(n^2)。
     * 算法适用于少量数据的排序，是稳定的排序方法。
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int length = array.length - 1;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                // 每一轮都找到一个最大的数放在右边
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }

    /**
     * 选择排序
     * 基本思想：每一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，直到全部待排序的数据元素排完。
     * 选择排序是不稳定的排序方法。时间复杂度 O(n^2)。
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minindex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) {  //选择当前最小的数
                    min = array[j];
                    minindex = j;
                }
            }
            if (i != minindex) { //若i不是当前元素最小的，则和找到的那个元素交换
                array[minindex] = array[i];
                array[i] = min;
            }
        }
    }


    /**
     * 插入排序
     * 基本思想：每步将一个待排序的纪录，按其关键码值的大小插入前面已经排序的文件中适当位置上，直到全部插入完为止。
     * 算法适用于少量数据的排序，时间复杂度为O(n^2)。是稳定的排序方法。
     *
     * @param array
     */
    public static void insertionSort(int[] array) {
        int tmp;
        for (int i = 1; i < array.length; i++) {
            tmp = array[i];  //将当前位置的数给tmp
            int j = i;
            // array[j-1]>tmp:大于号是升序排列，小于号是降序排列
            for (; j > 0 && array[j - 1] > tmp; j--) {
                // 往右移，腾出左边的位置
                array[j] = array[j - 1];
            }
            //将当前位置的数插入到合适的位置
            array[j] = tmp;
        }
    }


    /**
     * 希尔排序
     * 基本思想：先取一个小于n的整数d1作为第一个增量，把文件的全部记录分组。所有距离为d1的倍数的记录放在同一个组中。先在各组内进行直接插入排序；然后，取第二个增量d2<d1重复上述的分组和排序，直至所取的增量dt=1(dt<dt-1…<d2<d1)，即所有记录放在同一组中进行直接插入排序为止。
     * 在使用增量dk的一趟排序之后，对于每一个i，我们都有a[i]<=a[i+dk],即所有相隔dk的元素都被排序。
     * 如图：增量序列为5，3，1，每一趟排序之后，相隔对应增量的元素都被排序了。当增量为1时，数组元素全部被排序。
     * 希尔排序不稳定，时间复杂度 平均时间 O(nlogn) 最差时间O(n^2)
     *
     * @param array
     */
    public static void shellSort(int[] array) {
        int j;
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            //定义一个增长序列，即分割数组的增量,d1=N/2   dk=(d(k-1))/2
            for (int i = gap; i < array.length; i++) {
                int tmp = array[i];
                for (j = i; j >= gap && tmp < array[j - gap]; j -= gap) {
                    //将相距为Dk的元素进行排序
                    array[j] = array[j - gap];
                }
                array[j] = tmp;
            }
        }
    }

    /**
     * 堆排序
     * 预备知识:
     * 二叉堆是完全二元树（二叉树）或者是近似完全二元树（二叉树）。
     * 二叉堆有两种：最大堆和最小堆。
     *    大根堆：父结点的键值总是大于或等于任何一个子节点的键值；
     *    小根堆：父结点的键值总是小于或等于任何一个子节点的键值。
     *    二叉堆一般用数组来表示。例如，根节点在数组中的位置是0，第n个位置的子节点分别在2n+1和 2n+2。
     * 因此，第0个位置的子节点在1和2，1的子节点在3和4。以此类推。这种存储方式便於寻找父节点和子节点。
     * 例如初始要排序的数组为：49, 38, 65, 97, 76, 13, 27, 49 构造成大根堆之后的数组为：97 76 65 49 49 13 27 38 实际树形结构如图（最大堆）：
     */

    /**
     * 堆排序
     * 调整最大堆，交换根元素和最后一个元素。
     * 参数说明：
     * a -- 待排序的数组
     */
    public static void heapSort(int[] a) {
        int n = a.length;
        int i, tmp;
        // 从(n/2-1) --> 0逐次遍历。遍历之后，得到的数组实际上是一个(最大)二叉堆。
        for (i = n / 2 - 1; i >= 0; i--)
            maxHeapDown(a, i, n - 1);
        // 从最后一个元素开始对序列进行调整，不断的缩小调整的范围直到第一个元素
        for (i = n - 1; i > 0; i--) {
            // 交换a[0]和a[i]。交换后，a[i]是a[0...i]中最大的。
            tmp = a[0];
            a[0] = a[i];
            a[i] = tmp;
            // 调整a[0...i-1]，使得a[0...i-1]仍然是一个最大堆。
            // 即，保证a[i-1]是a[0...i-1]中的最大值。
            maxHeapDown(a, 0, i - 1);
        }
    }

    /*
     * 注：数组实现的堆中，第N个节点的左孩子的索引值是(2N+1)，右孩子的索引是(2N+2)。
     *     其中，N为数组下标索引值，如数组中第1个数对应的N为0。
     *
     * 参数说明：
     *     a -- 待排序的数组
     *     start -- 被下调节点的起始位置(一般为0，表示从第1个开始)
     *     end   -- 截至范围(一般为数组中最后一个元素的索引)
     */
    public static void maxHeapDown(int[] a, int start, int end) {
        int c = start;            // 当前(current)节点的位置
        int l = 2 * c + 1;        // 左(left)孩子的位置
        int tmp = a[c];            // 当前(current)节点的大小
        for (; l <= end; c = l, l = 2 * l + 1) {
            // "l"是左孩子，"l+1"是右孩子
            if (l < end && a[l] < a[l + 1])
                l++;        // 左右两孩子中选择较大者，即m_heap[l+1]
            if (tmp >= a[l])
                break;        // 调整结束
            else {            // 交换值
                a[c] = a[l];
                a[l] = tmp;
            }
        }
    }


    private  static int cache[];

    public static int fib(int n) {
        cache = new int[n + 1];
        return Myfib(n);
    }

    private static int Myfib(int n) {
        if (n < 2) return n;
        if (cache[n] == 0) {
            cache[n] = Myfib(n - 1) + Myfib(n - 2);
        }
        return cache[n]%1000000007;
    }
}
