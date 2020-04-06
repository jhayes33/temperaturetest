/**
 * Temperature -- Converts temperatures and checks
 * for equalities
 * @author Joshua Hayes
 * @since 2020-04-06
 */
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Creates a Temperature class
 */
public class Temperature implements TemperatureInterface
{
	Scanner scan = new Scanner(System.in);
	Pattern pattern = Pattern.compile("[CFcf]");
	public double degrees;
	public char type;

	/**
	 * Constructor - Initializes temperature with
	 * user set degrees and type
	 */
	public Temperature(double setdegrees,char settype)
	{
		degrees = setdegrees;
		type = settype;
	}
	/**
	 * Constructor - Initializes user set degrees
	 * and default unit Celsius
	 */
	public Temperature(double setdegrees)
	{
		degrees = setdegrees;
		type = 'C';
	}
	/**
	 * Constructor - Initializes user set type
	 * and default double 0.0 degrees
	 */
	public Temperature(char settype)
	{
		degrees = 0.0;
		type = settype;
	}
	/**
	 * Constructor - Initializes default degrees
	 * and temperature unit( 0.0 Celsius)
	 */
	public Temperature()
	{
		degrees = 0.0;
		type = 'C';
	}
	/**
	 * Prints temperature and unit
	 * @return No return value
	 */
	public void writeOutput()
	{	
		System.out.println("Temperature = "+ degrees + " degrees "
				+ type+ ".");
	}
	/**
	 * Prints temperature in Celsius
	 * @return No return value
	 */
	public void writeC()
	{
		if(type == 'f' || type == 'F')
		{
			System.out.println("Temperature = "
				+ Math.round(((degrees - 32) * 5/9)*10)/10.0
				+" Celsius.");
		}
		else
		{
			System.out.println("Temperature = "
					+ degrees + " Celsius.");
		}

	}
	/**
	 * Prints temperature in Fahrenheit
	 * @return No return value
	 */
	public void writeF()
	{
		if(type == 'c' || type == 'c')
		{
			System.out.println("Temperature = "
				+ Math.round(((degrees * 9/5) + 32)*10)/10.0
				+" Fahrenheit.");
		}
		else
		{
			System.out.println("Temperature = "
					+ degrees + " Fahrenheit.");
		}

	}
	/**
	 * Returns temperature in Celsius
	 * @return double
	 */
	public double getC()
	{
		if(type == 'f' || type == 'F')
		{
			return Math.round(((degrees - 32) * 5/9)*10)/10.0;
		}
		else
		{
			return degrees;
		}
	}
	/**
	 * Returns temperature in Fahrenheit
	 * @return double
	 */
	public double getF()
	{
		if(type == 'c' || type == 'C')
		{
			return Math.round(((degrees * 9/5) + 32)*10)/10.0;
		}
		else
		{
			return degrees;
		}
	}
	/**
	 * Sets value of degrees
	 * @param setdegrees(double)
	 * @return No return value
	 */
	public void set(double setdegrees)
	{
		degrees = setdegrees;
	}
	/**
	 * Sets unit of temperature
	 * @param settype
	 * @return No return value
	 */
	public void set(char settype)
	{
		type = settype;
	}
	/**
	 * Sets value of degrees and temperature unit
	 * @param setdegrees(double), settype(char)
	 * @return No return value
	 */
	public void set(double setdegrees, char settype)
	{
		degrees = setdegrees;
		type = settype;
	}
	/**
	 * Returns true if both temperatures are equal
	 * @param otherTemperature(Temperature)
	 * @return boolean
	 */
	public boolean equals(Temperature otherTemperature)
	{
		return this.getC() == otherTemperature.getC();
	}
	/**
	 * Returns a string representation of the object
	 * @return String
	 */
	public String toString()
	{
		return "temperature " + degrees + type;
	}
	/**
	 * Reads user input for degrees and temperature unit
	 * @return No return value
	 */
	public void readInput()
	{
		System.out.println("Enter a temperature in degrees"
				+"(for example 29.6): ");
		degrees = scan.nextDouble();
		do{
		System.out.println("Enter 'F' (or'f') for Fahrenheit or "
				+"'C' (or 'c') for Celsius: ");
		scan.nextLine();
		}
		while(!scan.hasNext(pattern));
		type = scan.next().toUpperCase().charAt(0);
	}
}
