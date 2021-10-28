import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
//import javax.swing.Timer;

public class NewJFrame extends javax.swing.JFrame {
    
    /**
     * Creates new form NewJFrame
     */
    private Dimension size;
    private String code = "";
    private int width, height;
    private String imgURL = "D:\\NetBeans Projects\\VerificadorPreciosJava\\VerificadorDePrecios\\src\\img\\";
    private int sec = 0;
    private DBConnection conn;
    private Timer timer;
    private ResultSet rs;
    
    public NewJFrame() {
        this.getContentPane().setBackground(new Color(192,255,192));
        
        initComponents();
        
        size = Toolkit. getDefaultToolkit(). getScreenSize();
        
        width = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
        height = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
        
        this.setSize(width, height);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        
        
        icon.setSize(100, 100);
        icon.setText("<html><img src='file:" + imgURL + "Icon-Placeholder-1.png' width='100' height='100'>");
        icon.setLocation(this.getWidth()/2-icon.getWidth()/2, this.getHeight()/4 - icon.getHeight() );
        image.setSize(200, 200);
        image.setText("<html><img src='file:" + imgURL + "barcode-scan2.gif' width='200' height='200'>");
        image.setLocation(this.getWidth()/2-image.getWidth()/2, this.getHeight()/2 - image.getHeight()/2 );
        
        text.setFont(new java.awt.Font("Times New Roman", 1, 24));
        text.setText("Por favor pase el código de barra debajo del escaner");
        text.setLocation(this.getWidth()/2 - text.getWidth()/2, this.getHeight()/4*3 + text.getHeight());
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        text = new javax.swing.JLabel();
        icon = new javax.swing.JLabel();
        image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(192, 255, 192));
        setUndecorated(true);
        setSize(Toolkit. getDefaultToolkit(). getScreenSize().width, Toolkit. getDefaultToolkit(). getScreenSize().height);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        text.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        text.setText("Linea de texto 1");

        icon.setText("jLabel3");
        icon.setPreferredSize(new java.awt.Dimension(305, 165));

        image.setText("jLabel4");
        image.setPreferredSize(new java.awt.Dimension(120, 120));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(text, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(352, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(text)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(icon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed

        if (evt.getKeyCode()!= 10) {
            code += evt.getKeyChar();
        }
        else{
            try{
                conn = new DBConnection();
                String query = "SELECT producto_codigo, producto_nombre, producto_precio, producto_cantidad_disponible, producto_imagen "
                        + "FROM productos WHERE producto_codigo = " + code;
                rs = conn.ExeccuteResultSet(query);

                if (rs.next()) {
                    SetLayout(2);
                    TimePause(4,3000,3000);
                    TimePause(1,8000,8000);
                }else{
                    SetLayout(3);
                    TimePause(1, 3000,3000);
                }
                
                //JOptionPane.showMessageDialog(null, "SELECT * FROM productos WHERE producto_codigo = "+codigo);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error"+e.toString());
                
            }catch(Exception e){
                
            }
            code = "";
        }
    }//GEN-LAST:event_formKeyPressed

    public void SetLayout(int action) throws SQLException, MalformedURLException{
        switch (action) {
            case 1: //Start window
                this.getContentPane().setBackground(new Color(192,255,192));
                icon.setSize(100, 100);
                icon.setText("<html><img src='file:" + imgURL + "Icon-Placeholder-1.png' width='100' height='100'>");
                icon.setLocation(this.getWidth() / 2 - icon.getWidth() / 2, this.getHeight() / 4 - icon.getHeight());
                image.setSize(200, 200);
                image.setIcon(null);
                image.setText("<html><img src='file:" + imgURL + "barcode-scan2.gif' width='200' height='200'>");
                image.setLocation(this.getWidth() / 2 - image.getWidth() / 2, this.getHeight() / 2 - image.getHeight() / 2);

                text.setSize(560, 30);
                text.setFont(new java.awt.Font("Times New Roman", 1, 24));
                text.setText("Por favor pase el código de barra debajo del escaner");
                text.setLocation(this.getWidth() / 2 - text.getWidth() / 2, this.getHeight() / 4 * 3 + text.getHeight());
                break;
            case 2: //Loading window
                this.getContentPane().setBackground(new Color(192,255,192));
                text.setSize(400,50);
                text.setText("Cargando la información del producto");
                text.setLocation(this.getWidth() / 2 - text.getWidth() / 2, this.getHeight() / 2 - text.getHeight());
                image.setIcon(null);
                image.setSize(150, 150);
                image.setText("<html><center><img src='file:" + imgURL + "loading-56.gif' width='150' height='150'></center>");
                image.setLocation(this.getWidth() / 2 - image.getWidth() / 2, this.getHeight() / 2 + image.getHeight() / 4);
                break;
            case 3: //Error window
                this.getContentPane().setBackground(new Color(255,192,192));
                text.setSize(250,50);
                text.setText("Producto no encontrado");
                text.setLocation(this.getWidth() / 2 - text.getWidth() / 2, this.getHeight() / 2 - text.getHeight());
                image.setText("");
                image.setIcon(null);
                image.setSize(150, 150);
                image.setText("<html><center><img src='file:" + imgURL + "error.png' width='150' height='150'></center>");
                image.setLocation(this.getWidth() / 2 - image.getWidth() / 2, this.getHeight() / 2 + image.getHeight() / 4);
                break;
            case 4: //result window
                this.getContentPane().setBackground(new Color(192,255,192));
                text.setText("<html>" + rs.getString(2) + "<br><br>"
                        + "<center>$" + rs.getString(3) + "</center>"
                        + "<br><center>Stock: " + rs.getString(4) + "</center><br>"
                        + "<center><img src='file:" + imgURL + "barcode.png' width='130' height='80'></center>"
                        + "<h4>" + rs.getString(1) + "</h4>");
                text.setSize(250, 300);
                text.setLocation(this.getWidth() / 4 * 3 - text.getWidth() / 2, this.getHeight() / 4);
                image.setSize(250, 250);
                image.setText("");
                image.setIcon(new ImageIcon(new ImageIcon(new URL(rs.getString(5))).getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT)));
                image.setLocation(this.getWidth()/4 - image.getWidth()/2, this.getHeight()/4 + 20);
                break;

        }
    }
    
    public void TimePause(int task, int Ptime, int Rtime) {
        Timer t = new Timer();
        t.schedule(new TimerTask(){
            @Override
            public void run(){
                try {
                    SetLayout(task);
                } catch (SQLException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                t.cancel();
                t.purge();
            }
        }, Ptime, Rtime);
    }
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel icon;
    private javax.swing.JLabel image;
    private javax.swing.JLabel text;
    // End of variables declaration//GEN-END:variables
}
