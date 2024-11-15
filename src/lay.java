import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class lay extends JFrame {
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField6;
    private JTextField textField1;
    private JTextField textField2;
    private JButton registerButton;
    private JButton loginButton;
    private JPanel mainregister;
    private JPasswordField passwordField1;

    public void regs() throws IOException{
        String fname = textField1.getText();
        String lname = textField3.getText();
        String email = textField4.getText();
        String usn = textField2.getText();
        String pass = new String(passwordField1.getPassword());
        String mb = textField6.getText();

        boolean res = acc.checklog(usn,pass);
        if (res) {
            JOptionPane.showMessageDialog(this,"Tai khoan ton tai roi", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            acc tk = new acc(fname,lname,email,usn,pass,mb);
            try{
                tk.Themtk();
            } catch (IOException e) {
            }
            JOptionPane.showMessageDialog(this,"Dang ky thanh cong","Success",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public lay(){
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    regs();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   login lg = new login();
                   lg.setSize(400,300);
                   lg.setContentPane(lg.getPanelmain());
                   lg.setLocationRelativeTo(null);
                   lg.setVisible(true);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }


    public static void main(String[] args) {
        lay layers = new lay();
        layers.setContentPane(layers.mainregister);
        layers.setSize(600,300);
        layers.setLocationRelativeTo(null);
        layers.setVisible(true);
        layers.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}