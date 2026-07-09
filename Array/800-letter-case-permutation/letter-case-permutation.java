class Solution {
    List<String> ans=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
        help(s.toCharArray(),0);
        return ans;
    }

    void help(char arr[],int i){
        if(i==arr.length){
            ans.add(new String(arr));
            return;

        }
        char ch=arr[i];
        if(Character.isDigit(ch)){
            help(arr,i+1);
        }else{
            arr[i]=Character.toLowerCase(ch);
            help(arr,i+1);
            arr[i]=Character.toUpperCase(ch);
            help(arr,i+1);
        }
    }
}