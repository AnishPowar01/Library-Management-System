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
public class Managebooks extends javax.swing.JFrame {

    /**
     * Creates new form Manage books
     * 
     */
    String book_name,autho;
    int book_id,quant;
    
    DefaultTableModel model;
    public Managebooks() {
        initComponents();
        setBookDetails();
    }
    
    public void setBookDetails()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
           Statement st = con.createStatement();
           ResultSet rs = st.executeQuery("select * from book_details");
           
            while (rs.next()) {

                String bookId = rs.getString("book_id");
                String bookName = rs.getString("book_name");
                String author = rs.getString("author");
                String quantity = rs.getString("quantity");
                
                Object[] obj = {bookId,bookName,author,quantity};
                model = (DefaultTableModel) table_bookDetails.getModel();
                model.addRow(obj);
                
                
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addBook()
    {
        boolean isAdded = false;
        book_id = Integer.parseInt(text_BookId.getText());
        book_name = text_BookName.getText();
        autho = text_Author.getText();
        quant = Integer.parseInt(text_Quant.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into book_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, book_id);
            pst.setString(2, book_name);
            pst.setString(3, autho);
            pst.setInt(4, quant);
            
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
    
    public boolean updateBook()
            {
                  boolean isUpdated = false;
        book_id = Integer.parseInt(text_BookId.getText());
        book_name = text_BookName.getText();
        autho = text_Author.getText();
        quant = Integer.parseInt(text_Quant.getText());
        
                try {
                    Connection con = DBConnection.getConnection();
                    String sql = "update book_details set book_name = ?,author = ?,quantity = ? where book_id = ?";
                    PreparedStatement pst = con.prepareStatement(sql);
                    
                    pst.setString(1, book_name);
                    pst.setString(2, autho);
                    pst.setInt(3, quant);
                    pst.setInt(4, book_id);
                    
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
    
    
    public boolean deleteBook()
    {
        boolean isDeleted = false;
                book_id = Integer.parseInt(text_BookId.getText());
                
                try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from book_details where book_id = ?";
            
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, book_id);
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
        DefaultTableModel model = (DefaultTableModel) table_bookDetails.getModel();
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
        text_BookId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        text_BookName = new app.bolivia.swing.JCTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        text_Author = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        text_Quant = new app.bolivia.swing.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_bookDetails = new rojeru_san.complementos.RSTableMetro();
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

        text_BookId.setBackground(new java.awt.Color(1, 77, 109));
        text_BookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_BookId.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_BookId.setPlaceholder("Enter Book ID..");
        text_BookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_BookIdFocusLost(evt);
            }
        });
        text_BookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_BookIdActionPerformed(evt);
            }
        });
        jPanel2.add(text_BookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 260, 40));

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 60, 50));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Book ID");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 220, 40));

        text_BookName.setBackground(new java.awt.Color(1, 77, 109));
        text_BookName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_BookName.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_BookName.setPlaceholder("Enter Book Name..");
        text_BookName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_BookNameFocusLost(evt);
            }
        });
        text_BookName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_BookNameActionPerformed(evt);
            }
        });
        jPanel2.add(text_BookName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 350, 260, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Moleskine_26px.png"))); // NOI18N
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 60, 50));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Book Name");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 220, 40));

        text_Author.setBackground(new java.awt.Color(1, 77, 109));
        text_Author.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_Author.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_Author.setPlaceholder("Author Name..");
        text_Author.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_AuthorFocusLost(evt);
            }
        });
        text_Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_AuthorActionPerformed(evt);
            }
        });
        jPanel2.add(text_Author, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 260, 40));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 60, 50));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Author Name");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 220, 40));

        text_Quant.setBackground(new java.awt.Color(1, 77, 109));
        text_Quant.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        text_Quant.setFont(new java.awt.Font("Segoe UI", 0, 17)); // NOI18N
        text_Quant.setPlaceholder("Quantity...");
        text_Quant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                text_QuantFocusLost(evt);
            }
        });
        text_Quant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_QuantActionPerformed(evt);
            }
        });
        jPanel2.add(text_Quant, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 570, 260, 40));

        jLabel15.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Unit_26px.png"))); // NOI18N
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 560, 60, 50));

        jLabel16.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Quantity");
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

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 830));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_bookDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", " Name", "Author", "Quantity"
            }
        ));
        table_bookDetails.setColorBackgoundHead(new java.awt.Color(1, 77, 109));
        table_bookDetails.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        table_bookDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        table_bookDetails.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        table_bookDetails.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        table_bookDetails.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        table_bookDetails.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        table_bookDetails.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        table_bookDetails.setRowHeight(30);
        table_bookDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_bookDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_bookDetails);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 740, 300));

        jLabel3.setFont(new java.awt.Font("Sitka Banner", 0, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 51));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel3.setText("  Manage Books");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 50, 290, -1));

        jPanel5.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 410, 5));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 980, 830));

        setSize(new java.awt.Dimension(1567, 831));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void text_BookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_BookIdFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_BookIdFocusLost

    private void text_BookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_BookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_BookIdActionPerformed

    private void text_BookNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_BookNameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_BookNameFocusLost

    private void text_BookNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_BookNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_BookNameActionPerformed

    private void text_AuthorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_AuthorFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_AuthorFocusLost

    private void text_AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_AuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_AuthorActionPerformed

    private void text_QuantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_text_QuantFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_text_QuantFocusLost

    private void text_QuantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_QuantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_QuantActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        // TODO add your handling code here:
        if (deleteBook()== true) {
            
            JOptionPane.showMessageDialog(this, "Book Deleted Successfully");
            clearTable();
            setBookDetails();
            
        }
        else 
        {
             JOptionPane.showMessageDialog(this, "Book not deleted");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        // TODO add your handling code here:
        
        if (addBook() == true) {
            
            JOptionPane.showMessageDialog(this, "Book Added Successfully");
            clearTable();
            setBookDetails();
            
        }
        else 
        {
             JOptionPane.showMessageDialog(this, "Book not added");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        // TODO add your handling code here:
           if (updateBook()== true) {
            
            JOptionPane.showMessageDialog(this, "Book Updated Successfully");
            clearTable();
            setBookDetails();
            
        }
        else 
        {
             JOptionPane.showMessageDialog(this, "Book not Updated");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void table_bookDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_bookDetailsMouseClicked

        // TODO add your handling code here:
        
        int rowNo = table_bookDetails.getSelectedRow();
        TableModel model = table_bookDetails.getModel();
        
        text_BookId.setText(model.getValueAt(rowNo, 0).toString());
        text_BookName.setText(model.getValueAt(rowNo, 1).toString());
        text_Author.setText(model.getValueAt(rowNo, 2).toString());
        text_Quant.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_table_bookDetailsMouseClicked

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
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Managebooks.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Managebooks().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private rojeru_san.complementos.RSTableMetro table_bookDetails;
    private app.bolivia.swing.JCTextField text_Author;
    private app.bolivia.swing.JCTextField text_BookId;
    private app.bolivia.swing.JCTextField text_BookName;
    private app.bolivia.swing.JCTextField text_Quant;
    // End of variables declaration//GEN-END:variables
}
