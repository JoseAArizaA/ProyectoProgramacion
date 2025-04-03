package utils;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;

@XmlRootElement
public class HashSetContenedor<T> {
    private HashSet<T> set;

    public HashSetContenedor() {
        this.set = new HashSet<>();
    }

    public HashSetContenedor(HashSet<T> set) {
        this.set = set;
    }

    @XmlElement
    public HashSet<T> getSet() {
        return set;
    }

    public void setSet(HashSet<T> set) {
        this.set = set;
    }
}
