public class FindMinMax {
    class Pair{
        int min;
        int max;

    Pair(int min , int max){
        this.min=min;
        this.max=max;
    }
    }

Pair FindMinMax(int a[],int s,int e){
    if(s==e){
    return new Pair(a[s],a[s]);
    }
    if(s+1==e){//2wotaelement
    
        if (a[s]>a[e]){
            return new Pair(a[e],a[s]);

        }
        else{
            return new Pair( a[s],a[e]);
        }
    }
    int mid =(s+e)/2;
    Pair leftpair=FindMinMax(a,s,mid);//left half
      Pair rightpair=FindMinMax(a,mid+1,e);//right half
    
      int overallmin=Math.min(leftpair.min, rightpair.min);
      int overallmax=Math.max(leftpair.max,rightpair.max);
      return new Pair(overallmin, overallmax);
}
}