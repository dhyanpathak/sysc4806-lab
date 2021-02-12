package app;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class AddressBook {

    @Id
    private Integer id = null;

    @OneToMany(cascade = CascadeType.ALL)
    private List<BuddyInfo> buddyInfos;

    public AddressBook() {
        buddyInfos = new ArrayList<BuddyInfo>();
    }

    public void addBuddy(BuddyInfo bud) {
        if(bud != null) {
            buddyInfos.add(bud);
        }
    }

    public void removeBuddy(BuddyInfo bud) {
        if(buddyInfos.contains(bud)) buddyInfos.remove(bud);
    }

    //@ManyToOne
    public int getSize() {
        return buddyInfos.size();
    }

    public boolean contains(BuddyInfo b) {
        return buddyInfos.contains(b);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void clear() {
        buddyInfos.clear();
    }

    public BuddyInfo getBuddy(int i) {
        return buddyInfos.get(i);
    }

    //@ManyToOne
    public List<BuddyInfo> getBuddyInfos() {
        return buddyInfos;
    }
//    public String toString() {
//        String output = "";
//
//        for(app.BuddyInfo bud: buddyInfos) {
//            output += bud.toString();
//        }
//        return output;
//    }

//    public static void main(String[] args) {
//        app.BuddyInfo bud1 = new app.BuddyInfo("Homer", 36, "1234567890", "12 Address Rd");
//        app.BuddyInfo bud2 = new app.BuddyInfo("Bart", 12, "0987654321", "12 Address Rd");
//        app.AddressBook ab = new app.AddressBook();
//        ab.addBuddy(bud1);
//        ab.addBuddy(bud2);
//
//        System.out.println(ab.toString());
//    }
}
