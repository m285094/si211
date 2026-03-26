// Sam Pirkl

public class Caesar implements Encryptor {

    private int sc;
    public Caesar() {
        this.sc = 18;
    }

    public String getAlgName() { return "caesar"; }

    public void   init(char[] key) throws IllegalCharException { 

        EncryptorHelp.validateInput(key);

        for(char c : key) 
            sc += (int)c - 42;
        sc = 42 + (sc % 81);
    }

    public String encrypt(String plain) throws IllegalCharException { 
        
        char[] cipher = plain.toCharArray(); // convert string to array

        EncryptorHelp.validateInput(cipher);
        for(int i = 0; i < cipher.length; i++)
            cipher[i] = EncryptorHelp.encryptChar(cipher[i], sc - 42);

        // return encrypted string
        return new String(cipher);
    }

    public String decrypt(String cipher){ 
        
        char[] plain = cipher.toCharArray(); // convert string to array

        for(int i = 0; i < plain.length; i++)
            plain[i] = EncryptorHelp.decryptChar(plain[i], sc - 42);

        // return decrypted string
        return new String(plain);
    }
}