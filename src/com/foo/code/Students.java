package com.foo.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;


public class Students {
	private Surs surname;
	private String initials;
	private Groups groupNumber;
	private int[] academicPerformance = new int[5];
	private double average;
	
	private static Logger myLog = Logger.getLogger(Students.class.getName());
	

	Students(){
			
		surname = Surs.getRandomSur();
		initials = " " + Initials.someLetter() + ". " + Initials.someLetter() + ". "; 
		groupNumber = Groups.pickGroup();
		
		for(int i = 0; i < academicPerformance.length; i++){
			academicPerformance[i] = new Random().nextInt(5) + 1;
			average += academicPerformance[i];
		}
		
		average /= academicPerformance.length; 
		
		//myLog.info(surname.toString());
	}
	
	public static void studBubbleSort(Students[] arr){
		
		Students temp;

		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length - i - 1; j++){
				if(arr[j].average > arr[j + 1].average){
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

	}
	
	public static void main(String[] args){
		
		Students[] stud = new Students[10];
		for(int i = 0; i < stud.length; i++){
			stud[i] = new Students();
		}
		
		studBubbleSort(stud);
		
		for(Students s : stud){
			if(s.average >= 3.0)
				System.out.println("==== G O O D  J O B ====");
			
			System.out.print(s.surname + " ");
			System.out.println(s.initials);
			System.out.println(s.groupNumber);
			System.out.println(Arrays.toString(s.academicPerformance));
			System.out.println("Average mark: " + s.average + '\n');
		}
		
	}
	
	
}

enum Initials{
	A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R, S, T, U, V, W, X, Y, Z;
	
	public static Initials someLetter(){
		Random rand = new Random();
		return values()[rand.nextInt(values().length)];
	}
}

enum Groups{
	RK101,
	RI101,
	RK111,
	RI111,
	RK121, 
	RI121,
	RK131,
	RI131;
	
	public static Groups pickGroup(){
		Random rand = new Random();
		return values()[rand.nextInt(values().length)];
	}
}


enum Surs{
	Smith, 
	Defoe,
	Li,
	Oneil,
	Mort,
	Simpson,
	House,
	Who,
	Sanchez,
	Olly,
	Matus,
	Henaro,
	Aberdine,
	Burroughs,
	Borges,
	Edison,
	Einstein, 
	Euler, 
	Gauss,
	Newton;
	
	public static Surs getRandomSur(){
		Random rand = new Random();
		return values()[rand.nextInt(values().length)];
	}
}