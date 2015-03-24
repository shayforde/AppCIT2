package project.dnet3.appcit;

import java.io.Serializable;

/**
 * Created by shay on 23/03/2015.
 */
public class RoomShortData implements Serializable {

    private static final long	serialVersionUID	= -7216710072738834035L;

    public String room_number;

    public String getRoomNumber(){
        return room_number;
    }
}