package bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "category", catalog = "svw")
public class Category
implements Serializable {
	private Integer id;
	private String name;
	private Integer parentid;
	private String remark;
	private Set<Video> videos = new HashSet<Video>(0);




	public Category() {}




	public Category(String name, Integer parentid, String remark, Set<Video> videos) {
		this.name = name;
		this.parentid = parentid;
		this.remark = remark;
		this.videos = videos;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() { return this.id; }



	public void setId(Integer id) { this.id = id; }



	@Column(name = "name")
	public String getName() { return this.name; }



	public void setName(String name) { this.name = name; }



	@Column(name = "parentid")
	public Integer getParentid() { return this.parentid; }



	public void setParentid(Integer parentid) { this.parentid = parentid; }



	@Column(name = "remark")
	public String getRemark() { return this.remark; }



	public void setRemark(String remark) { this.remark = remark; }



	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "category")
	public Set<Video> getVideos() { return this.videos; }



	public void setVideos(Set<Video> videos) { this.videos = videos; }
}


