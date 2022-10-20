package tw.com.fasterospring.vo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Table(name = "Review")
@Data
@Component
@NamedQueries({
	@NamedQuery(name = "selectByOrderId", query = "FROM ReviewVO WHERE orderId = :orderId")
})
public class ReviewVO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private Integer reviewId;
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "store_id")
	private Integer storeId;
	@Column(name = "order_id")
	private Integer orderId;
	@Column(name = "review_point")
	private Integer reviewPoint;
	@Column(name = "review_text")
	private String reviewText;
	@Column(name = "review_store_response")
	private String reviewStoreResponse;
	@Column(name = "review_time")
	private LocalDateTime reviewTime;
	@Column(name = "response_time")
	private LocalDateTime responseTime;

	
}
