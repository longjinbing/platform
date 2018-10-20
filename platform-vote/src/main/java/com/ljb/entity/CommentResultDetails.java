package com.ljb.entity;

import java.util.Date;
import java.io.Serializable;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 评价结果明细实体
 * 表名 comment_result_details
 *
 * @author longjinbn
 * @email 1106335838@qq.com
 * @date 2018-10-19 17:15:20
 */
public class CommentResultDetails implements Serializable{

    private static final long serialVersionUID = 1L;

    public  CommentResultDetails(){

    }
        private Integer id;
        private Integer commentId;
        private Integer commentResultId;
    	@NotBlank(message = "{field.not.blank}")
        private String a1;
    	@NotBlank(message = "{field.not.blank}")
        private String a2;
    	@NotBlank(message = "{field.not.blank}")
        private String a3;
    	@NotBlank(message = "{field.not.blank}")
        private String a4;
    	@NotBlank(message = "{field.not.blank}")
        private String a5;
    	@NotBlank(message = "{field.not.blank}")
        private String a6;
    	@NotBlank(message = "{field.not.blank}")
        private String a7;
    	@NotBlank(message = "{field.not.blank}")
        private String a8;
    	@NotBlank(message = "{field.not.blank}")
        private String a9;
    	@NotBlank(message = "{field.not.blank}")
        private String a10;
    	@NotBlank(message = "{field.not.blank}")
        private String a11;
    	@NotBlank(message = "{field.not.blank}")
        private String a12;
    	@NotBlank(message = "{field.not.blank}")
        private String a13;
    	@NotBlank(message = "{field.not.blank}")
        private String a14;
    	@NotBlank(message = "{field.not.blank}")
        private String a15;
    	@NotBlank(message = "{field.not.blank}")
        private String a16;
    	@NotBlank(message = "{field.not.blank}")
        private String a17;
    	@NotBlank(message = "{field.not.blank}")
        private String a18;
    	@NotBlank(message = "{field.not.blank}")
        private String a19;
    	@NotBlank(message = "{field.not.blank}")
        private String a20;
        private Date createTime;
        private Integer createId;
        private Integer updateId;
        private Date updateTime;
        private Integer status;
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
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    /**
     * 获取：
     */
    public Integer getCommentId() {
        return commentId;
    }
    /**
     * 设置：
     */
    public void setCommentResultId(Integer commentResultId) {
        this.commentResultId = commentResultId;
    }

    /**
     * 获取：
     */
    public Integer getCommentResultId() {
        return commentResultId;
    }
    /**
     * 设置：
     */
    public void setA1(String a1) {
        this.a1 = a1;
    }

    /**
     * 获取：
     */
    public String getA1() {
        return a1;
    }
    /**
     * 设置：
     */
    public void setA2(String a2) {
        this.a2 = a2;
    }

    /**
     * 获取：
     */
    public String getA2() {
        return a2;
    }
    /**
     * 设置：
     */
    public void setA3(String a3) {
        this.a3 = a3;
    }

    /**
     * 获取：
     */
    public String getA3() {
        return a3;
    }
    /**
     * 设置：
     */
    public void setA4(String a4) {
        this.a4 = a4;
    }

    /**
     * 获取：
     */
    public String getA4() {
        return a4;
    }
    /**
     * 设置：
     */
    public void setA5(String a5) {
        this.a5 = a5;
    }

    /**
     * 获取：
     */
    public String getA5() {
        return a5;
    }
    /**
     * 设置：
     */
    public void setA6(String a6) {
        this.a6 = a6;
    }

    /**
     * 获取：
     */
    public String getA6() {
        return a6;
    }
    /**
     * 设置：
     */
    public void setA7(String a7) {
        this.a7 = a7;
    }

    /**
     * 获取：
     */
    public String getA7() {
        return a7;
    }
    /**
     * 设置：
     */
    public void setA8(String a8) {
        this.a8 = a8;
    }

    /**
     * 获取：
     */
    public String getA8() {
        return a8;
    }
    /**
     * 设置：
     */
    public void setA9(String a9) {
        this.a9 = a9;
    }

    /**
     * 获取：
     */
    public String getA9() {
        return a9;
    }
    /**
     * 设置：
     */
    public void setA10(String a10) {
        this.a10 = a10;
    }

    /**
     * 获取：
     */
    public String getA10() {
        return a10;
    }
    /**
     * 设置：
     */
    public void setA11(String a11) {
        this.a11 = a11;
    }

    /**
     * 获取：
     */
    public String getA11() {
        return a11;
    }
    /**
     * 设置：
     */
    public void setA12(String a12) {
        this.a12 = a12;
    }

    /**
     * 获取：
     */
    public String getA12() {
        return a12;
    }
    /**
     * 设置：
     */
    public void setA13(String a13) {
        this.a13 = a13;
    }

    /**
     * 获取：
     */
    public String getA13() {
        return a13;
    }
    /**
     * 设置：
     */
    public void setA14(String a14) {
        this.a14 = a14;
    }

    /**
     * 获取：
     */
    public String getA14() {
        return a14;
    }
    /**
     * 设置：
     */
    public void setA15(String a15) {
        this.a15 = a15;
    }

    /**
     * 获取：
     */
    public String getA15() {
        return a15;
    }
    /**
     * 设置：
     */
    public void setA16(String a16) {
        this.a16 = a16;
    }

    /**
     * 获取：
     */
    public String getA16() {
        return a16;
    }
    /**
     * 设置：
     */
    public void setA17(String a17) {
        this.a17 = a17;
    }

    /**
     * 获取：
     */
    public String getA17() {
        return a17;
    }
    /**
     * 设置：
     */
    public void setA18(String a18) {
        this.a18 = a18;
    }

    /**
     * 获取：
     */
    public String getA18() {
        return a18;
    }
    /**
     * 设置：
     */
    public void setA19(String a19) {
        this.a19 = a19;
    }

    /**
     * 获取：
     */
    public String getA19() {
        return a19;
    }
    /**
     * 设置：
     */
    public void setA20(String a20) {
        this.a20 = a20;
    }

    /**
     * 获取：
     */
    public String getA20() {
        return a20;
    }
    /**
     * 设置：
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取：
     */
    public Date getCreateTime() {
        return createTime;
    }
    /**
     * 设置：
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 获取：
     */
    public Integer getCreateId() {
        return createId;
    }
    /**
     * 设置：
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 获取：
     */
    public Integer getUpdateId() {
        return updateId;
    }
    /**
     * 设置：
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取：
     */
    public Date getUpdateTime() {
        return updateTime;
    }
    /**
     * 设置：
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：
     */
    public Integer getStatus() {
        return status;
    }
}
