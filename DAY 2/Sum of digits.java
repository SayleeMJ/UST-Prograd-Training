public class DRoot {
  public static int digital_root(int a) {
    int res = 0;
    while (a > 0 || res > 9){
      if (a == 0){
        a = res;
        res = 0;
      }
      res = res + a % 10;
      a = a/10;
    }
    return res;
  }
}