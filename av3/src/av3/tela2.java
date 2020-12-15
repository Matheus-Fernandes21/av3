package av3;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import av3conexao.moduloconexao;





public class tela2 extends JFrame {
	
	
	private JPanel contentPane;
	private JTextField txtnome;
	private JTextField txtrua;
	private JTextField txtcpf;
	private JTextField txtcidade;
	private JLabel txtcodcarro;
	private JLabel lblNewLabel_9;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	
	
	
	
	
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tela2 frame = new tela2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public tela2() {
		
		conexao = moduloconexao.conector();
		//status abaixo
		System.out.println(conexao);
	}
		
		private void consulta() {
			String sql = "select * from dbo.CARRO where cod_carro=?";
		try {
			pst=conexao.prepareStatement(sql);
			pst.setString(1, txtcpf.getText());
			rs=pst.executeQuery();
			if(rs.next()) {
			txtnome.setText(rs.getString(2));
			txtcidade.setText(rs.getString(3));
			txtrua.setText(rs.getString(4));
			}else {
				JOptionPane.showMessageDialog(null,"Carro nao cadastrado");
				txtnome.setText(null);
				txtcidade.setText(null);
				txtrua.setText(null);
			}
		
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		}
		
		private void adicionar(){
			String sql = "insert into dbo.CARRO(cod_carro,nome_carro,ano,cor)values(?,?,?,?)";
		try {
			pst=conexao.prepareStatement(sql);
			pst.setString(1,txtcpf.getText());
			pst.setString(2,txtnome.getText());
			pst.setString(3,txtcidade.getText());
			pst.setString(4,txtrua.getText());
			
			if((((txtnome.getText().isEmpty())||txtcpf.getText().isEmpty())||txtcidade.getText().isEmpty())||txtrua.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Todos os campos sao obrigatorios");
					
			}else {		
				
				
			
			int adicionado =pst.executeUpdate();
			System.out.println(adicionado);
			if (adicionado >0) {
				JOptionPane.showMessageDialog(null,"Carro cadastrado com sucesso");
				txtcpf.setText(null);
				txtnome.setText(null);
				txtcidade.setText(null);
				txtrua.setText(null);
				
			}
		
			}
		
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		
		}
		}
		private void alterar(){
			String sql="update dbo.CARRO set nome_carro=?,ano=?,cor=? where cod_carro=?";
		
		try {
			pst=conexao.prepareStatement(sql);
			pst.setString(1,txtnome.getText());
			pst.setString(2,txtcidade.getText());
			pst.setString(3,txtrua.getText());
			pst.setString(4,txtcpf.getText());
			
			
			
			if((((txtnome.getText().isEmpty())||txtcpf.getText().isEmpty())||txtcidade.getText().isEmpty())||txtrua.getText().isEmpty()){
				JOptionPane.showMessageDialog(null,"Todos os campos sao obrigatorios");
					
			}else {		
				
				
			
			int adicionado =pst.executeUpdate();
			System.out.println(adicionado);
			if (adicionado >0) {
				JOptionPane.showMessageDialog(null,"Dados alterados com sucesso");
				txtcpf.setText(null);
				txtnome.setText(null);
				txtcidade.setText(null);
				txtrua.setText(null);
				
			}
		
			}
			
			
		
		
		}catch(Exception e) {
		JOptionPane.showMessageDialog(null, e);
		}
		}
		
		private void remover(){
			
		int confirma=JOptionPane.showConfirmDialog(null, "Deseja mesmo excluir o cliente","atencao",JOptionPane.YES_NO_OPTION);
		if(confirma==JOptionPane.YES_OPTION) {
		String sql="delete from dbo.CARRO where cod_carro=?";
		try {
		pst=conexao.prepareStatement(sql);
		pst.setString(1, txtcpf.getText());
		int apagado=pst.executeUpdate();
		if(apagado>0) {
			
			JOptionPane.showMessageDialog(null, "carro removido com sucesso");
			txtcpf.setText(null);
			txtnome.setText(null);
			txtcidade.setText(null);
			txtrua.setText(null);
		}
			
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
			
			
			
			
			
			
		}
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 598, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 562, 307);
		contentPane.add(scrollPane);
		
		txtnome = new JTextField();
		txtnome.setBounds(10, 352, 171, 20);
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nome do carro");
		lblNewLabel_5.setBounds(10, 338, 87, 14);
		contentPane.add(lblNewLabel_5);
		
		txtrua = new JTextField();
		txtrua.setBounds(10, 383, 171, 20);
		contentPane.add(txtrua);
		txtrua.setColumns(10);
		
		JLabel lblendereco = new JLabel("ano");
		lblendereco.setBounds(10, 370, 105, 14);
		contentPane.add(lblendereco);
		
		txtcpf = new JTextField();
		txtcpf.setBounds(218, 352, 171, 20);
		contentPane.add(txtcpf);
		txtcpf.setColumns(10);
		
		txtcidade = new JTextField();
		txtcidade.setBounds(218, 383, 171, 20);
		contentPane.add(txtcidade);
		txtcidade.setColumns(10);
		
		txtcodcarro = new JLabel("Cod do carro");
		txtcodcarro.setBounds(218, 338, 87, 14);
		contentPane.add(txtcodcarro);
		
		lblNewLabel_9 = new JLabel("cor");
		lblNewLabel_9.setBounds(218, 370, 46, 14);
		contentPane.add(lblNewLabel_9);
		
		btnNewButton_3 = new JButton("Adicionar Carro");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				adicionar();
			}
		});
		btnNewButton_3.setBounds(439, 366, 133, 23);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Editar Carro");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			alterar();
			}
		});
		btnNewButton_4.setBounds(439, 396, 133, 23);
		contentPane.add(btnNewButton_4);
		
		JButton Consultarbd = new JButton("Consultar Carro");
		Consultarbd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			consulta();
			}
		});
		Consultarbd.setBounds(439, 335, 133, 20);
		contentPane.add(Consultarbd);
		
		JButton btnexcluir = new JButton("Excluir Carro");
		btnexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				remover();
			
			}
		});
		btnexcluir.setBounds(439, 423, 133, 20);
		contentPane.add(btnexcluir);
		
		
		JButton btnNewButton = new JButton("Cadastrar carro");
		btnNewButton.setBounds(415, 31, 144, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
		btnNewButton.setBounds(323, 37, 136, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Editar");
		btnNewButton_1.setBounds(483, 37, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
	}

});
	}
}
