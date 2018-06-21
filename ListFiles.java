import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

class ListFiles {
	static int i = 0 ;
	public void listFiles(String directoryName , ArrayList al) throws IOException
	{
		File directory = new File(directoryName);
		File[] fList = directory.listFiles();

		for (File file : fList)
		{
			String a = file.toString();
			if(file.isDirectory()==true)
			{
				listFiles(a,al);
			}
			else if (file.isFile())
			{
				try {
					

					String m = (file.getName()).toString();
					String n = file.toString();

					al.add(m);
					al.add(n);
					
					i = i + 2;

				}
				catch(Exception e)
				{
					System.out.println("Invalid");
				}
				finally 
				{

				}
			}
		}
	}

	public static void main (String[] args) throws IOException
	{

		File fout = new File("E:\\abc.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(fos));

		ListFiles LF = new ListFiles();
		Scanner sc = new Scanner(System.in);
	    System.out.println("Enter path");
		String path = sc.nextLine();
		ArrayList<String> al=new ArrayList<String>();
		try 
		{
			LF.listFiles(path , al);
		}
		catch(Exception e)
		{
			System.out.println("Invalid Input");
		}
		finally
		{
			System.out.println("Please see the CSV File");
		}

		buffer.write("Filename" +" , " + "Filepath");
		buffer.newLine();
		for(int j = 0 ; j < i ; j = j +2)
		{
			buffer.write(al.get(j) +" , " + al.get(j+1));
			buffer.newLine();
		}
		buffer.close();
	}
}



