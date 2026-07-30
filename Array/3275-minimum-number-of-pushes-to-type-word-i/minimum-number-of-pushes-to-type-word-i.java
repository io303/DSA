class Solution {
    public int minimumPushes(String word) {
        int n=word.length();
        int c=0;
        System.out.println(n);
        for(int i=0;i<n;i++){
            if(i<=7){
                c=c+1;
            }else  if(i>7&&i<=15){
                c=c+2;
            }else if(i>15&&i<=23){
                c=c+3;
            }else{
                c=c+4;
            }
        }
        return  c;
    }
}