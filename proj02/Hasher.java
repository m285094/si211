// Sam Pirkl

public interface Hasher {
    public String getAlgName();
    public void   init(char[] pswd) throws IllegalCharException;
    // public String readPassword(char[] pswd);
    public String computeHash(char[] pswd) throws IllegalCharException;
}