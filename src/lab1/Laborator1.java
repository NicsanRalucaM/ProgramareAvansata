package lab1;

public class Laborator1 {
    public static void main(String[] args) {
        System.out.println("Hello world! ");
        //define an array of strings languages
        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        //generate a random integer n
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);

        n = n * 3;//multiply n by 3;
        int n1 = Integer.parseInt("10101", 2);//transform binary number 10101 to Integer
        int n2 = Integer.parseInt("FF", 16); //transform hexadecimal number FF to Integer
        System.out.println(n1);
        System.out.println(n2);
        n += n1;
        n += n2;
        n *= 6;
        System.out.println(n);

        //compute the sum of the digits
        int sum = 0;
        do {
            while (n != 0) {
                sum += n % 10;
                n = n / 10;
            }
            n = sum;
            System.out.println(sum);
            sum = 0;
        } while (n > 9);
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}

