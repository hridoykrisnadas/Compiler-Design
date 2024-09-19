public class Derivation {
    public static void main(String[] args) {
        leftMostDerivation();
        rightMostDerivation();
    }

    private static void rightMostDerivation() {
        System.out.println("Right Most Derivation:\\n---------------------");
        int step = 1;
        String derivation = "S";

        //S -> aAB
        derivation = derivation.replace("S", "aAB");
        System.out.println("Step "+step++ +": "+derivation);

        // B -> c
        derivation = derivation.replace("B", "c");
        System.out.println("Step "+step++ +": "+derivation);

        //A -> b (leftmost non-terminal)
        derivation = derivation.replace("A", "b");
        System.out.println("Step "+step++ +": "+derivation);

        System.out.println();
    }

    private static void leftMostDerivation() {
        System.out.println("Left Most Derivation:\\n---------------------");
        int step = 1;
        String derivation = "S";

        //S -> aAB
        derivation = derivation.replace("S", "aAB");
        System.out.println("Step "+step++ +": "+derivation);

        //A -> b (leftmost non-terminal)
        derivation = derivation.replace("A", "b");
        System.out.println("Step "+step++ +": "+derivation);

        // B -> c
        derivation = derivation.replace("B", "c");
        System.out.println("Step "+step++ +": "+derivation);

        System.out.println();

    }
}