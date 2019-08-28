package com.myproject.textgame;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Player player = new Player();
		Enemy enemy = new Enemy();
		Random rand = new Random();
		Scanner sc = new Scanner(System.in);
		boolean running = true;	
		
		System.out.println("\tWelcom to the dungeon !");
	
		GAME:
		while(running) {
			System.out.println("----------------------------------------------");
			
			int enemyHealth = rand.nextInt(enemy.enemyHealth);
			String enemyName = enemy.enemies[rand.nextInt(enemy.enemies.length)];
			System.out.println("\t# " + enemyName + " has appeared! #");
			
			while(enemyHealth > 0 ) {
				System.out.println("\tYour HP : " + player.health);
				System.out.println("\t" + enemyName + "'s HP : " + enemyHealth);
				System.out.println("\n\tWhat would you like to do?");
				System.out.println("\t1. Attack");
				System.out.println("\t2. Drink potion");
				System.out.println("\t3. Run!");
				
				String input = sc.nextLine();
				if(input.equals("1")) {
					int damageDealt = rand.nextInt(player.attackDamage);
					int damageTaken = rand.nextInt(enemy.enemyDamage);
					
					enemyHealth -= damageDealt;
					player.health -= damageTaken;
					
					System.out.println("\t- You strike the " + enemyName + " for " + damageDealt + " damage.");
					System.out.println("\t- You receive " + damageTaken + " in retaliation!");
					
					if(player.health < 1) {
						System.out.println("\t- You have taken too much damage. Drink potion!!");
					}
				}
				else if (input.contentEquals("2")) {
					if(player.numHealPotions > 0) {
						player.health += player.healAmount;
						player.numHealPotions--;
						System.out.println("\t- You drink a health potion, healing yourself for " + player.healAmount + "."
								+ "\n\t- You now have " + player.health + " HP."
								+ "\n\t- You now have " + player.numHealPotions + " health potions left.\n");
					}
					else {
						System.out.println("\t- You have no health potions left! Defeat enemies for a chance to get one!");
					}
				}
				else if (input.contentEquals("3")) {
					System.out.println("\tYou run away from the " + enemyName + "!");
					continue GAME;
				}
				else {
					System.out.println("\tInvalid command!!");
				}

			}
			
			if(player.health < 1) {
				System.out.println("YOU DIED !");
				break;
			}
			
			System.out.println("----------------------------------------------");
			System.out.println(" # " + enemyName + " was defeated! # ");
			System.out.println(" # You have " + player.health + " HP left. #" );
			
			if(rand.nextInt(100) < player.potionDropChance) {
				player.numHealPotions++;
				System.out.println(" # The " + enemyName + " dropped a health potion! # " );
				System.out.println(" # You now have " + player.numHealPotions + " health potions. # " );
			}
			System.out.println("----------------------------------------------");
			System.out.println("What would you like to do now?");
			System.out.println("1. Continue fighting");
			System.out.println("2. Exit dungeon");
			
			String input = sc.nextLine();
			
			while(!input.equals("1") && !input.equals("2")) {
				System.out.println("Invalid command!");
				input = sc.nextLine();
			}
			
			if(input.contentEquals("1")) {
				System.out.println("You continue on your adventure!");
			}
			else if(input.contentEquals("2")) {
				System.out.println("You exit the dungeon, successful from your adventures!");
				break;
			}
		}
		
		System.out.println("##################");
		System.out.println("THANKS FOR PLAYING");
		System.out.println("##################");
	}

}
