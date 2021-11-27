public class Solution{
  public static long sumCubes(long n)
  {
    long sum=0;
    for(long i=1;i<=n;i++){
      sum+=(long)i*i*i;
    }
    return sum;
  }
}