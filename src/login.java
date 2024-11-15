import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class login extends JFrame {
    private JPanel gg1;
    private JTextField textField1;
    private JButton loginButton;
    private JPanel login1;
    private JPasswordField passwordField1;

    public JPanel getPanelmain(){
        return gg1;
    }

    public login() throws IOException {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usn = textField1.getText();
                String pass = new String(passwordField1.getPassword());
                try{
                    boolean res = acc.checklog(usn,pass);
                    if(res){
                        JOptionPane.showMessageDialog(loginButton,"Login thanh cong","chao mung den voi tinh yeu",JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(loginButton,"Login khong thanh cong: sai username hoac mat khau","Cut",JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) throws IOException {
        login lg = new login();
        lg.setContentPane(lg.gg1);
        lg.setSize(400,300);
        lg.setVisible(true);
        lg.setLocationRelativeTo(null);
        lg.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
