public class DataList extends List<Data> {

    private static Encryptor[] H = {new Clear(), new Caesar(), new Vigenere()};
    private ArrayList<Data> datum;
    public DataList() {
        datum = new ArrayList<Data>();
    }

    public void add(String name, String encAlg, String ciphertext) {
        super.add(new Data(name, encAlg, ciphertext));
    }

    public String getLabel(String labelRequest) {

        for(Data data : list) {


        }
    } 

    public static String decryptCipher(String encAlg, ) throws IllegalCharException, Exception {

        // find hasher (throw exception if not found)
        int i = 0;
        while(i < E.length && !E[i].getAlgName().equals(encAlg))
            i++;
        if (i == E.length)
            throw new Exception("Error! Encyrption algorithm '"+encAlg+"' not supported.");
        Encryptor e = E[i];

        e.init(pswd);
        return h.computeHash(pswd);
    }
}