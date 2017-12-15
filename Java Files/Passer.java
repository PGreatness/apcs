public class Passer{
    public static String foo(int b){
	b = b+5;
	return b + "woo";
    }
    public static String boo(String s){
	s = s+"yo";
	return s;
    }
    public static void main(String[] args){
	int a = 4;
	System.out.println(a);
        System.out.println(foo(a));
	System.out.println(a);
	//pass-by-value for ints (primitives)
	String d = "he";
	System.out.println(d);
	System.out.println(boo(d));
	System.out.println(d);
	//pass-by-value for Strings (objects)
    }
}
