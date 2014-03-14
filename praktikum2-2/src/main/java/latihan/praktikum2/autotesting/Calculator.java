public class Calculator {
public Integer tambah(Integer x, Integer y){
if (x==null || y==null){
throw new IllegalArgumentException("Argument tidakboleh null");
}
return x + y;
}
public Integer kurang(Integer x, Integer y){
return x - y;
}
public Integer kali(Integer x, Integer y){
return x * y;
}
public Integer bagi(Integer x, Integer y){
return x / y;
}
}