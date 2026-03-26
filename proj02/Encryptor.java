// Sam Pirkl

// interface for objects that provide
// encryption functionality.
public interface Encryptor {
    public String getAlgName();
    public void   init(char[] key) throws IllegalCharException;
    public String encrypt(String plain) throws IllegalCharException;
    public String decrypt(String cipher);
}