//import the respective packages
import java.io.*;
import java.util.StringTokenizer;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

//driver class
public class EmployeeSalary
{
//Driver method
public static void main(String[]args) throws IOException
{
//Instantiate the object of DecimalFormat
DecimalFormat dF = new DecimalFormat("0.00");

try
{
//Set the input/output file
//input file
BufferedReader inputFile;
    inputFile = new BufferedReader(new
        FileReader("C:\\Users\\WAKAF 05\\Downloads\\employeeSalaries.txt"));

//Declare the variables
String inputData = null;
String employeeName;
double salary, annualSalary;
int yearsOfService;

//Initialize the variables for top-performing employee and least years of service
String topPerformer = "";
String leastExperience = "";
double highestAnnualSalary = 0;
int minYearsOfService = Integer.MAX_VALUE;

while((inputData = inputFile.readLine()) != null)
{
//Instantiate the object reference of the StringTokenizer
//to pass the string line (input data) & to set the delimiter
StringTokenizer sT = new StringTokenizer(inputData,";");

//Break into tokens and assign to the appropriate variables
employeeName = sT.nextToken();
salary = Double.parseDouble(sT.nextToken());
yearsOfService = Integer.parseInt(sT.nextToken());

//Calculate the annual salary
annualSalary = salary + (salary * yearsOfService * 0.05);

//Print the annual salary for each employee
System.out.println(employeeName + "'s annual salary: " + dF.format(annualSalary));

//Check if this employee has the highest annual salary
if(annualSalary > highestAnnualSalary) {
    highestAnnualSalary = annualSalary;
    topPerformer = employeeName;
}

//Check if this employee has the least years of service
if(yearsOfService < minYearsOfService) {
    minYearsOfService = yearsOfService;
    leastExperience = employeeName;
}
}//end of while loop

//Print the top-performing employee and the employee with the least years of service
System.out.println("Top-performing employee based on the highest annual salary: " + topPerformer);
System.out.println("Employee with the least years of service: " + leastExperience);

//Close the input file
inputFile.close();
}//end of try block
catch(FileNotFoundException ex)
{
String output="File not found";
JOptionPane.showMessageDialog(null, output);
}//end of catch
catch(IllegalArgumentException iae)
{
String output="Invalid input! The salary must be a positive number";
JOptionPane.showMessageDialog(null, output);
}//end of catch
}//end of main
}//end of class
