import java.util.ArrayList;
import java.util.List;

public class calc {
    public int add(String input){
        if(input.isEmpty()) {
            return 0;
        }
        String[] nums;
        String delimiter;
        String tmp2=input;
        if(input.startsWith("//")) {
            if(isMultiDelimiterCheck(input)) {
                delimiter = Character.toString(input.charAt(2));
                tmp2 = input.substring(4);
            } else {
                List<Integer> lst = new ArrayList<>();
                int begin = input.indexOf('[');
                while (begin >= 0) {
                    lst.add(begin);
                    begin = input.indexOf('[',begin + 1);
                }

                List<Integer> lst2 = new ArrayList<>();
                int end=input.indexOf(']');
                while(end>=0){
                    lst2.add(end);
                    end=input.indexOf(']',end+1);
                }

                int last = lst2.get(lst.size() - 1);

                StringBuilder s = new StringBuilder();
                int n = lst.size();
                for(int i=0; i<n; i++) {
                    int right = lst.get(i);
                    int left = lst2.get(i);
                    String temp = input.substring(right+1, left);
                    if(temp.charAt(0) == '$' || temp.charAt(0) == '.' || temp.charAt(0) == '+' || temp.charAt(0) == '?' || temp.charAt(0) == '^' || temp.charAt(0) == '*') {
                        int tempSize = temp.length();
                        StringBuilder tempStr = new StringBuilder();
                        for(int j=0; j<tempSize; j++) {
                            tempStr.append("\\").append(temp.charAt(j));
                        }
                        s.append(tempStr);
                    } else {
                        s.append(temp);
                    }

                    if(i < n-1) {
                        s.append("|");
                    }
                }
                delimiter = s.toString();
                tmp2 = input.substring(last + 2);
            }
        }
        else {
            delimiter = ("[,\n]");
        }
        nums=tmp2.split(delimiter);
        return sum(nums);
    }
    private Boolean isMultiDelimiterCheck(String input) {
        return input.charAt(2) != '[';
    }

    private int sum(String[] nums) {
        int sum;
        sum = 0;
        for(String values:nums) {

                sum += Integer.parseInt(values);

        }
        return sum;
    }
}
