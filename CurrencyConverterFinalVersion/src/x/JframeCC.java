package x;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;

public class JframeCC extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField jtxtAmount;
	private JTextField jtxtConversion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JframeCC frame = new JframeCC();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JframeCC() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 619);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel.setBounds(10, 11, 961, 91);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Currency Converter");
		lblNewLabel.setBounds(242, 9, 609, 70);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 60));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_1.setBounds(10, 121, 720, 291);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Amount");
		lblNewLabel_1.setBounds(31, 37, 165, 35);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("From Currency");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(31, 141, 301, 35);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("To Currency");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lblNewLabel_1_2.setBounds(31, 228, 267, 35);
		panel_1.add(lblNewLabel_1_2);
		
		JComboBox jcFromCurrency = new JComboBox();
		jcFromCurrency.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		jcFromCurrency.setModel(new DefaultComboBoxModel(new String[] {"GBP - Britain ", "PKR - Pakistani Rupee", "CAD - Canadian ", "EUR - Euro", "USD - United States Dollar", "NGN - Nigerian Nara", "CHF - Swiss Franc", "AUD - Australian Dollar", "CNY - Chinese Yen", "MXN - Mexican Peso"}));
		jcFromCurrency.setBounds(333, 133, 357, 43);
		panel_1.add(jcFromCurrency);
		
		JComboBox jcToCurrency = new JComboBox();
		jcToCurrency.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		jcToCurrency.setModel(new DefaultComboBoxModel(new String[] {"GBP - Britain ", "PKR - Pakistani Rupee", "CAD - Canadian ", "EUR - Euro", "USD - United States Dollar", "NGN - Nigerian Nara", "CHF - Swiss Franc", "AUD - Australian Dollar", "CNY - Chinese Yen", "MXN - Mexican Peso"}));
		jcToCurrency.setBounds(333, 228, 357, 43);
		panel_1.add(jcToCurrency);
		
		jtxtAmount = new JTextField();
		jtxtAmount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		jtxtAmount.setBounds(198, 37, 492, 47);
		panel_1.add(jtxtAmount);
		jtxtAmount.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_2.setBounds(10, 433, 720, 107);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_3 = new JLabel("Conversion");
		lblNewLabel_1_3.setBounds(23, 29, 194, 47);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 40));
		panel_2.add(lblNewLabel_1_3);
		
		jtxtConversion = new JTextField();
		jtxtConversion.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		jtxtConversion.setColumns(10);
		jtxtConversion.setBounds(241, 29, 448, 47);
		panel_2.add(jtxtConversion);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		panel_3.setBounds(740, 121, 231, 419);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double amount, convertAmount;
				String fromCurrency, toCurrency;
				
				try {
					amount = Double.parseDouble(jtxtAmount.getText());
				}catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Enter A Valid Number", "Exclamation", JOptionPane.ERROR_MESSAGE);
					jtxtAmount.setText("");
					jtxtAmount.requestFocus();
					return;
				}
				
				fromCurrency = jcFromCurrency.getSelectedItem().toString().substring(0, 3);
				toCurrency = jcToCurrency.getSelectedItem().toString().substring(0, 3);

				convertAmount = currencyFunction(amount, fromCurrency, toCurrency);
				
				jtxtConversion.setText(String.format("%.2f %s = %.2f %s", amount, fromCurrency, convertAmount, toCurrency));
				
			
			}
		});
		btnConvert.setBounds(47, 41, 151, 67);
		btnConvert.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_3.add(btnConvert);
	
		
		JButton btnNewButton_1_1 = new JButton("Exit");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			private JFrame frame;
			public void actionPerformed(ActionEvent e) {
				frame = new JFrame("Exit"); 
				if(JOptionPane.showConfirmDialog(frame, "Confirm If You Want To Exit" , "Currency Converter", 
						JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) /*option panel will give us options and we look
				for the one we need, then we change it to the frame, the next parameter is a message for the user, and the next one is the title*/{
					System.exit(0);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnNewButton_1_1.setBounds(47, 326, 151, 67);
		panel_3.add(btnNewButton_1_1);
		
		JButton btnRestart = new JButton("Restart");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtxtAmount.setText("");
				jtxtConversion.setText("");
				jcFromCurrency.setSelectedIndex(-1);
				jcToCurrency.setSelectedIndex(-1);
			}
		});
		btnRestart.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnRestart.setBounds(47, 182, 151, 67);
		panel_3.add(btnRestart);
	}
	public double currencyFunction(double Amount, String fromCurrency, String toCurrency) {
		Map<String, Double> conversionRate = new HashMap<>(); //map is a string and a double, the name of the variable is "conversionRate"
		
		conversionRate.put("GBP", 1.0);
		conversionRate.put("PKR", 360.50);
		conversionRate.put("CAD", 1.79);
		conversionRate.put("EUR", 1.20);
		conversionRate.put("USD", 1.30);
		conversionRate.put("NGN", 2127.74);
		conversionRate.put("CHF", 1.12);
		conversionRate.put("AUD", 1.95);
		conversionRate.put("CNY", 9.23);
		conversionRate.put("MXN", 25.95);
		
		//if statement for invalid input
		
		if(!conversionRate.containsKey(fromCurrency)||!conversionRate.containsKey(toCurrency)) {
			throw new IllegalArgumentException("Invalid Currency");
		}
		return Amount * conversionRate.get(fromCurrency) * conversionRate.get(toCurrency);
	}  
}
