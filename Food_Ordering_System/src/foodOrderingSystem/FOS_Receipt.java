package foodOrderingSystem;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class FOS_Receipt extends JFrame implements ActionListener {
	//Programmer: Roque, Raniel Christian B
	//Date Starter/Finished: April 22, 2023 - April 23, 2023
	//BSIT-1A IT-22
	ImageIcon Logo = new ImageIcon(new ImageIcon("Images/Logo-FOS.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	void FOS_Receipt_Design(){
		JLabel BG = new JLabel(new ImageIcon(new ImageIcon("Images/Templates/Receipt_Template.png").getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH)));
		JButton NewOrd = new JButton();
		
		setSize(BG.getPreferredSize());
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#F5F5DC"));
		getContentPane().add(BG);
		setResizable(false);
		setTitle("Food Ordering System");
		setIconImage(Logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		NewOrd.setText("Create New Order");
		NewOrd.setBounds(140, 370, 200, 50);
		NewOrd.setFont(new Font("Helvetica", Font.BOLD, 20));
		NewOrd.setForeground(Color.white);
		NewOrd.setBackground(Color.decode("#4a392f"));
		NewOrd.setOpaque(true);
		NewOrd.setBorder(null);
		NewOrd.setFocusable(false);
		NewOrd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		NewOrd.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	FOS_Dine_Take Frame = new FOS_Dine_Take();
	    		Frame.FOS_Dine_Take_Design();
	    		dispose();
		    }
		});
		NewOrd.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	NewOrd.setBackground(Color.decode("#7a5f4e"));
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	NewOrd.setBackground(Color.decode("#4a392f"));
		    }
		});
		
		
		add(NewOrd);
		
		getContentPane().setComponentZOrder(NewOrd, 0);
		//Design
		BG.setBounds(0, 0, getWidth(), getHeight());
		
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
