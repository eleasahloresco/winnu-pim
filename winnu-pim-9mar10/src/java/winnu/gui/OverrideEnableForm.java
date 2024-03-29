package winnu.gui;
import java.awt.event.KeyEvent;
import winnu.dao.Item;
import javax.swing.JOptionPane;

import winnu.control.WinnuControl;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AdminEnableForm.java
 *
 * Created on 03 2, 10, 9:54:03 PM
 */

/**
 *
 * @author argemgrflores
 */
public class OverrideEnableForm extends javax.swing.JFrame {
	private WinnuControl control;
	private ExecuteSalePanel parent;
	private int index;
	private String item;
	
    /** Creates new form AdminEnableForm */
    public OverrideEnableForm(WinnuControl control, ExecuteSalePanel parent, String selectedItem, int selectedIndex) {
        this.control = control;
        this.parent = parent;
        this.index = selectedIndex;
        this.item = selectedItem;
    	initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {
        lblEnableOverrideSale = new javax.swing.JLabel();
        lblUsername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnConfirm = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        opaneOverride = new javax.swing.JOptionPane();
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblEnableOverrideSale.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblEnableOverrideSale.setText("Enable Override Sale");

        lblUsername.setText("Username:");

        lblPassword.setText("Password:");

        btnConfirm.setText("Confirm");
        btnConfirm.setEnabled(false);
        btnConfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        
        txtPassword.addKeyListener(new java.awt.event.KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {	
			}

			@Override
			public void keyReleased(KeyEvent e) {				
			}

			@Override
			public void keyTyped(KeyEvent e) {	
				checkIfValid();
			}
        });
        
        txtUsername.addKeyListener(new java.awt.event.KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {	
			}

			@Override
			public void keyReleased(KeyEvent e) {		
			}

			@Override
			public void keyTyped(KeyEvent e) {	
				checkIfValid();
			}
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblEnableOverrideSale))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUsername)
                                    .addComponent(lblPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                    .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnConfirm)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblEnableOverrideSale)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUsername)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPassword))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnConfirm)
                    .addComponent(btnCancel))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>

    private void checkIfValid(){
    	if(txtPassword.getText().equals("") || txtUsername.getText().equals("")) {
    		btnConfirm.setEnabled(false);
    	}
    	else {
    		btnConfirm.setEnabled(true);
    	}
    }
    
	public void enableByUser() {
		if(!control.getCurrentUser().getType().toUpperCase().equals("ADMIN")) {
			this.setLocation(500, 250);
			this.setResizable(false);
			this.setEnabled(true);
			this.setVisible(true);
		}
		else {
			if(confirmOverrideSale()) {
				this.parent.updateItemList();
				JOptionPane.showMessageDialog(null, this.item +  " has been successfully removed.", "Override Sale", 1);
			}
		}
	}

	private void btnConfirmActionPerformed(java.awt.event.ActionEvent evt) {
		if(this.control.loginController.authenticateUser(txtUsername.getText(), txtPassword.getText())){
            if(confirmOverrideSale()) {
            	JOptionPane.showMessageDialog(null, this.item +  " has been successfully removed.", "Override Sale", 1);
            }
            
            this.setVisible(false);
    	}
		else{
    		txtPassword.setText("");
    	}
		
		this.parent.updateItemList();
	}
	
	private boolean confirmOverrideSale() {
		opaneOverride.setLocation(500, 250);
		opaneOverride.setEnabled(true);
		opaneOverride.setVisible(true);
		
		if(opaneOverride.showConfirmDialog(null, "Confirm Override Sale Option?", null, javax.swing.JOptionPane.YES_NO_OPTION) == opaneOverride.YES_OPTION) {
			control.saleController.overrideSale(this.index);
			
			return true;
		}
		
		return false;
	}
	
	private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {
		this.setVisible(false);
	}

    // Variables declaration - do not modify
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnConfirm;
    private javax.swing.JLabel lblEnableOverrideSale;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblUsername;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JOptionPane opaneOverride ;
    // End of variables declaration

}
