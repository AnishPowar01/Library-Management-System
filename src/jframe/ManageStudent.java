/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import static jframe.DBConnection.con;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import  java.sql.PreparedStatement;

/**
 *
 * @author Anish Powar
 */
public class ManageStudent extends javax.swing.JFrame {

    /**
     * Creates new form Manage books
     * 
     */
    String student_name,course,branch;
    int student_id;
    
    DefaultTableModel model;
    public ManageStudent() {
        initComponents();
        setStudentDetails();
    }
    
    public void setStudentDetails()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from student_details");
           
            while (rs.next()) {

                String studentid = rs.getString("student_id");
                String studentname = rs.getString("student_name");
                String cours = rs.getString("class");
                String bran = rs.getString("branch");
                
                Object[] obj = {studentid,studentname,cours,bran};
                model = (DefaultTableModel) table_StudentDetails.getModel();
                model.addRow(obj);
                
                
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addStudent()
    {
        boolean isAdded = false;
        student_id = Integer.parseInt(text_StudentId.getText());
        student_name = text_StudentName.getText();
        course = Combo_Class.getSelectedItem().toString();
        branch = Combo_Branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, student_id);
            pst.setString(2, student_name);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            
            if (rowCount > 0) {
                
                isAdded = true;
                
            }
            else
            {
                isAdded = false;
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        return isAdded;
    }
    
    //to update book
    
    public boolean updateStudent()
            {
                  boolean isUpdated = false;
       student_id = Integer.parseInt(text_StudentId.getText());
        student_name = text_StudentName.getText();
        course = Combo_Class.getSelectedItem().toString();
        branch = Combo_Branch.getSelectedItem().toString();
        
                try {
                    Connection con = DBConnection.getConnection();
                    String sql = "update student_details set student_name = ?,class = ?,branch = ? where student_id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    
                    pst.setString(1, student_name);
                    pst.setString(2, course);
                    pst.setString(3, branch);
                    pst.setInt(4, student_id);
                    
                    int rowCount = pst.executeUpdate();
                    
                    if (rowCount > 0) {
                        
                        isUpdated = true;
                        
                    }
                    else
                    {
                        isUpdated = false;
                    }
                            
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                return isUpdated;
            }
    
    
    //delte book
    
    
    public boolean deleteStudent()
    {
        boolean isDeleted = false;
                student_id = Integer.parseInt(text_StudentId.getText());
                
                try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, student_id);
            int rowCount = pst.executeUpdate();
            
                    if (rowCount > 0) {
                        isDeleted = true;
                        
                    }
                    
                    else
                    {
                        isDeleted = false;
                    }
        } catch (Exception e) {
            e.printStackTrace();
        }
                
                return isDeleted;

    }
    
    //clear table
    
    public void clearTable()
    {
        DefaultTableModel model = (DefaultTableModel) table_StudentDetails.getModel();
        model.setRowCount(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        text_StudentId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        text_StudentName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        Combo_Branch = new javax.swing.JComboBox<>();
        Combo_Class = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_StudentDetails = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 310));

        jPanel2.setBackground(new java.awt.Color(1, 77, 109));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(229, 14, 71));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel2.setText("Back");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, -1));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 50));

        text_StudentId.setBackground(new java.awt.Color(1, 77, 109));
        text_StudentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_StudentId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_StudentId.setPlaceholder("Enter Student ID..");
        text_StudentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_StudentIdFocusLost(evt);
            }
        });
        text_StudentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_StudentIdActionPerformed(evt);
            }
        });
        jPanel2.add(text_StudentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 260, 40));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 60, 50));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Student ID");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 220, 40));

        text_StudentName.setBackground(new java.awt.Color(1, 77, 109));
        text_StudentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_StudentName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_StudentName.setPlaceholder("Enter Student Name..");
        text_StudentName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_StudentNameFocusLost(evt);
            }
        });
        text_StudentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_StudentNameActionPerformed(evt);
            }
        });
        jPanel2.add(text_StudentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 260, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 60, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Student Name");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 220, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 60, 50));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Class");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 220, 40));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 60, 50));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Branch");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 220, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(229, 14, 71));
        rSMaterialButtonCircle1.setText("DELETE");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 660, 130, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(229, 14, 71));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 660, 130, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(229, 14, 71));
        rSMaterialButtonCircle3.setText("UPDATE");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel2.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 660, 130, 60));

        Combo_Branch.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        Combo_Branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Computer", "IT", "Mechanical", "Civil", "E&TC" }));
        Combo_Branch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_BranchActionPerformed(evt);
            }
        });
        jPanel2.add(Combo_Branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 270, 40));

        Combo_Class.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        Combo_Class.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A ", "B ", "C ", "D" }));
        Combo_Class.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Combo_ClassActionPerformed(evt);
            }
        });
        jPanel2.add(Combo_Class, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 270, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_StudentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student ID", " Name", "Course", "Branch"
            }
        ));
        table_StudentDetails.setColorBackgoundHead(new java.awt.Color(1, 77, 109));
        table_StudentDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        table_StudentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_StudentDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_StudentDetails.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        table_StudentDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        table_StudentDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_StudentDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        table_StudentDetails.setRowHeight(30);
        table_StudentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_StudentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_StudentDetails);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 800, 300));

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Student_Male_100px.png"))); // NOI18N
        jLabel3.setText("  Manage Students");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 360, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 410, 5));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 980, 830));

        setSize(new java.awt.Dimension(1567, 831));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void text_StudentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_StudentIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_StudentIdFocusLost

    private void text_StudentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_StudentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_StudentIdActionPerformed

    private void text_StudentNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_StudentNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_StudentNameFocusLost

    private void text_StudentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_StudentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_StudentNameActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if (deleteStudent()== true) {
            
            JOptionPane.showMessageDialog(this, "Students Record Deleted Successfully");
            clearTable();
            setStudentDetails();
            
        }
        else 
        {
             JOptionPane.showMessageDialog(this, "Student record not deleted");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        
        if (addStudent()== true) {
            
            JOptionPane.showMessageDialog(this, "Student Added Successfully");
            clearTable();
            setStudentDetails();
            
        }
        else 
        {
             JOptionPane.showMessageDialog(this, "Student not added");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
           if (updateStudent()== true) {
            
            JOptionPane.showMessageDialog(this, "Student Details Updated Successfully");
            clearTable();
            setStudentDetails();
            
        }
        else 
        {
             JOptionPane.showMessageDialog(this, "Student Details not Updated");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void table_StudentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_StudentDetailsMouseClicked

        // TODO add your handling code here:
        
        int rowNo = table_StudentDetails.getSelectedRow();
        TableModel model = table_StudentDetails.getModel();
        
        text_StudentId.setText(model.getValueAt(rowNo, 0).toString());
        text_StudentName.setText(model.getValueAt(rowNo, 1).toString());
        Combo_Class.setSelectedItem(model.getValueAt(rowNo, 2).toString());
        Combo_Branch.setSelectedItem(model.getValueAt(rowNo, 3).toString());
       
    }//GEN-LAST:event_table_StudentDetailsMouseClicked

    private void Combo_BranchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_BranchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_BranchActionPerformed

    private void Combo_ClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Combo_ClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Combo_ClassActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudent().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Combo_Branch;
    private javax.swing.JComboBox<String> Combo_Class;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro table_StudentDetails;
    private app.bolivia.swing.JCTextField text_StudentId;
    private app.bolivia.swing.JCTextField text_StudentName;
    // End of variables declaration//GEN-END:variables
}
