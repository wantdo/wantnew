package com.wantdo.domain;

/**
 * EcEorderdtlId entity. @author MyEclipse Persistence Tools
 */

public class EcEorderdtlId implements java.io.Serializable {

	// Fields

	private String orderid;
	private Integer lineid;

	// Constructors

	/** default constructor */
	public EcEorderdtlId() {
	}

	/** full constructor */
	public EcEorderdtlId(String orderid, Integer lineid) {
		this.orderid = orderid;
		this.lineid = lineid;
	}

	// Property accessors

	public String getOrderid() {
		return this.orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Integer getLineid() {
		return this.lineid;
	}

	public void setLineid(Integer lineid) {
		this.lineid = lineid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EcEorderdtlId))
			return false;
		EcEorderdtlId castOther = (EcEorderdtlId) other;

		return ((this.getOrderid() == castOther.getOrderid()) || (this
				.getOrderid() != null && castOther.getOrderid() != null && this
				.getOrderid().equals(castOther.getOrderid())))
				&& ((this.getLineid() == castOther.getLineid()) || (this
						.getLineid() != null && castOther.getLineid() != null && this
						.getLineid().equals(castOther.getLineid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getOrderid() == null ? 0 : this.getOrderid().hashCode());
		result = 37 * result
				+ (getLineid() == null ? 0 : this.getLineid().hashCode());
		return result;
	}

}