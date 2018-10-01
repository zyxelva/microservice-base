package com.taeyeon.zyx.common;

/**
 * 异常代码类
 * 10000以下为系统级错误
 * 1XXX 为数据库相关
 * 2XXX 为缓存操作相关
 * 3XXX 为调用外部接口相关 连接异常或超时
 * <p>
 * 10XXX 为公共的业务错误
 * 11XXX 为教材服务相关错误
 * 12XXX 为课程产品业务相关错误
 * 13XXX 为老师业务相关错误
 * 14XXX 为学生课节相关错误
 * 15XXX 为业务配置相关错误
 * 16XXX 为账本模块相关错误
 * 17XXX 为商品模块相关错误
 * 18XXX 为订单模块相关错误
 * 19XXX 为课节服务相关错误
 * 20XXX 为通知模块相关错误
 * 21XXX 为日志上传相关错误
 * 22XXX 为学生管理相关错误
 * Created by lynn on 2018/4/17.
 */
public class ErrCodeConsts {
    /**
     * 系统级错误
     * 迁移至 cn.huanju.edu100.util.Constants.SysError 给各个系统共用
     */
    /**
     * 公共业务级错误
     */
    public interface BussinessError {
        /**
         * 参数缺失
         */
        int ParamLost = 10001;
        /**
         * 参数错误
         */
        int ParamMError = 10002;
        /**
         * 对象不存在
         */
        int ObjNotExists = 10003;
        /**
         * 业务错误
         */
        int BubinessError = 10004;
        /**
         * 对象已经存在
         */
        int ObjAlreadyExists = 10005;
        /**
         * 对象太大超出限制
         */
        int ObjIsTooBig = 10006;
        /**
         * 更新人为空
         */
        int UpdateByEmpty = 10007;
        /**
         * 添加失败
         */
        int AddError = 10008;

        /**
         * 创建人为空
         */
        int CreateByEmpty = 10009;
        /**
         * 创建开始时间为空
         */
        int CreateBeginDateEmpty = 10010;
        /**
         * 创建结束时间为空
         */
        int CreateEndDateEmpty = 10011;
    }

    /**
     * 教材业务错误
     */
    public interface KnowledgeError {
        /**
         * 教材未上架
         */
        int NotOnShelf = 11001;
        /**
         * 教材code为空
         */
        int TextBookCodeEmpty = 11002;
        /**
         * 教材code重复
         */
        int DuplicateBookCode = 11003;
        /**
         * 教材英文名为空
         */
        int TextBookEnNameEmpty = 11004;
        /**
         * 教材封面url不能为空
         */
        int TextBookCoverUrlEmtpy = 11005;
        /**
         * 教材业务类型不能为空
         */
        int TextBookBusiTypeEmpty = 11006;
        /**
         * 教材不是新建状态
         */
        int TextBookNotNewStatus = 11007;
        /**
         * 教材不是更新中状态
         */
        int TextBookNotModifyStatus = 11008;
        /**
         * 教材编辑版本不存在
         */
        int TextBookEditVersionNotExist = 11009;
        /**
         * 已发布教材不存在
         */
        int TextBookNotExist = 11010;
        /**
         * 章节教学目标为空
         */
        int ChapterGoalEmpty = 11011;
        /**
         * 章节词语为空
         */
        int ChapterWordsEmpty = 11012;
        /**
         * 章节句型为空
         */
        int ChapterSentencePatternEmpty = 11013;
        /**
         * 章节语法为空
         */
        int ChapterGrammarEmpty = 11014;
        /**
         * 更新人为空
         */
        int UpdateByEmpty = 11015;
        /**
         * 章节不存在
         */
        int ChapterNotExist = 11016;
        /**
         * 章节编辑版本不存在
         */
        int ChapterEditVersionNotExist = 11017;
        /**
         * 课序级别错误 课序只能属于unit节点
         */
        int StandardClassLevelErr = 11018;
        /**
         * 课序不存在
         */
        int StandardClassNotExist = 11019;
        /**
         * 审核课序不存在，
         */
        int SpproveStandardClassNotExist = 11020;
        /**
         * 章节id为空
         */
        int ChapterIdEmpty = 11021;
        /**
         * 审核章节不存在，
         */
        int SpproveChaptersNotExist = 11022;
        /**
         * 审核课序尚未完善，
         */
        int SpproveStandardClassErr = 11023;

        int ChapterEnNameEmpty = 11024;

        int ChapterCodeEmpty = 11025;

        int ChapterSeqEmpty = 11026;

        int TextBookIdEmpty = 11027;

        int CreateByEmpty = 11028;

        int ChapterStatusNotNew = 11029;

        /**
         * 知识点分类名字为空
         */
        int KnowledgeCategoryNameEmpty = 11030;
        /**
         * 知识点内容为空
         */
        int KnowledgeContentEmpty = 11031;

        /**
         * 知识点分类id为空
         */
        int KnowledgeCategoryIdEmpty = 11032;
        /**
         * 知识点内容id为空
         */
        int KnowledgeContentIdEmpty = 11033;
        /**
         * 知识点内容类型为空
         */
        int KnowledgeContentTypeEmpty = 11034;
        /**
         * 知识点分类名字唯一值重复
         */
        int KnowledgeCategoryDuplicateName = 11035;

        /**
         * 知识点分类新增失败
         */
        int KnowledgeCategoryAddErr = 11036;
        /**
         * 知识点分类修改失败
         */
        int KnowledgeCategoryUpdateErr = 11037;
        /**
         * 知识点内容修改失败
         */
        int KnowledgeContentUpdateErr = 11038;
        /**
         * 知识点内容新增失败
         */
        int KnowledgeContentAddErr = 11039;
        /**
         * 知识点内容唯一值重复
         */
        int KnowledgeContentDuplicate = 11040;
        /**
         * 知识点内容单词唯一值重复
         */
        int KnowledgeWordsDuplicate = 11041;
        /**
         * 知识点内容词块唯一值重复
         */
        int KnowledgeChunkDuplicate = 11042;
        /**
         * 知识点内容句子唯一值重复
         */
        int KnowledgeSentencesDuplicate = 11043;
        /**
         * 章节不属于教材
         */
        int ChapterNotBelogToTextBook = 11044;
        /**
         * 章节的unit不属于level
         */
        int ChapterUnitNotBelongToLevel = 11045;
        /**
         * unit的上级level不存在
         */
        int ParentChapterNotExist = 11046;
        /**
         * 不能移动到其他教材
         */
        int CannotMoveToOtherTextBook = 11047;
        /**
         * 不能给unit增加子节点
         */
        int CannotAddChildUnit = 11048;
        /**
         * 不能修改课件的所属课序
         */
        int CannotMoveToOtherStandardClass = 11049;
        /**
         * 课件不能修改
         */
        int CoursewareIsNotReject = 11050;
        /**
         * 课件已废弃
         */
        int CoursewareIsAbandoned = 11051;
        /**
         * 课件不存在
         */
        int CoursewareNotExist=11052;
    }

    /**
     * 课程产品业务错误
     */
    public interface CourseError {
        /**
         * 课程未上架
         */
        int NotOnShelf = 12001;
        /**
         * 班级类型为空
         */
        int ClassTypeEmpty = 12002;
        /**
         * 上课时间为空
         */
        int LessonTimeEmpty = 12003;
        /**
         * 老师建议课酬为空
         */
        int TeacherRemunerationEmpty = 12004;
        /**
         * 课程名字为空
         */
        int CourseNameEmpty = 12005;

        /**
         * 业务类型为空
         */
        int BusiTypeEmpty = 12006;
        /**
         * 课程id为空
         */
        int CourseIdEmpty = 12007;
        /**
         * 课程类型为空
         */
        int CourseTypeEmpty = 12008;
        /**
         * 产品类型为空
         */
        int ProductTypeEmpty = 12009;
        /**
         * 产品状态错误，不能提交审核
         */
        int ProductStatusErr = 12010;
        /**
         * 产品id为空
         */
        int ProductIdEmpty = 12011;
        /**
         * 产品为空
         */
        int ProductEmpty = 12012;
        /**
         * 排课时间冲突
         */
        int AddLessonTimeConflict = 12013;
        /**
         * 课节开始时间错误
         */
        int InvalidLessonStartTime = 12014;
        /**
         * 课节修改错误
         */
        int LessonUpdateErr = 12015;

        /**
         * 课程老师已经存在
         */
        int TeacherCourseAlreadyExist = 12016;
        /**
         * 课节ID为空
         */
        int LessonIdEmpty = 12017;

        /**
         * 查询开始时间错误
         */
        int InvalidQueryStartTime = 12018;

        /**
         * 查询结束时间错误
         */
        int InvalidQueryEndTime = 12019;

        /**
         * 学生ID为空
         */
        int StudentUidEmpty = 12020;

        /**
         * 课节都取消原因为空
         */
        int LessonCancelReasonEmpty = 12021;

        /**
         * 课节已经被抢光
         */
        int LessonbookingIsNotEnough = 12022;

        /**
         * 获取课节异常
         */
        int LessonbookingGetError = 12023;

        /**
         * 老师时间已有课
         */
        int LessonTuidStartTimeAlready = 12024;
        /**
         * 课程模板为空
         */
        int CourseTemplateIsNull = 12025;
        /**
         * 产品不存在
         */
        int ProductNotExist = 12026;
        /**
         * 课序是否循环为空
         */
        int CycleFlagEmpty = 12027;
        int CourseTeacherAlreadyExist = 30028;
    }

    /**
     * 老师业务错误
     */
    public interface TeacherError {
        /**
         * 老师资格不够
         */
        int WithoutQualification = 13001;
        /**
         * uid为空
         */
        int UidNotExist = 13002;
        /**
         * 用户头像不存在
         */
        int PersonalPhotoNotExist = 13003;
        /**
         * 老师课程列表为空
         */
        int TeacherCourseListEmpty = 13004;
        /**
         * 老师电话为空
         */
        int MobileIsEmpty = 13005;
        /**
         * 老师类型为空
         */
        int TypeIsEmpty = 13006;
        /**
         * 老师姓名为空
         */
        int RealNameIsEmpty = 13007;
        /**
         * 老师学历为空
         */
        int DiplomaIsEmpty = 13008;
        /**
         * 老师年龄为空
         */
        int TeachAgeIsEmpty = 13009;
        /**
         * 老师性别为空
         */
        int SexIsEmpty = 13010;
        /**
         * 老师来源为空
         */
        int SourceIsEmpty = 13011;
        /**
         * 老师状态为空
         */
        int StateIsEmpty = 13012;
        /**
         * 老师邮箱为空
         */
        int EmailIsEmpty = 13013;
        /**
         * 国家为空
         */
        int CountryIsEmpty = 13014;
        /**
         * 城市为空
         */
        int CityIsEmpty = 13015;
        /**
         * 省市为空
         */
        int ProvinceIsEmpty = 13016;
        /**
         * 区域为空
         */
        int DistrictIsEmpty = 13017;
    }

    /**
     * 学生课节错误
     */
    public interface StudentLessonError {
        /**
         * 时间未到
         */
        int NotToTheTime = 14001;
    }

    /**
     * 业务配置模块
     */
    public interface BusiConfigError {
        /**
         * 业务唯一值重复
         */
        int DuplicateBusiConfigValue = 15001;
        /**
         * 业务类型ID为空
         */
        int IdEmpty = 15002;
        /**
         * 业务名称为空
         */
        int LabelEmpty = 15003;
        /**
         * 业务编码为空
         */
        int ValueEmpty = 15004;
        /**
         * 业务类别为空
         */
        int TypeEmpty = 15005;
        /**
         * 业务状态为空
         */
        int StatusEmpty = 15006;
    }

    /**
     * 订单模块模块
     */
    public interface OrderError {
        /**
         * 订单ID为空
         */
        int OrderIdEmpty = 18000;

        /**
         * 取消人不能为空
         */
        int ClsByEmpty = 18001;

        /**
         * 取消原因不能为空
         */
        int ClsReasonEmpty = 18002;

        /**
         * 商品为空
         */
        int GoodsIdEmpty = 18003;

        /**
         * 售卖用户为空
         */
        int SalesUidEmpty = 18004;

        /**
         * 购买用户为空
         */
        int UidEmpty = 18005;

        /**
         * 当前状态下不能变更为新状态
         */
        int UpdateStateOnErrorState = 18006;

        /**
         * 状态更新异常
         */
        int UpdateStateError = 18007;

        /**
         * 状态已经被变更过
         */
        int UpdateStateHasOver = 18008;

        /**
         * 订单添加账本失败
         */
        int orderAddClassBookError = 18009;

        /**
         * 支付金额为空
         */
        int MoneyIsEmpty = 18010;

        /**
         * 渠道订单号为空
         */
        int ChDealIdEmpty = 18011;

        /**
         * 支付方式为空
         */
        int PayMethodEmpty = 18012;

        /**
         * 支付渠道为空
         */
        int ChIdEmpty = 18013;

        /**
         * 支付单已经存在
         */
        int DuplicateOrderPayDetail = 18014;

        /**
         * 支付单为空
         */
        int PayDetailEmpty = 18015;

        /**
         * 支付金额大于应付金额
         */
        int PayMoneyOverOrderMoney = 18016;

        /**
         * 订单为空
         */
        int OrderEmpty = 18017;

        /**
         * 课时为空
         */
        int LessonNumEmpty = 18018;
        /**
         * 原因为空
         */
        int ReasonEmpty = 18019;
        /**
         * 课程ID为空
         */
        int CourseIdEmpty = 18020;
        /**
         * 责任方为空
         */
        int ResponsiblePartyEmpty = 18021;
        /**
         * 补偿单ID为空
         */
        int RefundFormIdEmpty = 18022;
        /**
         * 审核人为空
         */
        int VerifyByEmpty = 18023;
        /**
         * 订单状态异常
         */
        int OrderStateError = 18024;
        /**
         * 可退课程为空
         */
        int RefundableEmpty = 18025;
        /**
         * 退款流程单已经存在
         */
        int RefundFormExist = 18026;
        /**
         * 补偿单为空
         */
        int RefundFormEmpty = 18027;
        /**
         * 补偿单详情为空
         */
        int RefundDetailEmpty = 18028;

        /**
         * 订单已退费
         */
        int OrderRefunded = 18029;
        /**
         * 赠送流程单已经存在
         */
        int GiftFormExist = 18030;
        /**
         * 补偿单状态异常
         */
        int RefundStateError = 18031;
        /**
         * 订单中不包含此课程
         */
        int CourseExistInOrder = 18032;
        /**
         * 补偿单ID为空
         */
        int RefundIDEmpty = 18033;
        /**
         * 赠送单已经审核过
         */
        int GiftFormAlreadyVerify = 18034;
        /**
         * 订单支付有效期过期
         */
        int DeadLineExpire = 18035;
        /**
         * 商品不存在
         */
        int GoodsNotExist = 18036;
        /**
         * 商品未上架
         */
        int GoodsNotOnline = 18037;
        /**
         * 商品下没有产品
         */
        int GoodsProductEmpty = 18038;
        /**
         * 订单不存在
         */
        int OrderNotExist = 18039;
    }

    /**
     * 账本模块
     */
    public interface CosaccountError {

        /**
         * 操作失败
         */
        int OperationError = 16000;


        /**
         * 找不到排课记录
         */
        int NoAccountLogRecord = 16001;

        /**
         * 重复交易
         */
        int DuplicateLogRecords = 16004;

        /**
         * 购买课时-已约购买课时<= 0
         */
        int NoAccountRecord = 16005;

        /**
         * 更新学生账本表异常
         */
        int LackOfLogRecords = 16006;

        /**
         * 参数为空
         */
        int ParamCannotBeNull = 16007;

        /**
         * 更新账本表失败
         */
        int UpdateRsvCosaccount = 16008;

        /**
         * 完成课节 != 已约课节
         */
        int NotEqualFinishedWithReserved = 16009;

        /**
         * 添加课节 - 当前课节无法预约
         */
        int NoLessonLeft2Reserve = 16010;

        /**
         * 重复取消课节
         */
        int PartlyCancelLessonRequest = 16011;

        /**
         * 课节账本状态不一致，不支持不一致的批量处理
         */
        int InConsistentState = 16012;
        /**
         * 部分重复交易
         */
        int PartlyDuplicateLogRecords = 16013;
        /**
         * 账本为空
         */
        int CosaccountEmpty = 16014;
        /**
         * 无有效课时账本或已退费
         */
        int CourseAccountStateNotNormal = 16015;
        /**
         * 订单ID为空
         */
        int OrderIdEmpty = 16016;
        /**
         * 用户ID为空
         */
        int UidEmpty = 16017;
        /**
         * 课程ID为空
         */
        int CourseIdEmpty = 16018;
        /**
         * 课时数为空
         */
        int LessonNumEmpty = 16019;
        /**
         * 赠课单ID
         */
        int GiftFormIdEmpty = 16020;
        /**
         * 一次取消或补偿多综课程
         */
        int notSuportMultyCourseType = 16021;
        /**
         * 课节的课程和参数不一致
         */
        int lessonCourseIdNotValidWithParam = 16022;
        /**
         * 课节账本已完成,不能取消
         */
        int DoneLessonCannotBeCancel = 16023;
    }

    /**
     * 商品模块
     */
    public interface GoodsError {
        /**
         * 缺少产品信息
         */
        int ProductsLost = 17001;
    }

    /**
     * 课节服务错误码
     */
    public interface LessonBizError {
        /**
         * 一对一标准课首次上课课序为空
         */
        int StandardClassIdEmptyOnStandard1V1 = 19001;
        /**
         * 可用课时不足
         */
        int AvailableNotEnough = 19002;
        /**
         * 正在排课中
         */
        int ScheduleLessoning = 19003;
        /**
         * 开始时间为空
         */
        int StartTimeEmpty = 19004;
        /**
         * 结束日期为空
         */
        int EndDateEmpty = 19005;
        /**
         * 频率类型为空
         */
        int FrequencyTypeEmpty = 19006;
        /**
         * 学生ID为空
         */
        int StudentUidEmpty = 19007;
        /**
         * 课程ID为空
         */
        int CourseIdEmpty = 19008;
        /**
         * 课程不存在教材Id
         */
        int TextBookIdEmpty = 19009;

        /**
         * 无可排课程
         */
        int ScheduleLessonNotExists = 19010;
        /**
         * 课节ID为空
         */
        int LessonIdEmpty = 19011;
        /**
         * 课时为空
         */
        int LessonNumEmpty = 19012;
        /**
         * 责任方为空
         */
        int ResponsiblePartyEmpty = 19013;
        /**
         * 原因为空
         */
        int ReasonEmpty = 19014;
        /**
         * 补偿单ID为空
         */
        int CompenFormIdEmpty = 19015;
        /**
         * 审核人为空
         */
        int VerifyByEmpty = 19016;

        /**
         * 课节状态不为已完成
         */
        int LessonStateNotFinish = 19017;
        /**
         * 订单已退费
         */
        int OrderStateRefunded = 19018;
        /**
         * 补偿单已存在
         */
        int CompenFormExist = 19019;

        /**
         * 已经审核过
         */
        int CompenFormAlreadyVerify = 19020;
        /**
         * 此产品有未签协议
         */
        int UnsignedUserBuyExist = 19021;
        /**
         * 剩余课序大于已排课程
         */
        int RemainStandClassOverUnEndLesson = 19022;
        /**
         * 不是1V1标准课
         */
        int NotIsStandard1V1 = 19023;
    }

    /**
     * 学生管理相关错误
     */
    public interface StuManagementError {
        /**
         * 创建学生user profile失败
         */
        int CreateUserProfileFailed = 22001;

        /**
         * 查询不到学生信息
         */
        int NoStuInfo = 22002;

        /**
         * 参数为空
         */
        int ParamCannotBeNull = 22003;

        /**
         * 学生uid为空
         */
        int StudentUidEmpty = 22004;

        /**
         * 家长手机号为空
         */
        int FamilyPhoneEmpty = 22005;

        /**
         * 家长名字为空
         */
        int FamilyNameEmpty = 22006;

        /**
         * 家长身份为空
         */
        int RelationTypeEmpty = 22007;

        /**
         * 家长信息为空
         */
        int FamilyInfoEmpty = 22008;
        /**
         * 学生姓名为空
         */
        int RealNameIsEmpty = 22009;
        /**
         * 性别为空
         */
        int SexIsEmpty = 22010;
        /**
         * 学生出生年月为空
         */
        int BirthDayEmpty = 22011;
        /**
         * 学生电话为空为空
         */
        int MobileIsEmpty = 22012;
    }

    /**
     * 通知模块
     */
    public interface NotifyError {
        /**
         * 业务类型为空
         */
        int BusiTypeEmpty = 20001;
        /**
         * 对象id为空
         */
        int BizIdEmpty = 20002;
        /**
         * 通知类型为空
         */
        int NotifyTypeEmpty = 20003;
        /**
         * 消息类型为空
         */
        int MsgTypeEmpty = 20004;
        /**
         * 对象类型为空
         */
        int BizTypeEmpty = 20005;
        /**
         * 列表为空
         */
        int ListIsEmpty = 20006;
        /**
         * 通知消息Type为空
         */
        int NotifyMsgTypeEmpty = 20007;
        /**
         * 通知消息Template为空
         */
        int NotifyMsgTemplateEmpty = 20008;
        /**
         * ShardingItem参数小于0
         */
        int ShardingItemNotValid = 20009;
        /**
         * ShardingTotal参数小于等于0
         */
        int ShardingTotalNotValid = 20010;
        /**
         * 通知消息Uid为空
         */
        int MsgUidEmpty = 20011;
        /**
         * 通知消息Param为空
         */
        int MsgParamEmpty = 20012;
        /**
         * 通知消息模版Content为空
         */
        int TemplateContentEmpty = 20013;
        /**
         * Map为空
         */
        int MapEmpty = 20014;
        /**
         * 模版中微信Code为空
         */
        int CodeEmpty = 20015;
        /**
         * 过期时间为空
         */
        int TimeEmpty = 20016;
        /**
         * 重复记录
         */
        int DuplicateRecords = 20017;

    }

    /**
     * 日志上传模块
     */
    public interface ReportError {
        /**
         * uid为空
         */
        int UidEmpty = 21001;
        /**
         * 上报时间为空
         */
        int ReportTimeEmpty = 21002;
        /**
         * 文件大小为空
         */
        int FileSizeEmpty = 21003;
        /**
         * 文件路径为空
         */
        int FileUrlEmpty = 21004;

    }
}
