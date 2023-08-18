package foodOrderingSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class FOS_Intro extends JFrame {
	//Programmer: Roque, Raniel Christian B
	//Date Starter/Finished: April 22, 2023 - April 23, 2023
	//BSIT-1A IT-22
	ImageIcon Logo = new ImageIcon(new ImageIcon("Images/Logo-FOS.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));

	ImageIcon KareKare = new ImageIcon(new ImageIcon("Images/IntroImages/KareKare.png").getImage().getScaledInstance(390, 580, Image.SCALE_SMOOTH));
	ImageIcon Chicharon = new ImageIcon(new ImageIcon("Images/IntroImages/Chicharon.png").getImage().getScaledInstance(390, 580, Image.SCALE_SMOOTH));
	ImageIcon Bulalo = new ImageIcon(new ImageIcon("Images/IntroImages/Bulalo.png").getImage().getScaledInstance(390, 580, Image.SCALE_SMOOTH));
	ImageIcon[] Images = {KareKare, Bulalo, Chicharon};
	
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	
	void FOS_Intro_Design(){
		setSize(400, 600);
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#F5F5DC"));
		setResizable(false);
		setTitle("Food Ordering System");
		setIconImage(Logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//COMPONENTS
		JLabel Image = new JLabel();
		
		//SidebarDesign
		Image.setBounds(0, 0, getWidth(), 575);
		Image.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Image.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		    	if (e.getClickCount() == 1) {
		    		FOS_Dine_Take DT = new FOS_Dine_Take();
		    		DT.FOS_Dine_Take_Design();
		    		dispose();
		    	}
		    }
		});
		//ADD
		add(Image);

		setLayout(null);
		setVisible(true);
		
		//TIMER
		int index = 0;
		while (true) {
		    Image.setIcon(Images[index]);
		    index = (index + 1) % Images.length;

		    // Insert a delay between iterations so the icons change at a reasonable pace
		    try {
		        Thread.sleep(15000); // Wait for 15 Seconds
		    } catch (InterruptedException e) {
		        e.printStackTrace();
		    }
		}
		
	}

}
