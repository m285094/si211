// Sam Pirkl

public class EncryptorHelp {
    
    private static int low = 42, high = 122;
    private static int range = high - low + 1;
    public static void validateInput(char[] str) throws IllegalCharException {
        for(char c : str) {
            if((int)c < low || (int)c > high)
                throw new IllegalCharException("Error! Invalid symbol '" + c + "' in password.");
        }
    }

    public static char encryptChar(char currentChar, int k) {
        int p = (int)currentChar - low;
        int c = (p + k) % range;

        return (char)(low + c);
    }

    public static char decryptChar(char currentChar, int k) {
        return encryptChar(currentChar, range - k);
    }
}