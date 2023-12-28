package DataStructureAndAlgorithms.SelfLearning.DataStructures.List.Stack;

import java.util.Arrays;

public class ApplicationStack {
    /**
      A generic method for reversing an array. 
    */
    public static <E> void reverse(E[] a) {
        Stack<E> buffer = new ArrayStack<>(a.length);
        for (int i=0; i < a.length; i++)
            buffer.push(a[i]);
        for (int i=0; i < a.length; i++)
            a[i] = buffer.pop( );
    }
    
    // Tester routine for reversing arrays 
    public static void reverseTest() {
        Integer[ ] a = {4, 8, 15, 16, 23, 42}; // autoboxing allows this
        String[ ] s = {"Jack", "Kate", "Hurley", "Jin", "Michael"}; 
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
        System.out.println("Reversing...");
        reverse(a);
        reverse(s);
        System.out.println("a = " + Arrays.toString(a));
        System.out.println("s = " + Arrays.toString(s));
    }

    /* 
     * Tests if delimiters in the given expression are properly matched. 
     */ 
    public static boolean isMatched(String expression) {
        final String opening = "({["; // opening delimiters
        final String closing = ")}]"; // respective closing delimiters
        Stack<Character> buffer = new LinkedStack<>( );
    
        for (char c : expression.toCharArray( )) {
            if (opening.indexOf(c) != -1) // this is a left delimiter
                buffer.push(c);
            else if (closing.indexOf(c) != -1) { // this is a right delimiter
            if (buffer.isEmpty( )) // nothing to match with
                return false;
            if (closing.indexOf(c) != opening.indexOf(buffer.pop( )))
                return false; // mismatched delimiter
            }
        }
        return buffer.isEmpty( ); // were all opening delimiters matched?
    }

    // Tester the isMatched() function
    public static void isMatchedTest() {
        String expression = "( )(( )){([( )])}";
        expression = "((( )(( )){([( )])}))";
        System.out.println(isMatched(expression));
    }

    /** Tests if every opening tag has a matching closing tag in HTML string. */
    public static boolean isHTMLMatched(String html) {
        Stack<String> buffer = new LinkedStack<>( );
        int j = html.indexOf('<'); // find first ’<’ character (if any)
        while (j != -1) { 
            int k = html.indexOf('>', j+1); // find next ’>’ character
            if (k == -1)
                return false; // invalid tag
            String tag = html.substring(j+1, k); // strip away < >
            if (!tag.startsWith("/")) // this is an opening tag
                buffer.push(tag);
            else { // this is a closing tag
                if (buffer.isEmpty( ))
                    return false; // no tag to match
                if (!tag.substring(1).equals(buffer.pop( )))
                    return false; // mismatched tag
                }
            j = html.indexOf('<', k+1); // find next ’<’ character (if any)
        }
        return buffer.isEmpty( ); // were all opening tags matched?
    }

    // Tester the isHTMLMatched()
    public static void isHTMLMatchedTest() {
        String codeHTML = "<body>" + 
        "<center>" +
        "<h1> The Little Boat </h1>" +
        "</center>" +
        "<p> The storm tossed the little" +
        "boat like a cheap sneaker in an" +
        "old washing machine. The three drunken fishermen were used to such treatment, of course, but " +
        "not the tree salesman, who even as" +
        "a stowaway now felt that he" +
        "had overpaid for the voyage. </p>" +
        "<ol>" +
        "<li> Will the salesman die? </li>" +
        "<li> What color is the boat? </li>" +
        "<li> And what about Naomi? </li>" +
        "</ol>" +
        "</body>";
        System.out.println(isHTMLMatched(codeHTML));
    }
}
