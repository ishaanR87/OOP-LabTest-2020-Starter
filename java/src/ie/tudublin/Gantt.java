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
		float border = width * 0.1f;
		float left = width * 0.05f;

		float w = width * 0.3f;
		float h = height * 0.1f;

		for(int i = 0; i < tasks.size(); i++)
		{
			Task t = tasks.get(i);

			float y = map(i, 0, tasks.size(), border, height - border);
			fill(0);
			rect (left, y, w, h);
			fill(220);
			textAlign(LEFT, CENTER);
			text(t.getTask(), left + 20, y + (h/3));
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
