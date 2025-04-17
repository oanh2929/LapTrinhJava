package BaiTap17_4;

public interface Encryptable {
    String encrypt(String data) throws Exception;
    String decrypt(String encryptedData) throws Exception;
}

