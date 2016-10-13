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
  private String createDate;
  @HiveTablePartition
  private String finishDate;

//  public static CashLoanUserCreditInfoHiveRecord from(LoanUserCreditsInfoRecord loanUserCreditsInfoRecord, String mobileNumber, String dateCreated) {
//    CashLoanUserCreditInfoHiveRecord hiveRecord = new CashLoanUserCreditInfoHiveRecord();
//    hiveRecord.setMobileNumber(mobileNumber);
//    hiveRecord.setStatus(LoanCreditsStatus.fromCode(loanUserCreditsInfoRecord.getCreditsStatus()).message);
//    hiveRecord.setCreateDate(dateCreated);
//    hiveRecord.setFinishDate(YqgClock.dateString(loanUserCreditsInfoRecord.getTimeCreated()));
//    hiveRecord.setTimeFinished(YqgClock.dateTimeStringFromTimestamp(loanUserCreditsInfoRecord.getTimeCreated(), YqgClock.DATE_TIME_FORMAT));
//    return hiveRecord;
//  }
}
