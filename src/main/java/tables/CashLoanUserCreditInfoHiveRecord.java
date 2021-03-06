package tables;

import lombok.Data;
import spark.HiveTablePartition;

import java.io.Serializable;

/**
 * Created by StevenZhu on 16/10/11.
 */
@Data
public class CashLoanUserCreditInfoHiveRecord implements Serializable {
  private String mobileNumber;
  private Long loanAccountId;
  private String timeFinished;
  private String status;

  @HiveTablePartition
  private String finishDate;
  @HiveTablePartition
  private String createDate;
}
