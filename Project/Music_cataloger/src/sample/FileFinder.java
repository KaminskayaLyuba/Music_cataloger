package sample;

import java.io.File;
import static sample.Controller.mp3List;
import static sample.Controller.mp3ArtistList;
import static sample.Controller.mp3AlbumList;

/**
 * Created by люба on 29.10.2017.
 */
public class FileFinder {
    private String str=new String();
    public FileFinder(String s) {
        str=s;
    }

    public void start() {
        try{
            File f = new File(str);
            for (File s : f.listFiles()) {
                if (s.isFile()) {
                    if (s.getName().endsWith(".mp3"))
                    {
                        mp3List.add(new AudioParser(s));
                        if(!mp3ArtistList.contains(mp3List.get(mp3List.size()-1).artist))
                            mp3ArtistList.add(mp3List.get(mp3List.size()-1).artist);
                        if(!mp3AlbumList.contains(mp3List.get(mp3List.size()-1).album))
                            mp3AlbumList.add(mp3List.get(mp3List.size()-1).album);
                        // i++;
                        // if (i%100==0) System.out.println(i);
                    }
                } else if (s.isDirectory()) {
                    new FileFinder(s.getAbsolutePath()).start();
                }
            }
        }
        catch (NullPointerException e)
        {
            System.out.println("filefinder error");
        }
        catch (Exception e)
        {
            System.out.println("mp3 error");
        }
    }

}
