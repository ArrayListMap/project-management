package com.zhichubao.project.model.domain;

/**
 * 
 */
public class ProjectManagementDetail {
    /**
     * 
     */
    private Long id;

    /**
     * 租户id
     */
    private Long tenantId;

    /**
     * 立项申请id
     */
    private Long applicationId;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 单价
     */
    private Long price;

    /**
     * 数量
     */
    private Double quantity;

    /**
     * 
     */
    private Long totalPrice;

    /**
     * 
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
     * 立项申请id
     * @return application_id 立项申请id
     */
    public Long getApplicationId() {
        return applicationId;
    }

    /**
     * 立项申请id
     * @param applicationId 立项申请id
     */
    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 规格
     * @return specifications 规格
     */
    public String getSpecifications() {
        return specifications;
    }

    /**
     * 规格
     * @param specifications 规格
     */
    public void setSpecifications(String specifications) {
        this.specifications = specifications == null ? null : specifications.trim();
    }

    /**
     * 单价
     * @return price 单价
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 单价
     * @param price 单价
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 数量
     * @return quantity 数量
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * 数量
     * @param quantity 数量
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    /**
     * 
     * @return total_price 
     */
    public Long getTotalPrice() {
        return totalPrice;
    }

    /**
     * 
     * @param totalPrice 
     */
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * 
     * @return is_delete 
     */
    public Boolean getIsDelete() {
        return isDelete;
    }

    /**
     * 
     * @param isDelete 
     */
    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }
}