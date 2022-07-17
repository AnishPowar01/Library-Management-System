/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.sql.Date;


/**
 *
 * @author Anish Powar
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    Color mouseEnterColor = new Color(0,0,0);
    Color mouseExitColor = new Color(51,51,51);
    
        DefaultTableModel model;
    public HomePage() {
        initComponents();
//        setExtendedState(MAXIMIZED_BOTH); 
//           showPieChart();
           setStudentDetails();
           setBookDetails();
           SetCardData();
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
                model = (DefaultTableModel) tbl_studDeta.getModel();
                model.addRow(obj);
                
                
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                model = (DefaultTableModel) tbl_bookdeta.getModel();
                model.addRow(obj);
                
                
            }
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     
     public void SetCardData()
     {
         Statement st = null;
         ResultSet rs = null;
         long l = System.currentTimeMillis();
         Date today = new Date(l);
         
         
         try {
             Connection con  =  DBConnection.getConnection();
             st = con.createStatement();
             rs = st.executeQuery("select * from book_details");
             rs.last();
             label_noBoks.setText(Integer.toString(rs.getRow()));
             
             rs = st.executeQuery("select * from student_details");
             rs.last();
             label_studNO.setText(Integer.toString(rs.getRow()));
             
             
             rs = st.executeQuery("select * from issue_details");
             rs.last();
             label_issuNO.setText(Integer.toString(rs.getRow()));
             
             
             rs = st.executeQuery("select * from issue_details where due_date < '"+today+"'");
             rs.last();
             label_defuCOunt.setText(Integer.toString(rs.getRow()));
             
         } catch (Exception e) {
         }
     }
    
//    public void showPieChart(){
//        
//        //create dataset
//      DefaultPieDataset barDataset = new DefaultPieDataset( );
//      
//      
//      barDataset.setValue( "IPhone 5s" , new Double( 20 ) );  
//      barDataset.setValue( "SamSung Grand" , new Double( 20 ) );   
//      barDataset.setValue( "MotoG" , new Double( 40 ) );    
//      barDataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
//      
//      //create chart
//       JFreeChart piechart = ChartFactory.createPieChart("mobile sales",barDataset, false,true,false);//explain
//      
//        PiePlot piePlot =(PiePlot) piechart.getPlot();
//      
//       //changing pie chart blocks colors
//       piePlot.setSectionPaint("IPhone 5s", new Color(255,255,102));
//        piePlot.setSectionPaint("SamSung Grand", new Color(102,255,102));
//        piePlot.setSectionPaint("MotoG", new Color(255,102,153));
//        piePlot.setSectionPaint("Nokia Lumia", new Color(0,204,204));
//      
//       
//        piePlot.setBackgroundPaint(Color.white);
//        
//        //create chartPanel to display chart(graph)
//        ChartPanel barChartPanel = new ChartPanel(piechart);
//        PanelPiechart.removeAll();
//        PanelPiechart.add(barChartPanel, BorderLayout.CENTER);
//        PanelPiechart.validate();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel26 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jPanel30 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        label_noBoks = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        label_studNO = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel33 = new javax.swing.JPanel();
        label_issuNO = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jPanel34 = new javax.swing.JPanel();
        label_defuCOunt = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_studDeta = new rojeru_san.complementos.RSTableMetro();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_bookdeta = new rojeru_san.complementos.RSTableMetro();
        jLabel24 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1132, 1100));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, -1, -1));

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 150, -1, -1));

        jPanel7.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, -1, -1));

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(51, 51, 51));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_26px.png"))); // NOI18N
        jLabel2.setText("  Manage Books");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 290, 60));

        jPanel10.setBackground(new java.awt.Color(239, 77, 77));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Home_26px_2.png"))); // NOI18N
        jLabel3.setText("   Home Page");
        jPanel10.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 160, 40));

        jPanel8.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 290, 60));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setText("Features");
        jPanel8.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 180, 40));

        jPanel11.setBackground(new java.awt.Color(102, 102, 255));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Exit_26px_2.png"))); // NOI18N
        jLabel12.setText("  Logout");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel11.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel15.setBackground(new java.awt.Color(51, 51, 51));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel20.setText("  LMS Dashboard");
        jPanel15.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel11.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 60));

        jPanel24.setBackground(new java.awt.Color(51, 51, 51));
        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel29.setText("  LMS Dashboard");
        jPanel24.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel25.setBackground(new java.awt.Color(51, 51, 51));
        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel30.setText("  LMS Dashboard");
        jPanel25.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel24.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 60));

        jPanel11.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 260, 60));

        jPanel8.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 290, 60));

        jPanel12.setBackground(new java.awt.Color(51, 51, 51));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(153, 153, 153));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel14.setText("  LMS Dashboard");
        jPanel12.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 180, 40));

        jPanel8.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 290, 60));

        jPanel13.setBackground(new java.awt.Color(51, 51, 51));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(153, 153, 153));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Read_Online_26px.png"))); // NOI18N
        jLabel18.setText("  Manage Students");
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel18MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel18MouseExited(evt);
            }
        });
        jPanel13.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, 40));

        jPanel8.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 290, 60));

        jPanel14.setBackground(new java.awt.Color(51, 51, 51));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(153, 153, 153));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_26px.png"))); // NOI18N
        jLabel19.setText("  Issue Book");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
        });
        jPanel14.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel8.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 290, 60));

        jPanel16.setBackground(new java.awt.Color(51, 51, 51));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(153, 153, 153));
        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Return_Purchase_26px.png"))); // NOI18N
        jLabel21.setText("  Return Book");
        jLabel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel21MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel21MouseExited(evt);
            }
        });
        jPanel16.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel17.setBackground(new java.awt.Color(51, 51, 51));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel22.setText("  LMS Dashboard");
        jPanel17.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 60));

        jPanel8.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 290, 60));

        jPanel22.setBackground(new java.awt.Color(51, 51, 51));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(153, 153, 153));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel27.setText("View Issued Books");
        jLabel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel27MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel27MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel27MouseExited(evt);
            }
        });
        jPanel22.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 190, 40));

        jPanel23.setBackground(new java.awt.Color(51, 51, 51));
        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel28.setText("  LMS Dashboard");
        jPanel23.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel22.add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 60));

        jPanel8.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, 290, 60));

        jPanel26.setBackground(new java.awt.Color(51, 51, 51));
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel31.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(153, 153, 153));
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Conference_26px.png"))); // NOI18N
        jLabel31.setText("  Defaulter List");
        jLabel31.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel31MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel31MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel31MouseExited(evt);
            }
        });
        jPanel26.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel27.setBackground(new java.awt.Color(51, 51, 51));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel32.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel32.setText("  LMS Dashboard");
        jPanel27.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel26.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 60));

        jPanel28.setBackground(new java.awt.Color(51, 51, 51));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel33.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel33.setText("  LMS Dashboard");
        jPanel28.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel29.setBackground(new java.awt.Color(51, 51, 51));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Library_26px_1.png"))); // NOI18N
        jLabel34.setText("  LMS Dashboard");
        jPanel29.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 180, 40));

        jPanel28.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 60));

        jPanel26.add(jPanel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 260, 60));

        jPanel8.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 540, 290, 60));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 290, 960));

        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel31.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        label_noBoks.setFont(new java.awt.Font("Segoe UI Black", 0, 40)); // NOI18N
        label_noBoks.setForeground(new java.awt.Color(102, 102, 102));
        label_noBoks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Book_Shelf_50px.png"))); // NOI18N
        label_noBoks.setText("10");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(label_noBoks)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_noBoks)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 210, 120));

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Students Detail");
        jPanel18.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jPanel32.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        label_studNO.setFont(new java.awt.Font("Segoe UI Black", 0, 40)); // NOI18N
        label_studNO.setForeground(new java.awt.Color(102, 102, 102));
        label_studNO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_People_50px.png"))); // NOI18N
        label_studNO.setText("10");

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(label_studNO)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_studNO)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 210, 120));

        jLabel10.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("No of Students");
        jPanel18.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, -1, -1));

        jPanel33.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(255, 51, 51)));

        label_issuNO.setFont(new java.awt.Font("Segoe UI Black", 0, 40)); // NOI18N
        label_issuNO.setForeground(new java.awt.Color(102, 102, 102));
        label_issuNO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_Sell_50px.png"))); // NOI18N
        label_issuNO.setText("10");

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(label_issuNO)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_issuNO)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 70, 210, 120));

        jLabel15.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Issued Books");
        jPanel18.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        jPanel34.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 0, 0, 0, new java.awt.Color(102, 102, 255)));

        label_defuCOunt.setFont(new java.awt.Font("Segoe UI Black", 0, 40)); // NOI18N
        label_defuCOunt.setForeground(new java.awt.Color(102, 102, 102));
        label_defuCOunt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_List_of_Thumbnails_50px.png"))); // NOI18N
        label_defuCOunt.setText("10");

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(label_defuCOunt)
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(label_defuCOunt)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel18.add(jPanel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 70, 210, 120));

        jLabel17.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Defaulter Count");
        jPanel18.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 30, -1, -1));

        tbl_studDeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", " Name", "Course", "Branch"
            }
        ));
        tbl_studDeta.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_studDeta.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_studDeta.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studDeta.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_studDeta.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        tbl_studDeta.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_studDeta.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        tbl_studDeta.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_studDeta.setRowHeight(30);
        jScrollPane1.setViewportView(tbl_studDeta);

        jPanel18.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 470, 330));

        jLabel23.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("No of Books");
        jPanel18.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        tbl_bookdeta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Book Id", " Name", "Author", "Quantity"
            }
        ));
        tbl_bookdeta.setColorBackgoundHead(new java.awt.Color(102, 102, 255));
        tbl_bookdeta.setColorBordeFilas(new java.awt.Color(102, 102, 255));
        tbl_bookdeta.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_bookdeta.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tbl_bookdeta.setFont(new java.awt.Font("Yu Gothic Light", 0, 24)); // NOI18N
        tbl_bookdeta.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 0, 18)); // NOI18N
        tbl_bookdeta.setFuenteFilasSelect(new java.awt.Font("Yu Gothic Light", 1, 20)); // NOI18N
        tbl_bookdeta.setFuenteHead(new java.awt.Font("Yu Gothic UI Semibold", 1, 20)); // NOI18N
        tbl_bookdeta.setRowHeight(30);
        jScrollPane2.setViewportView(tbl_bookdeta);

        jPanel18.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 550, 330));

        jLabel24.setFont(new java.awt.Font("Segoe UI Historic", 1, 20)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Books Details");
        jPanel18.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 130, -1));

        getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 1250, 770));

        jPanel1.setBackground(new java.awt.Color(229, 14, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/icons8_menu_48px_1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 40));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 5, 50));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/male_user_50px.png"))); // NOI18N
        jLabel5.setText("Welcome, Admin");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 10, 220, 50));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Library Management System");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1540, 70));

        setSize(new java.awt.Dimension(1553, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Managebooks books = new Managebooks();
        books.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
        jPanel9.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        // TODO add your handling code here:
        jPanel9.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel2MouseExited

    private void jLabel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseEntered
        // TODO add your handling code here:
        jPanel13.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel18MouseEntered

    private void jLabel18MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseExited
        // TODO add your handling code here:
        jPanel13.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel18MouseExited

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
         jPanel14.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        // TODO add your handling code here:
        jPanel14.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseEntered
        // TODO add your handling code here:
        jPanel16.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel21MouseEntered

    private void jLabel21MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseExited
        // TODO add your handling code here:
        jPanel16.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel21MouseExited

    private void jLabel27MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseEntered
        // TODO add your handling code here:
        jPanel22.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel27MouseEntered

    private void jLabel27MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseExited
        // TODO add your handling code here:
        jPanel22.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel27MouseExited

    private void jLabel31MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseEntered
        // TODO add your handling code here:
        jPanel26.setBackground(mouseEnterColor);
    }//GEN-LAST:event_jLabel31MouseEntered

    private void jLabel31MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseExited
        // TODO add your handling code here:
        jPanel26.setBackground(mouseExitColor);
    }//GEN-LAST:event_jLabel31MouseExited

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        // TODO add your handling code here:
          ManageStudent student = new ManageStudent();
        student.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        // TODO add your handling code here:
        IssueBook issue  = new IssueBook();
        issue.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel21MouseClicked
        // TODO add your handling code here:
        
        ReturnBook rbook = new ReturnBook();
        rbook.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel21MouseClicked

    private void jLabel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel27MouseClicked
        // TODO add your handling code here:

        ViewRecord view = new ViewRecord();
        view.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel27MouseClicked

    private void jLabel31MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel31MouseClicked
        // TODO add your handling code here:
        
        DefaulterList li = new DefaulterList();
        li.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel31MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
           MainPage main = new MainPage();
        main.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label_defuCOunt;
    private javax.swing.JLabel label_issuNO;
    private javax.swing.JLabel label_noBoks;
    private javax.swing.JLabel label_studNO;
    private rojeru_san.complementos.RSTableMetro tbl_bookdeta;
    private rojeru_san.complementos.RSTableMetro tbl_studDeta;
    // End of variables declaration//GEN-END:variables
}
