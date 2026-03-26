// Sam Pirkl

// This matches the basic in/out functionality of Part 1.
// As you implement more Encryptors, you just put an "add"
// line in for them, and they become part of thie test driver.
import java.util.*;

public class TestHashers {
    public static void main(String[] args) throws Throwable, IllegalCharException {
    // Create ArrayList of all supported encryptors
    ArrayList<Hasher> H = new ArrayList<Hasher>();
    H.add(new Padcut());
    H.add(new ShiftCaesar());
    H.add(new ShiftVigenere());

    // Get alg,psw,msg from user
    System.out.print("algorithm: ");
    String hashalg = System.console().readLine();
    System.out.print("password : ");
    char[] password = System.console().readPassword();

    // Find encryptor (throw exception if not found)
    int i = 0;
    while(i < H.size() && !H.get(i).getAlgName().equals(hashalg))
        i++;
    if (i == H.size())
        throw new Exception("Unknown algorithm '"+hashalg+"'.");
    Hasher h = H.get(i);

    // Encrypt, decrypt print sumamry of results
    h.init(password);
    String hash = h.computeHash(password);
    System.out.println("password read : " + new String(password));
    System.out.println("hash computed : " + hash);
    }
}