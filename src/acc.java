import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class acc {
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String mobile;

    public acc(String firstname, String lastname, String email, String username, String password, String mobile) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.mobile = mobile;
    }

    public void Themtk() throws IOException{
        FileWriter fw = new FileWriter("acc.txt");
        fw.write(this.username+"\n"+this.password+"\n");
        fw.close();
    }

    public static boolean checklog(String username, String password) throws IOException{
        Scanner sc = new Scanner(new File("acc.txt"));
        while(sc.hasNextLine()){
           String user = sc.nextLine();
           String pass = sc.nextLine();
           if(user.equals(username) && pass.equals(password)){
               return true;
           }
        }
        return false;
    }
}
