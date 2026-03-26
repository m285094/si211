// Sam Pirkl

// Encryptor providing the clear algorithm, which is to
// not change the plaintext at all.
public class Clear implements Encryptor {

    public String getAlgName() { return "clear"; }
    
    public void   init(char[] key) throws IllegalCharException { 

        EncryptorHelp.validateInput(key);
    }

    public String encrypt(String plain) throws IllegalCharException { 

        EncryptorHelp.validateInput(plain.toCharArray());

        // return original string
        return plain; 
    }

    public String decrypt(String cipher) { return cipher; }
}