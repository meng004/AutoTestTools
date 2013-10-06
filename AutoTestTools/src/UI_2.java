import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author root
 */
@SuppressWarnings("serial")
public class UI_2 extends javax.swing.JFrame {
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    
    // End of variables declaration//GEN-END:variables
    /**
     * Creates new form UI_2
     */
    public UI_2() {
        initComponents();
    }   


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 236, Short.MAX_VALUE)
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "NAME", "Origin Value", "Post   Value"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTabbedPane1.addTab("Watch And Set", jScrollPane1);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
					jButton1ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
            }
        });    
        
        jButton2.setText("CANCLE");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
        

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //--------------------------------���� ��OK�� ����������������������������---------------------------------------
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {//GEN-FIRST:event_jButton2ActionPerformed 
    	//��������
		ArrayList<Parameters> paramArray = new ArrayList<Parameters>();	
		ArrayList<GlobeVariable> globeArray = new ArrayList<GlobeVariable>();	
		 
		//����
		String funcName = "func1"; 
		//String returnTypeText = "real";
		 
		//��������
		String paramName = "time";
		String paramType = "real";
		String paramValue = "10.0";
		Parameters paramObject = new Parameters(paramName, paramType, paramValue);
		paramArray.add(paramObject);
		
		//������������
		String Name = "gravity";
		String Type = "GVAR";
		String Value = "9.8";
		GlobeVariable globeVariableObject = new GlobeVariable(Name, Type, Value);
		globeArray.add(globeVariableObject);
		 
		//������������
		InvokeFunction ifunc = new InvokeFunction(funcName, paramArray, globeArray);
		try {
			ifunc.writeFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		//����������
//		InvokeSubroutine isub = new InvokeSubroutine(funcName, paramArray, globeArray);
//		try {
//			isub.writeFile();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
			
		
		//----------------------gcc   compile   and   run   FortranCode------------------------

		//execute command1
		Runtime.getRuntime().exec("g77   forexam.f   invoke.f   -o   exec");
		try {    
			//sleep  500ms ,because file execute is not created
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		//execute command2
		Runtime.getRuntime().exec("./exec");		
    }
}
