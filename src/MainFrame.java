/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 *
 * @author haoda
 */

public class MainFrame extends javax.swing.JFrame {
    RLabel [] [] mainGrid; //Creates a new array of JLabels
    
    //Creates an array of strings to identify what's on each grid
    public String [] [] gridId;
    String idMemory;
    public boolean turnBlack = true;
    
    //These variables are universally used
    public int currentRow;
    public int currentCol;
    
    
    /**LEGEND
     * o = empty
     * b = black
     * w = white
    */
    
    //Creates new form MainFrame
    public MainFrame() {
        
        initComponents();
        turnBlack = true;
        //Grid Variables
        mainGrid = new RLabel [8][8];
        panelBoard.setLayout(new GridLayout (8,8,0,0));
        gridId = new String [8][8];
        
        //SETTING UP THE GRID
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                mainGrid[row][col] = new RLabel(""); //Adds text to the label
                mainGrid[row][col].row = row;
                mainGrid[row][col].column = col;
                mainGrid[row][col].setPreferredSize(new Dimension(30, 30)); //Sets the label size
                mainGrid[row][col].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);//Sets word allignment
                
                mainGrid[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/tileEmpty.png")));
                
                panelBoard.add(mainGrid[row][col]); //Adds the label to the panel
                
                mainGrid[row][col].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                        RLabel labelClicked = (RLabel)e.getSource();
                        System.out.println("You clicked on " + labelClicked.row + " col " + labelClicked.column);
                    }
                    public void mouseEntered(MouseEvent e){
                        
                    }
                    public void mouseExited(MouseEvent e){
                        
                    }
                });
            }
        }
        //GRID : 0,1,2,3,4,5,6,7
        
        //NOTE THIS IS FOR DEBUGGING PURPOSES
        //panelBoard.addMouseListener(new MouseAdapter(){
        //    public void mousePressed(MouseEvent e){
        //        System.out.println("You've pressed something in the panel.");
        //    }
        //});
        
        /* OLD VERSION
        //Adds a mouse listener for every label 
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                currentRow = row;
                currentCol = col;
                mainGrid[row][col].addMouseListener(new MouseAdapter(){
                    public void mousePressed(MouseEvent e){
                        System.out.println("You clicked on" + currentRow + "," + currentCol);
                    }
                    public void mouseEntered(MouseEvent e){
                        
                    }
                    public void mouseExited(MouseEvent e){
                        
                    }
                });
                
            }
        }
        */ 
        
        //It's an old program
        //NEW TEST LISTENER METHOD
        //Nicknamed "THE REALLY INEFFICIENT AND ANNOYINGLY LONG ALGORITHM"
        panelBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e){
                int rowY = panelBoard.getY(); 
                int colX = panelBoard.getX(); //Gets the coordinates of the panel
                int row = -1;
                int col = -1; 
                
                //Debugging
                System.out.println("Y Coordinate: " + panelBoard.getY());
                
                //BEGIN ANNOYINGLY LONG PART
                if (rowY < 30){
                    row = 0;
                }
                else if (rowY < 60){
                    row = 1;
                }
                else if (rowY < 90){
                    row = 2;
                }
                else if (rowY < 120){
                    row = 3;
                }
                else if (rowY < 150){
                    row = 4;
                }
                else if (rowY < 180){
                    row = 5;
                }
                else if (rowY < 210){
                    row = 6;
                }
                else if (rowY < 240){
                    row = 7;
                }
                else{
                    System.out.println("ERROR");
                }
                
                System.out.println("You clicked on" + row + "," + col);
            }
        
        });
        
    }
    
    //Method name: NewGame
    //What the method does: Resets the board 
    private void NewGame(){
        turnBlack = true; //Turn black is true
        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); //Sets the image to black
        
        //SETS UP THE BOARD
        for (int row = 0; row < 8; row++){
            for (int col = 0; col < 8; col++){
                if (row == 3 && col == 3){
                    //SETS TO BLACK
                    mainGrid[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/tileBlack.png")));
                    gridId[row][col] = "b";
                }
                else if (row == 4 && col == 3){
                    //SETS TO WHITE
                    mainGrid[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/tileWhite.png")));
                    gridId[row][col] = "w";
                }
                else if (row == 3 && col == 4){
                    //SETS TO WHITE
                    mainGrid[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/tileWhite.png")));
                    gridId[row][col] = "w";
                }
                else if (row == 4 && col == 4){
                    //SETS TO BLACK
                    mainGrid[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/tileBlack.png")));
                    gridId[row][col] = "b";
                }
                else {
                    //SETS TO EMPTY
                    mainGrid[row][col].setIcon(new javax.swing.ImageIcon(getClass().getResource("/tileEmpty.png")));
                    gridId[row][col] = "o";
                }
            }
        }
        
        
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelBoard = new javax.swing.JPanel();
        btnNewGame = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        lblTurn = new javax.swing.JLabel();
        lblImage = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(224, 216, 116));
        setResizable(false);

        panelBoard.setBackground(new java.awt.Color(224, 216, 116));
        panelBoard.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panelBoard.setMinimumSize(new java.awt.Dimension(240, 240));

        javax.swing.GroupLayout panelBoardLayout = new javax.swing.GroupLayout(panelBoard);
        panelBoard.setLayout(panelBoardLayout);
        panelBoardLayout.setHorizontalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );
        panelBoardLayout.setVerticalGroup(
            panelBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 240, Short.MAX_VALUE)
        );

        btnNewGame.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        btnNewGame.setText("New Game");
        btnNewGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewGameActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Traditional Arabic", 0, 36)); // NOI18N
        lblTitle.setText("REVERSO - by Haoda Fan");

        lblTurn.setFont(new java.awt.Font("Traditional Arabic", 0, 18)); // NOI18N
        lblTurn.setText("BLACK's turn");

        lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/black.png"))); // NOI18N
        lblImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImageMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblImageMouseEntered(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTitle)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNewGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTurn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImage, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTurn)
                        .addGap(18, 18, 18)
                        .addComponent(btnNewGame, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // MAKING BUTTONS OUT OF EVERY LABEL
    
    
    
    
    private void btnNewGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewGameActionPerformed
        NewGame();
    }//GEN-LAST:event_btnNewGameActionPerformed

    
    
    
    
    // ------------- THESE ARE FOR THE SAKE OF EXAMPLES ---------------
    private void lblImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseClicked
        System.out.println("I'm definitely a pebble.");
    }//GEN-LAST:event_lblImageMouseClicked

    private void lblImageMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImageMouseEntered
        System.out.println("What am I?");
    }//GEN-LAST:event_lblImageMouseEntered
    // ---------------------------------------------------------------
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNewGame;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblImage;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTurn;
    private javax.swing.JPanel panelBoard;
    // End of variables declaration//GEN-END:variables
}
