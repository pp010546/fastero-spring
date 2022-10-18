package tw.com.fasterospring.vo;

import java.sql.Blob;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "Product")
@Data
@Component
//@NamedQueries({
//	@NamedQuery(name = "selectByUserId", query = "FROM OrderMasterVOForHistory WHERE userId = :userId"),
//	@NamedQuery(name = "selectByStoreId", query = "FROM OrderMasterVOForHistory WHERE storeId = :storeId")
//})
public class ProductVO {
	
	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "store_id")
	private Integer storeId;
	@Column(name = "product_name")
	private String productName;
	@Column(name = "product_introduction")
	private String productIntroduction;
	@Column(name = "product_price")
	private Integer productPrice;
	@Column(name = "product_status")
	private Boolean productStatus;
	@Column(name = "product_image")
	private Blob productImage;
	@Column(name = "product_wait_time")
	private Integer productWaitTime;
	@Column(name = "product_update_time")
	private LocalDateTime productUpdateTime;
	

}
