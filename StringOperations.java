public class StringOperations {
    public static void main(String[] args) {
        String name = new String("Andy Zong");
        System.out.println(name);
        name = name.replace('A', 'A').replace('g', 'Z');
        System.out.println(name);
        String web_ad = new String("www.stanford.edu");
        System.out.println(web_ad);
        web_ad = web_ad.substring(4, web_ad.length()-4) +"1331";
        System.out.println(web_ad);
    }
}
