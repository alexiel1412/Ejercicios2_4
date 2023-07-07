package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ejercicios2_4 extends JFrame implements CaretListener{

	private JPanel contentPane;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTextField txtNota3;
	private JTextField txtNombre;
	private JLabel lblPromRes;
	private JLabel lblResultRes;
	private JButton btnCalcular;
	private double prom = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejercicios2_4 frame = new Ejercicios2_4();
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
	public Ejercicios2_4() {
		setResizable(false);
		setTitle("Promedio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[31.00][59.00][65.00,grow][39.00,grow][61.00][grow][58.00][grow][38.00]", "[33.00][11.00][][25.00][13.00][][][][]"));
		
		JLabel lblTitulo = new JLabel("CALCULAR PROMEDIO");
		lblTitulo.setOpaque(true);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setBackground(Color.BLACK);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTitulo, "cell 1 0 7 1,grow");
		
		JLabel lblNombre = new JLabel("Nombre:");
		contentPane.add(lblNombre, "cell 1 2,alignx left");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 2 2 6 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNota1 = new JLabel("Nota 1:");
		contentPane.add(lblNota1, "cell 1 3,alignx left");
		
		txtNota1 = new JTextField();
		contentPane.add(txtNota1, "cell 2 3 2 1,growx");
		txtNota1.setColumns(10);
		
		JLabel lblNota2 = new JLabel("Nota 2:");
		contentPane.add(lblNota2, "cell 4 3,alignx left");
		
		txtNota2 = new JTextField();
		contentPane.add(txtNota2, "cell 5 3,growx");
		txtNota2.setColumns(10);
		
		JLabel lblNota3 = new JLabel("Nota 3:");
		contentPane.add(lblNota3, "cell 6 3,alignx left");
		
		txtNota3 = new JTextField();
		contentPane.add(txtNota3, "cell 7 3,growx");
		txtNota3.setColumns(10);
		
		btnCalcular = new JButton("Calcular");
		btnCalcular.setEnabled(false);
		btnCalcular.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				mostrarPromedio();
				mostrarResultado();
			}
		});
		contentPane.add(btnCalcular, "cell 6 5 2 1,alignx right");
		
		JLabel lblProm = new JLabel("Promedio:");
		lblProm.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblProm, "flowx,cell 1 7 2 1");
		
		JLabel lblResult = new JLabel("Resultado:");
		lblResult.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblResult, "flowx,cell 1 8 2 1");
		
		lblPromRes = new JLabel("0,0");
		lblPromRes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblPromRes, "cell 3 7,alignx left");
		
		lblResultRes = new JLabel("");
		lblResultRes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(lblResultRes, "cell 3 8 5 1,alignx left");

		txtNota1.addCaretListener(this);
		txtNota2.addCaretListener(this);
		txtNota3.addCaretListener(this);
		
		getRootPane().setDefaultButton(btnCalcular);
	}

	protected void mostrarPromedio()
	{
			prom = (Double.parseDouble(this.txtNota1.getText()) + Double.parseDouble(this.txtNota2.getText()) + Double.parseDouble(this.txtNota3.getText())) / 3;
			this.lblPromRes.setText(String.format("%.2f", prom));
	}

	protected void mostrarResultado()
	{
		if (prom >= 5)
			this.lblResultRes.setText("Ha aprobado la asignatura.");
		else
			this.lblResultRes.setText("Toca recuperar.");
	}

	@Override
	public void caretUpdate(CaretEvent e) {
		JTextField  txt = (JTextField)e.getSource();

		if (txt.getText()==null || txt.getText().isBlank())
			this.btnCalcular.setEnabled(false);
		else
		{
			if (! this.txtNota1.getText().isBlank() && ! this.txtNota2.getText().isBlank() && ! this.txtNota3.getText().isBlank())
			this.btnCalcular.setEnabled(true);
		}
	}

}
