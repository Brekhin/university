package licence.installer;

import com.sun.deploy.association.utility.WinRegistryWrapper;
import licence.GenerateHash;
import com.sun.security.auth.module.NTSystem;

public class GenLicense implements GenerateHash {
    private NTSystem NTSystem;
    public GenLicense(){
        this.NTSystem = new NTSystem();
    }

    public void generateLicense(String argc) {
        NTSystem NTSystem = new NTSystem();
        String id = getHash(NTSystem.getName() + " " + getHardwareAddress());
        WinRegistryWrapper.WinRegSetValueEx(WinRegistryWrapper.HKEY_CURRENT_USER,
                "SOFTWARE\\JavaSoft\\Prefs", "test", id);
        System.out.println("The license is generate!");
    }
}
