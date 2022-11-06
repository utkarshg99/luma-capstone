package com.luma.luma.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CardId implements Serializable {
    private String eid;
    private String lid;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((eid == null) ? 0 : eid.hashCode());
        result = prime * result + ((lid == null) ? 0 : lid.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CardId other = (CardId) obj;
        if (eid == null) {
            if (other.eid != null)
                return false;
        } else if (!eid.equals(other.eid))
            return false;
        if (lid == null) {
            if (other.lid != null)
                return false;
        } else if (!lid.equals(other.lid))
            return false;
        return true;
    }
}
