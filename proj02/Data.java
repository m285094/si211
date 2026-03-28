public class Data {

    private String name, encAlg, ciphertext;
    public User(String name, String encAlg, String ciphertext) {
        this.name = name;
        this.encAlg = encAlg;
        this.ciphertext = ciphertext;
    }

    public String getName() { return name; }
    public String getEncAlg() { return encAlg; }
    public String getCipherText() { return ciphertext; }
}