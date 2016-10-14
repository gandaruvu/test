package tables;


import lombok.Data;
import spark.HiveTablePartition;

/**
 * Created by StevenZhu on 16/10/11.
 */
@Data
public class LoanCreditFeatureHiveRecord extends LoanCreditFeature {
  private Long loanAccountId;

  @HiveTablePartition
  private String finishDate;
  @HiveTablePartition
  private String createDate;
}
