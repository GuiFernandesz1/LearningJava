import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class TelaDeCadastro extends JFrame {
    public final JLabel lblNome;
    public final JTextField txtNome;
    public final JLabel lblEmail;
    public final JTextField txtEmail;
    public final JLabel lblSenha;
    public final JPasswordField txtSenha;
    public final JButton btnCadastrar;
    public final JButton btnCancelar;
    public final JLabel lblNotificacoes;

    public TelaDeCadastro() {
        super("Tela de Cadastro");
        setLayout(new GridLayout(5,1,5,5));

        JPanel linhaNome = new JPanel(new GridLayout(1,2));
        
        lblNome = new JLabel("Nome:");
        txtNome = new JTextField(10);
        
        linhaNome.add(lblNome);
        linhaNome.add(txtNome);
        
        add(linhaNome);

        JPanel linhaEmail = new JPanel(new GridLayout(1,2));

        lblEmail = new JLabel("E-mail:");
        txtEmail = new JTextField(10);

        linhaEmail.add(lblEmail);
        linhaEmail.add(txtEmail);

        add(linhaEmail);

        JPanel linhaSenha = new JPanel(new GridLayout(1,2));

        lblSenha = new JLabel("Senha:");
        txtSenha = new JPasswordField(10);

        linhaSenha.add(lblSenha);
        linhaSenha.add(txtSenha);

        add(linhaSenha);

        JPanel linhaBotoes = new JPanel(new GridLayout(1,2));

        btnCadastrar = new JButton("Cadastrar");
        btnCancelar = new JButton("Cancelar");

        linhaBotoes.add(btnCadastrar);
        linhaBotoes.add(btnCancelar);

        add(linhaBotoes);

        JPanel linhaNotificacoes = new JPanel(new GridLayout(1,1));

        lblNotificacoes = new JLabel("Notificações", SwingConstants.CENTER);

        linhaNotificacoes.add(lblNotificacoes);

        add(linhaNotificacoes);

        btnCadastrar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    if (txtNome.getText().trim().length() == 0) {
                        lblNotificacoes.setText("Campo 'Nome' não pode ficar em branco.");
                        txtNome.requestFocus();
                        return;
                    }
                    if (txtEmail.getText().trim().length() == 0) {
                        lblNotificacoes.setText("Campo 'E-mail' não pode ficar em branco.");
                        txtEmail.requestFocus();
                        return;
                    }
                    if (String.valueOf(txtSenha.getPassword()).trim().length() == 0) {
                        lblNotificacoes.setText("Campo 'Senha' não pode ficar em branco.");
                        txtSenha.requestFocus();
                        return;
                    }

                    String strSqlCadastrar = "insert into `db_senac`.`tbl_senac` (`nome`, `email`, `senha`) values ('" + txtNome.getText() + "'','" + txtEmail.getText() 
                    + "','" + String.valueOf(txtSenha.getPassword()) + "');";
                    try{
                        Connection conexao = MySQLConnector.conectar();
                        Statement stmSqlCadastrar = conexao.createStatement();
                        stmSqlCadastrar.addBatch(strSqlCadastrar);
                        stmSqlCadastrar.executeBatch();
                        lblNotificacoes.setText("Cadastro realizado com sucesso! \n Por favor realize seu login.");
                    } catch (Exception e){
                        lblNotificacoes.setText("Erro de conexão, tente novamente mais tarde!");
                        System.err.println("Erro: " + e);
                    }
                }
            }
        );

        btnCancelar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    txtNome.setText("");
                    txtEmail.setText("");
                    txtSenha.setText("");
                    if (JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?") == 0) {
                        System.exit(0);
                    } else {
                        txtNome.requestFocus();
                    }
                }
            }
        );

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        TelaDeCadastro appTelaDeCadastro = new TelaDeCadastro();
        appTelaDeCadastro.setDefaultCloseOperation(EXIT_ON_CLOSE);;
    }
}