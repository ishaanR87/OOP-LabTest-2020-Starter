
package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	
	ArrayList<Task> tasks = new ArrayList<Task>();

	//declaring variables

	float yBorder; // Y axis border 
	float xBorder; // X axis border
	float w; // variable to readjust width of the boxes in the graph


	

	public void settings()
	{
		size(800, 600);
		xBorder = width * 0.05f; //width of screen
		yBorder = height * 0.10f; //height if screen
		w = width * 0.20f; //the boxes will be a fifth percent if the width of the screen
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header"); //loads the csv file
		for(TableRow row:table.rows())
		{
			Task t = new Task(row);
			tasks.add(t);

		}
	}

	public void printTasks() //prints csv file
	{
		for(Task t:tasks)
		{
			System.out.println(t);
		}
	}

	public void displayTasks()
	{
		for(int i = 1 ; i <=30 ; i ++) //While iterating through the csv file tasks
		{
			stroke(255); 
			fill(255); 
			
			float x = map(i, 0, 30, w * 0.80f, width - xBorder); //mapping co-ordinates for x
			
			textAlign(CENTER,CENTER); //text alligned to the center
			line(x, yBorder , x, height - yBorder);
			text(i, x, yBorder/2);
			
		}
		
		for(int i = 0; i < tasks.size(); i++) //while iterating through all the tasks
		{
			fill(255);
			stroke(255);

			Task t = tasks.get(i);

			float y = map(i, 0, tasks.size(), xBorder*2 , height - yBorder); //co-ordinates of y mapped

			textAlign(LEFT);
			text(t.getTask(), yBorder, y);
		}
		

		for(int i = 0; i < tasks.size(); i++) //iterating through tasks
		{
			Task t = tasks.get(i);
			noStroke(); //to elimiante outline
			colorMode(HSB);
			fill(map(i, 0, tasks.size(), 0, 255), 255, 255); //Boxes are filled with hsb colours
			
			float y = map(i, 0, tasks.size(), xBorder*2 , height - yBorder);
			float xStart = map(t.getStart(), 0, 30, w * 0.80f , width - xBorder);
			float xEnd = map(t.getEnd(), 0, 30, w * 0.80f , width - xBorder);
			rect(xStart, y - textAscent() , xEnd - xStart, yBorder/2, 7); // rectangles made according to the co-ordinates

		}

	}


	public void mousePressed()
	{
		println("Mouse pressed");	
	}

	public void mouseDragged()
	{
		println("Mouse dragged");
	}

	
	
	public void setup() 
	{
		 loadTasks();
		 printTasks();
	}
	
	public void draw()
	{			
		background(0);
		displayTasks();
	}
}
