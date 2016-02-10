package Module10;


public class Encoder {

    public static String encodeMechanism (String fileName, int offset) {
        offset = offset % 26;
        StringBuilder alreadyEncoded = new StringBuilder();
        for (char n : fileName.toCharArray()) {
            if (Character.isLetter(n)) {
                if (Character.isUpperCase(n)) {
                    alreadyEncoded.append((char) ('A' + (n - 'A' + offset) % 26 ));
                } else {
                    alreadyEncoded.append((char) ('a' + (n - 'a' + offset) % 26 ));
                }
            } else {
                alreadyEncoded.append(n);
            }
        }
        return alreadyEncoded.toString();
    }
}
