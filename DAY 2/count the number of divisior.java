public class FindDivisor {

  public long numberOfDivisors(int n) {
      long c = 0;
      for(int i=1; i<=n; i++){
          if(n % i == 0){
          c++;
          }
      }
      return c;
  }
}