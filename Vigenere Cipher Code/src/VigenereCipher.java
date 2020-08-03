import edu.duke.*;
import java.util.*;

public class VigenereCipher {
    CaeserCipherVin[] ciphers;
    
    public VigenereCipher(int[] key) {
        ciphers = new CaeserCipherVin[key.length];
        for (int i = 0; i < key.length; i++) {
            ciphers[i] = new CaeserCipherVin(key[i]);
        }
    }
    
    public String encrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaeserCipherVin thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.encryptLetter(c));
            i++;
        }
        return answer.toString();
    }
    
    public String decrypt(String input) {
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for (char c : input.toCharArray()) {
            int cipherIndex = i % ciphers.length;
            CaeserCipherVin thisCipher = ciphers[cipherIndex];
            answer.append(thisCipher.decryptLetter(c));
            i++;
        }
        return answer.toString();
    }
    
    public String toString() {
        return Arrays.toString(ciphers);
    }
    
}
