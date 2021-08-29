import java.util.ArrayList;
import java.util.List;

public class calc {
    public int add(String input){
        if(input.isEmpty()) {
            return 0;
        }
        String[] nums;
        String delimiter=",";
        nums=input.split(delimiter);
        return sum(nums);
    }
    private int sum(String[] nums) {
        int sum;
        sum = 0;
        for(String values:nums) {
            if(Integer.parseInt(values) <= 1000){
                sum += Integer.parseInt(values);
            }
        }
        return sum;
    }
}
