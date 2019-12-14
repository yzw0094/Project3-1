package Project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdateUserUI {
    public JFrame view;

    public JButton btnUpdate = new JButton("Update User");

    public JTextField txtUsername = new JTextField(20);
    public JTextField txtPassword = new JTextField(20);
    public JTextField txtFullname = new JTextField(20);
    public JTextField txtUsertype = new JTextField(20);


    public UpdateUserUI() {
        this.view = new JFrame();
        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Update User Information");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));
        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnUpdate);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("Enter Existing Username "));
        line1.add(txtUsername);
        view.getContentPane().add(line1);

        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Usertype "));
        line4.add(txtUsertype);
        view.getContentPane().add(line4);
        btnUpdate.addActionListener(new UpdateButtonListerner());
    }

    public void run() {
        view.setVisible(true);
    }

    class UpdateButtonListerner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            UserModel user = new UserModel();

            String username = txtUsername.getText();
            if (username.length() == 0) {
                JOptionPane.showMessageDialog(null, "Username cannot be null!");
                return;
            }
            user.mUsername = username;


            String usertype = txtUsertype.getText();
            if (usertype.length() == 0) {
                JOptionPane.showMessageDialog(null, "Usertype cannot be empty!");
                return;
            }
            user.mUserType = Integer.parseInt(usertype);

            int  res = StoreManager.getInstance().getDataAdapter().saveUser(user);

            if (res == IDataAdapter.USER_SAVE_FAILED)
                JOptionPane.showMessageDialog(null, "User is not Updated successfully!");
            else
                JOptionPane.showMessageDialog(null, "User is Updated successfully!");
        }
    }
}
