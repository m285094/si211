// Sam Pirkl

// Encryptor providing the clear algorithm, which is to
// not change the plaintext at all.
public class Clear implements Encryptor {

    public String getAlgName() { return "clear"; }
    
    public void   init(char[] key) throws IllegalCharException { 

        EncryptorHelp.validateInput(key);
        // // loop through characters in key
        // for(int i = 0; i < key.length; i++) {

        //     // throw exception if there's a dollar sign in key
        //     if(key[i] == '$')
        //         throw new IllegalCharException("error $ not allowed in key");

        //     // throw exception if char in key is outside allowed ascii range
        //     if((int)key[i] < 42 || (int)key[i] > 122)
        //         throw new IllegalCharException("error characters in key must be within ASCII range 42-122");
        // }

    }

    public String encrypt(String plain) throws IllegalCharException { 

        EncryptorHelp.validateInput(plain.toCharArray());
        // // convert string to char array
        // char[] cipher = plain.toCharArray();
        // for(int i = 0; i < cipher.length; i++) {

        //     // throw exception if therea's a dollar sign in plaintext
        //     if(cipher[i] == '$')
        //         throw new IllegalCharException("error $ not allowed in plaintext");

        //     // throw exception if char in plaintext is outside allowed ascii range
        //     if((int)cipher[i] < 42 || (int)cipher[i] > 122)
        //         throw new IllegalCharException("error characters in plaintext must be within ASCII range 42-122");
        // }

        // return original string
        return plain; 
    }

    public String decrypt(String cipher) { return cipher; }
}