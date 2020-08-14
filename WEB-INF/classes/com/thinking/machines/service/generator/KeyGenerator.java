package com.tm.one.generator;
import java.security.*;
import java.util.logging.*;
import javax.crypto.*;
import javax.crypto.spec.*;
public class KeyGenerator
{
public String encrypt(String data,String key) throws Exception
{
SecretKeySpec skeyspec=new SecretKeySpec(key.getBytes(),"AES");
Cipher cipher=Cipher.getInstance("AES");
cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
byte[] encrypted=cipher.doFinal(data.getBytes());
String strData=new String(encrypted);
return strData;
}
public String decrypt(String encryptedData,String key) throws Exception
{
SecretKeySpec skeyspec=new SecretKeySpec(key.getBytes(),"AES");
Cipher cipher=Cipher.getInstance("AES");
cipher.init(Cipher.DECRYPT_MODE, skeyspec);
byte[] decrypted=cipher.doFinal(encryptedData.getBytes());
String strData=new String(decrypted);
return strData;
}
}