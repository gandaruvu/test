package tables;

import lombok.Data;
import spark.HiveTablePartition;

import java.io.Serializable;

/**
 * Created by StevenZhu on 16/10/11.
 */
@Data
public class LoanCreditFeatureHiveRecord extends LoanCreditFeature implements Serializable {
  private Long loanAccountId;

  @HiveTablePartition
  private String finishDate;
  @HiveTablePartition
  private String createDate;
}
