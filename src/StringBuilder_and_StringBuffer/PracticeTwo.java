package StringBuilder_and_StringBuffer;

public class PracticeTwo {
    public static void main(String[] args) {
        String str = "Hello";

        // String -> StringBuilder
        StringBuilder sb1 = new StringBuilder(str);
        sb1.append(" StringBuilder");
        System.out.println("String -> StringBuilder: " + sb1);

        // String -> StringBuffer
        StringBuffer sbf1 = new StringBuffer(str);
        sbf1.append(" StringBuffer");
        System.out.println("String -> StringBuffer: " + sbf1);

        // StringBuilder -> String
        StringBuilder sb2 = new StringBuilder("StringBuilder Text");
        String strFromSB = sb2.toString();
        System.out.println("StringBuilder -> String: " + strFromSB);

        // StringBuffer -> String
        StringBuffer sbf2 = new StringBuffer("StringBuffer Text");
        String strFromSBF = sbf2.toString();
        System.out.println("StringBuffer -> String: " + strFromSBF);

        // StringBuilder -> StringBuffer (через String)
        StringBuilder sb3 = new StringBuilder("Convert Me");
        StringBuffer sbf3 = new StringBuffer(sb3.toString());
        sbf3.append(" to StringBuffer");
        System.out.println("StringBuilder -> StringBuffer: " + sbf3);

        // StringBuffer -> StringBuilder (через String)
        StringBuffer sbf4 = new StringBuffer("Convert Me");
        StringBuilder sb4 = new StringBuilder(sbf4.toString());
        sb4.append(" to StringBuilder");
        System.out.println("StringBuffer -> StringBuilder: " + sb4);
    }
}