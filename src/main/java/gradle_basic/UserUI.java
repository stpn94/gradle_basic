package gradle_basic;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import gradle_basic.ui.DepartmentUI;
import gradle_basic.ui.TitleUI;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnDepartment;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserUI frame = new UserUI();
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
	public UserUI() {
		setTitle("settilte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("UserUI");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setToolTipText("UserUI");
		contentPane.add(lblNewLabel, BorderLayout.CENTER);
		
		JPanel pbtn = new JPanel();
		contentPane.add(pbtn, BorderLayout.SOUTH);
		
		btnDepartment = new JButton("부서");
		btnDepartment.addActionListener(this);
		pbtn.add(btnDepartment);
		
		btnNewButton = new JButton("직책");
		btnNewButton.addActionListener(this);
		pbtn.add(btnNewButton);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNewButton) {
			actionPerformedBtnNewButton_1(e);
		}
		if (e.getSource() == btnDepartment) {
			actionPerformedBtnDepartment(e);
		}
	}
	protected void actionPerformedBtnDepartment(ActionEvent e) {
		
		DepartmentUI frame = new DepartmentUI();
		frame.setVisible(true);
	}
	protected void actionPerformedBtnNewButton_1(ActionEvent e) {
		JOptionPane.showMessageDialog(null, "직책 버튼 클릭");
		TitleUI frame = new TitleUI();
		frame.setVisible(true);
		
	}
}
