package com.ljb.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 实体
 * 表名 eachresult
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-16 22:29:56
 */
public class Eachresult implements Serializable{

    private static final long serialVersionUID = 1L;

    public  Eachresult(){

    }
        private Integer id;
        private Integer classId;
    	@NotBlank(message = "{field.not.blank}")
        private String studentNum;
    	@NotBlank(message = "{field.not.blank}")
        private String rateSnum;
        private Date answerTime;
        private BigDecimal answerGrade;
        private Integer mode;
    	@NotBlank(message = "{field.not.blank}")
        private String q1;
    	@NotBlank(message = "{field.not.blank}")
        private String q2;
    	@NotBlank(message = "{field.not.blank}")
        private String q3;
    	@NotBlank(message = "{field.not.blank}")
        private String q4;
    	@NotBlank(message = "{field.not.blank}")
        private String q5;
    	@NotBlank(message = "{field.not.blank}")
        private String q6;
    	@NotBlank(message = "{field.not.blank}")
        private String q7;
    	@NotBlank(message = "{field.not.blank}")
        private String q8;
    	@NotBlank(message = "{field.not.blank}")
        private String q9;
    	@NotBlank(message = "{field.not.blank}")
        private String q10;
    	@NotBlank(message = "{field.not.blank}")
        private String q11;
    	@NotBlank(message = "{field.not.blank}")
        private String q12;
    	@NotBlank(message = "{field.not.blank}")
        private String q13;
    	@NotBlank(message = "{field.not.blank}")
        private String q14;
    	@NotBlank(message = "{field.not.blank}")
        private String q15;
    	@NotBlank(message = "{field.not.blank}")
        private String q16;
    	@NotBlank(message = "{field.not.blank}")
        private String q17;
    	@NotBlank(message = "{field.not.blank}")
        private String q18;
    	@NotBlank(message = "{field.not.blank}")
        private String q19;
    /**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 获取：
     */
    public Integer getClassId() {
        return classId;
    }
    /**
     * 设置：
     */
    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    /**
     * 获取：
     */
    public String getStudentNum() {
        return studentNum;
    }
    /**
     * 设置：
     */
    public void setRateSnum(String rateSnum) {
        this.rateSnum = rateSnum;
    }

    /**
     * 获取：
     */
    public String getRateSnum() {
        return rateSnum;
    }
    /**
     * 设置：
     */
    public void setAnswerTime(Date answerTime) {
        this.answerTime = answerTime;
    }

    /**
     * 获取：
     */
    public Date getAnswerTime() {
        return answerTime;
    }
    /**
     * 设置：
     */
    public void setAnswerGrade(BigDecimal answerGrade) {
        this.answerGrade = answerGrade;
    }

    /**
     * 获取：
     */
    public BigDecimal getAnswerGrade() {
        return answerGrade;
    }
    /**
     * 设置：
     */
    public void setMode(Integer mode) {
        this.mode = mode;
    }

    /**
     * 获取：
     */
    public Integer getMode() {
        return mode;
    }
    /**
     * 设置：
     */
    public void setQ1(String q1) {
        this.q1 = q1;
    }

    /**
     * 获取：
     */
    public String getQ1() {
        return q1;
    }
    /**
     * 设置：
     */
    public void setQ2(String q2) {
        this.q2 = q2;
    }

    /**
     * 获取：
     */
    public String getQ2() {
        return q2;
    }
    /**
     * 设置：
     */
    public void setQ3(String q3) {
        this.q3 = q3;
    }

    /**
     * 获取：
     */
    public String getQ3() {
        return q3;
    }
    /**
     * 设置：
     */
    public void setQ4(String q4) {
        this.q4 = q4;
    }

    /**
     * 获取：
     */
    public String getQ4() {
        return q4;
    }
    /**
     * 设置：
     */
    public void setQ5(String q5) {
        this.q5 = q5;
    }

    /**
     * 获取：
     */
    public String getQ5() {
        return q5;
    }
    /**
     * 设置：
     */
    public void setQ6(String q6) {
        this.q6 = q6;
    }

    /**
     * 获取：
     */
    public String getQ6() {
        return q6;
    }
    /**
     * 设置：
     */
    public void setQ7(String q7) {
        this.q7 = q7;
    }

    /**
     * 获取：
     */
    public String getQ7() {
        return q7;
    }
    /**
     * 设置：
     */
    public void setQ8(String q8) {
        this.q8 = q8;
    }

    /**
     * 获取：
     */
    public String getQ8() {
        return q8;
    }
    /**
     * 设置：
     */
    public void setQ9(String q9) {
        this.q9 = q9;
    }

    /**
     * 获取：
     */
    public String getQ9() {
        return q9;
    }
    /**
     * 设置：
     */
    public void setQ10(String q10) {
        this.q10 = q10;
    }

    /**
     * 获取：
     */
    public String getQ10() {
        return q10;
    }
    /**
     * 设置：
     */
    public void setQ11(String q11) {
        this.q11 = q11;
    }

    /**
     * 获取：
     */
    public String getQ11() {
        return q11;
    }
    /**
     * 设置：
     */
    public void setQ12(String q12) {
        this.q12 = q12;
    }

    /**
     * 获取：
     */
    public String getQ12() {
        return q12;
    }
    /**
     * 设置：
     */
    public void setQ13(String q13) {
        this.q13 = q13;
    }

    /**
     * 获取：
     */
    public String getQ13() {
        return q13;
    }
    /**
     * 设置：
     */
    public void setQ14(String q14) {
        this.q14 = q14;
    }

    /**
     * 获取：
     */
    public String getQ14() {
        return q14;
    }
    /**
     * 设置：
     */
    public void setQ15(String q15) {
        this.q15 = q15;
    }

    /**
     * 获取：
     */
    public String getQ15() {
        return q15;
    }
    /**
     * 设置：
     */
    public void setQ16(String q16) {
        this.q16 = q16;
    }

    /**
     * 获取：
     */
    public String getQ16() {
        return q16;
    }
    /**
     * 设置：
     */
    public void setQ17(String q17) {
        this.q17 = q17;
    }

    /**
     * 获取：
     */
    public String getQ17() {
        return q17;
    }
    /**
     * 设置：
     */
    public void setQ18(String q18) {
        this.q18 = q18;
    }

    /**
     * 获取：
     */
    public String getQ18() {
        return q18;
    }
    /**
     * 设置：
     */
    public void setQ19(String q19) {
        this.q19 = q19;
    }

    /**
     * 获取：
     */
    public String getQ19() {
        return q19;
    }
}
