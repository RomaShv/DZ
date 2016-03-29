package dz4;

import java.util.ArrayList;
import java.util.List;

public class Contact {
	String name;
	String phone;
	List<Contact> linked = new ArrayList<>();
	
	Contact (String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public boolean inContacts(Contact c) {
		return this.linked.contains(c);
	}
	
	public void setLinkedContact(List<Contact> linked) {
		this.linked = linked;
	}
	
	@Override	
	public boolean equals(Object o) {
        if(o == null)
        {
            return false;
        }
        if (o == this)
        {
           return true;
        }
        if (getClass() != o.getClass())
        {
            return false;
        }
        Contact e = (Contact) o;
        return (this.phone == e.phone);
	}
	
	@Override
    public int hashCode() {
        return 0;
    }	
	
	@Override
	public String toString() {
		int i = 0;
		String str = name + " : " + phone;
		if(!linked.isEmpty()) {
			str += " : (";
			for(Contact c : linked) {
				if(i!=0) {
					str += ", ";
				}
				str += c.name + " : " + c.phone;
				i++;
			}
			str += ")";
		}
				
		return str;
	}
	
}
