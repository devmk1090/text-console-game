package com.myproject.textgame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {

	JFrame frame;
	Container con;
	JPanel titleNamePanel, startBtnPanel, mainTxtPanel, selectBtnPanel, playerPanel;
	JButton startBtn, select1, select2, select3;
	JLabel titleNameLab, playerHpLabel, playerHpLabelName, weaponLabel, weaponLabelName;
	JTextArea mainTxtArea;
	Font Nfont = new Font("Arial", Font.PLAIN, 28);
	
	Random rand = new Random();
	int playerHP, monsterHP, potion;
	String weapon, position;
	String [] monsters = {"Warrior", "DeathKnight", "Assassin", "Orc", "Undead"};
	String randomMonsters = monsters[rand.nextInt(monsters.length)];
	
	TitleScreen ms = new TitleScreen();
	SelectScreen ss = new SelectScreen();

	public static void main(String[] args) {

		new Game();

	}

	public Game() {

		frame = new JFrame();
		frame.setSize(1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.black);
		frame.setLayout(null);
		con = frame.getContentPane();

		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 150, 800, 150);
		titleNamePanel.setBackground(Color.BLACK);

		titleNameLab = new JLabel("MONSTER WORLD");
		titleNameLab.setForeground(Color.white);
		titleNameLab.setFont(new Font("Arial", Font.BOLD, 80));

		startBtnPanel = new JPanel();
		startBtnPanel.setBounds(300, 450, 400, 100);
		startBtnPanel.setBackground(Color.black);

		startBtn = new JButton("START");
		startBtn.setBackground(Color.black);
		startBtn.setForeground(Color.white);
		startBtn.setFont(new Font("Arial", Font.BOLD, 32));
		startBtn.setFocusPainted(false);
		startBtn.addActionListener(ms);

		titleNamePanel.add(titleNameLab);
		startBtnPanel.add(startBtn);
		con.add(titleNamePanel);
		con.add(startBtnPanel);
		frame.setVisible(true);
	}

	public void selectGame() {
		
		titleNamePanel.setVisible(false);
		startBtnPanel.setVisible(false);
		
		mainTxtPanel = new JPanel();
		mainTxtPanel.setBounds(50, 400, 600, 250);
		mainTxtPanel.setBackground(Color.black);
		con.add(mainTxtPanel);
		
		mainTxtArea = new JTextArea("Welcome to the Monster World !");
		mainTxtArea.setBounds(50, 400, 600 ,250);
		mainTxtArea.setForeground(Color.white);
		mainTxtArea.setBackground(Color.black);
		mainTxtArea.setFont(new Font("Arial", Font.PLAIN, 24));
		mainTxtArea.setLineWrap(true);
		mainTxtPanel.add(mainTxtArea);
		
		selectBtnPanel = new JPanel();
		selectBtnPanel.setBounds(700, 400, 250, 250);
		selectBtnPanel.setBackground(Color.black);
		selectBtnPanel.setLayout(new GridLayout(4,1));
		con.add(selectBtnPanel);
		
		select1 = new JButton("select1");
		select1.setBackground(Color.black);
		select1.setForeground(Color.white);
		select1.setFont(Nfont);
		selectBtnPanel.add(select1);
		select1.setActionCommand("s1");
		select1.addActionListener(ss);
		
		select2 = new JButton("select1");
		select2.setBackground(Color.black);
		select2.setForeground(Color.white);
		select2.setFont(Nfont);
		selectBtnPanel.add(select2);
		select2.setActionCommand("s2");
		select2.addActionListener(ss);
		
		select3 = new JButton("select1");
		select3.setBackground(Color.black);
		select3.setForeground(Color.white);
		select3.setFont(Nfont);
		selectBtnPanel.add(select3);
		select3.setActionCommand("s3");
		select3.addActionListener(ss);
		
		playerPanel = new JPanel();
		playerPanel.setBounds(700, 100, 250, 100);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(2, 2));
		con.add(playerPanel);
		
		playerHpLabel = new JLabel("HP:");
		playerHpLabel.setForeground(Color.white);
		playerHpLabel.setFont(Nfont);
		playerPanel.add(playerHpLabel);
		
		playerHpLabelName = new JLabel("");
		playerHpLabelName.setForeground(Color.white);
		playerHpLabelName.setFont(Nfont);
		playerPanel.add(playerHpLabelName);
		
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setForeground(Color.white);
		weaponLabel.setFont(Nfont);
		playerPanel.add(weaponLabel);
		
		weaponLabelName = new JLabel("");
		weaponLabelName.setForeground(Color.white);
		weaponLabelName.setFont(Nfont);
		playerPanel.add(weaponLabelName);
		
		playerSetting();
	}
	
	public void playerSetting() {
		
		playerHP = 20;
		monsterHP = 30;
		playerHpLabelName.setText("" + playerHP);
		weapon = "Knife";
		weaponLabelName.setText(weapon);
		
		town();
	}
	
	public void town() {
		
		position = "town";
		mainTxtArea.setText("You arrived the town.");
		select1.setText("Go to the field");		
		select2.setText("Store");
		select3.setText("");
	}
	
	public void store() {
		
		position = "store";
		mainTxtArea.setText("Welcome stranger. \n\nWhat do you need ?");
		select1.setText("Short Sword");
		select2.setText("Long Sword");
		select3.setText("Go back town");
	}
	
	public void shortSword() {
		weapon = "Short Sword";
		weaponLabelName.setText(weapon);
	}
	
	public void longSword() {
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
	}
	
	public void field() {
		
		position = "field";
		mainTxtArea.setText("You encounter a monster");
		select1.setText("Fight");
		select2.setText("Run1");
		select3.setText("");
	}
	
	public void fight() {
		
		position = "fight";
		mainTxtArea.setText(randomMonsters + " HP: " + monsterHP + "\nWhat do you do?");
		select1.setText("Attack");
		select2.setText("Run");
		select3.setText("");
	}
	
	public void playerAttack() {
		
		position = "playerAttack";
		int playerDamage = 0;
		if(weapon.contentEquals("Knife")) {
			playerDamage = rand.nextInt(3);
		}
		else if (weapon.contentEquals("Short Sword")) {
			playerDamage = rand.nextInt(9);
		}
		else if(weapon.contentEquals("Long Sword")) {
			playerDamage = rand.nextInt(18);
		}
		
		mainTxtArea.setText("You attacked monster " + playerDamage + " damage!" );
		monsterHP = monsterHP - playerDamage;
		
		select1.setText("Next");
		select2.setText("");
		select3.setText("");
		
	}
	
	public void monsterAttack() {
		
		position = "monsterAttack";
		int monsterDamage = 0;
		monsterDamage = rand.nextInt(7);
		
		mainTxtArea.setText("The " + randomMonsters +" attacked you " + monsterDamage + " damage!");
		
		playerHP = playerHP - monsterDamage;
		playerHpLabelName.setText("" + playerHP);
		
		select1.setText("Next");
		select2.setText("");
		select3.setText("");
	}
	
	public void win() {
		
		position = "win";
		
		mainTxtArea.setText("You killed the " + randomMonsters + "!" + "\nThe " + randomMonsters + " dropped potion\n(You obtained potion)");
	
		potion = 1;
		
		select1.setText("Go back town");
		select2.setText("");
		select3.setText("");
	}
	
	public void lose() {
		
		position = "lose";
		
		mainTxtArea.setText("You died!!\n\n<GAME OVER>");

		select1.setText("");
		select2.setText("");
		select3.setText("");
		select1.setVisible(false);
		select2.setVisible(false);
		select3.setVisible(false);
	}
	
	public class SelectScreen implements ActionListener{
		public void actionPerformed(ActionEvent event) {
			
			String yourSelect = event.getActionCommand();
			
			switch(position) {
			case "town":
				switch(yourSelect) {
				case "s1": field(); break;
				case "s2": store(); break;
				}
				break;
			case "store":
				switch(yourSelect) {
				case "s1": shortSword();break;
				case "s2": longSword(); break;
				case "s3": town(); break;
				}
				break;
			case "field":
				switch(yourSelect) {
				case "s1": fight(); break;
				case "s2": town(); break;
				}
				break;
			case "fight":
				switch(yourSelect) {
				case "s1": playerAttack(); break;
				case "s2": town(); break;
				}
				break;
			case "playerAttack":
				switch(yourSelect) {
				case "s1": 
					if(monsterHP<1) {
						win();
					}
					else {
						monsterAttack();
					}
					break;
				}
				break;
			case "monsterAttack":
				switch(yourSelect) {
				case "s1": 
					if(playerHP<1) {
						lose();
					}
					else {
						fight();
					}
					break;
				}
				break;
			case "win":
				switch(yourSelect) {
				case "s1": town(); break;
				}
				break;
			}
		}
	}
	
//		GAME: while (running) {
//			System.out.println("----------------------------------------------");
//
//			int enemyHealth = rand.nextInt(enemy.enemyHealth);
//			String enemyName = enemy.enemies[rand.nextInt(enemy.enemies.length)];
//			System.out.println("\t# " + enemyName + " has appeared! #");
//
//			while (enemyHealth > 0) {
//				System.out.println("\tYour HP : " + player.health);
//				System.out.println("\t" + enemyName + "'s HP : " + enemyHealth);
//				System.out.println("\n\tWhat would you like to do?");
//				System.out.println("\t1. Attack");
//				System.out.println("\t2. Drink potion");
//				System.out.println("\t3. Run!");
//
//				String input = sc.nextLine();
//				if (input.equals("1")) {
//					int damageDealt = rand.nextInt(player.attackDamage);
//					int damageTaken = rand.nextInt(enemy.enemyDamage);
//
//					enemyHealth -= damageDealt;
//					player.health -= damageTaken;
//
//					System.out.println("\t- You strike the " + enemyName + " for " + damageDealt + " damage.");
//					System.out.println("\t- You receive " + damageTaken + " in retaliation!");
//
//					if (player.health < 1) {
//						System.out.println("\t- You have taken too much damage. Drink potion!!");
//					}
//				} else if (input.contentEquals("2")) {
//					if (player.numHealPotions > 0) {
//						player.health += player.healAmount;
//						player.numHealPotions--;
//						System.out.println("\t- You drink a health potion, healing yourself for " + player.healAmount
//								+ "." + "\n\t- You now have " + player.health + " HP." + "\n\t- You now have "
//								+ player.numHealPotions + " health potions left.\n");
//					} else {
//						System.out.println(
//								"\t- You have no health potions left! Defeat enemies for a chance to get one!");
//					}
//				} else if (input.contentEquals("3")) {
//					System.out.println("\tYou run away from the " + enemyName + "!");
//					continue GAME;
//				} else {
//					System.out.println("\tInvalid command!!");
//				}
//
//			}
//
//			if (player.health < 1) {
//				System.out.println("YOU DIED !");
//				break;
//			}
//
//			System.out.println("----------------------------------------------");
//			System.out.println(" # " + enemyName + " was defeated! # ");
//			System.out.println(" # You have " + player.health + " HP left. #");
//
//			if (rand.nextInt(100) < player.potionDropChance) {
//				player.numHealPotions++;
//				System.out.println(" # The " + enemyName + " dropped a health potion! # ");
//				System.out.println(" # You now have " + player.numHealPotions + " health potions. # ");
//			}
//			System.out.println("----------------------------------------------");
//			System.out.println("What would you like to do now?");
//			System.out.println("1. Continue fighting");
//			System.out.println("2. Exit dungeon");
//
//			String input = sc.nextLine();
//
//			while (!input.equals("1") && !input.equals("2")) {
//				System.out.println("Invalid command!");
//				input = sc.nextLine();
//			}
//
//			if (input.contentEquals("1")) {
//				System.out.println("You continue on your adventure!");
//			} else if (input.contentEquals("2")) {
//				System.out.println("You exit the dungeon, successful from your adventures!");
//				break;
//			}
//		}
//
//		System.out.println("##################");
//		System.out.println("THANKS FOR PLAYING");
//		System.out.println("##################");

	public class TitleScreen implements ActionListener {

		public void actionPerformed(ActionEvent event) {

			selectGame();
		}
	}

}
