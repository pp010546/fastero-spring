package tw.com.fasterospring.vo;

import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;
@Entity
@Table(name = "Store")
@Data
@Component
@NamedQueries({
	@NamedQuery(name = "selectAllStore", query = "FROM StoreVO"),
	@NamedQuery(name = "selectStoreByAccount", query = "FROM StoreVO WHERE storeAdminAccount = :account")
})
public class StoreVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_id")
	private Integer storeId;
	@Column(name = "store_name")
	private String storeName;
	@Column(name = "store_address")
	private String storeAddress;
	@Column(name = "store_longitude")
	private String longitude;
	@Column(name = "store_latitude")
	private String latitude;
	@Column(name = "store_phone")
	private String storePhone;
	@Column(name = "store_email")
	private String storeEmail;
	@Column(name = "store_admin_account")
	private String storeAdminAccount;
	@Column(name = "store_admin_password")
	private String storeAdminPassword;
	@Column(name = "store_admin_phone")
	private String storeAdminPhone;
	@Column(name = "store_admin_address")
	private String storeAdminAddress;
	@Column(name = "store_preview_img")
	private Blob storeImg;
	@Column(name = "store_introduction")
	private String storeIntroduction;
	@Column(name = "store_open_status")
	private Boolean storeOpenStatus;
	@Column(name = "store_account_status")
	private Integer storeAccountStatus;
	@Column(name = "store_admin_name")
	private String storeAdminName;
	@Column(name = "store_admin_id")
	private String storeAdminId;
	@Column(name = "store_build_time")
	private LocalDateTime storeBuildTime;
	@Column(name = "store_update_time")
	private LocalDateTime storeUpdteTime;
	@Column(name = "store_comment_number")
	private Integer storeCommentNumber;
	@Column(name = "store_total_star")
	private Integer storeTotalStar;
	@Column(name = "store_business_time")
	private String storeBusinessTime;
	
//	@OneToMany(mappedBy = "store")
//	private List<OrderMasterVOForHistory> orders;

}
