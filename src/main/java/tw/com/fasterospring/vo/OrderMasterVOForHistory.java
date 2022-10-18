package tw.com.fasterospring.vo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "OrderMaster")
@Data
@Component
@NamedQueries({
	@NamedQuery(name = "selectByUserId", query = "FROM OrderMasterVOForHistory WHERE userId = :userId"),
	@NamedQuery(name = "selectByStoreId", query = "FROM OrderMasterVOForHistory WHERE storeId = :storeId")
})
public class OrderMasterVOForHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "store_id")
	private Integer storeId;
	@Column(name = "order_status")
	private Byte orderStatus;
	@Column(name = "order_amount")
	private Integer orderAmount;
	@Column(name = "order_time")
	private LocalDateTime orderTime;
	@Column(name = "update_time")
	private LocalDateTime updateTime;
	@Column(name = "order_remark")
	private String orderRemark;
//	@Column(table = "Store", name = "store_name")
//	private String storeName;
	@ManyToOne
	@JoinColumn(name = "store_id", insertable = false, updatable = false)
	private StoreVO store;

}