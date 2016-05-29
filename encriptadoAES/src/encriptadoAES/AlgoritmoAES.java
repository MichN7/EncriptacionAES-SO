
package encriptadoAES;

import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class AlgoritmoAES {
    
    public static String as = "AES";
    public byte[] keyValue;
    
    public AlgoritmoAES(byte key[]){
        keyValue = key;
    }
    
    public Key generarKey()throws Exception{
        Key key = new SecretKeySpec(keyValue,as);
        return key;
    }
    
    public String encriptar(String msg) throws Exception{
        Key key = generarKey();
        Cipher c = Cipher.getInstance(as);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] valEnc = c.doFinal(msg.getBytes());
        String valorEncriptado = new BASE64Encoder().encode(valEnc);
        return valorEncriptado;  
    }
    
    public String desencriptar(String msg)throws Exception{
        Key key = generarKey();
        Cipher c = Cipher.getInstance(as);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] valorDecodiado = new BASE64Decoder().decodeBuffer(msg);
        byte[] decValue = c.doFinal(valorDecodiado);
        String valorDesencriptado = new String(decValue);
        return valorDesencriptado;
    }
    
}
