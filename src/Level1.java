public class Level1 {
    public static boolean SherlockValidString(String s) {
        StringBuilder delChar = new StringBuilder();

        for (int k = -1; k < s.length(); k++) {
            StringBuilder expStr = new StringBuilder(s);

            if (k != -1 && delChar.indexOf(String.valueOf(expStr.charAt(k))) != -1) {
                continue;
            }

            if (k != -1) {
                delChar.append(expStr.charAt(k));
                expStr.deleteCharAt(k);
            }

            String string = expStr.toString();
            StringBuilder strBld = new StringBuilder();

            for (int i = 0; i < string.length(); i++) {
                String tmp = String.valueOf(string.charAt(i));

                if (strBld.indexOf(tmp) == -1) {
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