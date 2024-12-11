package tests.browser;

public class methodEx {
    public static void main(String[] args) {
        System.out.println(sum(2,5));
        sum2(6,6);
        System.out.println(array("mohammad"));
        array2("mohammad");
    }
    public static int sum(int firstN,int secondN){
        return firstN+secondN;
    }
    public static void sum2(int firstN,int secondN){
        System.out.println(firstN+secondN);
    }
    public static char[] array(String str){
        return str.toCharArray();
    }
    public static void array2(String str){
        char[] strCharArray =str.toCharArray();
        for (char charecters:strCharArray){
        System.out.println(charecters);}

    }

}
