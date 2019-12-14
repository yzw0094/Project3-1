package Project3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePurchaseUI {

    public JFrame view;

    public JButton btnSave = new JButton("Save Purchase");

    public JTextField txtPurchaseID = new JTextField(20);
    public JTextField txtCustomerID = new JTextField(20);
    public JTextField txtProductID = new JTextField(20);
    public JTextField txtPrice = new JTextField(20);
    public JTextField txtQuantity = new JTextField(20);
    public JTextField txtCost = new JTextField(20);
    public JTextField txtTax = new JTextField(20);
    public JTextField txtTotal = new JTextField(20);
    public JTextField txtDate = new JTextField(20);


    public ManagePurchaseUI() {
        this.view = new JFrame();

        view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        view.setTitle("Update Purchase Information");
        view.setSize(600, 400);
        view.getContentPane().setLayout(new BoxLayout(view.getContentPane(), BoxLayout.PAGE_AXIS));

        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.add(btnSave);
        view.getContentPane().add(panelButtons);

        JPanel line1 = new JPanel(new FlowLayout());
        line1.add(new JLabel("PurchaseID "));
        line1.add(txtPurchaseID);
        view.getContentPane().add(line1);

        JPanel line2 = new JPanel(new FlowLayout());
        line2.add(new JLabel("CustomerID "));
        line2.add(txtCustomerID);
        view.getContentPane().add(line2);

        JPanel line3 = new JPanel(new FlowLayout());
        line3.add(new JLabel("ProductID "));
        line3.add(txtProductID);
        view.getContentPane().add(line3);

        JPanel line4 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Price "));
        line4.add(txtPrice);
        view.getContentPane().add(line4);

        JPanel line5 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Quantity "));
        line4.add(txtQuantity);
        view.getContentPane().add(line5);

        JPanel line6 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Cost "));
        line4.add(txtCost);
        view.getContentPane().add(line6);

        JPanel line7 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Tax "));
        line4.add(txtTax);
        view.getContentPane().add(line7);

        JPanel line8 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Total "));
        line4.add(txtTotal);
        view.getContentPane().add(line8);

        JPanel line9 = new JPanel(new FlowLayout());
        line4.add(new JLabel("Date "));
        line4.add(txtDate);
        view.getContentPane().add(line9);

        btnSave.addActionListener(new SaveButtonListener());

    }

    public void run() {
        view.setVisible(true);
    }


    class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            PurchaseModel Purchase = new PurchaseModel();
            String id = txtPurchaseID.getText();

            if (id.length() == 0) {
                JOptionPane.showMessageDialog(null, "PurchaseID cannot be null!");
                return;
            }

            try {
                Purchase.mPurchaseID = Integer.parseInt(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "PurchaseID is invalid!");
                return;
            }

            String CustomerID = txtCustomerID.getText();
            try {
                Purchase.mPrice = Integer.parseInt(CustomerID);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
                return;
            }

            String ProductID = txtProductID.getText();
            try {
                Purchase.mProductID = Integer.parseInt(ProductID);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "CustomerID is invalid!");
                return;
            }

            String price = txtPrice.getText();
            try {
                Purchase.mPrice = Double.parseDouble(price);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Price is invalid!");
                return;
            }

            String quant = txtQuantity.getText();
            try {
                Purchase.mQuantity = Double.parseDouble(quant);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            String cost = txtCost.getText();
            try {
                Purchase.mCost = Double.parseDouble(cost);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            String tax = txtQuantity.getText();
            try {
                Purchase.mQuantity = Double.parseDouble(tax);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            // Total
            String total = txtTotal.getText();
            try {
                Purchase.mTotal = Double.parseDouble(total);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            // Date
            String date = txtDate.getText();
            try {
                Purchase.mDate = date;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantity is invalid!");
                return;
            }

            int  res = StoreManager.getInstance().getDataAdapter().savePurchase(Purchase);

            if (res == IDataAdapter.PURCHASE_SAVE_FAILED)
                JOptionPane.showMessageDialog(null, "Purchase is NOT saved successfully!");
            else
                JOptionPane.showMessageDialog(null, "Purchase is SAVED successfully!");
        }
    }
}
