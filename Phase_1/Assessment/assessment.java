package phase1project;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class assessment {
	static String DIRECTORY;
    File details;

    public assessment() {
        DIRECTORY = System.getProperty("user.dir");
        details = new File(DIRECTORY+"/files");
        if (!details.exists())
            details.mkdirs();
        System.out.println("DIRECTORY : "+ details.getAbsolutePath());
    }

    private static final String WELCOME_MESSAGE =
            "\n******* Phase1Project.com *******"+
            "\n******* Vikram*******\n";

    private static final String MAIN_MEMORY =
            "\nMAIN MEMORY - Choose any of the following: \n"+
                    "1 -> List of files in directory\n"+
                    "2 -> To Add, Delete or Search\n"+
                    "3 -> To Exit Program";

    private static final String SECONDARY_MEMORY =
            "   \nChoose any of the following: \n"+
                    "   a -> To Add a file\n"+
                    "   b -> To Delete a file\n"+
                    "   c -> To Search a file\n"+
                    "   d -> To GoBack";

    void showPrimaryMenu() {
        System.out.println(MAIN_MEMORY);
        try{
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose){
                case 1 : {
                    showFiles();
                    showPrimaryMenu();
                }
                case 2 : {
                    showSecondaryMenu();
                }
                case 3 : {
                    System.out.println("Thank You");
                    System.exit(0);
                }
                default: showPrimaryMenu();
            }
        }
        catch (Exception e){
            System.out.println("Please enter 1, 2 or 3");
            showPrimaryMenu();
        }
    }

    void showSecondaryMenu() {
        System.out.println(SECONDARY_MEMORY);
        try{
            Scanner scanner = new Scanner(System.in);
            char[] input = scanner.nextLine().toLowerCase().trim().toCharArray();
            char choose = input[0];

            switch (choose){
                case 'a' : {
                    System.out.print(" To Add a file, Please Enter a File Name : ");
                    String File_Name = scanner.next().trim().toLowerCase();
                    addFile(File_Name);
                    break;
                }
                case 'b' : {
                    System.out.print(" To Delete a file, Please Enter a File Name : ");
                    String File_Name = scanner.next().trim();
                    deleteFile(File_Name);
                    break;
                }
                case 'c' : {
                    System.out.print(" To Search a file, Please Enter a File Name : ");
                    String File_Name = scanner.next().trim();
                    searchFile(File_Name);
                    break;
                }
                case 'd' : {
                    System.out.println("Going Back to MAIN MEMORY");
                    showPrimaryMenu();
                    break;
                }
                default : System.out.println("Please enter a, b, c or d");
            }
            showSecondaryMenu();
        }
        catch (Exception e){
            System.out.println("Please enter a, b, c or d");
            showSecondaryMenu();
        }
    }

    void showFiles() {
        if (details.list().length==0)
            System.out.println("The folder is Empty");
        else {
            String[] list = details.list();
            System.out.println("The files in "+ details +" are :");
            Arrays.sort(list);
            for (String str:list) {
                System.out.println(str);
            }
        }
    }

    void addFile(String File_Name) throws IOException {
        File filepath = new File(details +"/"+File_Name);
        String[] list = details.list();
        for (String file: list) {
            if (File_Name.equalsIgnoreCase(file)) {
                System.out.println("File " + File_Name + " already exists at " + details);
                return;
            }
        }
        filepath.createNewFile();
        System.out.println("File "+File_Name+" added to "+ details);
    }

    void deleteFile(String File_Name) {
        File filepath = new File(details +"/"+File_Name);
        String[] list = details.list();
        for (String file: list) {
            if (File_Name.equals(file) && filepath.delete()) {
                System.out.println("File " + File_Name + " deleted from " + details);
                return;
            }
        }
        System.out.println("Delete Operation failed. FILE NOT FOUND");
    }

    void searchFile(String File_Name) {
        String[] list = details.list();
        for (String file: list) {
            if (File_Name.equals(file)) {
                System.out.println("FOUND : File " + File_Name + " exists at " + details);
                return;
            }
        }
        System.out.println("File NOT found");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(WELCOME_MESSAGE);
        assessment menu = new assessment();
        menu.showPrimaryMenu();

	}

}
