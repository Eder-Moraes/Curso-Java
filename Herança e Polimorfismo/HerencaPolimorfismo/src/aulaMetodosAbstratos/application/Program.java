package aulaMetodosAbstratos.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import aulaMetodosAbstratos.entities.Circle;
import aulaMetodosAbstratos.entities.Rectangle;
import aulaMetodosAbstratos.entities.Shape;
import aulaMetodosAbstratos.entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List<Shape> shapes = new ArrayList<>();

		System.out.print("Enter the number of shapes: ");
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			System.out.println("Shape #"+i+" data:");
			System.out.print("Rectangle or Circle (r/c)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Color (BLACK/BLUE/RED): ");
			Color color = Color.valueOf(sc.next());
			if(ch == 'r') {
				System.out.print("Width: ");
				double width = sc.nextDouble();
				System.out.print("Height: ");
				double height = sc.nextDouble();
				Shape shape = new Rectangle(color, width, height);
				shapes.add(shape);
			}
			else {
				System.out.print("Radius: ");
				double radius = sc.nextDouble();
				Shape shape = new Circle(color, radius);
				shapes.add(shape);
			}
		}
		
		System.out.println("\nSHAPE AREAS:");
		
		for (Shape shape : shapes) {
			System.out.println(String.format("%.2f", shape.area()));
		}
		
		sc.close();
	}

}
