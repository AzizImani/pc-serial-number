package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import kernel.Hardware4Win;
import kernel.MD5;
import kernel.SHA1;

import javax.swing.JComboBox;

public class SnUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txfSN;
	private JButton crypterBtn;
	private JPanel panel;
	private JLabel lblHash;
	private JTextField txfResult;
	private JLabel lblPrefix;
	private JTextField txfPrefix;
	private JLabel lblSuffix;
	private JTextField txfSuffix;
	private JLabel lblAlgorithme;
	private JComboBox<String> cbxAlgo;

	/**
	 * Create the frame.
	 */
	public SnUi() {
		super("Serial number");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(422, 234);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		JLabel lblSN = new JLabel("Pc Serial number");
		contentPane.add(lblSN);

		txfSN = new JTextField();
		txfSN.setText(Hardware4Win.getSerialNumber());
		contentPane.add(txfSN);
		txfSN.setColumns(10);

		lblPrefix = new JLabel("Prefix");
		contentPane.add(lblPrefix);

		txfPrefix = new JTextField();
		txfPrefix.setColumns(10);
		contentPane.add(txfPrefix);

		lblSuffix = new JLabel("Suffix");
		contentPane.add(lblSuffix);

		txfSuffix = new JTextField();
		txfSuffix.setColumns(10);
		contentPane.add(txfSuffix);

		lblAlgorithme = new JLabel("Algorithme ");
		contentPane.add(lblAlgorithme);

		cbxAlgo = new JComboBox<String>();
		cbxAlgo.addItem("MD5");
		cbxAlgo.addItem("SHA1");
		contentPane.add(cbxAlgo);

		lblHash = new JLabel("Empreinte num\u00E9rique");
		contentPane.add(lblHash);

		txfResult = new JTextField();
		txfResult.setColumns(10);
		contentPane.add(txfResult);

		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel);

		crypterBtn = new JButton("Crypter ");
		crypterBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String sn = txfSN.getText();
				String prefix = txfPrefix.getText();
				String suffix = txfSuffix.getText();
				String algo = (String) cbxAlgo.getSelectedItem();
				try {
					if (algo.equals("MD5")) {
						txfResult.setText(MD5.getEncodedString(prefix + sn + suffix));
					} else {
						txfResult.setText(SHA1.getEncodedString(prefix + sn + suffix));
					}
				} catch (NoSuchAlgorithmException e) {
					JOptionPane.showMessageDialog(SnUi.this, e.getMessage());
				}
			}
		});
		panel.add(crypterBtn);
	}

}
