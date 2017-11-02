package licence.installer;

public class Main {
    public static void main(String[] argv){
        GenLicense genLicense = new GenLicense();
        genLicense.generateLicense("install");
    }
}
