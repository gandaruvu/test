package tables;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.HashSet;
import java.util.Map;

/**
 * Created by heqiang on 16/2/24.
 */
@Data
public class LoanCreditFeature {

  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "姓名")
  public String name;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "身份证号")
  public String id;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "手机号")
  public String mobile;

  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "职业")
  public String occupation = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "职业分类")
  public String occupationCategory = null;

  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "性别")
  public String general_gender = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "年龄")
  public Integer general_age = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "婚否")
  public Boolean general_isMarried = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "婚姻状态")
  public Integer general_marryStatus = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "手机号匹配银行卡预留手机号")
  public Boolean general_isMobileMatchCardMobile = null;


  @LoanCreditFeatureAnnotation(source = "统计信息", description = "配额")
  public Boolean general_hasTicket = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "同一Wifi下人数")
  public Integer ticket_numberOfPeopleSharingWifi = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "同一Wifi下现金贷完件人数")
  public Integer ticket_numberOfRealLoanUserSharingWifi = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "同一设备下人数")
  public Integer ticket_numberOfPeopleSharingDevice = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "同一设备下现金贷完件人数")
  public Integer ticket_numberOfRealLoanUserSharingDevice = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "同一人脉下人数")
  public Integer ticket_numberOfPeopleInConnection = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "同一人脉下现金贷完件人数")
  public Integer ticket_numberOfRealLoanUserInConnection = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "一度人脉下人数")
  public Integer ticket_numberOfPeopleInOneDegreeConnection = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "一度人脉下现金贷完件人数")
  public Integer ticket_numberOfRealLoanUserInOneDegreeConnection = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "二度人脉下人数")
  public Integer ticket_numberOfPeopleInTwoDegreeConnection = null;
  @LoanCreditFeatureAnnotation(source = "统计信息", description = "二度人脉下现金贷完件人数")
  public Integer ticket_numberOfRealLoanUserInTwoDegreeConnection = null;
  @LoanCreditFeatureAnnotation(source = "", description = "成本优化")
  public Boolean general_isPruned = null;

  //黑名单特征
  @LoanCreditFeatureAnnotation(source = "CreditX", description = "CreditX黑名单")
  public Boolean creditx_isBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "聚信立黑名单")
  public Boolean juxinli_isBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "聚信立手机黑名单")
  public Boolean juxinli_isBlacklistMobile = null;
  @LoanCreditFeatureAnnotation(source = "百融", description = "百融黑名单")
  public Boolean bairong_isSpeciallist = null;
  @LoanCreditFeatureAnnotation(source = "中智诚", description = "中智诚黑名单")
  public Boolean intellicredit_isBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "平安前海", description = "前海黑名单")
  public Boolean qianhai_isBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "平安前海", description = "前海好信度分")
  public Integer qianhai_credooScore = null;
  @LoanCreditFeatureAnnotation(source = "平安前海", description = "前海常贷客")
  public Integer qianhai_loaneeAmount = null;

  @LoanCreditFeatureAnnotation(source = "91征信", description = "借贷总数")
  public Integer zhengxin91_loanCount = null;
  @LoanCreditFeatureAnnotation(source = "91征信", description = "拒贷笔数")
  public Integer zhengxin91_rejectedLoanCount = null;
  @LoanCreditFeatureAnnotation(source = "91征信", description = "批贷笔数")
  public Integer zhengxin91_approvedLoanCount = null;
  @LoanCreditFeatureAnnotation(source = "91征信", description = "正常还款笔数")
  public Integer zhengxin91_normalRepayCount = null;
  @LoanCreditFeatureAnnotation(source = "91征信", description = "逾期笔数")
  public Integer zhengxin91_overdueRepayCount = null;
  @LoanCreditFeatureAnnotation(source = "91征信", description = "结清笔数")
  public Integer zhengxin91_closedRepayCount = null;

  //face++特征
  @LoanCreditFeatureAnnotation(source = "Face++", description = "活体与身份证人脸匹配(误识率千分之一)")
  public Boolean face_isLiveFaceMatchIDCardFace_FPR1000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "活体与身份证人脸匹配(误识率万分之一)")
  public Boolean face_isLiveFaceMatchIDCardFace_FPR10000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "活体与身份证人脸匹配(误识率十万分之一)")
  public Boolean face_isLiveFaceMatchIDCardFace_FPR100000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "活体与公安人脸匹配(误识率千分之一)")
  public Boolean face_isLiveFaceMatchPoliceRecord_FPR1000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "活体与公安人脸匹配(误识率万分之一)")
  public Boolean face_isLiveFaceMatchPoliceRecord_FPR10000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "活体与公安人脸匹配(误识率十万分之一)")
  public Boolean face_isLiveFaceMatchPoliceRecord_FPR100000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "身份证与公安人脸匹配(误识率千分之一)")
  public Boolean face_isIDCardFaceMatchPoliceRecord_FPR1000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "身份证与公安人脸匹配(误识率万分之一)")
  public Boolean face_isIDCardFaceMatchPoliceRecord_FPR10000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "身份证与公安人脸匹配(误识率十万分之一)")
  public Boolean face_isIDCardFaceMatchPoliceRecord_FPR100000 = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "身份证号码是否曾被冒用来攻击活体检测")
  public Boolean face_isIdAttacked = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "是否软件人工合成的脸")
  public Boolean face_isSyntheticFace = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "是否戴面具的脸")
  public Boolean face_isMask = null;
  @LoanCreditFeatureAnnotation(source = "Face++", description = "是否屏幕翻拍回放的脸")
  public Boolean face_isScreenReplay = null;

  //银联智慧
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "银联智慧卡查询是否成功")
  public Boolean unionpay_hasUnionPaySmartData = null;
  
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "月均交易金额")
  public Float averageMonthlyTransactionAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "月均交易笔数")
  public Integer averageMonthlyTransactionTimes = null;
  
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月银行卡入账总金额")
  public Float bankCardIncomeAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月银行卡入账总金额")
  public Float bankCardIncomeAmount_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月银行卡入账总笔数")
  public Float bankCardIncomeTimes_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月银行卡入账总笔数")
  public Float bankCardIncomeTimes_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "境外交易金额")
  public Float internationalTransactionAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "境外交易金额占比")
  public Integer internationalTransactionAmountProportion = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "境外交易笔数")
  public Integer internationalTransactionTimes = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "境外交易笔数占比")
  public Integer internationalTransactionTimesProportion = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "全部历史交易总金额（消费类）")
  public Float totalConsumerTransactionAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月交易总金额（消费类）")
  public Float totalConsumerTransactionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月交易总金额（消费类）")
  public Float totalConsumerTransactionAmount_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近3月交易总金额（消费类）")
  public Float totalConsumerTransactionAmount_M3 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "全部历史交易总笔数（消费类）")
  public Integer totalConsumerTransactionTimes = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月交易总笔数（消费类）")
  public Integer totalConsumerTransactionTimes_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月交易总笔数（消费类）")
  public Integer totalConsumerTransactionTimes_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近3月交易总笔数（消费类）")
  public Integer totalConsumerTransactionTimes_M3 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月月均消费金额")
  public Float averageMonthlyConsumptionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月网购金额")
  public Float onlineTransactionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月网购笔数")
  public Integer onlineTransactionTimes_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月网购金额")
  public Float onlineTransactionAmount_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月网购笔数")
  public Integer onlineTransactionTimes_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "2011年至今有交易的月数")
  public Integer monthsWithTransaction_Y2011 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "全部历史交易总天数")
  public Integer daysWithTransaction_Y2011 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "低额交易占比")
  public Integer smallTransactionProportionByAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "中额交易占比")
  public Integer mediumTransactionProportionByAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "高额交易占比")
  public Integer bigTransactionProportionByAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "低额交易笔数占比")
  public Integer smallTransactionProportionByTimes = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "中额交易笔数占比")
  public Integer mediumTransactionProportionByTimes = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "高额交易笔数占比")
  public Integer bigTransactionProportionByTimes = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "取现金额占交易金额比例")
  public Integer withdrawProportionByAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "交易活跃月数比例")
  public Integer activeProportionByMonth = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "交易活跃天数")
  public Integer activeDays = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "交易活跃天数比例")
  public Float activeProportionByDay = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "还贷能力指标")
  public Float repayAbilityAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最近一笔交易距今天数")
  public Integer daysSinceLatestTransactionTime = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "第一笔交易时间距今月数")
  public Integer monthsSinceFirstTransactionTime = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月有交易的月数")
  public Integer monthsWithTransaction_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "是否银联高端客户")
  public Boolean isUnionPayHighEndCustomer = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "单笔最大金额、交易类型（近3月）")
  public Float maxTransactionAmount_M3 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "单笔最大金额、交易类型（近6月）")
  public Float maxTransactionAmount_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "单笔最大金额、交易类型（近12月）")
  public Float maxTransactionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "单笔最大金额、交易类型")
  public Float maxTransactionAmount = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月最大单日累计消费金额")
  public Float maxTransactionAmountInSingleDay_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月最大单日累计消费金额")
  public Float maxTransactionAmountInSingleDay_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近6月最大单日累计消费笔数")
  public Integer maxTransactionTimesInSingleDay_M6 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月最大单日累计消费笔数")
  public Integer maxTransactionTimesInSingleDay_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最大月交易金额（消费类）")
  public Float maxMonthlyConsumerTransactionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最大月交易金额（银行类）")
  public Float maxMonthlyBankTransactionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最大月交易金额（全部）")
  public Float maxMonthlyTransactionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最大月交易次数（消费类）")
  public Integer maxMonthlyConsumerTransactionTimes_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最大月交易次数（银行类）")
  public Integer maxMonthlyBankTransactionTimes_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最大月交易次数（全部）")
  public Integer maxMonthlyTransactionTimes_M12 = null;

  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "地域流动性")
  public Integer geographicalMobility = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "卡等级")
  public String cardLevel = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "每月交易金额同城排名（消费类）")
  public String monthlyConsumerTransactionAmountRank = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月月均消费金额本市对比")
  public Integer averageMonthlyTransactionAmountRank_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "年交易笔数同城排名（消费类）")
  public Integer consumerTransactionTimesRank_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月平均笔单价")
  public Float averageTransactionAmount_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月平均笔单价同市排名")
  public Integer averageTransactionAmountRank_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "最长交易天数间隔")
  public Integer longestTransactionInterval_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "近12月罚款笔数")
  public Integer penaltyTimes_M12 = null;
  @LoanCreditFeatureAnnotation(source = "银联智慧", description = "是否有车")
  public Boolean hasCar = null;

  @LoanCreditFeatureAnnotation(source = "聚信立", description = "运营商采集是否成功")
  public Boolean juxinli_hasMobileData = null;
  //聚信立application_check
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "运营商实名认证")
  public Boolean juxinli_application_reliability = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "姓名是否与运营商数据匹配")
  public Boolean juxinli_application_isNameMatchMobileRecord = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "身份证号码是否与运营商数据匹配")
  public Boolean juxinli_application_isIDMatchMobileRecord = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "运营商是否提供身份证号码")
  public Boolean juxinli_application_hasIDInMobileRecord = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人姓名+身份证是否出现在法院黑名单")
  public Boolean juxinli_application_isNameAndIDInJudicialBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人姓名+身份证是否出现在金融服务类机构黑名单")
  public Boolean juxinli_application_isNameAndIDInFinancialBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人姓名+手机号码是否出现在金融服务类机构黑名单")
  public Boolean juxinli_application_isNameAndMobileInFinancialBlacklist = null;
  //聚信立behavior_check
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "关机天数")
  public Integer juxinli_behavior_dayOfPoweredOff = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "连续三天以上关机次数")
  public Integer juxinli_behavior_timesOfPoweredOffMoreThanThreeDays = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "110话通话情况")
  public String juxinli_behavior_call110FrequencyResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "120话通话情况")
  public String juxinli_behavior_call120FrequencyResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "律师号码通话情况")
  public String juxinli_behavior_callLawyerFrequencyResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "法院号码通话情况")
  public String juxinli_behavior_callCourtFrequencyResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "号码使用时间")
  public String juxinli_behavior_mobileServiceTimeResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "号码使用时长")
  public Integer juxinli_behavior_monthOfMobileService = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "互通过电话的号码数量")
  public String juxinli_behavior_twoWayCallNumberResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码联系情况")
  public String juxinli_behavior_contactLoanRelatedNumberResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码联系情况详情")
  public String juxinli_behavior_contactLoanRelatedNumberEvidence = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码呼入次数")
  public Integer juxinli_callInTimesWithLoanRelatedNumber = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码呼出次数")
  public Integer juxinli_callOutTimesWithLoanRelatedNumber = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码数目")
  public Integer juxinli_numberOfLoanRelatedNumber = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码无呼出数目")
  public Integer juxinli_numberOfLoanRelatedNumberWithoutOutCall = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码无呼入数目")
  public Integer juxinli_numberOfLoanRelatedNumberWithoutInCall= null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "贷款类号码单次呼入数目")
  public Integer juxinli_numberOfLoanRelatedNumberWithSingleInCall = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "银行类号码联系情况")
  public String juxinli_behavior_contactBankNumberResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "信用卡类号码联系情况")
  public String juxinli_behavior_contactCreditCardRelatedNumberResult = null;

  //聚信立cell_behavior
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均短信数量")
  public Integer juxinli_cell_averageSMSCountOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均流量")
  public Float juxinli_cell_averageNetFlowOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均话费")
  public Float juxinli_cell_averageTotalAmountOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均呼出时间")
  public Float juxinli_cell_averageCallOutTimeOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均电话数量")
  public Integer juxinli_cell_averageCallCountOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均呼出数量")
  public Integer juxinli_cell_averageCallOutCountOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均呼入时间")
  public Float juxinli_cell_averageCallInTimeOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月平均呼入数量")
  public Integer juxinli_cell_averageCallInCountOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月常住地")
  public String juxinli_cell_mostCellLocationOver6Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "近6个月常住地匹配联系地址省份或出生省份")
  public Boolean juxinli_cell_isMostCellLocationOver6MonthMatchContactProvinceOrBornProvince = null;
  //聚信立旅行信息
  //聚信立联系人统计信息
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "最经常联系地点")
  public String juxinli_mostContactLocation = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "最经常联系地点匹配联系地址省份或出生省份")
  public Boolean juxinli_cell_isMostContactLocationMatchContactProvinceOrBornProvince = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "第二经常联系地点")
  public String juxinli_secondContactLocation = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "第二经常联系地点匹配联系地址省份或出生省份")
  public Boolean juxinli_cell_isSecondContactLocationMatchContactProvinceOrBornProvince = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "第三经常联系地点")
  public String juxinli_thirdContactLocation = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "第三经常联系地点匹配联系地址省份或出生省份")
  public Boolean juxinli_cell_isThirdContactLocationMatchContactProvinceOrBornProvince = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话地点数量")
  public Integer juxinli_numberOfContactLocations = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录人数")
  public Integer juxinli_numberOfPeopleInContactRecord = null;
  @LoanCreditFeatureAnnotation(source = "聚信立&鉴权信息", description = "通讯录与通话记录交集")
  public Integer numberOfOverlapPeopleBetweenAddressBookAndContactRecord = null;

  @LoanCreditFeatureAnnotation(source = "聚信立", description = "紧急联系人黑名单")
  public Boolean isImmediateContactBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "与紧急联系人是否有联系")
  public Boolean hasContactRecordWithImmediateContact = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "与紧急联系人是否有双向联系")
  public Boolean hasTwoWayContactRecordWithImmediateContact = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "与紧急联系人联系次数")
  public Integer callCountWithImmediateContact = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "自上次紧急联系人呼入天数")
  public Integer daysAfterLastInCallWithImmediateContact = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "自上次呼叫紧急联系人天数")
  public Integer daysAfterLastOutCallWithImmediateContact = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "紧急联系人是Top10联系人")
  public Boolean isImmediateContactTop10Contact = null;

  @LoanCreditFeatureAnnotation(source = "聚信立", description = "最近呼出距今天数")
  public Integer daysAfterLastOutCall = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "最近呼入距今天数")
  public Integer daysAfterLastInCall = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录全天候呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactAllDay = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录三月以上呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactMoreThanThreeMonth = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录一到三月呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactOneToThreeMonth = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录一周到一月呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactOneWeekToOneMonth = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录一周内呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactLessThanOneWeek = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录假期呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactHoliday = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录工作日呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactWeekday = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录周末呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactWeekend = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录中午呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactNoon = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录下午呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactAfterNoon = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录早晨呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactEarlyMorning = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录午夜呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactNight = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录上午呼叫人数")
  public Integer juxinli_numberOfPeopleInContactRecordWithContactMorning = null;

  //聚信立蜜罐
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "直接联系人在黑名单的数量")
  public Integer juxinli_usergrid_contactsClass1BlacklistCount = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "间接联系人在黑名单的数量")
  public Integer juxinli_usergrid_contactsClass2BlacklistCount = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "引起二阶黑名单人数")
  public Integer juxinli_usergrid_contactsRouterCount = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "引起占比")
  public Float juxinli_usergrid_contactsRouterRatio = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "一阶联系人总数")
  public Integer juxinli_usergrid_contactsClass1Count = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "手机号码灰度分数")
  public Integer juxinli_usergrid_phoneGrayScore = null;

  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "用户注册软件数目")
  public Integer juxinli_usergrid_userRegisterCount = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "用户注册借贷软件数目")
  public Integer juxinli_usergrid_userRegisterInLoanOrganization = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "用户注册理财软件数目")
  public Integer juxinli_usergrid_userRegisterInFinanceOrganization = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "用户注册借贷或理财软件数目")
  public Integer juxinli_usergrid_userRegisterInLoanOrFinanceOrganization = null;

  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "用户被机构查询数量")
  public Integer juxinli_usergrid_searchedOrganizationCount = null;

  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "手机号关联的其它身份证数目")
  public Integer juxinli_usergrid_numberOfOtherIdCardWithPhone = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "手机号关联的其它名字数目")
  public Integer juxinli_usergrid_numberOfOtherNameWithPhone = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "手机号在机构中出现的次数")
  public Integer juxinli_usergrid_numberOfApplicationWithPhone = null;

  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "身份证关联的其它手机数目")
  public Integer juxinli_usergrid_numberOfOtherPhoneWithIdCard = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "身份证关联的其它名字数目")
  public Integer juxinli_usergrid_numberOfOtherNameWithIdCard = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "身份证在机构中出现的次数")
  public Integer juxinli_usergrid_numberOfApplicationWithIdCard = null;

  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "用户被查询数目")
  public Integer juxinli_usergrid_numberOfUserSearchedHistory = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "1个月内用户被查询数目")
  public Integer juxinli_usergrid_numberOfUserSearchedHistoryWithin1Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "3个月内用户被查询数目")
  public Integer juxinli_usergrid_numberOfUserSearchedHistoryWithin3Month = null;
  @LoanCreditFeatureAnnotation(source = "聚信立蜜罐", description = "6个月内用户被查询数目")
  public Integer juxinli_usergrid_numberOfUserSearchedHistoryWithin6Month = null;


  /*account统计信息*/
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "与紧急联系人之间关系")
  public Integer loan_relationshipWithImmediateContact = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "紧急联系人与用户手机号或银行卡预留手机号相同")
  public Boolean loan_isImmediateContactMobileSameWithMobileOrCardMobile = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "通讯录人数")
  public Integer loan_numberOfPeopleInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "通讯录中至亲人数")
  public Integer loan_numberOfClosePeopleInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "通讯录中旁亲人数")
  public Integer loan_numberOfCollateralPeopleInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "手机应用数量")
  public Integer loan_numberOfPhoneApps = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "联系地址与GPS定位省份匹配")
  public Boolean loan_isAddressProvinceMatchGPS = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "联系地址与GPS定位城市匹配")
  public Boolean loan_isAddressCityMatchGPS = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "联系地址与GPS定位区域匹配")
  public Boolean loan_isAddressDistrictMatchGPS = null;

  /*同盾注册*/
  @LoanCreditFeatureAnnotation(source = "同盾注册", description = "注册事件是否成功")
  public Boolean tongdun_hasRegisterEvent = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜失信风险", description = "注册信息命中同盾黑名单库(失信／欺诈／黑中介等)")
  public Boolean tongdun_isBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "注册设备安卓模拟器识别")
  public Boolean tongdun_isRegisterAndroidSimulator = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "注册设备作弊工具识别")
  public Boolean tongdun_isRegisterDeviceFraud = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "注册设备越狱识别")
  public Boolean tongdun_isRegisteriOSJailBreak = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "注册代理检测")
  public Boolean tongdun_isRegisterWithProxy = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜垃圾注册", description = "注册时设备标识缺失异常")
  public Boolean tongdun_isRegisterWithoutBlackbox = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "1天内设备注册次数过多")
  public Boolean tongdun_isDeviceRegisterFloodingOver1Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "3天内设备注册次数过多")
  public Boolean tongdun_isDeviceRegisterFloodingOver3Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "7天内设备注册次数过多")
  public Boolean tongdun_isDeviceRegisterFloodingOver7Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "1月内设备注册次数过多")
  public Boolean tongdun_isDeviceRegisterFloodingOver1Month = null;
  @LoanCreditFeatureAnnotation(source = "同盾注册｜异常注册", description = "1天内IP注册次数过多")
  public Boolean tongdun_isIPRegisterFloodingOver1Day = null;

  /*同盾借款*/
  @LoanCreditFeatureAnnotation(source = "同盾借款", description = "借款事件是否成功")
  public Boolean tongdun_hasLoanEvent = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款", description = "借款设备价格")
  public Integer tongdun_loanDevicePrice = null;

  @LoanCreditFeatureAnnotation(source = "同盾借款", description = "联系地址与身份证省份匹配")
  public Boolean tongdun_isAddressProvinceMatchIDCardProvince = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款", description = "联系地址与身份证城市匹配")
  public Boolean tongdun_isAddressCityMatchIDCardCity = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款", description = "联系地址与身份证县区匹配")
  public Boolean tongdun_isAddressDistrictMatchIDCardCounty = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款", description = "联系地址与手机归属地省份匹配")
  public Boolean tongdun_isAddressProvinceMatchMobileProvince = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款", description = "联系地址与手机归属地城市匹配")
  public Boolean tongdun_isAddressCityMatchMobileCity = null;

  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "非官方APP识别")
  public Boolean tongdun_isNotOfficialApp = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "身份证归属地位于高风险较为集中地区")
  public Boolean tongdun_isIDAddressHighRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "借款设备代理识别")
  public Boolean tongdun_isLoanWithProxy = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "借款设备作弊工具识别")
  public Boolean tongdun_isLoanDeviceFraud = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "借款设备越狱识别")
  public Boolean tongdun_isLoaniOSJailBreak = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "借款设备标识缺失异常")
  public Boolean tongdun_isLoanWithoutBlackbox = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "邮箱黑名单")
  public Boolean tongdun_isEmailBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "3个月内身份证关联多个申请信息")
  public Boolean tongdun_isIDAssociateTooManyApplicationOver3Month = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内申请人在多个平台申请借款(身份证／手机／邮箱／设备)")
  public Boolean tongdun_isLoanFloodingCrossOrganizationOver7Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1个月内申请人在多个平台申请借款")
  public Boolean tongdun_isLoanFloodingCrossOrganizationOver1Month = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "3个月内申请人在多个平台申请借款")
  public Boolean tongdun_isLoanFloodingCrossOrganizationOver3Month = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内设备或身份证或手机号申请次数过多")
  public Boolean tongdun_isDeviceOrIDOrMobileLoanFloodingOver7Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1个月内设备或身份证或手机号申请次数过多")
  public Boolean tongdun_isDeviceOrIDOrMobileLoanFloodingOver1Month = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1天内设备使用过多的身份证或手机号进行申请")
  public Boolean tongdun_isDeviceAssociateTooManyIDOrMobileOver1Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内设备使用过多的身份证或手机号进行申请")
  public Boolean tongdun_isDeviceAssociateTooManyIDOrMobileOver7Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1天内身份证使用过多设备进行申请")
  public Boolean tongdun_isIDAssociateTooManyDeviceOver1Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内身份证使用过多设备进行申请")
  public Boolean tongdun_isIDAssociateTooManyDeviceOver7Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1个月内身份证使用过多设备进行申请")
  public Boolean tongdun_isIDAssociateTooManyDeviceOver1Month = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "第一联系人手机号3个月内在多个平台申请借款")
  public Boolean tongdun_isContact1LoanFloodingCrossOrganizationOver3Months = null;

  @LoanCreditFeatureAnnotation(source = "同盾借款｜机构代办", description = "单位名称疑似中介关键词")
  public Boolean tongdun_isOrganizationLoanAgent = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜机构代办", description = "第一联系人手机号黑名单")
  public Boolean tongdun_isContact1Blacklist = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜机构代办", description = "1天内设备上申请借款账号过多")
  public Boolean tongdun_isLoanAccountFloodingOnDeviceOver1Day = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜机构代办", description = "7天内设备上申请借款账号过多")
  public Boolean tongdun_isLoanAccountFloodingOnDeviceOver7Day = null;

  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "地址信息命中黑名单证据库")
  public Boolean tongdun_isAddressBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人身份证命中同盾欺诈高级灰名单")
  public Boolean tongdun_isLoanIDHighRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人身份证命中同盾欺诈中级灰名单")
  public Boolean tongdun_isLoanIDMediumRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人身份证命中同盾欺诈低级灰名单")
  public Boolean tongdun_isLoanIDLowRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人手机号命中同盾欺诈高级灰名单")
  public Boolean tongdun_isLoanMobileHighRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人手机号命中同盾欺诈中级灰名单")
  public Boolean tongdun_isLoanMobileMediumRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人手机号命中同盾欺诈低级灰名单")
  public Boolean tongdun_isLoanMobileLowRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人邮箱命中同盾欺诈高级灰名单")
  public Boolean tongdun_isLoanEmailHighRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人邮箱命中同盾欺诈中级灰名单")
  public Boolean tongdun_isLoanEmailMediumRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人邮箱命中同盾欺诈低级灰名单")
  public Boolean tongdun_isLoanEmailLowRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人卡号黑名单")
  public Boolean tongdun_isLoanBankCardBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人卡号命中同盾欺诈高级灰名单")
  public Boolean tongdun_isLoanBankCardHighRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人卡号命中同盾欺诈中级灰名单")
  public Boolean tongdun_isLoanBankCardMediumRisk = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜失信风险", description = "借款人卡号命中同盾欺诈低级灰名单")
  public Boolean tongdun_isLoanBankCardLowRisk = null;

  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内申请人在多个平台申请借款数目")
  public Integer tongdun_numberOfLoan_7D = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内手机号在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanByMobile_7D = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内身份证号在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanById_7D = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "7天内设备在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanByDevice_7D = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1个月内申请人在多个平台申请借款数目")
  public Integer tongdun_numberOfLoan_1M = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1个月内手机号在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanByMobile_1M = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1个月内身份证号在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanById_1M = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "1个月内设备在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanByDevice_1M = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "3个月内申请人在多个平台申请借款数目")
  public Integer tongdun_numberOfLoan_3M = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "3个月内手机号在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanByMobile_3M = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "3个月内身份证号在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanById_3M = null;
  @LoanCreditFeatureAnnotation(source = "同盾借款｜异常借款", description = "3个月内设备在多个平台申请借款数目")
  public Integer tongdun_numberOfLoanByDevice_3M = null;

  //高级统计信息
  @LoanCreditFeatureAnnotation(source = "", description = "通讯录洋钱罐注册用户数")
  public Integer numberOfYqgRegisterUserInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "", description = "通讯录洋钱罐鉴权用户数")
  public Integer numberOfYqgLoanUserInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "", description = "通讯录洋钱罐完件用户数")
  public Integer numberOfRealYqgLoanUserInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "", description = "通讯录现金贷过件用户数")
  public Integer numberOfApprovedRealYqgLoanUserInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "通讯录黑名单人数")
  public Integer numberOfPeopleIsBlacklistInAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "通讯录黑名单列表")
  public HashSet<String> addressBookBlacklist = new HashSet<>();
  @LoanCreditFeatureAnnotation(source = "", description = "通话记录洋钱罐注册用户数")
  public Integer numberOfYqgRegisterUserInContactRecord = null;
  @LoanCreditFeatureAnnotation(source = "", description = "通话记录洋钱罐鉴权用户数")
  public Integer numberOfYqgLoanUserInContactRecord = null;
  @LoanCreditFeatureAnnotation(source = "", description = "通话记录洋钱罐完件用户数")
  public Integer numberOfRealYqgLoanUserInContactRecord = null;
  @LoanCreditFeatureAnnotation(source = "", description = "通话记录现金贷过件用户数")
  public Integer numberOfApprovedRealYqgLoanUserInContactRecord = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录黑名单人数")
  public Integer numberOfPeopleIsBlacklistInContactRecord = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "通话记录黑名单列表")
  public HashSet<String> contactRecordBlacklist = new HashSet<>();
  @LoanCreditFeatureAnnotation(source = "", description = "通讯录中有双向通话记录黑名单人数")
  public Integer numberOfFriendIsBlacklist = null;
  @LoanCreditFeatureAnnotation(source = "", description = "通讯录中有单向通话记录黑名单人数")
  public Integer numberOfPeopleIsBlacklistInAddressBookWithOneWayCall = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "风险通讯录人数")
  public Integer numberOfPeopleInAddressBookContainKeyWords = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "风险通讯录列表")
  public HashSet<String> peopleInAddressBookContainKeyWords = new HashSet<>();

  @LoanCreditFeatureAnnotation(source = "", description = "淘宝联系人与通讯录交集")
  public Integer numberOfOverlapPeopleBetweenTaobaoContactAndAddressBook = null;
  @LoanCreditFeatureAnnotation(source = "", description = "淘宝联系人与通话记录交集")
  public Integer numberOfOverlapPeopleBetweenTaobaoContactAndContactRecord = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "用户投资笔数")
  public Integer assert_numberOfInvestment = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "用户投资总和")
  public Double assert_sumAmountOfInvestment = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "用户真实投资总和")
  public Double assert_sumAmountOfActualInvestment = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "用户资产总和")
  public Double assert_sumAmountOfAsset = null;

  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "用户注册时间")
  public String registerTime = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "用户绑卡(实名)时间")
  public String approximateVerifyIDTime = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "首次投资时间")
  public String firstInvestTime = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "最后投资时间")
  public String lastInvestTime = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "首次提现时间")
  public String firstWithDrawTime = null;
  @LoanCreditFeatureAnnotation(source = "洋钱罐", description = "最后提现时间")
  public String lastWithDrawTime = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "用户完件时间")
  public String applyLoanTime = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "用户完件时刻")
  public Integer applyLoanHour = null;
  @LoanCreditFeatureAnnotation(source = "鉴权信息", description = "用户借款天数")
  public Integer loanDays = null;

  @LoanCreditFeatureAnnotation(source = "债权", description = "债权次数")
  public Integer debtTimes = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "单笔债权最大值")
  public Float debtMax = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "单笔债权最小值")
  public Float debtMin = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "债权平均值")
  public Float debtAvg = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "涉及债权公司数目")
  public Integer providerAmount = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "涉及债权公司名称")
  public HashSet<String> debtPlatformName = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "分12期还款的次数")
  public Integer instalment12Times = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "债权时段无交叉次数")
  public Integer timeNoOverlapTimes = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "事件发生时共贷总额")
  public Map<String, Float> instalmentAmount = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "事件发生时最大共贷额")
  public Float maxInstalmentAmount = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "事件发生时日均共贷总额")
  public Map<String, Float> dayInstalmentAmount = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "事件发生时最大日均共贷额")
  public Float maxDayInstalmentAmount = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "事件发生时未还共贷总额")
  public Map<String, Float> overdueInstalmentAmount = null;
  @LoanCreditFeatureAnnotation(source = "债权", description = "事件发生时最大未还共贷额")
  public Float maxOverdueInstalmentAmount = null;


  //聚信立behavior_check 量化
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_110话通话情况")
  public Integer juxinli_behavior_call110Frequency = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_120话通话情况")
  public Integer juxinli_behavior_call120Frequency = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_律师号码通话情况")
  public Integer juxinli_behavior_callLawyerFrequency = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_法院号码通话情况")
  public Integer juxinli_behavior_callCourtFrequency = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_号码使用时间")
  public Integer juxinli_behavior_mobileServiceTime = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_互通过电话的号码数量")
  public Integer juxinli_behavior_twoWayCallNumber = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_贷款类号码联系情况")
  public Integer juxinli_behavior_contactLoanRelatedNumber = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_银行类号码联系情况")
  public Integer juxinli_behavior_contactBankNumber = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_信用卡类号码联系情况")
  public Integer juxinli_behavior_contactCreditCardRelatedNumber = null;
  //淘宝数据量化
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_总体电商使用情况")
  public Integer juxinli_behavior_overallEBusinessUsage = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_申请人本人电商使用情况")
  public Integer juxinli_behavior_personalEBusinessUsage = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_虚拟商品购买情况")
  public Integer juxinli_behavior_virtualGoodsPurchase = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_彩票购买情况")
  public Integer juxinli_behavior_lotteryPurchase = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_申请人本人地址变化情况")
  public Integer juxinli_behavior_personalAddressChange = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_申请人本人最近使用工作地址情况")
  public Integer juxinli_behavior_personalLatestWorkAddressUsage = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_申请人本人最近使用居住地址情况")
  public Integer juxinli_behavior_personalLatestHomeAddressUsage = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "_申请人本人最近使用学校地址情况")
  public Integer juxinli_behavior_personalLatestSchoolAddressUsage = null;



  @LoanCreditFeatureAnnotation(source = "聚信立", description = "淘宝联系人")
  public Map<String, String> taobaoContacts = Maps.newHashMap();

  @LoanCreditFeatureAnnotation(source = "鹏元", description = "司法案例信息条数")
  public Integer pengyuan_judicialCaseCount = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "司法执行信息条数")
  public Integer pengyuan_judicialEnforcementCount = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "司法失信信息条数")
  public Integer pengyuan_judicialViolationCount = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "税务行政执法信息条数")
  public Integer pengyuan_taxAndLawAdministrativeCount = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "催欠公告信息条数")
  public Integer pengyuan_dunningCount = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "网贷逾期信息条数")
  public Integer pengyuan_p2pOverdueCount = null;

  @LoanCreditFeatureAnnotation(source = "鹏元", description = "鹏元卡查询是否成功")
  public Boolean pengyuan_hasCardData = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "银行卡三要素鉴权匹配")
  public Boolean pengyuan_card_isBankAccountMatch = null;
  /*PersonCardTransInfo*/
  //CardInfo
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "卡等级名称")
  public String pengyuan_card_cardLevel = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "卡性质名称")
  public String pengyuan_card_cardAttr = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "卡种名称")
  public String pengyuan_card_cardClass = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "卡品牌名称")
  public String pengyuan_card_cardBrand = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "卡产品名称")
  public String pengyuan_card_cardProduct = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "两年内有效活跃月份")
  public Integer pengyuan_card_monthSinceFirstExpenseWithinTwoYears = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "收入总金额")
  public String pengyuan_card_cardTotalIncome = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "收入总次数")
  public String pengyuan_card_cardTotalIncomeTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "支出总金额")
  public String pengyuan_card_cardTotalExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "支出总次数")
  public String pengyuan_card_cardTotalExpenseTimes = null;
  //TransOverView
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "收入总金额")
  public String pengyuan_card_totalIncome = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "收入总次数")
  public String pengyuan_card_totalIncomeTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "支出总金额")
  public String pengyuan_card_totalExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "支出总次数")
  public String pengyuan_card_totalExpenseTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月平均收入金额")
  public String pengyuan_card_avgMonthIncome = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月平均收入次数")
  public String pengyuan_card_avgMonthIncomeTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月平均支出金额")
  public String pengyuan_card_avgMonthExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月平均支出次数")
  public String pengyuan_card_avgMonthExpenseTimes = null;
  //monthTrans
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月统计最高收入金额")
  public Float pengyuan_card_monthTotalHighestIncome = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月统计最高收入次数")
  public Integer pengyuan_card_monthTotalHighestIncomeTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月统计最高支出金额")
  public Float pengyuan_card_monthTotalHighestExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月统计最高支出次数")
  public Integer pengyuan_card_monthTotalHighestExpenseTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "单笔最高支出金额")
  public String pengyuan_card_singleHighestExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "月统计最高支出月份")
  public String pengyuan_card_monthHighest = null;//单笔支出最高月份
  //AllCardsSingleExpenseTop5Item
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "单笔前五总支出金额")
  public Float pengyuan_card_sumSingleExpenseTop5 = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "单笔前五支出范围")
  public Float pengyuan_card_rangeSingleExpenseTop5 = null;
  //OnlineTotalExpenseStatis
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "线上支出总金额")
  public String pengyuan_card_onlineTotalExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "线上支出总次数")
  public String pengyuan_card_onlineTotalExpenseTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "线上支出占总支出金额比例")
  public String pengyuan_card_onlinePercent = null;
  //AreaExpenseStatis
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "内地支出总金额")
  public Float pengyuan_card_domesticTotalExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "内地支出总次数")
  public Integer pengyuan_card_domesticTotalExpenseTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "内地发生交易的总天数")
  public Integer pengyuan_card_domesticExpenseTotalDays = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "港澳台及境外支出总金额")
  public Float pengyuan_card_internTotalExpense = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "港澳台及境外支出总次数")
  public Float pengyuan_card_internTotalExpenseTimes = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "港澳台及境外发生交易的总天数")
  public Integer pengyuan_card_internExpenseTotalDays = null;
  //moreThan2000
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "单笔2000以上总次数")
  public Integer pengyuan_card_moreThan2000STimes = null;
  /*PersonCardTransInfo-end*/
  //鹏元教育
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "鹏元教育查询是否成功")
  public Boolean pengyuan_hasEducationData = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "学校排名")
  public Integer pengyuan_education_collegeRank = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "学历等级")
  public Integer pengyuan_education_degree = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "毕业时间")
  public Integer pengyuan_education_graduateYears = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "毕业结果")
  public Integer pengyuan_education_studyResult = null;
  @LoanCreditFeatureAnnotation(source = "鹏元", description = "风险特征及授信建议")
  public String pengyuan_education_riskAndAdviceInfo = null;

  //淘宝数据
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "淘宝采集是否成功")
  public Boolean juxinli_hasTaobaoData = null;

  @LoanCreditFeatureAnnotation(source = "聚信立", description = "淘宝实名认证")
  public Boolean juxinli_taobao_reliability = null;

  @LoanCreditFeatureAnnotation(source = "聚信立", description = "总体电商使用情况")
  public String juxinli_behavior_overallEBusinessUsageResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人本人电商使用情况")
  public String juxinli_behavior_personalEBusinessUsageResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "虚拟商品购买情况")
  public String juxinli_behavior_virtualGoodsPurchaseResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "彩票购买情况")
  public String juxinli_behavior_lotteryPurchaseResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人本人地址变化情况")
  public String juxinli_behavior_personalAddressChangeResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人本人最近使用工作地址情况")
  public String juxinli_behavior_personalLatestWorkAddressUsageResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人本人最近使用居住地址情况")
  public String juxinli_behavior_personalLatestHomeAddressUsageResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "申请人本人最近使用学校地址情况")
  public String juxinli_behavior_personalLatestSchoolAddressUsageResult = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "本人号码是否用于淘宝收货")
  public Boolean juxinli_behavior_isMobileNumberTaobaoReceiver = null;

  @LoanCreditFeatureAnnotation(source = "聚信立", description = "淘宝使用月数")
  public Integer juxinli_behavior_serviceMonthOfTaobao = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "淘宝月均使用次数")
  public Integer juxinli_behavior_monthglyExpenseCount = null;
  @LoanCreditFeatureAnnotation(source = "聚信立", description = "淘宝月均消费")
  public Float juxinli_behavior_monthglyExpenseAmount = null;

  
}
