package frexie;

public class Validator {

    public static boolean isEmpty(String str) {
        if (str.equals("")) {
            return true;
        }

        return false;
    }

    public static boolean hasNoSpaces(String str) {
        int len = str.length();

        if (len == 0) {
            return true;
        }
        for (int i = 1; i < len; i++) {
            if (Character.isSpaceChar(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isEmail(String str) {
        int atCount = 0, periodCount = 0;
        boolean domainValid = false;
        if (!hasNoSpaces(str)) {
            return false;
        }
        if (str.length() == 0) {
            return true;
        }
        for (int x = 0; x < str.length(); x++) {
            if (str.charAt(x) == '@') {
                atCount++;
            }
            if (atCount > 1) {
                return false;
            }
        }
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '@') {
                if (i == 0) {
                    return false;
                }
               
                if (i < (str.length() - 3)) {
                    if (str.charAt(i + 1) != '.') {
                        domainValid = true;
                    }
                    for (int j = i; j < (str.length() - 3); j++) {
                        if (str.charAt(j + 2) == '.' && str.charAt(j + 3) == '.') {
                            return false;
                        }
                    }
                }
            }
            if (str.charAt(i) == '.') {
                if (i == (str.length() - 1) || i == 0) {
                    return false;
                }
                periodCount++;
            }
        }
        if (atCount == 1 && periodCount >= 1 && domainValid) {
            return true;
        } else {
            return false;
        }
    }

    
    
    
    
}
