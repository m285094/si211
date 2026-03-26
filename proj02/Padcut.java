// Sam Pirkl

public class Padcut implements Hasher {

    public String getAlgName() { return "padcut"; }

    public void   init(char[] pswd) throws IllegalCharException {

        EncryptorHelp.validateInput(pswd);
        // for(int i = 0; i < pswd.length; i++) {

        //     if((int)pswd[i] < 42 || (int)pswd[i] > 122)
        //         throw new IllegalCharException("error " + pswd[i] + " not allowed in password");
        // }
    }

    // public String readPassword(char[] pswd) { return new String(pswd); }

    public String computeHash(char[] pswd) throws IllegalCharException {

        char[] hash = new char[16];
        for(int i = 0; i < 16; i++) 
            hash[i] = (i < pswd.length) ? pswd[i] : 'x';
        
        return new String(hash);
    }
}