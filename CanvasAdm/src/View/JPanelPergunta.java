/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author kji
 */
public class JPanelPergunta extends javax.swing.JPanel {

    private String myTip;
    private String myQuestion;
    private String myAnswer;
    /**
     * Creates new form JPanelPergunta
     */
    public JPanelPergunta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPanePergunta = new javax.swing.JScrollPane();
        jTextAreaPergunta = new javax.swing.JTextArea();
        jScrollPaneResposta = new javax.swing.JScrollPane();
        jTextAreaResposta = new javax.swing.JTextArea();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jScrollPanePergunta.setBorder(javax.swing.BorderFactory.createTitledBorder("Pergunta"));

        jTextAreaPergunta.setEditable(false);
        jTextAreaPergunta.setBackground(new java.awt.Color(240, 240, 240));
        jTextAreaPergunta.setColumns(20);
        jTextAreaPergunta.setLineWrap(true);
        jTextAreaPergunta.setRows(5);
        jTextAreaPergunta.setText(myQuestion);
        jTextAreaPergunta.setToolTipText(myTip);
        jTextAreaPergunta.setWrapStyleWord(true);
        jScrollPanePergunta.setViewportView(jTextAreaPergunta);

        jScrollPaneResposta.setBorder(javax.swing.BorderFactory.createTitledBorder("Resposta"));

        jTextAreaResposta.setColumns(20);
        jTextAreaResposta.setLineWrap(true);
        jTextAreaResposta.setRows(5);
        jTextAreaResposta.setText(myAnswer);
        jTextAreaResposta.setToolTipText(myTip);
        jTextAreaResposta.setWrapStyleWord(true);
        jScrollPaneResposta.setViewportView(jTextAreaResposta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneResposta, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPanePergunta, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addComponent(jScrollPaneResposta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jScrollPanePergunta, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(95, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPanePergunta;
    private javax.swing.JScrollPane jScrollPaneResposta;
    private javax.swing.JTextArea jTextAreaPergunta;
    private javax.swing.JTextArea jTextAreaResposta;
    // End of variables declaration//GEN-END:variables
}