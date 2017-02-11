package nebulous.scifigenV2;
/**
 * SciFiName gathers input from a user to generate a custom name that
 * sounds like it could be used in a science fiction book or movie.
 * 
 * @author ckinnard
 * @version 3/4/16
 */

public class SciFiName   
{
    /**
     * All input that you privide should be at least three letters long
     * or the program may crash (feel free to test this!)
     * 
     * For best results, user lowercase letters and do not use spaces in your input
     */
    public static void main(String[] args)
    {
        System.out.println("If you provide me some information I will provide a Science Fiction name for you.");
        System.out.println("Please have all responses  be at least three characters long.");
        System.out.println("For best results, user lowercase letters with no spaces.\n");

        // notice this methd (print) does not print a newline
        System.out.print("Enter your first name: ");
        String firstName = UserInput.getString();
        System.out.print("Enter your last name: ");
        String lastName = UserInput.getString();
        System.out.print("Enter the city where you or one of your parents were born: ");
        String city = UserInput.getString();
        System.out.print("Enter the name of your grammar school: ");
        String school = UserInput.getString();
        System.out.print("Enter the first name of a sibling or other relative: ");
        String relativeName1 = UserInput.getString();
        System.out.print("Enter the first name of a second sibling or relative: ");
        String relativeName2 = UserInput.getString();

        // generate a sciFi name
        String sciFiFirstName = firstName.substring(0,3) + lastName.substring(0,2);
        String sciFiLastName = city.substring(0,2) + school.substring(0,3);
        int len1 = relativeName1.length()-1;
        int len2 = relativeName2.length()-1;
        int r1 = (int)(Math.random() * len1) + 1;
        int r2 = (int)(Math.random() * len2) + 1;
        // are your random numbers correct?
        // System.out.println("r1=" + r1 + " r2=" + r2);
        String sciFiPlaceOfOrigin = relativeName1.substring(r1) + relativeName2.substring(r2);

        /* BEGIN OPTIONAL algorithm using String.toLowerCase */
        sciFiFirstName = sciFiFirstName.toLowerCase();
        sciFiLastName = sciFiLastName.toLowerCase();
        sciFiPlaceOfOrigin = sciFiPlaceOfOrigin.toLowerCase();
        /* END OPTIONAL algorithm using String.toLowerCase */
                
        /* BEGIN OPTIONAL algorithm using String.toUpperCase */
        String firstLetter  = sciFiFirstName.substring(0,1);
        sciFiFirstName = firstLetter.toUpperCase() + sciFiFirstName.substring(1);

        firstLetter  = sciFiLastName.substring(0,1);
        sciFiLastName = firstLetter.toUpperCase() + sciFiLastName.substring(1);

        firstLetter  = sciFiPlaceOfOrigin.substring(0,1);
        sciFiPlaceOfOrigin = firstLetter.toUpperCase() + sciFiPlaceOfOrigin.substring(1);
        /* END OPTIONAL algorithm using String.toUpperCase */

        System.out.println("\n\nHello " + 
            sciFiFirstName + " " + sciFiLastName +
            " of " + sciFiPlaceOfOrigin + ". Welcome!");      
    }
}
