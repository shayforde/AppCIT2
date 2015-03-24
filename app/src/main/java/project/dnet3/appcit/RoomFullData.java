package project.dnet3.appcit;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by shay on 23/03/2015.
 */
public class RoomFullData implements Serializable {

    private static final long	serialVersionUID	= -7216110072788834032L;

    public String room_number;
    public String floor_level;
    public String map_section;
    public String map_page_link;
    @SerializedName("room_co-ordinates")
    public String room_co_ordinates;

    public String getRoomNumber(){
        return room_number;
    }

    public String getFloorLevel(){
        return floor_level;
    }

    public String getMapSection(){
        return map_section;
    }

    public String getMapPageLink(){
        return map_page_link;
    }

    public String getRoomCoordinates(){
        return room_co_ordinates;
    }

    @Override
    public String toString(){
        return "Room : " + getRoomNumber() + ", Floor Level : " + getFloorLevel() +
                ", Map Section : " + getMapSection() + ", Map Page Link : " + getMapPageLink()
                + ", Room Co-Ordinates : " + getRoomCoordinates();
    }
}