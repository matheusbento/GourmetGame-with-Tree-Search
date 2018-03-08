package view;

import javax.swing.JOptionPane;
import model.Refeicao;

/**
 *
 * @author MatheusBento
 */
public class Principal extends javax.swing.JFrame {
    
    private final Refeicao Lasanha = new Refeicao("Massa");
    private final Refeicao Lasanha2 = new Refeicao("Lasanha");
    private final Refeicao Doce = new Refeicao("Doce");
    private final Refeicao Doce2 = new Refeicao("Bolo de Chocolate");
    
    private Refeicao Atual = null;
    
    
    //variaveis globais
    private int Resposta;

    public Principal() {        
        initComponents();
                      
        /*Adicionando os pratos iniciais do jogo*/
        
        this.Lasanha.setSim(this.Lasanha2);
        this.Doce.setSim(this.Doce2);
        this.Lasanha.setNao(this.Doce);
        this.Atual = this.Lasanha;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jBtOk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Jogo Gourmet");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Pense em um prato que você gosta");

        jBtOk.setText("INICIAR");
        jBtOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtOkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(jBtOk, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtOk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtOkActionPerformed
        /*Ocultando a view principal*/
        this.setVisible(false);
        
        /*Iniciando o jogo*/
        IniciarJogo();
        
        /*Mostrando a view principal novamente*/
        this.setVisible(true);
    }//GEN-LAST:event_jBtOkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String ... args) {
        /*Instânciando a view e mostrando-a*/
        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtOk;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

    /*Método responsável por iniciar o jogo*/
    private void IniciarJogo() {    
            this.Resposta = perguntarRefeicao();
            /*Caso o usuário clique sim*/
            if (this.Resposta == JOptionPane.YES_OPTION) {
               escolhaSim();
            }else{
                escolhaNao();
            }
    }
    private void escolhaSim(){
        // Se clicar sim e não pssuir mais objeto no Nó sim.
        if(this.Resposta == JOptionPane.YES_OPTION && this.Atual.getSim()==null){
            // chama a opção sim
            acertei();
            // Se não
        }else{
            // Atual recebe SIM
            this.Atual = this.Atual.getSim();
            this.Resposta = perguntarRefeicao();
            
            // Se sim
            if (this.Resposta == JOptionPane.YES_OPTION) {
               acertei();
            // Se não
            }else{
                
                escolhaNao();
            }
        }
    }
    private void escolhaNao(){
        // Se a opção não, possuir Objeto, atual recebe o objeto Não.
        if(this.Atual.getNao() != null){
            this.Atual = this.Atual.getNao();
            IniciarJogo();
        // Se não, cria refeição.
        }else{
            this.Atual.setNao(criarRefeicao());
            this.Atual = this.Lasanha;
        }
    
    }
    
 
    /*Método que apresenta a mensagem de acertei*/
    private void acertei() {
        
        JOptionPane.showMessageDialog(rootPane, "Acertei de novo!", "Acertei", JOptionPane.INFORMATION_MESSAGE);
        this.Atual = this.Lasanha;
    }
    
    /*Método responsável por perguntar sobre o prato*/
    private int perguntarRefeicao() {
        // Teste para ver ramificações da arvore
        //System.out.println("Atual -> ".concat(atual.getDescricao()).concat(" -> "));
        //if(atual.getSim()!= null)
        //System.out.println("ZIM -> ".concat(atual.getSim().getDescricao()).concat(" -> "));
        //if(atual.getNao()!= null)
        //System.out.println("NAO -> ".concat(atual.getNao().getDescricao()).concat(" | "));
        return JOptionPane.showConfirmDialog(rootPane, "O prato que pensou é ".concat(this.Atual.getDescricao()).concat(" ?"), "Hmm...", JOptionPane.YES_NO_OPTION);
        
    }
    
    /*Método responsável por criar objeto da refeicao*/
    private Refeicao criarRefeicao() {
        String descricaoPrato = JOptionPane.showInputDialog(rootPane, "Qual prato você pensou ?", "Desisto.. Então me diga..", JOptionPane.QUESTION_MESSAGE);
        while("".equals(descricaoPrato)){
            JOptionPane.showMessageDialog(rootPane, "Descrição vazia!", "Sua descrição está vazia!.", JOptionPane.INFORMATION_MESSAGE);
            descricaoPrato = JOptionPane.showInputDialog(rootPane, "Qual prato você pensou ?", "Desisto.. Então me diga..", JOptionPane.QUESTION_MESSAGE);
        }
        Refeicao refeicao2 = new Refeicao(descricaoPrato);
        String caracteristicaPrato = JOptionPane.showInputDialog(rootPane, descricaoPrato.concat(" é ________ mas ").concat(Atual.getDescricao()).concat(" não."), "Complete", JOptionPane.QUESTION_MESSAGE);
        while("".equals(caracteristicaPrato)){
            JOptionPane.showMessageDialog(rootPane, "Caracteristica vazia!", "Sua caracteristica está vazia!.", JOptionPane.INFORMATION_MESSAGE);
            caracteristicaPrato = JOptionPane.showInputDialog(rootPane, descricaoPrato.concat(" é ________ mas ").concat(Atual.getDescricao()).concat(" não."), "Complete", JOptionPane.QUESTION_MESSAGE);
        }
        Refeicao refeicao = new Refeicao(caracteristicaPrato);
        refeicao.setSim(refeicao2);
                
        return refeicao;        
    }
}
