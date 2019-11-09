package DuplicateLinesElimination;

import java.io.*;
class DuplicateElimination
{
	public static void main(String[] args) throws Exception
	{
		System.out.println("Removing Duplicate lines in file");
		BufferedReader br1 = new BufferedReader(new FileReader("input.txt"));
 		PrintWriter pw = new PrintWriter("output.txt");
		String line = br1.readLine(); 
		while (line != null)
		{
			boolean available = false;
			BufferedReader br2 = new BufferedReader( new FileReader("output.txt") );
 			String target = br2.readLine();
			while (target != null)
			{
				if (line.equals(target) )
				{
					available = true;
					 break;
				}	
				target = br2.readLine(); 
			} 
			if (available == false)
			{
				pw.println(line);
				 pw.flush();
			}
			line = br1.readLine();
		}
	}
}
