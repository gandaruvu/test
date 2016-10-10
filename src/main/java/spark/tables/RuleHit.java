package spark.tables;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by StevenZhu on 16/10/9.
 */
@Data
public class RuleHit implements Serializable {
  public Long loanAccountId;
  public Long ruleSetId;
  public String ruleSetName;
  public Long ruleId;
  public String ruleName;
  public String result;

  // partition
  public Long date;
}
