

public class TenantLetter {
    private String letter;
    private String room_id;

    public TenantLetter(String letter, String room_id) {
        this.letter = letter;
        this.room_id = room_id;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public String getRoom_id() {
        return room_id;
    }

    public void setRoom_id(String room_id) {
        this.room_id = room_id;
    }
}
