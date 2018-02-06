public class StatsDriver
{
    public static void p(int a) 
    {
	System.out.println(a);
    }
    public static void p(double a)
    {
	System.out.println(a);
    }
    public static void main(String [] args)
    {
        Stats Stater = new Stats();
	/*	p(Stater.mean(12, 15));
	p(Stater.mean(12.345, 131.45));
	p(Stater.max(14, 64));
	p(Stater.max(145.12312,145.123123));
	p(Stater.geoMean(123, 12312));
	p(Stater.geoMean(123.452, 1231.1231));
	p(Stater.max(134,1567,1234));
	p(Stater.max(123,123.4123,12312.12));
	p(Stater.geoMean(123, 156, 132));
	p(Stater.geoMean(121, 141.12, 100));*/
	p(Stater.gcdEW(15, 20));
	p(Stater.gcdEW(15, 25));
	p(Stater.gcdER(15, 20));
	p(Stater.gcdER(15, 25));
	p(Stater.gcd(15, 20));
	p(Stater.gcd(15, 25));
	//	p(Stater.gcd(15, 0));
	//	p(Stater.gcdER(15, 0));
	//	p(Stater.gcdEW(15, 0));
    }
}
