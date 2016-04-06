public class AboutStrings {
    // PLEASE READ THROUGH SECTION 10.10 on the String Class!
    public static void main(String[] args) {
        // STRINGS ARE IMMUTABLE
        
        // note that s and t point to the same hello! this is
        // interning
        String s = "hello";
        String t = "hello";
        
        // but using the constructor, I get an entirely different
        // object!
        String u = new String("hello");
        
        // if I assign and increment, I get a new object as well
        // (the original is not modified, strings are immutable)
        s = s + " there";
        
        // compareTo returns an integer based on lexicographic
        // ordering of the first differing characters between 
        // two strings:
        // "hello".compareTo("heart") -> positive int
        // "heart".compareTo("hello") -> negative int
        int result = s.compareTo("heart");
        System.out.println(result);
        
        // split breaks up a string into an Array based on
        // the string delimiter passed in:
        String[] parts = "foo,bar,baz".split(",");
        System.out.println(parts[0]);
        
        // STRING BUILDERS *ARE* MUTABLE
        // (they're better than concatenation, because adding
        // continually creates new String objects!)
        StringBuilder sb = new StringBuilder("The variable, parts, contains ");
        sb.append(parts[0]);
        sb.append(" and ");
        sb.append(parts[1]);
        
        // see the output window...
        System.out.println(sb);
    }
}