package tables;

/**
 * Created by StevenZhu on 16/10/12.
 */
public enum HiveStaticTable {
  CASH_LOAN_USER_BASE_INFO("cash_loan_user_base_info"),
  RULE_HIT("rule_hit"),
  LOAN_CREDIT_FEATURE("loan_credit_feature"),
  ;

  public String tableName;

  HiveStaticTable(String tableName) {
    this.tableName = tableName;
  }
}
