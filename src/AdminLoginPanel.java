import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class ImageBackAdmin extends JPanel{
	 private BufferedImage img;
	ImageBackAdmin (){
		try{
			//img = ImageIO.read(new File("C:\\Users\\Taanveer Ahmeed\\Desktop\\wp\\1926935.jpg"));
			img = ImageIO.read(getClass().getResource("1926935.jpg"));
			//img = ImageIO.read(new File ("\\Selfillumination_1280_1024_by_Kutsche.jpg"));
		}catch (IOException e){
			e.printStackTrace();
		}
	}
	protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
   }
	
}

class AdminLoginPanel extends JPanel{
	
	JButton back ;
	JTextField username;
	JPasswordField password;
	JButton login;
	ImageBackAdmin tb = new ImageBackAdmin ();
	
	AdminLoginPanel (){
		
		setLayout(new GridLayout (1,0));
		
		add(tb);
		
		Font adminFont = new Font ("Serif",Font.BOLD+Font.ITALIC,25);
		
		JPanel outer = new JPanel();
		outer.setLayout(new BorderLayout());
		outer.add(back = new JButton("Back to Normal Login"),BorderLayout.PAGE_START);
		back.setFont(adminFont);
		
		JPanel p2 = new JPanel ();
		p2.setLayout(new GridLayout (7,1));
		
		JPanel schoolPanel = new JPanel ();
		JLabel school = new JLabel ("School Management System");
		Font f2 = new Font ("Serif",Font.BOLD+Font.ITALIC,38);
		school.setFont(f2);
		schoolPanel.add(school);
		
		JPanel signPanel= new JPanel ();
		JLabel sign = new JLabel ("Sign in with your Organizational ID");
		Font font = new Font ("Serif",Font.BOLD+Font.ITALIC,35);
		sign.setFont(font);
		signPanel.add(sign);
		
		
		JPanel usernamePanel = new JPanel ();
		JLabel signin;
		Font signinfont = new Font ("Serif",Font.ITALIC+Font.BOLD,30);
		usernamePanel.add(signin = new JLabel ("Username "));
		signin.setFont(signinfont);
		usernamePanel.add(username = new JTextField(10));
		username.setFont(signinfont);;
		
		JPanel passwordPanel = new JPanel ();
		JLabel pass;
		
		passwordPanel.add(pass = new JLabel ("Password "));
		pass.setFont(signinfont);
		passwordPanel.add(password = new JPasswordField(10));
		password.setFont(signinfont);;
		
		JPanel p3 = new JPanel ();
		p3.add(login = new JButton("Login"));
		
		login.setFont(signinfont);
		p2.add(schoolPanel);
		p2.add(signPanel);
		p2.add(usernamePanel);
		p2.add(passwordPanel);
		p2.add(p3);
		
		
		outer.add(p2,BorderLayout.CENTER);
		
		
		//outer.add(p3,BorderLayout.PAGE_END);
		JLabel adminPanelLabel = new JLabel ("Admin Panel  ");
		JPanel adminPanel = new JPanel ();
		Font adminPanelFont = new Font ("Serif",Font.BOLD+Font.ITALIC,36);
		adminPanelLabel.setFont(adminPanelFont);
		adminPanel.add(adminPanelLabel);
		outer.add(adminPanel, BorderLayout.PAGE_END);
		add(outer);
		
		
	}
}