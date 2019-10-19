import java.util.Arrays;

public final class MyString {
    private final char[] value;

    public MyString(char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public MyString(char[] value, int offset, int count) {
        this.value = Arrays.copyOfRange(value, offset, offset + count);
    }

    public char charAt(int index) {
        return value[index];
    }

    public char[] toCharArray() {
        return Arrays.copyOf(value, value.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyString)) return false;
        MyString myString = (MyString) o;
        return Arrays.equals(value, myString.value);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(value);
    }

    public MyString toUpperCase() {
        char[] value = toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (Character.isLowerCase(value[i])) {
                value[i] = Character.toUpperCase(value[i]);
            }
        }
        return new MyString(value);
    }

    public boolean equalsIgnoreCase(MyString o) {//忽略大小写
        if (o == null) {
            return false;
        }
        if (value.length != o.value.length) {//如果长度不相等，则一定不相等
            return false;
        }
        for (int i = 0; i < value.length; i++) {
            char c = Character.toUpperCase(value[i]);
            char d = Character.toUpperCase(o.value[i]);
            if (c != d) {
                return false;
            }
        }
        return true;
    }

    // String s = "hello";
    // String t = "world";
    // String o = s + t;    s.concat(t);
    public MyString concat(MyString o) {
        char[] v = new char[value.length + o.value.length];
        System.arraycopy(value, 0, v, 0, value.length);
        System.arraycopy(o.value, 0, v, value.length, o.value.length);
        return new MyString(v);
    }
}
