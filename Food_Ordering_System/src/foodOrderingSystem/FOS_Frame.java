package foodOrderingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.Random;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FOS_Frame extends JFrame implements ActionListener{
	//Programmer: Roque, Raniel Christian B
	//Date Starter/Finished: April 22, 2023 - April 23, 2023
	//BSIT-1A IT-22
	//IMAGES
	ImageIcon Logo = new ImageIcon(new ImageIcon("Images/Logo-FOS.png").getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH));
	String[] Inames = {"Back", "BF", "Main", "Dessert", "Buy", "help"};
    ImageIcon[] images = new ImageIcon[Inames.length];
    
	//BREAKFAST IMAGES
	String[] BFnames = {"Longsilog", "Tapsilog", "Tocilog", "Spamsilog", "Daingsilog", "Chicksilog", "Bangsilog", "Cornsilog", "Hotsilog", "Shanghaisilog"};
    String[] BFCheckNames = {"LongsilogCheck", "TapsilogCheck", "TocilogCheck", "SpamsilogCheck", "DaingsilogCheck", "ChicksilogCheck", "BangsilogCheck", "CornsilogCheck", "HotsilogCheck", "ShanghaisilogCheck"};
    ImageIcon[] BFicons = new ImageIcon[BFnames.length];
    ImageIcon[] selectedBFicons = new ImageIcon[BFCheckNames.length];
	
	//MAIN DISHES IMAGES
    String[] Mdishes = {"Sinigang", "Kare", "Sisig", "Adobo", "Chicken", "Inihaw", "Pata", "Nilaga", "Tinola", "Bulalo"};
    ImageIcon[] Micons = new ImageIcon[Mdishes.length];
    ImageIcon[] selectedMicons = new ImageIcon[Mdishes.length];

	//DESSERT IMAGES
    String[] Ddishes = {"Bumbong", "Mais", "Leche", "Halo", "Puto", "Fruit", "Mango", "Kalamay", "Ice", "Pandan"};
    ImageIcon[] Dicons = new ImageIcon[Mdishes.length];
    ImageIcon[] selectedDicons = new ImageIcon[Mdishes.length];
	
	//TOOLKITS
	Toolkit ToolK = getToolkit();
	Dimension Size = ToolK.getScreenSize();
	
	//DINE IN OR TAKE OUT FROM OTHER CLASS
	String DT;
	
	//INITIALIZE 
	DefaultListModel<String> ListModel = new DefaultListModel();
	JList<String> List = new JList<String>(ListModel);
	JScrollPane ScrollPane = new JScrollPane(List);
	
	JPanel BFPanel = new JPanel();
	JPanel MainPanel = new JPanel();
	JPanel DPanel = new JPanel();
	JPanel BuyPanel = new JPanel();
	
	JLabel Title = new JLabel(), Order = new JLabel(), DownBar = new JLabel(), SelectedUp = new JLabel(), SelectedDown = new JLabel(), Info = new JLabel(), DiscountTxT = new JLabel(), TotalTxT = new JLabel(), DiscountedTxT = new JLabel(), PaymentTxT = new JLabel(), ChangeTxT = new JLabel(); 
	JTextField ItemSelect = new JTextField(), Price = new JTextField(), Total = new JTextField(), Discount = new JTextField(), Payment = new JTextField(), Change = new JTextField();
	JButton BackButt, BFButt, MainButt, DessertButt, BuyButt, HelpButt, Confirm = new JButton(), Cancel = new JButton();
	JRadioButton None = new JRadioButton(), Student = new JRadioButton(), Senior = new JRadioButton();
	ButtonGroup ButtGroup = new ButtonGroup();
	
	//ARRAYS FOR LOOPS
	JButton[] SideButt = {BackButt = new JButton(), BFButt = new JButton(), MainButt = new JButton(), DessertButt = new JButton(), BuyButt = new JButton(), HelpButt = new JButton()};
	JCheckBox[] BFDish = new JCheckBox[10];
	JCheckBox[] MDish = new JCheckBox[10];
	JCheckBox[] DDish = new JCheckBox[10];
	
	//ARRAYS FOR LOOPS BUT FOR SET TEXTS
	String[] BF = {
				"<html>Longsilog <br>P80.00</html>", "<html>Tapsilog <br>P90.00</html>", "<html>Tocilog <br>P70.00</html>", 
				"<html>Spamsilog <br>P80.00</html>", "<html>Daingsilog <br>P90.00</html>", "<html>Chicksilog <br>P90.00</html>", 
				"<html>Bangsilog <br>P90.00</html>", "<html>Cornsilog <br>P80.00</html>", "<html>Hotsilog <br>P70.00</html>", 
				"<html>Shanghaisilog <br>P70.00</html>"
			};
	
	String[] M = {
				"<html>Sinigang na Bangus<br>P170.00</html>", "<html>Kare-Kare<br>P200.00</html>", "<html>Sisig<br>P170.00</html>", "<html>Pork Adobo<br>P200.00</html>", 
				"<html>Chicken Inasal<br>P120.00</html>", "<html>Inihaw na Liempo<br>P100.00</html>", "<html>Crispy Pata<br>P250.00</html>", 
				"<html>Beef Nilaga<br>P150.00</html>", "<html>Tinola<br>P150.00</html>", "<html>Bulalo<br>P200.00</html>"
			};
	
	String[] D = {
				"<html>Puto Bumbong<br>P50.00</html>", "<html>Mais Con Yelo<br>P100.00</html>", "<html>Leche Flan<br>P90.00</html>", 
				"<html>Halo-Halo<br>P70.00</html>", "<html>Puto<br>P60.00</html>", "<html>Fruit Salad<br>P50.00</html>", 
				"<html>Mango Graham Cake<br>P100.00</html>", "<html>Kalamay<br>P100.00</html>", 
				"<html>Ice Cream<br>P90.00</html>", "<html>Buko Pandan<br>P90.00</html>"
			};
	
	String[] BFShow = {
			"Longsilog","Tapsilog","Tocilog",
			"Spamsilog","Daingsilog","Chicksilog",
			"Bangsilog","Cornsilog","Hotsilog",
			"Shanghaisilog"
	};
	
	Double[] BFCalc = {
			80.00, 90.00, 70.00, 
			80.00, 90.00, 90.00,
			90.00, 80.00, 70.00,
			70.00
	};
	
	String[] MShow = {
			"Sinigang na Bangus","Kare-Kare", "Sisig", "Pork Adobo", 
			"Chicken Inasal", "Inihaw na Liempo", "Crispy Pata", 
			"Beef Nilaga", "Tinola", "Bulalo"
		};
	
	Double[] MCalc = {
			170.00, 200.00, 170.00, 200.00, 
			120.00, 100.00, 250.00,
			150.00, 150.00, 200.00
	};
	
	String[] DShow = {
			"Puto Bumbong", "Mais Con Yelo", "Leche Flan", 
			"Halo-Halo", "Puto", "Fruit Salad", 
			"Mango Graham Cake", "Kalamay", 
			"Ice Cream", "Buko Pandan"
		};
	
	Double[] DCalc = {
			50.00, 100.00, 90.00, 
			70.00, 60.00, 50.00, 
			100.00, 100.00, 
			90.00, 90.00
	};
	
	//PROCESS
	double TotalPrice = 0.00, BFnum = 0.00, Mnum = 0.00, Dnum = 0.00, DiscountPrice = 0.00, ChangeCalc = 0.00;
	int size = 0;
	String[] Totalarr= new String[100];
	
	void FOS_Frame_Design(){
		//IMAGES
		for (int i = 0; i < Inames.length; i++) {
			images[i] = new ImageIcon(new ImageIcon("Images/SideLogos/" + Inames[i] + ".png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		}
		
		for(int i = 0; i < BFnames.length; i++){
			BFicons[i] = new ImageIcon(new ImageIcon("Images/FrameDesignImages/BreakfastImages/"+BFnames[i]+".png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            selectedBFicons[i] = new ImageIcon(new ImageIcon("Images/FrameDesignImages/BreakfastImages/"+BFCheckNames[i]+".png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            Micons[i] = new ImageIcon(new ImageIcon("Images/FrameDesignImages/MainImages/" + Mdishes[i] + ".png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            selectedMicons[i] = new ImageIcon(new ImageIcon("Images/FrameDesignImages/MainImages/" + Mdishes[i] + "Check.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            Dicons[i] = new ImageIcon(new ImageIcon("Images/FrameDesignImages/DessertImages/" + Ddishes[i] + ".png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
            selectedDicons[i] = new ImageIcon(new ImageIcon("Images/FrameDesignImages/DessertImages/" + Ddishes[i] + "Check.png").getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH));
		}
		
		JLabel BG = new JLabel(new ImageIcon(new ImageIcon("Images/Templates/Template_2.png").getImage().getScaledInstance(500, 600, Image.SCALE_SMOOTH)));
		
		setSize(BG.getPreferredSize());
		getContentPane().add(BG);
		BG.setBounds(0, 0, getWidth(), getHeight());
		
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
		getContentPane().setBackground(Color.decode("#F5F5DC"));
		setResizable(false);
		setTitle("Food Ordering System");
		setIconImage(Logo.getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//COMPONENTS
		Title.setText("Breakfast");
		Title.setBounds(175, 85, 250, 40);
		Title.setFont(new Font("Georgia", Font.BOLD, 40));
		Title.setForeground(Color.black);
		Title.setBorder(null);
		Title.setFocusable(false);
		Title.setOpaque(false);
		
		//TOOLTIP EDITS
		UIManager.put("ToolTip.background", Color.white);
		UIManager.put("ToolTip.foreground", Color.black);
		UIManager.put("ToolTip.border", BorderFactory.createLineBorder(Color.black, 1));
		UIManager.put("ToolTip.font", new Font("Arial", Font.BOLD, 20));
	    int initialDelay = ToolTipManager.sharedInstance().getInitialDelay();
	    ToolTipManager.sharedInstance().setInitialDelay(10);
	    
	    //SIDE BUTTONS
	    int y = 75;
	    for (int i = 0; i < SideButt.length; i++) {
	        int index = i; // Final Variable for mouselistener
	        SideButt[index].setIcon(images[i]);
	        SideButt[index].setBounds(0, y, 69, 70);
	        y += 70;
	        SideButt[index].setBorder(null);
	        SideButt[index].setOpaque(true);
	        SideButt[index].setFocusable(false);
	        SideButt[index].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        SideButt[index].addActionListener(this);
	        
	        if (index == 0) {
		        	SideButt[index].addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseEntered(java.awt.event.MouseEvent evt) {
		                SideButt[index].setBackground(Color.decode("#695141"));
		            }
		            public void mouseExited(java.awt.event.MouseEvent evt) {
		                SideButt[index].setBackground(Color.decode("#4b3a2f"));
		            }
	        	});
	        } else if (index >= 1 && index <= SideButt.length-1){
	        	SideButt[index].addMouseListener(new java.awt.event.MouseAdapter() {
	    			public void mouseEntered(java.awt.event.MouseEvent evt) {
	    		    	if (SideButt[index].getBackground().equals(Color.decode("#4b3a2f"))) {
	    		    		SideButt[index].setBackground(Color.decode("#695141"));
	    		    	}
	    		    }
	    		    public void mouseExited(java.awt.event.MouseEvent evt) {
	    		    	if (SideButt[index].getBackground().equals(Color.decode("#695141"))) {
	    		    		SideButt[index].setBackground(Color.decode("#4b3a2f"));
	    		    	}
	    		    }
	    		});
	        } else {
	        	SideButt[index].addMouseListener(new java.awt.event.MouseAdapter() {
		            public void mouseEntered(java.awt.event.MouseEvent evt) {
		                SideButt[index].setBackground(Color.decode("#695141"));
		            }
		            public void mouseExited(java.awt.event.MouseEvent evt) {
		                SideButt[index].setBackground(Color.decode("#4b3a2f"));
		            }
	        	});
	        }
	        add(SideButt[index]);
	    }
	    
		BackButt.setBackground(Color.decode("#4b3a2f"));
		BackButt.setToolTipText("Back");
		
		BFButt.setBackground(Color.decode("#695142"));
		BFButt.setToolTipText("Breakfast");
		
		MainButt.setBackground(Color.decode("#4b3a2f"));
		MainButt.setToolTipText("Main Courses");
		
		DessertButt.setBackground(Color.decode("#4b3a2f"));
		DessertButt.setToolTipText("Desserts");

		BuyButt.setBackground(Color.decode("#4b3a2f"));
		BuyButt.setToolTipText("Checkout");
		
		HelpButt.setBackground(Color.decode("#4b3a2f"));
		HelpButt.setToolTipText("Help");
		
		BFPanel.setBounds(85, 150, 380, 400);
		BFPanel.setLayout(new GridLayout(5,5));
		
		MainPanel.setBounds(85, 150, 380, 400);
		MainPanel.setLayout(new GridLayout(5,5));
		MainPanel.setVisible(false);

		DPanel.setBounds(85, 150, 380, 400);
		DPanel.setLayout(new GridLayout(5,5));
		DPanel.setVisible(false);
		
		BuyPanel.setBounds(85, 180, 140, 300);
		BuyPanel.setVisible(false);
		BuyPanel.setLayout(new BorderLayout());
		
		ScrollPane.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		BuyPanel.add(ScrollPane);
		
		List.setFont(new Font("Arial", Font.BOLD, 12));
		List.setBackground(Color.white);
		List.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    int index = List.locationToIndex(e.getPoint());
                    String selectedValue = List.getModel().getElementAt(index);
                    ItemSelect.setText(selectedValue);
                    ItemSelect.setFont(new Font("Helvetica", Font.PLAIN, 18));
                    Price.setFont(new Font("Helvetica", Font.PLAIN, 18));
                    
                    
                    //ARRAY CHECKER AND INDEX GETTER
                    int BFIndex = -1, MIndex = -1, DIndex = -1;

                    for (int i = 0; i < BFShow.length; i++) {
                      if (BFShow[i].equals(selectedValue)) {
                    	  BFIndex = i;
                        break;
                      } else if (MShow[i].equals(selectedValue)) {
                    	  MIndex = i;
                          break;
                        } else if (DShow[i].equals(selectedValue)) {
                    	  DIndex = i;
                          break;
                        }
                    }
                    
                    //PRICE SETTER
                    if (BFIndex != -1) {
                    	  Price.setText("P" + String.format("%.2f", BFCalc[BFIndex]));
                    	}  else if (MIndex != -1) {
                      	  Price.setText("P" + String.format("%.2f", MCalc[MIndex]));
                      	} else if (DIndex != -1) {
                      	  Price.setText("P" + String.format("%.2f", DCalc[DIndex]));
                      	} 
                }
            }
        });
		
		for (int i = 0; i < BFDish.length; i++) {
			BFDish[i] = new JCheckBox(BF[i]);
			BFDish[i].setIcon(BFicons[i]);
		    	BFDish[i].setSelectedIcon(selectedBFicons[i]);
			BFDish[i].setBackground(Color.decode("#e8ccb4"));
			BFDish[i].setFocusable(false);
			BFDish[i].setOpaque(true);
			BFDish[i].setFont(new Font("Arial", Font.BOLD, 14));
			BFDish[i].addActionListener(this);
			BFDish[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			BFPanel.add(BFDish[i]);
			
			MDish[i] = new JCheckBox(M[i]);
			MDish[i].setIcon(Micons[i]);
			MDish[i].setSelectedIcon(selectedMicons[i]);
			MDish[i].setBackground(Color.decode("#e8ccb4"));
			MDish[i].setFocusable(false);
			MDish[i].setOpaque(true);
			MDish[i].setFont(new Font("Arial", Font.BOLD, 14));
			MDish[i].addActionListener(this);
			MDish[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			MainPanel.add(MDish[i]);
			
			DDish[i] = new JCheckBox(D[i]);
			DDish[i].setIcon(Dicons[i]);
		    	DDish[i].setSelectedIcon(selectedDicons[i]);
			DDish[i].setBackground(Color.decode("#e8ccb4"));
			DDish[i].setFocusable(false);
			DDish[i].setOpaque(true);
			DDish[i].setFont(new Font("Arial", Font.BOLD, 14));
			DDish[i].addActionListener(this);
			DDish[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			DPanel.add(DDish[i]);
		}
		
		//TEXT
		Order.setText("Order Details");
		Order.setBounds(92, 143, 250, 40);
		Order.setFont(new Font("Georgia", Font.BOLD, 18));
		Order.setForeground(Color.black);
		Order.setBorder(null);
		Order.setFocusable(false);
		Order.setOpaque(false);
		Order.setVisible(false);
		
		Info.setText("Billing details");
		Info.setBounds(280, 143, 250, 40);
		Info.setFont(new Font("Georgia", Font.BOLD, 18));
		Info.setForeground(Color.black);
		Info.setBorder(null);
		Info.setOpaque(false);
		Info.setVisible(false);
		
		//RIGHT SIDE
		SelectedUp.setBounds(235, 180, 230, 90);
		SelectedUp.setBackground(Color.white);
		SelectedUp.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		SelectedUp.setOpaque(true);
		SelectedUp.setVisible(false);
		
		ItemSelect.setText("Select an Item from your list");
		ItemSelect.setFont(new Font("Arial", Font.ITALIC, 14));
		ItemSelect.setForeground(Color.black);
		ItemSelect.setBounds(10, 10, 210, 30);
		ItemSelect.setBackground(Color.white);
		ItemSelect.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		ItemSelect.setOpaque(true);
		ItemSelect.setEditable(false);
		
		Price.setText("Item Price");
		Price.setBounds(10, 50, 210, 30);
		Price.setFont(new Font("Arial", Font.ITALIC, 14));
		Price.setForeground(Color.black);
		Price.setBackground(Color.white);
		Price.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		Price.setOpaque(true);
		Price.setEditable(false);
		
		SelectedDown.setBounds(235, 280, 230, 200);
		SelectedDown.setBackground(Color.white);
		SelectedDown.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		SelectedDown.setOpaque(true);
		SelectedDown.setVisible(false);
		
		DiscountTxT.setText("Discounts");
		DiscountTxT.setBounds(5, 5, 250, 15);
		DiscountTxT.setFont(new Font("Helvetica", Font.BOLD, 14));
		DiscountTxT.setForeground(Color.black);
		DiscountTxT.setBorder(null);
		DiscountTxT.setOpaque(false);
		
		None.setText("None");
		None.setSelected(true);
		None.setBounds(10, 25, 70, 15);
		None.setFocusable(false);
		None.setOpaque(false);
		None.setFont(new Font("Arial", Font.PLAIN, 12));
		None.addActionListener(this);
		
		Student.setText("Student (3%)");
		Student.setSelected(true);
		Student.setBounds(70, 25, 100, 15);
		Student.setFocusable(false);
		Student.setOpaque(false);
		Student.setFont(new Font("Arial", Font.PLAIN, 12));
		Student.addActionListener(this);
		
		Senior.setText("Senior (20%)");
		Senior.setSelected(true);
		Senior.setBounds(10, 45, 100, 15);
		Senior.setFocusable(false);
		Senior.setOpaque(false);
		Senior.setFont(new Font("Arial", Font.PLAIN, 12));
		Senior.addActionListener(this);
		
		ButtGroup.add(None);
		ButtGroup.add(Student);
		ButtGroup.add(Senior);
		
		TotalTxT.setText("Total: ");
		TotalTxT.setHorizontalAlignment(SwingConstants.RIGHT);
		TotalTxT.setBounds(5, 70, 90, 20);
		TotalTxT.setFont(new Font("Helvetica", Font.BOLD, 14));
		TotalTxT.setForeground(Color.black);
		TotalTxT.setBorder(null);
		TotalTxT.setOpaque(false);
		
		Total.setHorizontalAlignment(SwingConstants.RIGHT);
		Total.setFont(new Font("Arial", Font.PLAIN, 14));
		Total.setForeground(Color.black);
		Total.setBounds(100, 73, 120, 20);
		Total.setBackground(Color.white);
		Total.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		Total.setOpaque(true);
		Total.setEditable(false);
		
		DiscountedTxT.setText("Discounted: ");
		DiscountedTxT.setHorizontalAlignment(SwingConstants.RIGHT);
		DiscountedTxT.setBounds(5, 100, 90, 20);
		DiscountedTxT.setFont(new Font("Helvetica", Font.BOLD, 14));
		DiscountedTxT.setForeground(Color.black);
		DiscountedTxT.setBorder(null);
		DiscountedTxT.setOpaque(false);
		
		Discount.setText("P 0.00");
		Discount.setHorizontalAlignment(SwingConstants.RIGHT);
		Discount.setFont(new Font("Arial", Font.PLAIN, 14));
		Discount.setForeground(Color.black);
		Discount.setBounds(100, 103, 120, 20);
		Discount.setBackground(Color.white);
		Discount.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		Discount.setOpaque(true);
		Discount.setEditable(false);
		
		PaymentTxT.setText("Payment: ");
		PaymentTxT.setHorizontalAlignment(SwingConstants.RIGHT);
		PaymentTxT.setBounds(5, 130, 90, 20);
		PaymentTxT.setFont(new Font("Helvetica", Font.BOLD, 14));
		PaymentTxT.setForeground(Color.black);
		PaymentTxT.setBorder(null);
		PaymentTxT.setOpaque(false);
		
		Payment.setText("Enter amount");
		Payment.setHorizontalAlignment(SwingConstants.RIGHT);
		Payment.setFont(new Font("Helvetica", Font.PLAIN, 14));
		Payment.setForeground(Color.decode("#474747"));
		Payment.setBounds(100, 133, 120, 20);
		Payment.setBackground(Color.white);
		Payment.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		Payment.setOpaque(true);
		Payment.setEditable(false);
		Payment.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	if(Payment.getText().isEmpty()) {
		    		Payment.setText("Enter amount");
		    		Payment.setForeground(Color.decode("#474747"));
		    		Payment.setEditable(false);
		    	}
		    }
		    public void mouseReleased(java.awt.event.MouseEvent evt) {
		    	if(Payment.getText().equals("Enter amount")) {
		    		Payment.setText("");
		    		Payment.setForeground(Color.BLACK);
		    		Payment.setEditable(true);
		    	}
		    }
		});
		
		Payment.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void changedUpdate(DocumentEvent e) {
		        updateChange();
		    }

		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        updateChange();
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		        updateChange();
		    }

		    private void updateChange() {
		        if(Payment.getText().matches("[0-9]+")) {
		            ChangeCalc = Double.parseDouble(Payment.getText()) - (TotalPrice - DiscountPrice);
		            
		            if (ChangeCalc >= 0) {
		            	Change.setText("P " + String.format("%.2f",ChangeCalc));
		            	Change.setFont(new Font("Arial", Font.PLAIN, 14));
		            } else {
		            	Change.setText("Insufficient Amount");
		            	Change.setFont(new Font("Arial", Font.ITALIC, 12));
		            }
		            
		        } else if (Payment.getText().equals("Enter amount") || Payment.getText().equals(null)){
		            Change.setText("P 0.00");
		        } else if (!Payment.getText().matches("[0-9]+")){
		        	Change.setText("Invalid Input");
		        }
		    }
		});
		
		ChangeTxT.setText("Change: ");
		ChangeTxT.setHorizontalAlignment(SwingConstants.RIGHT);
		ChangeTxT.setBounds(5, 160, 90, 20);
		ChangeTxT.setFont(new Font("Helvetica", Font.BOLD, 14));
		ChangeTxT.setForeground(Color.black);
		ChangeTxT.setBorder(null);
		ChangeTxT.setOpaque(false);
		
		Change.setText("P 0.00");
		Change.setHorizontalAlignment(SwingConstants.RIGHT);
		Change.setFont(new Font("Arial", Font.PLAIN, 14));
		Change.setForeground(Color.black);
		Change.setBounds(100, 163, 120, 20);
		Change.setBackground(Color.white);
		Change.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		Change.setOpaque(true);
		Change.setEditable(false);
		
		//CONFIRM
		DownBar.setBounds(0, 495, 500, 100);
		DownBar.setBackground(Color.decode("#4b3a2f"));
		DownBar.setBorder(null);
		DownBar.setOpaque(true);
		DownBar.setVisible(false);
		
		Cancel.setText("Cancel");
		Cancel.setBounds(85, 15, 140, 35);
		Cancel.setFont(new Font("Helvetica", Font.BOLD, 16));
		Cancel.setForeground(Color.black);
		Cancel.setBackground(Color.decode("#f5b8b8"));
		Cancel.setOpaque(true);
		Cancel.setBorder(null);
		Cancel.setFocusable(false);
		Cancel.addActionListener(this);
		Cancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Cancel.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	Cancel.setBackground(Color.decode("#f72525"));
		    	Cancel.setForeground(Color.white);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	Cancel.setBackground(Color.decode("#f5b8b8"));
		    	Cancel.setForeground(Color.black);
		    }
		});
		
		Confirm.setText("Confirm");
		Confirm.setBounds(280, 15, 140, 35);
		Confirm.setFont(new Font("Helvetica", Font.BOLD, 16));
		Confirm.setForeground(Color.black);
		Confirm.setBackground(Color.decode("#bbf5b8"));
		Confirm.setOpaque(true);
		Confirm.setBorder(null);
		Confirm.setFocusable(false);
		Confirm.addActionListener(this);
		Confirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Confirm.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		    	Confirm.setBackground(Color.decode("#02bf34"));
		    	Confirm.setForeground(Color.white);
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		    	Confirm.setBackground(Color.decode("#bbf5b8"));
		    	Confirm.setForeground(Color.black);
		    }
		});
		
		//ADD
		add(Title);
		add(Order);
		add(Info);
		add(SelectedUp);
		SelectedUp.add(ItemSelect);
		SelectedUp.add(Price);
		
		add(SelectedDown);
		SelectedDown.add(TotalTxT);
		SelectedDown.add(DiscountTxT);
		SelectedDown.add(DiscountedTxT);
		SelectedDown.add(PaymentTxT);
		SelectedDown.add(ChangeTxT);
		SelectedDown.add(Total);
		SelectedDown.add(Discount);
		SelectedDown.add(Payment);
		SelectedDown.add(Change);
		SelectedDown.add(None);
		SelectedDown.add(Senior);
		SelectedDown.add(Student);
		
		add(DownBar);
		DownBar.add(Confirm);
		DownBar.add(Cancel);
		
		add(BFPanel);
		add(MainPanel);
		add(DPanel);
		add(BuyPanel);
		
		getContentPane().setComponentZOrder(Title, 0);
		getContentPane().setComponentZOrder(BFPanel, 0);
		getContentPane().setComponentZOrder(MainPanel, 0);
		getContentPane().setComponentZOrder(DPanel, 0);
		getContentPane().setComponentZOrder(BuyPanel, 0);
		getContentPane().setComponentZOrder(Order, 0);
		getContentPane().setComponentZOrder(Info, 0);
		getContentPane().setComponentZOrder(SelectedDown, 0);
		getContentPane().setComponentZOrder(SelectedUp, 0);
		getContentPane().setComponentZOrder(DownBar, 0);
		for (int i = 0; i < SideButt.length; i++) {
		    getContentPane().setComponentZOrder(SideButt[i], 0);
		}
		setLayout(null);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < BFDish.length;i++ ) {
    		if(e.getSource().equals(BFDish[i])) {
    			if(BFDish[i].isSelected()) {
        			ListModel.addElement(BFShow[i]);
    			} else {
    				ListModel.removeElement(BFShow[i]);
    			}
    		}
    		
    		if(e.getSource().equals(MDish[i])) {
    			if(MDish[i].isSelected()) {
        			ListModel.addElement(MShow[i]);
    			} else {
    				ListModel.removeElement(MShow[i]);
    			}
    		}
    		
    		if(e.getSource().equals(DDish[i])) {
    			if(DDish[i].isSelected()) {
        			ListModel.addElement(DShow[i]);
    			} else {
    				ListModel.removeElement(DShow[i]);
    			}
    		}
		}
		
		if (e.getSource() == BackButt) {
		    int Back = JOptionPane.showConfirmDialog(this, "Go back and discard order?", "Back", JOptionPane.YES_NO_OPTION);
		    if (Back == JOptionPane.YES_OPTION) {
		        FOS_Dine_Take Fos = new FOS_Dine_Take();
		        Fos.FOS_Dine_Take_Design();
		        dispose();
		    }
		}
		
		//PROCESS
		
	    if (e.getSource() == BFButt) {
	   
	        Title.setText("Breakfast");
	        BFButt.setBackground(Color.decode("#695142"));
    		MainButt.setBackground(Color.decode("#4b3a2f"));
    		DessertButt.setBackground(Color.decode("#4b3a2f"));
	        BuyButt.setBackground(Color.decode("#4b3a2f"));
	        
	        Title.setBounds(175, 85, 250, 40);
	        BFPanel.setVisible(true);
	        MainPanel.setVisible(false);
	        DPanel.setVisible(false);
	        BuyPanel.setVisible(false);
	        Order.setVisible(false);
	        Info.setVisible(false);
	        SelectedUp.setVisible(false);
	        SelectedDown.setVisible(false);
	        DownBar.setVisible(false);
	        Payment.setText("Enter amount");
    		Payment.setForeground(Color.decode("#474747"));
    		Payment.setEditable(false);
	        
	    } else if (e.getSource() == MainButt) {
	    	
	        Title.setText("Main Course");
	        BFButt.setBackground(Color.decode("#4b3a2f"));
    		MainButt.setBackground(Color.decode("#695142"));
    		DessertButt.setBackground(Color.decode("#4b3a2f"));
	        BuyButt.setBackground(Color.decode("#4b3a2f"));
	        
	        Title.setBounds(140, 85, 280, 40);
	        BFPanel.setVisible(false);
	        MainPanel.setVisible(true);
	        DPanel.setVisible(false);
	        BuyPanel.setVisible(false);
	        Order.setVisible(false);
	        Info.setVisible(false);
	        SelectedDown.setVisible(false);
	        SelectedUp.setVisible(false);
	        DownBar.setVisible(false);
	        Payment.setText("Enter amount");
    		Payment.setForeground(Color.decode("#474747"));
    		Payment.setEditable(false);
	        
	    } else if (e.getSource() == DessertButt) {
	    	
	        Title.setText("Desserts");
	        BFButt.setBackground(Color.decode("#4b3a2f"));
    		MainButt.setBackground(Color.decode("#4b3a2f"));
    		DessertButt.setBackground(Color.decode("#695142"));
	        BuyButt.setBackground(Color.decode("#4b3a2f"));
	        
	        Title.setBounds(175, 85, 250, 40);
	        BFPanel.setVisible(false);
	        MainPanel.setVisible(false);
	        DPanel.setVisible(true);
	        BuyPanel.setVisible(false);
	        Order.setVisible(false);
	        Info.setVisible(false);
	        SelectedUp.setVisible(false);
	        SelectedDown.setVisible(false);
	        DownBar.setVisible(false);
	        Payment.setText("Enter amount");
    		Payment.setForeground(Color.decode("#474747"));
    		Payment.setEditable(false);
	        
	    } else if (e.getSource() == BuyButt) {
	    	
	        Title.setText("Checkout");
	        BFButt.setBackground(Color.decode("#4b3a2f"));
    		MainButt.setBackground(Color.decode("#4b3a2f"));
    		DessertButt.setBackground(Color.decode("#4b3a2f"));
	        BuyButt.setBackground(Color.decode("#695142"));
	        
	        Title.setBounds(175, 85, 250, 40);
	        BFPanel.setVisible(false);
	        MainPanel.setVisible(false);
	        DPanel.setVisible(false);
	        BuyPanel.setVisible(true);
	        Order.setVisible(true);
	        Info.setVisible(true);
	        SelectedUp.setVisible(true);
	        SelectedDown.setVisible(true);
	        DownBar.setVisible(true);
	        Payment.setText("Enter amount");
    		Payment.setForeground(Color.decode("#474747"));
    		Payment.setEditable(false);
	      
    		//----------------------------------------------
    		
    		size = ListModel.getSize();
    		TotalPrice = 0.00;
    		BFnum = 0.00;
    		Mnum = 0.00; 
    		Dnum = 0.00; 
    		DiscountPrice = 0.00; 
    		ChangeCalc = 0.00;
    		
	        if (size == 0) {
	        	Total.setText("P 0.00");
	        } else {
	        	for (int i = 0; i < size; i++) {
	  			  String element = ListModel.getElementAt(i);
	  			  
	  					//ARRAY CHECKER AND INDEX GETTER
	  		             int BFIndex = -1, MIndex = -1, DIndex = -1;
	  		
	  		             for (int x = 0; x < BFShow.length; x++) {
	  		               if (BFShow[x].equals(element)) {
	  		             	  BFIndex = x;
	  		                 break;
	  		               } else if (MShow[x].equals(element)) {
	  		             	  MIndex = x;
	  		                   break;
	  		                 } else if (DShow[x].equals(element)) {
	  		             	  DIndex = x;
	  		                   break;
	  		                 }
	  		             }
	               
	  		           //PRICE SETTER
	  		             if (BFIndex != -1) {
	  		            	 	BFnum += BFCalc[BFIndex];
	  		            	 	Totalarr[i] = String.format("%.2f",BFCalc[BFIndex]);
	  		             	}  else if (MIndex != -1) {
	  		             		Mnum += MCalc[MIndex];
	  		             		Totalarr[i] = String.format("%.2f",MCalc[MIndex]);
	  		               	} else if (DIndex != -1) {
	  		               		Dnum += DCalc[DIndex];
	  		               		Totalarr[i] = String.format("%.2f",DCalc[DIndex]);
	  		               	} 
	  		             
	  		             TotalPrice = BFnum + Mnum + Dnum;
	  		             Total.setText("P " + String.format("%.2f", TotalPrice));
	  			}
	        }
	        
    		//----------------------------------------------
	    } else if (e.getSource() == HelpButt) {
	    	JOptionPane.showMessageDialog(null, "<html>To select the item(s) you want to order, simply <u>tap or click</u> on the area near the food you have chosen.<br> Once selected, a check mark will appear next to the item to indicate that it has been chosen.</html>", "How to use!", JOptionPane.INFORMATION_MESSAGE);	    	
	    }
	  //------------------------------------------------------------------

	    if (e.getSource() == None || e.getSource() == Student || e.getSource() == Senior || e.getSource() == BuyButt) {
			if(None.isSelected() == true) {
				Discount.setText("P 0.00");
				Total.setText("P " + String.format("%.2f", TotalPrice));
				Change.setText("P 0.00");
			} else if(Student.isSelected() == true) {
				DiscountPrice = TotalPrice * 0.03;
				Discount.setText("P " + String.format("%.2f",DiscountPrice));
				Total.setText("P " + String.format("%.2f", (TotalPrice - DiscountPrice)));
				
				if(Payment.getText().matches("[0-9]+")) {
		            ChangeCalc = Double.parseDouble(Payment.getText()) - (TotalPrice - DiscountPrice);
		            Change.setText("P " + String.format("%.2f",ChangeCalc));
		        } else {
		            Change.setText("P 0.00");
		        }
				
			} else if(Senior.isSelected() == true) {
				DiscountPrice = TotalPrice * 0.2;
				Discount.setText("P " + String.format("%.2f",DiscountPrice));
				Total.setText("P " + String.format("%.2f", (TotalPrice - DiscountPrice)));
				
				if(Payment.getText().matches("[0-9]+")) {
		            ChangeCalc = Double.parseDouble(Payment.getText()) - (TotalPrice - DiscountPrice);
		            Change.setText("P " + String.format("%.2f",ChangeCalc));
		        } else {
		            Change.setText("P 0.00");
		        }
				
			}
		}
	    
	  //------------------------------------------------------------------
	    
	    if(e.getSource() == Confirm) {
	    	if (size == 0){
	    		JOptionPane.showMessageDialog(null, "Please order atleast one dish.", "Order Please", JOptionPane.WARNING_MESSAGE);	    
	    	} else if(!Payment.getText().matches("[0-9]+")) {
	    		JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Payment", JOptionPane.WARNING_MESSAGE);	    
	    	} else if (ChangeCalc < 0) {
	    		JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Insufficient Amount", JOptionPane.WARNING_MESSAGE);	 
	    	} else {
	    		int option = JOptionPane.showOptionDialog(
	    			    null,
	    			    "You have entered: P " + Payment.getText(),
	    			    "Confirmation",
	    			    JOptionPane.YES_NO_OPTION,
	    			    JOptionPane.QUESTION_MESSAGE,
	    			    null,
	    			    new Object[] {"Yes", "Cancel"},
	    			    "Yes"
	    			);
	    		
	    		if(option == JOptionPane.YES_OPTION) {
	    			JDialog Receipt = new JDialog();
	    			JPanel ReceiptPanel = new JPanel();
	    			JButton Ok = new JButton();
	    			
	    			JLabel DTLabel = new JLabel(), OrderNum = new JLabel(), Title = new JLabel(), Dash = new JLabel(), SubTitle = new JLabel(), OrderRec = new JLabel(), Dash2 = new JLabel(), Dash3 = new JLabel();
	    			
	    			JLabel[] Order = new JLabel[ListModel.getSize()];
	    			JLabel[] Price = new JLabel[ListModel.getSize()];
	    			JLabel[] Dots = new JLabel[ListModel.getSize()];
	    			
	    			String[] CostTotal = {"Total", "Cash", "Discount", "Change"};
	    			JLabel[] Dots2 = new JLabel[CostTotal.length];
	    			JLabel[] LabelTotal = new JLabel[CostTotal.length];
	    			JLabel[] Price2 = new JLabel[CostTotal.length];
	    			
	    			JScrollPane Scroll = new JScrollPane(ReceiptPanel);
	    			JScrollBar ScrollBar = Scroll.getVerticalScrollBar();
	    			
	    			Receipt.setSize(350, 500);
	    			Receipt.setLocationRelativeTo(null);
	    			Receipt.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
	    			Receipt.getRootPane().setBorder(BorderFactory.createLineBorder(Color.black, 1));
	    			Receipt.setUndecorated(true);
	    			Receipt.setResizable(false);
	    			
	    			Title.setBounds(50, 10, 300, 30);
	    			Title.setText("Pinoy KaiNation");
	    			Title.setFont(new Font("Georgia", Font.BOLD, 28));
	    			Title.setOpaque(false);
	    			
	    			SubTitle.setBounds(70, 35, 300, 30);
	    			SubTitle.setText("Somewhere St, Capas, Tarlac");
	    			SubTitle.setFont(new Font("Helvetica", Font.BOLD, 14));
	    			SubTitle.setOpaque(false);
	    			
	    			OrderRec.setBounds(95, 80, 300, 30);
	    			OrderRec.setText("ORDER RECEIPT");
	    			OrderRec.setFont(new Font("Helvetica", Font.BOLD, 18));
	    			OrderRec.setOpaque(false);
	    			
	    			Dash.setBounds(30, 105, 300, 30);
	    			Dash.setText("----------------------------------");
	    			Dash.setFont(new Font("Georgia", Font.BOLD, 20));
	    			Dash.setOpaque(false);
	    			
	    			int y = 140;
	    			for (int i = 0; i < ListModel.getSize(); i++) {
	    			    Order[i] = new JLabel();
	    			    Order[i].setText(ListModel.getElementAt(i));
	    			    Order[i].setBounds(10, y, 150, 30);
	    			    Order[i].setFont(new Font("Arial", Font.BOLD, 14));
	    			    Order[i].setOpaque(false);
	    			    ReceiptPanel.add(Order[i]);
	    			    
	    			    Price[i] = new JLabel();
	    			    Price[i].setHorizontalAlignment(SwingConstants.RIGHT);
	    			    Price[i].setText(Totalarr[i]);
	    			    Price[i].setBounds(260, y, 50, 30);
	    			    Price[i].setOpaque(false);
	    			    Price[i].setFont(new Font("Arial", Font.BOLD, 14));
	    			    ReceiptPanel.add(Price[i]);
	    			    
	    			    Dots[i] = new JLabel("····················· P ");
	    			    Dots[i].setBounds(165, y, 100, 30);
	    			    Dots[i].setOpaque(false);
	    			    Dots[i].setFont(new Font("Arial", Font.BOLD, 12));
	    			    ReceiptPanel.add(Dots[i]);
	    			    
	    			    y += 30;
	    			}
	    			
	    			Dash2.setBounds(30, y, 300, 30);
	    			Dash2.setText("----------------------------------");
	    			Dash2.setFont(new Font("Georgia", Font.BOLD, 20));
	    			Dash2.setOpaque(false);
	    			
	    			y += 30;
	    			
	    			for (int i = 0; i < CostTotal.length; i++) {
	    				LabelTotal[i] = new JLabel();
	    				LabelTotal[i].setText(CostTotal[i]);
	    			    LabelTotal[i].setBounds(10, y, 150, 30);
	    			    LabelTotal[i].setFont(new Font("Arial", Font.BOLD, 14));
	    			    LabelTotal[i].setOpaque(false);
	    			    ReceiptPanel.add(LabelTotal[i]);
	    			    
	    			    Price2[i] = new JLabel();
	    			    Price2[i].setHorizontalAlignment(SwingConstants.RIGHT);
	    			    Price2[i].setText(Totalarr[i]);
	    			    Price2[i].setBounds(230, y, 80, 30);
	    			    Price2[i].setOpaque(false);
	    			    Price2[i].setFont(new Font("Arial", Font.BOLD, 14));
	    			    ReceiptPanel.add(Price2[i]);
	    			    
	    				Dots2[i] = new JLabel("···························· P ");
		    			Dots2[i].setBounds(105, y, 150, 30);
		    			Dots2[i].setOpaque(false);
		    			Dots2[i].setFont(new Font("Arial", Font.BOLD, 12));
		    			ReceiptPanel.add(Dots2[i]);
		    			
		    			y += 30;
	    			}
	    			
	    			Price2[0].setText(String.format("%.2f", TotalPrice));
	    			Price2[1].setText(String.format("%.2f", Double.parseDouble(Payment.getText())));
	    			Price2[2].setText(String.format("%.2f", DiscountPrice));
	    			Price2[3].setText(String.format("%.2f", ChangeCalc));
	    			
	    			Dash3.setBounds(30, y, 300, 30);
	    			Dash3.setText("----------------------------------");
	    			Dash3.setFont(new Font("Georgia", Font.BOLD, 20));
	    			Dash3.setOpaque(false);
	    			
	    			Random rand = new Random();
	    			String Digit1 = Integer.toString(rand.nextInt(10));
	    			String Digit2 = Integer.toString(rand.nextInt(10));
	    			String Digit3 = Integer.toString(rand.nextInt(10));
	    			String Digit4 = Integer.toString(rand.nextInt(10));
	    			
	    			y += 40;
	    			
	    			OrderNum.setBounds(60, y, 300, 30);
	    			OrderNum.setText("ORDER NUMBER: " + Digit1 + Digit2 + Digit3 + Digit4);
	    			OrderNum.setFont(new Font("Helvetica", Font.BOLD, 20));
	    			OrderNum.setOpaque(false);
	    			
	    			y += 30;
	    			DTLabel.setBounds(120, y, 300, 30);
	    			DTLabel.setText("For " + DT);
	    			DTLabel.setFont(new Font("Helvetica", Font.BOLD, 16));
	    			DTLabel.setOpaque(false);
	    			
	    			ReceiptPanel.setBackground(Color.white);
	    			ReceiptPanel.setLayout(null);
	    			
	    			y += 45;
	    			Ok.setText("OK");
	    			Ok.setBounds(120, y, 100, 30);
	    			Ok.setFont(new Font("Helvetica", Font.BOLD, 20));
	    			Ok.setForeground(Color.black);
	    			Ok.setBackground(Color.white);
	    			Ok.setOpaque(true);
	    			Ok.setBorder(null);
	    			Ok.setFocusable(false);
	    			Ok.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	    			Ok.addActionListener(new ActionListener(){
	    			    @Override
	    			    public void actionPerformed(ActionEvent e) {
	    			    	
	    			    	FOS_Receipt Frame = new FOS_Receipt();
	    					Frame.FOS_Receipt_Design();
	    					dispose();
	    					
	    			        Receipt.dispose();
	    			    }
	    			});
	    			
	    			ReceiptPanel.setPreferredSize(new Dimension(350, y+50));
	    			Scroll.setPreferredSize(new Dimension(350, 500));
	    			Scroll.setViewportView(ReceiptPanel);
	    			Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    			Scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    			Scroll.setBounds(10, 10, 320, 350);
	    			ScrollBar.setUnitIncrement(20);
	    			ScrollBar.setBlockIncrement(100);
	    			
	    			ReceiptPanel.add(Ok);
	    			ReceiptPanel.add(Title);
	    			ReceiptPanel.add(SubTitle);
	    			ReceiptPanel.add(OrderRec);
	    			ReceiptPanel.add(Dash);
	    			ReceiptPanel.add(Dash2);
	    			ReceiptPanel.add(Dash3);
	    			ReceiptPanel.add(OrderNum);
	    			ReceiptPanel.add(DTLabel);
	    			Receipt.add(Scroll);

	    			Receipt.setVisible(true);
	    		} 
	    	}
	    }
	    //---------------------------------------------------------
	    
	    if(e.getSource() == Cancel) {
	    	int Yezzir = JOptionPane.showConfirmDialog(null, "Do you want to cancel this order?", "Cancel Order", JOptionPane.YES_NO_OPTION);
	    	
	    	if (Yezzir == JOptionPane.YES_OPTION) {
	    		int Yezzir2 = JOptionPane.showConfirmDialog(null, "Create new order?", "New Order", JOptionPane.YES_NO_OPTION);
	    		if (Yezzir2 == JOptionPane.YES_OPTION) {
		    		FOS_Dine_Take Frame = new FOS_Dine_Take();
		    		Frame.FOS_Dine_Take_Design();
		    		dispose();
		    	} else {
		    		dispose();
		    	}
	    	} 
	    }
	}
}
