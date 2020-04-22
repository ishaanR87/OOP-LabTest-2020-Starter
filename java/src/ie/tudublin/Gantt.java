
package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class Gantt extends PApplet
{	
	
	ArrayList<Task> tasks = new ArrayList<Task>();

	float yBorder;
	float xBorder;
	float w;


	

	public void settings()
	{
		size(800, 600);
		xBorder = width * 0.05f;
		yBorder = height * 0.10f;
		w = width * 0.20f;
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
		for(int i = 1 ; i <=30 ; i ++)
		{
			stroke(255);
			fill(255);
			
			float x = map(i, 0, 30, w * 0.80f, width - xBorder);	
			
			textAlign(CENTER,CENTER);
			line(x, yBorder , x, height - yBorder);
			text(i, x, yBorder/2);
			
		}
		
		for(int i = 0; i < tasks.size(); i++)
		{
			fill(255);
			stroke(255);

			Task t = tasks.get(i);

			float y = map(i, 0, tasks.size(), xBorder*2 , height - yBorder);

			textAlign(LEFT);
			text(t.getTask(), yBorder, y);
		}
		

		for(int i = 0; i < tasks.size(); i++)
		{
			Task t = tasks.get(i);
			noStroke();
			colorMode(HSB);
			fill(map(i, 0, tasks.size(), 0, 255), 255, 255);
			
			float y = map(i, 0, tasks.size(), xBorder*2 , height - yBorder);
			float xStart = map(t.getStart(), 0, 30, w * 0.80f , width - xBorder);
			float xEnd = map(t.getEnd(), 0, 30, w * 0.80f , width - xBorder);
			rect(xStart, y - textAscent() , xEnd - xStart, yBorder/2, 7);

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
