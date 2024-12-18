package exfixacaomap.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<String, Integer> candidatosVotos = new LinkedHashMap<String, Integer>();
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] filds = line.split(",");
				if(candidatosVotos.containsKey(filds[0])) {
					int valorBefore = candidatosVotos.get(filds[0]);
					candidatosVotos.put(filds[0], valorBefore + Integer.parseInt(filds[1]));
				} else {
					candidatosVotos.put(filds[0], Integer.parseInt(filds[1]));
				}

				line = br.readLine();
			}
			
		}catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
		
		for(String key:candidatosVotos.keySet()) {
			System.out.println(key+": "+candidatosVotos.get(key));
		}
		
		sc.close();
	}
	
}
