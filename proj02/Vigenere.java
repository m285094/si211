// Sam Pirkl

public class Vigenere implements Encryptor {

    private char[] key;
    
    public String getAlgName() { return "vigenere"; }

    public void   init(char[] key) throws IllegalCharException { 

        EncryptorHelp.validateInput(key);

        // if get through the for loop, set objects key equal to parameter
        this.key = key;
    }

    public String encrypt(String plain) throws IllegalCharException { 
        
        // make string a char array
        char[] cipher = plain.toCharArray(); // convert string to array

        EncryptorHelp.validateInput(cipher);
        for(int i = 0; i < cipher.length; i++)
            cipher[i] = EncryptorHelp.encryptChar(cipher[i], (int)key[i % key.length] - 42);

        // return ecnrypted string
        return new String(cipher);
    }

    public String decrypt(String cipher){ 
        
        // make string a char array
        char[] plain = cipher.toCharArray(); // convert string to array

        for(int i = 0; i < plain.length; i++)
            plain[i] = EncryptorHelp.decryptChar(plain[i], key[i % key.length] - 42);

        // return decrypted string
        return new String(plain);
    }
}