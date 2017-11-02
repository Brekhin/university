package licence;

import org.apache.commons.codec.digest.DigestUtils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public interface GenerateHash {

    default String getHardwareAddress(){
        InetAddress ip;
        StringBuilder sb = new StringBuilder();
        try {
            ip = InetAddress.getLocalHost();
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e){
            e.printStackTrace();
        }
        return sb.toString();
    }

    default String getHash(String input){
        String[] splitStr = input.split(" ");
        StringBuilder stringBuilder = new StringBuilder();
        for(String buf : splitStr)
            stringBuilder.append(buf + "b卑ФЯIAAMf3@*^&!_");
        String md5 = DigestUtils.md5Hex(stringBuilder.toString());
        return md5;
    }
}
