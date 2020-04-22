package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	
	ArrayList<Task> tasks = new ArrayList<Task>();


	

	public void settings()
	{
		size(800, 600);
	}

	public void loadTasks()
	{
		Table table = loadTable("tasks.csv", "header");
		for(TableRow row:table.rows())
		{
			Task t = new Task(row);
			tasks.add(t);

		}
	}

	public void printTasks()
	{
		for(Task t:tasks)
		{
			System.out.println(t);
		}
	}

	public void displayTasks()
	{
		float xBorder = width * 0.20f;
		float yBorder = height * 0.05f; 
		colorMode(RGB);
		stroke(255);
		textAlign(CENTER, CENTER);
		for(int i = 1 ; i <=30 ; i ++)
		{
			float x = map(i, 1, 31, xBorder, width);				
			line(x, yBorder , x, height - yBorder);
			fill(255);
			text(i, x, yBorder/2);
			
		}
		
		for(int i = 0; i < tasks.size(); i++)
		{
			fill(255);
			stroke(255);

			Task t = tasks.get(i);

			float y = map(i, 0, tasks.size(), 80, height - (yBorder*4));

			textAlign(LEFT);
			text(t.getTask(), yBorder, y);

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
