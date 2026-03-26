// Sam Pirkl

public class ShiftVigenere extends ShiftHasher {

    // private Encryptor enc;
    public ShiftVigenere() {
        enc = new Vigenere();
    }

    public String getAlgName() { return "shift+vigenere"; }

    // public void   init(char[] pswd) throws IllegalCharException {

    //     // for(int i = 0; i < pswd.length; i++) {

    //     //     if((int)pswd[i] < 42 || (int)pswd[i] > 122)
    //     //         throw new IllegalCharException("error " + pswd[i] + " not allowed in password");
    //     // }

    //     enc.init(pswd);
    // }

    // public String readPassword(char[] pswd) { return new String(pswd); }

    // public String computeHash(char[] pswd) throws IllegalCharException {

    //     String hash = "GO_NAVY_2018^mid";
    //     for(int i = 0; i < hash.length(); i++) {
    //         char c = hash.charAt(i);
    //         int k = (int)c % 16;

    //         hash = hash.substring(k) + hash.substring(0, k);
    //         hash = enc.encrypt(hash);
    //     }

    //     return hash;
    // }
}