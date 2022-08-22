public class Level1 {
    public static boolean SherlockValidString(String s) {
        String delChars = "";

        for (int k = -1; k < s.length(); k++) {
            StringBuilder expStr = new StringBuilder(s);

            if (k != -1 && delChars.contains(String.valueOf(expStr.charAt(k)))) {
                break;
            }

            if (k != -1) {
                expStr.deleteCharAt(k);
                delChars += expStr.charAt(k);
            }

            String string = expStr.toString();
            StringBuilder strBld = new StringBuilder();

            for (int i = 0; i < string.length(); i++) {
                if (strBld.indexOf(String.valueOf(string.charAt(i))) == -1) {
                    strBld.append(string.charAt(i));
                }
            }

            int[] ma = new int[strBld.length()];

            for (int i = 0; i < strBld.length(); i++) {
                for (int j = 0; j < string.length(); j++) {
                    if (strBld.charAt(i) == string.charAt(j)) {
                        ma[i]++;
                    }
                }
            }

            for (int i = 0; i < ma.length - 1; i++) {
                if (ma[i] != ma[i + 1]) break;

                if (i == ma.length - 2) {
                    return true;
                }
            }
        }

        return false;
    }
}
