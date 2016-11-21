package space_GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class Frame extends JFrame implements Runnable{

	private JPanel contentPane;
	private JPanel GamePane;
	
	private static int Sun_r;
	private static int mercury_r;
	private static int venus_r;
	private static int earth_r;
	private static int mars_r;
	
	private static int mercury_x,mercury_y;
	private static int venus_x,venus_y;
	private static int earth_x,earth_y;
	private static int mars_x,mars_y;
	
	private static int mars_orbit_x,mars_orbit_y;
	private static int earth_orbit_x,earth_orbit_y;
	private static int venus_orbit_x,venus_orbit_y;
	private static int mercury_orbit_x,mercury_orbit_y;
	
	private static int mars_orbit_r;
	private static int earth_orbit_r;
	private static int venus_orbit_r;
	private static int mercury_orbit_r;
	
	private static int paint_x,paint_y;
	private static int paint_r;
	
	private static Color PaintingColor;
	
	private static boolean opposite_mars = false;
	private static boolean opposite_earth = false;
	private static boolean opposite_venus = false;
	private static boolean opposite_mercury = false;
	
	private static boolean inGame;
	private static boolean clear;
	private static boolean selected;
	
	private JTextField txtMass;
	private JTextField txtRadius;
	/**
	 * Create the frame.
	 */
	public Frame() {
		opposite_mars = false;
		opposite_earth = false;
		opposite_venus = false;
		opposite_mercury = false;
		clear = false;
		selected = false;
		
		Sun_r = 30;
		mercury_r = 10;
		venus_r = 10;
		earth_r = 12;
		mars_r = 11;
		
		mercury_orbit_r = 90;
		venus_orbit_r = 150;
		earth_orbit_r = 200;
		mars_orbit_r = 250;
		
		mercury_orbit_x = 380;
		mercury_orbit_y = 180;
		venus_orbit_x = 350;
		venus_orbit_y = 150;
		earth_orbit_x = 325;
		earth_orbit_y = 125;
		mars_orbit_x = 300;
		mars_orbit_y = 100;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 420);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		contentPane.setVisible(true);
		setContentPane(contentPane);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		btnStartGame.setForeground(Color.WHITE);
		btnStartGame.setBackground(new Color(0, 0, 0));
		btnStartGame.setBounds(35, 149, 176, 61);
		this.getContentPane().add(btnStartGame);
		btnStartGame.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(false);
				GamePane.setVisible(true);
				inGame = true;
				setContentPane(GamePane);
				clear = true;
				repaint();
			}
			
		});
		
		JLabel lblSpaced = new JLabel("SPACE 2D");
		lblSpaced.setBackground(Color.BLACK);
		lblSpaced.setForeground(Color.WHITE);
		lblSpaced.setFont(new Font("Bauhaus 93", Font.PLAIN, 40));
		lblSpaced.setBounds(35, 72, 208, 67);
		this.getContentPane().add(lblSpaced);
		
		JButton button = new JButton("?");
		button.setForeground(Color.WHITE);
		button.setBackground(Color.BLACK);
		button.setFont(new Font("Adobe Hebrew", Font.BOLD, 40));
		button.setBounds(35, 220, 60, 49);
		this.getContentPane().add(button);
		
		//gamePanel
		GamePane = new JPanel();
		GamePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GamePane.setLayout(null);
		GamePane.setVisible(false);
		GamePane.setBackground(Color.BLACK);
		GamePane.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				//set place
				if(selected){
					paint_x = e.getX()-paint_r+20;
					paint_y = e.getY()-paint_r+40;
					repaint();
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
		});
		
		//Color buttons
		JButton btnSun = new JButton("Sun");
		btnSun.setBackground(Color.ORANGE);
		btnSun.setBounds(10, 348, 153, 23);
		GamePane.add(btnSun);
		btnSun.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				PaintingColor = Color.ORANGE;
				paint_r = Sun_r;
				selected = true;
			}
			
		});
		
		JButton btnMercury = new JButton("mercury");
		btnMercury.setBackground(Color.LIGHT_GRAY);
		btnMercury.setBounds(173, 348, 93, 23);
		GamePane.add(btnMercury);
		btnMercury.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				PaintingColor = Color.LIGHT_GRAY;
				paint_r = mercury_r;
				selected = true;
			}
			
		});
		
		JButton btnVenus = new JButton("venus");
		btnVenus.setBackground(Color.YELLOW);
		btnVenus.setBounds(276, 348, 93, 23);
		GamePane.add(btnVenus);
		btnVenus.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				PaintingColor = Color.YELLOW;
				paint_r = venus_r;
				selected = true;
			}
			
		});
		
		JButton btnEarth = new JButton("earth");
		btnEarth.setBackground(Color.BLUE);
		btnEarth.setBounds(379, 348, 93, 23);
		GamePane.add(btnEarth);
		btnEarth.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				PaintingColor = Color.BLUE;
				paint_r = earth_r;
				selected = true;
			}
			
		});
		
		JButton btnMars = new JButton("mars");
		btnMars.setBackground(Color.RED);
		btnMars.setBounds(481, 348, 93, 23);
		GamePane.add(btnMars);
		btnMars.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				PaintingColor = Color.RED;
				paint_r = mars_r;
				selected = true;
			}
			
		});
		
		JButton btnBack = new JButton("<--back");
		btnBack.setBounds(0, 0, 93, 23);
		btnBack.setBackground(Color.WHITE);
		GamePane.add(btnBack);
		btnBack.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.setVisible(true);
				GamePane.setVisible(false);
				inGame = false;
				setContentPane(contentPane);
				repaint();
			}
			
		});
		
		JButton btnClear = new JButton("clear");
		btnClear.setBounds(521, 0, 63, 23);
		btnClear.setBackground(Color.WHITE);
		btnClear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				clear = true;
				repaint();
			}
			
		});
		GamePane.add(btnClear);
		
		txtMass = new JTextField();
		txtMass.setText("mass");
		txtMass.setBounds(103, 1, 66, 21);
		GamePane.add(txtMass);
		txtMass.setColumns(10);
		
		txtRadius = new JTextField();
		txtRadius.setText("radius");
		txtRadius.setBounds(179, 1, 66, 21);
		GamePane.add(txtRadius);
		txtRadius.setColumns(10);
		
		JButton btnCreate = new JButton();
		btnCreate.setText("Create");
		btnCreate.setBounds(255, 1, 80, 21);
		btnCreate.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				int first = 0;
				int second = 0;
				try{
					first = Integer.parseInt(txtMass.getText());
				}catch(Exception e1){
					txtMass.setText("a number!");
				}
				try{
					second = Integer.parseInt(txtRadius.getText());
					if(second > 100){
						second = 100;
					}
					if(second < 0){
						second = 1;
					}
					paint_r = second;
					PaintingColor = Color.MAGENTA;
					selected = true;
				}catch(Exception e1){
					txtRadius.setText("a number!");
				}
				
			}
			
		});
		GamePane.add(btnCreate);

		Thread t = new Thread(this);
		t.start();
	}

	//Thread
	@Override
	public void run() {
		while(true){
			if(inGame){
				//run game panel

			}else{
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				//run start panel
				//System.out.println("run1");
				if(mars_x < 300){
					mars_x = 300;
				}
				if(mars_x > 300 + mars_orbit_r * 2){
					mars_x = mars_orbit_r * 2;
				}
				if(earth_x < 325){
					earth_x = 325;
				}
				if(earth_x > 300 + earth_orbit_r * 2){
					earth_x = earth_r * 2;
				}
				if(venus_x < 350){
					venus_x = 350;
				}
				if(venus_x > 300 + venus_orbit_r * 2){
					venus_x = venus_r * 2;
				}
				if(mercury_x < 380){
					mercury_x = 380;
				}
				if(mercury_x > 300 + mercury_orbit_r * 2){
					mercury_x = mercury_r * 2;
				}
				
				//check if the direction needs to be turned
				if(Place.if_turn(mars_x, mars_y, 125,300) == 1){
					opposite_mars = false;
				}else if(Place.if_turn(mars_x, mars_y, 125,300) == 2){
					opposite_mars = true;
				}
				if(Place.if_turn(earth_x, earth_y, 100,325) == 1){
					opposite_earth = false;
				}else if(Place.if_turn(earth_x, earth_y, 100,325) == 2){
					opposite_earth = true;
				}
				if(Place.if_turn(venus_x, venus_y, 75,350) == 1){
					opposite_venus = false;
				}else if(Place.if_turn(venus_x, venus_y, 75,350) == 2){
					opposite_venus = true;
				}
				if(Place.if_turn(mercury_x, mercury_y, 45,380) == 1){
					opposite_mercury = false;
				}else if(Place.if_turn(mercury_x, mercury_y, 45,380) == 2){
					opposite_mercury = true;
				}
				//move mars
				if(opposite_mars){
					mars_x --;
					mars_y = 225-(int) Math.sqrt(125*125-((mars_x-425)*(mars_x-425)))-5;
					repaint();
				}else{
					mars_x ++;
					mars_y = (int) Math.sqrt(125*125-((mars_x-425)*(mars_x-425)))+225-5;
					repaint();
				}
				//move earth
				if(opposite_earth){
					earth_x --;
					earth_y = 225-(int) Math.sqrt(100*100-((earth_x-425)*(earth_x-425)))-5;
					repaint();
				}else{
					earth_x ++;
					earth_y = (int) Math.sqrt(100*100-((earth_x-425)*(earth_x-425)))+225-5;
					repaint();
				}
				//move venus
				if(opposite_venus){
					venus_x --;
					venus_y = 225-(int) Math.sqrt(75*75-((venus_x-425)*(venus_x-425)))-5;
					repaint();
				}else{
					venus_x ++;
					venus_y = (int) Math.sqrt(75*75-((venus_x-425)*(venus_x-425)))+225-5;
					repaint();
				}
				//move mercury
				if(opposite_mercury){
					//System.out.println("neg");
					mercury_x --;
					mercury_y = 225-(int) Math.sqrt(45*45-((mercury_x-425)*(mercury_x-425)))-5;
					repaint();
				}else{
					mercury_x ++;
					mercury_y = (int) Math.sqrt(45*45-((mercury_x-425)*(mercury_x-425)))+225-5;
					repaint();
				}
			}
		}
	}
	
	public void paint(Graphics g){
		if(inGame){
			//draw in game panel
			//clear button clicked
			if(clear){
				super.paint(g);
				g.clearRect(0, 50, 600, 320);
				g.fillRect(0, 50, 600, 320);
				clear = false;
			}
			if(selected){
				g.setColor(PaintingColor);
				g.fillOval(paint_x, paint_y, paint_r, paint_r);
				selected = false;
			}
		}else{
			//draw in start panel
			//System.out.println("paint");
			super.paint(g);
			g.setColor(Color.BLACK);
			g.clearRect(290, 90, 270, 270);
			g.fillRect(290, 90, 270, 270);
			//draw orbits
			g.setColor(Color.WHITE);
			//mars
			g.drawArc(mars_orbit_x, mars_orbit_y, mars_orbit_r, mars_orbit_r, 0, 360);
			//earth
			g.drawArc(earth_orbit_x, earth_orbit_y, earth_orbit_r, earth_orbit_r, 0, 360);
			//venus
			g.drawArc(venus_orbit_x, venus_orbit_y, venus_orbit_r, venus_orbit_r, 0, 360);
			//mercury
			g.drawArc(mercury_orbit_x, mercury_orbit_y, mercury_orbit_r, mercury_orbit_r, 0, 360);
			
			//draw objects(NOT TO SCALE)
			//sun
			g.setColor(Color.ORANGE);
			g.fillArc(410, 210, Sun_r, Sun_r, 0, 360);
			//mercury
			g.setColor(Color.LIGHT_GRAY);
			g.fillArc(mercury_x, mercury_y, mercury_r, mercury_r, 0, 360);
			//venus
			g.setColor(Color.YELLOW);
			g.fillArc(venus_x, venus_y, venus_r, venus_r, 0, 360);
			//earth
			g.setColor(Color.BLUE);
			g.fillArc(earth_x, earth_y, earth_r, earth_r, 0, 360);
			//mars
			g.setColor(Color.RED);
			g.fillArc(mars_x, mars_y, mars_r, mars_r, 0, 360);
		}
	}
}