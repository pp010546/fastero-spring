package tw.com.fasterospring.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "OrderDetail")
@Data
@Component
@NamedQueries({
	@NamedQuery(name ="selectAllDetailById", query = "FROM OrderDetailVO where orderId = :id"),
}
		)
@IdClass(PK.class)
public class OrderDetailVO {
	
	@Id
	@Column(name = "order_id")
	private Integer orderId;
	@Id
	@Column(name = "product_id")
	private Integer productId;
	private Integer price;
	private Integer quantity;
	
	@OneToOne
	@JoinColumn(name = "product_id", insertable = false, updatable = false)
	private ProductVO product;
	

}
