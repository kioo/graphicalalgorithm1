package binarySearch;

/**
 * 二分查找法
 */
public class BinarySearch {

    private static Integer binarySearch(int[] list, int item){
        int low = 0; // 声明数组起始位的下标号，初始值为 0
        int high = list.length - 1; // 声明数组终点位下标号，初始值为数组总长度减 1

        // 设置当最起始位小于最高位的时候执行代码块中的语句
        while( low <= high ){
            int mid = ( low + high) / 2; // 根据起始位和终点位找出中间位的下标号
            int guess = list[mid]; // 找出中间位的数字
            if(guess == item){ // 如果和查找的数字相等，则返回数字的下标
                return mid;
            }
            if(guess > item){ // 如果中间的数字大于查找的数字
                high = mid - 1; // 将终点位设置中间数字位减 1
            }else{          // 中间数字小于查找的数字
                low = mid + 1; // 将起始位设置为中间位加 1
            }
        }
        return null;
    }

    public static void main(String[] args){
        int[] myList = {1,3,5,7,9};
        System.out.println(binarySearch(myList, 3));
        System.out.println(binarySearch(myList, -1));

    }
}
