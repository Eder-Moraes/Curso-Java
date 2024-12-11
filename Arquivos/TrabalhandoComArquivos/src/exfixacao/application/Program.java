package exfixacao.application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exfixacao.models.entities.Produto;

public class Program {

	public static void main(String[] args) {
		
		String path = "c:\\temp\\produtos.csv";
		List<Produto> produtos = new ArrayList<>();

		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			while(line != null) {
				String[] atributos = line.split(";");
				Produto produto = new Produto(atributos[0], Double.parseDouble(atributos[1]), Integer.parseInt(atributos[2]));
				produtos.add(produto);
				line = br.readLine();
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		File sourceFile = new File(path);
		File pathCreate = new File(sourceFile.getParent()+"\\out");
		pathCreate.mkdir();
		
		path = pathCreate.getPath()+"\\summary.csv";
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for(Produto p:produtos) {
				bw.write(p.getName()+";"+String.format("%.2f", p.totalValue()));
				bw.newLine();
			}
			System.out.println("Summary criado com sucesso!");
		} catch(IOException e) {
			e.printStackTrace();
		}

	}

}
