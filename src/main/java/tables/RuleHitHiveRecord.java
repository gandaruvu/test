package tables;


import lombok.Data;
import spark.HiveTablePartition;

import java.io.Serializable;

/**
 * Created by StevenZhu on 16/10/9.
 */
@Data
public class RuleHitHiveRecord implements Serializable {
  private Long loanAccountId;
  private Long ruleSetId;
  private String ruleSetName;
  private Long ruleId;
  private String ruleName;
  private Boolean decision;
  private Double score;

  @HiveTablePartition
  private String finishDate;
  @HiveTablePartition
  private String createDate;


}
