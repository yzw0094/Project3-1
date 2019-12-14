package Project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageUserUI2 {
    public JFrame view;

    public JButton btnUpdate = new JButton("Update password/fullname");

    public JTextField txtPassword = new JTextField(20);
    public JTextField txtFullname = new JTextField(20);


    public ManageUserUI2() {
        this.view = new JFrame();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Update User Information");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnUpdate);
        view.getContentPane().add(panelButtons);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("Password "));
        line2.add(txtPassword);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("Fullname "));
        line3.add(txtFullname);
        view.getContentPane().add(line3);

        btnUpdate.addActionListener(new UpdateButtonListerner());
    }

    public void run() {
        view.setVisible(true);
    }

    class UpdateButtonListerner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            UserModel user = new UserModel();

            String password = txtPassword.getText();
            if (password.length() == 0) {
                JOptionPane.showMessageDialog(null, "Password cannot be empty!");
                return;
            }
            user.mPassword = password;

            String fullname = txtFullname.getText();
            if (fullname.length() == 0) {
                JOptionPane.showMessageDialog(null, "Fullname cannot be empty!");
                return;
            }
            user.mFullname = fullname;

            int  res = StoreManager.getInstance().getDataAdapter().saveUser(user);

            if (res == IDataAdapter.USER_SAVE_FAILED)
                JOptionPane.showMessageDialog(null, "User is NOT saved successfully!");
            else
                JOptionPane.showMessageDialog(null, "User is SAVED successfully!");
        }
    }
}
