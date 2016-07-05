package wicketMyBatis7.domain;

import java.io.Serializable;
import java.util.List;

public class BaseList<T> {
	int total;
	List<T> list;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "BaseList [total=" + total + ", list=" + list + "]";
	}
	
}
