package skyWar;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GameGUI extends JFrame { 


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Game game = new Game();
	private JPanel contentPane;
	private JButton moveButton;
	private JButton defensiveButton;
	private JButton OffensiveMode;
	private JButton startButton;
	private JButton ResumeButton;
	private JButton saveButton;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JLabel label6;
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label10;
	private JLabel label11;
	private JLabel label12;
	private JLabel label13;
	private JLabel label14;
	private JLabel label15;
	private JLabel label16;
	private JLabel spaceLabel;
	private ImageIcon master = new ImageIcon(getClass().getResource("master.png"));
	private ImageIcon bCruiser = new ImageIcon(getClass().getResource("cruiser.png"));
	private ImageIcon bShooter = new ImageIcon(getClass().getResource("shooter.png"));
	private ImageIcon bStar = new ImageIcon(getClass().getResource("star.png"));
	private ImageIcon spaceImage = new ImageIcon(getClass().getResource("space.jpeg"));
	private JLabel labelMasterIcon;
	private JLabel labelBstarIcon;
	private JLabel labelBcruiserIcon;
	private JLabel labelBshooterIcon;
	private JLabel masterLabel;
	private JLabel bstarLabel;
	private JLabel bcruiserLabel;
	private JLabel bshooterLabel;
	

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		GameGUI game = new GameGUI();
		game.setVisible(true);
		game.setBounds(100, 30, 900, 900);
		
	}
	/**
	 * Create the frame.
	 */
	public GameGUI() {
		spaceLabel = new JLabel(spaceImage);
		spaceLabel.setSize(900, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE );
		setBounds(100, 100, 886, 763);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(spaceLabel);
		spaceLabel.add(getLabel1());
		spaceLabel.add(getLabel2());
		spaceLabel.add(getLabel3());
		spaceLabel.add(getLabel4());
		spaceLabel.add(getLabel5());
		spaceLabel.add(getLabel6());
		spaceLabel.add(getLabel7());
		spaceLabel.add(getLabel8());
		spaceLabel.add(getLabel9());
		spaceLabel.add(getLabel10());
		spaceLabel.add(getLabel11());
		spaceLabel.add(getLabel12());
		spaceLabel.add(getLabel13());
		spaceLabel.add(getLabel14());
		spaceLabel.add(getLabel15());
		spaceLabel.add(getLabel16());
		spaceLabel.add(getSaveButton());
		spaceLabel.add(getResumeButton());
		spaceLabel.add(getOffensiveMode());
		spaceLabel.add(getDefensiveButton());
		spaceLabel.add(getLabelBshooterIcon());
		spaceLabel.add(getLabelBcruiserIcon());
		spaceLabel.add(getLabelMasterIcon());
		spaceLabel.add(getMoveButton());
		spaceLabel.add(getStartButton());
		spaceLabel.add(getLabelBstarIcon());
		spaceLabel.add(getBstarLabel());
		spaceLabel.add(getBcruiserLabel());
		spaceLabel.add(getBshooterLabel());
		spaceLabel.add(getMasterLabel());
	
		
	}
	

	private JButton getMoveButton() {
		if (moveButton == null) {
			moveButton = new JButton("Move");
			moveButton.setForeground(new Color(255, 255, 51));
			moveButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 24));
			moveButton.setOpaque(false);
			moveButton.setContentAreaFilled(false);
			moveButton.setBorderPainted(false);
			moveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(game.moveButton()) {
						dispose();
					}
					updateTheGrid();		
			}			
			});
			moveButton.setBounds(388, 6, 117, 29);
		}
		return moveButton;
	}
	private JButton getDefensiveButton() {
		if (defensiveButton == null) {
			defensiveButton = new JButton("Defensive Mode");
			defensiveButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
			defensiveButton.setForeground(new Color(255, 255, 51));
			defensiveButton.setOpaque(false);
			defensiveButton.setContentAreaFilled(false);
			defensiveButton.setBorderPainted(false);
			defensiveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					game.defensiveMode();
					
				}
			});
			defensiveButton.setBounds(0, 0, 144, 29);
			

		}
		return defensiveButton;
	}
	private JButton getOffensiveMode() {
		if (OffensiveMode == null) {
			OffensiveMode = new JButton("Offensive Mode");
			OffensiveMode.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
			OffensiveMode.setForeground(new Color(255, 255, 51));
			OffensiveMode.setOpaque(false);
			OffensiveMode.setContentAreaFilled(false);
			OffensiveMode.setBorderPainted(false);
			OffensiveMode.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					game.OffensiveMode();
					
				}
			});
			OffensiveMode.setBounds(744, 0, 150, 25);
		}
		return OffensiveMode;
	}
	private JButton getStartButton() {
		if (startButton == null) {
			startButton = new JButton("Start Game");
			startButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					game.startButton();
					updateTheGrid();
				}
			});
			startButton.setForeground(new Color(255, 255, 51));
			startButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 34));
			startButton.setBounds(311, 676, 300, 53);
			startButton.setOpaque(false);
			startButton.setContentAreaFilled(false);
			startButton.setBorderPainted(false);
		}
		return startButton;
	}
	private JButton getResumeButton() {
		if (ResumeButton == null) {
			ResumeButton = new JButton("Resume Game");
			ResumeButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
			ResumeButton.setForeground(new Color(255, 255, 51));
			ResumeButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					game.setSkyWar(game.resumeButton());
					updateTheGrid();
				}
			});

			ResumeButton.setBounds(0, 700, 150, 29);
			ResumeButton.setOpaque(false);
			ResumeButton.setContentAreaFilled(false);
			ResumeButton.setBorderPainted(false);
		}
		return ResumeButton;
	}
	private JButton getSaveButton() {
		if (saveButton == null) {
			saveButton = new JButton("Save Game");
			saveButton.setFont(new Font("Comic Sans MS", Font.ITALIC, 12));
			saveButton.setForeground(new Color(255, 255, 51));
			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					game.saveButton(game);
				}
			});
			saveButton.setBounds(763, 700, 150, 29);
			saveButton.setOpaque(false);
			saveButton.setContentAreaFilled(false);
			saveButton.setBorderPainted(false);
		}
		return saveButton;
	}

	


	/*
	 * 
	 * 
	 * 		Update Grid
	 * 
	 * 
	 */
//................................................................................................................................................................
	
	public void addIconsToLabelsTheGrid(JLabel label, int row, int col) {

		if(game.getSkyWar().getGrid().getARow(row).getASquare(col).isMastershipOn()) {
			System.out.println("Master --> row: " + row + " column: " + col);
			label.setIcon(master);
		}
		else if(game.getSkyWar().getGrid().getARow(row).getASquare(col).getNumberOfEnemyShips() > 0) {
			if(game.getSkyWar().getGrid().getARow(row).getASquare(col).getenemywithIndex(0).getShipKind() == 1 ) {
				System.out.println("BattleStar --> row: " + row + " column: " + col);
				label.setIcon(bStar);
			}
			else if(game.getSkyWar().getGrid().getARow(row).getASquare(col).getenemywithIndex(0).getShipKind() == 2) {
				System.out.println("BattleCruiser --> row: " + row + " column: " + col);
				label.setIcon(bCruiser);
			}
			else if(game.getSkyWar().getGrid().getARow(row).getASquare(col).getenemywithIndex(0).getShipKind() == 3) {
				System.out.println("BattleShooter --> row: " + row + " column: " + col);
				label.setIcon(bShooter);
			}			
		}else {
			label.setIcon(null);
		}

	}// end of ddIconsToLabelsTheGrid(JLabel label, int row, int col)
	
	public void updateTheGrid() {
		addIconsToLabelsTheGrid(label1, 1, 1 );
		addIconsToLabelsTheGrid(label2, 1, 2 );
		addIconsToLabelsTheGrid(label3, 1, 3 );
		addIconsToLabelsTheGrid(label4, 1, 4 );
		addIconsToLabelsTheGrid(label5, 2, 1 );
		addIconsToLabelsTheGrid(label6, 2, 2 );
		addIconsToLabelsTheGrid(label7, 2, 3 );
		addIconsToLabelsTheGrid(label8, 2, 4 );
		addIconsToLabelsTheGrid(label9, 3, 1 );
		addIconsToLabelsTheGrid(label10, 3, 2 );
		addIconsToLabelsTheGrid(label11, 3, 3 );
		addIconsToLabelsTheGrid(label12, 3, 4 );
		addIconsToLabelsTheGrid(label13, 4, 1 );
		addIconsToLabelsTheGrid(label14, 4, 2 );
		addIconsToLabelsTheGrid(label15, 4, 3 );
		addIconsToLabelsTheGrid(label16, 4, 4 );
	}// end of updateTheGrid()

	private JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("");
			label1.setBounds(79, 81, 100, 100);


		}
		return label1;
	}
	private JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("");
			label2.setBounds(247, 81, 100, 100);
		}
		return label2;
	}
	private JLabel getLabel3() {
		if (label3 == null) {
			label3 = new JLabel("");
			label3.setBounds(478, 81, 100, 100);

		}
		return label3;
	}
	private JLabel getLabel4() {
		if (label4 == null) {
			label4 = new JLabel("");
			label4.setBounds(665, 81, 100, 100);
		}
		return label4;
	}
	private JLabel getLabel5() {
		if (label5 == null) {
			label5 = new JLabel("");
			label5.setBounds(79, 230, 100, 100);
		}
		return label5;
	}
	private JLabel getLabel6() {
		if (label6 == null) {
			label6 = new JLabel("");
			label6.setBounds(247, 230, 100, 100);
		}
		return label6;
	}
	private JLabel getLabel7() {
		if (label7 == null) {
			label7 = new JLabel("");
			label7.setBounds(478, 214, 100, 100);
		}
		return label7;
	}
	private JLabel getLabel8() {
		if (label8 == null) {
			label8 = new JLabel("");
			label8.setBounds(665, 214, 100, 100);
		}
		return label8;
	}
	private JLabel getLabel9() {
		if (label9 == null) {
			label9 = new JLabel("");
			label9.setBounds(79, 358, 100, 100);
		}
		return label9;
	}
	private JLabel getLabel10() {
		if (label10 == null) {
			label10 = new JLabel("");
			label10.setBounds(258, 358, 100, 100);
		}
		return label10;
	}
	private JLabel getLabel11() {
		if (label11 == null) {
			label11 = new JLabel("");
			label11.setBounds(478, 358, 100, 100);
		}
		return label11;
	}
	private JLabel getLabel12() {
		if (label12 == null) {
			label12 = new JLabel("");
			label12.setBounds(665, 358, 100, 100);
		}
		return label12;
	}
	private JLabel getLabel13() {
		if (label13 == null) {
			label13 = new JLabel("");
			label13.setBounds(79, 510, 100, 100);
		}
		return label13;
	}
	private JLabel getLabel14() {
		if (label14 == null) {
			label14 = new JLabel("");
			label14.setBounds(258, 510, 100, 100);
		}
		return label14;
	}
	private JLabel getLabel15() {
		if (label15 == null) {
			label15 = new JLabel("");
			label15.setBounds(478, 510, 100, 100);
		}
		return label15;
	}
	private JLabel getLabel16() {
		if (label16 == null) {
			label16 = new JLabel("");
			label16.setBounds(665, 510, 100, 100);

		}
		return label16;
	}
	
	private JLabel getLabelMasterIcon() {
		if (labelMasterIcon == null) {
			labelMasterIcon = new JLabel("");
			labelMasterIcon.setBounds(803, 169, 77, 78);
			labelMasterIcon.setIcon(master);
		}
		return labelMasterIcon;
	}
	private JLabel getLabelBstarIcon() {
		if (labelBstarIcon == null) {
			labelBstarIcon = new JLabel("");
			labelBstarIcon.setBounds(803, 279, 77, 64);
			labelBstarIcon.setIcon(bStar);
		}
		return labelBstarIcon;
	}
	
	private JLabel getLabelBcruiserIcon() {
		if (labelBcruiserIcon == null) {
			labelBcruiserIcon = new JLabel("");
			labelBcruiserIcon.setBounds(803, 379, 77, 64);
			labelBcruiserIcon.setIcon(bCruiser);
		}
		return labelBcruiserIcon;
	}
	
	private JLabel getLabelBshooterIcon() {
		if (labelBshooterIcon == null) {
			labelBshooterIcon = new JLabel("");
			labelBshooterIcon.setBounds(803, 478, 77, 64);
			labelBshooterIcon.setIcon(bShooter);
		}
		return labelBshooterIcon;
	}
	

	private JLabel getMasterLabel() {
		if (masterLabel == null) {
			masterLabel = new JLabel("MasterShip");
			masterLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
			masterLabel.setForeground(new Color(255, 255, 51));
			masterLabel.setBounds(805, 159, 61, 16);
		}
		return masterLabel;
	}
	private JLabel getBstarLabel() {
		if (bstarLabel == null) {
			bstarLabel = new JLabel("BattleStar");
			bstarLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
			bstarLabel.setForeground(new Color(255, 255, 51));
			bstarLabel.setBounds(805, 264, 61, 16);
		}
		return bstarLabel;
	}
	
	private JLabel getBcruiserLabel() {
		if (bcruiserLabel == null) {
			bcruiserLabel = new JLabel("BattleCruiser");
			bcruiserLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
			bcruiserLabel.setForeground(new Color(255, 255, 51));
			bcruiserLabel.setBounds(805, 361, 70, 16);
		}
		return bcruiserLabel;
	}
	
	private JLabel getBshooterLabel() {
		if (bshooterLabel == null) {
			bshooterLabel = new JLabel("BattleShooter");
			bshooterLabel.setFont(new Font("Comic Sans MS", Font.ITALIC, 10));
			bshooterLabel.setForeground(new Color(255, 255, 51));
			bshooterLabel.setBounds(805, 460, 70, 16);
		}
		return bshooterLabel;
	}
}// end of GUI class
