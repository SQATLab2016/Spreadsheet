import java.util.ArrayList;

public class Spreadsheet 
{

	// the limit of array is hard coded to 128 x 128
	private String[][] cells = new String[128][128];

	public String get(String cell) 
	{
		return cells[0][0];
	}
	
	public void set(String cell, String value) 
	{
		cells[0][0] = value;
	}
	
	public String evaluate(String cell) 
	{
		String tempCell = cells[0][0];
		if (tempCell.substring(0,1).equals("-"))
		{
			tempCell = tempCell.substring(1);
		}
		else if (tempCell.substring(0, 1).equals("'"))
		{
			tempCell = tempCell.substring(1);
			if (tempCell.indexOf('\'') == tempCell.length() - 1)
			{
				tempCell = tempCell.substring(0, tempCell.length() - 1);
				return tempCell;
			}
			else
			{
				return "#Error";
			}
		}
		if (!tempCell.matches("\\d+"))
		{
			return "#Error";
		}
		return cells[0][0];
	}
	
}
