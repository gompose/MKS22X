public class Recursion {
 static double _guess = 5;
 static double accuracy = 0.00000001;
 public static String name(){
  return "Mei, Peter";
 }
 public static double sqrt(double n){
   _guess = helper(n, _guess);
   if (_guess * _guess >= n + accuracy || _guess * _guess <= n - accuracy){
     sqrt(n);
   } else{
     return _guess;
   }
    return _guess;
 }
 
 public static double helper(double n, double guess) {
   double better = n / guess;
   better = better + guess;
   better = better / 2;
   return better;
 }
}
