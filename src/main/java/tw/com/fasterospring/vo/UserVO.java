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
@Table(name = "User")
@Data
@Component
@NamedQueries({
	@NamedQuery(name ="selectAllUser", query = "FROM UserVO"),
	@NamedQuery(name = "selectUserByAccount", query = "FROM UserVO WHERE userAccount = :account")
}
		)
public class UserVO {
	
	//'userId', 'userAccount', 'userPassword', 'userName', 'userPhone', 'userBuildTime', 'userStatus'
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "user_id")
		private Integer userId;
		@Column(name = "user_account")
		private String userAccount;
		@Column(name = "user_password")
		private String userPassword;
		@Column(name = "user_name")
		private String userName;
		@Column(name = "user_phone")
		private String userPhone;
		@Column(name = "user_build_time", insertable = false, updatable = false)
		private LocalDateTime userBuildTime;

}
