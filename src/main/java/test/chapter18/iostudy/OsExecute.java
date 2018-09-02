package test.chapter18.iostudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OsExecute {

    public static void command(String command) {
        boolean err = false;
        try {
            String s;
            Process process = new ProcessBuilder(command.split(" ")).start();
            BufferedReader res = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((s = res.readLine()) != null){
                System.out.println(s);
            }
            BufferedReader erros = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()));
            while ((s = erros.readLine())!= null){
                System.err.println(s);
            }

        } catch (Exception e) {
            if (!command.startsWith("CMD /C")){
                command("CMD /C"+command);
            }else
                throw new RuntimeException(e);
        }
        if (err){
            throw new OSException("erro message"+command);
        }
    }

    public static void main(String[] args){
        OsExecute.command("javap OsExecute");
    }
}

class OSException extends RuntimeException{
    public OSException(String why){
        super(why);
    }
}