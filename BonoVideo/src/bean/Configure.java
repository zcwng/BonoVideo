package bean;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;









@Entity
@Table(name = "configure", catalog = "svw")
public class Configure
implements Serializable
{
	private Integer id;
	private String name;
	private String val;
	private String remark;

	public Configure() {}

	public Configure(String name, String val, String remark) {
		this.name = name;
		this.val = val;
		this.remark = remark;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() { return this.id; }



	public void setId(Integer id) { this.id = id; }



	@Column(name = "name")
	public String getName() { return this.name; }



	public void setName(String name) { this.name = name; }



	@Column(name = "val")
	public String getVal() { return this.val; }



	public void setVal(String val) { this.val = val; }



	@Column(name = "remark")
	public String getRemark() { return this.remark; }



	public void setRemark(String remark) { this.remark = remark; }
}


