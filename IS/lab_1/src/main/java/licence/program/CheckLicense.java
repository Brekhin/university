package licence.program;

import com.sun.deploy.association.utility.WinRegistryWrapper;
import com.sun.security.auth.module.NTSystem;
import licence.GenerateHash;

public class CheckLicense implements GenerateHash{
    private NTSystem NTSystem;
    public CheckLicense(){
        this.NTSystem = new NTSystem();
    }

    public void runProgram(){
        String id = getHash(NTSystem.getName() + " " + getHardwareAddress());
        try {
            if (WinRegistryWrapper.WinRegQueryValueEx(WinRegistryWrapper.HKEY_CURRENT_USER,
                    "SOFTWARE\\JavaSoft\\Prefs", "test").equals(id)) {
                System.out.println("License is valid!");
            }
            else{
                System.out.println("Unauthorised access!");
            }
        }catch(Exception e){
            System.out.println("Unauthorised access!");
        }
    }
}
