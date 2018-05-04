package com.zhichubao.project.model.domain;

import java.util.Date;

/**
 * 
 */
public class ProjectManagementApplication {
    /**
     * 
     */
    private Long id;

    /**
     * 申请编码
     */
    private String applicationCode;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 申请状态
     */
    private Integer applicationStatus;

    /**
     * 立项申请名称
     */
    private String applicationName;

    /**
     * 部门id
     */
    private Long departmentId;

    /**
     * 法律实体
     */
    private Long legalEntityId;

    /**
     * 立项负责人id
     */
    private Long projectChargePersonId;

    /**
     * 采购类型
     */
    private Integer purchaseType;

    /**
     * 开始时间
     */
    private Date startTime;

    /**
     * 结束时间
     */
    private Date endTime;

    /**
     * 需求描述
     */
    private String requirementDescription;

    /**
     * 投资回报
     */
    private String returnOnInvestment;

    /**
     * 抄送人id（多个id用‘，’分割）
     */
    private String copyPersonId;

    /**
     * 供应商名称
     */
    private String vendorName;

    /**
     * 联系人
     */
    private String linkman;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    /**
     * 立项总金额
     */
    private Long totalPrice;

    /**
     * 删除状态（1=删除，0=未删除）
     */
    private Boolean isDelete;

    /**
     * 
     * @return id 
     */
    public Long getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 申请编码
     * @return application_code 申请编码
     */
    public String getApplicationCode() {
        return applicationCode;
    }

    /**
     * 申请编码
     * @param applicationCode 申请编码
     */
    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode == null ? null : applicationCode.trim();
    }

    /**
     * 租户id
     * @return tenant_id 租户id
     */
    public Long getTenantId() {
        return tenantId;
    }

    /**
     * 租户id
     * @param tenantId 租户id
     */
    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }

    /**
     * 申请状态
     * @return application_status 申请状态
     */
    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    /**
     * 申请状态
     * @param applicationStatus 申请状态
     */
    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    /**
     * 立项申请名称
     * @return application_name 立项申请名称
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * 立项申请名称
     * @param applicationName 立项申请名称
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName == null ? null : applicationName.trim();
    }

    /**
     * 部门id
     * @return department_id 部门id
     */
    public Long getDepartmentId() {
        return departmentId;
    }

    /**
     * 部门id
     * @param departmentId 部门id
     */
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 法律实体
     * @return legal_entity_id 法律实体
     */
    public Long getLegalEntityId() {
        return legalEntityId;
    }

    /**
     * 法律实体
     * @param legalEntityId 法律实体
     */
    public void setLegalEntityId(Long legalEntityId) {
        this.legalEntityId = legalEntityId;
    }

    /**
     * 立项负责人id
     * @return project_charge_person_id 立项负责人id
     */
    public Long getProjectChargePersonId() {
        return projectChargePersonId;
    }

    /**
     * 立项负责人id
     * @param projectChargePersonId 立项负责人id
     */
    public void setProjectChargePersonId(Long projectChargePersonId) {
        this.projectChargePersonId = projectChargePersonId;
    }

    /**
     * 采购类型
     * @return purchase_type 采购类型
     */
    public Integer getPurchaseType() {
        return purchaseType;
    }

    /**
     * 采购类型
     * @param purchaseType 采购类型
     */
    public void setPurchaseType(Integer purchaseType) {
        this.purchaseType = purchaseType;
    }

    /**
     * 开始时间
     * @return start_time 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 结束时间
     * @return end_time 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 结束时间
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 需求描述
     * @return requirement_description 需求描述
     */
    public String getRequirementDescription() {
        return requirementDescription;
    }

    /**
     * 需求描述
     * @param requirementDescription 需求描述
     */
    public void setRequirementDescription(String requirementDescription) {
        this.requirementDescription = requirementDescription == null ? null : requirementDescription.trim();
    }

    /**
     * 投资回报
     * @return return_on_investment 投资回报
     */
    public String getReturnOnInvestment() {
        return returnOnInvestment;
    }

    /**
     * 投资回报
     * @param returnOnInvestment 投资回报
     */
    public void setReturnOnInvestment(String returnOnInvestment) {
        this.returnOnInvestment = returnOnInvestment == null ? null : returnOnInvestment.trim();
    }

    /**
     * 抄送人id（多个id用‘，’分割）
     * @return copy_person_id 抄送人id（多个id用‘，’分割）
     */
    public String getCopyPersonId() {
        return copyPersonId;
    }

    /**
     * 抄送人id（多个id用‘，’分割）
     * @param copyPersonId 抄送人id（多个id用‘，’分割）
     */
    public void setCopyPersonId(String copyPersonId) {
        this.copyPersonId = copyPersonId == null ? null : copyPersonId.trim();
    }

    /**
     * 供应商名称
     * @return vendor_name 供应商名称
     */
    public String getVendorName() {
        return vendorName;
    }

    /**
     * 供应商名称
     * @param vendorName 供应商名称
     */
    public void setVendorName(String vendorName) {
        this.vendorName = vendorName == null ? null : vendorName.trim();
    }

    /**
     * 联系人
     * @return linkman 联系人
     */
    public String getLinkman() {
        return linkman;
    }

    /**
     * 联系人
     * @param linkman 联系人
     */
    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    /**
     * 联系电话
     * @return phone 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系电话
     * @param phone 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 立项总金额
     * @return total_price 立项总金额
     */
    public Long getTotalPrice() {
        return totalPrice;
    }

    /**
     * 立项总金额
     * @param totalPrice 立项总金额
     */
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 删除状态（1=删除，0=未删除）
     * @return is_delete 删除状态（1=删除，0=未删除）
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 删除状态（1=删除，0=未删除）
     * @param isDelete 删除状态（1=删除，0=未删除）
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}