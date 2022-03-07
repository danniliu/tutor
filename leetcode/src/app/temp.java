package app;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.*;

public class Temp {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
           List<Integer> ds=new ArrayList<>();
           boolean used[]=new boolean[nums.length];
           backTrack(ans,ds,used,nums);
           return ans;
       }
       public void backTrack(List<List<Integer>> ans,List<Integer> ds,boolean[] used,int[] nums)
       {
           if(ds.size()==nums.length)
           {ans.add(new ArrayList<>(ds));return;}
           for(int i=0;i<nums.length;i++)
           {
               if(used[i]==false)
               {
                   ds.add(nums[i]);
                   used[i]=true;
                   backTrack(ans,ds,used,nums);
                   ds.remove(ds.size()-1);
                   used[i]=false;
               }
           }
       }
}






