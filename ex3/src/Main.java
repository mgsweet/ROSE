

import java.io.FileNotFoundException;

/**
 * @author Aaron-Qiu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length == 0)
		{
			System.out.println("Usage : java Main <inputfile>");
		}
		else
		{
			for (int i = 0; i < args.length; i++) 
			{
				OberonScanner obj = null;
				try {
					obj = new OberonScanner(new java.io.FileReader(args[i]));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				parser p = new parser(obj);
				System.out.println(args[i] + ":");
				try
				{	
					p.parse();
				}
				catch(Exception ex)
				{
					// ex.printStackTrace();
					System.out.println(obj.get_line()+" line "+ obj.get_column()+" column");
					System.out.println(ex.getMessage());
				}
				System.out.println();
			}
		}

	}

}
