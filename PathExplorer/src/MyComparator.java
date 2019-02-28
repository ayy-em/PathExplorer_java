public class MyComparator implements java.util.Comparator<String> {
    
    private int referenceLength;
    
    public MyComparator() {
        super();
    }
    
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
}