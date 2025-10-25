class Solution {
    public int[] sortedSquares(int[] nums) {
        List<Integer> neg = new ArrayList<>();
        List<Integer> pos = new ArrayList<>();
        
        //Separate negative and Positive Numbers
        for(int num:nums){
            if(num<0){
                neg.add(num);
            }else{
                pos.add(num);
            }
        }
        //Now We got 2 List one is positive and other one is Negative
        //Now we have 3 Cases
        //Case 1 No Negative Elements
        if(neg.size()==0){
            for(int i = 0;i< pos.size();i++){
                pos.set(i, pos.get(i) * pos.get(i)); //Square
            }
            return pos.stream().mapToInt(Integer::intValue).toArray();    
            }

        //Case 2 No positive Elements
        if(pos.size()==0){
            for(int i=0;i<neg.size();i++){
                neg.set(i,neg.get(i)*neg.get(i));
            }
            Collections.reverse(neg); //Reverse the List
            return neg.stream().mapToInt(Integer :: intValue).toArray(); //Convert into Array
            }

        //Case 3 Both Positive and Negative Elements
        for(int i=0;i<neg.size();i++){
            neg.set(i,neg.get(i)*neg.get(i));
        }
        for(int i=0;i<pos.size();i++){
            pos.set(i,pos.get(i)*pos.get(i));
        }
        Collections.reverse(neg);//now both lists sorted ascending

        //Merge Step
        int i=0,j=0;

        List<Integer> result =new ArrayList<>();
        while(i<neg.size() && j<pos.size()){
            if(neg.get(i)<pos.get(j)){
                result.add(neg.get(i));
                i++;
            }else{
                result.add(pos.get(j));
                j++;
            }
        }

        //Add Remaining Elements
        while(j<pos.size()){
            result.add(pos.get(j));
            j++;
        }
        while(i<neg.size()){
            result.add(neg.get(i));
            i++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}