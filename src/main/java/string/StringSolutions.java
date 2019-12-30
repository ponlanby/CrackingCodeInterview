package string;

/**
 * @author tongruochen
 * @since 2019/12/31
 */
public class StringSolutions {
    public static void main(String[] args) {
        String iniString = "welcometonowcoderrrrr";

        String stringA = "bwdyorsngiayocsksyybigrvqxtvhmfyyhmbhhlcenxalcpodllikancwwqbdfrfpcjftfknrekmvdkugdljtlrjcwlwwmswucgebmmsovdezsqtuohnnjjeqyhsnyumngxlgulsiclfrtzzynawgraqctkhrjluykmfujhrwgcgybhaulhmskstwjvgfmofxeuflkkqajialclnlzggccqwdgpkiiobpzgnipliekufylogjrarvxdwslnkwczfltveebzcrjcttxpizhsweeogsixegkwhfwtmtngqjhgkwduahgyyjxihuyxlsksfzpzikdnqvsgyzisnmqgdymkglbtuhjpxhbeybiewrvbdabprqzpvsvdejahfqsnvoijyypmmhpcpbjsukftobgnzxbdltfdfwjk";
        String stringB = "yypmmhpcpbjsukftobgnzxbdltfdfwjDbwdyorsngiayocsksyybigrvqxtvhmfyyhmbhhlcenxalcpodllikancwwqbdfrfpcjftfknrekmvdkugdljtlrjcwlwwmswucgebmmsovdezsqtuohnnjjeqyhsnyumngxlgulsiclfrtzzynawgraqctkhrjluykmfujhrwgcgybhaulhmskstwjvgfmofxeuflkkqajialclnlzggccqwdgpkiiobpzgnipliekufylogjrarvxdwslnkwczfltveebzcrjcttxpizhsweeogsixegkwhfwtmtngqjhgkwduahgyyjxihuyxlsksfzpzikdnqvsgyzisnmqgdymkglbtuhjpxhbeybiewrvbdabprqzpvsvdejahfqsnvoij";

        int[][] mat = {{1,2,3},{0,1,2},{0,0,1}};

        System.out.println(checkReverseEqual(stringA, stringB));
//        printMat(clearZero(mat, 3));
    }

    public static boolean checkDifferent(String iniString) {
        boolean[] charset = new boolean[256];
        for (int i=0; i<iniString.length(); i++) {
            int val = iniString.charAt(i);
            if (charset[val]) {
                return false;
            }
            charset[val]=true;
        }
        return true;

    }

    public static String reverseString(String iniString) {
        // write code here
        char[] strArr = iniString.toCharArray();
        for (int i=0, j=strArr.length-1; i<j; i++,j--) {
            char tmp = strArr[j];
            strArr[j] = strArr[i];
            strArr[i] = tmp;
        }
        return String.valueOf(strArr);
    }

    public static boolean checkSam(String stringA, String stringB) {
        // write code here
        if (stringA.length() != stringB.length()) {
            return false;
        }
        int[] arrA = new int[65536];
        int[] arrB = new int[65536];
        for (int i=0; i<stringA.length(); i++) {
            arrA[stringA.charAt(i)]++;
            arrB[stringB.charAt(i)]++;
        }
        for (int i=0; i<arrA.length; i++) {
            if (arrA[i] != arrB[i]) {
                return false;
            }
        }
        return true;
    }

    public static String replaceSpace(String iniString, int length) {
        // write code here
        iniString = iniString.replace(" ", "%20");
        return iniString;
    }

    public static String zipString(String iniString) {
        // write code here
        StringBuffer sb = new StringBuffer();
        int count = 1;
        char pivot = iniString.charAt(0);
        for (int i=1; i<iniString.length(); i++) {
            if (pivot == iniString.charAt(i)) {
                count++;
            } else {
                sb.append(pivot);
                sb.append(count);
                pivot = iniString.charAt(i);
                count = 1;
            }
        }
        sb.append(pivot);
        sb.append(count);
        if (sb.length() >= iniString.length()) {
            return iniString;
        } else {
            return sb.toString();
        }
    }

    public static int[][] transformImage(int[][] mat, int n) {
        // write code here
        /**
         * 先上下翻转
         */
        for (int i=0; i<n/2; i++) {
            for (int j=0; j<n; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[n-1-i][j];
                mat[n-1-i][j] = temp;
            }
        }
        /**
         * 再沿主对角线翻转
         */
        for (int i=0; i<n; i++) {
            for (int j=0; j<i; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        return mat;
    }

    public static int[][] clearZero(int[][] mat, int n) {
        // write code here
        boolean[] rowArr = new boolean[n];
        boolean[] colArr = new boolean[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    rowArr[i] = true;
                    colArr[j] = true;
                }
            }
        }
        for (int i=0; i<n; i++) {
            for (int j = 0; j < n; j++) {
                if (rowArr[i] || colArr[j]) {
                    mat[i][j] = 0;
                }
            }
        }
        return mat;
    }

    public static boolean checkReverseEqual(String s1, String s2) {
        // write code here
        if (s1.length()==0 || s2.length()==0 || s1.length() != s2.length()) {
            return false;
        }
        String rotateStr = s1 + s1;
        if (rotateStr.contains(s2)) {
            return true;
        }
        return false;
    }

    private static void printMat(int[][] mat) {
        for (int[] line : mat) {
            for (int elem : line) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

}
