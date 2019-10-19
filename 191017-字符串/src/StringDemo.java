public class StringDemo {
    public static void main(String[] args) {
        char[] value={'h','e','l','l','o'};
        String s=new String(value);
        System.out.println(s);//hello

        String t=new String(value,1,2);
        System.out.println(t);//el

        value[0]='a';
        System.out.println(s);//hello
        
        //s.charAt(0);
        //char[] a=s.toCharArray();
    }
}
