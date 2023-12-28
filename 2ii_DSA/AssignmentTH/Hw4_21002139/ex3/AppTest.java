package DataStructureAndAlgorithms.AssignmentTH.Hw4_21002139.ex3;

public class AppTest {
    public static void main(String[] args) throws Exception {
        String expression;
        expression = "(1 + ((2 + 3) * (4 * 5)))"; // 101
        expression = "(50 - ((8 - 4) * (2 + 3))) + (3 * 4)"; //42
        BracketMatching.bracketMatching(expression);
    }
}
