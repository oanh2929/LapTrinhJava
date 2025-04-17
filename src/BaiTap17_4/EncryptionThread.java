package BaiTap17_4;

public class EncryptionThread extends Thread {
    private Encryptable encryption;
    private String data;
    private boolean isEncrypt;

    public EncryptionThread(Encryptable encryption, String data, boolean isEncrypt) {
        this.encryption = encryption;
        this.data = data;
        this.isEncrypt = isEncrypt;
    }

    @Override
    public void run() {
        try {
            if (isEncrypt) {
                String encrypted = encryption.encrypt(data);
                System.out.println("Encrypted: " + encrypted);
            } else {
                String decrypted = encryption.decrypt(data);
                System.out.println("Decrypted: " + decrypted);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

