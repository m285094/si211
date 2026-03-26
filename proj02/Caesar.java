// Sam Pirkl

public class Caesar implements Encryptor {

    private int sc;
    public Caesar() {
        this.sc = 18;
    }

    public String getAlgName() { return "caesar"; }

    public void   init(char[] key) throws IllegalCharException { 

        EncryptorHelp.validateInput(key);
        // // calculate the shift for caesar cipher
        // for(int i = 0; i < key.length; i++) {

        //     // throw exception if there's a dollar sign in key
        //     if(key[i] == '$')
        //         throw new IllegalCharException("error $ not allowed in key");

        //     // throw exception if char in key is outside allowed ascii range
        //     if((int)key[i] < 42 || (int)key[i] > 122)
        //         throw new IllegalCharException("error characters in key must be within ASCII range 42-122");
        for(char c : key) 
            sc += (int)c - 42;
        sc = 42 + (sc % 81);
    }

    public String encrypt(String plain) throws IllegalCharException { 
        
        char[] cipher = plain.toCharArray(); // convert string to array
        // for(int i = 0; i < cipher.length; i++) {

        //     // throw exception if therea's a dollar sign in plaintext
        //     if(cipher[i] == '$')
        //         throw new IllegalCharException("error $ not allowed in plaintext");

        //     // throw exception if char in plaintext is outside allowed ascii range
        //     if((int)cipher[i] < 42 || (int)cipher[i] > 122)
        //         throw new IllegalCharException("error characters in plaintext must be within ASCII range 42-122");

        //     // get encrypted char
        //     int k = sc - 42;
        //     int p = (int)cipher[i] - 42;
        //     int c = (p + k) % 81;

        //     cipher[i] = (char)(42 + c); // make current char the encrypted one
        // }

        EncryptorHelp.validateInput(cipher);
        for(int i = 0; i < cipher.length; i++)
            cipher[i] = EncryptorHelp.encryptChar(cipher[i], sc - 42);

        // return encrypted string
        return new String(cipher);
    }

    public String decrypt(String cipher){ 
        
        char[] plain = cipher.toCharArray(); // convert string to array
        // for(int i = 0; i < plain.length; i++) {

        //     // get decrypted char
        //     int k = sc - 42;
        //     int c = (int)plain[i] - 42;
        //     int p = (c + (81 - k)) % 81;

        //     plain[i] = (char)(42 + p); // make current char the decrypted one
        // }

        for(int i = 0; i < plain.length; i++)
            plain[i] = EncryptorHelp.decryptChar(plain[i], sc - 42);

        // return decrypted string
        return new String(plain);
    }
}