
/**
 * Maintain a collection of song, movie, and book titles.
 * 
 * @author ckinnard
 * @version 3/5/16
 */
public class FavoritesMediaLib
{
    public static void main()
    {
        String songInfo =  MediaFile.readString();
        // System.out.println(songInfo);

        /* while loop solution 
        int index = songInfo.indexOf("|");
        while( index > 0) {
            // a delimiter was found, so get the next token and print
            String token = songInfo.substring(0, index);
            System.out.println(token);

            // generate a new string starting at the next token
            songInfo = songInfo.substring(index + 1);
            // get the location of the next delimiter
            index = songInfo.indexOf("|");
        }
        */

        /* for loop solution:
         * 
         * Since the algorithm above modidifes songInfo,
         * only one algorithm will work at a time

        for(int i = 1; i <= 100; i++) { // also: for(int i = 0; i < 100; i++)

            // get the location of the next delimiter
            int index = songInfo.indexOf("|");
            if (index > 0) {
                // a delimiter was found, so get the next token and print
                String token = songInfo.substring(0, index);
                System.out.println(token);
    
                // generate a new string starting at the next token
                songInfo = songInfo.substring(index + 1);
            }
        }
        */

        System.out.println("My Favorite Songs");
        System.out.println("-----------------");
        int index = songInfo.indexOf("|");
        while( index > 0) {
            // a delimiter for a title was found
            String title = songInfo.substring(0, index);

            // generate a new string starting at songs rating
            songInfo = songInfo.substring(index + 1);
            // get the rating string 
            index = songInfo.indexOf("|");
            String ratingStr = songInfo.substring(0, index);

            // convert to a integer
            int rating = Integer.valueOf(ratingStr);

            if (rating >= 8)
            {           
                System.out.println(title + "(" + rating + ")");
            }
            // generate a new string starting at songs rating
            songInfo = songInfo.substring(index + 1);
            // get the rating string 
            index = songInfo.indexOf("|");
        }

    }
}