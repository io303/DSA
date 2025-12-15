public class UniqueAndDuplicateCount {
    public static void main(String[] args) {
        int arr[]={1, 2, 2, 3, 4, 4, 4, 5};
        int hash[]=new int[101];
        for(int i=0;i<arr.length;i++){
            hash[arr[i]]++;

        }
        int dup=0;
        int uni=0;
        for(int i=0;i<hash.length;i++){
            if(hash[i]==1){
                uni++;
            }
            else if(hash[i]>1){
                dup+=hash[i]-1;
            }
        }
        System.out.println(uni);
        System.out.println(dup);
    }
}
