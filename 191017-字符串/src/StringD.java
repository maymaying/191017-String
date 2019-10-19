import java.util.*;

public class StringD {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        for (String cpdomain : cpdomains) {
            String[] a = cpdomain.split(" ");//用空格切开
            int n = Integer.valueOf(a[0]);
            String domain = a[1];

            String[] b = domain.split("\\.");//正则表达式
            for (int i = 0; i < b.length; i++) {
                String[] c = Arrays.copyOfRange(b, i, b.length);
                String subdomain = String.join(".", c);
                int oldCount = map.getOrDefault(subdomain, 0);
                map.put(subdomain, oldCount + n);
            }
        }
        List<String> ret = new ArrayList<>();
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            String domain = e.getKey();
            int n = e.getValue();
            String s = String.format("%d %s", n, domain);
            ret.add(s);
        }
        System.out.println(ret);
    }
}
