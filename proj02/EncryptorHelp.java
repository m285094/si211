// Sam Pirkl

public class EncryptorHelp {
    
    public static void validateInput(char[] str) throws IllegalCharException {
        for(char c : str) {
            if((int)c < 42 || (int)c > 122)
                throw new IllegalCharException("error " + c + " not allowed in key");
        }
    }

    public static char encryptChar(char currentChar, int k) {
        int p = (int)currentChar - 42;
        int c = (p + k) % 81;

        return (char)(42 + c);
    }

    public static char decryptChar(char currentChar, int k) {
        int c = (int)currentChar - 42;
        int p = (c + (81 - k)) % 81;

        return (char)(42 + p);
    }
}