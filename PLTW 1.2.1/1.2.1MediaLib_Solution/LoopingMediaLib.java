
/**
 * Maintain a collection of song, movie, and book titles.
 * 
 * @author ckinnard
 * @version 3/5/16
 */
public class LoopingMediaLib
{
    public static void main()
    {
        /* both the for loop and while loop shown */
        for(int i = 0; i < 10; i++) {
            System.out.println(MediaFile.readString());
        }
        MediaFile.saveAndClose();
        System.out.println();

        String songInfo =  MediaFile.readString();
        while(songInfo != null) {
            System.out.println(songInfo);
            songInfo =  MediaFile.readString();
        }
        
        songInfo =  MediaFile.readString();
        while(songInfo != null) {
            //System.out.println(songInfo);
            String title = songInfo.substring(0, songInfo.indexOf("|"));
            System.out.println("Title: " + title);
            String rateStr = songInfo.substring((songInfo.indexOf("|") + 1));
            System.out.println("Rating: " + rateStr);
            System.out.println();

            songInfo =  MediaFile.readString();
        }
    }
    
}