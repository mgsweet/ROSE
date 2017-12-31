import exceptions.LexicalException;

/**
 * @author Aaron-Qiu
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String return_id;
		if (args.length == 0)
		{
			System.out.println("Usage : java Main <inputfile>");
		}
		else
		{
			for (int i = 0; i < args.length; i++) 
			{
				OberonScanner scanner = null;
				try
				{
					scanner = new OberonScanner(new java.io.FileReader(args[i]));
					while (true)
					{
						try
						{
							return_id = scanner.yylex();
							System.out.println(return_id + " : " + scanner.yytext());
						}
						catch (LexicalException ex)
						{
							System.out.println(args[i]+ " : "+ ex.getMessage());
							System.out.print("Line "+ scanner.get_line() + ", Colume " + scanner.get_column() + ": ");
							System.out.println(scanner.yytext() + "\n");
							break;
						}
						if (return_id.equals("EOF"))
						{
							System.out.println(args[i] + " : No Lexical error!");
							break;
						}
					}
				}
				catch (java.io.FileNotFoundException e) 
				{
					System.out.println("File not found : \""+args[i]+"\"");
				}
				catch (java.io.IOException e) 
				{
					System.out.println("IO error scanning file \""+args[i]+"\"");
					System.out.println(e);
				}
				catch (Exception e)
				{
					System.out.println("Unexpected exception:");
					e.printStackTrace();
				}
			}
		}
	}

}
